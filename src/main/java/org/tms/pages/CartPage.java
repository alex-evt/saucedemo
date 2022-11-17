package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageName;

    @Step("Getting title name of the page")
    public String getPageName(){
    return pageName.getText();
    }
}
