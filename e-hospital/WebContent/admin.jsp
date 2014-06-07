<%@page import="com.sun.xml.internal.ws.client.sei.ValueSetter"%>
<%@ page language="java" errorPage="error.jsp"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="true" import="java.util.Date, java.util.List"%>
<%
	if (session.getAttribute("state").toString()
	.equalsIgnoreCase("LoggedIn")) {
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
				<span> Admin interface | <a href="welcome">Logout</a></span>
			</div>
		</div>
		<!-- USER TOOLS END -->
		<div class="grid_16" id="header" style="align: center">
			<!-- MENU START -->
			<div id="menu">
				<ul class="group" id="menu_group_main">
					<li class="item first" id="one"><a
						href="/e-hospital/admin.jsp"><span class="outer"><span
								class="inner dashboard">Control Panel</span></span></a></li>
					<li class="item middle" id="two"><a href="?id=edit_content"
						class="main"><span class="outer"><span
								class="inner user">Add User</span></span></a></li>
					<li class="item middle" id="five"><a href="?id=question"
						class="main"><span class="outer"><span
								class="inner content">Add Schedule</span></span></a></li>
					<li class="item middle" id="five"><a href="?id=media"
						class="main"><span class="outer"><span
								class="inner media_library">Research</span></span></a></li>
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
			<div class="grid_9">
				<!--  TITLE START  -->
				<h1 class="dashboard">Control Terminal</h1>
				<h4>${status}</h4>
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
				<div class="portlet-content nopadding">
					<form action="" method="post">
						<table width="100%" cellpadding="0" cellspacing="0"
							id="box-table-a" summary="Employee Pay Sheet">
							<thead>
								<tr>
									<th width="34" scope="col"><input type="checkbox"
										name="allbox" id="allbox" onclick="checkAll()" /></th>
									<th width="136" scope="col">Tag</th>
									<th width="109" scope="col">Description</th>
									<th width="129" scope="col">Date created</th>
									<th width="171" scope="col">Date Scheduled</th>
								</tr>
							</thead>
							<%
								for(String x: (List<String>) session.getAttribute("schedules")){
																																							String xml[] = x.split(";");
							%>
							<tbody>
								<tr>
									<td width="34"><label> <input type="checkbox"
											name="checkbox" id="checkbox" value="" />
									</label></td>
									<td>
										<%
											out.println(xml[1]);
										%>
									</td>
									<td>
										<%
											out.println(xml[2]);
										%>
									</td>
									<td>
										<%
											out.println(xml[3]);
										%>
									</td>

								</tr>
							</tbody>
							<%
								}
							%>
						</table>
					</form>
				</div>
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
											<td align="right">Doctor <input type="radio"
												name="value" class="radio" value="D" /></td>
											<td align="left">Admin <input type="radio" name="value"
												class="radio" value="A" /></td>
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
					<div class="column" id="left">Reports and Charts go here</div>
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
								<table width="100%" cellpadding="0" cellspacing="0"
									id="box-table-a" summary="Add new Schedule">
									<thead>

										<tr>
											<td width="34" scope="col" colspan=2 align="center">Add
												a new Schedule</td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan=2 align="center"><input type="text"
												name="tag" placeHolder="Schedule tag"></td>
										</tr>
										<tr>
											<td colspan=2 align="center"><input type="text"
												name="date" placeHolder="Days from now (dd/mm/yyyy) "></td>
										</tr>
										<tr>
											<td colspan=2 align="center"><textarea cols="50"
													rows="5" name="schedule" placeHolder="Question Description"> </textarea></td>
										</tr>
										<tr>
											<td colspan=2 align="center"><select name="usr">
													<option value="">Please select a doctor to assign</option>
													<%
														for(String user: (List<String>)session.getAttribute("users")){
																																																																																																																																																																																																																																																																																																																																																																																																															String val[] = user.split(";");
													%>
													<option value="<%out.println(val[0]);%>">
														<%
															out.println(val[1]);
														%>
													</option>
													<%
														}
													%>
											</select></td>
										</tr>
										<tr>
											<td align="center" colspan=2><input type="submit"
												value="Assign" /></td>
										</tr>
									</tbody>
								</table>
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
																																																																																																																																																																																																																																																																																																																	
																																																																																																																																																																																																																																																																																																																	List<String> users = (List<String>) session
																																																																																																																																																																																																																																																																																																																			.getAttribute("users");
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
													<th width="136" scope="col">Full Names</th>
													<th width="102" scope="col">Username</th>
													<th width="109" scope="col">Department</th>
													<th width="129" scope="col">Location</th>
													<th width="171" scope="col">E-mail</th>
													<th width="123" scope="col">Is Admin</th>
													<th width="90" scope="col">Actions</th>
												</tr>
											</thead>
											<%
												for(String user: users ){
																																																																																																																																																																																																																																																																																																																																																																																																																																																																															String val [] = user.split(";");
											%>
											<tbody>
												<tr>
													<td width="34"><label> <input type="checkbox"
															name="checkbox" id="checkbox"
															value="<%out.println(val[0]);%>" />
													</label></td>
													<td>
														<%
															out.println(val[3]);
														%>
													</td>
													<td>
														<%
															out.println(val[1]);
														%>
													</td>
													<td>
														<%
															out.println(val[7]);
														%>
													</td>
													<td>
														<%
															out.println(val[5]);
														%>
													</td>
													<td>
														<%
															out.println(val[4]);
														%>
													</td>
													<td>
														<%
															out.println(val[8]);
														%>
													</td>
													<td width="90"></a> <a
														href="idler?id=<%out.println(val[0]);%>"
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
		</div>
		<!-- WRAPPER END -->
		<!-- FOOTER START -->
		<div class="container_16" id="footer">Doctors Forum</div>
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
	<script type="text/javascript">
		alert('You must login to get exclusive rights to view this page');
		window.location = "http://localhost:8080/e-hospital/login.jsp";
	</script>
	<%
		}
	%>
</body>
</html>



