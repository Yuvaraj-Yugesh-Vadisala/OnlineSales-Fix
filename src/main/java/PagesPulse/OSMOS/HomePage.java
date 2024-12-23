package PagesPulse.OSMOS;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By WhiteLoader = By.xpath("//div[contains(@class,'loader-wrapper white-loader')]");
    final By ThemeChanger = By.xpath("//div[contains(@class,'darkmode-dropdown')]/descendant::button");
    final By LightTheme = By.xpath("//a[contains(@class,'pendo-track-light-mode-menu-option')]");
    final By DarkTheme = By.xpath("//a[contains(@class,'pendo-track-dark-mode-menu-option')]");
    final By SystemTheme = By.xpath("//a[contains(@class,'pendo-track-system-mode-menu-option')]");
    final String ComparingMetricSelectorField = "(//div[contains(@class,'pendo_feature_chart_metric_selection_dropdown group')])[%d]";
    final By MetricSearchField = By.xpath("//div[contains(@class,'Select__input-container')]/input");
    final String GenericOptionsSelectorXpath = "(//div[contains(@id,'-option-')])[%d]";
    final String ProjectsTableTitles = "(//label[contains(@class,'anchor-link')]/span)[%d]";
    final By ProjectsTrackerWindow = By.xpath("//div[contains(@class,'project-tracker-task-fix-layout')]");
    final By WindowCloseButton = By.xpath("//label[contains(@class,'icon-close1')]");

    @Step("Click on  Theme Changer")
    public void ClickOnThemeChanger() {
        wait.until(ExpectedConditions.elementToBeClickable(ThemeChanger));
        driver.findElement(ThemeChanger).click();
    }

    @Step("Click on Light Theme")
    public void ClickOnLightTheme() {
        wait.until(ExpectedConditions.elementToBeClickable(LightTheme));
        driver.findElement(LightTheme).click();
    }
    @Step("Click on Dark Theme")
    public void ClickOnDarkTheme() {
        wait.until(ExpectedConditions.elementToBeClickable(DarkTheme));
        driver.findElement(DarkTheme).click();
    }
    @Step("Click on System Theme")
    public void ClickOnSystemTheme() {
        wait.until(ExpectedConditions.elementToBeClickable(SystemTheme));
        driver.findElement(SystemTheme).click();
    }
    @Step("Selecting Comparing Metric Selector Field Option")
    public void SelectComparingMetricSelectorFieldOption(int index) {
        By formattedXpath = By.xpath(String.format(ComparingMetricSelectorField, index));
        wait.until(ExpectedConditions.elementToBeClickable(formattedXpath));
        driver.findElement(formattedXpath).click();
    }

    @Step("Enter Data in Metric Search Field")
    public void EnterDataInMetricSearchField(String inputText) {
        wait.until(ExpectedConditions.elementToBeClickable(MetricSearchField));
        driver.findElement(MetricSearchField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(MetricSearchField).sendKeys( inputText);

    }

    @Step("Selecting Generic Option from Selector")
    public void SelectGenericOptionFromSelector(int index) {
        By formattedXpath = By.xpath(String.format(GenericOptionsSelectorXpath, index));
        wait.until(ExpectedConditions.elementToBeClickable(formattedXpath));
        driver.findElement(formattedXpath).click();
    }

    @Step("Selecting Project Table Title Option")
    public void SelectProjectsTableTitleOption(int index) {
        By formattedXpath = By.xpath(String.format(ProjectsTableTitles, index));
        wait.until(ExpectedConditions.elementToBeClickable(formattedXpath));
        driver.findElement(formattedXpath).click();
    }
    @Step("Check if Projects Tracker Window is displayed")
    public boolean IsProjectsTrackerWindowDisplayed() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(ProjectsTrackerWindow));
            return driver.findElement(ProjectsTrackerWindow).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Click on Window Close Button")
    public void ClickOnWindowCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(WindowCloseButton));
        driver.findElement(WindowCloseButton).click();
    }
    
}
