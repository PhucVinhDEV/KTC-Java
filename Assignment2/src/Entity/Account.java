package Entity;

public class Account {
    private String username;
    private String password;
    private String email;
    private int isAdmin;

    public Account(String username, String password, String name, int isAdmin) {
        this.username = username;
        this.password = password;
        this.email = name;
        this.isAdmin = isAdmin;
    }

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
