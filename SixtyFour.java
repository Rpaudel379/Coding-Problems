/**
 * SixtyFour
 */
public class SixtyFour {

    public static void main(String[] args) {

    }
}

class DiameterOfBinaryTree {
    int result = 0;
    int res = -1; // min val

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int leftH = dfs(root.left);
        int rightH = dfs(root.right);

        result = Math.max(result, (2 + (leftH + rightH)));

        return 1 + Math.max(leftH, rightH);
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        dfs2(root);
        return result;
    }

    private int dfs2(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int leftH = 1 + dfs2(root.left);
        int rightH = 1 + dfs2(root.right);

        res = Math.max(res, (leftH + rightH));

        return Math.max(leftH, rightH);
    }

}