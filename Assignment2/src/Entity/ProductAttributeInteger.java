package Entity;

public class ProductAttributeInteger {
    private String productId;
    private String attributeId;
    private int attributeValue;

    public ProductAttributeInteger(String productId, String attributeId, int attributeValue) {
        this.productId = productId;
        this.attributeId = attributeId;
        this.attributeValue = attributeValue;
    }

    public ProductAttributeInteger() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public int getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(int attributeValue) {
        this.attributeValue = attributeValue;
    }
}
