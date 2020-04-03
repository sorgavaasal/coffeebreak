package chap.six.simple.pracs;

public class StockCalcUtil {

	public static FifoQueue<StockCompose> loadStockWQueue() {
		FifoQueue<StockCompose> sharesComposed = new FifoQueue<>();

		sharesComposed.enqueue(
				new StockCompose().
				setCompany("APPL").
				setActivity(StockActivity.BUY).
				setQuantity(100).
				setRate(100.00));

		sharesComposed.enqueue(
				new StockCompose().
				setCompany("APPL").
				setActivity(StockActivity.BUY).
				setQuantity(120).
				setRate(130.00));
		
		sharesComposed.enqueue(
				new StockCompose().
				setCompany("APPL").
				setActivity(StockActivity.BUY).
				setQuantity(140).
				setRate(110.00));

		sharesComposed.enqueue(
				new StockCompose().
				setCompany("ZOOM").
				setActivity(StockActivity.BUY).
				setQuantity(55).
				setRate(22.00));

		sharesComposed.enqueue(
				new StockCompose().
				setCompany("ZOOM").
				setActivity(StockActivity.BUY).
				setQuantity(100).
				setRate(42.00));

		sharesComposed.enqueue(
				new StockCompose().
				setCompany("ZOOM").
				setActivity(StockActivity.BUY).
				setQuantity(100).
				setRate(42.00));
		
		sharesComposed.enqueue(
				new StockCompose().
				setCompany("FB").
				setActivity(StockActivity.BUY).
				setQuantity(100).
				setRate(111));

		return sharesComposed;

	}

}
