package com.andersenlab.pageObjects.crmGeekBrains;

import com.andersenlab.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    protected static final By PAGE_TITLE = By.xpath("//li[contains(text(),\"Панели инструментов\")]");
    protected static final By CONTRAGENTS_HEADER = By.xpath("//span[text()=\"Контрагенты\"]");
    protected static final By CONTACT_PERSONS_BUTTON = By.xpath("//span[text()=\"Контактные лица\"]");
    protected static final By PROJECTS_HEADER = By.xpath("//span[text()=\"Проекты\"]");
    protected static final By MY_PROJECTS_BUTTON = By.xpath("//span[text()=\"Мои проекты\"]");

    @Step("Navigate to \"Contracts\" page")
    public ContactsPage navigateToContactsPage () {
        clickButton(CONTRAGENTS_HEADER);
        clickButton(CONTACT_PERSONS_BUTTON);
        waitForElementVisible(ContactsPage.PAGE_TITLE);
        return new ContactsPage();
    }

    @Step("Navigate to \"Projects\" page")
    public MyProjectsPage navigateToProjectsPage () {
        clickButton(PROJECTS_HEADER);
        clickButton(MY_PROJECTS_BUTTON);
        waitForElementVisible(MyProjectsPage.PAGE_TITLE);
        return new MyProjectsPage();
    }






}
