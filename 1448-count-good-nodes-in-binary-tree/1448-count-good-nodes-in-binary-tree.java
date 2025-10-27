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
        return helper(root,0,Integer.MIN_VALUE);
    }

    private int helper(TreeNode root, int sum, int maxVal){
        if(root==null){
            return 0;
        }

        int currentVal=0;
        if(root.val>=maxVal){
            maxVal=root.val;
            currentVal=1;
        }

        int lval=helper(root.left,sum,maxVal);
        int rval=helper(root.right,sum,maxVal);

        return currentVal+lval+rval;
    }
}