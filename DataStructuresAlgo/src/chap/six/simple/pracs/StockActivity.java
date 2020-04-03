package chap.six.simple.pracs;

public enum StockActivity {
	
	BUY("buy"),
	SELL("sell");

	private String activity;
	
	private StockActivity(String value) {
		this.activity = value;
	}
	
	public String value() {
		return this.activity;
	}
 
}
