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
public int minDepth(TreeNode root) {
    if (root == null) return 0;

    // Leaf node
    if (root.left == null && root.right == null) return 1;

    // If one side is null, go down the other
    if (root.left == null)  return minDepth(root.right) + 1;
    if (root.right == null) return minDepth(root.left) + 1;

    // Both sides exist → take the smaller one
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
}

    }
