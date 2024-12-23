package TestPulse;

import BaseClass.BaseTest;
import PagesPulse.CampaignTemplatePage;
import PagesPulse.ProductTemplatePage;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class ProductTemplate extends BaseTest {

    private ProductTemplatePage productTemplatePage;
    private CampaignTemplatePage campaignTemplatePage;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(PulseUrl);
        productTemplatePage = new ProductTemplatePage(getDriver());
        campaignTemplatePage = new CampaignTemplatePage(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "f968ddd03b493e94f7c70fa14e5c43d4");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }

    @BeforeMethod
    public void ResetPage() throws InterruptedException, AWTException {
        getDriver().navigate().to(PulseUrl);
    }

    @AfterClass
    public void TearDown() {
        getDriver().quit();
    }

    @Epic("TVING PULSE - Admin Dashboard")
    @Feature("This flow belongs to Product Template")
    @Story("Product Template Creation-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Create new product template")
    public void CreateNewProductTemplateWithAllOptionalFeatures() {
        campaignTemplatePage.RetryOnFailPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                if (!Language.equals("en")) {
                    productTemplatePage.ChangeLanguage();
                }
                productTemplatePage.ClickOnProductTemplateButton();
                productTemplatePage.ClickOnProductTemplateDashboardButton();
                productTemplatePage.ClickOnCreateProductTemplateButton();
                productTemplatePage.AddDesiredName();
                productTemplatePage.ClickOnNonPackagedRadioButton();
                productTemplatePage.ClickOnPackagedRadioButton();
                productTemplatePage.ClickOnStartDateField();
                productTemplatePage.ClickOnMonthField();
                if (!productTemplatePage.SelectDesiredMonthFromBasicInfoMonthDropdown(12)) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info Visibility Duration");
                    softAssert.fail("Cant select older then present month in basic info Visibility Duration");
                }
                productTemplatePage.ClickOnYearField();
                if (!productTemplatePage.SelectDesiredYearFromYearDropdown(2024)) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in basic info Visibility Duration");
                    softAssert.fail("Year cant be less then current year in basic info Visibility Duration");
                }
                productTemplatePage.SelectDesiredDayFromBasicInfoDayRange(2);
                productTemplatePage.ClickOnBasicInfoByAdAccountRadioButton();
                productTemplatePage.ClickOnBasicInfoAddAdAccountText();
                Thread.sleep(1500);
                productTemplatePage.SelectingDesiredAdvertisersFromAdAccount(1);
                productTemplatePage.ClickOnAddAdAccountSaveButton();
                Thread.sleep(3000);
                productTemplatePage.EnterDataInPricePerPackageField("50");
                productTemplatePage.EnterDataInTotalNumberOfPackagesField("20");
                productTemplatePage.EnterDataInPackagesPerBrandField("15");
                productTemplatePage.ClickOnExclusiveContentField();

                productTemplatePage.EnterDataInExclusiveContentSearchField("DeTarget Test");
                productTemplatePage.SelectDesiredOptionFromExclusiveDropDown(1);
                productTemplatePage.ClickOnExclusiveContentField();
                Thread.sleep(1500);
                productTemplatePage.ClickOnBasicInfoNextButton();
                Thread.sleep(1500);
                productTemplatePage.ClickOnAddCampaignTypeButton();

                productTemplatePage.SelectingCampaignFromDropDown(1);
                Thread.sleep(1500);
                productTemplatePage.SelectingDesiredProductTemplateFromTable(2);
                productTemplatePage.ClickOnAddCampaignTemplatesButton();
                productTemplatePage.EnterDataInBudgetAllocationField("100");
                productTemplatePage.ClickOnPriorityField();
                productTemplatePage.SelectDesiredOptionFromPriorityDropDown(2);
                productTemplatePage.ClickOnSaveAndActiveButton();
                if (!productTemplatePage.ValidatingCreatedProductTemplate()) {
                    Assert.fail("Product Template is not created");
                }
                productTemplatePage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                getDriver().navigate().refresh();
                Thread.sleep(2000);
                if (!productTemplatePage.ValidatingCreatedProductTemplateStatusEnabled()) {
                    Assert.fail("Product Template is Created by save and active but template is not enabled");
                }

                productTemplatePage.ClickOnProductTemplateButton();
                productTemplatePage.ClickOnExclusiveContentListButton();
                Thread.sleep(2000);
                productTemplatePage.EnterDataInExclusiveContentTableSearchField("DeTarget Test");
                Thread.sleep(2000);
                if (!productTemplatePage.ValidateExclusiveContentTableFirstRow()) {//
                    softAssert.fail("Exclusive content search results are not displayed.");
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Exclusive content search results are not displayed.");
                }

                productTemplatePage.ClickOnExclusiveContentListProductsTemplateButton();
                Thread.sleep(5000);
                productTemplatePage.EnterDataInExclusiveContentProductTemplateTableSearchField(ProductTemplatePage.ProductTemplateName);
                Thread.sleep(2000);
                if (!productTemplatePage.ValidateExclusiveContentProductTemplateTableFirstRow()) {
                    softAssert.fail("Product template is not created using exclusive content .");
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Product template is not created using exclusive content.");
                }

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
            softAssert.assertAll();

        }));

    }


    @Epic("TVING PULSE - Admin Dashboard")
    @Feature("This flow belongs to Product Template")
    @Story("Product Display Ad Template Creation-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Create display ad product template")
    public void CreateDisplayAdProductTemplateWithAllOptionalFeatures() {
        campaignTemplatePage.RetryOnFailPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                if (!Language.equals("en")) {
                    productTemplatePage.ChangeLanguage();
                }
                productTemplatePage.ClickOnProductTemplateButton();
                productTemplatePage.ClickOnProductTemplateDashboardButton();
                productTemplatePage.ClickOnCreateProductTemplateButton();
                productTemplatePage.AddDesiredName();
                productTemplatePage.ClickOnNonPackagedRadioButton();
//                productTemplatePage.ClickOnPackagedRadioButton();
                productTemplatePage.ClickOnStartDateField();
                productTemplatePage.ClickOnMonthField();
                if (!productTemplatePage.SelectDesiredMonthFromBasicInfoMonthDropdown(12)) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info Visibility Duration");
                    softAssert.fail("Cant select older then present month in basic info Visibility Duration");
                }
                productTemplatePage.ClickOnYearField();
                if (!productTemplatePage.SelectDesiredYearFromYearDropdown(2024)) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in basic info Visibility Duration");
                    softAssert.fail("Year cant be less then current year in basic info Visibility Duration");
                }
                productTemplatePage.SelectDesiredDayFromBasicInfoDayRange(2);
                productTemplatePage.ClickOnBasicInfoByAdAccountRadioButton();
                productTemplatePage.ClickOnBasicInfoAddAdAccountText();
                Thread.sleep(1500);
                productTemplatePage.SelectingDesiredAdvertisersFromAdAccount(1);
                productTemplatePage.ClickOnAddAdAccountSaveButton();
                Thread.sleep(3000);
//                productTemplatePage.EnterDataInPricePerPackageField("50");
//                productTemplatePage.EnterDataInTotalNumberOfPackagesField("20");
//                productTemplatePage.EnterDataInPackagesPerBrandField("15");
                productTemplatePage.ClickOnExclusiveContentField();

                productTemplatePage.EnterDataInExclusiveContentSearchField("DeTarget Test");
                productTemplatePage.SelectDesiredOptionFromExclusiveDropDown(1);
                productTemplatePage.ClickOnExclusiveContentField();
                Thread.sleep(1500);
                productTemplatePage.ClickOnBasicInfoNextButton();
                Thread.sleep(1500);
                productTemplatePage.ClickOnCampaignTemplateTypeButton(); //added
                productTemplatePage.ClickOnCampaignTypeSelector(2);
//                productTemplatePage.ClickOnAddCampaignTypeButton();


                Thread.sleep(1500);
                productTemplatePage.SelectingDesiredProductTemplateFromTable(2);
                productTemplatePage.ClickOnAddCampaignTemplatesButton();
                productTemplatePage.EnterDataInBudgetAllocationField("100");
                productTemplatePage.ClickOnPriorityField();
                productTemplatePage.SelectDesiredOptionFromPriorityDropDown(2);
                productTemplatePage.ClickOnSaveAndActiveButton();
                if (!productTemplatePage.ValidatingCreatedProductTemplate()) {
                    Assert.fail("Product Template is not created");
                }
                productTemplatePage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                getDriver().navigate().refresh();
                Thread.sleep(2000);
                if (!productTemplatePage.ValidatingCreatedProductTemplateStatusEnabled()) {
                    Assert.fail("Product Template is Created by save and active but template is not enabled");
                }

                productTemplatePage.ClickOnProductTemplateButton();
                productTemplatePage.ClickOnExclusiveContentListButton();
                Thread.sleep(2000);
                productTemplatePage.EnterDataInExclusiveContentTableSearchField("DeTarget Test");
                Thread.sleep(2000);
                if (!productTemplatePage.ValidateExclusiveContentTableFirstRow()) {//
                    softAssert.fail("Exclusive content search results are not displayed.");
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Exclusive content search results are not displayed.");
                }

                productTemplatePage.ClickOnExclusiveContentListProductsTemplateButton();
                Thread.sleep(5000);
                productTemplatePage.EnterDataInExclusiveContentProductTemplateTableSearchField(ProductTemplatePage.ProductTemplateName);
                Thread.sleep(2000);
                if (!productTemplatePage.ValidateExclusiveContentProductTemplateTableFirstRow()) {
                    softAssert.fail("Product template is not created using exclusive content .");
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Product template is not created using exclusive content.");
                }

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
            softAssert.assertAll();

        }));

    }


    @Epic("TVING PULSE - Admin Dashboard")
    @Feature("This flow belongs to Product Template")
    @Story("Product Template Creation-Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Validating all fields while creating product template")
    public void ValidateAllFieldInProductTemplateCreation() throws InterruptedException {
        campaignTemplatePage.RetryOnFailPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                if (!Language.equals("en")) {
                    productTemplatePage.ChangeLanguage();
                }
                productTemplatePage.ClickOnProductTemplateButton();
                productTemplatePage.ClickOnProductTemplateDashboardButton();
                productTemplatePage.ClickOnCreateProductTemplateButton();
                productTemplatePage.ClickOnSaveAsDraftButton();
                if (!productTemplatePage.ValidateSaveAsDraftButtonEmptyFieldErrorPopUp()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - With out filling mandatory fields product template is saving as draft");
                    softAssert.fail("With out filling mandatory fields product template is saving as draft");
                }
                productTemplatePage.ClickOnBasicInfoNextButton();
                if (!productTemplatePage.ValidateBasicInfoFields()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info mandatory fields are not filled and going to next step");
                    softAssert.fail("Basic info mandatory fields are not filled and going to next step");
                }
                productTemplatePage.ClickingOnPopUpCloseButton();
                productTemplatePage.EnterDataInNameField("      ");
                productTemplatePage.ClickOnBasicInfoNextButton();
                if (!productTemplatePage.ValidateNameFieldAcceptingSpaces()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info name field is accepting spaces");
                    softAssert.fail("Basic info name field is accepting spaces");
                }
                productTemplatePage.EnterDataInNameField(String.valueOf(productTemplatePage.TwoHundredWords));
                productTemplatePage.ClickOnBasicInfoNextButton();
                if (!productTemplatePage.ValidateNameFieldAcceptingMoreThan200Characters()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info name field is accepting more than 200 characters");
                    softAssert.fail("Basic info name field is accepting more than 200 characters");
                }
                productTemplatePage.EnterDataInNameField("Testing15");
                productTemplatePage.ClickOnNonPackagedRadioButton();
                productTemplatePage.ClickOnBasicInfoNextButton();

                if (!productTemplatePage.ValidateNameFieldAcceptingDuplicateName()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info name field is accepting already existing product template name");
                    softAssert.fail("Basic info name field is accepting already existing product template name");
                }
                productTemplatePage.ClickOnBasicInfoNextButton();
                productTemplatePage.ClickingOnPopUpCloseButton();
                productTemplatePage.AddDesiredName();
                productTemplatePage.ClickOnPackagedRadioButton();
                productTemplatePage.EnterDataInPricePerPackageField("Abcd%^$#@&");
                if (productTemplatePage.ValidatePricePerPackagedFieldAcceptingCharacters()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info price per package field is accepting characters without any error message");
                    softAssert.fail("Basic info price per package field is accepting characters without any error message");
                }
                productTemplatePage.EnterDataInPricePerPackageField("4.5");
                if (productTemplatePage.ValidatePricePerPackagedFieldAcceptingFloatValue()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info price per package field is accepting  float value without any error");
                    softAssert.fail("Basic info price per package field is accepting  float value without any error");
                }
                productTemplatePage.EnterDataInPricePerPackageField("-23");
                if (productTemplatePage.ValidatePricePerPackagedFieldAcceptingNegativeValue()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info price per package field is accepting negative value without any error");
                    softAssert.fail("Basic info price per package field is accepting negative value without any error");
                }

                productTemplatePage.EnterDataInTotalNumberOfPackagesField("Test@@");
                if (productTemplatePage.ValidateNumberOfPackagesFieldAcceptingCharacters()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info number of packages  field is accepting characters without any error message");
                    softAssert.fail("Basic info number of packages  field is accepting characters without any error message");
                }
                productTemplatePage.EnterDataInTotalNumberOfPackagesField("18.6");
                if (productTemplatePage.ValidateNumberOfPackagesFieldAcceptingFloatValue()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info number of packages  field is accepting  float value without any error");
                    softAssert.fail("Basic info number of packages  field is accepting  float value without any error");
                }
                productTemplatePage.EnterDataInTotalNumberOfPackagesField("-40");
                if (productTemplatePage.ValidateNumberOfPackagesFieldAcceptingNegativeValue()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info number of packages  field is accepting negative value without any error");
                    softAssert.fail("Basic info number of packages  field is accepting negative value without any error");
                }

                productTemplatePage.EnterDataInPackagesPerBrandField("ZZcd%^$#@&");
                if (productTemplatePage.ValidatePackagesPerBrandFieldAcceptingCharacters()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info Packages Per Brand  field is accepting characters without any error message");
                    softAssert.fail("Basic info Packages Per Brand  field is accepting characters without any error message");
                }
                productTemplatePage.EnterDataInPackagesPerBrandField("8.5");
                if (productTemplatePage.ValidatePackagesPerBrandFieldAcceptingFloatValue()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info Packages Per Brand  field is accepting  float value without any error");
                    softAssert.fail("Basic info Packages Per Brand  field is accepting  float value without any error");
                }
                productTemplatePage.EnterDataInPackagesPerBrandField("-10");
                if (productTemplatePage.ValidatePackagesPerBrandFieldAcceptingNegativeValue()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info Packages Per Brand  field is accepting negative value without any error");
                    softAssert.fail("Basic info Packages Per Brand  field is accepting negative value without any error");
                }


                productTemplatePage.EnterDataInPackagesPerBrandField("60");
                productTemplatePage.ClickOnBasicInfoNextButton();
                if (!productTemplatePage.ValidatePackagesPerBrandFieldAcceptingGreaterValueThanTotalPackages()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Basic info packages per brand field is accepting greater value then total packages");
                    softAssert.fail("Basic info packages per brand field is accepting greater value then total packages");
                }
                productTemplatePage.EnterDataInPackagesPerBrandField("2");

                productTemplatePage.ClickOnAdsWindowStartDateField();
                productTemplatePage.ClickOnAdsWindowMonthField();
                if (!productTemplatePage.SelectDesiredMonthFromAdsWindowMonthDropdown(12)) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in basic info ads period window date");
                    softAssert.fail("Cant select older then present month in basic info ads period window date");
                }
                productTemplatePage.ClickOnAdsWindowYearField();
                if (!productTemplatePage.SelectDesiredYearFromAdsWindowYearDropdown(2025)) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year in ads period window date");
                    softAssert.fail("Year cant be less then current year in ads period window date");
                }
                productTemplatePage.SelectDesiredDayFromAdsWindowDayRange(29);

                productTemplatePage.ClickOnAdsWindowEndDateField();
                productTemplatePage.ClickOnAdsWindowMonthField();
                if (!productTemplatePage.SelectDesiredMonthFromAdsWindowMonthDropdown(12)) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older then present month in ads period window date");
                    softAssert.fail("Cant select older then present month in ads period window date");
                }
                productTemplatePage.ClickOnAdsWindowYearField();
                if (!productTemplatePage.SelectDesiredYearFromAdsWindowYearDropdown(2025)) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less then current year ads period window date");
                    softAssert.fail("Year cant be less then current year ads period window date");
                }
                productTemplatePage.SelectDesiredDayFromAdsWindowDayRange(9);

                productTemplatePage.EnterDataInMinimumAdPeriodFieldField("5");
                if (!productTemplatePage.ValidateMinAdFieldIsWithinTheStartAndEndDateRange()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - The minimum ad period value should be less than the date range of the start and end dates");
                    softAssert.fail("The minimum ad period value should be less than the date range of the start and end dates");
                }


                productTemplatePage.EnterDataInMinimumAdPeriodFieldField("Abcd%^$#a");
                if (productTemplatePage.ValidateMinimumAdPeriodFieldAcceptingCharacters()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Minimum ad period  field is accepting characters without any error message");
                    softAssert.fail("number of packages  field is accepting characters without any error message");
                }
                productTemplatePage.EnterDataInMinimumAdPeriodFieldField("18.6");
                if (productTemplatePage.ValidateMinimumAdPeriodFieldAcceptingFloatValue()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Minimum ad period  field is accepting  float value without any error");
                    softAssert.fail("number of packages  field is accepting  float value without any error");
                }
                productTemplatePage.EnterDataInMinimumAdPeriodFieldField("-6");
                if (productTemplatePage.ValidateMinimumAdPeriodFieldAcceptingNegativeValue()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Minimum ad period  field is accepting negative value without any error");
                    softAssert.fail("number of packages  field is accepting negative value without any error");
                }
                productTemplatePage.ClickOnBasicInfoNextButton();
                productTemplatePage.ClickOnSaveAndActiveButton();
                if (!productTemplatePage.ValidateSaveAndActiveButtonWithOutCampaignTemplate()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Template is being saved without selecting any product campaign template");
                    softAssert.fail("Template is being saved without selecting product any campaign template");
                }
                productTemplatePage.ClickingOnPopUpCloseButton();
                productTemplatePage.ClickOnAddCampaignTypeButton();
                productTemplatePage.SelectingCampaignFromDropDown(1);


//                productTemplatePage.ClickOnAddCampaignTemplateButton();
//                productTemplatePage.ClickOnAddCampaignTemplatesButton();
//                if (!productTemplatePage.ValidateAddTemplateButtonWithOutSelectingTemplate()) {
//                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to process next to step with out selecting template ");
//                    softAssert.fail("User is able to process next to step with out selecting template");
//                }
//                productTemplatePage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                productTemplatePage.SelectingDesiredProductTemplateFromTable(2);
                productTemplatePage.ClickOnAddCampaignTemplatesButton();
                productTemplatePage.ClickOnSaveAndActiveButton();
                if (!productTemplatePage.ValidateBudgetAllocationFieldAcceptingEmptyValue()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign template budget allocation field is accepting empty value");
                    softAssert.fail("Campaign template budget allocation field is accepting empty value");
                }
                productTemplatePage.ClickingOnPopUpCloseButton();
                productTemplatePage.EnterDataInBudgetAllocationField("10");
                productTemplatePage.ClickOnSaveAndActiveButton();
                if (!productTemplatePage.ValidateBudgetAllocationFieldAcceptingLessThan100()) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign template Budget allocation field is accepting less than 100%");
                    softAssert.fail("Campaign template Budget allocation field is accepting less than 100%");
                }
                productTemplatePage.ClickingOnPopUpCloseButton();
                productTemplatePage.EnterDataInBudgetAllocationField("1000");
                productTemplatePage.ClickOnSaveAndActiveButton();
                if (productTemplatePage.ValidateBudgetAllocationFieldAcceptingMoreThan100("1000")) {
                    productTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign template Budget allocation field is accepting more than 100%");
                    softAssert.fail("Campaign template Budget allocation field is accepting more than 100%");
                }

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
            softAssert.assertAll();

        }));

    }

}

