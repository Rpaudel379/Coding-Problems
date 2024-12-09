public class FiftyTwo {
    public static void main(String[] args) {

    }
}

class MergeTwoSortedLists {

    public ListNode rec(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = rec(list1.next, list2);
            return list1;
        } else {
            list2.next = rec(list2.next, list1);
            return list2;
        }
    }

    public ListNode usingDummyNode(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        tail.next = list1 == null ? list2 : list1;

        return head.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = list2;

        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        ListNode tail = head;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // if one list node is empty
        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }

        return head;
    }
}