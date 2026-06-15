<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jav103.jav103_sum26_demo2.entity.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin chi tiết sản phẩm</title>
</head>
<body>

<h2>Thông tin chi tiết sản phẩm</h2>

<%
    Product product = (Product) request.getAttribute("productDetail");
    if (product != null) {
%>
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>Mã Sản Phẩm (ID)</th>
        <td><%= product.getId() %></td>
    </tr>
    <tr>
        <th>Tên Sản Phẩm</th>
        <td><%= product.getName() %></td>
    </tr>
    <tr>
        <th>Giá</th>
        <td><%= product.getPrice() %></td>
    </tr>
    <tr>
        <th>Danh mục</th>
        <td><%= product.getCategory() != null ? product.getCategory().getName() : "Chưa phân loại" %></td>
    </tr>
</table>
<%
} else {
%>
<p style="color: red;">Không tìm thấy thông tin sản phẩm này!</p>
<%
    }
%>

<br>
<button style="padding: 8px;text-decoration: none"><a href="${pageContext.request.contextPath}/products">Quay lại</a></button>

</body>
</html>
