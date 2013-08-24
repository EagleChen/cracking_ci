class Fibo {
    static int nth(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("What the fuck are you doing?");
        else {
            if (n == 1 || n == 2) return 1;
            else return nth(n-1) + nth(n-2);
        }
    }

    public static void main (String[] args) {
        System.out.println(Fibo.nth(8));
    }
}
