package com.files;

import com.files.dao.CustomerDao;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) 
    {
    	CustomerDao cdao=new CustomerDao();
    	cdao.registerCustomer();
    }
}
