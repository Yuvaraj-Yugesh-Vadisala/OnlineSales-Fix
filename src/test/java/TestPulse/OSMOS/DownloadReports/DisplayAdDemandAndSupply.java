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

public class DisplayAdDemandAndSupply extends BaseTest {
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
    @Feature("This flow belongs to download reports in Display Ad Demand and Supply")
    @Story("Download Demand and Supply Gap Analytics Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Demand and Supply Gap Analytics Report in Display Ad Demand and Supply")
    public void DownloadDemandAndSupplyGapAnalyticsReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDisplayAdDemandAndSupply();
                analyticsPage.ClickOnDisplayAdDemandAndSupplyGapAnalyticsTableView();
                analyticsPage.ClickOnDisplayAdDemandAndSupplyDemandAndSupplyGapAnalyticsDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Demand and Supply Gap Analytics Report Download Within 2 Minutes In Display Ad Demand and Supply");
                    softAssert.fail("Failed to load Demand and Supply Gap Analytics Report Download Within 2 Minutes In Display Ad Demand and Supply");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Display Ad Demand and Supply")
    @Story("Download Budget Utilization Trend Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Budget Utilization Trend Report in Display Ad Demand and Supply ")
    public void DownloadBudgetUtilizationTrendReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDisplayAdDemandAndSupply();
                analyticsPage.ClickOnDisplayAdDemandAndSupplyBudgetUtilizationTrendDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Budget Utilization Trend Report Download Within 2 Minutes In Display Ad Demand and Supply");
                    softAssert.fail("Failed to load Budget Utilization Trend Report Download Within 2 Minutes In Display Ad Demand and Supply");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Display Ad Demand and Supply")
    @Story("Download Seasonality Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Seasonality Report in Display Ad Demand and Supply")
    public void DownloadSeasonalityReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDisplayAdDemandAndSupply();
                analyticsPage.ClickOnDisplayAdDemandAndSupplySeasonalityDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Seasonality Report Download Within 2 Minutes In Display Ad Demand and Supply");
                    softAssert.fail("Failed to load Seasonality Report Download Within 2 Minutes In Display Ad Demand and Supply");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Display Ad Demand and Supply")
    @Story("Download 30-day Impression Projections Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download 30-day Impression Projections Report in Display Ad Demand and Supply")
    public void Download30dayImpressionProjectionsReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDisplayAdDemandAndSupply();
                analyticsPage.ClickOnDisplayAdDemandAndSupply30dayImpressionProjectionsDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load 30-day Impression Projections Report Download Within 2 Minutes In Display Ad Demand and Supply");
                    softAssert.fail("Failed to load 30-day Impression Projections Report Download Within 2 Minutes In Display Ad Demand and Supply");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Display Ad Demand and Supply")
    @Story("Download Supply Analytics Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Supply Analytics Report in Display Ad Demand and Supply")
    public void DownloadSupplyAnalyticsReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnDisplayAdDemandAndSupply();
                analyticsPage.ClickOnDisplayAdDemandAndSupplySupplyAnalyticsDownload();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }


}