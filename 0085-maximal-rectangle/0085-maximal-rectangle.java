class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){return 0;}
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int max = 0;
        for(char[] row: matrix){
            for(int j=0;j<cols;j++){
                if(row[j]=='1'){heights[j]++;}
                else{ heights[j]=0;}
            }
            max = Math.max(max,largest(heights));
        }
        return max;
    }
    static int largest(int[] heights){
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for(int i=0;i<=heights.length;i++){
            int curr = (i==heights.length)?0:heights[i];
            while(!st.isEmpty() && heights[st.peek()]>curr){
                int height = heights[st.pop()];
                int width;
                if(st.isEmpty()){width= i;}
                else{ width = i-st.peek()-1;}
                max = Math.max(max,width*height);
            }
            st.push(i);
        }
        return max;
    }
}