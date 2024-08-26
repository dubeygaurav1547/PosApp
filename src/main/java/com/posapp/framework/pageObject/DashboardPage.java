package com.posapp.framework.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage {

    @FindBy(xpath = "//div[@class='mt-10 flex flex-col gap-10']//span")
    public List <WebElement> sidebarElements;

    @FindBy(xpath = "//div[@class='flex w-full flex-col gap-6']//h3")
    public WebElement dashboardHeader;

    @FindBy(xpath = "//div[@class='rounded-md bg-white shadow-common flex flex-col gap-6 shadow-none']//h5")
    public WebElement TxSimulatorHeader;

    @FindBy(xpath = "//span[text()='Monitoring']")
    public WebElement monitoringHeader;

    @FindBy(xpath = "//span[text()='Monitoring']/ancestor::div[@class='relative h-[256px] rounded-xl border border-gray-300']//div[@class='text-2xl font-extrabold']")
    public WebElement monitoringHeadline;

    @FindBy(xpath = "//span[text()='Monitoring']/ancestor::div[@class='relative h-[256px] rounded-xl border border-gray-300']//div[@class='pt-2 text-gray-700']")
    public List <WebElement> monitoringDescription;

    @FindBy(xpath = "//div[@class='absolute z-1 flex h-full w-full items-center justify-center bg-white bg-opacity-80']/*")
    public List <WebElement> dashboardCardLoader;

    @FindBy(xpath = "//div[@class='inline-flex']")
    public List <WebElement> cardToolTipIcon;

    @FindBy(xpath = "//div[@role='tooltip']")
    public WebElement toolTipText;

    @FindBy(xpath = "//button[@type='button' and text()='Manage Addresses']")
    public WebElement manageAddressesBT;

    @FindBy(xpath = "//div[@class='p-16 mx-auto max-h-screen/90 w-full overflow-auto rounded-md bg-white']//h3/span")
    public WebElement manageAddressesModalHeader;

    @FindBy(xpath = "//div[@class='p-16 mx-auto max-h-screen/90 w-full overflow-auto rounded-md bg-white']//button/a")
    public WebElement downloadSimpleFileBT;

    @FindBy(xpath = "(//div[@class='p-16 mx-auto max-h-screen/90 w-full overflow-auto rounded-md bg-white']//button)[2]")
    public WebElement uploadCSVBT;

    @FindBy(xpath = "//div[@class='p-16 mx-auto max-h-screen/90 w-full overflow-auto rounded-md bg-white']//div[@class='flex justify-between']/span")
    public WebElement addNewAddressBT;

    @FindBy(xpath = "//form[@class='relative flex w-[760px] flex-col gap-[11px] rounded-lg bg-gray-100 px-3 py-[6px]']//div[@class='font-inter text-base font-extrabold']")
    public WebElement addNewAddressHeader;

    @FindBy(xpath = "//form[@class='relative flex w-[760px] flex-col gap-[11px] rounded-lg bg-gray-100 px-3 py-[6px]']//span[@class='text-sm font-medium']")
    public List <WebElement> addNewAddressLabel;

    @FindBy(xpath = "//form[@class='relative flex w-[760px] flex-col gap-[11px] rounded-lg bg-gray-100 px-3 py-[6px]']//div[@class='flex w-full flex-col gap-2 ']//span")
    public  WebElement enterAddressLabel;

    @FindBy(xpath = "//form[@class='relative flex w-[760px] flex-col gap-[11px] rounded-lg bg-gray-100 px-3 py-[6px]']//div[@class='flex w-full flex-col gap-2 ']//input")
    public  WebElement enterAddressBox;

    @FindBy(xpath = "//form[@class='relative flex w-[760px] flex-col gap-[11px] rounded-lg bg-gray-100 px-3 py-[6px]']//div[@class='flex w-full flex-col gap-2']/span")
    public  WebElement enterOptionalLabel;

    @FindBy(xpath = "//form[@class='relative flex w-[760px] flex-col gap-[11px] rounded-lg bg-gray-100 px-3 py-[6px]']//div[@class='flex w-full flex-col gap-2']/input")
    public  WebElement enterOptionalBox;

    @FindBy(xpath = "//div[@class='absolute z-10 flex h-full w-full items-center justify-center overflow-hidden bg-white bg-opacity-80']/*")
    public  WebElement monitoredAddModalLoader;

    @FindBy(xpath = "//div[@class='flex gap-2 p-2']//span[text()='Owned address']/preceding-sibling::button")
    public  WebElement ownedCheckbox;

    @FindBy(xpath = "//div[@class='flex gap-2 p-2']//span[text()='Import previous transactions']/preceding-sibling::button")
    public  WebElement importCheckbox;

    @FindBy(xpath = "//div[@class='flex gap-2 pt-[30px]']//button[@type='submit']")
    public  WebElement saveButton;

    @FindBy(xpath = "//div[@class='flex gap-2 pt-[30px]']//button[@type='button']")
    public  WebElement cancelButton;

    @FindBy(xpath = "//div[contains(@class,'flex flex-col gap-')]//div[@class='relative flex flex-col']")
    public  List <WebElement> allAddresses;

    @FindBy(xpath = "//div[@class='flex flex-col gap-0 w-[760px] ']//div[@class='relative flex flex-col'][1]//span")
    public  List <WebElement> addedAddressData;

    @FindBy(xpath = "//div[@class='flex flex-col gap-0 w-[760px] ']//div[@class='relative flex flex-col'][1]//div[@class='flex items-center gap-2']/div")
    public WebElement newAddressLabel;

    @FindBy(xpath = "//div[@class='absolute left-0 top-0 z-2 flex h-full w-full items-center justify-center bg-white bg-opacity-80']/*")
    public WebElement addNewAddressLoader;

    @FindBy(xpath = "//*[@class='h-6 w-6 animate-spin']")
    public WebElement addressLoader;

    @FindBy(xpath = "//div[contains(@class,'flex flex-col gap-')]//div[@class='relative flex flex-col']//span[text()='automation Address']")
    public WebElement addedAddress;

    @FindBy(xpath = "//div[@class='flex mt-[-10px] text-red-600 items-center gap-2 font-medium']/span")
    public WebElement errorMsg;

    @FindBy(xpath = "//div[@class='relative flex flex-col']//span[text()='automation Address']/ancestor::div[@class='relative flex flex-col']//button[@class='px-[32px]']/*")
    public WebElement deleteBTforAddedAddress;

    @FindBy(xpath = "//div[@class='space-y-6 ']//div[@class='py-6 font-rajdhani text-3xl font-semibold']")
    public WebElement deleteModalHeader;

    @FindBy(xpath = "//div[@class='space-y-6 ']//div[@class='text-center text-base font-medium text-gray-500']")
    public WebElement deleteModalDescription;

    @FindBy(xpath = "//div[@class='space-y-6 ']//div[@class='flex justify-end gap-2 pt-10']/button")
    public List <WebElement> deleteModalButtons;

    @FindBy(xpath = "//span[text()='Transacting']")
    public WebElement transactingHeader;

    @FindBy(xpath = "//span[text()='Transacting']/ancestor::div[@class='relative h-[256px] rounded-xl border border-gray-300']//div[@class='text-2xl font-extrabold']")
    public WebElement transactingHeadline;

    @FindBy(xpath = "//span[text()='Transacting']/ancestor::div[@class='relative h-[256px] rounded-xl border border-gray-300']//div[@class='pt-2 text-gray-700']")
    public WebElement transactingDescription;

    @FindBy(xpath = "//span[text()='Transacting']/ancestor::div[@class='relative h-[256px] rounded-xl border border-gray-300']//button")
    public WebElement transactingCardBT;

    @FindBy(xpath = "//div[contains(@class,'absolute flex h-full w-full items-center ')]")
    public WebElement apiKeyModalLoader;

    @FindBy(xpath = "//div[@class='relative max-w-220']//h3")
    public WebElement apiKeyModalHeader;

    @FindBy(xpath = "//div[@class='relative max-w-220']//div[@class='flex flex-col gap-2']/span")
    public List <WebElement> apiKeyModalElement;

    @FindBy(xpath = "//div[@class='relative max-w-220']//div[@class='flex flex-col gap-2']//button[@data-state='closed']")
    public WebElement selectNetworkBT;

    @FindBy(xpath = "//div[@class='relative max-w-220']//div[@class='flex flex-col gap-2']//div[@data-state='open' and @id]//div[@class='flex items-center gap-2']")
    public List <WebElement> allNetwork;

    @FindBy(xpath = "//div[@class='absolute z-1 flex h-full w-full items-center justify-center bg-white bg-opacity-80']/*")
    public List <WebElement> cardsLoader;

    @FindBy(xpath = "//div[@class='relative max-w-220']/button")
    public WebElement apiKeyCrossButton;

    @FindBy(xpath = "//div[@class='relative max-w-220 false']/button")
    public WebElement manageAddCrossButton;

    @FindBy(xpath = "//div[@class='rounded-md bg-white shadow-common flex flex-col gap-6 shadow-none']//h5")
    public WebElement TransactionSimulatorHeader;

    @FindBy(xpath = "//div[contains(@class,'rounded-md bg-white shadow-common flex flex-col gap-6 shadow-none')]//div[text()='Transaction Type']")
    public WebElement TSElementTxType;

    @FindBy(xpath = "//div[contains(@class,'rounded-md bg-white shadow-common flex flex-col gap-6 shadow-none')]//div[text()='Policy Interactions']")
    public WebElement TSElementPI;

    @FindBy(xpath = "//div[contains(@class,'rounded-md bg-white shadow-common flex flex-col gap-6 shadow-none')]//button[@type='submit']")
    public WebElement submitTestTransactionBt;

    @FindBy(xpath = "//div[contains(@class,'rounded-md bg-white shadow-common flex flex-col gap-6 shadow-none')]//div[text()='Transaction Type']/following-sibling::div")
    public WebElement TSElementTxTypeBT;

    @FindBy(xpath = "//div[contains(@class,'rounded-md bg-white shadow-common flex flex-col gap-6 shadow-none')]//div[text()='Policy Interactions']/following-sibling::div")
    public WebElement TSElementPIBt;
}
