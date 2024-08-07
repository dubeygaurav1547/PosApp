package com.shield3.framework.controller;

import org.openqa.selenium.WebDriver;

public class ApplicationController {
    public WebDriver driver ;
    public LoginPageController login;

    public ApplicationController(WebDriver driver) {
        this.driver=driver;
    }

    public LoginPageController loginPageController()  {
        if (login == null) {
            login = new LoginPageController(driver);
        }
        return login;
    }
}
