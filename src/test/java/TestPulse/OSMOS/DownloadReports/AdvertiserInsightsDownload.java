package TestPulse.OSMOS.DownloadReports;

import BaseClass.BaseTest;
import PagesPulse.CampaignTemplatePage;
import PagesPulse.OSMOS.AnalyticsPage;
import PagesPulse.OSMOS.SegmentManagerPage;
import PagesPulse.OSMOS.Utility;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class AdvertiserInsightsDownload extends BaseTest {
    private AnalyticsPage analyticsPage;
    private SegmentManagerPage segmentManagerPage;
    private Utility utils;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrlSandbox);
        segmentManagerPage = new SegmentManagerPage(getDriver());
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
    @Feature("This flow belongs to download Metrics Comparison reports in advertiser insights")
    @Story("Download Metrics Comparison Reports In Advertiser Insights")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Metrics Comparison Report In Advertiser Insights")
    public void DownloadReportsInAdvertiserInsights()   {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnAdvertiserInsightsButton();
                analyticsPage.ClickOnMetricsComparisonDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Metrics Comparison Reports Download Within 2 Minutes ");
                    softAssert.fail("Failed to load Metrics Comparison Reports Download Within 2 Minutes");
                }             } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));

    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download budget utilization reports in advertiser insights")
    @Story("Download Budget Utilization Reports In Advertiser Insights")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Budget Utilization Report In Advertiser Insights")
    public void DownloadBudgetUtilizationReportInAdvertiserInsights() {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnAdvertiserInsightsButton();
                analyticsPage.ClickOnBudgetUtilizationDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Budget Utilization Report Download Within 2 Minutes ");
                    softAssert.fail("Failed to load Budget Utilization Report Download Within 2 Minutes");
                }             } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        }));
    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download budget utilization reports in advertiser snapshot")
    @Story("Download Budget Utilization Reports In Advertiser Snapshot")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Advertiser Snapshot Report In Advertiser Insights")
    public void DownloadAdvertiserSnapshotReportInAdvertiserInsights() {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnAdvertiserInsightsButton();
                analyticsPage.ClickOnAdvertiserSnapshotDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to Budget Utilization Report Download Within 2 Minutes ");
                    softAssert.fail("Failed to load Budget Utilization Report Download Within 2 Minutes");
                }             } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        }));

    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download budget utilization reports in movers and shakers")
    @Story("Download Movers And Shakers Report In Advertiser Insights")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Movers And Shakers Report In Advertiser Insights")
    public void DownloadMoversAndShakersReportInAdvertiserInsights() {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnAdvertiserInsightsButton();
                analyticsPage.ClickOnMoversAndShakersDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Movers And Shakers Report Download Within 2 Minutes ");
                    softAssert.fail("Failed to load Movers And Shakers Report Download Within 2 Minutes");
                }              } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        }));
    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download budget utilization reports in adFormat performance")
    @Story("Download AdFormat Performance Report In AdFormat Performance")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download AdFormat Performance Report In Advertiser Insights")
    public void DownloadAdFormatPerformanceReportInAdvertiserInsights() {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnAdvertiserInsightsButton();
                analyticsPage.ClickOnAdFormatPerformanceDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load AdFormat Performance Report Download Within 2 Minutes In Advertiser Insights");
                    softAssert.fail("Failed to load AdFormat Performance Report Download Within 2 Minutes In Advertiser Insights");
                }            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        }));
    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download channel performance in advertiser insights")
    @Story("Download Channel Performance Report In Advertiser Insights")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Channel Performance Report In Advertiser Insights")
    public void DownloadChannelPerformanceReportInAdvertiserInsights() {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnAdvertiserInsightsButton();
                analyticsPage.ClickOnChannelPerformanceReportDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Channel Performance Report Download Within 2 Minutes In Advertiser Insights");
                    softAssert.fail("Failed to load Channel Performance Report Download Within 2 Minutes In Advertiser Insights");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        }));
    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download campaign performance report in advertiser insights")
    @Story("Download Campaign Performance Report In Advertiser Insights")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Campaign Performance Report In Advertiser Insights")
    public void DownloadCampaignPerformanceReportInAdvertiserInsights() {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnAdvertiserInsightsButton();
                analyticsPage.ClickOnCampaignPerformanceReportDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Campaign Performance Report Download Within 2 Minutes In Advertiser Insights");
                    softAssert.fail("Failed to load Campaign Performance Report Download Within 2 Minutes In Advertiser Insights");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download advertiser dimension report in advertiser insights")
    @Story("Download Advertiser Dimension Report In Advertiser Insights")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Advertiser Dimension Report In Advertiser Insights")
    public void DownloadAdvertiserDimensionReportInAdvertiserInsights() {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickOnAdvertiserInsightsButton();
                analyticsPage.ClickOnAdvertiserDimensionReportDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Advertiser Dimension Report Download Within 2 Minutes In Advertiser Insights");
                    softAssert.fail("Failed to load Advertiser Dimension Report Download Within 2 Minutes In Advertiser Insights");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }
}

