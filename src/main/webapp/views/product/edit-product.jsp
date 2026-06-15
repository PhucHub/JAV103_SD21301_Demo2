<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jav103.jav103_sum26_demo2.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa sản phẩm</title>
    <style>
        .error-message {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h2>Chỉnh sửa thông tin sản phẩm</h2>

<form action="${pageContext.request.contextPath}/product-edit" method="post">
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
            <td><input type="text" name="id" value="${product.id}" readonly /></td>
        </tr>
        <tr>
            <td>Tên sản phẩm:</td>
            <td><input type="text" name="name"  value="${product.name}" /></td>
        </tr>
        <tr>
            <td>Giá:</td>
            <td><input type="text" step="0.01" name="price" required value="${product.price}" /></td>
        </tr>
        <tr>
            <td>Danh mục:</td>
            <td>
                <select name="categoryId" required>
                    <option value="">-- Chọn danh mục --</option>
                    <%
                        List<Category> categories = (List<Category>) request.getAttribute("categories");
                        Long selectedCategoryId = null;
                        if (request.getAttribute("product") != null) {
                            com.jav103.jav103_sum26_demo2.entity.Product p =
                                (com.jav103.jav103_sum26_demo2.entity.Product) request.getAttribute("product");
                            if (p.getCategory() != null) {
                                selectedCategoryId = p.getCategory().getId();
                            }
                        }
                        if (categories != null) {
                            for (Category cat : categories) {
                                boolean selected = cat.getId().equals(selectedCategoryId);
                    %>
                    <option value="<%= cat.getId() %>" <%= selected ? "selected" : "" %>><%= cat.getName() %></option>
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
                <button type="submit">Cập nhật</button>
                <a href="${pageContext.request.contextPath}/products">Hủy</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
