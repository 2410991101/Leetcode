class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] change = new int[1001];
        for(int[] trip: trips){
            int pass = trip[0];
            int from = trip[1];
            int to = trip[2];
            change[from]+=pass;
            change[to]-=pass;
        }
        int curr = 0;
        for(int i=0;i<=1000;i++){
            curr+=change[i];
            if(curr>capacity){
                return false;
            }
        }
        return true;
    }
}