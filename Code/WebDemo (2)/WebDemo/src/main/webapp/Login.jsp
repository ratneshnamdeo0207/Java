<%@page import="com.files.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: lightblue;color : gray; text-align: center; font-size: 25px;">

	<%
		String uid = request.getParameter("loginid");
		String pass= request.getParameter("pass");
		//out.print("user id : "+uid);
		//out.print("password : "+pass);
		
		EmployeeDao edao=new EmployeeDao();
		boolean status = edao.checkLogin(uid, pass);
		if(status)
		{
	%>
			<h2>Login Successful!!!</h2>
		<%
		}
		else
		{
			out.print("<h2>Either Id or Password is Incorrect!!</h2>");
		}
		%>
	
	<h2> User id : <%=uid %></h2>
	<h2> Password : <%=pass %></h2>
</body>
</html>