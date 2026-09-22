class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int k,
                           int remaining,
                           int start,
                           List<Integer> curr,
                           List<List<Integer>> res) {

        if (curr.size() == k && remaining == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (curr.size() > k || remaining < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(k, remaining - i, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
