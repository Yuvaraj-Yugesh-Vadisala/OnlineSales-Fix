package TestPulse.OSMOS;

import PagesPulse.OSMOS.*;
import BaseClass.BaseTest;
import PagesSeller.AwarenessPage;
import PagesSeller.DashboardPage;
import PagesSeller.PerformancePage;

import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class Review extends BaseTest {

    private PageSetupPage pageSetupPage;
    private AdFormatSetupPage adFormatSetupPage;
    private AwarenessPage awarenessPage;
    private DashboardPage dashboardPage;

    private CampaignReviewPage campaignReviewPage;
    private PerformancePage performancePage;
    private Utility utility;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrl);
        awarenessPage = new AwarenessPage(getDriver());
        performancePage = new PerformancePage(getDriver());
        pageSetupPage = new PageSetupPage(getDriver());
        adFormatSetupPage = new AdFormatSetupPage(getDriver());
        campaignReviewPage = new CampaignReviewPage(getDriver());
        dashboardPage = new DashboardPage(getDriver());
        utility = new Utility(getDriver());

        Cookie UAToken = new Cookie("UA_TOKEN", "1e2f2aff7100c4ad50b185a1738aafd3");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();

        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Started: " + this.getClass().getSimpleName());

    }

    @BeforeMethod
    public void ResetPage() throws InterruptedException, AWTException {
        getDriver().navigate().to(OsmosPulseUrl);
        if (!Language.equals("en")) {
            utility.ChangeLanguage();
        }
    }

    @AfterClass
    public void TearDown() {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Finished: " + this.getClass().getSimpleName());

        getDriver().quit();
    }

    public void redirect() {
        getDriver().navigate().to(OsmosSellerUrl);
        Cookie UAToken = new Cookie("UA_TOKEN", "1e2f2aff7100c4ad50b185a1738aafd3");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
        dashboardPage.ClickOnSellerChooseField();
        dashboardPage.EnterDesiredTextToSellerSearchField("Whitakers");
        dashboardPage.SelectDesiredSeller(1);

    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Campaign Review")
    @Story("Campaign Review- Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Review created campaign")
    public void ReviewCreatedCampaign() {
        utility.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                redirect();
                awarenessPage.ClickingOnAwarenessDashBoard();
                performancePage.ClickOnCreateCampaignButton();
                performancePage.ClickingNextStepButton();
                String DefaultCampaignName = awarenessPage.RenameCampaignName();
                awarenessPage.ClickAwarenessNextButton();
                awarenessPage.ClickOnSelectPageButton();
                awarenessPage.EnterPageName("Qa Page 1");
                awarenessPage.SelectPage();
                awarenessPage.ClickDoneButton();
                Thread.sleep(1000);
                awarenessPage.ClickingOnCPMRadioButton();
                Thread.sleep(1000);
                awarenessPage.EnteringDataInAuctionInventorySearchField("QA Test");
                Thread.sleep(1000);
                awarenessPage.ClickOnDesiredInventory(1);
                Thread.sleep(1000);
                awarenessPage.ClickInventorySaveButton();
                Thread.sleep(2000);
                awarenessPage.ClickKeywordTargeting();     //KEYWORD TARGETING
                awarenessPage.ClickAddKeywordButton();
                awarenessPage.AddPositiveKeywords("laptop", "mobile");
                performancePage.ClickAddGivenKeywordsButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                awarenessPage.ClickSaveKeywordsButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                awarenessPage.ClickAddedKeywordSaveButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                awarenessPage.ClickingOnAudienceTargeting();     //AUDIENCE TARGETING
                Thread.sleep(1000);
                awarenessPage.ClickingOnSearchAudienceField();
                awarenessPage.EnteringDesiredTextInSearchAudienceField("yogurt");
                awarenessPage.SelectingDesiredAudience();
                awarenessPage.ClickingAudienceApplyButton();
                Thread.sleep(1000);
                awarenessPage.ClickDeviceTargeting();    //DEVICE TARGETING
                awarenessPage.ClickOnSearchDeviceInDeviceTargeting();
                awarenessPage.SelectingOptionsFromSearchDeviceDropdown(1);
                awarenessPage.ClickOnApplyInDeviceTargeting();
                if (!awarenessPage.ValidateDeviceTargetingAppliedSuccessfully()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Device targeting failed");
                    softAssert.fail("Device targeting failed");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickCustomTargeting();     //CUSTOM TARGETING
                awarenessPage.ClickOnAttributeDropdownInCustomTargeting();
                awarenessPage.SelectingOptionsFromAttributeDropdownInCustomTargeting(1);
                awarenessPage.ClickOnValueDropdownInCustomTargeting();
                awarenessPage.SelectingOptionsFromValueDropdownInCustomTargeting(1);
                awarenessPage.ClickOnResetInCustomTargeting();
                if (!awarenessPage.ValidateResetInCustomTargeting()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Reset is not successful");
                    softAssert.fail("Reset is not successful");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickCustomTargeting();
                awarenessPage.ClickOnAttributeDropdownInCustomTargeting();
                awarenessPage.SelectingOptionsFromAttributeDropdownInCustomTargeting(1);
                awarenessPage.ClickOnValueDropdownInCustomTargeting();
                awarenessPage.SelectingOptionsFromValueDropdownInCustomTargeting(1);
                awarenessPage.ClickOnAddButtonInCustomTargeting();
                awarenessPage.ClickDeleteButtonInCustomTargeting();
                awarenessPage.ClickSaveInCustomTargeting();
                if (!awarenessPage.CheckSaveInCustomTargeting()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Message should be displayed ");
                    softAssert.fail("Message should be displayed ");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickTargetingSaveButton();
                awarenessPage.SelectQAFullFledgeFormat();
                awarenessPage.ClickingCampaignCreativeNewAdButton();
                awarenessPage.AddingNameInAdNameField("QA Testing");
                awarenessPage.ClickUploadButtonFromCreativeLibrary(1);
                awarenessPage.SelectMediaFromCreativeLibrary();
                awarenessPage.ClickChooseButton();
                awarenessPage.ClickUploadButtonFromCreativeLibrary(1);
                awarenessPage.SelectMediaFromCreativeLibrary();
                awarenessPage.ClickChooseButton();
                awarenessPage.ClickingOnCampaignCreativeAdCarouselTextField(0);
                awarenessPage.EnteringDataInCampaignCreativeAdCarouselTextField(0, "QA TESTING");
                awarenessPage.ClickingOnCampaignCreativeAdCarouselCTAField(0);
                awarenessPage.ClickingOnCampaignCreativeAdCarouselCTAFieldDropDown(1);
                awarenessPage.ClickingOnCampaignCreativeAdCarouselCreativeCount(2);
                awarenessPage.ClickingOnCampaignCreativeAdCarouselTextField(1);
                awarenessPage.EnteringDataInCampaignCreativeAdCarouselTextField(1, "QA TESTING");
                awarenessPage.ClickingOnCampaignCreativeAdCarouselCTAField(1);
                awarenessPage.ClickingOnCampaignCreativeAdCarouselCTAFieldDropDown(2);
                awarenessPage.ClickingOnCampaignCreativeAdCarouselAddButton();
                awarenessPage.ClickingOnCampaignCreativeAdCarouselCreativeCount(3);
                awarenessPage.ClickingOnCampaignCreativeAdCarouselDeleteButton(3);
                awarenessPage.EnteringDataInCampaignCreativesQAFullFledgeCreativeAdTextComponentField("Qa Testing");
                awarenessPage.EnteringDataInCampaignCreativesQAFullFledgeCreativeAdUrlField("https://www.example.com");
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductButton();
                awarenessPage.ClickAddProductButton();
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(2);
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(3);
                awarenessPage.ClickAddButton();
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductAddButton();
                awarenessPage.ClickingOnAwarenessCampaignCreativesNewAdSaveButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2500);
                awarenessPage.SelectQAFullFledgeFormat();
                awarenessPage.ClickingSaveButton();
                Thread.sleep(2000);
                performancePage.ClickOnStartDateField();
                performancePage.DateSelector("October", "2024", "30");
                performancePage.ClickOnEndDateField();
                performancePage.DateSelector("March", "2025", "15");
                awarenessPage.AddValueInDailyBudgetField("200");
                Thread.sleep(1500);
                awarenessPage.EnteringDataInChargeableCPMField("100");
                awarenessPage.ClickSubmitForReviewButton();
                campaignReviewPage.EnterTextInSearchCampaignField(DefaultCampaignName);
                Thread.sleep(2000);
                if (!awarenessPage.ValidateCreatedAuctionCampaignName(DefaultCampaignName))
                    Assert.fail("Campaign Creation failed");

                ResetPage();
                pageSetupPage.ClickOnControlCenterNavButton();
                campaignReviewPage.ClickOnCampaignReviewButton();
                Thread.sleep(1500);
                campaignReviewPage.ClickRefreshButton();
                Thread.sleep(1500);
                campaignReviewPage.EnterDataInTableSearchField(DefaultCampaignName);
                Thread.sleep(2000);
//                campaignReviewPage.ClickOnCampaignReviewerField();
//                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(2);
//                awarenessPage.ClickingOnPopUpCloseButton();

                campaignReviewPage.ClickOnCampaignViewButton();
                campaignReviewPage.ClickOnCustomTargeting();
                if (!campaignReviewPage.IsCustomTargetingWindowDisplayed()) {
                    utility.TakeScreenshotOnSoftAssertion("Soft Assertion - Custom Targeting Window is not displayed");
                    softAssert.fail("Custom Targeting Window is not displayed");
                }
                Thread.sleep(1500);
                awarenessPage.ClickCrossButtonLevel2();

                campaignReviewPage.ClickOnKeywordCheckBoxSelector(1);
                Thread.sleep(2000);
                campaignReviewPage.ClickOnApproveAllButton();
                awarenessPage.ClickYesButtonForConfirmation();
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                if (!campaignReviewPage.IsKeywordApprovedStatusDisplayed()) {
                    utility.TakeScreenshotOnSoftAssertion("Soft Assertion - Keyword approved status is not displayed after approving a keyword");
                    softAssert.fail("Keyword approved status is not displayed");
                }
                campaignReviewPage.ClickOnKeywordCheckBoxSelector(1);
                Thread.sleep(2000);
                campaignReviewPage.ClickOnRejectAllButton();
                awarenessPage.ClickYesButtonForConfirmation();
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                if (!campaignReviewPage.IsKeywordRejectedStatusDisplayed()) {
                    utility.TakeScreenshotOnSoftAssertion("Soft Assertion - Keyword rejected status is not displayed after rejecting a keyword");
                    softAssert.fail("Keyword rejected status is not displayed");
                }
                Thread.sleep(1000);
                campaignReviewPage.ClickOnKeywordReviewIcon(1);
                awarenessPage.ClickingOnPopUpCloseButton();
                if (!campaignReviewPage.IsKeywordApprovedStatusDisplayedForSingleSelection()) {
                    utility.TakeScreenshotOnSoftAssertion("Soft Assertion - Keyword approved status is not displayed after approving a keyword");
                    softAssert.fail("Keyword approved status is not displayed");
                }
                campaignReviewPage.ClickOnCampaignReviewText();
                campaignReviewPage.ClickOnApproveButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickCrossButtonLevel1();

                if (!campaignReviewPage.IsApprovedCampaignStatusDisplayed()) {
                    utility.TakeScreenshotOnSoftAssertion("Soft Assertion - Approved campaign status is not displayed");
                    softAssert.fail("Approved campaign status is not displayed");
                }
                softAssert.assertAll();
            } catch (InterruptedException | AWTException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
        }));
    }
}
