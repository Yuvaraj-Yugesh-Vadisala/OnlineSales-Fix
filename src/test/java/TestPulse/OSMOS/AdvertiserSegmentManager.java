package TestPulse.OSMOS;

import BaseClass.BaseTest;
import PagesPulse.CampaignTemplatePage;
import PagesPulse.OSMOS.SegmentManagerPage;
import PagesPulse.OSMOS.Utility;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class AdvertiserSegmentManager extends BaseTest {
    private CampaignTemplatePage campaignTemplatePage;
    private SegmentManagerPage segmentManagerPage;
    private Utility utils;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrl);
        segmentManagerPage = new SegmentManagerPage(getDriver());
        campaignTemplatePage = new CampaignTemplatePage(getDriver());
        utils = new Utility(getDriver());
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

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Advertiser Segment Manager")
    @Story("Advertiser Segment Manager - Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut = 10000,description = "Test: Advertiser Segment Manager - Positive")
    public void AdvertiserSegmentMangerPositiveFlow()  {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                utils.ClickOnControlCenterNavButton();
                segmentManagerPage.ClickOnAdvertiserSegmentManager();
                segmentManagerPage.ClickOnAdNewSegmentButton();
                segmentManagerPage.EnterSegmentName("TestQA", 3);
                Thread.sleep(1000);
                segmentManagerPage.SelectEveryOneToggle();
                segmentManagerPage.ClickOnAddSegmentElementButton();
                segmentManagerPage.SelectDesiredSegmentOption(1);
                Thread.sleep(1000);
                segmentManagerPage.ClickOnCrossIcon();
                segmentManagerPage.ClickOnAddSegmentElementButton();
                segmentManagerPage.EnterDesiredElementName("Ad Impressions Last 7 days");
                segmentManagerPage.SelectDesiredSegmentOption(1);
                segmentManagerPage.ClickOnConditionDropdown();
                segmentManagerPage.SelectDesiredSegmentCondition(3);
                segmentManagerPage.EnterSegmentValue("100");
                segmentManagerPage.ClickOnSegmentSaveButton();
                if (!segmentManagerPage.ValidateVisibilityOfSuccessPopUp()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - segment creation failed");
                    Assert.fail("segment creation failed");
                }
                utils.ClickOnPopUpCloseButton();
                segmentManagerPage.ClickOnThreeDots(1);
                Thread.sleep(500);
                segmentManagerPage.ClickOnSegmentEditButton();
                if (!segmentManagerPage.ValidateVisibilityEditPage()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - Edit page is not visible");
                    softAssert.fail("Edit page is not visible");
                }
                utils.ClickOnCrossButton();
                segmentManagerPage.ClickOnThreeDots(1);
                segmentManagerPage.ClickOnSegmentDuplicateButton();
                segmentManagerPage.ClickOnSegmentSaveButton();
                if (!segmentManagerPage.ValidateVisibilityOfSuccessPopUp()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - segment duplication failed");
                    softAssert.fail("segment duplication failed");
                }
                utils.ClickOnPopUpCloseButton();
                segmentManagerPage.ClickOnThreeDots(1);
                segmentManagerPage.ClickOnMerchantDownloadButton();
                utils.ClickOnPopUpCloseButton();
                segmentManagerPage.ClickOnDownloadButton();
                //popup is not there to verify
                //verification

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Advertiser Segment Manager")
    @Story("Advertiser Segment Manager - Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut = 10000,description = "Test: Advertiser Segment Manager - Negative")
    public void AdvertiserSegmentMangerNegativeFlow() {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                utils.ClickOnControlCenterNavButton();
                segmentManagerPage.ClickOnAdvertiserSegmentManager();
                segmentManagerPage.ClickOnAdNewSegmentButton();
                segmentManagerPage.EnterSegmentName("         ");
                Thread.sleep(1000);
                segmentManagerPage.SelectEveryOneToggle();
                segmentManagerPage.ClickOnAddSegmentElementButton();
                segmentManagerPage.EnterDesiredElementName("Ad Impressions Last 7 days");
                segmentManagerPage.SelectDesiredSegmentOption(1);
                segmentManagerPage.ClickOnConditionDropdown();
                segmentManagerPage.SelectDesiredSegmentCondition(3);
                segmentManagerPage.EnterSegmentValue("100");
                segmentManagerPage.ClickOnSegmentSaveButton();
                if (!segmentManagerPage.ValidateErrorMessageForEmptyField()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - segment is being created with only spaces in segment name");
                    Assert.fail("segment is being created with only spaces in segment name");
                }
                utils.ClickOnPopUpCloseButton();
                utils.ClickOnCrossButton();
                segmentManagerPage.ClickOnAdNewSegmentButton();
                segmentManagerPage.ClickOnSegmentSaveButton();
                if (!segmentManagerPage.ValidateErrorMessageForSegmentNameField()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - segment is being created with empty segment name");
                    Assert.fail("segment  is being created with empty segment name");
                }
                utils.ClickOnPopUpCloseButton();
                segmentManagerPage.EnterSegmentName("TestQA");
                segmentManagerPage.ClickOnSegmentSaveButton();
                if (!segmentManagerPage.ValidateErrorMessageForSegmentElement()) {
                    campaignTemplatePage.TakeScreenshotOnSoftAssertion("Soft Assertion - segment creation is being Without selecting any segment element");
                    Assert.fail("segment creation is being Without selecting any segment element");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));
    }


}
