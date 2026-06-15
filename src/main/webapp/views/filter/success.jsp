<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập thành công</title>
    <style>
        .success-message {
            color: green;
            font-weight: bold;
            font-size: 18px;
        }
    </style>
</head>
<body>

<h2>Đăng nhập thành công!</h2>

<p class="success-message">Xin chào, <strong>${username}</strong>! Bạn đã đăng nhập thành công.</p>

<br>
<a href="${pageContext.request.contextPath}/employees">Quản lý Nhân viên</a>

<br><br>
<a href="${pageContext.request.contextPath}/filterInput">Đăng nhập lại</a>

</body>
</html>
