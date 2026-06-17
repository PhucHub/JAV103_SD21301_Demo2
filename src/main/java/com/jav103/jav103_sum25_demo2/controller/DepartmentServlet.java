package com.jav103.jav103_sum25_demo2.controller;

import com.jav103.jav103_sum25_demo2.entity.Category;
import com.jav103.jav103_sum25_demo2.entity.Department;
import com.jav103.jav103_sum25_demo2.services.CategoryServices;
import com.jav103.jav103_sum25_demo2.services.DepartmentServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentServlet", value = {"/department", "/department/add-form", "/department/insert", "/department/edit-form", "/department/update", "/department/delete"})
public class DepartmentServlet extends HttpServlet {

    private final DepartmentServices deptSv = new DepartmentServices();
    private final CategoryServices catSv = new CategoryServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String action = path;

        switch (action) {
            case "/department":
                listDepartments(request, response);
                break;
            case "/department/add-form":
                addForm(request, response);
                break;
            case "/department/edit-form":
                editForm(request, response);
                break;
            case "/department/delete":
                deleteDepartment(request, response);
                break;
            default:
                listDepartments(request, response);
                break;
        }
    }

    private void listDepartments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("search");
        List<Department> departments;
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            departments = deptSv.searchByName(keyword);
        } else {
            departments = deptSv.getDepartments();
        }
        
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("/views/department.jsp").forward(request, response);
    }

    private void addForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = catSv.getCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/views/new-department.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            Long id = Long.parseLong(idParam);
            Department department = deptSv.getDepartmentById(id);
            request.setAttribute("department", department);
        }
        List<Category> categories = catSv.getCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/views/edit-department.jsp").forward(request, response);
    }

    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            Long id = Long.parseLong(idParam);
            deptSv.deleteDepartment(id);
        }
        response.sendRedirect(request.getContextPath() + "/department");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        
        switch (action) {
            case "/department/insert":
                insertDepartment(request, response);
                break;
            case "/department/update":
                updateDepartment(request, response);
                break;
            default:
                listDepartments(request, response);
                break;
        }
    }

    private void insertDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorMessage = validateForm(request);

        if (errorMessage != null) {
            Department department = getDepartmentFromForm(request);
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("department", department);
            request.setAttribute("categories", catSv.getCategories());
            request.getRequestDispatcher("/views/new-department.jsp").forward(request, response);
            return;
        }

        Department department = getDepartmentFromForm(request);
        deptSv.addDepartment(department);
        response.sendRedirect(request.getContextPath() + "/department");
    }

    private void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String errorMessage = validateForm(request);

        if (errorMessage != null) {
            Department department = getDepartmentFromForm(request);
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("department", department);
            request.setAttribute("categories", catSv.getCategories());
            request.getRequestDispatcher("/views/edit-department.jsp").forward(request, response);
            return;
        }

        Department department = getDepartmentFromForm(request);
        deptSv.updateDepartment(department);
        response.sendRedirect(request.getContextPath() + "/department");
    }

    private String validateForm(HttpServletRequest request) {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String categoryId = request.getParameter("categoryId");

        if (code == null || code.trim().isEmpty()) {
            return "Mã phòng ban không được để trống";
        }
        if (name == null || name.trim().isEmpty()) {
            return "Tên phòng ban không được để trống";
        }
        if (categoryId == null || categoryId.trim().isEmpty()) {
            return "Loại phòng ban không được để trống";
        }
        return null;
    }

    private Department getDepartmentFromForm(HttpServletRequest request) {
        String idParam = request.getParameter("id");
        Long id = (idParam != null && !idParam.trim().isEmpty()) ? Long.parseLong(idParam) : null;
        
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String categoryIdStr = request.getParameter("categoryId");

        Category category = null;
        if (categoryIdStr != null && !categoryIdStr.trim().isEmpty()) {
            category = catSv.getCategoryById(Long.parseLong(categoryIdStr));
        }

        return new Department(id, code, name, category);
    }
}
