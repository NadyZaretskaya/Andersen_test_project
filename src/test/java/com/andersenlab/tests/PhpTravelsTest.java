package com.andersenlab.tests;

import com.andersenlab.pageObjects.phpTravels.*;
import com.andersenlab.users.PhpTravelsUsers;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhpTravelsTest extends BaseTest{
    protected static final String BASE_URL = "https://phptravels.net";
    PhpTravelsUsers baseUser = new PhpTravelsUsers("Zaretskaya", "Nady",
            "212 123 456", "nady.zaretskaya", "123321");
    PhpTravelsUsers invalidUser = new PhpTravelsUsers("Ilushina", "Viktoria",
            "212 654 321", "victoria.ilushina", "999666");

    MainPage mainPage;
    SignupPage signupPage;
    LoginPage loginPage;
    UserDashboardPage userDashboardPage;
    UserProfilePage userProfilePage;


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
        loginPage = null;
        userDashboardPage = null;
        userProfilePage = null;
    }

    @Test
    @Description("Creating of new valid user")
    public void creatingOfNewBaseUser() {
        signupPage = mainPage.pushSignUpButton();
        mainPage = signupPage.createUser(baseUser.getBaseUserName(), baseUser.getBaseUserLastName(),
                baseUser.getBaseUserPhone(), baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(MainPage.CONFIRMATION_OF_CREATION, mainPage.getConfirmationMessage());
    }

    @Test
    @Description("Check that we can't create users with same e-mails")
    public void creatingNewUserWithOccupiedEmail() {
        signupPage = mainPage.pushSignUpButton();
        mainPage = signupPage.createUser(baseUser.getBaseUserName(), baseUser.getBaseUserLastName(),
                baseUser.getBaseUserPhone(), baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        signupPage = mainPage.pushSignUpButton();
        mainPage = signupPage.createUser(baseUser.getBaseUserName(), baseUser.getBaseUserLastName(),
                baseUser.getBaseUserPhone(), baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(SignupPage.OCCUPIED_EMAIL_MESSAGE, mainPage.getErrorEmailMessage());
    }

    @Test
    @Description("Login as user with valid credentials")
    public void loginWithValidUser() {
        signupPage = mainPage.pushSignUpButton();
        mainPage = signupPage.createUser(baseUser.getBaseUserName(), baseUser.getBaseUserLastName(),
                baseUser.getBaseUserPhone(), baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(MainPage.CONFIRMATION_OF_CREATION, mainPage.getConfirmationMessage());
        loginPage = signupPage.navigateToLoginPage();
        userDashboardPage = loginPage.login(baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(baseUser.getBaseUserName(), userDashboardPage.getLoggedUserName());
    }

    @Test
    @Description("Login as user with invalid password")
    public void loginWithInvalidPassword() {
        signupPage = mainPage.pushSignUpButton();
        mainPage = signupPage.createUser(baseUser.getBaseUserName(), baseUser.getBaseUserLastName(),
                baseUser.getBaseUserPhone(), baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(MainPage.CONFIRMATION_OF_CREATION, mainPage.getConfirmationMessage());
        loginPage = signupPage.navigateToLoginPage();
        userDashboardPage = loginPage.login(baseUser.getBaseUserEmail(), invalidUser.getBaseUserPassword());
        Assertions.assertEquals(LoginPage.INVALID_CREDS_MESSAGE, loginPage.getInvalidCredentialMessage());
    }

    @Test
    @Description("Update password and login with new one")
    public void checkForUpdatedPassword() {
        //create new user
        signupPage = mainPage.pushSignUpButton();
        mainPage = signupPage.createUser(baseUser.getBaseUserName(), baseUser.getBaseUserLastName(),
                baseUser.getBaseUserPhone(), baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(MainPage.CONFIRMATION_OF_CREATION, mainPage.getConfirmationMessage());
        //login as user
        loginPage = signupPage.navigateToLoginPage();
        userDashboardPage = loginPage.login(baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(baseUser.getBaseUserName(), userDashboardPage.getLoggedUserName());
        //update password
        userProfilePage = userDashboardPage.navigateToProfilePage();
        userDashboardPage = userProfilePage.updatePassword(invalidUser.getBaseUserPassword());
        Assertions.assertEquals(UserDashboardPage.SUCCEESS_UPDATE_MESSAGE, userDashboardPage.getSuccessfulUpdateMessage());
        //logout
        mainPage = userDashboardPage.logOut();
        //login with new password
        userDashboardPage = loginPage.login(baseUser.getBaseUserEmail(), invalidUser.getBaseUserPassword());
        Assertions.assertEquals(baseUser.getBaseUserName(), userDashboardPage.getLoggedUserName());
    }

    @Test
    @Description("Update password and try to login with old")
    public void checkForLoginWithOldPasswordAfterUpdate() {
        //create new user
        signupPage = mainPage.pushSignUpButton();
        mainPage = signupPage.createUser(baseUser.getBaseUserName(), baseUser.getBaseUserLastName(),
                baseUser.getBaseUserPhone(), baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(MainPage.CONFIRMATION_OF_CREATION, mainPage.getConfirmationMessage());
        //login as user
        loginPage = signupPage.navigateToLoginPage();
        userDashboardPage = loginPage.login(baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(baseUser.getBaseUserName(), userDashboardPage.getLoggedUserName());
        //update password
        userProfilePage = userDashboardPage.navigateToProfilePage();
        userDashboardPage = userProfilePage.updatePassword(invalidUser.getBaseUserPassword());
        Assertions.assertEquals(UserDashboardPage.SUCCEESS_UPDATE_MESSAGE, userDashboardPage.getSuccessfulUpdateMessage());
        //logout
        mainPage = userDashboardPage.logOut();
        //try to login with old password
        userDashboardPage = loginPage.login(baseUser.getBaseUserEmail(), baseUser.getBaseUserPassword());
        Assertions.assertEquals(LoginPage.INVALID_CREDS_MESSAGE, loginPage.getInvalidCredentialMessage());
    }

}
