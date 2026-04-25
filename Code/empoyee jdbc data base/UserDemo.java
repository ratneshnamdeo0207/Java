package pack1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserDemo 
{
	EmployeeDao edao;
	Scanner sc;
	public UserDemo() 
	{
		edao=new EmployeeDao();
		sc=new Scanner(System.in);
	}
	
	public void registerEmployee()
	{
		Employee e=new Employee();
		
		sc.nextLine();
		System.out.println("Enter Employee id : ");
		e.setEmpid(sc.nextLine());
		
		System.out.println("Enter Employee Name : ");
		e.setEmpname(sc.nextLine());
		
		System.out.println("Enter Employee Age : ");
		e.setAge(sc.nextInt());
		
		sc.nextLine();
		System.out.println("Enter City : ");
		e.setCity(sc.nextLine());
		
		System.out.println("Enter Phone : ");
		e.setPhone(sc.nextLong());
		
		System.out.println("Enter Employee Salary: ");
		e.setSalary(sc.nextFloat());
		
		edao.registerEmployee(e);
	}
	
	public void menu()
	{
		int choice;
		
		do
		{
			System.out.println("0. Exit");
			System.out.println("1. Get All Records");
			System.out.println("2. Get Record by Id");
			System.out.println("3. Get Records by Name"); // *
			System.out.println("4. Get Records By City"); // *
			System.out.println("5. Register Employee");
			System.out.println("6. Delete Employee Record");
			System.out.println("Enter your choice : ");
			choice=sc.nextInt();
			
			if(choice == 0)
			{
				System.out.println("Goodbye!!!");
				edao.closeObjects();
			}
			else if(choice==1)
			{
//				edao.getRecords();
				
				ArrayList<Employee> records = edao.getRecords1();
				
				Iterator<Employee> itr = records.iterator();
				while(itr.hasNext()) System.out.println("\n-------------\n"+itr.next()+"\n---------------\n");
			}
			else if(choice ==2)
			{
				sc.nextLine();
				System.out.println("Enter Employee Id : ");
				edao.getRecordsById(sc.nextLine());
			}
			else if(choice ==5)
			{
				registerEmployee();
			}
			else if(choice==6)
			{
				sc.nextLine();
				System.out.println("Enter Employee Id : ");
				edao.deleteEmployeeById(sc.nextLine());
			}
			else
			{
				System.out.println("Wrong choice!! TryAgain!!!");
			}
			System.out.println("----------------------------------------------");
			
		}while(choice!=0);
	}
	
	public static void main(String[] args) 
	{
		UserDemo ud=new UserDemo();
		ud.menu();
		
	}

}
