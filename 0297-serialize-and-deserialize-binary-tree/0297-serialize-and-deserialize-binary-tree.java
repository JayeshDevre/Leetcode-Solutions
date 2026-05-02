/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "null";
        }
        return root.val +","+serialize(root.left)+","+serialize(root.right);
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue= new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue){
        String ele= queue.poll();
        if(ele.equals("null")){
            return null;
        }

        TreeNode root=new TreeNode(Integer.parseInt(ele));
        root.left=buildTree(queue);
        root.right=buildTree(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));