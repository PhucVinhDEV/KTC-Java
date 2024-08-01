package Entity;

import java.util.Date;

public class ProductAttributeDate {
    private String productId;
    private String attributeId;
    private Date attributeValue;

    public ProductAttributeDate(String productId, String attributeId, Date attributeValue) {
        this.productId = productId;
        this.attributeId = attributeId;
        this.attributeValue = attributeValue;
    }

    public ProductAttributeDate() {
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

    public Date getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(Date attributeValue) {
        this.attributeValue = attributeValue;
    }
}
