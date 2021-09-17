package com.andersenlab.pageObjects.crmGeekBrains;

import com.andersenlab.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    protected static final By LOGIN_INPUT = By.id("prependedInput");
    protected static final By PASSWORD_INPUT = By.id("prependedInput2");
    protected static final By LOGIN_BUTTON = By.xpath("//button[@id='_submit']");

    @Step("Fill in login {login}")
    public LoginPage fillInLogin(String login) {
        enterText(LOGIN_INPUT, login);
        return this;
    }

    @Step("Fill in password {password}")
    public LoginPage fillInPassword(String password) {
        enterText(PASSWORD_INPUT, password);
        return this;
    }

    @Step("Click on login button")
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
