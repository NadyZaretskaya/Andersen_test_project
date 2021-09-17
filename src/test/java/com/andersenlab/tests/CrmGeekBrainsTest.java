package com.andersenlab.tests;

import com.andersenlab.pageObjects.crmGeekBrains.*;
import com.andersenlab.users.CrmUsers;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import java.util.Date;

public class CrmGeekBrainsTest extends BaseTest{
    Date date = new Date();
    protected static final String BASE_URL = "https://crm.geekbrains.space/user/login";
    CrmUsers admin = new CrmUsers("Applanatest1", "Student2020!");
    CrmUsers contactPerson = new CrmUsers("Zaretskaya", "Nady", "Тестировщик");
    public final String PROJECT_NAME = "Zaretskay Test Project" + date;
    public static final String BUSINESS_UNIT_VALUE = "1";
    public static final String PROJECT_RESPONSIBLE = "117";

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage;
    ContactsPage contactsPage;
    CreateNewContactPage createNewContactPage;
    MyProjectsPage myProjectsPage;
    CreateNewProjectPage crateNewProjectPage;

    @BeforeEach
    public void setUp() {
        dashboardPage = new DashboardPage();
        dashboardPage.open(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
        dashboardPage = null;
        loginPage = null;
    }

    @Test
    @Description("Login as admin")
    public void login() {
        dashboardPage = loginPage.loginToCrm(admin.getAdminLogin(), admin.getAdminPassword());
    }

    @Test
    @Description("Creating of new contact person")
    public void checkCreationOfNewContactPerson() {
        dashboardPage = loginPage.loginToCrm(admin.getAdminLogin(), admin.getAdminPassword());
        contactsPage = dashboardPage.navigateToContactsPage();
        createNewContactPage = contactsPage.clickCreateContactButton();
        contactsPage = createNewContactPage.createNewContactPerson(contactPerson.getContactLastName(),
                contactPerson.getContactName(), contactPerson.getContactPosition());
        Assertions.assertEquals(contactsPage.getConfirmationMessage(), ContactsPage.CONFIRMATION_OF_CREATION);
    }

    @Test
    @Description("Creating of new project")
    public void checkCreationOfNewProject() {
        dashboardPage = loginPage.loginToCrm(admin.getAdminLogin(), admin.getAdminPassword());
        myProjectsPage = dashboardPage.navigateToProjectsPage();
        crateNewProjectPage = myProjectsPage.clickCreateProjectButton();
        myProjectsPage = crateNewProjectPage.createNewProject(PROJECT_NAME, BUSINESS_UNIT_VALUE, PROJECT_RESPONSIBLE,
                contactPerson.getContactLastName() + " " + contactPerson.getContactName());
        Assertions.assertEquals(myProjectsPage.getConfirmationMessage(), MyProjectsPage.CONFIRMATION_OF_CREATION);
    }

}
