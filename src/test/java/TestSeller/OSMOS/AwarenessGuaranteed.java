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

public class AwarenessGuaranteed extends BaseTest {
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
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Starting @Test: " + result.getMethod().getMethodName());
    }

    @AfterClass
    public void TearDown() {
        getDriver().quit();
    }

    @Epic("Seller Dashboard")
    @Feature("Awareness Page")
    @Story("This flow belongs to Guaranteed Campaign Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create a successful guaranteed campaign cost per impressions flow", timeOut = 20000)
    public void CreateGuaranteedCampaignsCostPerImpressionsWithAllOptionalFeatures() {
        performancePage.RetryOnFailOSMOSSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                awarenessPage.ClickingOnAwarenessDashBoard();
                awarenessPage.ClickOnCreateCampaignButton();
                awarenessPage.ClickingOnGuaranteedCampaignsImpressions();
                performancePage.ClickingNextStepButton();
                String DefaultCampaignName = awarenessPage.RenameCampaignName();
                awarenessPage.ClickingOnGuaranteedCampaignSelectPageTypeField();
                awarenessPage.EnteringDataInGuaranteedCampaignSelectPageTypeField("Home");
                awarenessPage.ClickingOnGuaranteedCampaignSelectPageTypeFieldDropDown();
                awarenessPage.EnteringDataInInventorySearchField("Text Ad Box");
                if (!awarenessPage.ValidatingInventorySearchResults()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory Setup search field results are not displayed");
                    softAssert.fail("Inventory Setup search field results are not displayed");
                }
                awarenessPage.ClickingOnGuaranteedCampaignSelectDateButton();
                if (awarenessPage.ClickingOnGuaranteedCampaignsMonthNextNavigator(awarenessPage.ReturnNextMonth(0))) {
                    Assert.fail("Only two months ahead can be selected");
                }
                awarenessPage.ClickingOnGuaranteedCampaignAvailableDateInSelectDate("12", 1);
                awarenessPage.ClickingOnGuaranteedCampaignAddInventoryButton();
                awarenessPage.ClickingOnSelectedInventoryDeleteButton();
                awarenessPage.ClickingOnSelectedInventoryDeleteConfirmationButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                if (!awarenessPage.ValidatingDeletedInventory()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Selected inventory is Not Deleted in inventory set up");
                    softAssert.fail("Selected inventory is Not Deleted in inventory set up");
                }
                Thread.sleep(1000);
                awarenessPage.ClickingOnGuaranteedCampaignSelectDateButton();
                if (awarenessPage.ClickingOnGuaranteedCampaignsMonthNextNavigator(awarenessPage.ReturnNextMonth(0))) {
                    Assert.fail("Only two months ahead can be selected");
                }
                awarenessPage.ClickingOnGuaranteedCampaignAvailableDateInSelectDate("12", 1);
                awarenessPage.EnteringDataInCampaignImpressionsField(500);
                awarenessPage.ClickingOnGuaranteedCampaignAddInventoryButton();
                awarenessPage.ClickingOnGuaranteedCampaignPayLaterButton();
                awarenessPage.ClickingOnGuaranteedCampaignPayLaterOkButton();
                awarenessPage.ClickingOnCampaignQAFullFledgeFormat(3);
                awarenessPage.ClickingCampaignCreativeNewAdButton();
                awarenessPage.AddingNameInAdNameField("QA Testing");
                awarenessPage.ClickingOnCampaignCreativeAdCarouselCreativeCount(1);
                awarenessPage.ClickingOnCampaignCreativeAdCarouselDeleteButton(1);
                if (!awarenessPage.ValidatingCarouselAlertPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - AdCarousel can not be deleted since minimum 2 items are required.");
                    softAssert.fail("AdCarousel can not be deleted since minimum 2 items are required.");
                }
                awarenessPage.ClickOnOkayButton();
                awarenessPage.ClickingOnCampaignCreativeAdCarouselTextField(0);
                awarenessPage.EnteringDataInCampaignCreativeAdCarouselTextField(0, "QA TESTING");
                awarenessPage.UploadingVideoInCampaignCreativeNewAd("SampleVideo-250X250-89KB.MP4.mp4");
                awarenessPage.UploadingRightImageInCampaignCreativeNewAd("CreativeAdLeftImage.jpg");
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
//              awarenessPage.ClickingOnCampaignCreativeAdCarouselDeleteYesButton();
                awarenessPage.EnteringDataInCampaignCreativesQAFullFledgeCreativeAdTextComponentField("Qa Testing");
                awarenessPage.EnteringDataInCampaignCreativesQAFullFledgeCreativeAdUrlField("https://www.example.com");
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductButton();
                awarenessPage.ClickAddProductButton();
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(2);
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(3);
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(4);
                awarenessPage.ClickAddButton();
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductAddButton();
                awarenessPage.ClickOnAddTracker();
                awarenessPage.ClickOnAddTracker();
                awarenessPage.ClickOnAddTracker();
                awarenessPage.EnterDcmClickURL("https://ad.doubleclick.net/");
                awarenessPage.EnterDcmScriptTag("<script src=\"https://ad.doubleclick.net\"></script>");
                awarenessPage.EnterDcmImageTag("<imgsrc=\"https://ad.doubleclick.net\"></img>");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingOnDuplicateIconInCreativeAd();
                awarenessPage.ClickingOnDuplicateIconCancelButtonInCreativeAd();
                awarenessPage.ClickingOnEditIconInCreativeAd();
                if (awarenessPage.ValidatingEditCreativeAd()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Ad edit Button is not working in creative Ad");
                    softAssert.fail("Ad edit Button is not working in creative Ad");
                }
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                awarenessPage.ClickingOnDuplicateIconInCreativeAd();
                awarenessPage.ClickingOnDuplicateIconConfirmationButtonInCreativeAd();
//                Thread.sleep(2000);
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                awarenessPage.ClickingOnPopUpCloseButton();
                if (awarenessPage.ValidatingDuplicatedCreativeAd()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Ad Duplicate Button is not working in creative AD");
                    softAssert.fail("Ad Duplicate Button is not working in creative AD");
                }
                Thread.sleep(2000);
                awarenessPage.ClickingOnDeleteIconInCreativeAd();
                awarenessPage.ClickingOnDeleteIconConfirmationButtonInCreativeAd();
                if (awarenessPage.ValidatingDeletedCreativeAd()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Ad Delete Button is not working in creative AD");
                    softAssert.fail("Ad Delete Button is not working in creative AD");
                }
                awarenessPage.ClickingOnGuaranteedCampaignCreativesSendForReviewButton();
                Thread.sleep(2000);
                awarenessPage.ClickOnPayFromWalletBalanceButton();
                if (!awarenessPage.ValidateSuccessfulPayment()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Payment failed");
                    Assert.fail("Payment failed");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickOnGuaranteedCampaignTabSwitch();
                dashboardPage.EnterTextInSearchCampaignField(DefaultCampaignName);
                Thread.sleep(3000);
                if (!awarenessPage.ValidateCreatedSearchOnlyCampaignName(DefaultCampaignName))
                    Assert.fail("Campaign Creation failed");
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("Seller Dashboard")
    @Feature("Awareness Page")
    @Story("This flow belongs to Guaranteed Campaign Creation")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Validating all features in guaranteed campaign creation", timeOut = 20000)
    public void ValidateAllFeaturesInGuaranteedCampaignCreation() {
        performancePage.RetryOnFailOSMOSSeller(() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                awarenessPage.ClickingOnAwarenessDashBoard();
                awarenessPage.ClickOnCreateCampaignButton();
                awarenessPage.ClickingOnGuaranteedCampaignsImpressions();
                performancePage.ClickingNextStepButton();
                Thread.sleep(2000);
                String DefaultCampaignName = awarenessPage.RenameCampaignName();
                awarenessPage.ClickGuaranteedNextButton();
                if (!awarenessPage.ValidatingGuaranteedCampaignSelectPageTypePopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - With out selecting inventory guaranteed campaign creation is going to next step");
                    softAssert.fail("With out selecting inventory guaranteed campaign creation is going to next step");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                if (!awarenessPage.ClickOnCreativesWithoutSelectingInventory()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - creatives should not be clickable in inventory setup without selecting page");
                    softAssert.fail("creatives should not be clickable in inventory setup without selecting page");
                }
                awarenessPage.ClickingOnGuaranteedCampaignSelectPageTypeField();
                awarenessPage.EnteringDataInGuaranteedCampaignSelectPageTypeField("Home");
                awarenessPage.ClickingOnGuaranteedCampaignSelectPageTypeFieldDropDown();
                awarenessPage.ClickingOnGuaranteedCampaignSelectDateButton();
                if (awarenessPage.ClickingOnGuaranteedCampaignsMonthNextNavigator(awarenessPage.ReturnNextMonth(0))) {
                    Assert.fail("Only two months ahead can be selected");
                }
                Thread.sleep(2000);
                awarenessPage.ClickingOnGuaranteedCampaignAddInventoryButton();
                if (!awarenessPage.ValidatingGuaranteedCampaignSelectDateErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Without selecting a date campaign is creating in inventory setup select dates step");
                    softAssert.fail("Without selecting a date campaign is creating in inventory setup select dates step");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(1500);
                awarenessPage.ClickingOnGuaranteedCampaignAvailableDateInSelectDate("12", 1);
                awarenessPage.ClickingCampaignImpressionsField();
                awarenessPage.EnteringDataInCampaignImpressionsField(0);
                Thread.sleep(1500);
                awarenessPage.ClickingOnGuaranteedCampaignAddInventoryButton();
                if (!awarenessPage.ValidatingGuaranteedCampaignSelectDateErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory setup  Impression Field is Accepting 0 Value");
                    softAssert.fail("Inventory setup  Impression Field is Accepting 0 Value");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingOnGuaranteedCampaignAvailableDateInSelectDate("12", 1);
                awarenessPage.EnteringDataInCampaignImpressionsField(500);
                awarenessPage.ClickingOnGuaranteedCampaignAddInventoryButton();
                awarenessPage.ClickingOnGuaranteedCampaignPayLaterButton();
                awarenessPage.ClickingOnGuaranteedCampaignPayLaterOkButton();
                awarenessPage.ClickingOnCampaignQAFullFledgeFormat(3);
                Thread.sleep(2000);
                awarenessPage.ClickingOnGuaranteedCampaignCreativesSendForReviewButton();
                Thread.sleep(800);
                awarenessPage.ClickingOnGuaranteedCampaignCreativesSendForReviewButton();
                if (!awarenessPage.ClickingSendForReviewWithoutSelectingCreatives()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Empty creative ad is submitting for review ");
                    softAssert.fail("Empty creative ad is going for review ");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.ClickingCampaignCreativeNewAdButton();
                awarenessPage.AddingNameInAdNameField("       ");
                if (!awarenessPage.ValidatingCreativeAdAdNameFieldIsAcceptingSpaces()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad name field is accepting input as spaces");
                    softAssert.fail("Creative ad name field is accepting input as spaces");
                }
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                awarenessPage.AddingNameInAdNameField("Anticonstitutionnellementkajabcdefgpo");
                if (!awarenessPage.ValidatingCreativeAdAdNameFieldIsAcceptingMoreThenMaximumLength()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad name field  is Accepting More Than 35 Characters");
                    softAssert.fail("Creative ad name field  is Accepting More Than 35 Characters");
                }
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                awarenessPage.AddingNameInAdNameField("QA Testing");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithoutUploadingImage()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Empty image error message is not displayed in creative ad");
                    softAssert.fail("Empty image error message is not displayed in creative ad");
                }
                awarenessPage.ClickUploadButtonFromCreativeLibrary(1);
                awarenessPage.ClickingCampaignCreativeAdMediaLibraryFilterButton();
                awarenessPage.ClickingOnGuaranteedCampaignMediaLibraryFilterOptions(2);
                awarenessPage.ClickingOnGuaranteedCampaignMediaLibraryTypeOptions(2);
                Thread.sleep(1000);
                awarenessPage.ClickingCampaignCreativeAdMediaLibraryApplyButton();
                Thread.sleep(1500);
                awarenessPage.SelectingImageFromMediaLibrary(1);
                awarenessPage.ClickingOnChooseButtonInMediaLibrary();
                if (!awarenessPage.ValidatingGuaranteedCampaignMediaLibraryErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - image is Accepting in creative ad video field");
                    softAssert.fail("Image is Accepting in creative ad video field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickCreativeAdMediaLibraryCloseButton();
                awarenessPage.ClickUploadButtonFromCreativeLibrary(2);
                awarenessPage.SelectingImageFromMediaLibrary(1);
                awarenessPage.SelectingImageFromMediaLibrary(2);
                if (!awarenessPage.ValidatingGuaranteedCampaignMediaLibraryMediaCount()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Two medias are accepting in creative ad media library");
                    softAssert.fail("Two medias are accepting in creative ad media library");
                }
                awarenessPage.ClickCreativeAdMediaLibraryCloseButton();
                awarenessPage.ClickUploadButtonFromCreativeLibrary(2);
                awarenessPage.ClickingCampaignCreativeAdMediaLibraryFilterButton();
                awarenessPage.ClickingOnGuaranteedCampaignMediaLibraryFilterOptions(2);
                awarenessPage.ClickingOnGuaranteedCampaignMediaLibraryTypeOptions(3);
                Thread.sleep(1000);
                awarenessPage.ClickingCampaignCreativeAdMediaLibraryApplyButton();
                awarenessPage.SelectingVideoFromMediaLibrary(1);
                awarenessPage.ClickingOnChooseButtonInMediaLibrary();
                if (!awarenessPage.ValidatingGuaranteedCampaignMediaLibraryErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Video is Accepting in creative ad image field");
                    softAssert.fail("Video is Accepting in creative ad image field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickCreativeAdMediaLibraryCloseButton();
                Thread.sleep(3000);
                awarenessPage.UploadingVideoInCampaignCreativeNewAd("SampleVideo_250x250_37mb.mp4");
                if (!awarenessPage.ValidatingGuaranteedCampaignUMoreThenMaximumSizeVideoErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - More then 20 MB video size is accepting in creative ad video field");
                    softAssert.fail("More then 20 MB video size is accepting in creative ad video field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.UploadingVideoInCampaignCreativeNewAd("Invalid_File_With_Video_Extension.mp4");
                if (!awarenessPage.ValidatingGuaranteedCampaignInvalidFileWithVideoExtensionErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid File is Accepting in creative ad video field");
                    softAssert.fail("Invalid File is Accepting in creative ad video field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.UploadingVideoInCampaignCreativeNewAd("CreativeAdLeftImage.jpg");
                if (!awarenessPage.ValidatingGuaranteedCampaignInvalidVideoFormatErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Image is uploading in creative ad video field");
                    softAssert.fail("Image is uploading in creative ad video field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.UploadingRightImageInCampaignCreativeNewAd("300x250_4Mb.jpg");
                if (!awarenessPage.ValidatingGuaranteedCampaignInvalidImageDimensionsErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid image dimensions are accepting in creative ad image field");
                    softAssert.fail("Invalid image dimensions are accepting in creative ad image field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);

                awarenessPage.UploadingRightImageInCampaignCreativeNewAd("Invalid_File_With_Image_Extension.jpg");
                if (!awarenessPage.ValidatingGuaranteedCampaignInvalidFileWithImageExtensionErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid file is accepting in creative ad image field");
                    softAssert.fail("Invalid file is accepting in creative ad image field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.UploadingVideoInCampaignCreativeNewAd("SampleVideo_1920X1080.mp4");
                if (!awarenessPage.ValidatingGuaranteedCampaignInvalidVideoDimensionsErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid file is accepting in creative ad video field");
                    softAssert.fail("Invalid file is accepting in creative ad video field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.UploadingRightImageInCampaignCreativeNewAd("SampleVideo-250X250-89KB.MP4.mp4");
                if (!awarenessPage.ValidatingGuaranteedCampaignInvalidImageFormatErrorPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Video is Accepting in creative ad Image Field");
                    softAssert.fail("Video is Accepting in creative ad Image Field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.UploadingRightImageInCampaignCreativeNewAd("LessThen1Kb.jpg");
                if (!awarenessPage.UploadingImageOfLessThanMinSize()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Image size less than 1Kb is accepting in creative ad image field");
                    softAssert.fail("Image size less than 1Kb is accepting in creative ad image field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                awarenessPage.UploadingRightImageInCampaignCreativeNewAd("250X250_10Mb.jpeg");
                if (!awarenessPage.UploadingImageOfMoreThanMaxSize()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Image size more than 10MB is accepting in creative ad image field");
                    softAssert.fail("Image size more than 10MB is accepting in creative ad image field");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                Thread.sleep(3000);
                awarenessPage.UploadingVideoInCampaignCreativeNewAd("SampleVideo-250X250-89KB.MP4.mp4");
                awarenessPage.UploadingRightImageInCampaignCreativeNewAd("CreativeAdLeftImage.jpg");
                awarenessPage.ClickingOnCampaignCreativeAdCarouselTextField(0);
                awarenessPage.EnteringDataInCampaignCreativeAdCarouselTextField(0, "    ");
                if (!awarenessPage.ValidatingCreativeAdCarouselFieldIsAcceptingSpaces(0)) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad carousel field is accepting spaces");
                    softAssert.fail("Creative ad carousel field is accepting spaces");
                }
                awarenessPage.EnteringDataInCampaignCreativeAdCarouselTextField(0, "FORMALDEHYDETETRAMETHYLAMIDOFLUORIMUM");
                if (!awarenessPage.ValidatingCreativeAdCarouselFieldIsAcceptingMoreThenMaximumLength(0)) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad carousel field is accepting more than 35 characters");
                    softAssert.fail("Creative ad carousel field is accepting more than 35 characters");
                }
                if (!awarenessPage.ValidatingCampaignCreativeAdCarouselAddButtonLimit()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - More then five Carousels are Creating in creative ad carousel");
                    softAssert.fail("More then five Carousels are Creating in creative ad carousel");
                }
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
                awarenessPage.EnteringInvalidInCampaignCreativesQAFullFledgeCreativeAdTextComponentField("QATestingvfgdnjemkfrndmkcnjfnrjhgerwef");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ValidatingTextComponentField()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad text component field is accepting more than 35 characters");
                    softAssert.fail("Creative ad text component field is accepting more than 35 characters");
                }
                awarenessPage.EnteringInvalidInCampaignCreativesQAFullFledgeCreativeAdTextComponentField("                               ");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.EnteringSpacesInTextComponentField()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad text component field is accepting only spaces as input");
                    softAssert.fail("Creative ad text component field is accepting only spaces as input");
                }
                awarenessPage.EnteringDataInCampaignCreativesQAFullFledgeCreativeAdTextComponentField("Qa Testing");
                awarenessPage.EnteringDataInCampaignCreativesQAFullFledgeCreativeAdUrlField("xyzwqad");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithInvalidURLInQAFullFledgeCreative()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad invalid url not displaying after clicking save");
                    softAssert.fail("Creative ad invalid url not displaying after clicking save");
                }
                awarenessPage.EnteringDataInCampaignCreativesQAFullFledgeCreativeAdUrlField("          ");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithInvalidURLInQAFullFledgeCreative()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad  url field is accepting only spaces");
                    softAssert.fail("Creative ad  url field is accepting only spaces");
                }
                awarenessPage.EnteringDataInCampaignCreativesQAFullFledgeCreativeAdUrlField("https://ww  w.exampl   e.com");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithInvalidURLWithSpacesInBetweenInQAFullFledgeCreative()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad  url field is accepting invalid url after clicking save");
                    softAssert.fail("Creative ad  url field is accepting invalid url after clicking save");
                }
                awarenessPage.EnteringDataInCampaignCreativesQAFullFledgeCreativeAdUrlField("");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithEmptyURLInQAFullFledgeCreative()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad  url field is accepting empty url after clicking save");
                    softAssert.fail("Creative ad  url field is accepting empty url after clicking save");
                }
                awarenessPage.EnteringDataInCampaignCreativesQAFullFledgeCreativeAdUrlField("https://www.example.com");
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductButton();
                Thread.sleep(2000);
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductAddButton();
                Thread.sleep(800);
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductAddButton();
                if (!awarenessPage.ValidateErrorMessageForNotAddingMinimumProducts()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Minimum 2 products should be added in creative ad products");
                    softAssert.fail("Minimum 2 products should be added in creative ad products");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickAddProductButton();
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(2);
                awarenessPage.ClickAddButton();
                Thread.sleep(2000);
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductAddButton();
                if (!awarenessPage.ValidateErrorMessageForNotAddingMinimumProducts()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Minimum 2 products should be added in creative ad products");
                    softAssert.fail("Minimum 2 products should  be added in creative ad products");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickAddProductButton();
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(3);
                awarenessPage.ClickAddButton();
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductAddButton();
                if (!awarenessPage.AddingMoreThanMaxProducts()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Maximum 5 products should be added in creative ad products");
                    softAssert.fail("Maximum 5 products should be added in creative ad products");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(1);
                Thread.sleep(2000);
                awarenessPage.ClickCreativeAdProductRemoveButton();
                awarenessPage.ClickCreativeAdProductRemoveConfirmationButton();
                awarenessPage.ClickAddProductButton();
                Thread.sleep(2000);
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(7);
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(8);
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(11);
                awarenessPage.ClickAddButton();
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductAddButton();
                awarenessPage.ClickOnAddTracker();
                awarenessPage.ClickOnAddTracker();
                awarenessPage.ClickOnAddTracker();
                if (!awarenessPage.CheckingTheVisibilityOfAddTrackerOption()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - More than 3 trackers are created in creative ad");
                    softAssert.fail("More than 3 trackers are created in creative ad");
                }
                awarenessPage.EnterDcmClickURL("         ");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithSpacesURLField("         ")) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Dcm Url field in creative ad is accepting spaces after clicking save");
                    softAssert.fail("Dcm Url field in creative ad is accepting spaces after clicking save");
                }
                awarenessPage.EnterDcmClickURL("");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithEmptyURLField()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Dcm url field in creative ad is accepting empty value after clicking save");
                    softAssert.fail("Dcm url field in creative ad is accepting empty value after clicking save");
                }
                awarenessPage.EnterDcmClickURL("xyzzzz");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithInvalidURL()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid dcm url  error is not displayed in creative ad ");
                    softAssert.fail("Invalid dcm url  error is not displayed in creative ad ");
                }
                awarenessPage.EnterDcmScriptTag("                                  ");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ValidateScriptTagErrorMessage()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Script field in creative ad is accepting spaces after clicking save without any error message");
                    softAssert.fail("Script field in creative ad is accepting spaces after clicking save");
                }
                awarenessPage.EnterDcmScriptTag("<script></script>");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithInvalidScriptTag()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid script tag error is not displayed in creative ad ");
                    softAssert.fail("Invalid script tag error is not displayed in creative ad ");
                }
                awarenessPage.EnterDcmScriptTag("");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithEmptyScriptField()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Script field in creative ad is accepting empty value after clicking save");
                    softAssert.fail("Script field in creative ad is accepting empty value after clicking save");
                }
                awarenessPage.EnterDcmImageTag("                ");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ValidateDCMImageTagErrorMessage()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad image Tag Field accepts spaces as input without any error message");
                    softAssert.fail("Creative ad image Tag Field accepts spaces as input without any error message");
                }
                awarenessPage.EnterDcmImageTag("");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ValidateDCMImageTagErrorMessage()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative ad image Tag Field is being saved with empty value");
                    softAssert.fail("Creative ad image Tag Field is being saved with empty value");
                }
                awarenessPage.EnterDcmImageTag("<imgsrc></img>");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ClickingSaveWithInvalidImageTag()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid image tag error is not displayed in creative ad ");
                    softAssert.fail("Invalid image tag error is not displayed in creative ad ");
                }
                awarenessPage.EnterDcmClickURL("https://ad.doubleclick.net/");
                awarenessPage.EnterDcmScriptTag("<script src=\"https://ad.doubleclick.net\"></script>");
                awarenessPage.EnterDcmImageTag("<imgsrc=\"https://ad.doubleclick.net\"></img>");
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
                if (!awarenessPage.ValidateCreativeAdSuccessPopUp()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative Ad success save pop up is not displayed after filling required fields and clicking save");
                    softAssert.fail("Creative Ad success save pop up is not displayed after filling required fields and clicking save");
                }
                awarenessPage.ClickingOnPopUpCloseButton();
                awarenessPage.ClickingOnGuaranteedCampaignCreativesSendForReviewButton();
                awarenessPage.ClickOnPayFromWalletBalanceButton();
                if (!awarenessPage.ValidateSuccessfulPayment()) {
                    awarenessPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Payment failed");
                    Assert.fail("Payment failed");
                }
                awarenessPage.ClickOnGuaranteedCampaignTabSwitch();
                dashboardPage.EnterTextInSearchCampaignField(DefaultCampaignName);
                Thread.sleep(3000);
                if (!awarenessPage.ValidateCreatedSearchOnlyCampaignName(DefaultCampaignName))
                    Assert.fail("Campaign Creation failed");

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        });
    }

    @Epic("Seller Dashboard")
    @Feature("Awareness Page")
    @Story("This flow belongs to Guaranteed Campaign Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create a successful guaranteed campaign cost per Day flow", timeOut = 20000)
    public void CreateGuaranteedCampaignsCostPerDay() {
        performancePage.RetryOnFailOSMOSSeller((() ->
        {
            SoftAssert softAssert = new SoftAssert();
            try {
                awarenessPage.ClickingOnAwarenessDashBoard();
                awarenessPage.ClickOnCreateCampaignButton();
                awarenessPage.ClickingOnGuaranteedCampaignsDay();
                performancePage.ClickingNextStepButton();
//                String DefaultCampaignName = awarenessPage.RenameCampaignName();
                awarenessPage.ClickingOnGuaranteedCampaignSelectPageTypeField();
                awarenessPage.EnteringDataInGuaranteedCampaignSelectPageTypeField("Home");
                awarenessPage.ClickingOnGuaranteedCampaignSelectPageTypeFieldDropDown();
                awarenessPage.ClickingOnGuaranteedCampaignSelectDateButton();
                //validation needed if slots are available
                if (awarenessPage.ClickingOnGuaranteedCampaignsMonthNextNavigator(awarenessPage.ReturnNextMonth(0))) {
                    Assert.fail("Only two months ahead can be selected");
                }
                awarenessPage.ClickingOnGuaranteedCampaignAvailableDateInSelectDate("12", 1);
                awarenessPage.ClickingOnGuaranteedCampaignAddInventoryButton();
                awarenessPage.ClickingOnGuaranteedCampaignPayLaterButton();
                awarenessPage.ClickingOnGuaranteedCampaignPayLaterOkButton();
                awarenessPage.ClickingOnCampaignQAFullFledgeFormat(2);
                awarenessPage.ClickingCampaignCreativeNewAdButton();
                awarenessPage.AddingNameInAdNameField("QA Testing");
                awarenessPage.ClickingOnCampaignCreativeAdCarouselTextField(0);
                awarenessPage.EnteringDataInCampaignCreativeAdCarouselTextField(0, "QA TESTING");
                awarenessPage.UploadingVideoInCampaignCreativeNewAd("SampleVideo-250X250-89KB.MP4.mp4");
                awarenessPage.UploadingRightImageInCampaignCreativeNewAd("CreativeAdLeftImage.jpg");
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
                awarenessPage.ClickCheckboxesToSelectIndividualProducts(4);
                awarenessPage.ClickAddButton();
                awarenessPage.ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductAddButton();
                awarenessPage.ClickingOnCampaignCreativesNewAdSaveButton();
//                awarenessPage.ClickingOnGuaranteedCampaignCreativesSendForReviewButton();
//                awarenessPage.ClickOnPayFromWalletBalanceButton();
//                awarenessPage.ClickOnGuaranteedCampaignTabSwitch();
//                dashboardPage.EnterTextInSearchCampaignField(DefaultCampaignName);
//                Thread.sleep(3000);
//                if (!awarenessPage.ValidateCreatedSearchOnlyCampaignName(DefaultCampaignName))
//                    Assert.fail("Campaign Creation failed");
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));

    }
}