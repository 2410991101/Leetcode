class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates,
                           int remaining,
                           int start,
                           List<Integer> curr,
                           List<List<Integer>> res) {

        if (remaining == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (remaining < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            curr.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
