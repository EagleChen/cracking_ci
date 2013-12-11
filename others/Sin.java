class Sin {
    private static Sin s = new Sin();
    private Sin() {}
    public static Sin getInstance() { return s; }
}

class Example {
    public static void main (String[] args) {
        Sin s = Sin.getInstance();
        Singleton a = Singleton.INSTANCE;
        a.print();
    }
}

enum Singleton {
    INSTANCE("abc");

    private String whatever;

    Singleton(String s) {
        whatever = s;
    }

    void print() {
        System.out.println(whatever);
    }
}
