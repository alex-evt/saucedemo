package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    public LoginPage openPage(String url){
        driver.get(url);
        return this;
    }

    public LoginPage fillInUsername(String userName){
        usernameInput.clear();
        usernameInput.sendKeys(userName);
        return this;
    }

    public LoginPage fillInPassword(String keyPassword){
        passwordInput.clear();
        passwordInput.sendKeys(keyPassword);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
