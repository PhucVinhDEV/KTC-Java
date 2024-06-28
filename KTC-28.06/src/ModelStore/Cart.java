package ModelStore;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //Khởi tạo listSanPham rỗng
    List<Product> listProduct = new ArrayList<Product>();

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public void addProduct(Product product) {
        listProduct.add(product);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : listProduct) {
            totalPrice += product.getProductPrice();
        }
        return totalPrice;
    }

    public void deleteProduct(Product product) {
        listProduct.remove(product);
    }

    public void PrinfAllProduct(){
        for (Product product : listProduct) {
            System.out.println( product.getProductID()+ " | " + product.getProductName()+ " | " + product.getProductPrice() + "|" + Product.storeName);
        }
    }
}
