class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = this.right = null;
    }

}

public class CompareBinaryTrees {

    public static void main(String[] args) {

        Node tree1 = new Node(10);
        tree1.left = new Node(9);
        tree1.right = new Node(11);

        tree1.left.left = new Node(8);
        tree1.left.right = new Node(10);

        Node tree2 = new Node(10);
        tree2.left = new Node(9);
        tree2.right = new Node(11);

        tree2.left.left = new Node(8);
        // tree2.left.right = new Node(22);

        compareBT(tree1, tree2);

    }

    private static void compareBT(Node tree1, Node tree2) {

        System.out.println(compare(tree1, tree2));
    }

    private static boolean compare(Node tree1, Node tree2) {

        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        if (tree1.value != tree2.value) {
            return false;
        }

        return compare(tree1.left, tree2.left) && compare(tree1.right, tree2.right);
    }

}
