package com.posapp.framework.controller;

import org.openqa.selenium.WebDriver;

public class ApplicationController {
    public WebDriver driver ;
    public LoginPageController login;
    public DashboardController dashboard;

    public ApplicationController(WebDriver driver) {
        this.driver=driver;
    }

    public LoginPageController loginPageController()  {
        if (login == null) {
            login = new LoginPageController(driver);
        }
        return login;
    }

    public DashboardController dashboardController()  {
        if (dashboard == null) {
            dashboard = new DashboardController(driver);
        }
        return dashboard;
    }
}
