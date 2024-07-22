package Enity;

public class RoleStaff {
    private int id;
    private int roleId;
    private String username;

    // Constructors
    public RoleStaff() {
    }

    public RoleStaff(int id, int roleId, String username) {
        this.id = id;
        this.roleId = roleId;
        this.username = username;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // toString method (optional for debugging)
    @Override
    public String toString() {
        return "RoleStaff{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", username='" + username + '\'' +
                '}';
    }
}
