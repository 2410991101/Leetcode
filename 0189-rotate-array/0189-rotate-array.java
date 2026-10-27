class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        rotation(nums,0,n-1);
        rotation(nums,0,k-1);
        rotation(nums,k,n-1);
    }
    public void rotation(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]= temp;
            start++;
            end--;
        }
    }
}