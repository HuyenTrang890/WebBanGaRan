package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Admin;
import beans.UserAccount;

public class LoginDAO {

	ResultSet rs = null;

	public UserAccount userCheckLogin(String userName, String password) {
		UserAccount user = null;
		String sql = "select userName, password from useraccount where userName = ? AND password = ?";
		new DatabaseConnection();
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			while (rs.next()) {
				 user = new UserAccount(rs.getString(1), rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public Admin adminCheckLogin(String userName, String password) {
		Admin admin=null;
		String sql = "select userName, password from admin where userName = ? AND password = ?";
		new DatabaseConnection();
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			while (rs.next()) {
				admin = new Admin(rs.getString(1), rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

}
