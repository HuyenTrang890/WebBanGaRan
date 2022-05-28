package beans;

public class Product {
	
	private String id;
	private double price;
	private String title;
	private String descrition;
	private int amount;

	public Product() {

	}

	public Product(String id, double price, String title, String descrition, int amount) {
		super();
		this.id = id;
		this.price = price;
		this.title = title;
		this.descrition = descrition;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", title=" + title + ", descrition=" + descrition
				+ ", amount=" + amount + "]";
	}

}