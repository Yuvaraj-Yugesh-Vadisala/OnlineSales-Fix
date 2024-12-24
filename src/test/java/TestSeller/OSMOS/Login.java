package TestSeller.OSMOS;

import BaseClass.BaseTest;
import PagesSeller.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosSellerUrl);
        loginPage = new LoginPage(getDriver());
    }

    @AfterMethod
    public void TearDown() {
        getDriver().quit();
    }


    @Epic("Seller Dashboard")
    @Feature("SignIn Page")
    @Story("This flow belongs to successful SignIn")
    @Severity(SeverityLevel.BLOCKER)
    @Test(timeOut=20000,description = "Test: SignIn is successful with valid credentials")
    public void SignInSuccessful() {
        loginPage.NativeLogin(UserName, Password);
        if (!loginPage.VerifyLoginWithURL())
            Assert.fail("Login validation failed through URL");
    }

    @Epic("Seller Dashboard")
    @Feature("SignIn Page")
    @Story("This flow belongs to successful SignIn")
    @Severity(SeverityLevel.BLOCKER)
    @Test(timeOut=20000,description = "Test: SignIn is successful with valid credentials and validating NavBar")
    public void SignInSuccessfulWithDashboard() {
        loginPage.NativeLogin(UserName, Password);
        if (!loginPage.VerifyLoginWithNavBar())
            Assert.fail("Login validation failed through NavBar visibility");
    }

    @Epic("Seller Dashboard")
    @Feature("SignIn Page")
    @Story("This flow belongs to Forgot Password")
    @Severity(SeverityLevel.CRITICAL)
    @Test(timeOut=20000,description = "Test: Verify if forgot password functionality is working")
    public void ForgotPasswordIsWorking() {
        loginPage.ClickOnForgotPasswordHyperLink();
        loginPage.EnterEmailAddressInForgotPassword(UserName);
        loginPage.ClickOnForgotPasswordSubmitButton();
        if (!loginPage.VerifyForgotPasswordLinkSent())
            Assert.fail("Pop up not appeared after submit");
    }

    @Epic("Seller Dashboard")
    @Feature("SignIn Page")
    @Story("This flow belongs to Forgot Password")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut=20000,description = "Test: Verify if forgot password back functionality is working")
    public void ForgotPasswordBackToSignInButtonIsWorking() {
        loginPage.ClickOnForgotPasswordHyperLink();
        loginPage.EnterEmailAddressInForgotPassword(UserName);
        loginPage.ClickOnForgotPasswordBackToSignInButton();
        if (!loginPage.VerifyRedirectionFromForgotPassword())
            Assert.fail("Failed to redirect to the sign in page");
    }

}
