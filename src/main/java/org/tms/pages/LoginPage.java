package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.AllureUtil;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;
    @Step("Opening saucedemo website")
     public LoginPage openPage(String url){
        driver.get(url);
        AllureUtil.takeScreenshot();
        return this;
    }
    @Step("Fill in {userName} in Username field")
    public LoginPage fillInUsername(String userName){
        usernameInput.clear();
        usernameInput.sendKeys(userName);
        AllureUtil.takeScreenshot();
        return this;
    }
    @Step("Fill in {keyPassword} in Password field")
    public LoginPage fillInPassword(String keyPassword){
        passwordInput.clear();
        passwordInput.sendKeys(keyPassword);
        AllureUtil.takeScreenshot();
        return this;
    }
    @Step("Clicking the Login button")
    public void clickLoginButton() {
        loginButton.click();
        AllureUtil.takeScreenshot();
    }
    @Step("Waiting for an icon to show up")
    public LoginPage waitForIcon(){
        waitVisibilityOf(loginButton);
        return this;
    }
}
