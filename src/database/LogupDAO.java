package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import beans.UserAccount;

public class LogupDAO {
	Connection con;

	public LogupDAO(Connection con) {
		this.con = con;
	}

	public boolean userLogup(UserAccount user) {
		boolean set = false;
		
			String sql = "INSERT INTO USERACCOUNT VALUES(?,?,?,?,?,?)";
			try {
			con = DatabaseConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getTelephone());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getAddress());
			stmt.executeUpdate();
			set = true;
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
			finally {
				try {
					con.close();
				} catch (SQLException sqleClose) {
					sqleClose.printStackTrace();
				}}
		return set;

			}}
