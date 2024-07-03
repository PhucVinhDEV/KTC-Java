public interface MyInterface {
    default void myMethod(){
        System.out.println("My Method");
    }
    static String myStaticMethod(String name) {
        System.out.println("This is a static method.");
        return name;
    }
}
