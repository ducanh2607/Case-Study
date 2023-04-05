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
<h1>Update form</h1>
<form method="post">
  <input type="text" value="${user.getId()}" name="id_user" hidden>
  <div class="mb-3 mt-3">
    <label for="name" class="form-label">Name</label>
    <input type="text" class="form-control" id="name" placeholder="Enter name" name="name_user" value="${user.getName()}">
  </div>
  <input type="text" value="${user.getUserName()}" name="user_name" hidden>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="text" class="form-control" id="password" placeholder="Enter password" name="password" value="${user.getPassword()}">
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Wallet</label>
    <input type="text" class="form-control" id="wallet" placeholder="Enter password" name="wallet" value="${user.getWallet()}">
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Share</label>
    <input type="text" class="form-control" id="share" placeholder="Enter password" name="share" value="${user.isShare()}">
  </div>

  <button type="submit" class="btn btn-primary">Update</button>
  <a href="login?action=login"><button type="button" class="btn btn-secondary">Cancel</button></a>
</form>

</body>
</html>
