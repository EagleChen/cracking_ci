// longest increasing sequence
import java.util.*;

class Main7 {
    static void longest(Person[] persons) {
        // descending order
        Arrays.sort(persons);
        int[] result = new int[persons.length];
        int[] link = new int[persons.length];
        result[0] = 1;
        Arrays.fill(link, -1);

        for (int i = 1; i < persons.length; i++) {
            for (int j = 0; j < i; j++) {
                if (persons[j].weight > persons[i].weight &&
                    result[j] > result[i]) {
                    result[i] = result[j];
                    link[i] = j;
                }
            }
            result[i]++;
        }

        int max = 0;
        int last = -1;
        for (int i = 0; i < persons.length; i++) {
            if (max < result[i]) {
                max = result[i];
                last = i;
            }
        }

        while (last != -1) {
            persons[last].print();
            last = link[last];
        }
    }

    public static void main (String[] args) {
        ArrayList<Person> arr = new ArrayList<Person>();
//        arr.add(new Person(65, 100));
//        arr.add(new Person(70, 150));
//        arr.add(new Person(56, 90));
//        arr.add(new Person(75, 190));
//        arr.add(new Person(60, 95));
//        arr.add(new Person(68, 110));
        arr.add(new Person(12, 12));
        arr.add(new Person(11, 8));
        arr.add(new Person(10, 9));
        arr.add(new Person(9, 7));
        arr.add(new Person(8, 11));
        arr.add(new Person(7, 6));
        Main7.longest(arr.toArray(new Person[0]));
    }
}

class Person implements Comparable<Person> {
    int height;
    int weight;

    Person(int h, int w) {
        height = h;
        weight = w;
    }

    public int compareTo(Person other) {
        if (height == other.height)
            return other.weight - weight;
        return other.height - height;
    }

    void print() {
        System.out.println("(" + height + "," + weight + ")");
    }
}


