<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"
	import="java.util.Date, java.util.List"%>
<%
	if (session.getAttribute("type").toString()
	.equalsIgnoreCase("admin")
	|| session.getAttribute("type").toString()
	.equalsIgnoreCase(null)) {
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Control |${fullnames}</title>
<link rel="stylesheet" type="text/css" href="css/960.css" />
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<link rel="stylesheet" type="text/css" href="css/text.css" />
<link rel="stylesheet" type="text/css" href="css/blue.css" />
<link type="text/css" href="css/smoothness/ui.css" rel="stylesheet" />

</head>
<body>
	<!-- WRAPPER START -->
	<div class="container_16" id="wrapper">
		<!-- HIDDEN COLOR CHANGER -->
		<div style="position: relative;"></div>
		<!--LOGO-->
		<div class="grid_8" id="logo">Welcome ${fullnames}</div>

		<div class="grid_8">
			<!-- USER TOOLS START -->
			<div id="user_tools">
				<span> Welcome <a href="#"> ${fullnames}</a> | <a
					href="authentication">Logout</a></span>
			</div>
		</div>
		<!-- USER TOOLS END -->
		<div class="grid_16" id="header" style="align: center">
			<!-- MENU START -->
			<div id="menu">
				<ul class="group" id="menu_group_main">
					<li class="item first" id="one"><a
						href="/e-analysis/admin.jsp"><span class="outer"><span
								class="inner dashboard">Control Panel</span></span></a></li>
					<li class="item middle" id="two"><a href="?id=edit_content"
						class="main"><span class="outer"><span
								class="inner user">Add User</span></span></a></li>
					<li class="item middle" id="five"><a href="?id=question"
						class="main"><span class="outer"><span
								class="inner content">Add Question</span></span></a></li>

					<li class="item middle" id="three"><a href="?id=reports"><span
							class="outer"><span class="inner reports png">Reports</span></span></a></li>
					<li class="item middle" id="five"><a href="?id=media"
						class="main"><span class="outer"><span
								class="inner media_library">Media Library</span></span></a></li>
					<li class="item middle" id="five"><a href="?id=contact"
						class="main"><span class="outer"><span
								class="inner media_library">Contact</span></span></a></li>

				</ul>
			</div>
			<!-- MENU END -->
		</div>


		<!-- HIDDEN SUBMENU END -->

		<!-- CONTENT START -->
		<div class="grid_16" id="content">
			<!--  TITLE START  -->
			<div class="grid_9">
				<h1 class="dashboard">Control Terminal</h1>

				<h3><%=session.getAttribute("status")%></h3>
			</div>
			<!--RIGHT TEXT/CALENDAR-->

			<!--RIGHT TEXT/CALENDAR END-->
			<div class="clear"></div>
			<!--  TITLE END  -->
			<!-- #PORTLETS START -->

			<%
				String id = request.getParameter("id");

														if (id != null) {
															if (id.equalsIgnoreCase("users")) {
			%>
			<div id="portlets">
				<!-- FIRST SORTABLE COLUMN START -->
				<div class="column" id="left">Users existing</div>
			</div>
			<%
				}
															if (id.equalsIgnoreCase("media")) {
			%>
			<div id="portlets">
				<!-- FIRST SORTABLE COLUMN START -->
				<div class="column" id="left">Pictures of lecturers</div>
			</div>
			<%
				}
															if (id.equalsIgnoreCase("edit_content")) {
			%>
			<div id="portlets">
				<!-- FIRST SORTABLE COLUMN START -->
				<div>
					<div class="portlet">
						<div class="portlet-content">
							<form method="post" action="adduser">
								<table width="100%" cellpadding="0" cellspacing="0"
									id="box-table-a" summary="Add new User">
									<thead>

										<tr>
											<td width="34" scope="col" colspan=2 align="center">Add
												a new user</td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan=2 align="center"><input type="text"
												name="username" id="textfield" class="largeInput"
												placeHolder="Username" /></td>
										</tr>
										<tr>
											<td colspan=2 align="center"><input type="password"
												name="password" id="textfield2" class="largeInput"
												placeHolder="Password" /></td>
										</tr>
										<tr>
											<td colspan=2 align="center"><input type="text"
												name="fullnames" id="textfield" class="largeInput"
												placeHolder="Full Names" /></td>
										</tr>
										<tr>
											<td colspan=2 align="center"><input type="text"
												name="email" id="textfield2" class="largeInput"
												placeHolder="Email" /></td>
										</tr>
										<tr>
											<td colspan=2 align="center"><input type="text"
												name="dept" id="textfield2" class="largeInput"
												placeHolder="Department" /></td>
										</tr>
										<tr>
											<td colspan=2 align="center"><input type="text"
												name="loct" id="textfield2" class="largeInput"
												placeHolder="Location" /></td>
										</tr>
										<tr>
											<td colspan=2 align="center"><input type="text"
												name="phone" id="textfield2" class="largeInput"
												placeHolder="Phone Number" /></td>
										</tr>
										<tr>
											<td align="right">Student <input type="checkbox"
												name="value" value="S" id="value" /></td>
											<td align="left">Lecturer <input type="checkbox"
												name="value" value="L" id="value" /></td>
										</tr>

										<tr>
											<td align="center"><input type="submit" value="Cancel" /></td>
											<td align="center"><input type="submit" value="Register" /></td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
					</div>

				</div>
				<%
					}
																									if (id.equalsIgnoreCase("reports")) {
				%>
				<div id="portlets">
					<!-- FIRST SORTABLE COLUMN START -->
					<div class="column" id="left">Reports and Charts go here
					
					
					</div>
				</div>
				<%
					}

																									if (id.equalsIgnoreCase("question")) {
				%>
				<div id="portlets">
					<!-- FIRST SORTABLE COLUMN START -->
					<div>
						<div class="portlet">
							<div class="portlet-content">
								<form method="post" action="addquestion">
									<table width="100%" cellpadding="0" cellspacing="0"
										id="box-table-a" summary="Add new Question">
										<thead>

											<tr>
												<td width="34" scope="col" colspan=2 align="center">Add
													a new Question</td>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td colspan=2 align="center"><textarea cols="50"
														rows="5" name="question"
														placeHolder="Question Description"> </textarea></td>
											</tr>
											<tr>
												<td colspan=2 align="center"><textarea cols="50"
														rows="5" name="question"
														placeHolder="Question Description"> </textarea></td>
											</tr>
											<tr>
												<td colspan=2 align="center"><textarea cols="50"
														rows="5" name="question"
														placeHolder="Question Description"> </textarea></td>
											</tr>
											<tr>
												<td colspan=2 align="center"><textarea cols="50"
														rows="5" name="question"
														placeHolder="Question Description"> </textarea></td>
											</tr>


											<tr>
												<td align="center" colspan=2><input type="submit"
													value="Add" /></td>
											</tr>
										</tbody>
									</table>
								</form>
							</div>
						</div>

					</div>
					<%
						}
																																			if (id.equalsIgnoreCase("contact")) {
					%>
					<div id="portlets">
						<!-- FIRST SORTABLE COLUMN START -->
						<div>
							<div class="portlet">
								<div class="portlet-content">
									<form method="post" action="">
										<table width="100%" cellpadding="0" cellspacing="0"
											id="box-table-a" summary="Send user a message" border="0">
											<thead>

												<tr>
													<td width="34" scope="col" colspan=2 align="center">Send
														a user a message</td>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td colspan=2 align="center"><input type="text"
														name="username" id="textfield" class="largeInput"
														placeHolder="to-email" /></td>
												</tr>

												<tr>
													<td colspan=2 align="center"><input type="text"
														name="fullnames" id="textfield" class="largeInput"
														placeHolder="Title" /></td>
												</tr>
												<tr>
													<td colspan=2 align="center"><textarea cols="50"
															rows="5" placeHolder="Message here" name="message"></textarea>
													</td>
												</tr>
												<tr>
													<td align="center"><input type="submit" value="Cancel" /></td>
													<td align="center"><input type="submit" value="Send" /></td>
												</tr>
											</tbody>
										</table>
									</form>
								</div>
							</div>

						</div>
						<%
							}
																																												} else {
																																													
																																													List<String> lecturers = (List<String>) session
																																															.getAttribute("lecturers");
						%>
						<div id="portlets">

							<div class="clear"></div>
							<!--THIS IS A WIDE PORTLET-->
							<div class="portlet">
								<div class="portlet-header fixed">
									<img src="images/icons/user.gif" width="16" height="16"
										alt="Latest Registered Users" /> Registered Lecturers
								</div>

								<div class="portlet-content nopadding">
									<form action="" method="post">
										<table width="100%" cellpadding="0" cellspacing="0"
											id="box-table-a" summary="Employee Pay Sheet">
											<thead>
												<tr>
													<th width="34" scope="col"><input type="checkbox"
														name="allbox" id="allbox" onclick="checkAll()" /></th>
													<th width="136" scope="col">Name</th>
													<th width="102" scope="col">Username</th>
													<th width="109" scope="col">Department</th>
													<th width="129" scope="col">Location</th>
													<th width="171" scope="col">E-mail</th>
													<th width="123" scope="col">Phone</th>
													<th width="90" scope="col">Actions</th>
												</tr>
											</thead>
											<%
												for(String lect: lecturers){
																																																	String[] details = lect.split(";");
											%>
											<tbody>
												<tr>
													<td width="34"><label> <input type="checkbox"
															name="checkbox" id="checkbox"
															value="<%out.print(details[0]);%>" />
													</label></td>
													<td>
														<%
															out.println(details[3]);
														%>
													</td>
													<td>
														<%
															out.println(details[1]);
														%>
													</td>
													<td>
														<%
															out.println(details[7]);
														%>
													</td>
													<td>
														<%
															out.println(details[6]);
														%>
													</td>
													<td>
														<%
															out.println(details[4]);
														%>
													</td>
													<td>
														<%
															out.println(details[5]);
														%>
													</td>
													<td width="90"></a> <a
														href="fixer?id=<%out.print(details[0]);%>"
														class="delete_icon" title="Delete"></a></td>
												</tr>

											</tbody>
											<%
												}
											%>
										</table>
									</form>
								</div>
							</div>
						</div>
						<!--  END #PORTLETS -->
						<%
							}
						%>
					</div>
				</div>
			</div>
			<div class="clear"></div>

			<!-- This contains the hidden content for modal box calls -->
			<div class='hidden'>
				<div id="inline_example1" title="This is a modal box"
					style='padding: 10px; background: #fff;'>
					<p>
						<strong>This content comes from a hidden element on this
							page.</strong>
					</p>

					<p>
						<strong>Try testing yourself!</strong>
					</p>
					<p>You can call as many dialogs you want with jQuery UI.</p>
				</div>
			</div>
		</div>
		<!-- WRAPPER END -->
		<!-- FOOTER START -->
		<div class="container_16" id="footer">
			Website Administration by <a href="">Owland Inc</a>
		</div>
	</div>
	<script type="text/javascript"
		src="../../ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/blend/jquery.blend.js"></script>
	<script type="text/javascript" src="js/ui.core.js"></script>
	<script type="text/javascript" src="js/ui.sortable.js"></script>
	<script type="text/javascript" src="js/ui.dialog.js"></script>
	<script type="text/javascript" src="js/ui.datepicker.js"></script>
	<script type="text/javascript" src="js/effects.js"></script>
	<script type="text/javascript" src="js/flot/j	query.flot.pack.js"></script>
	<script language="javascript" type="text/javascript" src="js/graphs.js"></script>


	<!-- FOOTER END -->
	<%
		} else {
	%>
	<script type="text/javascript" language="javascript">
		alert('You do not have permission to view this page');
		window.location = "http://localhost:8080/e-analysis/";
	</script>
	<%
		}
	%>
</body>
</html>




