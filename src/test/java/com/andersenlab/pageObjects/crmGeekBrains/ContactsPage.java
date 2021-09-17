package com.andersenlab.pageObjects.crmGeekBrains;

import com.andersenlab.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ContactsPage extends BasePage {
    public static final String CONFIRMATION_OF_CREATION = "Контактное лицо сохранено";

    protected static final By PAGE_TITLE = By.xpath("//li[text() =\"Контактные лица\"]");
    protected static final By CREATE_CONTACT_BUTTON = By.xpath("//a[@title = \"Создать контактное лицо\"]");
    protected static final By CONFIRMATION_MESSAGE_WINDOW = By.xpath("//div[@class=\"message\"]");

    @Step("Click \"Create contract\" button")
    public CreateNewContactPage clickCreateContactButton() {
        clickButton(CREATE_CONTACT_BUTTON);
        waitForElementVisible(CreateNewContactPage.PAGE_TITLE);
        return new CreateNewContactPage();
    }

    public String getConfirmationMessage() {
        return getText(CONFIRMATION_MESSAGE_WINDOW);
    }


}
