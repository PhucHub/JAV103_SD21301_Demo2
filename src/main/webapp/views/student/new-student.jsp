<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Thêm mới sinh viên</title>
  <style>
    .error-message {
      color: red;
      font-weight: bold;
    }
  </style>
</head>
<body>

<h2>Thêm mới sinh viên</h2>

<form action="${pageContext.request.contextPath}/students/insert" method="post">
  <table cellpadding="5">
    <c:if test="${not empty errorMessage}">
      <tr>
        <td colspan="2" class="error-message">
            ${errorMessage}
        </td>
      </tr>
    </c:if>

    <tr>
      <td>ID:</td>
      <td>
        <input type="number" name="id" required placeholder="Nhập số ID..." value="${student.id}"/>
      </td>
    </tr>
    <tr>
      <td>Họ và tên:</td>
      <td>
        <input type="text" name="name" placeholder="Nhập tên sinh viên..." value="${student.name}"/>
      </td>
    </tr>
    <tr>
      <td>Email:</td>
      <td>
        <input type="email" name="email" required placeholder="Nhập email..." value="${student.email}"/>
      </td>
    </tr>
    <tr>
      <td>Số điện thoại:</td>
      <td>
        <input type="text" name="phone" required placeholder="Nhập số điện thoại..." value="${student.phone}"/>
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <button type="submit">Lưu lại</button>
        <a href="${pageContext.request.contextPath}/students">Hủy bỏ</a>
      </td>
    </tr>
  </table>
</form>

</body>
</html>
