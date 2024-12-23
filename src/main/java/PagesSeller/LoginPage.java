package PagesSeller;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    final By UserNameField = By.xpath("//input[@placeholder='Email']");
    final By PasswordField = By.xpath("//input[@placeholder='Password']");
    final By SignInButton = By.xpath("//button[@type='button']//span[text()='Sign In']");
    final By NavBar = By.xpath("//div[@id='responsive-navbar-nav']");
    final By ForgotPasswordLink = By.xpath("//a[contains(text(),'Forgot password')]");
    final By ForgotPasswordEmailField = By.xpath("//input[@placeholder='Enter email address']");
    final By ForgotPasswordSuccessfulSentNotification = By.xpath("//div[contains(text(),'steps to reset your password')]");
    final By ForgotPasswordSubmitButton = By.xpath("//button/child::span[text()='Submit']");
    final By ForgotPasswordBackToSignInButton = By.xpath("//button/child::span[text()='Back to sign in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Step("Entering Email Id")
    public void EnterEmailId(String UserName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserNameField));
        driver.findElement(UserNameField).sendKeys(UserName);
    }

    @Step("Entering Password")
    public void EnterPassword(String Password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordField));
        driver.findElement(PasswordField).sendKeys(Password);
    }

    @Step("Clicking on SignIn button")
    public void ClickOnSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
        driver.findElement(SignInButton).click();
    }

    public void NativeLogin(String UserName, String Password) {
        EnterEmailId(UserName);
        EnterPassword(Password);
        ClickOnSignInButton();
    }

    @Step("Validating SignIn through URL")
    public boolean VerifyLoginWithURL() {
        return wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
    }

    @Step("Validating SignIn through NavBar Visibility")
    public boolean VerifyLoginWithNavBar() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NavBar));
        return driver.findElement(NavBar).isDisplayed();
    }

    @Step("Clicking on Forgot Password Link")
    public void ClickOnForgotPasswordHyperLink() {
        wait.until(ExpectedConditions.elementToBeClickable(ForgotPasswordLink));
        driver.findElement(ForgotPasswordLink).click();
    }

    @Step("Entering email address for getting forgot password reset link")
    public void EnterEmailAddressInForgotPassword(String ForgotPasswordEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ForgotPasswordEmailField));
        driver.findElement(ForgotPasswordEmailField).sendKeys(ForgotPasswordEmail);
    }

    @Step("Verifying notification popped up on successful reset link sent")
    public boolean VerifyForgotPasswordLinkSent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ForgotPasswordSuccessfulSentNotification));
        return driver.findElement(ForgotPasswordSuccessfulSentNotification).isDisplayed();
    }

    @Step("Clicking on forgot password submit button")
    public void ClickOnForgotPasswordSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ForgotPasswordSubmitButton));
        driver.findElement(ForgotPasswordSubmitButton).click();
    }

    @Step("Clicking on forgot password back to sign in button")
    public void ClickOnForgotPasswordBackToSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ForgotPasswordBackToSignInButton));
        driver.findElement(ForgotPasswordBackToSignInButton).click();
    }

    @Step("Verifying if back to sign in button redirecting to sign in page")
    public boolean VerifyRedirectionFromForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
        return driver.findElement(SignInButton).isDisplayed();
    }

}
