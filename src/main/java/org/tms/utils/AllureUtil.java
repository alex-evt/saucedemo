package org.tms.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.tms.driver.DriverSingleton;

public class AllureUtil {

    @Attachment(value="screenshot", type="image/png")
    public static byte[] takeScreenshot(){
        return ((TakesScreenshot)  DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
