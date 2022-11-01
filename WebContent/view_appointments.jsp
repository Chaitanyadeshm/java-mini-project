<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Health  Care Medical </title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon" href="/images/favicon.ico" />

<!-- bootstrap.min css -->
<link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
<!-- Icon Font Css -->
<link rel="stylesheet" href="plugins/icofont/icofont.min.css">
<!-- Slick Slider  CSS -->
<link rel="stylesheet" href="plugins/slick-carousel/slick/slick.css">
<link rel="stylesheet"
	href="plugins/slick-carousel/slick/slick-theme.css">

<!-- Main Stylesheet -->
<link rel="stylesheet" href="css/simple.css">
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
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
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
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
</head>

<body id="top">
<c:set var="role_id" value="${ applicationScope.userRoleId}"></c:set>

<jsp:include page="navbar.jsp" />
	<div class="card-body">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-5">
							<h2>Appointments</h2>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>#</th>
							<c:if test="${role_id == 1}">
								<th>Appointment Id</th>
							</c:if>
							<c:if test="${role_id == 1 || role_id == 2}">
								<th>Patient</th>
							</c:if>
							<c:if test="${role_id == 1 || role_id == 3}">
								<th>Doctor</th>
							</c:if>
							<th>Date</th>
							<th>Time</th>
							<th>Feedback</th>
							<th>Ratings</th>
							<th>Patient's Notes</th>
							<%-- <c:if test="${role_id == 1 || role_id == 2}"> --%>
							<th>Prescription</th>
						<%-- 	</c:if> --%>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ applicationScope.appointments }"
							var="appointments" varStatus="loop">
							<tr>
								<td><c:out value="${loop.index + 1}"></c:out></td>
								<c:if test="${role_id == 1}">
									<td><c:out value="${appointments.appointmentId}"></c:out></td>
								</c:if>
								<c:if test="${role_id == 1 || role_id == 2}">
									<td>
										<c:if test="${role_id == 1}">
											<a href="showProfile?user_id=${appointments.patientId}"> <c:out value="${appointments.paitentsName}"></c:out> </a>
										</c:if>
										<c:if test="${role_id != 1}">
											 <c:out value="${appointments.paitentsName}"></c:out>
										</c:if>
									</td>
								</c:if>
								<c:if test="${role_id == 1 || role_id == 3}">
									<td>
									<c:if test="${role_id == 1}">
										<a href="showProfile?user_id=${appointments.doctorId}"><c:out value="${appointments.doctorsName}"></c:out></a>
									</c:if>
									<c:if test="${role_id != 1}">
										<c:out value="${appointments.doctorsName}"></c:out>
									</c:if>
									</td>
								</c:if>
								<td><c:out value="${appointments.appointmentDate}"></c:out></td>
								<td><c:out value="${appointments.appointmentTime}"></c:out></td>
								<c:if test="${appointments.appointmentStatus == 'Done'}">
									<c:if test="${ role_id == 3}">
										<td><a href="addPrescription?appointmentId=${appointments.appointmentId}&heading=Feedback">Add Feedback</a></td>
									</c:if>
									<c:if test="${ role_id == 1 || role_id == 2}">
										<td><a href="viewFeedback?feedback=${appointments.feedback}">View Feedback</a></td>
									</c:if>
								</c:if>	
								<c:if test="${appointments.appointmentStatus == 'Done'}">
									
								</c:if> 
								<c:if test="${appointments.appointmentStatus != 'Done'}">
									<td>Waiting for Done</td>
								</c:if>	
									
								<td><c:out value="${appointments.ratings}"></c:out></td>
								<td><a href="viewFeedback?feedback=${appointments.patientsNotes}">Notes</a></td>
								
								<c:if test="${appointments.appointmentStatus == 'Done'}">
									<c:if test="${ role_id == 1}">
										<td><a href="viewFeedback?feedback=${appointments.prescription}">View</a></td>
									</c:if>
								</c:if>
								<c:if test="${appointments.appointmentStatus != 'Done'}">
									<c:if test="${ role_id == 1 }">
										<td>Not added</td>
									</c:if>
								</c:if>
								<c:if test="${appointments.appointmentStatus == 'Approve'}">
									<c:if test="${role_id == 2}">
										<td><a href="addPrescription?appointmentId=${appointments.appointmentId}&heading=Prescription">Add Prescription</a></td>
									</c:if>
								</c:if>
								
								<c:if test="${appointments.appointmentStatus == 'Pending'}">
									<c:if test="${role_id == 2 || role_id == 3}">
										<td>Wait For Approval</td>
									</c:if>
								</c:if>
								<c:if test="${appointments.appointmentStatus == 'Done'}">
									<c:if test="${role_id == 2 }">
										<td><a href="viewFeedback?feedback=${appointments.prescription}">
										Prescription Already Added
										</a></td>
									</c:if>
									<c:if test="${role_id == 3 }">
										<td><a href="viewFeedback?feedback=${appointments.prescription}">
										View Prescription
										</a></td>
									</c:if>
								</c:if>
								<c:if test="${role_id == 2 || role_id == 3}">
									<td><c:out value="${appointments.appointmentStatus}"></c:out></td>
								</c:if>
								<!-- If admin then only can change the status using drop down -->
								<c:if test="${role_id == 1}">
									<td>
										<div class="dropdown show">
											<a class="btn btn-info dropdown-toggle btn-sm px-2 py-2"
												href="#" role="button" id="dropdownMenuLink"
												data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false"> <c:out
													value="${appointments.appointmentStatus}"></c:out>
											</a>
											<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
												<a class="dropdown-item"
													href="updateAppointmentStatus?status=Pending&oldStatus=${appointments.appointmentStatus}&id=${appointments.appointmentId}">Pending</a>
												<a class="dropdown-item"
													href="updateAppointmentStatus?status=Approve&oldStatus=${appointments.appointmentStatus}&id=${appointments.appointmentId}">Approve</a>
												<a class="dropdown-item"
													href="updateAppointmentStatus?status=Cancel&oldStatus=${appointments.appointmentStatus}&id=${appointments.appointmentId}">Cancel</a>
												
											</div>
										</div>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	<!-- Show Doctors Table -->



	<!-- footer Start -->
	<footer class="footer  gray-bg">
		<div class="container">

			<div class="footer-btm py-4 mt-5">
				<div class="row align-items-center justify-content-between">
					<div class="copyright">
						&copy; Copyright Reserved to <span class="text-color">Group
							5</span>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-4">
						<a class="backtop js-scroll-trigger" href="#top"> <i
							class="icofont-long-arrow-up"></i>
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
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAkeLMlsiwzp6b3Gnaxd86lvakimwGA6UA&callback=initMap"></script>

	<script src="js/script.js"></script>
	<script src="js/contact.js"></script>


</body>

</html>