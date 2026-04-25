package com.file;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.file.Entity.Employee;

public class App1 
{
	StandardServiceRegistry ssr;
	Metadata meta;
	SessionFactory sf;
	
	public App1() 
	{
		ssr=new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		
		meta=new MetadataSources(ssr).getMetadataBuilder().build();
    	
    	sf= meta.getSessionFactoryBuilder().build();
    	
	}
	public Employee getEmployee(String empid)
	{
		Employee e;
    	Session session=sf.openSession();
    	
    	Transaction tr=session.beginTransaction();
    	
    	e= session.get(Employee.class, empid);
//    	Hibernate.initialize(e.getEmpname());
    	if(e!=null)
    		System.out.println("Employee Record : \n"+e);
    	session.close();
    	
    	return e;		

	}

}
