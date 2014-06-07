<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Doctor's Forum | Home</title>
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

	if (screen.width <= 800) {
		window.location = "http://localhost:8080/e-hospital/mobile/";
	}
</script>
</head>
<body>
	<!--start-wrap-->

	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=189263487927760&version=v2.0";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<!--start-header-->
	<div class="header">
		<div class="wrap">
			<!--start-logo-->
			<div class="logo">
				<a href="index.jsp"><img src="images/logo.png" title="logo" /></a>
			</div>
			<!--end-logo-->
			<!--start-top-nav-->
			<div class="top-nav">
				<ul>
					<li><a href="home.jsp">Home</a></li>
					<li><a href="about.jsp">About</a></li>
					<li><a href="services.jsp">services</a></li>
					<li><a href="contact.jsp">contact</a></li>
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
			<li><img src="images/slider-image1.jpg" alt=""></li>
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
						<img src="images/grid-img2.png">
					</div>
					<div class="text list_1_of_2">
						<h3>Out Clients</h3>
						<p>Need More info?</p>
						<div class="button">
							<span><a href="about.html">Know us better</a></span>
						</div>
					</div>

				</div>
				<div class="listview_1_of_3 images_1_of_3">

					<div class="text list_1_of_2">
						<div class="contact-form">
							<h4>${status}</h4>

							<form action="welcome" method="post">
								<div>
									<span><label>USERNAME</label></span> <span><input
										type="text" name="username"></span>
								</div>
								<div>
									<span><label>PASSWORD</label></span> <span><input
										type="password" name="password"></span>
								</div>

								<div>
									<span><input type="submit" value="lOGIN"></span>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="listview_1_of_3 images_1_of_3">
					<div class="listimg listimg_1_of_2">
						<img src="images/grid-img3.png">
					</div>
					<div class="text list_1_of_2">
						<h3>Visit Us</h3>
						<p>Need More info?</p>
						<div class="button">
							<span><a href="contact.jsp">Email us.</a></span>
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
					<h3>Government Programs</h3>
					<img src="images/box-img1.jpg" title="staff" /> <span> </span>
					<p></p>
					<a href="#">Readmore</a>
				</div>
				<div class="col_1_of_3 span_1_of_3 second">
					<h3>Activities</h3>
					<p>Current Activities.</p>
				</div>
				<div class="col_1_of_3 span_1_of_3 frist">
					<h3>Health Tips</h3>
					<span> Health tips here </span>
					<p>
						<a class="twitter-timeline" href="https://twitter.com/WHO"
							data-widget-id="474529585862701058">Tweets by @WHO</a>
						<script>
							!function(d, s, id) {
								var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
										.test(d.location) ? 'http' : 'https';
								if (!d.getElementById(id)) {
									js = d.createElement(s);
									js.id = id;
									js.src = p
											+ "://platform.twitter.com/widgets.js";
									fjs.parentNode.insertBefore(js, fjs);
								}
							}(document, "script", "twitter-wjs");
						</script>

					</p>
				</div>
			</div>
		</div>
	</div>



	<div class="clear"></div>
	<div class="footer">
		<div class="wrap">
			<div class="footer-left">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About</a></li>
					<li><a href="services.jsp">services</a></li>
					<li><a href="contact.jsp">contact</a></li>
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
</html>

