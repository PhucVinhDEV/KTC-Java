package Test;

public class Dog {
    public String type="123qwe";

    public  Dog(String type){
        this.type=type;
        this.printText();
        System.out.println("I am a "+ type);
    }
    public void printText(){
        System.out.println("printext");
    }
}
