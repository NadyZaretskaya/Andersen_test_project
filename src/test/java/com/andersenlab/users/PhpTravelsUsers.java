package com.andersenlab.users;

import java.util.Date;

public class PhpTravelsUsers {
    private Date date = new Date();
    private String adminLogin;
    private String adminPassword;
    private String baseUserName;
    private String baseUserLastName;
    private String baseUserPhone;
    private String baseUserEmail;
    private String baseUserPassword;


    public PhpTravelsUsers(String adminLogin, String adminPassword) {
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
    }

    public PhpTravelsUsers(String baseUserLastName, String baseUserName, String baseUserPhone, String baseUserEmail,
                           String baseUserPassword) {
        this.baseUserLastName = baseUserLastName;
        this.baseUserName = baseUserName;
        this.baseUserPhone = baseUserPhone;
        this.baseUserEmail = baseUserEmail + date.getTime() + "@example.com";
        this.baseUserPassword = baseUserPassword;

    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getBaseUserName() {
        return baseUserName;
    }

    public String getBaseUserLastName() {
        return baseUserLastName;
    }

    public String getBaseUserPhone() {
        return baseUserPhone;
    }

    public String getBaseUserEmail() {
        return baseUserEmail;
    }

    public String getBaseUserPassword() {
        return baseUserPassword;
    }

    public void setBaseUserPassword(String baseUserPassword) {
        this.baseUserPassword = baseUserPassword;
    }

}
