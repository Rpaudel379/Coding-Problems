/**
 * SixtyFive
 */
public class SixtyFive {

    public static void main(String[] args) {

    }
}

class BalancedBinaryTree {

    // O(N)
    public boolean isBalanced1(TreeNode root) {
        return dfs2(root) != -1;
    }

    private int dfs2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = dfs2(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = dfs2(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    } 

    public boolean isBalanced2(TreeNode root) {
        return dfs1(root).getKey();
    }

    private Pair<Boolean, Integer> dfs1(TreeNode root) {
        if (root == null) {
            return new Pair<Boolean, Integer>(true, 0);
        }

        var left = dfs1(root.left);
        var right = dfs1(root.right);

        boolean balanced = (left.getKey() && right.getKey()) && Math.abs(left.getValue() - right.getValue()) <= 1;

        return new Pair<Boolean, Integer>(balanced, 1 + Math.max(left.getValue(), right.getValue()));
    }

    // O(N2)
    // auxiliary O(N)
    public boolean bruteForce3(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }

        return bruteForce3(root.left) && bruteForce3(root.right);

    }

    public boolean bruteForce2(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);

        return Math.abs(leftH - rightH) <= 1 && bruteForce2(root.left) && bruteForce2(root.right);
    }

    public boolean bruteForce1(TreeNode root) {

        if (root == null) {
            return true;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);

        if (Math.abs(leftH - rightH) > 1) {
            return false;
        }

        boolean left = bruteForce1(root.left);
        boolean right = bruteForce1(root.right);

        if (!left || !right) {
            return false;
        }

        return true;
    }

    private int practice(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = practice(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = practice(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);

        return 1 + Math.max(leftH, rightH);
    }
}