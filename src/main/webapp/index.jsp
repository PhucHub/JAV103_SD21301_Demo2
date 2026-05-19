<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<p>SD21301</p>
<%--1.expression--%>
<p>The time on server: <%= new java.util.Date() %></p>
<p>Convert to upper case <%="Hallo".toUpperCase() %></p>
<p>Summary of 3 and 6 = <%= 3+6 %></p>

<%--2.scriptlet--%>
<%
    for (int i =1 ;i<4;i++){
        out.println("Item"+i);
        out.println("<br>");
    }


%>
<%--3.declaration--%>
<%!
    String makeItLower(String data){
        return data.toLowerCase();
    }

%>
<p>Lower case of Hello World: <%= makeItLower("Hello World")%></p>

<form action="StudentServlet">
    First Name : <input type="text" name="firstname">
    <br>
    Last Name : <input type="text" name="lastname">
    <br>

    <label>
        <select name="country">
            <option>Lao</option>
            <option>Cam</option>
            <option>VN</option>
            <option>TQ</option>
            <option>HQ</option>
        </select>

    </label>
    <br>
    <input type="checkbox" name="favouriteLang" value="java">Java
    <input type="checkbox" name="favouriteLang" value="C#">C#
    <input type="checkbox" name="favouriteLang"  value="PHP">PHP
    <input type="checkbox" name="favouriteLang"  value="JavaScript">JS
    <br>
    <input type="submit" value="Submit">
</form>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>