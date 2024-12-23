package PagesSeller;

import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;
    private PerformancePage performancePage;
    private AwarenessPage awarenessPage;

    public DashboardPage(WebDriver driver) {
        performancePage = new PerformancePage(driver);
        awarenessPage = new AwarenessPage(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    final By DisabledSortingDropdown = By.xpath("//div[contains(@class,'pendo_feature_campaign_sort_dropdown Select--is-disabled')]");
    final By SortingDropdown = By.xpath("//div[contains(@class,'pendo_feature_campaign_sort_dropdown')]");
    final By CreationDateStatus = By.xpath("//div[contains(@id,'option-1')]");
    final By FirstRowCampaignEditButton = By.xpath("(//td[contains(@class,'action-column campaignActions')]/descendant::button[contains(@class,'edit-campaign-btn')])[1]");
    final By FirstRowCampaignName = By.xpath("(//td[contains(@class,'pendo-track-goal-list-table-name universalText')]/descendant::span)[1]");
    final By DateButton = By.xpath("//div[@class='date-range-input']");
    final By FirstDisplayMonthYear = By.xpath("(//div[@class='react-datepicker__current-month'])[1]");
    final By SecondDisplayMonthYear = By.xpath("(//div[@class='react-datepicker__current-month'])[2]");
    final String FirstDisplayMonthDays = "(//div[@class='react-datepicker__month-container'])" +
            "[1]/descendant::div[contains(@class,'react-datepicker__day') and @aria-disabled='false' and " +
            "not(contains(@class,'day--outside-month')) and text()='%d']";
    final String SecondDisplayMonthDays = "(//div[@class='react-datepicker__month-container'])" +
            "[2]/descendant::div[contains(@class,'react-datepicker__day') and @aria-disabled='false' and" +
            " not(contains(@class,'day--outside-month')) and text()='%d']";
    final By PreviousDateButton = By.xpath("//button[@aria-label='Previous Month']");
    final By NextDateButton = By.xpath("//button[@aria-label='Next Month']");
    final By CalenderApplyButton = By.xpath("//button[contains(@class,'pendo_feature_date_comparison_apply_button')]");
    final By TodayInCalender = By.xpath("//div[contains(@class,'pendo_feature_realtime_enabled')]/descendant::div[contains(text(),'Today')]");
    final By DateCompareToggleButton = By.xpath("//span[contains(@class,'os-toggle-switch-round')]");
    final By DisabledCompareDateToggleButton = By.xpath("//label[contains(@class,'os-toggle-switch-container disabled pendo_feature_date_comparision_toggle undefined')]");
    final By TodayPresetDisplay = By.xpath("(//div[contains(@class,'chart-highchart-wrapper')]/descendant::span)[1]");
    final By ComparedDateDisplay = By.xpath("//div[contains(@class,'compare-date-div')]");
    final By SecondDateField = By.xpath("//div[contains(@class,'previous-date-range')]");
    final String SelectedTableAttributes = "(//div[contains(@class,'option-checkbox') and contains(@class,'selected') and not(contains(@class,'disabled'))])[%d]";
    final String DeselectedTableAttributes = "(//div[contains(@class,'option-checkbox') and not(contains(@class,'selected'))])[%d]";
    final By PerformanceTableHeadings = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_clientPerformance')]/descendant::th[contains(@class,'pendo_feature_column_sort_th')]");
    final By AddOrRemoveTableColumns = By.xpath("//div[contains(@class,'pendo-track-react-table-dynamic-column-click')]/descendant::button");
    final By PerformanceTableDownloadButton = By.xpath("//button[contains(@class,'download-performance-btn')]");
    final String SortingOptions = "//div[contains(@id,'option-%d')]";
    final By SelectedSortingOptionBeforeSorting = By.xpath("//div[contains(@class,'pendo_feature_campaign_sort_dropdown')]/descendant::div[contains(@class,'single-value')]");
    final By ComfortableViewButton = By.xpath("//div[contains(@class,'pendo_feature_campaign_view_option_comfortable')]");
    final By CompactViewButton = By.xpath("//div[contains(@class,'pendo_feature_campaign_view_option_compact')]");
    final By ComfortableViewFirstCampaign = By.xpath("(//div[contains(@class,'candy-title-name ellipsis-text')])[1]");
    final By FilterButton = By.xpath("//button[contains(@class,'pendo_feature_campaign_view_filter_btn')]");
    final By FilterApplyButton = By.xpath("//button[contains(@class,'pendo_feature_global_filter_apply button')]");
    final String StatusOptions = "(//div[contains(@class,'checkbox-wrapper')])[%d]";
    final String AttributeOptions = "(//nav[contains(@class,'nav-tabs')]/descendant::span[contains(@class,'title-name-container')])[%d]";
    final By KeywordsTab = By.xpath("//a[contains(@class,'pendo_feature_dashboard_client_performance_topKeywords')]");
    final By CategoriesTab = By.xpath("//a[contains(@class,'pendo_feature_dashboard_client_performance_topCategories')]");
    final By StartDateField = By.xpath("(//div[@class='date-picker-placeholder'])[1]");
    final By EndDateField = By.xpath("(//div[@class='date-picker-placeholder'])[1]");
    final By CreativeLibraryButton = By.xpath("// button[contains(@class,'pendo_feature_media_library button')]");
    final By UploadButton = By.xpath("//div[contains(@class,'pendo_feature_media_library_upload_button')]");
    final By DoneButton = By.xpath("//button[contains(@class,'pendo_feature_media_library_save_button')]");
    final By DoneButtonForCampaign = By.xpath("//button[contains(@class,'pendo_feature_goal_performance_cta_button')]");
    final By TroubleShootButton = By.xpath("(//button[contains(@class,'pendo-track-camapign-debugger-candy-troubleshoot-btn')])[1]");
    final By ConfirmationYesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By TroubleshootResultPage = By.xpath("//div[contains(@class,'troubleshoot-report')]");
    final By SearchCampaignField = By.xpath("//div[contains(@class,'pendo_feature_campaign_view_search_input')]");
    final By ClearAllButton = By.xpath("//button[contains(@class,'pendo_feature_global_filter_clear_all')]");
    final By AwarenessSummaryTableHeadings = By.xpath("//div[contains(@class,'reporting-performance')]/descendant::th[contains(@class,'right-align pendo_feature_column_sort_th')]");
    final By InventoryTab = By.xpath("//a[contains(@data-rb-event-key,'INVENTORY')]");
    final By CampaignTab = By.xpath("//a[contains(@data-rb-event-key,'GOAL')]");
    final By DownloadReportButton = By.xpath("//button[contains(@class,'pendo_feature_goal_performance_download_report_button')]");
    final By AnalyticsButton = By.xpath("(//button[contains(@class,'performance-btn')])[1]");
    final By ReviewAndLaunchButton = By.xpath("(//button[contains(@class,'draft-btn launch-campaign-btn')])[1]");
    final By ViewAllCampaignButton = By.xpath("//button[contains(@class,'pendo_feature_campaign_card_view_all_button')]");
    final By ViewAllTable = By.xpath("//div[contains(@class,'pendo_feature_campaign_view_all_drawer TABLE')]/descendant::div[contains(@class,'table-container')]");
    final String IndustryBenchmarkTemplateLearnMoreButton = "(//div[contains(@class,'card-cta-action')]/button)[%d]";
    final By TemplateDetailsPopUp = By.xpath("//div[contains(@class,'modal-header')]");
    final By GenericPopUpCloseButton = By.xpath("//div[contains(@class,'modal-header')]/button");
    final By SuggestionsButton = By.xpath("//button[contains(@class,'pending-opportunity-count-btn')]");
    final By PendingActionsWindow = By.xpath("//div[contains(@class,'mixed-suggestions-wrapper')]");
    final By CloseButton = By.xpath("//label[contains(@class,'icon-close1')]");
    final By HelpCenterButton = By.xpath("(//div[contains(@class,'dropdown-menu-right')]/descendant::a)[4]");
    final By HelpCenterWindow = By.xpath("//div[contains(@class,'help-section-iframe-wrapper')]");
    final By MenuButton = By.xpath("//div[contains(@class,'dashboard-header-sticky')]/descendant::button[contains(@class,'desktop-menu-config')]");
    final String DesiredSeller = ("(//div[contains(@id,'option-')])[%d] ");
    final By SellerSwitchField = By.xpath("//div[contains(@class,'pendo-track-client-list-dropdown')]");
    final By Footer = By.xpath("//div[contains(@class,'footer pendo_feature_dashboard_component_footer dashboard')]");
    final By RemoveCrossIcon = By.xpath("(//i[contains(@class,'remove-pill icon')])[1]");
    final By ErrorMessageForEmailAlertField = By.xpath("//div[contains(@class,'error-msg name-error-message')]");

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;

    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }


    @Step("Clicking on seller choose field")
    public void ClickOnSellerChooseField() {
        WebDriverWait ExtensiveWait =new WebDriverWait(driver,Duration.ofSeconds(50));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(SellerSwitchField));
        driver.findElement(SellerSwitchField).click();
    }
    @Step("Enter seller name")
    public void EnterDesiredTextToSellerSearchField(String Seller) {
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey+"+a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Seller);
    }
    @Step("Selecting desired Seller")
    public void SelectDesiredSeller(int seller) {
        WebDriverWait ExtensiveWait =new WebDriverWait(driver,Duration.ofSeconds(30));
        String XpathFormatter = String.format(DesiredSeller, seller);
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on creationDate status")
    public void ClickOnCreationDateStatus() {
        wait.until(visibilityOfElementLocated(CreationDateStatus));
        WebElement element = driver.findElement(CreationDateStatus);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(CreationDateStatus).click();
    }

    @Step("Clicking on dashboard calender")
    public void ClickOnDashboardCalender() {
        wait.until(ExpectedConditions.elementToBeClickable(DateButton));
        driver.findElement(DateButton).click();
    }
    @Step("Clicking on cross icon to deselect selected email Id")
    public void DeselectSelectedMailId() {
        wait.until(ExpectedConditions.elementToBeClickable(RemoveCrossIcon));
        driver.findElement(RemoveCrossIcon).click();
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

    @Epic("Clicking on the exact day")
    public void selectDay(int day, String dayPickerXpath) {
        String dayXPath = String.format(dayPickerXpath, day);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXPath)));
        driver.findElement(By.xpath(dayXPath)).click();
    }

    @Epic("Click on calender and taking date range from user")
    public void selectDateRange(LocalDate startDate, LocalDate endDate) {
        wait.until(ExpectedConditions.elementToBeClickable(DateButton));
        selectDate(startDate);
        selectDate(endDate);
    }

    @Epic("Clicking on apply button after range selection")
    public void ClickOnApplyDateRange() {
        wait.until(ExpectedConditions.elementToBeClickable(CalenderApplyButton));
        driver.findElement(CalenderApplyButton).click();
    }

    @Step("Clicking on 'Today' in calender")
    public void ClickOnTodayOnCalender() {
        wait.until(ExpectedConditions.elementToBeClickable(TodayInCalender));
        driver.findElement(TodayInCalender).click();
    }

    @Step("Clicking on date Compare toggle button")
    public void ClickOnDateCompareToggleButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DateCompareToggleButton));
        driver.findElement(DateCompareToggleButton).click();
    }

    @Step("Clicking on Second Date Field")
    public void ClickOnSecondDateField() {
        wait.until(ExpectedConditions.elementToBeClickable(SecondDateField));
        driver.findElement(SecondDateField).click();
    }

    @Step("Validating compared date display after selecting two dates and clicking on apply")
    public boolean ValidateComparedDateDisplay() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ComparedDateDisplay));
            return driver.findElement(ComparedDateDisplay).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating 'Today' preset is displayed in chart")
    public boolean ValidateTodayPresetDisplay() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TodayPresetDisplay));
            return driver.findElement(TodayPresetDisplay).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating is compare toggle button disable while selecting today preset")
    public boolean ValidateIsCompareToggleButtonDisableWhileSelectingTodayPreset() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DisabledCompareDateToggleButton));
            return driver.findElement(DisabledCompareDateToggleButton).getAttribute("class").contains("disable");
        }catch (NullPointerException e)
        {
            return false;
        }
    }


    @Step("Clicking on the 'Download Performance' button")
    public void ClickOnPerformanceTableDownloadButton() throws InterruptedException {
        wait.until(ExpectedConditions. visibilityOfAllElementsLocatedBy(awarenessPage.AwarenessDashboard));
        Thread.sleep(2000);
        WebElement element = driver.findElement(PerformanceTableDownloadButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);  // Scrolls to the element
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(PerformanceTableDownloadButton));
        driver.findElement(PerformanceTableDownloadButton).click();
    }


    @Step("Clicking on the 'Categories' tab")
    public void ClickOnCategoriesTab() {
        wait.until(ExpectedConditions.elementToBeClickable(CategoriesTab));
        driver.findElement(CategoriesTab).click();
    }


    @Step("Clicking on the 'Keywords' tab")
    public void ClickOnKeywordsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(KeywordsTab));
        driver.findElement(KeywordsTab).click();
    }

    @Step("Deselecting selected table attributes ")
    public void DeselectingSelectedTableAttributes(int OptionsSelector) {
        String XpathFormatter = String.format(SelectedTableAttributes, OptionsSelector);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathFormatter)));
        WebElement element = driver.findElement(By.xpath(XpathFormatter));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
        //        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting deselected table attributes ")
    public void SelectingDeSelectedTableAttributes(int OptionsSelector) {
        String XpathFormatter = String.format(DeselectedTableAttributes, OptionsSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        WebElement element = driver.findElement(By.xpath(XpathFormatter));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }

    @Step("Clicking on table add or remove columns")
    public void ClickOnTableAddOrRemoveColumns() {
        wait.until(ExpectedConditions.elementToBeClickable(AddOrRemoveTableColumns));
        driver.findElement(AddOrRemoveTableColumns).click();
    }

    public int TableHeadingsCount;

    @Step("Validating performance table headings count")
    public void CountingPerformanceTableHeadingsBeforeDeselectingTableAttribute() {
        wait.until(ExpectedConditions.elementToBeClickable(AddOrRemoveTableColumns));
        TableHeadingsCount = driver.findElements(PerformanceTableHeadings).size();
    }

    @Step("Validating performance table headings count")
    public boolean ValidatingPerformanceTableHeadingsAfterDeselectingTableAttribute() {
        wait.until(ExpectedConditions.elementToBeClickable(AddOrRemoveTableColumns));
        int Count = driver.findElements(PerformanceTableHeadings).size();
        return Count < TableHeadingsCount;
    }

    @Step("Validating performance table headings count")
    public boolean ValidatingPerformanceTableHeadingsAfterSelectingTableAttribute() {
        wait.until(ExpectedConditions.elementToBeClickable(AddOrRemoveTableColumns));
        int Count = driver.findElements(PerformanceTableHeadings).size();
        return Count == TableHeadingsCount;
    }


    public String StatusSelectedBeforeSorting;

    @Step("Clicking on sort by to sort the campaign table")
    public void ClickOnSortBy() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(invisibilityOfElementLocated(DisabledSortingDropdown));
        WebElement element = driver.findElement(SortingDropdown);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(SortingDropdown).click();
        StatusSelectedBeforeSorting = driver.findElement(SelectedSortingOptionBeforeSorting).getText();

    }

    @Step("Clicking on sorting option")
    public void ClickOnSortingOption(int optionNo) {
        String formattedXpath = String.format(SortingOptions, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        WebElement element = driver.findElement(By.xpath(formattedXpath));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Validate sorting of table")
    public boolean ValidateSortingOfCampaignTable() {
        try {
            String StatusSelectedAfterSorting = driver.findElement(SelectedSortingOptionBeforeSorting).getText();
            return StatusSelectedAfterSorting.equals(StatusSelectedBeforeSorting);
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }

    }

    @Step("Clicking on comfortable view button")
    public void ClickOnComfortableViewButton() {
        wait.until(visibilityOfElementLocated(ComfortableViewButton));
        driver.findElement(ComfortableViewButton).click();
    }

    @Step("Clicking on comfortable view button")
    public void ClickOnCompactView() {
        wait.until(visibilityOfElementLocated(CompactViewButton));
        driver.findElement(CompactViewButton).click();
    }

    @Step("Validate sorting of table")
    public boolean ValidateComfortableView() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ComfortableViewFirstCampaign));
            return driver.findElement(ComfortableViewFirstCampaign).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on filter button")
    public void ClickOnFilterButton() throws InterruptedException {
        Thread.sleep(4000);
        wait.until(elementToBeClickable(FilterButton));
        driver.findElement(FilterButton).click();
    }

    @Step("Clicking on filter button")
    public void ClickOnClearAllButton() throws InterruptedException {
        wait.until(elementToBeClickable(ClearAllButton));
        driver.findElement(ClearAllButton).click();
    }

    @Step("Clicking on multiple status options")
    public void SelectMultipleStatusOptions(int optionNo) {
        WebElement element = driver.findElement(FilterApplyButton);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        for (int i = 1; i <= optionNo; i++) {
            String formattedXpath = String.format(StatusOptions, i);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
            driver.findElement(By.xpath(formattedXpath)).click();
        }
    }

    @Step("Clicking on desired status option")
    public void SelectDesiredStatusOption(int optionNo) {
        WebElement element = driver.findElement(FilterApplyButton);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        String formattedXpath = String.format(StatusOptions, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();

    }

    @Step("Clicking on filter apply button")
    public void ClickOnFilterApplyButton() throws InterruptedException {
        wait.until(elementToBeClickable(FilterApplyButton));
        driver.findElement(FilterApplyButton).click();
    }

    @Step("Selecting desired filter attribute")
    public void SelectDesiredFilterAttribute(int optionNo) {
        String formattedXpath = String.format(AttributeOptions, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
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

    @Step("Clicking on the Creative Library button")
    public void ClickOnCreativeLibraryButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeLibraryButton));
        driver.findElement(CreativeLibraryButton).click();
    }

    @Step("Verifying visibility of the upload button in Creative Library")
    public boolean ValidateVisibilityOfUploadButton() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(UploadButton));
            return driver.findElement(UploadButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking done button")
    public void ClickDoneButton() {
        wait.until(elementToBeClickable(DoneButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((DoneButton)));
    }

    @Step("Clicking campaign done button")
    public void ClickCampaignDoneButton() {
        wait.until(elementToBeClickable(DoneButtonForCampaign));
        driver.findElement(DoneButtonForCampaign).click();
    }

    @Step("Clicking on troubleshoot button")
    public void ClickOnTroubleshootButton() {
        wait.until(elementToBeClickable(TroubleShootButton));
        driver.findElement(TroubleShootButton).click();
    }

    @Step("Clicking on troubleshoot button")
    public void ClickOnConfirmationButton() {
        wait.until(elementToBeClickable(ConfirmationYesButton));
        driver.findElement(ConfirmationYesButton).click();
    }

    @Step("Verifying visibility of the upload button in Creative Library")
    public boolean ValidateTroubleshootReport() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(TroubleshootResultPage));
            return driver.findElement(TroubleshootResultPage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on troubleshoot button")
    public void EnterTextInSearchCampaignField(String text) throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        ExtensiveWait.until(elementToBeClickable(SearchCampaignField));
        WebElement element = driver.findElement(SearchCampaignField);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(SearchCampaignField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey+ "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(text);
    }

    @Step("Verifying Campaign search result")
    public boolean ValidateCampaignSearchResult() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(FirstRowCampaignName));
            return driver.findElement(FirstRowCampaignName).getText().contains("Test");
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Edit button")
    public void ClickOnCampaignEditButton() {
        wait.until(elementToBeClickable(FirstRowCampaignEditButton));
        driver.findElement(FirstRowCampaignEditButton).click();
    }
    @Step("Clicking on Review and launch button")
    public void ClickOnReviewAndLaunchButton() {
        wait.until(elementToBeClickable(ReviewAndLaunchButton));
        driver.findElement(ReviewAndLaunchButton).click();
    }

    @Step("Verifying visibility of edit page")
    public boolean ValidateEditPageVisibility() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(performancePage.CampaignNameRenameButton));
            return driver.findElement(performancePage.CampaignNameRenameButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Verifying visibility of view all table")
    public boolean ValidateVisibilityOfViewAllTable() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ViewAllTable));
            return driver.findElement(ViewAllTable).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Analytics button")
    public void ClickOnAnalyticsButton() {
        wait.until(elementToBeClickable(AnalyticsButton));
        driver.findElement(AnalyticsButton).click();
    }

    @Step("Clicking on download report button")
    public void ClickOnDownloadReportButton() {
        wait.until(elementToBeClickable(DownloadReportButton));
        driver.findElement(DownloadReportButton).click();
    }

    @Step("Clicking on the inventory tab")
    public void ClickOnInventoryTab() throws InterruptedException {
        Thread.sleep(2500);
        WebDriverWait ExtensiveWait =new WebDriverWait(driver,Duration.ofSeconds(90));
        ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(FirstRowCampaignName));
        WebElement element =driver.findElement(InventoryTab);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(InventoryTab));
        driver.findElement(InventoryTab).click();
    }

    @Step("Clicking on the campaign tab")
    public void ClickOnCampaignTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        wait.until(ExpectedConditions.elementToBeClickable(CampaignTab));
        driver.findElement(CampaignTab).click();
    }

    public int AwarenessTableHeadingsCount;

    @Step("Validating awareness performance table headings count")
    public void CountingAwarenessTableHeadingsBeforeDeselectingTableAttribute() {
        wait.until(ExpectedConditions.elementToBeClickable(AwarenessSummaryTableHeadings));
        AwarenessTableHeadingsCount = driver.findElements(AwarenessSummaryTableHeadings).size();
    }

    @Step("Validating awareness table headings count")
    public boolean ValidatingAwarenessTableHeadingsAfterDeselectingTableAttribute() {
        wait.until(ExpectedConditions.elementToBeClickable(AddOrRemoveTableColumns));
        int Count = driver.findElements(AwarenessSummaryTableHeadings).size();
        return Count < AwarenessTableHeadingsCount;
    }


    @Step("Validating awareness table headings count")
    public boolean ValidatingAwarenessTableHeadingsAfterSelectingTableAttribute() {
        wait.until(ExpectedConditions.elementToBeClickable(AddOrRemoveTableColumns));
        int Count = driver.findElements(AwarenessSummaryTableHeadings).size();
        return Count == AwarenessTableHeadingsCount;
    }
    @Step("Clicking on View All Campaign button")
    public void ClickOnViewAllCampaignButton() {
        WebDriverWait ExtensiveWait =new WebDriverWait(driver,Duration.ofSeconds(60));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(ViewAllCampaignButton));
        WebElement element = driver.findElement(ViewAllCampaignButton);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(ViewAllCampaignButton).click();
    }
    @Step("Clicking on the 'Industry Benchmark Template Learn More' button for index {0}")
    public void ClickOnIndustryBenchmarkTemplateLearnMoreButton(int index) throws InterruptedException {
        Thread.sleep(1500);
        String formattedXpath = String.format(IndustryBenchmarkTemplateLearnMoreButton, index);
        WebElement element = driver.findElement(By.xpath(formattedXpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }
    @Step("Validating if the 'Template Details' pop-up is displayed")
    public boolean IsTemplateDetailsPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TemplateDetailsPopUp));
            return driver.findElement(TemplateDetailsPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on pop up close button")
    public void ClickingOnPopUpCloseButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(6));
        ExtensiveWait.until(elementToBeClickable(GenericPopUpCloseButton));
        driver.findElement(GenericPopUpCloseButton).click();
    }


    @Step("Clicking on the 'Suggestions' button")
    public void ClickOnSuggestionsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SuggestionsButton));
        driver.findElement(SuggestionsButton).click();
    }

    @Step("Validating if the pending actions window is displayed")
    public boolean IsPendingActionsWindowDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PendingActionsWindow));
            return driver.findElement(PendingActionsWindow).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validating if the error message foe empty email id is displayed")
    public boolean ValidateErrorMessageForEmptyEmailField() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageForEmailAlertField));
            return driver.findElement(ErrorMessageForEmailAlertField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on the close button")
    public void ClickCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CloseButton));
        driver.findElement(CloseButton).click();
    }

    @Step("Clicking on the menu button")
    public void ClickMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuButton));
        driver.findElement(MenuButton).click();
    }


    @Step("Clicking on the Help Center button")
    public void ClickHelpCenterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(HelpCenterButton));
        driver.findElement(HelpCenterButton).click();
    }
    @Step("Validating if the Help Center window is displayed")
    public boolean IsHelpCenterWindowDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(HelpCenterWindow));
            return driver.findElement(HelpCenterWindow).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


}


