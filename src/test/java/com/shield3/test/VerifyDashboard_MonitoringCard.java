package com.shield3.test;

import com.shield3.framework.base.BaseSetup;
import com.shield3.framework.controller.DashboardController;
import com.shield3.framework.controller.LoginPageController;
import com.shield3.framework.data.Data;
import com.shield3.framework.utils.ReuseableFunction;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyDashboard_MonitoringCard extends BaseSetup {

    DashboardController dashboard;
    SoftAssert softAssert;
//    Assert softAssert;
    String countofAddress;
    int beforeAdditionAddressCount;

    @Test(priority = 0)
    public void verifySidebar() throws Exception {
        softAssert = new SoftAssert();
        dashboard = shield().dashboardController();
        String actualSidebar[] = dashboard.getSideBarElement();
        softAssert.assertEquals(actualSidebar[0],"Dashboard");
        softAssert.assertEquals(actualSidebar[1],"Policies");
        softAssert.assertEquals(actualSidebar[2],"Workflows");
        softAssert.assertEquals(actualSidebar[3],"Analytics");
        softAssert.assertEquals(actualSidebar[4],"Administration");
        softAssert.assertEquals(actualSidebar[5],"Resources");
        softAssert.assertEquals(actualSidebar[6],"Notifications");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void verifyMonitoringCard() throws Exception {
        softAssert = new SoftAssert();
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.dashboardHeader,"header"),"Dashboardd");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.monitoringHeader,"subheader"),"Monitoring");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.monitoringHeadline,"headline"),"Monitored Addresses");
        countofAddress = dashboard.getText(dashboard.dashboard.monitoringDescription.get(0),"description1");
        softAssert.assertTrue(countofAddress.contains("addresses"));
        softAssert.assertTrue(dashboard.getText(dashboard.dashboard.monitoringDescription.get(1),"description2").contains("transactions (24h)"));
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.manageAddressesBT,"manage address button"),"Manage Addresses");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyManageAddressesModal() throws Exception {
        softAssert = new SoftAssert();
        dashboard.waitForElement(ReuseableFunction.WaitCondition.toBeInvisible,dashboard.dashboard.dashboardCardLoader.get(0));
        dashboard.clickObject(dashboard.dashboard.manageAddressesBT,"Manage Addresses");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.manageAddressesModalHeader,"Manage Addresses modal header"),"Monitored Addresses");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.monitoringHeadline,"headline"),"Monitored Addresses");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.downloadSimpleFileBT,"download button"),"Download Sample File");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.uploadCSVBT,"upload button"),"Upload CSV");
        beforeAdditionAddressCount = dashboard.dashboard.allAddresses.size();
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.addNewAddressBT,"add new address"),"Add New Address");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyAddNewAddressUI() throws Exception {
        softAssert = new SoftAssert();
        dashboard.clickObject(dashboard.dashboard.addNewAddressBT,"add new address");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.addNewAddressHeader,"addNewAddressHeader"),"Add New Address");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.addNewAddressLabel.get(0),"Label 1"),"Import previous transactions");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.addNewAddressLabel.get(1),"Label 2"),"Owned address");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.enterAddressLabel,"enterAddressLabel"),"Address");
        softAssert.assertEquals(dashboard.getattribute(dashboard.dashboard.enterAddressBox,"add new address", "placeholder"),"Enter the address");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.enterOptionalLabel,"enterAddressLabel"),"Label (Optional)");
        softAssert.assertEquals(dashboard.getattribute(dashboard.dashboard.enterOptionalBox,"add new address", "placeholder"),"Enter a label for this address");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.saveButton,"save button"),"Save");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.cancelButton,"cancel button"),"Cancel");
        dashboard.clickObject(dashboard.dashboard.cancelButton,"cancel");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void verifyAddNewAddressFunctionality() throws Exception {
        softAssert = new SoftAssert();
        dashboard.clickObject(dashboard.dashboard.addNewAddressBT,"add new address");
        softAssert.assertEquals(dashboard.isSelected(dashboard.dashboard.ownedCheckbox,"owned address checkbox"),false);
        softAssert.assertEquals(dashboard.isSelected(dashboard.dashboard.importCheckbox,"import previous tx checkbox"),false);
        dashboard.enterNewAddress();
        dashboard.waitForElement(ReuseableFunction.WaitCondition.toBeVisible,dashboard.dashboard.addedAddress);
        softAssert.assertTrue(beforeAdditionAddressCount<dashboard.dashboard.allAddresses.size());
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.addedAddressData.get(0),"new address name"), Data.addressName);
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.addedAddressData.get(1),"new address"), Data.address);
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.newAddressLabel,"new address label"), "Owned address");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void verifyErrorMsgForDuplicateAddress() throws Exception {
        softAssert = new SoftAssert();
        dashboard.enterNewAddress();
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.errorMsg,"error msg for duplicate address"), "Address already exits!");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void verifyDeleteAddressModal() throws Exception {
        softAssert = new SoftAssert();
        dashboard.clickObject(dashboard.dashboard.deleteBTforAddedAddress,"delete button for added address");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.deleteModalHeader,"delete modal header"), "Delete Address");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.deleteModalDescription,"new address"), "Are you sure you want to permanently delete this Address?");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.deleteModalButtons.get(0),"Cancel button"), "Cancel");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.deleteModalButtons.get(1),"Delete Address button"), "Delete Address");
        dashboard.deleteAddress();
        dashboard.waitForElement(ReuseableFunction.WaitCondition.toBeInvisible,dashboard.dashboard.allAddresses.get(0));
        softAssert.assertTrue(beforeAdditionAddressCount==dashboard.dashboard.allAddresses.size());
        dashboard.clickObject(dashboard.dashboard.manageAddCrossButton,"cross");
        softAssert.assertAll();
    }
}