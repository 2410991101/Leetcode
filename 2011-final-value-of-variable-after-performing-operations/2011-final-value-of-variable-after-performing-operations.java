class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations)
            x += op.contains("+") ? 1 : -1;
        return x;
    }
}
