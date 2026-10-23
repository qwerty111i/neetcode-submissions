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
    public int goodNodes(TreeNode root) {
        return checkNode(root.val, root);
    }

    public int checkNode(int highestVal, TreeNode node) {
        if (node == null) return 0;

        int leftGood = checkNode(Math.max(node.val, highestVal), node.left);
        int rightGood = checkNode(Math.max(node.val, highestVal), node.right);

        if (node.val >= highestVal) {
            return leftGood + rightGood + 1;
        }

        return leftGood + rightGood;
    }
}
