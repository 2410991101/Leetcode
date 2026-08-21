class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        
        for(int i = 0; i <= n; i++) {
            
            while(!st.isEmpty() && 
                  (i == n || heights[st.peek()] >= heights[i])) {
                
                int mid = st.pop();
                
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                
                int width = right - left - 1;
                
                int area = heights[mid] * width;
                
                maxArea = Math.max(maxArea, area);
            }
            
            if(i < n) {
                st.push(i);
            }
        }
        
        return maxArea;
    }
}