package TestSeller.OSMOS;

import BaseClass.BaseTest;
import PagesSeller.AwarenessPage;
import PagesSeller.DashboardPage;
import PagesSeller.PerformancePage;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class AwarenessAuction extends BaseTest {
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
    public void ResetPage(ITestResult result) throws InterruptedException, AWTException {
        getDriver().navigate().to(OsmosSellerUrl);
        if (!Language.equals("en")) {
            awarenessPage.ChangeLanguage();
        }

        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Starting @Test: " + result.getMethod().getMethodName());

    }
    @AfterMethod
    public void afterMethod(ITestResult result) {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Finished @Test: " + result.getMethod().getMethodName());
    }

    @AfterClass
    public void TearDown() {

        getDriver().quit();
    }

    @Epic("Seller Dashboard")
    @Feature("Awareness Page")
    @Story("This flow belongs Auction Campaign Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create a successful auction campaign flow with cpc buying type", timeOut = 1200000)
    public void CreateAuctionCampaignWithCPCBuyingType() {
        performancePage.RetryOnFailOSMOSSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                awarenessPage.ClickingOnAwarenessDashBoard();
                performancePage.ClickOnCreateCampaignButton();
                performancePage.ClickingNextStepButton();
                String DefaultCampaignName = awarenessPage.RenameCampaignName();
                awarenessPage.ClickAwarenessNextButton();
                awarenessPage.ClickOnSelectPageButton();
                awarenessPage.EnterPageName("Qa Page 1");
                awarenessPage.SelectPage();
                awarenessPage.ClickDoneButton();
                Thread.sleep(1500);
                awarenessPage.ClickingOnCPCRadioButton();
                Thread.sleep(1000);
                awarenessPage.EnteringDataInAuctionInventorySearchField("QA Test");
                Thread.sleep(2000);
                awarenessPage.ClickOnDesiredInventory(1);
                Thread.sleep(1500);
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
                awarenessPage.ClickingOnGeoLocationTargeting();   //GEO LOCATION TARGETING
                awarenessPage.ClickingOnIncludedLocationField();
                awarenessPage.EnteringDesiredTextInIncludeLocationField("b");
                awarenessPage.SelectingDesiredLocationWithCheckbox(1);
                awarenessPage.ClickingOnIncludedLocationField();
                awarenessPage.ClickingCrossButtonToDeleteSelectedLocations();
                if (!awarenessPage.ValidatingAllLocationSelected()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Selected include location is not deleted");
                    softAssert.fail("Selected include location is not deleted");
                }
                awarenessPage.ClickingOnExcludedLocationField();
                awarenessPage.EnteringDesiredTextInExcludeLocationField("b");
                awarenessPage.SelectingDesiredLocationWithCheckbox(5);
                awarenessPage.ClickingOnExcludedLocationField();
                awarenessPage.ClickingCrossButtonToDeleteSelectedLocations();
                if (!awarenessPage.ValidatingSelectedLocations()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Selected exclude location is not deleted");
                    softAssert.fail("Selected exclude location is not deleted");
                }
                awarenessPage.ClickingOnIncludedLocationField();
                awarenessPage.EnteringDesiredTextInIncludeLocationField("b");
                awarenessPage.SelectingDesiredLocationWithCheckbox(3);
                awarenessPage.ClickingOnExcludedLocationField();
                awarenessPage.EnteringDesiredTextInExcludeLocationField("b");
                awarenessPage.SelectingDesiredLocationWithCheckbox(3);
                if (!awarenessPage.ValidatingSameLocationSelectionErrorMsg()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to select the same location in include and exclude location");
                    softAssert.fail("User is able to select the same location in include and exclude location");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingLocationResetButton();
                awarenessPage.ClickingLocationResetConfirmationButton();
                awarenessPage.ClickingOnIncludedLocationField();
                awarenessPage.EnteringDesiredTextInIncludeLocationField("b");
                Thread.sleep(1000);
                awarenessPage.SelectingMultipleLocationWithCheckbox(10);
                awarenessPage.ClickingExportButton();
                awarenessPage.AddingExportFileName("Sample_locations");
                awarenessPage.ClickingExportSelectedLocationsButton();
                if (!awarenessPage.ValidatingExportLocation()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Locations were not exported");
                    softAssert.fail("Locations were not exported");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingLocationResetButton();
                awarenessPage.ClickingLocationResetConfirmationButton();
                Thread.sleep(1500);
                awarenessPage.ImportingLocationFile("Sample_locations.json");
                awarenessPage.ClickingContinueButtonToImport();
                if (!awarenessPage.ValidatingSuccessfulImportingLocationsPopup()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Import location failed");
                    softAssert.fail("Import location failed");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingLocationResetButton();
                awarenessPage.ClickingLocationResetConfirmationButton();
                awarenessPage.ClickingOnIncludedLocationField();
                awarenessPage.EnteringDesiredTextInIncludeLocationField("b");
                awarenessPage.SelectingDesiredLocationWithCheckbox(1);
                awarenessPage.ClickingOnExcludedLocationField();
                awarenessPage.EnteringDesiredTextInExcludeLocationField("b");
                awarenessPage.SelectingDesiredLocationWithCheckbox(2);
                awarenessPage.ClickingOnExcludedLocationField();
                awarenessPage.ClickingOnApplyLocationButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingOnAudienceTargeting();     //AUDIENCE TARGETING
                Thread.sleep(1000);
                awarenessPage.ClickingOnSearchAudienceField();
                awarenessPage.EnteringDesiredTextInSearchAudienceField("yogurt");
                awarenessPage.SelectingDesiredAudience();
                awarenessPage.DeselectingSelectedAudience();
                awarenessPage.ClickingOnCreateNewAudienceButton();
                awarenessPage.AddingAudienceNewName("Custom Audience By Attribute");
                awarenessPage.ClickingAttributeTypeDropdown();
                awarenessPage.SelectingDesiredAttribute(4);
                awarenessPage.ClickingConditionTypeDropdown();
                awarenessPage.SelectingDesiredCondition(1);
                awarenessPage.ClickingOnValueDropdown();
                awarenessPage.SelectingDesiredValue(1);
                awarenessPage.ClickOnAddAttributeButton();
                awarenessPage.ClickingSecondRowAttributeTypeDropdown();
                awarenessPage.SelectingDesiredAttribute(3);
                awarenessPage.ClickingOnSecondRowConditionTypeDropdown();
                awarenessPage.SelectingDesiredCondition(1);
                awarenessPage.ClickingOnValueDropdown();
                awarenessPage.SelectingDesiredValue(1);
                awarenessPage.ClickOnAddAttributeButton();
                awarenessPage.ClickingAttributeRowDeleteButton();
                awarenessPage.ClickOnAudienceSaveButton();
                if (!awarenessPage.ValidatingSuccessfulMsgForCreatingAudience()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Audience creation failed");
                    softAssert.fail("Audience creation failed");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2500);
                awarenessPage.ClickingOnCreateNewAudienceButton();
                awarenessPage.ClickByUserActivityRadioButton();
                awarenessPage.AddingAudienceNewName("Custom Audience By User Activity");
                awarenessPage.ClickOnProductCategoryDropdown();
                awarenessPage.SelectDesiredProductCategory(2);
                awarenessPage.ClickByUserActivityRadioButton();
                awarenessPage.ClickOnBrandSelectionDropdown();
                awarenessPage.SelectDesiredBrand(5);
                awarenessPage.ClickByUserActivityRadioButton();
                awarenessPage.ClickingOnUserActionDropdown();
                awarenessPage.SelectDesiredUserAction(3);
                awarenessPage.ClickingOnDurationDropdown();
                awarenessPage.SelectDesiredDuration(2);
                awarenessPage.SelectingDesiredFrequencyOfUserAction(4);
                awarenessPage.ClickOnAudienceSaveButton();
                if (!awarenessPage.ValidatingSuccessfulMsgForCreatingAudience()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Audience creation failed");
                    softAssert.fail("Audience creation failed");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickOnAudienceEditButton();
                if (!awarenessPage.ValidatingVisibilityOfAudienceNameField()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Edit button is not clicked");
                    softAssert.fail("Edit button is not clickable");
                }
                awarenessPage.ClickOnAudienceSaveButton();
                awarenessPage.ClickOnYesButtonToConfirmAudienceChange();
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingOnCreateNewAudienceButton();
                awarenessPage.AddingAudienceNewName("Custom Audience");
                awarenessPage.ClickingAttributeTypeDropdown();
                awarenessPage.SelectingDesiredAttribute(4);
                awarenessPage.ClickingConditionTypeDropdown();
                awarenessPage.SelectingDesiredCondition(1);
                awarenessPage.AddingKeywordsToAttributeValue("Ice-Cream");
                awarenessPage.ClickingOnAddKeywordButton();
                awarenessPage.ClickingOnDeleteAddedKeywordIcon();
                awarenessPage.AddingKeywordsToAttributeValue("Cream");
                awarenessPage.ClickingOnAddKeywordButton();
                if (!awarenessPage.ValidatingAddedCustomKeywords("Cream", 1)) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - keyword is not added");
                    softAssert.fail("keyword is not added");
                }
                awarenessPage.ClickOnAudienceSaveButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingAudienceApplyButton();
                Thread.sleep(1000);
                awarenessPage.ClickDeviceTargeting();    //DEVICE TARGETING
                awarenessPage.ClickOnSearchDeviceInDeviceTargeting();
                awarenessPage.SelectingOptionsFromSearchDeviceDropdown(1);
                awarenessPage.DeletingTheSelectedOptionInSearchDeviceInDeviceTargeting(1);
                awarenessPage.ClickOnSearchDeviceInDeviceTargeting();
                awarenessPage.SelectingOptionsFromSearchDeviceDropdown(2);
                awarenessPage.ClickOnResetInDeviceTargeting();
                awarenessPage.ClickOnSearchDeviceInDeviceTargeting();
                awarenessPage.SelectingOptionsFromSearchDeviceDropdown(2);
                Thread.sleep(2000);
                awarenessPage.ClickOnApplyInDeviceTargeting();
                if (!awarenessPage.ValidateDeviceTargetingAppliedSuccessfully()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Device targeting failed");
                    softAssert.fail("Device targeting failed");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickProductCatalogTargeting();    //PRODUCT CATALOG TARGETING
                awarenessPage.SelectingAttributeTypeDropdown(1);
                awarenessPage.SelectOptionsFromDropdownInProductCatalogTargeting(1);
                awarenessPage.SelectingConditionTypeDropdown(1);
                awarenessPage.SelectOptionsFromDropdownInProductCatalogTargeting(2);
                awarenessPage.SelectingBrandTypeDropdown(1);
                awarenessPage.SelectOptionsFromDropdownInProductCatalogTargeting(2);
                awarenessPage.ClickClearAllInProductCatalogTargeting();
                awarenessPage.ConfirmAfterClickingSaveInProductCatalogTargeting();
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                awarenessPage.ClickProductCatalogTargeting();
                awarenessPage.ClickOnCatalogCategoryTypeDropdown();
                awarenessPage.SelectingDesiredAttribute(2);
                awarenessPage.ClickingConditionTypeDropdown();
                awarenessPage.SelectingDesiredCondition(1);
                awarenessPage.ClickBrandTypeDropdownInProductCatalogTargeting();
                Thread.sleep(1000);
                awarenessPage.SelectDesiredOptionFromBrandTypeDropdown(2);
                Thread.sleep(1000);
                awarenessPage.ClickSaveInProductCatalogTargeting();
                awarenessPage.ConfirmButtonInProductCatalogTargeting();
                if (!awarenessPage.ValidateFilterAppliedInProductCatalogTargeting()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Filter is not applied");
                    softAssert.fail("Filter is not applied");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickProductCatalogTargeting();
                awarenessPage.ClickAddButtonInProductCatalogTargeting();
                if (awarenessPage.ValidateAdditionOfNewRow()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - New filter row is not added");
                    softAssert.fail("New filter row is not added");
                }
                awarenessPage.ClickDeleteButtonInProductCatalogTargeting();
                if (awarenessPage.ValidateDeletionOfFilterRow()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Filter row is not deleted");
                    softAssert.fail("Filter row is not deleted");
                }
                awarenessPage.ClickUploadInProductCatalogTargeting();
                if (!awarenessPage.ValidateVisibilityOfConfirmButton()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - It is switching without any confirmation popup");
                    softAssert.fail("It is switching without any confirmation popup");
                }
                Thread.sleep(1000);
                awarenessPage.ClickYesButtonForConfirmation();
                awarenessPage.DownloadSampleFileInProductCatalogTargeting();
                awarenessPage.UploadingFileInProductCatalogTargeting("sku_id.tsv");
                Thread.sleep(2000);
                awarenessPage.ClickSaveInProductCatalogTargetingAfterUpload();
                if (!awarenessPage.ValidateSuccessfulFileUpload()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - File is not uploaded");
                    softAssert.fail("File is not uploaded");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
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
                awarenessPage.EnteringDataInChargeableCPCField("100");
//                awarenessPage.EnteringDataInChargeableCPMField("1000");
                awarenessPage.ClickSubmitForReviewButton();
                dashboardPage.EnterTextInSearchCampaignField(DefaultCampaignName);
                Thread.sleep(2000);
                if (!awarenessPage.ValidateCreatedAuctionCampaignName(DefaultCampaignName))
                    Assert.fail("Campaign Creation failed");

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }


    @Epic("Seller Dashboard")
    @Feature("Awareness Page")
    @Story("This flow belongs Auction Campaign Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Creating an auction campaign without filling mandatory fields", timeOut = 1200000)
    public void ValidateAllFieldsWhileCreatingAuctionCampaignWithCPMBuyingType() {
        performancePage.RetryOnFailOSMOSSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                awarenessPage.ClickingOnAwarenessDashBoard();
                performancePage.ClickOnCreateCampaignButton();
                Thread.sleep(1500);
                performancePage.ClickingNextStepButton();
                awarenessPage.ClickingOnTheNativeAdsRadioButton();
                awarenessPage.ClickAwarenessNextButton();
                if (!awarenessPage.ValidatingErrorMessageWithOutSelectingAnyOption()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User able to proceed further without selecting any marketplace while creating auction campaign");
                    softAssert.fail("User is able to proceed further without selecting any marketplace");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingOnTheNativeAdsRadioButton();
                awarenessPage.ClickAwarenessNextButton();
                awarenessPage.ClickTargetingOptions();
                if (!awarenessPage.ValidateTargetingOptionsWithoutSelectingPage()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Clicking disabled targeting option without selecting any inventory");
                    softAssert.fail("Targeting options should be disabled");
                }
                awarenessPage.ClickOnSelectPageButton();
                Thread.sleep(1000);
                awarenessPage.ClickDoneButton();
                if (!awarenessPage.ValidatingErrorMessageWithOutSelectingAnyPage()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User able to proceed further without selecting any Page while creating auction campaign");
                    softAssert.fail("User able to proceed further without selecting any Page");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.EnterPageName("Qa Page 1");
                awarenessPage.SelectPage();
                awarenessPage.ClickDoneButton();
                Thread.sleep(1500);
                awarenessPage.ClickInventorySaveButton();
                if (!awarenessPage.ValidatingErrorMessageWithOutSelectingAnyInventory()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User able to proceed further without selecting any Inventory while creating auction campaign");
                    softAssert.fail("User able to proceed further without selecting any Inventory");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingOnCPCRadioButton();
                Thread.sleep(1500);
                awarenessPage.SelectMultipleInventories(2);
                awarenessPage.DeletingSelectedInventory(1);
                if (awarenessPage.ValidateDeletionOfInventory()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Deleting inventory failed");
                    softAssert.fail("Deleting inventory failed");
                }
                Thread.sleep(1500);
                awarenessPage.ClickingOnCPMRadioButton();
                if (!awarenessPage.ValidateVisibilityOfConfirmationPopup()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - There is no confirmation while changing buying type after customization");
                    softAssert.fail("There is no confirmation while changing buying type after customization");
                }
                Thread.sleep(1500);
                awarenessPage.ClickYesButtonForConfirmation();
                awarenessPage.SelectMultipleInventories(4);
                for (int i = 1; i <= 4; i++) {
                    if (!awarenessPage.ValidateDeleteIconForInventories(i)) {
                        awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Checking the delete icon disabled while coming back from targeting page to inventory selecting page after saving inventory");
                        softAssert.fail("Delete Icons should be disabled");
                    }
                }
                awarenessPage.ClickInventorySaveButton();
                awarenessPage.ClickBackButton();
                Thread.sleep(2000);
                if (!awarenessPage.VerifyAddedInventoriesAreInvisibleInOverviewPanel()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Checking the visibility of selected inventories in overview panel while creating auction campaign");
                    softAssert.fail("All inventories that are added should be reflected in overview panel");
                }
                for (int i = 1; i <= 4; i++) {
                    if (!awarenessPage.ValidateDeleteIconsAreDisabled(4)) {
                        awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Delete icons are enabled after saving and clicking back button");
                        softAssert.fail("Delete icons are enabled after saving the inventories");
                    }
                }
                awarenessPage.ClickInventorySaveButton();
                Thread.sleep(1000);
                awarenessPage.ClickTargetingSaveButtonWithoutCustomization();
                if (!awarenessPage.CheckIfTargetingOptionSaves()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to create ad without adding keywords from keyword targeting");
                    softAssert.fail("User is able to create ad without adding keyword");
                }
                awarenessPage.ClickingOnAddKeywordsButton();
                awarenessPage.ClickAddKeywordButton();
                Thread.sleep(2000);
                performancePage.ClickAddGivenKeywordsButton();
                if (!awarenessPage.ClickAddKeywordWithEmptyKeywordField()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to add empty field without any error message in keyword targeting");
                    softAssert.fail("User is able to add empty field without any error message");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                awarenessPage.ClickSaveKeywordsButton();
                if (!awarenessPage.ClickOnSaveWithEmptyKeywordField()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to save empty keywords without any error message while adding keywords in keyword targeting");
                    softAssert.fail("User is able to save empty keywords without any error message");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.AddPositiveKeywords("laptop", "mobile");
                performancePage.ClickAddGivenKeywordsButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.SelectCheckboxesNextToAddedKeywords(1);
                awarenessPage.ClickOnRemoveInKeywordTargeting();
                awarenessPage.AddPositiveKeywords("FaceWash", "Cream");
                performancePage.ClickAddGivenKeywordsButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickDeleteIconNextToAddedKeywords(1);
                awarenessPage.ClickSaveKeywordsButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickAddedKeywordSaveButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                awarenessPage.ClickKeywordTargeting();
                awarenessPage.ClickAddKeywordButton();
                performancePage.AddNegativeKeywordsFromExcel("InvalidKeywords_Auction");
                performancePage.ClickAddGivenKeywordsButton();
                if (!awarenessPage.ValidateAdditionOfSpecialCharactersInKeywordField()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Keywords with special characters are added without any error message in keyword targeting");
                    softAssert.fail("Keywords with special characters are added without any error message");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1500);
                performancePage.AddNegativeKeywordsFromExcel("50+Keywords_Auction");
                Thread.sleep(1500);
                performancePage.ClickAddGivenKeywordsButton();
                if (!awarenessPage.AddMoreThan50KeywordsToKeywordField()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to add more than 50 keywords while adding keyword for targeting");
                    softAssert.fail("User is able to add more than 50 keywords");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickCrossButtonLevel3();
                awarenessPage.ClickYesButtonForConfirmation();
                awarenessPage.ClickAddKeywordButton();
                performancePage.AddNegativeKeywordsFromExcel("Exceeding250_Auction");
                performancePage.ClickAddGivenKeywordsButton();
                if (!awarenessPage.Add250LettersInKeyword()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to add a keyword having more than 250 letters while adding keywords for targeting");
                    softAssert.fail("User is able to add a keyword having more than 250 letters");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickCrossButtonLevel3();
                awarenessPage.ClickCrossButtonLevel2();
                Thread.sleep(1000);
                awarenessPage.ClickingOnGeoLocationTargeting();
                awarenessPage.ClickingOnApplyLocationButton();
                if (!awarenessPage.ValidatingUpdateLocationMessage()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message for saving empty include and exclude location");
                    softAssert.fail("Geo locations are not updated");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickingOnGeoLocationTargeting();
                awarenessPage.ClickingOnIncludedLocationField();
                awarenessPage.EnteringDesiredTextInIncludeLocationField("b");
                Thread.sleep(3000);
                awarenessPage.SelectingMultipleLocationWithCheckbox(21);
                if (!awarenessPage.ValidatingMaximumLocationSelectedErrorMsg()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to select more than maximum include locations in geo location targeting");
                    softAssert.fail("User is able to select more than maximum include locations ");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingLocationResetButton();
                awarenessPage.ClickingLocationResetConfirmationButton();
                awarenessPage.ClickingOnIncludedLocationField();
                awarenessPage.EnteringDesiredTextInIncludeLocationField("b");
                Thread.sleep(3000);
                awarenessPage.SelectingMultipleLocationWithCheckbox(20);
                awarenessPage.ClickingOnApplyLocationButton();
                if (!awarenessPage.ValidateAddedLocationCountInTargetingCandy()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Desired number of locations are not selected while adding include location in geo location targeting");
                    softAssert.fail("Desired number of  include locations are not selected");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickingOnGeoLocationTargeting();
                awarenessPage.ClickingLocationResetButton();
                awarenessPage.ClickingLocationResetConfirmationButton();
                awarenessPage.ClickingOnExcludedLocationField();
                awarenessPage.EnteringDesiredTextInExcludeLocationField("b");
                Thread.sleep(3000);
                awarenessPage.SelectingMultipleLocationWithCheckbox(21);
                if (!awarenessPage.ValidatingMaximumLocationSelectedErrorMsg()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to select more than maximum Exclude locations while geo location targeting");
                    softAssert.fail("User is able to select more than maximum Exclude locations ");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingLocationResetButton();
                awarenessPage.ClickingLocationResetConfirmationButton();
                awarenessPage.ClickingOnExcludedLocationField();
                awarenessPage.EnteringDesiredTextInExcludeLocationField("b");
                Thread.sleep(3000);
                awarenessPage.SelectingMultipleLocationWithCheckbox(20);
                awarenessPage.ClickingOnApplyLocationButton();
                if (!awarenessPage.ValidateAddedLocationCountInTargetingCandy()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Desired number of locations are not selected while adding exclude location in geolocation targeting");
                    softAssert.fail("Desired number of Exclude locations are not selected");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1500);
                awarenessPage.ClickingOnGeoLocationTargeting();
                awarenessPage.ClickingLocationResetButton();
                awarenessPage.ClickingLocationResetConfirmationButton();
                awarenessPage.ClickingOnIncludedLocationField();
                awarenessPage.EnteringDesiredTextInIncludeLocationField("b");
                Thread.sleep(3000);
                awarenessPage.SelectingMultipleLocationWithCheckbox(10);
                awarenessPage.ClickingExportButton();
                awarenessPage.ClickingExportSelectedLocationsButton();
                if (!awarenessPage.ValidatingEmptyFileNameErrorMsg()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Locations were exported with empty file name while exporting location");
                    softAssert.fail("Locations were exported with empty file name");
                }
                awarenessPage.AddingExportFileName("  ");
                awarenessPage.ClickingExportSelectedLocationsButton();
                if (!awarenessPage.ValidateAddingSpacesOnlyInFileNameField()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - File name field is accepting spaces only while exporting location");
                    softAssert.fail("File name field is accepting spaces only");
                }
                awarenessPage.ClickingCancelButton();
                awarenessPage.ClickingLocationResetButton();
                awarenessPage.ClickingLocationResetConfirmationButton();
                awarenessPage.ClickingOnIncludedLocationField();
                awarenessPage.EnteringDesiredTextInIncludeLocationField("b");
                Thread.sleep(2000);
                awarenessPage.SelectingMultipleLocationWithCheckbox(10);
                awarenessPage.ClickingExportButton();
                awarenessPage.AddingExportFileName("Sample_location");
                awarenessPage.DeselectingIncludedLocation();
                awarenessPage.DeselectingExcludedLocation();
                awarenessPage.ClickingExportSelectedLocationsButton();
                if (!awarenessPage.ValidatingNoOptionSelectionErrorMsg()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Locations were exported without selecting any option while exporting in geo location targeting");
                    softAssert.fail("Locations were exported without selecting any option");
                }
                awarenessPage.ClickingCancelButton();
                awarenessPage.ClickingLocationResetButton();
                awarenessPage.ClickingLocationResetConfirmationButton();
                if (!awarenessPage.ValidatingExportButtonStatus()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - The Export button is enabled without selecting any location while geo location targeting");
                    softAssert.fail("The Export button is enabled without selecting any location");
                }
                awarenessPage.ImportingLocationFile("Sample_locations.json");
                awarenessPage.DeselectingIncludedLocation();
                awarenessPage.ClickingContinueButtonToImport();
                if (!awarenessPage.ValidatingErrorMsgWhenNoOptionSelected()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Locations were imported without selecting any  mandatory options while importing location in geo location targeting");
                    softAssert.fail("Locations were imported without selecting any  mandatory options");
                }
                awarenessPage.ClickingCancelButton();
                awarenessPage.ImportingLocationFile("Image.json");
                if (!awarenessPage.ValidatingErrorMsgWhenUploadingInvalidFile()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to upload  file by changing extension successfully while importing location in geo location targeting");
                    softAssert.fail("User is able to upload  file by changing extension successfully");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ImportingLocationFile("Bug_07.png");
                if (!awarenessPage.ValidatingErrorMsgWhenUploadingInvalidFile()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to upload invalid file successfully while importing location in geo location targeting");
                    softAssert.fail("User is able to upload invalid file successfully");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickCrossButtonLevel2();
                Thread.sleep(1500);
                awarenessPage.ClickingLocationResetConfirmationButton();
                awarenessPage.ClickingOnAudienceTargeting();
                awarenessPage.ClickingOnSearchAudienceField();
                awarenessPage.SelectingDesiredAudience();
                Thread.sleep(1500);
                awarenessPage.ClickingOnSearchAudienceFieldAfterSelectingAudience();
                Thread.sleep(1000);
                awarenessPage.SelectingDesiredAudience();
                if (!awarenessPage.ValidatingErrorMsgForSelectingSameAudienceFromDropdown()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to select same audience from dropdown in audience targeting");
                    softAssert.fail("User is able to select same audience from dropdown");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingOnCreateNewAudienceButton();
                awarenessPage.AddingAudienceNewName("Custom Audience");
                awarenessPage.ClickingAttributeTypeDropdown();
                awarenessPage.SelectingDesiredAttribute(4);
                awarenessPage.ClickingConditionTypeDropdown();
                awarenessPage.SelectingDesiredCondition(1);
                awarenessPage.AddingKeywordsToAttributeValue("Ice-Cream");
                awarenessPage.ClickingOnAddKeywordButton();
                awarenessPage.ClickingOnDeleteAddedKeywordIcon();
                awarenessPage.AddingKeywordsToAttributeValue("Cream");
                awarenessPage.ClickingOnAddKeywordButton();
                if (!awarenessPage.ValidatingAddedCustomKeywords("Cream", 1)) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Adding a valid keyword as attribute value while creating audience");
                    softAssert.fail("keyword is not added");
                }
                awarenessPage.ClickByUserActivityRadioButton();
                if (!awarenessPage.ValidatingPopUpWhileChangingAudience()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User able to change audience type while editing without any error message");
                    softAssert.fail("No pop up is shown while changing audience type while editing");
                }
                awarenessPage.ClickYesButtonForConfirmation();
                awarenessPage.ClickCrossButtonLevel3();
                awarenessPage.ClickingOnCreateNewAudienceButton();
                awarenessPage.ClickOnAudienceSaveButton();
                if (!awarenessPage.ValidatingErrorMsgWithoutFillingAnyDetailClickingSaveButton()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Audience is created without filling mandatory fields While creating new audience");
                    softAssert.fail("Audience is created without filling mandatory fields");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickCrossButtonLevel3();
                awarenessPage.ClickCrossButtonLevel2();
                awarenessPage.ClickYesButtonForConfirmation();
                Thread.sleep(1500);
                awarenessPage.ClickCustomTargeting();
                Thread.sleep(1500);
                awarenessPage.ClickSaveInCustomTargeting();
                if (!awarenessPage.ValidateErrorMessageForSavingEmptyCustomTarget()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to click save button with out any error message in custom targeting");
                    softAssert.fail("User is able to click save button without any error pop up");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                awarenessPage.ClickCrossButtonLevel2();
                awarenessPage.ClickYesButtonForConfirmation();
                Thread.sleep(1000);
                awarenessPage.ClickProductCatalogTargeting();
                Thread.sleep(1500);
                awarenessPage.ClickSaveInProductCatalogTargeting();
                if (!awarenessPage.ClickSaveWithEmptyFieldInProductCatalogTargeting()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to click save button with out any error message in product targeting");
                    softAssert.fail("User is able to click save button with out any error message");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickUploadInProductCatalogTargeting();
                awarenessPage.UploadingFileInProductCatalogTargeting("Empty_sku_id.tsv");
                Thread.sleep(2000);
                awarenessPage.ClickSaveInProductCatalogTargetingAfterUpload();
                if (!awarenessPage.ValidateSuccessfulFileUpload()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to upload an empty file without any error in product targeting");
                    softAssert.fail("User is able to upload an empty file without any error");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickProductCatalogTargeting();
                awarenessPage.ClickingCrossButtonToDeselectSelectedSkuFile();
                Thread.sleep(2000);
                awarenessPage.ClickSaveInProductCatalogTargeting();
                Thread.sleep(1000);
                awarenessPage.ConfirmButtonInProductCatalogTargeting();
                if (!awarenessPage.ValidateSuccessfulFileUpload()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is getting error pop up for not uploading any product catalog file while clicking save button");
                    softAssert.fail("User is getting error pop up for not uploading any product catalog file while clicking save button");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                awarenessPage.ClickProductCatalogTargeting();
                awarenessPage.UploadingFileInProductCatalogTargeting("Invalid_sku_id.tsv");
                Thread.sleep(3000);
                awarenessPage.ClickSaveInProductCatalogTargetingAfterUpload();
                if (!awarenessPage.ValidateInvalidFileErrorMsg()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid file uploaded to target product catalog without error message");
                    softAssert.fail("File Uploaded without any error message");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickCrossButtonLevel2();
                Thread.sleep(1500);
                awarenessPage.ClickYesButtonForConfirmation();
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
                Thread.sleep(1000);
                awarenessPage.ClickAddButton();
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductAddButton();
                awarenessPage.ClickingOnAwarenessCampaignCreativesNewAdSaveButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.SelectQAFullFledgeFormat();
                awarenessPage.ClickingSaveButton();
                awarenessPage.AddValueInDailyBudgetField("300");
                awarenessPage.EnteringDataInChargeableCPMField("ABCD^*^%$^");
                if (!awarenessPage.ValidateChargeableCPMFieldWithSpecialCharactersAndAlphabets()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - CPM field accepting special characters and alphabets without any error message");
                    softAssert.fail("CPM field accepting special characters and alphabets without any error message");
                }
                awarenessPage.EnteringDataInChargeableCPMField("-100");
                if (!awarenessPage.ValidateChargeableCPMFieldWithNegativeValue()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Chargeable CPM field accepts Negative values without any error message while creating auction campaign");
                    softAssert.fail("Chargeable CPM field accepts Negative values without any error message");
                }
                awarenessPage.ClickingChargeableSetButton();
                Thread.sleep(1500);
                awarenessPage.SortMinimumCPMColumn();
                Thread.sleep(1000);
                awarenessPage.EnteringValueLessThanMinimumValue();
                awarenessPage.ClickChargeableSaveButton();
                if (!awarenessPage.ValidateErrorMessageForSavingLessThanMinimumValue()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to save with less than minimum chargeable cpc or cpm value without any error message");
                    softAssert.fail("User is able to save with less than minimum chargeable cpc or cpm value without any error message");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.EnteringValueMoreThanMinimumValue();
                awarenessPage.EnteringValueLessThanMinimumValueInIndividualChargeableCPMField();
                awarenessPage.ClickEnterButton();
                if (!awarenessPage.ValidateWarningForEnteringLessThanMinimumValue()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is not getting any warning for entering less than minimum value");
                    softAssert.fail("User is not getting any warning for entering less than minimum value");
                }
                Thread.sleep(500);
                awarenessPage.ClickCopyToAllButton();
                awarenessPage.ClickYesButtonForConfirmation();
                Thread.sleep(500);
                awarenessPage.ClickResetButton();
                awarenessPage.ClickYesButtonForConfirmation();
                Thread.sleep(500);
                awarenessPage.EnteringValueMoreThanMinimumValueInIndividualChargeableCPMField();
                awarenessPage.ClickEnterButton();
                awarenessPage.ClickChargeableSaveButton();
                Thread.sleep(1000);
                //------------------------------------------------------------------------------------------------------------------------------
                //Biddable field code which may not needed
//                awarenessPage.ClickPublisherSettingsButton();
//                Thread.sleep(1000);
//                awarenessPage.AddValueInBiddableCPMField("ABCD&^&$%$^$*");
//                if (!awarenessPage.ValidateBiddableCPMFieldWithSpecialCharactersAndAlphabets()) {
//                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Biddable CPM field accepting special characters and alphabets without any error message");
//                    softAssert.fail("Biddable CPM field accepting special characters and alphabets without any error message");
//                }
//                awarenessPage.AddValueInBiddableCPMField("-100");
//                if (!awarenessPage.ValidateBiddableCPMFieldWithNegativeValue()) {
//                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Biddable CPM field accepts Negative values without any error message while creating auction campaign");
//                    softAssert.fail("Biddable CPM field accepts Negative values without any error message");
//                }
//                awarenessPage.ClickingBiddableSetButton();
//                Thread.sleep(1500);
//                awarenessPage.EnteringValueLessThanMinimumValueInBiddableField();
//                if (!awarenessPage.ValidateMessageForMinimumBiddableValue()) {
//                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to save less than minimum biddable cpc or cpm value without any error message");
//                    softAssert.fail("User is able to save less than minimum biddable cpc or cpm value without any error message");
//                }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                //may not needed
//                awarenessPage.ClickChargeableSaveButton();
//                if (!awarenessPage.ValidateErrorMessageForSavingLessThanMinimumValue()) {
//                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to save less than minimum chargeable cpc or cpm value without any error message");
//                    softAssert.fail("User is able to save less than minimum chargeable cpc or cpm value without any error message");
//                }
//                awarenessPage.ClickingOnPopUpCloseButton();
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                //may not needed
//                awarenessPage.EnteringValueMoreThanMinimumValueInBiddableField();
//                awarenessPage.ClickingOnPopUpCloseButton();
//                awarenessPage.ClickSubmitForReviewButton();
                //---------------------------------------------------------------------
//                awarenessPage.ClickChargeableSaveButton();

                awarenessPage.ClickPublisherSettingsButton();
                awarenessPage.ClickingAuctionCampaignPriorityField();
                awarenessPage.SelectDropDownFromAuctionCampaignPriority(3);
                Thread.sleep(2000);
                awarenessPage.ClickingOnAuctionAdvancedSettingsButton();
                performancePage.SelectOptimizedCampaignPacing();
                performancePage.ClickCampaignTypeSaveButton();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("Seller Dashboard")
    @Feature("Awareness Page")
    @Story("This flow belongs Auction Campaign Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Validating media estimator Fields", timeOut = 1200000)
    public void ValidateMediaEstimatorTotalBudgetFields() {
        performancePage.RetryOnFailOSMOSSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                awarenessPage.ClickingOnAwarenessDashBoard();
                performancePage.ClickOnCreateCampaignButton();
                performancePage.ClickingNextStepButton();
                awarenessPage.ClickAwarenessNextButton();
                awarenessPage.ClickOnSelectPageButton();
                awarenessPage.EnterPageName("Qa Page 1");
                awarenessPage.SelectPage();
                awarenessPage.ClickDoneButton();
                Thread.sleep(1500);
                awarenessPage.ClickingOnCPMRadioButton();
//                Thread.sleep(1000);
                awarenessPage.SelectMultipleInventories(5);
                Thread.sleep(1500);
                awarenessPage.ClickInventorySaveButton();
                Thread.sleep(1500);
                awarenessPage.ClickBackButton();
                for (int i = 1; i <= 5; i++) {
                    if (!awarenessPage.ValidateDeleteIconForInventories(i)) {
                        awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Checking the delete icon disabled while coming back from targeting page to inventory selecting page after saving inventory");
                        softAssert.fail("Delete Icons should be disabled");
                    }
                }
                Thread.sleep(1500);
                if (!awarenessPage.VerifyAddedInventoriesAreInvisibleInOverviewPanel()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Checking the visibility of selected inventories in overview panel while creating auction campaign");
                    softAssert.fail("All inventories that are added should be reflected in overview panel");
                }
                Thread.sleep(1500);
                awarenessPage.EnterValueInMediaEstimatorTotalBudgetField("-100");
                Thread.sleep(1000);
                if (!awarenessPage.ValidateMediaEstimatorTotalBudgetFieldWithNegativeValue()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Total Budget field accepts Negative values without any error message while creating auction campaign");
                    softAssert.fail("Total Budget field accepts Negative values without any error message");
                }
                Thread.sleep(1500);
                awarenessPage.EnterValueInMediaEstimatorTotalBudgetField("abcderfn@@@^^^***");
                Thread.sleep(1500);
                if (!awarenessPage.ValidateMediaEstimatorTotalBudgetFieldWithSpecialCharactersAndAlphabets()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Total Budget field should accepts special characters and alphabets while creating auction campaign");
                    softAssert.fail("Total Budget field should accept special characters and alphabets");
                }
                Thread.sleep(1500);
                awarenessPage.ClickEnterIcon();
                Thread.sleep(1500);
                awarenessPage.SelectMediaEstimatorCPMBidField("-100");
                if (!awarenessPage.ValidateMediaEstimatorCPMBidFieldWithNegativeValue()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - User able to proceed further without selecting any marketplace while creating auction campaign");
                    softAssert.fail("Cpm bid field should not accept Negative values");
                }
                Thread.sleep(1500);
                awarenessPage.ClickEnterIcon();
                Thread.sleep(1500);
                awarenessPage.SelectMediaEstimatorCPMBidField("abcddfgrej@@##$$");
                if (!awarenessPage.ValidateMediaEstimatorCPMBidFieldWithSpecialCharactersAndAlphabets()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cpm bid field should not accept special characters and alphabets while creating auction campaign");
                    softAssert.fail("Cpm bid field should not accept special characters and alphabets");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));

    }


}



