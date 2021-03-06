<%@ page language="java" errorPage="error.jsp"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="true" import="java.util.List"%>
<!DOCTYPE HTML>
<html>
<head>
<title>medicare | blog</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Ropa+Sans'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<!--start-wrap-->
	<%
		if (session.getAttribute("state").toString().equalsIgnoreCase(null)) {
	%>
	<script type="text/javascript">
		alert('Invalid address. please login to continue');
		window.location = "welcome";
	</script>
	<%
		} else {
	%>

	<!--start-header-->
	<div class="header">
		<div class="wrap">
			<!--start-logo-->
			<div class="logo">
				<a href="index.html"><img src="images/logo.png" title="logo" /></a>
			</div>
			<!--end-logo-->
			<!--start-top-nav-->
			<div class="top-nav">
				<ul>
					<li><a href="home.jsp">Home</a></li>
					<li class="active"><a href="blog.jsp">blog</a></li>
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
	<div class="wrap">
		<div>
			<br />
			<div class="col span_1_of_3">
				<div class="contact-form">
					<form action="addpost" method="post" enctype="multipart/form-data">
						<div>
							<input type="text" name="headline" placeHolder="Tag for the post"><br />
						</div>
						<div>
							<textarea name="posting" placeHolder="What's Bothering you today"></textarea>
						</div>
						<div>
							<input type="file" name="file" />
						</div>
						<div>
							<input type="submit" value="Post">
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<br />
		<div class="blog">
			<div class="col span_2_of_3">
				<h2>Recent Posts</h2>
				<%
					List<String> posts = (List<String>) session
								.getAttribute("posts");
						if (posts.isEmpty()) {
				%>
				<div class="blog-grid">
					<div class="blog-grid-header"></div>
					<div class="image group">
						<div class="grid images_3_of_1"></div>
						<div class="grid span_2_of_3">
							<h3>No one has posted anything yet. you could be the first
								to do so</h3>
						</div>
					</div>
				</div>
				<%
					} else {
							for (String post : posts) {
								String[] values = post.split("@");
				%>
				<div class="blog-grid">
					<div class="blog-grid-header">
						<h5>
							<%
								out.println(values[1]);
							%>
						</h5>
						<ul>
							<li><img src="images/cal.png" alt=""> <%
 	out.println(values[3]);
 %></li>
							<li><img src="images/admin.png" alt=""> <%
 	out.println(values[5]);
 %><a href="#"></a></li>
						</ul>
					</div>
					<div class="image group">
						<%
							if (!values[4].equals(null)) {
						%>
						<div class="grid images_3_of_1">
							<img src="<%out.println(values[4]);%>" alt="">
						</div>
						<%
							}
						%>
						<div class="grid span_2_of_3">
							<p>
								<%
									out.println(values[2]);
								%>
							</p>
							<div class="button">
								<span><a href="parser?id=<%out.println(values[0]);%>">Read
										More</a></span>
							</div>
						</div>
					</div>
				</div>
				<%
					}
						}
				%>
				<br />
				<%
					if (!posts.isEmpty() && posts.size() > 5) {
				%>
				<div class="clear"></div>

				<%
					}
				%>
			</div>
		</div>
	</div>
	<div class="col span_3_of_3"></div>
	<div class="clear"></div>
	<br />
	<br />
	<%
		if (!posts.isEmpty()) {
	%>
	<div class="footer">
		<div class="wrap">
			<div class="footer-left">
				<ul>
					<li><a href="home.jsp">Home</a></li>
					<li class="active"><a href="blog.jsp">blog</a></li>
					<li><a href="research.jsp">research</a></li>
					<li><a href="profile.jsp">Schedules</a></li>
					<li><a href="welcome">Logout</a></li>
				</ul>
			</div>
			<div class="footer-right">
				<p>
					Medicare | Design By <a href="http://w3layouts.com/">W3Layouts</a>
				</p>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<%
		}
		}
	%>
	<!--end-wrap-->
</body>
</html>

