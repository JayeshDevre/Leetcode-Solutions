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
    long max;
    long total;
    int mod= 1_000_000_007;
    public int maxProduct(TreeNode root) {
        total= getSum(root);
        helper(root);
        return (int) (max%mod);
    }

    private long getSum(TreeNode root){
        if(root==null){
            return 0l;
        }
        return root.val+getSum(root.left)+getSum(root.right);
    }

    private long helper(TreeNode root){
        if(root==null){
            return 0l;
        }

        long lsum=helper(root.left);
        long rsum=helper(root.right);
        long subsum=root.val+lsum+rsum;

       long product=(total-subsum)*subsum;
       if(product>max){
        max=product;
       }
       
       return subsum ;
    }
}