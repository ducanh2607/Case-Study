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
            margin-left: 500px;
        }
        a {
            color: black;
            text-decoration: none;
            font-weight: bold;
        }
        input {
            border-radius: 4px;
            color: orange;
        }
        form {
            float: right;
        }
        th {
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-weight: bold;
            font-size: 25px;
            color: #dd4b39;
        }

        td {
            font-family: "Lato", Arial, sans-serif;
            font-weight: lighter;
            font-size: 20px;
        }

        body {
            background-color: lightgray;
        }
    </style>

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


</head>
<body>
<div class="container">
    <h1>List User</h1>
    <h6><a href="/login"><button class="btn btn-secondary">Log out</button></a></h6>
    <h6><a href="home/home.jsp"><button class="btn btn-primary">Home</button></a></h6>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th></th>
            <th>Name</th>
            <th></th>
            <th>Username</th>
            <th></th>
            <th>Password</th>
            <th></th>
            <th>Status</th>
            <th></th>
            <th>Wallet</th>
            <th></th>
            <th></th>
            <th colspan="3" style="text-align: center; width: 25%">Action</th>
        </tr>
        <c:forEach items="${users}" var="u">
            <tr>
                <td style="text-align: center"><c:out value="${u.getId()}"></c:out></td>
                <td>|</td>
                <td style="text-align: center"><c:out value="${u.getName()}"></c:out></td>
                <td>|</td>
                <td style="text-align: center"><c:out value="${u.getUserName()}"></c:out></td>
                <td>|</td>
                <td style="text-align: center"><c:out value="${u.getPassword()}"></c:out></td>
                <td>|</td>
                <td style="text-align: center"><c:out value="${u.isStatus()}"></c:out></td>
                <td>|</td>
                <td style="text-align: center"><c:out value="${u.getWallet()}"></c:out></td>
                <td></td>
                <td></td>
                <td><a href="admin?action=block&id=${u.getId()}" onclick='return confirm(${u.getId()}, ${u.getUserName()}, "block")'><button class="btn btn-warning">Block</button></a></td>
                <td><a href="admin?action=unlock&id=${u.getId()}" onclick='return confirm(${u.getId()}, ${u.getUserName()}, "unlock")'><button class="btn btn-success">Unlock</button></a></td>
                <td><a href="admin?action=delete&id=${u.getId()}" onclick='return confirm(${u.getId()}, ${u.getUserName()}, "delete")'><button class="btn btn-danger">Delete</button></a></td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
<script>
    function confirm(id, name, target){
        Swal.fire({
            title: "Do you want to " + target + " user: " + name + ' ?',
            showDenyButton: true,
            showCancelButton: false,
            confirmButtonText: target,
            denyButtonText: 'Cancel',
            timer: 5000
        }).then((result) => {
            if (result.isConfirmed){
                Swal.fire({
                    title: 'Delete successfully',
                    timer: 2500
                })
                check(id, target)
            }else if (result.isDenied){
            }
        })
        return false
    }
    function check(id, target){
        window.location.href = "http://local.host:8000/admin?action=" + target + "&id=" + id;
    }
</script>
</html>

