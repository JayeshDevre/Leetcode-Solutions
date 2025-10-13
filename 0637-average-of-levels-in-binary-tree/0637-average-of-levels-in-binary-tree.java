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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        if(root==null){
            return result;
        }

        Queue <TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize=queue.size();
            Double res=0.0;
            for(int i=0;i<levelSize;i++){
                TreeNode temp=queue.poll();
                res=res+temp.val;
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            Double ans=res/levelSize;
            result.add(ans);
        }
        return result;
    }
}