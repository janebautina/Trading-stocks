package TradingStocks;

/**
 * Suppose we could access yesterday's stock prices as an array, where: The
 * indices are the time in minutes past trade opening time, which was 9:30am
 * local time. The values are the price in dollars of the stock at that time.
 * So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500. Write
 * an efficient function that takes stockPricesYesterday and returns the best
 * profit I could have made from 1 purchase and 1 sale of 1 stock
 * yesterday.
 */
public class TradingStocks {

	private int[] stockPrices;
	private int bestBuyTime;
	private int bestSellTime;
	private int maxProfit;

	/**
	 * Return the best profit
	 * 
	 * @return bestProfit
	 */
	public int getMaxProfit() {
		return this.maxProfit;
	}

	/**
	 * Return the best time for buying stocks
	 * 
	 * @return bestButTime
	 */
	public int getBestBuyTime() {
		return this.bestBuyTime;
	}

	/**
	 * Return the best time for selling stocks
	 * 
	 * @return bestSellTime
	 */
	public int getBestSellTime() {
		return this.bestSellTime;
	}

	/**
	 * Constructor
	 * 
	 * @param array
	 *            - stock prices array
	 */
	TradingStocks(int[] array) {
		this.stockPrices = array;
	}

	/**
	 * Calculate the best Profit for the day, 
	 * best buy time and sell time.
	 */
	public void setMaxProfit() {
		int globalMaxProfit = 0;
		int globalBestBuy = stockPrices[0];
		int globalBestSell = stockPrices[0];
		int localBestBuy = stockPrices[0];
		int localBestSell = stockPrices[0];
		int localProfit = 0;
		for (int i = 0; i < stockPrices.length; i++) {
			if (stockPrices[i] <= localBestBuy) {
				localBestBuy = stockPrices[i];
				localBestSell = stockPrices[i];
				localProfit = 0;
			} else {
				localBestSell = stockPrices[i];
				localProfit = localBestSell - localBestBuy;
				if (localProfit > globalMaxProfit) {
					globalMaxProfit = localProfit;
					globalBestBuy = localBestBuy;
					globalBestSell = localBestSell;
				}
			}
		}
		this.bestBuyTime = globalBestBuy;
		this.bestSellTime = globalBestSell;
		this.maxProfit = globalMaxProfit;
	}

	/**
	 * Print the best buy/sell time and max profit
	 */
	public void printData() {
		System.out.println("Buy: " + this.bestBuyTime);
		System.out.println("Sell: " + this.bestSellTime);
		System.out.println("Profit: " + this.maxProfit);

	}
}
