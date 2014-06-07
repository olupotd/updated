<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"
	import="java.util.List, java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%
	if (session.getAttribute("logged_in").toString()
	.equalsIgnoreCase("true")
	&& session.getAttribute("type").toString()
	.equalsIgnoreCase("student")) {
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>e-evaluation</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="header">
		<div id="logo">
			<h1>
				<a href="#">E-Analysis</a>
			</h1>

		</div>
		<div id="menu">
			<ul>
				<li class="active"><a href="home.jsp" accesskey="1"
					title=" Blog page">Home</a></li>
				<li><a href="contact.jsp" accesskey="4" title="">Contact</a></li>
				<li><a href="authentication">Logout</a></li>
			</ul>
		</div>
	</div>
	<hr />
	<div id="page">
		<div id="bg">
			<div id="content">
				<div class="post" style="padding-top: 57px;">

					<h2 class="title">
						<b>Welcome ${fullnames} 
					</h2>
					</h3>
					<h3 class="date"><%=new SimpleDateFormat("HH:mm dd/MM/YYYY")
						.format(new Date())%></h3>
				</div>
				<%
					List<String> lecturers = (List<String>) request
												.getAttribute("lecturers");
				%>
				<div class="post">

					<%
						if (lecturers.isEmpty()) {
														out.println("<h2>Looks like your done evaluating.</h2>");
													} else {
														for (String lecturer : lecturers) {
															String[] details = lecturer.split(";");
					%>

					<div class="entry">
						<h3 class="title">
							<%
								out.print(details[1]);
							%>
						</h3>
						</h3>
						<h3 class="date">
							<a href="Parser?id=<%out.println(details[0]);%>">Evaluate</a>
						</h3>
						<p>
							Department:
							<%
							out.print(details[2]);
						%>
						</p>

					</div>


					<%
						}
													}
					%>
				</div>
			</div>

			<!-- end contentn -->
			<div id="sidebar">
				<div id="about-box">
					<h2>About this Site</h2>
					<p>
						Doctor's forum is an online platform that allows doctors and
						nurses to share and help others to during their work processes and
						Read more about this site from <a
							href="http://olupotdouglas.yolasite.com">here</a>
					</p>
				</div>
				<ul>
					<li>
						<h2>Links</h2>
						<ul>
							<li><a href="#">Github pages</a></li>
							<li><a href="#">Facebook page</a></li>
							<li><a href="#">Twitter page</a></li>
							<li><a href="#">Google plus page</a></li>
							<li><a href="#">Tumblr page</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- end sidebar -->
			<div style="clear: both;">&nbsp;</div>
		</div>
	</div>
	<!-- end page -->
	<hr />
	<div id="footer">
		<p>
			(c) 2007 owlandinc.com. All rights reserved. Design by <a
				href="http://olupotdouglas.yolasite.com/">Arol Inc</a>
		</p>
	</div>
	<%
		} else {
	%>
	<script type='text/javascript' language='javascript'>
		alert('You must be logged in to view this content');
		window.location = "http://localhost:8080/e-analysis/";
	</script>
	<%
		}
	%>
</body>
</html>











