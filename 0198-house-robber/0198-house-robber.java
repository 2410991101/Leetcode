class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int prev2 = nums[0];
        int prev1 = Math.max(nums[1],nums[0]);
        for(int i=2;i<n;i++){
            int take = prev2 + nums[i];
            int skip = prev1;
            int curr = Math.max(take,skip);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}