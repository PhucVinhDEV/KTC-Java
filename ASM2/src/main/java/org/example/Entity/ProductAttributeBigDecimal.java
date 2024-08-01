package org.example.Entity;

import java.math.BigDecimal;

public class ProductAttributeBigDecimal {
    private String productId;
    private String attributeId;
    private BigDecimal attributeValue;

    public ProductAttributeBigDecimal(String productId, String attributeId, BigDecimal attributeValue) {
        this.productId = productId;
        this.attributeId = attributeId;
        this.attributeValue = attributeValue;
    }

    public ProductAttributeBigDecimal() {
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

    public BigDecimal getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(BigDecimal attributeValue) {
        this.attributeValue = attributeValue;
    }
}
