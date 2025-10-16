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
    Integer prev;
    int result=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        prev=null;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        if(prev!=null){
            result=Math.min(result, root.val-prev);
        }
        prev=root.val;
        inOrder(root.right);
    }
}