package TestSeller.Tving;

import BaseClass.BaseTest;
import PagesPulse.OrdersPage;
import PagesPulse.ProductTemplatePage;
import PagesPulse.ScheduleReportsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.Cookie;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.LocalDate;

public class ScheduleReport extends BaseTest {
    private ScheduleReportsPage reportspage;
    private OrdersPage ordersPage;
    private ProductTemplatePage productTemplatePage;


    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(TvingSellerUrl);
        ordersPage = new OrdersPage(getDriver());
        reportspage = new ScheduleReportsPage(getDriver());
        productTemplatePage = new ProductTemplatePage(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "f968ddd03b493e94f7c70fa14e5c43d4");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();


    }

    @BeforeMethod
    public void ResetPage(ITestResult result) {
        getDriver().navigate().to(TvingSellerUrl);
//        Cookie UAToken = new Cookie("UA_TOKEN", "f968ddd03b493e94f7c70fa14e5c43d4");
//        Cookie Ubid = new Cookie("ubid", "unique12345");
//        getDriver().manage().addCookie(UAToken);
//        getDriver().manage().addCookie(Ubid);
//        getDriver().navigate().refresh();
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Starting @Test: " + result.getMethod().getMethodName());

    }
    @AfterMethod
    public void afterMethod(ITestResult result) {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Starting @Test: " + result.getMethod().getMethodName());
    }

    @AfterClass
    public void TearDown() {
        getDriver().quit();
    }


    @Epic("TVING - Seller Dashboard")
    @Feature("This flow belongs to Scheduling Of Report")
    @Story("Schedule Report - Positive Flow")
    @Test(description = "Test: Successful Scheduling of report with all mandatory fields", timeOut = 6000)
    public void SuccessfullyScheduleReports() {
        ordersPage.RetryOnFailTvingSeller((() -> {
            SoftAssert softAssert = new SoftAssert();
            try {
                if (!Language.equals("en")) {
                    productTemplatePage.ChangeLanguage();
                }
                reportspage.ClickScheduleReportsTab();
                reportspage.ClickOnCreateNewReportButton();  //scheduling Report using now frequency option
                Thread.sleep(1000);
                reportspage.EnterDataInReportNameField(11);
                reportspage.ClickOnSelectTimeRangeDropdown();
                LocalDate StartDate = LocalDate.of(2024, 10, 25);
                LocalDate EndDate = LocalDate.of(2024, 11, 25);
                reportspage.selectDateRange(StartDate, EndDate);
                reportspage.ClickOnEmailField();
                reportspage.ClickOnSelectOwnEmailId();
                reportspage.ClickOnCreateReportButton();
//                if (!reportspage.ValidateVisibilityOfSuccessPopupAfterScheduleReport()) {
//                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Clicking or visibility of successful message popup failed");
//                    softAssert.fail("Immediate delivery schedule report failed");
//                }
//                reportspage.ClickingOnPopUpCloseButton();
                reportspage.ClickOnCreateNewReportButton();   //scheduling Report Using daily frequency option
                Thread.sleep(1000);
                reportspage.EnterDataInReportNameField(10);
                Thread.sleep(1000);
                reportspage.ClickOnReportTypeDropdown();
                reportspage.SelectReportTypeOption(1);
                reportspage.ClickOnSelectTimePeriodDropdown();
                reportspage.SelectTimePeriodOption(2);
                reportspage.ClickOnDeliveryEndDateField();
                reportspage.ClickOnYearField();
                if (!reportspage.SelectDesiredYearFromYearDropdown(2024)) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less than current year in ads period window date");
                    softAssert.fail("Year cant be less than current year in ads period window date");
                }
                reportspage.ClickOnGenericMonthField();
                if (!reportspage.SelectMonthFromMonthDropDown(12)) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older than present month in basic info ads period window date");
                    softAssert.fail("Cant select older than present month in basic info ads period window date");
                }
                reportspage.SelectDesiredDate(4);
                Thread.sleep(1500);
                reportspage.ClickOnEmailField();
                reportspage.ClickOnSelectOwnEmailId();
                reportspage.ClickOnCreateReportButton();
//                if (!reportspage.ValidateVisibilityOfSuccessPopupAfterScheduleReport()) {
//                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Clicking or visibility of successful message popup failed");
//                    softAssert.fail("Daily delivery schedule report failed");
//                }
//                reportspage.ClickingOnPopUpCloseButton();
                Thread.sleep(1000);
                reportspage.ClickOnCreateNewReportButton();  //scheduling Report using weekly frequency option
                reportspage.EnterDataInReportNameField(11);
                reportspage.SelectReportDeliveryFrequency(3);
                reportspage.ClickOnSelectTimePeriodDropdown();
                reportspage.SelectTimePeriodOption(3);
                reportspage.SelectDeliveryDay(2);
                reportspage.SelectDeliveryDay(3);
                reportspage.ClickOnDeliveryEndDateField();
                reportspage.ClickOnYearField();
                if (!reportspage.SelectDesiredYearFromYearDropdown(2024)) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year cant be less than current year in ads period window date");
                    softAssert.fail("Year cant be less than current year in ads period window date");
                }
                reportspage.ClickOnGenericMonthField();
                if (!reportspage.SelectMonthFromMonthDropDown(12)) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older than present month in basic info ads period window date");
                    softAssert.fail("Cant select older than present month in basic info ads period window date");
                }
                reportspage.SelectDesiredDate(5);
                reportspage.ClickOnEmailField();
                reportspage.ClickOnSelectOwnEmailId();
                reportspage.ClickOnCreateReportButton();
//                if (!reportspage.ValidateVisibilityOfSuccessPopupAfterScheduleReport()) {
//                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Clicking or visibility of successful message popup failed");
//                    softAssert.fail("Weekly delivery schedule report failed");
//                }
//                reportspage.ClickingOnPopUpCloseButton();
                reportspage.ClickOnCreateNewReportButton();   //scheduling Report using  monthly frequency option
                reportspage.EnterDataInReportNameField(11);
                reportspage.SelectReportDeliveryFrequency(4);
                reportspage.ClickOnSelectTimePeriodDropdown();
                reportspage.SelectTimePeriodOption(2);
                reportspage.ClickOnDayOfMonthField();
                reportspage.SelectDayOfMonth(5);
                reportspage.ClickOnDeliveryEndDateField();
                reportspage.ClickOnYearField();
                if (!reportspage.SelectDesiredYearFromYearDropdown(2024)) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Year can't be less than current year in ads period window date");
                    softAssert.fail("Year cant be less than current year in ads period window date");
                }
                reportspage.ClickOnGenericMonthField();
                if (!reportspage.SelectMonthFromMonthDropDown(12)) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Cant select older than present month in basic info ads period window date");
                    softAssert.fail("Can't select older than present month in basic info ads period window date");
                }
                reportspage.SelectDesiredDate(15);
                reportspage.ClickOnEmailField();
                reportspage.ClickOnSelectOwnEmailId();
                reportspage.ClickOnCreateReportButton();
//                if (!reportspage.ValidateVisibilityOfSuccessPopupAfterScheduleReport()) {
//                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Clicking or visibility of successful message popup failed");
//                    softAssert.fail("Monthly delivery schedule report failed");
//                }
//                reportspage.ClickingOnPopUpCloseButton();
            } catch (InterruptedException | AWTException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));
    }

    @Epic("TVING - Seller Dashboard")
    @Feature("This flow belongs to Scheduling Of Report")
    @Story("Schedule Report - Negative Flow")
    @Test(description = "Test: Scheduling of report with negative aspect", timeOut = 6000)
    public void ScheduleReportsWithNegativeAspect() {
        ordersPage.RetryOnFailTvingSeller((() ->
        {
            SoftAssert softAssert = new SoftAssert();
            try {
                if (!Language.equals("en")) {
                    productTemplatePage.ChangeLanguage();
                }
                reportspage.ClickScheduleReportsTab();
                reportspage.ClickOnCreateNewReportButton();   //Without filling mandatory fields clicking create report button
                reportspage.ClickOnCreateReportButton();
                if (!reportspage.ValidateVisibilityOfEmptyFieldErrorMessage()) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to schedule a report without filling mandatory fields and not getting error message");
                    softAssert.fail("User is able to schedule a report without filling mandatory fields and not getting error message");
                }
                reportspage.EnterDesiredDataInReportNameField("     ");    //Adding spaces in report name field and verifying whether it accepts only spaces or not
                reportspage.ClickOnSelectTimeRangeDropdown();
                LocalDate StartDate = LocalDate.of(2024, 10, 25);
                LocalDate EndDate = LocalDate.of(2024, 11, 4);
                reportspage.selectDateRange(StartDate, EndDate);
                reportspage.ClickOnCreateReportButton();
                if (!reportspage.ValidateVisibilityOfEmptyFieldErrorMessage()) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to schedule a report without filling mandatory fields and not getting error message");
                    softAssert.fail("User is able to schedule a report without filling mandatory fields and not getting error message");
                }
                reportspage.EnterDataInReportNameField(51);  //Adding more than maximum characters i.e. 50 in report name field and verifying whether it shows error message or not
                if (!reportspage.ValidateVisibilityOfMaxCharacterErrorMessage()) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Report field name is accepting more than maximum character allowed");
                    softAssert.fail("Report field name is accepting more than maximum character allowed");
                }
                reportspage.EnterDesiredDataInReportNameField("@$&%*$%!-");   //Adding special characters  in report name field and verifying whether it shows error message or not
                if (!reportspage.ValidateReportNameFieldAcceptingCharacters()) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Report field name is accepting special character without any error message");
                    softAssert.fail("Report field name is accepting special character without any error message");
                }
                reportspage.EnterDataInReportNameField(40);
                reportspage.ClickOnEmailField();
                reportspage.EnterDesiredDataIntoEmailField("com.example@gmail");  //Adding an invalid mail id to email id field and verify whether it accepts invalid email id
                if (reportspage.ValidateVisibilityOfValidEmailAddButton()) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Email field is accepting invalid email id");
                    softAssert.fail("Email field is accepting invalid email id");
                }
                reportspage.SelectReportDeliveryFrequency(1);
                reportspage.ClickOnEmailField();
                reportspage.EnterDesiredDataIntoEmailField("    ");  //Adding only spaces to email id field and verify whether it accepts spaces
                if (reportspage.ValidateVisibilityOfValidEmailAddButton()) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - Email field is accepting spaces");
                    softAssert.fail("Email field is accepting spaces");
                }
                Thread.sleep(500);
                reportspage.SelectReportDeliveryFrequency(4); //Changing report delivery after filling mandatory fields
                if (!reportspage.ValidateVisibilityOfYesButton()) {
                    reportspage.TakeScreenshotOnSoftAssertion("Soft Assertion - User is able to change the frequency after filling mandatory fields with out any confirmation");
                    softAssert.fail("User is able to change the frequency after filling mandatory fields with out any confirmation");
                }
                reportspage.ClickCancelButton();

            } catch (InterruptedException | AWTException e) {
                softAssert.fail("Test interrupted unexpectedly: " + e.getMessage());
            }
            softAssert.assertAll();

        }));
    }
}