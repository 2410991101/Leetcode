class Solution {
    public boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        for(int i=1;i<nums.length;i++){
            gcd = gcd(gcd,nums[i]);
            if(gcd == 1){
                return true;
            }
        }
        return gcd==1;
    }
    int gcd(int a,int b){
        while(b!=0){
            int res = a%b;
            a=b;
            b=res;
        }
        return a;
    }
}