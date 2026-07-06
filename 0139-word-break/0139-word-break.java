class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        Boolean[] dp = new Boolean[s.length()];

        return helper(0, s, wordDict, dp);
    }

    private boolean helper(int index, String s,
                           List<String> wordDict,
                           Boolean[] dp) {

        if(index == s.length())
            return true;

        // Already solved
        if(dp[index] != null)
            return dp[index];

        for(String word : wordDict){

            if(s.startsWith(word, index)){

                if(helper(index + word.length(), s, wordDict, dp))
                    return dp[index] = true;
            }
        }

        return dp[index] = false;
    }
}