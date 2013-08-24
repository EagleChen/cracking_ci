import java.util.*;

class BinaryTree {
    Node root;

    BinaryTree() {root = null;}
    BinaryTree(Node n) {root = n;}

    static void preOrder(Node n) {
        n.print();
        if (n.left != null) {
            preOrder(n.left);
        }
        if (n.right != null) {
            preOrder(n.right);
        }
    }

    static void inOrder(Node n) {
        if (n.left != null) {
            inOrder(n.left);
        }
        n.print();
        if (n.right != null) {
            inOrder(n.right);
        }
    }

    static void postOrder(Node n) {
        if (n.left != null) {
            postOrder(n.left);
        }
        if (n.right != null) {
            postOrder(n.right);
        }
        n.print();
    }

    static BinaryTree build(int... args) {
        BinaryTree bt = new BinaryTree();
        for (int v : args)
            bt.insert(new Node(v));
        return bt;
    }

    void bfs() {
        System.out.print("Breadth-first search: ");
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            current.print();
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    void dfs() {
        System.out.print("Depth-first search: ");
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            current.print();
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        System.out.println();
    }

    // this is for binary search tree
    void insert(Node n) {
        Node current = root;
        int where = 0; // 0 left, 1 right
        if (current == null) {
            root = n;
            return;
        }
        while (current != null) {
            if (current.compareTo(n) > 0) {
                if (current.left == null) {
                    current.left = n;
                    break;
                } else current = current.left;
            } else {
                if (current.right == null) {
                    current.right = n;
                    break;
                } else current = current.right;
            }
        }
    }

    static class Node implements Comparable<Node> {
        Node left;
        Node right;
        int value;

        Node(int v) {value = v;}

        void print() {
            System.out.print(value + "  ");
        }

        public int compareTo(Node other) {
            return value - other.value;
        }
    }

    public static void main (String[] args) {
        BinaryTree t = BinaryTree.build(5, 3, 18, 1, 6, 2, 29, 4);
        t.bfs();
        t.dfs();
    }
}
