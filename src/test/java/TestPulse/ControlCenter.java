package TestPulse;

import BaseClass.BaseTest;
import PagesPulse.CampaignTemplatePage;
import PagesPulse.ControlCenterPage;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class ControlCenter extends BaseTest {

    private ControlCenterPage controlcenterpage;
    private CampaignTemplatePage campaignTemplatePage;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(PulseUrl);
        controlcenterpage = new ControlCenterPage(getDriver());
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
        if (!Language.equals("en")) {
            controlcenterpage.ChangeLanguage();
        }

    }

    @AfterClass
    public void TearDown() {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Finished: " + this.getClass().getName());
        getDriver().quit();
    }

    @Epic("TVING PULSE - Admin Dashboard")
    @Feature("This flow belongs to Control Center")
    @Story("Control Center-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Add and Delete AdOps User")
    public void AddAndDeleteAdOpsUser() throws InterruptedException {
        campaignTemplatePage.RetryOnFailPulse((() ->
        {
            SoftAssert softAssert = new SoftAssert();
            try {
                controlcenterpage.ClickOnControlCenterButton();
                controlcenterpage.ClickOnAdOpsUser();
                controlcenterpage.ClickOnAddNewUser();
                controlcenterpage.AddingDesiredUserName();
                controlcenterpage.SelectingDesiredAccessRole(3);
                controlcenterpage.AddingUserEmail();
                controlcenterpage.ClickingAddButton();
                controlcenterpage.ClickingOnPopUpCloseButton();
                Thread.sleep(2000);
                controlcenterpage.AddingTextInUserSearchField();
                Thread.sleep(2000);
                if (controlcenterpage.ValidateSuccessfulAdditionOfNewUser()) {
                    controlcenterpage.TakeScreenshotOnSoftAssertion("Soft Assertion - User creation failed");
                    softAssert.fail("User creation failed");
                }
                Thread.sleep(1500);
                controlcenterpage.SelectingDesiredAccessRoleInTable(2);
                Thread.sleep(1500);
                controlcenterpage.ClickYesButtonToAccessRoleChange();
                Thread.sleep(1500);
                getDriver().navigate().refresh();
                controlcenterpage.AddingTextInUserSearchField();
                Thread.sleep(1500);
                controlcenterpage.ClickingDeleteUserButton();
                Thread.sleep(2000);
                controlcenterpage.ClickYesButtonToConfirmDeletion();
                controlcenterpage.ClickingOnPopUpCloseButton();
//                controlcenterpage.ClickOnSettingsButton();
//                controlcenterpage.ClickOnLogOutButton();    //disabled logout because UA token changes for every logout
//                if (controlcenterpage.ValidateVisibilityOfLogInButton()) {
//                    controlcenterpage.TakeScreenshotOnSoftAssertion("Soft Assertion - Log out failed");
//                    softAssert.fail("Logout failed");
//                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));
    }

    @Epic("TVING PULSE - Admin Dashboard")
    @Feature("This flow belongs to Control Center")
    @Story("Control Center-Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Test: Add and Delete AdOps User")
    public void ValidateAllFieldsWhileCreatingNewAdOpsUser() throws InterruptedException {
        campaignTemplatePage.RetryOnFailPulse((() ->
        {
            SoftAssert softAssert = new SoftAssert();
            try {
                controlcenterpage.ClickOnControlCenterButton();
                controlcenterpage.ClickOnAdOpsUser();
                controlcenterpage.ClickOnAddNewUser();
                controlcenterpage.EnterDesiredTextInUserNameField("     ");
                controlcenterpage.SelectingDesiredAccessRole(3);
                controlcenterpage.AddingUserEmail();
                controlcenterpage.ClickingAddButton();
                if (!controlcenterpage.ValidateErrorMessageForAddingSpacesInUserNameField()) {
                    controlcenterpage.TakeScreenshotOnSoftAssertion("Soft Assertion - User name field accepts spaces without any error message while adding a new user");
                    softAssert.fail("user name field accepts spaces without any error message");
                }
                getDriver().navigate().refresh();
                controlcenterpage.ClickOnAddNewUser();
                controlcenterpage.SelectingDesiredAccessRole(3);
                controlcenterpage.AddingUserEmail();
                controlcenterpage.ClickingAddButton();
                if (!controlcenterpage.ValidateErrorMessageAfterClickingAddButtonWithoutFillingUserNameField()) {
                    controlcenterpage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to create a user without filling username field while adding a new user");
                    softAssert.fail("User is able to create a new user without filling username field");
                }
                getDriver().navigate().refresh();
                controlcenterpage.ClickOnAddNewUser();
                controlcenterpage.AddingDesiredUserName();
                controlcenterpage.AddingUserEmail();
                controlcenterpage.ClickingAddButton();
                if (!controlcenterpage.ValidateErrorMessageForAccessRoleField()) {
                    controlcenterpage.TakeScreenshotOnSoftAssertion("Soft Assertion - Clicking add button without selecting any access role while creating a new user");
                    softAssert.fail("User is able to create a new user without selecting any access role");
                }
                getDriver().navigate().refresh();
                controlcenterpage.ClickOnAddNewUser();
                controlcenterpage.AddingDesiredUserName();
                controlcenterpage.SelectingDesiredAccessRole(3);
                controlcenterpage.ClickingAddButton();
                if (!controlcenterpage.ValidateErrorMessageForEmailField()) {
                    controlcenterpage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to create a new user without adding user email While adding a new user");
                    softAssert.fail("User is able to create a new user without adding user email");
                }
                getDriver().navigate().refresh();
                Thread.sleep(500);
                controlcenterpage.ClickOnAddNewUser();
                controlcenterpage.AddingDesiredUserName();
                controlcenterpage.SelectingDesiredAccessRole(3);
                controlcenterpage.EnterDesiredUserEmail("    ");
                controlcenterpage.ClickingAddButton();
                if (!controlcenterpage.ValidateErrorMessageForEmailField()) {
                    controlcenterpage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to create a new user with spaces in email field While adding a new user");
                    softAssert.fail("User is able to create a new user with spaces in email field without any error message");
                }
                controlcenterpage.EnterDesiredUserEmail("@example.com");
                controlcenterpage.ClickingAddButton();
                if (!controlcenterpage.ValidateErrorMessageForAddingInvalidEmailId()) {
                    controlcenterpage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to create a new user with invalid  email  While adding a new user");
                    softAssert.fail("User is able to create a new user with invalid email without any error message");
                }
                getDriver().navigate().refresh();
                controlcenterpage.ClickOnAddNewUser();
                controlcenterpage.AddingDesiredUserName();
                controlcenterpage.SelectingDesiredAccessRole(3);
                controlcenterpage.EnterDesiredUserEmail("rajesh@frugaltestingin.com");
                controlcenterpage.ClickingAddButton();
                if (!controlcenterpage.ValidateErrorMessageForAddingExistingUser()) {
                    controlcenterpage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to add an existing user While adding a new user");
                    softAssert.fail("User is able to add an existing user without any error message");
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));
    }
}