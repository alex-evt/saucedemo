package org.tms.driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DriverSingleton {

    private static ThreadLocal<DriverSingleton> instance = new ThreadLocal<>();
    private static WebDriver driver;

    private DriverSingleton() {
        driver = WebDriverFactory.getWebDriver();
    }

    public static synchronized DriverSingleton getInstance() {
        if (instance.get() == null) {
            instance.set(new DriverSingleton());
        }
        return instance.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        try {
            driver.quit();
            driver = null;
        } catch (Exception e) {
            log.fatal("FATAL: Driver did not close!");
        } finally {
            instance.remove();
        }
    }
}
