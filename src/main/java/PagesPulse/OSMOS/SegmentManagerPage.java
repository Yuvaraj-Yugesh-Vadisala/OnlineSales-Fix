package PagesPulse.OSMOS;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Locale;

public class SegmentManagerPage {
    WebDriver driver;
    WebDriverWait wait;

    public SegmentManagerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By WhiteLoader = By.xpath("//div[contains(@class,'loader-wrapper white-loader')]");
    final By AdvertiserSegmentManager = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-advertiser-segment_manager')]");
    final By AddNewSegmentButton = By.xpath("//button[contains(@class,'pendo-feature-kam-add-segment-float-button-click')]");
    final By SegmentNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-segment-name')]/descendant::div[contains(@class,'input')]");
    final By EveryOneToggle = By.xpath("(//div[contains(@class,'radio-wrapper')])[2]");
    final By OnlyMeToggle = By.xpath("(//div[contains(@class,'radio-wrapper')])[1]");
    final By AddSegmentElementButton = By.xpath("//div[contains(@class,'pendo-track-segment-column-add-button')]");
    //div[contains(@class,'pendo-track-segment-column-add-button')]/descendant::span[contains(@class,'plus')]
    final By DeleteAddedSegmentElementButton = By.xpath("//div[contains(@class,'pendo_ott_feature_remove_rule_action_button')]");
    final By ElementSearchField = By.xpath("//div[contains(@class,'popover-body')]/descendant::div[contains(@class,'input-wrapper')]");
    final String SegmentElements = ("(//div[contains(@class,'scrollable-content')]/descendant::div[contains(@class,'menu-item-right')])[%d]");
    final By SegmentValueField = By.xpath("//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::div[contains(@class,'input-wrapper')]");
    final By SegmentSaveButton = By.xpath("//button[contains(@class,'pendo-feature-kam-segment-creation-form-save-click button')]");
    final By ConditionDropdown = By.xpath("//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::div[contains(@class,'drodown-wrapper')]");
    final String ConditionOptions = ("(//div[contains(@class,'Select__menu-list')]/descendant::div[contains(@class,'Select__option')])[%d]");
    final By EligibleMerchantCount = By.xpath("//div[contains(@class,'eligible-merchant-count-loader animated-bg')]");
    final By SuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By ErrorMessageForEmptyField = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final String SegmentMenu = ("(//td[contains(@class,'segmentAction')]/descendant::div[contains(@class,'dropdown')])[%d]");
    final By SegmentEditButton = By.xpath("//a[contains(@class,'pendo-feature-kam-segment-edit-option')]");
    final By SegmentDuplicateButton = By.xpath("//a[contains(@class,'pendo-feature-kam-segment-duplicate-option')]");
    final By SegmentEditPage = By.xpath("//div[contains(@class,'drawer-header drawer-flex')]/descendant::span[contains(text(),'Edit')]");
    final By DownloadMerchantListButton = By.xpath("//a[contains(@class,'pendo-feature-kam-segment-download-merchants-option')]");
    final By DownloadButton = By.xpath("//button[contains(@class,'pendo-track-bulk-download-button')]");
    final By DisabledDownloadButton = By.xpath("//button[contains(@class,'pendo-track-bulk-download-button') and contains(@class,'disabled')]");
    final By ErrorMessageForSegmentNameField = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final By ErrorMessageForSegmentElement = By.xpath("//div[contains(@class,'pendo-track-segment-empty-error')]");

    @Step("Clicking on Advertiser Segment Manager")
    public void ClickOnAdvertiserSegmentManager() {
        wait.until(ExpectedConditions.elementToBeClickable(AdvertiserSegmentManager));
        driver.findElement(AdvertiserSegmentManager).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));
    }
    @Step("Clicking on Add new segment button")
    public void ClickOnAdNewSegmentButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddNewSegmentButton));
        driver.findElement(AddNewSegmentButton).click();
    }

    @Step("Clicking on Everyone toggle for segment visibility")
    public void SelectEveryOneToggle() {
        wait.until(ExpectedConditions.elementToBeClickable(EveryOneToggle));
        driver.findElement(EveryOneToggle).click();
    }
    @Step("Clicking on Add segments Elements button")
    public void ClickOnAddSegmentElementButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddSegmentElementButton));
        driver.findElement(AddSegmentElementButton).click();
    }
    @Step("Entering Segment element Name")
    public void EnterDesiredElementName(String SegmentName) {
        wait.until(ExpectedConditions.elementToBeClickable(ElementSearchField));
        driver.findElement(ElementSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(SegmentName);
    }
    @Step("Select desired segment element")
    public void SelectDesiredSegmentOption(int optionNo) {
        String formattedXpath = String.format(String.valueOf(SegmentElements), optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }
    @Step("Entering Segment Value")
    public void EnterSegmentValue(String SegmentValue) {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentValueField));
        driver.findElement(SegmentValueField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(SegmentValue);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(EligibleMerchantCount));
    }
    @Step("Clicking on Segment Save button")
    public void ClickOnSegmentSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentSaveButton));
        driver.findElement(SegmentSaveButton).click();
    }
    @Step("Clicking on cross icon to delete added segment element")
    public void ClickOnCrossIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(DeleteAddedSegmentElementButton));
        driver.findElement(DeleteAddedSegmentElementButton).click();
    }
    @Step("Clicking on condition dropdown")
    public void ClickOnConditionDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(ConditionDropdown));
        driver.findElement(ConditionDropdown).click();
    }
    @Step("Select desired condition")
    public void SelectDesiredSegmentCondition(int optionNo) {
        String formattedXpath = String.format(String.valueOf(ConditionOptions), optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }
    @Step("Validate visibility of Error message for segment name")
    public boolean ValidateVisibilityOfSuccessPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessPopUp));
            return driver.findElement(SuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    } @Step("Validate visibility of Error message for segment name")
    public boolean ValidateErrorMessageForEmptyField() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForEmptyField));
            return driver.findElement(ErrorMessageForEmptyField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    public static StringBuilder RandomSegmentName;
    public  final static String SegmentName = String.valueOf(RandomSegmentName);


    @Step("Entering Segment Name")
    public void EnterSegmentName(String Segment, int count) {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentNameField));
        driver.findElement(SegmentNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        RandomSegmentName = generateRandomData(Segment, count);
        driver.switchTo().activeElement().sendKeys(RandomSegmentName);
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
    @Step("Entering Segment Name")
    public void EnterSegmentName(String SegmentName) {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentNameField));
        driver.findElement(SegmentNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(SegmentName);
    }
    @Step("Click on three  dots")
    public void ClickOnThreeDots(int optionNo) {
        String formattedXpath = String.format(String.valueOf(SegmentMenu), optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }
    @Step("Clicking on Segment edit button")
    public void ClickOnSegmentEditButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentEditButton));
        driver.findElement(SegmentEditButton).click();
    }
    @Step("Clicking on merchant download button")
    public void ClickOnMerchantDownloadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DownloadMerchantListButton));
        driver.findElement(DownloadMerchantListButton).click();
    }
    @Step("Clicking on  download button")
    public boolean ClickOnDownloadButton() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(120));
            ExtensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(DisabledDownloadButton));
            ExtensiveWait.until(ExpectedConditions.elementToBeClickable(DownloadButton));
            driver.findElement(DownloadButton).click();
            return false;
        }catch (Exception e){
            return true;
        }
    }
    @Step("Clicking on Segment duplicate button")
    public void ClickOnSegmentDuplicateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SegmentDuplicateButton));
        driver.findElement(SegmentDuplicateButton).click();
    }
    @Step("Validate visibility of edit page")
    public boolean ValidateVisibilityEditPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SegmentEditPage));
            return driver.findElement(SegmentEditPage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate visibility Error message for segment name field")
    public boolean ValidateErrorMessageForSegmentNameField() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForSegmentNameField));
            return driver.findElement(ErrorMessageForSegmentNameField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate visibility Error message for segment Element")
    public boolean ValidateErrorMessageForSegmentElement() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForSegmentElement));
            return driver.findElement(ErrorMessageForSegmentElement).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
