package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcdemo 
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	public jdbcdemo() 
	{
		try 
		{
			// find the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Found!!");
			// initialize the connection object	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b8342","root","1234");
			System.out.println("Connection Established!!");
			
		} catch (SQLException | ClassNotFoundException e) {
				
			System.out.println("Error : "+e);
		}
	}
	
	public void getRecords()
	{
		String query = "select * from employee";
		try
		{
			// setup the statement for database
			st = con.createStatement();
			// execute the query and get the results
			rs = st.executeQuery(query);
//			get records one by one
			
//			next(): to check if we have more records or not -> rs.next()
			while(rs.next())
			{
				// get records
				System.out.println("------------------------------------------");
				System.out.println("Emp id : "+rs.getString("empid"));
				System.out.println("Name : "+rs.getString("empname"));
				System.out.println("Age : "+rs.getInt("age"));
				System.out.println("Phone : "+rs.getLong("phone"));
				System.out.println("City : "+rs.getString("city"));
				System.out.println("Salary : "+rs.getFloat("salary"));
				System.out.println("------------------------------------------");
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) 
		{
			System.out.println("Error : "+e);
		}
	}
	
	
	
	public static void main(String[] args) 
	{
		
		jdbcdemo jd=new jdbcdemo();
				
		jd.getRecords();
	}

}
