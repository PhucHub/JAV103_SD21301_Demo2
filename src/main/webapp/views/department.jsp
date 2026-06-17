<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jav103.jav103_sum25_demo2.entity.Department" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Phòng ban</title>
    <script>
        function loadAjax() {
            console.log("=== Đang lấy dữ liệu bằng Ajax ===");
            fetch('${pageContext.request.contextPath}/department')
                .then(response => {
                    if (response.ok) {
                        console.log("Đã tải xong dữ liệu danh sách phòng ban.");
                        alert("Đã gọi Ajax thành công! Xem log ở Console.");
                    }
                })
                .catch(error => console.error("Có lỗi xảy ra:", error));
        }
    </script>
</head>
<body>

<h2>Danh sách phòng ban</h2>

<!-- Tìm kiếm -->
<form action="${pageContext.request.contextPath}/department" method="get" style="margin-bottom: 15px;">
    <input type="text" name="search" placeholder="Nhập tên phòng ban..." value="<%= request.getParameter("search") != null ? request.getParameter("search") : "" %>" />
    <button type="submit">Tìm kiếm</button>
</form>

<button style="padding: 8px;margin-bottom:5px">
    <a href="${pageContext.request.contextPath}/department/add-form" style="text-decoration:none; color:black;">Thêm mới</a>
</button>

<button style="padding: 8px;margin-bottom:5px" onclick="loadAjax()">
    Load qua Ajax (Console)
</button>

<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Mã phòng ban</th>
        <th>Tên phòng ban</th>
        <th>Loại phòng ban</th>
        <th>Hành động</th>
    </tr>

    <%
        List<Department> departments = (List<Department>) request.getAttribute("departments");
        if (departments != null) {
            for (Department d : departments) {
    %>
    <tr>
        <td><%= d.getId() %></td>
        <td><%= d.getCode() %></td>
        <td><%= d.getName() %></td>
        <td><%= d.getCategory() != null ? d.getCategory().getName() : "" %></td>
        <td>
            <a href="${pageContext.request.contextPath}/department/edit-form?id=<%= d.getId() %>">Edit</a> |
            <a href="${pageContext.request.contextPath}/department/delete?id=<%= d.getId() %>"
               onclick="return confirm('Bạn có chắc muốn xoá phòng ban này?')">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
