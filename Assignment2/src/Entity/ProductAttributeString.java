package Entity;

public class ProductAttributeString {
    private String productId;
    private String attributeId;
    private String attributeValue;

    public ProductAttributeString(String productId, String attributeId, String attributeValue) {
        this.productId = productId;
        this.attributeId = attributeId;
        this.attributeValue = attributeValue;
    }

    public ProductAttributeString() {
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

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
