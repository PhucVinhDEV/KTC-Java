package org.example.Service;


import org.example.DTO.WarehouseAccountReponseeDTO;
import org.example.Entity.AccountWarehouse;

import java.util.List;

public interface AccountWareHouseService {
    /**
     * Tạo một liên kết giữa tài khoản và kho.
     *
     * @param accountWarehouse Đối tượng AccountWarehouse để tạo.
     */
    void createAccountWarehouse(AccountWarehouse accountWarehouse);

    /**
     * Cập nhật một liên kết giữa tài khoản và kho.
     *
     * @param accountWarehouse Đối tượng AccountWarehouse để cập nhật.
     */
    void updateAccountWarehouse(AccountWarehouse accountWarehouse);

    /**
     * Xóa một liên kết giữa tài khoản và kho.
     *
     * @param accountId ID của tài khoản.
     */
    void deleteAccountWarehouseWithaccountId(String accountId);


    /**
     * Xóa một liên kết giữa tài khoản và kho.
     *
     * @param warehouseId ID của tài khoản.
     */
    void deleteAccountWarehouseWithwarehouseId(String warehouseId);
    /**
     * Lấy danh sách tất cả các liên kết giữa tài khoản và kho.
     *
     * @return Danh sách các đối tượng WareHouseAccountReponseeDTO.
     */
    List<WarehouseAccountReponseeDTO> readWarehouses();

    /**
     * Lấy danh sách tất cả các liên kết giữa tài khoản và kho.
     * @param accountId
     * @return Danh sách các đối tượng WareHouseAccountReponseeDTO.
     */
    List<WarehouseAccountReponseeDTO> readWarehousesByAccountId(String accountId);

}
