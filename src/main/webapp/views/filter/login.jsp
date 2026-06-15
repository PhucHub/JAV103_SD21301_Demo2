<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <style>
        .error-message {
            color: red;
            font-weight: bold;
            margin-bottom: 10px;
        }
        table {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<h2>Đăng nhập hệ thống</h2>

<c:if test="${not empty errorMessage}">
    <p class="error-message">${errorMessage}</p>
</c:if>

<form action="${pageContext.request.contextPath}/filterInput" method="post">
    <table cellpadding="5">
        <tr>
            <td>Tên đăng nhập:</td>
            <td>
                <input type="text" name="username" placeholder="Nhập tên đăng nhập..." value="${username}" required/>
            </td>
        </tr>
        <tr>
            <td>Mật khẩu:</td>
            <td>
                <input type="password" name="password" placeholder="Nhập mật khẩu..." required/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Đăng nhập</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
