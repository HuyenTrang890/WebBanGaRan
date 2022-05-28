package beans;

import java.util.ArrayList;
import java.util.List;

import database.DAOFactory;
import database.ProductDAO;

public class ListProductBean {
	private int batchSize = 15;
	private int firstItem = 0;
	private ProductDAO productDAO;
	private List<Product> products;

	public ListProductBean() {
		productDAO = DAOFactory.getInstance().getProductDAO();
	}

	public List<Product> getProducts() {
		products = productDAO.findBatch(firstItem, batchSize);
		return products;
	}

	public Product getProduct(String id) {
		return productDAO.findTitle(id);
	}
	public List<Product> getTitle(String title){
		products = productDAO.search(title);
		return  products;
	}
	
	public void deleteProduct(String id) {
		productDAO.delete(id);
	}

	public void updateProduct(Product p) {
		productDAO.update(p);
	}

	public void insertProduct(Product p) {
		productDAO.insert(p);
	}

	public int getProductCount() {
		return productDAO.productCount();
	}

	public int getLastItem() {
		int size = getProductCount();
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
		if (getFirstItem() + batchSize < getProductCount()) {
			firstItem += batchSize;
		}
	}

	public void prev() {
		firstItem -= batchSize;
		if (getFirstItem() < 0) {
			firstItem = 0;
		}
	}
	public void checkOut(Bill bill) {
		productDAO.checkOut(bill);
	}
	
}
