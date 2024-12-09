
public class SixtyTwo {

    public static void main(String[] args) {

    }
}

class InvertBinaryTree {
    public TreeNode invertTree2(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree2(root.right);
        root.right = invertTree2(temp);

        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}