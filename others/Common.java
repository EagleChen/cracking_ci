import java.util.*;

class Common {
    public static void hi() {
        System.out.println("what the ");
    }

    public static void main (String[] args) {
        int[] intArr = new int[] { 2, 5, 1, 3};
        Arrays.sort(intArr);
        System.out.println(Arrays.binarySearch(intArr, 3));
        System.out.println(Arrays.toString(intArr));

        List list = Collections.emptyList();
        Set emptySet = Collections.emptySet();
        System.out.println(list);
        System.out.println(emptySet);

        Common com = new Common();
        com.hi();
        Common.hi();
    }
}
