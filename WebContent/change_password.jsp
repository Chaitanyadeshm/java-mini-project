<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Health  Care Medical </title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>



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

	<c:set var="userProfile" value="${applicationScope.userProfile}"></c:set>
	 <div class="signup-form">
			<form action="<%= request.getContextPath() %>/changePassword?user_id=${userProfile.userId}" method="post">
					<h2>Change Profile's Password</h2>
					<p class="hint-text">Enter your new password</p>
					
					<div class="form-group">
						<input type="text" class="form-control" name="new_password" placeholder="New Password" 
						 required="required" >
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="confirm_password" placeholder="Confirm Password"
						 required="required" >
					</div>
					<c:if test="${not empty error_msg }">
						<p class="text-center text-danger fs-5">${error_msg}</p>
						<c:remove var="error_msg" scope="session" />
					</c:if>
				<div class="form-group">
					<button type="submit" class="btn btn-info btn-lg btn-block">Update Password</button>
				</div>
			</form>
		</div>
	
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
</body>
</html>