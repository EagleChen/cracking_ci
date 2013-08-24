class SimpleQueue<T> {
    Node<T> head, tail;
    int size;

    SimpleQueue() {
        size = 0;
    }

    T dequeue() {
        if (head != null) {
            T v = head.value;
            head = head.next;
            size--;
            return v;
        } else return null;
    }

    void enqueue(T v) {
        Node<T> n = new Node<T>(v);
        if (tail != null)
            tail.next = n;
        else {
            head = n;
        }
        tail = n;
        size++;
    }
}
