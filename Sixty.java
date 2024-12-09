public class Sixty {
    public static void main(String[] args) {

    }
}

class MergeKSortedLists {

    // O(N*K)
    // O(1)
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeSort(lists, 0, lists.length - 1);
    }

    // 2 3 1 4 2
    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        ListNode left = mergeSort(lists, start, mid);
        ListNode right = mergeSort(lists, mid + 1, end);

        return merge(left, right);
    }

    // O(N*K)
    // O(1)
    public ListNode mergeKListsIterative(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = lists[0];

        for (int i = 1; i < lists.length; i++) {
            head = merge(head, lists[i]);
        }

        return head;
    }

    public ListNode merge(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode tail = head;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 != null ? l1 : l2;

        return head.next;
    }

}