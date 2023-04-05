<!--
=========================================================
Light Bootstrap Dashboard - v2.0.1
=========================================================

Product Page: https://www.creative-tim.com/product/light-bootstrap-dashboard
Copyright 2019 Creative Tim (https://www.creative-tim.com)
Licensed under MIT (https://github.com/creativetimofficial/light-bootstrap-dashboard/blob/master/LICENSE)

Coded by Creative Tim

=========================================================

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.  -->
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.ico">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>Light Bootstrap Dashboard - Free Bootstrap 4 Admin Dashboard by Creative Tim</title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
  <!-- CSS Files -->
  <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="../assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="../assets/css/demo.css" rel="stylesheet" />
</head>

<body>
<div class="wrapper">
  <div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
    <!--
Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

Tip 2: you can also add an image using data-image tag
-->
    <div class="sidebar-wrapper">
      <div class="logo">
        <a href="javascript:;" class="simple-text">
          <span> Sending Management</span>
        </a>
      </div>
      <ul class="nav">
        <li class="nav-item active">
          <a class="nav-link" href="home.jsp">
            <p>Income and Expense</p>
            <%-------////////////////////   Danh Sach Chi tieu--%>
          </a>
        </li>
        <li>
          <a class="nav-link" href="statistical.jsp">
            <p>Account</p>
            <%-------//////////////////// Quan ly Acc count--%>
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
              <button style="background-color: #8564ca;border: none;border-radius: 10px; " type="submit"
                      class="btn-primary">
                <a style="color: white;font-size: 13px;padding: 10px" data-toggle="modal"
                   data-target="#myModal">ADD TRANSACTION</a>
              </button>
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



    <!-- End Navbar -->
    <div class="content">
      <table>
        <tr>
          <th></th>
          <th>Total income</th>
          <th>Total spending</th>
        </tr>
        <tr>
          <th>January</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th>February</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th>March</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th>April</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th>May</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th>June</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th>July</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th> August</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th>September</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th>October</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th>November</th>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <th>December</th>
          <td></td>
          <td></td>
        </tr>
      </table>
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
            <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
          </p>
        </nav>
      </div>
    </footer>
  </div>
</div>

-->
</body>
<style>
  table {
    border: 1px solid;
    width: 80%;
    border-color: #8564ca;
    border-radius: 10px;
  }
  tr {
    border: 1px solid;
    border-color: #8564ca;
    border-radius: 10px;
  }

  td {
    border: 1px solid;
    border-color: #8564ca;
    border-radius: 10px;
  }

  th {
    border: 1px solid;
    border-color: #8564ca;
    text-align: center;
    border-radius: 10px;
  }
</style>
<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="../assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="../assets/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="../assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="../assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="../assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="../assets/js/demo.js"></script>

</html>
