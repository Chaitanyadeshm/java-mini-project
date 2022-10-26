<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html lang="zxx">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="description" content="Orbitor,business,company,agency,modern,bootstrap4,tech,software">
  <meta name="author" content="themefisher.com">

  <title>Novena- Health & Care Medical template</title>

  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="/images/favicon.ico" />

  <!-- bootstrap.min css -->
  <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
  <!-- Icon Font Css -->
  <link rel="stylesheet" href="plugins/icofont/icofont.min.css">
  <!-- Slick Slider  CSS -->
  <link rel="stylesheet" href="plugins/slick-carousel/slick/slick.css">
  <link rel="stylesheet" href="plugins/slick-carousel/slick/slick-theme.css">

  <!-- Main Stylesheet -->
  <link rel="stylesheet" href="css/style.css">
  <style>
	body {
		color: #566787;
		background: #f5f5f5;
		font-family: 'Varela Round', sans-serif;
		font-size: 13px;
	}
	.table-responsive {
		margin: 30px 0;
	}
	.table-wrapper {
		min-width: 1000px;
		background: #fff;
		padding: 20px 25px;
		border-radius: 3px;
		box-shadow: 0 1px 1px rgba(0,0,0,.05);
	}
	.table-title {
		padding-bottom: 15px;
		background: #299be4;
		color: #fff;
		padding: 16px 30px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
	}
	.table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.table-title .btn {
		color: #566787;
		float: right;
		font-size: 13px;
		background: #fff;
		border: none;
		min-width: 50px;
		border-radius: 2px;
		border: none;
		outline: none !important;
		margin-left: 10px;
	}
	.table-title .btn:hover, .table-title .btn:focus {
		color: #566787;
		background: #f2f2f2;
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
	table.table tr th, table.table tr td {
		border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
	}
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 100px;
	}
	table.table-striped tbody tr:nth-of-type(odd) {
		background-color: #fcfcfc;
	}
	table.table-striped.table-hover tbody tr:hover {
		background: #f5f5f5;
	}
	table.table th i {
		font-size: 13px;
		margin: 0 5px;
		cursor: pointer;
	}	
	table.table td:last-child i {
		opacity: 0.9;
		font-size: 22px;
		margin: 0 5px;
	}
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
	}
	table.table td a:hover {
		color: #2196F3;
	}
	table.table td a.settings {
		color: #2196F3;
	}
	table.table td a.delete {
		color: #F44336;
	}
	table.table td i {
		font-size: 19px;
	}
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
	.status {
		font-size: 30px;
		margin: 2px 2px 0 0;
		display: inline-block;
		vertical-align: middle;
		line-height: 10px;
	}
	.text-success {
		color: #10c469;
	}
	.text-info {
		color: #62c9e8;
	}
	.text-warning {
		color: #FFC107;
	}
	.text-danger {
		color: #ff5b5b;
	}
	.pagination {
		float: right;
		margin: 0 0 5px;
	}
	.pagination li a {
		border: none;
		font-size: 13px;
		min-width: 30px;
		min-height: 30px;
		color: #999;
		margin: 0 2px;
		line-height: 30px;
		border-radius: 2px !important;
		text-align: center;
		padding: 0 6px;
	}
	.pagination li a:hover {
		color: #666;
	}	
	.pagination li.active a, .pagination li.active a.page-link {
		background: #03A9F4;
	}
	.pagination li.active a:hover {        
		background: #0397d6;
	}
	.pagination li.disabled i {
		color: #ccc;
	}
	.pagination li i {
		font-size: 16px;
		padding-top: 6px
	}
	.hint-text {
		float: left;
		margin-top: 10px;
		font-size: 13px;
	}
	</style>
	<script>
	$(document).ready(function(){
		$('[data-toggle="tooltip"]').tooltip();
	});
	</script>
</head>

<body id="top">

<header>
	
	<c:set var="role_id" value="${ applicationScope.userRoleId}"></c:set>
	<nav class="navbar navbar-expand-lg navigation" id="navbar">
		<div class="container">
		 	 <a class="navbar-brand" href="index.jsp">
			  	<img src="images/logo.png" alt="" class="img-fluid">
			  </a>

		  	<button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarmain" aria-controls="navbarmain" aria-expanded="false" aria-label="Toggle navigation">
			<span class="icofont-navigation-menu"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarmain">
			<ul class="navbar-nav ml-auto">
			  <li class="nav-item active">
				<a class="nav-link" href="index.jsp">Home <c:out value="${role_id}"></c:out></a>
			  </li>
				   <li class="nav-item"><a class="nav-link" href="viewAppointments">Appointments</a></li>
			   <c:if test="${role_id == 2}">
				   <li class="nav-item"><a class="nav-link" href="view_feedbacks.jsp">Feedbacks</a></li>
			  </c:if>
			  <c:if test="${role_id == 1 || role_id == 3}">
			  	<li class="nav-item"><a class="nav-link" href="showAllDoctors">Doctors</a></li>
			  </c:if>
			  <li class="nav-item"><a class="nav-link" href="user_profile.jsp">User Profile</a> </li> 
			  	
			</ul>
		  </div>
		</div>
	</nav>
</header>
	


<!-- Slider Start -->
<section class="banner">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-12 col-xl-7">
				<div class="block">
					<div class="divider mb-3"></div>
					<span class="text-uppercase text-sm letter-spacing ">Total Health care solution</span>
					<h1 class="mb-3 mt-3">Your most trusted health partner</h1>
					
					<p class="mb-4 pr-5">Preventive health check-ups are extremely important because they can reveal early risk factors for disease and can detect developing illness in their early stages, when you are not even showing any symptoms.</p>
					
				</div>
			</div>
		</div>
	</div>
</section>
<c:if test="${role_id == 1}">
	<section class="features">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="feature-block d-lg-flex">
						<div class="feature-item mb-5 mb-lg-0">
							<div class="feature-icon mb-4">
								<i class="icofont-surgeon-alt"></i>
							</div>
							<span>Be a Professional</span>
							<h4 class="mb-3">Register a Doctor</h4>
							<p class="mb-4">Register a doctor in our existing teams of professional doctors.</p>
							<a href="/registerDoctor" class="btn btn-main btn-round-full">Register Doctor</a>
						</div>
					
						<div class="feature-item mb-5 mb-lg-0">
							<div class="feature-icon mb-4">
								<i class="icofont-ui-clock"></i>
							</div>
							<span>Timing schedule</span>
							<h4 class="mb-3">Working Hours</h4>
							<ul class="w-hours list-unstyled">
			                    <li class="d-flex justify-content-between">Sun - Wed : <span>12:00 - 13:00</span></li>
			                    <li class="d-flex justify-content-between">Thu - Fri : <span>13:00 - 14:00</span></li>
			                    <li class="d-flex justify-content-between">Sat - sun : <span>14:00 - 15:00</span></li>
			                </ul>
							<a href="show_users.jsp" class="btn btn-main btn-round-full">View ALl Users</a>
						</div>
					
						<div class="feature-item mb-5 mb-lg-0">
							<div class="feature-icon mb-4">
								<i class="icofont-support"></i>
							</div>
							<span>Appointments</span>
							<h4 class="mb-3">Manage Appointments</h4>
							<p>Update the appointment status of patients so doctor can see patient.</p>
							 <a href="appoinment.html" class="btn btn-main btn-round-full">Manage Appointments</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</c:if>
<section>
	<div class="container-xl mb-5 mb-lg-0 mx-4">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="text-center">
							<h2>Doctors</h2>
						</div>
						
					</div>
				</div>
				<table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Mobile</th>
                            <th>Specialization</th>
                            <th>Active</th>
                            <th>City</th>
                        </tr>
                    </thead>
                    <tbody>
                          	<c:forEach items="${ applicationScope.doctors }" var="doctors">
                    
                        <tr>
                            <td><c:out value="${doctors.userId }"></c:out></td>
                            <td><a href="#"><i class="icofont-user"><c:out value="${doctors.firstname }"></c:out>  <c:out value="${doctors.lastname}"></c:out> </i></a></td>
                            <td><c:out value="${doctors.email}"></c:out></td>
                            <td><c:out value="${doctors.mobile}"></c:out></td>
                            <td>
                                 <div class="dropdown">
                                    <button class="btn btn-secondary dropdown-toggle" type="button"
                                        id="dropdownMenuButton" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false">
                                        Specialization
                                    </button>
                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <c:forEach items="${ doctors.specializations }" var="specialization">
                                        <a class="dropdown-item"><c:out value="${specialization }"></c:out></a>
                                       </c:forEach>
                                    </div>
                                </div> 
                            </td>
                            <td><span class="status text-success">&bull;</span> Active</td>
                            <td><c:out value="${doctors.city}"></c:out></td>
                        </tr>
                        </c:forEach>
                    </tbody>
				</table>
			</div>
		</div>
	</div>
</section>

<c:if test="${role_id == 3}">
<section class="section appoinment">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 ">
				<div class="appoinment-content">
					<img src="images/about/img-3.jpg" alt="" class="img-fluid">
	
				</div>
			</div>
			<div class="col-lg-6 col-md-10 ">
				<div class="appoinment-wrap mt-5 mt-lg-0">
					<h2 class="mb-2 title-color">Book appoinment</h2>
					<p class="mb-4">Mollitia dicta commodi est recusandae iste, natus eum asperiores corrupti qui velit . Iste dolorum atque similique praesentium soluta.</p>
					     <form id="#" class="appoinment-form" method="post" action="#">
                    <div class="row">
                         <div class="col-lg-6">
                            <div class="form-group">
                                <select class="form-control" id="exampleFormControlSelect1">
                                  <option>Choose Department</option>
                                  <option>Software Design</option>
                                  <option>Development cycle</option>
                                  <option>Software Development</option>
                                  <option>Maintenance</option>
                                  <option>Process Query</option>
                                  <option>Cost and Duration</option>
                                  <option>Modal Delivery</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <select class="form-control" id="exampleFormControlSelect2">
                                  <option>Select Doctors</option>
                                  <option>Software Design</option>
                                  <option>Development cycle</option>
                                  <option>Software Development</option>
                                  <option>Maintenance</option>
                                  <option>Process Query</option>
                                  <option>Cost and Duration</option>
                                  <option>Modal Delivery</option>
                                </select>
                            </div>
                        </div>

                         <div class="col-lg-6">
                            <div class="form-group">
                                <input name="date" id="date" type="text" class="form-control" placeholder="dd/mm/yyyy">
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="form-group">
                                <input name="time" id="time" type="text" class="form-control" placeholder="Time">
                            </div>
                        </div>
                         <div class="col-lg-6">
                            <div class="form-group">
                                <input name="name" id="name" type="text" class="form-control" placeholder="Full Name">
                            </div>
                        </div>

                        <div class="col-lg-6">
                            <div class="form-group">
                                <input name="phone" id="phone" type="Number" class="form-control" placeholder="Phone Number">
                            </div>
                        </div>
                    </div>
                    <div class="form-group-2 mb-4">
                        <textarea name="message" id="message" class="form-control" rows="6" placeholder="Your Message"></textarea>
                    </div>

                    <a class="btn btn-main btn-round-full" href="appoinment.html" >Make Appoinment <i class="icofont-simple-right ml-2  "></i></a>
                </form>
            </div>
			</div>
		</div>
	</div>
</section>
</c:if>
    
<!-- footer Start -->
<footer class="footer  gray-bg">
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
   

    <!-- 
    Essential Scripts
    =====================================-->

    
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
   