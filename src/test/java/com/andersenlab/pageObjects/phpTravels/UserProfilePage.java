package com.andersenlab.pageObjects.phpTravels;

import com.andersenlab.pageObjects.BasePage;
import com.andersenlab.pageObjects.crmGeekBrains.DashboardPage;
import org.openqa.selenium.By;

public class UserProfilePage extends BasePage {
    protected static final By NEW_PASSWORD_INPUT = By.xpath("//input[@name='password']");
    protected static final By UPDATE_PROFILE_BUTTON = By.xpath("//button[@type='submit']");

    public UserDashboardPage updatePassword(String password) {
        fillInPassword(password)
                .saveUserProfileUpdate();
        return new UserDashboardPage();
    }

    public UserProfilePage fillInPassword(String password) {
        enterText(NEW_PASSWORD_INPUT, password);
        return this;
    }

    public UserProfilePage saveUserProfileUpdate() {
        clickButton(UPDATE_PROFILE_BUTTON);
        return this;
    }


}
