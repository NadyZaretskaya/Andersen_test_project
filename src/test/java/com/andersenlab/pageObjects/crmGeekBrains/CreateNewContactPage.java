package com.andersenlab.pageObjects.crmGeekBrains;

import com.andersenlab.pageObjects.BasePage;
import org.openqa.selenium.By;

public class CreateNewContactPage extends BasePage {
    protected static final By PAGE_TITLE = By.xpath("//h1[@class=\"user-name\"]");
    protected static final By LAST_NAME = By.xpath("//*[@name=\"crm_contact[lastName]\"]");
    protected static final By FIRST_NAME = By.xpath("//*[@name=\"crm_contact[firstName]\"]");
    protected static final By CONTACT_POSITION = By.xpath("//input[@name=\"crm_contact[jobTitle]\"]");
    protected static final By ORGANIZATION_DROPDOWN = By.xpath("//span[text()=\"Укажите организацию\"]");
    protected static final By ORGANIZATION = By.xpath("//div[contains(text(),\"Bins-Haley\")]");
    protected static final By SAVE_AND_CLOSE = By.xpath("//button[contains(text(),\"Сохранить и закрыть\")]");

    public ContactsPage createNewContactPerson(String lastName, String firstName, String position) {
        fillInLastName(lastName)
                .fillInFirstName(firstName)
                .fillInOrganization()
                .fillInContactPosition(position)
                .saveContactAndClose();
        waitForElementVisible(ContactsPage.PAGE_TITLE);
        return new ContactsPage();
    }

    public CreateNewContactPage fillInLastName(String lastName) {
        enterText(LAST_NAME, lastName);
        return this;
    }

    public CreateNewContactPage fillInFirstName(String firstName) {
        enterText(FIRST_NAME, firstName);
        return this;
    }

    public CreateNewContactPage fillInContactPosition(String contactPosition) {
        enterText(CONTACT_POSITION, contactPosition);
        return this;
    }

    public CreateNewContactPage fillInOrganization() {
        clickButton(ORGANIZATION_DROPDOWN);
        clickButton(ORGANIZATION);
        return this;
    }

    public CreateNewContactPage saveContactAndClose() {
        clickButton(SAVE_AND_CLOSE);
        waitForElementVisible(CreateNewContactPage.PAGE_TITLE);
        return this;
    }

}
