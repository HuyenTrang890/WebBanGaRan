package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import beans.Admin;
import beans.UserAccount;

public class AdminDAO {

	public void insert(Admin admin) {
		String sql = "INSERT INTO ADMIN(userName,name, dateOfBirth, email, telephone, password,address) VALUES(?,?,?,?,?,?)";
		Connection con = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getUserName());
			stmt.setString(2, admin.getName());
			stmt.setString(3, admin.getEmail());
			stmt.setString(4, admin.getTelephone());
			stmt.setString(5, admin.getPassword());
			stmt.setString(6, admin.getAddress());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void edit(Admin admin) {
		Connection con = null;
		String sql = "INSERT INTO ADMIN VALUES(?,?,?,?,?,?)";

		try {
			con = DatabaseConnection.getConnection();
			con.setAutoCommit(false);

			PreparedStatement stmt = con.prepareStatement("DELETE FROM ADMIN WHERE userName = ?");
			stmt.setString(1, admin.getUserName());
			stmt.executeUpdate();

			stmt = con.prepareStatement(sql);
			stmt.setString(1, admin.getUserName());
			stmt.setString(2, admin.getName());
			stmt.setString(3, admin.getEmail());
			stmt.setString(4, admin.getTelephone());
			stmt.setString(5, admin.getPassword());
			stmt.setString(6, admin.getAddress());
			stmt.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void delete(String userName) {
		String sql = "DELETE FROM ADMIN where userName = ?";
		new DatabaseConnection();
		Connection con = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
	}

	public UserAccount getName(String name) {
		return null;
	}

	public Admin getUserName(String userName) {
		Admin user = new Admin();
		String sql = "select * from ADMIN where userName=?";
		new DatabaseConnection();
		Connection con;

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				user.setUserName(rs.getString("userName"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telaphone"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public List<Admin> getAll() {
		List<Admin> admins = new ArrayList<Admin>();
		String sql = "SELECT * FROM ADMIN";
		Connection con;

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Admin admin = new Admin();

				admin.setUserName(rs.getString("userName"));
				admin.setName(rs.getString("name"));
				admin.setEmail(rs.getString("email"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setPassword(rs.getString("password"));
				admin.setAddress(rs.getString("address"));
				admins.add(admin);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return admins;
	}

	public List<Admin> findBatch(int first, int size) {
		Connection connection = null;
		List<Admin> adminList = new ArrayList<Admin>();
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM ADMIN;");
			for (int i = 0; i < first; i++) {
				result.next();
			}
			for (int count = 0; result.next() && count < size; count++) {
				String userName = result.getNString("userName");
				String name = result.getString("name");
				String email = result.getString("email");
				String address = result.getString("address");
				String telephone = result.getString("telephone");
				String password = result.getString("password");
				Admin admin = new Admin(userName, name, email, telephone, password, address);
				adminList.add(admin);
			}
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return adminList;
	}

	public List<Admin> findByNameAndMale(String pname, boolean pmale) {
		return null;
	}

	public int admin() {
		Connection connection = null;
		int count = 0;
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT count(*) FROM ADMIN;");
			if (result.next())
				count = result.getInt(1);
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return count;
	}

}
