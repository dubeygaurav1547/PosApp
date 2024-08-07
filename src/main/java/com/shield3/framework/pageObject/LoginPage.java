package com.shield3.framework.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//h1[@class='font-rajdhani text-3xl font-bold text-gray-900']")
    public WebElement signupHeader;

    @FindBy(xpath = "//div[@class='font-medium text-gray-600']")
    public WebElement verifyEmailDec;

    @FindBy(xpath = "//a[@class='text-sm font-bold text-gray-900']")
    public WebElement resources;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement goBackBT;

    @FindBy(xpath = "//input[@placeholder='Enter your email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueBT;

    @FindBy(xpath = "//h1[text()='Verify your email']")
    public WebElement verifyHeader;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement verifyEmailBT;

    @FindBy(xpath = "//div[@class='ml-[120px] flex flex-1 items-center justify-center gap-2 text-sm font-extrabold']")
    public WebElement breadcrumb;

    @FindBy(xpath = "//button/div[@class='rounded-full object-cover font-bold uppercase bg-green-500 text-green-50 h-9 w-9 text-base flex items-center justify-center']")
    public WebElement profileIcon;

    @FindBy(xpath = "//div[@class='min-w-32 animate-fade-in rounded-md bg-white py-4 shadow-common']//a")
    public WebElement signOutBT;
}
