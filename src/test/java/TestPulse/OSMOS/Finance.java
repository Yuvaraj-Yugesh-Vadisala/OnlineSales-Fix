package TestPulse.OSMOS;

import BaseClass.BaseTest;
import PagesPulse.OSMOS.FinancePage;
import PagesPulse.OSMOS.Utility;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class Finance extends BaseTest {
    private FinancePage financepage;
    private Utility utils;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrl);
        financepage = new FinancePage(getDriver());
        utils = new Utility(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "1e2f2aff7100c4ad50b185a1738aafd3");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }

    @BeforeMethod
    public void ResetPage(ITestResult result) throws InterruptedException, AWTException {
        getDriver().navigate().to(OsmosPulseUrl);
        if (!Language.equals("en")) {
            utils.ChangeLanguage();
        }
         System.out.println("Thread ID: " + Thread.currentThread().getId()+ " - Started @Test: " + result.getMethod().getMethodName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Finished @Test: " + result.getMethod().getMethodName());
    }

    @AfterClass
    public void TearDown() {
        getDriver().quit();
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Finance Tab Operation")
    @Story("Finance-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Finance Dashboard Operations" , priority = 0)
    public void FinanceDashboardOperations() throws RuntimeException {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                financepage.ClickOnFinanceTab();
                financepage.ClickOnFinanceDashboard();
                financepage.ClickOnAdvertiserWalletSnapshotDownloadButton();
                utils.ClickOnPopUpCloseButton();
                if (financepage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Advertiser wallet snapshot Download Within 2 Minutes In finance dashboard");
                    softAssert.fail("Failed to load Advertiser wallet snapshot Download Within 2 Minutes In finance dashboard");
                }
                Thread.sleep(1500);
                financepage.ClickOnDownloadDismissButton();
                financepage.EnterAdvertiserName("Single");
                Thread.sleep(1500);
                financepage.ClickOnTheFirstItemInWalletNameColumn();
                financepage.ClickingOnTransactionLogRefreshButton();
                Thread.sleep(1500);
                financepage.ClickOnTransactionLogsDownloadButton();
                utils.ClickOnPopUpCloseButton();
                if (financepage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load single wallet transaction logs download button Within 2 Minutes In Advertiser wallet snapshot");
                    softAssert.fail("Failed to load single wallet transaction logs download button Within 2 Minutes In Advertiser wallet snapshot");
                }
                financepage.ClickOnDownloadDismissButton();
                utils.ClickOnCrossButton();
                financepage.EnterAdvertiserName("Multi");
                Thread.sleep(1500);
                financepage.ClickOnTheFirstItemInWalletNameColumn();
                if (!financepage.ValidateVisibilityOfWalletDropdown()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Multi wallet page is not displayed");
                    softAssert.fail("Multi wallet page is not displayed");
                }
                financepage.ClickOnTheTransactionalLogsTab();
                financepage.ClickingOnTransactionLogRefreshButton();
                Thread.sleep(1500);
                financepage.ClickOnTransactionLogsDownloadButton();
                utils.ClickOnPopUpCloseButton();
                if (financepage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load multi wallet transaction logs download button Within 2 Minutes in Advertiser wallet snapshot");
                    softAssert.fail("Failed to load multi wallet transaction logs download button Within 2 Minutes In Advertiser wallet snapshot");
                }
                financepage.ClickOnDownloadDismissButton();
                financepage.ClickOnWalletTab();
                financepage.ClickOnIndividualTransactionLogButton();
                financepage.ClickOnTransactionLogsDownloadButton();
                utils.ClickOnPopUpCloseButton();
                if (financepage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load multi wallet transaction logs for individual wallet download button Within 2 Minutes in Advertiser wallet snapshot");
                    softAssert.fail("Failed to load multi wallet transaction logs for individual wallet download button Within 2 Minutes In Advertiser wallet snapshot");
                }
                financepage.ClickOnDownloadDismissButton();
                utils.ClickOnCrossButtonLevel2();
                utils.ClickOnCrossButton();
                financepage.ClickOnTransactionDownloadButton();
            } catch (Exception  e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        softAssert.assertAll();
        }));
    }
    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Finance Advertiser Management tab operations")
    @Story("Finance-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Finance Advertiser Management Operations" , priority = 1)
    public void FinanceAdvertiserManagementOperations() {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                financepage.ClickOnFinanceTab();
                financepage.ClickOnFinanceAdvertiserManagement();
                financepage.ClickOnAdvertisersDownloadButton();
                utils.ClickOnPopUpCloseButton();
                if (financepage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Advertisers Download Within 2 Minutes In Finance Advertiser Management page");
                    softAssert.fail("Failed to load Advertisers Download Within 2 Minutes In Finance Advertiser Management page");
                }
                financepage.ClickOnDownloadDismissButton();
                financepage.EnterAdvertiserName("Single");
                Thread.sleep(1500);
                financepage.ClickOnFirstTableColumnItem();
                financepage.ClickingOnTransactionLogRefreshButton();
                Thread.sleep(1500);
                financepage.ClickOnTransactionLogsDownloadButton();
                utils.ClickOnPopUpCloseButton();
                if (financepage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load single wallet transaction logs download button Within 2 Minutes in Finance Advertiser Management page");
                    softAssert.fail("Failed to load single wallet transaction logs download button Within 2 Minutes In Finance Advertiser Management page");
                }
                financepage.ClickOnDownloadDismissButton();
                Thread.sleep(1500);
                utils.ClickOnCrossButton();
                financepage.EnterAdvertiserName("Multi");
                Thread.sleep(1500);
                financepage.ClickOnFirstTableColumnItem();
                if (!financepage.ValidateVisibilityOfWalletDropdown()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Wallet dropdown is not displayed");
                    softAssert.fail(" Wallet dropdown is not displayed");
                }
                financepage.ClickOnTheTransactionalLogsTab();
                financepage.ClickingOnTransactionLogRefreshButton();
                Thread.sleep(1500);
                financepage.ClickOnTransactionLogsDownloadButton();
                utils.ClickOnPopUpCloseButton();
                if (financepage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load multi wallet transaction logs download button Within 2 Minutes in Finance Advertiser Management page");
                    softAssert.fail("Failed to load multi wallet transaction logs download button Within 2 Minutes In Finance Advertiser Management page");
                }
            } catch (Exception e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));

    }
}
