import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * SixtyThree
 */
public class SixtyThree {

    public static void main(String[] args) {

        Deque<Integer> q = new LinkedList<>();
        q.addFirst(1);
        q.addFirst(2);
        q.addFirst(3);
        q.addFirst(4);
        q.addFirst(5);

        while (!q.isEmpty()) {
            System.out.println(q.pollFirst());
        }

    }
}

class MaximumDepthOfBinaryTree {
    public int maxDepthDFS(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepthDFS(root.left);
        int right = maxDepthDFS(root.right);

        return 1 + Math.max(left, right);
    }

    public int maxDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<SetD> stack = new Stack<>();
        int res = 0;

        stack.push(new SetD(root, 1));

        while (!stack.isEmpty()) {
            SetD s = stack.pop();
            TreeNode node = s.node;
            int depth = s.depth;

            if (node != null) {
                res = Math.max(res, depth);
                stack.push(new SetD(node.left, depth + 1));
                stack.push(new SetD(node.right, depth + 1));
            }

            /*
             * if (node.left != null) {
             * stack.push(new SetD(node.left, depth + 1));
             * }
             * if (node.right != null) {
             * stack.push(new SetD(node.right, depth + 1));
             * }
             * res = Math.max(res, depth);
             */

        }

        return res;
    }

    public int maxDepthBFS(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depth = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

            }

            depth += 1;
        }

        return depth;
    }

    public int maxDepth(TreeNode root) {
        int res = 0;

        Stack<SetD> s = new Stack<>();
        s.push(new SetD(root, 1));

        while (!s.isEmpty()) {

            SetD curr = s.pop();
            TreeNode node = curr.node;
            int value = curr.depth;

            if (node != null) {
                res = Math.max(res, value);
                s.push(new SetD(node.left, value + 1));
                s.push(new SetD(node.right, value + 1));
            }

        }

        return res;
    }

    class SetD {
        TreeNode node;
        int depth;

        public SetD(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

}