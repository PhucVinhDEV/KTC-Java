import java.util.Scanner;

public class HelloWorld {
    /*
    Author : BitzNomad
    Time : 17/06/2024
    Hàm : In ra chuỗi đc nhập vào từ bàn phím
    @Param String input : chuỗi được nhập vào
     */
    static void PrintTypedString(){
        System.out.println("Lession 2");
        System.out.print(" Input :");

        //Library input data from Client
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Your String :" +input);
    }


    public static void main(String[] args) {

//        //Bài 1
//        System.out.println("Lession 1");
//        System.out.println("Hello World");
//        System.out.println("I am learning Java");


//        //Call funtion printf data
//        PrintTypedString();

//        Tuan tuan = new Tuan();
//
//       switch (tuan.age){
//           case 10:
//               break;
//               case 20:
//                   System.out.println("case 20");
//                   break;
//           default:
//               System.out.println("default case");
//               break;
//       }
//        int[] array = {1,2,3,4};
//
//       for (int i = 0; i < array.length; i++) {
//           System.out.println(array[i]);
//       }
//
//        for (int i: array) {
//            System.out.println(i);
//        }
//
//        while (tuan.age == 20){
//            tuan.age++;
//            System.out.println("Tuấn age"+ tuan.age);
//        }


//        ConCuaTuan conCuaTuan = new ConCuaTuan();
//        conCuaTuan.Antoi();
//        conCuaTuan.antrua();

//        ChauCuaTuan cCuaTuan = new ChauCuaTuan();
//        cCuaTuan.Antoi();
//        cCuaTuan.AnSang();


        Tuan testTuan = new ChauCuaTuan();
        testTuan.Antoi();
    }
}
