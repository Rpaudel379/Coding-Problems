/**
 * SixtyEight
 */
public class SixtyEight {

    public static void main(String[] args) {

    }
}

class LowestCommonAncestorOfBST {

    // O(logN)
    // O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode curr = root;

        while (true) {
            if (curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            } else if (curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
    }

    // O(logN)
    // O(1)
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorRecursive(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorRecursive(root.left, p, q);
        } else {
            return root;
        }
    }

    // O(N)
    // O(1) if not counting recursive stack frame or -> auxiliary O(N)
    public TreeNode lowestCommonAncestorLinear(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestorLinear(root.left, p, q);
        TreeNode right = lowestCommonAncestorLinear(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        } else {
            return left;
        }

    }
}