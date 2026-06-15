<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jav103.jav103_sum26_demo2.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm mới sản phẩm</title>
    <style>
        .error-message {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h2>Thêm mới sản phẩm</h2>

<form action="${pageContext.request.contextPath}/products/insert" method="post">
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
                <input type="text" name="id" required placeholder="Nhập số ID..." value="${product.id}"/>
            </td>
        </tr>
        <tr>
            <td>Tên sản phẩm:</td>
            <td>
                <input type="text" name="name"  placeholder="Nhập tên sản phẩm..." value="${product.name}"/>
            </td>
        </tr>
        <tr>
            <td>Giá:</td>
            <td>
                <input type="text" step="0.01" name="price" required placeholder="Nhập giá..." value="${product.price}"/>
            </td>
        </tr>
        <tr>
            <td>Danh mục:</td>
            <td>
                <select name="categoryId" required>
                    <option value="">-- Chọn danh mục --</option>
                    <%
                        List<Category> categories = (List<Category>) request.getAttribute("categories");
                        if (categories != null) {
                            for (Category cat : categories) {
                    %>
                    <option value="<%= cat.getId() %>"><%= cat.getName() %></option>
                    <%
                            }
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Lưu lại</button>
                <a href="${pageContext.request.contextPath}/products">Hủy bỏ</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
