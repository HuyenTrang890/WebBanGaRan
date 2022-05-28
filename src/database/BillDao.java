package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Bill;
import beans.Product;

public class BillDao {
	public List<Bill> findAll() {
		Connection connection = null;
		List<Bill> billList = new ArrayList<Bill>();
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Bill;");
			billList = populateList(rs);
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
		return billList;
	}

	private List<Bill> populateList(ResultSet rs) throws SQLException {
		List<Bill> stList = new ArrayList<Bill>();
		while (rs.next()) {
			String userName = rs.getString("userName");
			Double total = rs.getDouble("total");

			Bill bill = new Bill(userName, total);
			stList.add(bill);
		}
		return stList;
	}

	public List<Bill> findBatch(int first, int size) {
		Connection connection = null;
		List<Bill> billList = new ArrayList<Bill>();
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Bill;");
			for (int i = 0; i < first; i++) {
				rs.next();
			}
			for (int count = 0; rs.next() && count < size; count++) {
				String userName = rs.getString("userName");
				Double total = rs.getDouble("total");

				Bill bill = new Bill(userName, total);

				billList.add(bill);

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
		return billList;
	}

	public int billCount() {
		Connection connection = null;
		int count = 0;
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT count(*) FROM bill");
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
