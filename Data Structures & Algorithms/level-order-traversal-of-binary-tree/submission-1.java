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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null) return finalList;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            List<Integer> nextList = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currNode = queue.poll();
                nextList.add(currNode.val);

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }

            finalList.add(nextList);
        }

        return finalList;
    }
}
