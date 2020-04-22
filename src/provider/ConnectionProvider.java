package provider;

import java.sql.*;

public class ConnectionProvider implements connProvider{

	static Connection con = null;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(connURL,username,pass);
	}
		catch (Exception e) {
			System.out.println (e);
		}
		return con;
	}
}
