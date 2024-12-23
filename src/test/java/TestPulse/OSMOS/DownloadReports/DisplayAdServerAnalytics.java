package TestPulse.OSMOS.DownloadReports;

import BaseClass.BaseTest;
import PagesPulse.CampaignTemplatePage;
import PagesPulse.OSMOS.*;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class DisplayAdServerAnalytics extends BaseTest {
    private PageSetupPage pageSetupPage;
    private AnalyticsPage analyticsPage;
    private AdFormatSetupPage adFormatSetupPage;
    private SegmentManagerPage segmentManagerPage;
    private InventorySetupPage inventorySetupPage;
    private HomePage homePage;
    private Utility utils;

    private CampaignTemplatePage campaignTemplatePage;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrlSandbox);
        inventorySetupPage = new InventorySetupPage(getDriver());
        pageSetupPage = new PageSetupPage(getDriver());
        adFormatSetupPage = new AdFormatSetupPage(getDriver());
        segmentManagerPage = new SegmentManagerPage(getDriver());
        homePage = new HomePage(getDriver());
        analyticsPage = new AnalyticsPage(getDriver());
        utils = new Utility(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "fabbae24885e81b2872c2379e563ea7a");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }

    @BeforeMethod
    public void ResetPage() throws InterruptedException, AWTException {
        getDriver().navigate().to(OsmosPulseUrlSandbox);
        if (!Language.equals("en")) {
            utils.ChangeLanguage();
        }
    }

        @AfterClass
    public void TearDown() {
        getDriver().quit();

    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Display Ad Server Analytics")
    @Story("Download Page Level Performance Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Page Level Performance Report in Display Ad Server Analytics")
    public void DownloadPageLevelPerformanceReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickAdServerAnalytics();
                analyticsPage.ClickOnDisplayAdServerAnalyticsPageLevelPerformanceTableView();
                analyticsPage.ClickOnDisplayAdServerAnalyticsPageLevelPerformanceReportDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Page Level Performance Report Download Within 2 Minutes In Display Ad Server Analytics");
                    softAssert.fail("Failed to load Page Level Performance Report Download Within 2 Minutes In Display Ad Server Analytics");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Display Ad Server Analytics")
    @Story("Download Page Level Contribution Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Page Level Contribution Report in Display Ad Server Analytics")
    public void DownloadPageLevelContributionReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickAdServerAnalytics();
                analyticsPage.ClickOnDisplayAdServerAnalyticsPageLevelContributionDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Page Level Contribution Report Download Within 2 Minutes In Display Ad Server Analytics");
                    softAssert.fail("Failed to load Page Level Contribution Report Download Within 2 Minutes In Display Ad Server Analytics");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Display Ad Server Analytics")
    @Story("Download Ad Inventory Performance Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Ad Inventory Performance Report in Display Ad Server Analytics")
    public void DownloadAdInventoryPerformanceReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickAdServerAnalytics();
                analyticsPage.ClickOnDisplayAdServerAnalyticsAdInventoryPerformanceReportDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Ad Inventory Performance Report Download Within 2 Minutes In Display Ad Server Analytics");
                    softAssert.fail("Failed to load Ad Inventory Performance Report Download Within 2 Minutes In Display Ad Server Analytics");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }


}