package beans;

import java.util.List;

import database.DAOFactory;
import database.UserDao;

public class ListUser {
	private int batchSize = 8;
	private int firstItem = 0;
	private UserAccount user;
	private List<UserAccount> users;
	private UserDao userDAO;

	public ListUser() {
		userDAO = DAOFactory.getInstance().getUserDAO();
	}

	public List<UserAccount> getUsers() {
		users = userDAO.findBatch(firstItem, batchSize);
		return users;
	}
	public UserAccount getEmployee(String userName) {
		return userDAO.getUserName(userName);
	}

	public void deleteUser(String userName) {
		userDAO.delete(userName);
	}

	public void insertUser(UserAccount User) {
		userDAO.insert(User);
	}

	public void updateUser(UserAccount User) {
		userDAO.edit(user);
	}

	public int getUserCount() {
		return userDAO.userCount();
	}

	public int getLastItem() {
		int size = getUserCount();
		return firstItem + batchSize > size ? size : firstItem + batchSize;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public int getFirstItem() {
		return firstItem;
	}

	public void next() {
		if (getFirstItem() + batchSize < getUserCount()) {
			firstItem += batchSize;
		}
	}

	public void prev() {
		firstItem -= batchSize;
		if (getFirstItem() < 0) {
			firstItem = 0;
		}
	}
}
