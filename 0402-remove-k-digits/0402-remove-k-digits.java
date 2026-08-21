class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char digit: num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>digit){st.pop();k--;}
            st.push(digit);
        }
            while(k>0){st.pop();k--;}
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            sb.reverse();
        int i=0;
        while(i<sb.length() && sb.charAt(i)=='0'){
            i++;
        }
        String ans= sb.substring(i);
        if(ans.length()==0){
            return "0";
        }
        return ans;
    }
}