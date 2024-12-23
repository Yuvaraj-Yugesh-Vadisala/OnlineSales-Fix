package PagesPulse.OSMOS;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Locale;


public class UserManagementPage {
    WebDriver driver;
    WebDriverWait wait;

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By WhiteLoader = By.xpath("//div[contains(@class,'loader-wrapper white-loader')]");
    final By SuperAdminUsers = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-super-admin_users')]/descendant::label");
    final By OpsUser = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-ops-users')]");
    final By AdvertiserUser = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-advertiser-users')]");
    final By AddNewUserButton = By.xpath("//button[contains(@class,'pendo-track-uam-add-new-user-table-fixed-button')]");
    final By NameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-name')]/descendant::input");
    final By EmailField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-email')]/descendant::input");
    final By YesAddUserButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By SuperAdminAddUserButton = By.xpath("//button[contains(@class,'pendo-track-super-admin-add-new-user-modal-form-cta-button')]");
    final By OpsUserAddUserButton = By.xpath("//button[contains(@class,'pendo-track-ops-users-add-new-user-modal-form-cta-button')]");
    final By AddUserButtonTemp = By.xpath("//button[contains(@class,'os-button  button-primary shape-cornor medium')]");
    final By SuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By SearchField = By.xpath("//div[contains(@class,'pendo_feature_table_search_input')]");
    final By DeleteUserButton = By.xpath("//td[contains(@class,'pendo-track-uam-delete-user-table-column')]/button");
    final By YesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By ChangeLogButton = By.xpath("//button[contains(@class,'pendo-track-uam-change-log-button')]");
    final By ChangeLogPage = By.xpath("//div[contains(@class,'pure-drawer')]");
    final By PageCloseButton = By.xpath("//label[contains(@class,'pure-toggle-label icon icon-close1')]");
    final By ResetPasswordButton = By.xpath("(//button[contains(@class,'button reset-password')])[1]");
    final By ErrorMessageForNameField = By.xpath("(//div[contains(@class,'pendo-track-field-empty-error')])[1]");
    final By ErrorMessageForEmailField = By.xpath("(//div[contains(@class,'pendo-track-field-empty-error')])[2]");
    final By ErrorMessageForNameFieldSpecialCharacters = By.xpath("//div[contains(@class,'pendo-track-field-special-charaters-error')]");
    final By ErrorMessageForInvalidEmail= By.xpath("//div[contains(@class,'pendo-track-field-email-invalid-error')]");
    final By AccessRoleDropdown= By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-access-role')]/descendant::div[contains(@class,'select-dropdown')]");
    final By IndividualAccessRoleDropdown= By.xpath("(//div[contains(@class,'pendo-track-uam-access-level-dropdown')]/descendant::div[contains(@class,'select-dropdown')])[1]");
    final String DesiredAccessRole= ("(//div[contains(@class,'option')])[%d]");
    final By ErrorMessageForAccessRoleField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-access-role')]/descendant::div[contains(@class,'error')]");
    final By AdvertiserDropdown = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-select-a-advertiser')]/descendant::div[contains(@class,'client-select-dropdown')]");
    final String DesiredMerchant = "(//div[contains(@class,'Select__option')])[%d]";
    final  By ErrorMessageUnauthorizedAccess = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By EmptyFieldErrorMessage = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");


    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    @Step("Clicking on Super admin users")
    public void ClickOnSuperAdminUsers() {
        wait.until(ExpectedConditions.elementToBeClickable(SuperAdminUsers));
        driver.findElement(SuperAdminUsers).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));
    }
    @Step("Clicking on Ops users")
    public void ClickOnOpsUser() {
        wait.until(ExpectedConditions.elementToBeClickable(OpsUser));
        driver.findElement(OpsUser).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));
    }
    @Step("Clicking on Advertiser users")
    public void ClickOnAdvertiserUsers() {
        wait.until(ExpectedConditions.elementToBeClickable(AdvertiserUser));
        driver.findElement(AdvertiserUser).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));
    }

    @Step("Clicking on Add new user button")
    public void ClickOnAddNewUser() {
        wait.until(ExpectedConditions.elementToBeClickable(AddNewUserButton));
        driver.findElement(AddNewUserButton).click();
    }

    public static StringBuilder RandomUserName;
    public final static String SuperAdminTemp = String.valueOf(RandomUserName);

    @Step("Enter user name")
    public void EnterName(String Name, int count) {
        wait.until(ExpectedConditions.elementToBeClickable(NameField));
        driver.findElement(NameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        RandomUserName = generateRandomData(Name, count);
//        System.out.println(RandomUserName);
        driver.switchTo().activeElement().sendKeys(RandomUserName);
    }
    @Step("Enter user name")
    public void EnterName(String Name) {
        wait.until(ExpectedConditions.elementToBeClickable(NameField));
        driver.findElement(NameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Name);
    }
    public StringBuilder RandomEmail;

    @Step("Enter user Email")
    public void EnterEmail(String Email, int count) {
        wait.until(ExpectedConditions.elementToBeClickable(EmailField));
        driver.findElement(EmailField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        RandomEmail = generateRandomData(Email, count);
        driver.switchTo().activeElement().sendKeys(RandomEmail);
    }
    @Step("Enter user Email")
    public void EnterEmail(String Email) {
        wait.until(ExpectedConditions.elementToBeClickable(EmailField));
        driver.findElement(EmailField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Email);
    }

    @Step("Clicking on Yes,Add user button")
    public void ClickOnYesAddUser() {
        wait.until(ExpectedConditions.elementToBeClickable(YesAddUserButton));
        driver.findElement(YesAddUserButton).click();
    }

    @Step("Clicking on Add user button for Super Admin")
    public void ClickOnAddUserForSuperAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(SuperAdminAddUserButton));
        driver.findElement(SuperAdminAddUserButton).click();
    }
    @Step("Clicking on Add user button")
    public void ClickOnAddUserForOpsUser() {
        wait.until(ExpectedConditions.elementToBeClickable(OpsUserAddUserButton));
        driver.findElement(OpsUserAddUserButton).click();
    }
    @Step("Clicking on Add user button")
    public void ClickOnAddUserTemp() {
        wait.until(ExpectedConditions.elementToBeClickable(AddUserButtonTemp));
        driver.findElement(AddUserButtonTemp).click();
    }

    @Step("Validate user creation success pop up")
    public boolean ValidateSuccessfulUserCreation() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait( driver, Duration.ofSeconds(3));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(SuccessPopUp));
            return driver.findElement(SuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate visibility of error message")
    public boolean ValidateErrorMessageForEmptyField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait( driver, Duration.ofSeconds(3));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(EmptyFieldErrorMessage));
            return driver.findElement(EmptyFieldErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate success pop up for sending reset password")
    public boolean ValidateSuccessfulResetPasswordSending() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait( driver, Duration.ofSeconds(7));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(SuccessPopUp));
            return driver.findElement(SuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }

    }


    @Step("Enter desired text in search field")
    public void EnterDesiredTextInSearchField(String Text) {
        wait.until(ExpectedConditions.elementToBeClickable(SearchField));
        driver.findElement(SearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Text);
    }

    public StringBuilder generateRandomData(String useCase, int count) {
        String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk0123456789";
        StringBuilder result = new StringBuilder();
        String fixedPart = "QATesting";
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            result.append(randomChar);
        }
        if (useCase.equalsIgnoreCase("mail")) {
            return result.append("@gmail.com");
        } else if (useCase.equalsIgnoreCase("randomdata")) {

            return new StringBuilder(fixedPart).append(result);
        }
        return result;
    }

    @Step("Clicking on delete icon to delete user")
    public void ClickDeleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DeleteUserButton));
        driver.findElement(DeleteUserButton).click();
    }

    @Step("Clicking on Yes button  to confirm deletion")
    public void ClickYesButtonToConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(YesButton));
        driver.findElement(YesButton).click();
    }

    @Step("Clicking on change log button")
    public void ClickOnChangeLogButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ChangeLogButton));
        driver.findElement(ChangeLogButton).click();
    }

    @Step("Clicking on cross button to close the page")
    public void ClickOnCrossButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PageCloseButton));
        driver.findElement(PageCloseButton).click();
    }

    @Step("Validate visibility of change logs page")
    public boolean ValidateVisibilityOfChangeLogPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ChangeLogPage));
            return driver.findElement(ChangeLogPage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Clicking on reset password button")
    public void ClickOnResetPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ResetPasswordButton));
        driver.findElement(ResetPasswordButton).click();
    }
    @Step("Validate visibility error message for Name field")
    public boolean ValidateErrorMessageForNameField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait( driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForNameField));
            return driver.findElement(ErrorMessageForNameField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate visibility error message for Email field")
    public boolean ValidateErrorMessageForEmailField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait( driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForEmailField));
            return driver.findElement(ErrorMessageForEmailField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate visibility error message for invalid Email")
    public boolean ValidateErrorMessageForInvalidEmail() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait( driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForInvalidEmail));
            return driver.findElement(ErrorMessageForInvalidEmail).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate visibility error message for Name field for special characters")
    public boolean ValidateErrorMessageForNameFieldForSpecialChars() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait( driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForNameFieldSpecialCharacters));
            return driver.findElement(ErrorMessageForNameFieldSpecialCharacters).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Clicking on Access Role Dropdown")
    public void ClickOnAccessRoleDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(AccessRoleDropdown));
        driver.findElement(AccessRoleDropdown).click();
    }
    @Step("Clicking on individual Access Role Dropdown in table")
    public void ClickOnIndividualAccessRoleDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(IndividualAccessRoleDropdown));
        driver.findElement(IndividualAccessRoleDropdown).click();
    }
    @Step("Clicking on desired access role option")
    public void ClickOnDesiredAccessRole(int optionNo) {
        String formattedXpath = String.format(DesiredAccessRole, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }
    @Step("Validate visibility error message for Name field")
    public boolean ValidateErrorMessageForAccessRole() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait( driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForAccessRoleField));
            return driver.findElement(ErrorMessageForAccessRoleField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Clicking on Advertiser dropdown")
    public void ClickOnAdvertiserDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(AdvertiserDropdown));
        driver.findElement(AdvertiserDropdown).click();
    }
    @Step("Entering data in merchant search field")
    public void EnterDataInMerchantSearchField(String MerchantName) {
//        wait.until(ExpectedConditions.elementToBeClickable(MerchantDropdown));
        driver.switchTo().activeElement().sendKeys(MerchantName);
    }
    @Step("Clicking on desired merchant option")
    public void ClickOnDesiredMerchant(int optionNo) {
        String formattedXpath = String.format(DesiredMerchant, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }
    @Step("Validate visibility error message for unauthorized deletion")
    public boolean ValidateErrorMessageForUnauthorizedDeletion() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait( driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageUnauthorizedAccess));
            return driver.findElement(ErrorMessageUnauthorizedAccess).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}
