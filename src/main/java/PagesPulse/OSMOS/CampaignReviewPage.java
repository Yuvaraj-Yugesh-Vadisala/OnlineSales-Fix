package PagesPulse.OSMOS;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
public class CampaignReviewPage {
    WebDriver driver;
    WebDriverWait wait;

    public CampaignReviewPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    final By CampaignReview = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-display-campaign_review')]");
    final By ApproveButton = By.xpath("(//div[contains(@class,'inventory-text')]/button)[2]");
    final By SearchCampaignField = By.xpath("//div[contains(@class,'pendo_feature_campaign_view_search_input')]");
    final By CampaignReviewText = By.xpath("//div[contains(@class,'creative-actionbtn')]/button");
    final String KeywordReviewIconXPath = "(//span[contains(@class,'icon icon-check-circle-2 ')])[%d]";
    final By TableSearchField = By.xpath("//div[contains(@class,'pendo_feature_table_search_input with-shadow')]/descendant::input");
    final By CampaignReviewerField = By.xpath("//td[contains(@class,'campaignReviewerDropdown')]/div");
    final By CampaignViewButton = By.xpath("//button[contains(@class,'view-ad-set-btn')]");
    final By CustomTargeting = By.xpath("//div[contains(@class,'choose-target-skus ')]/descendant::button");
    final By CustomTargetingWindow = By.xpath("//div[contains(@class,'filters-dropdown-section')]/parent::div");
    final By KeywordCheckBoxSelector = By.xpath("//label[contains(@for,'bidding_keywords-')]");
    final By ApproveAllButton = By.xpath("(//div[contains(@class,'snackbar-btngroup')]/button)[1]");
    final By RejectAllButton = By.xpath("(//div[contains(@class,'snackbar-btngroup')]/button)[2]");
    final By KeywordApprovedStatus = By.xpath("//div[contains(@class,'approved-status')]");
    final By KeywordRejectedStatus = By.xpath("//div[contains(@class,'rejected-status')]");
    final By ApprovedCampaignStatus = By.xpath("//span[contains(@class,'active-green')]");
    final By CampaignTableRefreshButton = By.xpath("//button[contains(@class,'refresh-button')]/span");


    @Step("Click on campaign review")
    public void ClickOnCampaignReviewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignReview));
        driver.findElement(CampaignReview).click();
    }
 @Step("Click on campaign refresh")
    public void ClickRefreshButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignTableRefreshButton));
        driver.findElement(CampaignTableRefreshButton).click();
    }

    @Step("Enter data in Table Search Field")
    public void EnterDataInTableSearchField(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(TableSearchField));
        driver.findElement(TableSearchField).sendKeys(Keys.CONTROL + "a");
        driver.findElement(TableSearchField).sendKeys(text);
    }

    @Step("Click on Campaign Reviewer Field")
    public void ClickOnCampaignReviewerField() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignReviewerField));
        driver.findElement(CampaignReviewerField).click();
    }
    @Step("Click on Campaign View Button")
    public void ClickOnCampaignViewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignViewButton));
        driver.findElement(CampaignViewButton).click();
    }
    @Step("Click on Custom Targeting")
    public void ClickOnCustomTargeting() {
        wait.until(ExpectedConditions.elementToBeClickable(CustomTargeting));
        driver.findElement(CustomTargeting).click();
    }
    @Step("Check if Custom Targeting Window is displayed")
    public boolean IsCustomTargetingWindowDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CustomTargetingWindow));
            return driver.findElement(CustomTargetingWindow).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Click on Keyword CheckBox Selector option")
    public void ClickOnKeywordCheckBoxSelector(int index) {
        By formattedXpath = By.xpath(String.format("//label[contains(@for,'bidding_keywords-')]", index));
        wait.until(ExpectedConditions.elementToBeClickable(formattedXpath));
        driver.findElement(formattedXpath).click();
    }
    @Step("Click on Approve All Button")
    public void ClickOnApproveAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ApproveAllButton));
        driver.findElement(ApproveAllButton).click();
    }
    @Step("Click on Reject All Button")
    public void ClickOnRejectAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(RejectAllButton));
        driver.findElement(RejectAllButton).click();
    }
    @Step("Check if Keyword Approved Status is displayed")
    public boolean IsKeywordApprovedStatusDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(KeywordApprovedStatus));
            int ApprovedCount = driver.findElements(KeywordApprovedStatus).size();
//            System.out.println(ApprovedCount);
//            System.out.println(ApprovedCount == 2);
            return ApprovedCount == 2;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Check if Keyword Rejected Status is displayed")
    public boolean IsKeywordRejectedStatusDisplayed () {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(KeywordRejectedStatus));
            int RejectCount = driver.findElements(KeywordRejectedStatus).size();
//            System.out.println(RejectCount);
            return RejectCount == 2;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Check if Keyword Approved Status is displayed")
    public boolean IsKeywordApprovedStatusDisplayedForSingleSelection() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(KeywordApprovedStatus));
            int ApprovedCount = driver.findElements(KeywordApprovedStatus).size();
//            System.out.println(ApprovedCount);
//            System.out.println(ApprovedCount == 2);
            return ApprovedCount == 1;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Selecting the review icon option")
    public void ClickOnKeywordReviewIcon(int index) {
        String XpathFormatter = String.format(KeywordReviewIconXPath,index);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }
    @Step("Clicking on the campaign review button")
    public void ClickOnCampaignReviewText() {
        wait.until(ExpectedConditions.elementToBeClickable(CampaignReviewText));
        driver.findElement(CampaignReviewText).click();
    }
    @Step("Clicking on the approve button")
    public void ClickOnApproveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ApproveButton));
        driver.findElement(ApproveButton).click();
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
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL+ "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(text);
    }
    @Step("Check if Approved Campaign Status is displayed")
    public boolean IsApprovedCampaignStatusDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedCampaignStatus));
            return driver.findElement(ApprovedCampaignStatus).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
