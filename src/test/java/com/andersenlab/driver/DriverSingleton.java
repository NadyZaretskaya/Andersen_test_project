package com.andersenlab.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.platform.commons.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

public class DriverSingleton {
    static Logger log = LogManager.;
    private static EventFiringWebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                switch (System.getProperty("browser")) {
                    case "firefox": {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new EventFiringWebDriver(new FirefoxDriver());
                        break;
                    }
                    case "opera": {
                        WebDriverManager.operadriver().setup();
                        driver = new EventFiringWebDriver(new OperaDriver());
                        break;
                    }
                    case "edge": {
                        WebDriverManager.edgedriver().setup();
                        driver = new EventFiringWebDriver(new EdgeDriver());
                        break;
                    }
                    default: {
                        WebDriverManager.chromedriver().setup();
                        driver = new EventFiringWebDriver(new ChromeDriver());
                    }
                }
            } catch (Exception e) {
                log.info("Property 'driver' was not set, setting up the default browser - Chrome");
            }
        }

        driver.register(new WebDriverListener());
        setUpDriver();
        log.info("Initiated of driver successfully. Driver:" + driver.getClass().getName());
        log.info(driver.getCapabilities());
        return driver;
    }

    private static void setUpDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
}