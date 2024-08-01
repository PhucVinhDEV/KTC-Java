package org.example.Service;

import org.example.Entity.Product;

import java.util.List;

public interface ProductService {
    /**
     * Lưu một sản phẩm mới vào cơ sở dữ liệu.
     *
     * @param product Sản phẩm cần được lưu.
     */
    void saveProduct(Product product);

    /**
     * Tìm một sản phẩm theo ID của nó.
     *
     * @param productId ID của sản phẩm cần tìm.
     * @return Sản phẩm với ID được cung cấp, hoặc null nếu không tìm thấy.
     */
    Product findProductById(String productId);

    /**
     * Tìm một sản phẩm theo Tên của nó.
     * @param productname
     * @return Sản phẩm với Name được cung cấp, hoặc null nếu ko tìm thấy
     */
    Product findProductByProductName(String productname);
    /**
     * Lấy tất cả sản phẩm từ cơ sở dữ liệu.
     *
     * @return Danh sách tất cả các sản phẩm.
     */
    List<Product> findAllProducts();

    /**
     * Cập nhật một sản phẩm hiện có trong cơ sở dữ liệu.
     *
     * @param product Sản phẩm với các chi tiết đã được cập nhật.
     */
    void updateProduct(Product product);

    /**
     * Xóa một sản phẩm khỏi cơ sở dữ liệu theo ID của nó.
     *
     * @param productId ID của sản phẩm cần xóa.
     */
    void deleteProduct(String productId);
}
