class Solution {
    public int longestMountain(int[] arr) {
       int n = arr.length;
       int maxlen = 0;
       int i=1;
       while(i<n-1){
       if(arr[i]>arr[i-1] && arr[i]> arr[i+1]){
        int left=i;
        int right = i;
        while(left>0 && arr[left]>arr[left-1]){left--;}
        while(right<n-1 && arr[right]>arr[right+1]){right++;}
        int len = right-left+1;
        maxlen = Math.max(maxlen,len);
        i = right;
       } else{
        i++;
       }
       }
       return maxlen;
    }
}