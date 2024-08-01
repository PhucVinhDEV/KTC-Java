package Service;

import Entity.WareHouse;

import java.util.List;

public interface WareHouseService {



    /**
     * Tạo một kho mới.
     *
     * @param warehouse Đối tượng WareHouse để tạo.
     * @return Đối tượng WareHouse đã được tạo.
     */
    WareHouse createWarehouse(WareHouse warehouse);

    /**
     * Lấy danh sách tất cả các kho.
     *
     * @return Danh sách các đối tượng WareHouse.
     */
    List<WareHouse> findAll();

    /**
     * Tìm kiếm một kho dựa trên ID.
     *
     * @param id ID của kho.
     * @return Đối tượng WareHouse nếu tìm thấy, ngược lại trả về null.
     */
    WareHouse findById(String id);

    /**
     * Tìm kiếm một kho dựa trên tên kho.
     *
     * @param warehouseName Tên của kho.
     * @return Đối tượng WareHouse nếu tìm thấy, ngược lại trả về null.
     */
    WareHouse findByWareHouseName(String warehouseName);

    /**
     * Cập nhật thông tin của một kho.
     *
     * @param warehouse Đối tượng WareHouse để cập nhật.
     */
    void updateWarehouse(WareHouse warehouse);

    /**
     * Xóa một kho dựa trên ID.
     *
     * @param id ID của kho.
     */
    void deleteWarehouse(String id);

    /**
     * Lấy danh sách các kho ko có User
     *
     *
     */
    List<WareHouse> getAllWarehousesisNotUser();
}
