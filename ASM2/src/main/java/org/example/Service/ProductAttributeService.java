package org.example.Service;

import org.example.Entity.ProductAttributeBigDecimal;
import org.example.Entity.ProductAttributeDate;
import org.example.Entity.ProductAttributeInteger;
import org.example.Entity.ProductAttributeString;

import java.util.List;

public interface ProductAttributeService {
    void saveProductAttributeBigDecimal(ProductAttributeBigDecimal productAttribute);
    ProductAttributeBigDecimal findProductAttributeBigDecimalById(String productId, String attributeId);
    List<ProductAttributeBigDecimal> findAllProductAttributesBigDecimal();
    void updateProductAttributeBigDecimal(ProductAttributeBigDecimal productAttribute);
    void deleteProductAttributeBigDecimal(String productId, String attributeId);

    void saveProductAttributeDate(ProductAttributeDate productAttribute);
    ProductAttributeDate findProductAttributeDateById(String productId, String attributeId);
    List<ProductAttributeDate> findAllProductAttributesDate();
    void updateProductAttributeDate(ProductAttributeDate productAttribute);
    void deleteProductAttributeDate(String productId, String attributeId);

    void saveProductAttributeInt(ProductAttributeInteger productAttribute);
    ProductAttributeInteger findProductAttributeIntById(String productId, String attributeId);
    List<ProductAttributeInteger> findAllProductAttributesInt();
    void updateProductAttributeInt(ProductAttributeInteger productAttribute);
    void deleteProductAttributeInt(String productId, String attributeId);

    void saveProductAttributeString(ProductAttributeString productAttribute);
    ProductAttributeString findProductAttributeStringById(String productId, String attributeId);
    List<ProductAttributeString> findAllProductAttributesString();
    void updateProductAttributeString(ProductAttributeString productAttribute);
    void deleteProductAttributeString(String productId, String attributeId);
}
