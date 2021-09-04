package com.andersenlab.pageObjects.crmGeekBrains;

import com.andersenlab.pageObjects.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    protected static final By LOGIN_INPUT = By.id("prependedInput");
    protected static final By PASSWORD_INPUT = By.id("prependedInput2");
    protected static final By LOGIN_BUTTON = By.xpath("//button[@id='_submit']");



    public LoginPage fillInLogin(String login) {
        enterText(LOGIN_INPUT, login);
        return this;
    }

    public LoginPage fillInPassword(String password) {
        enterText(PASSWORD_INPUT, password);
        return this;
    }

    public LoginPage pushSignInButton() {
        clickButton(LOGIN_BUTTON);
        return this;
    }

    public DashboardPage loginToCrm(String login, String password) {
        fillInLogin(login)
                .fillInPassword(password)
                .pushSignInButton();
        waitForElementVisible(DashboardPage.PAGE_TITLE);
        return new DashboardPage();
    }


}
