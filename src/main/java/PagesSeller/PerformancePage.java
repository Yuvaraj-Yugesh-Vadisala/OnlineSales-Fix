package PagesSeller;

import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class PerformancePage {

    WebDriver driver;
    WebDriverWait wait;

    public PerformancePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    final By SaveButtonPopUp = By.xpath("//div[contains(@class,'pendo-track-performance-campaign-product-selection-settings-updated')]");
    final By EmptyKeywordFieldErrorMsg = By.xpath("//div[contains(@class,'pendo-track-add-empty-keywords-error')]");
    final By KeywordSuccessPopup = By.xpath("//div[contains(@class,'pendo-track-keywords-processed-successfully')]");
    final By KeywordFailurePopup = By.xpath("//div[contains(@class,'pendo-track-keywords-processed-partially')]");
    final By SelectProductUsingFilterDropDown = By.xpath("//div[contains(@class,'pendo-track-product-selection-by-filters')]");
    final By SelectIndividualProductToExcludeOption = By.xpath("//div[contains(@class,'pendo-track-product-selection-individual-products-to-exclude')]");
    final By ManualProductionSelectionProductNameField = By.xpath("//div[contains(@class,'pendo-track-manual-product-selection-product-name')]/descendant::input");
    final By SelectIndividualProductToIncludeOption = By.xpath("//div[contains(@class,'pendo-track-product-selection-individual-products-to-inlcude')]");

    final By TotalBudgetInActiveField = By.xpath("//div[contains(@class,'pendo-track-performance-total-budget-input')]");
    final By KeywordIdeasEmptyKeywordsPopUp = By.xpath("//div[contains(@class,'pendo-track-keyword-ideas-empty-error')]");
    final By FileUploadedPopUp = By.xpath("//div[contains(@class,'pendo-track-performance-campaign-file-uploaded-successfully')]");
    final By ManualBiddingErrorPopUp = By.xpath("//div[contains(@class,'pendo-track-bid-settings-atleast-one-bid')]");
    final By ExceedKeywordFailurePopup = By.xpath("//div[contains(@class,'pendo-track-keywords-count-failed')]");
    final By InvalidKeywordFailurePopup = By.xpath("//div[contains(@class,'pendo-track-keywords-processed-partially')]");
    final By ErrorMessageMaximumSpendCap = By.xpath("//div[contains(@class,'pendo-track-campaign-performance-maximum-spend-cap-error')]");
    final By PreviousDateButton = By.xpath("//button[@aria-label='Previous Month']");
    final By NextDateButton = By.xpath("//button[@aria-label='Next Month']");
    final By FirstDisplayMonthYear = By.xpath("(//div[@class='react-datepicker__current-month'])[1]");
    final By SecondDisplayMonthYear = By.xpath("(//div[@class='react-datepicker__current-month'])[2]");
    final String FirstDisplayMonthDays = "(//div[@class='react-datepicker__month-container'])" +
            "[1]/descendant::div[contains(@class,'react-datepicker__day') and @aria-disabled='false' and " +
            "not(contains(@class,'day--outside-month')) and text()='%d']";
    final String SecondDisplayMonthDays = "(//div[@class='react-datepicker__month-container'])" +
            "[2]/descendant::div[contains(@class,'react-datepicker__day') and @aria-disabled='false' and" +
            " not(contains(@class,'day--outside-month')) and text()='%d']";
    final By DateButton = By.xpath("//div[@class='date-range-input']");
    final By CalenderApplyButton = By.xpath("//button[contains(@class,'pendo_feature_date_comparison_apply_button')]");
    final By CreateNewCampaignButton = By.xpath("//button[contains(@class,'pendo_feature_campaign_card_create_new_button')]");
    final By CreateCampaignFrameTitle = By.xpath("//div[text()='Select your campaign type']");
    final By SearchOnlyCampaign = By.xpath("//div[contains(@class,'pendo-track-search-only-campaigns-title')]");
    final By NextStepCampaignButton = By.xpath("//button[contains(@class,'pendo-track-campaign-performance-create-campaign-next-button')]");
    final By DailyBudgetInactiveField = By.xpath("//div[contains(@class,'pendo-track-performance-daily-budget-input')]");
    final By DailyBudgetActiveField = By.xpath("//div[@class='in-progress-wrapper']/child::input");
    final By StartDateField = By.xpath("//div[contains(@class,'start-date')]/div");
    final By EndDateField = By.xpath("//div[contains(@class,'end-date')]/div");
    final By YearDropdown = By.xpath("//div[contains(@class,'year-dropdown')]");
    final By CampaignNameRenameButton = By.xpath("//span[@class='icon icon-edit-filled']");
    final By ExistingCampaignName = By.xpath("//div[@class='editable-header input-wrapper']/descendant::input");
    final By DefaultCampaignNamePreFilled = By.xpath("//div[@class='editable-header input-wrapper']/descendant::input");
    final By MonthDropdown = By.xpath("//div[contains(@class,'select-dropdown os-mr month-dropdown')]");
    final By ProductSelection = By.xpath("//div[contains(@class,'pendo_feature_track-product-selection-sidebar-tile')]");
    final By AddProductButton = By.xpath("//div[contains(@class,'float-menu-open')]//button[contains(@type,'button')]");
    final By ChooseProductIndividuallyButton = By.xpath("//span[@class='icon icon-edit_selection']");
    final By AddButton = By.xpath("//button[contains(@class,'pendo-track-skus-drawer-add-button')]");
    final By SaveButton = By.xpath("//button[contains(@class,'pendo-track-skus-drawer-save-button')]");
    final By DisabledSaveButton = By.xpath("//button[contains(@class,'pendo-track-skus-drawer-save-button') and contains(@class,'disabled')]");
    final By SaveButtonSpinner = By.xpath("//i[@class='icon icon-spinner icon-spin mr-2']");
    final By KeywordSettings = By.xpath("//div[contains(@class,'pendo_feature_track-keyword-bidding-sidebar-tile')]");
    final By AddKeywordsButton = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-positive-outer-add-new-keywords')]");
    final By KeywordTextField = By.xpath("//textarea[contains(@class,'form-control')]");
    final By AddGivenKeywords = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-positive-inner-add-new-keyword')]");
    final By SaveKeywordButton = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-positive-inner-save-btn-text ')]");
    final By SaveKeywordButtonDisabled = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-positive-inner-save-btn-text ') and contains(@class,'disabled')]");
    final By ApplyKeywordButton = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-positve-apply-btn')]");
    final By SearchOnlyCampaignLaunchButton = By.xpath("//button[contains(@class,'pendo-track-campaign-performance-search-only-launch-button')]");
    final By SearchOnlyCampaignTab = By.xpath("//div[contains(@class,'pendo_feature_campaign_list_campaign_sub_type_selection')]/descendant::label[contains(@for,'SEARCH_ONLY')]");
    final By CampaignNameVerificationFirstRow = By.xpath("//td[contains(@class,'pendo-track-goal-list-table-name')][1]");
    final By ErrorMessageDailyBudget = By.xpath("//div[contains(@class,'pendo-track-campaign-performance-daily-budget-error')]");
    final By DailyBudgetFilledData = By.xpath("//div[contains(@class,'pendo-track-performance-daily-budget-input')]/div/span/span");
    final By DailyBudgetFilledDataActive = By.xpath("//div[contains(@class,'pendo-track-performance-daily-budget-input')]/div/input");
    final By MaximumSpendCapFilledData = By.xpath("//div[contains(@class,'pendo-track-performance-total-budget-input border-padding')]/div/span/span");
    final By CrossButtonLevel1 = By.xpath("//label[@class='pure-toggle-label icon icon-close1' and @data-toggle-label='right']");
    final String CrossButtonLevel3 = "(//label[@class='pure-toggle-label icon icon-close1' and @data-toggle-label='right'])[%d]";
    final By KeywordCancelYesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By KeywordStatusToggle = By.xpath("//label[contains(@class,'pendo_feature_track-keyword-bidding-positive-status-on')]");
    final By SidebarToggleButton = By.xpath("//div[@class='sidebar-toggle-button']/child::label[contains(@class,'icon icon-arrow-')]");
    final By SmartCampaign = By.xpath("//div[contains(@class,'pendo-track-smart-shopping-campaigns-title')]");
    final By FlexiBudgetToggleButton = By.xpath("//span[@class='os-toggle-switch-round']");
    final By FlexiBudgetToggleOffConfirmationButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn ')]");
    final By ResetToIdealSettingsButton = By.xpath("//button[contains(@class,'button os-button  button-primary shape-cornor medium     link')]");
    final By ResetToIdealSettingsConfirmationButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn ')]");
    final By ResetToIdealSettingsCancelButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_right_btn ')]");
    final By ResetToIdealSettingsConfirmationPopUp = By.xpath("//div[@class='Toastify__toast-container Toastify__toast-container--top-center']");
    final By ManualModeProductSelection = By.xpath("(//div[@class='top-left']/span)[2]");//changed
    final By UploadProductsInBulkButton = By.xpath("//span[contains(@class,'icon icon-bulk_sku_selection')]");
    final By DownloadProductListText = By.xpath("//button[contains(@class,'button os-button download-link ')]");
    final By ProductListDownloadPopUp = By.xpath("//div[@id='popover-tour']");
    final By ProductListDownloadPopUpCloseButton = By.xpath("//div[contains(@class,'download-bar-z-index')]/descendant::span");
    final By DownloadProductListButton = By.xpath("//button[contains(@class,'pendo-track-bulk-download-button')]");
    final By DownloadButtonCloseButton = By.xpath("//span[@class='dismiss-icon icon icon-close1']");
    final By XlsxUploadingField = By.xpath("//div[@class='media-progress-overlay-dom']");
    final By XlsxInputField = By.xpath("//input[@accept='.xlsx']");
    final By BulkUploadCommentField = By.xpath("//div[contains(@class,'pendo-track-bulk-sku-upload-confirm-textarea-wrapper')]/textarea");
    final By CommentsConfirmingButton = By.xpath("//button[contains(@class,'pendo-track-bulk-sku-upload-confirm-button')]");
    final By CommentsBackButton = By.xpath("//button[@class='button os-button variable-button button-primary shape-cornor medium     link ']");
    final By BulkUploadCheckStatusButton = By.xpath("//button[@class='button os-button status-button button-primary shape-cornor medium   outline    ']");
    final By ManualProductSelectionFrameTitle = By.xpath("//div[@class='fixed-layout-header  ']");
    final By ChooseProductTypeSelectionDropdown = By.xpath("//div[contains(@class,'os-select-dropdown default')]/child::div[contains(@class,'Select__control')]");
    final String ManualProductSelectionGenericRowOptionsField = "(//div[@class='filters-options'])[%d]";
    final String ManualProductSelectionGenericOptionDropdownSelecting = "(//div[contains(@id,'option')])[%d]";
    final String ManualProductsSelectionGenericRowConditionField = "(//div[@class='filter-conditions'])[%d]";
    final String ManualProductSelectionGenericConditionDropdownSelecting = "(//div[contains(@id,'option')])[%d]";
    final By ManualProductionSelectionRowOneValueField = By.xpath("//div[@class='filter-values']");
    final String ManualProductionSelectionGenericRowInputField = "(//div[contains(@class,'pendo-track-aku-upload-filter-component-filter-value-wrapper')]/descendant::input)[%d]";
    final By ManualProductionSelectionCombinationsText = By.xpath("//div[contains(@class,'sku-selection-table-wrapper')]");
    final By ManualProductionAddNewRowButton = By.xpath("//span[@class='icon icon-add-plus']");
    final By ManualProductionSelectionDeleteRowButton = By.xpath("//span[@class='icon icon-close1']//span[@class='icon icon-close1']");
    final By ManualProductionSelectionSaveButton = By.xpath("//button[contains(@class,'pendo-track-skus-drawer-save-button')]");
    final By ManualProductionSelectionBackButton = By.xpath("//button[@class='button os-button auto-width button-primary shape-cornor medium   outline    ']");
    final By ManualProductionSelectionYesButton = By.xpath("//button[contains(@class,'button os-button pendo_feature_confirmation')]");
    final By TotalBudgetActiveField = By.xpath("//div[@class='in-progress-wrapper']/child::input");
    final By ProductSelectionDropdown = By.xpath("//div[@class='select-product']");
    final By ManualModeKeywordTargeting = By.xpath("//div[contains(@class,'pendo-track-manual-keyword-settings-wrapper')]");
    final By NegativeKeywordTargeting = By.xpath("//a[@data-rb-event-key='negativeKeywordTargeting']");
    final By AddNegativeKeywordsButton = By.xpath("//span[contains(@class,'pendo_feature_track-keyword-bidding-negative-outer-add')]");
    final By AddGivenNegativeKeywords = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-negative-inner-add-new-keyword')]");
    final By SaveNegativeKeywordSettings = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-negative-inner-save-btn-text')]");
    final By SaveNegativeKeywordSettingsDisabled = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-negative-inner-save-btn-text') and contains(@class,'disabled')]");
    final By ApplyNegativeKeywordSettings = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-negative-apply-btn')]");
    final By ApplyNegativeKeywordSettingsDisabled = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-negative-apply-btn') and contains(@class,'disabled')]");
    final By GetKeywordIdeas = By.xpath("//div[contains(@class,'pendo_feature_keyword_planner_keyword_ideas_cta')]");
    final By SearchCategoryDropdown = By.xpath("//div[contains(@class,'pendo-track-keyword-category-selection-dropdown')]");
    final String KeywordIdeasSearchCategory = "(//div[contains(@class,'Select__option ')])[%d]";
    final By ClickMatchTypeDropdown = By.xpath("(//div[contains(@class,'Select__placeholder ')])[1]");
    final By SelectPhraseMatchType = By.xpath("//div[contains(@class,'Select__option ') and contains(@id,'option-1')]");
    final By SelectButton = By.xpath("(//span[@class='icon icon-add-plus iconweight iconbtn'])[1]");
    final By BidPriceField = By.xpath("(//div[@class='in-progress-wrapper']/child::input[@class='form-control simple-input '])[1]");
    final By SaveSelectedKeywords = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-positive-inner-save-btn-text')]");
    final By AdvanceSettingsButton = By.xpath("//div[contains(@class,'pendo_feature_track-advance-settings-sidebar-tile')]");
    final By OptimizedCampaignPacing = By.xpath("//div[contains(@class,'form-tab-wrapper') and not(contains(@class,'selected'))]");
    final By SaveCampaignTypeButton = By.xpath("//button[contains(@class,'pendo-track-advance-settings-form-save-button')]");
    final By BidSettingsButton = By.xpath("//div[contains(@class,'pendo-track-campaign-performance-goal-settings-bid-settings')]");
    final By ManualBiddingRadioButton = By.xpath("(//div[@class='top-left']/span)[2]");
    final By ManualBiddingProductCategorySelector = By.xpath("(//div[@class='single-select-checkbox'])[0]");
    final String ManualBiddingAllProductCategorySelector = "(//label[@class='os-custom-checkbox-label'])[%d]";
    final By ManualBiddingUpdateBidPopUp = By.xpath("//div[@class='snackbar-block']");
    final By ManualBiddingUpdateBidButton = By.xpath("//button[contains(@class,'button os-button activate-btn-snackbar button-primary ')]");
    final By ManualBiddingBidUpdateInputField = By.xpath("(//input[@class='form-control simple-input ' and @type='number'])[7]");     //pendo needed
    final By ManualBiddingBidUpdateDoneButton = By.xpath("//button[@class='button os-button add-btn button-primary shape-cornor medium      ']");    //pendo needed
    final By ManualBiddingApplyButton = By.xpath("//button[contains(@class,'pendo-track-manual-bidding-apply-bid-button')]");
    final By ManualBiddingConfirmationButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal')]");
    final By ManualBiddingProductCount = By.xpath("//span[@class='tab-badge icon manual']");
    final By ManualBiddingBidCpcField = By.xpath("(//input[@class='form-control simple-input '])[2]");
    final By ManualBiddingBackButton = By.xpath("//button[@class='button os-button auto-width button-primary shape-cornor medium   outline    ']"); //pendo needed
    final By ManualProductionSelectionAddProductsPriceSorting = By.xpath("//th[contains(@class,'pendo-track-sku-selection-table-wrapper-header-price')]");
    final By ManualProductionSelectionFilterButton = By.xpath("//button[@class='button os-button os-filter-btn  button-default shape-cornor medium      ']"); //pendo needed
    final By ManualProductionSelectionProductNameFilterOption = By.xpath("(//span[@class='title-name-container'])[2]");
    final By ManualProductionSelectionProductCategoryFilterOption = By.xpath("(//span[@class='title-name-container'])[3]");
    final By ManualProductionSelectionProductCategoryField = By.xpath("//div[contains(@class,'pendo-track-manual-product-selection-product-category')]/descendant::input");
    final By ManualProductionSelectionProductBrandFilterOption = By.xpath("(//span[@class='title-name-container'])[4]");
    final By ManualProductionSelectionProductBrandField = By.xpath("(//div[@class='search-box-container']/descendant::div/input)[2]");
    final By ManualProductionSelectionPriceFilterOption = By.xpath("(//span[@class='title-name-container'])[5]");
    final By ManualProductionSelectionPriceMinField = By.xpath("(//div[@class='in-progress-wrapper']/input)[1]");
    final By ManualProductionSelectionPriceMaxField = By.xpath("(//div[@class='in-progress-wrapper']/input)[2]");
    final By ManualProductionSelectionSalePriceFilterOption = By.xpath("(//span[@class='title-name-container'])[6]");
    final By ManualProductionSelectionSalePriceMinField = By.xpath("(//div[@class='in-progress-wrapper']/input)[3]");
    final By ManualProductionSelectionSalePriceMaxField = By.xpath("(//div[@class='in-progress-wrapper']/input)[4]");
    final By ManualProductionSelectionFilterApplyButton = By.xpath("//button[contains(@class,'pendo_feature_global_filter_apply')]");
    final By ManualProductionSelectionFilterClearAllButton = By.xpath("//button[contains(@class,'pendo_feature_global_filter_clear_all')]");
    final By ManualProductionSelectionFilterClearAllConformationButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By ManualProductionSelectionAllProductsRadioButton = By.xpath("(//label[contains(@class,'pendo-track-sku-selection-table-row-selection-checkbox')])[1]");
    final By ManualBiddingBibCpcMinValueText = By.xpath("(//span[@class='error-msg bid-error'])[1]");
    final By CopySymbolForMatchType = By.xpath("(//span[@class='clipboard-block'])[1]");
    final By CopySymbolForBid = By.xpath("(//span[@class='clipboard-block'])[2]");
    final By MatchTypeCopySymbolText = By.xpath("(//a[@class='dropdown-item'])[1]");
    final By BidCopySymbolText = By.xpath("(//a[@class='dropdown-item'])[2]");
    final String ManualProductionSelectionFilterGenericResults = "(//div[@aria-hidden='false' and @role='tabpanel']/descendant::label[contains(@for,'checkbox')])['%d']";
    final By ManualProductionSelectionFilterGenericResultsValidation = By.xpath("(//div[@aria-hidden='false' and @role='tabpanel']/descendant::label[contains(@for,'checkbox')])[1]");
    final String ManualProductionSelectionGenericFieldWithDropDown = "(//div[contains(@class,'form-component-dropdown')]/descendant::input)[%d]";
    final String ManualProductionSelectionCategoryFieldDropdown = "(//div[contains(@class,'pendo-event-tracker-common-form-component-dropdownfilter')])[%d]";
    final By ManualProductionSelectionGenericFieldWithDropDownResults = By.xpath("//div[contains(@class,'Select__option--is-focused')]/div");
    final By ManualProductionSelectionsProductResults = By.xpath("(//table[contains(@class,'table sticky-header')]/descendant::div[contains(@class,'ellipsis-cell')])[1]");
    final By KeywordIdeasZeroBidValueErrorMessage = By.xpath("//span[@class='error-msg bid-validation-msg']");
    final By BulkUploadStatus = By.xpath("(//td[@role='cell'])[466]/div/span[@class='icon icon-close error-msg']");  //vulnerable
    final By SelectIndividualProductToIncludeErrorPopUp = By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--error']");
    final By KeywordIdeasBidValidationText = By.xpath("//span[@class='error-msg bid-validation-msg']");
    final By WarningIcon = By.xpath("//span[contains(@class,'icon icon-warning')]");
    final By SelectProductsResultsFrameCloseButton = By.xpath("(//label[@class='pure-toggle-label icon icon-close1'])[3]");
    final By ErrorMessageWhileSelectingProduct = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");
    final By PerformanceCampaignSelectWalletField = By.xpath("//div[contains(@class,'pendo-track-performance-config-wallet-selection-dropdown')]/descendant::button");
    final By YesConfirmationButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final String PerformanceCampaignWalletSelection = "(//div[contains(@id,'-option-')][%d])";
    final By ProductSelectionProductCount = By.xpath("//div[contains(@class,'pendo_feature_track-product-selection-sidebar-tile')]/span[contains(@class,'tab-badge icon manual')]");
    final By AddNetworksButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By NetworkTargetingTab = By.xpath("//div[contains(@class,'pendo_feature_track-network-targeting-sidebar-tile')]");
    final By NetworkSaveButton = By.xpath("//div[contains(@class,'fixed-layout-footer')]/descendant::button[contains(@class,'button os-button  button-primary shape-cornor')]");
    final By NetworkSaveButtonDisabled = By.xpath("//div[contains(@class,'fixed-layout-footer')]/descendant::button[contains(@class,'button os-button  button-primary shape-cornor') and contains(@class,'disable')]");
    final String DesiredNetwork = ("(//div[contains(@class,'common-card-component-wrapper')]/descendant::span[contains(@class,'selected-icon')])[%d]");

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;

    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }


    @Step("Validating bulk upload product count")
    public boolean ValidateBulkUploadProductCount(int Count) {
        boolean flag = false;
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(90));
        ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(ProductSelectionProductCount));
        String ActualCountText = driver.findElement(ProductSelectionProductCount).getText();
        int ActualCount = Integer.parseInt(ActualCountText);
        // System.out.println(ActualCount);
        System.out.println(" ");
        if (ActualCount == Count) {
            flag = true;
        }
        return flag;
    }

    @Step("Clicking on choose wallet field")
    public void ClickOnChooseWalletField() throws InterruptedException {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(90));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(PerformanceCampaignSelectWalletField));
        driver.findElement(PerformanceCampaignSelectWalletField).click();
    }
    @Step("Clicking Add networks button")
    public void ClickOnAdNetworkButton()  {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(90));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(AddNetworksButton));
        driver.findElement(AddNetworksButton).click();
    }
    @Step("Clicking  networks targeting tab ")
    public void ClickOnNetworkTargetingTab()  {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(90));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(NetworkTargetingTab));
        WebElement element = driver.findElement(NetworkTargetingTab);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    @Step("Select desired Network")
    public void SelectDesiredNetwork(int option)  {
        String XpathFormatter = String.format(DesiredNetwork, option);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking network save button")
    public void ClickOnNetworkSaveButton()  {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(90));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(NetworkSaveButton));
        driver.findElement(NetworkSaveButton).click();
        ExtensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(NetworkSaveButtonDisabled));
    }

    @Step("Selecting wallet option from drop down")
    public void SelectWalletFromDropDown(int OptionsSelector) {
        String XpathFormatter = String.format(PerformanceCampaignWalletSelection, OptionsSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on yes button")
    public void ClickingOnYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(YesConfirmationButton));
        driver.findElement(YesConfirmationButton).click();
    }

    @Step("Clicking on dashboard calender")
    public void ClickOnDashboardCalender() {
        wait.until(ExpectedConditions.elementToBeClickable(DateButton));
        driver.findElement(DateButton).click();
    }


    @Step("Click on calender and taking date range from user")
    public void selectDateRange(LocalDate startDate, LocalDate endDate) {
        wait.until(ExpectedConditions.elementToBeClickable(DateButton));
//        driver.findElement(DateButton).click();
        selectDate(startDate);
        selectDate(endDate);
    }

    @Epic("Traversing to the start and end date using calender navigation buttons")
    public void selectDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        YearMonth targetMonthYear = YearMonth.from(date);

        while (true) {
            String firstDisplayedMonthYearStr = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstDisplayMonthYear)).getText();
            String secondDisplayedMonthYearStr = wait.until(ExpectedConditions.visibilityOfElementLocated(SecondDisplayMonthYear)).getText();

            YearMonth firstDisplayedMonthYear = YearMonth.parse(firstDisplayedMonthYearStr, formatter);
            YearMonth secondDisplayedMonthYear = YearMonth.parse(secondDisplayedMonthYearStr, formatter);

            if (targetMonthYear.equals(firstDisplayedMonthYear)) {
                selectDay(date.getDayOfMonth(), FirstDisplayMonthDays);
                break;
            } else if (targetMonthYear.equals(secondDisplayedMonthYear)) {
                selectDay(date.getDayOfMonth(), SecondDisplayMonthDays);
                break;
            } else if (targetMonthYear.isBefore(firstDisplayedMonthYear)) {
                driver.findElement(PreviousDateButton).click();
            } else
                driver.findElement(NextDateButton).click();
        }
    }

    @Step("Clicking on the exact day")
    public void selectDay(int day, String dayPickerXpath) {
        String dayXPath = String.format(dayPickerXpath, day);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXPath)));
        driver.findElement(By.xpath(dayXPath)).click();
    }

    @Step("Clicking on apply button after range selection")
    public void ClickOnApplyDateRange() {
        wait.until(ExpectedConditions.elementToBeClickable(CalenderApplyButton));
        driver.findElement(CalenderApplyButton).click();
    }

    @Step("Clicking on create campaign button")
    public void ClickOnCreateCampaignButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateNewCampaignButton));
        WebElement element = driver.findElement(CreateNewCampaignButton);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
//        driver.findElement(CreateNewCampaignButton).click();
    }

    @Step("Validating create campaign button clickability")
    public boolean ValidateCreateCampaignTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateCampaignFrameTitle));
        return driver.findElement(CreateCampaignFrameTitle).isDisplayed();

    }

    @Step("Clicking on the search only campaign")
    public void SelectSearchOnlyCampaign() {
        wait.until(ExpectedConditions.elementToBeClickable(SearchOnlyCampaign));
        driver.findElement(SearchOnlyCampaign).click();
    }

    @Step("Clicking on the Next button")
    public void ClickingNextStepButton() {
        wait.until(ExpectedConditions.elementToBeClickable(NextStepCampaignButton));
        driver.findElement(NextStepCampaignButton).click();
    }

    @Step("Entering value to the Daily Budget Field")
    public void EnterDailyBudgetPrice(String DailyBudget) {
        wait.until(ExpectedConditions.elementToBeClickable(DailyBudgetInactiveField));
        driver.findElement(DailyBudgetInactiveField).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DailyBudgetActiveField));
        driver.findElement(DailyBudgetActiveField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(DailyBudgetActiveField).sendKeys(DailyBudget);

    }

    @Step("Clicking on start date field")
    public void ClickOnStartDateField() {
        wait.until(ExpectedConditions.elementToBeClickable(StartDateField));
        driver.findElement(StartDateField).click();
    }

    @Step("Clicking on start date field")
    public void ClickOnEndDateField() {
        wait.until(ExpectedConditions.elementToBeClickable(EndDateField));
        driver.findElement(EndDateField).click();
    }

    @Step("Selecting Start Date ")
    public void DateSelector(String month, String year, String date) {
        wait.until(ExpectedConditions.elementToBeClickable(MonthDropdown));
        driver.findElement(MonthDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'react-select') and contains(text(),'" + month + "')]")));
        driver.findElement(By.xpath("//div[contains(@id,'react-select') and contains(text(),'" + month + "')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(YearDropdown));
        driver.findElement(YearDropdown).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Select__menu-list css-qr46ko']/child::div[contains(@id,'react-select-8-option') and contains(text(),'"+year+"')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[(@class='Select__option Select__option--is-focused Select__option--is-selected css-tr4s17-option'  or @class='Select__option css-10wo9uf-option') and contains(text(),'" + year + "')]")));
        WebElement element = driver.findElement(By.xpath("//div[(@class='Select__option Select__option--is-focused Select__option--is-selected css-tr4s17-option'  or @class='Select__option css-10wo9uf-option') and contains(text(),'" + year + "')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--0" + date + "') and not(contains(@class,'outside-month'))]")));
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--0" + date + "') and not(contains(@class,'outside-month'))]")).click();

    }

    // public  String CampaignName ="New Campaign";
    @Step("Renaming of Search Only Campaign Name Button")
    public void RenameCampaignName(String CampaignName) {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignNameRenameButton));
        driver.findElement(CampaignNameRenameButton).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
//        driver.switchTo().activeElement().sendKeys(CampaignName);
    }

    @Step("Clicking on product selection button")
    public void ClickProductSelectionButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(90));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(ProductSelection));
        driver.findElement(ProductSelection).click();
    }

    @Step("Selecting a manual mode in product selection")
    public void ProductSelectionManualMode() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualModeProductSelection));
        driver.findElement(ManualModeProductSelection).click();
    }

    @Step("Clicking on add product button")
    public void ClickAddProductButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(AddProductButton));
        driver.findElement(AddProductButton).click();
    }

    @Step("Choosing products individually button")
    public void ClickChooseProductIndividuallyButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(ChooseProductIndividuallyButton));
        driver.findElement(ChooseProductIndividuallyButton).click();
    }


    @Step("Clicking on add button to add selected products")
    public void ClickAddButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(AddButton));
        driver.findElement(AddButton).click();
    }
    @Step("Clicking on save button to save selected products")
    public void ClickSaveButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        driver.findElement(SaveButton).click();
        ExtensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(DisabledSaveButton));


    }

    @Step("Clicking on the product selection type dropdown")
    public void ChooseProductSelectionTypeDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductSelectionDropdown));
        driver.findElement(ProductSelectionDropdown).click();
    }

    @Step("Choosing 'Select Product to Exclude' option from dropdown")
    public void ClickSelectProductToExcludeOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectIndividualProductToExcludeOption));
        driver.findElement(SelectIndividualProductToExcludeOption).click();
    }

    @Step("Choosing 'Select Product to include' option from dropdown")
    public void ClickSelectProductToIncludeOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectIndividualProductToIncludeOption));
        driver.findElement(SelectIndividualProductToIncludeOption).click();
    }

    @Step("Clicking on keyword settings button")
    public void ClickKeywordSettingsButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(not(ExpectedConditions.visibilityOfElementLocated(SaveButtonSpinner)));
        wait.until(ExpectedConditions.elementToBeClickable(KeywordSettings));
        driver.findElement(KeywordSettings).click();
    }

    @Step("Selecting a manual mode in keyword selection")
    public void KeywordSelectionManualMode() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualModeKeywordTargeting));
        driver.findElement(ManualModeKeywordTargeting).click();
    }

    @Step("Clicking on add keyword button")
    public void ClickAddKeywordsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddKeywordsButton));
        driver.findElement(AddKeywordsButton).click();
    }

    @Step("Adding desired positive keywords to keyword field manually")
    public void AddPositiveKeywordsManually(String Keyword, String KeywordType, String BidPrice, String Keyword2, String KeywordType2, String BidPrice2) {
        wait.until(ExpectedConditions.elementToBeClickable(KeywordTextField));
        driver.findElement(KeywordTextField).sendKeys(Keyword + ", " + KeywordType + ", " + BidPrice);
        driver.findElement(KeywordTextField).sendKeys(Keys.ENTER);
        driver.findElement(KeywordTextField).sendKeys(Keyword2 + ", " + KeywordType2 + ", " + BidPrice2);
    }

    @Step("Validate status of selected keywords")
    public boolean ValidateStatusOfKeyword() {
        wait.until(ExpectedConditions.elementToBeClickable(KeywordStatusToggle));
        return driver.findElement(KeywordStatusToggle).isEnabled();
    }

    @Step("Adding negative keywords till 999+")
    public void AddNegativeKeywordsFromExcel(String SheetName) {

        String UserPath = System.getProperty("user.dir");
        String workbookName = UserPath + File.separator + "Resources" +  File.separator + "OsmosResources" + File.separator + "Excel_data" + File.separator + "TEST_DATA_KEYWORDS.xlsx";
        wait.until(ExpectedConditions.elementToBeClickable(KeywordTextField));
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
            WebElement keywordField = driver.findElement(KeywordTextField);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value = arguments[1];", keywordField, allData.toString());
            driver.findElement(KeywordTextField).click();
            driver.findElement(KeywordTextField).sendKeys(" ");
//            driver.findElement(KeywordTextField).sendKeys(Keys.BACK_SPACE);

            workbook.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Step("Verify the error message for keyword field")
    public boolean ValidateSuccessfulKeywordAddition() {
        wait.until(ExpectedConditions.elementToBeClickable(KeywordSuccessPopup));
        return driver.findElement(KeywordSuccessPopup).isDisplayed();
    }

    @Step("Clicking on add keywords button to submit given keywords")
    public void ClickAddGivenKeywordsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddGivenKeywords));
        driver.findElement(AddGivenKeywords).click();
    }

    @Step("Clicking on yes button while cancelling save keywords")
    public void ClickYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(KeywordCancelYesButton));
        driver.findElement(KeywordCancelYesButton).click();
    }


    @Step("Clicking of save keywords button")
    public void ClickSaveKeywordsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveKeywordButton));
        driver.findElement(SaveKeywordButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(SaveKeywordButtonDisabled));
    }

    @Step("Clicking of apply keywords button")
    public void ClickApplyKeywordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ApplyKeywordButton));
        driver.findElement(ApplyKeywordButton).click();
    }

    @Step("Clicking on negative keyword targeting section")
    public void ClickNegativeKeywordTargeting() {
        wait.until(ExpectedConditions.elementToBeClickable(NegativeKeywordTargeting));
        driver.findElement(NegativeKeywordTargeting).click();
    }

    @Step("Clicking on 'add negative keywords' button")
    public void ClickAddNegativeKeywordsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddNegativeKeywordsButton));
        driver.findElement(AddNegativeKeywordsButton).click();
    }

    @Step("Adding desired negative keywords to keyword field manually")
    public void AddNegativeKeywordsManually(String Keyword1, String KeywordType1, String Keyword2, String KeywordType2) {
        wait.until(ExpectedConditions.elementToBeClickable(KeywordTextField));
        driver.findElement(KeywordTextField).sendKeys(Keyword1 + ", " + KeywordType1);
        driver.findElement(KeywordTextField).sendKeys(Keys.ENTER);
        driver.findElement(KeywordTextField).sendKeys(Keyword2 + ", " + KeywordType2);
    }

    @Step("Clicking on add negative keywords button to submit given keywords ")
    public void AddNegativeKeywordsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddGivenNegativeKeywords));
        driver.findElement(AddGivenNegativeKeywords).click();
    }

    @Step("Click on save negative keywords button")
    public void ClickSaveNegativeKeywordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveNegativeKeywordSettings));
        driver.findElement(SaveNegativeKeywordSettings).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(SaveNegativeKeywordSettingsDisabled));
    }

    @Step("Click on apply negative keywords button")
    public void ClickApplyNegativeKeywordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ApplyNegativeKeywordSettings));
        driver.findElement(ApplyNegativeKeywordSettings).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ApplyNegativeKeywordSettingsDisabled));

    }

    @Step("Clicking on the search only campaign launch button")
    public void ClickSearchOnlyLaunchButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(not(ExpectedConditions.visibilityOfElementLocated(SaveButtonSpinner)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchOnlyCampaignLaunchButton));
        driver.findElement(SearchOnlyCampaignLaunchButton).click();
    }

    @Step("Validating successful creation of Search Only campaign")
    public boolean ValidateCreatedSearchOnlyCampaignName(String CampaignName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignNameVerificationFirstRow));
        // System.out.println(driver.findElement(CampaignNameVerificationFirstRow).getText());
        return driver.findElement(CampaignNameVerificationFirstRow).getText().equalsIgnoreCase(CampaignName);
    }
    @Step("Clicking on searchOnly campaign tab in home page")
    public void ClickSearchOnlyCampaignTab() {
        wait.until(ExpectedConditions.elementToBeClickable(SearchOnlyCampaignTab));
        WebElement element = driver.findElement(SearchOnlyCampaignTab);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @Step("Clicking on get keyword ideas")
    public void ClickGetKeywordIdeas() {
        wait.until(ExpectedConditions.elementToBeClickable(GetKeywordIdeas));
        driver.findElement(GetKeywordIdeas).click();
    }

    @Step("Clicking on Search category dropdown")
    public void ClickSearchCategoryDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(SearchCategoryDropdown));
        driver.findElement(SearchCategoryDropdown).click();
    }

    @Step("Selecting Frozen desert>Frozen Yogurt")
    public void SelectingKeywordIdeasSearchCategory(int OptionsSelector) {
        String XpathFormatter = String.format(KeywordIdeasSearchCategory, OptionsSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking match type dropdown")
    public void ClickMatchTypeDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(ClickMatchTypeDropdown));
        driver.findElement(ClickMatchTypeDropdown).click();
    }

    @Step("Clicking match type dropdown")
    public void SelectPhraseFromMatchTypeDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(SelectPhraseMatchType));
        driver.findElement(SelectPhraseMatchType).click();
    }

    @Step("Adding bid value for selected keyword")
    public void AddBidValue(String BidPrice) {
        wait.until(ExpectedConditions.elementToBeClickable(BidPriceField));
//        driver.findElement(BidPriceField).click();
        driver.findElement(BidPriceField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(BidPriceField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(BidPriceField).sendKeys(BidPrice);
    }

    @Step("Clicking select button to select keyword ")
    public void ClickSelectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SelectButton));
        driver.findElement(SelectButton).click();
    }

    @Step("Click save selected keywords")
    public void ClickSaveSelectedKeywords() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveSelectedKeywords));
        driver.findElement(SaveSelectedKeywords).click();
    }

    @Step("Validate error message daily budget")
    public boolean ValidateErrorMessageDailyBudget() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageDailyBudget));
        return driver.findElement(ErrorMessageDailyBudget).isDisplayed();
    }

    @Step("Validate error message for maximum spend cap ")
    public boolean ValidateErrorMessageMaximumSpendCap() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageMaximumSpendCap));
        return driver.findElement(ErrorMessageMaximumSpendCap).isDisplayed();
    }

    @Step("Validate daily budget field not accepting negative value")
    public boolean ValidateDailyBudgetFieldWithNegativeValue() {
        wait.until(ExpectedConditions.elementToBeClickable(SidebarToggleButton));
        driver.findElement(SidebarToggleButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DailyBudgetFilledData));
        wait.until(ExpectedConditions.textToBe(DailyBudgetFilledData, "200"));
        return driver.findElement(DailyBudgetFilledData).getText().equals("-200");
    }

    @Step("Validate daily budget field not accepting characters")
    public boolean ValidateDailyBudgetFieldWithCharacters(String characters) {
        wait.until(ExpectedConditions.textToBe(DailyBudgetFilledDataActive, ""));
        String text = driver.findElement(DailyBudgetFilledDataActive).getAttribute("value");
        return text.equalsIgnoreCase(characters);
    }

    @Step("Validate maximum spend cap field not accepting negative value")
    public boolean ValidateMaximumSpendCapFieldWithNegativeValue() {
        wait.until(ExpectedConditions.elementToBeClickable(SidebarToggleButton));
        driver.findElement(SidebarToggleButton).click();
        wait.until(ExpectedConditions.textToBe(MaximumSpendCapFilledData, "400"));
        return driver.findElement(MaximumSpendCapFilledData).getText().equals("-400");

    }

    @Step("Validate maximum spend cap field not accepting special characters")
    public boolean ValidateMaximumSpendCapFieldWithCharacters(String characters) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(SidebarToggleButton));
        driver.findElement(SidebarToggleButton).click();
        Thread.sleep(1000);
        driver.findElement(SidebarToggleButton).click();
        wait.until(ExpectedConditions.textToBe(MaximumSpendCapFilledData, ""));
        return driver.findElement(MaximumSpendCapFilledData).getText().equalsIgnoreCase(characters);


    }

    @Step("Clicking cross button")
    public void ClickCrossButtonLevel1() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CrossButtonLevel1));
        driver.findElement(CrossButtonLevel1).click();
    }

    @Step("Clicking cross button")
    public void ClickCrossButtonLevel(int CrossButtonLevel) {
        String XpathFormatter = String.format(CrossButtonLevel3, CrossButtonLevel);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Validate clicking cross button")
    public boolean ValidateCreateNewCampaignButtonVisibility() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateNewCampaignButton));
        return driver.findElement(CreateNewCampaignButton).isDisplayed();
    }


    @Step("Clicking on smart campaign")
    public void ClickOnSmartCampaign() { // Not used as of now as it is a default value
        wait.until(ExpectedConditions.elementToBeClickable(SmartCampaign));
        driver.findElement(SmartCampaign).click();
    }

    @Step("Clicking on the next button")
    public void ClickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(NextStepCampaignButton));
        driver.findElement(NextStepCampaignButton).click();
    }

    @Step("Entering value to the maximum spend cap filed")
    public void EnterMaximumSpendCapPrice(String BudgetValue) {
        wait.until(ExpectedConditions.elementToBeClickable(TotalBudgetInActiveField));
        driver.findElement(TotalBudgetInActiveField).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TotalBudgetActiveField));
        driver.findElement(TotalBudgetActiveField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(TotalBudgetActiveField).sendKeys(BudgetValue);
    }

    @Step("Toggling on flexi budget button")
    public void TogglingOnFlexiBudgetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FlexiBudgetToggleButton));
        driver.findElement(FlexiBudgetToggleButton).click();
    }

    @Step("Toggling off flexi budget button")
    public void TogglingOffFlexiBudgetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FlexiBudgetToggleButton));
        driver.findElement(FlexiBudgetToggleButton).click();
    }

    @Step("Confirming toggling off flexi budget")
    public void ClickOnYesForFlexiBudgetConfirmation() {
        wait.until(ExpectedConditions.elementToBeClickable(FlexiBudgetToggleOffConfirmationButton));
        driver.findElement(FlexiBudgetToggleOffConfirmationButton).click();
    }

    @Step("Renaming of campaign name button")
    public String RenameCampaignName() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignNameRenameButton));
        driver.findElement(CampaignNameRenameButton).click();
        String DefaultCampaignName = driver.findElement(DefaultCampaignNamePreFilled).getAttribute("value");
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(DefaultCampaignName);
        return DefaultCampaignName;
    }

    @Step("Verify the error message for keyword field")
    public boolean ValidateErrorMessageKeywordField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(KeywordFailurePopup));
        return driver.findElement(KeywordFailurePopup).isDisplayed();
    }
    final By ErrorMessageForNetworkTargeting = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    @Step("Verify the error message for not selecting any network and clicking save button")
    public boolean ValidateErrorMessageForNotSelectionOfAnyNetwork() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForNetworkTargeting));
        return driver.findElement(ErrorMessageForNetworkTargeting).isDisplayed();
    }

    @Step("Verify the error message for keyword field")
    public boolean ValidateExceedLimitKeywordAdditionErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ExceedKeywordFailurePopup));
        return driver.findElement(ExceedKeywordFailurePopup).isDisplayed();

    }

    @Step("Verify the error message for keyword field")
    public boolean ValidateInvalidKeywordAdditionErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidKeywordFailurePopup));
        return driver.findElement(InvalidKeywordFailurePopup).isDisplayed();

    }

    @Step("Verify the error message for keyword field")
    public boolean ValidateErrorMessageForEmptyKeywordField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmptyKeywordFieldErrorMsg));
        return driver.findElement(EmptyKeywordFieldErrorMsg).isDisplayed();
    }

    @Step("Clicking the smart campaign reset to ideal settings button")
    public void ClickResetToIdealSettingsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ResetToIdealSettingsButton));
        driver.findElement(ResetToIdealSettingsButton).click();
    }

    @Step("Clicking the reset to ideal settings confirmation button")
    public void ClickRestIdealSettingConfirmationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ResetToIdealSettingsConfirmationButton));
        driver.findElement(ResetToIdealSettingsConfirmationButton).click();
    }

    @Step("Validating reset to ideal settings confirmation button click ability")
    public boolean ValidateResetToIdealSettingsConfirmation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ResetToIdealSettingsConfirmationPopUp));
        return driver.findElement(ResetToIdealSettingsConfirmationPopUp).isDisplayed();
    }

    @Step("Clicking the reset to ideal settings cancel button")
    public void ClickResetIdealSettingCancelButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ResetToIdealSettingsButton));
        driver.findElement(ResetToIdealSettingsButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(ResetToIdealSettingsCancelButton));
        driver.findElement(ResetToIdealSettingsCancelButton).click();
    }

    @Step("Clicking the advance settings button")
    public void ClickAdvanceSettingsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdvanceSettingsButton));
        driver.findElement(AdvanceSettingsButton).click();
    }

    @Step("Selecting optimized campaign pacing")
    public void SelectOptimizedCampaignPacing() {
        wait.until(ExpectedConditions.elementToBeClickable(OptimizedCampaignPacing));
        driver.findElement(OptimizedCampaignPacing).click();
    }


    @Step("Clicking the smart campaign launch button")
    public void ClickSmartLaunchButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(not(ExpectedConditions.visibilityOfElementLocated(SaveButtonSpinner)));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(SearchOnlyCampaignLaunchButton));
        driver.findElement(SearchOnlyCampaignLaunchButton).click();
    }

    @Step("Clicking Save Button to Choose Campaign Type")
    public void ClickCampaignTypeSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveCampaignTypeButton));
        driver.findElement(SaveCampaignTypeButton).click();
    }

    @Step("Validating the smart campaign created campaign name")
    public boolean ValidateCreatedSmartCampaignName(String CampaignName) {
        // System.out.println(CampaignName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignNameVerificationFirstRow));
        return driver.findElement(CampaignNameVerificationFirstRow).getText().equalsIgnoreCase(CampaignName);

    }

    @Step("Selecting a product option in smart campaign")
    public void ClickingProductSelectionButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(ProductSelection));
        driver.findElement(ProductSelection).click();
    }


    @Step("Clicking on add products Button")
    public void ClickingAddProductButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddProductButton));
        driver.findElement(AddProductButton).click();
    }

    @Step("Clicking on upload products in bulk button")
    public void ClickingUploadProductsInBulkButton() {
        wait.until(ExpectedConditions.elementToBeClickable(UploadProductsInBulkButton));
        driver.findElement(UploadProductsInBulkButton).click();
    }

    @Step("Clicking on download product list button")
    public void ClickingDownloadProductListText() {
        wait.until(ExpectedConditions.elementToBeClickable(DownloadProductListText));
        driver.findElement(DownloadProductListText).click();
    }

    @Step("Validating download product list pop up")
    public boolean ValidatingProductListDownloadPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductListDownloadPopUp));
        return driver.findElement(ProductListDownloadPopUp).isDisplayed();
    }

    @Step("Clicking on  download product list pop up close button")
    public void ClickingOnDownloadProductListPopUpCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductListDownloadPopUpCloseButton));
        driver.findElement(ProductListDownloadPopUpCloseButton).click();

    }

    @Step("Clicking on download product list Button")
    public void ClickingOnDownloadProductListButton() {
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        Wait.until(ExpectedConditions.elementToBeClickable(DownloadProductListButton));
        driver.findElement(DownloadProductListButton).click();
        driver.findElement(DownloadButtonCloseButton).click();

    }

    private static File excelFileName; //Global Variable added

    @Step("Modifying bulk upload file with yes and uploading")
    public void BulkUploadFileModifiedWithYes(int NumberOfOccurrenceForYes) throws IOException {

        String downloadFolderPath = System.getProperty("user.home") + File.separator + "Downloads" + File.separator;
        File downloadFolder = new File(downloadFolderPath);
        Pattern pattern = Pattern.compile("^BULK_PRODUCT.*");

        for (File file : downloadFolder.listFiles()) {
            if (pattern.matcher(file.getName()).matches()) {
                excelFileName = file;
                break;  // Exit the loop after finding the first match
            }
        }

        // Step 3: Load the Excel file
        File file = new File(downloadFolderPath + excelFileName.getName());
        FileInputStream ExcelFile = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(ExcelFile);
        Sheet sheet = workbook.getSheetAt(0);  // Assuming the first sheet is the target

        // Step 4: Modify the first 3 occurrences of "No" to "Yes" in the "Select" column
        int selectColumnIndex = findColumnIndex(sheet, "Selected");
        int modifiedCount = 0;

        for (Row row : sheet) {
            Cell cell = row.getCell(selectColumnIndex);
            if (cell != null && "No".equalsIgnoreCase(cell.getStringCellValue())) {
                cell.setCellValue("Yes");
                modifiedCount++;
                if (modifiedCount == NumberOfOccurrenceForYes) {
                    break;
                }
            }
        }

        // Step 5: Write the updated file back to disk
        ExcelFile.close();  // Close input stream
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        workbook.close();
        fos.close();

        System.out.println("Successfully modified the first 3 'No' values to 'Yes' in the 'Select' column.");
        // System.out.println(downloadFolder + "\\" + excelFileName.getName());
        driver.findElement(XlsxInputField).sendKeys(downloadFolder + File.separator + excelFileName.getName());
        System.out.println("Uploaded Successfully");
    }


    // Helper function to find the index of the "Select" column
    public int findColumnIndex(Sheet sheet, String columnName) {
        Row headerRow = sheet.getRow(0);  // Assuming the first row is the header
        for (Cell cell : headerRow) {
            if (columnName.equalsIgnoreCase(cell.getStringCellValue())) {
                return cell.getColumnIndex();
            }
        }
        return -1;  // Column not found
    }

    @Step("Deleting Bulk Product File") // Only can be called after BulkUploadFileModifiedWithYes
    public void DeleteFileAfterModification() {
        excelFileName.delete();
        // System.out.println("File Deleted Successfully");
    }

    @Step("Uploading xlsx file into the field ")
    public void UploadingXlsxFileIntoInputField(String FileName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(XlsxUploadingField));
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" +  File.separator + "OsmosResources" + File.separator + "Excel_data" + File.separator + FileName;
        driver.findElement(XlsxInputField).sendKeys(Filepath);
    }

    @Step("Entering comments to bulk uploaded field")
    public void EnteringCommentsIntoBulkUploadCommentField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BulkUploadCommentField));
        driver.findElement(BulkUploadCommentField).sendKeys("Uploaded Sample Products File");
    }

    @Step("Clicking on comments confirm button")
    public void ClickingOnCommentsConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CommentsConfirmingButton));
        driver.findElement(CommentsConfirmingButton).click();
    }

    @Step("Clicking on comments back button")
    public void ClickingOnCommentsBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CommentsBackButton));
        driver.findElement(CommentsBackButton).click();
    }

    @Step("Clicking on check status  button")
    public void ClickingOnCheckStatusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(BulkUploadCheckStatusButton));
        driver.findElement(BulkUploadCheckStatusButton).click();
    }


    @Step("Validating uploaded file pop up")
    public boolean ValidatingUploadedFilePopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FileUploadedPopUp));
        return driver.findElement(FileUploadedPopUp).isDisplayed();
    }

    @Step("Validating manual product selection frame title")
    public void ValidatingManualProductSelectionFrameTitle() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        ExtensiveWait.until(not(ExpectedConditions.visibilityOfElementLocated(ManualProductSelectionFrameTitle)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchOnlyCampaignLaunchButton));
        ClickProductSelectionButton();
    }

    @Step("Clicking on Choose products field")
    public void ClickingOnChooseProductsField() {
        wait.until(ExpectedConditions.elementToBeClickable(ChooseProductTypeSelectionDropdown));
        driver.findElement(ChooseProductTypeSelectionDropdown).click();
    }

    @Step("Clicking on select products using filters from dropdown")
    public void ClickingOnSelectProductsUsingFilters() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectProductUsingFilterDropDown));
        driver.findElement(SelectProductUsingFilterDropDown).click();
    }


    @Step("Selecting product option in row one field one")
    public void ClickingOnManualProductGenericRowOptionField(int RowOptionSelector) {
        String XpathFormatter = String.format(ManualProductSelectionGenericRowOptionsField, RowOptionSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting product option in row one field one")
    public void ClickingOnManualProductGenericOptionsDropdown(int OptionsSelector) {
        String XpathFormatter = String.format(ManualProductSelectionGenericOptionDropdownSelecting, OptionsSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Step("Clicking on manual product selection row one condition dropdown")
    public void ClickingOnManualProductGenericRowConditionDropField(int RowConditionSelector) {
        String XpathFormatter = String.format(ManualProductsSelectionGenericRowConditionField, RowConditionSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting manual product option in row one condition dropdown")
    public void ClickingOnManualProductGenericConditionsDropdown(int ConditionsSelector) {
        String XpathFormatter = String.format(ManualProductSelectionGenericConditionDropdownSelecting, ConditionsSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on manual product value field in row one")
    public void ClickingOnManualProductValueFieldInRowOne() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionRowOneValueField));
        driver.findElement(ManualProductionSelectionRowOneValueField).click();

    }

    @Step("Entering data into manual product value field in row one")
    public void EnteringDataIntoManualProductGenericInputField(int RowInputFieldSelector, String Input) {
        String XpathFormatter = String.format(ManualProductionSelectionGenericRowInputField, RowInputFieldSelector);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).sendKeys(Input);
    }

    @Step("Clicking on product combination results")
    public void ClickingOnProductsCombinationResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionCombinationsText));
        driver.findElement(ManualProductionSelectionCombinationsText).click();
    }

    @Step("Adding manual product selection second row combination fields")
    public void ClickingOnAddRowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionAddNewRowButton));
        driver.findElement(ManualProductionAddNewRowButton).click();
    }

    @Step("Clicking on manual production save button")
    public void ClickingOnManualProductionSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionSaveButton));
        driver.findElement(ManualProductionSelectionSaveButton).click();
    }

    @Step("Clicking on manual production back button")
    public void ClickingOnManualProductionBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionBackButton));
        driver.findElement(ManualProductionSelectionBackButton).click();
    }

    @Step("Clicking on confirm button in manual production for going to back page")
    public void ClickingOnManualProductionYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionYesButton));
        driver.findElement(ManualProductionSelectionYesButton).click();
    }

    @Step("Validating product selection settings pop up")
    public boolean ValidatingProductSelectionSettingsPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SaveButtonPopUp));
        return driver.findElement(SaveButtonPopUp).isDisplayed();
    }

    @Step("Validating product selection settings pop up")
    public boolean ValidatingErrorMessageWhileClickingSaveWithoutAddingAnyProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageWhileSelectingProduct));
        return driver.findElement(ErrorMessageWhileSelectingProduct).isDisplayed();
    }

    @Step("Clicking on bid settings button")
    public void ClickingOnBidSettingsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(BidSettingsButton));
        driver.findElement(BidSettingsButton).click();
    }

    @Step("Selecting  manual bidding radio button")
    public void SelectingManualBiddingRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualBiddingRadioButton));
        driver.findElement(ManualBiddingRadioButton).click();
    }

    @Step("Selecting  product category in manual bidding ")
    public void SelectingProductCategoryInManualBidding() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualBiddingProductCategorySelector));
        driver.findElement(ManualBiddingProductCategorySelector).click();
    }

    @Step("Validating manual bidding update bid pop up")
    public boolean ValidatingManualBiddingUpdateBidPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualBiddingUpdateBidPopUp));
        return driver.findElement(ManualBiddingUpdateBidPopUp).isDisplayed();
    }

    @Step("Clicking on  update bid button in manual bidding ")
    public void ClickingOnUpdateBidButtonInManualBidding() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ManualBiddingUpdateBidButton));
        driver.findElement(ManualBiddingUpdateBidButton).click();

    }

    @Step("Entering data into manual bidding bid update field ")
    public void EnteringDataIntoManualBiddingBidUpdateField(String BidValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualBiddingBidUpdateInputField));
        driver.findElement(ManualBiddingBidUpdateInputField).sendKeys(BidValue);
    }

    @Step("Clicking on manual bidding bid update done button ")
    public void ClickingOnManualBiddingBidUpdateDoneButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualBiddingBidUpdateDoneButton));
        driver.findElement(ManualBiddingBidUpdateDoneButton).click();

    }

    @Step("Clicking on manual bidding apply button ")
    public void ClickingOnManualBiddingApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualBiddingApplyButton));
        driver.findElement(ManualBiddingApplyButton).click();
    }

    @Step("Clicking on manual bidding back button ")
    public void ClickingOnManualBiddingBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualBiddingBackButton));
        driver.findElement(ManualBiddingBackButton).click();
    }

    @Step("Clicking on manual bidding confirmation button ")
    public void ClickingOnManualBiddingConfirmationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualBiddingConfirmationButton));
        driver.findElement(ManualBiddingConfirmationButton).click();
    }

    @Step("Validating manual bidding selected product count")
    public boolean ValidatingManualBiddingSelectedProductCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualBiddingProductCount));
        return driver.findElement(ManualBiddingProductCount).isDisplayed();
    }

    @Step("Selecting all products category in manual bidding ")
    public void SelectingAllProductsCategoryInManualBidding(int ProductNo) {
        String XpathFormatter = String.format(ManualBiddingAllProductCategorySelector, ProductNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering data into manual bidding bid cpc field")
    public void EnteringDataIntoManualBiddingBidCpcField(String Value) {
        wait.until(ExpectedConditions.elementToBeClickable(ManualBiddingBidCpcField));
        driver.findElement(ManualBiddingBidCpcField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(ManualBiddingBidCpcField).sendKeys(Value);
    }

    @Step("Deselecting all products category in manual bidding ")
    public void DeselectingAllProductsCategoryInManualBidding(int AllProductsRadioButtonNo) {
        String XpathFormatter = String.format(ManualBiddingAllProductCategorySelector, AllProductsRadioButtonNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Sorting manual product selection price in add products table ")
    public void SortingPriceInManualProductSelection() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionAddProductsPriceSorting));
        driver.findElement(ManualProductionSelectionAddProductsPriceSorting).click();
    }

    @Step("Clicking on manual production filter button")
    public void ClickingOnManualProductionFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionFilterButton));
        driver.findElement(ManualProductionSelectionFilterButton).click();

    }

    @Step("Selecting product name in manual production filter ")
    public void ClickingOnProductNameInManualProductionFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionProductNameFilterOption));
        driver.findElement(ManualProductionSelectionProductNameFilterOption).click();
    }

    @Step("Entering product name in the manual product selection filter")
    public void EnteringDataInManualProductionSelectionProductNameField(String ProductName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionProductNameField));
        driver.findElement(ManualProductionSelectionProductNameField).sendKeys(ProductName);
    }

    @Step("Selecting product category in manual production filter ")
    public void ClickingOnProductCategoryInManualProductionFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionProductCategoryFilterOption));
        driver.findElement(ManualProductionSelectionProductCategoryFilterOption).click();
    }

    @Step("Entering product category in the manual product selection filter")
    public void EnteringDataInManualProductionSelectionProductCategoryField(String ProductCategory) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionProductCategoryField));
        driver.findElement(ManualProductionSelectionProductCategoryField).sendKeys(ProductCategory);
    }


    @Step("Selecting product Brand in manual production filter ")
    public void ClickingOnProductBrandInManualProductionFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionProductBrandFilterOption));
        driver.findElement(ManualProductionSelectionProductBrandFilterOption).click();
    }

    @Step("Entering product brand in the manual product selection filter")
    public void EnteringDataInManualProductionSelectionProductBrandField(String ProductBrand) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionProductBrandField));
        driver.findElement(ManualProductionSelectionProductBrandField).sendKeys(ProductBrand);
    }


    @Step("Selecting price in manual production filter ")
    public void ClickingOnPriceInManualProductionFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionPriceFilterOption));
        driver.findElement(ManualProductionSelectionPriceFilterOption).click();
    }

    @Step("Entering price minimum value in the manual product selection filter")
    public void EnteringDataInManualProductionSelectionPriceMinField(String MinPrice) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionPriceMinField));
        driver.findElement(ManualProductionSelectionPriceMinField).sendKeys(MinPrice);
    }

    @Step("Entering price maximum value in the manual product selection filter")
    public void EnteringDataInManualProductionSelectionPriceMaxField(String MaxPrice) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionPriceMaxField));
        driver.findElement(ManualProductionSelectionPriceMaxField).sendKeys(MaxPrice);
    }


    @Step("Selecting sale price in manual production filter ")
    public void ClickingOnSalePriceInManualProductionFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionSalePriceFilterOption));
        driver.findElement(ManualProductionSelectionSalePriceFilterOption).click();
    }

    @Step("Entering sale price minimum value in the manual product selection filter")
    public void EnteringDataInManualProductionSelectionSalePriceMinField(String MinPrice) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionSalePriceMinField));
        driver.findElement(ManualProductionSelectionSalePriceMinField).sendKeys(MinPrice);
    }

    @Step("Entering Sale price maximum value in the manual product selection filter")
    public void EnteringDataInManualProductionSelectionSalePriceMaxField(String MaxPrice) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionSalePriceMaxField));
        driver.findElement(ManualProductionSelectionSalePriceMaxField).sendKeys(MaxPrice);
    }

    @Step("Clicking on manual production filter apply button")
    public void ClickingOnManualProductionFilterApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionFilterApplyButton));
        driver.findElement(ManualProductionSelectionFilterApplyButton).click();
    }

    @Step("Clicking on manual production filter clear all button")
    public void ClickingOnManualProductionFilterClearAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionFilterClearAllButton));
        driver.findElement(ManualProductionSelectionFilterClearAllButton).click();
    }

    @Step("Clicking on manual production filter clear all conformation button")
    public void ClickingOnManualProductionFilterClearAllConformationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionFilterClearAllConformationButton));
        driver.findElement(ManualProductionSelectionFilterClearAllConformationButton).click();
    }


    @Step("Clicking on manual production select all product radio button")
    public void ClickingOnAllProductsRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ManualProductionSelectionAllProductsRadioButton));
        driver.findElement(ManualProductionSelectionAllProductsRadioButton).click();
    }

    @Step("Validating bid value field with negative value")
    public boolean ValidatingBidValueFieldWithNegativeValue(String Value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualBiddingBidCpcField));
        return driver.findElement(ManualBiddingBidCpcField).getText().equalsIgnoreCase(Value);
    }

    @Step("Validating bid value field with Minimum value")
    public boolean ValidatingBidValueFieldWithMinimumValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualBiddingBibCpcMinValueText));
        return driver.findElement(ManualBiddingBibCpcMinValueText).isDisplayed();
    }

    @Step("Validating bid settings error pop up ")
    public boolean ValidatingBidSettingsErrorPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualBiddingErrorPopUp));
        return driver.findElement(ManualBiddingErrorPopUp).isDisplayed();
    }

    @Step("Clicking on keyword ideas match type copy symbol")
    public void ClickingOnKeywordIdeasMatchTypeCopySymbol() {
        wait.until(ExpectedConditions.elementToBeClickable(CopySymbolForMatchType));
        driver.findElement(CopySymbolForMatchType).click();
        driver.findElement(MatchTypeCopySymbolText).click();
    }

    @Step("Clicking on keyword ideas bid copy symbol")
    public void ClickingOnKeywordIdeasBidCopySymbol() {
        wait.until(ExpectedConditions.elementToBeClickable(CopySymbolForBid));
        driver.findElement(CopySymbolForBid).click();
        driver.findElement(BidCopySymbolText).click();
    }


    @Step("Selecting manual product option in row one condition dropdown")
    public void ClickingOnFilterGenericDropdown(int ConditionsSelector) {
        String XpathFormatter = String.format(ManualProductionSelectionFilterGenericResults, ConditionsSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Validating product category field results in manual product selection")
    public boolean ValidatingProductCategoryFieldResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionFilterGenericResultsValidation));
        return driver.findElement(ManualProductionSelectionFilterGenericResultsValidation).isDisplayed();
    }

    @Step("Clicking on manual product selection generic product category field")
    public void ClickingOnManualProductionDropdown(int dropdown) throws InterruptedException {
        Thread.sleep(1500);
        String XpathFormatter = String.format(ManualProductionSelectionCategoryFieldDropdown, dropdown);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering data in manual product selection generic product category field")
    public void EnteringDataInManualProductionGenericFieldWithDropDown(int ConditionsSelector, String Product) {
        String XpathFormatter = String.format(ManualProductionSelectionGenericFieldWithDropDown, ConditionsSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).sendKeys(Product);
    }

    @Step("Validating manual production selection generic field with dropdown results")
    public boolean ValidatingManualProductionSelectionGenericFieldWithDropDownResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionGenericFieldWithDropDownResults));
        return driver.findElement(ManualProductionSelectionGenericFieldWithDropDownResults).isDisplayed();
    }

    @Step("Clicking on manual production selection generic field with dropdown results")
    public void ClickingOnManualProductionSelectionGenericFieldWithDropDownResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionGenericFieldWithDropDownResults));
        driver.findElement(ManualProductionSelectionGenericFieldWithDropDownResults).click();
    }


    @Step("Validating keyword ideas zero bid value error message")
    public boolean KeywordIdeasZeroBidValueErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(KeywordIdeasZeroBidValueErrorMessage));
        return driver.findElement(KeywordIdeasZeroBidValueErrorMessage).isDisplayed();

    }

    @Step("Validating empty keywords pop up in keyword ideas")
    public boolean KeywordIdeasEmptyKeywordsPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(KeywordIdeasEmptyKeywordsPopUp));
        return driver.findElement(KeywordIdeasEmptyKeywordsPopUp).isDisplayed();

    }

    @Step("Validating bulk upload status")
    public boolean ValidatingBulkUploadStatus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BulkUploadStatus));
        return driver.findElement(BulkUploadStatus).isDisplayed();

    }

    @Step("Validating select individual product to include error pop up")
    public boolean SelectIndividualProductToIncludeErrorPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectIndividualProductToIncludeErrorPopUp));
        return driver.findElement(SelectIndividualProductToIncludeErrorPopUp).isDisplayed();

    }

    @Step("Validating visibility of warning icon ")
    public boolean ValidatingVisibilityOfWarningIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(WarningIcon));
        return driver.findElement(WarningIcon).isDisplayed();

    }

    @Step("Validating products combination results ")
    public boolean ValidatingProductsCombinationResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ManualProductionSelectionsProductResults));
        return driver.findElement(ManualProductionSelectionsProductResults).isDisplayed();

    }

    @Step("Clicking on manual production results frame close button")
    public void ClickingOnManualProductionSelectionResultsCloseButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectProductsResultsFrameCloseButton));
        driver.findElement(SelectProductsResultsFrameCloseButton).click();
    }

    private static String OsmosSellerUrl = "https://osmos-qa-staging-1.onlinesales.ai/";

    public void RetryOnFailOSMOSSeller(Runnable action) {
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
                TakeScreenshotOnSoftAssertion("Test Failed due to " + Message + " Attempt: " + attempts);

                if (System.getProperty("OsmosSellerUrl") != null)
                    OsmosSellerUrl = System.getProperty("OsmosSellerUrl");

                driver.navigate().to(OsmosSellerUrl);
            }
        }
        if (!success) {
            Assert.fail("Action failed after multiple attempts due to: " + Message);
        }
    }

    @Step("Clicking on pop up close button")
    public void ClickingOnPopUpCloseButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(GenericPopUpCloseButton));
        driver.findElement(GenericPopUpCloseButton).click();
    }

}