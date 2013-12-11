import java.util.*;

class Hash {
    int v = 0;

    @Override
    public int hashCode() {
        return v;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Hash)) return false;

        Hash t = (Hash)o;
        return v == t.v;
    }

    @Override
    public String toString() {
        return String.valueOf(v);
    }

    public static void main (String[] args) {
        Hash t = new Hash();
        Map<Hash, Integer> map = new HashMap<Hash , Integer>();
        map.put(t, 1);
        System.out.println(map.get(t));
        t.v = 5;
        // override the hashcode method will make this "get" fail
        // need to re-hash here
        System.out.println(map.get(t));  //null
        Hash t1 = map.keySet().toArray(new Hash[0])[0];
        System.out.println(t1 == t); // true
        System.out.println(map.containsKey(t)); //false
    }
}
