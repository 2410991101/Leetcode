class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0,sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int left = sum%k;
            if(left<0){
                left+=k;
            }
            count+=map.getOrDefault(left,0);
            map.put(left,map.getOrDefault(left,0)+1);
        }
        return count;
    }
}