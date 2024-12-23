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

public class InventorySetupPage {
    WebDriver driver;
    WebDriverWait wait;
    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By SavedTagData = By.xpath("//div[contains(@class,'tab-input-field-form')]/span");
    final By PersonaTargetingEmptyErrorMessage = By.xpath("//div[contains(@class,'persona-selection')]/following-sibling::div[contains(@class,'name-error-message')]");
    final By SilverAccountCheckBox = By.xpath("//input[contains(@id,'checkbox-SILVER')]/following-sibling::label");
    final By GoldAccountCheckBox = By.xpath("//input[contains(@id,'checkbox-GOLD')]/following-sibling::label");
    final By PlatinumAccountCheckBox = By.xpath("//input[contains(@id,'checkbox-PLATINUM')]/following-sibling::label");
    final By BetAccountCheckBox = By.xpath("//input[contains(@id,'checkbox-BETA')]/following-sibling::label");
    final By PersonasVisibilityToggleButton = By.xpath("//div[contains(@class,'im-inventory-component-item-container visibility-setting-wrapper')]/descendant::span[contains(@class,'os-toggle-switch-round')]");
    final By InventoryDailyImpressionsFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-est-daily-impression')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]");
    final By InventoryMinimumCPMFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-minimum-cpm')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]");
    final By InventoryMinimumCPCFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-minimum-cpc')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]");
    final By InventoryAdFormatFieldEmptyErrorMessage = By.xpath("(//div[contains(@class,'name-error-message')])[6]");
    final By InventoryPositionFieldEmptyErrorMessage = By.xpath("(//div[contains(@class,'name-error-message')])[5]");
    final By InventoryPageFieldEmptyErrorMessage = By.xpath("(//div[contains(@class,'name-error-message')])[4]");
    final By InventoryApiFieldEmptyErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-field-empty-error')])[2]");
    final By InventoryNameFieldEmptyErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-field-empty-error')])[1]");
    final By TableSearchField = By.xpath("//div[contains(@class,'pendo_feature_table_search_input')]/descendant::input");
    final By PageTableFirstRowPageName = By.xpath("(//tbody[contains(@role,'rowgroup')]/descendant::label/span)[2]");
    final By InventoryCreateButton = By.xpath("//button[contains(@class,'pendo_feature_inventory_management_inventory_form_cta_click')]");
    final By AuctionInventoryTagsField = By.xpath("(//div[contains(@class,'step-wrapper')]/descendant::input)[25]");
    final By ThumbnailDescriptionField = By.xpath("(//div[contains(@class,'im-ad-preview-form-array-component')]/descendant::input)[4]");
    final By ThumbnailNameField = By.xpath("(//div[contains(@class,'im-ad-preview-form-array-component')]/descendant::input)[3]");
    final By PreviewDescriptionField = By.xpath("(//div[contains(@class,'im-ad-preview-form-array-component')]/descendant::input)[2]");
    final By PreviewNameField = By.xpath("(//div[contains(@class,'im-ad-preview-form-array-component')]/descendant::input)[1]");
    final By InventoryDailyImpressionsField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-est-daily-impression')]/descendant::div[contains(@class,'input-wrapper  undefined')]");
    final By InventoryMinimumCpmField = By.xpath("(//div[contains(@class,'im-inventory-component-item-component')]/descendant::div[contains(@class,'fake-input-wrapper')])[1]");
    final By InventoryMinimumCpcField = By.xpath("(//div[contains(@class,'im-inventory-component-item-component')]/descendant::div[contains(@class,'fake-input-wrapper')])[1]");
    final By CustomTargetingCheckBox = By.xpath("(//div[contains(@class,'checkbox-wrapper')]/descendant::label)[6]");
    final By DeviceTargetingCheckBox = By.xpath("(//div[contains(@class,'checkbox-wrapper')]/descendant::label)[5]");
    final By KeywordTargetingCheckBox = By.xpath("(//div[contains(@class,'checkbox-wrapper')]/descendant::label)[4]");
    final By AudienceTargetingCheckBox = By.xpath("(//div[contains(@class,'checkbox-wrapper')]/descendant::label)[3]");
    final By GeoLocationTargetingCheckBox = By.xpath("(//div[contains(@class,'checkbox-wrapper')]/descendant::label)[2]");
    final By ProductCatalogTargetingCheckBox = By.xpath("(//div[contains(@class,'checkbox-wrapper')]/descendant::label)[1]");
    final By InventoryAdFormatField = By.xpath("(//div[contains(@class,'im-inventory-form-component')]/descendant::input)[5]"); //ipf not present
    final By InventoryPositionField = By.xpath("(//div[contains(@class,'im-inventory-form-component')]/descendant::input)[5]");
    final By InventoryPageField = By.xpath("(//div[contains(@class,'im-inventory-form-component')]/descendant::input)[4]");
    final By InventoryDescriptionField = By.xpath("(//div[contains(@class,'im-inventory-form-component')]/descendant::input)[2]");
    final By ApiIdentifierField = By.xpath("(//div[contains(@class,'im-inventory-form-component')]/descendant::input)[3]");
    final By AuctionCampaignButton = By.xpath("(//div[contains(@class,'floating-container-inner')]/descendant::button)[1]");
    final By InventoryAddButton = By.xpath("//div[contains(@class,'float-btn-with-menu-wrapper')]/button");
    final By InventorySetupButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-inventory-setup')]");
    final By InventoryNameField = By.xpath("(//div[contains(@class,'im-inventory-form-component')]/descendant::input)");
    final By SearchFirstOption = By.xpath("(//div[contains(@id,'-option-')])[1]");

    public InventorySetupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    @Step("Click on Inventory Setup Button")
    public void ClickOnInventorySetupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(InventorySetupButton));
        driver.findElement(InventorySetupButton).click();
    }

    @Step("Click on inventory add button")
    public void ClickOnInventoryAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryAddButton));
        driver.findElement(InventoryAddButton).click();
    }


    @Step("Click on auction campaign button")
    public void ClickOnAuctionCampaignButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AuctionCampaignButton));
        driver.findElement(AuctionCampaignButton).click();
    }



    public static StringBuilder InventoryName;

    @Step("Entering data in inventory name field")
    public void EnterDataInInventoryNameField(String FixedData, int Count, String Time) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryNameField)).click();
        driver.findElement(InventoryNameField).sendKeys(controlOrCommandKey + "a");
        InventoryName = new StringBuilder(String.valueOf(RandomString(FixedData, Count, Time)));
        driver.findElement(InventoryNameField).sendKeys(InventoryName);
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


    @Step("Entering data in inventory description field")
    public void EnterDataInInventoryDescriptionField(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryDescriptionField)).click();
        driver.findElement(InventoryDescriptionField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(InventoryDescriptionField).sendKeys(data);
    }

    @Step("Entering data in API identifier field")
    public void EnterDataInApiIdentifierField(String FixedPart, int Count, String Type) {
        wait.until(ExpectedConditions.elementToBeClickable(ApiIdentifierField)).click();
        driver.findElement(ApiIdentifierField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ApiIdentifierField).sendKeys(RandomString(FixedPart, Count, Type));
    }


    @Step("Enter data in inventory page field")
    public void EnterDataInInventoryPageField(String PageName) {
            wait.until(ExpectedConditions.elementToBeClickable(InventoryPageField));
            driver.findElement(InventoryPageField).sendKeys(PageName);
    }

    @Step("Enter data in inventory position field")
    public void EnterDataInInventoryPositionField(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryPositionField));
        driver.findElement(InventoryPositionField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(InventoryPositionField).sendKeys(data);
    }

    @Step("Enter data in inventory ad format field")
    public void EnterDataInInventoryAdFormatField(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryAdFormatField));
        driver.findElement(InventoryAdFormatField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(InventoryAdFormatField).sendKeys(data);
    }

    @Step("Click on Product Catalog Targeting checkbox")
    public void ClickOnProductCatalogTargetingCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductCatalogTargetingCheckBox));
        driver.findElement(ProductCatalogTargetingCheckBox).click();
    }

    @Step("Click on Geo Location Targeting checkbox")
    public void ClickOnGeoLocationTargetingCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(GeoLocationTargetingCheckBox));
        driver.findElement(GeoLocationTargetingCheckBox).click();
    }

    @Step("Click on Audience Targeting checkbox")
    public void ClickOnAudienceTargetingCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(AudienceTargetingCheckBox));
        driver.findElement(AudienceTargetingCheckBox).click();
    }

    @Step("Click on Keyword Targeting checkbox")
    public void ClickOnKeywordTargetingCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(KeywordTargetingCheckBox));
        driver.findElement(KeywordTargetingCheckBox).click();
    }

    @Step("Click on Device Targeting checkbox")
    public void ClickOnDeviceTargetingCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(DeviceTargetingCheckBox));
        driver.findElement(DeviceTargetingCheckBox).click();
    }

    @Step("Click on Custom Targeting checkbox")
    public void ClickOnCustomTargetingCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(CustomTargetingCheckBox));
        driver.findElement(CustomTargetingCheckBox).click();
    }

    @Step("Enter data in Inventory Minimum CPC Field")
    public void EnterDataInInventoryMinimumCpcField(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryMinimumCpcField));
        driver.findElement(InventoryMinimumCpcField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(inputData);
    }

    @Step("Enter data in Inventory Maximum CPM Field")
    public void EnterDataInInventoryMinimumCpmField(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryMinimumCpmField));
        driver.findElement(InventoryMinimumCpmField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(inputData);
    }

    @Step("Enter data in Inventory Daily Impressions Field")
    public void EnterDataInInventoryDailyImpressionsField(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryDailyImpressionsField));
        driver.findElement(InventoryDailyImpressionsField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(inputData);
    }


    @Step("Enter data in preview name field")
    public void EnterDataInPreviewNameField(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(PreviewNameField));
        driver.findElement(PreviewNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(inputData);
    }

    @Step("Enter data in preview description field")
    public void EnterDataInPreviewDescriptionField(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(PreviewDescriptionField));
        driver.findElement(PreviewDescriptionField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(inputData);
    }

    @Step("Enter data in thumbnail name field")
    public void EnterDataInThumbnailNameField(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(ThumbnailNameField));
        driver.findElement(ThumbnailNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(inputData);
    }

    @Step("Enter data in thumbnail description field")
    public void EnterDataInThumbnailDescriptionField(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(ThumbnailDescriptionField));
        driver.findElement(ThumbnailDescriptionField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(inputData);
    }


    @Step("Entering data in auction inventory tags field")
    public void EnterDataInAuctionInventoryTagsField(String data) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        wait.until(ExpectedConditions.elementToBeClickable(AuctionInventoryTagsField));
        WebElement element = driver.findElement(AuctionInventoryTagsField);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(AuctionInventoryTagsField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(data);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

    }


    @Step("Click on inventory create button")
    public void ClickOnInventoryCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryCreateButton));
        driver.findElement(InventoryCreateButton).click();
    }

    @Step("Validating created page is present in table")
    public boolean ValidatingCreatedInventory() {
        String PageName = driver.findElement(PageTableFirstRowPageName).getText();
//        System.out.println(InventoryName);
//        System.out.println(PageName);
//        System.out.println(InventoryName.toString().equals(PageName));
        return InventoryName.toString().equals(PageName);
    }

    @Step("Enter data in the table search field")
    public void EnterDataInTableSearchField(String searchData) {
        wait.until(ExpectedConditions.elementToBeClickable(TableSearchField));
        driver.findElement(TableSearchField).clear();
        driver.findElement(TableSearchField).sendKeys(searchData);
    }

    @Step("Validate name field empty error message is displayed")
    public boolean ValidateInventoryNameFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryNameFieldEmptyErrorMessage));
            return driver.findElement(InventoryNameFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate inventory api field empty error message is displayed")
    public boolean ValidateInventoryApiFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryApiFieldEmptyErrorMessage));
            return driver.findElement(InventoryApiFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate inventory page field empty error message ")
    public boolean ValidateInventoryPageFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryPageFieldEmptyErrorMessage));
            return driver.findElement(InventoryPageFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate Inventory Position Field Empty Error Message")
    public boolean ValidateInventoryPositionFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryPositionFieldEmptyErrorMessage));
            return driver.findElement(InventoryPositionFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate Inventory AdFormat Field Empty Error Message")
    public boolean ValidateInventoryAdFormatFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryAdFormatFieldEmptyErrorMessage));
            return driver.findElement(InventoryAdFormatFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate Inventory Minimum CPC Field Empty Error Message")
    public boolean ValidateInventoryMinimumCPCFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryMinimumCPCFieldEmptyErrorMessage));
            return driver.findElement(InventoryMinimumCPCFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate Inventory Minimum CPM Field Empty Error Message")
    public boolean ValidateInventoryMinimumCPMFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryMinimumCPMFieldEmptyErrorMessage));
            return driver.findElement(InventoryMinimumCPMFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate inventory page field empty error message ")
    public boolean ValidateInventoryDailyImpressionsFieldEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryDailyImpressionsFieldEmptyErrorMessage));
            return driver.findElement(InventoryDailyImpressionsFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Entering only spaces in inventory name field")
    public void EnterSpacesInInventoryNameField(String Data) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryNameField)).click();
        WebElement element = driver.findElement(InventoryNameField);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(1500);
        driver.findElement(InventoryNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(InventoryNameField).sendKeys(Data);
    }


    @Step("Validating  inventory name field accepts only spaces")
    public boolean ValidateInventoryNameFieldAcceptsOnlySpaces() {
        driver.findElement(InventoryNameField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(InventoryNameField).getAttribute("value").trim().isEmpty();
    }

    @Step("Validating  inventory description field accepts only spaces")
    public boolean ValidateInventoryDescriptionFieldAcceptsOnlySpaces() {
        driver.findElement(InventoryDescriptionField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(InventoryDescriptionField).getAttribute("value").trim().isEmpty();
    }


    @Step("Entering spaces in API identifier field")
    public void EnterSpacesInApiIdentifierField(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(ApiIdentifierField)).click();
        driver.findElement(ApiIdentifierField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ApiIdentifierField).sendKeys(Data);
    }

    @Step("Validating  inventory api field accepts only spaces")
    public boolean ValidateInventoryApiFieldAcceptsOnlySpaces() {
        driver.findElement(ApiIdentifierField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(ApiIdentifierField).getAttribute("value").trim().isEmpty();
    }

    @Step("Click on Personas visibility toggle button")
    public void ClickOnPersonasVisibilityToggleButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PersonasVisibilityToggleButton));
        driver.findElement(PersonasVisibilityToggleButton).click();
    }


    @Step("Click on silver account checkbox")
    public void clickOnSilverAccountCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(SilverAccountCheckBox));
        driver.findElement(SilverAccountCheckBox).click();
    }

    @Step("Click on gold account checkbox")
    public void clickOnGoldAccountCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(GoldAccountCheckBox));
        driver.findElement(GoldAccountCheckBox).click();
    }

    @Step("Click on platinum account checkbox")
    public void clickOnPlatinumAccountCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(PlatinumAccountCheckBox));
        driver.findElement(PlatinumAccountCheckBox).click();
    }

    @Step("Click on beta account checkbox")
    public void clickOnBetaAccountCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(BetAccountCheckBox));
        driver.findElement(BetAccountCheckBox).click();
    }


    @Step("Check if persona targeting empty error message is displayed")
    public boolean ValidatePersonaTargetingEmptyErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PersonaTargetingEmptyErrorMessage));
            return driver.findElement(PersonaTargetingEmptyErrorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    @Step("Validating Inventory Minimum CPC Field accepting characters")
    public boolean ValidateInventoryMinimumCpcFieldAcceptingCharacters(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryMinimumCpcField));
        driver.findElement(InventoryMinimumCpcField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating Inventory Minimum CPC Field accepting negative value")
    public boolean ValidateInventoryMinimumCpcFieldAcceptingNegativeValue(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryMinimumCpcField));
        driver.findElement(InventoryMinimumCpcField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating inventory minimum CPM field accepting characters")
    public boolean ValidateInventoryMinimumCpmFieldAcceptingCharacters(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryMinimumCpmField));
        driver.findElement(InventoryMinimumCpmField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating inventory minimum CPM field accepting characters")
    public boolean ValidateInventoryMinimumCpmFieldAcceptingNegativeValue(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryMinimumCpmField));
        driver.findElement(InventoryMinimumCpmField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }


    @Step("Validating inventory daily impressions field accepting characters")
    public boolean ValidateInventoryDailyImpressionsFieldAcceptingCharacters(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryDailyImpressionsField));
        driver.findElement(InventoryDailyImpressionsField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating inventory daily impressions field accepting characters")
    public boolean ValidateInventoryDailyImpressionsFieldAcceptingNegativeValue(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(InventoryDailyImpressionsField));
        driver.findElement(InventoryDailyImpressionsField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }


    @Step("Validating  inventory preview name field accepts only spaces")
    public boolean ValidateInventoryPreviewNameFieldAcceptsOnlySpaces() {
        driver.findElement(PreviewNameField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(PreviewNameField).getAttribute("value").trim().isEmpty();
    }

    @Step("Validating inventory placement preview name field accepts only spaces")
    public boolean ValidateInventoryPlacementDescriptionFieldAcceptsOnlySpaces() {
        driver.findElement(PreviewDescriptionField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(PreviewDescriptionField).getAttribute("value").trim().isEmpty();
    }


    @Step("Validating inventory placement preview name field accepts only spaces")
    public boolean ValidateInventoryPlacementDescriptionFieldAcceptsMoreThan35Characters() {
        driver.findElement(PreviewDescriptionField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(PreviewDescriptionField).getAttribute("value").length() > 35;
    }


    @Step("Validating  inventory thumb nail name field accepts only spaces")
    public boolean ValidateInventoryThumbNailNameFieldAcceptsOnlySpaces() {
        driver.findElement(ThumbnailNameField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(ThumbnailNameField).getAttribute("value").trim().isEmpty();
    }

    @Step("Validating inventory thumb nail description field accepts only spaces")
    public boolean ValidateInventoryThumbNailDescriptionFieldAcceptsOnlySpaces() {
        driver.findElement(PreviewDescriptionField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(PreviewDescriptionField).getAttribute("value").trim().isEmpty();
    }


    @Step("Validating inventory thumb nail description field accepts only spaces")
    public boolean ValidateInventoryThumbNailDescriptionFieldAcceptsMoreThan35Characters() {
        driver.findElement(PreviewDescriptionField).sendKeys(controlOrCommandKey + "a");
        return driver.findElement(PreviewDescriptionField).getAttribute("value").length() > 35;
    }

    @Step("Validating tag field accept only spaces")
    public boolean ValidateSavedTagDataContainsOnlySpaces() {
        try {
            return driver.findElement(SavedTagData).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating created page name is available in inventory ")
    public boolean ValidateCreatedPageIsAvailableInInventory() {
        try {
            return driver.findElement(SearchFirstOption).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating created ad format is available in inventory ")
    public boolean ValidateCreatedAdFormatIsAvailableInInventory() {
        try {
            return driver.findElement(SearchFirstOption).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    final By CpcRadioButton = By.xpath("//input[contains(@id,'checkbox-CPC')]/parent::div/label");

    @Step("Click on CPC Radio Button")
    public void ClickOnCpcRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CpcRadioButton));
        WebElement element = driver.findElement(CpcRadioButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(CpcRadioButton).click();
    }



    final By CpmRadioButton = By.xpath("//input[contains(@id,'checkbox-CPM')]/parent::div/label");

    @Step("Click on CPM Radio Button")
    public void ClickOnCpmRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CpmRadioButton));
        WebElement element = driver.findElement(CpmRadioButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(CpmRadioButton).click();
    }
}
