package com.utility;

import java.sql.*;

public class DBConfig {
	static String userDB="root";
	static String passDB="";
	static String url="jdbc:mysql://localhost:3306/e_gadgets";
	static String driver="com.mysql.jdbc.Driver";
	static Connection con;
	public static Connection dbConnect() {
		// load the driver
		try {
		Class.forName(driver);
		System.out.println("Driver Loaded");
		}
		catch(ClassNotFoundException e){
			System.out.println("Driver not Loaded..");
			e.printStackTrace();
			// to show the detail of the error print stacktrace is used			
		}

	// establish the connect
			try {
				con =DriverManager.getConnection(url, userDB, passDB);
				System.out.println("Connection Established");
			} catch (SQLException e) {
				System.out.println("Connection Failed");
				e.printStackTrace();
				}
			return con;
	}
			
			public static Connection dbClose() {
				try {
				con.close();
				System.out.println("Connection closed");
				}
				catch(SQLException e) {
					System.out.println("Connection could not be closed");
				}
				return con;
			}
			
	public static void main(String[]args) {
		DBConfig dbCon = new DBConfig();
		dbCon.dbConnect();
		dbCon.dbClose();
	}
}
