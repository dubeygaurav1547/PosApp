package com.posapp.framework.controller;

import com.posapp.framework.data.Data;
import com.posapp.framework.pageObject.DashboardPage;
import com.posapp.framework.utils.ReuseableFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
//        typeValue(dashboard.enterAddressBox,"address",Data.address);
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

    public String getCardToolTipText(String cardName) throws Exception {
        if(cardName.equalsIgnoreCase("Monitoring")){
            mouseOverObject(dashboard.cardToolTipIcon.get(0),"Monitoring");
        } else if (cardName.equalsIgnoreCase("Transacting")) {
            mouseOverObject(dashboard.cardToolTipIcon.get(1),"Transacting");
        }
        return getText(dashboard.toolTipText,cardName+" tooltip");
    }

    public boolean TransactionSimulatorDD(String dropdownName) throws Exception {
        boolean flag = false;
        if(dropdownName.equalsIgnoreCase("Transaction Type")){
        String before_state = getattribute(dashboard.TSElementTxTypeBT,dropdownName+" dropdown","data-state");
        if(before_state.equals("closed")){
            clickObject(dashboard.TSElementTxTypeBT,dropdownName+" dropdown");
            String after_state = getattribute(dashboard.TSElementTxTypeBT,dropdownName+" dropdown","data-state");
            if (after_state.equals("open")){
                clickObject(dashboard.TSElementTxTypeBT,dropdownName+" dropdown");
                String close_state = getattribute(dashboard.TSElementTxTypeBT,dropdownName+" dropdown","data-state");
                if (close_state.equals("closed")){
                    flag=true;
                }
            }
        }
        }else if(dropdownName.equalsIgnoreCase("Policy Interactions")){
            String before_state = getattribute(dashboard.TSElementPIBt,dropdownName+" dropdown","data-state");
            if(before_state.equals("closed")){
                clickObject(dashboard.TSElementPIBt,dropdownName+" dropdown");
                String after_state = getattribute(dashboard.TSElementPIBt,dropdownName+" dropdown","data-state");
                if (after_state.equals("open")){
                    clickObject(dashboard.TSElementPIBt,dropdownName+" dropdown");
                    String close_state = getattribute(dashboard.TSElementPIBt,dropdownName+" dropdown","data-state");
                    if (close_state.equals("closed")){
                        flag=true;
                    }
                }
            }
        }else {
            System.err.print("please enter valid dropdown name");
        }
        return flag;
    }
}
