package Implement;

import DAO.WarehouseDAO;
import Entity.WareHouse;
import Service.WareHouseService;

import java.util.List;

public class WareHouseImplement implements WareHouseService {
    private WarehouseDAO warehouseDAO = new WarehouseDAO();

    @Override
    public WareHouse createWarehouse(WareHouse warehouse) {
        warehouseDAO.save(warehouse);
        return warehouse;
    }

    @Override
    public List<WareHouse> findAll() {
        return warehouseDAO.findAll();
    }

    @Override
    public WareHouse findById(String id) {
        return warehouseDAO.findById(id);
    }

    @Override
    public WareHouse findByWareHouseName(String name) {
        return warehouseDAO.findByWarehouseName(name);
    }


    @Override
    public void updateWarehouse(WareHouse warehouse) {
        warehouseDAO.update(warehouse);
    }

    @Override
    public void deleteWarehouse(String id) {
        warehouseDAO.delete(id);
    }

    @Override
    public List<WareHouse> getAllWarehousesisNotUser() {
        return warehouseDAO.findWarehousesWithoutUsers();
    }
}
