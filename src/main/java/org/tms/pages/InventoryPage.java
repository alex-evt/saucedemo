package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{

    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfPageSelection;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement productSortSelector;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    private WebElement addToCartSauceLabsOnesie;

    @FindBy(xpath = "//img[@alt='Sauce Labs Onesie']")
    private WebElement imageSauceLabsOnesie;

    @Step("Clicking the 'Shopping Cart' button")
    public void clickShoppingCart(){
        shoppingCart.click();
    }
    @Step("Clicking the 'Add to cart' button in the SauceLabs Onesie product description")
    public InventoryPage clickAddToCartButtonSauceLabsOnesie(){
         addToCartSauceLabsOnesie.click();
         return this;
    }
    @Step("Selecting {optionName} in the sort product dropdown")
    public InventoryPage selectOptionByTextInTheProductSortSelector(String optionName){
        Select select = new Select(productSortSelector);
        select.selectByVisibleText(optionName);
        return this;
    }
    @Step("Getting text of the selected option")
    public String getTextSelectedOption(){
        Select select = new Select(productSortSelector);
        return select.getFirstSelectedOption().getText();
    }
    @Step("Waiting for SauceLabs Onesie image to show up")
    public InventoryPage waitForSauceLabsOnesieImage(){
        waitVisibilityOf(imageSauceLabsOnesie);
        return this;
    }
    @Step("Getting title name of the page")
    public String getTextOfNameOfPageSelection() {
        return nameOfPageSelection.getText();
    }

}
