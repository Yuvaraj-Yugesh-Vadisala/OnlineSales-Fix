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
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CampaignTemplatePage {

    WebDriver driver;
    WebDriverWait wait;

    public CampaignTemplatePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public final StringBuilder TwoHundredWords = createRandomString();
    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");

    final By CampaignTemplateButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-campaign-templates')]");
    final By CreateNewCampaignTemplateButton = By.xpath("//button[contains(@class,'pendo_feature_oms_seller_create_campaign_template_button')]");
    final By TemplateNameField = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-name')]/descendant::input");
    final By GuaranteedUncheckedRadioButton = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-campaign-type')]/descendant::input[contains(@id,'GUARANTEED') and not(contains(@id,'NON'))]");
    final By NonGuaranteedUncheckedRadioButton = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-campaign-type')]/descendant::input[contains(@id,'NON_GUARANTEED')]");
    final By LifeTimeFrequencyField = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-life-time-frequency')]/descendant::div[contains(@class,'white-bg')]");
    final By DailyFrequencyField = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-daily-frequency')]/descendant::div[contains(@class,'white-bg')]");
    final By BasePriceField = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-basic-price-cpm')]/descendant::div[contains(@class,'white-bg')]");
    final By TargetDropdown = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-targets')]/descendant::div[contains(@class,'universal-dd-wrapper')]");
    final String DesiredTarget = "//div[@id='react-select-2-option-%s']";
    final By SurchargeValueField = By.xpath("//input[contains(@class,'pendo-oms-campaign-template-surcharge-input')]");
    final By SurchargeDropdown = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-surcharge-type-dropdown')]");
    final By SurchargeValueType = By.xpath("//div[contains(@class,'Select__option') and contains(@id,'option-1')]");
    final By SaveAndActivateButton = By.xpath("//button[contains(@class,'pendo_feature_oms_campaign_template_save_and_activate_button')]");
    final By SaveAsDraftButton = By.xpath("//button[contains(@class,'pendo_feature_oms_campaign_template_save_as_draft_button')]");
    final By CampaignTemplateTableFirstRowName = By.xpath("(//td[contains(@class,'pendo_feature_oms_campaign_template_table_name_column_link_button universalText do-not-wrap')]/descendant::span)[1]");
    final By CampaignTemplateStatus = By.xpath("(//span[contains(@class,'status-displayname')])[1]");
    final By ErrorMessageForTemplateNameField = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final By DuplicateNameErrorPopUp = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-api-error')]");
    final By EmptyFieldErrorPopUp = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-form-field-toast-error')]");
    final By ErrorMessageForLifeTimeFrequencyField = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-life-time-frequency')]/descendant::div[contains(@class,'pendo-track-field-max-value-error')]");
    final By ErrorMessageForDailyFrequencyField = By.xpath("//div[contains(@class,'pendo-oms-campaign-template-daily-frequency')]/descendant::div[contains(@class,'pendo-track-field-max-value-error')]");
    final By CampaignTemplateCreationPopUp = By.xpath("//div[contains(@class,'pendo-tracking-lancher-go-live-success')]");
    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");

    final By DisplayADsRadioButton = By.xpath("//label[contains(@for,'DISPLAY')]");
    final By YesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");

    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    public StringBuilder RandomString() {
        String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomString = new StringBuilder();
        String fixedPart = "QATesting";
        SecureRandom rand = new SecureRandom();

        randomString.append(fixedPart);

        for (int i = 0; i < 4; i++) {
            int randomIndex = rand.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            randomString.append(randomChar);
        }

        return randomString;
    }

    public void ChangeLanguage() throws AWTException, InterruptedException {
        WebElement element = driver.findElement(By.xpath("//body[contains(@class,'osmos')]"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        Robot robot = new Robot();
        for (int i = 1; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
        }
        Thread.sleep(7000);
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

    @Step("Clicking on Campaign Template Button")
    public void ClickOnCampaignTemplateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignTemplateButton));
        driver.findElement(CampaignTemplateButton).click();
    }

    @Step("Clicking on create new campaign template button")
    public void ClickOnCreateNewCampaignTemplate() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateNewCampaignTemplateButton));
        driver.findElement(CreateNewCampaignTemplateButton).click();
    }

    @Step("Adding desired name to template name field")
    public void AddingDesiredName() {
        wait.until(ExpectedConditions.elementToBeClickable(TemplateNameField));
        driver.findElement(TemplateNameField).sendKeys(RandomString());
    }

    @Step("Selecting guaranteed radio button")
    public void SelectGuaranteedRadioButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(GuaranteedUncheckedRadioButton));
        driver.findElement(GuaranteedUncheckedRadioButton).click();
    }

    @Step("Entering desired value to lifetime frequency field")
    public void EnterDesiredValueTOLifeTimeFrequencyField(String lifetime_frequency) {
        wait.until(ExpectedConditions.elementToBeClickable(LifeTimeFrequencyField));
        driver.findElement(LifeTimeFrequencyField).click();
        driver.switchTo().activeElement().sendKeys((controlOrCommandKey + "A"));
        driver.switchTo().activeElement().sendKeys((Keys.BACK_SPACE));
        driver.switchTo().activeElement().sendKeys((lifetime_frequency));

    }

    @Step("Entering desired value to daily frequency field")
    public void EnterValueTODailyFrequencyField(String daily_frequency) {
        wait.until(ExpectedConditions.elementToBeClickable(DailyFrequencyField));
        driver.findElement(DailyFrequencyField).click();
        driver.switchTo().activeElement().sendKeys((controlOrCommandKey + "A"));
        driver.switchTo().activeElement().sendKeys((Keys.BACK_SPACE));
        driver.switchTo().activeElement().sendKeys((daily_frequency));

    }

    @Step("Entering desired value to base price field")
    public void EnterValueTOBasePriceField(String base_price) {
        wait.until(ExpectedConditions.elementToBeClickable(BasePriceField));
        driver.findElement(BasePriceField).click();
        driver.switchTo().activeElement().sendKeys((base_price));
    }

    @Step("Clicking on target dropdown")
    public void ClickTargetDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(TargetDropdown));
        driver.findElement(TargetDropdown).click();
    }

    @Step("Selecting desired  target from dropdown")
    public void SelectDesiredTarget(String target) {
        String XpathFormatter = String.format(DesiredTarget, target);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering desired value to the surcharge field")
    public void EnterValueToSurchargeField(String SurchargeValue) {
        wait.until(ExpectedConditions.presenceOfElementLocated(SurchargeValueField));
        driver.findElement(SurchargeValueField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(SurchargeValueField).sendKeys((SurchargeValue));
    }

    @Step("Clicking on surcharge dropdown")
    public void ClickSurchargeDropdown() {
        wait.until(ExpectedConditions.presenceOfElementLocated(SurchargeDropdown));
        driver.findElement(SurchargeDropdown).click();
    }

    @Step("Select desired   surcharge value")
    public void SelectSurchargeValueType() {
        wait.until(ExpectedConditions.presenceOfElementLocated(SurchargeValueType));
        driver.findElement(SurchargeValueType).click();
    }

    @Step("Clicking on Save and Activate button")
    public void ClickOnSaveAndActivateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveAndActivateButton));
        driver.findElement(SaveAndActivateButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Clicking on Save as draft button")
    public void ClickOnSaveAsDraftButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveAsDraftButton));
        driver.findElement(SaveAsDraftButton).click();
    }


    final StringBuilder Text = RandomString();

    @Step("Validating  successful creation of Campaign template")
    public boolean ValidateCreationOfCampaignTemplate() throws InterruptedException {
        try{
        wait.until(ExpectedConditions.elementToBeClickable(CampaignTemplateCreationPopUp));
        return driver.findElement(CampaignTemplateCreationPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating created campaign template  status")
    public Boolean ValidatingCreatedCampaignTemplateStatus() {
        boolean flag = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignTemplateStatus));
        String TemplateStatus = driver.findElement(CampaignTemplateStatus).getText();
        if (TemplateStatus.equalsIgnoreCase("Enable"))
            flag = true;
        return flag;
    }

    @Step("Enter desired data to template name field")
    public void EnterDataInNameField(String Template_Name) {
        wait.until(ExpectedConditions.elementToBeClickable(TemplateNameField));
        driver.findElement(TemplateNameField).sendKeys(controlOrCommandKey, "a");
        driver.findElement(TemplateNameField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(TemplateNameField).sendKeys(Template_Name);
    }

    @Step("Validating name field accepting spaces")
    public boolean ValidateNameFieldAcceptingSpaces() {
        try{
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ErrorMessageForTemplateNameField));
        return driver.findElement(ErrorMessageForTemplateNameField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public static StringBuilder createRandomString() {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < 202; i++) {
            int randomIndex = rand.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(randomIndex));
        }
        return randomString;
    }

    @Step("Validating name field accepting more than 200 characters")
    public boolean ValidateNameFieldAcceptingMoreThan200Characters() {
        boolean flag = true;
        String Text = driver.findElement(TemplateNameField).getAttribute("value");
        if (Text.length() > 200) {
            flag = false;
        }
        return flag;

    }

    @Step("Validating name field accepting more than 200 characters")
    public boolean ValidateNameFieldAcceptingDuplicateName() {
        try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(DuplicateNameErrorPopUp));
        return driver.findElement(DuplicateNameErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message popup after clicking save and activate button without filling mandatory fields")
    public boolean ValidateErrorMessagePopupAfterClickingSaveAndActivateButtonWithoutFillingAnyField() {
        try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmptyFieldErrorPopUp));
        return driver.findElement(EmptyFieldErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message popup after clicking save and activate button without filling mandatory fields")
    public boolean ValidateErrorMessagePopupAfterClickingSaveAsDraftButtonWithoutFillingAnyField() {
        try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmptyFieldErrorPopUp));
        return driver.findElement(EmptyFieldErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating lifetime frequency field accepting characters")
    public boolean ValidateLifeTimeFrequencyFieldAcceptingCharacters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LifeTimeFrequencyField));
        return driver.switchTo().activeElement().getAttribute("value").equals("Abcd&*^%*^*&*");
    }

    @Step("Validating lifetime frequency field accepting float value without any error")
    public boolean ValidateLifetimeFrequencyFieldAcceptingFloatValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LifeTimeFrequencyField));
        return driver.switchTo().activeElement().getAttribute("value").contains(".");
    }

    @Step("Validating lifetime frequency field accepting negative value without any error")
    public boolean ValidateLifetimeFrequencyFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LifeTimeFrequencyField));
        return driver.switchTo().activeElement().getAttribute("value").contains("-");
    }

    @Step("Validating lifetime frequency field accepting more value than max value")
    public boolean ValidateLifetimeFrequencyFieldAcceptingMoreThanMaximumValue() {
        try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForLifeTimeFrequencyField));
        return driver.findElement(ErrorMessageForLifeTimeFrequencyField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating daily frequency field accepting characters  without any error")
    public boolean ValidateDailyFrequencyFieldAcceptingCharacters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DailyFrequencyField));
        return driver.switchTo().activeElement().getAttribute("value").equals("Abcd%^$#@&");
    }

    @Step("Validating daily frequency field accepting float value without any error")
    public boolean ValidateDailyFrequencyFieldAcceptingFloatValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DailyFrequencyField));
        return driver.switchTo().activeElement().getAttribute("value").contains(".");
    }

    @Step("Validating daily frequency field accepting negative value without any error")
    public boolean ValidateDailyFrequencyFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DailyFrequencyField));
        return driver.switchTo().activeElement().getAttribute("value").contains("-");
    }

    @Step("Validating daily frequency field accepting  more than maximum  value without any error")
    public boolean ValidateDailyFrequencyFieldAcceptingMoreThanMaximumValue() {
        try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForDailyFrequencyField));
        return driver.findElement(ErrorMessageForDailyFrequencyField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating daily frequency field accepting characters  without any error")
    public boolean ValidateBasePriceFieldAcceptingCharacters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BasePriceField));
        return driver.switchTo().activeElement().getAttribute("value").equals("Abcd%^$#@&");
    }

    @Step("Validating Base price field accepting float value without any error")
    public boolean ValidateBasePriceFieldAcceptingFloatValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BasePriceField));
        return driver.switchTo().activeElement().getAttribute("value").contains(".");
    }

    @Step("Validating Base price field accepting negative value without any error")
    public boolean ValidateBasePriceFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BasePriceField));
        return driver.switchTo().activeElement().getAttribute("value").contains("-");
    }

    @Step("Validating surcharge field accepting characters  without any error")
    public boolean ValidateSurchargeFieldAcceptingCharacters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SurchargeValueField));
        return driver.findElement(SurchargeValueField).getAttribute("value").equals("Abcd%^$#@&");
    }

    @Step("Validating surcharge field accepting float value without any error")
    public boolean ValidateSurchargeFieldAcceptingFloatValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SurchargeValueField));
        return driver.findElement(SurchargeValueField).getAttribute("value").contains(".");
    }

    @Step("Validating Surcharge value field accepting negative value without any error")
    public boolean ValidateSurchargeFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SurchargeValueField));
        return driver.findElement(SurchargeValueField).getAttribute("value").contains("-");
    }

    @Step("Clicking on pop up close button")
    public void ClickingOnPopUpCloseButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(GenericPopUpCloseButton));
        driver.findElement(GenericPopUpCloseButton).click();
    }

    private static String PulseUrl = "https://oms-qa-staging-2.onlinesales.ai/";

    public void RetryOnFailPulse(Runnable action) {
        int attempts = 0;
        boolean success = false;
        String Message = "";
        while (attempts < 3 && !success) {
            try {
                action.run();
                success = true;
            } catch (Exception e) {
                Message = e.getClass().getSimpleName();
                attempts++;
                RetryListener++;
                TakeScreenshotOnSoftAssertion("Test Failed due to " + Message + " Attempt: " + attempts);
                if (System.getProperty("PulseUrl") != null)
                    PulseUrl = System.getProperty("PulseUrl");
                driver.navigate().to(PulseUrl);
            }
        }
        if (!success) {
            Assert.fail("Action failed after multiple attempts due to: " + Message);
        }
    }

    public int ReturnRetryCount() {
        return RetryListener;
    }

    @Step("Clicking on Display Ads radio button")
    public void ClickOnDisplayADsRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DisplayADsRadioButton));
        driver.findElement(DisplayADsRadioButton).click();
    }
@Step("Clicking on yes button")
public void ClickYesButtonForConfirmation() {
    wait.until(elementToBeClickable(YesButton));
    driver.findElement(YesButton).click();
}




}
