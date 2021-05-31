package com.mindtree.json.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public static Connection getConnection() throws MyException
	{
		Connection con=null;
		try {
			//Class.forName("com.mysql.cj.jdbcDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Driver driver=new com.mysql.cj.jdbc.Driver();
//			DriverManager.deregisterDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/game?user=root&password=Kiccha@123");
			
			
		}catch(ClassNotFoundException e)
		{
			throw new MyException("Class not found");
		}catch(SQLException e)
		{
			throw new MyException("You running wrong query");
		}
		return con;
	}
}
