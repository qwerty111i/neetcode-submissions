/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return globalMax;
    }

    public int findMax(TreeNode node) {
        if (node == null) return 0;

        int bestLeft = Math.max(findMax(node.left), 0);
        int bestRight = Math.max(findMax(node.right), 0);

        int localMax = node.val + bestLeft + bestRight;
        globalMax = Math.max(globalMax, localMax);

        return node.val + Math.max(bestLeft, bestRight);
    }
}
