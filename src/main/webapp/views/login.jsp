<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>

<h2>Đăng nhập Hệ thống</h2>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
    <p style="color: red;"><%= errorMessage %></p>
<%
    }
%>

<form action="${pageContext.request.contextPath}/login" method="post">
    <label>Tài khoản (MSSV):</label><br/>
    <input type="text" name="username" required /><br/><br/>
    
    <label>Mật khẩu (Tên lớp):</label><br/>
    <input type="password" name="password" required /><br/><br/>
    
    <button type="submit">Đăng nhập</button>
</form>

</body>
</html>
