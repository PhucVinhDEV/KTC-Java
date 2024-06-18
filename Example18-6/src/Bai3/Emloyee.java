package Bai3;

public class Emloyee {

    private String name;
    private String address;
    private double bonus;
    private String Jobtitle;
    private String Perfomance;
    private String ManegerProject;


   public  void getBonus(int bonus,String Jobtitle){
        System.out.println(Jobtitle + " Bonus:  " + bonus);
    }

    public void getPerfomance(String Jobtitle,String name, String Perfomance){
        System.out.println("Perfomance Report for " + Jobtitle + " " + name + " : " + Perfomance );
    }

    public void getJobtitle(String Jobtitle,String name, String ManegerProject){
        System.out.println( Jobtitle +" "+ name + "" + ManegerProject);
    }
}
