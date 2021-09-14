package com.andersenlab.pageObjects.phpTravels;

import com.andersenlab.pageObjects.BasePage;
import org.openqa.selenium.By;

public class UserProfilePage extends BasePage {
    protected static final By NEW_PASSWORD_INPUT = By.xpath("//input[@name='password']");
    protected static final By SECOND_ADDRESS_INPUT = By.xpath("//input[@name='address2']");
    protected static final By UPDATE_PROFILE_BUTTON = By.xpath("//button[contains(text(),\"Update Profile\")]");

    public UserDashboardPage updatePassword(String password) {
        fillInPassword(password)
//                .fillInSecondAddress("")
                .saveUserProfileUpdate();
        return new UserDashboardPage();
    }

    public UserProfilePage fillInPassword(String password) {
        clearField(NEW_PASSWORD_INPUT);
        enterText(NEW_PASSWORD_INPUT, password);
        return this;
    }

    public UserProfilePage fillInSecondAddress(String secondAddress) {
        clearField(SECOND_ADDRESS_INPUT);
        enterText(SECOND_ADDRESS_INPUT, secondAddress);
        return this;
    }

    public UserProfilePage saveUserProfileUpdate() {
        scrollToElement(UPDATE_PROFILE_BUTTON);
        isButtonEnabled(UPDATE_PROFILE_BUTTON);
        clickButton(UPDATE_PROFILE_BUTTON);
        return this;
    }

}
