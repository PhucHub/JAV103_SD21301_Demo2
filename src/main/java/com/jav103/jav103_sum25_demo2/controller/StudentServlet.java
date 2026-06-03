package com.jav103.jav103_sum25_demo2.controller;

import com.jav103.jav103_sum25_demo2.entity.Student;
import com.jav103.jav103_sum25_demo2.services.StudentServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = {"/students", "/student-view", "/student-delete","/add-form","/students/insert","/student-edit","/edit-form"})
public class StudentServlet extends HttpServlet {

    private final StudentServices sv = new StudentServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {
            case "/students":
                listStudents(request, response);
                break;
            case "/student-view":
                viewStudent(request, response);
                break;
            case "/student-delete":
                deleteStudent(request, response);
                break;
            case "/add-form":
                addForm(request, response);
                break;
            case "/edit-form":
                editForm(request, response);
                break;

        }
    }


    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = sv.getStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/views/student.jsp").forward(request, response);
    }

    private void viewStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            Long id = Long.parseLong(idStr);
            Student student = sv.getStudentById(id);
            request.setAttribute("studentDetail", student);
        }

        request.getRequestDispatcher("/views/student-detail.jsp").forward(request, response);
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nid = request.getParameter("id");
        if (nid != null) {
            Long id = Long.parseLong(nid);
            sv.deleteStudent(id);
        }

        response.sendRedirect(request.getContextPath() + "/students");


    }
    private void addForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/new-student.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");

        if (idParam != null) {
            Long id = Long.parseLong(idParam);
            Student student = sv.getStudentById(id);

            request.setAttribute("student", student);
        }

        request.getRequestDispatcher("/views/edit-student.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

         switch (path) {
            case "/students/insert":
                insertStudent(request, response);
                break;

            case "/student-edit":
                editStudent(request, response);
                break;
         }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Student student = getStudentFromForm(request);

        if (student.getName() == null || student.getName().trim().isEmpty()) {
            request.setAttribute("errorMessage", "Tên không được để trống");
            request.setAttribute("student", student);

            request.getRequestDispatcher("/views/new-student.jsp").forward(request, response);
            return;
        }
        sv.addStudent(student);

        response.sendRedirect(request.getContextPath() + "/students");
    }

    private Student getStudentFromForm(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        return new Student(id, name, email, phone);
    }
    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Student student = getStudentFromForm(request);

        if (student.getName() == null || student.getName().trim().isEmpty()) {
            request.setAttribute("errorMessage", "Tên không được để trống");
            request.setAttribute("student", student);

            request.getRequestDispatcher("/views/edit-student.jsp").forward(request, response);
            return;
        }

        sv.editStudent(student);

        response.sendRedirect(request.getContextPath() + "/students");
    }
}