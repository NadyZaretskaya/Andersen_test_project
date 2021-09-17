package com.andersenlab.pageObjects.crmGeekBrains;

import com.andersenlab.pageObjects.BasePage;
import com.andersenlab.utils.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CreateNewProjectPage extends BasePage {
    protected static final By PAGE_TITLE = By.xpath("//h1[@class=\"user-name\"]");
    protected static final By PROJECT_NAME = By.xpath("//input[@name=\"crm_project[name]\"]");
    protected static final By ORGANIZATION_DROPDOWN = By.xpath("//span[text()=\"Укажите организацию\"]");
    protected static final By ORGANIZATION = By.xpath("//div[contains(text(),\"Bins-Haley\")]");
    protected static final By BUSINESS_UNIT_DROPDOWN = By.xpath("//select[@name=\"crm_project[businessUnit]\"]");
    protected static final By PROJECT_CURATOR_DROPDOWN = By.xpath("//select[@name=\"crm_project[curator]\"]");
    protected static final By PROJECT_RP_DROPDOWN = By.xpath("//select[@name=\"crm_project[rp]\"]");
    protected static final By PROJECT_ADMINISTRATOR_DROPDOWN = By.xpath("//select[@name=\"crm_project[administrator]\"]");
    protected static final By PROJECT_MANAGER_DROPDOWN = By.xpath("//select[@name=\"crm_project[manager]\"]");
    protected static final By PROJECT_CONTACT_MAIN_DROPDOWN = By.xpath("//select[@name=\"crm_project[contactMain]\"]");
    protected static final By SAVE_AND_CLOSE_BUTTON = By.xpath("//button[contains(text(),\"Сохранить и закрыть\")]");

    protected static final By BUSINESS_UNIT_INPUT = By.xpath("//span[text()=\"Выберите подразделение\"]");
    protected static final By PROJECT_CURATOR_INPUT = By.xpath("//span[text()=\"Выберите куратора проекта\"]");
    protected static final By PROJECT_RP_INPUT = By.xpath("//span[text()=\"Выберите руководителя проекта\"]");
    protected static final By PROJECT_ADMINISTRATOR_INPUT = By.xpath("//span[text()=\"Выберите администратора продаж\"]");
    protected static final By PROJECT_MANAGER_INPUT = By.xpath("//span[text()=\"Выберите менеджера\"]");
    protected static final By PROJECT_CONTACT_MAIN_INPUT = By.xpath("//*[text()='Основное контактное лицо']/../..//input");
    protected static final By BUSINESS_UNIT_VALUE = By.xpath("//div[contains(text(),\"Research & Development\")]");

    public MyProjectsPage createNewProject(String projectName, String businessUnit, String responsiblePerson, String contactLastFirstName) {
        fillInProjectName(projectName)
                .fillInOrganization()
                .setMainContact(contactLastFirstName)
                .setProjectManager(responsiblePerson)
                .setProjectAdministrator(responsiblePerson)
                .setProjectRp(responsiblePerson)
                .setProjectCurator(responsiblePerson)
                .setBusinessUnit(businessUnit)

                .saveProjectAndClose();
        waitForElementVisible(MyProjectsPage.ALL_PROJECTS_PAGE_TITLE);
        return new MyProjectsPage();
    }

    @Step("Fill in new project name {projectName}")
    public CreateNewProjectPage fillInProjectName(String projectName) {
        enterText(PROJECT_NAME, projectName);
        return this;
    }

    @Step("Fill in organization")
    public CreateNewProjectPage fillInOrganization() {
        clickButton(ORGANIZATION_DROPDOWN);
        clickButton(ORGANIZATION);
        return this;
    }

    @Step("Set business unit {businessUnit}")
    public CreateNewProjectPage setBusinessUnit(String businessUnit) {
        selectValue(BUSINESS_UNIT_DROPDOWN, businessUnit);
        return this;
    }

    @Step("Set project curator {responsiblePerson}")
    public CreateNewProjectPage setProjectCurator(String responsiblePerson) {
        selectValue(PROJECT_CURATOR_DROPDOWN, responsiblePerson);
        return this;
    }

    @Step("Set project RP {responsiblePerson}")
    public CreateNewProjectPage setProjectRp(String responsiblePerson) {
        selectValue(PROJECT_RP_DROPDOWN, responsiblePerson);
        return this;
    }

    @Step("Set project administrator {responsiblePerson}")
    public CreateNewProjectPage setProjectAdministrator(String responsiblePerson) {
        selectValue(PROJECT_ADMINISTRATOR_DROPDOWN, responsiblePerson);
        return this;
    }

    @Step("Set project manager {responsiblePerson}")
    public CreateNewProjectPage setProjectManager(String responsiblePerson) {
        selectValue(PROJECT_MANAGER_DROPDOWN, responsiblePerson);
        return this;
    }

    @Step("Set main contact {responsiblePerson}")
    public CreateNewProjectPage setMainContact(String responsiblePerson) {
        selectByText(PROJECT_CONTACT_MAIN_DROPDOWN, responsiblePerson);
        return this;
    }

    @Step("Click on \"Save and close\" button")
    public CreateNewProjectPage saveProjectAndClose() {
        clickButton(SAVE_AND_CLOSE_BUTTON);
        return this;
    }

}
