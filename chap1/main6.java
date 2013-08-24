class Main6 {
    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
            };

        int n = 4;

        for (int i = n/2 - 1; i >= 0; i--)
            for (int j = n-i-2; j >= i; j--) {
                int tmp1 = matrix[i][j];
                int tmp2 = matrix[n-1-j][i];
                matrix[n-1-j][i] = tmp1;

                tmp1 = tmp2;
                tmp2 = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = tmp1;

                tmp1 = tmp2;
                tmp2 = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp1;

                matrix[i][j] = tmp2;
            }

        Main6.printMatrix(matrix, n);
    }
}
