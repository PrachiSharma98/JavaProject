package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

	public static boolean insertStudentTODB(Student st) {
		// TODO Auto-generated constructor stub
	//JDBC 
		boolean flag=true;
		try {
		Connection con=ConnectionProvider.createConnection();
		String insertQuery="insert into students(sname,sphone) values(?,?)";
		PreparedStatement pstmt=con.prepareStatement(insertQuery);
		pstmt.setString(1, st.getStudentName());
		pstmt.setString(2, st.getStudentPhone());
		pstmt.executeUpdate();
		flag=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean  deleteStudent(int stuId) {
		// TODO Auto-generated method stub
		boolean flag=true;
		try {
		Connection con=ConnectionProvider.createConnection();
		String delQuery="delete from  students where sid=?";
		PreparedStatement pstmt=con.prepareStatement(delQuery);
		pstmt.setInt(1, stuId);

		pstmt.executeUpdate();
		flag=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
		
	}

	public static void showAll() {
		// TODO Auto-generated method stub
	//	boolean flag=true;
		try {
		Connection con=ConnectionProvider.createConnection();
		String selectQuery="select * from students";
		Statement stmt=con.createStatement();
		ResultSet set=stmt.executeQuery(selectQuery);
		while(set.next())
		{
			int id=set.getInt(1);
			String name=set.getString(2);
			String phone =set.getString(3);
			System.out.println("ID :" + id);
			System.out.println("Name :" + name);
			System.out.println("Phone :" + phone);
			System.out.println("***********");
		}
		
	//	flag=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
	}

}
