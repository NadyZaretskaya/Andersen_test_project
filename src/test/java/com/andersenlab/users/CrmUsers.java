package com.andersenlab.users;

public class CrmUsers {
    private String adminLogin;
    private String adminPassword;
    private String contactName;
    private String contactLastName;
    private String contactPosition;


    public CrmUsers(String adminLogin, String adminPassword) {
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
    };

    public CrmUsers(String contactLastName, String contactName , String contactPosition) {
        this.contactLastName = contactLastName;
        this.contactName = contactName;
        this.contactPosition = contactPosition;
    };

    public String getAdminLogin() {
        return adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public String getContactPosition() {
        return contactPosition;
    }


}
