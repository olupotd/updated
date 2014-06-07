<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" errorPage="error.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>medicare Website Schedules</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Ropa+Sans'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<!--start-wrap-->

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
					<li><a href="blog.jsp">blog</a></li>
					<li><a href="research.jsp">research</a></li>
					<li class="active"><a href="profile.jsp">Schedules</a></li>
					<li><a href="welcome">Logout</a></li>
				</ul>
			</div>
			<div class="clear"></div>
			<!--end-top-nav-->
		</div>
		<!--end-header-->
	</div>
	<div class="clear"></div>

	<div class="wrap">
		<div class="about">
			<h4>Welcome ${fullnames}</h4>
			<div class="content-box">
				<div class="section group">
					<div class="col_1_of_3 span_1_of_3 frist">
						<h3>Basic Info</h3>
						<h5>${fullnames}</h5>
						<br /> <img src="images/box-img1.jpg" title="staff" />
						<!-- The basic information in a loop for the given user. -->
						<hr />
						<p>Location ${location}</p>
						<hr />
						<p>Department.${dept}</p>
						<hr />
						<p>Contact: ${contact}</p>
						<hr />
						<p>Full names: ${fullnames}</p>
						<hr />

					</div>

					<!-- Displays the schedules available for the user -->
					<div class="col_1_of_3 span_1_of_3 second">
						<h3>Schedules</h3>
						<p>You are schedules for the following activities.</p>

						<ul>
							<%
								for (String schedule : (List<String>) session
										.getAttribute("schedules")) {
									String val[] = schedule.split(";");
							%>
							<li><a href="pars?id=<%out.println(val[0]);%>"><img
									src="images/arrow.png"> <%
 	out.println(val[1]);
 %></a></li>
							<%
								}
							%>
						</ul>
					</div>
					<!-- End of the schedules section. -->
					<!-- Displays the social interactions between the user and other community members. -->
					<div class="col_1_of_3 span_1_of_3 frist">
						<h3>Communities</h3>
						<img src="images/staff1.jpg" title="staff" /> <span>Social
							information here.</span> <br /> <br /> <img src="images/staff2.jpg"
							title="staff" /> <span>Pictures of your friends and other
							stuff.</span>
					</div>
					<!-- End of the div -->
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<div class="footer">
		<div class="wrap">
			<div class="footer-left">
				<ul>
					<li><a href="home.jsp">Home</a></li>
					<li><a href="blog.jsp">blog</a></li>
					<li><a href="research.jsp">research</a></li>
					<li class="active"><a href="profile.jsp">Schedules</a></li>
					<li><a href="welcome">Logout</a></li>
				</ul>
			</div>
			<div class="footer-right">
				<p>Medicare</p>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!--end-wrap-->
</body>
</html>

