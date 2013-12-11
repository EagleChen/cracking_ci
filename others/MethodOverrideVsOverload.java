public class MethodOverrideVsOverload {

    public boolean equals( MethodOverrideVsOverload other ) {
        System.out.println("MethodOverrideVsOverload equals method reached");
        return true;
    }

    public boolean equals(Object other ) {
        System.out.println(" this is override ");
        return true;
    }

    public static void main(String[] args) {
        Object o1 = new MethodOverrideVsOverload();
        Object o2 = new MethodOverrideVsOverload();

        MethodOverrideVsOverload o3 = new MethodOverrideVsOverload();
        MethodOverrideVsOverload o4 = new MethodOverrideVsOverload();

        System.out.println(o2.getClass());
        if(o1.equals(o2)){
            System.out.println("objects o1 and o2 are equal");
        }

        if(o3.equals(o4)){
            System.out.println("objects o3 and o4 are equal");
        }



        Parent a = new Son("a");
        Parent b = new Son("b");

        Son c = new Son("c");
        Son d = new Son("d");

        // 判断传入参数的类型是在编译期做的。。。
        a.say(b);
        c.say(d);
    }
}

class Parent {
    String pa;

    Parent(String p) {pa = p;}

    void say(Parent p) {
        System.out.println("parent says " + p.pa);
    }
}

class Son extends Parent {
    String pa;

    Son(String p) {super(p); pa = p; }

    @Override
    void say(Parent p) {
        System.out.println("son for parent says " + p.pa);
    }

    void say(Son p) {
        System.out.println("son says " + p.pa);
    }


}
