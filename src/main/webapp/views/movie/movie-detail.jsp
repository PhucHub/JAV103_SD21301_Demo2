<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jav103.jav103_sum26_demo2.entity.Movie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin chi tiết phim</title>
</head>
<body>

<h2>Thông tin chi tiết phim</h2>

<%

    Movie movie = (Movie) request.getAttribute("movieDetail");
    if (movie != null) {
%>
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <td><%= movie.getId() %></td>
    </tr>
    <tr>
        <th>Tên phim</th>
        <td><%= movie.getTitle() %></td>
    </tr>
    <tr>
        <th>Đạo diễn</th>
        <td><%= movie.getDirector() %></td>
    </tr>
    <tr>
        <th>Thể loại</th>
        <td><%= movie.getGenre() %></td>
    </tr>
    <tr>
        <th>Năm phát hành</th>
        <td><%= movie.getReleaseYear() %></td>
    </tr>
    <tr>
        <th>Đánh giá</th>
        <td><%= movie.getRating() %></td>
    </tr>
    <tr>
        <th>Trạng thái</th>
        <td><%= movie.getStatus() %></td>
    </tr>
</table>
<%
} else {
%>
<p style="color: red;">Không tìm thấy thông tin phim này!</p>
<%
    }
%>

<br>
<button style="padding: 8px;text-decoration: none"><a href="movies">Quay lại </a></button>

</body>
</html>
