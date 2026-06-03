<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Chỉnh sửa sinh viên</title>
            <style>
                .error-message {
                    color: red;
                    font-weight: bold;
                }
            </style>
        </head>

        <body>

            <h2>Chỉnh sửa thông tin sinh viên</h2>

            <form action="${pageContext.request.contextPath}/student-edit" method="post">
                <table cellpadding="5">
                    <c:if test="${not empty errorMessage}">
                        <tr>
                            <td colspan="2" class="error-message">
                                ${errorMessage}
                            </td>
                        </tr>
                    </c:if>

                    <tr>
                        <td>ID (Không được sửa):</td>
                        <td><input type="text" name="id" value="${student.id}" readonly /></td>
                    </tr>
                    <tr>
                        <td>Họ và tên:</td>
                        <td><input type="text" name="name" value="${student.name}" /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="email" name="email" value="${student.email}" /></td>
                    </tr>
                    <tr>
                        <td>Số điện thoại:</td>
                        <td><input type="text" name="phone" value="${student.phone}" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="submit">Cập nhật</button>
                            <a href="${pageContext.request.contextPath}/students">Hủy</a>
                        </td>
                    </tr>
                </table>
            </form>
        </body>

        </html>