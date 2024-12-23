package TestPulse.OSMOS;

import PagesPulse.OSMOS.PageSetupPage;
import BaseClass.BaseTest;
import PagesPulse.OSMOS.AdFormatSetupPage;
import PagesPulse.OSMOS.InventorySetupPage;
import PagesPulse.OSMOS.Utility;

import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class AdInventoryManagement extends BaseTest {
    private PageSetupPage pageSetupPage;
    private AdFormatSetupPage adFormatSetupPage;
    private InventorySetupPage inventorySetupPage;
    private Utility utility;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrl);
        inventorySetupPage = new InventorySetupPage(getDriver());
        pageSetupPage = new PageSetupPage(getDriver());
        adFormatSetupPage = new AdFormatSetupPage(getDriver());
        utility = new Utility(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "1e2f2aff7100c4ad50b185a1738aafd3");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();

        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Started: " + this.getClass().getName());

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
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Finished: " + this.getClass().getName());

        getDriver().quit();
    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Page Set Up")
    @Story("Page Creation-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 0, description = "Test: Create new Page")
    public void CreateNewPage()  {
        utility.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                pageSetupPage.ClickOnControlCenterNavButton();
                pageSetupPage.ClickOnPageSetUp();
                pageSetupPage.ClickAddOrRemoveColumnsButton();
                pageSetupPage.optionalClickDeselectingSelectedMetrics(1);
                pageSetupPage.SelectingMetrics(1);
                pageSetupPage.ClickOnAddPageButton();
                pageSetupPage.EnterPageName("QA_TestingPage");
                pageSetupPage.EnterTagsField("QA_TestingPage");
                pageSetupPage.ClickEnterIcon();
                pageSetupPage.EnterDataToApiIdentifierField("QA_TestingPage");
                pageSetupPage.EnablingTargetingOptions(1);
                pageSetupPage.EnableProductCatalogOptions(1);
                pageSetupPage.EnableProductCatalogOptions(2);
                pageSetupPage.EnableProductCatalogOptions(3);
                pageSetupPage.EnableProductCatalogOptions(4);
                pageSetupPage.EnableProductCatalogOptions(5);
                pageSetupPage.EnableProductCatalogOptions(6);
                pageSetupPage.EnablingTargetingOptions(2);
                pageSetupPage.EnablingTargetingOptions(3);
                pageSetupPage.ClickPageCreateButton();
                pageSetupPage.ClickingOnPopUpCloseButton();
                if (!pageSetupPage.IsPageCreationSuccessPopUpDisplayed()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Page creation success pop-up is not displayed");
                    softAssert.fail("Page creation success pop-up is not displayed");
                }
                pageSetupPage.EnterDataInTableSearchField();
                Thread.sleep(2000);
                if (!pageSetupPage.ValidatingCreatedPage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Created page is not present in the table");
                    softAssert.fail("Created page is not present in the table");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Ad Format Set Up")
    @Story("Ad Format Creation-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1,description = "Test: Create new Ad Format")
    public void CreateNewAdFormat()   {
        utility.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                adFormatSetupPage.ClickOnControlCenterNavButton();
                adFormatSetupPage.ClickAdFormatSetupButton();
                adFormatSetupPage.ClickCustomAdSetup();
                adFormatSetupPage.ClickOnAddAdFormatButton();
                adFormatSetupPage.ClickAdTypeField();
                adFormatSetupPage.ClickImageInAdTypeDropDown(5);
                adFormatSetupPage.EnterDataInAdFormatNameField("");
                adFormatSetupPage.EnterDataInDescriptionField("Sample Description");
                adFormatSetupPage.EnterDataInIdentifierKeyField("Api_Key_", 4, "time");
                adFormatSetupPage.EnterDataInMaxWidthField("1024");
                adFormatSetupPage.EnterDataInMinWidthField("768");
                adFormatSetupPage.EnterDataInPreviewNameField("Preview Name");
                adFormatSetupPage.EnterDataInAdPreviewDescriptionField("Ad preview description content");
                adFormatSetupPage.ClickUploadPreviewImage();
                adFormatSetupPage.ClickCreativeLibraryImageSelector();
                adFormatSetupPage.ClickCreativeLibraryChooseButton();
                adFormatSetupPage.ClickOnPreviewAdPlusIcon();
                adFormatSetupPage.OptionalClickOnAdPreviewDeleteIcon(2);
                adFormatSetupPage.ClickOnYesButton();
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(1);
                adFormatSetupPage.EnterDataInVideoFieldName("Your Video Field Name");
                adFormatSetupPage.EnterDataInVideoDescription("Your Video Description");
                adFormatSetupPage.EnterDataInVideoAPIIdentifier("Your Video API Identifier");
                adFormatSetupPage.EnterDataInVideoWidth("10");
                adFormatSetupPage.EnterDataInVideoHeight("15");
                adFormatSetupPage.EnterDataInVideoMinSize("69");
                adFormatSetupPage.EnterDataInVideoMaxSize("2");
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(2);
                adFormatSetupPage.EnterDataInImageFieldName("Sample Image");
                adFormatSetupPage.EnterDataInImageDescription("This is a sample image description.");
                adFormatSetupPage.EnterDataInImageAPIIdentifier("ImageAPI123");
                adFormatSetupPage.EnterDataInImageWidth("1920");
                adFormatSetupPage.EnterDataInImageHeight("1080");
                adFormatSetupPage.EnterDataInImageMinSize("500KB");
                adFormatSetupPage.EnterDataInImageMaxSize("1000");
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(3);
                adFormatSetupPage.EnterDataInCarouselFieldName("Sample Carousel");
                adFormatSetupPage.EnterDataInCarouselDescription("This is a sample carousel description.");
                adFormatSetupPage.EnterDataInCarouselAPIIdentifier("CarouselAPI123");
                adFormatSetupPage.EnterDataInCarouselMinCount("1");
                adFormatSetupPage.EnterDataInCarouselMaxCount("10");
//        adFormatSetupPage.ClickOnAddCarouselElementButton();
//        adFormatSetupPage.SelectingAddElementDropDownOptions(3);
//        adFormatSetupPage.EnterDataInCarouselStaticApiIdentifierField("API-Identifier");
//        adFormatSetupPage.EnterDataInCarouselStaticValueField("StaticValue");
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(4);
                adFormatSetupPage.EnterDataInTextFieldName("Sample TextField");
                adFormatSetupPage.EnterDataInMaxCharactersSupported("100");
                adFormatSetupPage.EnterDataInTextDescription("This is a sample text description.");
                adFormatSetupPage.EnterDataInTextAPIIdentifier("TextAPI123");
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(5);
                adFormatSetupPage.EnterDataInStaticAPIIdentifier("StaticAPI123");
                adFormatSetupPage.EnterDataInStaticValue("StaticValue123");
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(6);
                adFormatSetupPage.EnterDataInUrlName("https://example.com");
                adFormatSetupPage.EnterDataInUrlAPIIdentifier("UrlAPI123");
                adFormatSetupPage.EnterDataInRestrictUrl("https://restricted.com");
                adFormatSetupPage.ClickEnterIcon();
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(7);
                adFormatSetupPage.EnterDataInCTAFieldName("ClickHereButton");
                adFormatSetupPage.EnterDataInCtaOptions("LearnMore");
                adFormatSetupPage.ClickEnterIcon();
                adFormatSetupPage.EnterDataInCtaOptions("GrabNow");
                adFormatSetupPage.ClickEnterIcon();
                adFormatSetupPage.EnterDataInCtaAPIIdentifier("CtaAPI123");
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(8);
                adFormatSetupPage.EnterDataInTrackerFieldName("TrackingCode123");
                adFormatSetupPage.ClickOnDCMClickCheckBox();
                adFormatSetupPage.ClickOnDCmIMpressionCheckBox();
                adFormatSetupPage.ClickOnDCMImpressionImageCheckBox();
                adFormatSetupPage.ClickAddElementsButton();
//                adFormatSetupPage.SelectingAddElementDropDownOptions(9);
//                adFormatSetupPage.EnterDataInLandingProductFieldName("SampleProductName");
//                adFormatSetupPage.EnterDataInLandingProductButtonName("SampleButtonName");
//                adFormatSetupPage.EnterDataInLandingProductMin("10");
//                adFormatSetupPage.EnterDataInLandingProductMax("30");
//                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(9);
                adFormatSetupPage.EnterDataInAdSchedulingFieldName("SampleAdScheduleName");
                adFormatSetupPage.ClickOnAdSchedulingDayWiseCheckBox();
                adFormatSetupPage.ClickOnAdSchedulingDateWise();
                adFormatSetupPage.OptionalClickAdFormatDeleteIcon(3);  // Clicks the first delete icon
                Thread.sleep(500);
                adFormatSetupPage.ClickOnYesButton();
                adFormatSetupPage.ClickOnAdFormatCreateButton();
                pageSetupPage.ClickingOnPopUpCloseButton();
                if (!adFormatSetupPage.ValidatingAdFormatCreationSuccessPopUpDisplayed()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Ad format creation success pop-up is not displayed");
                    softAssert.fail("Ad format creation success pop-up is not displayed");
                }
                adFormatSetupPage.EnterDataInTableSearchField(String.valueOf(adFormatSetupPage.AdFormatName));
                Thread.sleep(2000);
                if (!adFormatSetupPage.ValidatingCreatedAdFormat()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Created ad format is not present in the table");
                    softAssert.fail("Created ad format is not present in the table");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Inventory Set Up")
    @Story("Inventory Creation-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2,description = "Test: Create new CPM Inventory")
    public void CreateNewCPMInventory()   {
        utility.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                pageSetupPage.ClickOnControlCenterNavButton();
                inventorySetupPage.ClickOnInventorySetupButton();
                inventorySetupPage.ClickOnInventoryAddButton();
                inventorySetupPage.ClickOnAuctionCampaignButton();
                inventorySetupPage.EnterDataInInventoryNameField("QaTestingCPM", 5, "text");
                inventorySetupPage.EnterDataInInventoryDescriptionField("Sample Inventory Description");
                inventorySetupPage.EnterDataInApiIdentifierField("QaTesting", 5, "time");
                inventorySetupPage.EnterDataInInventoryPageField(String.valueOf(pageSetupPage.PageName));
                Thread.sleep(4000);
                if (!inventorySetupPage.ValidateCreatedPageIsAvailableInInventory()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Created page is not available in inventory");
                    Assert.fail("Created page is not available in inventory");
                }
                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(1);
//                inventorySetupPage.EnterDataInInventoryPositionField("First");
//                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(1);
                inventorySetupPage.EnterDataInInventoryAdFormatField(String.valueOf(adFormatSetupPage.AdFormatName));
                Thread.sleep(4000);

                if (!inventorySetupPage.ValidateCreatedAdFormatIsAvailableInInventory()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Created ad format is not available in inventory");
                    Assert.fail("Created ad format is not available in inventory");
                }
                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(1);
                inventorySetupPage.ClickOnProductCatalogTargetingCheckBox();
                inventorySetupPage.ClickOnGeoLocationTargetingCheckBox();
                inventorySetupPage.ClickOnAudienceTargetingCheckBox();
                inventorySetupPage.ClickOnKeywordTargetingCheckBox();
                inventorySetupPage.ClickOnDeviceTargetingCheckBox();
                inventorySetupPage.ClickOnCustomTargetingCheckBox();
                inventorySetupPage.ClickOnPersonasVisibilityToggleButton();
                inventorySetupPage.clickOnSilverAccountCheckBox();
                inventorySetupPage.clickOnGoldAccountCheckBox();
                inventorySetupPage.clickOnPlatinumAccountCheckBox();
                inventorySetupPage.clickOnBetaAccountCheckBox();
                inventorySetupPage.ClickOnCpmRadioButton();
                inventorySetupPage.EnterDataInInventoryMinimumCpmField("200");
                inventorySetupPage.EnterDataInInventoryDailyImpressionsField("5000");

                inventorySetupPage.EnterDataInPreviewNameField("Sample Preview Name");
                inventorySetupPage.EnterDataInPreviewDescriptionField("Sample Preview Description");
                inventorySetupPage.EnterDataInThumbnailNameField("Sample Thumbnail Name");
                inventorySetupPage.EnterDataInThumbnailDescriptionField("Sample Thumbnail Description");

                inventorySetupPage.EnterDataInAuctionInventoryTagsField("Sample Tag Data");
                adFormatSetupPage.ClickEnterIcon();
                inventorySetupPage.ClickOnInventoryCreateButton();
                Thread.sleep(2500);
                inventorySetupPage.EnterDataInTableSearchField(String.valueOf(inventorySetupPage.InventoryName));
                Thread.sleep(2000);
                if (!inventorySetupPage.ValidatingCreatedInventory()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Created inventory is not present in the table");
                    softAssert.fail("Created inventory is not present in the table");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Inventory Set Up")
    @Story("Inventory Creation-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3,description = "Test: Create new CPC Inventory")
    public void CreateNewCPCInventory()   {
        utility.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                pageSetupPage.ClickOnControlCenterNavButton();
                inventorySetupPage.ClickOnInventorySetupButton();
                inventorySetupPage.ClickOnInventoryAddButton();
                inventorySetupPage.ClickOnAuctionCampaignButton();
                inventorySetupPage.EnterDataInInventoryNameField("QaTestingCPC", 5, "text");
                inventorySetupPage.EnterDataInInventoryDescriptionField("Sample Inventory Description");
                inventorySetupPage.EnterDataInApiIdentifierField("QaTesting", 5, "time");
                inventorySetupPage.EnterDataInInventoryPageField(String.valueOf(pageSetupPage.PageName));
                if (!inventorySetupPage.ValidateCreatedPageIsAvailableInInventory()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Created page is not available in inventory");
                    Assert.fail("Created page is not available in inventory");
                }
                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(1);
//                inventorySetupPage.EnterDataInInventoryPositionField("First");
//                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(1);
                inventorySetupPage.EnterDataInInventoryAdFormatField(String.valueOf(adFormatSetupPage.AdFormatName));
                if (!inventorySetupPage.ValidateCreatedAdFormatIsAvailableInInventory()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Created ad format is not available in inventory");
                    Assert.fail("Created ad format is not available in inventory");
                }
                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(1);
                inventorySetupPage.ClickOnProductCatalogTargetingCheckBox();
                inventorySetupPage.ClickOnGeoLocationTargetingCheckBox();
                inventorySetupPage.ClickOnAudienceTargetingCheckBox();
                inventorySetupPage.ClickOnKeywordTargetingCheckBox();
                inventorySetupPage.ClickOnDeviceTargetingCheckBox();
                inventorySetupPage.ClickOnCustomTargetingCheckBox();
                inventorySetupPage.ClickOnPersonasVisibilityToggleButton();
                inventorySetupPage.clickOnSilverAccountCheckBox();
                inventorySetupPage.clickOnGoldAccountCheckBox();
                inventorySetupPage.clickOnPlatinumAccountCheckBox();
                inventorySetupPage.clickOnBetaAccountCheckBox();
                inventorySetupPage.ClickOnCpcRadioButton();
                inventorySetupPage.EnterDataInInventoryMinimumCpcField("100");
                inventorySetupPage.EnterDataInInventoryDailyImpressionsField("5000");

                inventorySetupPage.EnterDataInPreviewNameField("Sample Preview Name");
                inventorySetupPage.EnterDataInPreviewDescriptionField("Sample Preview Description");
                inventorySetupPage.EnterDataInThumbnailNameField("Sample Thumbnail Name");
                inventorySetupPage.EnterDataInThumbnailDescriptionField("Sample Thumbnail Description");

                inventorySetupPage.EnterDataInAuctionInventoryTagsField("Sample Tag Data");
                adFormatSetupPage.ClickEnterIcon();
                inventorySetupPage.ClickOnInventoryCreateButton();
                Thread.sleep(2500);
                inventorySetupPage.EnterDataInTableSearchField(String.valueOf(inventorySetupPage.InventoryName));
                Thread.sleep(2000);
                if (!inventorySetupPage.ValidatingCreatedInventory()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Created inventory is not present in the table");
                    softAssert.fail("Created inventory is not present in the table");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Inventory Set Up")
    @Story("Inventory Creation- Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 4,description = "Test: Validate all fields while creating  new Inventory")
    public void ValidateAllFieldsWhileCreatingInventory()   {
        utility.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                pageSetupPage.ClickOnControlCenterNavButton();
                inventorySetupPage.ClickOnInventorySetupButton();
                inventorySetupPage.ClickOnInventoryAddButton();
                inventorySetupPage.ClickOnAuctionCampaignButton();
                Thread.sleep(1500);
                inventorySetupPage.ClickOnCpcRadioButton();
                inventorySetupPage.ClickOnCpmRadioButton();
                inventorySetupPage.ClickOnInventoryCreateButton();
                utility.ClickOnPopUpCloseButton();
                if (!inventorySetupPage.ValidateInventoryNameFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when inventory Name is empty");
                    softAssert.fail("No error message displayed when inventory Name is empty");
                }
                if (!inventorySetupPage.ValidateInventoryApiFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when inventory Api field is empty");
                    softAssert.fail("No error message displayed when inventory Api field is empty");
                }
                if (!inventorySetupPage.ValidateInventoryPositionFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when inventory position field is empty");
                    softAssert.fail("No error message displayed when inventory position field is empty");
                }
                if (!inventorySetupPage.ValidateInventoryAdFormatFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when inventory ad format field is empty");
                    softAssert.fail("No error message displayed when inventory ad format field is empty");
                }
                if (!inventorySetupPage.ValidateInventoryMinimumCPCFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when inventory minimum cpc field is empty");
                    softAssert.fail("No error message displayed when inventory minimum cpc field is empty");
                }
                if (!inventorySetupPage.ValidateInventoryMinimumCPMFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when inventory minimum cpm field is empty");
                    softAssert.fail("No error message displayed when inventory minimum cpm field is empty");
                }
                if (!inventorySetupPage.ValidateInventoryDailyImpressionsFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when inventory daily impressions field is empty");
                    softAssert.fail("No error message displayed when inventory daily impressions field is empty");
                }
                inventorySetupPage.EnterSpacesInInventoryNameField("       ");
                inventorySetupPage.ClickOnInventoryCreateButton();
                utility.ClickOnPopUpCloseButton();
                if (!inventorySetupPage.ValidateInventoryNameFieldAcceptsOnlySpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory Name field accepts only spaces as input.");
                    softAssert.fail("Inventory Name field accepts only spaces as input.");
                }
                Thread.sleep(1000);
                inventorySetupPage.EnterSpacesInApiIdentifierField("       ");
                inventorySetupPage.ClickOnInventoryCreateButton();
                if (!inventorySetupPage.ValidateInventoryApiFieldAcceptsOnlySpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory api field accepts only spaces as input.");
                    softAssert.fail("Inventory api field accepts only spaces as input.");
                }
                Thread.sleep(1000);
                utility.ClickOnPopUpCloseButton();
                inventorySetupPage.EnterDataInInventoryNameField("QaTesting", 5, "text");
                inventorySetupPage.EnterDataInInventoryDescriptionField("Sample Inventory Description");
                inventorySetupPage.EnterDataInApiIdentifierField("QaTestingCPCAndCPM", 5, "time");
                inventorySetupPage.EnterDataInInventoryPageField("QaTesting");
                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(1);
//                inventorySetupPage.EnterDataInInventoryPositionField("First");
//                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(1);
                inventorySetupPage.EnterDataInInventoryAdFormatField("QA Full Fledge");
                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(1);
                inventorySetupPage.ClickOnProductCatalogTargetingCheckBox();
                inventorySetupPage.ClickOnGeoLocationTargetingCheckBox();
                inventorySetupPage.ClickOnAudienceTargetingCheckBox();
                inventorySetupPage.ClickOnKeywordTargetingCheckBox();
                inventorySetupPage.ClickOnDeviceTargetingCheckBox();
                inventorySetupPage.ClickOnCustomTargetingCheckBox();
                inventorySetupPage.ClickOnPersonasVisibilityToggleButton();
                inventorySetupPage.ClickOnInventoryCreateButton();
                utility.ClickOnPopUpCloseButton();
                if (!inventorySetupPage.ValidatePersonaTargetingEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Persona Targeting Empty Error Message is displayed.");
                    softAssert.fail("Persona Targeting Empty Error Message is displayed.");
                }
                inventorySetupPage.clickOnSilverAccountCheckBox();
                inventorySetupPage.clickOnGoldAccountCheckBox();
                inventorySetupPage.clickOnPlatinumAccountCheckBox();
                inventorySetupPage.clickOnBetaAccountCheckBox();

                inventorySetupPage.EnterDataInInventoryMinimumCpcField("abcd");
                if (inventorySetupPage.ValidateInventoryMinimumCpcFieldAcceptingCharacters("abcd")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory Minimum CPC Field is accepting characters.");
                    softAssert.fail("Inventory Minimum CPC Field is accepting characters.");
                }
                inventorySetupPage.EnterDataInInventoryMinimumCpcField("-10");
                if (inventorySetupPage.ValidateInventoryMinimumCpcFieldAcceptingNegativeValue("-10")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory Minimum CPC Field is accepting negative values.");
                    softAssert.fail("Inventory Minimum CPC Field is accepting negative values.");
                }
                inventorySetupPage.EnterDataInInventoryMinimumCpcField("10");
                inventorySetupPage.EnterDataInInventoryMinimumCpmField("abcd");
                if (inventorySetupPage.ValidateInventoryMinimumCpmFieldAcceptingCharacters("abcd")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory Minimum CPM Field is accepting characters.");
                    softAssert.fail("Inventory Minimum CPM Field is accepting characters.");
                }
                inventorySetupPage.EnterDataInInventoryMinimumCpmField("-10");
                if (inventorySetupPage.ValidateInventoryMinimumCpmFieldAcceptingNegativeValue("-10")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory Minimum CPM Field is accepting negative values.");
                    softAssert.fail("Inventory Minimum CPM Field is accepting negative values.");
                }
                inventorySetupPage.EnterDataInInventoryMinimumCpmField("11");
                inventorySetupPage.EnterDataInInventoryDailyImpressionsField("abcd");
                if (inventorySetupPage.ValidateInventoryDailyImpressionsFieldAcceptingCharacters("abcd")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory Minimum CPM Field is accepting characters.");
                    softAssert.fail("Inventory Minimum CPM Field is accepting characters.");
                }
                inventorySetupPage.EnterDataInInventoryDailyImpressionsField("-100");
                if (inventorySetupPage.ValidateInventoryDailyImpressionsFieldAcceptingNegativeValue("-10")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory daily impressions Field is accepting negative values.");
                    softAssert.fail("Inventory daily impressions Field is accepting negative values.");
                }
                inventorySetupPage.EnterDataInInventoryDailyImpressionsField("");
                inventorySetupPage.EnterDataInInventoryDailyImpressionsField("5000");
                inventorySetupPage.EnterDataInPreviewNameField("     ");
                if (!inventorySetupPage.ValidateInventoryPreviewNameFieldAcceptsOnlySpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory preview name field accepts only spaces as input.");
                    softAssert.fail("Inventory preview name field accepts only spaces as input.");
                }
                inventorySetupPage.EnterDataInPreviewNameField("QaTesting Preview Name");
//                inventorySetupPage.EnterDataInPreviewDescriptionField("     ");
//                if (inventorySetupPage.ValidateInventoryPlacementDescriptionFieldAcceptsOnlySpaces()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory description  field accepts only spaces as input.");
//                    softAssert.fail("Inventory preview description field accepts only spaces as input.");
//                }
                inventorySetupPage.EnterDataInPreviewDescriptionField(String.valueOf(inventorySetupPage.RandomString("QATesting", 40, "text")));
                if (inventorySetupPage.ValidateInventoryPlacementDescriptionFieldAcceptsMoreThan35Characters()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory description  field accepts more than 35 characters.");
                    softAssert.fail("Inventory preview description  field accepts more than 35 characters");
                }
//                inventorySetupPage.EnterDataInThumbnailNameField("     ");
//                inventorySetupPage.ClickOnInventoryCreateButton();
//                utility.ClickOnPopUpCloseButton();
//                if (!inventorySetupPage.ValidateInventoryThumbNailNameFieldAcceptsOnlySpaces()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory preview name field accepts only spaces as input.");
//                    softAssert.fail("Inventory thumbnail name field accepts only spaces as input.");
//                }
                inventorySetupPage.EnterDataInThumbnailNameField("QaTesting ThumbNail Name");
//                inventorySetupPage.EnterDataInThumbnailDescriptionField("     ");
//                if (inventorySetupPage.ValidateInventoryThumbNailDescriptionFieldAcceptsOnlySpaces()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory description  field accepts only spaces as input.");
//                    softAssert.fail("Inventory thumbnail description field accepts only spaces as input.");
//                }
                Thread.sleep(1000);
                inventorySetupPage.EnterDataInThumbnailDescriptionField(String.valueOf(inventorySetupPage.RandomString("QATesting", 40, "text")));
                if (inventorySetupPage.ValidateInventoryThumbNailDescriptionFieldAcceptsMoreThan35Characters()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Inventory description  field accepts more than 35 characters.");
                    softAssert.fail("Inventory thumbnail description  field accepts more than 35 characters");
                }
                inventorySetupPage.EnterDataInThumbnailDescriptionField("Sample Thumbnail Description");
                inventorySetupPage.EnterDataInAuctionInventoryTagsField("         ");
                adFormatSetupPage.ClickEnterIcon();   //bug
                if (inventorySetupPage.ValidateSavedTagDataContainsOnlySpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Saved tag data contains only spaces.");
                    softAssert.fail("Saved tag data contains only spaces.");
                }

                inventorySetupPage.ClickOnInventoryCreateButton();
                Thread.sleep(2500);
                inventorySetupPage.EnterDataInTableSearchField(String.valueOf(inventorySetupPage.InventoryName));
                Thread.sleep(2000);
                if (!inventorySetupPage.ValidatingCreatedInventory()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Created inventory is not present in the table");
                    softAssert.fail("Created inventory is not present in the table");
                }

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Page Set Up")
    @Story("Page Creation-Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 5,description = "Test: Validate all fields while creating page")
    public void ValidateAllFieldsWhileCreatingPage()  {
        utility.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                pageSetupPage.ClickOnControlCenterNavButton();
                pageSetupPage.ClickOnPageSetUp();
                pageSetupPage.ClickOnAddPageButton();
                pageSetupPage.ClickPageCreateButton();
                if (!pageSetupPage.IsPageNameEmptyErrorMessageDisplayed()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Page name empty error message is not displayed.");
                    softAssert.fail("Page name empty error message is not displayed.");
                }
                if (!pageSetupPage.ValidatingApiIdentifierEmptyErrorMessageDisplayed()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Api identifier empty error message is not displayed.");
                    softAssert.fail("Api identifier empty error message is not displayed.");
                }
                pageSetupPage.PageNameFieldWithOnlySpaces();
                pageSetupPage.ClickPageCreateButton();
                if (pageSetupPage.ValidateNameFieldNoSpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Name field accepts only spaces as input.");
                    softAssert.fail("Name field accepts only spaces as input.");
                }
                pageSetupPage.PageNameFieldWithMaxCount();
                if (pageSetupPage.ValidateNameFieldMaxCharacterCount()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Name field exceeds maximum character count of 30.");
                    softAssert.fail("Name field exceeds maximum character count of 30.");
                }
                pageSetupPage.EnterSpacesInTagsField("   ");
                pageSetupPage.ClickEnterIcon();
                if (pageSetupPage.ValidateSavedTagDataContainsOnlySpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Saved tag data contains only spaces.");
                    softAssert.fail("Saved tag data contains only spaces.");
                }
                Thread.sleep(500);
//                pageSetupPage.clickSavedTagRemoveIcon();
                pageSetupPage.EnterDataInApiIdentifierField("      ");
                pageSetupPage.ClickPageCreateButton();
                if (!pageSetupPage.ValidateApiIdentifierFieldWithSpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Api identifier field is not displaying spaces error message.");
                    softAssert.fail("Api identifier field is not displaying spaces error message.");
                }
                pageSetupPage.EnterDataInApiIdentifierField("*&&%^%");
                pageSetupPage.ClickPageCreateButton();
                if (!pageSetupPage.ValidateApiIdentifierFieldWithSpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Api identifier field is not displaying special characters error message.");
                    softAssert.fail("Api identifier field is not displaying special characters error message.");
                }
                pageSetupPage.EnterExistingApiNameApiIdentifierField("demo");
                pageSetupPage.EnterExistingPageName("demo");
                pageSetupPage.ClickPageCreateButton();
                if (!pageSetupPage.ValidatingSamePageTypeErrorPopUpDisplayedWhenSavingWithExistingPageName()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Same page type error pop-up is not displayed.");
                    softAssert.fail("Same page type error pop-up is not displayed.");
                }
                pageSetupPage.ClickingOnPopUpCloseButton();

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }





    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Ad Format Set Up")
    @Story("Ad Format Creation-Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6,description = "Test: Validate all fields while creating ad format")
    public void ValidateAllFieldsWhileCreatingAdFormat()   {
        utility.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                adFormatSetupPage.ClickOnControlCenterNavButton();
                adFormatSetupPage.ClickAdFormatSetupButton();
                adFormatSetupPage.ClickCustomAdSetup();
                adFormatSetupPage.ClickOnAddAdFormatButton();
                adFormatSetupPage.ClickAdTypeField();
                adFormatSetupPage.ClickImageInAdTypeDropDown(5);
                if (!adFormatSetupPage.ValidateAdFormatNameEmptyFieldError()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when Ad Format Name is empty");
                    softAssert.fail("No error message displayed when Ad Format Name is empty");
                }
                if (!adFormatSetupPage.ValidateAdFormatApiFieldEmptyFieldError()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when Ad Format Name is empty");
                    softAssert.fail("No error message displayed when Ad Format Name is empty");
                }
                if (!adFormatSetupPage.ValidateAdFormatAdSizeEmptyFieldError()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when Ad Format ad type is empty");
                    softAssert.fail("No error message displayed when Ad Format ad type is empty");
                }
                if (!adFormatSetupPage.ValidateAdFormatPreviewNameEmptyFieldError()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when Ad Format preview name is empty");
                    softAssert.fail("No error message displayed when Ad Format preview name is empty");
                }
                if (!adFormatSetupPage.ValidateAdFormatPreviewImageEmptyFieldError()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when Ad Format preview image is empty");
                    softAssert.fail("No error message displayed when Ad Format preview image is empty");
                }
                adFormatSetupPage.EnterSpacesInAdFormatNameField("    ");
                pageSetupPage.ClickPageCreateButton();
                if (adFormatSetupPage.ValidateAdFormatNameFieldNoSpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Name field accepts only spaces as input.");
                    softAssert.fail("Name field accepts only spaces as input.");
                }
                pageSetupPage.ClickingOnPopUpCloseButton();
                adFormatSetupPage.EnterDataInAdFormatNameField("");
//                adFormatSetupPage.EnterOnlySpacesInDescriptionField("           ");
//                pageSetupPage.ClickPageCreateButton();
//                if (!adFormatSetupPage.ValidateAdFormatDescriptionFieldNoSpaces()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Ad format Description field accepts only spaces as input.");
//                    softAssert.fail("Ad formatDescription field accepts only spaces as input.");
//                }

                adFormatSetupPage.EnterDataInDescriptionField("Sample Description");

                adFormatSetupPage.ValidateApiIdentifierField("        ");
                pageSetupPage.ClickPageCreateButton();
                pageSetupPage.ClickingOnPopUpCloseButton();
                if (adFormatSetupPage.ValidateApiIdentifierFieldWithSpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Api identifier field is accepting only spaces.");
                    softAssert.fail("Api identifier field is accepting only spaces.");
                }
                adFormatSetupPage.EnterDataInIdentifierKeyField("Api_Key_", 4, "time");

                adFormatSetupPage.EnterDataInMaxWidthField("abcd");
                if (adFormatSetupPage.ValidateMaxWidthFieldAcceptingCharacters("abcd")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Max width field is accepting characters.");
                    softAssert.fail("Max width field is accepting characters.");
                }

                adFormatSetupPage.EnterDataInMaxWidthField("-10");
                if (adFormatSetupPage.ValidateMaxWidthFieldAcceptingNegativeValue("-10")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Max width field is accepting negative values.");
                    softAssert.fail("Max width field is accepting negative values.");
                }


                adFormatSetupPage.EnterDataInMinWidthField("abcd");
                if (adFormatSetupPage.ValidateMinWidthFieldAcceptingCharacters("abcd")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Min width field is accepting characters.");
                    softAssert.fail("Min width field is accepting characters.");
                }

                adFormatSetupPage.EnterDataInMinWidthField("-10");
                if (adFormatSetupPage.ValidateMinWidthFieldAcceptingNegativeValue("-10")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Min width field is accepting negative values.");
                    softAssert.fail("Min width field is accepting negative values.");
                }
                adFormatSetupPage.EnterDataInMaxWidthField("1024");
                adFormatSetupPage.EnterDataInMinWidthField("768");

                adFormatSetupPage.EnterDataInPreviewNameField("           ");
                adFormatSetupPage.ClickOnAdFormatCreateButton();
                pageSetupPage.ClickingOnPopUpCloseButton();
                if (adFormatSetupPage.ValidatePreviewNameFieldAcceptingOnlySpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Preview name field is accepting only spaces as input.");
                    softAssert.fail("Preview name field is accepting only spaces as input.");
                }

                adFormatSetupPage.EnterDataInAdPreviewDescriptionField("             ");
                adFormatSetupPage.ClickOnAdFormatCreateButton();
                if (adFormatSetupPage.ValidateDescriptionFieldAcceptingOnlySpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Preview description field is accepting only spaces as input.");
                    softAssert.fail("Preview description field is accepting only spaces as input.");
                }
                adFormatSetupPage.EnterDataInPreviewNameField("Preview Name");


                adFormatSetupPage.EnterDataInAdPreviewDescriptionField(String.valueOf(AdFormatSetupPage.RandomString("QaTesting", 35, "text")));
                if (adFormatSetupPage.ValidateDescriptionFieldAcceptingMoreThan35Characters()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Preview description field is accepting more than 35 characters.");
                    softAssert.fail("Preview description field is accepting more than 35 characters.");
                }
                adFormatSetupPage.EnterDataInAdPreviewDescriptionField("Ad preview description content");
                adFormatSetupPage.ClickUploadPreviewImage();
                adFormatSetupPage.ClickCreativeLibraryImageSelector();
                adFormatSetupPage.ClickCreativeLibraryChooseButton();
//        adFormatSetupPage.ValidateApiIdentifierField("Carousel");


                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(1);

                adFormatSetupPage.EnterDataInVideoFieldName("Your Video Field Name");
                adFormatSetupPage.EnterDataInVideoDescription("Your Video Description");
                adFormatSetupPage.EnterDataInVideoAPIIdentifier("Your Video API Identifier");
                adFormatSetupPage.EnterDataInVideoWidth("10");
                adFormatSetupPage.EnterDataInVideoHeight("15");
                adFormatSetupPage.EnterDataInVideoMinSize("0");
                adFormatSetupPage.EnterDataInVideoMaxSize("0");
                adFormatSetupPage.ClickOnAdFormatCreateButton();
                pageSetupPage.ClickingOnPopUpCloseButton();
                if (!adFormatSetupPage.ValidateVideoSizeEmptyFieldError()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Empty video min and max size error is not visible.");
                    softAssert.fail("Empty video min and max size error is not visible.");
                }
                adFormatSetupPage.EnterDataInVideoMinSize("abcd");
                if (adFormatSetupPage.ValidateVideoMinSizeFieldAcceptingCharacters("abcd")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Video Min size field is accepting characters.");
                    softAssert.fail("Video Min size field is accepting characters.");
                }
                adFormatSetupPage.EnterDataInVideoMinSize("-20");
                if (adFormatSetupPage.ValidateVideoMinSizeFieldAcceptingNegativeValues()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Video Min size field is accepting negative values.");
                    softAssert.fail("Video Min size field is accepting negative values.");
                }

                adFormatSetupPage.EnterDataInVideoMaxSize("abcd");
                if (adFormatSetupPage.ValidateVideoMaxSizeFieldAcceptingCharacters("abcd")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Video Max size field is accepting characters.");
                    softAssert.fail("Video Max size field is accepting characters.");
                }
                adFormatSetupPage.EnterDataInVideoMaxSize("-2");
                if (adFormatSetupPage.ValidateVideoMaxSizeFieldAcceptingNegativeValues()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Video Max size field is accepting negative values.");
                    softAssert.fail("Video Max size field is accepting negative values.");
                }
                adFormatSetupPage.ClickOnVideoSizeTypeDropDown(2);
                adFormatSetupPage.OptionalClickOnGenericOptionsSelector(1);
                if (!adFormatSetupPage.ValidateVideoSizeEmptyFieldError()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Error Message in Video size is not displaying max size is less than min size.");
                    softAssert.fail("Error Message in Video size is not displaying max size is less than min size.");
                }
                adFormatSetupPage.EnterDataInVideoMaxSize("200");
                for (int i = 1; i <= 5; i++) {
                    adFormatSetupPage.VideoFormatSelector(i);
                }
                if (!adFormatSetupPage.ValidateVideoAcceptedErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Video accepted error message  is not displaying after deselecting all formats.");
                    softAssert.fail("Video accepted error message  is not displaying after deselecting all formats");
                }
                for (int i = 1; i <= 5; i++) {
                    adFormatSetupPage.VideoFormatSelector(i);
                }
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(2);
                adFormatSetupPage.EnterDataInImageFieldName("Sample Image");
                adFormatSetupPage.EnterDataInImageDescription("This is a sample image description.");
                adFormatSetupPage.EnterDataInImageAPIIdentifier("ImageAPI123");
                adFormatSetupPage.EnterDataInImageWidth("1920");
                adFormatSetupPage.EnterDataInImageHeight("1080");
                adFormatSetupPage.EnterDataInImageMinSize("500KB");
                adFormatSetupPage.EnterDataInImageMaxSize("1000");
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(3);
                adFormatSetupPage.EnterDataInCarouselFieldName("Sample Carousel");
                adFormatSetupPage.EnterDataInCarouselDescription("This is a sample carousel description.");
                adFormatSetupPage.EnterDataInCarouselAPIIdentifier("CarouselAPI123");
                adFormatSetupPage.EnterDataInCarouselMinCount("1");
                adFormatSetupPage.EnterDataInCarouselMinCount("abcd");
                if (adFormatSetupPage.ValidateCarouselMinFieldAcceptingCharacters("abcd")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Carousel Min field is accepting characters.");
                    softAssert.fail("Carousel Min field is accepting characters.");
                }
                adFormatSetupPage.EnterDataInCarouselMinCount("-10");
                if (adFormatSetupPage.ValidateCarouselMinFieldAcceptingNegativeValues()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Video Min size field is accepting negative values.");
                    softAssert.fail("Video Min size field is accepting negative values.");
                }


                adFormatSetupPage.EnterDataInCarouselMaxCount("abcd");
                if (adFormatSetupPage.ValidateCarouselMaxFieldAcceptingCharacters("abcd")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Carousel Man field is accepting characters.");
                    softAssert.fail("Carousel Min field is accepting characters.");
                }
                adFormatSetupPage.EnterDataInCarouselMaxCount("-10");
                if (adFormatSetupPage.ValidateCarouselMaxFieldAcceptingNegativeValues()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Carousel Max size field is accepting negative values.");
                    softAssert.fail("Carousel Max size field is accepting negative values.");
                }
                adFormatSetupPage.EnterDataInCarouselMaxCount("1");
                adFormatSetupPage.ClickOnAdFormatCreateButton();
                if (!adFormatSetupPage.ValidateCarouselCountErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Carousel Max field is accepting less than Min count value.");
                    softAssert.fail("Carousel Max field is accepting less than Min count value");
                }
                if (!adFormatSetupPage.ValidateAddCarouselElementErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Add at least one  carousel element error message is not displayed.");
                    softAssert.fail("Add at least one  carousel element error message is not displayed.");
                }
                adFormatSetupPage.EnterDataInCarouselMaxCount("15");
                //        adFormatSetupPage.EnterDataInCarouselMaxCount("10");
//        adFormatSetupPage.ClickOnAddCarouselElementButton();
//        adFormatSetupPage.SelectingAddElementDropDownOptions(3);
//        adFormatSetupPage.EnterDataInCarouselStaticApiIdentifierField("API-Identifier");
//        adFormatSetupPage.EnterDataInCarouselStaticValueField("StaticValue");

                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(4);
                adFormatSetupPage.EnterDataInTextFieldName("Sample TextField");
                adFormatSetupPage.EnterDataInMaxCharactersSupported("100");
                adFormatSetupPage.EnterDataInTextDescription("This is a sample text description.");
                adFormatSetupPage.EnterDataInTextAPIIdentifier("TextAPI123");
                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(5);
                adFormatSetupPage.EnterDataInStaticAPIIdentifier("StaticAPI123");
                adFormatSetupPage.EnterDataInStaticValue("StaticValue123");


                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(6);
                adFormatSetupPage.EnterDataInUrlName("https://example.com");
                adFormatSetupPage.EnterDataInUrlAPIIdentifier("UrlAPI123");
                adFormatSetupPage.EnterDataInRestrictUrl("      ");
                adFormatSetupPage.ClickEnterIcon();
                if (adFormatSetupPage.ValidateRestrictUrlFieldAcceptingOnlySpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Restrict url field is accepting only spaces as input.");
                    softAssert.fail("Restrict url field is accepting only spaces as input.");
                }
                adFormatSetupPage.EnterDataInRestrictUrl("https://example.com");
                adFormatSetupPage.ClickEnterIcon();

                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(7);
                adFormatSetupPage.ClickOnAdFormatCreateButton();
                if (!adFormatSetupPage.ValidateEmptyCtaOptionsErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cta Options empty field error message is not displayed.");
                    softAssert.fail("Cta Options empty field error message is not displayed.");
                }
                adFormatSetupPage.EnterDataInCTAFieldName("ClickHereButton");
                adFormatSetupPage.EnterDataInCtaOptions("        ");
                adFormatSetupPage.ClickEnterIcon();
                if (adFormatSetupPage.ValidateCtaOptionsFieldAcceptingOnlySpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cta Options field is accepting only spaces as input.");
                    softAssert.fail("Cta Options field is accepting only spaces as input.");
                }

                adFormatSetupPage.EnterDataInCtaOptions("GrabNow");
                adFormatSetupPage.ClickEnterIcon();
                adFormatSetupPage.EnterDataInCtaAPIIdentifier("CtaAPI123");


                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(8);
                adFormatSetupPage.ClickOnAdFormatCreateButton();
                if (!adFormatSetupPage.ValidateEmptyThirdPartyTrackersErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Third party trackers field error message is not displayed.");
                    softAssert.fail("Third party trackers field error message is not displayed.");
                }
                adFormatSetupPage.EnterDataInTrackerFieldName("TrackingCode123");
                adFormatSetupPage.ClickOnDCMClickCheckBox();
                adFormatSetupPage.ClickOnDCmIMpressionCheckBox();
                adFormatSetupPage.ClickOnDCMImpressionImageCheckBox();



                adFormatSetupPage.ClickAddElementsButton();
//                adFormatSetupPage.SelectingAddElementDropDownOptions(9);
//                adFormatSetupPage.ClickOnAdFormatCreateButton();
//                if (!adFormatSetupPage.ValidateEmptyProductListButtonFieldErrorMessage()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Product list empty button field error message is not displayed.");
//                    softAssert.fail("Product list empty button field error message is not displayed.");
//                }
//                if (!adFormatSetupPage.ValidateEmptyProductListRangeFieldErrorMessage()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Product list empty range field error message is not displayed.");
//                    softAssert.fail("Product list empty range field error message is not displayed.");
//                }
//                adFormatSetupPage.EnterDataInLandingProductFieldName("SampleProductName");
//                adFormatSetupPage.EnterDataInLandingProductButtonName("SampleButtonName");
//                adFormatSetupPage.EnterDataInLandingProductMin("10");
//                adFormatSetupPage.EnterDataInLandingProductMax("9");
//                if (!adFormatSetupPage.ValidateProductsRangeCountFieldErrorMessage()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Products range min value is greater than max value error message is not displayed.");
//                    softAssert.fail("Products range min value is greater than max value error message is not displayed.");
//                }
//                adFormatSetupPage.EnterDataInLandingProductMax("50");
//                if (!adFormatSetupPage.ValidateProductsRangeMaxFieldErrorMessage()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Products range max value is greater than 40 error message is not displayed.");
//                    softAssert.fail("Products range max value is greater than 40 error message is not displayed.");
//                }
//                adFormatSetupPage.EnterDataInLandingProductMax("20");
//                adFormatSetupPage.ClickAddElementsButton();
                adFormatSetupPage.SelectingAddElementDropDownOptions(9);
                adFormatSetupPage.ClickOnAdFormatCreateButton();
                if (!adFormatSetupPage.ValidateEmptyScheduleConfigurationErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Schedule configuration empty error message is not displayed.");
                    softAssert.fail("Schedule configuration empty error message is not displayed.");
                }
                adFormatSetupPage.EnterDataInAdSchedulingFieldName("SampleAdScheduleName");
                adFormatSetupPage.ClickOnAdSchedulingDayWiseCheckBox();
                adFormatSetupPage.ClickOnAdSchedulingDateWise();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }





}