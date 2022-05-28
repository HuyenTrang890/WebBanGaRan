package beans;

import java.util.List;

import database.BillDao;
import database.DAOFactory;

public class ListBill {
	private int batchSize = 8;
	private int firstItem = 0;
	private BillDao billDAO;
	private List<Bill> bills;
	private Bill current;

	public ListBill() {
		billDAO = DAOFactory.getInstance().getBillDAO();
	}

	public List<Bill> getBills() {
		bills = billDAO.findBatch(firstItem, batchSize);
		return bills;
	}

	public int getbillCount() {
		return billDAO.billCount();
	}

	public int getLastItem() {
		int size = getbillCount();
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
		if (getFirstItem() + batchSize < getbillCount()) {
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
