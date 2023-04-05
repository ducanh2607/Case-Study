<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2022
  Time: 11:24 AM
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
        h1 {
            text-align: center;
            color: orangered;
        }
        a {
            color: black;
            text-decoration: none;
            font-weight: bold;
        }
        input {
            border-radius: 4px;
        }
        form {
            float: right;
        }
        body {
            background-color: lightgray;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome</h1>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Username</th>
            <th>Password</th>
            <th>Wallet</th>
            <th>Share</th>
            <th colspan="3" style="text-align: center; width: 25%">Action</th>
        </tr>
        <tr>
            <td name="id"><c:out value="${user.getId()}"></c:out></td>
            <td><c:out value="${user.getName()}"></c:out></td>
            <td><c:out value="${user.getUserName()}"></c:out></td>
            <td><c:out value="${user.getPassword()}"></c:out></td>
            <td><c:out value="${user.getWallet()}"></c:out></td>
            <td><c:out value="${user.isShare()}"></c:out></td>
            <td>
                <a href="admin?action=update&id=${user.getId()}">
                    <button class="btn btn-warning">
                        Update
                    </button>
                </a>
            </td>
            <td><a href="/login?action=logout"><button class="btn btn-primary">Log out</button></a> </td>
<%--            <td ><a href="/login?action=view&id=${user.getId()}"><button style="column-span: 5" class="btn btn-primary">View Spending Detail</button></a> </td>--%>
            <td><a href=/login?action=createForm><button class="btn btn-secondary">Add Spending</button></a> </td>
        </tr>
    </table>
</div>
</body>
</html>
