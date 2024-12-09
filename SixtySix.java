/**
 * SixtySix
 */
public class SixtySix {
    public static void main(String[] args) {

    }

}

class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }

}