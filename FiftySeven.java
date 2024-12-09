import java.util.HashSet;

public class FiftySeven {
    public static void main(String[] args) {

    }
}

class DetectCycleLinkedList {
    public boolean usingFastAndSlowPointers(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public boolean usingHashSet(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            }

            set.add(cur);
            cur = cur.next;
        }

        return false;
    }
}