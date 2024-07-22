package Utils;

import Enity.Permission;
import Enity.Staff;

import java.util.List;

public class Auth {
    public static Staff user = null;
    public static List<String> permissions = null;

    public static void clear(){
        Auth.user = null;
        Auth.permissions = null;
    }
    public static boolean isLogin(){
        return Auth.user != null;
    }

    public static Staff getUser() {
        return user;
    }

    public static void setUser(Staff user) {
        Auth.user = user;
    }

    public static List<String> getPermissions() {
        return permissions;
    }

    public static void setPermissions(List<String> permissions) {
        Auth.permissions = permissions;
    }
}
