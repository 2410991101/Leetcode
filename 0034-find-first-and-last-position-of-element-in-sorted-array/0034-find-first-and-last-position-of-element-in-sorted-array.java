class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = bound(nums, target, true);
        int last = bound(nums, target, false);
        return new int[]{first, last};
    }

    private int bound(int[] nums, int target, boolean first) {
        int l = 0, r = nums.length - 1, ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                ans = m;
                if (first) r = m - 1; // search left
                else l = m + 1;       // search right
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
