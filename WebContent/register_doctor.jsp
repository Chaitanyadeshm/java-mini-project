<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description"
			content="Orbitor,business,company,agency,modern,bootstrap4,tech,software">
		<meta name="author" content="themefisher.com">

		  <title>Health  Care Medical </title>


  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="/images/favicon.ico" />

  <!-- bootstrap.min css -->
  <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
  <!-- Icon Font Css -->
  <link rel="stylesheet" href="plugins/icofont/icofont.min.css">
  <!-- Slick Slider  CSS -->
  <link rel="stylesheet" href="plugins/slick-carousel/slick/slick.css">
  <link rel="stylesheet" href="plugins/slick-carousel/slick/slick-theme.css">

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>


  <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Raleway'>
  <link rel='stylesheet' href='https://fonts.googleapis.com/icon?family=Material+Icons'>

  <link rel="stylesheet" href="css/style.css">
  
  <style>
	  body {
		  line-height: 1.6;
		  font-family: "Roboto", sans-serif;
		  -webkit-font-smoothing: antialiased;
		  font-size: 16px;
		  font-weight: 400;
		  position: relative;
		  overflow: hidden;
		  background: url("images/bg/slider-bg-1.jpg") no-repeat;
		  background-size: cover;
		  min-height: 550px;
	  }

	  .form-control {
		  height: 40px;
		  box-shadow: none;
		  color: #969fa4;
	  }

	  .form-control:focus {
		  border-color: #5cb85c;
	  }

	  .form-control,
	  .btn {
		  border-radius: 10px;
	  }

	  .signup-form {
		  width: 450px;
		  margin: 0 auto;
		  padding: 30px 0;
		  font-size: 15px;
	  }

	  .signup-form h2 {
		  color: #636363;
		  margin: 0 0 15px;
		  position: relative;
		  text-align: center;
	  }

	  .signup-form h2:before,
	  .signup-form h2:after {
		  content: "";
		  height: 2px;
		  width: 30%;
		  background: #d4d4d4;
		  position: absolute;
		  top: 50%;
		  z-index: 2;
	  }

	  .signup-form h2:before {
		  left: 0;
	  }

	  .signup-form h2:after {
		  right: 0;
	  }

	  .signup-form .hint-text {
		  color: #999;
		  margin-bottom: 30px;
		  text-align: center;
	  }

	  .signup-form form {
		  color: #999;
		  border-radius: 3px;
		  margin-bottom: 15px;
		  background: rgb(247, 247, 242);
		  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
		  padding: 30px;
	  }

	  .signup-form .form-group {
		  margin-bottom: 20px;
	  }

	  .signup-form input[type="checkbox"] {
		  margin-top: 3px;
	  }

	  .signup-form .btn {
		  font-size: 16px;
		  font-weight: bold;
		  min-width: 140px;
		  outline: none !important;
	  }

	  .signup-form .row div:first-child {
		  padding-right: 10px;
	  }

	  .signup-form .row div:last-child {
		  padding-left: 10px;
	  }

	  .signup-form a {
		  color: #fff;
		  text-decoration: underline;
	  }

	  .signup-form a:hover {
		  text-decoration: none;
	  }

	  .signup-form form a {
		  color: #5cb85c;
		  text-decoration: none;
	  }

	  .signup-form form a:hover {
		  text-decoration: underline;
	  }
  </style>

	</head>

	<body>
<jsp:include page="navbar.jsp" />
<c:set var="role_id" value="${ applicationScope.userRoleId}"></c:set>

		<div class="signup-form">
			<form action="registerDoctor" method="post">
					<h2>Register</h2>
					<p class="hint-text">Register a Doctor into our existing team of
						professionals.</p>
						<br>
					<div class="form-group">
						<div class="row">
							<div class="col"><input type="text" class="form-control" name="first_name"
									placeholder="First Name"
									required="required"></div>
							<div class="col"><input type="text" class="form-control" name="last_name"
									placeholder="Last Name"
									required="required"></div>
						</div>
					</div>
					<div class="form-group">
						<input type="email" class="form-control" name="email" placeholder="Email"
							required="required">
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col"><input type="number" class="form-control" name="mobile"
									placeholder="Mobile no."
									required="required"></div>
							<div class="col"><input type="text" class="form-control" name="city"
									placeholder="City"
									required="required"></div>
						</div>
					</div>
				<div class="form-group">
						<p>Select Specialization</p>
							<fieldset>      
							<c:forEach items="${ applicationScope.specializations }" var="specialization">
								<input type="checkbox" name="selected_specialization" value="${specialization.specializationId}"> <c:out value="${specialization.category}"></c:out>
							</c:forEach>
							</fieldset>  
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg btn-block">Create Account</button>
				</div>
			</form>
		</div>
	</div>
   
<!-- footer Start -->
				<footer class="footer gray-bg">
					<div class="container">

						<div class="footer-btm py-4 mt-5">
							<div class="row align-items-center justify-content-between">
								<div class="copyright">
									&copy; Copyright Reserved to <span class="text-color">Group 5</span>
								</div>
							</div>

							<div class="row">
								<div class="col-lg-4">
									<a class="backtop js-scroll-trigger" href="#top">
										<i class="icofont-long-arrow-up"></i>
									</a>
								</div>
							</div>
						</div>
					</div>
				</footer>


    <!-- Main jQuery -->
    <script src="plugins/jquery/jquery.js"></script>
    <!-- Bootstrap 4.3.2 -->
    <script src="plugins/bootstrap/js/popper.js"></script>
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="plugins/counterup/jquery.easing.js"></script>
    <!-- Slick Slider -->
    <script src="plugins/slick-carousel/slick/slick.min.js"></script>
    <!-- Counterup -->
    <script src="plugins/counterup/jquery.waypoints.min.js"></script>
    
    <script src="plugins/shuffle/shuffle.min.js"></script>
    <script src="plugins/counterup/jquery.counterup.min.js"></script>
    <!-- Google Map -->
    <script src="plugins/google-map/map.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAkeLMlsiwzp6b3Gnaxd86lvakimwGA6UA&callback=initMap"></script>    
    
    <script src="js/script.js"></script>
    <script src="js/contact.js"></script>

			</body>

		</html>