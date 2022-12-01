package org.tms.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

@Log4j2
public class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver getWebDriver() {
        WebDriver driver = null;
        switch (System.getProperty("browser")) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "opera": {
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            }
            default: {
                try {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito");
//                    chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);
                } catch (Exception e){
                    log.fatal("FATAL: Driver did not start!");
                }
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
}
