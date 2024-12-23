package TestPulse.OSMOS.DownloadReports;

import BaseClass.BaseTest;
import PagesPulse.OSMOS.*;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class HomeDownload extends BaseTest {
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
    @Feature("This flow belongs to download Metrics Comparison reports in home")
    @Story("Download Metrics Comparison Reports In Home")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Download Metrics Comparison Report In Home")
    public void DownloadMetricsComparisonReportReportsInHome()   {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnHomeMetricsComparisonReportDownload();
                utils.ClickOnPopUpCloseButton();
                if (segmentManagerPage.ClickOnDownloadButton()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssertion: Failed to load Metrics Comparison Reports Download Within 2 Minutes In Home");
                    softAssert.fail("Failed to load Metrics Comparison Reports Download Within 2 Minutes In Home");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));

    }

}