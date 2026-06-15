<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jav103.jav103_sum26_demo2.entity.Movie" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Movie List</title>
</head>
<body>

<h2>Danh sách phim</h2>

<button style="padding: 8px;margin-bottom:5px"><a href="${pageContext.request.contextPath}/movie-add-form">Thêm phim</a></button>


<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Tên phim</th>
        <th>Đạo diễn</th>
        <th>Thể loại</th>
        <th>Năm phát hành</th>
        <th>Đánh giá</th>
        <th>Trạng thái</th>
        <th></th>
    </tr>

    <%
        List<Movie> movies = (List<Movie>) request.getAttribute("movies");
        if (movies != null) {
            for (Movie m : movies) {
    %>
    <tr>
        <td><%= m.getId() %></td>
        <td><%= m.getTitle() %></td>
        <td><%= m.getDirector() %></td>
        <td><%= m.getGenre() %></td>
        <td><%= m.getReleaseYear() %></td>
        <td><%= m.getRating() %></td>
        <td><%= m.getStatus() %></td>
        <td>

            <a href="${pageContext.request.contextPath}/movie-view?id=<%= m.getId() %>">Xem</a> |
            <a href="${pageContext.request.contextPath}/movie-delete?id=<%= m.getId() %>"
               onclick="return confirm('Bạn có chắc muốn xoá phim này?')">Xoá</a>|
            <a href="${pageContext.request.contextPath}/movie-edit-form?id=<%= m.getId() %>">Sửa</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
