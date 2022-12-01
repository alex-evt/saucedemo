package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.AllureUtil;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;
    @Step("Opening saucedemo website")
     public LoginPage openPage(String url){
        log.info("Opening Login page"); //логи ставить перед действием
        driver.get(url);
        AllureUtil.takeScreenshot();
        return this;
    }
    @Step("Fill in {userName} in Username field")
    public LoginPage fillInUsername(String userName){
        log.info("Entering '{}' in username field", userName);
        usernameInput.clear();
        usernameInput.sendKeys(userName);
        AllureUtil.takeScreenshot();
        return this;
    }
    @Step("Fill in {keyPassword} in Password field")
    public LoginPage fillInPassword(String keyPassword){
        log.info("Entering '{}' in password field", keyPassword);
        passwordInput.clear();
        passwordInput.sendKeys(keyPassword);
        AllureUtil.takeScreenshot();
        return this;
    }
    @Step("Clicking the 'Login' button")
    public void clickLoginButton() {
        log.info("Clicking the 'Login' button");
        loginButton.click();
        AllureUtil.takeScreenshot();
    }
    @Step("Waiting for an icon to show up")
    public LoginPage waitForIcon(){
        waitVisibilityOf(loginButton);
        return this;
    }
}
