package PagesPulse.OSMOS;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Locale;

public class FinancePage {
    WebDriver driver;
    WebDriverWait wait;

    public FinancePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }
    public static int RetryListener = 0;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;

    final By FinanceTab = By.xpath("//a[contains(@class,'pendo-tracking-navbar-finance')]");
    final By SupportTab = By.xpath("//a[contains(@class,'pendo-tracking-navbar-support')]");
    final By FinanceDashboard = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-finance-dashboard')]");
    final By AdvertiserWalletSnapShotDownloadReport = By.xpath("//button[contains(@class,'pendo-track-FINANCE_ADVERTISER_WALLET_SNAPSHOT_TABLE-download-report')]");
    final By DownloadButton = By.xpath("//button[contains(@class,'pendo-track-bulk-download-button')]");
    final By DisabledDownloadButton = By.xpath("//button[contains(@class,'pendo-track-bulk-download-button') and contains(@class,'disabled')]");
    final By TransactionDownloadButton = By.xpath("//button[contains(@class,'pendo-track-FINANCE_ADVERTISER_TRANSACTIONS_PREPAID_TABLE-download-report')]");
    final By TransactionDownloadButtonDisabled = By.xpath("//button[contains(@class,'pendo-track-FINANCE_ADVERTISER_TRANSACTIONS_PREPAID_TABLE-download-report') and contains(@class,'disable')]");
    final By AdvertiserManagement = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-finance-advertiser_management')]");
    final By DesiredClient = By.xpath("(//div[contains(@class,'search-results')]/a[contains(@class,'search-item')])[1]");
    final By TableElement = By.xpath("//div[contains(@class,'pendo_feature_dashboard_component_FINANCE_ADVERTISER_TRANSACTIONS')]/descendant::div[contains(@class,'table-body-parent-section')]");
    final By AdvertisersDownloadButton = By.xpath("//button[contains(@class,'pendo-track-FINANCE_ADVERTISER_MANAGEMENT_TABLE-download-report')]");
    final By ClientNameField = By.xpath("//div[contains(@class,'modal-body')]/descendant::input");
    final By FirstColumnItem = By.xpath("(//div[contains(@class,'pendo_feature_dashboard_component_FINANCE_ADVERTISER_MANAGEMENT_TABLE')]/descendant::div[@class='ellipsis-cell']/descendant::span)[1]");
    final By AdvertiserSearchField = By.xpath("//div[contains(@class,'pendo_feature_table_search_input')]/descendant::input");
    final By DownloadDismissButton = By.xpath("//div[contains(@class,'file-download-status-bar')]/descendant::span[contains(@class,'dismiss-icon icon icon-close1')]");
    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");
//    final By WalletTab = By.xpath("//nav[contains(@class,'nav nav-tabs')]/descendant::a[contains(@data-rb-event-key,'WALLET')]");
    final By WalletTable = By.xpath("//a[contains(@class,'pendo_feature_finance_manage_tab_prePaidWalletTable')]/div");
    final By IndividualTransactionLogButton = By.xpath("(//span[contains(@class,'icon icon-transaction-dollar')])[1]");
    final By TransactionLogDownloadButton = By.xpath("//button[contains(@class,'download-report only-icon download-action-table')]");
    final By RefreshButton = By.xpath("//button[contains(@class,'pendo-track-react-table-refresh-button')]/span");
    final By TransactionalLogsTab = By.xpath("//a[contains(@class,'pendo_feature_finance_manage_tab_transactionLog')]");
    final By WalletDropdown = By.xpath("//div[contains(@class,'pendo-track-wallet-selection-dropdown')]");
    final By DownloadStatusBarArrow = By.xpath("//div[contains(@class,'file-download-status-bar')]/descendant::span[contains(@class,'toggle-icon icon icon-arrow-1-up')]");
    final By FirstElementInWalletNameColumn = By.xpath("(//div[contains(@class,'pendo_feature_dashboard_component_FINANCE_ADVERTISER_WALLET_SNAPSHOT_TABLE dashboard')]/descendant::div[contains(@class,'ellipsis-cell')]/descendant::span)[4]");




    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }
    @Step("Clicking on finance tab")
    public void ClickOnFinanceTab() {
        wait.until(ExpectedConditions.elementToBeClickable(FinanceTab));
        WebElement element = driver.findElement(SupportTab);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(FinanceTab).click();
    }
    @Step("Clicking on finance dashboard tab")
    public void ClickOnFinanceDashboard() {
        wait.until(ExpectedConditions.elementToBeClickable(FinanceDashboard));
        driver.findElement(FinanceDashboard).click();
    }
    @Step("Clicking on the first element in wallet name column")
    public void ClickOnTheFirstItemInWalletNameColumn() {
        wait.until(ExpectedConditions.elementToBeClickable(FirstElementInWalletNameColumn));
        driver.findElement(FirstElementInWalletNameColumn).click();
    }

    @Step("Clicking on advertiser wallet snapshot download button")
    public void ClickOnAdvertiserWalletSnapshotDownloadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdvertiserWalletSnapShotDownloadReport));
        driver.findElement(AdvertiserWalletSnapShotDownloadReport).click();
    }
    @Step("Clicking on download button")
    public boolean ClickOnDownloadButton() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(120));
            ExtensiveWait.until(ExpectedConditions.invisibilityOfElementLocated(DisabledDownloadButton));
            ExtensiveWait.until(ExpectedConditions.elementToBeClickable(DownloadButton));
            driver.findElement(DownloadButton).click();
            return false;
        }catch (Exception e){
            return true;
        }
    }
    @Step("Clicking on finance advertiser management")
    public void ClickOnFinanceAdvertiserManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(AdvertiserManagement));
        driver.findElement(AdvertiserManagement).click();
    }

    @Step("Clicking on Transaction Download Button")
    public void ClickOnTransactionDownloadButton() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionDownloadButton));
        WebElement table = driver.findElement(TableElement);
        WebElement element = driver.findElement(TransactionDownloadButton);
        Actions action = new Actions(driver);
        action.moveToElement(table).perform();
        Thread.sleep(2000);
        String ClassName = driver.findElement(TransactionDownloadButton).getAttribute("class");
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
        }
        else {
            System.out.println("Transaction Download button is disabled.");
        }
    }
    @Step("Changing desired client")
    public void ChangeClient() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
        robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        wait.until(ExpectedConditions.elementToBeClickable(ClientNameField));
        driver.findElement(ClientNameField).sendKeys("qa-marketplace");
        wait.until(ExpectedConditions.elementToBeClickable(DesiredClient));
        driver.findElement(DesiredClient).click();
    }
    @Step("Clicking on advertisers download button")
    public void ClickOnAdvertisersDownloadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdvertisersDownloadButton));
        driver.findElement(AdvertisersDownloadButton).click();
    }
    @Step("Clicking on the first item in table")
    public void ClickOnFirstTableColumnItem() {
        wait.until(ExpectedConditions.elementToBeClickable(FirstColumnItem));
        driver.findElement(FirstColumnItem).click();
    }
    @Step("Enter desired advertiser name in search field")
    public void EnterAdvertiserName(String Advertiser_Name) {
        wait.until(ExpectedConditions.elementToBeClickable(AdvertiserSearchField));
        driver.findElement(AdvertiserSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Advertiser_Name);
    }
    @Step("Clicking on the download dismiss button")
    public void ClickOnDownloadDismissButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DownloadDismissButton));
        driver.findElement(DownloadDismissButton).click();
    }
    @Step("Clicking on the Wallet Table tab")
    public void ClickOnWalletTab() {
        wait.until(ExpectedConditions.elementToBeClickable(WalletTable));
        driver.findElement(WalletTable).click();
    }
    @Step("Clicking on the Individual transaction log button")
    public void ClickOnIndividualTransactionLogButton() {
        wait.until(ExpectedConditions.elementToBeClickable(IndividualTransactionLogButton));
        driver.findElement(IndividualTransactionLogButton).click();
    }
    @Step("Clicking on the Transaction logs  download button")
    public void ClickOnTransactionLogsDownloadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(TransactionLogDownloadButton));
        driver.findElement(TransactionLogDownloadButton).click();
    }
    @Step("Clicking on transaction logs refresh button")
    public void ClickingOnTransactionLogRefreshButton() {
        wait.until(ExpectedConditions.elementToBeClickable(RefreshButton));
        driver.findElement(RefreshButton).click();
    }
    @Step("Validate visibility of Wallet dropdown")
    public boolean ValidateVisibilityOfWalletDropdown() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait( driver, Duration.ofSeconds(20));
            ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(WalletDropdown));
            return driver.findElement(WalletDropdown).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Clicking on transaction logs refresh button")
    public void ClickOnTheTransactionalLogsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(TransactionalLogsTab));
        driver.findElement(TransactionalLogsTab).click();
    }

}
