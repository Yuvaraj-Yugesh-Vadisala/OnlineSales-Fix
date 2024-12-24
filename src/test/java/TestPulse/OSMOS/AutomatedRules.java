package TestPulse.OSMOS;

import PagesPulse.OSMOS.*;
import BaseClass.BaseTest;

import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class AutomatedRules extends BaseTest {
    private PageSetupPage pageSetupPage;
    private InventorySetupPage inventorySetupPage;
    private WalletRulesPage walletRulesPage;
    private Utility utility;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrl);
        inventorySetupPage = new InventorySetupPage(getDriver());
        pageSetupPage = new PageSetupPage(getDriver());
        walletRulesPage = new WalletRulesPage(getDriver());
        utility = new Utility(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "1e2f2aff7100c4ad50b185a1738aafd3");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }

    @BeforeMethod
    public void ResetPage(ITestResult result) throws InterruptedException, AWTException {
        getDriver().navigate().to(OsmosPulseUrl);
        if (!Language.equals("en")) {
            utility.ChangeLanguage();
        }
         System.out.println("Thread ID: " + Thread.currentThread().getId()+ " - Started @Test: " + result.getMethod().getMethodName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Finished @Test: " + result.getMethod().getMethodName());
    }

    @AfterClass
    public void TearDown() {
        getDriver().quit();
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Wallet Rules Set Up")
    @Story("Wallet Rules Creation- Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Validate all fields while creating new Wallet Rules")
    public void CreateWalletRules()   {
//        utility.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                pageSetupPage.ClickOnControlCenterNavButton();
                walletRulesPage.ClickOnPageSetUp();
                walletRulesPage.ClickOnAddPageButton();
                walletRulesPage.EnterWalletName("QaTesting", 5, "text");
                walletRulesPage.EnterDataInWalletDescriptionField("Sample Data about Wallet");
                walletRulesPage.ClickOnScheduleRadioButton();
                walletRulesPage.ClickingOnYesButton();
                walletRulesPage.ClickOnLookBackPeriodField();
                walletRulesPage.EnterDataInLookBackPeriodSearchFieldField("15 Days");
                walletRulesPage.ClickOnGenericOptionsSelector(1);
                Thread.sleep(2000);
                walletRulesPage.ClickingOnActionsConditionField();
                walletRulesPage.EnterDataInActionsConditionSearchField("Add");
                walletRulesPage.ClickOnGenericOptionsSelector(1);
                walletRulesPage.EnterDataInActionsAmountField("100");
                walletRulesPage.EnterDataInActionsDescriptionField("Wallet Sample Data");
                walletRulesPage.ClickingOnSchedulePeriodField();
                walletRulesPage.ClickOnGenericOptionsSelector(4);
                walletRulesPage.ClickingOnScheduleDayField();
                walletRulesPage.EnterDataInScheduleDaySearchField("Monday");
                Thread.sleep(1000);
                walletRulesPage.ClickOnGenericOptionsSelector(1);
                walletRulesPage.ClickingOnScheduleTimeField();
                walletRulesPage.ClickOnSelectTimeHourDropDown(2);
                walletRulesPage.ClickOnSelectTimeMinuteDropDown(2);
                walletRulesPage.ClickingOnNotifyMeField();
                walletRulesPage.EnterDataInNotifyMeSearchField("Custom");
                walletRulesPage.ClickOnGenericOptionsSelector(1);
                walletRulesPage.EnterDataInNotifyMeGmailField("rajesh@frugaltestingin.com");
                walletRulesPage.ClickEnterIcon();
                walletRulesPage.ClickWalletCreateButton();
                pageSetupPage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                inventorySetupPage.EnterDataInTableSearchField(walletRulesPage.WalletName);
                Thread.sleep(2000);
                if (!walletRulesPage.ValidatingCreatedWalletRule()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Created wallet rule is not present in the table");
                    softAssert.fail("Created wallet rule is not present in the table");
                }
                softAssert.assertAll();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
//        }));
    }


    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Wallet Rules Set Up")
    @Story("Wallet Rules Creation- Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Validate all fields while creating new Wallet Rules")
    public void ValidateAllFieldsWhileCreatingNewWalletRules() throws InterruptedException {
//        utility.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                pageSetupPage.ClickOnControlCenterNavButton();
                walletRulesPage.ClickOnPageSetUp();
                walletRulesPage.ClickOnAddPageButton();
                walletRulesPage.ClickWalletCreateButton();
                pageSetupPage.ClickingOnPopUpCloseButton();
                if (!walletRulesPage.ValidateWalletNameFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when wallet Name is empty on saving");
                    softAssert.fail("No error message displayed when wallet Name is empty on saving");
                }
                if (!walletRulesPage.ValidateWalletDescriptionFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when wallet description is empty on saving");
                    softAssert.fail("No error message displayed when wallet description is empty on saving");
                }
                walletRulesPage.EnterSpacesInWalletNameField("      ");
                if (!walletRulesPage.ValidateWalletNameFieldAcceptsOnlySpaces()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Wallet Name field accepts only spaces as input.");
                    softAssert.fail("Wallet Name field accepts only spaces as input.");
                }
                walletRulesPage.EnterMoreThan50CharactersInWalletNameField();
                if (walletRulesPage.ValidateWalletNameFieldAcceptingMoreThan50Characters()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Wallet name field is accepting more than 50 characters.");
                    softAssert.fail("Wallet name field is accepting more than 50 characters.");
                }
//                walletRulesPage.EnterDataInWalletDescriptionField("        ");
//                if (walletRulesPage.ValidateWalletDescriptionFieldAcceptsOnlySpaces()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Wallet description field accepts only spaces as input.");
//                    softAssert.fail("Wallet description field accepts only spaces as input.");
//                }
                walletRulesPage.EnterDataInWalletDescriptionField("Sample Data about Wallet");
                walletRulesPage.ClickingOnRuleTypeField();
                walletRulesPage.EnterDataInWalletRuleTypeSearchField("On");
                walletRulesPage.ClickOnGenericOptionsSelector(1);
                walletRulesPage.ClickingOnYesButton();
                walletRulesPage.ClickOnLookBackPeriodField();
                walletRulesPage.EnterDataInLookBackPeriodSearchFieldField("15 Days");
                walletRulesPage.ClickOnGenericOptionsSelector(1);
                walletRulesPage.ClickWalletCreateButton();
                pageSetupPage.ClickingOnPopUpCloseButton();
                if (!walletRulesPage.ValidateWalletActionDescriptionFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when wallet action description is empty on saving");
                    softAssert.fail("No error message displayed when wallet action description is empty on saving");
                }
                if (!walletRulesPage.ValidateWalletActionValueFieldEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - No error message displayed when wallet action value is empty on saving");
                    softAssert.fail("No error message displayed when wallet action value is empty on saving");
                }
//                walletRulesPage.EnterDataInActionsDescriptionField("    ");
//                walletRulesPage.ClickWalletCreateButton();
//                if (walletRulesPage.ValidateWalletActionsDescriptionFieldAcceptsOnlySpaces()) {
//                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Wallet actions description field accepts only spaces as input.");
//                    softAssert.fail("Wallet actions description field accepts only spaces as input.");
//                }
                walletRulesPage.EnterDataInActionsDescriptionField("Sample Wallet Data");
                walletRulesPage.EnterDataInActionsAmountField("abcd");
                if (walletRulesPage.ValidateWalletActionsValueFieldAcceptingCharacters("abcd")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Wallet actions value field is accepting characters.");
                    softAssert.fail("Wallet actions value field is accepting characters.");
                }
                walletRulesPage.EnterDataInActionsAmountField("-100");
                if (walletRulesPage.ValidateWalletActionsValueFieldAcceptingCharacters("-100")) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Wallet actions value field is accepting negative value.");
                    softAssert.fail("Wallet actions value field is accepting negative value.");
                }
                walletRulesPage.EnterDataInActionsAmountField("100");
                walletRulesPage.ClickingOnNotifyMeField();
                walletRulesPage.EnterDataInNotifyMeSearchField("Custom");
                walletRulesPage.ClickOnGenericOptionsSelector(1);
                walletRulesPage.ClickingOnSavedMailRemoveIcon();
                if (!walletRulesPage.ValidateEmptyMailErrorMessageDisplayed()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Empty mail error message not displayed on saving.");
                    softAssert.fail("Empty mail error message not displayed on saving.");
                }
                walletRulesPage.EnterDataInNotifyMeGmailField("      ");
                walletRulesPage.ClickEnterIcon();
                if (!walletRulesPage.ValidateInvalidMailPopUpDisplayed()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid mail error pop up not displayed on saving with invalid mail.");
                    softAssert.fail("Invalid mail error pop up not displayed on saving with invalid mail.");
                }
//                pageSetupPage.ClickingOnPopUpCloseButton();
                walletRulesPage.EnterDataInNotifyMeGmailField("@gmail.com");
                walletRulesPage.ClickEnterIcon();
                if (!walletRulesPage.ValidateInvalidMailPopUpDisplayed()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid mail error pop up not displayed on saving with invalid mail.");
                    softAssert.fail("Invalid mail error pop up not displayed on saving with invalid mail.");
                }
                pageSetupPage.ClickingOnPopUpCloseButton();
                walletRulesPage.EnterDataInNotifyMeGmailField("rajesh@gma il.com");
                walletRulesPage.ClickEnterIcon();
                if (!walletRulesPage.ValidateInvalidMailPopUpDisplayed()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid mail error pop up not displayed on saving with invalid mail.");
                    softAssert.fail("Invalid mail error pop up not displayed on saving with invalid mail.");
                }
                pageSetupPage.ClickingOnPopUpCloseButton();
                walletRulesPage.EnterDataInNotifyMeGmailField("-@gmail.com");
                walletRulesPage.ClickEnterIcon();
                if (walletRulesPage.ValidateInvalidMailIsAcceptingInSavedTags()) {    //rename this method
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Invalid mail is accepting in mail saved tags.");
                    softAssert.fail("Invalid mail id is being accepted  in mail saved tags.");
                }
                walletRulesPage.EnterDataInNotifyMeGmailField("rajesh@frugaltestingin.com");
                walletRulesPage.ClickEnterIcon();
                walletRulesPage.ClickOnScheduleRadioButton();
                walletRulesPage.ClickingOnYesButton();
                walletRulesPage.EnterDataInActionsAmountField("100");
                walletRulesPage.EnterDataInActionsDescriptionField("Sample Wallet Data");
                walletRulesPage.ClickWalletCreateButton();
                if (!walletRulesPage.ValidateSelectADateEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Select a date empty error message is not displayed on clicking save.");
                    softAssert.fail("Select a date empty error message is not displayed on clicking save");
                }
                utility.ClickOnPopUpCloseButton();
                if (!walletRulesPage.ValidateSelectTimeEmptyErrorMessage()) {
                    pageSetupPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Select time empty error message is not displayed on clicking save.");
                    softAssert.fail("Select time empty error message is not displayed on clicking save");
                }
                walletRulesPage.ClickingOnSchedulePeriodField();
                walletRulesPage.ClickOnGenericOptionsSelector(4);
                walletRulesPage.ClickingOnScheduleDayField();
                walletRulesPage.EnterDataInScheduleDaySearchField("Monday");
                Thread.sleep(1000);
                walletRulesPage.ClickOnGenericOptionsSelector(1);
                walletRulesPage.ClickingOnScheduleTimeField();
                walletRulesPage.ClickOnSelectTimeHourDropDown(2);
                walletRulesPage.ClickOnSelectTimeMinuteDropDown(2);
                softAssert.assertAll();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
//        }));
    }
}
