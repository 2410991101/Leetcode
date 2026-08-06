class Solution {
    public int majorityElement(int[] nums) {
        int can=0;
        int count=0;
        for(int num: nums){
            if(count==0){can=num;}
            if(can==num){
                count++;
            }
            else{
                count--;
            }
        }
return can;
    }
}