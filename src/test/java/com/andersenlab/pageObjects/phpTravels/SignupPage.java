package com.andersenlab.pageObjects.phpTravels;

import com.andersenlab.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignupPage extends BasePage {

    protected static final By FIRST_NAME_INPUT = By.xpath("//input[@name='first_name']");
    protected static final By LAST_NAME_INPUT = By.xpath("//input[@name='last_name']");
    protected static final By PHONE_INPUT = By.xpath("//input[@name='phone']");
    protected static final By EMAIL_INPUT = By.xpath("//input[@name='email']");
    protected static final By PASSWORD_INPUT = By.xpath("//input[@name='password']");
    protected static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    protected static final By NAVIGATE_TO_LOGIN_PAGE_BUTTON = By.xpath("(//a[contains(.,'Login')])[3]");
    protected static final By ACCEPT_COOKIES_BUTTON = By.xpath("//button[@id='cookie_stop']");

    public static final String OCCUPIED_EMAIL_MESSAGE = "Email already exist!";

    public MainPage createUser(String firstName, String lastName, String phoneNumber, String baseEmail, String password) {
        fillInFirstName(firstName)
                .fillInLastName(lastName)
                .fillInPhone(phoneNumber)
                .fillInEmail(baseEmail)
                .fillInPassword(password)
                .pushSignInButton();
        return new MainPage();
    }

    @Step("Fill in first name {firstName}.")
    public SignupPage fillInFirstName(String firstName) {
        enterText(FIRST_NAME_INPUT, firstName);
        return this;
    }

    @Step("Fill in last name {lastName}.")
    public SignupPage fillInLastName(String lastName) {
        enterText(LAST_NAME_INPUT, lastName);
        return this;
    }

    @Step("Fill in phone number {phoneNumber}.")
    public SignupPage fillInPhone(String phoneNumber) {
        enterText(PHONE_INPUT, phoneNumber);
        return this;
    }

    @Step("Fill in e-mail {email}.")
    public SignupPage fillInEmail(String email) {
        enterText(EMAIL_INPUT, email);
        return this;
    }

    @Step("Fill in password {password}.")
    public SignupPage fillInPassword(String password) {
        enterText(PASSWORD_INPUT, password);
        return this;
    }

    @Step("Click sign in button.")
    public SignupPage pushSignInButton() {
        clickButton(LOGIN_BUTTON);
        return this;
    }

    @Step("Click on \"Login\" button.")
    public LoginPage navigateToLoginPage() {
        clickButton(NAVIGATE_TO_LOGIN_PAGE_BUTTON);
        return new LoginPage();
    }

    @Step("Accept cookies.")
    public SignupPage acceptCookies() {
        clickButton(ACCEPT_COOKIES_BUTTON);
        return this;
    }

}
