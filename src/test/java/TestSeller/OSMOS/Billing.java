package TestSeller.OSMOS;

import BaseClass.BaseTest;
import PagesSeller.AwarenessPage;
import PagesSeller.BillingPage;
import PagesSeller.PerformancePage;
import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.*;

public class Billing extends BaseTest {
    private PerformancePage performancePage;
    private AwarenessPage awarenessPage;
    private BillingPage billingPage;

    @BeforeClass
    public void SetUpTests() {
        super.Setup();
        getDriver().get(OsmosSellerUrl);
        performancePage = new PerformancePage(getDriver());
        awarenessPage = new AwarenessPage(getDriver());
        billingPage = new BillingPage(getDriver());
        Cookie UAToken = new Cookie("UA_TOKEN", "87679961c8ff0b310f4ecfe73f579912");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }

    @BeforeMethod
    public void ResetPage() {
        getDriver().navigate().to(OsmosSellerUrl);
        Cookie UAToken = new Cookie("UA_TOKEN", "395d45de1c1a49bed1dbdbdddd073dbf");
        Cookie Ubid = new Cookie("ubid", "unique12345");
        getDriver().manage().addCookie(UAToken);
        getDriver().manage().addCookie(Ubid);
        getDriver().navigate().refresh();
    }


    @AfterClass
    public void TearDown() {

        getDriver().quit();
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Adding desired amount to wallet")
    public void AddMoneyToWallet() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.SelectDesiredWalletFromWalletDropdown(1);
        billingPage.AddDesiredAmountInTopUpAmountField("500");
        billingPage.ClickAddMoneyButton();
        billingPage.AddPhoneNumberWhilePaying("8658743625");
        billingPage.ClickProceedButton();
        billingPage.ClickOnWalletOption();
        billingPage.ClickOnPhonePeOption();
        billingPage.ClickOnPayNowButton();
        billingPage.ClickOnSuccessButton();
        if (!billingPage.ValidateSuccessfulAdditionOfMoney())
            Assert.fail("Failed to add money to wallet");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create new wallet ")
    public void CreateNewWallet() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.ClickOnCreateNewWallet();
        billingPage.EnterWalletNameInWalletNameField();
        billingPage.ClickOnCampaignTypeField();
        billingPage.SelectDesiredOptionFromCampaignTypeDropdown(1);
        billingPage.ClickOnCreateWalletButton();
        if (!billingPage.ValidateCreationOfNewWalletName()) {
            Assert.fail("Wallet creation failed");
        }
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create new wallet ")
    public void PayFromSupportedWalletForGuaranteedCampaignCreation() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        awarenessPage.ClickingOnAwarenessDashBoard();
        awarenessPage.ClickOnCreateCampaignButton();
        awarenessPage.ClickingOnGuaranteedCampaignsImpressions();
//        awarenessPage.ClickGuaranteedNextButton();
        performancePage.ClickingNextStepButton();
        awarenessPage.ClickingOnGuaranteedCampaignSelectPageTypeField();
        awarenessPage.EnteringDataInGuaranteedCampaignSelectPageTypeField("Home");
        awarenessPage.ClickingOnGuaranteedCampaignSelectPageTypeFieldDropDown();
        awarenessPage.ClickingOnGuaranteedCampaignSelectDateButton();
        if (awarenessPage.ClickingOnGuaranteedCampaignsMonthNextNavigator(awarenessPage.ReturnNextMonth(1))) {
            Assert.fail("Only two months ahead can be selected");
        }
        awarenessPage.ClickingOnGuaranteedCampaignAvailableDateInSelectDate("09", 1);
        awarenessPage.ClickingOnGuaranteedCampaignAddInventoryButton();
        awarenessPage.ClickingOnGuaranteedCampaignPayNowButton();
        billingPage.ClickOnChooseWalletDropdownInPaymentPage();
        billingPage.SelectDesiredWalletFromWalletDropdown(2);
        billingPage.ClickOnPayFromWalletButton();
        if (!billingPage.ValidateSuccessfulPayment())
            Assert.fail("Payment failed from wallet");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Pay from supported while creation auction campaign")
    public void PayFromSupportedWalletForAuctionCampaignCreation() throws InterruptedException {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        awarenessPage.ClickingOnAwarenessDashBoard();
        awarenessPage.ClickOnCreateCampaignButton();
        performancePage.ClickingNextStepButton();
//        performancePage.ClickingNextStepButton();
        billingPage.ClickOnSelectPageButton();
        billingPage.SelectHomePage();
        awarenessPage.ClickDoneButton();
        awarenessPage.SelectInventory();
        billingPage.ClickNextButton();
        awarenessPage.ClickTargetingSaveButton();
        awarenessPage.ClickingCampaignCreativeNewAdButton();
        billingPage.AddNameToAdName();
        billingPage.AddNameHeadLineField();
        billingPage.ClickAdSaveButton();
        awarenessPage.ClickingSaveButton();
        performancePage.ClickOnStartDateField();
        performancePage.DateSelector("August", "2024", "10");
        performancePage.ClickOnEndDateField();
        performancePage.DateSelector("September", "2024", "30");
        awarenessPage.AddValueInBiddableCPMField("20");
        awarenessPage.AddValueInDailyBudgetField("40");
        billingPage.ClickOnWalletDropdownInAuctionPaymentPage();
        billingPage.SelectDesiredWalletFromWalletDropdown(2);
        awarenessPage.ClickSubmitForReviewButton();

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Paying from multi wallet for performance campaign ")
    public void PayFromSupportedWalletForPerformanceCampaignCreation() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        awarenessPage.ClickOnCreateCampaignButton();
        performancePage.EnterDailyBudgetPrice("10");
        billingPage.ClickOnChooseWalletFieldInPerformance();
        billingPage.SelectDesiredWalletFromWalletDropdown(3);
        billingPage.ClickOnCampaignLaunchButton();
        if (!billingPage.ValidateSuccessfulPerformanceCampaignCreation())
            Assert.fail("Campaign creation failed");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Entering characters in amount field in add money ")
    public void EnterCharactersInMultiWalletAddMoneyAmountField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.SelectDesiredWalletFromWalletDropdown(5);
        billingPage.AddDesiredAmountInTopUpAmountField("abc");
        billingPage.ClickAddMoneyButton();
        if (!billingPage.ValidateTopUpAmountErrorMessage())
            Assert.fail("Field is Accepting Characters");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Entering spaces in amount field in add money ")
    public void EnterSpacesInMultiWalletAddMoneyAmountField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.SelectDesiredWalletFromWalletDropdown(5);
        billingPage.AddDesiredAmountInTopUpAmountField("    ");
        if (!billingPage.ValidateTopUpAmountFieldAcceptingSpaces())
            Assert.fail("Field is Accepting Spaces");
        billingPage.ClickAddMoneyButton();
        if (!billingPage.ValidateTopUpAmountErrorMessage())
            Assert.fail("Field is Accepting Spaces");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Entering more then one period  in amount field in add money ")
    public void EnterMoreThenOnePeriodInMultiWalletAddMoneyAmountField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.SelectDesiredWalletFromWalletDropdown(5);
        billingPage.AddDesiredAmountInTopUpAmountField("123.2.3");
        if (billingPage.ValidateTopUpAmountFieldAcceptingMoreThenOnePeriod())
            Assert.fail("Field is Accepting More Then One Period");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Entering negative value in amount field in add money ")
    public void EnterNegativeValueInMultiWalletAddMoneyAmountField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.SelectDesiredWalletFromWalletDropdown(5);
        billingPage.AddDesiredAmountInTopUpAmountField("-234");
        if (billingPage.ValidateTopUpAmountFieldAcceptingNegativeValue())
            Assert.fail("Field is Accepting Negative Value");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Entering less then minimum value in top up amount field ")
    public void EnterLessThenMinimumValueInMultiWalletAddMoneyAmountField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.SelectDesiredWalletFromWalletDropdown(5);
        billingPage.AddDesiredAmountInTopUpAmountField("0.9");
        billingPage.ClickAddMoneyButton();
        if (!billingPage.ValidateTopUpAmountErrorMessage())
            Assert.fail("Field is Accepting Less Then Minimum Value");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Clicking add money with empty top up amount field ")
    public void ClickAddMoneyWithEmptyTopUpInMultiWalletAddMoneyAmountField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.SelectDesiredWalletFromWalletDropdown(5);
        billingPage.AddDesiredAmountInTopUpAmountField("");
        billingPage.ClickAddMoneyButton();
        if (!billingPage.ValidateTopUpAmountErrorMessage())
            Assert.fail("Field is Accepting Empty Value");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Transferring  desired amount from wallet to wallet")
    public void TransferMoneyFromOneWalletToOtherWallet() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnFromWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(2);
        billingPage.ClickOnToWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(3);
        billingPage.ClickOnExchangeIcon();
        billingPage.ClickOnEnterAmountField();
        billingPage.EnterDataInEnterAmountField("233");
        billingPage.EnterDataInDescriptionField("QA Testing");
        billingPage.ClickOnTransferButton();
        if (!billingPage.ValidateWalletTransferSuccessPopUP())
            Assert.fail("Wallet Transfer Failed");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Adding spaces in transfer money wallet")
    public void AddSpacesInTransferMoneyWalletField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnFromWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(2);
        billingPage.ClickOnToWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(3);
        billingPage.ClickOnExchangeIcon();
        billingPage.ClickOnEnterAmountField();
        billingPage.EnterDataInEnterAmountField("   ");
        billingPage.EnterDataInDescriptionField("QA Testing");
        billingPage.ClickOnTransferButton();
        if (!billingPage.ValidateWalletTransferErrorPopUP())
            Assert.fail("Field is Accepting Spaces");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Adding characters in transfer money wallet")
    public void AddCharactersInTransferMoneyWalletField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnFromWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(2);
        billingPage.ClickOnToWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(3);
        billingPage.ClickOnExchangeIcon();
        billingPage.ClickOnEnterAmountField();
        billingPage.EnterDataInEnterAmountField("abcde");
        billingPage.EnterDataInDescriptionField("QA Testing");
        billingPage.ClickOnTransferButton();
        if (!billingPage.ValidateWalletTransferErrorPopUP())
            Assert.fail("Field is Accepting Characters");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Adding period in transfer money wallet")
    public void AddPeriodInTransferMoneyWalletField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnFromWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(2);
        billingPage.ClickOnToWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(3);
        billingPage.ClickOnExchangeIcon();
        billingPage.ClickOnEnterAmountField();
        billingPage.EnterDataInEnterAmountField("12.2.3");
        billingPage.EnterDataInDescriptionField("QA Testing");
        billingPage.ClickOnTransferButton();
        if (billingPage.ValidateTransferTopUpAmountFieldAcceptingPeriod())
            Assert.fail("Field is Accepting Period");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Clicking on transfer button with out filling amount field")
    public void ClickOnTransferButtonWithoutFillingAmountField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnFromWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(2);
        billingPage.ClickOnToWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(3);
        billingPage.EnterDataInDescriptionField("QA Testing");
        billingPage.ClickOnTransferButton();
        if (!billingPage.ValidateWalletTransferErrorPopUP())
            Assert.fail("Field is Should Not Accept Empty Value");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Entering negative value in amount field in enter amount field")
    public void EnterNegativeValueInAMountFieldInTransferWallet() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnFromWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(2);
        billingPage.ClickOnToWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(3);
        billingPage.ClickOnEnterAmountField();
        billingPage.EnterDataInEnterAmountField("-23");
        billingPage.EnterDataInDescriptionField("QA Testing");
        billingPage.ClickOnTransferButton();
        if (billingPage.ValidateTransferEnterAmountFieldAcceptingNegativeValue())
            Assert.fail("Field is Should Not Accept Negative Value");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Adding more value than maximum value present in from wallet")
    public void AddAmountMoreThanFromWalletInEnterAmountField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnFromWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(2);
        billingPage.ClickOnToWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(3);
        billingPage.ClickOnEnterAmountField();
        billingPage.EnterDataInEnterAmountField("9999999999");
        billingPage.EnterDataInDescriptionField("QA Testing");
        billingPage.ClickOnTransferButton();
        if (!billingPage.ValidateAddMoreThenFromWalletValueInEnterAmountField())
            Assert.fail("Amount Can Not be More Then From Wallet Balance");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Adding more then 100 characters in description field")
    public void AddMoreThenHundredCharactersInDescriptionField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnFromWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(2);
        billingPage.ClickOnToWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(3);
        billingPage.ClickOnEnterAmountField();
        billingPage.EnterDataInEnterAmountField("999");
        billingPage.EnterDataInDescriptionField("Testing ensures software quality by identifying defects and verifying functionality before releases..");
        if (billingPage.ValidateDescriptionFieldAcceptingMoreThenHundredCharacters())
            Assert.fail("Field Should Not Accept More Then 100 Words");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Clicking on transfer button with out selecting to wallet")
    public void ClickOnTransferButtonWithOutSelectingAnyToWallet() throws InterruptedException {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnEnterAmountField();
        billingPage.EnterDataInEnterAmountField("999");
        billingPage.EnterDataInDescriptionField("QA Testing");
        Thread.sleep(1000);
        billingPage.ClickOnTransferButton();
        if (!billingPage.ValidateToWalletErrorMessage())
            Assert.fail("To Wallet Field Cant Be Empty");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Clicking on transfer button with out filling any field")
    public void ClickOnTransferButtonWithOutSelectingRequiredFields() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnTransferButton();
        if (!billingPage.ValidateTransferWalletErrorPopUp())
            Assert.fail("Required Fields Cant Be Empty");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Clicking on transfer button without filling amount field")
    public void ClickOnTransferButtonWithOutFillingAmountField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTransferIcon();
        billingPage.ClickOnFromWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(2);
        billingPage.ClickOnToWallet();
        billingPage.SelectingDesiredWalletFromWalletDropdown(3);
        billingPage.EnterDataInDescriptionField("QA Testing");
        billingPage.ClickOnTransferButton();
        if (!billingPage.ValidateTopUpAmountErrorMessage())
            Assert.fail("Amount Field Cant Be Empty");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page")
    @Story("This flow belongs to Multi Wallet")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Deletion of default campaign type selected while editing a wallet")
    public void DeleteDefaultCampaignTypeSelectedWhileEditWallet() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnMultiWalletEditIcon();
        if (!billingPage.ValidatingDeletionOfDefaultCampaignTypeSelectedWhileEditingWallet())
            Assert.fail("Default Campaign Type Options Cant Be Deleted");
    }


    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Enter Spaces as Input Field of wallet name")
    public void EnterSpacesAsInputFieldOfWalletName() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.ClickOnCreateNewWallet();
        billingPage.EnterDataInWalletNameField("         ");
        billingPage.ClickOnCampaignTypeField();
        billingPage.SelectDesiredOptionFromCampaignTypeDropdown(1);
        billingPage.ClickOnCreateWalletButton();
        if (!billingPage.ValidateWalletCreationWithSpacesInWalletName())
            Assert.fail("Wallet Created successfully");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create wallet with empty wallet name ")
    public void CreateWalletWithEmptyWalletName() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.ClickOnCreateNewWallet();
        billingPage.ClickOnCampaignTypeField();
        billingPage.SelectDesiredOptionFromCampaignTypeDropdown(1);
        billingPage.ClickOnCreateWalletButton();
        if (!billingPage.ValidateWalletCreationWithEmptyWalletName())
            Assert.fail("Wallet Created successfully");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Enter more than 20 characters in  wallet name")
    public void EnterMoreThan20CharactersInWalletName() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.ClickOnCreateNewWallet();
        billingPage.EnterDataInWalletNameField("aasdfghjklasdfghjklasdfghjkasdfghjkl");
        billingPage.ClickOnCampaignTypeField();
        billingPage.SelectDesiredOptionFromCampaignTypeDropdown(1);
        billingPage.ClickOnCreateWalletButton();
        if (billingPage.ValidateWalletCreationWithMoreThan20CharactersInWalletName())
            Assert.fail("More than 20 characters in Wallet name");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create wallet without choosing campaign type ")
    public void CreateWalletWithEmptyCampaignTypeField() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.ClickOnCreateNewWallet();
        billingPage.EnterDataInWalletNameField("Testing16");
        billingPage.ClickOnCreateWalletButton();
        if (!billingPage.ValidateWalletCreationWithEmptyCampaignType())
            Assert.fail("Wallet Created successfully");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Create duplicate wallet with same config and name ")
    public void CreateDuplicateWalletWithSameNameAndConfig() throws InterruptedException {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnChooseWalletField();
        billingPage.ClickOnCreateNewWallet();
        billingPage.EnterDataInWalletNameField("Testing15");
        billingPage.ClickOnCampaignTypeField();
        billingPage.SelectDesiredOptionFromCampaignTypeDropdown(1);
        billingPage.ClickOnCreateWalletButton();
        if (!billingPage.ValidateDuplicateWalletCreationWithSameConfigAndName()) {
            Assert.fail("Wallet created successfully");
        }
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Click on apply button without selecting any option in add filter ")
    public void ClickOnApplyWithoutSelectingAnyOptionInCampaignType() throws InterruptedException {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnAddFilter();
        billingPage.ClickOnApplyButtonInAddFilter();
        if (!billingPage.ValidateApplyButtonWithoutSelectingAnyOption())
            Assert.fail("Filter should not be added");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Click on apply button without selecting  any option in add filter in transaction log  ")
    public void ClickOnApplyWithoutSelectingAnyOptionInTransactionLog() throws InterruptedException {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        billingPage.ClickOnManageWallet();
        billingPage.ClickOnTransactionLogTab();
        billingPage.ClickOnAddFilter();
        billingPage.ClickOnApplyButtonInAddFilter();
        if (!billingPage.ValidateApplyButtonWithoutSelectingAnyOption())
            Assert.fail("Filter should not be added");
    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Selecting transaction log by applying filters")
    public void ApplyFilterInTransactionLogTab() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnTransactionLogTab();
        billingPage.ClickOnAddFilter();
        billingPage.ClickOnTransactionDetailsFieldInTransactionLog();
        billingPage.EnterDataInTransactionDetailsInputFieldInTransactionLog("Date");
        billingPage.SelectDesiredOptionFromTransactionDetailsDropdown(1);
        billingPage.ClickOnConditionFieldInTransactionLog();
        billingPage.SelectDesiredOptionFromTransactionConditionDropdown(2);
        billingPage.ClickOnTransactionLogFSelectDateField();
        billingPage.SelectDesiredDayFromTransactionDayRange(4);
        billingPage.ClickOnTransactionLogHourField();
        billingPage.SelectDesiredHourFromTransactionHourDropdown(2);
        billingPage.ClickOnTransactionLogMinutesField();
        billingPage.SelectDesiredMinutesFromTransactionMinutesDropdown(2);
        billingPage.ClickOnTransactionLogDateAndTimeCancelButton();
        billingPage.ClickOnTransactionLogFSelectDateField();
        billingPage.ClickOnTransactionLogMonthField();
        billingPage.SelectDesiredMonthFromTransactionMonthDropdown(12);
        billingPage.ClickOnTransactionLogYearField();
        if (billingPage.SelectDesiredYearFromTransactionYearDropdown(2023))
            Assert.fail("Date cant be less then 1990");
        billingPage.SelectDesiredDayFromTransactionDayRange(4);
        billingPage.ClickOnTransactionLogDateAndTimeApplyButton();
        billingPage.ClickOnWalletFilterApplyButton();
//        billingPage.EnterDataInputFieldInTransactionLog("200");
//        billingPage.ClickOnTransactionLogFilterApplyButton();


    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Clicking on apply button with out selecting any option in transaction log")
    public void ClickOnApplyButtonWithOutSelectingAnyOptionInTransactionLog() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnTransactionLogTab();
        billingPage.ClickOnAddFilter();
        billingPage.ClickOnWalletFilterApplyButton();
        if (!billingPage.ValidateTransactionLogApplyButtonWithOutSelectingAnyOptions())
            Assert.fail("Fields Cant Be Empty");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Selecting Campaign type by applying filters")
    public void ApplyFiltersInCampaignTypeTab() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnCampaignTypeTab();
        billingPage.ClickOnWalletTableRefreshIcon();
        billingPage.ClickOnAddFilter();
        billingPage.ClickOnCampaignTypeFieldInCampaignType();
        billingPage.SelectDesiredOptionsFromCampaignTypeDropdown(2);
        billingPage.ClickOnConditionFieldInCampaignType();
        billingPage.SelectDesiredOptionFromCampaignTypeConditionDropdown(2);
        billingPage.EnterDataInputFieldInCampaignType("300");
        billingPage.ClickOnWalletFilterApplyButton();
        billingPage.ClickOnAddOrRemoveColumns();
        billingPage.EnterDataInSearchFieldInAddOrRemoveColumns("");
        billingPage.SelectOrDeselectDesiredOptionFromAddOrRemoveColumns(1);
        billingPage.SelectOrDeselectDesiredOptionFromAddOrRemoveColumns(1);


    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Clicking on apply button with out selecting any option in campaign type")
    public void ClickOnApplyButtonWithOutSelectingAnyOptionInCampaignType() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnCampaignTypeTab();
        billingPage.ClickOnAddFilter();
        billingPage.ClickOnWalletFilterApplyButton();
        if (!billingPage.ValidateCampaignTypeApplyButtonWithOutSelectingAnyOptions())
            Assert.fail("Fields Cant Be Empty");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Apply filter in wallet tab")
    public void ApplyFilterInWalletTab() throws InterruptedException {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTypeTab();
        billingPage.ClickOnAddFilter();
        billingPage.ClickOnWalletFieldInWalletTab();
        billingPage.SelectDesiredOptionsFromWalletDropdown(3);
        billingPage.ClickOnConditionFieldInWallet();
        billingPage.EnterDataInConditionInputFieldInWallet("less");
        billingPage.SelectDesiredOptionFromWalletConditionDropdown(1);
        billingPage.EnterDataInputFieldInWallet("300");
        billingPage.ClickOnWalletFilterApplyButton();

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Clicking on apply button with out selecting any option in wallet tab")
    public void ClickOnApplyButtonWithOutSelectingAnyOptionInWalletTab() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        billingPage.ClickOnManageWallet();
        billingPage.ClickOnWalletTypeTab();
        billingPage.ClickOnAddFilter();
        billingPage.ClickOnWalletFilterApplyButton();
        if (!billingPage.ValidateWalletTabApplyButtonWithOutSelectingAnyOptions())
            Assert.fail("Fields Cant Be Empty");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Selecting a wallet which is not available for awareness guaranteed campaign")
    public void SelectSPAWalletsWhileAwarenessGuaranteedCampaignCreation() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        awarenessPage.ClickingOnAwarenessDashBoard();
        awarenessPage.ClickOnCreateCampaignButton();
        awarenessPage.ClickingOnGuaranteedCampaignsImpressions();
        performancePage.ClickingNextStepButton();
        awarenessPage.RenameCampaignName();
        awarenessPage.ClickingOnGuaranteedCampaignSelectPageTypeField();
        awarenessPage.EnteringDataInGuaranteedCampaignSelectPageTypeField("Home");
        awarenessPage.ClickingOnGuaranteedCampaignSelectPageTypeFieldDropDown();
        awarenessPage.ClickingOnGuaranteedCampaignSelectDateButton();
        if (awarenessPage.ClickingOnGuaranteedCampaignsMonthNextNavigator(awarenessPage.ReturnNextMonth(1))) {
            Assert.fail("Only two months ahead can be selected");
        }
        awarenessPage.ClickingOnGuaranteedCampaignAvailableDateInSelectDate("09", 1);
        awarenessPage.ClickingOnGuaranteedCampaignAddInventoryButton();
        awarenessPage.ClickingOnGuaranteedCampaignPayNowButton();
        billingPage.ClickOnAwarenessCampaignWalletSelectionField();
        billingPage.EnterDataInAwarenessCampaignWalletInputField("SPA Wallet ");
        if (billingPage.ValidateDisabledWalletsInAwarenessCampaign("SPA Wallet"))
            Assert.fail("Performance Wallet Can be Used in Awareness");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test: Selecting a wallet which is not available for awareness guaranteed campaign")
    public void SelectSPAWalletsWhileAwarenessAuctionCampaignCreation() throws InterruptedException {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);
        awarenessPage.ClickingOnAwarenessDashBoard();
        awarenessPage.ClickOnCreateCampaignButton();
        billingPage.ClickNextStepButton();
        billingPage.ClickOnSelectPageButton();
        billingPage.SelectHomePage();
        awarenessPage.ClickDoneButton();
        awarenessPage.SelectInventory();
        billingPage.ClickNextButton();
        awarenessPage.ClickTargetingSaveButton();
        awarenessPage.ClickingCampaignCreativeNewAdButton();
        billingPage.AddNameToAdName();
        billingPage.AddNameHeadLineField();
        billingPage.ClickAdSaveButton();
        awarenessPage.ClickingSaveButton();
        performancePage.ClickOnStartDateField();
        performancePage.DateSelector("August", "2024", "10");
        performancePage.ClickOnEndDateField();
        performancePage.DateSelector("September", "2024", "30");
        awarenessPage.AddValueInBiddableCPMField("20");
        awarenessPage.AddValueInDailyBudgetField("40");
        billingPage.ClickOnAwarenessCampaignWalletSelectionField();
        billingPage.EnterDataInAwarenessCampaignWalletInputField("SPA Wallet ");
        if (billingPage.ValidateDisabledWalletsInAwarenessCampaign("SPA Wallet"))
            Assert.fail("Performance Wallet Can be Used in Awareness");

    }

    @Epic("Seller Dashboard")
    @Feature("Billing Page ")
    @Story("This flow belongs to Multi Wallet ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Test:  Selecting a wallet which is not available for performance campaign")
    public void SelectSDAWalletsWhilePerformanceCampaignCreation() {
        billingPage.ClickOnSellerChooseField();
        billingPage.SelectDesiredSeller(2);

        awarenessPage.ClickOnCreateCampaignButton();
        performancePage.EnterDailyBudgetPrice("10");
        billingPage.ClickOnPerformanceCampaignWalletSelectionField();
        billingPage.EnterDataInPerformanceCampaignWalletInputField("SPA Wallet");
        billingPage.ClickOnPerformanceCampaignWalletSelectionField();
        billingPage.EnterDataInPerformanceCampaignWalletInputField("SDA Wallet");
        if (billingPage.ValidateDisabledWalletsInPerformanceCampaign("SDA Wallet"))
            Assert.fail("Awareness Wallet Can be Used in Performance");

    }

}

