package TradingStocks;

import static org.junit.Assert.*;

import org.junit.Test;

public class TradingStocksTest {

	@Test
	public void testSetMaxProfit() {
		int[] pricesDay1 = { 10, 7, 5, 8, 11, 9 };
		TradingStocks day1 = new TradingStocks(pricesDay1);
		day1.setMaxProfit();
		assertEquals(day1.getMaxProfit(), 6);
		assertEquals(day1.getBestBuyTime(), 5);
		assertEquals(day1.getBestSellTime(), 11);
		int[] pricesDay2 = { 100, 200, 6, 13, 5, 100, 1, 2 };
		TradingStocks day2 = new TradingStocks(pricesDay2);
		day2.setMaxProfit();
		assertEquals(day2.getMaxProfit(), 100);
		assertEquals(day2.getBestBuyTime(), 100);
		assertEquals(day2.getBestSellTime(), 200);
		int[] pricesDay3 = { 10, 9, 8, 7, 6, 5 };
		TradingStocks day3 = new TradingStocks(pricesDay3);
		day3.setMaxProfit();
		assertEquals(day3.getMaxProfit(), 0);
		assertEquals(day3.getBestBuyTime(), 10);
		assertEquals(day3.getBestSellTime(), 10);
	}
}
