package beans;

public class Bill {
	private String userName;
	private Double total;

	public Bill(String userName, Double total) {
		super();
		this.userName = userName;
		this.total = total;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
