class Solution {
    public int maximumWealth(int[][] accounts) {
       return java.util.Arrays.stream(accounts).mapToInt(row -> java.util.Arrays.stream(row).sum()).max().orElse(0); 
    }
}