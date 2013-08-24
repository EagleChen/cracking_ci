class Main1 {
    public static void main (String[] args) {
        int[] arrA = new int[15];
        int[] tmp = { 2, 10, 30, 50, 55, 60, 70, 75, 80, 100 };
        System.arraycopy(tmp, 0, arrA, 0, 10);
        int[] arrB = { 1, 3, 10, 90, 103 };

        int i   = arrA.length - arrB.length - 1;
        int j   = arrB.length - 1;
        int pos = arrA.length - 1;
        while (i >= 0 && j >= 0) {
            if (arrB[j] >= arrA[i]) {
                arrA[pos--] = arrB[j--];
            } else {
                arrA[pos--] = arrA[i--];
            }
        }
        if (j >= 0)
            while (j >= 0) arrA[pos--] = arrB[j--];

        for (int n : arrA)
            System.out.print(" " + n);
        System.out.println();
    }
}
