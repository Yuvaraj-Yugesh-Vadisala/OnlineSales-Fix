package TestPulse;

import BaseClass.BaseTest;
import PagesPulse.CampaignTemplatePage;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class CampaignTemplate extends BaseTest {

    private CampaignTemplatePage campaignTemplatePage;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(PulseUrl);
        campaignTemplatePage = new CampaignTemplatePage(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "f968ddd03b493e94f7c70fa14e5c43d4");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();

        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Started: " + this.getClass().getName());

    }

    @BeforeMethod
    public void ResetPage() throws InterruptedException, AWTException {
        getDriver().navigate().to(PulseUrl);
        if (!Language.equals("en")) {
            campaignTemplatePage.ChangeLanguage();
        }

    }

    @AfterClass
    public void TearDown() {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Finished: " + this.getClass().getName());

        getDriver().quit();
    }

    @Epic("TVING PULSE - Admin Dashboard")
    @Feature("This flow belongs to Campaign Template")
    @Story("Campaign Template Creation-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Create new campaign template")
    public void CreateNewCampaignTemplate()  {
        campaignTemplatePage.RetryOnFailPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                campaignTemplatePage.ClickOnCampaignTemplateButton();
                campaignTemplatePage.ClickOnCreateNewCampaignTemplate();
                campaignTemplatePage.AddingDesiredName();
                campaignTemplatePage.SelectGuaranteedRadioButton();
                campaignTemplatePage.EnterDesiredValueTOLifeTimeFrequencyField("200");
                campaignTemplatePage.EnterValueTODailyFrequencyField("20");
                campaignTemplatePage.EnterValueTOBasePriceField("40");
                campaignTemplatePage.ClickTargetDropdown();
//                campaignTemplatePage.SelectDesiredTarget("1");
//                campaignTemplatePage.EnterValueToSurchargeField("2");
//                campaignTemplatePage.ClickSurchargeDropdown();
//                campaignTemplatePage.SelectSurchargeValueType();
                campaignTemplatePage.ClickOnSaveAndActivateButton();
                if (!campaignTemplatePage.ValidateCreationOfCampaignTemplate())
                    Assert.fail("Campaign template creation failed");
                campaignTemplatePage.ClickingOnPopUpCloseButton();
                Thread.sleep(1500);
                getDriver().navigate().refresh();
                Thread.sleep(1500);
                if (!campaignTemplatePage.ValidatingCreatedCampaignTemplateStatus()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Newly Created Campaign Status is disabled");
                    softAssert.fail("Newly Created Campaign Status is disabled");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }



    @Epic("TVING PULSE - Admin Dashboard")
    @Feature("This flow belongs to Campaign Template")
    @Story("Campaign Template Creation-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Create display ad campaign template")
    public void CreateDisplayAdCampaignTemplate()  {
        campaignTemplatePage.RetryOnFailPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                campaignTemplatePage.ClickOnCampaignTemplateButton();
                campaignTemplatePage.ClickOnCreateNewCampaignTemplate();
                campaignTemplatePage.ClickOnDisplayADsRadioButton();//added
//                campaignTemplatePage.ClickYesButtonForConfirmation();

                campaignTemplatePage.AddingDesiredName();
                campaignTemplatePage.SelectGuaranteedRadioButton();
                campaignTemplatePage.EnterDesiredValueTOLifeTimeFrequencyField("200");
                campaignTemplatePage.EnterValueTODailyFrequencyField("20");
                campaignTemplatePage.EnterValueTOBasePriceField("40");
                campaignTemplatePage.ClickTargetDropdown();
//                campaignTemplatePage.SelectDesiredTarget("1");
//                campaignTemplatePage.EnterValueToSurchargeField("2");
//                campaignTemplatePage.ClickSurchargeDropdown();
//                campaignTemplatePage.SelectSurchargeValueType();
                campaignTemplatePage.ClickOnSaveAndActivateButton();
                if (!campaignTemplatePage.ValidateCreationOfCampaignTemplate())
                    Assert.fail("Campaign template creation failed");
                campaignTemplatePage.ClickingOnPopUpCloseButton();
                Thread.sleep(1500);
                getDriver().navigate().refresh();
                Thread.sleep(1500);
                if (!campaignTemplatePage.ValidatingCreatedCampaignTemplateStatus()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Newly Created Campaign Status is disabled");
                    softAssert.fail("Newly Created Campaign Status is disabled");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }




    @Epic("TVING PULSE - Admin Dashboard")
    @Feature("This flow belongs to Campaign Template")
    @Story("Campaign Template Creation-Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Validating All fields while creating Campaign template")
    public void ValidationOfAllFieldsWhileCampaignTemplateCreation() throws InterruptedException {
        campaignTemplatePage.RetryOnFailPulse((() ->
        {
            SoftAssert softAssert = new SoftAssert();
            try {
                campaignTemplatePage.ClickOnCampaignTemplateButton();
                campaignTemplatePage.ClickOnCreateNewCampaignTemplate();
                campaignTemplatePage.EnterDataInNameField("     ");
                campaignTemplatePage.ClickOnSaveAndActivateButton();
                if (!campaignTemplatePage.ValidateNameFieldAcceptingSpaces()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Template name field is accepting spaces without any error message while creating campaign template");
                    softAssert.fail("Name Field is accepting spaces without error message");
                }
                campaignTemplatePage.EnterDataInNameField(String.valueOf(campaignTemplatePage.TwoHundredWords));
                Thread.sleep(2000);
                campaignTemplatePage.ClickOnSaveAndActivateButton();
                if (!campaignTemplatePage.ValidateNameFieldAcceptingMoreThan200Characters()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Template name field does not accept 200 words without any  error message while creating campaign template");
                    softAssert.fail("Field is accepting more than 200 characters");
                }
                campaignTemplatePage.EnterDataInNameField("Testing15");
                campaignTemplatePage.EnterValueTOBasePriceField("40");
                campaignTemplatePage.ClickOnSaveAndActivateButton();
                if (!campaignTemplatePage.ValidateNameFieldAcceptingDuplicateName()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Duplicate template creation error message while creating multiple campaign template with same name");
                    softAssert.fail("User is able to create multiple campaign templates with same name");
                }
                Thread.sleep(2000);

                campaignTemplatePage.EnterDesiredValueTOLifeTimeFrequencyField("Abcd&*^%*^*&*");
                if (campaignTemplatePage.ValidateLifeTimeFrequencyFieldAcceptingCharacters()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Lifetime frequency field accepts characters without any error message while creating campaign template");
                    softAssert.fail("LifeTime frequency field is accepting characters without any error message");
                }
                campaignTemplatePage.SelectGuaranteedRadioButton();
                campaignTemplatePage.EnterDesiredValueTOLifeTimeFrequencyField("2.5");
                if (campaignTemplatePage.ValidateLifetimeFrequencyFieldAcceptingFloatValue()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Lifetime frequency field accepts float value without any error message while creating campaign template");
                    softAssert.fail("LifeTime frequency field is accepting float value without any error");
                }
                getDriver().navigate().refresh();
                campaignTemplatePage.EnterDesiredValueTOLifeTimeFrequencyField("-21");
                if (campaignTemplatePage.ValidateLifetimeFrequencyFieldAcceptingNegativeValue()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Lifetime frequency field accepts negative value without any error message while creating campaign template");
                    softAssert.fail("LifeTime frequency field is accepting Negative value without any error");
                }
                getDriver().navigate().refresh();
                campaignTemplatePage.EnterDesiredValueTOLifeTimeFrequencyField("10001");
                campaignTemplatePage.ClickOnSaveAndActivateButton();
                if (!campaignTemplatePage.ValidateLifetimeFrequencyFieldAcceptingMoreThanMaximumValue()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Lifetime frequency field accepts more than maximum value without any error message while creating campaign template");
                    softAssert.fail("LifeTime frequency field is accepting more than maximum value without any error message");
                }
                campaignTemplatePage.EnterValueTODailyFrequencyField("Abcd%^$#@&");
                if (campaignTemplatePage.ValidateDailyFrequencyFieldAcceptingCharacters()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Daily frequency value accepts characters without any error message while creating campaign template");
                    softAssert.fail("daily frequency field is accepting characters without any error message");
                }
                campaignTemplatePage.SelectGuaranteedRadioButton();
                campaignTemplatePage.EnterValueTODailyFrequencyField("2.5");
                if (campaignTemplatePage.ValidateDailyFrequencyFieldAcceptingFloatValue()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Daily frequency field accepts float value without any error message while creating campaign template");
                    softAssert.fail("Daily frequency field is accepting float value without any error");
                }
                getDriver().navigate().refresh();
                campaignTemplatePage.EnterValueTODailyFrequencyField("-21");
                if (campaignTemplatePage.ValidateDailyFrequencyFieldAcceptingNegativeValue()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Daily frequency accepts Negative value without any error message while creating campaign template");
                    softAssert.fail("Daily frequency field is accepting negative value without any error");
                }
                getDriver().navigate().refresh();
                campaignTemplatePage.EnterValueTODailyFrequencyField("1001");
                campaignTemplatePage.ClickOnSaveAndActivateButton();
                if (!campaignTemplatePage.ValidateDailyFrequencyFieldAcceptingMoreThanMaximumValue()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Daily frequency accepts more than maximum value without any error message while creating campaign template");
                    softAssert.fail("Daily frequency field is accepting more than maximum value without any error message");
                }
                campaignTemplatePage.EnterValueTOBasePriceField("Abcd%^$#@&");
                if (campaignTemplatePage.ValidateBasePriceFieldAcceptingCharacters()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Base price accepts characters without any error message while creating campaign template");
                    softAssert.fail("Base price field is accepting characters without any error message");
                }
                campaignTemplatePage.SelectGuaranteedRadioButton();
                campaignTemplatePage.EnterValueTOBasePriceField("2.5");
                if (campaignTemplatePage.ValidateBasePriceFieldAcceptingFloatValue()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Base price accepts flot value without any error message while creating campaign template");
                    softAssert.fail("Base Price field is accepting float value without any error");
                }
                getDriver().navigate().refresh();
                campaignTemplatePage.EnterValueTOBasePriceField("-21");
                if (campaignTemplatePage.ValidateBasePriceFieldAcceptingNegativeValue()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Base price accepts negative value without any error message while creating campaign template");
                    softAssert.fail("Base Price field is accepting negative value without any error");
                }
//                campaignTemplatePage.ClickTargetDropdown();   //commented for staging-2
//                campaignTemplatePage.SelectDesiredTarget("1");
//                campaignTemplatePage.EnterValueToSurchargeField("Abcd%^$#@&");
//                if (campaignTemplatePage.ValidateSurchargeFieldAcceptingCharacters()) {
//                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Surcharge accepts characters without any error message while creating campaign template");
//                    softAssert.fail("Surcharge field is accepting characters without any error message");
//                }
//                campaignTemplatePage.SelectGuaranteedRadioButton();
//                campaignTemplatePage.EnterValueToSurchargeField("2.5");
//                if (campaignTemplatePage.ValidateSurchargeFieldAcceptingFloatValue()) {
//                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Surcharge accepts float value without any error message while creating campaign template");
//                    softAssert.fail("Surcharge field is accepting float value without any error");
//                }
//                getDriver().navigate().refresh();
//                Thread.sleep(2000);
//                campaignTemplatePage.ClickTargetDropdown();
//                campaignTemplatePage.SelectDesiredTarget("1");
//                campaignTemplatePage.EnterValueToSurchargeField("-25");
//                if (campaignTemplatePage.ValidateSurchargeFieldAcceptingNegativeValue()) {
//                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Surcharge field negative value acceptance without any error message while creating campaign template");
//                    softAssert.fail("Surcharge field is accepting Negative value without any error");
//                }
//                getDriver().navigate().refresh();
                campaignTemplatePage.ClickOnSaveAndActivateButton();
                if (!campaignTemplatePage.ValidateErrorMessagePopupAfterClickingSaveAndActivateButtonWithoutFillingAnyField()) {
                    softAssert.fail("Campaign template is created without filling mandatory fields");
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Campaign creation without filling any field");
                }
                campaignTemplatePage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                campaignTemplatePage.ClickOnSaveAsDraftButton();
                if (!campaignTemplatePage.ValidateErrorMessagePopupAfterClickingSaveAsDraftButtonWithoutFillingAnyField()) {
                    softAssert.fail("Campaign template is being saved as draft without filling mandatory fields while creating campaign template");
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Clicking Save as draft button without filling any field");
                }
                campaignTemplatePage.ClickingOnPopUpCloseButton();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));
    }
}