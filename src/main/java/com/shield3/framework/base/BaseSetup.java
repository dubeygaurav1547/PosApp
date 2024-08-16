package com.shield3.framework.base;

import com.shield3.framework.controller.ApplicationController;
import com.shield3.framework.controller.LoginPageController;
import com.shield3.framework.data.Data;
import com.shield3.framework.utils.ReuseableFunction;
import org.testng.annotations.*;

public class BaseSetup {

    public ApplicationController shield = null;
    public ReuseableFunction ruseable = new ReuseableFunction();
    LoginPageController login;
    @BeforeSuite
    public void openUrl(){
        ruseable.launchBrowser("chrome", Data.stagingUrl);
    }

    @AfterSuite
    public void closeBrowser(){
        ruseable.getDriver().close();
    }

    @BeforeTest
    public void login_Shield() throws Exception {
        login = shield().loginPageController();
        login.login();
    }

    @AfterTest
    public void logout_shield() throws Exception {
        login.signOut();
    }

    public ApplicationController shield() {
        if (shield == null) {
            shield = new ApplicationController(ruseable.getDriver());
        }
        return shield;
    }
}
