package Lambda;

public interface BaseInterface {
    Integer timX(int x , int y);

    default void dontSayHello(){
        System.out.println("Don't say hello");
    }

    static void dontSayHello2(){
        System.out.println("Don't say hello2");
    }
}
