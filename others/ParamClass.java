public class ParamClass {
    public static class A {
        void print(A a) {
            System.out.println("A: param is of class A");
        }
    }

    public static class B extends A {
        void print(A a) {
            System.out.println("B: param is of class A");
        }

        void print(B b) {
            System.out.println("B: param is of class B");
        }
    }

    public static void main (String[] args) {
        A a = new B();
        B b = new B();

        System.out.println(a.getClass());
        System.out.println(b.getClass());
        a.print(a);
        a.print(b);
        b.print(a);
        b.print(b);
    }
}
