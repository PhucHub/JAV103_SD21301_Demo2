<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Chỉnh sửa nhân viên</title>
            <style>
                .error-message {
                    color: red;
                    font-weight: bold;
                }
            </style>
        </head>

        <body>

            <h2>Chỉnh sửa thông tin nhân viên</h2>

            <form action="${pageContext.request.contextPath}/employee-edit" method="post">
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
                        <td><input type="text" name="id" value="${employee.id}" readonly /></td>
                    </tr>
                    <tr>
                        <td>Họ và tên:</td>
                        <td><input type="text" name="name" value="${employee.name}" /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="email" name="email" value="${employee.email}" /></td>
                    </tr>
                    <tr>
                        <td>Lương:</td>
                        <td><input type="number" step="0.01" name="salary" value="${employee.salary}" /></td>
                    </tr>
                    <tr>
                        <td>Phòng ban:</td>
                        <td>
                            <select name="departmentId" required>
                                <option value="">-- Chọn phòng ban --</option>
                                <c:forEach var="dept" items="${departments}">
                                    <option value="${dept.id}" ${employee.department != null && employee.department.id == dept.id ? 'selected' : ''}>${dept.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button type="submit">Cập nhật</button>
                            <a href="${pageContext.request.contextPath}/employees">Hủy</a>
                        </td>
                    </tr>
                </table>
            </form>
        </body>

        </html>
