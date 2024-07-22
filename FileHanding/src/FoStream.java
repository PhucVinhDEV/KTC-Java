import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FoStream {
    public static void WriteFile(String fileName, String data) {
        try {
            //Ghi de len file cu~ neu trung ten
            // nen bat exception
            FileOutputStream file = new FileOutputStream(fileName);
            for(String line : data.split("\n")) {}
            file.close();

        }catch (FileNotFoundException  e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static StringBuilder ReadFile(String fileName)  {
        FileInputStream fis = null;
        StringBuilder result = new StringBuilder();
        try {
            fis = new FileInputStream(fileName);

          //ghi noi dung
            int content;

            while ((content = fis.read()) != -1) {
                result.append((char) content);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                fis.close();
            }catch(IOException io){
                io.printStackTrace();
            }
        }
        return result;
    }
    public static void main(String[] args)  {
        // duong dan~
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap file name: ");
        String fileName = sc.nextLine();
        System.out.println("Nhap du lieu :");
        String data = sc.nextLine();
        WriteFile(fileName,data);

//        ReadFile(fileName);
        //Xoa file ne
//            Path path = Paths.get(filepath);
//            Files.delete(path);


    }
}
