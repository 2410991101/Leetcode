class Solution {
    public int maxProfit(int[] prices, int fee) {
       int hold = -prices[0];
       int cash = 0;
       for(int i=1;i<prices.length;i++){
        int prevhold = hold;
        int prevcash = cash;
        hold = Math.max(prevhold,prevcash-prices[i]);
        cash = Math.max(prevcash,prevhold+prices[i]-fee);
       } 
       return cash;
    }
}