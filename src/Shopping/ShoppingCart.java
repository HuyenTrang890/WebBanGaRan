package Shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import beans.Product;
import database.ProductDAO;

public class ShoppingCart {
	HashMap<String, ProductInCart> products = null;
	int numberOfProducts = 0;
	ProductDAO proDAO;

	public ShoppingCart() {
		products = new HashMap<String, ProductInCart>();
		proDAO = new ProductDAO();
	}

	public HashMap<String, ProductInCart> add(String id, Product book) {
		if (products.containsKey(id)) {
			ProductInCart scitem = (ProductInCart) products.get(id);
			scitem.incrementQuantity();

		} else {
			ProductInCart newItem = new ProductInCart(book);
			products.put(id, newItem);

		}
		return products;

	}

	public void remove(String bookId) {
		if (products.containsKey(bookId)) {
			ProductInCart scitem = (ProductInCart) products.get(bookId);
			scitem.decrementQuantity();

			if (scitem.getQuantity() <= 0) {
				products.remove(bookId);
			}

			numberOfProducts--;
		}
	}

	public List<ProductInCart> getProducts() {
		List<ProductInCart> results = new ArrayList<ProductInCart>();
		results.addAll(this.products.values());

		return results;
	}

	protected void finalize() throws Throwable {
		products.clear();
	}

	public int getNumberOfItems() {
		numberOfProducts = 0;

		for (Iterator i = getProducts().iterator(); i.hasNext();) {
			ProductInCart item = (ProductInCart) i.next();
			numberOfProducts += item.getQuantity();

		}

		return numberOfProducts;
	}

	public double getTotal() {
		double amount = 0;

		for (Iterator i = getProducts().iterator(); i.hasNext();) {
			ProductInCart item = (ProductInCart) i.next();
			Product pr = (Product) item.getProduct();
			amount += (item.getQuantity() * pr.getPrice());
		}

		return amount;
	}

	public void clearCart() {

		products.clear();
		numberOfProducts = 0;
	}

	public ProductInCart getBookICById(String id) {
		ProductInCart pro = null;
		for (ProductInCart p : getProducts()) {
			if (p.getProduct().getId().equals(id)) {
				pro = p;
			}

		}
		return pro;

	}

	public void buy(ShoppingCart cart) {

		proDAO.buy(cart);
		;

	}

}
