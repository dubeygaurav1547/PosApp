package com.shield3.framework.controller;

import com.shield3.framework.utils.ReuseableFunction;
import com.shield3.framework.data.Data;
import com.shield3.framework.pageObject.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPageController extends ReuseableFunction {

    public LoginPage login = null;
    WebDriver driver;
    public LoginPageController(WebDriver driver) {
        login = PageFactory.initElements(driver, LoginPage.class);
        this.driver=driver;
    }


    public String getHeader() throws Exception {
        return getText(login.signupHeader,"signup header");
    }

    public String continueText() throws Exception {
       return getText(login.continueBT, "continue");
    }

    public String getverifyEmailDes() throws Exception {
        return getText(login.verifyEmailDec,"verify email description");
    }

    public String getEmailplaceHolder() throws Exception {
        return getattribute(login.emailInputBox,"email field","placeholder");
    }

    public String getGobackBTText() throws Exception {
        return getText(login.goBackBT,"go back");
    }

    public String getVerifyHeader() throws Exception {
        return getText(login.verifyHeader,"email verify header");
    }


    public void enterEmail() throws Exception {
        typeValue(login.emailInputBox,"email field", Data.email);
        clickObject(login.continueBT,"continue");
    }

    public void enterOTP() throws Exception {
        List<WebElement> ele = driver.findElements(By.xpath("//div[@class='inline-flex gap-3']//input"));
        String otp = readEmailOTP();
        for (int i=0;i<ele.size(); i++){
            typeValue(ele.get(i),"",String.valueOf(otp.charAt(i)));
        }
        clickObject(login.verifyEmailBT,"verify Email");
    }

    public void signOut() throws Exception {
        clickObject(login.profileIcon,"profile icon");
        clickObject(login.signOutBT,"sign out");
    }
}
