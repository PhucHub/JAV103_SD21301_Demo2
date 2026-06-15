<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Thêm mới phim</title>
  <style>
    .error-message {
      color: red;
      font-weight: bold;
    }
  </style>
</head>
<body>

<h2>Thêm mới phim</h2>

<form action="${pageContext.request.contextPath}/movies/insert" method="post">
  <table cellpadding="5">
    <c:if test="${not empty errorMessage}">
      <tr>
        <td colspan="2" class="error-message">
            ${errorMessage}
        </td>
      </tr>
    </c:if>

    <tr>
      <td>Tên phim:</td>
      <td>
        <input type="text" name="title" required placeholder="Nhập tên phim..." value="${movie.title}"/>
      </td>
    </tr>
    <tr>
      <td>Đạo diễn:</td>
      <td>
        <input type="text" name="director" placeholder="Nhập tên đạo diễn..." value="${movie.director}"/>
      </td>
    </tr>
    <tr>
      <td>Thể loại:</td>
      <td>
        <input type="text" name="genre" placeholder="Nhập thể loại..." value="${movie.genre}"/>
      </td>
    </tr>
    <tr>
      <td>Năm phát hành:</td>
      <td>
        <input type="number" name="releaseYear" placeholder="Nhập năm phát hành..." value="${movie.releaseYear}"/>
      </td>
    </tr>
    <tr>
      <td>Đánh giá:</td>
      <td>
        <input type="number" step="0.1" name="rating" placeholder="Nhập đánh giá (0-10)..." value="${movie.rating}"/>
      </td>
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
        <button type="submit">Lưu lại</button>
        <a href="${pageContext.request.contextPath}/movies">Hủy bỏ</a>
      </td>
    </tr>
  </table>
</form>

</body>
</html>
