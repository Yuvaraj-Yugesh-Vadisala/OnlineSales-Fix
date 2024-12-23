package TestSeller.OSMOS;

import BaseClass.BaseTest;
import PagesSeller.AwarenessPage;
import PagesSeller.DashboardPage;
import PagesSeller.PerformancePage;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.LocalDate;

public class Dashboard extends BaseTest {
    private PerformancePage performancePage;
    private AwarenessPage awarenessPage;
    private DashboardPage dashboardPage;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosSellerUrl);
        performancePage = new PerformancePage(getDriver());
        awarenessPage = new AwarenessPage(getDriver());
        dashboardPage = new DashboardPage(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "1e2f2aff7100c4ad50b185a1738aafd3");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
        dashboardPage.ClickOnSellerChooseField();
        dashboardPage.EnterDesiredTextToSellerSearchField("Whitakers");
        dashboardPage.SelectDesiredSeller(1);
    }

    @BeforeMethod
    public void ResetPage() throws InterruptedException, AWTException {
        getDriver().navigate().to(OsmosSellerUrl);
        if (!Language.equals("en")) {
            awarenessPage.ChangeLanguage();
        }
    }

    @AfterClass
    public void TearDown() {
        getDriver().quit();
    }

    @Epic("Seller Dashboard")
    @Feature("Dashboard Page")
    @Story("This flow belongs dashboard operations")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Operations related to dashboard")
    public void DashboardOperations()   {
        performancePage.RetryOnFailOSMOSSeller((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            LocalDate StartDate = LocalDate.of(2024, 8, 15);
            LocalDate EndDate = LocalDate.of(2024, 9, 10);
            dashboardPage.ClickOnDashboardCalender();
            dashboardPage.selectDateRange(StartDate, EndDate);
            dashboardPage.ClickOnDateCompareToggleButton();
            dashboardPage.ClickOnSecondDateField();
            dashboardPage.ClickOnApplyDateRange();
            if (!dashboardPage.ValidateComparedDateDisplay()) {
                dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Compared dates are not visible after selecting two dates and clicking on apply");
                softAssert.fail("Compared dates are not visible after selecting two dates and clicking on apply");
            }
            dashboardPage.ClickOnDashboardCalender();
            dashboardPage.ClickOnTodayOnCalender();
            if (!dashboardPage.ValidateIsCompareToggleButtonDisableWhileSelectingTodayPreset()) {
                dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Compare date toggle is not disabled while today preset is selected");
                softAssert.fail("Compare date toggle is not disabled while today preset is selected");
            }
            dashboardPage.ClickOnApplyDateRange();
            if (!dashboardPage.ValidateTodayPresetDisplay()) {
                dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - 'Today' preset is not visible in the chart");
                softAssert.fail("'Today' preset is not visible in the chart");
            }
            dashboardPage.ClickOnSuggestionsButton();
            if (!dashboardPage.IsPendingActionsWindowDisplayed()) {
                dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Pending actions window is not displayed after clicking suggestions button");
                softAssert.fail("Pending actions window is not displayed after clicking suggestions button");
            }
            dashboardPage.ClickCloseButton();
            awarenessPage.ClickOnDesktopMenuButton();
            awarenessPage.ClickOnNotificationSetting();
            dashboardPage.DeselectSelectedMailId();
            awarenessPage.ClickOnSaveButton();   //Clicking save button without selecting any email id
            if (!dashboardPage.ValidateErrorMessageForEmptyEmailField()) {
                dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to save the notification settings without filling email id field");
                softAssert.fail("User is able to save the notification settings without filling email id field");
            }
            awarenessPage.ClickingOnPopUpCloseButton();
            Thread.sleep(1000);
            awarenessPage.ClickOnAlertsDeliveryEmailIdField();
            awarenessPage.SelectingOwnEmailID();
            awarenessPage.ClickOnSaveButton();              //selecting own email id
            if (!awarenessPage.ValidateSavingOfNotificationSettings()) {
                awarenessPage.TakeScreenshotOnSoftAssertion("Saving of notification settings failed");
                softAssert.fail("saving of notification setting failed");
            }
            awarenessPage.ClickingOnPopUpCloseButton();
            awarenessPage.ClickOnDesktopMenuButton();
            awarenessPage.ClickOnNotificationSetting();
            awarenessPage.ClickOnAlertsDeliveryEmailIdField();
            Thread.sleep(1500);
            awarenessPage.EnterDesiredTextToMailIdField("example@com");
            if (!awarenessPage.ValidateVisibilityOfValidEmailAddButton()) {
                awarenessPage.TakeScreenshotOnSoftAssertion("It is accepting invalid email id");
                softAssert.fail("It is accepting invalid email id ");
            }
            awarenessPage.EnterDesiredTextToMailIdField("          ");
            if (!awarenessPage.ValidateVisibilityOfValidEmailAddButton()) {
                awarenessPage.TakeScreenshotOnSoftAssertion("It is only spaces as email id");
                softAssert.fail("It is accepting only spaces as email id ");
            }
            awarenessPage.ClickOnSaveButton();
            awarenessPage.ClickingOnPopUpCloseButton();
            awarenessPage.ClickOnDesktopMenuButton();
            dashboardPage.ClickHelpCenterButton();
            if (!dashboardPage.IsHelpCenterWindowDisplayed()) {
                dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Help Center window is not displayed after clicking the Help Center button");
                softAssert.fail("Help Center window is not displayed after clicking the Help Center button");
            }
            dashboardPage.ClickCloseButton();
        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
            softAssert.assertAll();
        }));
    }

    @Epic("Seller Dashboard")
    @Feature("Dashboard Page")
    @Story("This flow belongs dashboard operations")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validating All dashboard operations")
    public void AwarenessTableOperations()  {
        performancePage.RetryOnFailOSMOSSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                awarenessPage.ClickingOnAwarenessDashBoard();
                dashboardPage.EnterTextInSearchCampaignField("Test");
                Thread.sleep(3000);
                if (!dashboardPage.ValidateCampaignSearchResult()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Search campaign failed");
                    softAssert.fail("Search campaign failed");
                }
                dashboardPage.ClickOnSortBy();
                dashboardPage.ClickOnSortingOption(1);
                if (dashboardPage.ValidateSortingOfCampaignTable()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Sorting failed");
                    softAssert.fail("sorting failed");
                }
                dashboardPage.ClickOnComfortableViewButton();
                if (!dashboardPage.ValidateComfortableView()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - View changing failed");
                    softAssert.fail("View changing failed");
                }
                // dashboardPage.ClickOnFilterButton();
                // dashboardPage.SelectMultipleStatusOptions(3);
                // dashboardPage.SelectDesiredFilterAttribute(2);
                dashboardPage.ClickOnStartDateField();
                performancePage.DateSelector("September", "2024", "15");
                dashboardPage.ClickOnEndDateField();
                performancePage.DateSelector("March", "2025", "15");
                dashboardPage.SelectDesiredFilterAttribute(3);
                dashboardPage.ClickOnStartDateField();
                performancePage.DateSelector("September", "2024", "01");
                dashboardPage.ClickOnEndDateField();
                performancePage.DateSelector("February", "2025", "22");
                dashboardPage.ClickOnFilterApplyButton();
                dashboardPage.ClickOnCreativeLibraryButton();
                if (!dashboardPage.ValidateVisibilityOfUploadButton()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative page is not visible");
                    softAssert.fail("Upload button is not visible");
                }
                dashboardPage.ClickDoneButton();
                Thread.sleep(1000);
//                dashboardPage.ClickOnTroubleshootButton();
//                dashboardPage.ClickOnConfirmationButton();
//                if (!dashboardPage.ValidateTroubleshootReport()) {
//                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Troubleshoot results is not visible");
//                    softAssert.fail("Troubleshoot Failed");
//                }
//                Thread.sleep(1500);
//                awarenessPage.ClickCrossButtonLevel1();
                dashboardPage.ClickOnCompactView();
                dashboardPage.ClickOnCampaignEditButton();
                if (!dashboardPage.ValidateEditPageVisibility()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Edit page is not visible");
                    softAssert.fail("Edit page is not visible");
                }
                awarenessPage.ClickCrossButtonLevel1();
                dashboardPage.ClickOnAnalyticsButton();
                dashboardPage.ClickOnDownloadReportButton();
                dashboardPage.ClickCampaignDoneButton();
                dashboardPage.ClickOnFilterButton();
                dashboardPage.ClickOnClearAllButton();
                dashboardPage.ClickOnConfirmationButton();
                dashboardPage.EnterTextInSearchCampaignField("Auction");
                dashboardPage.ClickOnFilterButton();
                dashboardPage.SelectDesiredStatusOption(3);
                dashboardPage.ClickOnFilterApplyButton();
                Thread.sleep(3000);
                dashboardPage.ClickOnReviewAndLaunchButton();
                if (!dashboardPage.ValidateEditPageVisibility()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Edit page is not visible after clicking ReviewAndLaunch Button");
                    softAssert.fail("Edit page is not visible after clicking ReviewAndLaunch Button");
                }
                awarenessPage.ClickCrossButtonLevel1();
                dashboardPage.EnterTextInSearchCampaignField("");
                Thread.sleep(3900);
                dashboardPage.ClickOnViewAllCampaignButton();
                Thread.sleep(1500);
                if (!dashboardPage.ValidateVisibilityOfViewAllTable()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - View all table is not visible");
                    softAssert.fail("View all table is not visible");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("Seller Dashboard")
    @Feature("Dashboard Page")
    @Story("This flow belongs dashboard operations")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validating all performance table operations")
    public void PerformanceTableOperations()  {
        performancePage.RetryOnFailOSMOSSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                dashboardPage.ClickOnPerformanceTableDownloadButton();
                dashboardPage.ClickOnCategoriesTab();
                dashboardPage.ClickOnPerformanceTableDownloadButton();
                dashboardPage.ClickOnKeywordsTab();
                // dashboardPage.ClickOnPerformanceTableDownloadButton();
                // dashboardPage.CountingPerformanceTableHeadingsBeforeDeselectingTableAttribute();
                // dashboardPage.ClickOnTableAddOrRemoveColumns();
                dashboardPage.DeselectingSelectedTableAttributes(1);
                dashboardPage.ClickOnTableAddOrRemoveColumns();
                if (!dashboardPage.ValidatingPerformanceTableHeadingsAfterDeselectingTableAttribute()) {
                    dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign name heading is visible after deselecting it in add/remove columns");
                    softAssert.fail("Campaign name heading is visible after deselecting it in add/remove columns");
                }
                Thread.sleep(1500);
                dashboardPage.ClickOnTableAddOrRemoveColumns();
                dashboardPage.SelectingDeSelectedTableAttributes(1);
                dashboardPage.ClickOnTableAddOrRemoveColumns();
                if (!dashboardPage.ValidatingPerformanceTableHeadingsAfterSelectingTableAttribute()) {
                    dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign name heading is not visible after selecting it in add/remove columns");
                    softAssert.fail("Campaign name heading is not visible after selecting it in add/remove columns");
                }
                dashboardPage.ClickOnIndustryBenchmarkTemplateLearnMoreButton(1);
                if (!dashboardPage.IsTemplateDetailsPopUpDisplayed()) {
                    dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - 'Template Details' pop-up is not displayed after clicking");
                    softAssert.fail("'Template Details' pop-up is not displayed after clicking");
                }
                dashboardPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingOnAwarenessDashBoard();
                Thread.sleep(5000);
                dashboardPage.ClickOnInventoryTab();
                dashboardPage.ClickOnCampaignTab();
                dashboardPage.CountingAwarenessTableHeadingsBeforeDeselectingTableAttribute();
                Thread.sleep(1000);
                dashboardPage.ClickOnTableAddOrRemoveColumns();
                dashboardPage.DeselectingSelectedTableAttributes(1);
                dashboardPage.ClickOnTableAddOrRemoveColumns();
                if (!dashboardPage.ValidatingAwarenessTableHeadingsAfterDeselectingTableAttribute()) {
                    dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Spend heading is visible after deselecting it in add/remove columns");
                    softAssert.fail("Spend heading is visible after deselecting it in add/remove columns");
                }
                dashboardPage.ClickOnTableAddOrRemoveColumns();
                dashboardPage.SelectingDeSelectedTableAttributes(1);
                dashboardPage.ClickOnTableAddOrRemoveColumns();
                if (!dashboardPage.ValidatingAwarenessTableHeadingsAfterSelectingTableAttribute()) {
                    dashboardPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Spend heading is not visible after selecting it in add/remove columns");
                    softAssert.fail("Spend heading is not visible after selecting it in add/remove columns");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));

    }
}
