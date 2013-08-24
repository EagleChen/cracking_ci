import java.util.concurrent.*;
class Main5 {
    public static void main (String[] args) throws InterruptedException {
        class TempleRun implements Runnable {
            private Semaphore s1;
            private Semaphore s2;
            private int sleepTime;
            private String words;

            TempleRun(Semaphore si1, Semaphore si2, int t, String w) {
                s1 = si1;
                s2 = si2;
                sleepTime = t;
                words = w;
            }

            public void run() {
                try {
                    s1.acquire();
                    Thread.sleep(sleepTime);
                    System.out.println(words);
                    s2.release();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }


        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        Thread a = new Thread(new TempleRun(s1,s2, 5, "a"));
        Thread b = new Thread(new TempleRun(s2,s3, 2, "b"));
        Thread c = new Thread(new TempleRun(s3,s1, 0, "c"));
        Thread d = new Thread(new TempleRun(s1,s2, 5, "d"));
        Thread e = new Thread(new TempleRun(s2,s3, 2, "e"));
        Thread f = new Thread(new TempleRun(s3,s1, 0, "f"));
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
        a.join();
        b.join();
        c.join();
        d.join();
        e.join();
        f.join();
    }
}
