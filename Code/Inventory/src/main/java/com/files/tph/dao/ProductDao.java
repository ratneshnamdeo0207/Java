package com.files.tph.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.files.tph.entity.Product;
import com.files.tph.entity.ProductSales;
import com.files.tph.entity.ProductVendor;

public class ProductDao 
{
	StandardServiceRegistry ssr;
	Metadata meta;
	SessionFactory sf;
	
	public ProductDao() 
	{
		ssr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		meta = new MetadataSources(ssr).getMetadataBuilder().build();
		sf= meta.getSessionFactoryBuilder().build();
	}
	
	public String storeData(Product p, ProductSales ps, ProductVendor pv)
	{
		String result ="None";
		Session session = sf.openSession();
		Transaction tr=session.beginTransaction();
		
		// persist() method is used to store values from object to tables
		session.persist(p);
		session.persist(ps);
		session.persist(pv);
		
		tr.commit();// it is used save changes in the table
		session.close();
		result ="Data Saved Successfully!!";
		return result;
	}
	public String viewData(int pid)
	{
		Session session = sf.openSession();
		Transaction tr=session.beginTransaction();
		
		Product product = session.get(Product.class, pid);
		ProductSales ps = session.get(ProductSales.class, pid);
		ProductVendor pv = session.get(ProductVendor.class, pid);
		String output = product.toString()+"\n"+ps.toString()+"\n"
				+pv.toString();
		session.close();
		
		return output;
	}
	
	
}
