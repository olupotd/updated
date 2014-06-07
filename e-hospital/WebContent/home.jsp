<%@ page language="java" session="true" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>DoctorForum | Home</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Ropa+Sans'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/responsiveslides.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script>
	// You can also use "$(window).load(function() {"
	$(function() {

		// Slideshow 1
		$("#slider1").responsiveSlides({
			maxwidth : 1600,
			speed : 600
		});
	});
</script>
</head>
<%
	if (session.getAttribute("state").toString()
			.equalsIgnoreCase("LoggedIn")) {
%>
<body>
	<!--start-header-->
	<div class="header">
		<div class="wrap">
			<!--start-logo-->
			<div class="logo">
				<a href="home.jsp"><img src="images/logo.png" title="logo" /></a>
			</div>
			<!--end-logo-->
			<!--start-top-nav-->
			<div class="top-nav">
				<ul>
					<li><a href="home.jsp">Home</a></li>
					<li><a href="blog.jsp">blog</a></li>
					<li><a href="research.jsp">research</a></li>
					<li><a href="profile.jsp">Schedules</a></li>
					<li><a href="welcome">Logout</a></li>
				</ul>
			</div>
			<div class="clear"></div>
			<!--end-top-nav-->
		</div>
		<!--end-header-->
	</div>
	<div class="clear"></div>
	<!--start-image-slider---->
	<div class="image-slider">
		<!-- Slideshow 1 -->
		<ul class="rslides" id="slider1">
			<li><img src="images/slider-image2.jpg" alt=""></li>
		</ul>
		<!-- Slideshow 2 -->
	</div>
	<!--End-image-slider---->
	<div class="clear"></div>
	<div class="content-grids">
		<div class="wrap">
			<div class="section group">
				<div class="listview_1_of_3 images_1_of_3">
					<div class="listimg listimg_1_of_2">
						<img src="images/grid-img1.png">
					</div>
					<div class="text list_1_of_2">
						<h3>${fullnames}</h3>
						<p>Review your profile?</p>
						<div class="button">
							<span><a href="profile.jsp">Proceed</a></span>
						</div>
					</div>
				</div>
				<div class="listview_1_of_3 images_1_of_3">
					<div class="listimg listimg_1_of_2">
						<img src="images/grid-img2.png">
					</div>
					<div class="text list_1_of_2">
						<h3>
							<a href="blog.jsp">What's Trending!</a>
						</h3>
						<p>Join the debate</p>
						<div class="button">
							<span><a href="blog.jsp">Get involved</a></span>
						</div>
					</div>
				</div>
				<div class="listview_1_of_3 images_1_of_3">
					<div class="listimg listimg_1_of_2">
						<img src="images/grid-img3.png">
					</div>
					<div class="text list_1_of_2">
						<h3>
							<a href="">Report an Issue</a>
						</h3>
						<p>Something bothering you?</p>
						<div class="button">
							<span><a href="#">Get started</a></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="wrap">
		<div class="content-box">
			<div class="section group">
				<div class="col_1_of_3 span_1_of_3 frist">
					<h3>Dedicated Staff</h3>
					<img src="images/box-img1.jpg" title="staff" /> <span> </span>
					<p></p>
					<a href="#">Readmore</a>
				</div>
				<div class="col_1_of_3 span_1_of_3 second">
					<h3>Activities</h3>
					<span></span>
					<p></p>
					<ul>
						<li><a href="#"><img src="images/arrow.png">Primary
								Care Directory</a></li>
						<li><a href="#"><img src="images/arrow.png">Medical
								Fee Waiving Mechanism</a></li>
						<li><a href="#"><img src="images/arrow.png">Health
								Care Voucher</a></li>
						<li><a href="#"><img src="images/arrow.png">reprehenderit
								in voluptate</a></li>
						<li><a href="#"><img src="images/arrow.png">laboris
								nisi ut aliquip ex ean</a></li>
					</ul>
				</div>
				<div class="col_1_of_3 span_1_of_3 frist">
					<h3>Quality Service</h3>
					<img src="images/box-img2.jpg" title="staff" /> <span></span>
					<p></p>
					<a href="#">Readmore</a>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<div class="footer">
		<div class="wrap">
			<div class="footer-left">
				<ul>
					<li class="active"><a href="home.jsp">Home</a></li>
					<li><a href="blog.jsp">blog</a></li>
					<li><a href="research.jsp">research</a></li>
					<li><a href="profile.jsp">Schedules</a></li>
					<li><a href="welcome">Logout</a></li>
				</ul>
			</div>
			<div class="footer-right">
				<p>Doctors Forum</p>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!--end-wrap-->
</body>
<%
	} else {
%>
<script type="text/javascript">
	alert('You must login to get exclusive rights to view this page');
	window.location = "http://localhost:8080/e-hospital/login.jsp";
</script>
<%
	}
%>
</html>

