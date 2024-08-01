package org.example.Entity;

public class Product {
    private String productId;
    private String productName;
    private String warehouseId;

    public Product(String productId, String productName, String warehouseId) {
        this.productId = productId;
        this.productName = productName;
        this.warehouseId = warehouseId;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
}
