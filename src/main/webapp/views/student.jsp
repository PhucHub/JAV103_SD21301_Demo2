<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Student Info</title>
</head>
<body>
<h1>Student Information</h1>
<p>
    <b>First Name:</b> ${firstName} </p>

<p>
    <b>Last Name:</b> ${lastName} </p>

<p>
    <b>Form:</b> ${country}
</p>

<p>
    <b>Favourite Language:</b>
    <br>
<ul>
    <c:choose>
        <c:when test="${not empty lang}">
            <c:forEach var="item" items="${lang}">
                <li>${item}</li> </c:forEach>
        </c:when>
        <c:otherwise>
            No language selected.
        </c:otherwise>
    </c:choose>
</ul>
</p>

</body>
</html>