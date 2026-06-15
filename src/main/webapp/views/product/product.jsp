<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jav103.jav103_sum26_demo2.entity.Product" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>

<h2>Danh sách sản phẩm</h2>

<button style="padding: 8px;margin-bottom:5px"><a href="${pageContext.request.contextPath}/add-product">Add</a></button>


<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Category</th>
        <th>Action</th>
    </tr>

    <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        if (products != null) {
            for (Product p : products) {
    %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getCategory() != null ? p.getCategory().getName() : "Chưa phân loại" %></td>
        <td>
            <a href="${pageContext.request.contextPath}/product-view?id=<%= p.getId() %>">View</a> |
            <a href="${pageContext.request.contextPath}/product-delete?id=<%= p.getId() %>"
               onclick="return confirm('Bạn có chắc muốn xoá?')">Delete</a> |
            <a href="${pageContext.request.contextPath}/edit-product?id=<%= p.getId() %>">Edit</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
