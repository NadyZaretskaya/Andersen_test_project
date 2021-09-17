package com.andersenlab.pageObjects.crmGeekBrains;

import com.andersenlab.pageObjects.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyProjectsPage extends BasePage {
    public static final String CONFIRMATION_OF_CREATION = "Проект сохранен";

    protected static final By PAGE_TITLE = By.xpath("//li[text() =\"Мои проекты\"]");
    protected static final By ALL_PROJECTS_PAGE_TITLE = By.xpath("//li[text() =\"Все проекты\"]");
    protected static final By CREATE_PROJECT_BUTTON = By.xpath("//a[@title=\"Создать проект\"]");
    protected static final By CONFIRMATION_MESSAGE_WINDOW = By.xpath("//div[@class=\"message\"]");

    @Step("Click on \"Create new project\" button")
    public CreateNewProjectPage clickCreateProjectButton() {
        clickButton(CREATE_PROJECT_BUTTON);
        waitForElementVisible(CreateNewProjectPage.PAGE_TITLE);
        return new CreateNewProjectPage();
    }

    public String getConfirmationMessage() {
        return getText(CONFIRMATION_MESSAGE_WINDOW);
    }

}
