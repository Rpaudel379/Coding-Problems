public class FiftySix {
    public static void main(String[] args) {

    }
}

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode cur = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {

            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = carry + val1 + val2;

            ListNode newNode = new ListNode(sum);
            cur.next = newNode;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            cur = cur.next;
        }

        return head.next;
    }
}