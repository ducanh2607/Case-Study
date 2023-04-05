
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
        h1 {
            margin-left: 20px;
            text-align: center;
            Color: orangered;
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
            float: unset;
        }

    </style>
</head>
<body>
<div>
    <h1>Detail Spending List</h1>
        <table class="table table-striped">
            <tr>
                <th>Date Create</th>
                <td><c:out value="${details.getDateCreate()}"/></td>
                <th>Date Active</th>
                <td><c:out value="${details.getDateActive()}"/></td>
                <th>Money Limit</th>
                <td><c:out value="${details.getMoney()}"/></td>
                <th colspan="2" style="text-align: center; margin-left: 10px">Action</th>
                <td><a href="/login?action=update&id=${p.getId()}"><button class="btn btn-warning">Update</button> </a></td>
                <td><a href="/login?action=update&id=${p.getId()}"><button class="btn btn-warning">Delete</button> </a></td>
        </table>
        <div>
            <a href="home/home.jsp">
                <button type="button" class="btn btn-secondary">Cancel</button>
            </a>
        </div>
</div>
</body>
</html>
