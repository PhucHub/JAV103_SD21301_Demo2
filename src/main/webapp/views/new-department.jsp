<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jav103.jav103_sum25_demo2.entity.Category" %>
<%@ page import="com.jav103.jav103_sum25_demo2.entity.Department" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Thêm mới Phòng ban</title>
</head>
<body>

<h2>Thêm mới Phòng ban</h2>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    Department department = (Department) request.getAttribute("department");
    if (errorMessage != null) {
%>
    <p style="color: red;"><%= errorMessage %></p>
<%
    }
%>

<form action="${pageContext.request.contextPath}/department/insert" method="post">
    <label>Mã phòng ban:</label><br/>
    <input type="text" name="code" value="<%= (department != null && department.getCode() != null) ? department.getCode() : "" %>" /><br/><br/>
    
    <label>Tên phòng ban:</label><br/>
    <input type="text" name="name" value="<%= (department != null && department.getName() != null) ? department.getName() : "" %>" /><br/><br/>

    <label>Loại phòng ban:</label><br/>
    <select name="categoryId">
        <option value="">-- Chọn Loại phòng ban --</option>
        <%
            List<Category> categories = (List<Category>) request.getAttribute("categories");
            if (categories != null) {
                for (Category c : categories) {
                    boolean isSelected = department != null && department.getCategory() != null && department.getCategory().getId().equals(c.getId());
        %>
            <option value="<%= c.getId() %>" <%= isSelected ? "selected" : "" %>><%= c.getName() %></option>
        <%
                }
            }
        %>
    </select><br/><br/>

    <button type="submit">Thêm mới</button>
    <a href="${pageContext.request.contextPath}/department">Quay lại</a>
</form>

</body>
</html>
