package model;

public class User {

    private int userId;

    private String username;

    private String password;

    private String fullName;

    private String role;

    private String status;

    // Empty Constructor
    public User() {
    }

    // Full Constructor
    public User(String username,
                String password,
                String fullName,
                String role,
                String status) {

        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
    }

    // GETTERS & SETTERS

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
    @Override
public int hashCode() {

    return Integer.hashCode(userId);
}

@Override
public boolean equals(Object obj) {

    if (this == obj)
        return true;

    if (obj == null || getClass() != obj.getClass())
        return false;

    User other = (User) obj;

    return userId == other.userId;
}
}