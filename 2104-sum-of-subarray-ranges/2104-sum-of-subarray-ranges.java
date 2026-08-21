class Solution {
    public long subArrayRanges(int[] nums) {
        
        int n = nums.length;
        long minSum = 0;
        long maxSum = 0;
        
        Stack<Integer> st = new Stack<>();
        
        // Minimum contribution
        for(int i = 0; i <= n; i++) {
            
            while(!st.isEmpty() && 
                  (i == n || nums[st.peek()] >= nums[i])) {
                
                int mid = st.pop();
                
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                
                minSum += (long) nums[mid] 
                        * (mid - left) 
                        * (right - mid);
            }
            
            if(i < n) {
                st.push(i);
            }
        }
        
        st.clear();
        
        // Maximum contribution
        for(int i = 0; i <= n; i++) {
            
            while(!st.isEmpty() && 
                  (i == n || nums[st.peek()] <= nums[i])) {
                
                int mid = st.pop();
                
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                
                maxSum += (long) nums[mid] 
                        * (mid - left) 
                        * (right - mid);
            }
            
            if(i < n) {
                st.push(i);
            }
        }
        
        return maxSum - minSum;
    }
}