package org.tms.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.services.InventoryPageService;
import org.tms.services.LoginPageService;



public class InventoryPageTest extends BaseTest{

    InventoryPageService inventoryPageService;
    @BeforeMethod
    public void openInventoryPage(){
        LoginPageService loginPageService = new LoginPageService();
        User user = new User();
        inventoryPageService = new InventoryPageService();
        loginPageService.login(user);
    }
    @Description("Verify second option in sort product dropdown is selected")
    @Test(priority = 1)
    public void verifySelectSecondOption(){
        String actualSelectedOption = inventoryPageService
                .getTextAndSelectSecondOptionInSortContainer();
        String expectedSelectedOption = "Name (Z to A)";
        Assert.assertEquals(actualSelectedOption,expectedSelectedOption, "The actual selection does not match the expected!");
    }
    @Description("Verify adding the product to cart and go to shopping cart after clicking on the 'Shopping cart' button")
    @Test(priority = 2)
    public void verifyAddToCartButton(){
        String actualTextOfCartPage = inventoryPageService
                .addToCartSauceLabsOnesie()
                .getPageName();

        String expectedTextOfCartPage = "YOUR CART";
        Assert.assertEquals(actualTextOfCartPage, expectedTextOfCartPage, "The actual text of the page does not match expected!");
    }

}
