package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private DBConnection() {
	}

	// Bütün program bu metodu kullanarak bağlantıyı alır.Connection yoksa yaratılır.
	
	 public static Connection getConnection() {
         Connection conn = null;
         try
 		{
 			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
 			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:mehmet","system","123456");
 			 
 		}catch(Exception ex)
 		{
 			System.out.println(ex+"");
 		}
         return conn;
   }
}
