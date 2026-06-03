<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jav103.jav103_sum25_demo2.entity.Student" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>

<h2>Danh sách sinh viên</h2>

<button style="padding: 8px;margin-bottom:5px"><a href="${pageContext.request.contextPath}/add-form">Add</a></button>


<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th></th>
    </tr>

    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students != null) {
            for (Student s : students) {
    %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getPhone() %></td>
        <td>

            <a href="${pageContext.request.contextPath}/student-view?id=<%= s.getId() %>">View</a> |
            <a href="${pageContext.request.contextPath}/student-delete?id=<%= s.getId() %>"
               onclick="return confirm('Bạn có chắc muốn xoá?')">Delete</a>|
            <a href="${pageContext.request.contextPath}/edit-form?id=<%= s.getId() %>">Edit</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>