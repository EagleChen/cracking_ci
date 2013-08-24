class SimpleStack<T extends Comparable<T>> {
    Node<T> top;
    Node<T> min;
    int size;

    SimpleStack() {
        size = 0;
    }

    T min() {
        if (min != null)
            return min.value;
        else return null;
    }

    T pop() {
        if (top != null) {
            T v = top.value;
            top = top.next;
            min = min.next;
            size--;
            return v;
        } else return null;
    }

    void push(T v) {
        Node<T> n = new Node<T>(v);
        n.next = top;
        top = n;

        if (min != null) {
            T value = (min.value.compareTo(v) > 0) ? v : min.value;
            Node<T> m = new Node<T>(value);
            m.next = min;
            min = m;
        } else {
            Node<T> m = new Node<T>(v);
            min = m;
        }

        size++;
    }

    void print() {
        System.out.println("Stack is ==============>");
        Node n = top;
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }

        System.out.println("Stack min is ==============>");
        n = min;
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }

    static <K extends Comparable<K>> SimpleStack<K> makeStack(K... data) {
        SimpleStack<K> s = new SimpleStack<K>();
        for (K d : data) {
            s.push(d);
        }
        return s;
    }
}
