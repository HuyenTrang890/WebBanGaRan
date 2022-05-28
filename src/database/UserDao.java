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

import beans.UserAccount;

public class UserDao {

	public void insert(UserAccount user) {
		String sql = "INSERT INTO USERACCOUNT VALUES(?,?,?,?,?,?)";
		Connection con = null;
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

	public boolean edit(UserAccount user) {
		Connection con = null;
		String sql = "INSERT INTO USERACCOUNT VALUES(?,?,?,?,?,?)";

		try {
			con = DatabaseConnection.getConnection();
			con.setAutoCommit(false);

			PreparedStatement stmt = con.prepareStatement("DELETE FROM USERACCOUNT WHERE userName = ?");
			stmt.setString(1, user.getUserName());
			stmt.executeUpdate();

			stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getTelephone());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getAddress());
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
		return true;

	}

	public void delete(String userName) {
		String sql = "DELETE FROM USERACCOUNT where userName = ?";
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

	public UserAccount getUserName(String userName) {
		UserAccount user = new UserAccount();
		String sql = "select * from USERACCOUNT where userName=?";
		new DatabaseConnection();
		Connection con;

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				user.setUserName(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public List<UserAccount> getAll() {
		List<UserAccount> users = new ArrayList<UserAccount>();
		String sql = "SELECT * FROM USERACCOUNT";
		Connection con;

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserAccount user = new UserAccount();

				user.setUserName(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setTelephone(rs.getString("telephone"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return users;
	}

	public List<UserAccount> findBatch(int first, int size) {
		Connection connection = null;
		List<UserAccount> userList = new ArrayList<UserAccount>();
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM USERACCOUNT;");
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
				UserAccount user = new UserAccount(userName, name, email, telephone, password, address);
				userList.add(user);
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
		return userList;
	}

	public List<UserAccount> findByNameAndMale(String pname, boolean pmale) {
		// TODO Auto-generated method stub
		return null;
	}

	public int userCount() {
		Connection connection = null;
		int count = 0;
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT count(*) FROM USERACCOUNT;");
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
