package model;

import java.sql.Date;

public class User {
    private int id;
    private String userName;
    private String password;
    private String name;
    private Date dob;
    private Gender gender;
    private String phone;
    private String email;
    private String address;
    private String cccd;
    private Role role;


    public User() {
    }

    public User(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public User(int id, String name, Date dob, Gender gender, String phone, String email, String address, String cccd) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.cccd = cccd;
    }

    public User(String userName, String password, String name, Date dob, Gender gender, String phone, String email, String address, String cccd) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.cccd = cccd;
    }

    public User(int id, String userName, String password, String name, Date dob, Gender gender, String phone, String email, String address, String cccd, Role role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.cccd = cccd;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
