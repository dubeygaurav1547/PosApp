package com.shield3.framework.controller;

import com.shield3.framework.data.Data;
import com.shield3.framework.pageObject.DashboardPage;
import com.shield3.framework.utils.ReuseableFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class DashboardController extends ReuseableFunction {

    public DashboardPage dashboard = null;
    WebDriver driver;
    public DashboardController(WebDriver driver) {
        dashboard = PageFactory.initElements(driver, DashboardPage.class);
        this.driver=driver;
    }

    public String [] getSideBarElement() throws Exception {
        String sideBarEle[] = new String[dashboard.sidebarElements.size()];
        for(int i = 0; i<sideBarEle.length; i++){
            sideBarEle[i] = getText(dashboard.sidebarElements.get(i),"");
        }
        return sideBarEle;
    }

    public void enterNewAddress() throws Exception {
        typeValue(dashboard.enterAddressBox,"address",Data.address);
        typeValue(dashboard.enterOptionalBox,"address",Data.addressName);
        clickObject(dashboard.saveButton,"save button");
    }

    public void deleteAddress() throws Exception {
        clickObject(dashboard.deleteModalButtons.get(1),"Delete Address");
    }

    public ArrayList<String> getAllNetwork() throws Exception {
        clickObject(dashboard.selectNetworkBT,"API key");
        ArrayList <String> networks = new ArrayList<String>();
        for(int i=0;i<dashboard.allNetwork.size();i++){
            networks.add(i,getText(dashboard.allNetwork.get(i),"network "+i));
        }
        return networks;
    }
}
