package chap2;

class Main1 {
    static void removeDup(Node head) {
        Node n = head;
        boolean moved = false;
        while (n.next != null) {
            moved = false;
            Node check = head;
            while (check != n.next) {
                if (check.value == n.next.value) {
                    n.next = n.next.next;
                    moved = true;
                    break;
                } else {
                    check = check.next;
                }
            }
            if (!moved) n = n.next;
        }
    }

    public static void main (String[] args) {
        Node head = Node.makeSingleList(1, 3, 1, 4, 5, 4, 2);
        Main1.removeDup(head);
        Node.printList(head);
    }
}
