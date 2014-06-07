<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"
	import="java.util.List, java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>SCIT Evaluation</title>
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
					<h3 class="title">
						<%
							String details[] = request.getAttribute("lecturer").toString()
									.split(":");
							out.println("Your evaluating:<b>" + details[1] + " </b>");
							session.setAttribute("lecturer_id", details[0]);
						%>

					</h3>
					<h3 class="date"><%=new SimpleDateFormat("HH:mm dd/MM/YYYY")
					.format(new Date())%></h3>
				</div>
				<form action="Evaluation" method="POST">

					<%
						List<String> question = (List<String>) request
								.getAttribute("questions");
						if (!question.isEmpty()) {
							for (String quest : question) {
					%>


					<div class="post">
						<h3 class="title">
							<%
								String[] ids = quest.split(" ");
										out.println("<b>" + quest + "</b>");
										String id[] = quest.split(" ");
							%>
						</h3>
						<div class="entry">
							<p>
								Effective--><input type="checkbox" name="<%out.println(id[0]);%>"
									value="5"> Highly Effective--><input type="checkbox"
									name="<%out.println(id[0]);%>" value="4"> Some How--><input
									type="checkbox" name="<%out.println(id[0]);%>" value="Some how">
								Exemplary--><input type="checkbox" name="<%out.println(id[0]);%>"
									value="3"> <br>

							</p>
						</div>
					</div>

					<%
						}
					%>
					<div>
						<p>
							<input type="submit" value="evaluate" align="right">
						</p>
					</div>
				</form>
				<%
					} else {
						out.println("No Questions posted so far.");
					}
				%>

			</div>
		</div>
		<!-- end content -->
		<div id="sidebar">
			<div id="about-box">
				<h2>About this Site</h2>
				<p>
					Doctor's forum is an online platform that allows doctors and nurses
					to share and help others to during their work processes and Read
					more about this site from <a
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

	<!-- end page -->
	<hr />
	<div id="footer">
		<p>
			(c) 2007 owlandinc.com. All rights reserved. Design by <a
				href="http://olupotdouglas.yolasite.com/">Arol Inc</a>
		</p>
	</div>
</body>
</html>