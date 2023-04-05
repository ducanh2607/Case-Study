<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 12/2/2022
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="img js-fullheight" style="background-image: url(../images/bgg.jpg);">
<link rel="stylesheet" href="css/style.css">
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">Spending Management</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-4">
                <div class="login-wrap p-0">
                    <form method="post" action="/login?action=login">
                        <div class="form-group">
                            <input type="text" class="form-control" name="user_name" placeholder="Username" required>
                        </div>
                        <div class="form-group">
                            <input id="password-field" type="password" class="form-control" name="password" placeholder="Password" required>
                            <span toggle="#password-field" ></span>
                            <h5 style="color:white"><c:out value="${message}"/></h5>
                        </div>
                        <div class="form-group">

                            <button type="submit" class="form-control btn btn-primary submit px-3" ><i class="fa-solid fa-right-to-bracket" style="margin-right: 30px; color: coral;text-align: center" ></i>Sign In</button>

                        </div>
                    </form>
                        <div class="form-group">
                            <a href="login/create.jsp">
                                <button type="submit" class="form-control btn btn-primary submit px-3"><i class="fa-solid fa-pen-to-square" style="color: coral; margin-right: 20px"></i>Register</button>
                            </a>
                        </div>
                        <div class="form-group d-md-flex">
                            <div class="w-50">
                                    <span></span>
                                </label>
                            </div>
                            <div>
                                <%--   MODAL QUEN MAT KHAU--%>
                                <!DOCTYPE html>
                                <html>
                                <head>
                                    <meta name="viewport" content="width=device-width, initial-scale=1">
                                    <script src="https://kit.fontawesome.com/8a5dbdb706.js" crossorigin="anonymous"></script>
                                    <style>
                                        body {font-family: Arial, Helvetica, sans-serif;}

                                        /* Full-width input fields */
                                        input[type=text], input[type=password] {
                                            width: 100%;
                                            padding: 12px 20px;
                                            margin: 8px 0;
                                            display: inline-block;
                                            border: 1px solid #ccc;
                                            box-sizing: border-box;
                                        }

                                        /* Set a style for all buttons */
                                        button {
                                            background-color: #04AA6D;
                                            color: white;
                                            padding: 14px 20px;
                                            margin: 8px 0;
                                            border: none;
                                            cursor: pointer;
                                            width: 50%;
                                        }

                                        button:hover {
                                            opacity: 0.8;
                                        }

                                        /* Extra styles for the cancel button */
                                        .cancelbtn {
                                            width: auto;
                                            padding: 10px 18px;
                                            background-color: #f44336;
                                        }

                                        /* Center the image and position the close button */
                                        .imgcontainer {
                                            text-align: center;
                                            margin: 24px 0 12px 0;
                                            position: relative;
                                        }

                                        img.avatar {
                                            width: 25%;
                                            border-radius: 35%;
                                        }

                                        .container {
                                            padding: 16px;
                                        }

                                        span.psw {
                                            float: right;
                                            padding-top: 16px;
                                        }

                                        /* The Modal (background) */
                                        .modal {
                                            display: none; /* Hidden by default */
                                            position: fixed; /* Stay in place */
                                            z-index: 1; /* Sit on top */
                                            left: 0;
                                            top: 0;
                                            width: 100%; /* Full width */
                                            height: 100%; /* Full height */
                                            overflow: auto; /* Enable scroll if needed */
                                            background-color: rgb(0,0,0); /* Fallback color */
                                            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
                                            padding-top: 60px;
                                        }

                                        /* Modal Content/Box */
                                        .modal-content {
                                            background-color: #fefefe;
                                            margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                                            border: 1px solid #888;
                                            width: 50%; /* Could be more or less, depending on screen size */
                                        }

                                        /* The Close Button (x) */
                                        .close {
                                            position: absolute;
                                            right: 25px;
                                            top: 0;
                                            color: #000;
                                            font-size: 35px;
                                            font-weight: bold;
                                        }

                                        .close:hover,
                                        .close:focus {
                                            color: red;
                                            cursor: pointer;
                                        }

                                        /* Add Zoom Animation */
                                        .animate {
                                            -webkit-animation: animatezoom 0.6s;
                                            animation: animatezoom 0.6s
                                        }

                                        @-webkit-keyframes animatezoom {
                                            from {-webkit-transform: scale(0)}
                                            to {-webkit-transform: scale(1)}
                                        }

                                        @keyframes animatezoom {
                                            from {transform: scale(0)}
                                            to {transform: scale(1)}
                                        }

                                        /* Change styles for span and cancel button on extra small screens */
                                        @media screen and (max-width: 300px) {
                                            span.psw {
                                                display: block;
                                                float: none;
                                            }
                                            .cancelbtn {
                                                width: 100%;
                                            }
                                        }
                                    </style>
                                </head>
                                <body>
                                <button onclick="document.getElementById('id01').style.display='block'" style="width:auto; border-radius: 25px; backdrop-filter: brightness(90)">Forgot Password</button>

                                <div id="id01" class="modal">

                                    <form class="modal-content animate" action="/action_page.php" method="post">
                                        <div class="imgcontainer">
                                            <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                                            <img src="/images/logo.png" class="avatar">
                                        </div>

                                        <div class="container">
                                            <i class="fa-solid fa-user" style="color:coral;"></i>
                                            <label for="uname" style="color: coral"><b>Username</b></label>
                                            <input type="text" placeholder="Enter Username" id="uname" name="uname" style="border-radius: 25px;background-color: lightblue" required>

                                            <i class="fa-solid fa-envelope" style="color:coral"></i>
                                            <label for="psw" style="color: coral; border-radius: 25px" ><b>Your Email</b></label>
                                            <input type="password" placeholder="Enter Your Email" id="psw" name="psw" style=" border-radius: 25px; background-color: lightblue" required>

                                            <button type="submit" style="margin-left: 150px; background-color: #7abaff; color: red; border-radius: 25px">Accept</button>
                                        </div>
                                    </form>
                                </div>

                                <script>
                                    // Get the modal
                                    var modal = document.getElementById('id01');

                                    // When the user clicks anywhere outside of the modal, close it
                                    window.onclick = function(event) {
                                        if (event.target == modal) {
                                            modal.style.display = "none";
                                        }
                                    }
                                </script>
                                </body>
                                </html>
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
</body>
</html>
