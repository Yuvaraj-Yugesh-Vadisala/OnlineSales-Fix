package PagesPulse.OSMOS;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AnalyticsPage {
    WebDriver driver;
    WebDriverWait wait;

    public AnalyticsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By WhiteLoader = By.xpath("//div[contains(@class,'loader-wrapper white-loader')]");
    final By AdvertiserInsightsButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-program-insights')]");
    final String FunnelMetricDropDown = "(//div[contains(@class,'pendo_feature_funnel_metric_dropdown')])[%d]";
    final By AdvertiserInsightsMetricSearchField = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component')]/descendant::div[contains(@class,'Select__input-container')]/input");
    final String GenericOptionsSelectorXpath = "(//div[contains(@id,'-option-')])[%d]";
    final By BudgetTableAddOrRemoveColumnButton = By.xpath("(//div[contains(@class,'pendo_feature_chart_metric_selection_dropdown')])[5]");
    final String SelectedTableAttributes = "(//div[contains(@class,'option-checkbox') and contains(@class,'selected') and not(contains(@class,'disabled'))])[%d]";
    final String AdvertiseSnapshotTableValue = "(//div[contains(@class,'pendo_feature_table_click_cell')])[%d]";
    final By AdvertiseSnapshotTableValueWindow = By.xpath("//div[contains(@class,'pure-drawer')]");
    final By WindowCloseButton = By.xpath("//label[contains(@class,'icon-close1')]");
    final By MoversAndShakersAddFilterButton = By.xpath("(//button[contains(@class,'pendo_feature_filter_pill_add_button button-default-outline')])[2]");
    final By AddFilterTypeField = By.xpath("//div[contains(@class,'form-component-filters-0-key')]/div[contains(@class,'universal-dropdown-container')]");
    final By AddFilterConditionField = By.xpath("//div[contains(@class,'common-form-component-filters-0-operator')]/div[contains(@class,'universal-dropdown-container')]");
    final By AddFilterConditionSearchField = By.xpath("//div[contains(@class,'pendo-track-filter-condition-dropdown')]/descendant::input");
    final By AddFilterInputField = By.xpath("//div[contains(@class,'pendo-track-filter-fincane-operator-input')]/descendant::input");
    final By AddFilterApplyButton = By.xpath("//button[contains(@class,'pendo_feature_pill_filter_submit_button')]");
    final By FilterResults = By.xpath("(//div[contains(@class,'MOVERS_AND_SHAKERS dashboard')]/descendant::tr/td)[1]");
    final By TableExpandIcon = By.xpath("(//div[contains(@class,'pendo-feature-react-table-expand-collapse-click')]/span)[1]");
    final By TableCollapseIcon = By.xpath("(//div[contains(@class,'pendo-feature-react-table-expand-collapse-click')]/span)[1]");
    final By PerformanceReportMetricField = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_ANALYTICS_PROGRAM_INSIGHTS_AD')]/descendant::div[contains(@class,'pendo_feature_chart_metric_selection_dropdown')]");
    final By PerformanceReportMetricSearchField = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_ANALYTICS_PROGRAM_INSIGHTS_AD')]/descendant::div[contains(@class,'Select__input-container')]/input");
    final By ChannelPerformanceTableValues = By.xpath("(//div[contains(@class,'ANALYTICS_PROGRAM_CHANNEL_PERFORMANCE_')]/descendant::div[contains(@class,'d-inline-flex')])[1]");
    final By ChannelPerformanceTableValueWindow = By.xpath("//div[contains(@class,'pure-drawer')]");
    final String DeselectedTableAttributes = "(//div[contains(@class,'option-checkbox') and not(contains(@class,'selected'))])[%d]";


    final By AnalyticsTab = By.xpath("//a[contains(@class,'pendo-tracking-navbar-analytics')]");
    final By ProductAdsInsightsDemandAndSupply = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-spa-demand_and_supply')]");
    final By ListViewButton = By.xpath("//div[contains(@class,'pendo_feature_toggle_report_view_button')]/descendant::span[contains(@class,'table-view')]");
    final By ActionButton = By.xpath("(//div[contains(@class,'pill-list')]/descendant::label)[1]");
    final By HelpPage = By.xpath("//div[contains(@class,'pure-drawer')]/descendant::div[contains(@class,'help-section-iframe-body-wrapper')]");
    final By Level1PageCloseCross = By.xpath("//label[contains(@class,'pure-toggle-label icon icon-close1')]");
    final By DayView = By.xpath("(//div[contains(@class,'pendo_feature_dashboard_component_ANALYTICS_SPA_TOD_DOW_CHART_LEFT')]/descendant::label[contains(@for,'ANALYTICS_SPA_TOD_DOW_CHART_WEEK_DAY')])[2]");
    final By HourView = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_ANALYTICS_SPA_TOD_DOW_CHART_LEFT')]/descendant::label[contains(@for,'ANALYTICS_SPA_TOD_DOW_CHART_HOUR')]");
    final By SeasonalityDaysChart = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_ANALYTICS_SPA_TOD_DOW_CHART_LEFT')]/descendant::div[contains(@class,'line-chart-container-wrapper')]");
    final By SeasonalityHourChart = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_ANALYTICS_SPA_TOD_DOW_CHART_LEFT')]/descendant::div[contains(@class,'line-chart-container-wrapper')]");
    final By AttributeDropdown = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_ANALYTICS_SPA_TOD_DOW_CHART_LEFT')]/descendant::div[contains(@class,'pendo_feature_chart_metric_selection_dropdown')]");
    final By AdvertiserOverAllGMV = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_SPA_DEMAND_AND_SUPPLY_ADVERTISER_OVERALL_GMV')]");
    final By GMVCategoryDropdown = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_SPA_DEMAND_AND_SUPPLY_ADVERTISER_OVERALL_GMV')]/descendant::div[contains(@class,'universal-dd-wrapper')]");
    final By SelectAllCheckBox = By.xpath("(//div[contains(@class,'Select__option')])[1]");
    final String CategoryOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final By CategorySearchField = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_SPA_DEMAND_AND_SUPPLY_ADVERTISER_OVERALL_GM')]/descendant::div[contains(@class,'Select__input-container')]");
    final String AttributeOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final By LoaderBars = By.xpath("//div[contains(@class,'loader-bar stacked')]");
    final By AdServerAnalytics = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-sda-ad_server_analytics')]");
    final By ProductAdServerAnalytics = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-spa-ad_server_analytics')]");

    final By MetricDropdown = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_SDA_AD_SERVER_ANALYTICS_PAGE_LEVEL_PERFORMANCE_REPORT')]/descendant::div[contains(@class,'pendo_feature_chart_metric_selection_dropdown')]");
    final By MetricSearchField = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_SDA_AD_SERVER_ANALYTICS_PAGE_LEVEL_PERFORMANCE_REPORT')]/descendant::div[contains(@class,'Select__input-container')]");
    final String MetricOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final By AnalyticsButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-analytics')]");
    final By PerformanceReportAddFilterButton = By.xpath("(//button[contains(@class,'pendo_feature_filter_pill_add_button button-default-outline')])[4]");
    final By DisplayAdDemandAndSupplyDemandAndSupplyGapAnalytics = By.xpath("//button[contains(@class,'pendo-track-SDA_DEMAND_AND_SUPPLY_INVENTORY_QUADRANT_TABLE-download-report-click')]");
    final By DisplayAdDemandAndSupplyBudgetUtilizationTrend = By.xpath("//button[contains(@class,'pendo-track-SDA_DEMAND_AND_SUPPLY_OVERALL_BU-download-report-click')]");
    final By DisplayAdDemandAndSupplySeasonality = By.xpath("//button[contains(@class,'pendo-track-ANALYTICS_SDA_TOD_DOW_CHART-download-report-click')]");
    final By DisplayAdDemandAndSupply30dayImpressionProjections = By.xpath("//button[contains(@class,'pendo-track-SDA_DEMAND_AND_SUPPLY_DISPLAY_ESTIMATOR_REPORT-download-report-click')]");
    final By DisplayAdDemandAndSupplySupplyAnalyticsDownloadButton = By.xpath("//button[contains(@class,'pendo-track-SDA_DEMAND_AND_SUPPLY_INVENTORY_REQUEST_FILTERING_TABLE-download-report-click')]");
    final By DisplayAdDemandAndSupplySupplyAnalyticsTable = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_SDA_DEMAND_AND_SUPPLY_INVENTORY_REQUEST_FILTERING_TABLE dashboard')]/descendant::div[contains(@class,'table-body-parent-section')]");
    final By DownloadButton = By.xpath("//button[contains(@class,'pendo-track-bulk-download-button')]");
    final By DisplayAdDemandAndSupply = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-sda-demand_and_supply')]");
    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");
    final By DisabledDownloadButton = By.xpath("//button[contains(@class,'pendo-track-bulk-download-button') and contains(@class,'disabled')]");
    final By TableView = By.xpath("//label[contains(@for,'SPA_AD_SERVER_ANALYTICS_DAILY_PAGE_PERFORMANCE_REPORT_TABLE-')]"); final By ProductDemandAndSupplyGapAnalytics = By.xpath("//button[contains(@class,'pendo-track-SPA_DEMAND_AND_SUPPLY_CATEGORY_QUADRANT_TABLE-download-report-click')]");
    final By ProductDemandAndSupplyBudgetUtilizationTrend = By.xpath("//button[contains(@class,'pendo-track-SPA_DEMAND_AND_SUPPLY_OVERALL_BU-download-report-click')]");
    final By ProductDemandAndSupplySeasonality = By.xpath("//button[contains(@class,'pendo-track-ANALYTICS_SPA_TOD_DOW_CHART_WEEK_DAY_HOUR-download-report-click')]");
    final By ProductDemandAndSupplyAdvertiserOverallGMV = By.xpath("//button[contains(@class,'pendo-track-pulse-kam-merchant-revenue-download-report-click')]");
    final By ProductDemandAndSupplySearchDemandPlanner = By.xpath("//button[contains(@class,'pendo-track-SPA_DEMAND_AND_SUPPLY_SEARCH_DEMAND_PLANNER-download-report-click')]");
    final By ProductDemandAndSupplyCategoryPerformanceReport = By.xpath("//button[contains(@class,'pendo-track-SPA_DEMAND_AND_SUPPLY_SKU_CATEGORY_ANALYSIS_REPORT-download-report-click')]");
    final By DemandAndSupplyGapTableView = By.xpath("//label[contains(@for,'SPA_DEMAND_AND_SUPPLY_CATEGORY_QUADRANT_TABLE-')]");
    final By DisplayAdServerAnalyticsPageLevelPerformanceReport = By.xpath("//button[contains(@class,'pendo-track-SDA_AD_SERVER_ANALYTICS_PAGE_LEVEL_PERFORMANCE_REPORT_TABLE-download-report-click')]");
    final By DisplayAdServerAnalyticsPageLevelContribution = By.xpath("//button[contains(@class,'pendo-track-SDA_AD_SERVER_ANALYTICS_PAGE_LEVEL_CONTRIBUTION-download-report-click')]");
    final By DisplayAdServerAnalyticsAdInventoryPerformanceReport = By.xpath("//button[contains(@class,'pendo-track-SDA_AD_SERVER_ANALYTICS_INVENTORY_LEVEL_PERFORMANCE_REPORT_TABLE-download-report-click')]");
    final By DisplayAdServerAnalyticsPageLevelPerformanceTableView = By.xpath("//label[contains(@for,'SDA_AD_SERVER_ANALYTICS_PAGE_LEVEL_PERFORMANCE_REPORT_TABLE-')]");
    final By DisplayAdDemandAndSupplyGapAnalyticsTableView = By.xpath("//label[contains(@for,'SDA_DEMAND_AND_SUPPLY_INVENTORY_QUADRANT_TABLE-')]");
    final By HomeMetricsComparisonReport = By.xpath("//button[contains(@class,'pendo-track-HOME_PERFORMANCE_TRENDS_LEFT-download-report-click')]");
    final By AnalyticsProgramInsightsDownload = By.xpath("//button[contains(@class,'pendo-track-ANALYTICS_PROGRAM_INSIGHTS_PERFORMANCE_TRENDS_LEFT-download-report')]");
    final By AnalyticsProgramInsightsBudgetUtilizationDownload = By.xpath("//button[contains(@class,'pendo-track-ANALYTICS_PROGRAM_INSIGHTS_OVERALL')]");
    final By AnalyticsProgramInsightsAdvertiserSnapshotDownload = By.xpath("//button[contains(@class,'pendo-track-ANALYTICS_PROGRAM_INSIGHTS_ADVERTISER_SNAPSHOT-download-report-click')]");
    final By AnalyticsProgramInsightsMoversAndShakersDownload = By.xpath("//button[contains(@class,'pendo-track-MOVERS_AND_SHAKERS-download-report-click')]");
    final By AnalyticsProgramInsightsAdFormatPerformanceDownload = By.xpath("//button[contains(@class,'pendo-track-ANALYTICS_PROGRAM_INSIGHTS_AD_FORMAT_REPORT_TABLE-download-report-click')]");
    final By AnalyticsProgramInsightsChannelPerformanceDownload = By.xpath("//button[contains(@class,' pendo-track-ANALYTICS_PROGRAM_CHANNEL_PERFORMANCE_REPORT-download-report-click')]");
    final By AnalyticsInsightsCampaignPerformanceReportDownload = By.xpath("//button[contains(@class,'pendo-track-ANALYTICS_PROGRAM_INSIGHTS_CAMPAIGN_PERFORMANCE_REPORT-download-report-click')]");
    final By AnalyticsInsightsAdvertiserDimensionReportDownload = By.xpath("//button[contains(@class,'pendo-track-ANALYTICS_PROGRAM_INSIGHTS_MERCHANT_DIMENSION_REPORT-download-report-click')]");
    final By ProductAdServerAnalyticsPageLevelContribution = By.xpath("//button[contains(@class,'pendo-track-SPA_AD_SERVER_ANALYTICS_PAGE_LEVEL_CONTRIBUTION-download-report-click')]");
    final By ProductAdServerAnalyticsDailyPagePerformanceReport = By.xpath("//button[contains(@class,'pendo-track-SPA_AD_SERVER_ANALYTICS_DAILY_PAGE_PERFORMANCE_REPORT_TABLE-download-report-click')]");
    final By ProductAdServerAnalyticsSKUByHour = By.xpath("//button[contains(@class,'pendo-track-SPA_AD_SERVER_ANALYTICS_AVAILABLE_ADVERTISING_SKU_BY_HOUR-download-report-click')]");
    final By ProductAdServerAnalyticsDevicePerformanceReport = By.xpath("//button[contains(@class,'pendo-track-SPA_AD_SERVER_ANALYTICS_DEVICE_PERFORMANCE_REPORT_TABLE-download-report-click')]");

    @Step("Clicking on Analytics Tab")
    public void ClickAnalyticsTab() {
        wait.until(elementToBeClickable(AnalyticsTab));
        driver.findElement(AnalyticsTab).click();
    }

    @Step("Clicking on Ad Server Analytics")
    public void ClickAdServerAnalytics() {
        wait.until(elementToBeClickable(AdServerAnalytics));
        driver.findElement(AdServerAnalytics).click();
    }

    @Step("Clicking on Product Ad Server Analytics")
    public void ClickProductAdServerAnalytics() {
        wait.until(elementToBeClickable(ProductAdServerAnalytics));
        driver.findElement(ProductAdServerAnalytics).click();
    }

    @Step("Clicking on Demand and supply")
    public void ClickOnDemandAndSupply() {
        wait.until(elementToBeClickable(ProductAdsInsightsDemandAndSupply));
        driver.findElement(ProductAdsInsightsDemandAndSupply).click();
    }

    @Step("Clicking on Demand and supply")
    public void ClickOnDemandAndS() {
        wait.until(elementToBeClickable(ProductAdsInsightsDemandAndSupply));
        driver.findElement(ProductAdsInsightsDemandAndSupply).click();
    }

    @Step("Clicking on List View Button")
    public void ClickOnListViewButton() {
        wait.until(elementToBeClickable(ListViewButton));
        driver.findElement(ListViewButton).click();
    }

    @Step("Clicking on Table action Button")
    public void ClickOnTableActionButton() {
        wait.until(elementToBeClickable(ActionButton));
        driver.findElement(ActionButton).click();
    }

    @Step("Validate visibility of Help Page")
    public boolean ValidateVisibilityOfHelpPage() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(HelpPage));
            return driver.findElement(HelpPage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on cross button ")
    public void ClickCrossButtonToClosePageLevel1() {
        wait.until(elementToBeClickable(Level1PageCloseCross));
        driver.findElement(Level1PageCloseCross).click();
    }

    @Step("Clicking on Day view")
    public void ClickOnDaysView() {
        wait.until(elementToBeClickable(DayView));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(DayView)).perform();
        driver.findElement(DayView).click();
    }

    @Step("Clicking on Hour view")
    public void ClickOnHourView() {
        wait.until(elementToBeClickable(HourView));
        driver.findElement(HourView).click();
    }

    @Step("Visibility of Days Chart")
    public boolean ValidateVisibilityOfDaysChart() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(20));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(SeasonalityDaysChart));
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(SeasonalityDaysChart)).perform();
            return driver.findElement(SeasonalityDaysChart).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Visibility of Hour Chart")
    public boolean ValidateVisibilityOfHourChart() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(20));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(SeasonalityHourChart));
            return driver.findElement(SeasonalityHourChart).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Attribute dropdown")
    public void ClickOnAttributeDropdown() {
        wait.until(elementToBeClickable(AttributeDropdown));
        driver.findElement(AttributeDropdown).click();
    }

    @Step("Selecting desired Attribute")
    public void SelectDesiredAttribute(int Option) {
        String XpathFormatter = String.format(AttributeOptions, Option);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on GMV category dropdown")
    public void ClickOnGMVCategoryDropdown() {
        wait.until(elementToBeClickable(AdvertiserOverAllGMV));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(AdvertiserOverAllGMV)).perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(LoaderBars));
        driver.findElement(GMVCategoryDropdown).click();
    }

    @Step("Clicking on Attribute dropdown")
    public void ClickOnSelectAllCheckBox() {
        wait.until(elementToBeClickable(SelectAllCheckBox));
        driver.findElement(SelectAllCheckBox).click();
    }

    @Step("Selecting desired categories")
    public void SelectDesiredCategory(int Option) {
        String XpathFormatter = String.format(CategoryOptions, Option);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Enter Category name")
    public void EnterCategoryName(String category) {
        wait.until(elementToBeClickable(CategorySearchField));
        driver.findElement(CategorySearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(category);
    }

    @Step("Clicking on metric dropdown")
    public void ClickOnTheMetricDropdown() {
        wait.until(elementToBeClickable(MetricDropdown));
        driver.findElement(MetricDropdown).click();
    }

    @Step("Selecting desired metric")
    public void SelectDesiredMetric(int option) {
        String XpathFormatter = String.format(MetricOptions, option);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Enter metric name")
    public void EnterMetricName(String MetricName) {
        wait.until(elementToBeClickable(MetricSearchField));
        driver.findElement(MetricSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(MetricName);
    }


    @Step("Click on advertiser insights button")
    public void ClickOnAdvertiserInsightsButton() {
        wait.until(elementToBeClickable(AdvertiserInsightsButton));
        driver.findElement(AdvertiserInsightsButton).click();
    }

    @Step("Click on funnel metric dropdown")
    public void ClickOnFunnelMetricDropDown(int index) {
        By formattedXpath = By.xpath(String.format(FunnelMetricDropDown, index));
        wait.until(elementToBeClickable(formattedXpath));
        driver.findElement(formattedXpath).click();
    }

    @Step("Enter data in metric search field")
    public void EnterDataInMetricSearchField(String text) {
        wait.until(elementToBeClickable(AdvertiserInsightsMetricSearchField));
        driver.findElement(AdvertiserInsightsMetricSearchField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AdvertiserInsightsMetricSearchField).sendKeys(text);
    }

    @Step("Click on generic options selector")
    public void ClickOnGenericOptionsSelector(int index) {
        By formattedXpath = By.xpath(String.format(GenericOptionsSelectorXpath, index));
        wait.until(elementToBeClickable(formattedXpath));
        driver.findElement(formattedXpath).click();
    }

    @Step("Click on budget table add or remove column button")
    public void ClickOnBudgetTableAddOrRemoveColumnButton() {
        wait.until(elementToBeClickable(BudgetTableAddOrRemoveColumnButton));
        driver.findElement(BudgetTableAddOrRemoveColumnButton).click();
    }

    @Step("Click on advertise snapshot table value")
    public void ClickOnAdvertiseSnapshotTableValue(int index) {
        WebElement element = driver.findElement(MoversAndShakersAddFilterButton);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        By formattedXpath = By.xpath(String.format(AdvertiseSnapshotTableValue, index));
        wait.until(elementToBeClickable(formattedXpath));
        driver.findElement(formattedXpath).click();
    }

    @Step("Click on advertise snapshot table value window")
    public void clickOnAdvertiseSnapshotTableValueWindow() {
        wait.until(elementToBeClickable(AdvertiseSnapshotTableValueWindow));
        driver.findElement(AdvertiseSnapshotTableValueWindow).click();
    }

    @Step("Click on window close button")
    public void clickOnWindowCloseButton() {
        wait.until(elementToBeClickable(WindowCloseButton));
        driver.findElement(WindowCloseButton).click();
    }

    @Step("Click on movers and shakers add filter button")
    public void clickOnMoversAndShakersAddFilterButton() {
        wait.until(elementToBeClickable(MoversAndShakersAddFilterButton));
        driver.findElement(MoversAndShakersAddFilterButton).click();
    }

    @Step("Click on add filter type field")
    public void clickOnAddFilterTypeField() {
        wait.until(elementToBeClickable(AddFilterTypeField));
        driver.findElement(AddFilterTypeField).click();
    }

    @Step("Click on add filter condition field")
    public void clickOnAddFilterConditionField() {
        wait.until(elementToBeClickable(AddFilterConditionField));
        driver.findElement(AddFilterConditionField).click();
    }

    @Step("Enter data in add filter condition search field")
    public void EnterDataInAddFilterConditionSearchField(String text) {
        wait.until(elementToBeClickable(AddFilterConditionSearchField));
        driver.findElement(AddFilterConditionSearchField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AddFilterConditionSearchField).sendKeys(text);
    }

    @Step("Enter data in add filter input field")
    public void EnterDataInAddFilterInputField(String text) {
        wait.until(elementToBeClickable(AddFilterInputField));
        driver.findElement(AddFilterInputField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AddFilterInputField).sendKeys(text);
    }

    @Step("Click on add filter apply button")
    public void ClickOnAddFilterApplyButton() {
        wait.until(elementToBeClickable(AddFilterApplyButton));
        driver.findElement(AddFilterApplyButton).click();
    }

    @Step("Check if filter results are displayed")
    public boolean IsFilterResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FilterResults));
            return driver.findElement(FilterResults).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Click on table expand icon")
    public void ClickOnTableExpandIcon() {
        wait.until(elementToBeClickable(TableExpandIcon));
        driver.findElement(TableExpandIcon).click();
    }

    @Step("Click on table collapse icon")
    public void ClickOnTableCollapseIcon() {
        wait.until(elementToBeClickable(TableCollapseIcon));
        driver.findElement(TableCollapseIcon).click();
    }

    @Step("Click on performance report metric field")
    public void ClickOnPerformanceReportMetricField() {
        wait.until(elementToBeClickable(PerformanceReportMetricField));
        driver.findElement(PerformanceReportMetricField).click();
    }

    @Step("Enter data in performance report metric search field")
    public void EnterDataInPerformanceReportMetricSearchField(String text) {
        wait.until(elementToBeClickable(PerformanceReportMetricSearchField));
        driver.findElement(PerformanceReportMetricSearchField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(PerformanceReportMetricSearchField).sendKeys(text);
    }

    @Step("Click on channel performance table values")
    public void ClickOnChannelPerformanceTableValues() {
        WebElement element = driver.findElement(PerformanceReportAddFilterButton);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(elementToBeClickable(ChannelPerformanceTableValues));
        driver.findElement(ChannelPerformanceTableValues).click();
    }

    @Step("Check if channel performance table value window is displayed")
    public boolean IsChannelPerformanceTableValueWindowDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ChannelPerformanceTableValueWindow));
            return driver.findElement(ChannelPerformanceTableValueWindow).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Click on analytics button")
    public void ClickOnAnalyticsButton() {
        wait.until(elementToBeClickable(AnalyticsButton));
        driver.findElement(AnalyticsButton).click();
    }

    @Step("Selecting deselected table attributes ")
    public void SelectingDeSelectedTableAttributes(int OptionsSelector) {
        String XpathFormatter = String.format(DeselectedTableAttributes, OptionsSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        WebElement element = driver.findElement(By.xpath(XpathFormatter));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @Step("Deselecting selected table attributes ")
    public void DeselectingSelectedTableAttributes(int OptionsSelector) {
        String XpathFormatter = String.format(SelectedTableAttributes, OptionsSelector);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathFormatter)));
        WebElement element = driver.findElement(By.xpath(XpathFormatter));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    //    ----------------------------------------------------------------------------------------------------------------


    @Step("Click on metrics comparison download button")
    public void ClickOnMetricsComparisonDownload() {
        wait.until(ExpectedConditions.elementToBeClickable(AnalyticsProgramInsightsDownload));
        driver.findElement(AnalyticsProgramInsightsDownload).click();
    }




    @Step("Click on budget utilization download button")
    public void ClickOnBudgetUtilizationDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AnalyticsProgramInsightsBudgetUtilizationDownload));
        WebElement element = driver.findElement(AnalyticsProgramInsightsBudgetUtilizationDownload);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(AnalyticsProgramInsightsBudgetUtilizationDownload));
        driver.findElement(AnalyticsProgramInsightsBudgetUtilizationDownload).click();
    }


    @Step("Click on advertiser snapshot download button")
    public void ClickOnAdvertiserSnapshotDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AnalyticsProgramInsightsAdvertiserSnapshotDownload));
        WebElement element = driver.findElement(AnalyticsProgramInsightsAdvertiserSnapshotDownload);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(AnalyticsProgramInsightsAdvertiserSnapshotDownload));
        driver.findElement(AnalyticsProgramInsightsAdvertiserSnapshotDownload).click();
    }



    @Step("Click on movers and shakers download button")
    public void ClickOnMoversAndShakersDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AnalyticsProgramInsightsMoversAndShakersDownload));
        WebElement element = driver.findElement(AnalyticsProgramInsightsMoversAndShakersDownload);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(AnalyticsProgramInsightsMoversAndShakersDownload));
        driver.findElement(AnalyticsProgramInsightsMoversAndShakersDownload).click();
    }



    @Step("Click on ad format performance download button")
    public void ClickOnAdFormatPerformanceDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AnalyticsProgramInsightsAdFormatPerformanceDownload));
        WebElement element = driver.findElement(AnalyticsProgramInsightsAdFormatPerformanceDownload);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(AnalyticsProgramInsightsAdFormatPerformanceDownload));
        driver.findElement(AnalyticsProgramInsightsAdFormatPerformanceDownload).click();
    }




    @Step("Click on channel performance download button")
    public void ClickOnChannelPerformanceReportDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AnalyticsProgramInsightsChannelPerformanceDownload));
        WebElement element = driver.findElement(AnalyticsProgramInsightsChannelPerformanceDownload);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(AnalyticsProgramInsightsChannelPerformanceDownload));
        driver.findElement(AnalyticsProgramInsightsChannelPerformanceDownload).click();
    }




    @Step("Click on campaign performance report download button")
    public void ClickOnCampaignPerformanceReportDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AnalyticsInsightsCampaignPerformanceReportDownload));
        WebElement element = driver.findElement(AnalyticsInsightsCampaignPerformanceReportDownload);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(AnalyticsInsightsCampaignPerformanceReportDownload));
        driver.findElement(AnalyticsInsightsCampaignPerformanceReportDownload).click();
    }



    @Step("Click on advertiser dimension report download button")
    public void ClickOnAdvertiserDimensionReportDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(AnalyticsInsightsAdvertiserDimensionReportDownload));
        WebElement element = driver.findElement(AnalyticsInsightsAdvertiserDimensionReportDownload);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(AnalyticsInsightsAdvertiserDimensionReportDownload));
        driver.findElement(AnalyticsInsightsAdvertiserDimensionReportDownload).click();
    }




    @Step("Click on Page Level Contribution download button")
    public void ClickOnProductAdServerAnalyticsPageLevelContributionDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductAdServerAnalyticsPageLevelContribution));
        WebElement element = driver.findElement(ProductAdServerAnalyticsPageLevelContribution);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(ProductAdServerAnalyticsPageLevelContribution));
        driver.findElement(ProductAdServerAnalyticsPageLevelContribution).click();
    }


    @Step("Click on Daily Page Performance Report download button")
    public void ClickOnProductAdServerAnalyticsDailyPagePerformanceReportDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(TableView));
        WebElement element = driver.findElement(TableView);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(TableView));
        driver.findElement(TableView).click();
        wait.until(ExpectedConditions.elementToBeClickable(ProductAdServerAnalyticsDailyPagePerformanceReport));
        driver.findElement(ProductAdServerAnalyticsDailyPagePerformanceReport).click();
    }

    @Step("Click on SKU By Hour download button")
    public void ClickOnProductAdServerAnalyticsSKUByHourDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductAdServerAnalyticsSKUByHour));
        WebElement element = driver.findElement(ProductAdServerAnalyticsSKUByHour);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(ProductAdServerAnalyticsSKUByHour));
        driver.findElement(ProductAdServerAnalyticsSKUByHour).click();
    }

    @Step("Click on Device Performance Report download button")
    public void ClickOnProductAdServerAnalyticsDevicePerformanceReportDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductAdServerAnalyticsDevicePerformanceReport));
        WebElement element = driver.findElement(ProductAdServerAnalyticsDevicePerformanceReport);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(ProductAdServerAnalyticsDevicePerformanceReport));
        driver.findElement(ProductAdServerAnalyticsDevicePerformanceReport).click();
    }


    @Step("Click on Product Demand and Supply Gap Analytics download button")
    public void ClickOnProductDemandAndSupplyGapAnalyticsDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductDemandAndSupplyGapAnalytics));
        WebElement element = driver.findElement(ProductDemandAndSupplyGapAnalytics);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(ProductDemandAndSupplyGapAnalytics));
        driver.findElement(ProductDemandAndSupplyGapAnalytics).click();
    }

    @Step("Click on Product Demand and Supply Budget Utilization Trend download button")
    public void ClickOnProductDemandAndSupplyBudgetUtilizationTrendDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductDemandAndSupplyBudgetUtilizationTrend));
        WebElement element = driver.findElement(ProductDemandAndSupplyBudgetUtilizationTrend);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(ProductDemandAndSupplyBudgetUtilizationTrend));
        driver.findElement(ProductDemandAndSupplyBudgetUtilizationTrend).click();
    }

    @Step("Click on Product Demand and Supply Seasonality download button")
    public void ClickOnProductDemandAndSupplySeasonalityDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductDemandAndSupplySeasonality));
        WebElement element = driver.findElement(ProductDemandAndSupplySeasonality);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(ProductDemandAndSupplySeasonality));
        driver.findElement(ProductDemandAndSupplySeasonality).click();
    }

    @Step("Click on Product Demand and Supply Advertiser Overall GMV download button")
    public void ClickOnProductDemandAndSupplyAdvertiserOverallGMVDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductDemandAndSupplyAdvertiserOverallGMV));
        WebElement element = driver.findElement(ProductDemandAndSupplyAdvertiserOverallGMV);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(ProductDemandAndSupplyAdvertiserOverallGMV));
        driver.findElement(ProductDemandAndSupplyAdvertiserOverallGMV).click();
    }

    @Step("Click on Product Demand and Supply Search Demand Planner download button")
    public void ClickOnProductDemandAndSupplySearchDemandPlannerDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductDemandAndSupplySearchDemandPlanner));
        WebElement element = driver.findElement(ProductDemandAndSupplySearchDemandPlanner);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(ProductDemandAndSupplySearchDemandPlanner));
        driver.findElement(ProductDemandAndSupplySearchDemandPlanner).click();
    }

    @Step("Click on Product Demand and Supply Category Performance Report download button")
    public void ClickOnProductDemandAndSupplyCategoryPerformanceReportDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductDemandAndSupplyCategoryPerformanceReport));
        WebElement element = driver.findElement(ProductDemandAndSupplyCategoryPerformanceReport);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(ProductDemandAndSupplyCategoryPerformanceReport));
        driver.findElement(ProductDemandAndSupplyCategoryPerformanceReport).click();
    }



    @Step("Click on demand and supply gap table view")
    public void ClickOnDemandAndSupplyGapTableView() {
        wait.until(ExpectedConditions.elementToBeClickable(DemandAndSupplyGapTableView));
        driver.findElement(DemandAndSupplyGapTableView).click();
    }


    @Step("Click on page level performance report download button")
    public void ClickOnDisplayAdServerAnalyticsPageLevelPerformanceReportDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(DisplayAdServerAnalyticsPageLevelPerformanceReport));
        WebElement element = driver.findElement(DisplayAdServerAnalyticsPageLevelPerformanceReport);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdServerAnalyticsPageLevelPerformanceReport));
        driver.findElement(DisplayAdServerAnalyticsPageLevelPerformanceReport).click();
    }

    @Step("Click on page level contribution download button")
    public void ClickOnDisplayAdServerAnalyticsPageLevelContributionDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(DisplayAdServerAnalyticsPageLevelContribution));
        WebElement element = driver.findElement(DisplayAdServerAnalyticsPageLevelContribution);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdServerAnalyticsPageLevelContribution));
        driver.findElement(DisplayAdServerAnalyticsPageLevelContribution).click();
    }

    @Step("Click on ad inventory performance report download button")
    public void ClickOnDisplayAdServerAnalyticsAdInventoryPerformanceReportDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(DisplayAdServerAnalyticsAdInventoryPerformanceReport));
        WebElement element = driver.findElement(DisplayAdServerAnalyticsAdInventoryPerformanceReport);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdServerAnalyticsAdInventoryPerformanceReport));
        driver.findElement(DisplayAdServerAnalyticsAdInventoryPerformanceReport).click();
    }


    @Step("Click on page level performance table view table view")
    public void ClickOnDisplayAdServerAnalyticsPageLevelPerformanceTableView() {
        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdServerAnalyticsPageLevelPerformanceTableView));
        driver.findElement(DisplayAdServerAnalyticsPageLevelPerformanceTableView).click();
    }


    @Step("Click on Demand and Supply Gap Analytics download button")
    public void ClickOnDisplayAdDemandAndSupplyDemandAndSupplyGapAnalyticsDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(DisplayAdDemandAndSupplyDemandAndSupplyGapAnalytics));
        WebElement element = driver.findElement(DisplayAdDemandAndSupplyDemandAndSupplyGapAnalytics);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdDemandAndSupplyDemandAndSupplyGapAnalytics));
        driver.findElement(DisplayAdDemandAndSupplyDemandAndSupplyGapAnalytics).click();
    }

    @Step("Click on Budget Utilization Trend download button")
    public void ClickOnDisplayAdDemandAndSupplyBudgetUtilizationTrendDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(DisplayAdDemandAndSupplyBudgetUtilizationTrend));
        WebElement element = driver.findElement(DisplayAdDemandAndSupplyBudgetUtilizationTrend);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdDemandAndSupplyBudgetUtilizationTrend));
        driver.findElement(DisplayAdDemandAndSupplyBudgetUtilizationTrend).click();
    }

    @Step("Click on Seasonality download button")
    public void ClickOnDisplayAdDemandAndSupplySeasonalityDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(DisplayAdDemandAndSupplySeasonality));
        WebElement element = driver.findElement(DisplayAdDemandAndSupplySeasonality);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdDemandAndSupplySeasonality));
        driver.findElement(DisplayAdDemandAndSupplySeasonality).click();
    }

    @Step("Click on 30-day Impression Projections download button")
    public void ClickOnDisplayAdDemandAndSupply30dayImpressionProjectionsDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(DisplayAdDemandAndSupply30dayImpressionProjections));
        WebElement element = driver.findElement(DisplayAdDemandAndSupply30dayImpressionProjections);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdDemandAndSupply30dayImpressionProjections));
        driver.findElement(DisplayAdDemandAndSupply30dayImpressionProjections).click();
    }

    //    @Step("Click on Supply Analytics download button")
//    public void ClickOnDisplayAdDemandAndSupplySupplyAnalyticsDownload() throws InterruptedException {
//        wait.until(ExpectedConditions.presenceOfElementLocated(DisplayAdDemandAndSupplySupplyAnalytics));
//        WebElement element = driver.findElement(DisplayAdDemandAndSupplySupplyAnalytics);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdDemandAndSupplySupplyAnalytics));
//        driver.findElement(DisplayAdDemandAndSupplySupplyAnalytics).click();
//    }
    @Step("Click on Supply Analytics download button")
    public void ClickOnDisplayAdDemandAndSupplySupplyAnalyticsDownload() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(DisplayAdDemandAndSupplySupplyAnalyticsDownloadButton));
        WebElement table = driver.findElement(DisplayAdDemandAndSupplySupplyAnalyticsTable);
        WebElement element = driver.findElement(DisplayAdDemandAndSupplySupplyAnalyticsDownloadButton);
        Actions action = new Actions(driver);
        action.moveToElement(table).perform();
        Thread.sleep(2000);
        String ClassName = driver.findElement(DisplayAdDemandAndSupplySupplyAnalyticsDownloadButton).getAttribute("class");
        if (!ClassName.contains("disable")) {
            element.click();
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
            ExtensiveWait.until(ExpectedConditions.elementToBeClickable(GenericPopUpCloseButton));
            driver.findElement(GenericPopUpCloseButton).click();
            WebDriverWait extensiveWait = new WebDriverWait(driver, Duration.ofSeconds(120));
            extensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(DisabledDownloadButton));
            WebElement downloadButton = extensiveWait.until(ExpectedConditions.elementToBeClickable(DownloadButton));
            if (downloadButton.isEnabled()) {
                downloadButton.click();
            } else {
                System.out.println("The download button took more than 2 minutes to become enabled.");
            }
        } else {
            System.out.println("The download button is disabled as no data is available");
        }
    }

    @Step("Click on display ad demand and supply")
    public void ClickOnDisplayAdDemandAndSupply() {
        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdDemandAndSupply));
        driver.findElement(DisplayAdDemandAndSupply).click();
    }


    @Step("Click on display ad demand and supply gap analytics table view")
    public void ClickOnDisplayAdDemandAndSupplyGapAnalyticsTableView() {
        wait.until(ExpectedConditions.elementToBeClickable(DisplayAdDemandAndSupplyGapAnalyticsTableView));
        driver.findElement(DisplayAdDemandAndSupplyGapAnalyticsTableView).click();
    }

    @Step("Click on home metrics comparison report download ")
    public void ClickOnHomeMetricsComparisonReportDownload() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(HomeMetricsComparisonReport));
        driver.findElement(HomeMetricsComparisonReport).click();
    }
}
