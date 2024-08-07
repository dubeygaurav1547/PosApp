package com.shield3.test;

import com.shield3.framework.base.BaseSetup;
import com.shield3.framework.controller.LoginPageController;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class verifySigninSignoutTest extends BaseSetup {
    LoginPageController login;


    @Test(priority = 0)
    public void verifySignupSigninPage() throws Exception {
        login = shield().loginPageController();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(login.getText(login.login.resources,"Resources"), "Resource");
        softAssert.assertEquals(login.getHeader(), "Sign up or sign in to Shield3");
        softAssert.assertEquals(login.continueText(), "Continue");
        softAssert.assertEquals(login.getEmailplaceHolder(), "Enter your email");
        login.enterEmail();
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void verifyOTPverifyPage() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(login.getVerifyHeader(), "Verify your email");
        softAssert.assertTrue(login.getverifyEmailDes().contains("Enter the 6-digit code you received at"));
        softAssert.assertEquals(login.getGobackBTText(), "Go Back");
        softAssert.assertEquals(login.getText(login.login.verifyEmailBT,"verify button"), "Verify Email");
        login.enterOTP();
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyLogout() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(login.getText(login.login.breadcrumb,"breadcrumb"), "Dashboard");
        softAssert.assertEquals(login.getDriver().getTitle(), "Dashboard | Shield3");
        login.signOut();
        softAssert.assertEquals(login.getHeader(), "Sign up or sign in to Shield3", "Sign out successfully");
        softAssert.assertEquals(login.getDriver().getTitle(), "Sign In | Shield3");
        softAssert.assertAll();
    }
}