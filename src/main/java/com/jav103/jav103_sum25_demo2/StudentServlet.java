package com.jav103.jav103_sum25_demo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Lấy dữ liệu từ form
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String country = request.getParameter("country");
        // Lấy mảng các giá trị checkbox
        String[] favouriteLang = request.getParameterValues("favouriteLang");

        // 2. Đẩy dữ liệu vào Request Attribute
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("country", country);
        request.setAttribute("lang", favouriteLang);

        // 3. Chuyển hướng sang student.jsp
        request.getRequestDispatcher("/views/student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}