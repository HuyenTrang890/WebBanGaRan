package database;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Shopping.ProductInCart;
import Shopping.ShoppingCart;
import beans.Bill;
import beans.Product;
import beans.UserAccount;

import database.DatabaseConnection;

public class ProductDAO {

	public List<Product> findAll() {
		Connection connection = null;
		List<Product> stList = new ArrayList<Product>();
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cart;");
			stList = populateList(rs);
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
		return stList;
	}

	public Product findTitle(String id) {
		Connection connection = null;
		Product product = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cart WHERE id = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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
		return product;
	}

	private List<Product> populateList(ResultSet rs) throws SQLException {
		List<Product> stList = new ArrayList<Product>();
		while (rs.next()) {
			String id = rs.getString("id");
			String title = rs.getString("title");
			double price = rs.getDouble("price");
			String descrition = rs.getString("descrition");
			int amount = rs.getInt("amount");
			Product product = new Product(id, price, title, descrition, amount);
			stList.add(product);
		}
		return stList;
	}

	public List<Product> findBatch(int first, int size) {
		Connection connection = null;
		List<Product> stList = new ArrayList<Product>();
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cart;");
			for (int i = 0; i < first; i++) {
				rs.next();
			}
			for (int count = 0; rs.next() && count < size; count++) {
				String id = rs.getString("id");
				String title = rs.getString("title");
				float price = rs.getFloat("price");
				String descrition = rs.getString("descrition");
				int amount = rs.getInt("amount");
				Product product = new Product(id, price, title, descrition, amount);

				stList.add(product);

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
		return stList;
	}

	public int productCount() {
		Connection connection = null;
		int count = 0;
		try {
			connection = DatabaseConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery("SELECT count(*) FROM cart");
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

	public boolean delete(String id) {
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM CART WHERE ID = ?");
			stmt.setString(1, id);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return true;
	}

	public boolean insert(Product employee) {
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO CART VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, employee.getId());
			stmt.setDouble(2, employee.getPrice());
			stmt.setString(3, employee.getTitle());

			stmt.setString(4, employee.getDescrition());
			stmt.setInt(5, employee.getAmount());

			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return true;
	}

	public boolean update(Product employee) {
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			connection.setAutoCommit(false);

			PreparedStatement stmt = connection.prepareStatement("DELETE FROM CART WHERE ID = ?");
			stmt.setString(1, employee.getId());
			stmt.executeUpdate();

			stmt = connection.prepareStatement("INSERT INTO CART VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, employee.getId());
			stmt.setDouble(2, employee.getPrice());
			stmt.setString(3, employee.getTitle());

			stmt.setString(4, employee.getDescrition());
			stmt.setInt(5, employee.getAmount());
			stmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			try {
				connection.rollback();
				return false;
			} catch (SQLException sqleRollback) {
				sqleRollback.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return true;
	}

	public void buyBook(String bookId, int quantity) {
		Connection connection = null;

		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement prepStmt = connection.prepareStatement("select * " + "from CART where ID = ? ");
			prepStmt.setString(1, bookId);

			ResultSet rs = prepStmt.executeQuery();

			if (rs.next()) {
				int amount = rs.getInt(6);
				prepStmt.close();

				if ((amount - quantity) >= 0) {
					PreparedStatement updateStatement = connection
							.prepareStatement("update CART set AMOUNT = AMOUNT - ? where ID = ?");

					updateStatement.setInt(1, quantity);
					updateStatement.setString(2, bookId);
					updateStatement.executeUpdate();

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void buy(ShoppingCart cart) {
		Connection connection = null;
		Collection books = cart.getProducts();
		Iterator i = books.iterator();

		try {
			connection = DatabaseConnection.getConnection();
			connection.setAutoCommit(false);

			while (i.hasNext()) {
				ProductInCart pic = (ProductInCart) i.next();
				Product p = (Product) pic.getProduct();
				String id = p.getId();
				int quantity = pic.getQuantity();
				buyBook(id, quantity);
			}

			connection.commit();
			connection.setAutoCommit(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private ArrayList<Product> product;
	/*
	 * private String id; private String title; private String author; private
	 * double price; private String decription;
	 * 
	 * 
	 * ID CHAR(8) PRIMARY KEY, TITLE NCHAR(50) NOT NULL, AUTHOR CHAR(50) NULL, PRICE
	 * FLOAT NOT NULL, DECRIPITION NTEXT NULL)
	 */

	public List<Product> getProducts() {
		product = new ArrayList<Product>();
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM CART");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Product b = new Product(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
						rs.getInt(5));
				if (rs.getInt(5) > 0) {
					product.add(b);
				}

			}

			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return product;
	}
	public static List<Product> search(String title) {
		Connection connection = null;
		List<Product> pro = new ArrayList<Product>();
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cart where title like ?");
			stmt.setString(1, "%"+title+"%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Product product = new Product(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				pro.add(product);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		System.out.println(pro);
		return pro;
	}
	public static void main(String[] args) {
		new ProductDAO().search("Gà");
		System.out.println(new ProductDAO().search("Gà"));
	}
	public boolean checkOut(Bill bill) {
		Connection connection = null;

		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO BILL VALUES (?, ?)");
			stmt.setString(1, bill.getUserName());
			stmt.setDouble(2, bill.getTotal());
			stmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			try {
				connection.rollback();
				return false;
			} catch (SQLException sqleRollback) {
				sqleRollback.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException sqleClose) {
				sqleClose.printStackTrace();
			}
		}
		return true;}

}