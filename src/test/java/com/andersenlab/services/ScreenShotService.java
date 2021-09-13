package com.andersenlab.services;

import com.andersenlab.driver.DriverSingleton;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenShotService {
    private static Logger log = LoggerFactory.getLogger(ScreenShotService.class);

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot() {
        return ((TakesScreenshot) DriverSingleton
                .getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
