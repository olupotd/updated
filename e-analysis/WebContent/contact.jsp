<%@page session="true" language="java" autoFlush="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>e-analysis</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="header">
		<div id="logo">
			<h1>
				<a href="#">e-analysis</a>
			</h1>

		</div>
		<div id="menu">
			<ul>
				<li><a href="home.jsp" accesskey="1" title="">Home</a></li>
				<li><a href="archive.jsp" accesskey="2" title="">Archives</a></li>
				<li><a href="about.jsp" accesskey="3" title="">About</a></li>
				<li class="active"><a href="contact.jsp" accesskey="4" title="">Contact</a></li>
			</ul>
		</div>
	</div>
	<hr />
	<div id="page">
		<div id="bg">
			<div id="content">
				<div class="post" style="padding-top: 57px;">
					<h2 class="title">Welcome ${fullnames}</h2>
					<h3 class="date">Friday, July 6, 2007</h3>
					<div class="entry">
						<p>Please leave us a message and we'll get back to you as soon
							as possible.</p>

						<form action="" method="">
							<p>
								<input type="text" name="email" placeHolder="email">
							</p>
							<p>
								<input type="text" name="email" placeHolder="full names.">
							</p>
							<p>
								<input type="text" name="email" placeHolder="subject">
							</p>
							<p>
								<textarea cols="70" rows="8" placeHolder="Message Body here."></textarea>
							</p>
							<p style="position: right">
								<input type="file" value="Add file">
								&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Send">
							</p>
						</form>
						</p>
					</div>

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
						<h2>Categories</h2>
						<ul>
							<li class="first"><a href="#">Research</a></li>
							<li><a href="#">Surgery</a></li>
							<li><a href="#">Paedritician</a></li>
							<li><a href="#">Hemorology</a></li>
							<li><a href="#">Psychology</a></li>
						</ul>
					</li>
					<li>
						<h2>Links</h2>
						<ul>
							<li class="first"><a href="#">Designer website</a></li>
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
			(c) 2007 arol.com. All rights reserved. Design by <a
				href="http://olupotdouglas.yolasite.com/">Arol Inc</a>
		</p>
	</div>
</body>
</html>