package Utils;


import Entity.Account;

public class Auth {
    public static Account user = null;


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
}
