package Shopping;

import beans.Product;

public class ProductInCart {
	Product product;
	int quantity;

	public ProductInCart(Product anItem) {
		product = anItem;
		quantity = 1;
	}

	public void incrementQuantity() {
		quantity++;
	}

	public void decrementQuantity() {
		quantity--;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
