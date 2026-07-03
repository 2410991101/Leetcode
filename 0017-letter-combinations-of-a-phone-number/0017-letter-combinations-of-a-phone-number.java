class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        String[] map = {
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        helper(0,digits,map,new StringBuilder(),res);
        return res;
    }
    private void helper(int index,String digits,String[] map,StringBuilder output, List<String> res){
        if(index==digits.length()){
            res.add(output.toString());
            return;
        }
        String letters = map[digits.charAt(index)-'0'];
        for(int i=0;i<letters.length();i++){
            output.append(letters.charAt(i));
            helper(index+1,digits,map,output,res);
            output.deleteCharAt(output.length()-1);
        }
    }
}