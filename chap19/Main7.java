class Main7 {
    static int getMaxSum(int[] arr) {
        int maxTail = 0;
        int maxAll  = 0;

        for (int i : arr) {
            maxTail += i;
            if (maxTail > maxAll) {
                maxAll = maxTail;
            }
            maxTail = maxTail < 0 ? 0 : maxTail;
        }

        return maxAll;
    }

    public static void main (String[] args) {
        int[] arr = new int[]{ 2, -8, 3, -2, 4, -10};

        System.out.println(Main7.getMaxSum(arr));
    }
}
