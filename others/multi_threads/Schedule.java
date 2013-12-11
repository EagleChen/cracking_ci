import java.util.concurrent.*;

class Schedule implements Runnable {
    private final int index;
    private Seed seed;
    private Semaphore[] conditions;
    private final int total;

    public Schedule(int i, Seed s, Semaphore[] c, int t) {
        index = i;
        seed = s;
        conditions = c;
        total = t;
    }

    private void print() {
        System.out.println(index + " prints " + seed.value);
    }

    public void run() {
        while (true) {
            try {
                conditions[index].acquire();
                if (seed.value >= total) return;
                print();
                seed.incr();
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            } finally {
                int to = (index + 1) % conditions.length;
                System.out.println(index + " is going to release " + to);
                conditions[to].release();
            }
        }

    }

    public static void main (String[] args) throws InterruptedException {
        int total = 6;
        int thread_num = 3;

        Seed seed = new Seed(0);
        Thread[] threads = new Thread[thread_num];
        Semaphore[] conditions = new Semaphore[thread_num];

        for (int i = 0; i < thread_num; i++)
            conditions[i] = new Semaphore(0);

        for (int i = 0; i < thread_num; i++) {
            threads[i] = new Thread(new Schedule(i, seed, conditions, total));
            threads[i].start();
        }

        conditions[0].release();
        System.out.println("Run !");

        for (int i = 0; i < thread_num; i++)
            threads[i].join();
    }
}

class Seed {
   int value;

   Seed(int v) {
       value = v;
   }

   void incr() {
        value++;
    }
}
