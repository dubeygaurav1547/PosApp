package com.posapp.framework.base;

import com.posapp.framework.controller.ApplicationController;
import com.posapp.framework.controller.LoginPageController;
import com.posapp.framework.data.Data;
import com.posapp.framework.utils.ReuseableFunction;

import org.testng.annotations.*;

public class BaseSetup {

    public ApplicationController posApp = null;
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

    @BeforeTest(alwaysRun = true)
    public void login_PosApp() throws Exception {
        login = posApp().loginPageController();

        login.login();

    }

    @AfterTest(alwaysRun = true)
    public void logout_PosApp() throws Exception {
        login.logOut();
    }

    public ApplicationController posApp() {
        if (posApp == null) {
            posApp = new ApplicationController(ruseable.getDriver());
        }
        return posApp;
    }
}
