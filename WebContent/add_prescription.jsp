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

  <!-- Main Stylesheet -->
  <link rel="stylesheet" href="css/style.css">

</head>

<body id="top">
<jsp:include page="navbar.jsp" />
<c:set var="role_id" value="${ applicationScope.userRoleId}"></c:set>

	<%
		int appointmentId = (int) request.getAttribute("appointmentId");
		String heading = (String) request.getAttribute("heading");
	%>
          
	<section class="page-title bg-1">
	  <div class="overlay"></div>
	  <div class="container">
	    <div class="row">
	      <div class="col-md-12">
	        <div class="block text-center">
	          <span class="text-white">Add <%=heading%> for Patient</span>
	          <h1 class="text-capitalize mb-5 text-lg"><%=heading%></h1>
	
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
	
	<section class="appoinment section">
	  <div class="container">
	    <div class="row">
	      <div class="col-lg-4">
	          <div class="mt-3">
	            <div class="feature-icon mb-3">
	              <i class="icofont-support text-lg"></i>
	            </div>
	             <span class="h3">Call for an Emergency Service!</span>
	              <h2 class="text-color mt-3">+91 12121 12121 </h2>
	          </div>
	      </div>

	      <div class="col-lg-8">
	           <div class="appoinment-wrap mt-5 mt-lg-0 pl-lg-5">
	            <h2 class="mb-2 title-color">Add Detailed <%=heading%></h2>
	               <form class="appoinment-form" method="post" action="addPrescription?appointmentId=<%=appointmentId%>&heading=<%=heading%>">
	    		
	                    <div class="form-group-2 mb-4">
	                        <textarea name="entered_text" id="message" class="form-control" rows="6" placeholder="Your Notes"></textarea>
	                    </div>
						<button type="submit" class="btn btn-main btn-round-full mb-3">Add<i class="icofont-simple-right ml-2 mb-2 "></i></button>
	                </form>
	            </div>
	        </div>
	      </div>
	    </div>
	</section>
   
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