package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageName;

    public String getPageName(){
    return pageName.getText();
    }
}
