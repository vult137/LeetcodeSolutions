// 123. Best Time to Buy and Sell Stock III
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int p : prices) {
            buy1 = Math.min(buy1, p);
            sell1 = Math.max(sell1, p - buy1);
            buy2 = Math.min(buy2, p - sell1);
            sell2 = Math.max(sell2, p - buy2);
        }
        return sell2;
    }
}
