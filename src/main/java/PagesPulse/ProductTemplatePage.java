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
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

public class ProductTemplatePage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductTemplatePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    final StringBuilder Text = RandomString();
    public final StringBuilder TwoHundredWords = createRandomString();
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By CreateProductTemplateButton = By.xpath("//button[contains(@class,'pendo_feature_oms_seller_create_product_template_button')]");
    final By TemplateNameField = By.xpath("//div[contains(@class,'pendo-oms-product-template-name')]/descendant::input");
    final By ProductTemplateNonPackagedRadioButton = By.xpath("//div[contains(@class,'pendo-oms-product-template-package-type-non-packaged')]");
    final By ProductTemplateNextButton = By.xpath("//button[contains(@class,'os-button pendo_feature_oms_package_template_details_')]");
    final String CampaignTypeSelector = "(//div[contains(@class,'dropdown-menu')]/descendant::a)[%d]";
    final String AddCampaignTemplatesRadioButton = "(//label[contains(@class,'os-custom-checkbox-label')])[%d]";
    final By AddCampaignTemplatesButton = By.xpath("//button[contains(@class,'pendo_feature_oms_admin_add_campaign_templates_button')]");
    final By BudgetAllocationField = By.xpath("//div[contains(@class,'pendo-oms-product-template-ct-bugdet-allocation')]/descendant::input");
    final By SaveAndActiveButton = By.xpath("//button[contains(@class,'pendo_feature_oms_package_template_form_save_and_activate_button')]");
    final By ProductTemplateTableFirstRowName = By.xpath("(//td[contains(@class,'pendo_feature_oms_package_template_table_name_column_link_button')]/descendant::span)[1]");
    final By ProductTemplateCreationPopUp = By.xpath("//div[contains(@class,'Toastify__progress-bar Toastify__progress-bar--animated Toastify__progress-bar-theme--colored Toastify__progress-bar--success')]");
    final By PriorityField = By.xpath("//div[contains(@class,'pendo-oms-product-template-ct-priority')]");
    final By ProductTemplateStatus = By.xpath("(//span[contains(@class,'status-displayname ')])[1]");
    final By DuplicateNameErrorPopUp = By.xpath("//div[contains(@class,'pendo-oms-product-template-api-error')]");
    final By BasicInfoEmptyFieldsErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By BasicInfoStartDateField = By.xpath("//div[contains(@class,'pendo-oms-product-template-visibility-duration-startDate')]/descendant::div[contains(@class,'os-datepicker ')]");
    final By BasicInfoMonthField = By.xpath("//div[contains(@class,'month-dropdown')]");
    final String BasicInfoMonthDropDown = "(//div[contains(@id,'-option-')])[%d]";
    final By BasicInfoYearField = By.xpath("//div[contains(@class,'year-dropdown')]");
    final String BasicInfoYearDropDown = "//div[text()='%d']";
    final String BasicInfoDateRange = "(//div[contains(@class,'react-datepicker__day--') and not(contains(@class,'--outside-month'))])[%d]";
    final By visibilityByAdAccountRadioButton = By.xpath("//div[contains(@class,'pendo-oms-product-template-visibility-by-ad-account')]");
    final By BasicInfoAddAdAccount = By.xpath("//button[contains(@class,'pendo_feature_oms_package_template_form_ad_accounts_button')]");
    final String AdAccountAdvertisersRadioButton = "(//label[contains(@class,'os-custom-checkbox-label')])[%d] ";
    final By AdAccountAdvertisersSaveButton = By.xpath("//button[contains(@class,'pendo-advertiser-table-save button')]");
    final By ProductTemplatePackagedRadioButton = By.xpath("//div[contains(@class,'pendo-oms-product-template-package-type-packaged')]");
    final By PricePerPackageField = By.xpath("//div[contains(@class,'pendo-oms-product-template-price-per-package')]/descendant::div[contains(@class,'white-bg')]");
    final By PackagesPerBrandField = By.xpath("//div[contains(@class,'pendo-oms-product-template-max-package')]/descendant::div[contains(@class,'input-wrapper') and not(contains(@class,'fake'))]");
    final By TotalNumberOfPackagesField = By.xpath("//div[contains(@class,'pendo-oms-product-template-total-package')]/descendant::div[contains(@class,'white-bg')]");
    final By PackagePerBrandMaxNumberErrorMessage = By.xpath("//div[contains(@class,'pendo-oms-product-template-max-package')]/descendant::div[contains(@class,'error-msg name-error-message')]");
    final By MinimumAdPeriodField = By.xpath("//div[contains(@class,'pendo-oms-product-template-min-ads-period')]/descendant::div[contains(@class,'white-bg')]");
    final By BudgetAllocationMoreOrLessErrorPopUp = By.xpath("//div[contains(@class,'pendo-oms-product-template-form-field-toast-error')]");
    final By BudgetAllocationEmptyErrorPopUp = By.xpath("//div[contains(@class,'pendo-oms-product-template-form-field-toast-error')]");
    final By SaveAsDraftErrorPopUp = By.xpath("//div[contains(@class,' pendo-oms-product-template-form-field-toast-error')]   ");
    final By SaveAsDraftButton = By.xpath("//button[contains(@class,'pendo_feature_oms_package_template_form_save_as_draft_button')]");
    final By SaveAndActiveErrorPopUp = By.xpath("//div[contains(@class,'pendo-oms-product-template-form-field-toast-error')]  ");
    final String PriorityDropdownSelection = "(//div[contains(@id,'-option-')])[%d]";
    final By AddCampaignsTemplateErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By AdsPeriodWindowStartDateField = By.xpath("(//div[contains(@class,'date-picker-input-wrapper')])[3]");
    final By AdsPeriodWindowEndDateField = By.xpath("(//div[contains(@class,'date-picker-input-wrapper')])[4]");

    final By AdsPeriodWindowMonthField = By.xpath("//div[contains(@class,'month-dropdown')]");
    final String AdsPeriodWindowMonthDropDown = "(//div[contains(@id,'-option-')])[%d]";
    final By AdsPeriodWindowYearField = By.xpath("//div[contains(@class,'year-dropdown')]");
    final String AdsPeriodWindowYearDropDown = "//div[text()='%d']";
    final String AdsPeriodWindowDateRange = "(//div[contains(@class,'react-datepicker__day--') and not(contains(@class,'--outside-month'))])[%d]";
    final By MinAdsPeriodFieldErrorMessage = By.xpath("//div[contains(@class,'error-msg name-error-message nowrap-text')]");
    final By BasicInfoEndDateField = By.xpath("//div[contains(@class,'pendo-oms-product-template-visibility-duration-endDate')]/descendant::div[contains(@class,'os-datepicker ')]");

    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");
    final By ProductTemplateButton = By.xpath("//span[contains(@class,'icon-product-templates')]");
    final By ExclusiveContentField = By.xpath("//div[contains(@class,'pendo-oms-package-template-exclusive-targets')]/descendant::button");
    final String ExclusiveContentDropdownSelection = "(//div[contains(@id,'-option-')])[%d]";
    final By ExclusiveContentListButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-exclusive-content_targeting')]");
    final By ExclusiveContentTableSearchField = By.xpath("//div[contains(@class,'pendo_feature_table_search_input ')]/descendant::input");
    final By ExclusiveContentTableFirstRow = By.xpath("(//tr[contains(@class,'odd')])[1]");
    final By ExclusiveContentProductsTemplateButton = By.xpath("//td[contains(@class,'pendo_feature_oms_package_template_exclusive_content_table_product_template_column')]/button");
    final By ExclusiveContentProductTemplateTableSearchField = By.xpath("(//div[contains(@class,'pendo_feature_table_search_input ')]/descendant::input)[2]");
    final By ExclusiveContentProductTemplateTableFirstRow = By.xpath("//td[contains(@class,'pendo_feature_oms_package_template_table_name_column_link_button universalText do-not-wrap')]/descendant::span");
    final By ExclusiveContentTableRefreshButton = By.xpath("(//button[contains(@class,'pendo-track-react-table-refresh-button')])[2]");
    final By ExclusiveContentSearchField = By.xpath("//div[contains(@class,'pendo-oms-package-template-exclusive-targets')]/descendant::input");
    final By CampaignTemplateTypeButton = By.xpath("(//div[contains(@class,'oms-product-template-split-button')]/descendant::button)[2]");
    final String CampaignTypeOptionSelector = "(//div[contains(@class,'oms-product-template-split-button')]/descendant::a)[%d]";
    final By AddCampaignTypeButton = By.xpath("//div[contains(@class,'oms-product-template-split-button')]");

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By ProductTemplateDashboardButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-product-templates_table ')]");

    @Step("Clicking on Product Template Dashboard Button")
    public void ClickOnProductTemplateDashboardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductTemplateDashboardButton));
        driver.findElement(ProductTemplateDashboardButton).click();
    }

    public StringBuilder RandomString() {
        String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk_0123456789";
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

    @Step("Clicking on Product Template Button")
    public void ClickOnProductTemplateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductTemplateButton));
        driver.findElement(ProductTemplateButton).click();
    }

    @Step("Clicking on pop up close button")
    public void ClickingOnPopUpCloseButton() throws InterruptedException {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(GenericPopUpCloseButton));
        driver.findElement(GenericPopUpCloseButton).click();
        Thread.sleep(1000);
    }

    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    @Step("Clicking on create product template button")
    public void ClickOnCreateProductTemplateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateProductTemplateButton));
        driver.findElement(CreateProductTemplateButton).click();
    }

    public static String ProductTemplateName;

    @Step("Adding desired name to template name field")
    public void AddDesiredName() {
        wait.until(ExpectedConditions.elementToBeClickable(TemplateNameField));
        driver.findElement(TemplateNameField).sendKeys(controlOrCommandKey + "a");
        ProductTemplateName = String.valueOf(RandomString());
        driver.findElement(TemplateNameField).sendKeys(ProductTemplateName);
    }

    @Step("Enter desired name to template name field")
    public void EnterDataInNameField(String Template_Name) {
        wait.until(ExpectedConditions.elementToBeClickable(TemplateNameField));
        driver.findElement(TemplateNameField).sendKeys(controlOrCommandKey, "a");
        driver.findElement(TemplateNameField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(TemplateNameField).sendKeys(Template_Name);
    }

    @Step("Clicking on non packaged radio button")
    public void ClickOnNonPackagedRadioButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductTemplateNonPackagedRadioButton));
        driver.findElement(ProductTemplateNonPackagedRadioButton).click();
    }

    @Step("Clicking on basic info next button")
    public void ClickOnBasicInfoNextButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductTemplateNextButton));
        driver.findElement(ProductTemplateNextButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Selecting campaign from add campaign template button options ")
    public void SelectingCampaignFromDropDown(int RadioButtonNo) {
        String XpathFormatter = String.format(CampaignTypeOptionSelector, RadioButtonNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired  product template from table")
    public void SelectingDesiredProductTemplateFromTable(int RadioButtonNo) {
        String XpathFormatter = String.format(AddCampaignTemplatesRadioButton, RadioButtonNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }


    @Step("Clicking add campaign templates button")
    public void ClickOnAddCampaignTemplatesButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddCampaignTemplatesButton));
        driver.findElement(AddCampaignTemplatesButton).click();
    }

    @Step("Enter data in budget allocation field")
    public void EnterDataInBudgetAllocationField(String BudgetValue) {
        wait.until(ExpectedConditions.elementToBeClickable(BudgetAllocationField));
        driver.findElement(BudgetAllocationField).sendKeys(controlOrCommandKey, "a");
        driver.findElement(BudgetAllocationField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(BudgetAllocationField).sendKeys(BudgetValue);

    }

    @Step("Clicking on priority field")
    public void ClickOnPriorityField() {
        wait.until(ExpectedConditions.elementToBeClickable(PriorityField));
        driver.findElement(PriorityField).click();
    }

    @Step("Clicking save and active button")
    public void ClickOnSaveAndActiveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveAndActiveButton));
        driver.findElement(SaveAndActiveButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Validating created product template")
    public Boolean ValidatingCreatedProductTemplate() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
            ExtensiveWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ProductTemplateCreationPopUp));
            return driver.findElement(ProductTemplateCreationPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating created product template enabled status")
    public Boolean ValidatingCreatedProductTemplateStatusEnabled() {
        boolean flag = false;
        wait.until(ExpectedConditions.elementToBeClickable(ProductTemplateStatus));
        String TemplateStatus = driver.findElement(ProductTemplateStatus).getText();
        if (TemplateStatus.equalsIgnoreCase("Enable"))
            flag = true;
        return flag;

    }

    @Step("Validating name field accepting spaces")
    public boolean ValidateNameFieldAcceptingSpaces() {
        boolean flag = false;
        String Text = driver.findElement(TemplateNameField).getAttribute("value");
        if (Text.trim().isEmpty()) {
            flag = true;
        }
        return flag;

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

    @Step("Validating name field accepting duplicate name")
    public boolean ValidateNameFieldAcceptingDuplicateName() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DuplicateNameErrorPopUp));
            return driver.findElement(DuplicateNameErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating basic info fields")
    public boolean ValidateBasicInfoFields() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BasicInfoEmptyFieldsErrorPopUp));
            return driver.findElement(BasicInfoEmptyFieldsErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on start date field ")
    public void ClickOnStartDateField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(BasicInfoStartDateField));
        driver.findElement(BasicInfoStartDateField).click();
    }

    @Step("Clicking on month field ")
    public void ClickOnMonthField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(BasicInfoMonthField));
        driver.findElement(BasicInfoMonthField).click();
    }

    @Step("Selecting desired month from month drop down ")
    public boolean SelectDesiredMonthFromBasicInfoMonthDropdown(int OptionNo) {
        boolean flag = true;
        String XpathFormatter = String.format(BasicInfoMonthDropDown, OptionNo);
        int CurrentMonthNumber = LocalDate.now().getMonthValue();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
        String selectedMonthText = driver.findElement(BasicInfoMonthField).getText().trim().toUpperCase();
        int selectedMonthNumber = Month.valueOf(selectedMonthText).getValue();
        if (selectedMonthNumber < CurrentMonthNumber) {
            flag = false;
        }
        return flag;
    }

    @Step("Clicking on year field ")
    public void ClickOnYearField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(BasicInfoYearField));
        driver.findElement(BasicInfoYearField).click();
    }

    @Step("Selecting desired year from year drop down ")
    public Boolean SelectDesiredYearFromYearDropdown(int OptionNo) {
        boolean flag = true;
        if (OptionNo < 2024) {
            flag = false;
        } else {
            String XpathFormatter = String.format(BasicInfoYearDropDown, OptionNo);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
            driver.findElement(By.xpath(XpathFormatter)).click();
        }
        return flag;
    }


    @Step("Selecting desired day from transaction day range ")
    public void SelectDesiredDayFromBasicInfoDayRange(int DayNo) {
        String XpathFormatter = String.format(BasicInfoDateRange, DayNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on visibility by ad account radio button")
    public void ClickOnBasicInfoByAdAccountRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(visibilityByAdAccountRadioButton));
        driver.findElement(visibilityByAdAccountRadioButton).click();
    }

    @Step("Clicking on basic info add ad account text")
    public void ClickOnBasicInfoAddAdAccountText() {
        wait.until(ExpectedConditions.elementToBeClickable(BasicInfoAddAdAccount));
        driver.findElement(BasicInfoAddAdAccount).click();
    }

    @Step("Selecting desired  account from ad account")
    public void SelectingDesiredAdvertisersFromAdAccount(int RadioButtonNo) {
        String XpathFormatter = String.format(AdAccountAdvertisersRadioButton, RadioButtonNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Clicking on add ad account save button")
    public void ClickOnAddAdAccountSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdAccountAdvertisersSaveButton));
        driver.findElement(AdAccountAdvertisersSaveButton).click();
    }

    @Step("Clicking on packaged radio button")
    public void ClickOnPackagedRadioButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductTemplatePackagedRadioButton));
        driver.findElement(ProductTemplatePackagedRadioButton).click();
    }

    @Step("Entering data in price per package")
    public void EnterDataInPricePerPackageField(String Value) {
        wait.until(ExpectedConditions.elementToBeClickable(PricePerPackageField));
        driver.findElement(PricePerPackageField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(String.valueOf(Value));
    }

    @Step("Entering data in total number of packages")
    public void EnterDataInTotalNumberOfPackagesField(String Value) {
        wait.until(ExpectedConditions.elementToBeClickable(TotalNumberOfPackagesField));
        driver.findElement(TotalNumberOfPackagesField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(String.valueOf(Value));
    }

    @Step("Entering data in packages per brand")
    public void EnterDataInPackagesPerBrandField(String Value) {
        WebElement nextButton = driver.findElement(PackagesPerBrandField);
        Actions actions = new Actions(driver);
        actions.moveToElement(nextButton).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PackagesPerBrandField));
        driver.findElement(PackagesPerBrandField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(String.valueOf(Value));
    }

    @Step("Validating price per package field accepting characters  without any error")
    public boolean ValidatePricePerPackagedFieldAcceptingCharacters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").equals("Abcd%^$#@&");
    }

    @Step("Validating price per package field accepting float value without any error")
    public boolean ValidatePricePerPackagedFieldAcceptingFloatValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").contains(".");
    }

    @Step("Validating price per package field accepting negative value without any error")
    public boolean ValidatePricePerPackagedFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").contains("-");
    }

    @Step("Validating packages per brand  field accepting characters  without any error")
    public boolean ValidatePackagesPerBrandFieldAcceptingCharacters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").equals("Abcd%^$#@&");
    }

    @Step("Validating packages per brand  field accepting float value without any error")
    public boolean ValidatePackagesPerBrandFieldAcceptingFloatValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").contains(".");
    }

    @Step("Validating packages per brand  field accepting negative value without any error")
    public boolean ValidatePackagesPerBrandFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").contains("-");
    }

    @Step("Validating number of packages field  field accepting characters  without any error")
    public boolean ValidateNumberOfPackagesFieldAcceptingCharacters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").equals("Abcd%^$#@&");
    }

    @Step("Validating number of packages field  field accepting float value without any error")
    public boolean ValidateNumberOfPackagesFieldAcceptingFloatValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").contains(".");
    }

    @Step("Validating number of packages field  field accepting negative value without any error")
    public boolean ValidateNumberOfPackagesFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").contains("-");
    }

    @Step("Validating packages per brand field accepting  greater value then total packages")
    public boolean ValidatePackagesPerBrandFieldAcceptingGreaterValueThanTotalPackages() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PackagePerBrandMaxNumberErrorMessage));
            return driver.findElement(PackagePerBrandMaxNumberErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Entering data in minimum ad period field")
    public void EnterDataInMinimumAdPeriodFieldField(String Value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MinimumAdPeriodField));
        driver.findElement(MinimumAdPeriodField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Value);
    }

    @Step("Validating minimum ad period field accepting characters  without any error")
    public boolean ValidateMinimumAdPeriodFieldAcceptingCharacters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").equals("Abcd%^$#@&");
    }

    @Step("Validating minimum ad period field accepting float value without any error")
    public boolean ValidateMinimumAdPeriodFieldAcceptingFloatValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").contains(".");
    }

    @Step("Validating minimum ad period field accepting negative value without any error")
    public boolean ValidateMinimumAdPeriodFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PricePerPackageField));
        return driver.switchTo().activeElement().getAttribute("value").contains("-");
    }

    @Step("Validating budget allocation field accepting less than 100%")
    public boolean ValidateBudgetAllocationFieldAcceptingLessThan100() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BudgetAllocationMoreOrLessErrorPopUp));
            return driver.findElement(BudgetAllocationMoreOrLessErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating budget allocation field accepting more than 100%")
    public boolean ValidateBudgetAllocationFieldAcceptingMoreThan100(String Number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BudgetAllocationField));
        return driver.findElement(BudgetAllocationField).getAttribute("value").equals(Number);
    }

    @Step("Validating budget allocation field accepting empty value")
    public boolean ValidateBudgetAllocationFieldAcceptingEmptyValue() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BudgetAllocationEmptyErrorPopUp));
            return driver.findElement(BudgetAllocationEmptyErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on save as draft button")
    public void ClickOnSaveAsDraftButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveAsDraftButton));
        driver.findElement(SaveAsDraftButton).click();
    }

    @Step("Validating save as draft empty button field error pop up")
    public boolean ValidateSaveAsDraftButtonEmptyFieldErrorPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SaveAsDraftErrorPopUp));
            return driver.findElement(SaveAsDraftErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating save and active button with out campaign template")
    public boolean ValidateSaveAndActiveButtonWithOutCampaignTemplate() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SaveAndActiveErrorPopUp));
            return driver.findElement(SaveAndActiveErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Selecting desired option from priority drop down ")
    public void SelectDesiredOptionFromPriorityDropDown(int OptionNo) {
        String XpathFormatter = String.format(PriorityDropdownSelection, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Validating add templates button with out selecting template")
    public boolean ValidateAddTemplateButtonWithOutSelectingTemplate() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddCampaignsTemplateErrorPopUp));
            return driver.findElement(AddCampaignsTemplateErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on start date field ")
    public void ClickOnAdsWindowStartDateField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AdsPeriodWindowStartDateField));
        driver.findElement(AdsPeriodWindowStartDateField).click();
    }

    @Step("Clicking on start date field ")
    public void ClickOnAdsWindowEndDateField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AdsPeriodWindowEndDateField));
        driver.findElement(AdsPeriodWindowEndDateField).click();
    }

    @Step("Clicking on month field ")
    public void ClickOnAdsWindowMonthField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AdsPeriodWindowMonthField));
        driver.findElement(AdsPeriodWindowMonthField).click();
    }

    @Step("Selecting desired month from month drop down ")
    public boolean SelectDesiredMonthFromAdsWindowMonthDropdown(int OptionNo) {
        boolean flag = true;
        String XpathFormatter = String.format(AdsPeriodWindowMonthDropDown, OptionNo);
        int CurrentMonthNumber = LocalDate.now().getMonthValue();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
        String selectedMonthText = driver.findElement(AdsPeriodWindowMonthField).getText().trim().toUpperCase();
        int selectedMonthNumber = Month.valueOf(selectedMonthText).getValue();
        if (selectedMonthNumber < CurrentMonthNumber) {
            flag = false;
        }
        return flag;
    }

    @Step("Clicking on year field ")
    public void ClickOnAdsWindowYearField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AdsPeriodWindowYearField));
        driver.findElement(AdsPeriodWindowYearField).click();
    }

    @Step("Selecting desired year from year drop down ")
    public Boolean SelectDesiredYearFromAdsWindowYearDropdown(int OptionNo) {
        boolean flag = true;
        if (OptionNo < 2024) {
            flag = false;
        } else {
            String XpathFormatter = String.format(AdsPeriodWindowYearDropDown, OptionNo);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
            driver.findElement(By.xpath(XpathFormatter)).click();
        }
        return flag;
    }


    @Step("Selecting desired day from transaction day range ")
    public void SelectDesiredDayFromAdsWindowDayRange(int DayNo) {
        String XpathFormatter = String.format(AdsPeriodWindowDateRange, DayNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Validating that the minimum ad field is within the start and end date range")
    public boolean ValidateMinAdFieldIsWithinTheStartAndEndDateRange() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MinAdsPeriodFieldErrorMessage));
            return driver.findElement(MinAdsPeriodFieldErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Clicking exclusive content field ")
    public void ClickOnExclusiveContentField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ExclusiveContentField));
        driver.findElement(ExclusiveContentField).click();
    }
    @Step("Selecting desired option from exclusive drop down ")
    public void SelectDesiredOptionFromExclusiveDropDown(int OptionNo) {
        String XpathFormatter = String.format(ExclusiveContentDropdownSelection, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }
    @Step("Clicking on exclusive content list button ")
    public void ClickOnExclusiveContentListButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ExclusiveContentListButton));
        driver.findElement(ExclusiveContentListButton).click();
        driver.navigate().refresh();
    }
    @Step("Entering data in exclusive content table search field")
    public void EnterDataInExclusiveContentTableSearchField(String Value) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ExclusiveContentTableSearchField));
        driver.findElement(ExclusiveContentTableSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Value);
        Thread.sleep(2000);
    }
    @Step("Validating exclusive content table search results is visible")
    public boolean ValidateExclusiveContentTableFirstRow() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ExclusiveContentTableFirstRow));
            return driver.findElement(ExclusiveContentTableFirstRow).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Clicking on exclusive content list products template button ")
    public void ClickOnExclusiveContentListProductsTemplateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ExclusiveContentProductsTemplateButton));
        driver.findElement(ExclusiveContentProductsTemplateButton).click();
    }
    @Step("Entering data in exclusive content table search field")
    public void EnterDataInExclusiveContentProductTemplateTableSearchField(String Value) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ExclusiveContentProductTemplateTableSearchField));
        driver.findElement(ExclusiveContentProductTemplateTableSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Value);


    }
    @Step("Validating exclusive content product template table search results is visible")
    public boolean ValidateExclusiveContentProductTemplateTableFirstRow() {
        try {
            Thread.sleep(2000);
            if (driver.findElements(ExclusiveContentProductTemplateTableFirstRow).isEmpty() ||
                    !driver.findElement(ExclusiveContentProductTemplateTableFirstRow).isDisplayed()) {
                Thread.sleep(60000);
                driver.findElement(ExclusiveContentTableRefreshButton).click();
                Thread.sleep(1500);
                String text = driver.findElement(ExclusiveContentProductTemplateTableFirstRow).getText();
                // System.out.println(text);
                // System.out.println(ProductTemplateName);
                return text.equals(ProductTemplateName);
            }

            String text = driver.findElement(ExclusiveContentProductTemplateTableFirstRow).getText();
            // System.out.println(text);
            // System.out.println(ProductTemplateName);
            return text.equals(ProductTemplateName);
        } catch (NoSuchElementException | TimeoutException | InterruptedException e) {
            return false;
        }
    }
    @Step("Entering data in exclusive content  search field")
    public void EnterDataInExclusiveContentSearchField(String Value) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ExclusiveContentSearchField));
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Value);
    }
    @Step("Clicking on Campaign Template Type button")
    public void ClickOnCampaignTemplateTypeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignTemplateTypeButton));
        driver.findElement(CampaignTemplateTypeButton).click();
    }
    @Step("Clicking on Campaign Type Selector at position {0}")
    public void ClickOnCampaignTypeSelector(int position) {
        By formattedXpath = By.xpath(String.format(CampaignTypeSelector, position));
        wait.until(ExpectedConditions.elementToBeClickable(formattedXpath));
        driver.findElement(formattedXpath).click();
    }

    @Step("Clicking on Add Campaign Type Button")
    public void ClickOnAddCampaignTypeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddCampaignTypeButton));
        driver.findElement(AddCampaignTypeButton).click();
    }
}
