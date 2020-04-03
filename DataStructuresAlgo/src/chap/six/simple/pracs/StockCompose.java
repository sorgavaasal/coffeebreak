package chap.six.simple.pracs;

public class StockCompose {

	private String company;
	private StockActivity activity;
	private int quantity;
	private double rate;
	private static final String separator = "#";

	public String getCompany() {
		return company;
	}

	public StockCompose setCompany(String company) {
		this.company = company;
		return this;
	}

	public StockActivity getActivity() {
		return activity;
	}

	public StockCompose setActivity(StockActivity activity) {
		this.activity = activity;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public StockCompose setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public double getRate() {
		return rate;
	}

	public StockCompose setRate(double rate) {
		this.rate = rate;
		return this;
	}

	public String toString() {
		return new StringBuilder(this.company)
				.append(separator)
				.append(this.activity.value())
				.append(separator)
				.append(quantity)
				.append(separator)
				.append(rate).toString();
	}
	
}
