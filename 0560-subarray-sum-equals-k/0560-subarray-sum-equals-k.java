class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count = 0;
        for(int n: nums){
            sum+=n;
            int left = sum-k;
            if(map.containsKey(left)){
                count+=map.get(left);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}