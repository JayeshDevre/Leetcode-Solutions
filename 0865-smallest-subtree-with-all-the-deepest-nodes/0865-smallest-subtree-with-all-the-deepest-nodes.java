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
    HashMap<Integer, Integer> map= new HashMap<>();
    int maxD=0;

    public void depth(TreeNode root, int d){
        if(root==null){
            return;
        }
        map.put(root.val,d);
        maxD=Math.max(d,maxD);
        depth(root.left,d+1);
        depth(root.right,d+1);
    }

    public TreeNode Lca(TreeNode root){
        if(root==null || map.get(root.val)==maxD){
            return root;
        }
        TreeNode l=Lca(root.left);
        TreeNode r=Lca(root.right);

        if(l!=null && r!=null){
            return root;
        }

        return l==null?r:l;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth(root,0);
        return Lca(root);
    }
}