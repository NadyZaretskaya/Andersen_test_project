package com.andersenlab.tests;

import com.andersenlab.pageObjects.crmGeekBrains.ContactsPage;
import com.andersenlab.pageObjects.crmGeekBrains.DashboardPage;
import com.andersenlab.pageObjects.phpTravels.MainPage;
import com.andersenlab.pageObjects.phpTravels.TravelsSignupPage;
import com.andersenlab.users.PhpTravelsUsers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhpTravelsTest extends BaseTest{
    protected static final String BASE_URL = "https://phptravels.net";
    PhpTravelsUsers admin = new PhpTravelsUsers("Applanatest1", "Student2020!");
    PhpTravelsUsers baseUser = new PhpTravelsUsers("Zaretskaya", "Nady",
            "212 123 456", "nady.zaretskaya", "123321");

    MainPage mainPage;
    TravelsSignupPage signupPage;


    @BeforeEach
    public void setUp() {
        mainPage = new MainPage();
        mainPage.open(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
        signupPage = null;
        mainPage = null;
    }

    @Test
    public void creatingOfNewBaseUser() {
        signupPage = mainPage.pushSignUpButton();
        mainPage = signupPage.createUser(baseUser.getBaseUserName(), baseUser.getBaseUserLastName(),
                baseUser.getBaseUserPhone(), baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(MainPage.CONFIRMATION_OF_CREATION, mainPage.getConfirmationMessage());
    }

    @Test
    public void creatingNewUserWithOccupiedEmail() {
        signupPage = mainPage.pushSignUpButton();
        mainPage = signupPage.createUser(baseUser.getBaseUserName(), baseUser.getBaseUserLastName(),
                baseUser.getBaseUserPhone(), baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        signupPage = mainPage.pushSignUpButton();
        mainPage = signupPage.createUser(baseUser.getBaseUserName(), baseUser.getBaseUserLastName(),
                baseUser.getBaseUserPhone(), baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(TravelsSignupPage.OCCUPIED_EMAIL_MESSAGE, mainPage.getErrorEmailMessage());
    }
}
