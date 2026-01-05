/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        
        while(root!=null){
            if(p.val<root.val && q.val<root.val){
                root=root.left;
            }else if(p.val>root.val && q.val>root.val){
                root=root.right;
            }else{
                return root;
            }
        }
        return null;
    }
}