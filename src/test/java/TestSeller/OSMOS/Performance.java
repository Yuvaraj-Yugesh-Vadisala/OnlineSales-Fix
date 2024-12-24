package TestSeller.OSMOS;

import BaseClass.BaseTest;
import PagesSeller.*;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.IOException;

public class Performance extends BaseTest {

    private PerformancePage performancePage;
    private AwarenessPage awarenessPage;
    private DashboardPage dashboardPage;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosSellerUrl);
        awarenessPage = new AwarenessPage(getDriver());
        performancePage = new PerformancePage(getDriver());
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
    @Feature("Performance Page")
    @Story("This flow belongs to search only campaign creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut=1200000,description = "Test: Create a successful search only campaign flow")
    public void CreateSearchOnlyCampaign() {
        performancePage.RetryOnFailOSMOSSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                performancePage.ClickOnCreateCampaignButton();
                performancePage.SelectSearchOnlyCampaign();
                performancePage.ClickingNextStepButton();
                performancePage.EnterDailyBudgetPrice("20");
                performancePage.ClickOnStartDateField();
                performancePage.DateSelector("August", "2025", "30");
                performancePage.ClickOnChooseWalletField();
                Thread.sleep(1000);
                performancePage.SelectWalletFromDropDown(1);
                String DefaultCampaignName = performancePage.RenameCampaignName();
                performancePage.ClickProductSelectionButton();
                performancePage.ClickAddProductButton();
                performancePage.ClickChooseProductIndividuallyButton();
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(2);
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(3);
                performancePage.ClickAddButton();
                performancePage.ClickSaveButton();
                performancePage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                performancePage.ClickKeywordSettingsButton();
                performancePage.ClickAddKeywordsButton();
                performancePage.AddPositiveKeywordsManually("Shampoo", "Phrase", "27", "Oil",
                        "Exact", "20");
                performancePage.ClickAddGivenKeywordsButton();
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickCrossButtonLevel(3);
                performancePage.ClickYesButton();
                performancePage.ClickAddKeywordsButton();
                performancePage.AddPositiveKeywordsManually("shampOo", "phrase", "27", "Oil",
                        "eXact", "20");
                performancePage.ClickAddGivenKeywordsButton();
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickSaveKeywordsButton();
                if (!performancePage.ValidateStatusOfKeyword()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Keyword Addition Failed");
                    softAssert.fail("Keyword Addition Failed");
                }
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickNegativeKeywordTargeting();
                performancePage.ClickAddNegativeKeywordsButton();
                performancePage.AddNegativeKeywordsManually("knife", "Phrase", "Wireless Charging", "Exact");
                performancePage.AddNegativeKeywordsButton();
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickSaveNegativeKeywordButton();
                Thread.sleep(500);
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickApplyNegativeKeywordButton();
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickSearchOnlyLaunchButton();

                performancePage.ClickOnAdNetworkButton();
                performancePage.SelectDesiredNetwork(1);
                performancePage.ClickOnNetworkSaveButton();
                performancePage.ClickingOnPopUpCloseButton();
                Thread.sleep(1500);
                performancePage.ClickSearchOnlyLaunchButton();
//                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickSearchOnlyCampaignTab();
                dashboardPage.EnterTextInSearchCampaignField(DefaultCampaignName);
                Thread.sleep(1500);
                if (!performancePage.ValidateCreatedSearchOnlyCampaignName(DefaultCampaignName))
                    Assert.fail("Campaign Creation failed");
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("Seller Dashboard")
    @Feature("Performance Page")
    @Story("This flow belongs to smart campaign creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut=1200000,description = "Test: Create a successful smart campaign with all optional features")
    public void CreateSmartCampaignWithAllOptionalFeatures() {
        performancePage.RetryOnFailOSMOSSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                performancePage.ClickOnCreateCampaignButton();
                performancePage.ClickingNextStepButton();
                performancePage.EnterDailyBudgetPrice("20");
                performancePage.EnterMaximumSpendCapPrice("4000");
                performancePage.TogglingOnFlexiBudgetButton();
                performancePage.TogglingOffFlexiBudgetButton();
                performancePage.ClickOnYesForFlexiBudgetConfirmation();
                String DefaultCampaignName = performancePage.RenameCampaignName();
                performancePage.ClickOnChooseWalletField();
                Thread.sleep(1000);
                performancePage.SelectWalletFromDropDown(1);
                performancePage.ClickingProductSelectionButton();
                performancePage.ProductSelectionManualMode();
                performancePage.ClickingAddProductButton();
                performancePage.ClickingUploadProductsInBulkButton();
                performancePage.ClickingDownloadProductListText();
                if (!performancePage.ValidatingProductListDownloadPopUp()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Failed to prepare product List to download while  Bulk Upload");
                    softAssert.fail("Failed to prepare product List to download while  Bulk Upload");
                }
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickingOnDownloadProductListPopUpCloseButton();
                performancePage.ClickingOnDownloadProductListButton();
                Thread.sleep(4000);
                performancePage.BulkUploadFileModifiedWithYes(3);
                performancePage.EnteringCommentsIntoBulkUploadCommentField();
                performancePage.ClickingOnCommentsConfirmButton();
                if (!performancePage.ValidatingUploadedFilePopUp()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - File Not Uploaded In Bulk Upload");
                    softAssert.fail("File Not Uploaded In Bulk Upload");
                }
                performancePage.DeleteFileAfterModification();
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickingOnCheckStatusButton();
                if (!performancePage.ValidateBulkUploadProductCount(35)) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Selected Products are not updated in bulk upload file");
                    softAssert.fail("Soft Assertion - Selected Products are not updated in bulk upload file");
                }
                performancePage.ValidatingManualProductSelectionFrameTitle();
                Thread.sleep(2000);
                performancePage.ProductSelectionManualMode();
                performancePage.ChooseProductSelectionTypeDropdown();
                performancePage.ClickSelectProductToExcludeOption();
                performancePage.ClickingOnYesButton();
                performancePage.ClickAddProductButton();
                performancePage.ClickChooseProductIndividuallyButton();
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(2);
                performancePage.SortingPriceInManualProductSelection();
                performancePage.ClickingOnManualProductionFilterButton();
                performancePage.ClickAddButton();
                performancePage.ClickSaveButton();
                performancePage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                performancePage.ClickingOnBidSettingsButton();
                performancePage.SelectingManualBiddingRadioButton();
                performancePage.ClickingOnManualBiddingBackButton();
                performancePage.SelectingManualBiddingRadioButton();
                performancePage.EnteringDataIntoManualBiddingBidCpcField("15");
                performancePage.ClickingOnManualBiddingApplyButton();
                performancePage.ClickingOnManualBiddingConfirmationButton();
                if (!performancePage.ValidatingManualBiddingSelectedProductCount()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Bid Settings are not Applied To Products");
                    softAssert.fail("Bid Settings are not Applied To Products");
                }
                performancePage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                performancePage.ClickingOnBidSettingsButton();
                performancePage.SelectingManualBiddingRadioButton();
                performancePage.SelectingAllProductsCategoryInManualBidding(2);
                performancePage.SelectingAllProductsCategoryInManualBidding(3);
                performancePage.DeselectingAllProductsCategoryInManualBidding(2);
                performancePage.SelectingAllProductsCategoryInManualBidding(2);
                performancePage.SelectingAllProductsCategoryInManualBidding(1);
                if (!performancePage.ValidatingManualBiddingUpdateBidPopUp()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Failed to Show Selected Product Category Row Count");
                    softAssert.fail("Failed to Show Selected Product Category Row Count");
                }
                performancePage.ClickingOnUpdateBidButtonInManualBidding();
                performancePage.EnteringDataIntoManualBiddingBidUpdateField("11");
                performancePage.ClickingOnManualBiddingBidUpdateDoneButton();
                performancePage.ClickingOnManualBiddingApplyButton();
                if (!performancePage.ValidatingManualBiddingSelectedProductCount()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Bid Settings are not Applied To Product");
                    softAssert.fail("Bid Settings are not Applied To Product");
                }
                performancePage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                performancePage.ClickingProductSelectionButton();
                performancePage.ProductSelectionManualMode();
                performancePage.ClickingOnChooseProductsField();
                performancePage.ClickingOnSelectProductsUsingFilters();
                performancePage.ClickingOnYesButton();
                performancePage.EnteringDataIntoManualProductGenericInputField(1, "yogurt");
                performancePage.ClickingOnAddRowButton();
                performancePage.ClickingOnManualProductGenericRowOptionField(2);
                performancePage.ClickingOnManualProductGenericOptionsDropdown(2);
                performancePage.ClickingOnManualProductionDropdown(1);
                performancePage.EnteringDataInManualProductionGenericFieldWithDropDown(1, "icelandic");
                if (!performancePage.ValidatingManualProductionSelectionGenericFieldWithDropDownResults()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Selected Product Category Not Found in Filter");
                    softAssert.fail("Selected Product Category Not Found in Filter ");
                }
                performancePage.ClickingOnManualProductionSelectionGenericFieldWithDropDownResults();
                performancePage.ClickingOnAddRowButton();
                performancePage.ClickingOnManualProductGenericRowOptionField(3);
                performancePage.ClickingOnManualProductGenericOptionsDropdown(3);
                performancePage.ClickingOnManualProductionDropdown(2);
                Thread.sleep(1000);
                if (!performancePage.ValidatingManualProductionSelectionGenericFieldWithDropDownResults()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Product Brand Not Found In Filtering Products");
                    softAssert.fail("Product Brand Not Found In Filtering Products");
                }
                performancePage.ClickingOnManualProductionSelectionGenericFieldWithDropDownResults();
                Thread.sleep(2000);
                performancePage.ClickingOnProductsCombinationResults();
                if (!performancePage.ValidatingProductsCombinationResults()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid Products Combinations Results");
                    softAssert.fail("Invalid Products Combinations Results");
                }
                performancePage.ClickingOnManualProductionSelectionResultsCloseButton();
                performancePage.ClickingOnManualProductionSaveButton();
                if (!performancePage.ValidatingProductSelectionSettingsPopUp()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Products are Not Selecting in Filter Option");
                    softAssert.fail("Products are Not Selecting in Filter Option");
                }
                performancePage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                performancePage.ClickProductSelectionButton();
                performancePage.ProductSelectionManualMode();
                performancePage.ChooseProductSelectionTypeDropdown();
                performancePage.ClickSelectProductToExcludeOption();
                performancePage.ClickingOnYesButton();
                performancePage.ClickAddProductButton();
                performancePage.ClickChooseProductIndividuallyButton();
                performancePage.SortingPriceInManualProductSelection();
                performancePage.ClickingOnManualProductionFilterButton();
                performancePage.ClickingOnProductNameInManualProductionFilter();
                performancePage.EnteringDataInManualProductionSelectionProductNameField("yogurt");
                performancePage.ClickingOnManualProductionFilterClearAllButton();
                performancePage.ClickingOnManualProductionFilterClearAllConformationButton();
                performancePage.ClickingOnManualProductionFilterButton();
                performancePage.ClickingOnProductNameInManualProductionFilter();
                performancePage.EnteringDataInManualProductionSelectionProductNameField("Ice Cream");
                performancePage.ClickingOnProductCategoryInManualProductionFilter();
                performancePage.EnteringDataInManualProductionSelectionProductCategoryField("Ice Cream");
                if (!performancePage.ValidatingProductCategoryFieldResult()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Selected Product Category Not Found");
                    softAssert.fail("Selected Product Category Not Found");
                }
                performancePage.ClickingOnFilterGenericDropdown(1);
                performancePage.ClickingOnProductBrandInManualProductionFilter();
                performancePage.EnteringDataInManualProductionSelectionProductBrandField("Whitakers");
                if (!performancePage.ValidatingProductCategoryFieldResult()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Entered Product Brand not Available ");
                    softAssert.fail("Entered Product Brand not Available");
                }
                performancePage.ClickingOnFilterGenericDropdown(1);
                performancePage.ClickingOnPriceInManualProductionFilter();
                performancePage.EnteringDataInManualProductionSelectionPriceMinField("3");
                performancePage.EnteringDataInManualProductionSelectionPriceMaxField("7");
                performancePage.ClickingOnSalePriceInManualProductionFilter();
                performancePage.EnteringDataInManualProductionSelectionSalePriceMinField("2");
                performancePage.EnteringDataInManualProductionSelectionSalePriceMaxField("6");
                performancePage.ClickingOnManualProductionFilterApplyButton();
                performancePage.ClickingOnAllProductsRadioButton();
                performancePage.ClickAddButton();
                performancePage.ClickSaveButton();
                performancePage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                performancePage.ClickKeywordSettingsButton();
                performancePage.KeywordSelectionManualMode();
                performancePage.ClickGetKeywordIdeas();
                performancePage.ClickSearchCategoryDropdown();
                performancePage.SelectingKeywordIdeasSearchCategory(1);
                performancePage.ClickMatchTypeDropdown();  //Keyword Ideas are not available
                performancePage.SelectPhraseFromMatchTypeDropdown();
                performancePage.ClickingOnKeywordIdeasMatchTypeCopySymbol();
                performancePage.ClickSelectButton();
                performancePage.AddBidValue("0");
                if (!performancePage.ValidatingVisibilityOfWarningIcon()) {  //changes
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Bid Field is accepting 0 value in Bid Settings without any error or waring");
                    softAssert.fail("Bid Field is accepting 0 value in Bid Settings without any error or warning");
                }
                performancePage.AddBidValue("0.55");
                performancePage.ClickingOnKeywordIdeasBidCopySymbol();
                performancePage.ClickSaveSelectedKeywords();
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickApplyKeywordButton();
                Thread.sleep(2000);
                performancePage.ClickAdvanceSettingsButton();
                performancePage.SelectOptimizedCampaignPacing();
                performancePage.ClickCampaignTypeSaveButton();
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickOnNetworkTargetingTab();
                Thread.sleep(1500);
                performancePage.SelectDesiredNetwork(1);
                performancePage.ClickOnNetworkSaveButton();
                performancePage.ClickingOnPopUpCloseButton();
                Thread.sleep(1500);
                performancePage.ClickSmartLaunchButton();
                if (!performancePage.ValidateCreatedSmartCampaignName(DefaultCampaignName)) {
                    Assert.fail("Campaign Creation failed");
                }
            } catch (InterruptedException  e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        softAssert.assertAll();
        }));
    }


    @Epic("Seller Dashboard")
    @Feature("Performance Page")
    @Story("This flow belongs to smart campaign creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut=1200000,description = "Test: Validation of all fields while creating performance campaign")
    public void ValidateAllFieldsInPerformanceCampaignCreation() {
        performancePage.RetryOnFailOSMOSSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                performancePage.ClickOnCreateCampaignButton();
                performancePage.ClickingNextStepButton();
                performancePage.ClickSmartLaunchButton();
                if (!performancePage.ValidateErrorMessageDailyBudget()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to launch the campaign without filling mandatory field without any error message");
                    softAssert.fail("User is able to launch the campaign without filling mandatory field without any error message");
                }
                performancePage.EnterDailyBudgetPrice("abcd!@#$");
                if (performancePage.ValidateDailyBudgetFieldWithCharacters("abcd!@#$")) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Daily budget field accepts special characters without any error messages");
                    softAssert.fail("Daily budget field accepts special characters without any error messages");
                }
                performancePage.EnterDailyBudgetPrice("-200");
                if (performancePage.ValidateDailyBudgetFieldWithNegativeValue()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Daily budget field is accepting negative value without any error messages");
                    softAssert.fail("Daily budget field is accepting negative value without any error message");
                }
                performancePage.EnterDailyBudgetPrice("0.5");
                performancePage.ClickSmartLaunchButton();
                if (!performancePage.ValidateErrorMessageDailyBudget()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Daily budget field is accepting less than minimum value without any error message");
                    softAssert.fail("Daily budget field is accepting less than minimum value without any error message");
                }
                performancePage.EnterDailyBudgetPrice("100");
                performancePage.EnterMaximumSpendCapPrice("60");
                performancePage.ClickSmartLaunchButton();
                if (!performancePage.ValidateErrorMessageMaximumSpendCap()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Maximum Spend Cap field is accepting less than daily budget value with out error message");
                    softAssert.fail("Maximum Spend Cap field is accepting less than daily budget value with out error message");
                }
                performancePage.EnterMaximumSpendCapPrice("-400");
                if (performancePage.ValidateMaximumSpendCapFieldWithNegativeValue()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Maximum Spend Cap field is accepting negative value");
                    softAssert.fail("Maximum Spend Cap field is accepting negative value");
                }
                Thread.sleep(2000);
                performancePage.EnterMaximumSpendCapPrice("abcd@#$%");
                if (performancePage.ValidateMaximumSpendCapFieldWithCharacters("abcd@#$%")) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Maximum spend cap field accepts special Characters");
                    softAssert.fail("Maximum spend cap field accepts special Characters");
                }
                performancePage.ClickOnChooseWalletField();
                Thread.sleep(1000);
                performancePage.SelectWalletFromDropDown(1);
                performancePage.ClickingProductSelectionButton();
                performancePage.ProductSelectionManualMode();
                performancePage.ClickingOnChooseProductsField();
                performancePage.ClickingOnSelectProductsUsingFilters();
                performancePage.ClickingOnManualProductionSaveButton();
                if (!performancePage.ValidatingErrorMessageWhileClickingSaveWithoutAddingAnyProduct()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creating a campaign without selecting any products");
                    softAssert.fail("Creating a campaign without selecting any products");
                }
                performancePage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                performancePage.ClickCrossButtonLevel(2);
                Thread.sleep(1500);
                performancePage.ClickingOnYesButton();
                Thread.sleep(1500);
                performancePage.ClickingOnBidSettingsButton();
                performancePage.SelectingManualBiddingRadioButton();
                performancePage.ClickingOnManualBiddingBackButton();
                performancePage.SelectingManualBiddingRadioButton();
                Thread.sleep(2000);
                performancePage.ClickingOnManualBiddingApplyButton();
                if (!performancePage.ValidatingBidSettingsErrorPopUp()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Bid cpc field is accepting empty value");
                    softAssert.fail("Bid cpc field is accepting empty value");
                }
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.EnteringDataIntoManualBiddingBidCpcField("-4");
                if (performancePage.ValidatingBidValueFieldWithNegativeValue("-4")) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Bid cpc field accepts negative value");
                    softAssert.fail("Bid cpc field accepts negative value");
                }
                performancePage.EnteringDataIntoManualBiddingBidCpcField("0.01");
                if (!performancePage.ValidatingBidValueFieldWithMinimumValue()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Bid cpc is accepting less then 0.02 bid value");
                    softAssert.fail("Bid cpc is accepting less then 0.02 bid value");
                }

                performancePage.ClickCrossButtonLevel(2);
                performancePage.ClickingOnYesButton();
                performancePage.ClickKeywordSettingsButton();
                performancePage.KeywordSelectionManualMode();
                performancePage.ClickGetKeywordIdeas();
                performancePage.ClickSearchCategoryDropdown();
                performancePage.SelectingKeywordIdeasSearchCategory(1);
                performancePage.ClickSaveSelectedKeywords();
                if (!performancePage.KeywordIdeasEmptyKeywordsPopUp()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Empty Keywords are Saving with out any error");
                    softAssert.fail("Empty Keywords are Saving with out any error");
                }
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickCrossButtonLevel(3);
                Thread.sleep(2000);
                performancePage.ClickGetKeywordIdeas();
                performancePage.ClickSearchCategoryDropdown();
                performancePage.SelectingKeywordIdeasSearchCategory(1);
                performancePage.ClickMatchTypeDropdown();
                performancePage.SelectPhraseFromMatchTypeDropdown();
                performancePage.ClickingOnKeywordIdeasMatchTypeCopySymbol();
                performancePage.ClickSelectButton();
                performancePage.AddBidValue("0");
                if (!performancePage.ValidatingVisibilityOfWarningIcon()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Bid Cpc Field is Accepting 0 Value");
                    softAssert.fail("Bid Cpc Field is Accepting 0 Value");
                }
                performancePage.ClickCrossButtonLevel(3);
                performancePage.ClickingOnYesButton();
                performancePage.ClickAddKeywordsButton();
                performancePage.AddNegativeKeywordsFromExcel("999");
                performancePage.ClickAddGivenKeywordsButton();
                if (!performancePage.ValidateSuccessfulKeywordAddition()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Keyword settings is failed to accept keywords under 1000");
                    softAssert.fail("Keyword settings is failed to accept keywords under 1000");
                }
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickCrossButtonLevel(3);
                performancePage.ClickYesButton();
                Thread.sleep(2000);
                performancePage.ClickAddKeywordsButton();
                performancePage.AddNegativeKeywordsFromExcel("1005");
                performancePage.ClickAddGivenKeywordsButton();
                if (!performancePage.ValidateErrorMessageKeywordField()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Keyword settings is accepting keywords more than 1000");
                    softAssert.fail("Keyword settings is accepting keywords more than 1000");
                }
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickCrossButtonLevel(3);
                performancePage.ClickYesButton();
                Thread.sleep(2000);
                performancePage.ClickAddKeywordsButton();
                performancePage.AddNegativeKeywordsFromExcel("invalid_format");
                performancePage.ClickAddGivenKeywordsButton();
                if (!performancePage.ValidateErrorMessageKeywordField()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Keyword settings is accepting invalid format Keywords");
                    softAssert.fail("Keyword settings is accepting invalid format Keywords");
                }
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickCrossButtonLevel(3);
                performancePage.ClickYesButton();
                Thread.sleep(2000);
                performancePage.ClickAddKeywordsButton();
                performancePage.ClickAddGivenKeywordsButton();
                if (!performancePage.ValidateErrorMessageForEmptyKeywordField()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Empty Keyword field is accepted with our error message in keyword settings");
                    softAssert.fail("Empty Keyword field is accepted with our error message in keyword settings");
                }
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickCrossButtonLevel(3);
                performancePage.ClickAddKeywordsButton();
                performancePage.AddNegativeKeywordsFromExcel("Exceeding250");
                Thread.sleep(2000);
                performancePage.ClickAddGivenKeywordsButton();
                if (!performancePage.ValidateExceedLimitKeywordAdditionErrorMsg()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Keyword settings is accepting keywords exceeding 250 letters");
                    softAssert.fail("Keyword settings is accepting keywords exceeding 250 letters");
                }
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickCrossButtonLevel(3);
                performancePage.ClickAddKeywordsButton();
                performancePage.AddNegativeKeywordsFromExcel("Invalid_keywords");
                Thread.sleep(2000);
                performancePage.ClickAddGivenKeywordsButton();
                if (!performancePage.ValidateInvalidKeywordAdditionErrorMsg()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Keyword settings is accepting keywords with special character in middle");
                    softAssert.fail("Keyword settings is accepting keywords with special character in middle");
                }
                performancePage.ClickingOnPopUpCloseButton();
                performancePage.ClickCrossButtonLevel(3);
                performancePage.ClickYesButton();
                performancePage.ClickAddKeywordsButton();
                performancePage.AddNegativeKeywordsFromExcel("Duplicates");
                performancePage.ClickAddGivenKeywordsButton();
                performancePage.ClickingOnPopUpCloseButton();
                if (!performancePage.ValidateErrorMessageKeywordField()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Keyword Targeting is accepting duplicate values");
                    softAssert.fail("Keyword targeting is accepting duplicate values without any error message");
                }
                performancePage.ClickOnNetworkTargetingTab();
                Thread.sleep(1000);
                performancePage.ClickOnNetworkSaveButton();
                if (!performancePage.ValidateErrorMessageForNotSelectionOfAnyNetwork()) {
                    performancePage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to click save button without selecting any network targeting and getting no error message");
                    softAssert.fail("User is able to click save button without selecting any network targeting and getting no error message");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));

    }


//    @Epic("Seller Dashboard")
//    @Feature("Performance Page")
//    @Story("This flow belongs to create campaign")
//    @Severity(SeverityLevel.CRITICAL)
//    @Test(timeOut=1200000,description = "Test: Validate reset to ideal settings confirmation ")
//    public void ValidateResetToIdealSettingsConfirmation() {
//        performancePage.ClickOnCreateCampaignButton();
//        performancePage.ClickNextButton();
//        performancePage.EnterDailyBudgetPrice("20");
//        performancePage.EnterTotalBudgetPrice("4000");
//        performancePage.TogglingOnFlexiBudgetButton();
//        performancePage.TogglingOffFlexiBudgetButton();
//        performancePage.ClickOnYesForFlexiBudgetConfirmation();
////        performancePage.RenameSmartCampaignName("New Campaign Sample1");
//        performancePage.ClickResetToIdealSettingsButton();
//        performancePage.ClickRestIdealSettingConfirmationButton();
//        if (!performancePage.ValidateResetToIdealSettingsConfirmation())
//            Assert.fail("Reset to Ideal Settings Failed");
//    }


}
