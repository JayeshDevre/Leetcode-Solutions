import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; // direction flag

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            // process current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Insert depending on traversal direction
                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                // normal BFS enqueueing
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // store this level
            result.add(level);
            // flip direction for next level
            leftToRight = !leftToRight;
        }

        return result;
    }
}
