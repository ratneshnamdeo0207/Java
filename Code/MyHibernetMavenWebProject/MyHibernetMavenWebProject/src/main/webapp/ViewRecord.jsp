<%@page import="com.file.Entity.Employee"%>
<%@page import="com.file.App1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Record By Id</title>
</head>
<body style="background-color: lightgray; color:blue; text-align: center;font-size: 25px;">
<h1>View Record By Id</h1>

<%
	String eid = request.getParameter("eid");
	App1 ob=new App1();
	
	Employee e=ob.getEmployee(eid);
	
	if(e!=null)
	{
%>
		<h2>Employee Id   : <%=e.getEmpid() %></h2>
		<h2>Employee Name : <%=e.getEmpname() %></h2>
		<h2>Age           : <%=e.getAge() %></h2>
		<h2>Phone No.     : <%=e.getPhone() %></h2>
		<h2>City          : <%=e.getCity() %></h2>
		<h2>Salary        : <%=e.getSalary() %></h2>

  <%}
	else
	{
	%>
  	<h2>Employee id Does not Exists!!!</h2>
  	<%
	}
  	%>
</body>
</html>