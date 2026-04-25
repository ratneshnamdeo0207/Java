package com.files;

import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.files.entity.Person;

/**
 * Hello world!
 */
public class App2 {
    public static void main(String[] args) 
    {
    	Configuration config=new Configuration();
    	config.configure("com/files/resources/hibernate.cfg.xml");
    	SessionFactory sf=config.buildSessionFactory();
    	
    	Session session=sf.openSession();
    	
    	TypedQuery query = session.getNamedQuery("findByPname");
    	
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter Person Name : ");
    	query.setParameter("name", sc.nextLine());
    	
    	List<Person> pp = query.getResultList();
    	
    	for(Person p:pp)
    		System.out.println(p);
    
    	
//    	System.out.println("All Records:-");
//    	
//    	TypedQuery query1 = session.getNamedQuery("findAll");
//    	
//    	List<Person> records = query1.getResultList();
//    	
//    	for(Person p:records) System.out.println(p);
//    	
    	
    	session.close();
    }
}
