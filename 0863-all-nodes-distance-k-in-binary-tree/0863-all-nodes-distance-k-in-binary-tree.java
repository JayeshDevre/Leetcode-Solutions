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

    private void parentTrack(TreeNode root, HashMap<TreeNode, TreeNode> parentT){
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr= queue.poll();
            if(curr.left!=null){
                parentT.put(curr.left,curr);
                queue.offer(curr.left);
            }
            if(curr.right!=null){
                parentT.put(curr.right,curr);
                queue.offer(curr.right);                
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans= new ArrayList<>();
        HashMap<TreeNode, TreeNode> parentT=new HashMap<>();
        parentTrack(root, parentT);

        Map<TreeNode,Boolean> visited= new HashMap<>();
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(target);
        visited.put(target,true);
        int currLevel=0;

        while(!queue.isEmpty()){
            int size=queue.size();
            if(currLevel==k){
                break;
            }
            currLevel++;

            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    queue.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    queue.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parentT.get(curr)!=null && visited.get(parentT.get(curr))==null){
                    queue.offer(parentT.get(curr));
                    visited.put(parentT.get(curr),true);
                }
            } 
        }

        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            ans.add(curr.val);
        }
        return ans;
    }
}