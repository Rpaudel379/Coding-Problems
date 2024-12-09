import java.util.LinkedList;
import java.util.Queue;

public class BTBFS {

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }

    }

    public static void main(String[] args) {
        BTBFS btbfs = new BTBFS();

        Node tree = btbfs.fill();

        btbfs.search(tree, 200);

    }

    private void search(BTBFS.Node tree, int key) {

        Queue<Node> q = new LinkedList<Node>();
        q.add(tree);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.value == key) {
                System.out.println("key found " + key + " = " + curr.value);
                return;
            }

            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);

        }

        System.out.println("key found " + key);
        return;
    }

    private Node fill() {
        Node tree = new Node(50);
        tree.left = new Node(71);
        tree.right = new Node(100);
        tree.left.left = new Node(101);
        tree.left.right = new Node(80);
        tree.right.left = new Node(200);
        tree.right.right = new Node(105);

        return tree;
    }
}
