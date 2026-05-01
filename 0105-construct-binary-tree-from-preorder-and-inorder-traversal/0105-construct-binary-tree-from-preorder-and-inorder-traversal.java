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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return splitTree(preorder, 0,inorder.length-1,map);
    }

    private TreeNode splitTree(int [] preorder, int start, int end, Map<Integer, Integer> map){
        if(start>end){
            return null;
        }

        int rootindex=preorder[index++];
        TreeNode root= new TreeNode(rootindex);
        int mid=map.get(rootindex);
        root.left=splitTree(preorder,start,mid-1,map);
        root.right=splitTree(preorder,mid+1,end,map);
        return root;
    }
}