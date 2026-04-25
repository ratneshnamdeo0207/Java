package com.files.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.files.entity.Employee;

public class EmpDao 
{
	Connection con;
	CallableStatement ps;
	ResultSet rs;
	
	public EmpDao() 
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
	
	public ArrayList<Employee> viewRecords(int sindex, int total)
	{
		String query = "call emplist(?,?)";
		
		ArrayList<Employee> emplist =new ArrayList<Employee>();
		
		try 
		{
			ps =con.prepareCall(query);
			ps.setInt(1, total);
			ps.setInt(2, sindex);
	
			rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Employee e=new Employee();
				e.setEmpid(rs.getString("empid"));
				e.setEmpname(rs.getString("empname"));
				e.setAge(rs.getInt("age"));
				e.setPhone(rs.getLong("phone"));
				e.setCity(rs.getString("city"));
				e.setSalary(rs.getFloat("salary"));
				
				emplist.add(e);
				System.out.println(e);
				
			}
			boolean moreResults = ps.getMoreResults();
			if(moreResults)
			{
				rs= ps.getResultSet();
				while(rs.next())
				{
					System.out.println("Maximum salary : "+rs.getFloat(1));
					System.out.println("Minimum Salary : "+rs.getFloat(2));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emplist;
	}
	public static void main(String[] args) {
		new EmpDao().viewRecords(3, 4);
	}
}
