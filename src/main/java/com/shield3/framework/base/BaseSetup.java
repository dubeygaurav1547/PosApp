package com.shield3.framework.base;

import com.shield3.framework.controller.ApplicationController;
import com.shield3.framework.data.Data;
import com.shield3.framework.utils.ReuseableFunction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseSetup {

    public ApplicationController shield = null;
    public ReuseableFunction ruseable = new ReuseableFunction();

    @BeforeClass
    public void openUrl(){
        ruseable.launchBrowser("chrome", Data.stagingUrl);
    }

    @AfterClass
    public void closeBrowser(){
        ruseable.getDriver().close();
    }

    public ApplicationController shield() {
        if (shield == null) {
            shield = new ApplicationController(ruseable.getDriver());
        }
        return shield;
    }
}
