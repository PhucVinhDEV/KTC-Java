package org.example.Implement;

import org.example.DAO.AttributeDAO;
import org.example.Entity.Attribute;
import org.example.Service.AttributeSerivce;

public class AttributeImplement implements AttributeSerivce {
    private AttributeDAO attributeDAO = new AttributeDAO();
    @Override
    public void CreateAttribute(Attribute attribute) {
        attributeDAO.save(attribute);
    }
}
