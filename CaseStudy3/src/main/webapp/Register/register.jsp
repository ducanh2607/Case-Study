<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 12/2/2022
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.6.14/dist/sweetalert2.min.css">
</head>
<body class="img js-fullheight" style="background-image: url(images/register.jpg);">
<script>

</script>
<form action="/login?action=create" method="post">
    <link rel="stylesheet" href="css/style.css">
    <section class="ftco-section">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <h2 class="heading-section">Create Account</h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-6 col-lg-4">
                    <div class="login-wrap p-0">
                        <h3 class="mb-4 text-center">Have an account?</h3>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Username" name="username" id="username" required>
                        </div>
                        <div class="form-group">
                            <input id="password-field" type="password" class="form-control" placeholder="Password" name="password"
                                   required>
                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                                <button type="submit" class="form-control btn btn-primary submit px-3">Accept</button>
                        </div>
                        <a href="/login?action=login"><span>Back to home</span></a>
                        <div class="form-group d-md-flex">
                            <div class="w-50">
                                <span></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </section>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.6.14/dist/sweetalert2.min.js"></script>
<script>
    document.querySelector('button').addEventListener('click', (event) => {
        event.preventDefault();
        Swal.fire(
            'Register Successfullly!',
            'You clicked the button!',
            'success'
        )
    })
</script>
</html>
