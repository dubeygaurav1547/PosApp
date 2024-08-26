package com.posapp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.posapp.framework.base.BaseSetup;
import com.posapp.framework.utils.ReuseableFunction;

public class HassanTest extends BaseSetup{
    static ReuseableFunction reu = new ReuseableFunction();
    @Test  
    public void hassanText() throws Exception {
        	
        
    	ruseable.clickObject(ruseable.getDriver().findElement(By.xpath("//button[@class='brown-btn' and text()='POS']")),"POS");
    	ruseable.clickObject(ruseable.getDriver().findElement(By.xpath("//label[text()='Customer Mobile']/ancestor::div[@class='MuiBox-root css-0']//button[@title='Open']")),"phoneNumber");
        reu.clickObject(ruseable.getDriver().findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiAutocomplete-paper css-t4hinj']//li[1]")),"phoneNumber first option");
        ruseable.clickObject(ruseable.getDriver().findElement(By.xpath("//label[text()='Ref.Hospital']/ancestor::div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-3 css-ja4s3e\"]//button[@title=\"Open\"]")),"hospital");
        ruseable.clickObject(ruseable.getDriver().findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiAutocomplete-paper css-t4hinj']//li[1]")),"hospital first option");
        ruseable.clickObject(ruseable.getDriver().findElement(By.xpath("//label[text()='Ref.Doctor']/ancestor::div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-3 css-ja4s3e\"]//button[@title=\"Open\"]")),"doctor");
        ruseable.clickObject(ruseable.getDriver().findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiAutocomplete-paper css-t4hinj']//li[4]")),"doctor fourth option");
        ruseable.clickObject(ruseable.getDriver().findElement(By.xpath("//span[text()='Items Entry']/ancestor::div[@class=\"d-lg-flex d-md-flex d-flex justify-content-between align-items-center pos-card-header\"]//button[text()='Find branch items']")),"Find branch items");
        ruseable.clickObject(ruseable.getDriver().findElement(By.xpath("//span[text()='Branch Items']/ancestor::div[@class=\"mx-6 MuiBox-root css-tht3cf\"]//button[@title=\"Open\"]")),"search item");
        ruseable.clickObject(ruseable.getDriver().findElement(By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiAutocomplete-paper css-t4hinj']//li[text()='CONTACT LENS']")),"CONTACT LENS");
        Thread.sleep(2000);
        ruseable.waitForElement(ReuseableFunction.WaitCondition.toBeInvisible,reu.getDriver().findElement(By.xpath("//div[@class=\"MuiBox-root css-1cc6fge\"]/span")));
        ruseable.clickObject(ruseable.getDriver().findElement(By.xpath("(//td[@data-index=\"4\" and text()='3']/preceding-sibling::td[@data-index=\"0\"])[1]/div")),"lens");
        Thread.sleep(1000);
        ruseable.waitForElement(ReuseableFunction.WaitCondition.toBeInvisible,reu.getDriver().findElement(By.xpath("//div[@class=\"MuiBox-root css-1cc6fge\"]/span")));
        ruseable.clickObject(reu.getDriver().findElement(By.xpath("(//td[@data-index=\"4\" and text()='2']/preceding-sibling::td[@data-index=\"0\"])[1]/div")),"lens");
        Thread.sleep(1000);
        ruseable.waitForElement(ReuseableFunction.WaitCondition.toBeInvisible,reu.getDriver().findElement(By.xpath("//div[@class=\"MuiBox-root css-1cc6fge\"]/span")));
        Thread.sleep(1000);
        ruseable.waitForElement(ReuseableFunction.WaitCondition.toBeInvisible,reu.getDriver().findElement(By.xpath("//div[@class='Toastify']//div[text()]")));
        ruseable.clickObject(reu.getDriver().findElement(By.xpath("//span[text()='Branch Items']/ancestor::div[@class=\"mx-6 MuiBox-root css-tht3cf\"]//button[@aria-label=\"close\"]")),"item search modal cross");
        ruseable.typeValue(reu.getDriver().findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div[6]/div/div/div/div/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[16]/input")),"warranty 1","123");
        ruseable.typeValue(reu.getDriver().findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div[6]/div/div/div/div/div/div[2]/div/div/div[1]/table/tbody/tr[2]/td[16]/input")),"warranty 2","123");
        ruseable.clickObject(reu.getDriver().findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[1]/div[7]/button")),"payment");
        Thread.sleep(5000);
        ruseable.clickObject(reu.getDriver().findElement(By.xpath("/html/body/div[5]/div[3]/div[1]/div/div[1]/div[2]/div[1]/button")),"add");
        Thread.sleep(500);
        ruseable.waitForElement(ReuseableFunction.WaitCondition.toBeInvisible,reu.getDriver().findElement(By.xpath("//div[@class=\"MuiBox-root css-wtfv8c\"]/span/img")));
        ruseable.clickObject(reu.getDriver().findElement(By.xpath("//span[text()='Payment Data']/ancestor::div[@class=\"p-2 MuiBox-root css-6jk8fa\"]//button[text()='Post']")),"Post");
        ruseable.clickObject(reu.getDriver().findElement(By.xpath("//div[@aria-labelledby=\"alert-dialog-title\"]//button[text()='Ok']")),"Ok");
        ruseable.waitForElement(ReuseableFunction.WaitCondition.toBeInvisible,reu.getDriver().findElement(By.xpath("//div[@class=\"MuiDialogActions-root MuiDialogActions-spacing css-tt5p9o\"]//span")));

    }
}


