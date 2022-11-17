package org.tms.services;

import io.qameta.allure.Step;
import org.tms.pages.CartPage;
import org.tms.pages.InventoryPage;

public class InventoryPageService {

    private static final String INVENTORY_URL = "https://www.saucedemo.com/inventory";

    private static final String FIRST_OPTION_PRODUCT_SORT = "Name (A to Z)";
    private static final String SECOND_OPTION_PRODUCT_SORT = "Name (Z to A)";
    private static final String THIRD_OPTION_PRODUCT_SORT = "Price (low to high)";
    private static final String FOURTH_OPTION_PRODUCT_SORT = "Price (high to low)";

    protected InventoryPage inventoryPage = new InventoryPage();


    public String selectFirstOptionInSortContainer() {
        return inventoryPage
                .selectOptionByTextInTheProductSortSelector(FIRST_OPTION_PRODUCT_SORT)
                .getTextSelectedOption();
    }
    @Step("Selecting second option in the sort product dropdown")
    public String getTextAndSelectSecondOptionInSortContainer() {
        return inventoryPage
                .waitForSauceLabsOnesieImage()
                .selectOptionByTextInTheProductSortSelector(SECOND_OPTION_PRODUCT_SORT)
                .getTextSelectedOption();
    }

    public String selectThirdOptionInSortContainer() {
        return inventoryPage.
                selectOptionByTextInTheProductSortSelector(THIRD_OPTION_PRODUCT_SORT)
                .getTextSelectedOption();
    }

    public String selectFourthOptionInSortContainer() {
        return inventoryPage.
                selectOptionByTextInTheProductSortSelector(FOURTH_OPTION_PRODUCT_SORT)
                .getTextSelectedOption();
    }
    @Step("Verify adding to cart and go to cart ")
    public CartPage addToCartSauceLabsOnesie() {
        inventoryPage
                .clickAddToCartButtonSauceLabsOnesie()
                .clickShoppingCart();
        return new CartPage();
    }

}
