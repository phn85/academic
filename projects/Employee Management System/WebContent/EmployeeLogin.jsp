<%@page import="edu.iit.entities.Employee"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Employee Management System</title>
<meta name="description" content="">
	<meta name="keywords" content="">
		<meta http-equiv="Content-Type"
			content="text/html; charset=iso-8859-1">
			<link href="style.css" rel="stylesheet" type="text/css">



				<link rel="stylesheet"
					href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
				<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
				<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
				<link rel="stylesheet" href="/resources/demos/style.css" />
				<script>
					$(function() {
						$("#accordion").accordion();
					});
				</script>
				<style>
div.header-bottom {
	font-style: oblique;
	color: #345899;
	font-family: sans-serif;
}
</style>
</head>
<body>
	<div class="page-out">
		<div class="page-in">
			<div class="page">
				<div class="main">
					<div class="header">
						<div class="header-top">
							<h1>IIT GRADS</h1>
						</div>
						<div class="header-bottom">


							<marquee font color="black" scrollamount="10" width="500">
							<h1>
								<br /> <br /> <br /> <br /> <b>&nbsp;&nbsp;&nbsp;EMPLOYEE
									MANAGEMENT SYSTEM 
							</h1>
							</marquee>
						</div>
						<div class="topmenu">
							<ul>
								<li
									style="background: transparent none repeat scroll 0% 50%; -moz-background-clip: initial; -moz-background-origin: initial; -moz-background-inline-policy: initial; padding-left: 0px;"><a
									href="EmployeeLogin.jsp"><span>Home</span></a></li>

								<li><a href="DisplayEmployeeOwnInfo.jsp"><span>View
											Information</span></a></li>

								<li><a href="FirstPage.html"><span>Logout </span></a></li>

							</ul>
						</div>
					</div>


					<div class="content">
						<div class="content-left">
							<div class="row1">
								<%
									Employee emp = (Employee) session.getAttribute("employee");
								%>
								<h1 class="title">
									Hello
									<%=emp.getFirstName()%>!
								</h1>



								<div id="accordion">
									<h3>WELCOME TO EMPLOYEE LOGIN PAGE</h3>
									<div>
										<h2>Here we provide you information based on which
											employee logs in to the application</h2>
										<br />
										<h2>You are provided with only display functionality for
											an employee type login.</h2>
									</div>

								</div>
							</div>
						</div>

						<div class="content-right">
							<div class="mainmenu">
								<h2 class="sidebar1">Entertainment</h2>
								<ul>
									<li><a href="https://www.youtube.com/">Video</a></li>
									<li><a href="https://www.vevo.com/">Music</a></li>
									<li><a href="https://www.amazon.com/">Shopping</a></li>
								</ul>
							</div>
							<br /> <br /> <br />

							<div class="contact">
								<h2 class="sidebar2">Contact</h2>
								<div class="contact-detail">
									<p class="green">
										<strong>IIT Grads</strong>
									</p>
									<p>
										<strong>Address :</strong> Illinois Institute of Technology <br>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3300
											S Federal St, Chicago, IL 60616 
									</p>
									<p>
										<strong>E-mail :</strong>
										&nbsp;&nbsp;&nbsp;jjagadeesh@hawk.iit.edu
									</p>
									<p>
										<strong>Phone :</strong> &nbsp;&nbsp;&nbsp;+1 312-731-9174<br>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;











										
									</p>
								</div>
							</div>
						</div>

					</div>


					<div class="footer">

						<a href="http://www.htmltemplates.net"> <img
							src="images/footer.gif" alt="html templates" border="0"
							height="1" width="1"></a>
						<p>
							&copy; Copyright 2016. Designed by <a target="_blank"
								href="http://www.htmltemplates.net">ITM Students</a><br>
						</p>
						<ul>
							<li><a href="DisplayAboutUs.html"><span>About&nbsp;us</span></a></li>
							<li><a href="DisplayServices.html"><span>Services</span></a></li>



						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
