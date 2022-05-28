package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static String driverClass = "org.hsqldb.jdbcDriver";
	private static String url = "jdbc:hsqldb:hsql://localhost/sam";
	private static String username = "sa";
	private static String password = "";

//	static {
//		try {
//			Class.forName(driverClass);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(url, username, password);
//	}
	public static Connection getConnection()  {
		Connection con = null;
		try {
			Class.forName(driverClass);
			con=DriverManager.getConnection(url, username, password);
			System.out.println("Kết nối thành công!");
			
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println("kết nối thất bại! "+ e.getMessage());
		}
	return con;
	}
}
