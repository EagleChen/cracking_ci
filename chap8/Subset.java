import java.util.ArrayList;
import java.util.Arrays;

class Subset {
    static void find_subset(ArrayList<Integer> got, ArrayList<Integer> remain) {
        if (remain.size() == 0) return;
        int num = remain.get(0);
        ArrayList<Integer> newGot = new ArrayList<Integer>(got);
        newGot.add(num);

        System.out.print("Got subset : [");
        for (int i : newGot)
            System.out.print(String.format("%d ", i));
        System.out.println("]");

        ArrayList<Integer> newRemain = new ArrayList<Integer>(remain);
        newRemain.remove(0);
        find_subset(newGot, newRemain);
        remain.remove(0);
        find_subset(got, remain);
    }

    public static void main (String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 5, 7, 10));
        System.out.println("[]");
        Subset.find_subset(new ArrayList<Integer>(), arr);
    }
}
