import java.util.*;

class Main6 {
    public static void main (String[] args) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(50);
            s1.push(num);
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();

        while (!s1.empty()) {
            int top = s1.pop();
            while (!s2.empty()) {
                int top2 = s2.pop();
                if (top < top2) {
                    s1.push(top2);
                } else {
                    s2.push(top2);
                    break;
                }
            }
            s2.push(top);
        }

        while(!s2.empty()) {
            System.out.print(s2.pop());
            System.out.print(" ");
        }
        System.out.println();
    }
}
