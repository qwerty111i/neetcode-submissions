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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (isSame(p, q) == -1) return false;
        return true;
    }

    public int isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return 0;
        if (p == null || q == null) return -1;

        if (p.val != q.val) return -1;
        
        int checkLeft = isSame(p.left, q.left);
        if (checkLeft == -1) return -1;

        int checkRight = isSame(p.right, q.right);
        if (checkRight == -1) return -1;

        return 0;
    }
}
