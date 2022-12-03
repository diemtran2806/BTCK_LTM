package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDatabase {
	
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsv_2", "root", "190523");
		if (conn != null) {
			System.out.println("Connected!");
			return conn;
		}
		
		
		return null;
	}
}

//performance cpu 
//9h ngày 