package TestPulse.OSMOS;

import BaseClass.BaseTest;
import PagesPulse.OSMOS.HomePage;
import PagesPulse.OSMOS.Utility;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class Home extends BaseTest {
    private HomePage homePage;
    private Utility utility;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosPulseUrlSandbox);
        homePage = new HomePage(getDriver());
        utility = new Utility(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "fabbae24885e81b2872c2379e563ea7a");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();

        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Started: " + this.getClass().getSimpleName());

    }

    @BeforeMethod
    public void ResetPage() throws InterruptedException, AWTException {
        getDriver().navigate().to(OsmosPulseUrlSandbox);
        if (!Language.equals("en")) {
            utility.ChangeLanguage();
        }
    }
    @AfterClass
    public void TearDown() {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Finished: " + this.getClass().getSimpleName());

        getDriver().quit();
    }

    @Epic("OSMOS PULSE - Admin Dashboard")
    @Feature("This flow belongs to Home Page")
    @Story("Home Page Validations")
    @Severity(SeverityLevel.NORMAL)
    @Test(timeOut = 10000,description = "Test: Validate home pages elements")
    public void ValidateHomePageElements()   {
        utility.RetryOnFailOsmosPulseSandBox((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                homePage.ClickOnThemeChanger();
                homePage.ClickOnLightTheme();
                homePage.SelectComparingMetricSelectorFieldOption(1);
                homePage.EnterDataInMetricSearchField("CTR");
                homePage.SelectGenericOptionFromSelector(1);
                Thread.sleep(500);
                homePage.SelectComparingMetricSelectorFieldOption(2);
                homePage.EnterDataInMetricSearchField("ROAS");
                homePage.SelectGenericOptionFromSelector(1);
                homePage.SelectComparingMetricSelectorFieldOption(3);
                homePage.EnterDataInMetricSearchField("SKU");
                homePage.SelectGenericOptionFromSelector(1);
                homePage.SelectProjectsTableTitleOption(1);
                if (!homePage.IsProjectsTrackerWindowDisplayed()) {
                    utility.TakeScreenshotOnSoftAssertion("Soft Assertion - Projects Tracker Window is not displayed");
                    softAssert.fail("Projects Tracker Window is not displayed");
                    homePage.ClickOnWindowCloseButton();
                    softAssert.assertAll();
                }
            } catch (InterruptedException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();
        }));
    }
}

