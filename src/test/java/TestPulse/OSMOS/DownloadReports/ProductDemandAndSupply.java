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

public class ProductDemandAndSupply extends BaseTest {
    private PageSetupPage pageSetupPage;
    private AnalyticsPage analyticsPage;
    private AdFormatSetupPage adFormatSetupPage;
    private SegmentManagerPage segmentManagerPage;
    private HomePage homePage;
    private Utility utils;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrlSandbox);
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
    @Feature("This flow belongs to download reports in Product Demand and Supply")
    @Story("Download Gap Analytics Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Gap Analytics Report in Product Demand and Supply")
    public void DownloadGapAnalyticsReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDemandAndSupply();
                analyticsPage.ClickOnDemandAndSupplyGapTableView();
                analyticsPage.ClickOnProductDemandAndSupplyGapAnalyticsDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Gap Analytics Report Download Within 2 Minutes In Product Demand and Supply");
                    softAssert.fail("Failed to load Gap Analytics Report Download Within 2 Minutes In Product Demand and Supply");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Product Demand and Supply")
    @Story("Download Budget Utilization Trend Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Budget Utilization Trend Report in Product Demand and Supply")
    public void DownloadBudgetUtilizationTrendReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDemandAndSupply();
                analyticsPage.ClickOnProductDemandAndSupplyBudgetUtilizationTrendDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Budget Utilization Trend Report Download Within 2 Minutes In Product Demand and Supply");
                    softAssert.fail("Failed to load Budget Utilization Trend Report Download Within 2 Minutes In Product Demand and Supply");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Product Demand and Supply")
    @Story("Download Seasonality Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Seasonality Report in Product Demand and Supply")
    public void DownloadSeasonalityReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDemandAndSupply();
                analyticsPage.ClickOnProductDemandAndSupplySeasonalityDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Seasonality Report Download Within 2 Minutes In Product Demand and Supply");
                    softAssert.fail("Failed to load Seasonality Report Download Within 2 Minutes In Product Demand and Supply");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Product Demand and Supply")
    @Story("Download Advertiser Overall GMV Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Advertiser Overall GMV Report in Product Demand and Supply")
    public void DownloadAdvertiserOverallGMVReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDemandAndSupply();
                analyticsPage.ClickOnProductDemandAndSupplyAdvertiserOverallGMVDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Advertiser Overall GMV Report Download Within 2 Minutes In Product Demand and Supply");
                    softAssert.fail("Failed to load Advertiser Overall GMV Report Download Within 2 Minutes In Product Demand and Supply");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Product Demand and Supply")
    @Story("Download Search Demand Planner Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Search Demand Planner Report in Product Demand and Supply")
    public void DownloadSearchDemandPlannerReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDemandAndSupply();
                analyticsPage.ClickOnProductDemandAndSupplySearchDemandPlannerDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Search Demand Planner Report Download Within 2 Minutes In Product Demand and Supply");
                    softAssert.fail("Failed to load Search Demand Planner Report Download Within 2 Minutes In Product Demand and Supply");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Product Demand and Supply")
    @Story("Download Category Performance Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Category Performance Report in Product Demand and Supply")
    public void DownloadCategoryPerformanceReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDemandAndSupply();
                analyticsPage.ClickOnProductDemandAndSupplyCategoryPerformanceReportDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Category Performance Report Download Within 2 Minutes In Product Demand and Supply");
                    softAssert.fail("Failed to load Category Performance Report Download Within 2 Minutes In Product Demand and Supply");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }


}