package com.files.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.files.entity.OfflineReader;
import com.files.entity.OnlineReader;

public class CustomerDao 
{
	StandardServiceRegistry ssr;
	Metadata meta;
	SessionFactory sf;
	
	public CustomerDao() 
	{
		ssr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		meta = new MetadataSources(ssr).getMetadataBuilder().build();
		sf= meta.getSessionFactoryBuilder().build();
	}
	
	public void registerCustomer()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Choose Subscription Type : ");
		System.out.println("1. Online Subscription");
		System.out.println("2. Offline Subscription");
		System.out.println("Enter your choice : ");
		int choice=sc.nextInt();
		
		OnlineReader or=null;
		OfflineReader of=null;
		
		Session session = sf.openSession();
		Transaction tr=session.beginTransaction();
		
		if(choice ==1 || choice==2)
		{
			
			if(choice==1)
			{
				or=new OnlineReader();
				
				System.out.println("Enter Customer Name : ");
				sc.nextLine();
				or.setCname(sc.nextLine());
				
				System.out.println("Enter Phone : ");
				or.setPhone(sc.nextLong());
				
				System.out.println("Enter Price : ");
				or.setPrice(sc.nextFloat());
				
				sc.nextLine();
				System.out.println("Enter email id : ");
				or.setEmailid(sc.nextLine());
				
				session.persist(or);
			}
			else if(choice==2)
			{
				of=new OfflineReader();
				System.out.println("Enter Customer Name : ");
				sc.nextLine();
				of.setCname(sc.nextLine());
				
				System.out.println("Enter Phone : ");
				of.setPhone(sc.nextLong());
				
				System.out.println("Enter Price : ");
				of.setPrice(sc.nextFloat());
				
				sc.nextLine();
				System.out.println("Enter Address : ");
				of.setAddress(sc.nextLine());
				
				System.out.println("Enter News Boy Name : ");
				of.setNewsboy(sc.nextLine());
				session.persist(of);
			}
			tr.commit();
		}
		else
		{
			System.out.println("Wrong choice!!");
		}
		session.close();
	}
}
