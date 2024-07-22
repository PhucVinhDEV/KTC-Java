package Base64;

import java.util.Base64;

public class Base64Main {
    public static void main(String[] args) {
        String originalInput = "Hello, World!";
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(originalInput.getBytes());

        System.out.println("Original Input: " + originalInput);
        System.out.println("Encoded String: " + encodedString);

        Base64.Decoder decoder = Base64.getDecoder();
        String decodedString = new String(decoder.decode(encodedString));
        System.out.println("Decoded String: " + decodedString);

        Base64.Encoder decoder1 = Base64.getMimeEncoder();
        String mimeString = "Ở đời có làm thì mới có ăn ko làm mà đòi có ăn thì ăn bầu đuồi , ăn cớt !";

        String encodedString1 = decoder1.encodeToString(mimeString.getBytes());
        System.out.println(encodedString1);
        Base64.Decoder decoder2 = Base64.getMimeDecoder();

        String decodedString2 = "Ci0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tRWFzdGVyIGVnZy0tLS0tLS0tLS0tLS0tLS0tLS0tLS0t\n" +
                "ClRyb25nIG3DoyBow7NhIEJhc2U2NCwgxJHhu5kgZMOgaSBj4bunYSBjaHXhu5dpIMSRxrDhu6Nj\n" +
                "IG3DoyBow7NhIMSR4bqndSByYSBwaOG6o2kgbMOgIGLhu5lpIHPhu5EgY+G7p2EgMy4KTuG6v3Ug\n" +
                "a2jDtG5nIMSR4bunLCDEkeG6p3UgcmEgc+G6vSDEkcaw4bujYyDEkeG7h20gYuG6sW5nIGPDoWMg\n" +
                "a8O9IHThu7EgcGFkIGLhu5Ugc3VuZyAoZOG6pXUgPSkuClRhIGPDsyB0aOG7gyBi4buPIGThuqV1\n" +
                "ID0gYuG6sW5nIGPDoWNoIHPhu60gZOG7pW5nIHdpdGhvdXRQYWRkaW5nIG5oxrAgc2F1OiBCYXNl\n" +
                "NjQuZ2V0RW5jb2RlcigpLndpdGhvdXRQYWRkaW5nKCkuZW5jb2RlVG9TdHJpbmcoc3RyLmdldEJ5\n" +
                "dGVzKCkp";
        String decodemime = new String(decoder2.decode(decodedString2));
        System.out.println("Decoded String: " + decodemime);
    }
}
