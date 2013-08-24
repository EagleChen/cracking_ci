class Main1 {
    private class Node {
        int prev;
        int value;
        Node(int v, int p) {
            value = v;
            prev = p;
        }
    }

    int STACKSIZE = 5;
    int[] stackPointer = {-1, -1, -1};
    Node[] buffer = new Node[STACKSIZE * 3];

    int pop(int index) {
        int bufIndex = stackPointer[index];
        int value = buffer[bufIndex].value;
        stackPointer[index] = buffer[bufIndex].prev;
        buffer[bufIndex] = null;
        return value;
    }

    void push(int index, int value) {
        int bufIndex = 0;
        while (bufIndex < buffer.length && buffer[bufIndex] != null)
            bufIndex++;
        if (bufIndex >= buffer.length) return;
        buffer[bufIndex] = new Node(value, stackPointer[index]);
        stackPointer[index] = bufIndex;
    }

    int top(int index) {
        if (stackPointer[index] != -1)
            return buffer[stackPointer[index]].value;
        else return -1;
    }

    boolean isEmpty(int index) {
        return stackPointer[index] == -1;
    }

    void print() {
        for (int i = 0; i < buffer.length; i++) {
            System.out.print((buffer[i] == null) ? -1 : buffer[i].value);
            System.out.print("  ");
        }
        System.out.println();
    }

    public static void main (String[] args) {
        Main1 m = new Main1();
        m.push(0, 0);
        m.push(1, 1);
        m.push(2, 2);
        m.push(0, 3);
        m.push(1, 4);
        m.push(2, 5);
        m.pop(1);
        m.print();
        System.out.println(m.top(0));
        System.out.println(m.top(1));
        System.out.println(m.top(2));

        m.push(2, 6);
        m.push(1, 7);
        m.print();
        System.out.println(m.top(0));
        System.out.println(m.top(1));
        System.out.println(m.top(2));
    }
}
