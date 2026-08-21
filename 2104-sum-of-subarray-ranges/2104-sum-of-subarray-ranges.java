class Solution {
    public long subArrayRanges(int[] nums) {
        
        int n = nums.length;
        
        long minSum = 0;
        long maxSum = 0;
        
        Stack<Integer> st = new Stack<>();
        
        // Sum of subarray minimums
        for(int i = 0; i <= n; i++) {
            
            while(!st.isEmpty() && 
                  (i == n || nums[st.peek()] >= nums[i])) {
                
                int mid = st.pop();
                
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                
                long leftCount = mid - left;
                long rightCount = right - mid;
                
                minSum += (long) nums[mid] * leftCount * rightCount;
            }
            
            st.push(i);
        }
        
        st.clear();
        
        // Sum of subarray maximums
        for(int i = 0; i <= n; i++) {
            
            while(!st.isEmpty() && 
                  (i == n || nums[st.peek()] <= nums[i])) {
                
                int mid = st.pop();
                
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                
                long leftCount = mid - left;
                long rightCount = right - mid;
                
                maxSum += (long) nums[mid] * leftCount * rightCount;
            }
            
            st.push(i);
        }
        
        return maxSum - minSum;
    }
}