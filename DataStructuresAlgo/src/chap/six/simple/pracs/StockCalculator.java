package chap.six.simple.pracs;

import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author srividhya
 *
 */

public class StockCalculator {

	private FifoQueue<StockCompose> filterAndCalc(FifoQueue<StockCompose> composeContent, StockCompose sellActivity) {
		
		FifoQueue<StockCompose> filtered = new FifoQueue<>();
		boolean filterStock = false;
		List<StockCompose> sellingStock = new ArrayList<>();
		StockCompose origSellActivity = sellActivity;
		
		while (composeContent.getSize() >= 0) {
			StockCompose stockDetail = composeContent.dequeue();
			
			if (stockDetail == null) break;

			if (stockDetail.getCompany().equals(sellActivity.getCompany())) {
				filterStock = true;
				sellingStock.add(stockDetail);
			}
			
			if (!filterStock) 
				filtered.enqueue(stockDetail);
		}
		
		List<String> capitalAmtEarned = calcCapitalGainAmount(sellingStock, sellActivity);
		
		for (StockCompose stockUpdated : sellingStock) {
			if (stockUpdated.getQuantity() != 0) {
				filtered.enqueue(stockUpdated);
			}
		}
		
	    for (String result : capitalAmtEarned) {
	    	System.out.println(result);
	    }
	    
		
		return filtered;
	}
	
	private List<String> calcCapitalGainAmount(List<StockCompose> stockDetailList, StockCompose sellActivity) {
		List<String> capitalAmtEarned = new ArrayList<>();

		for (StockCompose stockDetail : stockDetailList) {
			if (sellActivity.getQuantity() <= 0)
				break;
			if (sellActivity.getQuantity() < stockDetail.getQuantity()) {
				Double earned = 0.0;
				Double buying = 0.0;
				earned = sellActivity.getQuantity() * sellActivity.getRate();
				buying = stockDetail.getQuantity() * stockDetail.getRate();
				capitalAmtEarned.add(buildCapDetail(sellActivity, earned, buying));
				stockDetail.setQuantity(stockDetail.getQuantity()-sellActivity.getQuantity());					
				sellActivity.setQuantity(0);
			} else if (sellActivity.getQuantity() == stockDetail.getQuantity()) {
				Double earned = 0.0;
				Double buying = 0.0;
				earned = sellActivity.getQuantity() * sellActivity.getRate();
				buying = stockDetail.getQuantity() * stockDetail.getRate();
				capitalAmtEarned.add(buildCapDetail(sellActivity, earned, buying)); 
				stockDetail.setQuantity(stockDetail.getQuantity()-sellActivity.getQuantity());
				sellActivity.setQuantity(0);
			} else if (sellActivity.getQuantity() > stockDetail.getQuantity()) {
				Double earned = 0.0;
				Double buying = 0.0;
				earned = stockDetail.getQuantity() * sellActivity.getRate();
				buying = stockDetail.getQuantity() * stockDetail.getRate();
				capitalAmtEarned.add(buildCapDetail(sellActivity, earned, buying));
				sellActivity.setQuantity(sellActivity.getQuantity()-stockDetail.getQuantity());
				stockDetail.setQuantity(0);
			}

		}
		
		return capitalAmtEarned;
	}
	
	private String buildCapDetail(StockCompose sellActivity, Double earned, Double buying) {
		StringBuilder capitalDetail = new StringBuilder();
		String separator = "#";
		
		capitalDetail.append(sellActivity.getCompany())
		.append(separator)
		.append(sellActivity.getActivity().value())
		.append(separator)
		.append(sellActivity.getQuantity())
		.append(separator)
		.append(sellActivity.getRate())
		.append(separator)
		.append(earned)
		.append(separator)
		.append(buying);
		
		return capitalDetail.toString();
		
	}
	
	public static void main(String[] args) {
		FifoQueue<StockCompose> composeContent = StockCalcUtil.loadStockWQueue();
		new StockCalculator().
			filterAndCalc(composeContent, 
					new StockCompose().
					setCompany("ZOOM").
					setActivity(StockActivity.SELL).
					setQuantity(100).
					setRate(55));
	}
}
