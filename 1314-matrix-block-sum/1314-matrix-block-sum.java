class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;
        int[][] arr = new int[r+1][c+1];
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                arr[i][j] = mat[i-1][j-1]+arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }
        int[][] ans = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int r1 = Math.max(0,i-k);
                int c1 = Math.max(0,j-k);
                int r2 = Math.min(r-1,i+k);
                int c2 = Math.min(c-1,j+k);
                ans[i][j] = arr[r2+1][c2+1]-arr[r1][c2+1]-arr[r2+1][c1]+arr[r1][c1];
            }
        }
        return ans;
    }
}