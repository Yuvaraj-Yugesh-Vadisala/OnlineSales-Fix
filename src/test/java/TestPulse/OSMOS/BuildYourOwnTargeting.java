package TestPulse.OSMOS;

import BaseClass.BaseTest;
import PagesPulse.OSMOS.BuildYourOwnTargetingPage;
import PagesPulse.OSMOS.Utility;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class BuildYourOwnTargeting extends BaseTest {
    private BuildYourOwnTargetingPage customtargetingpage;
    private Utility utils;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrl);
        customtargetingpage = new BuildYourOwnTargetingPage(getDriver());
        utils = new Utility(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "1e2f2aff7100c4ad50b185a1738aafd3");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }

    @BeforeMethod
    public void ResetPage() throws InterruptedException, AWTException {
        getDriver().navigate().to(OsmosPulseUrl);
        if (!Language.equals("en")) {
            utils.ChangeLanguage();
        }
    }
    @AfterClass
    public void TearDown() {
        getDriver().quit();
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Build Your Own Targeting- Key Value Setup")
    @Story("Key Value Setup-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: KeyValue Setup")
    public void KeyValueSetUp()   {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                utils.ClickOnControlCenterNavButton();
                customtargetingpage.ClickOnKeyValueSetup();
                Thread.sleep(2000);
                customtargetingpage.ClickOnCreateNewKeyIfEnabledOrDeleteOneKey(4);
                customtargetingpage.EnterKeyName("category", 5);
                customtargetingpage.EnterApiIdentifier("cat565614");
                customtargetingpage.AddValueFromExcel("50Values");
                Thread.sleep(1000);
                customtargetingpage.ClickOnAddValuesButton();
                Thread.sleep(1500);
                customtargetingpage.ClickOnIndividualValueDeleteButton();
                Thread.sleep(1500);
                customtargetingpage.ClickOnYesButton();
                customtargetingpage.ClickOnCreateButton();
                if (!customtargetingpage.ValidateSuccessfulKeyValueAddition()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Key value addition failed");
                    softAssert.fail("Key Value addition failed");
                }
                utils.ClickOnPopUpCloseButton();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Build Your Own Targeting- Key Value Setup")
    @Story("Key Value Setup - Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: KeyValue Setup - Negative")
    public void KeyValueSetUpNegativeFlow()   {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                utils.ClickOnControlCenterNavButton();
                customtargetingpage.ClickOnKeyValueSetup();
                Thread.sleep(1500);
                customtargetingpage.ClickOnCreateNewKeyIfEnabledOrDeleteOneKey(4);
                Thread.sleep(1000);
                customtargetingpage.ClickOnCreateButton();
                if (!customtargetingpage.ValidateErrorMessageForEmptyKeyName()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Without filling mandatory fields user is able to create the key value");
                    softAssert.fail("Without filling mandatory fields user is able to create the key value");
                }
                customtargetingpage.EnterKeyName("category", 5);
                customtargetingpage.EnterDesiredValues("test");
                Thread.sleep(500);
                customtargetingpage.ClickOnAddValuesButton();
                customtargetingpage.ClickOnCreateButton();
                if (!customtargetingpage.ValidateErrorMessageForEmptyField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Without adding API Identifier user can create key value");
                    softAssert.fail("Without adding API Identifier user can create key value");
                }
                customtargetingpage.EnterDesiredKeyName("        ");   //Adding spaces in the key name field
                customtargetingpage.EnterApiIdentifier("cat565614");
                customtargetingpage.ClickOnCreateButton();
                if (!customtargetingpage.ValidateErrorMessageForEmptyField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - The key is created with spaces only");
                    softAssert.fail("The key is created with spaces only");
                }
                customtargetingpage.ClickOnIndividualValueDeleteButton();
                Thread.sleep(1000);
                customtargetingpage.ClickOnYesButton();
                customtargetingpage.EnterKeyName("category", 35); //Adding KeyName More than 35 characters
                if (customtargetingpage.ValidateKeyNameFieldAcceptingMoreThan35Characters()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Key Name field accepts more than maximum char allowed");
                    softAssert.fail("Key Name field accepts more than maximum char allowed");
                }
                customtargetingpage.EnterApiIdentifier("$%^&$&&%$6");   // Entering invalid characters in api identifier
                customtargetingpage.ClickOnAddValuesButton();
                if (!customtargetingpage.ValidateErrorPopUpForEmptyValueField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User can add empty value ");
                    softAssert.fail("User can add empty value without any error message");
                }
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(1500);
                customtargetingpage.EnterDesiredValues("^&%^$&*");   //Entering special chars in value field
                Thread.sleep(1500);
                customtargetingpage.ClickOnAddValuesButton();
                if (!customtargetingpage.ValidateErrorPopUpForInvalidValueField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User can add values with special chars which are not allowed");
                    softAssert.fail("User can add values with special chars which are not allowed");
                }
                utils.ClickOnPopUpCloseButton();
                customtargetingpage.ClickOnCreateButton();
                if (!customtargetingpage.ValidateErrorMessageForInvalidApiIdentifier()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User can add api identifier with special character which are not allowed");
                    softAssert.fail("User can add api identifier with special character which are not allowed");
                }
                customtargetingpage.EnterDesiredApiIdentifier("            "); //Entering only spaces in api identifier
                customtargetingpage.ClickOnCreateButton();
                if (!customtargetingpage.ValidateErrorMessageForEmptyField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User can add api identifier with spaces only");
                    softAssert.fail("User can add api identifier with spaces only");
                }
                customtargetingpage.EnterApiIdentifier("cat6");
                customtargetingpage.AddValueFromExcel("50+Values");
                Thread.sleep(1000);
                customtargetingpage.ClickOnAddValuesButton();
                if (!customtargetingpage.ValidateErrorPopUpForMoreThanMaxValueField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User can add more than maximum value allowed values");
                    softAssert.fail("User can add more than maximum value allowed values");
                }
                utils.ClickOnPopUpCloseButton();
                customtargetingpage.EnterDesiredValues("       ");   //Entering only spaces in value field
                Thread.sleep(1500);
                customtargetingpage.ClickOnAddValuesButton();
                if (!customtargetingpage.ValidateErrorPopUpForSpacesInValueField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User can add values with only spaces");
                    softAssert.fail("User can add values with only spaces");
                }
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(4000);
                customtargetingpage.ClickOnCreateButton();
                if (!customtargetingpage.ValidateErrorPopUpForEmptyKeyValue()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User can add key value with empty value field");
                    softAssert.fail("User can add key value with empty value field");
                }
                utils.ClickOnPopUpCloseButton();

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Build Your Own Targeting- Targeting Setup")
    @Story("Targeting Setup-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Targeting Setup")
    public void TargetingSetUp()   {
        utils.RetryOnFailOsmosPulse((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            utils.ClickOnControlCenterNavButton();
            Thread.sleep(1000);
            customtargetingpage.ClickOnTargetingSetup();
            customtargetingpage.EnterTargetingName("Demographic Targeting");
            customtargetingpage.EnterTargetingDescription("With demographic targeting, you can reach a specific set of potential customers who are likely to be within a particular age range, gender, parental status, or household income.");
            customtargetingpage.SelectDesiredRadioButton(1);
            customtargetingpage.ClickTargetingSaveButton();
            if (!customtargetingpage.ValidateSuccessfulTargetingSetUp()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Targeting Setup failed");
                softAssert.fail("Targeting Setup failed");
            }
            utils.ClickOnPopUpCloseButton();
            customtargetingpage.EnterTargetingName("Custom Targeting");
            customtargetingpage.EnterTargetingDescription("Custom Targeting is used to target ads based on information gathered about visitors to your website or app.");
            customtargetingpage.SelectDesiredRadioButton(2);
            customtargetingpage.ClickTargetingSaveButton();
            utils.ClickOnPopUpCloseButton();
        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
         softAssert.assertAll();
        }));

    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Build Your Own Targeting- Targeting Setup")
    @Story("Targeting Setup-Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Targeting Setup-Negative Flow")
    public void TargetingSetUpNegativeFlow()  {
        utils.RetryOnFailOsmosPulse((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            utils.ClickOnControlCenterNavButton();
            Thread.sleep(1000);
            customtargetingpage.ClickOnTargetingSetup();
            customtargetingpage.EnterTargetingName("");    //Empty Name
            customtargetingpage.ClickTargetingSaveButton();
            if (!customtargetingpage.ValidateErrorMessageForEmptyTargetingNameValue()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - There are no error message for empty targeting name field");
                softAssert.fail("There are no error message for empty targeting name field");
            }
            customtargetingpage.EnterTargetingName("Custom Targeting");
            customtargetingpage.EnterTargetingDescription("");  //Empty Description
            customtargetingpage.ClickTargetingSaveButton();
            if (!customtargetingpage.ValidateErrorMessageForEmptyTargetingDescriptionValue()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - There are no error message for empty targeting description field");
                softAssert.fail("There are no error message for empty targeting description field");
            }
            customtargetingpage.EnterTargetingName("Aequeosalinocalcalinoceraceoaluminosocupreovitriolicvfdbfd");
            if (customtargetingpage.ValidateTargetingNameFieldAcceptingMoreThan50Characters()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Targeting Name field accepts more than maximum character allowed");
                softAssert.fail("Targeting Name field accepts more than maximum character allowed");
            }
            customtargetingpage.EnterTargetingDescription("With demographic targeting, you can reach a specific set of potential customers who are likely to be within a particular age range, gender, parental status, or household income potential customers who are likely to be within a particular age range, gender, parental status, or household income.");
            if (customtargetingpage.ValidateTargetingDescriptionFieldAcceptingMoreThan220Characters()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Targeting description field accepts more than maximum character allowed");
                softAssert.fail("Targeting description field accepts more than maximum character allowed");
            }
            customtargetingpage.EnterTargetingName("       ");    //Only spaces in Name field
            customtargetingpage.EnterTargetingDescription("Test");
            customtargetingpage.ClickTargetingSaveButton();
            if (!customtargetingpage.ValidateErrorMessageForEmptyTargetingNameValue()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - It accepts only spaces as targeting name input");
                softAssert.fail("It accepts only spaces as targeting name input");
            }
            customtargetingpage.EnterTargetingName("Custom Targeting1");
            customtargetingpage.EnterTargetingDescription("Custom Targeting is used to target ads based on information gathered about visitors to your website or apps.");
            customtargetingpage.ClickOnCreativeRemoveIcon();
            customtargetingpage.ClickTargetingSaveButton();
            if (!customtargetingpage.ValidateErrorMessageForEmptyCreative()) {
                utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User can create targeting setup with empty creative");
                softAssert.fail("User can create targeting setup with empty creative");
            }
            customtargetingpage.ClickOnUploadCreativeField();
            customtargetingpage.EnterCreativeTag("custom targeting");
            Thread.sleep(1500);
            customtargetingpage.SelectDesiredCreative();
            customtargetingpage.ClickOnChooseButton();
            Thread.sleep(1000);
            customtargetingpage.ClickTargetingSaveButton();
            utils.ClickOnPopUpCloseButton();
        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        }
        softAssert.assertAll();

        }));
    }
}