package ra.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class User implements Serializable {
    private int userId;
    private String name;
    private String userName;
    private String email;
    private String password;
    private String rePassword;
    private String address;
    private String phone;
    private Boolean status;
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(int userId,String name, String userName, String email, String password, String rePassword, String address, String phone, Boolean status, Set<Role> roles) {
        this.userId = userId;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.roles = roles;
    }

    public User(int id,String name, String userName, String email, String password, String rePassword, Set<Role> roleSet,boolean status) {
        this.userId= id;
        this.name = name;
        this.userName = userName;
        this.email= email;
        this.password= password;
        this.rePassword = rePassword;
        this.roles = roleSet;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("name='" + name + "'")
                .add("userName='" + userName + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("rePassword='" + rePassword + "'")
                .add("address='" + address + "'")
                .add("phone='" + phone + "'")
                .add("status=" + status)
                .add("roles=" + roles)
                .toString();
    }
}
