// Time complexity: O(N), Only one traversal of the loop is needed.
// Auxiliary Space: O(N), N is the space required to store the value in the hashmap.

import java.util.HashSet;

/**
 * DetectLoopInLL
 */

public class DetectLoopInLL {

    public static void main(String[] args) {

        SLL ll = new SLL();
        ll.display();
        ll.insertTail(40);
        ll.insertTail(50);
        ll.insertTail(70);
        ll.display();

        ll.createLoop();

        System.out.println(ll.checkLoop());
    }

}

class Node {
    int value;
    Node next;

    public Node(int val) {
        this.value = val;
        this.next = null;
    }
}

class SLL {

    private Node head = null;
    private Node tail = null;

    public void insertHead(int value) {
        Node newNode = new Node(value);

        // if list is empty
        if (this.head == null || this.tail == null) {
            this.head = newNode;
            this.tail = this.head;
            return;
        }

        newNode.next = this.head;
        this.head = newNode;
    }

    public void insertTail(int value) {
        Node newNode = new Node(value);

        if (this.head == null || this.tail == null) {

            this.head = newNode;
            this.tail = this.head;
            return;
        }

        this.tail.next = newNode;
        this.tail = newNode;
    }

    public void deleteHead() {
        if (this.head == null) {
            System.out.println("empty list");
        } else {
            this.head = this.head.next;
        }
    }

    public void deleteTail() {
        if (this.tail == null) {
            System.out.println("empty list");
        } else {
            Node curNode = this.head;

            // if there is only one list node
            if (curNode.next == null) {
                this.head = null;
                return;
            }

            while (curNode.next.next != null) {
                curNode = curNode.next;
            }

            curNode.next = null;
            this.tail = curNode;

        }
    }

    public void insert(int position, int value) {
        Node newNode = new Node(value);

        if (this.head == null) {
            System.out.println("list empty");
            return;
        }

        if (position == 1) {
            this.insertHead(value);
            return;
        }

        Node prev = this.head;
        Node curr = this.head;
        int i = 1;

        while (curr != null && position != i) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        if (curr == null && i == position) {
            this.insertTail(value);
        } else if (i == position) {
            prev.next = newNode;
            newNode.next = curr;
        } else {
            System.out.println("index out of range");
        }
    }

    public void delete(int position) {
        if (this.head == null || this.tail == null) {
            System.out.println("empty list");
        } else {

            if (position == 1) {
                this.deleteHead();
                return;
            }

            Node prev = this.head;
            Node curr = this.head;
            int i = 1;

            while (curr.next != null && i != position) {
                prev = curr;
                curr = curr.next;
                i++;
            }

            if (curr.next == null && i == position) {
                this.deleteTail();
            } else if (i == position) {
                prev.next = curr.next;
            } else {
                System.out.println("index out of range");
            }

        }
    }

    public void display() {
        Node currNode = this.head;
        if (currNode == null) {
            System.out.println("List empty");
        } else {
            while (currNode != null) {
                System.out.print(currNode.value + "\t");
                currNode = currNode.next;
            }
        }
        System.out.println();
    }

    public void createLoop() {
        this.tail.next = this.head;
    }

    public boolean checkLoop() {
        HashSet<Node> s = new HashSet<Node>();
        Node node = this.head;

        while (node != null) {
            if (s.contains(node)) {
                return true;
            }
            s.add(node);
            node = node.next;
        }

        return false;
    }

    // public static void main(String[] args) {

    // SLL ll = new SLL();

    // ll.display();

    // ll.insertHead(22);
    // ll.display();

    // ll.insertHead(23);
    // ll.display();

    // ll.insertTail(21);
    // ll.display();

    // ll.insertTail(20);
    // ll.display();

    // ll.deleteHead();
    // ll.display();

    // ll.deleteTail();
    // ll.display();

    // ll.insertHead(23);
    // ll.display();

    // ll.insert(4, 20);
    // ll.display();

    // ll.delete(5);
    // ll.display();

    // ll.deleteTail();
    // ll.display();
    // ll.deleteTail();
    // ll.display();
    // ll.deleteTail();
    // ll.display();

    // ll.deleteTail();
    // ll.display();

    // }
}
