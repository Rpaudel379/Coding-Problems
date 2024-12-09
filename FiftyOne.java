public class FiftyOne {
    public static void main(String[] args) {

    }
}

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode prev = null;
        ListNode nextCur = null;

        while (current != null) {
            nextCur = current.next;

            current.next = prev;
            prev = current;
            current = nextCur;
        }

        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        return rec(head, null);
    }

    public ListNode rec(ListNode cur, ListNode prev) {

        if (cur == null) {
            return prev;
        }

        ListNode tmp = cur.next;
        cur.next = prev;
        return rec(tmp, cur);
    }

    // 1 2 3
    // rec(1, null)
    // 1st call - prev = null
    // 1st call - curr 1
    // 1st call - curr.next = null(prev)
    // 1st call - temp = 2
    // rec(2, 1)

    // 2nd call - prev = 1
    // 2nd call - curr = 2
    // 2nd call - curr.next = 1(prev)
    // 2nd call - temp = 3
    // rec(3, 2)

    // 3rd call - prev = 2
    // 3rd call - curr = 3
    // 3rd call - curr.next = 2(prev)
    // 3rd call - temp = null
    // rec(null, 3)

    // curr == null
    // return 3(prev)

}
