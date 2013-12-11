class CLoader {
    public static void main (String[] args) {
        ClassLoader cl = CLoader.class.getClassLoader();
        while (cl != null) {
            System.out.println(cl);
            cl = cl.getParent();
        }
    }
}
