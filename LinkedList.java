
public class LinkedList {

    ListNode head = null;
    ListNode tail = null;

    public LinkedList() {
        head = null;
    }

    public void insertHead(int value) {
        ListNode newNode = new ListNode(value);

        if (this.head == null || this.tail == null) {
            this.head = newNode;
            this.tail = this.head;
            return;
        }

        newNode.next = this.head;
        this.head = newNode;

    }

    public void insertTail(int value) {
        ListNode newNode = new ListNode(value);

        if (this.head == null || this.tail == null) {
            this.head = newNode;
            this.tail = this.head;
        }

        this.tail.next = newNode;
        this.tail = newNode;

    }

    public void display() {
        ListNode currNode = this.head;

        if (currNode == null) {
            System.out.println("List empty");
        } else {
            while (currNode != null) {
                System.out.print(currNode.val + " ");
                currNode = currNode.next;
            }
        }

        System.out.println();
    }

}
