class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = fir(nums,target);
        int last = las(nums,target);
        return new int[]{first,last};
    }
    static int fir(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                high = mid-1;
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    static int las(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                low = mid+1;
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}