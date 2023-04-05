<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/6/2022
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <style>
        div {
            margin: auto;
            width: 500px;
        }
    </style>
</head>
<body>
<form method="post" action="/login?action=updateSpending">
    <div>
        <h1>Update form</h1>
        <div class="mb-3 mt-3">
            <input value="${sl.getId().getName()}"/>
        </div>
        <div class="mb-3 mt-3">
            <input value="${sl.getId()}"/>
        </div>
        <div class="mb-3 mt-3">
            <input value="${sl.getDateCreate()}"/>
        </div>
        <div class="mb-3 mt-3">
            <input value="${sl.getDateActive()}"/>
        </div>
        <div class="mb-3 mt-3">
            <input value="${sl.getMoney()}"/>
        </div>
        <a href="/login?action=login">
            <button type="button" class="btn btn-secondary">Cancel</button>
        </a>
    </div>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
<a href="login?action=login">
    <button type="button" class="btn btn-secondary">Cancel</button>
</a>
</body>
</html>