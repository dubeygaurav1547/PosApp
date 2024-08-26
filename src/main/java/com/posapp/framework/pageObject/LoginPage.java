package com.posapp.framework.pageObject;

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

	@FindBy(xpath = "//input[@id='username']")
	public WebElement userNameInputBox;
	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordInputBox;
	@FindBy(xpath = "//div[@class='card-body']//button[@type='button']")
	public WebElement login;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement continueBT;

	@FindBy(xpath = "//h1[text()='Verify your email']")
	public WebElement verifyHeader;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement verifyEmailBT;

	@FindBy(xpath = "//div[@class='ml-[120px] flex flex-1 items-center justify-center gap-2 text-sm font-extrabold']")
	public WebElement breadcrumb;


	@FindBy(xpath = "//a[text()='System']")
	public WebElement profileIcon;

	@FindBy(xpath = "//a[text()='Log out']")
	public WebElement logOutBT;
}
