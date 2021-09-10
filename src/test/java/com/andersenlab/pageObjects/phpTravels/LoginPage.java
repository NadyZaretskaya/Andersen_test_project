package com.andersenlab.pageObjects.phpTravels;

import com.andersenlab.pageObjects.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    protected static final By EMAIL_INPUT = By.xpath("//input[@name='email']");
    protected static final By PASSWORD_INPUT = By.xpath("//input[@name='password']");
    protected static final By LOGIN_BUTTON = By.xpath("//span[contains(.,'Login')]");
    protected static final By ERROR_MESSAGE = By.xpath("//div[@class=\"message\"]");

    public static final String INVALID_CREDS_MESSAGE = "Wrong credentials. try again!";

    public UserDashboardPage login(String email, String password) {
        fillInEmail(email)
                .fillInPassword(password)
                .pushLoginButton();
        return new UserDashboardPage();
    }

    public LoginPage fillInEmail(String firstName) {
        enterText(EMAIL_INPUT, firstName);
        return this;
    }

    public LoginPage fillInPassword(String password) {
        enterText(PASSWORD_INPUT, password);
        return this;
    }

    public LoginPage pushLoginButton() {
        clickButton(LOGIN_BUTTON);
        return this;
    }

    public String getInvalidCredentialMessage () {
        return getText(ERROR_MESSAGE);
    }
}
