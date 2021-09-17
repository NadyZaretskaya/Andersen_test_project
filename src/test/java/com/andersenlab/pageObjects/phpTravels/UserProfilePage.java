package com.andersenlab.pageObjects.phpTravels;

import com.andersenlab.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class UserProfilePage extends BasePage {
    protected static final By NEW_PASSWORD_INPUT = By.xpath("//input[@name='password']");
    protected static final By UPDATE_PROFILE_BUTTON = By.xpath("//button[contains(text(),\"Update Profile\")]");

    public UserDashboardPage updatePassword(String password) {
        fillInPassword(password)
                .saveUserProfileUpdate();
        return new UserDashboardPage();
    }

    @Step("Fill in new password {password}.")
    public UserProfilePage fillInPassword(String password) {
        clearField(NEW_PASSWORD_INPUT);
        enterText(NEW_PASSWORD_INPUT, password);
        return this;
    }

    @Step("Click on \"Update profile\" button.")
    public UserProfilePage saveUserProfileUpdate() {
        scrollToElement(UPDATE_PROFILE_BUTTON);
        isButtonEnabled(UPDATE_PROFILE_BUTTON);
        clickButton(UPDATE_PROFILE_BUTTON);
        return this;
    }

}
