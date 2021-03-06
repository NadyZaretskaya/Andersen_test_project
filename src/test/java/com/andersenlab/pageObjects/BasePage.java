package com.andersenlab.pageObjects;

import com.andersenlab.driver.DriverSingleton;
import com.andersenlab.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    private WebDriver driver = DriverSingleton.getDriver();

    public void open(String url) {
        driver.get(url);
    }

    protected void scrollToElement(By by) {
        WebElement webElement = driver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void clickButton(By by) {
        waitForElementClickable(by);
        driver.findElement(by).click();
    }

    protected void enterText(By by, String text) {
        findElement(by).sendKeys(text);
    }

    protected WebElement findElement(By by) {
        return driver.findElement(by);
    }

    protected void waitForElementVisible(By by) {
        Waiters.waitForElementVisible(driver, by);
    }

    protected void waitForElementClickable(By by) {
        Waiters.waitForElementClickable(driver, by);
    }

    protected String getText(By by) {
        waitForElementVisible(by);
        return findElement(by).getText();
    }

    protected String getAttributeValue(By by, String attribute) {
        return findElement(by).getAttribute(attribute);
    }

    protected boolean isButtonEnabled(By by) {
        return driver.findElement(by).isEnabled();
    }

    protected void selectValue(By by, String value) {
        Select element = new Select(findElement(by));
        element.selectByValue(value);
    }

    protected void selectByText(By by, String value) {
        Waiters.waitForElementVisible(driver, by);
        Select element = new Select(findElement(by));
        element.selectByVisibleText(value);
    }

    protected void clearField(By by) {
        Waiters.waitForElementClickable(driver, by);
        findElement(by).clear();
    }

}
