package TestSeller.Tving;

import BaseClass.BaseTest;
import PagesPulse.OrdersPage;
import PagesPulse.ProductTemplatePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class OrdersDev extends BaseTest {

    private OrdersPage ordersPage;
    private ProductTemplatePage productTemplatePage;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(TvingSellerUrl);
        ordersPage = new OrdersPage(getDriver());
        productTemplatePage = new ProductTemplatePage(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "f968ddd03b493e94f7c70fa14e5c43d4");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }

    @BeforeMethod
    public void ResetPage() {
        getDriver().navigate().refresh();
    }


        @AfterClass
    public void TearDown() {
        getDriver().quit();
    }

    public void Redirect() {
        getDriver().navigate().to(PulseUrl);
        Cookie UAToken = new Cookie("UA_TOKEN", "bff88ccf038bc03f34efb34c04479b38");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }

    public void RedirectToDev() {
        getDriver().navigate().to(TvingSellerUrl);
//        Cookie UAToken = new Cookie("UA_TOKEN", "bff88ccf038bc03f34efb34c04479b38");
//        Cookie Ubid = new Cookie("ubid", "unique12345");
//        getDriver().manage().addCookie(UAToken);
//        getDriver().manage().addCookie(Ubid);
//        getDriver().navigate().refresh();
    }

    @Epic("TVING Dev - Seller Dashboard")
    @Feature("This flow belongs to Order Creation flow")
    @Story("Order Creation - Positive Flow")
    @Test(description = "Test: Creation of order using all mandatory features", priority = 1)
    public void CreateNewOrderWithAllMandatoryFields() {
        ordersPage.RetryOnFailTvingSeller((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            if (!Language.equals("en")) {
                productTemplatePage.ChangeLanguage();
            }
            ordersPage.ClickOnDevOrdersButton();
            ordersPage.ClickOnSellerSelectAdAccountField();
            ordersPage.ClickOnSelectAdAccountSearchIcon();
            ordersPage.EnterDataInSellerAdAccountSearchField("AD_ACCOUNT_DEV");
            ordersPage.SelectAdAccountDropDown(1);
            ordersPage.ClickOnCreateOrderButton();
            ordersPage.AddNameInNameField();
            ordersPage.EnterDataInAllOrdersDescriptionField(10);
            ordersPage.ClickOnBillingMonthField();
            ordersPage.ClickOnBillingMonthNextYearNavButton("2020");
            ordersPage.SelectingDesiredMonthInBillingMonthField(2);
            ordersPage.ClickOnCreateOrderBrandField();
            ordersPage.EnterDataInDevBrandSearchField("JTBC");
            ordersPage.SelectingDesiredOptionFromDebBrandDropDown(1);
            ordersPage.ClickOnAdvertiserCategoryField();
//              ordersPage.EnterDataInIabCategorySearchField("Business");
            ordersPage.SelectingDesiredOptionFromIabCategoryDropDown(1);
            ordersPage.ClickOnSubscriptionCategoryField();
            ordersPage.SelectingDesiredOptionFromCustomCategoryDropDown(1);
            ordersPage.ClickOnCreateOrderBasicInfoSaveButton();
            ordersPage.EnterDataInOrderCostField("20000");
            ordersPage.ClickOnCreateOrderAddTemplateButton();
            ordersPage.EnterDataInAddTemplateSearchField("%%%##");
            ordersPage.SelectingDesiredTemplateRadioButtonFromTable(2);
            ordersPage.EnterDataInAddTemplateSearchField("QATestingP0L_");
            ordersPage.SelectingDesiredTemplateRadioButtonFromTable(2);
            ordersPage.ClickOnAddProductTemplatesButton();
            ordersPage.ClickStartDateFieldForDesiredTemplate(1);
            ordersPage.ClickOnYearField();
            ordersPage.SelectCurrentYearFromYearDropdown();
            ordersPage.ClickOnGenericMonthField();
            ordersPage.SelectCurrentMonthFromMonthDropDown();
            ordersPage.SelectDayBasedOnTimeAhead();
            ordersPage.SelectValidTime();
            ordersPage.ClickOnCalenderApplyButton();
            ordersPage.ClickEndDateFieldForDesiredTemplate(1);
            ordersPage.ClickOnYearField();
            if (!ordersPage.SelectDesiredYearFromYearDropdown(2024)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in ads period window date");
                softAssert.fail("Year cant be less then current year in ads period window date");
            }
            ordersPage.ClickOnGenericMonthField();
            if (!ordersPage.SelectMonthFromMonthDropDown(12)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info ads period window date");
                softAssert.fail("Cant select older then present month in basic info ads period window date");
            }
            ordersPage.SelectDesiredDayDayRange(29);
            ordersPage.ClickOnCalenderApplyButton();
            ordersPage.EnterDataInPackageTotalCostField(1, "10000");
            ordersPage.EnterDataInBonusRateField(1, "0");
            ordersPage.ClickStartDateFieldForDesiredTemplate(2);
            ordersPage.ClickOnYearField();
            ordersPage.SelectCurrentYearFromYearDropdown();
            ordersPage.ClickOnGenericMonthField();
            ordersPage.SelectCurrentMonthFromMonthDropDown();
            ordersPage.SelectDayBasedOnTimeAhead();
            ordersPage.SelectValidTime();
            ordersPage.ClickOnCalenderApplyButton();

            ordersPage.ClickEndDateFieldForDesiredTemplate(2);
            ordersPage.ClickOnYearField();
            if (!ordersPage.SelectDesiredYearFromYearDropdown(2024)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in ads period window date");
                softAssert.fail("Year cant be less then current year in ads period window date");
            }
            ordersPage.ClickOnGenericMonthField();
            if (!ordersPage.SelectMonthFromMonthDropDown(12)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info ads period window date");
                softAssert.fail("Cant select older then present month in basic info ads period window date");
            }
            ordersPage.SelectDesiredDayDayRange(29);
            ordersPage.ClickOnCalenderApplyButton();
            ordersPage.EnterDataInPackageTotalCostField(2, "10000");
            ordersPage.EnterDataInBonusRateField(2, "0");
            ordersPage.ClickOnProductTemplateNextButton();
//                ordersPage.SelectingDesiredOptionFromCreativeTreeMenu(2);
            ordersPage.ClickOnAddCreativeButton();
            ordersPage.EnterDataInCreativeDetailsNameField("Qa Testing");
            ordersPage.EnterDataInCreativeDetailsDescriptionField(15);
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("100");     //commented for staging-2
            ordersPage.EnterDataInCreativeDetailsUrlField("https://example.com");
            ordersPage.ClickOnCreativeDetailsSpecificUrlRadioButton();
            ordersPage.ClickOnYesButton();
            ordersPage.EnterDataInCreativeDetailsWebUrlField("https://example.com");
            ordersPage.EnterDataInCreativeDetailsIosUrlField("https://example.com");
            ordersPage.EnterDataInCreativeDetailsAndroidUrlField("https://example.com");
            ordersPage.SelectingCreativeDetailsChooseFromLibraryButton(1);
            ordersPage.OptionalSendToCreativelibrarySearchField("VerifiedTag");
            Thread.sleep(1500);
            ordersPage.SelectingCreativeLibraryVideo(1);
            Thread.sleep(2000);
            ordersPage.ClickOnCreativeLibraryChooseButton();
            Thread.sleep(1500);
            if (!ordersPage.IsApprovedVideoTickMarkDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Approved video tick mark is not displayed after selecting approved video");
                softAssert.fail("Approved video tick mark is not displayed after selecting approved video");
            }
            ordersPage.ClickOnVideoCreativeCloseButton();
            ordersPage.ClickOnYesButtonToConfirm();
            ordersPage.SelectingDesiredVideoUploadFromSystemButton("1920✕1080px_Video.mp4");
            ordersPage.ClickOnVideoCreativeCloseButton();
            ordersPage.ClickOnYesButtonToConfirm();
            ordersPage.SelectingCreativeDetailsChooseFromLibraryButton(1);
            ordersPage.SelectingCreativeLibraryVideo(1);
            ordersPage.ClickOnAddTagButton();
            ordersPage.SendKeysToAddTagInputField(ordersPage.TagName2);
            ordersPage.ClickOnAddTagSaveButton();
//                ordersPage.ClickOnAddTagSaveButton();  //duplicate
            ordersPage.ClickOnCreativeLibraryChooseButton();
            ordersPage.ClickOnVideoCreativeCloseButton();
            ordersPage.ClickOnYesButtonToConfirm();
            ordersPage.SelectingDesiredVideoUploadFromSystemButton("1920✕1080px_Video.mp4");
            ordersPage.ClickOnVideoCreativeCloseButton();
            ordersPage.ClickOnYesButtonToConfirm();
            ordersPage.SelectingCreativeDetailsChooseFromLibraryButton(1);
            ordersPage.SelectingCreativeLibraryVideo(1);
            ordersPage.ClickOnAddTagButton();
            ordersPage.SendKeysToAddTagInputField(ordersPage.TagName);
            ordersPage.ClickOnAddTagSaveButton();
//                ordersPage.ClickOnAddTagSaveButton(); //duplicate
            Thread.sleep(1000);
            ordersPage.ClickOnCreativeLibraryChooseButton();
            ordersPage.ClickOnCreativeLibraryAddCompanionImagesToggleButton();
            ordersPage.SelectingCreativeDetailsChooseFromLibraryButton(1);
            ordersPage.SelectingCreativeLibraryImage(1);
            ordersPage.ClickOnCreativeLibraryChooseButton();
            ordersPage.SelectingCreativeDetailsChooseFromLibraryButton(1);
            ordersPage.SelectingCreativeLibraryImage(1);
            ordersPage.ClickOnCreativeLibraryChooseButton();
            ordersPage.ClickOnCreativeLibraryAdSchedulingToggleButton();
            ordersPage.ClickOnCreativeLibraryAddTimeSlotsButton();
            ordersPage.SelectingDesiredTimeSlotTrashIconButton(1);
            ordersPage.ClickOnCreativeLibraryAddTimeSlotsButton();
            ordersPage.ClickOnCreativeLibraryAddTimeSlotsButton();
            ordersPage.ClickOnCreativeLibraryAdSchedulingTSelectDayField(1);
            ordersPage.SelectingDesiredOptionSelectDaysDropDownOptions(2);
            ordersPage.ClickOnClickOnCreativeLibrarySelectTimeSlotField(1);
            ordersPage.SelectingDesiredTimeSlotFromTimeSlotsDropDown(3);
            ordersPage.ClickOnCreativeLibraryAdSchedulingTSelectDayField(2);
            ordersPage.SelectingDesiredOptionSelectDaysDropDownOptions(3);
            ordersPage.ClickOnClickOnCreativeLibrarySelectTimeSlotField(2);
            ordersPage.SelectingDesiredTimeSlotFromTimeSlotsDropDown(3);
            ordersPage.SelectingDesiredTimeSlotCopyIconButton(2);
            ordersPage.ClickOnCreativeLibraryAdSchedulingTSelectDayField(3);
            ordersPage.SelectingDesiredOptionSelectDaysDropDownOptions(4);
            Thread.sleep(1000);
            ordersPage.ClickOnScheduleAdRadioButton();
            ordersPage.ClickOnCreativeDetailsStartDateField();
            ordersPage.ClickOnYearField();
            if (!ordersPage.SelectDesiredYearFromYearDropdown(2025)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in ads period window date");
                softAssert.fail("Year cant be less then current year in ads period window date");
            }
            ordersPage.ClickOnGenericMonthField();
            if (!ordersPage.SelectMonthFromMonthDropDown(3)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info ads period window date");
                softAssert.fail("Cant select older then present month in basic info ads period window date");
            }
            ordersPage.SelectDesiredDayDayRange(20);
            ordersPage.ClickOnCreativeDetailsEndDateField();
            ordersPage.ClickOnYearField();
            if (!ordersPage.SelectDesiredYearFromYearDropdown(2025)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in ads period window date");
                softAssert.fail("Year cant be less then current year in ads period window date");
            }
            ordersPage.ClickOnGenericMonthField();
            if (!ordersPage.SelectMonthFromMonthDropDown(3)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info ads period window date");
                softAssert.fail("Cant select older then present month in basic info ads period window date");
            }
            ordersPage.SelectDesiredDayDayRange(29);
            ordersPage.ClickOnAddTrackerButton();
            ordersPage.EnterDataInImpressionUrlField(1, "example.com");
            ordersPage.ClickOnAddTrackerButton();
            ordersPage.SelectDesiredEventTrackerField(2);
            ordersPage.SelectingDesiredOptionFromTrackerField(2);
            ordersPage.EnterDataInClickTrackerUrlField(1, "example.com");
            ordersPage.ClickOnCreativeDetailsSaveButton();
            if (!ordersPage.IsAdCreativeAddSuccessPopupDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - On clicking creative ad save ad the ad is not created in creative");
                softAssert.fail("On clicking creative ad save ad the ad is not created in creative");
            }
            ordersPage.ClickOnPopupCloseButton();
            //--------------------Adding product template--------------------------------------------
            ordersPage.SelectCreativeProductTemplateCard(1);
            ordersPage.ClickOnAddCreativeButton();
            ordersPage.EnterDataInCreativeDetailsNameField("Display Ads Qa Testing");
            ordersPage.EnterDataInCreativeDetailsDescriptionField(15);
            ordersPage.EnterDataInCreativeDetailsUrlField("https://example.com");
            ordersPage.ClickOnCreativeDetailsSpecificUrlRadioButton();
            ordersPage.ClickOnYesButton();
            ordersPage.EnterDataInCreativeDetailsWebUrlField("https://example.com");
            ordersPage.EnterDataInCreativeDetailsIosUrlField("https://example.com");
            ordersPage.EnterDataInCreativeDetailsAndroidUrlField("https://example.com");
            ordersPage.UploadingImageInDisplayAdCreativeLibraryUploadField("1920X160.png");
            ordersPage.ClickOn750X122ImageFormat();
            ordersPage.ClickOnYesButtonToConfirm();
            ordersPage.UploadingImageInDisplayAdCreativeLibraryUploadField("750X122.png");
            ordersPage.ClickOn550X190ImageFormat();
            ordersPage.ClickOnYesButtonToConfirm();
            ordersPage.UploadingImageInDisplayAdCreativeLibraryUploadField("550X190.jpg");
            ordersPage.ClickOnVideoCreativeCloseButton();
            ordersPage.ClickOnYesButtonToConfirm();
            ordersPage.SelectingCreativeDetailsChooseFromLibraryButton(1);
            ordersPage.ClickOnImagePreviewSelector();
            ordersPage.ClickOnAddTagButton();
            ordersPage.SendKeysToAddTagInputField(ordersPage.ImageTagName);
            ordersPage.ClickOnAddTagSaveButton();
            ordersPage.ClickOnCreativeLibraryChooseButton();
            ordersPage.ClickOnCreativeDetailsSaveButton();
            if (!ordersPage.IsAdCreativeAddSuccessPopupDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - On clicking creative ad save ad the ad is not created in creative");
                softAssert.fail("On clicking creative ad save ad the ad is not created in creative");
            }
            ordersPage.ClickOnPopupCloseButton();
            //-------------------------------------------
            ordersPage.ClickOnPreviewOrderButton();
            ordersPage.ClickOnSubmitForReviewButton();
            Redirect();   //Redirect to dev pulse to verify created order
            ordersPage.ClickOnOrdersTemplateButton();
            ordersPage.ClickOnAllOrdersButton();
            ordersPage.EnterDataInOrdersTableSearchField(ordersPage.ApprovedOrderName);
            Thread.sleep(1000);
            ordersPage.ClickOnMenuButton();
            ordersPage.ClickOnEditButton();
            ordersPage.EnterDataInAllOrdersDescriptionField(10);
            ordersPage.ClickOnBillingMonthField();
            ordersPage.ClickOnBillingMonthNextYearNavButton("2024");
            ordersPage.SelectingDesiredMonthInBillingMonthField(10);
            ordersPage.ClickOnAdvertiserCategoryField();
            ordersPage.SelectingDesiredOptionFromIabCategoryDropDown(1);
            ordersPage.ClickOnSubscriptionCategoryField();
            ordersPage.SelectingDesiredOptionFromCustomCategoryDropDown(1);
            ordersPage.ClickOnOrdersDetailsSaveButton();
            ordersPage.EnterDataInOrderCostField("60000");
            ordersPage.EnterDataInPackageTotalCostField(1, "15000");
            //Set Daily Budget cap operations
            ordersPage.SelectingDesiredDailyBudgetCapRadioButton(1);
            ordersPage.SelectingDesiredDailyBudgetCapRadioButton(1);
            Thread.sleep(10000);
            ordersPage.SelectingDesiredDailyBudgetCapEditButton(1);
            ordersPage.SelectingDesiredDailyBudgetRadioButton(1);
            if (!ordersPage.VerifyEditableDailyBudgetFieldsMatchWithStartDateEndDate()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Mismatch in editable budget fields: some fields are incorrectly editable or non-editable based on the start and end dates.");
                softAssert.fail("Mismatch in editable budget fields: some fields are incorrectly editable or non-editable based on the start and end dates.");
            }
            ordersPage.EnterDataInDailyBudgetCapBudgetField(1, "577");
            ordersPage.SelectingDesiredDailyBudgetCopyIcon(1, 1);
            ordersPage.ClickOnCopyToAllButton();
            ordersPage.ClickOnSplitEquallyButton();
            ordersPage.ClickOnYesButton();
            ordersPage.ClickOnDailyBudgetSaveButton();
            Thread.sleep(1500);
            ordersPage.OptionallyClickOnClosedOrderTemplate(1);
            ordersPage.SelectingDesiredDailyBudgetCapRadioButton(1);
            ordersPage.ClickOnAddMoreProductTemplatesButton();
            ordersPage.EnterDataInAddTemplateSearchField("QATestingKRbO");
            Thread.sleep(1500);
            ordersPage.SelectingDesiredTemplateRadioButtonFromTable(2);
            ordersPage.ClickOnAddProductTemplatesButton();
            ordersPage.ClickStartDateFieldForDesiredTemplate(1);
            ordersPage.ClickOnYearField();
            if (!ordersPage.SelectDesiredYearFromYearDropdown(2024)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in ads period window date");
                softAssert.fail("Year cant be less then current year in ads period window date");
            }
            ordersPage.ClickOnGenericMonthField();
            if (!ordersPage.SelectMonthFromMonthDropDown(12)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info ads period window date");
                softAssert.fail("Cant select older then present month in basic info ads period window date");
            }
            ordersPage.SelectDayBasedOnTimeAhead();
//            ordersPage.SelectValidTime();
            ordersPage.ClickOnCalenderApplyButton();
            ordersPage.ClickEndDateFieldForDesiredTemplate(1);
            ordersPage.ClickOnYearField();
            if (!ordersPage.SelectDesiredYearFromYearDropdown(2025)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in ads period window date");
                softAssert.fail("Year cant be less then current year in ads period window date");
            }
            ordersPage.ClickOnGenericMonthField();
            if (!ordersPage.SelectMonthFromMonthDropDown(1)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info ads period window date");
                softAssert.fail("Cant select older then present month in basic info ads period window date");
            }
            ordersPage.SelectDesiredDayDayRange(29);
            ordersPage.ClickOnCalenderApplyButton();
            ordersPage.EnterDataInPackageTotalCostField(1, "15000");

            //-------------------------Adding Display Ad Template---------------------------------------------

            ordersPage.ClickOnAddMoreProductTemplatesButton();
            ordersPage.EnterDataInAddTemplateSearchField("Display Ad Qa Testing");
            ordersPage.SelectingDesiredTemplateRadioButtonFromTable(2);
            ordersPage.ClickOnAddProductTemplatesButton();
            ordersPage.ClickStartDateFieldForDesiredTemplate(4);
            ordersPage.ClickOnYearField();
            if (!ordersPage.SelectDesiredYearFromYearDropdown(2024)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in ads period window date");
                softAssert.fail("Year cant be less then current year in ads period window date");
            }
            ordersPage.ClickOnGenericMonthField();
            if (!ordersPage.SelectMonthFromMonthDropDown(12)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info ads period window date");
                softAssert.fail("Cant select older then present month in basic info ads period window date");
            }
            ordersPage.SelectDayBasedOnTimeAhead();
            ordersPage.SelectValidTime();
            ordersPage.ClickOnCalenderApplyButton();
            ordersPage.ClickEndDateFieldForDesiredTemplate(4);
            ordersPage.ClickOnYearField();
            if (!ordersPage.SelectDesiredYearFromYearDropdown(2025)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in ads period window date");
                softAssert.fail("Year cant be less then current year in ads period window date");
            }
            ordersPage.ClickOnGenericMonthField();
            if (!ordersPage.SelectMonthFromMonthDropDown(1)) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info ads period window date");
                softAssert.fail("Cant select older then present month in basic info ads period window date");
            }
            ordersPage.SelectDesiredDayDayRange(29);
            ordersPage.ClickOnCalenderApplyButton();
            ordersPage.EnterDataInPackageTotalCostField(3, "15000");
            ordersPage.EnterDataInPackageTotalCostField(4, "15000");
            ordersPage.SelectingDesiredDailyBudgetCapRadioButton(3);
            ordersPage.ClickOnProductTemplateSaveButton();
            Thread.sleep(1000);
            //------------------------Adding Creative----------------------
            ordersPage.SelectingDesiredOptionFromCreativeTreeMenu(1);
            ordersPage.ClickOnCreativeCopyAdField();
            Thread.sleep(1000);
            ordersPage.EnterDataInCreativeCopyAdSearchField("PT level creative 3");
            Thread.sleep(1000);
            ordersPage.SelectingDesiredCreativeAdCard(1);
            ordersPage.SelectingDesiredCopyButtonFromCreativeCopyAd(1);
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("100");   //commented for staging-2
            ordersPage.ClickOnCopyAdButton();
            if (!ordersPage.IsCopyAdSuccessPopupDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - On clicking copy ad the ad is not copied in creative");
                softAssert.fail("On clicking copy ad the ad is not copied in creative");
            }
            ordersPage.ClickOnPopupCloseButton();
//                ordersPage.ClickOnDailyBudgetEditIcon(1);      //commented for staging-2
//                ordersPage.EnterDataInBudgetSplit("100");
//                ordersPage.ClickOnDailyBudgetEditIcon(2);
//                ordersPage.EnterDataInBudgetSplit("50");
            ordersPage.ClickOnCreativeSaveButton();
            //--------------------- Adding  Display Ad Creative ------------------------------
            Thread.sleep(1000);
            ordersPage.SelectingDesiredOptionFromCreativeTreeMenu(4);
            ordersPage.ClickOnCreativeCopyAdField();
            Thread.sleep(1000);
            ordersPage.EnterDataInCreativeCopyAdSearchField("Testing QA Display Ads Creative");
            Thread.sleep(1000);
            ordersPage.SelectingDesiredCreativeAdCard(1);
            ordersPage.SelectingDesiredCopyButtonFromCreativeCopyAd(1);
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("100");   //commented for staging-2
            ordersPage.ClickOnCopyAdButton();
            if (!ordersPage.IsCopyAdSuccessPopupDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - On clicking copy ad the ad is not copied in creative");
                softAssert.fail("On clicking copy ad the ad is not copied in creative");
            }
            ordersPage.ClickOnPopupCloseButton();
//                ordersPage.ClickOnDailyBudgetEditIcon(1);      //commented for staging-2
//                ordersPage.EnterDataInBudgetSplit("100");
//                ordersPage.ClickOnDailyBudgetEditIcon(2);
//                ordersPage.EnterDataInBudgetSplit("50");
            ordersPage.ClickOnCreativeSaveButton();
            //Review Order
            ordersPage.ClickOnOrdersTemplateButton();
            ordersPage.ClickOnReviewOrdersButton();
            ordersPage.ClickOnReviewOrdersViewButton();
            ordersPage.EnterDataInViewOrderSearchField(ordersPage.ApprovedOrderName);
            Thread.sleep(2000);
            ordersPage.ClickingOnViewOrderSearchResult();
            ordersPage.ClickOnGoToOrdersButton();
            ordersPage.ClickOnBackButton();
            ordersPage.ClickOnOrdersTemplateButton();
            ordersPage.ClickOnReviewOrdersButton();
            ordersPage.ClickOnReviewOrdersViewButton();
            ordersPage.EnterDataInViewOrderSearchField(ordersPage.ApprovedOrderName);
            Thread.sleep(2000);
            ordersPage.ClickingOnViewOrderSearchResult();
            String validationMessage = String.valueOf(ordersPage.ValidatingTranscodeConditionsAndApproving());
            if (validationMessage.contains("Assertion Failed")) {
                softAssert.fail(validationMessage);
            }
            if (ordersPage.Approved) {
                ordersPage.ClickOnApproveAndNextButton();
                ordersPage.ClickOnYesButtonToConfirm();
                if (!ordersPage.ValidateOrderApprovedSuccessPopUp()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Order Approved Success Pop-Up Not Displayed");
                    softAssert.fail("Order Approved Success Pop-Up was not displayed.");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ClickOnOrdersTemplateButton();
                ordersPage.ClickOnVideoCreativeLibrary();
                ordersPage.ClickOnSelectAdAccountField();
                ordersPage.EnterDataInAdAccountSearchField("AD_ACCOUNT_DEV");
                ordersPage.SelectAdAccountDropDown(1);  // Selects the first option from the ad account dropdown
                Thread.sleep(2000);
                ordersPage.EnterSearchTermInVideoCreativeLibrarySearchField(ordersPage.TagName);
                ordersPage.ClickOnCreativeApprovedStatusIcon();
                Thread.sleep(1000);
                if (!ordersPage.ValidatingCreativeVideoApprovedByWhichOrder()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Video is reviewed in " + ordersPage.OrderName + " but showing reviewed in " + ordersPage.ReviewedOrderName);
                    softAssert.fail("Video is reviewed in" + ordersPage.OrderName + "but showing" + ordersPage.ReviewedOrderName);
                }
            }
            if (ordersPage.Rejected) {
                ordersPage.ClickOnRejectButton();
                ordersPage.CommentingAndRejectingOrder();
                ordersPage.ClickOnYesButtonToConfirm();
                if (!ordersPage.ValidateCommentReviewSuccessPopUp()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Comment Review Success Pop-Up Not Displayed");
                    softAssert.fail("Comment Review Success Pop-Up was not displayed.");
                }
            }
            ordersPage.ClickOnOrdersTemplateButton();
            Thread.sleep(1000);
            ordersPage.ClickOnVideoCreativeLibrary();
            Thread.sleep(3000);
            ordersPage.ClickOnSelectAdAccountField();
            ordersPage.EnterDataInAdAccountSearchField("AD_ACCOUNT_DEV");
            ordersPage.SelectAdAccountDropDown(1);
            ordersPage.EnterSearchTermInVideoCreativeLibrarySearchField(ordersPage.TagName2);
            Thread.sleep(2000);
            ordersPage.ClickOnVideoPreviewSelector();
            ordersPage.ClickOnMarkAsReviewedButton();
            ordersPage.ClickOnYesButtonToConfirm();
            ordersPage.ClickOnPopupCloseButton();
            if (!ordersPage.IsCreativeApproveStatusIconDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative Approve Status Icon is not displayed when video is uploaded by admin");
                softAssert.fail("Creative Approve Status Icon is not displayed when video is uploaded by admin");
            }
            ordersPage.ClickOnCreativeApprovedStatusIcon();
            ordersPage.ClickOnOrdersTemplateButton();
            ordersPage.ClickOnAllOrdersButton();
            ordersPage.EnterDataInOrdersTableSearchField("QATestingSJeZYj5OdP");
            Thread.sleep(1000);
            ordersPage.ClickOnMenuButton();
            ordersPage.ClickOnEditButton();
            ordersPage.ClickOnCreativeCardContainer();
            ordersPage.ClickOnAddNewCreativeAddButton();
            ordersPage.SelectingCreativeDetailsChooseFromLibraryButton(1);
            ordersPage.EnterSearchTermInVideoCreativeLibrarySearchField(ordersPage.TagName2);
            if (!ordersPage.ValidatingCreativeVideoApprovedByWhichUser()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative Video is Approved By " + ordersPage.VideoApprovedUser + " But Shows different user name");
                softAssert.fail("Creative Video is Approved By " + ordersPage.VideoApprovedUser + " But Shows different user name");
            }
            ordersPage.ClickCrossButtonLevel2();
            ordersPage.ClickCrossButtonLevel1();

            ordersPage.ClickOnOrdersTemplateButton();
            ordersPage.ClickOnImageCreativeLibrary();
            ordersPage.EnterDataInImageCreativeLibrarySearchField(ordersPage.ImageTagName);
            Thread.sleep(1500);
            ordersPage.ClickOnImagePreviewSelector();
            if (!ordersPage.IsImageCreativeApproveStatusIconDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Image Creative Approve Status Icon is not displayed");
                softAssert.fail("Image Creative Approve Status Icon is not displayed ");
            }
//-----------------MidFlight---------------------------------
            RedirectToDev();
            ordersPage.ClickOnDevOrdersButton();
            ordersPage.ClickOnSellerSelectAdAccountField();
            ordersPage.ClickOnSelectAdAccountSearchIcon();
            ordersPage.EnterDataInSellerAdAccountSearchField("AD_ACCOUNT_DEV");
            ordersPage.SelectAdAccountDropDown(1);
            ordersPage.EnterDataInOrdersTableSearchField(ordersPage.ApprovedOrderName);
            Thread.sleep(2000);
            if (!ordersPage.IsDevOrdersTableResultsDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Dev Orders Table Results are not displayed");
                softAssert.fail("Dev Orders Table Results are not displayed");
            }
            ordersPage.ClickOnDevOrdersTableResults();
            ordersPage.ClickOnProductTemplateCard();
            Thread.sleep(1500);
            ordersPage.EnterDataInOrderCostField("40000");
            ordersPage.EnterDataInPackageTotalCostField(1, "10000");
            ordersPage.EnterDataInPackageTotalCostField(2, "10000");
            ordersPage.EnterDataInPackageTotalCostField(3, "10000");
            ordersPage.EnterDataInPackageTotalCostField(4, "10000");
            ordersPage.ClickOnProductTemplateSaveButton();
            ordersPage.ClickOnCreativeCopyAdField();
            Thread.sleep(1000);
            ordersPage.EnterDataInCreativeCopyAdSearchField("PT level creative 3");
            Thread.sleep(1000);
            ordersPage.SelectingDesiredCreativeAdCard(1);
            ordersPage.SelectingDesiredCopyButtonFromCreativeCopyAd(1);
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("100");   //commented for staging-2
            ordersPage.ClickOnCopyAdButton();
            if (!ordersPage.IsCopyAdSuccessPopupDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - On clicking copy ad the ad is not copied in creative");
                softAssert.fail("On clicking copy ad the ad is not copied in creative");
            }
            ordersPage.ClickOnPopupCloseButton();
            ordersPage.ClickOnCreativeCopyAdField();
            Thread.sleep(1000);
            ordersPage.EnterDataInCreativeCopyAdSearchField("Qa Testing");
            Thread.sleep(1000);
            ordersPage.SelectingDesiredCreativeAdCard(1);
            ordersPage.SelectingDesiredCopyButtonFromCreativeCopyAd(1);
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("100");   //commented for staging-2
            ordersPage.ClickOnCopyAdButton();
            if (!ordersPage.IsCopyAdSuccessPopupDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - On clicking copy ad the ad is not copied in creative");
                softAssert.fail("On clicking copy ad the ad is not copied in creative");
            }
            ordersPage.ClickOnPopupCloseButton();
            ordersPage.ClickOnCreativeDeleteIcon();
            ordersPage.ClickOnYesButtonToConfirm();
            ordersPage.ClickOnPopupCloseButton();
            Thread.sleep(2000);
            ordersPage.ClickOnMidFlightSubmitForReviewButton();
            ordersPage.ClickOnPopupCloseButton();
            Thread.sleep(2000);
            Redirect();
            ordersPage.ClickOnOrdersTemplateButton();
            ordersPage.ClickOnAllOrdersButton();
            ordersPage.EnterDataInOrdersTableSearchField(ordersPage.ApprovedOrderName);
            Thread.sleep(1000);
            if (!ordersPage.IsPulseOrdersTableResultsDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Pulse Orders Table Results are not displayed");
                softAssert.fail("Pulse Orders Table Results are not displayed");
            }
            ordersPage.ClickOnPulseOrdersTableResults();
            if (!ordersPage.IsPulseOrderCostValueUpdatedWithValueOfSellerOrderCost()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Pulse Order Cost Value is not updated as seller order cost.");
                softAssert.fail("Pulse Order Cost Value is not updated as seller order cost.");
            }

            if (!ordersPage.IsPulseProductTemplateValueUpdatedWithValueOfSellerProductCost()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Pulse Product Template Cost Value is not updated as seller product template cost.");
                softAssert.fail("Pulse Product Template Cost Value is not updated as seller product template cost.");
            }
            ordersPage.ClickOnReviewChangeButton();
            ordersPage.ClickOnRejectButton();
            ordersPage.CommentingAndRejectingOrder();
            ordersPage.ClickOnYesButtonToConfirm();
            if (!ordersPage.ValidateCommentReviewSuccessPopUp()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Comment Review Success Pop-Up Not Displayed");
                softAssert.fail("Comment Review Success Pop-Up was not displayed.");
            }
            RedirectToDev();
            ordersPage.ClickOnDevOrdersButton();
            ordersPage.ClickOnSellerSelectAdAccountField();
            ordersPage.ClickOnSelectAdAccountSearchIcon();
            ordersPage.EnterDataInSellerAdAccountSearchField("AD_ACCOUNT_DEV");
            ordersPage.SelectAdAccountDropDown(1);
            ordersPage.EnterDataInOrdersTableSearchField(ordersPage.ApprovedOrderName);
            Thread.sleep(2000);
            if (!ordersPage.IsDevOrdersTableResultsDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Dev Orders Table Results are not displayed");
                softAssert.fail("Dev Orders Table Results are not displayed");
            }
            if (!ordersPage.IsMidFlightStatusRejectedDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Mid-Flight Rejected Status is not displayed");
                softAssert.fail("Mid-Flight Rejected Status is not displayed");
            }
            ordersPage.ClickOnDevOrdersTableResults();
            ordersPage.ClickOnProductTemplateCard();
            Thread.sleep(1500);
            ordersPage.EnterDataInOrderCostField("40000");
            ordersPage.EnterDataInPackageTotalCostField(1, "10000");
            ordersPage.EnterDataInPackageTotalCostField(2, "10000");
            ordersPage.EnterDataInPackageTotalCostField(3, "10000");
            ordersPage.EnterDataInPackageTotalCostField(4, "10000");
            ordersPage.ClickOnProductTemplateSaveButton();
            Thread.sleep(2000);
            ordersPage.ClickOnMidFlightSubmitForReviewButton();
            ordersPage.ClickOnPopupCloseButton();
            Thread.sleep(2000);
            Redirect();
            ordersPage.ClickOnOrdersTemplateButton();
            ordersPage.ClickOnAllOrdersButton();
            ordersPage.EnterDataInOrdersTableSearchField(ordersPage.ApprovedOrderName);
            Thread.sleep(1000);
            if (!ordersPage.IsPulseOrdersTableResultsDisplayed()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Pulse Orders Table Results are not displayed");
                softAssert.fail("Pulse Orders Table Results are not displayed");
            }
            ordersPage.ClickOnPulseOrdersTableResults();
            if (!ordersPage.IsPulseOrderCostValueUpdatedWithValueOfSellerOrderCost()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Pulse Order Cost Value is not updated as seller order cost.");
                softAssert.fail("Pulse Order Cost Value is not updated as seller order cost.");
            }
            if (!ordersPage.IsPulseProductTemplateValueUpdatedWithValueOfSellerProductCost()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Pulse Product Template Cost Value is not updated as seller product template cost.");
                softAssert.fail("Pulse Product Template Cost Value is not updated as seller product template cost.");
            }
            ordersPage.ClickOnReviewChangeButton();
            ordersPage.ClickOnApproveAndNextButton();
            ordersPage.ClickOnYesButtonToConfirm();
            if (!ordersPage.ValidateOrderApprovedSuccessPopUp()) {
                ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Order Approved Success Pop-Up Not Displayed");
                softAssert.fail("Order Approved Success Pop-Up was not displayed.");
            }
            ordersPage.ClickOnPopupCloseButton();
        } catch (InterruptedException | AWTException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();
        }));

    }

    @Epic("TVING Dev - Seller Dashboard")
    @Feature("This flow belongs to All Order Flow")
    @Story("Order Creation - Negative Flow")
    @Test(description = "Test: Validating all fields in order creation", priority = 0)
    public void ValidateAllFieldsInOrderCreation() {
        ordersPage.RetryOnFailTvingSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                if (!Language.equals("en")) {
                    productTemplatePage.ChangeLanguage();
                }
                Thread.sleep(2000);
                ordersPage.ClickOnDevOrdersButton();
                ordersPage.ClickOnSellerSelectAdAccountField();
                ordersPage.ClickOnSelectAdAccountSearchIcon();

                ordersPage.EnterDataInSellerAdAccountSearchField("AD_ACCOUNT_DEV");
                ordersPage.SelectAdAccountDropDown(1);
                ordersPage.ClickOnCreateOrderButton();
                Thread.sleep(2000);
                ordersPage.AddNameInNameFieldValidation("   ");
                Thread.sleep(2000);
                ordersPage.ClickOnBasicInfoNextButton();
                if (!ordersPage.IsBasicInfoNameFieldEmptyErrorMessageDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info name field empty error message is not displayed");
                    softAssert.fail("Basic info name field empty error message is not displayed");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.AddNameInNameField200();
                if (!ordersPage.ValidateNameFieldAcceptingMoreThan200Characters()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - The name field accepted more than 200 characters");
                    softAssert.fail("The name field accepted more than 200 characters");
                }
                ordersPage.EnterDataInAllOrdersDescriptionField(1002);
                if (!ordersPage.ValidateAllOrdersDescriptionFieldAcceptingMoreThan1000Characters()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - The All Orders Description Field accepted more than 1000 characters");
                    softAssert.fail("The All Orders Description Field accepted more than 1000 characters");
                }
                ordersPage.EnterDataInAllOrdersDescriptionFieldForSpaces("   ");
                ordersPage.ClickOnBasicInfoNextButton();
                if (ordersPage.ValidateAllOrdersDescriptionFieldAcceptingOnlySpaces()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - The All Orders Description Field accepted only spaces");
                    softAssert.fail("The All Orders Description Field accepted only spaces");
                }
                ordersPage.ClickOnBillingMonthField();
                ordersPage.ClickOnBillingMonthNextYearNavButton("2020");
                ordersPage.SelectingDesiredMonthInBillingMonthField(2);
                ordersPage.ClickOnCreateOrderBrandField();
                ordersPage.EnterDataInDevBrandSearchField("JTBC");
                ordersPage.SelectingDesiredOptionFromDebBrandDropDown(1);
                ordersPage.ClickOnAdvertiserCategoryField();
//                ordersPage.EnterDataInIabCategorySearchField("Business");
                ordersPage.SelectingDesiredOptionFromIabCategoryDropDown(1);
                ordersPage.ClickOnSubscriptionCategoryField();
                ordersPage.SelectingDesiredOptionFromCustomCategoryDropDown(1);
                ordersPage.AddNameInNameFieldValidation("QATestingf6A7");
                Thread.sleep(1000);
                ordersPage.EnterDataInAllOrdersDescriptionFieldForSpaces("test");

                ordersPage.ClickOnBasicInfoNextButton();
                if (!ordersPage.IsOrderCreationDuplicateNameErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Order creation duplicate name error pop-up is not displayed");
                    softAssert.fail("Order creation duplicate name error pop-up is not displayed");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.AddNameInNameFieldDev();
                ordersPage.ClickOnBasicInfoNextButton();
                ordersPage.EnterDataInOrderCostField("Abcd%^$#@&");
                if (ordersPage.ValidateOrderCostFieldAcceptingCharacters()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Order cost field is accepting characters without any error message");
                    softAssert.fail("Order cost field is accepting characters without any error message");
                }
                ordersPage.EnterDataInOrderCostField("4.5");
                if (ordersPage.ValidateOrderCostFieldAcceptingFloatValue()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Order cost field is accepting float value without any error");
                    softAssert.fail("Order cost field is accepting float value without any error");
                }
                ordersPage.EnterDataInOrderCostField("-23");
                if (ordersPage.ValidateOrderCostFieldAcceptingNegativeValue()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Order cost field is accepting negative value without any error");
                    softAssert.fail("Order cost field is accepting negative value without any error");
                }
                ordersPage.EnterDataInOrderCostField("3");
                if (ordersPage.CheckIfValueBecomesNegativeAfterDownArrow()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Order cost field is accepting negative value with down arrow clicking");
                    softAssert.fail("Order cost field is accepting negative value with down arrow clicking");
                }
                ordersPage.EnterDataInOrderCostField("10000");
                ordersPage.ClickOnProductTemplateNextButton();
                ordersPage.ClickOnPopupCloseButton();
                if (!ordersPage.IsEmptyTemplateErrorMessageDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Soft Assertion - Empty template error message is not displayed");
                    softAssert.fail("Empty template error message is not displayed");
                }
                ordersPage.ClickOnCreateOrderAddTemplateButton();
                Thread.sleep(1500);
                ordersPage.ClickOnAddProductTemplatesButton();
                if (!ordersPage.ValidateAddProductTemplatesEmptyTemplateErrorPopUp()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Add Product Templates Empty Template error pop-up not displayed after clicking add with out any template");
                    softAssert.fail("Add Product Templates Empty Template error pop-up not displayed  after clicking add with out any template");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ClickOnProductTemplateAddFilterButton();
                ordersPage.ClickOnAddFilterTypeField();
                ordersPage.SelectingDesiredOptionFromAddFilter(4);
                ordersPage.ClickOnAddFilterConditionField();
                ordersPage.SelectingDesiredOptionFromAddFilter(3);
                ordersPage.ClickOnAddFilterDropdownField();
                ordersPage.SelectingDesiredOptionFromAddFilter(2);
                ordersPage.ClickOnAddFilterApplyButton();
                Thread.sleep(2000);
                if (!ordersPage.ValidateFilterResultsDisplayed()) {
                    Assert.fail("Filter results are not displayed as expected");
                }
                Thread.sleep(2000);
                ordersPage.EnterDataInAddTemplateSearchField("%%%##");
                ordersPage.SelectingDesiredTemplateRadioButtonFromTable(2);
                ordersPage.ClickOnAddProductTemplatesButton();
//            ordersPage.ClickOnAddMoreProductTemplateButton();
//            ordersPage.SelectingDesiredTemplateRadioButtonFromTable(9);
//            ordersPage.ClickOnAddProductTemplatesButton();
                ordersPage.ClickStartDateFieldForDesiredTemplate(1);
                ordersPage.ClickOnYearField();
                ordersPage.SelectCurrentYearFromYearDropdown();
                ordersPage.ClickOnGenericMonthField();
                ordersPage.SelectCurrentMonthFromMonthDropDown();
                ordersPage.SelectCurrentDayFromDayRange();
//                ordersPage.SelectDesiredDayDayRange(13);
                ordersPage.SelectInvalidTime();
                ordersPage.ClickOnCalenderApplyButton();
                Thread.sleep(2000);
                ordersPage.ClickEndDateFieldForDesiredTemplate(1);
                ordersPage.ClickOnYearField();
                ordersPage.SelectCurrentYearFromYearDropdown();
                ordersPage.ClickOnGenericMonthField();
                ordersPage.SelectEndDateMonthFromMonthDropDown();
                ordersPage.SelectDesiredDayDayRange(29);
                ordersPage.ClickOnCalenderApplyButton();
                if (!ordersPage.IsInvalidTimeErrorMessageDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - You can choose schedule only after 30 Mins from now.' error message is not displayed");
                    softAssert.fail("Error message 'You can choose schedule only after 30 Mins from now.' is not displayed");
                }
                ordersPage.ClickStartDateFieldForDesiredTemplate(1);
                ordersPage.ClickOnYearField();
                ordersPage.SelectCurrentYearFromYearDropdown();
                ordersPage.ClickOnGenericMonthField();
                ordersPage.SelectCurrentMonthFromMonthDropDown();
                ordersPage.SelectDayBasedOnTimeAhead();
                ordersPage.SelectValidTime();
                ordersPage.ClickOnCalenderApplyButton();
                ordersPage.EnterDataInBonusRateField(1, "4.5");
                if (ordersPage.ValidateBonusRateFieldAcceptingFloatValue(1)) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Bonus rate field is accepting float value without any error");
                    softAssert.fail("Bonus rate field is accepting float value without any error");
                }
                ordersPage.EnterDataInBonusRateField(1, "Abcd%^$#@&");
                if (ordersPage.ValidateBonusRateFieldAcceptingCharacters(1)) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Bonus rate field is accepting characters without any error message");
                    softAssert.fail("Bonus rate field is accepting characters without any error message");
                }
                ordersPage.EnterDataInBonusRateField(1, "-23");
                if (!ordersPage.ValidateBonusRateFieldAcceptingNegativeValue(1)) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Bonus rate field is accepting negative value without any error");
                    softAssert.fail("Bonus rate field is accepting negative value without any error");
                }
                ordersPage.EnterDataInBonusRateField(1, "3");
                if (!ordersPage.CheckIfBonusRateValueBecomesNegativeAfterDownArrow(1)) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Bonus rate field is accepting negative value with down arrow clicking");
                    softAssert.fail("Bonus rate field is accepting negative value with down arrow clicking");
                }
                ordersPage.EnterDataInBonusRateField(1, "0");
                ordersPage.EnterDataInPackageTotalCostField(1, "Abcd%^$#@&");
                if (ordersPage.ValidatePackageTotalCostFieldAcceptingCharacters(1, "Abcd%^$#@&")) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Package total cost field is accepting characters without any error");
                    softAssert.fail("Package total cost field is accepting characters without any error");
                }
                ordersPage.EnterDataInPackageTotalCostField(1, "4.5");
                if (ordersPage.ValidatePackageTotalCostFieldAcceptingFloatValue(1)) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Package total cost field is accepting float value without any error");
                    softAssert.fail("Package total cost field is accepting float value without any error");
                }
                ordersPage.EnterDataInPackageTotalCostField(1, "-23");
                if (ordersPage.ValidatePackageTotalCostFieldAcceptingNegativeValue(1)) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Package total cost field is accepting negative value without any error");
                    softAssert.fail("Package total cost field is accepting negative value without any error");
                }
                ordersPage.EnterDataInPackageTotalCostField(1, "4");
                if (ordersPage.CheckIfValueBecomesNegativeAfterMultipleDownArrows(1)) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Package total cost field is accepting negative value after multiple down arrow clicks");
                    softAssert.fail("Package total cost field is accepting negative value after multiple down arrow clicks");
                }
                ordersPage.EnterDataInPackageTotalCostField(1, "5000");
                if (!ordersPage.IsOrderCostPackageCostErrorMessageDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - The error message for mismatched order cost and package cost is not displayed");
                    softAssert.fail("The error message for mismatched order cost and package cost is not displayed");
                }
                ordersPage.EnterDataInPackageTotalCostField(1, "10000");
                ordersPage.ClickOnProductTemplateNextButton();
                ordersPage.ClickOnPreviewOrderButton();
                if (!ordersPage.ValidateEmptyCreativeErrorPopUp()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - 'Empty Creative' error pop-up is not displayed after clicking preview order without any creative");
                    softAssert.fail("'Empty Creative' error pop-up is not displayed after  preview order without any creative");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ClickOnAddCreativeButton();
                Thread.sleep(1500);
                ordersPage.ClickOnCreativeDetailsSaveButton();
                if (!ordersPage.ValidateCompleteAllRequiredFieldsErrorPopUp()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - 'Complete All Required Fields' error pop-up is not displayed after clicking save without entering any data");
                    softAssert.fail("'Complete All Required Fields' error pop-up is not displayed after clicking save without entering any data");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.EnterDataInCreativeDetailsNameField200();
                if (!ordersPage.ValidateCreativeADNameFieldAcceptingMoreThan200Characters()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad name field is accepting more than 200 characters");
                    softAssert.fail("Creative ad name field is accepting more than 200 characters");
                }
                ordersPage.EnterDataInCreativeDetailsNameField("      ");
                ordersPage.ClickOnCreativeDetailsSaveButton();
                if (!ordersPage.ValidateCreativeDetailsNameFieldAcceptingOnlySpaces()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad name field is accepting only spaces without any error message");
                    softAssert.fail("Creative ad name field is accepting only spaces without any error message");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.EnterDataInCreativeDetailsNameField("Qa Testing");

                ordersPage.EnterDataInCreativeDetailsDescriptionField(1001);
                if (ordersPage.ValidateCreativeDetailsDescriptionFieldAcceptingMoreThan1000Characters()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative details description field is accepting more than 1000 characters");
                    softAssert.fail("Creative details description field is accepting more than 1000 characters");
                }

                ordersPage.EnterDataInCreativeDetailsDescriptionFieldSpaces("   ");
                ordersPage.ClickOnCreativeDetailsSaveButton();
                if (!ordersPage.ValidateCreativeDetailsDescriptionFieldAcceptingOnlySpaces()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative details description field is accepting only spaces without any error message");
                    softAssert.fail("Creative details description field is accepting only spaces without any error message");
                }
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("Abcd%^$#@&");   //commented for staging-2
//                if (ordersPage.ValidateCreativeDetailsBudgetSplitFieldAcceptingCharacters()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative details budget split field is accepting characters without any error message");
//                    softAssert.fail("Creative details budget split field is accepting characters without any error message");
//                }
//
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("4.5");
//                ordersPage.ClickOnCreativeDetailsSaveButton();
//                if (ordersPage.ValidateCreativeDetailsBudgetSplitFieldAcceptingFloatValue()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative details budget split field is accepting float value without any error");
//                    softAssert.fail("Creative details budget split field is accepting float value without any error");
//                }
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("-23");
//                if (ordersPage.ValidateCreativeDetailsBudgetSplitFieldAcceptingNegativeValue()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative details budget split field is accepting negative value without any error");
//                    softAssert.fail("Creative details budget split field is accepting negative value without any error");
//                }
//
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("3");
//                if (ordersPage.CheckIfCreativeDetailsBudgetSplitValueBecomesNegativeAfterDownArrow()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative details budget split field is accepting negative value with down arrow clicking");
//                    softAssert.fail("Creative details budget split field is accepting negative value with down arrow clicking");
//                }
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("0");
//                ordersPage.ClickOnCreativeDetailsSaveButton();
//                if (!ordersPage.ValidateBudgetSplitMinimumErrorMessage()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Budget split minimum error message is not displayed when entering 0");
//                    softAssert.fail("Budget split minimum error message is not displayed when entering 0");
//                }
//                ordersPage.ClickOnPopupCloseButton();
//                ordersPage.EnterDataInCreativeDetailsBudgetSplitField("100");
                ordersPage.EnterDataInCreativeDetailsUrlField("xyzwqad");
                if (!ordersPage.ValidateCreativeDetailsUrlFieldInvalidUrlError()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid URL error message not displayed after clicking save");
                    softAssert.fail("Invalid URL error message not displayed after clicking save");
                }
                ordersPage.EnterDataInCreativeDetailsUrlField("          ");
                if (ordersPage.ValidateCreativeDetailsUrlFieldInvalidUrlError()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - URL field is accepting only spaces without displaying error message");
                    softAssert.fail("URL field is accepting only spaces without displaying error message");
                }
                ordersPage.EnterDataInCreativeDetailsUrlField("https://ww  w.exampl   e.com");
                if (ordersPage.ValidateCreativeDetailsUrlFieldWithSpacesInBetweenError("https://ww  w.exampl   e.com")) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion -  URL is accepting spaces in between");
                    softAssert.fail("URL is accepting spaces in between");
                }
                ordersPage.ClickOnCreativeDetailsSpecificUrlRadioButton();
                ordersPage.ClickOnYesButton();
                ordersPage.EnterDataInCreativeDetailsWebUrlField("example.com");
                ordersPage.ClickOnCreativeDetailsSaveButton();
                ordersPage.ClickOnPopupCloseButton();
                if (!ordersPage.ValidateWebUrlFieldWithInvalidURL()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid URL not showing error message after clicking save");
                    softAssert.fail("Invalid URL not showing error message after clicking save");
                }
                ordersPage.EnterDataInCreativeDetailsWebUrlField("https://ww  w.exampl   e.com");
                if (ordersPage.ValidateWebUrlFieldWithSpacesInBetweenError("https://ww  w.exampl   e.com")) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid URL with spaces in between not showing error message after clicking save");
                    softAssert.fail("Invalid URL with spaces in between not showing error message after clicking save");
                }
                ordersPage.EnterDataInCreativeDetailsIosUrlField("https:com");
                ordersPage.ClickOnCreativeDetailsSaveButton();
                if (!ordersPage.ValidateIosUrlFieldWithInvalidURL()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid iOS URL not showing error message after clicking save");
                    softAssert.fail("Invalid iOS URL not showing error message after clicking save");
                }
//            ordersPage.ClickOnPopupCloseButton();
                ordersPage.EnterDataInCreativeDetailsIosUrlField("https://ww  w.exampl   e.com");
                if (ordersPage.ValidateIosUrlFieldWithSpacesInBetweenError("https://ww  w.exampl   e.com")) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid iOS URL with spaces in between not showing error message after clicking save");
                    softAssert.fail("Invalid iOS URL with spaces in between not showing error message after clicking save");
                }
                ordersPage.EnterDataInCreativeDetailsAndroidUrlField("httle.com");
                ordersPage.ClickOnCreativeDetailsSaveButton();
                if (!ordersPage.ValidateAndroidUrlFieldWithInvalidURL()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid Android URL not showing error message after clicking save");
                    softAssert.fail("Invalid Android URL not showing error message after clicking save");
                }
//            ordersPage.ClickOnPopupCloseButton();
                ordersPage.EnterDataInCreativeDetailsAndroidUrlField("https://ww  w.exampl   e.com");
                if (ordersPage.ValidateAndroidUrlFieldWithSpacesInBetweenError("https://ww  w.exampl   e.com")) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid Android URL with spaces in between not showing error message after clicking save");
                    softAssert.fail("Invalid Android URL with spaces in between not showing error message after clicking save");
                }
                ordersPage.SelectingDesiredVideoUploadFromSystemButton("1920✕1080px_Video210Seconds.mp4");
                if (!ordersPage.IsVideoWithMoreThan200SecondsErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for video longer than 200 seconds is not displayed after uploading a more than 200 seconds video");
                    softAssert.fail("Error pop-up for video longer than 200 seconds is not displayed after uploading a more than 200 seconds video");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.SelectingDesiredVideoUploadFromSystemButton("1920✕1080px_WEBM.webm");
                if (!ordersPage.IsIncorrectVideoFileFormatErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for incorrect video type format is not displayed after uploading an incorrect type format video");
                    softAssert.fail("Error pop-up for incorrect video type format is not displayed after uploading an incorrect type format video");
                }
                ordersPage.ClickOnPopupCloseButton();

                ordersPage.SelectingDesiredVideoUploadFromSystemButton("Invalid_Dimensions.mp4");
                if (!ordersPage.IsIncorrectDimensionsErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for incorrect video dimensions is not displayed after uploading a video with invalid dimensions");
                    softAssert.fail("Error pop-up for incorrect video dimensions is not displayed after uploading a video with invalid dimensions");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.SelectingDesiredVideoUploadFromSystemButton("Invalid_File_With_Video_Extension.mp4");
                if (!ordersPage.IsInvalidFileErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for invalid file upload is not displayed after uploading an invalid file");
                    softAssert.fail("Error pop-up for invalid file upload is not displayed after uploading an invalid file");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.SelectingDesiredVideoUploadFromSystemButton("Image.jpg");
                if (!ordersPage.IsIncorrectFileFormatErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for incorrect file format is not displayed after uploading an image file in the video field");
                    softAssert.fail("Error pop-up for incorrect file format is not displayed after uploading an image file in the video field");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.SelectingDesiredVideoUploadFromSystemButton("1920✕1080px_Video.mp4");
                ordersPage.ClickOnCreativeLibraryAddCompanionImagesToggleButton();
                ordersPage.ClickOnCreativeDetailsSaveButton();
                if (!ordersPage.IsCompanionImagesEmptyErrorMessageDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Companion Images Empty Error Message is not displayed");
                    softAssert.fail("Companion Images Empty Error Message is not displayed");
                }
                Thread.sleep(2000);
                ordersPage.ImageOneMediaUploader("750X120_Image2MB.jpeg");
                if (!ordersPage.IsImageWithMoreThanMaximumSizeErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for image with more than maximum size is not displayed after uploading a large image file");
                    softAssert.fail("Error pop-up for image with more than maximum size is not displayed after uploading a large image file");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ImageOneMediaUploader("1920X1080_Image.jpg");
                if (!ordersPage.IsImageOneInvalidDimensionsErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for image with invalid dimensions is not displayed after uploading an image with invalid dimensions");
                    softAssert.fail("Error pop-up for image with invalid dimensions is not displayed after uploading an image with invalid dimensions");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ImageOneMediaUploader("SampleVideo-250X250-89KB.mp4");

                if (!ordersPage.IsImageIncorrectFormatErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for image with incorrect format is not displayed after uploading an video");
                    softAssert.fail("Error pop-up for image with incorrect format is not displayed after uploading an video");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ImageOneMediaUploader("Invalid_File_With_Image_Extension.jpg");

                if (!ordersPage.IsInvalidImageFileErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for invalid image file is not displayed after uploading an file with image extension");
                    softAssert.fail("Error pop-up for invalid image file is not displayed after uploading an file with image extension");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ImageOneMediaUploader("750X120_Image.png");

                ordersPage.ImageTwoMediaUploader("1920X1080_Image2MB.jpg");
                if (!ordersPage.IsImageWithMoreThanMaximumSizeErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for image with more than maximum size is not displayed after uploading a large image");
                    softAssert.fail("Error pop-up for image with more than maximum size is not displayed after uploading a large image");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ImageTwoMediaUploader("SampleVideo-250X250-89KB.mp4");
                if (!ordersPage.IsImageInvalidDimensionsErrorPopUpDisplayedForImageTwo()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for image with invalid dimensions is not displayed after uploading an image with invalid dimensions");
                    softAssert.fail("Error pop-up for image with invalid dimensions is not displayed after uploading an image with invalid dimensions");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ImageTwoMediaUploader("SampleVideo-250X250-89KB.mp4");
                if (!ordersPage.IsImageIncorrectFormatErrorPopUpDisplayedForImageTwo()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for image with incorrect format is not displayed after uploading an image with incorrect format");
                    softAssert.fail("Error pop-up for image with incorrect format is not displayed after uploading an image with incorrect format");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ImageTwoMediaUploader("Invalid_File_With_Image_Extension.jpg");
                if (!ordersPage.IsInvalidImageFileErrorPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error pop-up for invalid image file is not displayed after uploading an image file");
                    softAssert.fail("Error pop-up for invalid image file is not displayed after uploading an image file");
                }
                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ImageTwoMediaUploader("1920X160_Image.jpg");
                ordersPage.ClickOnAddTrackerButton();
                ordersPage.ClickOnCreativeDetailsSaveButton();
                if (!ordersPage.CheckIfImpressionTrackerEmptyFieldErrorIsDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Impression Tracker empty field error pop-up not displayed after clicking save");
                    softAssert.fail("Impression Tracker empty field error pop-up not displayed after clicking save");
                }
//              ordersPage.ClickOnPopupCloseButton();
                ordersPage.EnterDataInImpressionUrlField(1, "example12");
                if (!ordersPage.CheckIfImpressionTrackerFieldInvalidUrlErrorMessageIsDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Impression Tracker field invalid URL error message not displayed after entering invalid URL");
                    softAssert.fail("Impression Tracker field invalid URL error message not displayed after entering invalid URL");
                }
                ordersPage.EnterDataInImpressionUrlField(1, "exam p  l  e12");
                if (ordersPage.ValidateImpressionUrlFieldAcceptingSpacesInBetween("exam p  l  e12")) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Impression Tracker field is accepting spaces in between the text");
                    softAssert.fail("Impression Tracker field is accepting spaces in between the text");
                }
                ordersPage.EnterDataInImpressionUrlField(1, "example.com");
                ordersPage.ClickOnAddTrackerButton();
                ordersPage.SelectDesiredEventTrackerField(2);
                ordersPage.SelectingDesiredOptionFromTrackerField(2);
                ordersPage.ClickOnCreativeDetailsSaveButton();
                if (!ordersPage.ValidateClickTrackerEmptyUrlErrorMessage()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Click Tracker URL empty error message not displayed after leaving URL empty");
                    softAssert.fail("Click Tracker URL empty error message not displayed after leaving URL empty");
                }
//            ordersPage.ClickOnPopupCloseButton();
                Thread.sleep(1000);
                ordersPage.EnterDataInClickTrackerUrlField(1, "example12");
                if (!ordersPage.ValidateClickTrackerInvalidUrlErrorMessage()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Click Tracker URL invalid error message not displayed after entering an invalid URL");
                    softAssert.fail("Click Tracker URL invalid error message not displayed after entering an invalid URL");
                }
                ordersPage.EnterDataInClickTrackerUrlField(1, "exam p  l  e12");
                if (ordersPage.ValidateClickTrackerUrlFieldAcceptingSpacesInBetween("exam p  l  e12")) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Click Tracker URL field is accepting spaces in between the text");
                    softAssert.fail("Click Tracker URL field is accepting spaces in between the text");
                }
                ordersPage.EnterDataInClickTrackerUrlField(1, "example2.com");
                ordersPage.ClickOnCreativeDetailsSaveButton();
                if (!ordersPage.IsCreatedCreativeAdSuccessPopUpDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative Ad success pop up is not displayed after saving the ad");
                    softAssert.fail("Creative Ad success pop up is not displayed after saving the ad");
                }
                ordersPage.ClickOnPopupCloseButton();
//                ordersPage.ClickOnDailyBudgetEditIcon(1);   //commented for staging-2
//                ordersPage.EnterDataInBudgetSplit("3");
//                if (ordersPage.ValidateBudgetSplitFieldAcceptingNegativeValuesWithDownArrowMultipleTimes()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Budget split field is accepting negative values after pressing down arrow 4 times.");
//                    softAssert.fail("Budget split field is accepting negative values after pressing down arrow 4 times.");
//                }
//                ordersPage.EnterDataInBudgetSplit("abcd");
//                if (ordersPage.ValidateBudgetSplitFieldAcceptingAlphabets("abcd")) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Budget split field is accepting alphabetic characters without any error.");
//                    softAssert.fail("Budget split field is accepting alphabetic characters without any error.");
//                }
//                ordersPage.EnterDataInBudgetSplit("10");
//                ordersPage.ClickOnPreviewOrderButton();
//                if (!ordersPage.IsBudgetSplitSuccessPopUpDisplayed()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Budget Split success pop-up is not displayed after entering data and saving.");
//                    softAssert.fail("Budget Split success pop-up is not displayed after entering data and saving.");
//                }
//                ordersPage.ClickOnPopupCloseButton();
//                ordersPage.ClickOnPreviewOrderButton();
//                if (!ordersPage.IsBudgetSplitLessThan100PopUpDisplayed()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Budget Split must equal 100' not shown when entering and saving a value less than 100.");
//                    softAssert.fail("Budget Split must equal 100' not shown when entering and saving a value less than 100.");
//                }
//                ordersPage.ClickOnPopupCloseButton();
//                ordersPage.ClickOnDailyBudgetEditIcon(1);
//                ordersPage.EnterDataInBudgetSplit("100");
//                ordersPage.ClickOnPreviewOrderButton();
//                if (!ordersPage.IsBudgetSplitSuccessPopUpDisplayed()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Budget Split success pop-up is not displayed after entering data and saving.");
//                    softAssert.fail("Budget Split success pop-up is not displayed after entering data and saving.");
//                }
//                ordersPage.ClickOnPopupCloseButton();
                ordersPage.ClickOnPreviewOrderButton();
                ordersPage.ClickOnSubmitForReviewButton();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
            softAssert.assertAll();
        }));
    }
}
