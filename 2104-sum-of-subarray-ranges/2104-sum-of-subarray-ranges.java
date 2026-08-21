class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long minsum=0;
        long maxsum=0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || nums[st.peek()]>=nums[i])){
                int mid = st.pop();
                int left = st.isEmpty()? -1: st.peek();
                int right = i;
                long leftcount = mid-left;
                long rightcount = right-mid;
                minsum+= (long)nums[mid]*leftcount*rightcount;
            }
            st.push(i);
        }
        st.clear();
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || nums[st.peek()]<=nums[i])){
                int mid = st.pop();
                int left = st.isEmpty()? -1: st.peek();
                int right = i;
                long leftcount = mid-left;
                long rightcount = right-mid;
                maxsum+= (long)nums[mid]*leftcount*rightcount;
            }
            st.push(i);
        }
        return maxsum-minsum;
    }
}