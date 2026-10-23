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
    int result = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTrav(root, k);
        return result;
    }

    public void inOrderTrav(TreeNode node, int kthSmall) {
        if (node != null) {
            inOrderTrav(node.left, kthSmall);

            count++;
            if (count == kthSmall) {
                result = node.val;
                return;
            }

            inOrderTrav(node.right, kthSmall);
        }
    }
}
