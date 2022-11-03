package org.tms.pages;

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

    public void clickShoppingCart(){
        shoppingCart.click();
    }

    public InventoryPage clickAddToCartButtonSauceLabsOnesie(){
         addToCartSauceLabsOnesie.click();
         return this;
    }

    public InventoryPage selectOptionByTextInTheProductSortSelector(String optionName){
        Select select = new Select(productSortSelector);
        select.selectByVisibleText(optionName);
        return this;
    }
    public String getTextSelectedOption(){
        Select select = new Select(productSortSelector);
        return select.getFirstSelectedOption().getText();
    }

    public InventoryPage waitForSauceLabsOnesieImage(){
        waitVisibilityOf(imageSauceLabsOnesie);
        return this;
    }

    public String getTextOfNameOfPageSelection() {
        return nameOfPageSelection.getText();
    }

}
