package org.tms.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.tms.driver.DriverSingleton;
import org.tms.tests.utils.Listener;

@Listeners(Listener.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        driver = DriverSingleton.getInstance().getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.getInstance().closeDriver();
    }
}
