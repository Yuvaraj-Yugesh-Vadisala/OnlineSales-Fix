package TestPulse.OSMOS;

import BaseClass.BaseTest;
import PagesPulse.OSMOS.ProductAdsYieldControlPage;
import PagesPulse.OSMOS.Utility;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class ProductAdsYieldControl extends BaseTest {
    private ProductAdsYieldControlPage productAdsPage;
    private Utility utils;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrl);
        utils = new Utility(getDriver());
        productAdsPage = new ProductAdsYieldControlPage(getDriver());
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
            utils.ChangeLanguage();
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
    @Feature("This flow belongs to Product Ads Yield Control")
    @Story("Product Ads Yield Control-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Product Ads Yield Control - Positive")
    public void ProductAdsYieldControlPositiveFlow()   {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                utils.ClickOnControlCenterNavButton();
                Thread.sleep(1000);
                productAdsPage.ClickOnProductAdsYieldControl();
                productAdsPage.EnterDefaultFloorBidValue("10");
                productAdsPage.EnterDefaultCeilingBidValue("15");
                productAdsPage.EnterDefaultBidMultiplierValue("5");
                productAdsPage.ClickOnCheckBox(1);
                Thread.sleep(1000);
                productAdsPage.ClickOnUpdateBidDropdown();
                productAdsPage.SelectDesiredBidOption(2);
                productAdsPage.EnterUpdateValue("10");
                productAdsPage.ClickDoneButton();
                productAdsPage.ClickYesButton();
                productAdsPage.ClickOnCheckBox(1);
                Thread.sleep(1000);
                productAdsPage.ClickOnUpdateBidDropdown();
                productAdsPage.SelectDesiredBidOption(2);
                productAdsPage.ClickOnUpdateTypeDropdown();
                productAdsPage.SelectDesiredUpdateType(2);
                productAdsPage.SelectPercentTypeRadio();
                productAdsPage.EnterUpdateValue("10");
                productAdsPage.ClickDoneButton();
                productAdsPage.ClickYesButton();
                productAdsPage.ClickOnCheckBox(1);
                Thread.sleep(1000);
                productAdsPage.ClickOnResetBidDropdown();
                productAdsPage.SelectDesiredBidOption(2);
                productAdsPage.ClickYesButton();
                utils.ClickOnChangeLogButton();
                if (!utils.ValidateVisibilityOfChangeLogPage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Change logs page is not displayed");
                    softAssert.fail("Change logs page is not displayed");
                }
                utils.ClickOnCrossButton();
                productAdsPage.ClickOnReviewAndApplyButton();
                productAdsPage.ClickProductAdsYieldApplyButton();
                productAdsPage.ClickYesButton();
                if (!productAdsPage.ValidateVisibilityOfSuccessPopUp()) {
                    utils.TakeScreenshotOnSoftAssertion("SoftAssert - application of product ads yield failed");
                    softAssert.fail("Application of product ads yield failed");
                }
                utils.ClickOnPopUpCloseButton();
                productAdsPage.EnterIndividualFloorBidValue("2");
                productAdsPage.EnterIndividualCeilingBidValue("4");
                productAdsPage.EnterIndividualBidMultiplierValue("9");
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Product Ads Yield Control")
    @Story("Product Ads Yield Control-Negative Flow")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut=1200000,description = "Test: Product Ads Yield Control - Negative")
    public void ProductAdsYieldControlNegativeFlow()   {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                utils.ClickOnControlCenterNavButton();
                Thread.sleep(1000);
                productAdsPage.ClickOnProductAdsYieldControl();
                productAdsPage.ClickOnReviewAndApplyButton();
                if (!productAdsPage.ValidateVisibilityOfDisabledApplyButton()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Apply button is enabled even user didn't change any bid value");
                    softAssert.fail("Apply button is enabled even user didn't change any bid value");
                }
                productAdsPage.ClickCloseButton();
                productAdsPage.EnterDefaultFloorBidValue("10");
                productAdsPage.EnterDefaultCeilingBidValue("5");    //entering less value than floor bid value
                productAdsPage.EnterDefaultBidMultiplierValue("5");
                productAdsPage.ClickOnReviewAndApplyButton();
                if (!productAdsPage.ValidateErrorMessageForBidFields()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Default floor bid accepts more value than default ceiling bid without any error message");
                    softAssert.fail("Default floor bid accepts more value than default ceiling bid without any error message");
                }
                utils.ClickOnPopUpCloseButton();
                productAdsPage.EnterDefaultCeilingBidValue("15");
                productAdsPage.EnterDefaultBidMultiplierValue("0.4");  //less than min value i.e - 0.5
                if (!productAdsPage.ValidateErrorMessageForMultiplierBidField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Default multiplier bid field less value than 0.5 without any error message");
                    softAssert.fail("Default multiplier bid field less value than 0.5 without any error message");
                }
                productAdsPage.EnterDefaultCeilingBidValue("15");    //entering less value than floor bid value
                productAdsPage.EnterDefaultBidMultiplierValue("11"); //more than maximum value i.e-10
                if (!productAdsPage.ValidateErrorMessageForMultiplierBidField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Default multiplier bid field more value than 10 without any error message");
                    softAssert.fail("Default multiplier bid field more value than 10 without any error message");
                }
                productAdsPage.EnterDefaultFloorBidValue("-8");
                if (!productAdsPage.ValidateDefaultFloorBidFieldWithNegativeValue()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Default floor bid field accepts Negative values without any error message");
                    softAssert.fail("Default floor bid field accepts Negative values without any error message");
                }
                productAdsPage.EnterDefaultCeilingBidValue("-10");
                if (!productAdsPage.ValidateDefaultCeilingBidFieldWithNegativeValue()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Default Ceiling bid field accepts Negative values without any error message");
                    softAssert.fail("Default Ceiling bid field accepts Negative values without any error message");
                }
                productAdsPage.EnterDefaultBidMultiplierValue("11");
                if (!productAdsPage.ValidateDefaultBidMultiplierFieldWithNegativeValue()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Default Bid multiplier field accepts Negative values without any error message");
                    softAssert.fail("Default Bid multiplier field accepts Negative values without any error message");
                }
                productAdsPage.EnterDefaultFloorBidValue("HGFGFFJHJGH!@#$%^&*(&^)");
                if (!productAdsPage.ValidateDefaultFloorBidFieldWithSpecialCharactersAndAlphabets()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Default floor bid field accepts Special char and alphabets  without any error message");
                    softAssert.fail("Default floor bid field accepts Special char and alphabets without any error message");
                }
                productAdsPage.EnterDefaultCeilingBidValue("HGFGFFJHJGH!@#$%^&*(&^)");
                if (!productAdsPage.ValidateDefaultCeilingBidFieldWithSpecialCharactersAndAlphabets()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Default Ceiling bid field accepts Special char and alphabets without any error message");
                    softAssert.fail("Default Ceiling bid field accepts Special char and alphabets without any error message");
                }
                productAdsPage.EnterDefaultBidMultiplierValue("HGFGFFJHJGH!@#$%^&*(&^)");
                if (!productAdsPage.ValidateDefaultBidMultiplierFieldWithSpecialCharactersAndAlphabets()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Default Bid multiplier field accepts Special char and alphabets without any error message");
                    softAssert.fail("Default Bid multiplier field accepts Special char and alphabets without any error message");
                }
                productAdsPage.EnterIndividualFloorBidValue("5");
                productAdsPage.EnterIndividualCeilingBidValue("4");
                if (!productAdsPage.ValidateErrorMessageForCeilingBidBeingLessThanFloorBid()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User can enter ceiling value less than floor bid without getting error message");
                    softAssert.fail("User can enter ceiling value less than floor bid without getting error message");
                }
                utils.ClickOnPopUpCloseButton();
                productAdsPage.EnterIndividualCeilingBidValue("10");
                productAdsPage.ClickOnCheckBox(1);
                Thread.sleep(1000);
                productAdsPage.ClickOnResetBidDropdown();
                productAdsPage.SelectDesiredBidOption(2);
                productAdsPage.ClickYesButton();
                productAdsPage.EnterIndividualBidMultiplierValue("15");
                productAdsPage.EnterIndividualFloorBidValue("0");  //added this step because the tool tip is covering the individual bid multiplier field
                if (!productAdsPage.ValidateErrorMessageForMultiplierBidField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Individual bid multiplier Field accepts more than maximum value");
                    softAssert.fail("Individual bid multiplier Field accepts more than maximum value");
                }
                utils.ClickOnPopUpCloseButton();
                productAdsPage.EnterIndividualFloorBidValue("-8");
                if (!productAdsPage.ValidateIndividualFloorBidNotAcceptingNegativeValue()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Individual floor bid value accepts -ve values without any error message");
                    softAssert.fail(" Individual floor bid value accepts -ve values without any error message");
                }
                productAdsPage.EnterIndividualCeilingBidValue("-8");
                if (!productAdsPage.ValidateIndividualCeilingBidNotAcceptingNegativeValue()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion -  Individual ceiling bid value accepts -ve values without any error message");
                    softAssert.fail("Individual ceiling bid value accepts -ve values without any error message");
                }
                productAdsPage.EnterIndividualBidMultiplierValue("-5");
                if (!productAdsPage.ValidateIndividualBidMultiplierNotAcceptingNegativeValue()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Individual bid multiplier value accepts -ve values without any error message");
                    softAssert.fail("Individual bid multiplier value accepts -ve values without any error message");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));

    }
}
