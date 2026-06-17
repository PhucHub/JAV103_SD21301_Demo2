package com.jav103.jav103_sum25_demo2.controller;

import com.jav103.jav103_sum25_demo2.entity.Department;
import com.jav103.jav103_sum25_demo2.entity.Employee;
import com.jav103.jav103_sum25_demo2.services.DepartmentServices;
import com.jav103.jav103_sum25_demo2.services.EmployeeServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = {"/employees", "/employee-delete", "/add-form", "/employees/insert", "/employee-edit", "/edit-form"})
public class EmployeeServlet extends HttpServlet {

    private final EmployeeServices sv = new EmployeeServices();
    private final DepartmentServices deptSv = new DepartmentServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {
            case "/employees":
                listEmployees(request, response);
                break;
            case "/employee-delete":
                deleteEmployee(request, response);
                break;
            case "/add-form":
                addForm(request, response);
                break;
            case "/edit-form":
                editForm(request, response);
                break;

        }
    }


    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("search");
        List<Employee> employees;

        if (keyword != null && !keyword.trim().isEmpty()) {
            employees = sv.searchByName(keyword.trim());
        } else {
            employees = sv.getEmployees();
        }

        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/views/employee.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nid = request.getParameter("id");
        if (nid != null) {
            Long id = Long.parseLong(nid);
            sv.deleteEmployee(id);
        }

        response.sendRedirect(request.getContextPath() + "/employees");


    }
    private void addForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = deptSv.getDepartments();
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("/views/new-employee.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam != null) {
            Long id = Long.parseLong(idParam);
            Employee employee = sv.getEmployeeById(id);

            request.setAttribute("employee", employee);
        }

        List<Department> departments = deptSv.getDepartments();
        request.setAttribute("departments", departments);

        request.getRequestDispatcher("/views/edit-employee.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

         switch (path) {
            case "/employees/insert":
                insertEmployee(request, response);
                break;

            case "/employee-edit":
                editEmployee(request, response);
                break;
         }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String errorMessage = validateForm(request);

        if (errorMessage != null) {
            Employee employee = getEmployeeFromForm(request);
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("employee", employee);

            List<Department> departments = deptSv.getDepartments();
            request.setAttribute("departments", departments);

            request.getRequestDispatcher("/views/new-employee.jsp").forward(request, response);
            return;
        }

        Employee employee = getEmployeeFromForm(request);
        sv.addEmployee(employee);

        response.sendRedirect(request.getContextPath() + "/employees");
    }

    private String validateForm(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String salaryStr = request.getParameter("salary");
        String departmentId = request.getParameter("departmentId");

        if (name == null || name.trim().isEmpty()) {
            return "Tên không được để trống";
        }
        if (email == null || email.trim().isEmpty()) {
            return "Email không được để trống";
        }
        if (salaryStr == null || salaryStr.trim().isEmpty()) {
            return "Lương không được để trống";
        }
        try {
            Double salary = Double.parseDouble(salaryStr);
            if (salary < 0) {
                return "Lương phải lớn hơn hoặc bằng 0";
            }
        } catch (NumberFormatException e) {
            return "Lương phải là số hợp lệ";
        }
        if (departmentId == null || departmentId.trim().isEmpty()) {
            return "Phòng ban không được để trống";
        }
        return null;
    }

    private Employee getEmployeeFromForm(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String salaryStr = request.getParameter("salary");
        String departmentIdStr = request.getParameter("departmentId");

        Double salary = null;
        if (salaryStr != null && !salaryStr.trim().isEmpty()) {
            try {
                salary = Double.parseDouble(salaryStr);
            } catch (NumberFormatException e) {
                salary = 0.0;
            }
        }

        Department department = null;
        if (departmentIdStr != null && !departmentIdStr.trim().isEmpty()) {
            department = deptSv.getDepartmentById(Long.parseLong(departmentIdStr));
        }

        return new Employee(id, name, email, salary, department);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String errorMessage = validateForm(request);

        if (errorMessage != null) {
            Employee employee = getEmployeeFromForm(request);
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("employee", employee);

            List<Department> departments = deptSv.getDepartments();
            request.setAttribute("departments", departments);

            request.getRequestDispatcher("/views/edit-employee.jsp").forward(request, response);
            return;
        }

        Employee employee = getEmployeeFromForm(request);
        sv.editEmployee(employee);

        response.sendRedirect(request.getContextPath() + "/employees");
    }
}
