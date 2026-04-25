package com.files.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.files.entity1.BeachDestination;
import com.files.entity1.MountainDestination;
import com.files.entity1.TravelInformation;

public class TravelDaoannotate 
{
	
		StandardServiceRegistry ssr;
		Metadata meta;
		SessionFactory sf;
		
		public TravelDaoannotate() 
		{
			ssr= new StandardServiceRegistryBuilder().configure("com\\files\\resources\\hibernate1.cfg.xml").build();
			meta = new MetadataSources(ssr).getMetadataBuilder().build();
			sf= meta.getSessionFactoryBuilder().build();
		}
		
		public void registerTravel()
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Choose Travel Type : ");
			System.out.println("1. Beach Destination");
			System.out.println("2. Mountain Destination");
			System.out.println("3. Register Travel Info Only");
			System.out.println("Enter your choice : ");
			int choice=sc.nextInt();
			
			Session session = sf.openSession();
			Transaction tr=session.beginTransaction();
			
			if(choice == 1 || choice== 2 || choice== 3)
			{
				if(choice==1)
				{
					BeachDestination bd=new BeachDestination();
					
					System.out.println("Enter Customer Name : ");
					sc.nextLine();
					bd.setCustomername(sc.nextLine());
					
					System.out.println("Enter Package Price : ");
					bd.setPackageprice(sc.nextFloat());
					
					sc.nextLine();
					System.out.println("Enter sports type : ");
					bd.setSporttype(sc.nextLine());
					System.out.println("Enter cruise type : ");
					bd.setCruisetype(sc.nextLine());
					
					session.persist(bd);
				}
				else if(choice==2)
				{
					MountainDestination md=new MountainDestination();
					System.out.println("Enter Customer Name : ");
					sc.nextLine();
					md.setCustomername(sc.nextLine());
					
					System.out.println("Enter Package Price : ");
					md.setPackageprice(sc.nextFloat());
					
					sc.nextLine();
					System.out.println("Enter activities : ");
					md.setActivities(sc.nextLine());
					
					System.out.println("Enter Roomtype : ");
					md.setRoomtype(sc.nextLine());
					session.persist(md);
				}
				else if(choice==3)
				{   
					TravelInformation ti=new TravelInformation();
					
					System.out.println("Enter Customer Name : ");
					sc.nextLine();
					ti.setCustomername(sc.nextLine());
					
					System.out.println("Enter Package Price : ");
					ti.setPackageprice(sc.nextFloat());
					session.persist(ti);
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
