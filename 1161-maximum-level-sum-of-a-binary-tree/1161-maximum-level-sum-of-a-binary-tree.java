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
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=Integer.MIN_VALUE;
        Queue<TreeNode > queue=new LinkedList<>();
        queue.offer(root);
        int maxlevel=1;
        int level=1;

        while(!queue.isEmpty()){
            int levelSize= queue.size();
            int currentsum=0;
   

            for(int i=0;i<levelSize;i++){
                TreeNode node=queue.poll();
                currentsum=currentsum+node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            if(currentsum>ans){
                ans=currentsum;
                maxlevel=level;
            }
            level++;

        }
        return maxlevel;
    }
}