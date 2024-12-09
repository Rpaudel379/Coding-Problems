// Reorder List, leetcode 143
// 1 -> 4 -> 2 - >3
// 1 -> 3 -> 4 -> 2

public class FiftyThree {
    public static void main(String[] args) {

    }

}

class ReorderList {

    // O(n)
    // O(1)
    public void reorderList(ListNode head) {

        // find the middle of the list
        // split them
        // reverse second half
        // merge them

        // find middle of the list
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // the middle point
        ListNode second = slow.next;

        // split them
        slow.next = null;

        // reverse second half
        // initially, head of the second half will point to node as it will be reversed
        ListNode prev = null;

        while (second != null) {
            ListNode curNext = second.next;

            second.next = prev;
            prev = second;
            second = curNext;
        }

        // prev, now is the head of the second half

        // merge them
        ListNode first = head;
        second = prev; // reassigning second to where prev is pointing
        // 1 2 3 6 | 5 4
        while (second != null) {
            ListNode firstNext = first.next; // 3
            ListNode secondNext = second.next; // null  

            first.next = second; // 
            second.next = firstNext;

            first = firstNext; // 2 
            second = secondNext;// 4
        }

        // 1 5 2 4 3
    }
}
