package TestPulse.OSMOS;

import PagesPulse.OSMOS.*;
import BaseClass.BaseTest;

import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import PagesPulse.OSMOS.Utility;

import java.awt.*;

public class Analytics extends BaseTest {
    private PageSetupPage pageSetupPage;
    private AnalyticsPage analyticsPage;
    private Utility utils;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrlSandbox);
        pageSetupPage = new PageSetupPage(getDriver());
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
    @Feature("This flow belongs to Analytics-Demand And Supply")
    @Story("Analytics-Product Ads Insights-Demand And Supply")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Products Ads Insights-Demand And Supply")
    public void ProductsAdsInsights()   {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickAnalyticsTab();
                Thread.sleep(500);
                analyticsPage.ClickOnDemandAndSupply();
                analyticsPage.ClickOnListViewButton();
                Thread.sleep(2000);
                analyticsPage.ClickOnTableActionButton();
                if (!analyticsPage.ValidateVisibilityOfHelpPage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Help Page is not Displayed");
                    softAssert.fail("Help Page is not Displayed");
                }
                analyticsPage.ClickCrossButtonToClosePageLevel1();
                analyticsPage.ClickOnDaysView();
                if (!analyticsPage.ValidateVisibilityOfDaysChart()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Days Chart is not Displayed");
                    softAssert.fail("Days Chart is not Displayed");
                }
                analyticsPage.ClickOnHourView();
                if (!analyticsPage.ValidateVisibilityOfHourChart()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Hour Chart is not Displayed");
                    softAssert.fail("Hour Chart is not Displayed");
                }
                analyticsPage.ClickOnAttributeDropdown();
                analyticsPage.SelectDesiredAttribute(3);
                analyticsPage.ClickOnGMVCategoryDropdown();
                analyticsPage.ClickOnSelectAllCheckBox();
                analyticsPage.SelectDesiredCategory(2);
                analyticsPage.SelectDesiredCategory(4);
                analyticsPage.SelectDesiredCategory(5);
                analyticsPage.EnterCategoryName("Makeup");
                analyticsPage.SelectDesiredCategory(2);
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Analytics-Ad Server Analytics")
    @Story("Analytics-Display Ads Insights- Ad Server Analytics")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Display Ads Insights-Ad Server Analytics")
    public void DisplayAdsInsights()   {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickAnalyticsTab();
                Thread.sleep(500);
                analyticsPage.ClickAdServerAnalytics();
                analyticsPage.ClickOnTheMetricDropdown();
                analyticsPage.EnterMetricName("Cart");
                analyticsPage.SelectDesiredMetric(1);
                Thread.sleep(1000);
                analyticsPage.ClickOnTheMetricDropdown();
                analyticsPage.EnterMetricName("");
                analyticsPage.SelectDesiredMetric(6);
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Advertiser Insights")
    @Story("Advertiser Insights Validations-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Validate Advertiser Insights elements")
    public void ValidateAdvertiserInsightsElements()  {
        utils.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                analyticsPage.ClickOnAnalyticsButton();
                analyticsPage.ClickOnAdvertiserInsightsButton();
                analyticsPage.ClickOnFunnelMetricDropDown(1);
                analyticsPage.EnterDataInMetricSearchField("CTR");
                analyticsPage.ClickOnFunnelMetricDropDown(1);
                analyticsPage.ClickOnFunnelMetricDropDown(2);
                analyticsPage.EnterDataInMetricSearchField("CPC");
                analyticsPage.ClickOnGenericOptionsSelector(1);
                analyticsPage.ClickOnBudgetTableAddOrRemoveColumnButton();
                analyticsPage.DeselectingSelectedTableAttributes(1);
                analyticsPage.DeselectingSelectedTableAttributes(1);
                analyticsPage.SelectingDeSelectedTableAttributes(1);
                analyticsPage.SelectingDeSelectedTableAttributes(1);
                analyticsPage.ClickOnAdvertiseSnapshotTableValue(3);
                analyticsPage.clickOnAdvertiseSnapshotTableValueWindow();
                analyticsPage.clickOnWindowCloseButton();
                Thread.sleep(500);
                analyticsPage.clickOnMoversAndShakersAddFilterButton();
                analyticsPage.clickOnAddFilterTypeField();
                analyticsPage.clickOnAddFilterConditionField();
                analyticsPage.EnterDataInAddFilterConditionSearchField("contains");
                analyticsPage.ClickOnGenericOptionsSelector(1);
                analyticsPage.EnterDataInAddFilterInputField("buy");
                analyticsPage.ClickOnAddFilterApplyButton();
                Thread.sleep(1500);
                if (!analyticsPage.IsFilterResultsDisplayed()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Filter results not displayed");
                    softAssert.fail("Filter results not displayed.");
                }
                analyticsPage.ClickOnTableExpandIcon();
                analyticsPage.ClickOnTableCollapseIcon();
                analyticsPage.ClickOnPerformanceReportMetricField();
                analyticsPage.EnterDataInPerformanceReportMetricSearchField("CPM");
                analyticsPage.ClickOnGenericOptionsSelector(1);
//                analyticsPage.ClickOnChannelPerformanceTableValues();
//                if (!analyticsPage.IsChannelPerformanceTableValueWindowDisplayed()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Channel performance table value window not displayed");
//                    softAssert.fail("Channel performance table value window not displayed");
//                }
                softAssert.assertAll();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }


}
