package PagesPulse.OSMOS;

import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Locale;

public class BuildYourOwnTargetingPage {
    WebDriver driver;
    WebDriverWait wait;


    public BuildYourOwnTargetingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By WhiteLoader = By.xpath("//div[contains(@class,'loader-wrapper white-loader')]");
    final By KeyValueSetup = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-key-value_setup')]");
    final By CreateNewKeyButton = By.xpath("//button[contains(@class,'pendo_feature_custom-targeting_create_new_button')]");
    final By DisabledCreateNewKeyButton = By.xpath("//button[contains(@class,'pendo_feature_custom-targeting_create_new_button') and contains(@class,'disable')]");
    final By KeyNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-key-name')]/descendant::div[contains(@class,'input')]");
    final By ApiIdentifierField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-api-identifier')]/descendant::div[contains(@class,'input')]");
    final By ValueField = By.xpath("//div[contains(@class,'pendo-track-key-value-values-textarea')]/descendant::textarea");
    final By AddValuesButton = By.xpath("//button[contains(@class,'pendo-track-key-value-add-values-button')]");
    final By CreateButton = By.xpath("//button[contains(@class,'pendo-track-key-value-form-cta-button')]");
    final By SuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By ErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By TargetingSetUp = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-targeting-setup')]");
    final By TargetingNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-name')]/descendant::input");
    final By TargetingDescriptionField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-description')]/descendant::textarea");
    final String RadioButton = ("(//div[contains(@class,'radio-wrapper')])[%d]");
    final By TargetingSaveButton = By.xpath("//button[contains(@class,'pendo-track-build-your-own-targeting-form-cta-button')]");
    final By DeleteIcon = By.xpath("//span[contains(@class,'icon-trash')]");
    final By YesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final String SegmentMenu = ("(//div[contains(@class,'table-body-parent-section ')]/descendant::button[contains(@class,'dropdown-menu-btn  dropdown-toggle btn btn-primary')])[1]");
    final By PopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");
    final By ErrorMessageForInvalidAPIIdentifier = By.xpath("//div[contains(@class,'pendo-track-field-value-invalid-error')]");
    final By ErrorMessageForEmptyAPIIdentifier = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final By ErrorMessageForEmptyKeyName = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final By CreativeRemoveButton = By.xpath("//div[contains(@class,'im-creative-block')]/descendant::span");
    final By ErrorMessageForCreative = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-icon')]/descendant::div[contains(@class,'error-msg name-error-message')]");
    final By UploadCreativeField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-icon')]/descendant::div[contains(@class,'creative-image-wrapper')]");
    final By ErrorMessageForTargetingFields = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final By CreativeSearchField = By.xpath("//div[contains(@class,'creative-selection-search')]/input");
    final By DesiredCreative = By.xpath("(//div[contains(@class,'media-list-mosaic-view')]/span)[1]");
    final By ChooseButton = By.xpath("//button[contains(@class,'pendo_feature_media_library_save_button')]");


    @Step("Clicking on Create New Key button if active, otherwise clicking the alternative button")
    public void ClickOnCreateNewKeyIfEnabledOrDeleteOneKey(int optionNo) throws InterruptedException {
        WebElement button = driver.findElement(CreateNewKeyButton);
        if (!button.getAttribute("class").contains("disable")) {
            wait.until(ExpectedConditions.elementToBeClickable(CreateNewKeyButton));
            button.click();
            System.out.println("Create New Key button clicked successfully.");
        } else {
            System.out.println("Create New Key button is disabled; deleting and creating new key.");
            String formattedXpath = String.format(String.valueOf(SegmentMenu), optionNo);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
            driver.findElement(By.xpath(formattedXpath)).click();
            driver.findElement(DeleteIcon).click();
            driver.findElement(YesButton).click();
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
            ExtensiveWait.until(ExpectedConditions.elementToBeClickable(PopUpCloseButton));
            driver.findElement(PopUpCloseButton).click();
            wait.until(ExpectedConditions.elementToBeClickable(CreateNewKeyButton));
            driver.findElement(CreateNewKeyButton).click();
        }
    }

    @Step("Clicking on KeyValue Setup")
    public void ClickOnKeyValueSetup() {
        wait.until(ExpectedConditions.elementToBeClickable(KeyValueSetup));
        driver.findElement(KeyValueSetup).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));
    }

    @Step("Clicking on Create New Key button")
    public void ClickOnCreateNewKeyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateNewKeyButton));
        driver.findElement(CreateNewKeyButton).click();
    }

    @Step("Enter Random key name")
    public void EnterKeyName(String KeyName, int count) {
        wait.until(ExpectedConditions.elementToBeClickable(KeyNameField));
        driver.findElement(KeyNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        String RandomKeyName = String.valueOf(generateRandomData(KeyName, count));
        driver.switchTo().activeElement().sendKeys(RandomKeyName);
    }

    @Step("Enter Desired key name")
    public void EnterDesiredKeyName(String KeyName) {
        wait.until(ExpectedConditions.elementToBeClickable(KeyNameField));
        driver.findElement(KeyNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(KeyName);
    }

    public StringBuilder generateRandomData(String useCase, int count) {
        String ALPHANUMERIC_STRING = "0123456789";
        StringBuilder result = new StringBuilder();
        String fixedPart = useCase;
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            result.append(randomChar);
        }
        return new StringBuilder(fixedPart).append(result);
    }

    @Step("Entering Random API Identifier")
    public void EnterApiIdentifier(String ApiIdentifier) {
        wait.until(ExpectedConditions.elementToBeClickable(ApiIdentifierField));
        driver.findElement(ApiIdentifierField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        String RandomApiIdentifier = String.valueOf(generateRandomData(ApiIdentifier, 5));
        driver.switchTo().activeElement().sendKeys(RandomApiIdentifier);
    }

    @Step("Entering desired API Identifier")
    public void EnterDesiredApiIdentifier(String ApiIdentifier) {
        wait.until(ExpectedConditions.elementToBeClickable(ApiIdentifierField));
        driver.findElement(ApiIdentifierField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(ApiIdentifier);
    }

    @Step("Adding keywords from excel")
    public void AddValueFromExcel(String SheetName) {
        driver.findElement(ValueField).click();
        String UserPath = System.getProperty("user.dir");
        String workbookName = UserPath + File.separator + "Resources" + File.separator + "OsmosResources" + File.separator + "Excel_data" + File.separator + "TEST_DATA_KEYWORDS.xlsx";
        wait.until(ExpectedConditions.elementToBeClickable(ValueField));
        try {
            DataFormatter formatter = new DataFormatter();
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(workbookName));
            Sheet sheet = workbook.getSheet(SheetName);
            StringBuilder allData = new StringBuilder();
            int rowNumber = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rowNumber; i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);
                String cellValue = formatter.formatCellValue(cell);
                allData.append(cellValue).append("\n");
            }
            WebElement element = driver.findElement(ValueField);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.findElement(ValueField).click();
            driver.findElement(ValueField).sendKeys(controlOrCommandKey+ "A");
            driver.findElement(ValueField).sendKeys(allData.toString());
//            js.executeScript("arguments[0].value = arguments[1];", element, allData.toString());
//            driver.findElement(ValueField).click();
//            driver.findElement(ValueField).sendKeys(" ");
//            driver.findElement(ValueField).sendKeys(Keys.BACK_SPACE);
            workbook.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("Clicking on Add Values Button")
    public void ClickOnAddValuesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddValuesButton));
        driver.findElement(AddValuesButton).click();
    }

    @Step("Enter desired values")
    public void EnterDesiredValues(String Value) {
        wait.until(ExpectedConditions.elementToBeClickable(ValueField));
        driver.findElement(ValueField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Value);
    }

    @Step("Clicking on Create Button")
    public void ClickOnCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateButton));
        driver.findElement(CreateButton).click();
    }

    @Step("Validate visibility success pop up for key value addition")
    public boolean ValidateSuccessfulKeyValueAddition() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(SuccessPopUp));
            return driver.findElement(SuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility Error pop up for  empty key addition")
    public boolean ValidateErrorPopUpForEmptyKeyValue() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorPopUp));
            return driver.findElement(ErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility Error pop up for  empty Value addition")
    public boolean ValidateErrorPopUpForSpacesInValueField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorPopUp));
            return driver.findElement(ErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Targeting Setup")
    public void ClickOnTargetingSetup() {
        wait.until(ExpectedConditions.elementToBeClickable(TargetingSetUp));
        driver.findElement(TargetingSetUp).click();
    }

    @Step("Enter desired Targeting Name")
    public void EnterTargetingName(String Name) {
        wait.until(ExpectedConditions.elementToBeClickable(TargetingNameField));
        driver.findElement(TargetingNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Name);
    }

    @Step("Enter Targeting Description")
    public void EnterTargetingDescription(String Description) {
        wait.until(ExpectedConditions.elementToBeClickable(TargetingDescriptionField));
        driver.findElement(TargetingDescriptionField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Description);
    }

    @Step("Clicking on desired radio button")
    public void SelectDesiredRadioButton(int option) {
        String formattedXpath = String.format(RadioButton, option);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Clicking on Targeting Save Button")
    public void ClickTargetingSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(TargetingSaveButton));
        driver.findElement(TargetingSaveButton).click();
    }


    @Step("Validate visibility Error message for invalid api identifier")
    public boolean ValidateErrorMessageForInvalidApiIdentifier() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForInvalidAPIIdentifier));
            return driver.findElement(ErrorMessageForInvalidAPIIdentifier).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility Error message for empty api identifier")
    public boolean ValidateErrorMessageForEmptyField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForEmptyAPIIdentifier));
            return driver.findElement(ErrorMessageForEmptyAPIIdentifier).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility Error pop up for  empty Value addition")
    public boolean ValidateErrorPopUpForEmptyValueField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorPopUp));
            return driver.findElement(ErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility Error pop up for  invalid Value addition")
    public boolean ValidateErrorPopUpForInvalidValueField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorPopUp));
            return driver.findElement(ErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility Error pop up for adding more than maximum Values")
    public boolean ValidateErrorPopUpForMoreThanMaxValueField() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorPopUp));
            return driver.findElement(ErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Key name field accepting more than 35 characters")
    public boolean ValidateKeyNameFieldAcceptingMoreThan35Characters() {
        wait.until(ExpectedConditions.elementToBeClickable(KeyNameField));
        driver.findElement(KeyNameField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        // System.out.println(nameValue);
        return nameValue.length() > 35;
    }

    final By IndividualValueDeleteButton = By.xpath("(//button[contains(@class,'user-delete cursor-pointer btnheight button')])[1]");

    @Step("Clicking on individual value delete Button")
    public void ClickOnIndividualValueDeleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(IndividualValueDeleteButton));
        driver.findElement(IndividualValueDeleteButton).click();
    }

    @Step("Clicking on yes button")
    public void ClickOnYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(YesButton));
        driver.findElement(YesButton).click();
    }

    @Step("Validate visibility Error message for empty Key Name")
    public boolean ValidateErrorMessageForEmptyKeyName() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForEmptyKeyName));
            return driver.findElement(ErrorMessageForEmptyKeyName).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility success pop up for targeting setup")
    public boolean ValidateSuccessfulTargetingSetUp() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(SuccessPopUp));
            return driver.findElement(SuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Targeting name field accepting more than 50 characters")
    public boolean ValidateTargetingNameFieldAcceptingMoreThan50Characters() {
        wait.until(ExpectedConditions.elementToBeClickable(TargetingNameField));
        driver.findElement(TargetingNameField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        // System.out.println(nameValue);
        return nameValue.length() > 50;
    }

    @Step("Validating Targeting description field accepting more than 220 characters")
    public boolean ValidateTargetingDescriptionFieldAcceptingMoreThan220Characters() {
        wait.until(ExpectedConditions.elementToBeClickable(TargetingDescriptionField));
        driver.findElement(TargetingDescriptionField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        // System.out.println(nameValue);
        return nameValue.length() > 220;
    }

    @Step("Validate visibility Error message for  empty Targeting Name field")
    public boolean ValidateErrorMessageForEmptyTargetingNameValue() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForTargetingFields));
            return driver.findElement(ErrorMessageForTargetingFields).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility Error message for  empty Targeting description field")
    public boolean ValidateErrorMessageForEmptyTargetingDescriptionValue() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForTargetingFields));
            return driver.findElement(ErrorMessageForTargetingFields).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validate visibility Error message for  empty creative ")
    public boolean ValidateErrorMessageForEmptyCreative() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForCreative));
            return driver.findElement(ErrorMessageForCreative).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Creative remove icon")
    public void ClickOnCreativeRemoveIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeRemoveButton));
        driver.findElement(CreativeRemoveButton).click();
    }

    @Step("Clicking on upload Creative Field")
    public void ClickOnUploadCreativeField() {
        wait.until(ExpectedConditions.elementToBeClickable(UploadCreativeField));
        driver.findElement(UploadCreativeField).click();
    }

    @Step("Enter desired creative tag")
    public void EnterCreativeTag(String Tag) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeSearchField));
        driver.findElement(CreativeSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Tag);
    }

    @Step("Clicking on desired Creative media")
    public void SelectDesiredCreative() {
        wait.until(ExpectedConditions.elementToBeClickable(DesiredCreative));
        driver.findElement(DesiredCreative).click();
    }

    @Step("Clicking on choose button")
    public void ClickOnChooseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ChooseButton));
        driver.findElement(ChooseButton).click();
    }
}
