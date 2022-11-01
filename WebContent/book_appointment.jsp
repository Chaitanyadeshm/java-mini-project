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
	<c:set var="specializationId" value="${applicationScope.specializationId}"></c:set>
	
               <!-- Show Doctors Table -->
           <form action="" method="get"></form>
                <div class="card-body">
                    <div class="container-xl mb-5 mb-lg-0">
                        <div class="table-responsive">
                            <div class="table-wrapper">
                                <div class="table-title">
                                    <div class="row">
                                        <div class="col-sm-5">
                                            <h2>Doctor</h2>
                                        </div>
                                    </div>
                                </div>
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Book</th>
                                        </tr>
                                    </thead>
                                    <tbody>
										<c:forEach items="${ applicationScope.specializedDoctors }" var="doctors">
	                                        <tr>
	                                            <td><c:out value="${loop.index}"></c:out></td>
	                                            <td><a href="#"><i class="icofont-user"><c:out value="${doctors.firstname } "></c:out>  <c:out value="${doctors.lastname}"></c:out> </i></a></td>
	                                            <td><c:out value="${doctors.email}"></c:out></td>
	                                            <td><a href="<%= request.getContextPath() %>/bookAppointment?doctorId=${doctors.userId}&specializationId=${applicationScope.specializationId}"
	                                             class="btn btn-main btn-round-full mb-3">Book<i class="icofont-simple-right ml-2 mb-2 "></i></a></td>
	                                          <%--   <td><c:out value="${doctors.userId}"></c:out></td> --%>
	                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
        

    
<c:if test="${doctor_selected > 0}">
	<section class="page-title bg-1">
	  <div class="overlay"></div>
	  <div class="container">
	    <div class="row">
	      <div class="col-md-12">
	        <div class="block text-center">
	          <span class="text-white">Book your Seat</span>
	          <h1 class="text-capitalize mb-5 text-lg">Appoinment</h1>
	
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
	            <h2 class="mb-2 title-color">Book an appoinment</h2>
	            
	            <!-- <p class="mb-4">Mollitia dicta commodi est recusandae iste, natus eum asperiores corrupti qui velit . Iste dolorum atque similique praesentium soluta.</p> -->
	               <form class="appoinment-form" method="post" action="bookAppointment">
	                    <div class="row">
	                        
	                         <div class="col-lg-6">
	                            <div class="form-group">
	                                 <input name="date" id="date" type="date" class="form-control" placeholder="yyyy-mm-dd"> 
	                            </div>
	                        </div>
	
	                        <div class="col-lg-6">
	                            <div class="form-group">
	                                <select class="form-control" id="exampleFormControlSelect1" name="time">
	                                  <option value ="11:00">Choose Time</option>
	                                  <option value="12:00:00">12:00 - 13:00</option>
	                                  <option value="13:00:00">13:00 - 14:00</option>
	                                  <option value="14:00:00">14:00 - 15:00</option>
	                                </select>
	                            </div>
	                    </div>
	                    <div class="form-group-2 mb-4">
	                        <textarea name="patient_notes" id="message" class="form-control" rows="6" placeholder="Your Notes"></textarea>
	                    </div>
						<button type="submit" class="btn btn-main btn-round-full mb-3">Make Appoinment<i class="icofont-simple-right ml-2 mb-2 "></i></button>
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