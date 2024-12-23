package PagesPulse;

import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ScheduleReportsPage {
    WebDriver driver;
    WebDriverWait wait;

    public ScheduleReportsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By CreateNewReportButton = By.xpath("//button[contains(@class,'pendo_feature_schedule_report_create_new_button')]");
    final By ReportNameField = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-name')]/descendant::input");
    final By ReportTypeDropdown = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-report-type')]/descendant::div[contains(@class,'os-select-dropdown')]");
    final String ReportTypeOptions = "//div[contains(@class,'pendo-tracking-schedule-report-report-type')]/descendant::div[contains(@id,'option-%s')]";
    final By ReportTimePeriodField = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-report-time-period')]/descendant::div[contains(@class,'os-select-dropdown')]");
    final String TimePeriodOptions = "(//div[contains(@class,'Select__menu')]/descendant::div[contains(@id,'option')])[%d]";
    final By EmailField = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-email-list')]/descendant::div[contains(@class,'Select__placeholder')]");
    final By EmailInputField = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-email-list')]/descendant::input");
    final By DateRangeSelectionField = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-report-time-period')]/descendant::div[contains(@class,'date-range-input-wrapper')]");
    final By SelectOwnEmailId = By.xpath("//div[contains(@id,'option')]");
    final By CreateReportButton = By.xpath("//button[contains(@class,'pendo_feature_schedule_report_form_save_button')]");
    final By SuccessMessageForScheduleReport = By.xpath("//div[contains(@class,'pendo-feature-schedule-report-form-save-success')]");
    final By DeliveryEndDateField = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-delivery-end-date')]/descendant::div[contains(@class,'os-datepicker')]");
    final By GenericMonthField = By.xpath("//div[contains(@class,'month-dropdown')]");
    final String GenericMonthDropDown = "(//div[contains(@id,'-option-')])[%d]";
    final By GenericYearField = By.xpath("//div[contains(@class,'year-dropdown')]");
    final String GenericYearDropDown = "//div[text()='%d']";
    final String GenericDateRange = "(//div[contains(@class,'react-datepicker__day--') and not(contains(@class,'--outside-month'))])[%d]";
    final By GenericYearFieldText = By.xpath("//div[contains(@class,'year-dropdown')]/descendant::div[contains(@class,'Select__single-value css-1dimb5e-singleValue')]");
    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");

    //DateRangeSelection
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
    final String ReportDeliveryFrequency = "(//div[contains(@class,'pendo-tracking-schedule-report-report-delivery')]/descendant::div[contains(@class,'radio-wrapper')])[%d]";
    final String DeliveryDaysRadios = "(//div[contains(@class,'pendo-tracking-schedule-report-report-delivery-weekly-selection')]/descendant::div[contains(@class,'checkbox-wrapper')])[%d]";
    final By DayOfMonthField = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-report-delivery-monthly-selection')]/descendant::div[contains(@class,'input-container')]");
    final String DayOfMonth = "(//div[contains(@class,'monthly-day-select-wrapper pendo-tracking-schedule-report-report-delivery-monthly-selection')]/descendant::div[contains(@id,'option')])[%d]";
    final By EmptyReportNameErrorMessage = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-name')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]");
    final By MaxCharacterReportNameErrorMessage = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-name')]/descendant::div[contains(@class,'pendo-track-field-max-length-error')]");
    final By ValidMailIdAddButton = By.xpath("//div[contains(@class,'pendo-tracking-schedule-report-email-list')]/descendant::span[contains(text(),'Add')]");
    final By ConfirmYesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By CancelButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_right_btn')]");
    final By ScheduleReportsButton = By.xpath("//a[contains(@id,'header-menu-schedule-reports')]");

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    public static int RetryListener = 0;
    public StringBuilder RandomString(int Count) {
        String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk_0123456789";
        StringBuilder randomString = new StringBuilder();
        String fixedPart = "QATesting";
        SecureRandom rand = new SecureRandom();
        randomString.append(fixedPart);

        for (int i = 0; i < Count; i++) {
            int randomIndex = rand.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            randomString.append(randomChar);
        }
        return randomString;
    }
    @Step("Clicking on Schedule reports tab")
    public void ClickScheduleReportsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(ScheduleReportsButton));
        driver.findElement(ScheduleReportsButton).click();
    }

    @Step("Clicking on create report button")
    public void ClickOnCreateNewReportButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateNewReportButton));
        driver.findElement(CreateNewReportButton).click();
    }

    @Step("Entering data in report name field")
    public void EnterDataInReportNameField(int Count) {
        wait.until(ExpectedConditions.elementToBeClickable(ReportNameField));
        driver.findElement(ReportNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(RandomString(Count));
    }
    @Step("Entering desired  data in report name field")
    public void EnterDesiredDataInReportNameField(String Name) {
        wait.until(ExpectedConditions.elementToBeClickable(ReportNameField));
        driver.findElement(ReportNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Name);
    }

    @Step("Clicking on report type dropdown (Ad Performance)")
    public void ClickOnReportTypeDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(ReportTypeDropdown));
        driver.findElement(ReportTypeDropdown).click();
    }

    @Step("Selecting desired option from report type dropdown")
    public void SelectReportTypeOption(int optionNo) {
        String formattedXpath = String.format(ReportTypeOptions, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Clicking on select time period dropdown")
    public void ClickOnSelectTimePeriodDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(ReportTimePeriodField));
        driver.findElement(ReportTimePeriodField).click();
    }

    @Step("Clicking on select time period dropdown")
    public void ClickOnSelectTimeRangeDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(DateRangeSelectionField));
        driver.findElement(DateRangeSelectionField).click();
    }

    @Step("Selecting desired time period option")
    public void SelectTimePeriodOption(int optionNo) {
        String formattedXpath = String.format(TimePeriodOptions, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Clicking on the second select input container")
    public void ClickOnEmailField() {
        wait.until(ExpectedConditions.elementToBeClickable(EmailField));
        driver.findElement(EmailField).click();
    }
    @Step("Enter desired data into email field")
    public void EnterDesiredDataIntoEmailField(String email) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EmailField));
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(email);
    }

    @Step("Clicking on select own email ID option")
    public void ClickOnSelectOwnEmailId() {
        wait.until(ExpectedConditions.elementToBeClickable(SelectOwnEmailId));
        driver.findElement(SelectOwnEmailId).click();
    }

    @Step("Clicking on create report button")
    public void ClickOnCreateReportButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateReportButton));
        driver.findElement(CreateReportButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Validate success pop up for successful scheduling of report")
    public boolean ValidateVisibilityOfSuccessPopupAfterScheduleReport() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
            ExtensiveWait.until(ExpectedConditions.elementToBeClickable(SuccessMessageForScheduleReport));
            return driver.findElement(SuccessMessageForScheduleReport).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on delivery end date field")
    public void ClickOnDeliveryEndDateField() {
        wait.until(ExpectedConditions.elementToBeClickable(DeliveryEndDateField));
        driver.findElement(DeliveryEndDateField).click();
    }


    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    @Step("Clicking on pop up close button")
    public void ClickingOnPopUpCloseButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(GenericPopUpCloseButton));
        driver.findElement(GenericPopUpCloseButton).click();
    }

    @Step("Clicking on month field ")
    public void ClickOnGenericMonthField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(GenericMonthField));
        driver.findElement(GenericMonthField).click();
    }

    @Step("Selecting desired month from month drop down")
    public boolean SelectMonthFromMonthDropDown(int OptionNo) {
        boolean flag = true;
        String XpathFormatter = String.format(GenericMonthDropDown, OptionNo);
        int CurrentMonthNumber = LocalDate.now().getMonthValue();
        int CurrentYear = LocalDate.now().getYear();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

        String selectedMonthText = driver.findElement(GenericMonthField).getText().trim().toUpperCase();
        int selectedMonthNumber = Month.valueOf(selectedMonthText).getValue();

        // Get the selected year from the year dropdown
        String selectedYearText = driver.findElement(GenericYearFieldText).getText().trim();
        int selectedYear = Integer.parseInt(selectedYearText);

        // Compare both the year and month
        if (selectedYear < CurrentYear || (selectedYear == CurrentYear && selectedMonthNumber < CurrentMonthNumber)) {
            flag = false;
        }

        return flag;
    }

    @Step("Clicking on year field ")
    public void ClickOnYearField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(GenericYearField));
        driver.findElement(GenericYearField).click();
    }

    @Step("Selecting desired year from year drop down ")
    public Boolean SelectDesiredYearFromYearDropdown(int OptionNo) {
        boolean flag = true;
        if (OptionNo < 2024) {
            flag = false;
        } else {
            String XpathFormatter = String.format(GenericYearDropDown, OptionNo);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
            driver.findElement(By.xpath(XpathFormatter)).click();
        }
        return flag;
    }


    @Step("Selecting desired day from day range ")
    public void SelectDesiredDate(int date) {
        String XpathFormatter = String.format(GenericDateRange, date);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Epic("Clicking on the exact day")
    public void selectDay(int day, String dayPickerXpath) {
        String dayXPath = String.format(dayPickerXpath, day);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayXPath)));
        driver.findElement(By.xpath(dayXPath)).click();
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

    @Epic("Click on calender and taking date range from user")
    public void selectDateRange(LocalDate startDate, LocalDate endDate) {
        wait.until(ExpectedConditions.elementToBeClickable(DateButton));
        selectDate(startDate);
        selectDate(endDate);
    }
    @Step("Selecting report delivery frequency option")
    public void SelectReportDeliveryFrequency(int optionNo) {
        String formattedXpath = String.format(ReportDeliveryFrequency, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }
    @Step("Selecting delivery day checkbox")
    public void SelectDeliveryDay(int dayOption) {
        String formattedXpath = String.format(DeliveryDaysRadios, dayOption);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }
    @Step("Clicking on day of the month input field")
    public void ClickOnDayOfMonthField() {
        wait.until(ExpectedConditions.elementToBeClickable(DayOfMonthField));
        driver.findElement(DayOfMonthField).click();
    }
    @Step("Selecting day of the month option")
    public void SelectDayOfMonth(int dayOption) {
        String formattedXpath = String.format(DayOfMonth, dayOption);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }
    @Step("Validate visibility of empty field error message")
    public boolean ValidateVisibilityOfEmptyFieldErrorMessage() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(EmptyReportNameErrorMessage));
            return driver.findElement(EmptyReportNameErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate visibility of maximum character error message for report name field")
    public boolean ValidateVisibilityOfMaxCharacterErrorMessage() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(MaxCharacterReportNameErrorMessage));
            return driver.findElement(MaxCharacterReportNameErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating report name field accepting characters  without any error")
    public boolean ValidateReportNameFieldAcceptingCharacters(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ReportNameField));
        return driver.findElement(ReportNameField).getAttribute("value").equals("@$&%*$%!-");
    }
    @Step("Validate visibility of email add button")
    public boolean ValidateVisibilityOfValidEmailAddButton() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            ExtensiveWait.until(ExpectedConditions.elementToBeClickable(ValidMailIdAddButton));
            return driver.findElement(ValidMailIdAddButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Validate visibility yes button")
    public boolean ValidateVisibilityOfYesButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(ConfirmYesButton));
            return driver.findElement(ConfirmYesButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    @Step("Clicking on Cancel Button")
    public void ClickCancelButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CancelButton));
        driver.findElement(CancelButton).click();

    }


}
