<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/7/2022
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create New City</title>
</head>
<body>
<center>
    <h2>
        <a href="/cities?action=cities">Back To Home</a>
    </h2>
</center>
<div align="center">
    <form action="/cities?action=createPost" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New City</h2>
            </caption>
            <tr>
                <th>Name City:</th>
                <td>
                    <input type="text" name="name_city" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Popular:</th>
                <td>
                    <input type="text" name="popular" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Area:</th>
                <td>
                    <input type="text" name="area" size="45"/>
                </td>
            </tr>
            <tr>
                <th>GDP:</th>
                <td>
                    <input type="text" name="GDP" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <select name="name_country">
                        <c:forEach items="${countryList}" var="country">
                        <option value="${country.getName_country()}">${country.getName_country()}</option>
                        </c:forEach>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
