<html>
<body>
<h1 style="background-color: gray; color: blue;">First web project</h1>
<h2>
<%= 
	"Hello World! java part" 
%>

<%
	out.print("kdkdk");
	for(int i=1;i<=10;i++)
	{
		out.print(i);
%>
	<br/>
<%
	}
%>
<!-- to add java code in between, you need to add scriptlets -->

<h2>Click here to <a href="Login.html">Login</a> </h2>
<h2>Click here to <a href="ViewRecords.html">View Records</a> </h2>
<h2>Click here to <a href="RecordDetaila.jsp">Record Details by Salary</a> </h2>
<h2>Click here to <a href="EmployeeRecord.jsp">View Record</a> </h2>

</h2>
</body>
</html>
