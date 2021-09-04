package com.andersenlab.pageObjects.phpTravels;

import com.andersenlab.pageObjects.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    protected static final By SIGN_UP_BUTTON = By.xpath("(//a[contains(text(),'Signup')])[3]");
    protected static final By ALERT_SUCCES_MESSAGE = By.xpath("//div[@class=\"alert alert-success signup\"]");
    public static final String CONFIRMATION_OF_CREATION = "Signup successfull please login.";
    protected static final By ERROR_EMAIL_MESSAGE = By.xpath("//div[@class=\"message\"]");


    public TravelsSignupPage pushSignUpButton() {
        clickButton(SIGN_UP_BUTTON);
        return new TravelsSignupPage();
    }

    public String getConfirmationMessage () {
        return getText(ALERT_SUCCES_MESSAGE);
    }
    public String getErrorEmailMessage () {
//        Waiters.waitForElementVisible(ERROR_MESSAGE_WINDOW);
        return getText(ERROR_EMAIL_MESSAGE);
    }

}
