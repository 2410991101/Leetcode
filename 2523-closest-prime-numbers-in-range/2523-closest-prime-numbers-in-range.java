class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right+1];
        for(int i=2;i<=right;i++){
            prime[i]=true;
        }
        for(int i=2;i*i<=right;i++){
            if(prime[i]){
                for(int j=i*i;j<=right;j+=i){
                    prime[j]=false;
                }
            }
        }
        int prev = -1;
        int diff = Integer.MAX_VALUE;
        int a=-1,b=-1;
        for(int i=Math.max(2,left);i<=right;i++){
            if(prime[i]){
                if(prev!=-1 && i-prev < diff){
                    diff = i-prev;
                    a = prev;
                    b = i;
                }
                prev = i;
            }
        }
        return new int[] {a,b};
    }
}