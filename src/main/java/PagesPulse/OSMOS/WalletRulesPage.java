package PagesPulse.OSMOS;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

public class WalletRulesPage {
    WebDriver driver;
    WebDriverWait wait;

    public WalletRulesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }
    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By WalletRules = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-wallet-rules')]");
    final By AddPageButton = By.xpath("//button[contains(@class,'table-fixed-btn')]");
    final By WalletNameField = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::input)[1]");
    final By WalletDescriptionField = By.xpath("//div[contains(@class,'form-component-wrapper')]/descendant::textarea");
    final By ScheduleRadioButton = By.xpath("//input[contains(@id,'SCHEDULE-')]/following-sibling::label");
    final By LookBackPeriodField = By.xpath("//div[contains(@class,'usedata-form-wrapper')]/descendant::div[contains(@class,'os-select-dropdown')]");
    final By YesConfirmationButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By LookBackPeriodSearchField = By.xpath("(//div[contains(@class,'os-select-dropdown')]/descendant::input)[1]");
    final String GenericOptionsSelectorXpath = "(//div[contains(@id,'-option-')])[%d]";
    final By ActionsConditionField = By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::input)[5]");
    final By ActionsAmountField = By.xpath("(//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::input)[1]");
    final By ActionsDescriptionField = By.xpath("(//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::input)[2]");
    final By SchedulePeriodField = By.xpath("(//div[contains(@class,'pendo-track-filter-action-dropdown')]/descendant::div[contains(@class,'os-select-dropdown')])[2]");
    final By ScheduleDayField = By.xpath("//div[contains(@class,'WEEKLY')]/descendant::div[contains(@class,'os-select-dropdown')]");
    final By ScheduleDaySearchField = By.xpath("//div[contains(@class,'WEEKLY')]/descendant::input");
    final By ScheduleSelectTimeField = By.xpath("//span[contains(@class,'time-picker-time')]");
    final String SelectTimeHourDropDown = "(//div[contains(@class,'custom-timepicker-li')]/descendant::span[contains(@class,'tp-hour-data')])[%d]";
    final String SelectTimeMinuteDropDown = "(//div[contains(@class,'custom-timepicker-li')]/descendant::span[contains(@class,'tp-min-data')])[%d]";
    final By NotifyMeField = By.xpath("//div[contains(@class,'notifyMe-form-wrapper')]/descendant::div[contains(@class,'os-select-dropdown')]");
    final By NotifyMeSearchField = By.xpath("//div[contains(@class,'notifyMe-form-wrapper')]/descendant::input");
    final By NotifyMeGmailField = By.xpath("(//div[contains(@class,'notifyMe-form-wrapper')]/descendant::input)[2]");
    final By WalletCreateButton = By.xpath("(//div[contains(@class,'add-new-rule-form-footer')]/descendant::button)[1]");
    final By PageTableFirstRowPageName = By.xpath("(//tbody[contains(@role,'rowgroup')]/descendant::label/span)[2]");
    final By TableSearchField = By.xpath("//div[contains(@class,'pendo_feature_table_search_input')]/descendant::input");
    final By WalletNameFieldEmptyErrorMessage = By.xpath("(//div[contains(@class,' pendo-track-field-empty-error')])[1]");
    final By WalletDescriptionFieldEmptyErrorMessage = By.xpath("(//div[contains(@class,' pendo-track-field-empty-error')])[1]");
    final By RuleTypeField =By.xpath("(//div[contains(@class,'form-component-wrapper')]/descendant::input)[4]");
    final By ActionsDescriptionFieldEmptyErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::div[contains(@class,'pendo-track-field-empty-error')])[2]");
    final By ActionsValueFieldEmptyErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::div[contains(@class,'pendo-track-field-empty-error')])[1]");
    final By WalletInvalidMailPopUp = By.xpath("//div[contains(@class,'Toastify__toast-theme--colored Toastify__toast--error')]");
    final By SavedMailRemoveIcon = By.xpath("//i[contains(@class,'remove-pill icon icon-close1')]");
    final By EmptyMailEmptyErrorMessage = By.xpath("(//div[contains(@class,'notifyMe-form-wrapper')]/descendant::div[contains(@class,'error-msg name-error-message')])[1]");
    final By SavedTagData = By.xpath("//div[contains(@class,'tab-input-field-form')]/span");
    final By SelectADateErrorMessage = By.xpath("(//div[contains(@class,'form-rule-schedule')]/descendant::div[contains(@class,'error-msg name-error-message')])[2]");
    final By SelectTimeErrorMessage = By.xpath("(//div[contains(@class,'form-rule-schedule')]/descendant::div[contains(@class,'error-msg name-error-message')])[3]");

    @Step("Clicking on Page Set Up")
    public void ClickOnPageSetUp() {
        wait.until(ExpectedConditions.elementToBeClickable(WalletRules));
        driver.findElement(WalletRules).click();
    }
    @Step("Clicking on Add Page Button")
    public void ClickOnAddPageButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddPageButton));
        driver.findElement(AddPageButton).click();
    }

    public static StringBuilder RandomString(String fixedPart, int count, String type) {
        String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk_0123456789";
        StringBuilder randomString = new StringBuilder();
        SecureRandom rand = new SecureRandom();

        // Append fixed part
        randomString.append(fixedPart);

        if (type.equalsIgnoreCase("text")) {
            // Generate random alphanumeric string if type is "text"
            for (int i = 0; i < count; i++) {
                int randomIndex = rand.nextInt(ALPHANUMERIC_STRING.length());
                char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
                randomString.append(randomChar);
            }
        } else if (type.equalsIgnoreCase("time")) {
            // Append current timestamp if type is "time"
            String currentTimeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            randomString.append(currentTimeStamp);
        }

        return randomString;
    }


    public String WalletName;
    @Step("Entering data into the wallet name field")
    public void EnterWalletName(String FixedData, int Count, String Time) {
        wait.until(ExpectedConditions.elementToBeClickable(WalletNameField));
        driver.findElement(WalletNameField).click();
        driver.findElement(WalletNameField).sendKeys(controlOrCommandKey + "a");
        WalletName = String.valueOf(RandomString(FixedData,Count,Time));
        driver.findElement(WalletNameField).sendKeys(WalletName);
    }

    @Step("Entering data into the wallet description field")
    public void EnterDataInWalletDescriptionField(String walletName) {
        wait.until(ExpectedConditions.elementToBeClickable(WalletDescriptionField));
        driver.findElement(WalletDescriptionField).click();
        driver.findElement(WalletDescriptionField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(WalletDescriptionField).sendKeys(walletName);
    }


    @Step("Clicking on schedule radio button")
    public void ClickOnScheduleRadioButton() {
        WebElement element = driver.findElement(ScheduleRadioButton);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(ScheduleRadioButton));
        driver.findElement(ScheduleRadioButton).click();
    }

    @Step("Clicking on look back Period Field")
    public void ClickOnLookBackPeriodField() {
        wait.until(ExpectedConditions.elementToBeClickable(LookBackPeriodField));
        driver.findElement(LookBackPeriodField).click();
    }

    @Step("Clicking on yes button")
    public void ClickingOnYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(YesConfirmationButton));
        driver.findElement(YesConfirmationButton).click();
    }


    @Step("Entering data into the wallet description field")
    public void EnterDataInLookBackPeriodSearchFieldField(String walletName) {
//        wait.until(ExpectedConditions.elementToBeClickable(LookBackPeriodSearchField));
//        driver.findElement(LookBackPeriodSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(walletName);
    }

    @Step("Optional click on generic options selector")
    public void ClickOnGenericOptionsSelector(int optionIndex) {
        String xpathFormatter = String.format(GenericOptionsSelectorXpath, optionIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }

    @Step("Clicking on actions condition field")
    public void ClickingOnActionsConditionField() {
        WebElement element = driver.findElement(ActionsDescriptionField);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(ActionsConditionField));
        driver.findElement(ActionsConditionField).click();
    }

    @Step("Entering data into the actions condition search field ")
    public void EnterDataInActionsConditionSearchField(String walletName) {
        wait.until(ExpectedConditions.elementToBeClickable(ActionsConditionField));
        driver.findElement(ActionsConditionField).click();
        driver.findElement(ActionsConditionField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ActionsConditionField).sendKeys(walletName);
    }


    @Step("Entering data into the actions amount search field ")
    public void EnterDataInActionsAmountField(String walletAmount) {
        WebElement element = driver.findElement(ActionsDescriptionField);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(ActionsAmountField));
        driver.findElement(ActionsAmountField).click();
        driver.findElement(ActionsAmountField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ActionsAmountField).sendKeys(walletAmount);
    }


    @Step("Entering data into the actions description search field ")
    public void EnterDataInActionsDescriptionField(String Data) {
        WebElement element = driver.findElement(ActionsDescriptionField);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(ActionsDescriptionField));
        driver.findElement(ActionsDescriptionField).click();
        driver.findElement(ActionsDescriptionField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ActionsDescriptionField).sendKeys(Data);
    }

    @Step("Clicking on schedule period field")
    public void ClickingOnSchedulePeriodField() {
        WebElement element = driver.findElement(NotifyMeField);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(SchedulePeriodField));
        driver.findElement(SchedulePeriodField).click();
    }

    @Step("Clicking on schedule day field")
    public void ClickingOnScheduleDayField() {
        wait.until(ExpectedConditions.elementToBeClickable(ScheduleDayField));
        driver.findElement(ScheduleDayField).click();
    }
    @Step("Entering data into the schedule day search field ")
    public void EnterDataInScheduleDaySearchField(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(ScheduleDaySearchField));
        driver.findElement(ScheduleDaySearchField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ScheduleDaySearchField).sendKeys(Data);
    }

    @Step("Clicking on schedule time field")
    public void ClickingOnScheduleTimeField() {
        wait.until(ExpectedConditions.elementToBeClickable(ScheduleSelectTimeField));
        driver.findElement(ScheduleSelectTimeField).click();
    }



    @Step("Click on Select Time Hour Drop Down")
    public void ClickOnSelectTimeHourDropDown(int index) {
        String xpathFormatter = String.format(SelectTimeHourDropDown, index+1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }




    @Step("Click on select time Minute Drop Down")
    public void ClickOnSelectTimeMinuteDropDown(int index) {
        String xpathFormatter = String.format(SelectTimeMinuteDropDown, index+1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }




    @Step("Clicking on notify me field time")
    public void ClickingOnNotifyMeField() {
        WebElement element = driver.findElement(NotifyMeField);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(NotifyMeField));
        driver.findElement(NotifyMeField).click();
    }


    @Step("Entering data into the notify me search field ")
    public void EnterDataInNotifyMeSearchField(String Data) {
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'-internal-user-only')]/descendant::span[contains(@class,'os-toggle-switch-round')]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(NotifyMeSearchField));
        driver.findElement(NotifyMeSearchField).click();
        driver.findElement(NotifyMeSearchField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(NotifyMeSearchField).sendKeys(Data);
    }

    @Step("Entering data into the notify me gmail field ")
    public void EnterDataInNotifyMeGmailField(String Data) throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(NotifyMeGmailField));
        driver.findElement(NotifyMeGmailField).click();
        driver.findElement(NotifyMeGmailField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(NotifyMeGmailField).sendKeys(Data);
    }


    @Step("Clicking on enter icon")
    public void ClickEnterIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(NotifyMeGmailField));
        driver.findElement(NotifyMeGmailField).sendKeys(Keys.ENTER);
    }

    @Step("Clicking on wallet create button")
    public void ClickWalletCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(WalletCreateButton));
        driver.findElement(WalletCreateButton).sendKeys(Keys.ENTER);
    }
    @Step("Validating created wallet rule is present in table")
    public boolean ValidatingCreatedWalletRule() {
        String PageName = driver.findElement(PageTableFirstRowPageName).getText();
        // System.out.println(PageName);
        return WalletName.equals(PageName);
    }
    @Step("Enter data in the table search field")
    public void EnterDataInTableSearchField(String searchData) {
        wait.until(ExpectedConditions.elementToBeClickable(TableSearchField));
        driver.findElement(TableSearchField).clear();
        driver.findElement(TableSearchField).sendKeys(searchData);
    }

    @Step("Entering Spaces into the wallet name field")
    public void EnterSpacesInWalletNameField(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(WalletNameField));
        driver.findElement(WalletNameField).click();
        driver.findElement(WalletNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(WalletNameField).sendKeys(Data);
    }



    @Step("Validate wallet name field empty error message is displayed")
    public boolean ValidateWalletNameFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(WalletNameFieldEmptyErrorMessage));
            return driver.findElement(WalletNameFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validate wallet description field empty error message is displayed")
    public boolean ValidateWalletDescriptionFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(WalletDescriptionFieldEmptyErrorMessage));
            return driver.findElement(WalletDescriptionFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating  wallet name field accepts only spaces")
    public boolean ValidateWalletNameFieldAcceptsOnlySpaces() {
        driver.findElement(WalletNameField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(WalletNameField).getAttribute("value").trim().isEmpty();
    }


    @Step("Entering more than 50 characters in wallet name field")
    public void EnterMoreThan50CharactersInWalletNameField() {
        wait.until(ExpectedConditions.elementToBeClickable(WalletNameField));
        driver.findElement(WalletNameField).click();
        driver.findElement(WalletNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(WalletNameField).sendKeys(RandomString("QaTesting",55,"text"));
    }

    @Step("Validating wallet name field accepting more than 50 characters")
    public boolean ValidateWalletNameFieldAcceptingMoreThan50Characters() {
        wait.until(ExpectedConditions.elementToBeClickable(WalletNameField));
        driver.findElement(WalletNameField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.length()>50;
    }


    @Step("Validating wallet description field accepts only spaces")
    public boolean ValidateWalletDescriptionFieldAcceptsOnlySpaces() {
        driver.findElement(WalletDescriptionField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(WalletDescriptionField).getAttribute("value").trim().isEmpty();
    }

    @Step("Clicking on rule type field")
    public void ClickingOnRuleTypeField() {
        wait.until(ExpectedConditions.elementToBeClickable(RuleTypeField));
        driver.findElement(RuleTypeField).click();
    }

    @Step("Entering data into the rule type search field")
    public void EnterDataInWalletRuleTypeSearchField(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(RuleTypeField));
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Data);
    }

    @Step("Validating wallet actions value field accepting characters")
    public boolean ValidateWalletActionsValueFieldAcceptingCharacters(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(ActionsAmountField));
        driver.findElement(ActionsAmountField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }
    @Step("Validating wallet actions value field accepting negative value")
    public boolean ValidateWalletActionsValueFieldAcceptingNegativeValue(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(ActionsAmountField));
        driver.findElement(ActionsAmountField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.contains("-");
    }


    @Step("Validating wallet actions description field accepts only spaces")
    public boolean ValidateWalletActionsDescriptionFieldAcceptsOnlySpaces() {
        driver.findElement(ActionsDescriptionField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(ActionsDescriptionField).getAttribute("value").trim().isEmpty();
    }

    @Step("Validate wallet action description field empty error message is displayed")
    public boolean ValidateWalletActionDescriptionFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ActionsDescriptionFieldEmptyErrorMessage));
            return driver.findElement(ActionsDescriptionFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
        @Step("Validate wallet action value field empty error message is displayed")
        public boolean ValidateWalletActionValueFieldEmptyErrorMessage() {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(ActionsValueFieldEmptyErrorMessage));
                return driver.findElement(ActionsValueFieldEmptyErrorMessage).isDisplayed();
            } catch (NoSuchElementException | TimeoutException e) {
                return false;
            }
        }

    @Step("Validate invalid mail pop up is displayed")
    public boolean ValidateInvalidMailPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(WalletInvalidMailPopUp));
            return driver.findElement(WalletInvalidMailPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on saved mail remove icon")
    public void ClickingOnSavedMailRemoveIcon() {
        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'-internal-user-only')]/descendant::span[contains(@class,'os-toggle-switch-round')]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(SavedMailRemoveIcon));
        driver.findElement(SavedMailRemoveIcon).click();
    }

    @Step("Validate empty mail error pop up is displayed")
    public boolean ValidateEmptyMailErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(EmptyMailEmptyErrorMessage));
            return driver.findElement(EmptyMailEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
}
    @Step("Validate invalid mail is accepting in saved tags")
    public boolean ValidateInvalidMailIsAcceptingInSavedTags() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SavedTagData));
            return driver.findElement(SavedTagData).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate select a date empty error message is displayed")
    public boolean ValidateSelectADateEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SelectADateErrorMessage));
            return driver.findElement(SelectADateErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate select time empty error message is displayed")
    public boolean ValidateSelectTimeEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SelectTimeErrorMessage));
            return driver.findElement(SelectTimeErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}