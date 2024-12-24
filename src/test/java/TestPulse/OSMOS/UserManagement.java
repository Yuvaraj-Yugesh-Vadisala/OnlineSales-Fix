package TestPulse.OSMOS;

import BaseClass.BaseTest;
import PagesPulse.OSMOS.UserManagementPage;
import PagesPulse.OSMOS.Utility;
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

public class UserManagement extends BaseTest {
    private UserManagementPage userManagementPage;
    private Utility utils;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrl);
        userManagementPage = new UserManagementPage(getDriver());
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
    @Feature("This flow belongs to User Management- Super Admin Users")
    @Story("Super Admin Operations-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Super Admin Operations")
    public void SuperAdminOperations()   {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                utils.ClickOnControlCenterNavButton();
                userManagementPage.ClickOnSuperAdminUsers();
                userManagementPage.ClickOnAddNewUser();
                userManagementPage.EnterName("randomdata", 3);
                userManagementPage.EnterEmail("mail", 8);
                userManagementPage.ClickOnAddUserForSuperAdmin();
                userManagementPage.ClickOnYesAddUser();
                if (!userManagementPage.ValidateSuccessfulUserCreation()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Success Pop up is not displayed");
                    softAssert.fail("User creation failed");
                }
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(1000);
                userManagementPage.EnterDesiredTextInSearchField(String.valueOf(userManagementPage.RandomUserName));
                userManagementPage.ClickOnResetPasswordButton();
                if (!userManagementPage.ValidateSuccessfulResetPasswordSending()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Success Pop up is not displayed");
                    softAssert.fail("reset password failed");
                }
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(1000);
                userManagementPage.ClickDeleteButton();
                Thread.sleep(1000);
                userManagementPage.ClickYesButtonToConfirm();
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(1000);
                userManagementPage.ClickOnChangeLogButton();
                if (!userManagementPage.ValidateVisibilityOfChangeLogPage()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Change logs page is not displayed");
                    softAssert.fail("Change logs page is not displayed");
                }
                Thread.sleep(800);
                userManagementPage.ClickOnCrossButton();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));

    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to User Management-Super Admin Users")
    @Story("Super Admin Operations-Negative Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Super Admin Operations")
    public void SuperAdminOperationsNegative() throws InterruptedException {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                Thread.sleep(1000);
                utils.ClickOnControlCenterNavButton();
                userManagementPage.ClickOnSuperAdminUsers();
                userManagementPage.ClickOnAddNewUser();
                userManagementPage.ClickOnAddUserForSuperAdmin();  //Clicking Add user button without filling any mandatory fields
                if (!userManagementPage.ValidateErrorMessageForNameField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error message for Name field is not displayed");
                    softAssert.fail("Error message for Name field is not displayed");
                }
                if (!userManagementPage.ValidateErrorMessageForEmailField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error message for Email field is not displayed");
                    softAssert.fail("Error message for Email field is not displayed");
                }
                userManagementPage.EnterName("           ");
                userManagementPage.EnterEmail("mail", 8);
                userManagementPage.ClickOnAddUserForSuperAdmin();
                if (!userManagementPage.ValidateErrorMessageForEmptyField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - User is being created with empty name");
                    softAssert.fail("Super Admin User is being created with empty name");
                }
                userManagementPage.EnterName("%^$&#%$^^*7");
                userManagementPage.ClickOnAddUserForSuperAdmin();
                if (!userManagementPage.ValidateErrorMessageForNameFieldForSpecialChars()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error message for Name field is not displayed");
                    softAssert.fail("Error message for Name field is not displayed");
                }
                userManagementPage.EnterName("randomdata", 3);
                userManagementPage.EnterEmail("jhbdc@com");
                userManagementPage.ClickOnAddUserForSuperAdmin();
                if (!userManagementPage.ValidateErrorMessageForInvalidEmail()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error message for invalid Email is not displayed");
                    softAssert.fail("Email field is accepting invalid mail id");
                }
                userManagementPage.EnterEmail("           ");
                userManagementPage.ClickOnAddUserForSuperAdmin();
                if (!userManagementPage.ValidateErrorMessageForEmptyField()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Email field is accepting only spaces without any error message");
                    softAssert.fail("Email field is accepting only spaces without any error message");
                }
                userManagementPage.EnterEmail("rajesh@frugaltestingin.com");
                userManagementPage.ClickOnAddUserForSuperAdmin();
                userManagementPage.ClickOnYesAddUser();
                if (!userManagementPage.ValidateSuccessfulUserCreation()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Success Pop up is not displayed");
                    softAssert.fail("User creation failed with existing user");
                }
                utils.ClickOnPopUpCloseButton();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to User Management- Ops Users")
    @Story("OpsUser Operations-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Ops User Operations")
    public void OpsUserOperations() throws InterruptedException {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                utils.ClickOnControlCenterNavButton();
                userManagementPage.ClickOnOpsUser();
                userManagementPage.ClickOnAddNewUser();
                userManagementPage.EnterName("randomdata", 3);
                userManagementPage.ClickOnAccessRoleDropdown();
                userManagementPage.ClickOnDesiredAccessRole(2);
                userManagementPage.EnterEmail("mail", 8);
                userManagementPage.ClickOnAddUserForOpsUser();
                userManagementPage.ClickOnYesAddUser();
                if (!userManagementPage.ValidateSuccessfulUserCreation()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Success Pop up is not displayed");
                    softAssert.fail("User creation failed");
                }
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(1000);
                userManagementPage.EnterDesiredTextInSearchField(String.valueOf(userManagementPage.RandomUserName));
                userManagementPage.ClickOnIndividualAccessRoleDropdown();
                userManagementPage.ClickOnDesiredAccessRole(3);
                userManagementPage.ClickYesButtonToConfirm();
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(1000);
                userManagementPage.EnterDesiredTextInSearchField(String.valueOf(userManagementPage.RandomUserName));
                userManagementPage.ClickDeleteButton();
                Thread.sleep(1000);
                userManagementPage.ClickYesButtonToConfirm();
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(1000);
                userManagementPage.ClickOnAddNewUser();
                userManagementPage.EnterName("randomdata", 3);
                userManagementPage.EnterEmail("mail", 8);
                userManagementPage.ClickOnAddUserForOpsUser();
                if (!userManagementPage.ValidateErrorMessageForAccessRole()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error message for Access Role field is not displayed");
                    softAssert.fail("Error message for Access Role field is not displayed");
                }
                userManagementPage.ClickOnAccessRoleDropdown();
                userManagementPage.ClickOnDesiredAccessRole(2);
                userManagementPage.ClickOnAddUserForOpsUser();
                userManagementPage.ClickOnYesAddUser();
                utils.ClickOnPopUpCloseButton();

                utils.ClickOnControlCenterNavButton();
                userManagementPage.ClickOnAdvertiserUsers();
                Thread.sleep(1500);
                userManagementPage.EnterDesiredTextInSearchField(String.valueOf(userManagementPage.RandomUserName));
                Thread.sleep(1500);
                userManagementPage.ClickDeleteButton();
                userManagementPage.ClickYesButtonToConfirm();
                if (!userManagementPage.ValidateErrorMessageForUnauthorizedDeletion()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Error message for unauthorized deletion is not displayed");
                    softAssert.fail("Error message for unauthorized deletion is not displayed");
                }
                utils.ClickOnPopUpCloseButton();
                utils.ClickOnControlCenterNavButton();
                userManagementPage.ClickOnOpsUser();
                Thread.sleep(1500);
                userManagementPage.EnterDesiredTextInSearchField(String.valueOf(userManagementPage.RandomUserName));
                Thread.sleep(1500);
                userManagementPage.ClickDeleteButton();
                userManagementPage.ClickYesButtonToConfirm();
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to User Management- Advertiser Users")
    @Story("Advertiser Users Operations-Positive Flow")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=1200000,description = "Test: Advertiser User Operations")
    public void AdvertiserUsersOperations() throws InterruptedException {
        utils.RetryOnFailOsmosPulse((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                utils.ClickOnControlCenterNavButton();
                userManagementPage.ClickOnAdvertiserUsers();
                userManagementPage.ClickOnAdvertiserDropdown();
                userManagementPage.EnterDataInMerchantSearchField("Whitakers");
                userManagementPage.ClickOnDesiredMerchant(1);
                userManagementPage.ClickOnAddNewUser();
                userManagementPage.EnterName("randomdata", 3);
                userManagementPage.ClickOnAccessRoleDropdown();
                userManagementPage.ClickOnDesiredAccessRole(2);
                userManagementPage.EnterEmail("mail", 8);
                userManagementPage.ClickOnAddUserTemp();
//                userManagementPage.ClickOnYesAddUser();
                if (!userManagementPage.ValidateSuccessfulUserCreation()) {
                    utils.TakeScreenshotOnSoftAssertion("Soft Assertion - Success Pop up is not displayed");
                    softAssert.fail("User creation failed");
                }
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(1000);
                userManagementPage.EnterDesiredTextInSearchField(String.valueOf(userManagementPage.RandomUserName));
                Thread.sleep(1500);
                userManagementPage.ClickOnIndividualAccessRoleDropdown();
                userManagementPage.ClickOnDesiredAccessRole(3);
                userManagementPage.ClickYesButtonToConfirm();
                utils.ClickOnPopUpCloseButton();
                Thread.sleep(1000);
                userManagementPage.EnterDesiredTextInSearchField(String.valueOf(userManagementPage.RandomUserName));
                Thread.sleep(1000);
                userManagementPage.ClickDeleteButton();
                userManagementPage.ClickYesButtonToConfirm();
                utils.ClickOnPopUpCloseButton();

            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));

    }

}
