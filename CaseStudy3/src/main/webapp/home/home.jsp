<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Light Bootstrap Dashboard - Free Bootstrap 4 Admin Dashboard by Creative Tim</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <!-- CSS Files -->
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="../assets/css/demo.css" rel="stylesheet"/>
</head>
<body>
<link rel="stylesheet" href="homepage.css">
<div class="wrapper">
    <div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
        <div style=" " class="sidebar-wrapper">
            <div class="logo">
                <a href="javascript:;" class="simple-text">
                    <span> Sending Management</span>
                </a>
            </div>
            <ul class="nav">
                <li class="nav-item active">
                    <a class="nav-link" href="dashboard.html">
                        <p>Income and Expense</p>
                        <%-------////////////////////   Danh Sach Chi tieu--%>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="user.jsp">
                        <p>Account</p>
                        <%-------//////////////////// Quan ly Acc count--%>
                    </a>
                </li>
                <li>
                    <a class="nav-link" href="/login?action=spendingdetail">
                        <p>Spending limit detail</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg " color-on-scroll="500">
            <div class="container-fluid">

                <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                        aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar burger-lines"></span>
                    <span class="navbar-toggler-bar burger-lines"></span>
                    <span class="navbar-toggler-bar burger-lines"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    <ul class="nav navbar-nav mr-auto">

                        <li class="nav-item">
                            <a href="#" class="nav-link"> <%------///////////////////////  Tim Kiem -------%>
                                <i class="nc-icon nc-zoom-split"></i>
                                <span class="d-lg-block">&nbsp;Search</span>
                            </a>
                        </li>
                    </ul>
                    <ul class="navbar-nav ml-auto">
                        <li style="padding-top: 27px" class="nav-item">
                            <a href="/login?action=createWallet"
                               data-toggle="modal"
                               data-target="#myModal">
                                <button style="background-color: #8564ca;border: none;border-radius: 10px;color: white;font-size: 13px;padding: 10px; "
                                        type="submit"
                                        class="btn-primary">ADD TRANSACTION
                                </button>
                            </a>
                            <%----------------  ////////////////////////////// Them chi tieu--%>
                        </li>
                        <a href="/login?action=createForm">
                            <li style="padding-top: 27px" class="nav-item">
                                <button style="background-color: #8564ca;border: none;border-radius: 10px; " type="submit"
                                        class="btn-primary">
                                    ADD SPENDING LIMIT
                                </button>
                        </a>
                        <%----------------  ////////////////////////////// Them chi tieu--%>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#pablo"><%-----------////////////////    Dang xuat--%>
                                <span class="no-icon">Log out</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <div style="width: 700px;text-align: center" class="card">
                    <form method="post" action="/login?action=createWallet">
                        <h3 style="color: #8564ca"><b>Add Transaction</b></h3>
                        <select onchange="categorySelected()" id="type" name="type">
                            <option selected hidden>Category Transaction</option>
                            <option value="0" id="expense" name="expense">Expense</option>
                            <option value="1" id="income" name="income">Income</option>
                        </select>

                        <select id="clone">
                            <option selected>Category</option>
                        </select>

                        <select hidden id="category1" name="category1">

                            <c:forEach items="${categoriesType1}" var="c">
                                <option class="type1" value="${c.getId()}">${c.getName()}</option>
                            </c:forEach>
                        </select>

                        <select hidden id="category2" name="category2">

                            <c:forEach items="${categoriesType2}" var="c">
                                <option class="type1" value="${c.getId()}">${c.getName()}</option>
                            </c:forEach>

                        </select>

                        <input type="text" placeholder="Amount" name="money">
                        <input type="date" placeholder="Date" name="date">
                        <textarea name="notes" placeholder="Notes..."></textarea>

                        <div id="btn-modal">
                            <button type="submit" style="background-color:#1e7e34;" class="btn">Add</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>


        <div class="modal fade" id="myModalEditExpense" role="dialog">
            <div class="modal-dialog">
                <div style="width: 700px;text-align: center" class="card">
                    <form method="post" action="/login?action=editWallet">
                        <h3 style="color: #8564ca"><b>Edit Expense Transaction</b></h3>
                        <input type="text" value="${wallet.getId()}" name="id" hidden>

                        <select disabled name="type">
                            <option selected value="0" name="expense">Expense</option>
                            <option value="1"  name="income">Income</option>
                        </select>

                        <select id="category-ex" name="category1">
                            <option selected hidden value="${wallet.getCategory().getId()}">${wallet.getCategory().getName()}</option>

                            <c:forEach items="${categoriesType1}" var="c">
                                <option class="type1" value="${c.getId()}">${c.getName()}</option>
                            </c:forEach>
                        </select>

                        <input type="text" placeholder="Amount" name="money" id="money">
                        <input disabled type="date" placeholder="Date" name="date" id="date">
                        <textarea name="notes" id="note" placeholder="Notes..."></textarea>

                        <div id="btn-modal-expense">
                            <button type="submit" style="background-color:#4d6fe3;" class="btn">Edit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <div class="modal fade" id="myModalEditIncome" role="dialog">
            <div class="modal-dialog">
                <div style="width: 700px;text-align: center" class="card">
                    <form method="post" action="/login?action=editWallet">
                        <h3 style="color: #8564ca"><b>Edit Income Transaction</b></h3>

                        <input type="text" name="a" id="a" hidden>

                        <input type="text" value="${wallet.getId()}" name="id" hidden>
                        <select disabled name="type">
                            <option value="0" name="expense">Expense</option>
                            <option selected value="1"  name="income">Income</option>
                        </select>

                        <select class="category-in" name="category2">
                            <option selected hidden value="${wallet.getCategory().getId()}">${wallet.getCategory().getName()}</option>

                            <c:forEach items="${categoriesType2}" var="c">
                                <option class="type1" value="${c.getId()}">${c.getName()}</option>
                            </c:forEach>
                        </select>
                        <input type="text" placeholder="Amount" name="money" id="money1">
                        <input disabled type="date" placeholder="Date" name="date" id="date1">
                        <textarea id="note1" name="notes" placeholder="Notes..."></textarea>

                        <div id="btn-modal-income">
                            <button type="submit" style="background-color:#4d6fe3;" class="btn">Edit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="section">
                    <div class="container" style="margin-top: 20px;">

                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <form action="" class="form-horizontal" id="validate">
                                    <ul class="nav nav-tabs nav-justified nav-inline">
                                        <li class="active">
                                            <button style="  background-color: #8564ca; ; border: none;">
                                                <a style="color: white" href="#primary" data-toggle="tab"><b>Expense</b></a>
                                            </button>
                                        </li>
                                        <li>
                                            <button style="  background-color: #8564ca;color: white;  border: none;">
                                                <a style="color: white" href="#secondary"
                                                   data-toggle="tab"><b>Income</b></a>
                                            </button>
                                        </li>
                                    </ul>

                                    <div class="tab-content tab-validate" style="margin-top:20px;">
                                        <div class="tab-pane active" id="primary">
                                            <c:forEach items="${walletsExpense}" var="wallet">
                                                <div class="item-spending">
                                                    <div class="item-head">
                                                        <p style="padding: 10px 0px 0px 10px;color: #8564ca;font-weight: bold">
                                                            <b>Expense</b></p>
                                                        <div class="item-btn">
                                                            <button

                                                                    onclick="passVariable('${wallet.getId()}','${wallet.getDate()}','${wallet.getCategory().getId()}','${wallet.getMoney()}','${wallet.getNotes()}')"

                                                                    style="border-radius: 10px" class="btnEdit-item" >
                                                                <a href="login?action=updateForm&id=${wallet.getId()}"
                                                                   style="color: white" data-toggle="modal"
                                                                   data-target="#myModalEditExpense">
                                                                    Edit
                                                                </a>
                                                            </button>
                                                            <button style="border-radius: 10px" class="btnDelete-item">
                                                                <a style="color: white"
                                                                   href="login?action=deleteWallet&id=${wallet.getId()}">
                                                                    Delete
                                                                </a>
                                                            </button>
                                                        </div>
                                                    </div>
                                                    <div class="item-top">
                                                        <i class="fa fa-arrow-up"
                                                           style="font-size:20px;color:#cc3e3e;padding: 5px 0px 0px 10px"></i>
                                                        <div><span
                                                                style="background-color: #cc3e3e;padding: 5px;border-radius: 10px;color: white"><c:out
                                                                value="${wallet.getCategory().getName()}"/></span>
                                                        </div>
                                                        <p><span><b>Date :</b></span><c:out
                                                                value="${wallet.getDate()}"/></p>
                                                    </div>
                                                    <div style="display: grid; grid-template-columns: 40% 60%;padding-left: 78px"
                                                         class="item-bot">
                                                        <p><span><b>Total:</b></span><c:out
                                                                value="${wallet.getMoney()}"/></p>
                                                        <p style="padding-left: 95px"><span><b>Note</b></span>:<c:out
                                                                value="${wallet.getNotes()}"/></p>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>

                                        <div class="tab-pane" id="secondary">
                                            <c:forEach items="${walletsIncome}" var="wallet">
                                                <div class="item-spending">
                                                    <div class="item-head">
                                                        <p style="padding: 10px 0px 0px 10px;color: #8564ca;font-weight: bold">
                                                            <b>Income</b></p>
                                                        <div class="item-btn">
                                                            <button style="border-radius: 10px" class="btnEdit-item"
                                                                    onclick="passVariable2('${wallet.getId()}','${wallet.getDate()}','${wallet.getCategory().getId()}','${wallet.getMoney()}','${wallet.getNotes()}')">
                                                                <a  href="login?action=updateForm&id=${wallet.getId()}"
                                                                    style="color: white" data-toggle="modal"
                                                                    data-target="#myModalEditIncome">
                                                                    Edit
                                                                </a>
                                                            </button>
                                                            <button style="border-radius: 10px" class="btnDelete-item">
                                                                <a style="color: white"
                                                                   href="login?action=deleteWallet&id=${wallet.getId()}">
                                                                    Delete
                                                                </a>
                                                            </button>
                                                        </div>
                                                    </div>
                                                    <div class="item-top">
                                                        <i class="fa fa-arrow-down"
                                                           style="font-size:20px;color:#1e7e34;padding: 5px 0px 0px 10px"></i>
                                                        <div><span
                                                                style="background-color: #1e7e34;padding: 5px;border-radius: 10px;color: white">
                                                        <c:out value="${wallet.getCategory().getName()}"/>
                                                    </span>
                                                        </div>
                                                        <p><span><b>Date : </b></span>${wallet.getDate()}</p>
                                                    </div>
                                                    <div style="display: grid; grid-template-columns: 40% 60%;padding-left: 78px"
                                                         class="item-bot">
                                                        <p><span><b>Total :</b></span>${wallet.getMoney()}</p>
                                                        <p style="padding-left: 95px">
                                                            <span><b>Note : </b></span>${wallet.getNotes()}</p>
                                                    </div>
                                                </div>
                                            </c:forEach>

                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container-fluid">
                <nav>
                    <ul class="footer-menu">
                        <li>
                            <a href="#">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Company
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Portfolio
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Blog
                            </a>
                        </li>
                    </ul>
                    <p class="copyright text-center">
                        ©
                        <script>
                            document.write(new Date().getFullYear())
                        </script>
                        <a href="">F44</a> Hũ chi tiêu số 1 Châu Á
                    </p>
                </nav>
            </div>
        </footer>
    </div>
</div>

<script>
    function passVariable(id,date,category,money,note){
        document.getElementById("category-ex").value = category
        document.getElementById("date").value = date
        document.getElementById("money").value = money
        document.getElementById("note").value = note
    }

    function passVariable2(id,date,category,money,note){
        document.getElementById("category-in").value = category
        document.getElementById("date1").value = date
        document.getElementById("money1").value = money
        document.getElementById("note1").value = note
    }
</script>
</body>
<!--   Core JS Files   -->
<style>
    body {
        box-sizing: border-box;
        margin: auto;
    }

    @import url(https://fonts.googleapis.com/css?family=Calibri:400,300,700);


    textarea {
        margin-left: 10px;
        width: 220px;
        border-color: #8564ca;
        outline: none;
        border-radius: 10px;
    }


    .card form select {
        border-radius: 10px;
        margin: 10px;
        width: 220px;
        height: 30px;
        border-color: #8564ca;
        outline: none;
    }

    .card form input {
        margin: 10px;
        width: 220px;
        height: 30px;
        outline: none;
        padding: 10px;
        border-radius: 10px;
        border-color: #8564ca;
    }

    @media (max-width: 767px) {
        .card {
            width: 90vw;
        }
    }


    .card-title p {
        color: rgb(29, 226, 226);
        font-weight: 900;
        font-size: 30px;
        margin-bottom: unset;
    }

    .card-text p {
        color: grey;
        font-size: 25px;
        text-align: center;
        padding: 3vh 0;
        font-weight: lighter;
    }

    #btn-modal,#btn-modal-expense,#btn-modal-income {
        margin-left: 260px;
        display: grid;
        grid-template-columns: 45% 45%;
    }

    #btn-modal button,#btn-modal-expense button,#btn-modal-income button {
        border-radius: 10px;
        border: none;
        color: white;
        margin: 15px;

    }


    .item-top {
        padding: 10px 0px 5px 10px;
        display: grid;
        grid-template-columns:10% 50% 40%;

    }

    .item-title {
        font-weight: bold;
    }

    .item-spending {
        background-color: white;
        width: 70%;
        padding-left: 50px;
        border-radius: 15px;
        margin-bottom: 30px;
        border: 5px solid;
        border-color: #892ef1 #9c73ec #afaff1;
    }

    .item-head {
        display: grid;
        grid-template-columns: 60% 40%;
    }

    .btnEdit-item {
        height: 30px;
        width: 50px;
        border: none;
        background-color: #1e7e34;
        color: white;
    }

    .btnDelete-item {
        height: 30px;
        width: 70px;
        border: none;
        color: white;
        background-color: #a22626;
    }

    .item-btn {
        margin: 10px;
        padding-left: 120px;
    }

</style>
<script>
    let category = document.getElementById("category");
    let type = document.getElementById("type");
    let options = type.options;
    // let type1 = document.getElementsByClassName("type1");
    let expense = document.getElementById("category1");
    let income = document.getElementById("category2");
    let clone = document.getElementById("clone");

    // let type2 = document.getElementsByClassName("type2");


    function categorySelected() {

        if (options[1].selected === true) {
            income.hidden = true;
            clone.hidden = true;
            expense.hidden = false;
        }
        if (options[2].selected === true) {
            clone.hidden = true;
            income.hidden = false;
            expense.hidden = true;
        }
    }


</script>

<script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="assets/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>

</html>
