<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/7/2022
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1>All City</h1>
<button type="button" class="btn btn-outline-primary">
    <a href="${pageContext.request.contextPath}/cities?action=createGet">Create New City</a>
</button>
<div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Popular</th>
            <th>Area</th>
            <th>GDP</th>
            <th>Country</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cityList}" var="city">
            <tr>
                <td>${city.getId_city()}</td>
                <td>${city.getName_city()}</td>
                <td>${city.getPopular()}</td>
                <td>${city.getArea()}</td>
                <td>${city.getGDP()}</td>
                <td>${city.getName_country()}</td>
                <td>
                    <button type="button" class="btn btn-outline-danger">
                        <a href="${pageContext.request.contextPath}/cities?action=editGet&id=${city.getId_city()}">Edit</a>
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-outline-danger">
                        <a href="${pageContext.request.contextPath}/cities?action=delete&id=${city.getId_city()}">Delete</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
