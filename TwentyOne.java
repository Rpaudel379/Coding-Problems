public class TwentyOne {
    public static void main(String[] args) {

        MinStackRevise stack = new MinStackRevise();

        stack.display();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.display();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}

class MinStack2 {

    class Node {
        int value;
        int min;
        Node next;

        private Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    private Node head;

    public MinStack2() {
        head = null;
    }

    public void push(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            newNode.min = val;
            return;
        }

        int minVal = Math.min(val, head.value);
        newNode.min = minVal;
        newNode.next = head;
        head = newNode;
    }

    public void pop() {

        if (this.head == null) {
            return;
        }

        head = head.next;

    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }

    public void display() {
        if (head == null) {
            System.out.println("empty stack");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

}

class MinStack {

    class Node {
        int value;
        Node next;

        private Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    private Node head;
    private Node minHead;

    public MinStack() {
        head = null;
    }

    public void push(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            minHead = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

        int minVal = head.value < minHead.value ? head.value : minHead.value;
        Node newNodeMin = new Node(minVal);
        newNodeMin.next = minHead;
        minHead = newNodeMin;

    }

    public void pop() {

        if (this.head == null) {
            return;
        }

        head = head.next;

        minHead = minHead.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return minHead.value;
    }

    public void display() {
        if (head == null) {
            System.out.println("empty stack");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

}

// revise

class MinStackRevise {

    class Node {
        int val;
        int min;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;

    public MinStackRevise() {
        head = null;
    }

    public void push(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            head.min = val;
        } else {
            newNode.next = head;

            System.out.println(val + " v " + head.min);
            int minVal = Math.min(val, head.min);
            System.out.println(minVal + " mv");
            newNode.min = minVal;
            head = newNode;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    public void display() {
        if (head == null) {
            System.out.println("empty stack");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

}