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


public class AdFormatSetupPage {
    WebDriver driver;
    WebDriverWait wait;

    public AdFormatSetupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By EmptyScheduleConfigurationErrorMessage = By.xpath("//div[contains(@class,'component-schedule-configuration')]/descendant::div[contains(@class,'name-error-message')]");//updated
    final By ProductsMaxErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-ad-product-range')]/descendant::div[contains(@class,'error-message')]"); //updated
    final By ProductsRangeCountErrorMessage = By.xpath("//div[contains(@class,'component-ad-product-range')]/descendant::div[contains(@class,'name-error-message')]"); //updated
    final By ProductListRangeEmptyErrorMessage = By.xpath("//div[contains(@class,'component-ad-product-range')]/descendant::div[contains(@class,'name-error-message')]"); //updated
    final By ProductListButtonEmptyErrorMessage = By.xpath("//div[contains(@class,'component-button-name')]/descendant::div[contains(@class,'name-error-message')]");//updated
    final By ThirdPartyTrackersEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-third-party-trackers')]/descendant::div[contains(@class,'name-error-message')]");//updated
    final By CtaOptionsEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-options')]/descendant::div[contains(@class,'name-error-message')]"); //updated
    final By CtaOptionsData = By.xpath("(//div[contains(@class,'tab-input-field-form')]/span/span)[3]");
    final By RestrictURLData = By.xpath("//div[contains(@class,'tab-input-field-form')]/span/span");
    final By AddCarouselElementErrorMessage = By.xpath("(//label[contains(@class,'error-text')])");
    final By CarouselItemCountErrorMessage = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-item-count')]/descendant::div[contains(@class,'name-error-message')]");//updated
    final By AcceptedFormatsErrorMessage = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[14]");
    final String GenericOptionSelectorXpath = "(//div[contains(@class,'checkbox-group  horizontal ')]/descendant::label)[%d]";
    final String GenericOptionsSelectorXpath = "(//div[contains(@id,'-option-')])[%d]";
    final String VideoSizeTypeDropDownXpath = "(//div[contains(@class,'os-drodown-wrapper')]/div[contains(@class,'include-lookalike')])[%d]";
    final By VideoMinSizeMaxSizeEmptyErrorMessage = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[13]");
    final String AdPreviewDeleteIconXpath = "(//div[contains(@class,'creative-tab-list')]/button[contains(@class,'delete-item')])[%d]";
    final By PreviewAdPlusIcon = By.xpath("//div[contains(@class,'bottom-section')]/button[contains(@class,'im-ad-format-duplicate')]");
    final By PreviewImageEmptyErrorMessage = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[6]");
    final By PreviewNameEmptyErrorMessage = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[7]");
    final By AdSizeEmptyErrorMessage = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[5]");

    final By AdSchedulingDayWiseCheckBox = By.xpath("//div[contains(@class,'checkbox-wrapper')]/descendant::label[contains(@for,'checkbox-day_wise')]");
    final By AdSchedulingDateWise = By.xpath("//div[contains(@class,'checkbox-wrapper')]/descendant::label[contains(@for,'checkbox-date_wise')]");
    final By ADSchedulingFieldName = By.xpath("(//div[contains(text(),'Ad Scheduling')]/parent::div/following-sibling::div/descendant::input)[1]");    final By LandingProductFieldName = By.xpath("(//input[contains(@class,'form-control simple-input ')])[40]"); //check
    final By LandingProductButtonName = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-button-name')]/descendant::input"); //updated
    final By LandingProductMin = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-ad-product-range')]/descendant::input)[1]"); //updated
    final By LandingProductMax = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-ad-product-range')]/descendant::input)[2]"); //updated
    final By DCMClickCheckBox = By.xpath("//div[contains(@class,'checkbox-wrapper')]/descendant::label[contains(@for,'checkbox-script_dcm_click')]");
    final By DCMImpressionCheckBox = By.xpath("//div[contains(@class,'checkbox-wrapper')]/descendant::label[contains(@for,'checkbox-script_dcm_impression')]");
    final By DCMImpressionImageCheckBox = By.xpath("//div[contains(@class,'checkbox-wrapper')]/descendant::label[contains(@for,'checkbox-img_dcm_impression')]");
    final By TrackerFieldName = By.xpath("(//input[contains(@class,'form-control simple-input ')])[39]"); //check
    final By CTAFieldName = By.xpath("(//input[contains(@class,'form-control simple-input ')])[36]"); //check
    final By CtaOptions = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-options')]/descendant::input"); //updated
    final By CtaAPIIdentifier = By.xpath("(//input[contains(@class,'form-control simple-input ')])[38]"); //check
    final By TagEnterIcon = By.xpath("//span[contains(@class,'icon-enter')]");
    final By UrlName = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-name')]/descendant::input");
    final By UrlAPIIdentifier = By.xpath("(//input[contains(@class,'form-control simple-input ')])[34]"); //check
    final By RestrictUrl = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-allowed-domains')]/descendant::input"); //updated
    final By StaticAPIIdentifier = By.xpath("(//input[contains(@class,'form-control simple-input ')])[31]"); //check
    final By StaticValue = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-value')]/descendant::input"); //updated

    final By AdFormatSetupButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-ad-format_setup')]");
    final By TextFieldName = By.xpath("(//input[contains(@class,'form-control simple-input ')])[27]"); //check
    final By MaxCharactersSupported = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-max-characters-supported')]/descendant::input"); //updated
    final By TextDescription = By.xpath("(//input[contains(@class,'form-control simple-input ')])[29]"); //check
    final By TextAPIIdentifier = By.xpath("(//input[contains(@class,'form-control simple-input ')])[30]"); //check
    final By CarouselFieldName = By.xpath("//div[contains(@class,'carousel-adformat-container')]/descendant::div[contains(@class,'-name')]/descendant::input");
    final By CarouselDescription = By.xpath("//div[contains(@class,'carousel-adformat-container')]/descendant::div[contains(@class,'-description')]/descendant::input");
    final By CarouselAPIIdentifier = By.xpath("//div[contains(@class,'carousel-adformat-container')]/descendant::div[contains(@class,'-api-identifier')]/descendant::input");
    final By CarouselMinCount = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-item-count')]/descendant::input)[1]");
    final By CarouselMaxCount = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-item-count')]/descendant::input)[2]");
    final By ImageFieldName = By.xpath("(//input[contains(@class,'form-control simple-input ')])[15]"); //check
    final By ImageDescription = By.xpath("(//input[contains(@class,'form-control simple-input ')])[16]"); //check
    final By ImageAPIIdentifier = By.xpath("(//input[contains(@class,'form-control simple-input ')])[17]"); //check
    final By ImageWidth = By.xpath("(//input[contains(@class,'form-control simple-input ')])[18]");
    final By ImageHeight = By.xpath("(//input[contains(@class,'form-control simple-input ')])[19]");
    final By ImageMinSize = By.xpath("(//input[contains(@class,'form-control simple-input ')])[20]");
    final By ImageMaxSize = By.xpath("(//input[contains(@class,'form-control simple-input ')])[21]");
    final By VideoFieldName = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-video-field-name')]/descendant::input");
    final By VideoDescription = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-video-description')]/descendant::input");
    final By VideoAPIIdentifier = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-video-api-identifier')]/descendant::input");
    final By VideoWidth = By.xpath("//div[contains(@class,'pendo-track-ad-format-video-max-width')]/descendant::input");
    final By VideoHeight = By.xpath("//div[contains(@class,'pendo-track-ad-format-video-max-height')]/descendant::input");
    final By VideoMinSize = By.xpath("//div[contains(@class,'pendo-track-ad-format-video-min-size-input' )]/descendant::input");
    final By VideoMaxSize = By.xpath("//div[contains(@class,'pendo-track-ad-format-video-max-size-input')]/descendant::input");
    final String AddElementDropDownOptionsXpath = "(//div[contains(@class,'popover-menu-item')])[%d]";
    final By AddElementsButton = By.xpath("//div[contains(@class,'creative-actionbtn')]");
    final By CreativeLibraryChooseButton = By.xpath("//button[contains(@class,'pendo_feature_media_library_save_button')]");
    final By CreativeLibraryImageSelector = By.xpath("(//div[contains(@class,'media-item')])[1]");
    final By UploadPreviewImage = By.xpath("//div[contains(@class,'im-creative-image-wrapper')]");
    final String AdTypeDropDownXpath = "(//div[contains(@id,'-option-')])[%d]";
    final By AdTypeField = By.xpath("//div[contains(@class,'Select__input-container')]");
    final By DescriptionField = By.xpath("(//input[contains(@class,'form-control simple-input ')])[2]");
    final By IdentifierKeyField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-identifier-key')]/descendant::input");
    final By MaxWidthField = By.xpath("//div[contains(@class,'pendo-track-ad-format-max-width')]/descendant::input");
    final By MaxHeightField = By.xpath("//div[contains(@class,'pendo-track-ad-format-max-height')]/descendant::input");
    final By PreviewNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-ad-preview-preview-name')]/descendant::input"); //updated
    final By AdPreviewDescriptionField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-ad-preview-description')]/descendant::input"); //updated
    final By AdFormatNameField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-ad-format-name')]/descendant::input");
    final By AddAdFormatButton = By.xpath("//button[contains(@class,'table-fixed-btn')]");
    final By ControlCenterNavButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-control-center')]");
    final By CustomAdSetup = By.xpath("(//div[contains(@class,'adformat-card clickable')])[5]");
    final By AddCarouselElementButton = By.xpath("//div[contains(@class,'im-item-menu-add-new-item-container')]/descendant::button");
    final String AdFormatDeleteIconXpath = "(//button[contains(@class,'im-ad-format-remove')])[%d]";
    final By YesButton = By.xpath("(//div[contains(@class,'modal-content')]/descendant::button)[1]");
    final By TableSearchField = By.xpath("//div[contains(@class,'pendo_feature_table_search_input')]/descendant::input");
    final By AdFormatEmptyApiErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-field-empty-error')])[1]");
    final By AdFormatEmptyCreationErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-field-empty-error')])[1]");
    final By ApiIdentifierInvalidDataErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-field-empty-error')])[2]");
    final By PageTableFirstRowPageName = By.xpath("(//tbody[contains(@role,'rowgroup')]/descendant::label/span)[1]");
    final By CarouselStaticApiIdentifierField = By.xpath("(//div[contains(text(),'Static')]/parent::div/following-sibling::div/descendant::input)[1]");
    final By CarouselStaticValueField = By.xpath("(//div[contains(text(),'Static')]/parent::div/following-sibling::div/descendant::input)[2]");

    @Step("Click ad Format setup button")
    public void ClickAdFormatSetupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdFormatSetupButton));
        driver.findElement(AdFormatSetupButton).click();
    }


    @Step("Clicking on Control Center Navigation Button")
    public void ClickOnControlCenterNavButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ControlCenterNavButton));
        driver.findElement(ControlCenterNavButton).click();
    }

    @Step("Click custom ad setup")
    public void ClickCustomAdSetup() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(CustomAdSetup);
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(CustomAdSetup));
        driver.findElement(CustomAdSetup).click();
    }

    @Step("Clicking on add ad format button")
    public void ClickOnAddAdFormatButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddAdFormatButton));
        driver.findElement(AddAdFormatButton).click();
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

    public static StringBuilder AdFormatName;

    @Step("Enter data in ad format name field")
    public void EnterDataInAdFormatNameField(String adFormatName) {
        wait.until(ExpectedConditions.elementToBeClickable(AdFormatNameField));
        driver.findElement(AdFormatNameField).sendKeys(controlOrCommandKey + "a");
        AdFormatName = RandomString("QATesting", 3, "text");
        // System.out.println(AdFormatName);
        driver.findElement(AdFormatNameField).sendKeys(AdFormatName);
    }


    @Step("Enter data in description field")
    public void EnterDataInDescriptionField(String description) {
        wait.until(ExpectedConditions.elementToBeClickable(DescriptionField));
        driver.findElement(DescriptionField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(DescriptionField).sendKeys(description);
    }

    @Step("Enter data in identifier key field")
    public void EnterDataInIdentifierKeyField(String identifierKey, int Count, String Time) {
        wait.until(ExpectedConditions.elementToBeClickable(IdentifierKeyField));
        driver.findElement(IdentifierKeyField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(IdentifierKeyField).sendKeys(RandomString(identifierKey, Count, Time));
    }

    @Step("Enter data in max width field")
    public void EnterDataInMaxWidthField(String maxWidth) {
        wait.until(ExpectedConditions.elementToBeClickable(MaxWidthField));
        driver.findElement(MaxWidthField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(MaxWidthField).sendKeys(maxWidth);
    }

    @Step("Enter data in min width field")
    public void EnterDataInMinWidthField(String minWidth) {
        wait.until(ExpectedConditions.elementToBeClickable(MaxHeightField));
        driver.findElement(MaxHeightField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(MaxHeightField).sendKeys(minWidth);
    }

    @Step("Enter data in preview name field")
    public void EnterDataInPreviewNameField(String previewName) {
        wait.until(ExpectedConditions.elementToBeClickable(PreviewNameField));
        driver.findElement(PreviewNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(PreviewNameField).sendKeys(previewName);
    }

    @Step("Enter data in ad preview description field")
    public void EnterDataInAdPreviewDescriptionField(String adPreviewDescription) {
        wait.until(ExpectedConditions.elementToBeClickable(AdPreviewDescriptionField));
        driver.findElement(AdPreviewDescriptionField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AdPreviewDescriptionField).sendKeys(adPreviewDescription);
    }


    @Step("Click ad type field")
    public void ClickAdTypeField() {
        wait.until(ExpectedConditions.elementToBeClickable(AdTypeField));
        driver.findElement(AdTypeField).click();
    }


    @Step("Click image in ad type drop down")
    public void ClickImageInAdTypeDropDown(int dropDownIndex) {
        String xpathFormatter = String.format(AdTypeDropDownXpath, dropDownIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }


    @Step("Click upload preview image")
    public void ClickUploadPreviewImage() {
        wait.until(ExpectedConditions.elementToBeClickable(UploadPreviewImage));
        driver.findElement(UploadPreviewImage).click();
    }


    @Step("Click creative library image selector")
    public void ClickCreativeLibraryImageSelector() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeLibraryImageSelector));
        driver.findElement(CreativeLibraryImageSelector).click();
    }


    @Step("Click creative library choose button")
    public void ClickCreativeLibraryChooseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeLibraryChooseButton));
        driver.findElement(CreativeLibraryChooseButton).click();
    }


    @Step("Click add elements button")
    public void ClickAddElementsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddElementsButton));
        driver.findElement(AddElementsButton).click();
    }

    @Step("Selecting add element drop down options")
    public void SelectingAddElementDropDownOptions(int optionIndex) {
        String xpathFormatter = String.format(AddElementDropDownOptionsXpath, optionIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }

    @Step("Entering data in video field name")
    public void EnterDataInVideoFieldName(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(VideoFieldName));
        driver.findElement(VideoFieldName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(VideoFieldName).sendKeys(data);
    }

    @Step("Entering data in video description")
    public void EnterDataInVideoDescription(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(VideoDescription));
        driver.findElement(VideoDescription).sendKeys(controlOrCommandKey + "a");
        driver.findElement(VideoDescription).sendKeys(data);
    }

    @Step("Entering data in video API identifier")
    public void EnterDataInVideoAPIIdentifier(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(VideoAPIIdentifier));
        driver.findElement(VideoAPIIdentifier).sendKeys(controlOrCommandKey + "a");
        driver.findElement(VideoAPIIdentifier).sendKeys(data);
    }

    @Step("Entering data in video width")
    public void EnterDataInVideoWidth(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(VideoWidth));
        driver.findElement(VideoWidth).sendKeys(controlOrCommandKey + "a");
        driver.findElement(VideoWidth).sendKeys(data);
    }

    @Step("Entering data in video height")
    public void EnterDataInVideoHeight(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(VideoHeight));
        driver.findElement(VideoHeight).sendKeys(controlOrCommandKey + "a");
        driver.findElement(VideoHeight).sendKeys(data);
    }

    @Step("Entering data in video minimum size")
    public void EnterDataInVideoMinSize(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(VideoMinSize));
        driver.findElement(VideoMinSize).sendKeys(controlOrCommandKey + "a");
        driver.findElement(VideoMinSize).sendKeys(data);
    }

    @Step("Entering data in video maximum size")
    public void EnterDataInVideoMaxSize(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(VideoMaxSize));
        driver.findElement(VideoMaxSize).sendKeys(controlOrCommandKey + "a");
        driver.findElement(VideoMaxSize).sendKeys(data);
    }


    @Step("Entering data in image field name")
    public void EnterDataInImageFieldName(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(ImageFieldName));
        driver.findElement(ImageFieldName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ImageFieldName).sendKeys(data);
    }

    @Step("Entering data in image description")
    public void EnterDataInImageDescription(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(ImageDescription));
        driver.findElement(ImageDescription).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ImageDescription).sendKeys(data);
    }

    @Step("Entering data in image API identifier")
    public void EnterDataInImageAPIIdentifier(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(ImageAPIIdentifier));
        driver.findElement(ImageAPIIdentifier).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ImageAPIIdentifier).sendKeys(data);
    }

    @Step("Entering data in image width")
    public void EnterDataInImageWidth(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(ImageWidth));
        driver.findElement(ImageWidth).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ImageWidth).sendKeys(data);
    }

    @Step("Entering data in image height")
    public void EnterDataInImageHeight(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(ImageHeight));
        driver.findElement(ImageHeight).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ImageHeight).sendKeys(data);
    }

    @Step("Entering data in image min size")
    public void EnterDataInImageMinSize(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(ImageMinSize));
        driver.findElement(ImageMinSize).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ImageMinSize).sendKeys(data);
    }

    @Step("Entering data in image max size")
    public void EnterDataInImageMaxSize(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(ImageMaxSize));
        driver.findElement(ImageMaxSize).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ImageMaxSize).sendKeys(data);
    }


    @Step("Entering data in carousel field name")
    public void EnterDataInCarouselFieldName(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselFieldName));
        driver.findElement(CarouselFieldName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CarouselFieldName).sendKeys(data);
    }

    @Step("Entering data in carousel description")
    public void EnterDataInCarouselDescription(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselDescription));
        driver.findElement(CarouselDescription).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CarouselDescription).sendKeys(data);
    }

    @Step("Entering data in carousel API identifier")
    public void EnterDataInCarouselAPIIdentifier(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselAPIIdentifier));
        driver.findElement(CarouselAPIIdentifier).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CarouselAPIIdentifier).sendKeys(data);
    }

    @Step("Entering data in carousel min count")
    public void EnterDataInCarouselMinCount(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselMinCount));
        driver.findElement(CarouselMinCount).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CarouselMinCount).sendKeys(data);
    }

    @Step("Entering data in carousel max count")
    public void EnterDataInCarouselMaxCount(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselMaxCount));
        driver.findElement(CarouselMaxCount).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CarouselMaxCount).sendKeys(data);
    }


    @Step("Entering data in text field name")
    public void EnterDataInTextFieldName(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(TextFieldName));
        driver.findElement(TextFieldName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(TextFieldName).sendKeys(data);
    }

    @Step("Entering data in max characters supported")
    public void EnterDataInMaxCharactersSupported(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(MaxCharactersSupported));
        driver.findElement(MaxCharactersSupported).sendKeys(controlOrCommandKey + "a");
        driver.findElement(MaxCharactersSupported).sendKeys(data);
    }

    @Step("Entering data in text description")
    public void EnterDataInTextDescription(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(TextDescription));
        driver.findElement(TextDescription).sendKeys(controlOrCommandKey + "a");
        driver.findElement(TextDescription).sendKeys(data);
    }

    @Step("Entering data in text API identifier")
    public void EnterDataInTextAPIIdentifier(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(TextAPIIdentifier));
        driver.findElement(TextAPIIdentifier).sendKeys(controlOrCommandKey + "a");
        driver.findElement(TextAPIIdentifier).sendKeys(data);
    }


    @Step("Entering data in static API identifier")
    public void EnterDataInStaticAPIIdentifier(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(StaticAPIIdentifier));
        driver.findElement(StaticAPIIdentifier).sendKeys(controlOrCommandKey + "a");
        driver.findElement(StaticAPIIdentifier).sendKeys(data);
    }

    @Step("Entering data in static value")
    public void EnterDataInStaticValue(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(StaticValue));
        driver.findElement(StaticValue).sendKeys(controlOrCommandKey + "a");
        driver.findElement(StaticValue).sendKeys(data);
    }


    @Step("Entering data in URL name")
    public void EnterDataInUrlName(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(UrlName));
        driver.findElement(UrlName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(UrlName).sendKeys(data);
    }

    @Step("Entering data in URL API identifier")
    public void EnterDataInUrlAPIIdentifier(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(UrlAPIIdentifier));
        driver.findElement(UrlAPIIdentifier).sendKeys(controlOrCommandKey + "a");
        driver.findElement(UrlAPIIdentifier).sendKeys(data);
    }

    @Step("Entering data in restrict URL")
    public void EnterDataInRestrictUrl(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(RestrictUrl));
        driver.findElement(RestrictUrl).sendKeys(controlOrCommandKey + "a");
        driver.findElement(RestrictUrl).sendKeys(data);
    }

    @Step("Clicking on enter icon")
    public void ClickEnterIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(TagEnterIcon));
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
//        driver.findElement(TagEnterIcon).click();
    }

    final By tagsField = By.xpath("//div[contains(@class,'label-align-start-with-input')]/descendant::input");


    @Step("Entering data in CTA field name")
    public void EnterDataInCTAFieldName(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(CTAFieldName));
        driver.findElement(CTAFieldName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CTAFieldName).sendKeys(data);
    }

    @Step("Entering data in CTA options")
    public void EnterDataInCtaOptions(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(CtaOptions));
        driver.findElement(CtaOptions).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CtaOptions).sendKeys(data);
    }

    @Step("Entering data in CTA API identifier")
    public void EnterDataInCtaAPIIdentifier(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(CtaAPIIdentifier));
        driver.findElement(CtaAPIIdentifier).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CtaAPIIdentifier).sendKeys(data);
    }

    @Step("Entering data in tracker field name")
    public void EnterDataInTrackerFieldName(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(TrackerFieldName));
        driver.findElement(TrackerFieldName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(TrackerFieldName).sendKeys(data);
    }

    @Step("Click on DCM click checkbox")
    public void ClickOnDCMClickCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(DCMClickCheckBox));
        driver.findElement(DCMClickCheckBox).click();
    }

    @Step("Click on DCM impression checkbox")
    public void ClickOnDCmIMpressionCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(DCMImpressionCheckBox));
        driver.findElement(DCMImpressionCheckBox).click();
    }

    @Step("Click on DCM impression image checkbox")
    public void ClickOnDCMImpressionImageCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(DCMImpressionImageCheckBox));
        driver.findElement(DCMImpressionImageCheckBox).click();
    }


    @Step("Enter data in landing product field name")
    public void EnterDataInLandingProductFieldName(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(LandingProductFieldName));
        driver.findElement(LandingProductFieldName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(LandingProductFieldName).sendKeys(inputData);
    }

    @Step("Enter data in landing product button name")
    public void EnterDataInLandingProductButtonName(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(LandingProductButtonName));
        driver.findElement(LandingProductButtonName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(LandingProductButtonName).sendKeys(inputData);
    }

    @Step("Enter data in landing product min")
    public void EnterDataInLandingProductMin(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(LandingProductMin));
        driver.findElement(LandingProductMin).sendKeys(controlOrCommandKey + "a");
        driver.findElement(LandingProductMin).sendKeys(inputData);
    }

    @Step("Enter data in landing product max")
    public void EnterDataInLandingProductMax(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(LandingProductMax));
        driver.findElement(LandingProductMax).sendKeys(controlOrCommandKey + "a");
        driver.findElement(LandingProductMax).sendKeys(inputData);
    }

    @Step("Enter data in ad scheduling field name")
    public void EnterDataInAdSchedulingFieldName(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(ADSchedulingFieldName));
        driver.findElement(ADSchedulingFieldName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ADSchedulingFieldName).sendKeys(inputData);
    }

    @Step("Click on ad scheduling day-wise checkbox")
    public void ClickOnAdSchedulingDayWiseCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(AdSchedulingDayWiseCheckBox));
        driver.findElement(AdSchedulingDayWiseCheckBox).click();
    }

    @Step("Click on ad scheduling date-wise checkbox")
    public void ClickOnAdSchedulingDateWise() {
        wait.until(ExpectedConditions.elementToBeClickable(AdSchedulingDateWise));
        driver.findElement(AdSchedulingDateWise).click();
    }

    final By AdFormatCreateButton = By.xpath("//button[contains(@class,'pendo_feature_inventory_management_ad_format_form_cta_click')]");

    @Step("Click on ad format create button")
    public void ClickOnAdFormatCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdFormatCreateButton));
        driver.findElement(AdFormatCreateButton).click();
    }

    final By AdFormatCreationSuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast--success')]");

    @Step("Check if ad format creation success pop-up is displayed")
    public boolean ValidatingAdFormatCreationSuccessPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AdFormatCreationSuccessPopUp));
            return driver.findElement(AdFormatCreationSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }

    }

    @Step("Validating created page is present in table")
    public boolean ValidatingCreatedAdFormat() {
        String PageName = driver.findElement(PageTableFirstRowPageName).getText();
        // System.out.println(AdFormatName);
        // System.out.println(PageName);
        // System.out.println(AdFormatName.toString().equals(PageName));
        return AdFormatName.toString().equals(PageName);
    }


    @Step("Click on add carousel element button")
    public void ClickOnAddCarouselElementButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddCarouselElementButton));
        driver.findElement(AddCarouselElementButton).click();
    }



    @Step("Enter data in carousel static API identifier field")
    public void EnterDataInCarouselStaticApiIdentifierField(String input) {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselStaticApiIdentifierField));
        driver.findElement(CarouselStaticApiIdentifierField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CarouselStaticApiIdentifierField).sendKeys(input);
    }

    @Step("Enter data in carousel static value field")
    public void EnterDataInCarouselStaticValueField(String input) {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselStaticValueField));
        driver.findElement(CarouselStaticValueField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CarouselStaticValueField).sendKeys(input);
    }


    @Step("Optional click on ad format delete icon")
    public void OptionalClickAdFormatDeleteIcon(int iconIndex) {
        String xpathFormatter = String.format(AdFormatDeleteIconXpath, iconIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }


    @Step("Click on Yes button in confirmation modal")
    public void ClickOnYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(YesButton));
        driver.findElement(YesButton).click();
    }


    @Step("Enter data in the table search field")
    public void EnterDataInTableSearchField(String searchData) {
        wait.until(ExpectedConditions.elementToBeClickable(TableSearchField));
        driver.findElement(TableSearchField).clear();
        driver.findElement(TableSearchField).sendKeys(searchData);
    }


    @Step("Validating error message appears when creating Ad Format without entering a name")
    public boolean ValidateAdFormatNameEmptyFieldError() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AdFormatNameField));
            driver.findElement(AdFormatNameField).sendKeys(controlOrCommandKey + "a", Keys.DELETE);
            driver.findElement(AdFormatCreateButton).click();
            return driver.findElement(AdFormatEmptyCreationErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }



    @Step("Validating error message appears when creating Ad Format without entering a api")
    public boolean ValidateAdFormatApiFieldEmptyFieldError() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(AdFormatNameField));
            driver.findElement(AdFormatEmptyApiErrorMessage).click();
            return driver.findElement(AdFormatEmptyCreationErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Enter spaces in ad format name field")
    public void EnterSpacesInAdFormatNameField(String adFormatName) {
        wait.until(ExpectedConditions.elementToBeClickable(AdFormatNameField));
        driver.findElement(AdFormatNameField).sendKeys(adFormatName);
    }

    @Step("Validating ad format name field for spaces")
    public boolean ValidateAdFormatNameFieldNoSpaces() {
        wait.until(ExpectedConditions.elementToBeClickable(AdFormatNameField));
        driver.findElement(AdFormatNameField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.length() > 1;
    }

    @Step("Enter spaces in description field")
    public void EnterOnlySpacesInDescriptionField(String description) {
        wait.until(ExpectedConditions.elementToBeClickable(DescriptionField));
        driver.findElement(DescriptionField).sendKeys(description);
    }

    @Step("Validating ad format DescriptionField field accepting only spaces")
    public boolean ValidateAdFormatDescriptionFieldNoSpaces() {
        wait.until(ExpectedConditions.elementToBeClickable(DescriptionField));
        driver.findElement(DescriptionField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.length() > 1;
    }


    @Step("Enter  data to API identifier field")
    public void ValidateApiIdentifierField(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(IdentifierKeyField));
        driver.findElement(IdentifierKeyField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(IdentifierKeyField).sendKeys(data);
    }


    @Step("Validating name field for spaces")
    public boolean ValidateApiIdentifierFieldWithSpaces() {
        wait.until(ExpectedConditions.elementToBeClickable(IdentifierKeyField));
        driver.findElement(IdentifierKeyField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.length() > 1;
    }

    @Step("Enter existing name to API identifier field")
    public void EnterExistingApiNameApiIdentifierField(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(IdentifierKeyField));
        driver.findElement(IdentifierKeyField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(IdentifierKeyField).sendKeys(data);
    }

    @Step("Validating max width field accepting characters")
    public boolean ValidateMaxWidthFieldAcceptingCharacters(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(MaxWidthField));
        driver.findElement(MaxWidthField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating max width field accepting negative value")
    public boolean ValidateMaxWidthFieldAcceptingNegativeValue(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(MaxWidthField));
        driver.findElement(MaxWidthField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }


    @Step("Validating min width field accepting characters")
    public boolean ValidateMinWidthFieldAcceptingCharacters(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(MaxHeightField));
        driver.findElement(MaxHeightField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating min width field accepting negative value")
    public boolean ValidateMinWidthFieldAcceptingNegativeValue(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(MaxHeightField));
        driver.findElement(MaxHeightField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating error message appears when creating Ad Format without entering a ad size")
    public boolean ValidateAdFormatAdSizeEmptyFieldError() {
        try {
            driver.findElement(AdFormatCreateButton).click();
            return driver.findElement(AdSizeEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message appears when creating Ad Format without entering preview name")
    public boolean ValidateAdFormatPreviewNameEmptyFieldError() {
        try {
            driver.findElement(AdFormatCreateButton).click();
            return driver.findElement(PreviewNameEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message appears when creating Ad Format without entering preview image")
    public boolean ValidateAdFormatPreviewImageEmptyFieldError() {
        try {
            driver.findElement(AdFormatCreateButton).click();
            return driver.findElement(PreviewImageEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating preview name field accepting more only spaces")
    public boolean ValidatePreviewNameFieldAcceptingOnlySpaces() {
        wait.until(ExpectedConditions.elementToBeClickable(PreviewNameField));
        driver.findElement(PreviewNameField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.length() > 1;
    }

    @Step("Validating description field accepting more only spaces")
    public boolean ValidateDescriptionFieldAcceptingOnlySpaces() {
        wait.until(ExpectedConditions.elementToBeClickable(AdPreviewDescriptionField));
        driver.findElement(AdPreviewDescriptionField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.length() > 1;
    }

    @Step("Validating description field accepting more than 35 characters")
    public boolean ValidateDescriptionFieldAcceptingMoreThan35Characters() {
        wait.until(ExpectedConditions.elementToBeClickable(AdPreviewDescriptionField));
        driver.findElement(AdPreviewDescriptionField).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.length() > 35;
    }

    @Step("Clicking on Preview Ad Plus Icon")
    public void ClickOnPreviewAdPlusIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(PreviewAdPlusIcon));
        driver.findElement(PreviewAdPlusIcon).click();
    }

    @Step("Optional click on Ad Preview Delete Icon")
    public void OptionalClickOnAdPreviewDeleteIcon(int elementIndex) {
        String xpathFormatter = String.format(AdPreviewDeleteIconXpath, elementIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }

    @Step("Validating vide min size   field accepting characters")
    public boolean ValidateVideoMinSizeFieldAcceptingCharacters(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(VideoMinSize));
        driver.findElement(VideoMinSize).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating vide min size  field accepting negative values")
    public boolean ValidateVideoMinSizeFieldAcceptingNegativeValues() {
        wait.until(ExpectedConditions.elementToBeClickable(VideoMinSize));
        driver.findElement(VideoMinSize).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.contains("-");
    }

    @Step("Validating error message appears when creating Ad Format without entering video max and min size")
    public boolean ValidateVideoSizeEmptyFieldError() {
        try {
            return driver.findElement(VideoMinSizeMaxSizeEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Click on Video Size Type DropDown")
    public void ClickOnVideoSizeTypeDropDown(int elementIndex) {
        String xpathFormatter = String.format(VideoSizeTypeDropDownXpath, elementIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }


    @Step("Validating vide max size field accepting characters")
    public boolean ValidateVideoMaxSizeFieldAcceptingCharacters(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(VideoMaxSize));
        driver.findElement(VideoMaxSize).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating vide max sizefield accepting negative values")
    public boolean ValidateVideoMaxSizeFieldAcceptingNegativeValues() {
        wait.until(ExpectedConditions.elementToBeClickable(VideoMaxSize));
        driver.findElement(VideoMaxSize).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.contains("-");
    }

    @Step("Optional click on Generic Options Selector")
    public void OptionalClickOnGenericOptionsSelector(int optionIndex) {
        String xpathFormatter = String.format(GenericOptionsSelectorXpath, optionIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }

    @Step("Selecting on Generic Option Selector")
    public void VideoFormatSelector(int optionIndex) {
        String xpathFormatter = String.format(GenericOptionSelectorXpath, optionIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }

    @Step("Validating error message appears when creating Ad Format without any vide accepted format")
    public boolean ValidateVideoAcceptedErrorMessage() {
        try {
            return driver.findElement(AcceptedFormatsErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating carousel min count field accepting characters")
    public boolean ValidateCarouselMinFieldAcceptingCharacters(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselMinCount));
        driver.findElement(CarouselMinCount).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating carousel min count field accepting negative values")
    public boolean ValidateCarouselMinFieldAcceptingNegativeValues() {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselMinCount));
        driver.findElement(CarouselMinCount).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.contains("-");
    }


    @Step("Validating carousel max count field accepting characters")
    public boolean ValidateCarouselMaxFieldAcceptingCharacters(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselMaxCount));
        driver.findElement(CarouselMinCount).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.equals(text);
    }

    @Step("Validating carousel max count field accepting negative values")
    public boolean ValidateCarouselMaxFieldAcceptingNegativeValues() {
        wait.until(ExpectedConditions.elementToBeClickable(CarouselMaxCount));
        driver.findElement(CarouselMaxCount).click();
        String nameValue = driver.switchTo().activeElement().getAttribute("value");
        return nameValue.contains("-");
    }


    @Step("Validating error message appears when carousel max count accept less than min count")
    public boolean ValidateCarouselCountErrorMessage() {
        try {
            return driver.findElement(CarouselItemCountErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message appears when at least one add carousel element is not added")
    public boolean ValidateAddCarouselElementErrorMessage() {
        try {
            return driver.findElement(AddCarouselElementErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating is restrict url field accepting only spaces")
    public boolean ValidateRestrictUrlFieldAcceptingOnlySpaces() {
        try {
            return driver.findElement(RestrictURLData).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating CTA url field accepting spaces or not")
    public boolean ValidateCtaOptionsFieldAcceptingOnlySpaces() {
        try {
            return driver.findElement(CtaOptionsData).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message appears with out any cta options")
    public boolean ValidateEmptyCtaOptionsErrorMessage() {
        try {
            return driver.findElement(CtaOptionsEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating error message appears with out any third party trackers")
    public boolean ValidateEmptyThirdPartyTrackersErrorMessage() {
        try {
            return driver.findElement(ThirdPartyTrackersEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message appears with out product list button field")
    public boolean ValidateEmptyProductListButtonFieldErrorMessage() {
        try {
            return driver.findElement(ProductListButtonEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message appears with out product list range field")
    public boolean ValidateEmptyProductListRangeFieldErrorMessage() {
        try {
            return driver.findElement(ProductListRangeEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message appears when min  count is greater than max count")
    public boolean ValidateProductsRangeCountFieldErrorMessage() {
        try {
            return driver.findElement(ProductsRangeCountErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message appears when max value is greater than 40 ")
    public boolean ValidateProductsRangeMaxFieldErrorMessage() {
        try {
            return driver.findElement(ProductsMaxErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message appears when schedule configuration is empty ")
    public boolean ValidateEmptyScheduleConfigurationErrorMessage() {
        try {
            return driver.findElement(EmptyScheduleConfigurationErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


}