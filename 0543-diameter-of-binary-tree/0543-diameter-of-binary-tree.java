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
    private int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter-1;
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=helper(root.left);
        int right=helper(root.right);

        int d=left+right+1;

        diameter = Math.max(d, diameter);

        return Math.max(left,right)+1;
    }


}