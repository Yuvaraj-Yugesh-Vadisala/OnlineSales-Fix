package PagesPulse.OSMOS;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Utility {
    WebDriver driver;
    WebDriverWait wait;

    public Utility(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public static int RetryListener = 0;

    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }


    final By ControlCenterNavButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-control-center')]");
    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");
    final By ChangeLogButton = By.xpath("//button[contains(@class,'os-button mr-2 button-primary shape-cornor')]");  //need_pendo
    final By ChangeLogPage = By.xpath("//div[contains(@class,'pure-drawer')]");
    final By PageCloseButton = By.xpath("(//label[contains(@class,'pure-toggle-label icon icon-close1')])[1]");
    final By PageCloseButtonLevel2 = By.xpath("(//label[contains(@class,'pure-toggle-label icon icon-close1')])[2]");


    @Step("Clicking on Control Center Navigation Button")
    public void ClickOnControlCenterNavButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ControlCenterNavButton));
        driver.findElement(ControlCenterNavButton).click();
    }

    @Step("Clicking on pop up close button")
    public void ClickOnPopUpCloseButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(GenericPopUpCloseButton));
        driver.findElement(GenericPopUpCloseButton).click();
    }

    @Step("Clicking on change log button")
    public void ClickOnChangeLogButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ChangeLogButton));
        driver.findElement(ChangeLogButton).click();
    }

    private static String OsmosPulseUrl = "https://osmos-qa-staging-2.onlinesales.ai/";

    public void RetryOnFailOsmosPulse(Runnable action) {
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
                if (System.getProperty("OsmosPulseUrl") != null)
                    OsmosPulseUrl = System.getProperty("OsmosPulseUrl");
                driver.navigate().to(OsmosPulseUrl);
            }
        }
        if (!success) {
            Assert.fail("Action failed after multiple attempts due to: " + Message);
        }
    }

    public int ReturnRetryCount() {
        return RetryListener;

    }

    @Step("Validate visibility of change logs page")
    public boolean ValidateVisibilityOfChangeLogPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ChangeLogPage));
            return driver.findElement(ChangeLogPage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on cross button to close the page")
    public void ClickOnCrossButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PageCloseButton));
        driver.findElement(PageCloseButton).click();
    }
    @Step("Clicking on cross button to close the page in level 2")
    public void ClickOnCrossButtonLevel2() {
        wait.until(ExpectedConditions.elementToBeClickable(PageCloseButtonLevel2));
        driver.findElement(PageCloseButtonLevel2).click();
    }

    public void ChangeLanguage() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        actions.contextClick().perform();
        Thread.sleep(2000);
        Robot robot = new Robot();
        for (int i = 1; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
        }
        Thread.sleep(3000);
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
    //temporary sandbox env
    private static String OsmosPulseUrlSandbox = "https://osmos-sandbox-pulse.onlinesales.ai/";

    public void RetryOnFailOsmosPulseSandBox(Runnable action) {
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
                if (System.getProperty("OsmosPulseUrlSandbox") != null)
                    OsmosPulseUrlSandbox = System.getProperty("OsmosPulseUrlSandbox");
                driver.navigate().to(OsmosPulseUrlSandbox);
            }
        }
        if (!success) {
            Assert.fail("Action failed after multiple attempts due to: " + Message);
        }
    }
}
