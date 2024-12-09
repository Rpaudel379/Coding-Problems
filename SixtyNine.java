import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

/**
 * SixtyNine
 */
public class SixtyNine {

    public static void main(String[] args) {

    }
}

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> nodes = new ArrayList<>();

            for (int i = 0; i < q.size(); i++) {
                TreeNode curr = q.poll();
                nodes.add(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

            }
            res.add(nodes);

        }
        return res;
    }
}