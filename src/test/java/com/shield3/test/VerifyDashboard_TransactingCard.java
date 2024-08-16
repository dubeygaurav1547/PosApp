package com.shield3.test;

import com.shield3.framework.base.BaseSetup;
import com.shield3.framework.controller.DashboardController;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class VerifyDashboard_TransactingCard extends BaseSetup {

    DashboardController dashboard;
    SoftAssert softAssert;
//        Assert softAssert;




    @Test(priority = 1)
    public void verifyTransactingCard() throws Exception {
        softAssert = new SoftAssert();
        dashboard = shield().dashboardController();
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.dashboardHeader,"header"),"Dashboard");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.transactingHeader,"subheader"),"Transacting");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.transactingHeadline,"headline"),"Transactions");
        softAssert.assertTrue(dashboard.getText(dashboard.dashboard.transactingDescription,"description").contains(" transactions (24h)"));
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.transactingCardBT,"API Key"),"API Key");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyAPI_KeyModal() throws Exception {
        softAssert = new SoftAssert();
        dashboard.clickObject(dashboard.dashboard.transactingCardBT,"API key");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.apiKeyModalHeader,"api key modal header"),"API Key");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.apiKeyModalElement.get(0),"element 1"),"Select Network");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.apiKeyModalElement.get(1),"element 2"),"API Key");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.apiKeyModalElement.get(2),"element 3"),"HTTP RPC URL");
        softAssert.assertEquals(dashboard.getText(dashboard.dashboard.apiKeyModalElement.get(3),"element 4"),"WS RPC URL");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyAPI_KeyModalNetwork() throws Exception {
        softAssert = new SoftAssert();
        ArrayList <String> networks = dashboard.getAllNetwork();
        softAssert.assertTrue(networks.contains("Mainnet Mainnet"));
        softAssert.assertTrue(networks.contains("Polygon Mainnet"));
        softAssert.assertTrue(networks.contains("Binance Smart Chain Mainnet"));
        softAssert.assertTrue(networks.contains("Amoy Testnet"));
        softAssert.assertTrue(networks.contains("Sepolia Testnet"));
        softAssert.assertTrue(networks.contains("Arbitrum Mainnet"));
        softAssert.assertTrue(networks.contains("Arbitrum Sepolia Testnet"));
        softAssert.assertTrue(networks.contains("Optimism Mainnet"));
        softAssert.assertTrue(networks.contains("Base Mainnet"));
        softAssert.assertTrue(networks.contains("Base Testnet"));
        softAssert.assertTrue(networks.contains("Scroll Mainnet"));
        softAssert.assertTrue(networks.contains("Scroll Testnet"));
        dashboard.clickObject(dashboard.dashboard.apiKeyCrossButton,"cross icon");
        softAssert.assertAll();
    }
}