package PagesPulse;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class ControlCenterPage {

    WebDriver driver;
    WebDriverWait wait;
    private  CampaignTemplatePage campaignTemplatePage;

    public static int RetryListener = 0;


    public ControlCenterPage(WebDriver driver) {
        campaignTemplatePage= new CampaignTemplatePage(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    final By ControlCenterButton = By.xpath("//span[contains(@class,'nav-icon icon icon-watchlist-nav-filled')]");
    final By AdOpsUsers = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-user-role_access_agency')]");
    final By AddNewUserButton = By.xpath("//button[contains(@class,'pendo_feature_user_access_management_add_new_user_button')]");
    final By UserNameField = By.xpath("(//div[contains(@class,'input-wrapper')]/input)[1]");
    final By UserEmailField = By.xpath("(//div[contains(@class,'input-wrapper')]/input)[2]");
    final By AccessRoleDropdown = By.xpath("//div[contains(@class,'borderbottom dropdown')]");
    final String AccessRoleOptions = ("(//div[contains(@class,' Select__menu-list')]/descendant::div[contains(@id,'option-')])[%d]");
    final By AddButton = By.xpath("//button[contains(@class,'pendo_feature_user_access_management_add_modal_save_button')]");
    final By SearchField = By.xpath("//div[contains(@class,'table-search-input custom-search')]/input");
    final By FirstRowUserName = By.xpath("(//div[contains(@class,'ellipsis-cell-overflow d-align-center')]/descendant::span)[1]");
    final By DeleteUserButton = By.xpath("(//button[contains(@class,'pendo_feature_user_access_management_delete_user')])[1]");
    final By DeleteConfirmButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By ChangeAccessRoleConfirmButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By ErrorMessageForAddUserFields = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[1]");
    final By ErrorMessageForInvalidEmailId = By.xpath("//div[contains(@class,'pendo-track-field-value-invalid-error')]");
    final By ErrorMessageForAccessRoleField = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[2]");
    final By ErrorMessageForEmailField = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[3]");
    final By ErrorMessageForExistingUser = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By AccessRoleDropdownInTable = By.xpath("//button[contains(@class,'dropdown-toggle btn btn-primary')]");
    final By NavBarSettingsButton = By.xpath("(//a[contains(@class,'pendo-tracking-navbar-settings')]/descendant::span)[1]");
    final By LogOutButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-logout')]");
    final By LogInButton = By.xpath("//button[contains(@class,'login-button')]");
    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");



    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }
    public void ChangeLanguage() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        actions.contextClick().perform();
        Thread.sleep(2000);
        Robot robot = new Robot();
        for (int i = 1; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
        }
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Step("Clicking on control center button")
    public void ClickOnControlCenterButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ControlCenterButton));
        WebElement element = driver.findElement(ControlCenterButton);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(1500);
        driver.findElement(ControlCenterButton).click();
    }
    @Step("Clicking on AdOps User section")
    public void ClickOnAdOpsUser() {
        wait.until(ExpectedConditions.elementToBeClickable(AdOpsUsers));
        driver.findElement(AdOpsUsers).click();
    }
    @Step("Clicking on Add new user button")
    public void ClickOnAddNewUser() {
        wait.until(ExpectedConditions.elementToBeClickable(AddNewUserButton));
        driver.findElement(AddNewUserButton).click();
    }
    @Step("Adding User name")
    public void AddingDesiredUserName() {
        wait.until(ExpectedConditions.elementToBeClickable(UserNameField));
        driver.findElement(UserNameField).sendKeys(campaignTemplatePage.Text);
    }
    @Step("Adding desired user name")
    public void EnterDesiredTextInUserNameField(String UserName) {
        wait.until(ExpectedConditions.elementToBeClickable(UserNameField));
        driver.findElement(UserNameField).sendKeys(UserName);
    }
    @Step("Select desired access role")
    public void SelectingDesiredAccessRole(int option) {
        wait.until(ExpectedConditions.elementToBeClickable(AccessRoleDropdown));
        driver.findElement(AccessRoleDropdown).click();
        String XpathFormatter = String.format(AccessRoleOptions, option);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }
    @Step("Adding user email")
    public void AddingUserEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(UserEmailField));
        driver.findElement(UserEmailField).sendKeys(campaignTemplatePage.Text + "@gmail.com");
    }
    @Step("Adding desired user email")
    public void EnterDesiredUserEmail(String Email) {
        wait.until(ExpectedConditions.elementToBeClickable(UserEmailField));
        driver.findElement(UserEmailField).sendKeys(Email);
    }
    @Step("Clicking Add Button")
    public void ClickingAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddButton));
        driver.findElement(AddButton).click();
    }
    @Step("Adding desired text in user's table search field")
    public void AddingTextInUserSearchField() {
        wait.until(ExpectedConditions.elementToBeClickable(SearchField));
        driver.findElement(SearchField).sendKeys(campaignTemplatePage.Text);
    }
    @Step("Adding desired text in user's table search field")
    public void AddingDesiredTextInUserSearchField() {
        wait.until(ExpectedConditions.elementToBeClickable(SearchField));
        driver.findElement(SearchField).sendKeys(campaignTemplatePage.Text);
    }
    @Step("Validate successful addition of new user")
    public boolean ValidateSuccessfulAdditionOfNewUser() {
        wait.until(ExpectedConditions.elementToBeClickable(FirstRowUserName));
        return driver.findElement(FirstRowUserName).getText().equals(campaignTemplatePage.Text);
    }
    @Step("Deleting existing user")
    public void ClickingDeleteUserButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DeleteUserButton));
        driver.findElement(DeleteUserButton).click();
    }
    @Step("Clicking Yes button to confirm delete user")
    public void ClickYesButtonToConfirmDeletion() {
        wait.until(ExpectedConditions.elementToBeClickable(DeleteConfirmButton));
        driver.findElement(DeleteConfirmButton).click();
    }
    @Step("Clicking Yes button to confirm Access role change")
    public void ClickYesButtonToAccessRoleChange() {
        wait.until(ExpectedConditions.elementToBeClickable(ChangeAccessRoleConfirmButton));
        driver.findElement(ChangeAccessRoleConfirmButton).click();
    }
    @Step("Validate error message after creating a user with spaces in username field")
    public boolean ValidateErrorMessageForAddingSpacesInUserNameField() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForAddUserFields));
            return driver.findElement(ErrorMessageForAddUserFields).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate error message after clicking add button  without filling username field")
    public boolean ValidateErrorMessageAfterClickingAddButtonWithoutFillingUserNameField() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForAddUserFields));
            return driver.findElement(ErrorMessageForAddUserFields).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate error message after clicking add button without selecting any access role")
    public boolean ValidateErrorMessageForAccessRoleField() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForAccessRoleField));
            return driver.findElement(ErrorMessageForAccessRoleField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate error message for not filling user email field")
    public boolean ValidateErrorMessageForEmailField() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForEmailField));
            return driver.findElement(ErrorMessageForEmailField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate error message for adding invalid email id ")
    public boolean ValidateErrorMessageForAddingInvalidEmailId() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForInvalidEmailId));
            return driver.findElement(ErrorMessageForInvalidEmailId).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate error message for adding existing user")
    public boolean ValidateErrorMessageForAddingExistingUser() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForExistingUser));
            return driver.findElement(ErrorMessageForExistingUser).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Settings button")
    public void ClickOnSettingsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(NavBarSettingsButton));
        driver.findElement(NavBarSettingsButton).click();
    }@Step("Clicking on LogOut button")
    public void ClickOnLogOutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LogOutButton));
        driver.findElement(LogOutButton).click();
    }
    @Step("Validate visibility of login button")
    public boolean ValidateVisibilityOfLogInButton() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(LogInButton));
            return driver.findElement(LogInButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Select desired access role after creating user in table")
    public void SelectingDesiredAccessRoleInTable(int option) {
        wait.until(ExpectedConditions.elementToBeClickable(AccessRoleDropdownInTable));
        driver.findElement(AccessRoleDropdownInTable).click();
        String XpathFormatter = String.format(AccessRoleOptions, option);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }
    @Step("Clicking on pop up close button")
    public void ClickingOnPopUpCloseButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(GenericPopUpCloseButton));
        driver.findElement(GenericPopUpCloseButton).click();
    }





}