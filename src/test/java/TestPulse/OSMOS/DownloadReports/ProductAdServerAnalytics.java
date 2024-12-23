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

public class ProductAdServerAnalytics extends BaseTest {
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
    @Feature("This flow belongs to download reports in Product Ad Server Analytics")
    @Story("Download Page Level Contribution Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Page Level Contribution Report in Product Ad Server Analytics")
    public void DownloadPageLevelContributionReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickProductAdServerAnalytics();
                analyticsPage.ClickOnProductAdServerAnalyticsPageLevelContributionDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Page Level Contribution Report Download Within 2 Minutes In Product Ad Server Analytics");
                    softAssert.fail("Failed to load Page Level Contribution Report Download Within 2 Minutes In Product Ad Server Analytics");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Product Ad Server Analytics")
    @Story("Download Daily Page Performance Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Daily Page Performance Report in Product Ad Server Analytics")
    public void DownloadDailyPagePerformanceReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickProductAdServerAnalytics();
                analyticsPage.ClickOnProductAdServerAnalyticsDailyPagePerformanceReportDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Daily Page Performance Report Download Within 2 Minutes In Product Ad Server Analytics");
                    softAssert.fail("Failed to load Daily Page Performance Report Download Within 2 Minutes In Product Ad Server Analytics");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Product Ad Server Analytics")
    @Story("Download SKU By Hour Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download SKU By Hour Report in Product Ad Server Analytics")
    public void DownloadSKUByHourReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickProductAdServerAnalytics();
                analyticsPage.ClickOnProductAdServerAnalyticsSKUByHourDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load SKU By Hour Report Download Within 2 Minutes In Product Ad Server Analytics");
                    softAssert.fail("Failed to load SKU By Hour Report Download Within 2 Minutes In Product Ad Server Analytics");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to download reports in Product Ad Server Analytics")
    @Story("Download Device Performance Report")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Device Performance Report in Product Ad Server Analytics")
    public void DownloadDevicePerformanceReport() {
        utils.RetryOnFailOsmosPulseSandBox(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                Thread.sleep(100);
                analyticsPage.ClickProductAdServerAnalytics();
                analyticsPage.ClickOnProductAdServerAnalyticsDevicePerformanceReportDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Device Performance Report Download Within 2 Minutes In Product Ad Server Analytics");
                    softAssert.fail("Failed to load Device Performance Report Download Within 2 Minutes In Product Ad Server Analytics");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        });
    }


}