import java.util.Random;

class Main2 {
    static void randomize(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = r.nextInt(arr.length - i) + i;
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main (String[] args) {
        int[] cards = new int[]{ 1, 2, 3, 4, 5};
        Main2.randomize(cards);
    }
}
