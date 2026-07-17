class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high =0;
        for(int pile : piles){
            high = Math.max(high,pile);
        }
        int ans = high;
        while(low<=high){
            int mid = low + (high - low)/2;
            long hours = calculate(piles,mid);
            if(hours<=h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    private long calculate(int[] piles, int speed){
        long hours = 0;
        for(int pile : piles){
            hours += ((long)pile+speed-1)/speed;
        }
        return hours;
    }
}