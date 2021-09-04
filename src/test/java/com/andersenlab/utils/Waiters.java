package com.andersenlab.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    public static void waitForElementVisible(WebDriver webDriver, By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20), Duration.ofMillis(500));
        wait
                .withMessage("Can't find element" + by)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public static void waitForElementClickable(WebDriver webDriver, By by) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20), Duration.ofMillis(500));
        wait
                .withMessage("Can't click element" + by)
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}
