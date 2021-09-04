package com.andersenlab.pageObjects.phpTravels;

import com.andersenlab.pageObjects.BasePage;
import com.andersenlab.pageObjects.crmGeekBrains.DashboardPage;
import com.andersenlab.utils.Waiters;
import org.openqa.selenium.By;

public class TravelsSignupPage extends BasePage {

    protected static final By FIRST_NAME_INPUT = By.xpath("//input[@name='first_name']");
    protected static final By LAST_NAME_INPUT = By.xpath("//input[@name='last_name']");
    protected static final By PHONE_INPUT = By.xpath("//input[@name='phone']");
    protected static final By EMAIL_INPUT = By.xpath("//input[@name='email']");
    protected static final By PASSWORD_INPUT = By.xpath("//input[@name='password']");
    protected static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    protected static final By ERROR_MESSAGE_WINDOW = By.xpath("//div[@class=\"contact-form-action\"]");


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

    public TravelsSignupPage fillInFirstName(String firstName) {
        enterText(FIRST_NAME_INPUT, firstName);
        return this;
    }

    public TravelsSignupPage fillInLastName(String lastName) {
        enterText(LAST_NAME_INPUT, lastName);
        return this;
    }

    public TravelsSignupPage fillInPhone(String phoneNumber) {
        enterText(PHONE_INPUT, phoneNumber);
        return this;
    }

    public TravelsSignupPage fillInEmail(String email) {
        enterText(EMAIL_INPUT, email);
        return this;
    }

    public TravelsSignupPage fillInPassword(String password) {
        enterText(PASSWORD_INPUT, password);
        return this;
    }

    public TravelsSignupPage pushSignInButton() {
        clickButton(LOGIN_BUTTON);
        return this;
    }



}
