package PagesPulse.OSMOS;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ProductAdsYieldControlPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductAdsYieldControlPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By WhiteLoader = By.xpath("//div[contains(@class,'loader-wrapper white-loader')]");
    final By ProductAdsYieldControl = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-advance-yield_control')]");
    final By DefaultFloorBidField = By.xpath("//div[contains(@class,'pendo-track-yield-contol-default-floor-bid')]/descendant::input");
    final By DefaultCeilingBidField = By.xpath("//div[contains(@class,'pendo-track-yield-contol-default-ceiling-bid')]/descendant::input");
    final By DefaultMultiplierBidField = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-default-bid-multiplier')]/descendant::div[contains(@class,'input-wrapper')])[2]");
    final By ReviewAndApplyButton = By.xpath("//button[contains(@class,'pendo_feature_yield_control_review_and_apply_btn')]");
    final By ProductAdsYieldApplyButton = By.xpath("//button[contains(@class,'pendo_feature_yield_control_save_btn')]");
    final By DisabledProductAdsYieldApplyButton = By.xpath("//button[contains(@class,'pendo_feature_yield_control_save_btn button-primary shape-cornor medium disabled')]");
    final By YesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By SuccessPopup = By.xpath("//div[contains(@class,'Toastify__toast-theme--colored Toastify__toast--success')]");
    final String CheckBox = ("(//div[contains(@class,'single-select-checkbox')])[%d]");
    final String BidOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final By ResetBidDropdown = By.xpath("//div[contains(@class,'pendo-track-yield-control-snackbar-reset-bid')]");
    final By UpdateBidDropdown = By.xpath("//div[contains(@class,'pendo-track-yield-control-snackbar-update-bid')]");
    final By UpdateTypeDropdown = By.xpath("//div[contains(@class,'modal-content')]/descendant::div[contains(@class,'os-select-dropdown')]");
    final String UpdateTypeOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final By PercentValueRadio = By.xpath("(//div[contains(@class,'radio-wrapper')])[2]");
    final By NumericValueRadio = By.xpath("(//div[contains(@class,'radio-wrapper')])[1]");
    final By ValueField = By.xpath("//div[contains(@class,'modal-content')]/descendant::div[contains(@class,'input-wrapper')]");
    final By DoneButton = By.xpath("//button[contains(@class,'pendo_feature_yield_control_selected_rows_bult_action')]");
    final By CloseButton = By.xpath("// button[contains(@class,'close')]");
    final By ErrorMessageForFloorAndCeilingField = By.xpath("//div[contains(@class,'pendo-track-yield-contol-bid-group')]/descendant::div[contains(@class,'error')]");
    final By ErrorMessageForMultiplierBidField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-default-bid-multiplier')]/descendant::div[contains(@class,'error')]");
    final By IndividualFloorBidEditButton = By.xpath("(//span[contains(@class,'pendo_feature_yield_control_cell_edit_btn')])[1]");
    final By IndividualCeilingBidEditButton = By.xpath("(//span[contains(@class,'pendo_feature_yield_control_cell_edit_btn')])[2]");
    final By IndividualBidMultiplierValueField = By.xpath("(//span[contains(@class,'pendo_feature_yield_control_cell_edit_btn')])[3]");
    final By FloorBidExistingValue = By.xpath("(//label[contains(@class,'default-value')])[1]");
    final By CeilingBidExistingValue = By.xpath("(//label[contains(@class,'default-value')])[2]");
    final By BidMultiplierExistingValue = By.xpath("(//label[contains(@class,'default-value')])[3]");
    final By CeilingValueErrorMessage = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By IndividualActiveField = By.xpath("//td[contains(@class,'bidColumn')]/descendant::div[contains(@class,'in-progress-wrapper')]/input");
                                                            //td[contains(@class,'pendo-track-yield-control-table')]/descendant::input
    @Step("Clicking on Product Ads Yield Control")
    public void ClickOnProductAdsYieldControl() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductAdsYieldControl));
        driver.findElement(ProductAdsYieldControl).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));
    }

    @Step("Enter default floor bid value")
    public void EnterDefaultFloorBidValue(String FloorBid) {
        wait.until(ExpectedConditions.elementToBeClickable(DefaultFloorBidField));
        driver.findElement(DefaultFloorBidField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(FloorBid);
    }

    @Step("Enter default Ceiling bid value")
    public void EnterDefaultCeilingBidValue(String CeilingBid) {
        wait.until(ExpectedConditions.elementToBeClickable(DefaultCeilingBidField));
        driver.findElement(DefaultCeilingBidField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(CeilingBid);
    }

    @Step("Enter default bid multiplier value")
    public void EnterDefaultBidMultiplierValue(String MultiplierValue) {
        wait.until(ExpectedConditions.elementToBeClickable(DefaultMultiplierBidField));
        driver.findElement(DefaultMultiplierBidField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(MultiplierValue);

    }

    @Step("Clicking on Review and Apply Button")
    public void ClickOnReviewAndApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ReviewAndApplyButton));
        driver.findElement(ReviewAndApplyButton).click();
    }

    @Step("Clicking on product ads yield apply button")
    public void ClickProductAdsYieldApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductAdsYieldApplyButton));
        driver.findElement(ProductAdsYieldApplyButton).click();
    }

    @Step("Clicking on yes button to confirm")
    public void ClickYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(YesButton));
        driver.findElement(YesButton).click();
    }

    @Step("Validate visibility of success pop up for product ads yield application")
    public boolean ValidateVisibilityOfSuccessPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessPopup));
            return driver.findElement(SuccessPopup).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on category checkboxes option")
    public void ClickOnCheckBox(int optionNo) {
        String formattedXpath = String.format(CheckBox, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Clicking reset bid dropdown")
    public void ClickOnResetBidDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(ResetBidDropdown));
        driver.findElement(ResetBidDropdown).click();
    }

    @Step("Clicking Update bid dropdown")
    public void ClickOnUpdateBidDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(UpdateBidDropdown));
        driver.findElement(UpdateBidDropdown).click();
    }

    @Step("Selecting desired bid")
    public void SelectDesiredBidOption(int optionNo) {
        String formattedXpath = String.format(BidOptions, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Clicking Update bid type dropdown")
    public void ClickOnUpdateTypeDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(UpdateTypeDropdown));
        driver.findElement(UpdateTypeDropdown).click();
    }

    @Step("Clicking on percent type radio")
    public void SelectPercentTypeRadio() {
        wait.until(ExpectedConditions.elementToBeClickable(PercentValueRadio));
        driver.findElement(PercentValueRadio).click();
    }

    @Step("Clicking on Numeric type radio")
    public void SelectNumericTypeRadio() {
        wait.until(ExpectedConditions.elementToBeClickable(NumericValueRadio));
        driver.findElement(NumericValueRadio).click();
    }

    @Step("Selecting desired Update type")
    public void SelectDesiredUpdateType(int optionNo) {
        String formattedXpath = String.format(UpdateTypeOptions, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Enter value which need to be updated")
    public void EnterUpdateValue(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(ValueField));
        driver.findElement(ValueField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(value);
    }

    @Step("Clicking on Done Button")
    public void ClickDoneButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DoneButton));
        driver.findElement(DoneButton).click();
    }

    @Step("Validate visibility of Error Message for default floor and ceiling bid value")
    public boolean ValidateErrorMessageForBidFields() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForFloorAndCeilingField));
            return driver.findElement(ErrorMessageForFloorAndCeilingField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility of Error Message for default multiplier bid value")
    public boolean ValidateErrorMessageForMultiplierBidField() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForMultiplierBidField));
            return driver.findElement(ErrorMessageForMultiplierBidField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate visibility disabled apply button")
    public boolean ValidateVisibilityOfDisabledApplyButton() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DisabledProductAdsYieldApplyButton));
            return driver.findElement(DisabledProductAdsYieldApplyButton).getAttribute("class").contains("disable");
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Clicking on cross icon to close the pop window")
    public void ClickCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CloseButton));
        driver.findElement(CloseButton).click();
    }
    @Step("Validate whether the floor bid field accepts negative values or not")
    public boolean ValidateDefaultFloorBidFieldWithNegativeValue() {
        boolean flag = true;
        wait.until(elementToBeClickable(DefaultFloorBidField));
        driver.findElement(DefaultFloorBidField).click();
        String actualText = driver.findElement(DefaultFloorBidField).getAttribute("value");
        if (actualText.contains("-")) {
            flag = false;
        }
        return flag;
    }
    @Step("Validate whether the Ceiling bid field accepts negative values or not")
    public boolean ValidateDefaultCeilingBidFieldWithNegativeValue() {
        boolean flag = true;
        wait.until(elementToBeClickable(DefaultCeilingBidField));
        driver.findElement(DefaultCeilingBidField).click();
        String actualText = driver.findElement(DefaultCeilingBidField).getAttribute("value");
        if (actualText.contains("-")) {
            flag = false;
        }
        return flag;
    }
    @Step("Validate whether the bid multiplier field accepts negative values or not")
    public boolean ValidateDefaultBidMultiplierFieldWithNegativeValue() {
        boolean flag = true;
        driver.findElement(DefaultCeilingBidField).click();
        String actualText = driver.findElement(DefaultMultiplierBidField).getText();
        if (actualText.contains("-")) {
            flag = false;
        }
        return flag;
    }
    @Step("Entering Special characters and alphabets in Floor bid value")
    public boolean ValidateDefaultFloorBidFieldWithSpecialCharactersAndAlphabets() {
        boolean flag = false;
        wait.until(elementToBeClickable(DefaultFloorBidField));
        driver.findElement(DefaultFloorBidField).click();
        String actualText = driver.findElement(DefaultFloorBidField).getAttribute("value");
        if (actualText.equals("0")) {
            flag = true;
        }
        return flag;
    }
    @Step("Entering Special characters and alphabets in Ceiling bid value")
    public boolean ValidateDefaultCeilingBidFieldWithSpecialCharactersAndAlphabets() {
        boolean flag = false;
        wait.until(elementToBeClickable(DefaultCeilingBidField));
        driver.findElement(DefaultCeilingBidField).click();
        String actualText = driver.findElement(DefaultCeilingBidField).getAttribute("value");
        if (actualText.equals("0")) {
            flag = true;
        }
        return flag;
    }
    @Step("Entering Special characters and alphabets in default bid multiplier field")
    public boolean ValidateDefaultBidMultiplierFieldWithSpecialCharactersAndAlphabets() {
        boolean flag = false;
        driver.findElement(DefaultCeilingBidField).click();
        String actualText = driver.findElement(DefaultMultiplierBidField).getText();
        System.out.println(actualText);
        if (actualText.isEmpty()) {
            flag = true;
        }
        return flag;
    }
    @Step("Enter individual floor bid value")
    public void EnterIndividualFloorBidValue(String FloorBid) {
        wait.until(ExpectedConditions.elementToBeClickable(FloorBidExistingValue));
        driver.findElement(FloorBidExistingValue).click();
        driver.findElement(IndividualFloorBidEditButton).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(FloorBid);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

    }
    @Step("Enter individual floor bid value")
    public void EnterIndividualCeilingBidValue(String FloorBid) {
        wait.until(ExpectedConditions.elementToBeClickable(CeilingBidExistingValue));
        driver.findElement(CeilingBidExistingValue).click();
        driver.findElement(IndividualCeilingBidEditButton).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(FloorBid);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    @Step("Enter individual floor bid value")
    public void EnterIndividualBidMultiplierValue(String FloorBid) {
        wait.until(ExpectedConditions.elementToBeClickable(BidMultiplierExistingValue));
        driver.findElement(BidMultiplierExistingValue).click();
        driver.findElement(IndividualBidMultiplierValueField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(FloorBid);
//        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }
    @Step("Validate visibility of Error Message when Ceiling value is entered less than floor bid")
    public boolean ValidateErrorMessageForCeilingBidBeingLessThanFloorBid() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CeilingValueErrorMessage));
            return driver.findElement(CeilingValueErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate whether individual floor bid accepts negative value or not")
    public boolean ValidateIndividualFloorBidNotAcceptingNegativeValue() {
        boolean flag = true;
        wait.until(ExpectedConditions.elementToBeClickable(FloorBidExistingValue));
        driver.findElement(FloorBidExistingValue).click();
        driver.findElement(IndividualFloorBidEditButton).click();
        String actualText = driver.findElement(IndividualActiveField).getAttribute("value");
        System.out.println(actualText);
        if (actualText.contains("-")) {
            flag = false;
        }
        return flag;
    }

    @Step("Validate whether individual ceiling bid accepts negative value or not")
    public boolean ValidateIndividualCeilingBidNotAcceptingNegativeValue() {
        boolean flag = true;
        wait.until(ExpectedConditions.elementToBeClickable(CeilingBidExistingValue));
        driver.findElement(CeilingBidExistingValue).click();
        driver.findElement(IndividualCeilingBidEditButton).click();
        String actualText = driver.findElement(IndividualActiveField).getAttribute("value");
        System.out.println(actualText);
        if (actualText.contains("-")) {
            flag = false;
        }
        return flag;
    }
    @Step("Validate whether individual  bid multiplier accepts negative value or not")
    public boolean ValidateIndividualBidMultiplierNotAcceptingNegativeValue() {
        boolean flag = true;
        wait.until(ExpectedConditions.elementToBeClickable(BidMultiplierExistingValue));
        driver.findElement(BidMultiplierExistingValue).click();
        driver.findElement(IndividualBidMultiplierValueField).click();
        String actualText = driver.findElement(IndividualActiveField).getAttribute("value");
        System.out.println(actualText);
        if (actualText.contains("-")) {
            flag = false;
        }
        return flag;
    }

}

