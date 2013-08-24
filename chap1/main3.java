class Main3 {
    public static void removeDuplicates(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;

        int tail = 1;
        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) break;
            }
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
            System.out.println(j);
            System.out.println(tail);
            System.out.println(str);
        }
        str[tail] = '\0';
    }

    public static void main (String[] args) {
        char[] str = "abcdadf".toCharArray();
        System.out.println(str);

        Main3.removeDuplicates(str);
        for (char c : str)
            System.out.println(c);
    }
}
