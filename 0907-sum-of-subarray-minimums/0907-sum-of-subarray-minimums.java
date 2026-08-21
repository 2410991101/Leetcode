class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;
        long mod = 1000000007;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }
            
            st.push(i);
        }
        
        st.clear();
        
        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }
            
            st.push(i);
        }
        
        // Calculate contribution
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            
            long leftCount = i - left[i];
            long rightCount = right[i] - i;
            
            ans = (ans + arr[i] * leftCount * rightCount) % mod;
        }
        
        return (int) ans;
    }
}