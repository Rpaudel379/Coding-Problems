/**
 * SixtySeven
 */
public class SixtySeven {

    public static void main(String[] args) {
        SubtreeOfAnotherTree ss = new SubtreeOfAnotherTree();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        StringBuilder s = new StringBuilder();

        ss.generateHash(root, s);

        System.out.println(s);
    }
}

class SubtreeOfAnotherTree {

    // TC : O(N * M) where N: Number of nodes in root tree and M: Number of nodes in tree to be compared
    // SC:  O(h) where h : maximum depth of main tree
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return true;
        }

        if (sameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s != null && t != null && s.val == t.val) {
            return sameTree(s.left, t.left) && sameTree(s.right, t.right);
        }

        return false;
    }


    // TC : O(N + M) + O(N * M) -> O(N * M)
    // SC: O(N + M) where N: Number of nodes in root tree and M: Number of nodes in tree to be compared
    public boolean isSubtreeHashing(TreeNode root, TreeNode subRoot) {
        StringBuilder mainTree = new StringBuilder();
        StringBuilder subTree = new StringBuilder();

        generateHash(root, mainTree);
        generateHash(subRoot, subTree);

        return mainTree.toString().contains(subTree.toString());
    }

    void generateHash(TreeNode root, StringBuilder str) {

        if (root == null) {
            str.append("L");
            return;
        }

        // use hash to separate nodes
        // str += ("," + Integer.toString(root.val));
        str.append("," + Integer.toString(root.val));

        generateHash(root.left, str);
        generateHash(root.right, str);

        // str += "#";
        str.append("#");
    }
}