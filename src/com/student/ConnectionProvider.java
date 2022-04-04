package com.student;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionProvider {
 static  Connection  con;
	
		// TODO Auto-generated constructor stub
		public static Connection createConnection()
		{
			try {
			//Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			//create connection
			String user="root";
			String password ="Prachisharma@1";
			String url = "jdbc:mysql://localhost:3306/student";
			con = DriverManager.getConnection(url,user,password);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			return con;
		}
		
	

}
