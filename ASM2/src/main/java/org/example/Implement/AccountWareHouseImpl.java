package org.example.Implement;

import org.example.DAO.AccountWarehouseDAO;
import org.example.DTO.WarehouseAccountReponseeDTO;
import org.example.Entity.AccountWarehouse;
import org.example.Service.AccountWareHouseService;

import java.util.List;

public class AccountWareHouseImpl implements AccountWareHouseService {
   private AccountWarehouseDAO accountWarehouseDAO = new AccountWarehouseDAO();
    @Override
    public void createAccountWarehouse(AccountWarehouse accountWarehouse) {
        accountWarehouseDAO.save(accountWarehouse);
    }

    @Override
    public void updateAccountWarehouse(AccountWarehouse accountWarehouse) {
        accountWarehouseDAO.update(accountWarehouse);
    }

    @Override
    public void deleteAccountWarehouseWithaccountId(String accountId) {
            accountWarehouseDAO.deleteAccountWarehouseWithAccountId(accountId);
    }

    @Override
    public void deleteAccountWarehouseWithwarehouseId(String warehouseId) {
            accountWarehouseDAO.deleteAccountWarehouseWithWarehouseId(warehouseId);
    }

    @Override
    public List<WarehouseAccountReponseeDTO> readWarehouses() {
        return accountWarehouseDAO.readWareHouse();
    }

    @Override
    public List<WarehouseAccountReponseeDTO> readWarehousesByAccountId(String accountId) {
        return List.of();
    }
}
