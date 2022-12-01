package org.tms.services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.tms.model.User;
import org.tms.pages.InventoryPage;
import org.tms.pages.LoginPage;

@Log4j2
public class LoginPageService {

    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";

    protected LoginPage loginPage = new LoginPage();

    @Step("Log in to a SauceDemo website as {user}")
    public InventoryPage login(User user) {
        log.info("Log in to a SauceDemo website as {}", user);
        loginPage.openPage(LOGIN_PAGE_URL)
                .waitForIcon()
                .fillInUsername(user.getLogin())
                .fillInPassword(user.getPassword())
                .clickLoginButton();
        return new InventoryPage();
    }
}
