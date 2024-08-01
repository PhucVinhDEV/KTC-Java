package Entity;

public class AccountWarehouse {
    private String accountId;
    private String warehouseId;

    public AccountWarehouse(String accountId, String warehouseId) {
        this.accountId = accountId;
        this.warehouseId = warehouseId;
    }

    public AccountWarehouse() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
}
