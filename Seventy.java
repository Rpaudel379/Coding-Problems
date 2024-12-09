import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Seventy
 */
public class Seventy {

    public static void main(String[] args) {

    }
}

class BinaryTreeRightSideView {
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int depth) {
        if (root == null) {
            return;
        }

        if (depth == res.size()) {
            res.add(root.val);
        }

        dfs(root.right, res, depth + 1);
        dfs(root.left, res, depth + 1);

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode lastNode = null;
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    lastNode = curr;

                    q.add(curr.left);
                    q.add(curr.right);
                }
            }

            if (lastNode != null) {
                res.add(lastNode.val);
            }
        }

        return res;
    }
}