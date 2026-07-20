class Solution {
    public int[] findPeakGrid(int[][] mat) {
      int r = mat.length;
      int c = mat[0].length;
      int low = 0;
      int high = c-1;
      while(low<=high){
        int mid = low +(high - low)/2;
        int max=0;
        for(int i=0;i<r;i++){
            if(mat[i][mid]>mat[max][mid]){
                max = i;
            }
        }
        int left = mid==0? -1: mat[max][mid-1];
        int right = mid==c-1?-1: mat[max][mid+1];
        if(mat[max][mid]>left && mat[max][mid]>right){
            return new int[]{max,mid};
        }
        if(mat[max][mid]<left){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
      }
      return new int[]{-1,-1};
    }
}