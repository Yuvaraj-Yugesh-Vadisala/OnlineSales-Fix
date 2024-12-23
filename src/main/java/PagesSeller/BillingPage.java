package PagesSeller;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;

public class BillingPage {
    WebDriver driver;
    WebDriverWait wait;

    public BillingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    final StringBuilder Text = RandomString();
    final By NextButton = By.xpath("//button[contains(@class,'pendo-track-auction-inventory-save-button')]");
    final By CreateNewWalletButton = By.xpath("//button[contains(@class,'pendo-track-finance-wallet-details-create-wallet-dropdown-button')]");
    final By CampaignTypeField = By.xpath("//div[contains(@class,'pendo-track-finance-wallet-campaign-type-dropdown')]");
    final By SearchFieldOfChooseWalletField = By.xpath("//div[contains(@class,'pendo-track-wallet-selection-dropdown')]/descendant::input");
    final By TopUpAmountErrorMessage = By.xpath("//div[contains(@class,'pendo-track-topup-amount-error')]");
    final By MultiWalletTransferSuccessPopUp = By.xpath("//div[contains(@class,'pendo-track-wallet-transfer-modal-form-success')]");
    final By MultiWalletToWalletErrorMessage = By.xpath("//div[contains(@class,'pendo-track-wallet-transfer-to-finance-error')]");
    final By MultiWalletTransferWalletErrorPopUp = By.xpath("//div[contains(@class,'pendo-track-wallet-transfer-modal-form-empty-error')]");
    final By ErrorMessageWithEmptyFieldsInWalletCreation = By.xpath("//div[contains(@class,'pendo-track-finance-wallet-name-input-error')]");
    final By ErrorMessage = By.xpath("//div[contains(@class,'pendo-track-wallet-creation-failed-errorf')]");
    final By ErrorMessageOfEmptyValueField = By.xpath("//div[contains(@class,'pendo-track-filter-fincane-operator')]/following-sibling::div[@class='error-msg name-error-message']");
    final By SearchFieldInAddOrRemoveColumns = By.xpath("//div[contains(@class,'pendo-track-react-table-dynamic-')]/descendant::div[contains(@class,'input-container')]/input");
    final By CampaignTypeAddFilterTransactionDetailsField = By.xpath("//div[contains(@class,'pendo-track-filter-action-dropdown')]");
    final By TransactionLogAddFilterTransactionDetailsField = By.xpath("//div[contains(@class,'pendo-track-filter-action-dropdown')]");
    final By TransactionLogTransactionDetailsInputField = By.xpath("//div[contains(@class,'pendo-track-filter-action-dropdown')]/descendant::input");
    final By TransactionLogSelectMonthField = By.xpath("//div[contains(@class,'month-dropdown')]");
    final By TransactionLogSelectYearField = By.xpath("//div[contains(@class,'year-dropdown')]");
    final String TransactionLogDateRange = "(//div[contains(@class,'react-datepicker__day--') and not(contains(@class,'--outside-month'))])";
    final By TransactionLogHourField = By.xpath("//div[contains(@class,'pendo-track-time-picker-hour-dropdown')]");
    final By TransactionLogMinutesField = By.xpath("//div[contains(@class,'pendo-track-time-picker-minute-dropdown')]");
    final By TransactionLogTimeAndDateApplyButton = By.xpath("//button[contains(@class,'pendo-track-time-picker-apply-button')]");
    final By TransactionLogErrorMessage = By.xpath("//div[contains(@class,'pendo-track-filter-fincane-operator-toggle-date-picker-dropdown ')]/following-sibling::div[@class='error-msg name-error-message']");
    final By CampaignTypeTabErrorMessage = By.xpath("//div[contains(@class,'pendo-track-filter-fincane-operator-toggle-multi-dropdown')]/following-sibling::div[@class='error-msg name-error-message']");
    final By AddFilterGenericConditionInputField = By.xpath(" //div[contains(@class,'pendo-track-filter-condition-dropdown')]/descendant::input");

    final By SellerSwitchField = By.xpath("//div[contains(@class,'pendo-track-client-list-dropdown')]");
    final String DesiredSeller = ("(//div[contains(@id,'option-')])[%d] ");
    final By ManageWallet = By.xpath("//div[contains(@class,'pendo-track-wallet-balance-wrapper')]");
    final By ChooseWalletField = By.xpath("(//div[contains(@class,'pendo-track-wallet-selection-dropdown')])[1]"); //changed
    final By ChooseWalletInPaymentPage = By.xpath("//div[contains(@class,'pendo-track-auciton-config-wallet-selection-dropdown')]");
    final String WalletOptions = ("(//div[contains(@id,'-option-')])[%d]");
    final By TopUpField = By.xpath("//div[contains(@class,'pendo-track-topup-amount-input')]/descendant::input");
    final By AddMoneyButton = By.xpath("//button[contains(@class,'pendo_feature_topup_button')]");
    final By PhoneNumberField = By.xpath("//div[@class='elem elem-one-click-checkout  svelte-1lowomx']/child::input[@id='contact']");
    final By ProceedButton = By.xpath("//button[contains(@id,'redesign')]");
    final By RazorpayFrame = By.xpath("//iframe[contains(@class,'razorpay-checkout-frame')]");
    final By CrossButton = By.xpath("//button[@class='modal-close svelte-1sop3ts']");
    final By NextStepButton = By.xpath("//button[contains(@class,'pendo-track-campaign-performance-create-campaign-next-button')]");
    final By WalletOption = By.xpath("//div[@class='title svelte-1d17g67']/child::div[contains(text(),'Wallet')]");
    final By PhonePeOption = By.xpath("//div[@class='title-container svelte-qfnoyu']/child::span[contains(text(),'PhonePe')]");
    final By PayNowButton = By.xpath("//button[contains(@id,'redesign')]");
    final By SuccessButton = By.xpath("//button[contains(text(),'Success')]");
    final By AddMoneySuccessMessage = By.xpath("//div[contains(@class,'pendo-track-money-added-successfully')]");
    final By WalletNameField = By.xpath("//div[contains(@class,'pendo-track-finance-wallet-name-input')]/descendant::input");
    final String CampaignTypeDropdown = ("(//div[contains(@class,'pendo-track-finance-wallet-campaign-type-dropdown')]/descendant::div[contains(@class,'Select__option')])[%d]");
    final By SelectPageButtonBilling = By.xpath("//button[contains(@class,'pendo-track-auction-select-page-button')]");
    final By CreateWalletButton = By.xpath("//button[contains(@class,'pendo-track-billing-create-wallet-button')]");
    final By FirstElementInDropDownOfChooseWallet = By.xpath("//label[contains(@class,'pendo-track-wallet-selection-dropdown-popover-wrapper Select__menu-list custom-option-wrapper:nth-child[1]')]");
    final By SelectHomePage = By.xpath("(//span[text()='Home Page'])[1]");
    final By CampaignLaunchButton = By.xpath("//button[contains(@class,'pendo-track-campaign-performance-search-only-launch-button')]");
    final By PayFromWalletButton = By.xpath("//span[contains(text(),'balance')]");
    final By SuccessfulPaymentFromWalletMessage = By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--success']");
    final By AdNameField = By.xpath("//div[contains(@class,'pendo-track-ad-name-input')]");
    final By AdNameActiveField = By.xpath("//div[contains(@class,'pendo-track-ad-name-input')]/child::input");
    final By HeadLineField = By.xpath("//div[contains(@class,'pendo-track-creative-form-group-text_headline')]/descendant::input");
    final By AdSaveButton = By.xpath("//button[contains(@class,'pendo-track-creative-upload-drawer-wrapper-save-button')]");
    final By ChooseWalletInAuctionCampaignPaymentPage = By.xpath("//div[@class='universal-dd-wrapper medium full-border dropdown']");
    final By ChooseWalletFieldInPerformancePaymentPage = By.xpath("//div[contains(@class,'pendo-track-performance-config-wallet-selection-dropdown search-enabled')]");
    final By MultiWalletFromWallet = By.xpath("//div[contains(@class,'pendo-track-wallet-transfer-from-finance')]");
    final By MultiWalletToWallet = By.xpath("//div[contains(@class,'universal-dropdown-container pendo-track-wallet-transfer-to-finance')]");
    final By MultiWalletTransferIcon = By.xpath("//span[contains(@class,'transfer-arrow')]");
    final By MultiWalletEnterAmountField = By.xpath("//div[@class='fake-input-wrapper']");
    final By MultiWalletEnterAmountInputField = By.xpath("(//div[@class='in-progress-wrapper']/descendant::input[@placeholder='Enter Amount'])[2]");
    final By MultiWalletDescriptionField = By.xpath("//textarea[@class='form-control  with-character-limit']");
    final By MultiWalletTransferButton = By.xpath("//button[@class='button os-button  button-primary shape-cornor medium      ']");
    final By MultiWalletExchangeIcon = By.xpath("//span[@class='icon icon-exchange-2  iconbtn']");
    final By MultiWalletManageWalletAddAmountErrorLine = By.xpath("//div[contains(@class,'pendo-track-transaction-modal-amount-error')]");
    final By MultiWalletMoreThanFromWalletAmountError = By.xpath("//div[contains(@class,'pendo-track-field-max-value-error')]");
    final By MultiWalletCampaignTypeRemoveButton = By.xpath("//i[@class='remove-pill icon icon-close1']");
    final By MultiWalletEditWalletIcon = By.xpath("//span[@class='icon icon-edit-filled edit-wallet-icon cursor-pointer']");
    final By AddFilter = By.xpath("//button[contains(@class,'pendo_feature_filter_pill_add_button')]");
    final By ApplyButtonInAddFilter = By.xpath("//button[contains(@class,'pendo_feature_pill_filter_submit_button')]");
    final By AddOrRemoveColumns = By.xpath("//div[@class='os-react-table-container clearfix horizontal-plain-layout table-with-api table-small with-sticky-header row-highlight-enable']//button[@class='dropdown-toggle btn btn-primary']");
    final By TransactionLogTab = By.xpath("//a[@class='pendo_feature_finance_manage_tab_transactionLog nav-item nav-link']");
    final String AddFilterConditionFieldGenericDropDown = "(//div[contains(@class,'pendo-track-filter')]/descendant::div[contains(@id,'option')])[%d]";
    final By GenericWalletAddFilterConditionField = By.xpath("//div[contains(@class,'condition-dropdowns')]");
    final By GenericWalletAddFilterInputField = By.xpath("//div[@class='form-component-wrapper  small-dropdown condition-dropdowns   ']/following-sibling::div/div/div/div/div/input");
    final By TransactionLogAddFilterApplyButton = By.xpath("//button[contains(@class,'button os-button filter-apply-btn pendo_feature_pill_filter_submit_button ')]");
    final By TransactionLogAddFilterSelectDateField = By.xpath("//div[@class='date-picker-input-wrapper d-align-between form-controls']");
    final String TransactionLogMonthDropDown = "(//div[contains(@id,'-option-')])[%d]";
    final String TransactionLogYearDropDown = "//div[text()='%d']";
    final By TransactionLogTimeAndDateCancelButton = By.xpath("//button[contains(@class,'pendo-track-time-picker-cancel-button')]");
    final By WalletFilterLogApplyButton = By.xpath("//button[contains(@class,'button os-button filter-apply-btn pendo_feature_pill_filter_submit_')]");
    final By CampaignTypeTab = By.xpath("//a[@class='pendo_feature_finance_manage_tab_campaignTypeTable nav-item nav-link active']");
    final By WalletTableRefreshIcon = By.xpath("//button[contains(@class,'button os-button refresh-button only-icon false undefined pendo-track-react-table-refresh-button button-default shape-cornor medium      ')]");
    final String AddOrRemoveCheckBoxes = "(//div[contains(@class,'Select__option Select__option--is-') and not(contains(@class,'-disabled'))])[%d]";
    final By WalletTab = By.xpath("//a[contains(@class,'pendo_feature_finance_manage_tab_prePaidWalletTable nav-item nav-link')]");
    final By WalletTabErrorMessage = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final By AwarenessCampaignWalletSelectionField = By.xpath("//div[contains(@class,'pendo-track-auciton-config-wallet-selection-dropdown')]");
    final By AwarenessCampaignWalletInputField = By.xpath("//input[contains(@aria-controls,'-listbox')]");
    final By AwarenessGuaranteedCampaignDisableWallets = By.xpath("(//div[@class='custom-option-wrapper disabled d-align-between  undefined'])[1]");
    final By PerformanceCampaignWalletInputField = By.xpath("//input[contains(@aria-controls,'-listbox')]");
    final By PerformanceCampaignWalletSelectionField = By.xpath("//div[contains(@class,'pendo-track-performance-config-wallet-selection-dropdown')]/descendant::button");
    final By PerformanceCampaignWalletSelectionFieldText = By.xpath("//div[contains(@class,'pendo-track-performance-config-wallet-selection-dropdown')]/descendant::div[contains(@class,'Select__input-container')]");
    final By AwarenessCampaignWalletSelectionFieldText = By.xpath("//label[@class='os-tooltip-text undefined width-flex-1 w100p']/span");

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;

    @Step("Clicking on Manage Wallet ")
    public void ClickOnManageWallet() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ManageWallet));
        driver.findElement(ManageWallet).click();
    }

    @Step("Clicking on Choose Wallet field ")
    public void ClickOnChooseWalletField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ChooseWalletField));
        driver.findElement(ChooseWalletField).click();
    }

    @Step("Clicking on seller choose field")
    public void ClickOnSellerChooseField() {
        wait.until(ExpectedConditions.elementToBeClickable(SellerSwitchField));
        driver.findElement(SellerSwitchField).click();
    }
    @Step("Enter seller name")
    public void EnterDesiredTextToSellerSearchField(String Seller) {
//        wait.until(ExpectedConditions.elementToBeClickable(SellerSwitchField));
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey+"+a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(Seller);

    }

    @Step("Selecting desired Seller")
    public void SelectDesiredSeller(int seller) {
        String XpathFormatter = String.format(DesiredSeller, seller);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired wallet from wallet dropdown")
    public void SelectDesiredWalletFromWalletDropdown(int wallet_no) {
        String XpathFormatter = String.format(WalletOptions, wallet_no);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering desired amount in Top Up amount Field")
    public void AddDesiredAmountInTopUpAmountField(String Amount) {
        wait.until(ExpectedConditions.elementToBeClickable(TopUpField));
        driver.findElement(TopUpField).sendKeys(Amount);
    }

    @Step("Clicking on Add Money Button")
    public void ClickAddMoneyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddMoneyButton));
        driver.findElement(AddMoneyButton).click();
    }

    @Step("Clicking on Next Step Button While creating a new campaign")
    public void ClickNextStepButton() {
        wait.until(ExpectedConditions.elementToBeClickable(NextStepButton));
        driver.findElement(NextStepButton).click();
    }

    @Step("Adding phone number while paying through desired payment method")
    public void AddPhoneNumberWhilePaying(String Phone_no) {
        wait.until(ExpectedConditions.presenceOfElementLocated(RazorpayFrame));
        WebElement iframe = driver.findElement(RazorpayFrame);
        driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.presenceOfElementLocated(PhoneNumberField));
        driver.findElement(PhoneNumberField).click();
        driver.switchTo().activeElement().sendKeys(Phone_no);
    }

    @Step("Click on Proceed Button")
    public void ClickProceedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ProceedButton));
        driver.findElement(ProceedButton).click();
    }

    @Step("Selecting wallet option from available payment methods")
    public void ClickOnWalletOption() {
        wait.until(ExpectedConditions.elementToBeClickable(WalletOption));
        driver.findElement(WalletOption).click();
    }

    @Step("Selecting PhonePe from available wallet options")
    public void ClickOnPhonePeOption() {
        wait.until(ExpectedConditions.elementToBeClickable(PhonePeOption));
        driver.findElement(PhonePeOption).click();
    }

    @Step("Click on pay now button")
    public void ClickOnPayNowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PayNowButton));
        driver.findElement(PayNowButton).click();
    }

    @Step("Click on success button")
    public void ClickOnSuccessButton() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        String mainWindowHandle = iterator.next();
        String secondWindowHandle = iterator.next();
        driver.switchTo().window(secondWindowHandle);
        wait.until(ExpectedConditions.elementToBeClickable(SuccessButton));
        driver.findElement(SuccessButton).click();
        driver.switchTo().window(mainWindowHandle);
        driver.switchTo().parentFrame();
    }

    @Step("Validate successful addition of money")
    public boolean ValidateSuccessfulAdditionOfMoney() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddMoneySuccessMessage));
        return driver.findElement(AddMoneySuccessMessage).isDisplayed();
    }

    @Step("Clicking on Create New Wallet Button")
    public void ClickOnCreateNewWallet() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CreateNewWalletButton));
        driver.findElement(CreateNewWalletButton).click();
    }

    @Step("Entering data in Wallet Name Field ")
    public void EnterDataInWalletNameField(String WalletName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(WalletNameField));
        driver.findElement(WalletNameField).sendKeys(WalletName);
    }

    @Step("Entering data in Wallet Name Field while creating a wallet ")
    public void EnterWalletNameInWalletNameField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(WalletNameField));
        driver.findElement(WalletNameField).sendKeys(Text);
    }

    @Step("Click on next button")
    public void ClickNextButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(NextButton));
        driver.findElement(NextButton).click();
    }

    @Step("Click on select page button")
    public void ClickOnSelectPageButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SelectPageButtonBilling));
        driver.findElement(SelectPageButtonBilling).click();
    }


    @Step("Clicking on campaign type field")
    public void ClickOnCampaignTypeField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CampaignTypeField));
        driver.findElement(CampaignTypeField).click();
    }

    @Step("Clicking on campaign type field")
    public void ClickOnCampaignLaunchButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CampaignLaunchButton));
        driver.findElement(CampaignLaunchButton).click();
    }

    @Step("Selecting desired option from campaign type dropdown ")
    public void SelectDesiredOptionFromCampaignTypeDropdown(int RowConditionSelector) {
        String XpathFormatter = String.format(CampaignTypeDropdown, RowConditionSelector);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on Create Wallet Button")
    public void ClickOnCreateWalletButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CreateWalletButton));
        driver.findElement(CreateWalletButton).click();
    }

    @Step("Entering data in Search field of Choose wallet field ")
    public void EnterDataInSearchFieldOfChooseWalletField(String WalletName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(SearchFieldOfChooseWalletField));
        driver.findElement(SearchFieldOfChooseWalletField).click();
        driver.findElement(SearchFieldOfChooseWalletField).sendKeys(WalletName);
    }

    @Step("Validating successful creation of new wallet")
    public boolean ValidateCreationOfNewWallet(String WalletName) {
        boolean flag = false;
        ClickOnChooseWalletField();
        EnterDataInSearchFieldOfChooseWalletField(String.valueOf(WalletName));
        wait.until(ExpectedConditions.presenceOfElementLocated(FirstElementInDropDownOfChooseWallet));
        String CreatedWalletName = driver.findElement(FirstElementInDropDownOfChooseWallet).getText();
        System.out.print(CreatedWalletName);
        if (CreatedWalletName.equalsIgnoreCase(String.valueOf(WalletName)))
            flag = true;
        return flag;
    }

    @Step("Validating successful creation of new wallet")
    public boolean ValidateCreationOfNewWalletName() {
        boolean flag = false;
        ClickOnChooseWalletField();
        EnterDataInSearchFieldOfChooseWalletField(String.valueOf(Text));
        wait.until(ExpectedConditions.presenceOfElementLocated(FirstElementInDropDownOfChooseWallet));
        String CreatedWalletName = driver.findElement(FirstElementInDropDownOfChooseWallet).getText();
        System.out.print(CreatedWalletName);
        if (CreatedWalletName.equalsIgnoreCase(String.valueOf(Text)))
            flag = true;
        return flag;
    }

    @Step("Clicking on choose Wallet Button on payment page")
    public void ClickOnChooseWalletDropdownInPaymentPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ChooseWalletInPaymentPage));
        driver.findElement(ChooseWalletInPaymentPage).click();
    }

    @Step("Click on the pay from wallet button")
    public void ClickOnPayFromWalletButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(PayFromWalletButton));
        driver.findElement(PayFromWalletButton).click();
    }

    @Step("Validate successful payment message")
    public boolean ValidateSuccessfulPayment() {
        wait.until(ExpectedConditions.presenceOfElementLocated(SuccessfulPaymentFromWalletMessage));
        return driver.findElement(SuccessfulPaymentFromWalletMessage).isDisplayed();
    }

    @Step("Adding text to ad name field")
    public void AddNameToAdName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdNameField));
        driver.findElement(AdNameField).click();
        driver.findElement(AdNameActiveField).sendKeys("Test");
    }

    @Step("Adding text to headline field")
    public void AddNameHeadLineField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HeadLineField));
        driver.findElement(HeadLineField).click();
        driver.findElement(HeadLineField).sendKeys("test");
    }

    @Step("Click on save button While creating ad")
    public void ClickAdSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdSaveButton));
        driver.findElement(AdSaveButton).click();
    }

    @Step("Click on save button While creating ad")
    public void ClickOnWalletDropdownInAuctionPaymentPage() {
        wait.until(ExpectedConditions.elementToBeClickable(ChooseWalletInAuctionCampaignPaymentPage));
        driver.findElement(ChooseWalletInAuctionCampaignPaymentPage).click();
    }

    @Step("Clicking on Choose Wallet field in Performance page")
    public void ClickOnChooseWalletFieldInPerformance() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ChooseWalletFieldInPerformancePaymentPage));
        driver.findElement(ChooseWalletFieldInPerformancePaymentPage).click();
    }

    @Step("Validate successful payment message")
    public boolean ValidateSuccessfulPerformanceCampaignCreation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(SuccessfulPaymentFromWalletMessage));
        return driver.findElement(SuccessfulPaymentFromWalletMessage).isDisplayed();
    }

    @Step("Validate top up amount field error message")
    public boolean ValidateTopUpAmountErrorMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TopUpAmountErrorMessage));
        return driver.findElement(TopUpAmountErrorMessage).isDisplayed();
    }

    @Step("Validating top up amount field accepting spaces")
    public boolean ValidateTopUpAmountFieldAcceptingSpaces() {
        boolean flag = false;
        String Text = driver.findElement(TopUpField).getAttribute("value");
        if (Text.trim().isEmpty()) {
            flag = true;
        }
        return flag;

    }

    @Step("Validating top up amount field accepting more then one period")
    public boolean ValidateTopUpAmountFieldAcceptingMoreThenOnePeriod() {
        String Text = driver.findElement(TopUpField).getAttribute("value");
        return Text.chars().filter(ch -> ch == '.').count() > 1;

    }

    @Step("Validating top up amount field accepting negative value")
    public boolean ValidateTopUpAmountFieldAcceptingNegativeValue() {
        String Text = driver.findElement(TopUpField).getAttribute("value");
        return Text.contains("-");

    }

    @Step("Clicking on multi wallet transfer icon")
    public void ClickOnWalletTransferIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MultiWalletTransferIcon));
        driver.findElement(MultiWalletTransferIcon).click();
    }

    @Step("Clicking on from wallet")
    public void ClickOnFromWallet() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletFromWallet));
        driver.findElement(MultiWalletFromWallet).click();
    }

    @Step("Clicking on to wallet")
    public void ClickOnToWallet() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletToWallet));
        driver.findElement(MultiWalletToWallet).click();
    }

    @Step("Selecting desired wallet from wallet dropdown")
    public void SelectingDesiredWalletFromWalletDropdown(int wallet_no) {
        String XpathFormatter = String.format(WalletOptions, wallet_no);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on enter amount field")
    public void ClickOnEnterAmountField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletEnterAmountField));
        driver.findElement(MultiWalletEnterAmountField).click();
    }

    @Step("Entering data in enter amount field")
    public void EnterDataInEnterAmountField(String Amount) {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletEnterAmountInputField));
        driver.findElement(MultiWalletEnterAmountInputField).click();
        driver.findElement(MultiWalletEnterAmountInputField).sendKeys(String.valueOf(Amount));
    }

    @Step("Entering data in description field")
    public void EnterDataInDescriptionField(String Text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletDescriptionField));
        driver.findElement(MultiWalletDescriptionField).sendKeys(Text);
    }

    @Step("Clicking on transfer button")
    public void ClickOnTransferButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletTransferButton));
        driver.findElement(MultiWalletTransferButton).click();
    }

    @Step("Validating wallet transfer success pop up")
    public boolean ValidateWalletTransferSuccessPopUP() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MultiWalletTransferSuccessPopUp));
        return driver.findElement(MultiWalletTransferSuccessPopUp).isDisplayed();
    }

    @Step("Clicking on exchange icon")
    public void ClickOnExchangeIcon() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletExchangeIcon));
        driver.findElement(MultiWalletExchangeIcon).click();
    }

    @Step("Validating wallet transfer add amount error pop up")
    public boolean ValidateWalletTransferErrorPopUP() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MultiWalletManageWalletAddAmountErrorLine));
        return driver.findElement(MultiWalletManageWalletAddAmountErrorLine).isDisplayed();
    }

    @Step("Validating transfer top up amount field accepting more then one period")
    public boolean ValidateTransferTopUpAmountFieldAcceptingPeriod() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletEnterAmountField));
        driver.findElement(MultiWalletEnterAmountField).click();
        String Text = driver.findElement(MultiWalletEnterAmountInputField).getAttribute("value");
        return Text.chars().filter(ch -> ch == '.').count() >= 1;

    }

    @Step("Validating transfer enter amount field accepting negative value")
    public boolean ValidateTransferEnterAmountFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletEnterAmountField));
        driver.findElement(MultiWalletEnterAmountField).click();
        String Text = driver.findElement(MultiWalletEnterAmountInputField).getAttribute("value");
        return Text.contains("-");

    }

    @Step("Validating adding more then from wallet value in enter amount field")
    public boolean ValidateAddMoreThenFromWalletValueInEnterAmountField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MultiWalletMoreThanFromWalletAmountError));
        return driver.findElement(MultiWalletMoreThanFromWalletAmountError).isDisplayed();
    }

    @Step("Validating description field accepting more then 100 characters")
    public boolean ValidateDescriptionFieldAcceptingMoreThenHundredCharacters() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletEnterAmountField));
        driver.findElement(MultiWalletEnterAmountField).click();
        String Text = driver.findElement(MultiWalletDescriptionField).getText();
        return Text.length() > 100;
    }

    @Step("Validating to wallet error message")
    public boolean ValidateToWalletErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MultiWalletToWalletErrorMessage));
        return driver.findElement(MultiWalletToWalletErrorMessage).isDisplayed();
    }

    @Step("Validating transfer wallet error pop up")
    public boolean ValidateTransferWalletErrorPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MultiWalletTransferWalletErrorPopUp));
        return driver.findElement(MultiWalletTransferWalletErrorPopUp).isDisplayed();
    }

    @Step(" Validating deletion of default campaign type selected while editing a wallet")
    public boolean ValidatingDeletionOfDefaultCampaignTypeSelectedWhileEditingWallet() {
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(MultiWalletCampaignTypeRemoveButton));
        boolean Flag = false;
        if (isElementInvisible)
            Flag = true;
        return Flag;
    }

    @Step("Clicking on multi wallet edit icon ")
    public void ClickOnMultiWalletEditIcon() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MultiWalletEditWalletIcon));
        driver.findElement(MultiWalletEditWalletIcon).click();
    }

    @Step("Validate Wallet creation with spaces in wallet name ")
    public boolean ValidateWalletCreationWithSpacesInWalletName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ErrorMessageWithEmptyFieldsInWalletCreation));
        return driver.findElement(ErrorMessageWithEmptyFieldsInWalletCreation).isDisplayed();
    }

    @Step("Validate Wallet creation with Empty wallet name ")
    public boolean ValidateWalletCreationWithEmptyWalletName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ErrorMessageWithEmptyFieldsInWalletCreation));
        return driver.findElement(ErrorMessageWithEmptyFieldsInWalletCreation).isDisplayed();
    }

    @Step("Validate Wallet creation with more than 20 characters in wallet name ")
    public boolean ValidateWalletCreationWithMoreThan20CharactersInWalletName() {
        boolean flag = false;
        String Text = driver.findElement(WalletNameField).getAttribute("value");
        if (Text.length() > 20) {
            flag = true;
        }
        return flag;
    }

    @Step("Validate Wallet creation with Empty campaign type ")
    public boolean ValidateWalletCreationWithEmptyCampaignType() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageWithEmptyFieldsInWalletCreation));
        return driver.findElement(ErrorMessageWithEmptyFieldsInWalletCreation).isDisplayed();
    }

    @Step("Validate duplicate wallet creation with same config and name ")
    public boolean ValidateDuplicateWalletCreationWithSameConfigAndName() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ErrorMessage));
        return driver.findElement(ErrorMessage).isDisplayed();
    }

    @Step("Clicking on Add filter ")
    public void ClickOnAddFilter() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AddFilter));
        driver.findElement(AddFilter).click();
    }

    @Step("Clicking on Apply button in Add filter ")
    public void ClickOnApplyButtonInAddFilter() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ApplyButtonInAddFilter));
        driver.findElement(ApplyButtonInAddFilter).click();
    }

    @Step("Validate apply button without selecting any option in add filter  ")
    public boolean ValidateApplyButtonWithoutSelectingAnyOption() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageOfEmptyValueField));
        return driver.findElement(ErrorMessageOfEmptyValueField).isDisplayed();
    }

    @Step("Clicking on add or remove columns  ")
    public void ClickOnAddOrRemoveColumns() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AddOrRemoveColumns));
        driver.findElement(AddOrRemoveColumns).click();
    }

    @Step("Entering data in Search field in Add or remove Columns ")
    public void EnterDataInSearchFieldInAddOrRemoveColumns(String Text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(SearchFieldInAddOrRemoveColumns));
        driver.findElement(SearchFieldInAddOrRemoveColumns).sendKeys(Text);
    }

    @Step("Clicking on transaction log tab ")
    public void ClickOnTransactionLogTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogTab));
        driver.findElement(TransactionLogTab).click();
    }

    @Step("Clicking on transaction details field in transaction log")
    public void ClickOnTransactionDetailsFieldInTransactionLog() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogAddFilterTransactionDetailsField));
        driver.findElement(TransactionLogAddFilterTransactionDetailsField).click();
    }

    @Step("Entering data in transaction details input field in transaction log")
    public void EnterDataInTransactionDetailsInputFieldInTransactionLog(String Text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogTransactionDetailsInputField));
        driver.findElement(TransactionLogTransactionDetailsInputField).sendKeys(Text);
    }

    @Step("Selecting desired option from transaction details drop down ")
    public void SelectDesiredOptionFromTransactionDetailsDropdown(int OptionNo) {
        String XpathFormatter = String.format(AddFilterConditionFieldGenericDropDown, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on condition field in transaction log")
    public void ClickOnConditionFieldInTransactionLog() {
        wait.until(ExpectedConditions.presenceOfElementLocated(GenericWalletAddFilterConditionField));
        driver.findElement(GenericWalletAddFilterConditionField).click();
    }

    @Step("Selecting desired option from transaction condition drop down ")
    public void SelectDesiredOptionFromTransactionConditionDropdown(int OptionNo) {
        String XpathFormatter = String.format(AddFilterConditionFieldGenericDropDown, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering data in  input field in transaction log")
    public void EnterDataInputFieldInTransactionLog(String Value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(GenericWalletAddFilterInputField));
        driver.findElement(GenericWalletAddFilterInputField).sendKeys(Value);
    }

    @Step("Clicking on transaction log filter apply button ")
    public void ClickOnTransactionLogFilterApplyButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogAddFilterApplyButton));
        driver.findElement(TransactionLogAddFilterApplyButton).click();
    }

    @Step("Clicking on transaction log select date field ")
    public void ClickOnTransactionLogFSelectDateField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogAddFilterSelectDateField));
        driver.findElement(TransactionLogAddFilterSelectDateField).click();
    }

    @Step("Clicking on transaction log  month field ")
    public void ClickOnTransactionLogMonthField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogSelectMonthField));
        driver.findElement(TransactionLogSelectMonthField).click();
    }

    @Step("Selecting desired month from transaction month drop down ")
    public void SelectDesiredMonthFromTransactionMonthDropdown(int OptionNo) {
        String XpathFormatter = String.format(TransactionLogMonthDropDown, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on transaction log  year field ")
    public void ClickOnTransactionLogYearField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogSelectYearField));
        driver.findElement(TransactionLogSelectYearField).click();
    }

    @Step("Selecting desired year from transaction year drop down ")
    public Boolean SelectDesiredYearFromTransactionYearDropdown(int OptionNo) {
        boolean flag = false;
        if (OptionNo < 1990) {
            flag = true;
        } else {
            String XpathFormatter = String.format(TransactionLogYearDropDown, OptionNo);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
            driver.findElement(By.xpath(XpathFormatter)).click();

        }
        return flag;
    }

    @Step("Selecting desired day from transaction day range ")
    public void SelectDesiredDayFromTransactionDayRange(int DayNo) {
        String XpathFormatter = String.format(TransactionLogDateRange, DayNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on transaction log  hour field ")
    public void ClickOnTransactionLogHourField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogHourField));
        driver.findElement(TransactionLogHourField).click();
    }

    @Step("Selecting desired hour from transaction hour drop down ")
    public void SelectDesiredHourFromTransactionHourDropdown(int OptionNo) {
        String XpathFormatter = String.format(AddFilterConditionFieldGenericDropDown, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on transaction log  minutes field ")
    public void ClickOnTransactionLogMinutesField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogMinutesField));
        driver.findElement(TransactionLogMinutesField).click();
    }

    @Step("Selecting desired minutes from transaction minutes drop down ")
    public void SelectDesiredMinutesFromTransactionMinutesDropdown(int OptionNo) {
        String XpathFormatter = String.format(AddFilterConditionFieldGenericDropDown, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on transaction log  date and time apply button")
    public void ClickOnTransactionLogDateAndTimeApplyButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogTimeAndDateApplyButton));
        driver.findElement(TransactionLogTimeAndDateApplyButton).click();
    }

    @Step("Clicking on transaction log  date and time cancel button")
    public void ClickOnTransactionLogDateAndTimeCancelButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogTimeAndDateCancelButton));
        driver.findElement(TransactionLogTimeAndDateCancelButton).click();
    }

    @Step("Clicking on transaction log apply button")
    public void ClickOnWalletFilterApplyButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(WalletFilterLogApplyButton));
        driver.findElement(WalletFilterLogApplyButton).click();
    }

    @Step("Validating transaction log apply button with out selecting any options")
    public boolean ValidateTransactionLogApplyButtonWithOutSelectingAnyOptions() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TransactionLogErrorMessage));
        return driver.findElement(TransactionLogErrorMessage).isDisplayed();
    }

    @Step("Clicking on campaign type tab ")
    public void ClickOnCampaignTypeTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CampaignTypeTab));
        driver.findElement(CampaignTypeTab).click();
    }

    @Step("Clicking on campaign type field in campaign type")
    public void ClickOnCampaignTypeFieldInCampaignType() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CampaignTypeAddFilterTransactionDetailsField));
        driver.findElement(CampaignTypeAddFilterTransactionDetailsField).click();
    }

    @Step("Selecting desired option from campaign type drop down ")
    public void SelectDesiredOptionsFromCampaignTypeDropdown(int OptionNo) {
        String XpathFormatter = String.format(AddFilterConditionFieldGenericDropDown, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on condition field in campaign type")
    public void ClickOnConditionFieldInCampaignType() {
        wait.until(ExpectedConditions.presenceOfElementLocated(GenericWalletAddFilterConditionField));
        driver.findElement(GenericWalletAddFilterConditionField).click();
    }

    @Step("Selecting desired option from campaign type condition drop down ")
    public void SelectDesiredOptionFromCampaignTypeConditionDropdown(int OptionNo) {
        String XpathFormatter = String.format(AddFilterConditionFieldGenericDropDown, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering data in  input field in campaign type")
    public void EnterDataInputFieldInCampaignType(String Value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(GenericWalletAddFilterInputField));
        driver.findElement(GenericWalletAddFilterInputField).sendKeys(Value);
    }

    @Step("Validating campaign type apply button with out selecting any options")
    public boolean ValidateCampaignTypeApplyButtonWithOutSelectingAnyOptions() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CampaignTypeTabErrorMessage));
        return driver.findElement(CampaignTypeTabErrorMessage).isDisplayed();
    }

    @Step("Clicking on wallet table refresh icon")
    public void ClickOnWalletTableRefreshIcon() {
        wait.until(ExpectedConditions.presenceOfElementLocated(WalletTableRefreshIcon));
        driver.findElement(WalletTableRefreshIcon).click();
    }

    @Step("Selecting and deselecting desired option from add or remove columns ")
    public void SelectOrDeselectDesiredOptionFromAddOrRemoveColumns(int OptionNo) {
        String XpathFormatter = String.format(AddOrRemoveCheckBoxes, OptionNo);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on wallettab ")
    public void ClickOnWalletTypeTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(WalletTab));
        driver.findElement(WalletTab).click();
    }


    @Step("Clicking on wallet field in wallet type tab")
    public void ClickOnWalletFieldInWalletTab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CampaignTypeAddFilterTransactionDetailsField));
        driver.findElement(CampaignTypeAddFilterTransactionDetailsField).click();
    }

    @Step("Selecting desired option from wallet drop down ")
    public void SelectDesiredOptionsFromWalletDropdown(int OptionNo) {
        String XpathFormatter = String.format(AddFilterConditionFieldGenericDropDown, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on condition field in wallet")
    public void ClickOnConditionFieldInWallet() {
        wait.until(ExpectedConditions.presenceOfElementLocated(GenericWalletAddFilterConditionField));
        driver.findElement(GenericWalletAddFilterConditionField).click();
    }

    @Step("Selecting desired option from wallet condition drop down ")
    public void SelectDesiredOptionFromWalletConditionDropdown(int OptionNo) {
        String XpathFormatter = String.format(AddFilterConditionFieldGenericDropDown, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering data in  input field in wallet")
    public void EnterDataInputFieldInWallet(String Value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GenericWalletAddFilterInputField));
        driver.findElement(GenericWalletAddFilterInputField).sendKeys(Value);
    }

    @Step("Validating wallet tab apply button with out selecting any options")
    public boolean ValidateWalletTabApplyButtonWithOutSelectingAnyOptions() {
        wait.until(ExpectedConditions.presenceOfElementLocated(WalletTabErrorMessage));
        return driver.findElement(WalletTabErrorMessage).isDisplayed();
    }

    @Step("Entering data in condition input field in wallet")
    public void EnterDataInConditionInputFieldInWallet(String Value) {
        driver.findElement(AddFilterGenericConditionInputField).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AddFilterGenericConditionInputField));
        driver.findElement(AddFilterGenericConditionInputField).sendKeys(Value);

    }

    @Step("Clicking on campaign wallet selection field")
    public void ClickOnAwarenessCampaignWalletSelectionField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AwarenessCampaignWalletSelectionField));
        driver.findElement(AwarenessCampaignWalletSelectionField).click();
    }

    @Step("Enter data in  campaign wallet input field")
    public void EnterDataInAwarenessCampaignWalletInputField(String WalletName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(AwarenessCampaignWalletInputField));
        driver.findElement(AwarenessCampaignWalletInputField).sendKeys(WalletName);
        driver.findElement(AwarenessCampaignWalletInputField).sendKeys(Keys.ENTER);


    }

    @Step("Validating disabled wallets in Awareness campaign ")
    public boolean ValidateDisabledWalletsInAwarenessCampaign(String WalletName) {
        String Text = driver.findElement(AwarenessCampaignWalletSelectionFieldText).getText();
        return Text.equalsIgnoreCase(WalletName);
    }

    @Step("Clicking on performance campaign wallet selection field")
    public void ClickOnPerformanceCampaignWalletSelectionField() {
        wait.until(ExpectedConditions.elementToBeClickable(PerformanceCampaignWalletSelectionField));
        driver.findElement(PerformanceCampaignWalletSelectionField).click();
    }

    @Step("Enter data in performance campaign wallet input field")
    public void EnterDataInPerformanceCampaignWalletInputField(String WalletName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(PerformanceCampaignWalletInputField));
        driver.findElement(PerformanceCampaignWalletInputField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(PerformanceCampaignWalletInputField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(PerformanceCampaignWalletInputField).sendKeys(WalletName);
        driver.findElement(PerformanceCampaignWalletInputField).sendKeys(Keys.ENTER);


    }

    @Step("Validating disabled wallets in performance campaign ")
    public boolean ValidateDisabledWalletsInPerformanceCampaign(String WalletName) {
        String Text = driver.findElement(PerformanceCampaignWalletSelectionFieldText).getText();
        return Text.equalsIgnoreCase("WalletName");
    }

    public StringBuilder RandomString() {
        StringBuilder randomString = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            int randomIndex = rand.nextInt(26);
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }
        return randomString;
    }

    @Step("Selecting Home page")
    public void SelectHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(SelectHomePage));
        driver.findElement(SelectHomePage).click();

    }
}