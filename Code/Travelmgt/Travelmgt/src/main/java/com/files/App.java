package com.files;

import com.files.dao.TravelDaoannotate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//       TravelDao tdao=new TravelDao();
//       tdao.registerTravel();
    	
    	TravelDaoannotate dao=new TravelDaoannotate();
    	dao.registerTravel();
    }
}
