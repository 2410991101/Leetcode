class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       if(n==1){return nums[0];}
       int c1 = range(nums,0,n-2);
       int c2 = range(nums,1,n-1);
       return Math.max(c1,c2); 
    }
    public int range(int[] nums,int start,int end){
        int prev2=0;
        int prev1=0;
        for(int i=start;i<=end;i++){
            int x = prev2+nums[i];
            int y = prev1;
            int curr = Math.max(x,y);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}