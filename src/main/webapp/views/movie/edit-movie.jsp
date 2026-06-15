<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa phim</title>
    <style>
        .error-message {
            color: red;
            font-weight: bold;
        }
    </style>
</head>

<body>

    <h2>Chỉnh sửa thông tin phim</h2>

    <form action="${pageContext.request.contextPath}/movie-edit" method="post">
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
                <td><input type="text" name="id" value="${movie.id}" readonly /></td>
            </tr>
            <tr>
                <td>Tên phim:</td>
                <td><input type="text" name="title" value="${movie.title}" /></td>
            </tr>
            <tr>
                <td>Đạo diễn:</td>
                <td><input type="text" name="director" value="${movie.director}" /></td>
            </tr>
            <tr>
                <td>Thể loại:</td>
                <td><input type="text" name="genre" value="${movie.genre}" /></td>
            </tr>
            <tr>
                <td>Năm phát hành:</td>
                <td><input type="number" name="releaseYear" value="${movie.releaseYear}" /></td>
            </tr>
            <tr>
                <td>Đánh giá:</td>
                <td><input type="number" step="0.1" name="rating" value="${movie.rating}" /></td>
            </tr>
            <tr>
                <td>Trạng thái:</td>
                <td>
                    <select name="status">
                        <option value="Đang chiếu" ${movie.status == 'Đang chiếu' ? 'selected' : ''}>Đang chiếu</option>
                        <option value="Sắp chiếu" ${movie.status == 'Sắp chiếu' ? 'selected' : ''}>Sắp chiếu</option>
                        <option value="Ngừng chiếu" ${movie.status == 'Ngừng chiếu' ? 'selected' : ''}>Ngừng chiếu</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Cập nhật</button>
                    <a href="${pageContext.request.contextPath}/movies">Hủy</a>
                </td>
            </tr>
        </table>
    </form>
</body>

</html>
