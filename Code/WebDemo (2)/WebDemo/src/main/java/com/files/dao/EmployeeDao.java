package com.files.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.files.entity.Employee;

public class EmployeeDao 
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	public EmployeeDao() 
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
	
	public boolean checkLogin(String userid, String pass)
	{
		String query = "select * from employee where empid='"+userid+"' and password='"+pass+"'";
		
		try 
		{
			st=con.createStatement();
			rs = st.executeQuery(query);
			
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
			
			
		} catch (SQLException e) 
		{
			System.out.println("Error : "+e);
		}
	}
	// ctrl+shift+o
	
	public ArrayList<Employee> getRecords1()
	{
		String query = "select * from employee";
	
		ArrayList<Employee> records =new ArrayList<Employee>();
		
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
				Employee e=new Employee();
				
				// get records
				
				e.setEmpid(rs.getString("empid"));
				e.setEmpname(rs.getString("empname"));
				e.setAge(rs.getInt("age"));
				e.setPhone(rs.getLong("phone"));
				e.setCity(rs.getString("city"));
				e.setSalary(rs.getFloat("salary"));
				
				records.add(e);
			}
					
		} catch (SQLException e) 
		{
			System.out.println("Error : "+e);
		}
		return records;
	}
	
	public void getRecordsById(String id)
	{
		String query = "select * from employee where empid = '"+id+"'";
		
		try 
		{
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			if(rs.next())
			{
				System.out.println("------------------------------------------");
				System.out.println("Emp id : "+rs.getString("empid"));
				System.out.println("Name : "+rs.getString("empname"));
				System.out.println("Age : "+rs.getInt("age"));
				System.out.println("Phone : "+rs.getLong("phone"));
				System.out.println("City : "+rs.getString("city"));
				System.out.println("Salary : "+rs.getFloat("salary"));
				System.out.println("------------------------------------------");
			}
		} catch (SQLException e) 
		{
			System.out.println("Error : "+e);
		}
	}
	
	public void closeObjects()
	{
		try
		{
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) 
		{
			System.out.println("Error : "+e);
		}
		
	}

	public void registerEmployee(Employee e) 
	{
		String query = "insert into employee values('"+e.getEmpid()+"', '"+e.getEmpname()+"',"
				+e.getAge()+", "+e.getPhone()+",'"+e.getCity()+"', "+e.getSalary()+")";
		
		try 
		{
			st = con.createStatement();
			
			int save = st.executeUpdate(query);

			System.out.println("Record Saved : "+save);
		} catch (SQLException e1) 
		{
			System.out.println("Error : "+e1+" already exists!!");
		}
		
	}

	public void deleteEmployeeById(String empcode) 
	{
		String query = "delete from employee where empid='"+empcode+"'";
		
		try 
		{
			st = con.createStatement();
			
			int del = st.executeUpdate(query);

			if(del==0)
				System.out.println("Record Does not Exists!!!");
			else
				System.out.println("Record deleted Successfully!! : ");
			
		} catch (SQLException e1) 
		{
			System.out.println("Error : Employee Does not Exists!!!");
		}
	}
	
	public ArrayList<Employee> getRecordsByName(String name) 
	{
		ArrayList<Employee> result = new ArrayList<Employee>();
		
		String query = "select * from employee where empname='"+name+"'";
		
		try 
		{
			st=con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next())
			{
				Employee e =new Employee();
				e.setEmpid(rs.getString("empid"));
				e.setEmpname(rs.getString("empname"));
				e.setAge(rs.getInt("age"));
				e.setPhone(rs.getLong("phone"));
				e.setCity(rs.getString("city"));
				e.setSalary(rs.getFloat("salary"));
				
				result.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	public ArrayList<Employee> getRecordsByCity(String city) 
	{
		ArrayList<Employee> result = new ArrayList<Employee>();
		
		String query = "select * from employee where city='"+city+"'";
		
		try 
		{
			st=con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next())
			{
				Employee e =new Employee();
				e.setEmpid(rs.getString("empid"));
				e.setEmpname(rs.getString("empname"));
				e.setAge(rs.getInt("age"));
				e.setPhone(rs.getLong("phone"));
				e.setCity(rs.getString("city"));
				e.setSalary(rs.getFloat("salary"));
				
				result.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateRecord(String colname, Employee e) 
	{
		String query="";
		int status =-1;
		if(colname.equals("All"))
		{
			query = "update employee set empname='"+e.getEmpname()+"',age="+e.getAge()+
					",phone="+e.getPhone()+",city='"+e.getCity()+"',salary="+e.getSalary()+
					",password='"+e.getPassword()+"' where empid='"+e.getEmpid()+"'";
		}
		else if(colname.equals("empname")|| colname.equals("city")||colname.equals("password"))
		{
			String value="";
			if(colname.equals("empname")) value = e.getEmpname();
			else if(colname.equals("city")) value = e.getCity();
			else if(colname.equals("password")) value=e.getPassword();
			query = "update employee set "+colname+"='"+value+"' where empid='"+e.getEmpid()+"'";
		}
		else if(colname.equals("age"))
		{
			query = "update employee set "+colname+"="+e.getAge()+" where empid='"+e.getEmpid()+"'";
		}
		else if(colname.equals("phone"))
		{
			query = "update employee set "+colname+"="+e.getPhone()+" where empid='"+e.getEmpid()+"'";
		}
		else
		{
			query = "update employee set "+colname+"="+e.getSalary()+" where empid='"+e.getEmpid()+"'";
		}
		
		try 
		{
			st=con.createStatement();
			status = st.executeUpdate(query);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}
	
	
}
