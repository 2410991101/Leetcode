class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pre(root);
        return maxSum;
    }

    private int pre(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, pre(node.left));
        int right = Math.max(0, pre(node.right));

        int currentPath = node.val + left + right;
        maxSum = Math.max(maxSum, currentPath);

        return node.val + Math.max(left, right);
    }
}