package TestPulse;

import BaseClass.BaseTest;
import PagesPulse.CampaignTemplatePage;
import PagesPulse.OrdersPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class OrdersPulse extends BaseTest {

    private OrdersPage ordersPage;
    private CampaignTemplatePage campaignTemplatePage;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(PulseUrl);
        ordersPage = new OrdersPage(getDriver());
        campaignTemplatePage = new CampaignTemplatePage(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "f968ddd03b493e94f7c70fa14e5c43d4");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }

    @BeforeMethod
    public void ResetPage() {
        getDriver().navigate().to(PulseUrl);
    }


        @AfterClass
    public void TearDown() {
        getDriver().quit();
    }


    @Epic("TVING PULSE - Admin Dashboard")
    @Feature("This flow belongs to All Order Flow")
    @Story("Order Edit - Positive Flow")
    @Test(timeOut=1200000,description = "Test: Validating comment section in created orders")
    public void AddingCommentToOrder() {
        campaignTemplatePage.RetryOnFailPulse((() ->
        {
            SoftAssert softAssert = new SoftAssert();
            try {
                if (!Language.equals("en")) {
                    campaignTemplatePage.ChangeLanguage();
                }
                ordersPage.ClickOnOrdersTemplateButton();
                Thread.sleep(1000);
                ordersPage.ClickOnAllOrdersButton();
                ordersPage.ClickOnMenuButton();
                ordersPage.ClickOnAddComments();
                ordersPage.EnterDataInCommentInputField("       ");
                ordersPage.ClickOnAddCommentButton();
                if (!ordersPage.IsCommentFieldErrorWarningDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Comment field error warning is not displayed after entering only spaces and clicking  on add comment");
                    softAssert.fail("Comment field error warning is not displayed after entering only spaces and clicking  on add comment");
                }

                ordersPage.EnterDataInCommentInputField("");
                ordersPage.ClickOnAddCommentButton();
                if (!ordersPage.IsCommentFieldErrorWarningDisplayed()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Comment field error warning is not displayed after clicking on add comment without any message");
                    softAssert.fail("Comment field error warning is not displayed after clicking on add comment without any message");
                }
                ordersPage.EnterDataInCommentInputField("Qa Testing");
                ordersPage.ClickOnAddCommentButton();
                if (!ordersPage.ValidateAddCommentSuccessPopUp()) {
                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Add comment success message is not displayed after adding comment");
                    softAssert.fail("Add comment success message is not displayed after adding comment");
                }
            } catch (Exception e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));

    }

    @Epic("TVING PULSE - Admin Dashboard")
    @Feature("This flow belongs to video creative library")
    @Story("Video reviewing - Happy flow")
    @Test(timeOut=1200000,description = "Test: Reviewing creative video library media")
    public void ReviewVideoCreativeLibrary() throws InterruptedException {
//        campaignTemplatePage.RetryOnFailPulse((() -> {
        SoftAssert softAssert = new SoftAssert();
        try {
            if (!Language.equals("en")) {
                campaignTemplatePage.ChangeLanguage();
            }
            ordersPage.ClickOnOrdersTemplateButton();
            Thread.sleep(1000);
            ordersPage.ClickOnVideoCreativeLibrary();
            Thread.sleep(3000);
            ordersPage.ClickOnSelectAdAccountField();
            ordersPage.EnterDataInAdAccountSearchField("AD_ACCOUNT_DEV");
            ordersPage.SelectAdAccountDropDown(1);  // Selects the first option from the ad account dropdown

            ordersPage.UploadingVideoInCreativeLibraryUploadField("1920✕1080px_Video.mp4");
            Thread.sleep(5000);
            ordersPage.SelectingCreativeLibraryVideo(1);
            ordersPage.ClickOnAddTagButton();
            ordersPage.SendKeysToAddTagInputField(ordersPage.TagName2);
            ordersPage.ClickOnAddTagSaveButton();
//                ordersPage.ClickOnAddTagSaveButton(); //duplicate
            ordersPage.EnterSearchTermInVideoCreativeLibrarySearchField(ordersPage.TagName2);
            Thread.sleep(2000);
//                ordersPage.ClickOnVideoPreviewSelector();
//                ordersPage.ClickOnMarkAsReviewedButton();
//                ordersPage.ClickOnYesButtonToConfirm();
//                ordersPage.ClickOnPopupCloseButton();
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
            ordersPage.ClickOnVideoCreativeLibrary();
            ordersPage.ClickOnSelectAdAccountField();
            ordersPage.EnterDataInAdAccountSearchField("AD_ACCOUNT_DEV");
            ordersPage.SelectAdAccountDropDown(1);  // Selects the first option from the ad account dropdown
            ordersPage.EnterSearchTermInVideoCreativeLibrarySearchField(ordersPage.TagName2);
            ordersPage.ClickOnVideoPreviewSelector();
            ordersPage.ClickOnUnMarkAsReviewedButton();
            ordersPage.ClickOnYesButtonToConfirm();
            ordersPage.ClickOnPopupCloseButton();
        } catch (InterruptedException e) {
            softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        softAssert.assertAll();

//        }));
    }
}

//    @Epic("TVING PULSE - Admin Dashboard")
//    @Feature("This flow belongs to video creative library")
//    @Story("Video reviewing - Happy flow")
//    @Test(timeOut=1200000,description = "Test: Reviewing creative video library media")
//    public void ReviewImageCreativeLibrary() throws InterruptedException {
//        campaignTemplatePage.RetryOnFailPulse((() -> {
//            SoftAssert softAssert = new SoftAssert();
//            try {
//                if (!Language.equals("en")) {
//                    campaignTemplatePage.ChangeLanguage();
//                }
//                ordersPage.ClickOnOrdersTemplateButton();
//                Thread.sleep(1000);
//                ordersPage.ClickOnImageCreativeLibrary();//added
//                Thread.sleep(3000);
//                ordersPage.ClickOnSelectAdAccountField();
//                ordersPage.EnterDataInAdAccountSearchField("AD_ACCOUNT_DEV");
//                ordersPage.SelectAdAccountDropDown(1);  // Selects the first option from the ad account dropdown
//
//                ordersPage.UploadingVideoInCreativeLibraryUploadField("1920✕1080px_Video.mp4");
//                Thread.sleep(5000);
//                ordersPage.SelectingCreativeLibraryVideo(1);
//                ordersPage.ClickOnAddTagButton();
//                ordersPage.SendKeysToAddTagInputField(ordersPage.TagName2);
//                ordersPage.ClickOnAddTagSaveButton();
////                ordersPage.ClickOnAddTagSaveButton(); //duplicate
//                ordersPage.EnterSearchTermInVideoCreativeLibrarySearchField(ordersPage.TagName2);
//                Thread.sleep(2000);
////                ordersPage.ClickOnVideoPreviewSelector();
////                ordersPage.ClickOnMarkAsReviewedButton();
////                ordersPage.ClickOnYesButtonToConfirm();
////                ordersPage.ClickOnPopupCloseButton();
//                if (!ordersPage.IsCreativeApproveStatusIconDisplayed()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative Approve Status Icon is not displayed when video is uploaded by admin");
//                    softAssert.fail("Creative Approve Status Icon is not displayed when video is uploaded by admin");
//                }
//                ordersPage.ClickOnCreativeApprovedStatusIcon();
//                ordersPage.ClickOnOrdersTemplateButton();
//                ordersPage.ClickOnAllOrdersButton();
//                ordersPage.EnterDataInOrdersTableSearchField("QATestingSJeZYj5OdP");
//                Thread.sleep(1000);
//                ordersPage.ClickOnMenuButton();
//                ordersPage.ClickOnEditButton();
//                ordersPage.ClickOnCreativeCardContainer();
//                ordersPage.ClickOnAddNewCreativeAddButton();
//
//                ordersPage.SelectingCreativeDetailsChooseFromLibraryButton(1);
//                ordersPage.EnterSearchTermInVideoCreativeLibrarySearchField(ordersPage.TagName2);
//                if (!ordersPage.ValidatingCreativeVideoApprovedByWhichUser()) {
//                    ordersPage.TakeScreenshotOnSoftAssertion("Soft Assertion - Creative Video is Approved By " + ordersPage.VideoApprovedUser + " But Shows different user name");
//                    softAssert.fail("Creative Video is Approved By " + ordersPage.VideoApprovedUser + " But Shows different user name");
//                }
//                ordersPage.ClickCrossButtonLevel2();
//                ordersPage.ClickCrossButtonLevel1();
//                ordersPage.ClickOnOrdersTemplateButton();
//                ordersPage.ClickOnVideoCreativeLibrary();
//                ordersPage.ClickOnSelectAdAccountField();
//                ordersPage.EnterDataInAdAccountSearchField("AD_ACCOUNT_DEV");
//                ordersPage.SelectAdAccountDropDown(1);  // Selects the first option from the ad account dropdown
//                ordersPage.EnterSearchTermInVideoCreativeLibrarySearchField(ordersPage.TagName2);
//                ordersPage.ClickOnVideoPreviewSelector();
//                ordersPage.ClickOnUnMarkAsReviewedButton();
//                ordersPage.ClickOnYesButtonToConfirm();
//                ordersPage.ClickOnPopupCloseButton();
//            } catch (InterruptedException e) {
//                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
//            } catch (AWTException e) {
//                throw new RuntimeException(e);
//            }
//            softAssert.assertAll();
//
//        }));
//    }
//}



