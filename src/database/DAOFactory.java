package database;

public class DAOFactory {
	private static DAOFactory instance = new DAOFactory();

	public static DAOFactory getInstance() {
		return instance;
	}

	public ProductDAO getProductDAO() {
		return new ProductDAO();
	}

	public UserDao getUserDAO() {
		return new UserDao();
	}
	public BillDao getBillDAO() {
		return new BillDao();
	}
}
