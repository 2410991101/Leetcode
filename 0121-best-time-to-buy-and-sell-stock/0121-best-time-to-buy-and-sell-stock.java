class Solution {
    public int maxProfit(int[] prices) {
       int min = Integer.MAX_VALUE;
       int maxx = 0;
       for(int price: prices){
        min = Math.min(min,price);
        maxx = Math.max(maxx,price-min);
       }
        return maxx;
    }
}