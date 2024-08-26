package com.posapp.framework.controller;

import com.posapp.framework.data.Data;
import com.posapp.framework.pageObject.LoginPage;
import com.posapp.framework.utils.ReuseableFunction;

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

    public void login() throws Exception {
        enterUserName();
        enterPassword();
        clickOnLoginBtn();
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
        return getattribute(login.userNameInputBox,"email field","placeholder");
    }

    public String getGobackBTText() throws Exception {
        return getText(login.goBackBT,"go back");
    }

    public String getVerifyHeader() throws Exception {
        return getText(login.verifyHeader,"email verify header");
    }


    public void enterUserName() throws Exception {
    	Thread.sleep(5000);
    	waitForElement(WaitCondition.toBeVisible, login.userNameInputBox);
    	clickObject(login.userNameInputBox, "");
        typeValue(login.userNameInputBox,"Username field", Data.username);
       
    }
    public void enterPassword() throws Exception {
    	clickObject(login.passwordInputBox, "");
        typeValue(login.passwordInputBox,"Password field", Data.password);
       
    }
    public void clickOnLoginBtn() throws Exception {
        clickObject(login.login,"Login Button");
       
    }

    public void enterOTP() throws Exception {
        List<WebElement> ele = driver.findElements(By.xpath("//div[@class='inline-flex gap-3']//input"));
        Thread.sleep(2000);
        String otp = readEmailOTP();
        for (int i=0;i<ele.size(); i++){
            typeValue(ele.get(i),"",String.valueOf(otp.charAt(i)));
        }
        clickObject(login.verifyEmailBT,"verify Email");
    }

    public void logOut() throws Exception {
        clickObject(login.profileIcon,"profile icon");
        clickObject(login.logOutBT,"sign out");
    }
}
