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
    public boolean isValidBST(TreeNode root) {
        
        List<Integer> inOrderList= new LinkedList<>();
        helper(root,inOrderList);

        boolean isBst=true;
        int prev=inOrderList.get(0);

        for(int i=1;i<inOrderList.size();i++){
            if(inOrderList.get(i)<=prev){
                isBst=false;
            }
            prev=inOrderList.get(i);
        }
        return isBst;
    }
    
    void helper(TreeNode node, List<Integer> inOrderList){
        if(node==null){
            return;
        }
        helper(node.left,inOrderList);
        inOrderList.add(node.val);
        helper(node.right,inOrderList);
    }
}