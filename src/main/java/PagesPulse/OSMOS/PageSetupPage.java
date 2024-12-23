package PagesPulse.OSMOS;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class PageSetupPage {
    WebDriver driver;
    WebDriverWait wait;

    public PageSetupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }
    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final String SelectingMetricsXpath = "//div[contains(@class,'option-checkbox') and not(contains(@class,'selected'))][%d]";
    final String DeselectingSelectedMetricsXpath = "//div[contains(@class,'option-checkbox') and contains(@class,'selected')][%d]";
    final By AddOrRemoveColumnsButton = By.xpath("//div[contains(@class,'pendo-track-react-table-dynamic-column-click')]/descendant::button");
    final By SavedTagRemoveIcon = By.xpath("//i[contains(@class,'icon-close1')]");
    final By SamePageTypeErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast--error')]");
    final By ApiIdentifierInvalidDataErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-api-identifier')]/descendant::div[contains(@class,'error')]"); //changed
    final By ApiIdentifierEmptyErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-field-empty-error')])[2]");
    final By SavedTagData = By.xpath("//div[contains(@class,'tab-input-field-form')]/span");
    final By PageNameEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");
    final By PageTableFirstRowPageName = By.xpath("(//tbody[contains(@role,'rowgroup')]/descendant::label/span)[1]");
    final By TableSearchField = By.xpath("//div[contains(@class,'pendo_feature_table_search_input')]/descendant::input");
    final By PageCreationSuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast--success')]");
    final By PageCreateButton = By.xpath("//div[contains(@class,'is-sticky-footer')]/button");
    final String ProductCatalogOptionsXpath = "(//div[contains(@class,'checkbox-wrapper')]/descendant::label)[%d]";
    final String TargetingToggleButtonXpath = "(//div[contains(@class,'toggle-section')])[%d]";
    final By ApiIdentifierField = By.xpath("//div[contains(@class,'response-ident-input')]/descendant::input");
    final By TagEnterIcon = By.xpath("//span[contains(@class,'icon-enter')]");
    final By tagsField = By.xpath("//div[contains(@class,'label-align-start-with-input')]/descendant::input");
    final By PageNameField = By.xpath("//div[contains(@class,'page-name-input')]/descendant::input");
    final By AddPageButton = By.xpath("//button[contains(@class,'table-fixed-btn')]");
    final By PageSetUp = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-page-setup')]");
    final By ControlCenterNavButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-control-center')]");

    @Step("Clicking on Control Center Navigation Button")
    public void ClickOnControlCenterNavButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ControlCenterNavButton));
        driver.findElement(ControlCenterNavButton).click();
    }

    @Step("Clicking on Page Set Up")
    public void ClickOnPageSetUp() {
        wait.until(ExpectedConditions.elementToBeClickable(PageSetUp));
        driver.findElement(PageSetUp).click();
    }


    @Step("Clicking on Add Page Button")
    public void ClickOnAddPageButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddPageButton));
        driver.findElement(AddPageButton).click();
    }

    public static StringBuilder PageName;

    @Step("Entering data into the page name field")
    public void EnterPageName(String pageName) {
        wait.until(ExpectedConditions.elementToBeClickable(PageNameField));
        driver.findElement(PageNameField).clear();
        driver.findElement(PageNameField).sendKeys(controlOrCommandKey + "a");
        PageName = RandomString(4);
        driver.findElement(PageNameField).sendKeys(PageName);
    }

    @Step("Entering existing page name into the page name field")
    public void EnterExistingPageName(String pageName) {
        wait.until(ExpectedConditions.elementToBeClickable(PageNameField));
        driver.findElement(PageNameField).clear();
        driver.findElement(PageNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(PageNameField).sendKeys(pageName);
    }


    @Step("Entering tags into the tags field")
    public void EnterTagsField(String tagName) {
        wait.until(ExpectedConditions.elementToBeClickable(tagsField));
        driver.findElement(tagsField).clear();
        driver.findElement(tagsField).sendKeys(tagName);
    }


    @Step("Clicking on enter icon")
    public void ClickEnterIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(TagEnterIcon));
        driver.findElement(tagsField).sendKeys(Keys.ENTER);
        driver.findElement(TagEnterIcon).click();
    }


    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    @Step("User sending data to API identifier field")
    public void EnterDataToApiIdentifierField(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(ApiIdentifierField));
        driver.findElement(ApiIdentifierField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ApiIdentifierField).sendKeys(RandomString(5));
    }

    @Step("Enter existing name to API identifier field")
    public void EnterExistingApiNameApiIdentifierField(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(ApiIdentifierField));
        driver.findElement(ApiIdentifierField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ApiIdentifierField).sendKeys(data);
    }


    @Step("Optional click targeting toggle button")
    public void EnablingTargetingOptions(int TargetingNo) {
        String XpathFormatter = String.format(TargetingToggleButtonXpath, TargetingNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Optional click product catalog options")
    public void EnableProductCatalogOptions(int optionNo) {
        String XpathFormatter = String.format(ProductCatalogOptionsXpath, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Step("Click page create button")
    public void ClickPageCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PageCreateButton));
        driver.findElement(PageCreateButton).click();
    }


    @Step("Check if page creation success pop-up is displayed")
    public boolean IsPageCreationSuccessPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PageCreationSuccessPopUp));
            return driver.findElement(PageCreationSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Enter data in the table search field")
    public void EnterDataInTableSearchField() {
        wait.until(ExpectedConditions.elementToBeClickable(TableSearchField));
        driver.findElement(TableSearchField).clear();
        driver.findElement(TableSearchField).sendKeys(PageName);
    }



    public StringBuilder RandomString(int count) {
        String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk_0123456789";
        StringBuilder randomString = new StringBuilder();
        String fixedPart = "QATesting";
        SecureRandom rand = new SecureRandom();

        randomString.append(fixedPart);

        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            randomString.append(randomChar);

        }

        return randomString;
    }

    @Step("Validating created page is present in table")
    public boolean ValidatingCreatedPage() {
        String pageName = (driver.findElement(PageTableFirstRowPageName).getText());
//        System.out.println(Text);
//        System.out.println(PageName);
//        System.out.println(Text.toString().equals(PageName));
        return PageName.toString().equals(pageName);
    }

    @Step("Clicking on pop up close button")
    public void ClickingOnPopUpCloseButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        ExtensiveWait.until(elementToBeClickable(GenericPopUpCloseButton));
        driver.findElement(GenericPopUpCloseButton).click();
    }


    @Step("Entering data into the page name field")
    public void PageNameFieldWithMaxCount() {
        wait.until(ExpectedConditions.elementToBeClickable(PageNameField));
        driver.findElement(PageNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(PageNameField).sendKeys(RandomString(35));
    }

    @Step("Validating name field for maximum character count")
    public boolean ValidateNameFieldMaxCharacterCount() {
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.length() > 30;
    }

    @Step("Entering data into the page name field")
    public void PageNameFieldWithOnlySpaces() {
        wait.until(ExpectedConditions.elementToBeClickable(PageNameField));
        driver.findElement(PageNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(PageNameField).sendKeys("         ");
    }

    @Step("Validating name field for spaces")
    public boolean ValidateNameFieldNoSpaces() {
        wait.until(ExpectedConditions.elementToBeClickable(PageNameField));
        driver.findElement(PageNameField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.length() > 1;
    }

    @Step("Checking if page name empty error message is displayed")
    public boolean IsPageNameEmptyErrorMessageDisplayed() {
        try {
            return driver.findElement(PageNameEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Entering tags into the tags field")
    public void EnterSpacesInTagsField(String tagName) {
        wait.until(ExpectedConditions.elementToBeClickable(tagsField));
        driver.findElement(tagsField).clear();
        driver.findElement(tagsField).sendKeys(tagName);
    }

    @Step("Validating tag field accept only spaces")
    public boolean ValidateSavedTagDataContainsOnlySpaces() {
        try {
            return driver.findElement(SavedTagData).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Checking if api identifier empty error message is displayed")
    public boolean ValidatingApiIdentifierEmptyErrorMessageDisplayed() {
        try {
            return driver.findElement(ApiIdentifierEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Enter  data to API identifier field")
    public void EnterDataInApiIdentifierField(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(ApiIdentifierField));
        driver.findElement(ApiIdentifierField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ApiIdentifierField).sendKeys(data);
    }

    @Step("Validating name field for spaces")
    public boolean ValidateApiIdentifierFieldWithSpaces() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ApiIdentifierInvalidDataErrorMessage));
            return driver.findElement(ApiIdentifierInvalidDataErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating same page type error pop-up is displayed when enter existing page name")
    public boolean ValidatingSamePageTypeErrorPopUpDisplayedWhenSavingWithExistingPageName() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SamePageTypeErrorPopUp));
            return driver.findElement(SamePageTypeErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Click saved tag remove icon")
    public void clickSavedTagRemoveIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(SavedTagRemoveIcon));
        driver.findElement(SavedTagRemoveIcon).click();
    }


    @Step("Click add or remove columns button")
    public void ClickAddOrRemoveColumnsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddOrRemoveColumnsButton));
        driver.findElement(AddOrRemoveColumnsButton).click();
    }
    @Step("Click to deselect selected metric")
    public void optionalClickDeselectingSelectedMetrics(int metricIndex) {
        String XpathFormatter = String.format(DeselectingSelectedMetricsXpath, metricIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }
    @Step("Click to select metric")
    public void SelectingMetrics(int metricIndex) {
        String XpathFormatter = String.format(SelectingMetricsXpath, metricIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


}
