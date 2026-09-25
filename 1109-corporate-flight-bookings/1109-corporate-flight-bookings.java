class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
       int[] arr = new int[n+1];
       for(int[] b: bookings){
        int first = b[0];
        int last = b[1];
        int seats = b[2];
        arr[first-1]+=seats;
        arr[last]-=seats;
       }
       int[] res = new int[n];
       res[0]=arr[0];
       for(int i=1;i<n;i++){
        res[i]=res[i-1]+arr[i];
       }
       return res;
    }
}