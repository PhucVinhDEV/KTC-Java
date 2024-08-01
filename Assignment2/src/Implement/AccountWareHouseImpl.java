package Implement;

import DAO.AccountWarehouseDAO;
import DTO.WarehouseAccountReponseeDTO;
import Entity.AccountWarehouse;
import Service.AccountWareHouseService;

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
}
