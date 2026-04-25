package com.files.entity;

public class Employee 
{
	private String empid;
	private String empname;
	private int age;
	private long phone;
	private String city;
	private float salary;
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() 
	{
		return "Employee Id : " + empid + "\nEmployee Name : " + empname + 
				"\nAge : " + age + "\nPhone : " + phone +
				"\nCity : "+ city + "\nSalary : " + salary
				+"\nPassword : "+password;
	}
	
//	alt+shift+s-> generate getter and setters
	
	
}
