<%@page import="java.util.Iterator"%>
<%@page import="com.files.entity.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.files.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int total = Integer.parseInt(request.getParameter("totalrecords"));
		int sindex= Integer.parseInt(request.getParameter("sindex"));
		
		EmpDao ob=new EmpDao();
		
		ArrayList<Employee> emplist = ob.viewRecords(sindex, total);
		
		Iterator itr=emplist.iterator();
	%>
	<table>
	<tr border="1">
		<th>Employee Id</th>
		<th>Employee Name</th>
		<th>Age</th>
		<th>Phone</th>
		<th>City</th>
		<th>Salary</th>
	</tr>
	<%	
		while(itr.hasNext())
		{
			Employee e=(Employee)itr.next();
	%>
			<tr>
				<td><%=e.getEmpid() %></td>
				<td><%=e.getEmpname()%></td>
				<td><%=e.getAge()%></td>
				<td><%=e.getPhone() %></td>
				<td><%=e.getCity() %></td>
				<td><%=e.getSalary() %></td>
			</tr>
	<%		
		}
	%>
	</table>
</body>
</html>