package org.example.DTO;

public class WarehouseAccountReponseeDTO {
    private String username;
    private String email;
    private String warehouseName;
    private String warehouseId;

    public WarehouseAccountReponseeDTO(String username, String email, String warehouseName, String warehouseId) {
        this.username = username;
        this.email = email;
        this.warehouseName = warehouseName;
        this.warehouseId = warehouseId;
    }

    public WarehouseAccountReponseeDTO() {
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public String toString() {
        return "WarehouseAccountReponseeDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", warehouseId='" + warehouseId + '\'' +
                '}';
    }
}
