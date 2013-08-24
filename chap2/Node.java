package chap2;

class Node {
    int value;
    Node next = null;

    Node(int data) {value = data;}

    void appendToTail(int v) {
        Node n = this;
        while(n.next != null) n = n.next;
        n.next = new Node(v);
    }

    public String toString() {
        return String.valueOf(value);
    }

    static void printList(Node head) {
        StringBuffer sb = new StringBuffer();
        Node n = head;
        while (n != null) {
            sb.append(n.toString());
            sb.append(" --> ");
            n = n.next;
        }
        sb.delete(sb.length() - 5, sb.length() - 1);
        System.out.println(sb);
    }

    static Node deleteNode(Node head, int v) {
        if (head.value == v) head = head.next;
        else {
            Node n = head;
            while (n.next != null) {
                if (n.next.value == v)
                    n.next = n.next.next;
                n = n.next;
            }
        }

        return head;
    }

    static Node makeSingleList(int... args) {
        if (args.length == 0) return null;
        Node head = new Node(args[0]);
        for (int i = 1; i < args.length; i++)
            head.appendToTail(args[i]);

        return head;
    }
}
