class Main1 {
    public static void main (String[] args) {
        boolean[] exist = new boolean[256];
        String s = "abckdfl";
        for (char c : s.toCharArray()) {
            int i = (int)c;
            if (exist[i]) {
                System.out.println("found");
                return;
            }
            exist[i] = true;
        }
        System.out.println("not found");
        System.out.println(Integer.MAX_VALUE);
    }
}
