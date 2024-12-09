
public class FiftyFour {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.insertTail(1);
        ll.insertTail(2);
        ll.insertTail(3);
        ll.insertTail(4);
        ll.insertTail(5);

        RemoveNthNodeFromEndOfList rm = new RemoveNthNodeFromEndOfList();

        ll.head = rm.removeNthFromEnd(ll.head, 2);
        ll.display();
    }
}

class RemoveNthNodeFromEndOfList {

    public ListNode byReversing(ListNode head, int n) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode newHead = reversList(head), prev = null, cur = newHead;

        while (--n > 0) {
            prev = cur;
            cur = cur.next;
        }

        if (prev == null) {
            // 5 4 3 2 1
            prev = cur;

            prev = prev.next;
            cur.next = null;

            head = reversList(prev);
        } else {
            prev.next = cur.next;
            cur.next = null;

            head = reversList(newHead);
        }

        return head;
    }

    private ListNode reversList(ListNode head) {
        ListNode prev = null, cur = head, temp = null;

        while (cur != null) {
            temp = cur.next;

            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode left = dummyHead;
        ListNode right = head;
        // 1 2 3 4 5
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummyHead.next;
    }
}
