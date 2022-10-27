package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.services.InventoryPageService;
import org.tms.services.LoginPageService;



public class InventoryPageTest extends BaseTest{

    @Test(priority = 1)
    public void verifySelectSecondOption(){
        LoginPageService loginPageService = new LoginPageService();
        User user = new User();
        InventoryPageService inventoryPageService = new InventoryPageService();
        loginPageService.login(user);
        String actualSelectedOption = inventoryPageService
                .selectSecondOptionInSortContainer();
        String expectedSelectedOption = "Name (Z to A)";
        Assert.assertEquals(actualSelectedOption,expectedSelectedOption, "The actual selection does not match the expected!");
    }

    @Test(priority = 2)
    public void verifyAddToCartButton(){
        LoginPageService loginPageService = new LoginPageService();
        User user = new User();
        InventoryPageService inventoryPageService = new InventoryPageService();
        loginPageService.login(user);
        String actualTextOfCartPage = inventoryPageService
                .addToCartSauceLabsOnesie()
                .getPageName();
        String expectedTextOfCartPage = "YOUR CART";
        Assert.assertEquals(actualTextOfCartPage, expectedTextOfCartPage, "The actual text of the page does not match expected!");
    }

}
