
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div>
    <h1>Create form</h1>
    <form action="/login?action=createspending" method="post" >
        <div class="mb-3">
            <label for="user" class="form-label">User</label>
            <select class="form-control" id="user" name="user">
                <option>-------</option>
                <c:forEach items="${users}" var="users">
                    <option value="${users.getId()}"><c:out value="${users.getName()}"/></option>
                </c:forEach>
            </select>
        </div>
        <div>
            <input type="date" placeholder="Date" name="date_create" id="date_create">Date Create
        </div>
        <div>
            <input type="date"  placeholder="Date" name="activation_date" id="activation_date">Activation Date
        </div>
        <div>
            <input type="number" placeholder="money" name="money_limit" id="money_limit" pattern="[-+]?[0-9]">Money Limit
        </div>
    </form>
        <a href="/login?action=spendingdetail">
        <button type="submit" class="btn btn-primary">Create</button>
        </a>
        <a href="/login?action=home">
            <button type="button" class="btn btn-secondary">Cancel</button>
        </a>
</div>
</body>
</html>
