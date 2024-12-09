import java.util.HashMap;

public class FiftyFive {
    public static void main(String[] args) {
        CopyListWithRandomPointer copy = new CopyListWithRandomPointer();

        copy.copyRandomList(null);
    }
}

class CopyListWithRandomPointer {

    public Node copyRandomList2(Node head) {

        if (head == null) {
            return null;
        }
        Node curr = head;

        // a -> a' -> b -> b' -> c -> c'
        while (curr != null) {
            Node newNode = new Node(curr.val);

            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        // pointing new node's random to new node
        curr = head;
        while (curr != null) {
            Node newNode = curr.next;

            newNode.random = curr.random == null ? null : curr.random.next;

            curr = curr.next.next;
        }

        // separating new nodes from old nodes
        // a -> a' -> b -> b' -> c -> c'
        curr = head;
        Node newHead = curr.next;

        while (curr != null) {

            Node newNode = curr.next;

            curr.next = newNode.next;

            newNode.next = curr.next == null ? null : curr.next.next;

            curr = curr.next;
        }

        return newHead;
    }

    public Node copyRandomList(Node head) {

        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();

        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}