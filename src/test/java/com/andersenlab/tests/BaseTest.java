package com.andersenlab.tests;

import com.andersenlab.driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    @AfterEach
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
