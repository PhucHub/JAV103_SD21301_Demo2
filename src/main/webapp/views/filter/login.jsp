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
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <meta name="contextPath" content="<%= request.getContextPath() %>">
    <%--    <script src="js/student.js"></script> will not works!--%>
    <script src="/js/student.js?v=<%= System.currentTimeMillis() %>"></script>
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

<hr>
<h3>Post new student using Ajax</h3>
<form action="">
    <div id="responseDiv"></div>
    <div>
        <label>id</label>
        <input type="text" id="student_id" name="student_id">
    </div>
    <div>
        <label>id</label>
        <input type="text" id="student_email" name="student_email">
    </div>
    <div>
        <label>id</label>
        <input type="text" id="student_phone" name="student_phone">
    </div>
    <div>
        <button type="button" onclick="saveStudent()">Add</button>
    </div>


</form>



</body>
</html>
