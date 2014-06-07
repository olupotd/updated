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
				<a href="home.jsp"><img src="images/logo.png" title="logo" /></a>
			</div>
			<!--end-logo-->
			<!--start-top-nav-->
			<div class="top-nav">
				<ul>
					<li><a href="home.jsp">Home</a></li>
					<li><a href="blog.jsp">blog</a></li>
					<li><a href="research.jsp">research</a></li>
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
		<div class="blog">
			<%
				List<String> posts = (List<String>) request
							.getAttribute("single_post");
					if (posts.isEmpty()) {
			%>
			<div class="blog-grid">
				<div class="blog-grid-header"></div>
				<div class="image group">
					<div class="grid images_3_of_1"></div>
					<div class="grid span_2_of_3">
						<h3>No one has posted anything yet. you could be the first to
							do so</h3>
					</div>
				</div>
			</div>
		</div>
		<div class="blog">
			<%
				} else {
						for (String post : posts) {
							String[] values = post.split(";");
			%>
			<div class="blog-grid">
				<div class="blog-grid-header">
					<h3>
						<%
							out.println(values[1]);
						%>
					</h3>
					<ul>
						<li><img src="images/cal.png" alt=""> <%
 	out.println(values[4]);
 %></li>
						<li><img src="images/admin.png" alt="">${fullnames}</li>
						<li><img src="images/post-in.png" alt=""><a href="#">10</a></li>
					</ul>
				</div>
				<div class="image group">
					<div class="grid images_3_of_1">
						<img src="<%out.println(values[5]);%>">
					</div>
					<div class="grid span_2_of_3">
						<p>
							<%
								out.println(values[2]);
							%>
						</p>
					</div>
				</div>
			</div>
			<div class="col span_1_of_3">
				<div class="contact-form">
					<%
						List<String> comments = (List<String>) request
											.getAttribute("comments");
									if (!comments.isEmpty()) {
										for (String comment : comments) {
											String[] det = comment.split(";");
					%>
					<div class="blog-grid">
						<div class="blog-grid-header"></div>
						<div class="image group">
							<div>
								<h4>
									<%
										out.println(det[3]);
									%>
								</h4>
							</div>

							<div>
								<%
									out.println(det[0]);
								%>
							</div>
						</div>
					</div>

					<%
						}
									} else {
										out.println("<div>No comments made so far</div>");
									}
					%>
					<form action="addcomment" method="post">
						<div>
							<textarea name="comment" placeHolder="Make a suggestion"></textarea>
						</div>
						<div>
							<input type="submit" value="Comment">
						</div>
					</form>

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
			<div class="pagnation">
				<ul>
					<li><a href="#">Next</a></li>
				</ul>
			</div>
			<%
				}
			%>
		</div>
	</div>
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
					<li><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About</a></li>
					<li><a href="services.jsp">services</a></li>
					<li class="active"><a href="blog.jsp">blog</a></li>
					<li><a href="contact.jsp">contact</a></li>
					<li><a href="research.jsp">research</a></li>
				</ul>
			</div>
			<div class="footer-right">
				<p>Doctors Focrum | Blog</p>
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

