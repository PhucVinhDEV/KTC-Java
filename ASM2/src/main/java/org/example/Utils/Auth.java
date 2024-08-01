package org.example.Utils;


import org.example.DAO.AccountWarehouseDAO;
import org.example.Entity.Account;
import org.example.Entity.AccountWarehouse;

import java.util.List;

public class Auth {
    public static Account user = null;
    private static final AccountWarehouseDAO accountWarehouseDAO = new AccountWarehouseDAO();

    public static void clear(){
        Auth.user = null;
    }

    public static boolean isLogin(){
        return Auth.user != null;
    }

    public static Account getUser() {
        return user;
    }

    public static void setUser(Account user) {
        Auth.user = user;
    }

    public static boolean canAccessWarehouse(String warehouseId) {
        if (user == null) {
            return false;
        }

        if (user.getIsAdmin() == 1) {
            return true;
        }

        List<AccountWarehouse> warehouses = accountWarehouseDAO.findByAccountId(user.getUsername());
        for (AccountWarehouse warehouse : warehouses) {
            if (warehouse.getWarehouseId().equals(warehouseId)) {
                return true;
            }
        }

        return false;
    }

    public static List<AccountWarehouse> getUserWarehouses() {
        if (user == null) {
            throw new RuntimeException("User is not logged in");
        }

        return accountWarehouseDAO.findByAccountId(user.getUsername());
    }
}
