import java.util.*;
import java.lang.ref.WeakReference;

class Reference {
    static class Refer {
        String name;

        Refer(String n) {
            name = n;
        }

        protected void finalize() {
            System.out.println(name + " : Good bye cruel world");
        }
    }

    public static void main (String[] args) {
        HashMap<Refer, Integer> cache = new HashMap<Refer, Integer>();
        Refer a = new Refer("refer a");
        cache.put(a, 50);
        a = null;
        System.gc();
        for(Refer r: cache.keySet())
            System.out.println(r.name); // so the object is still there

        System.out.println("testing weakhashmap");
        WeakHashMap<Refer, Integer> weakCache = new WeakHashMap<Refer, Integer>();
        Refer b = new Refer("refer b");
        weakCache.put(b, 20);
        b = null; //this will make the key collected by gc
        for(Refer r: weakCache.keySet())
            System.out.println(r.name); // it's likely that the object is still there
        System.gc();
        for(Refer r: weakCache.keySet())
            System.out.println(r.name); // it's likely that nothing will be printed here

        System.out.println("testing weak Reference");
        HashMap<WeakReference<Refer>, Integer> weakRefCache = new HashMap<WeakReference<Refer>, Integer>();
        Refer c = new Refer("refer c");
        WeakReference<Refer> cWeakRef = new WeakReference<Refer>(c);
        weakRefCache.put(cWeakRef, 20);
        c = null;
        for(WeakReference<Refer> r: weakRefCache.keySet())
            System.out.println(r.get().name); // it's likely that the object is still there
        System.gc();
        for(WeakReference<Refer> r: weakRefCache.keySet()) {
            System.out.println(r); // the reference is there
            System.out.println(r.get() == null); // it's likely this will be "true", the object is collected by gc
        }
        System.gc();
        for(WeakReference<Refer> r: weakRefCache.keySet()) {
            System.out.println(r); // the reference is there
            System.out.println(r.get() == null); // it's likely this will be "true", the object is collected by gc
        }
    }
}
