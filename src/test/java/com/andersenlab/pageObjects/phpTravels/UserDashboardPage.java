package com.andersenlab.pageObjects.phpTravels;

import com.andersenlab.pageObjects.BasePage;
import org.openqa.selenium.By;

public class UserDashboardPage extends BasePage {
    protected static final By LOGGED_USER_NAME = By.xpath("//h4[@class=\"author__title\"]/strong");
    protected static final By MY_PROFILE_BUTTON = By.xpath("//a[contains(text(),'My Profile')]");
    protected static final By LOGOUT_BUTTON = By.xpath("(//a[contains(text(),'Logout')])[2]");
    protected static final By SUCCESS_MESSAGE = By.xpath("//div[@class=\"alert alert-success\"]");

    public static final String SUCCEESS_UPDATE_MESSAGE = "Profile updated successfully.";

    public String getLoggedUserName () {
        return getText(LOGGED_USER_NAME);
    }

    public UserProfilePage navigateToProfilePage() {
        clickButton(MY_PROFILE_BUTTON);
        return new UserProfilePage();
    }

    public MainPage logOut() {
        clickButton(LOGOUT_BUTTON);
        return new MainPage();
    }

    public String getSuccessfulUpdateMessage() {
        return getText(SUCCESS_MESSAGE);
    }
}
