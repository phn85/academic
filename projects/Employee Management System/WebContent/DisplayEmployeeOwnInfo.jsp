<%@page import="edu.iit.entities.Employee"%>
<%@page import="edu.iit.entities.Department"%>
<%@page import="java.sql.*"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Employee Management System</title>
<meta name="description" content="">
	<meta name="keywords" content="">
		<meta http-equiv="Content-Type"
			content="text/html; charset=iso-8859-1">
			<link href="style.css" rel="stylesheet" type="text/css">
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
								<li><a href="FirstPage.html"><span>Logout</span></a></li>

							</ul>
						</div>
					</div>

					<div class="content">
						<div class="content-left">
							<h1 class="title">WELCOME TO EMPLOYEE DISPLAYING FORM</h1>
							<table border="1" width="100%" height="30%">
								<tr>
									<th><font color='Red'>EMPLOYEE ID</font></th>
									<th><font color='Red'>FIRST NAME</font></th>
									<th><font color='Red'>LAST NAME</font></th>

									<th><font color='Red'> DOJ </font></th>
									<th><font color='Red'>SALARY</font></th>
									<th><font color='Red'>MANAGER ID</font></th>
									<th><font color='Red'>GRADE</font></th>
									<th><font color='Red'>DEPARTMENT ID</font></th>
								</tr>
								<%
									Employee emp = (Employee) session.getAttribute("employee");
								%>
								<tr>
									<td><%=emp.getEmpId()%></td>
									<td><%=emp.getFirstName()%></td>
									<td><%=emp.getLastName()%></td>
									<td><%=emp.getJoinDate()%></td>
									<td><%=emp.getSalary()%></td>
									<td><%=emp.getMgrID()%></td>
									<td><%=emp.getEmpGrade()%></td>
									<td><%=emp.getDeptId()%></td>
								</tr>
							</table>
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