import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
class Parentheses {
    static String makeString(String str, int pos) {
        String pre = str.substring(0, pos);
        String post = str.substring(pos);
        return "(" + pre + ")" + post;
    }
    static String[] subsets(int num) {
        if (num <= 0)
            throw new IllegalArgumentException("What the fuck are you doing?");
        if (num == 1)
            return new String[] { "()" };
        else {
            String[] subs = subsets(num-1);
            ArrayList<String> result = new ArrayList<String>();
            for (String sub : subs) {
                int level = 0;
                for (int i = 0; i < sub.length(); i++) {
                    if (level == 0)
                        result.add(makeString(sub, i));
                    if (sub.charAt(i) == '(') level++;
                    else level--;
                }
                result.add(makeString(sub, sub.length()));
            }
            return result.toArray(new String[0]);
        }
    }

    static void printPar(int l, int r, char[] str, int count) {
        if (l < 0 || r < l) return; // invalid state
        if (l == 0 && r == 0)
            System.out.println(str); // found one, so print it
        else {
            if (l > 0) { // try a left paren, if there are some available
                str[count] = '(';
                printPar(l - 1, r, str, count + 1);
            }
            if (r > l) { // try a right paren, if there’s a matching left
                str[count] = ')';
                printPar(l, r - 1, str, count + 1);
            }
        }
    }

    static void printPar(int count) {
        char[] str = new char[count*2];
        printPar(count, count, str, 0);
    }

    public static void main (String[] args) {
        for (String r : new HashSet<String>(Arrays.asList(Parentheses.subsets(Integer.parseInt(args[0])))))
            System.out.println(r);

        System.out.println("the following should be valid");
        Parentheses.printPar(Integer.parseInt(args[0]));
    }
}
