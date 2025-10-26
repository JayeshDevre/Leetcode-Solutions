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

    private int helper(TreeNode root, int ans, int currentMax){
        if(root==null){
            return 0;
        }
        int currentAns=0;

        if(root.val>=currentMax){
            currentAns=1;
            currentMax=root.val;
        }

        int lans=helper(root.left,ans,currentMax);
        int rans=helper(root.right,ans,currentMax);

        return currentAns+lans+rans;

    }
}