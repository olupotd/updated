<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>medicare Website Template | contact :: W3layouts</title>
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
				<a href="index.html"><img src="images/logo.png" title="logo" /></a>
			</div>
			<!--end-logo-->
			<!--start-top-nav-->
			<div class="top-nav">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About</a></li>
					<li><a href="services.jsp">services</a></li>
					<li class="active"><a href="contact.jsp">contact</a></li>
				</ul>
			</div>
			<div class="clear"></div>
			<!--end-top-nav-->
		</div>
		<!--end-header-->
	</div>
	<div class="clear"></div>
	<div class="wrap">
		<div class="contact">
			<div class="section group">
				<div class="col span_1_of_3">
					<div class="contact_info">
						<h2>Find Us Here</h2>
						<br />
						<div class="map">
							<iframe width="100%" height="175" frameborder="0" scrolling="no"
								marginheight="0" marginwidth="0"
								src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe>
							<br> <small><a
								href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265"
								style="color: #666; text-align: left; font-size: 12px">View
									Larger Map</a></small>
						</div>
					</div>
					<div class="company_address">
						<h2>Company Information :</h2>
						<p>Medicare Hospital,</p>
						<p>7061, Medicare, Kampala</p>
						<p>UGANDA</p>
						<p>Phone:(256) 774 335 214</p>
						<p>Fax: (256) 000 00 00 0</p>
						<p>
							Email: <span>info@medicare.com</span>
						</p>
						<p>
							Follow on: <span>Facebook</span>, <span>Twitter</span>
						</p>
					</div>
				</div>
				<div class="col span_2_of_3">
					<div class="contact-form">
						<h2>Contact Us</h2>
						<h5>${status}</h5>
						<form action="readMessage" method="post">
							<div>
								<span><label>NAME</label></span> <span><input type="text"
									name="name"></span>
							</div>
							<div>
								<span><label>E-MAIL</label></span> <span><input
									type="text" name="email"></span>
							</div>
							<div>
								<span><label>MOBILE.NO</label></span> <span><input
									type="text" name="phone"></span>
							</div>
							<div>
								<span><label>SUBJECT</label></span> <span><textarea
										name="subject"> </textarea></span>
							</div>
							<div>
								<span><input type="submit" value="Submit"></span>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="footer">
		<div class="wrap">
			<div class="footer-left">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About</a></li>
					<li><a href="services.jsp">services</a></li>
					<li class="active"><a href="contact.jsp">contact</a></li>
				</ul>
			</div>
			<div class="footer-right">
				<p>
					Medicare | Design By <a href="http://owland.com/">Owland Inc</a>
				</p>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!--end-wrap-->
</body>
</html>

