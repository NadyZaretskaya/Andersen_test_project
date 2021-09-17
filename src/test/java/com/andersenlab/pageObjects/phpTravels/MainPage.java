package com.andersenlab.pageObjects.phpTravels;

import com.andersenlab.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    protected static final By SIGN_UP_BUTTON = By.xpath("(//a[contains(text(),'Signup')])[3]");
    protected static final By ALERT_SUCCESS_MESSAGE = By.xpath("//div[@class=\"alert alert-success signup\"]");
    protected static final By ERROR_EMAIL_MESSAGE = By.xpath("//div[@class=\"message\"]");

    public static final String CONFIRMATION_OF_CREATION = "Signup successfull please login.";

    @Step("Click sign up button.")
    public SignupPage pushSignUpButton() {
        clickButton(SIGN_UP_BUTTON);
        return new SignupPage();
    }

    public String getConfirmationMessage () {
        return getText(ALERT_SUCCESS_MESSAGE);
    }

    public String getErrorEmailMessage () {
        return getText(ERROR_EMAIL_MESSAGE);
    }

}
