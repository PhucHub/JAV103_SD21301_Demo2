<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jav103.jav103_sum25_demo2.entity.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin chi tiết sinh viên</title>
</head>
<body>

<h2>Thông tin chi tiết sinh viên</h2>

<%

    Student student = (Student) request.getAttribute("studentDetail");
    if (student != null) {
%>
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>Mã Số Sinh Viên (ID)</th>
        <td><%= student.getId() %></td>
    </tr>
    <tr>
        <th>Họ và Tên</th>
        <td><%= student.getName() %></td>
    </tr>
    <tr>
        <th>Email</th>
        <td><%= student.getEmail() %></td>
    </tr>
    <tr>
        <th>Số điện thoại</th>
        <td><%= student.getPhone() %></td>
    </tr>
</table>
<%
} else {
%>
<p style="color: red;">Không tìm thấy thông tin sinh viên này!</p>
<%
    }
%>

<br>
<button style="padding: 8px;text-decoration: none"><a href="students">Quay lại </a></button>

</body>
</html>