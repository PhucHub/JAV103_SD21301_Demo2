<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.functions" prefix="fn" %>
<%@ page import="com.jav103.jav103_sum25_demo2.entity.Employee" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>

<h2>Danh sách nhân viên</h2>


<%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>

<form action="${pageContext.request.contextPath}/employees" method="get" style="margin-bottom: 15px;">
    <input type="text" name="search" placeholder="Nhập tên nhân viên..." value="<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>" />
    <button type="submit">Tìm kiếm</button>
    <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/employees'">Clear</button>
</form>

<%
    String searchKeyword = request.getParameter("search");
    if (searchKeyword != null && !searchKeyword.trim().isEmpty() && employees != null) {
%>
    <p style="font-style: italic;">Đã tìm thấy <%= employees.size() %> kết quả</p>
<%
    }
%>

<button style="padding: 8px;margin-bottom:5px"><a href="${pageContext.request.contextPath}/add-form">Add</a></button>


<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Salary</th>
        <th>Department</th>
        <th></th>
    </tr>

    <%
        if (employees != null) {
            for (Employee e : employees) {
    %>
    <tr>
        <td><%= e.getId() %></td>
        <td><%= e.getName() %></td>
        <td><%= e.getEmail() %></td>
        <td><%= e.getSalary() %></td>
        <td><%= e.getDepartment() != null ? e.getDepartment().getName() : "" %></td>
        <td>
            <a href="${pageContext.request.contextPath}/employee-delete?id=<%= e.getId() %>"
               onclick="return confirm('Bạn có chắc muốn xoá?')">Delete</a>|
            <a href="${pageContext.request.contextPath}/edit-form?id=<%= e.getId() %>">Edit</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
