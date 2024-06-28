import ModelStore.Cart;
import ModelStore.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingAPP {
    public static void main(String[] args) {
        //Tạo Cart
        Cart c = new Cart();

        Product p = new Product(1,"Xe đạp",1500000);
        Product p2 = new Product(2,"Xe máy",1500000);
        Product p3 = new Product(3,"Xe tăng",1500000);

        //Phương thức add Product
        c.addProduct(p);
        c.addProduct(p2);
        c.addProduct(p3);

        c.PrinfAllProduct();
        System.out.println("Tổng giá sản phẩm là : " + c.getTotalPrice());
        //phương thức xóa product khỏi cart
        c.deleteProduct(p);
        System.out.println("sau khi xóa");
        //Phương thức in ra tât cả Product đang có trong cart
        c.PrinfAllProduct();
        System.out.println("Tổng giá sản phẩm là : " + c.getTotalPrice());
    }
}
