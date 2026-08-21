class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<>();
        
        for(char digit : num.toCharArray()) {
            
            while(!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }
            
            st.push(digit);
        }
        
        // If removals are still left
        while(k > 0) {
            st.pop();
            k--;
        }
        
        // Build answer
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        sb.reverse();
        
        // Remove leading zeroes
        int i = 0;
        while(i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        
        String ans = sb.substring(i);
        
        if(ans.length() == 0) {
            return "0";
        }
        
        return ans;
    }
}