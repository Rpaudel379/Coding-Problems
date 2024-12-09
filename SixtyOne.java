/**
 * SixtyOne
 */
public class SixtyOne {

    public static void main(String[] args) {

    }
}

class ReverseNodesInKGroup {

    // k = 2
    // 1 -> 2 -> 3 -> 4 -> 5
    // 2 -> 1 -> 4 -> 3 -> 5
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyHead = new ListNode(-1, head);

        ListNode groupPrev = dummyHead;

        while (true) {
            ListNode kth = findKth(groupPrev, k);
            // no more k groups can be formed
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            // reverse the group
            ListNode curr = groupPrev.next;
            ListNode prev = groupNext;

            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }

        return dummyHead.next;
    }

    private ListNode findKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

}