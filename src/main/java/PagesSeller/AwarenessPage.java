package PagesSeller;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AwarenessPage {

    WebDriver driver;
    WebDriverWait wait;
    private PerformancePage performancePage;

    public AwarenessPage(WebDriver driver) {
        performancePage = new PerformancePage(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By WhiteLoader = By.xpath("//div[contains(@class,'loader-wrapper white-loader')]");
    final By ButtonSpinner = By.xpath("//i[contains(@class,'icon-spinner')]");

    final By NoOptionSelectedErrorMsg = By.xpath("//div[contains(@class,'pendo-track-import-geo-settings-modal error-msg')]");
    final By NoOptionSelectedErrorMsgWhileExporting = By.xpath("(//div[contains(@class,'error-msg name-error-message')])[2]");
    final By GeoLocationTargeting = By.xpath("//div[contains(@class,'pendo-track-geo-targeting-setting-card')]");
    final By GeoLocationUpdateMsg = By.xpath("//div[contains(@class,'pendo-track-geo-location-details-updated-successfully')]");
    final By ErrorMessageInvalidQAFullFledgeCreativeAdUrlField = By.xpath("//div[contains(@class,'pendo-track-common-error-for-invalid-url')]");
    final By ErrorMessageSpacesInBetweenQAFullFledgeCreativeAdUrlField = By.xpath("//div[contains(@class,'pendo-track-click-url-regex-error-with-spaces')]");
    final By TopUpErrorMessage = By.xpath("//div[contains(@class,'error-msg name-error-message')]");
    final String AwarenessCampaignCreateAdCarouselCTAFieldDropDown = "(//div[contains(@class,'pendo-track-creative-form-carousel-')]/descendant::div[contains(@id,'-option-')])[%d]";
    final String AwarenessCampaignCreateAdCarouselTextField = "//div[contains(@class,'pendo-track-creative-form-carousel-%d-text-1')]/descendant::input";
    final String AwarenessCampaignCreateAdCarouselCTAField = "//div[contains(@class,'pendo-track-creative-form-carousel-%d-cta-1')]/descendant::div[contains(@class,'os-select-dropdown')]";
    final By QAFullFledgeFormatCreativeAdTextComponentField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-text-component')]/descendant::input");
    final By QAFullFledgeFormatCreativeAdUrlField = By.xpath("//div[contains(@class,'pendo-track-creative-form-group-url')]/descendant::textarea");
    final By IncludedLocationCheckBox = By.xpath("//div[contains(@class,'pendo-track-geo-location-import-included')] | //div[contains(@class, 'pendo-track-geo-location-included')]");
    final By AudienceNameField = By.xpath("//div[contains(@class,'pendo-track-audience-name-input')]/descendant::input | (//div[contains(@class,'input-wrapper')]/child::input[@class='form-control simple-input '])[2]");
    final By SearchAudienceField = By.xpath("//div[contains(@class,'pendo-track-create-audience-search-audience-name')]");
    final By ProductCategoryField = By.xpath("//div[contains(@class,'pendo-track-audience-product-category-dropdown search-enabled')]");
    final By ErrorMessageForNotChoosingAnyOption = By.xpath("//div[contains(@class,'pendo-track-campaign-auction-select-native-marketplace-empty')]");
    final By ErrorMessageForNotChoosingAnyPage = By.xpath("//div[contains(@class,'pendo-track-campaign-auction-select-page-empty')]");
    final By ErrorMessageForNotChoosingAnyInventory = By.xpath("//div[contains(@class,'pendo-track-campaign-auction-select-inventory-empty')]");
    final By MaximumLocationSelectionErrorMsg = By.xpath("//div[contains(@class,'pendo-track-auction-geo-location-max-locations')]");
    final By ImportLocationSuccessMsg = By.xpath("//div[contains(@class,'pendo-track-geo-location-details-imported-successfully')]");
    final By SuccessfulExportMsg = By.xpath("//div[contains(@class,'pendo-track-geo-location-details-exported-successfully')]");
    final By GuaranteedCampaignSelectPageTypeErrorPopUp = By.xpath("//div[contains(@class,'pendo-track-guaranteed-campaign-select-one-inventory')]");
    final By GuaranteedCampaignSelectDataErrorPopUp = By.xpath("//div[contains(@class,'pendo-track-guaranteed-campaign-select-one-date-inventory')]");
    final By ErrorMessageAddSpecialCharactersInKeywords = By.xpath("//div[contains(@class,'pendo-track-keywords-count-failed')]");
    final By ErrorMessageClickSaveWithEmptyFieldInProductCatalogTargeting = By.xpath("//div[contains(@class,'pendo-track-product-catalog-invalid-configuration-error')]");
    final By ApplyInDeviceTargeting = By.xpath("//button[contains(@class,'pendo-track-device-targeting-drawer-save-button')]");
    final By ApplyInDeviceTargetingDisabled = By.xpath("//button[contains(@class,'pendo-track-device-targeting-drawer-save-button') and contains(@class,'disabled')]");
    final String CheckBoxesForKeywordsInKeywordTargeting = ("//label[contains(@class,'pendo-track-keyword-row-selection-checkbox')]");
    final By RemoveButtonForRemovingSelectedKeywords = By.xpath("//button[contains(@class,'pendo-track-auction-keywords-remove-button')]");
    final By MediaEstimatorTotalBudgetFieldEditIcon = By.xpath("//span[@class='icon icon-edit1 pendo_feature_media_estimator_total_budget_edit']");
    final By MediaEstimatorTotalBudgetField = By.xpath("//div[contains(@class,'pendo-track-media-estimator-total-budget-input')]/descendant::input");
    final By DeleteKeywordIcon = By.xpath("//div[contains(@class,'Select__multi-value__remove')]");
    final By AddDesiredValueButton = By.xpath("//div[contains(@class,'Select__option Select__option--is-focused')]");
    final String ProductCategoryOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final String BrandOptions = ("(//div[contains(@class,'Select__option')])[%d]");
    final String Options = ("(//div[contains(@class,'Select__option')])[%d]");
    final By CatalogCategoryTypeDropdown = By.xpath("//div[@class='filters-options']/descendant::div[contains(@class,'Select__dropdown-indicator')]");
    final By ConditionTypeDropdown = By.xpath("//div[@class='filter-conditions']/descendant::div[contains(@class,'Select__dropdown-indicator')]");
    final By SecondRowConditionTypeDropdown = By.xpath("(//div[@class='filter-conditions']/descendant::div[contains(@class,'Select__dropdown-indicator')])[2]");
    final By BrandTypeDropdown = By.xpath("//div[@class='dropdown-filter-container']/descendant::div[contains(@class,'Select__dropdown-indicator')][3]");
    final String DesiredAttributeInBrandTypeDropdown = ("(//div[contains(@class,'Select__option ')])[%d]");
    final By SearchDeviceField = By.xpath("//div[@class='dropdown-outer-wrapper']");
    final By AttributeDropdownInCustomTargeting = By.xpath("//div[@class='filters-options']");
    final By ValueDropdownInCustomTargeting = By.xpath("//div[@class='filter-values']");
    final By GuaranteedCampaignsImpressions = By.xpath("//span[contains(@class,'pendo-track-guaranteed-impressions-campaign')]");
    final By AwarenessNextButton = By.xpath("//button[contains(@class,'pendo-track-campaign-consideration-wrapper-save-button')]");
    final By GuaranteedNextButton = By.xpath("//button[contains(@class,'pendo-track-guraranteed-campaign-next-button')]");
    final By AwarenessDashboard = By.xpath("//span[contains(@class,'pendo-track-dashboard-tab-inventory')]");
    final By GuaranteedCampaignSelectPageTypeField = By.xpath("//div[contains(@class,'pendo-track-campaign-guaranteed-page-type-dropdown')]");
    final By GuaranteedCampaignSelectPageTypeInputFieldDropdown = By.xpath("//div[contains(@class,'Select__option--is-focused')]");
    final String GuaranteedCampaignAvailableDate = "(//div[contains(@class,'cell      2024-%s-')])[%d]";
    final By GuaranteedCampaignSelectDate = By.xpath("//button[contains(@class,'pendo-track-campaign-guraranteed-select-dates-button')]");
    final By GuaranteedCampaignAddInventoryButton = By.xpath("//button[contains(@class,'pendo-track-select-dates-add-inventory-button')]");
    final By GuaranteedCampaignPayNowButton = By.xpath("//button[contains(@class,'pendo-track-campaign-guraranteed-pay-now-button')]");
    final By GuaranteedCampaignPayLaterButton = By.xpath("//button[contains(@class,'pendo-track-campaign-guraranteed-pay-later-button')]");
    final By GuaranteedCampaignPayLaterInactiveButton = By.xpath("//button[contains(@class,'button-primary shape-cornor medium disabled') and (contains(@class,'outline'))]");
    final By GuaranteedCampaignPayLaterOkButton = By.xpath("//button[contains(@class,'pendo-track-campaign-guraranteed-pay-later-modal-okay-button')]");
    final By GuaranteedCampaignInactivePayNowButton = By.xpath("//button[contains(@class,'button-primary shape-cornor medium disabled') and not(contains(@class,'outline'))]");
    final By AwarenessCampaignCreativesNewAd = By.xpath("//span[@class='upload-img icon icon-plus creative-line']");
    final By AwarenessCampaignCreativesNewAdName = By.xpath("//div[contains(@class,'pendo-track-ad-name-input')]/descendant::input");
    final By AwarenessCampaignCreativesNewAdLeftImageField = By.xpath("(//input[@type='file'])[1]");
    final By AwarenessCampaignCreativesNewAdRightImageField = By.xpath("(//input[@type='file'])[2]");
    final By AwarenessCampaignCreativesNewAdSaveButton = By.xpath("//button[contains(@class,'pendo-track-creative-upload-drawer-wrapper-save-button')]");
    final By GuaranteedCampaignCreativesNewAdSaveButton = By.xpath("//button[contains(@class,'pendo-track-guaranteed-creative-upload-drawer-wrapper-save-button')]");
    final String QAFullFledgeFormat = "//div[contains(@class,'pendo-track-creative-tab-menu-qa-full-fledge')]";
    final By AwarenessCampaignCreateAdCarouselAddIcon = By.xpath("//i[@class='icon icon-add-plus']");
    final String AwarenessCampaignCreateAdCarouselDeleteIcon = "(//div[@class='delete-link'])[%d]";
    final By AwarenessCampaignCreateAdCarouselDeleteIconConfirmation = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final String AwarenessCampaignCreateAdCarouselCreativeCount = "(//div[@class='creative-count'])[%d]";
    final By GuaranteedCampaignSendForReviewButton = By.xpath("//button[contains(@class,'pendo-track-campaign-guraranteed-pay-now-button')] | //button[contains(@class,'pendo-track-guraranteed-campaign-send-for-review-button')]");
    final By QAFullFledgeFormatCreativeAdAddProductButton = By.xpath("//button[contains(@class,'pendo_feature_add_product')]");
    final By QAFullFledgeFormatCreativeAdAddProductAddButton = By.xpath("//button[contains(@class,'pendo_feature_onSave_dynamic_sku_selection button')]");
    final By GuaranteedCampaignMonthNextNavigator = By.xpath("//div[@class='next-button ']");
    final By GuaranteedCampaignMonthTitle = By.xpath("//div[@class='month-title']");
    final String AwarenessCampaignCreateAdIndividualProductCheckBox = "(//label[contains(@class,'pendo-track-sku-selection-table-row-selection-checkbox')])[%d]";
    final By GuaranteedCampaignsDay = By.xpath("//span[contains(@class,'pendo-track-guaranteed-cpd-campaign-type-indicator')]");
    final By SelectPageButton = By.xpath("//button[contains(@class,'pendo-track-auction-select-page-button')]");
    final String SelectDesiredPage = ("//span[text()='QA Page 1'] | //font[text()='क्यूए पेज 1'] ");
    final By DoneButton = By.xpath("//button[contains(@class,'pendo-track-auction-page-selection-drawer-save-button')]");
    final By SelectionOfInventory = By.xpath("//button[contains(@class,'pendo-track-inventory-selection-select-button')]");
    final By InventorySaveButton = By.xpath("//button[contains(@class,'pendo-track-auction-inventory-save-button')]");
    final By KeywordTargeting = By.xpath("//div[contains(@class,'pendo-track-keyword-targeting-setting-card')]");
    final By KeywordTargetingDivisionBox = By.xpath("(//div[@class='fade tab-pane active show' and @aria-hidden='false'])[1]");
    final By AudienceTargeting = By.xpath("//div[contains(@class,'pendo-track-audience-targeting-setting-card')]");
    final By ProductCatalogTargeting = By.xpath("//div[contains(@class,'pendo-track-product-catalog-targeting-setting-card')]/span");
    final By AddKeywordButton = By.xpath("//button[contains(@class,'pendo_feature_track-inventory-keyword-bidding-outer-add-new-keywords button')]");
    final By SaveKeywordButton = By.xpath("//button[contains(@class,'pendo_feature_track-inventory-keyword-bidding-inner-save-btn-text')]");
    final By SaveKeywordButtonDisabled = By.xpath("//button[contains(@class,'pendo_feature_track-inventory-keyword-bidding-inner-save-btn') and contains(@class,'disabled')]");
    final By SaveAddedKeywords = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-positve-apply-btn')]");
    final By SaveAddedKeywordsDisabled = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-positve-apply-btn') and contains(@class,'disabled')]");
    final By SaveTargetingButton = By.xpath("//button[contains(@class,'pendo_feature_targetting_save_button')]");
    final By InActiveSaveButton = By.xpath("//button[contains(@class,'pendo_feature_track-keyword-bidding-positve-apply-btn')]");
    final By AuctionQAFullFledgeFormat = By.xpath("//div[contains(@class,'pendo-track-creative-tab-menu-qa-full-fledge')]");
    final By CreativeLibraryUploadImageButton = By.xpath("(//div[@class='creative-actionbtn']/child::div[@class='creative-line action-icons icon icon-upload-library'])[2]");
    final By SelectImageFromCreativeLibrary = By.xpath("(//div[@class='media-list-mosaic-view-container']/descendant::div[contains(@class,'media-item card-uneven-inner')])[1]");
    final By ChooseImageButton = By.xpath("//button[contains(@class,'pendo_feature_media_library_save_button')]");
    final By SaveCampaignFormatButton = By.xpath("//button[contains(@class,'pendo-track-auction-campaign-ads-save-button')]");
    final By BiddableCPMField = By.xpath("//div[contains(@class,'pendo-track-auction-campaign-biddable-cpm-input')]");
    final By BiddableCPMFieldTemp = By.xpath("(//span[@class='form-control fake-input'])[1]");
    final By DailyBudgetField = By.xpath("//div[contains(@class,'pendo-track-auction-campaign-daily-budget-input')]");
    final By DailyBudgetFieldTemp = By.xpath("(//span[@class='form-control fake-input'])[1]");
    final By SubmitForReviewButton = By.xpath("// button[contains(@class,'button os-button  button-primary shape-cornor medium')]/span[contains(text(),'Submit for review')]");
    final By NativeAdsRadioButton = By.xpath("(//span[contains(@class,'icon status-icon icon')])[1]");
    final By AudienceNetworkAdsRadioButton = By.xpath("(//span[contains(@class,'icon status-icon icon')])[2]");
    final By IncludedLocation = By.xpath("//div[contains(@class,'pendo-track-geo-location-include-dropdown-wrapper')] ");
    final By IncludedLocationField = By.xpath("//div[contains(@class,'pendo-track-geo-location-include-dropdown')]/descendant::input");
    final By ExcludedLocationField = By.xpath("//div[contains(@class,'pendo-track-geo-location-exclude-dropdown')]/descendant::input");
    final By ExcludedLocation = By.xpath("//div[contains(@class,'pendo-track-geo-location-exclude-dropdown-wrapper')]");
    final String LocationCheckBoxes = "(//label[contains(@class,'os-custom-checkbox-label')])[%d]";
    final By LocationApplyButton = By.xpath("//button[contains(@class,'pendo-track-geo-targeting-drawer-save-button')]");
    final By LocationApplyButtonDisabled = By.xpath("//button[contains(@class,'pendo-track-geo-targeting-drawer-save-button') and contains(@class,'disabled')]");
    final By TargetingCandySelectedLocationCount = By.xpath("(//div[contains(@class,'pendo-track-geo-targeting-setting-card')]/descendant::div[@class='tab-subtext ellipsis-text'])[1]");
    final By ResetLocationField = By.xpath("//div[contains(@class,'title')]/following-sibling::a");
    final By ResetLocationConfirmationButton = By.xpath("//button[contains(@class,'button pendo_feature_confirmation_modal_action_btn')]/span[contains(text(),'Yes')]");
    final By SameLocationSelectionErrorMsg = By.xpath("//div[contains(@class,'pendo-track-auction-geo-location-already-included-in-targeted-locations')]");
    final By CrossIconToDeleteSelectedLocations = By.xpath("//i[@class='remove-pill icon icon-close1']");
    final By AllLocationSelected = By.xpath("//div[@class='pill-list all-ld-pill-wrapper']");
    final By SelectedLocations = By.xpath("//div[@class='pill-list ld-pill-wrapper']");
    final By ImportButton = By.id("file");
    final By ContinueButton = By.xpath("//button[contains(@class,'button os-button  button-primary shape-cornor')]/span[contains(text(),'Continue')]");
    final By ExportButton = By.xpath("//button[@class='button os-button pendo_feature_geo_settings_export button-primary shape-cornor medium   outline    ']");
    final By ExportSelectedLocationButton = By.xpath(" //button[contains(@class,'pendo-track-geo-location-export-modal-cta')]");
    final By EmptyFileNameErrorMsg = By.xpath("//div[contains(@class,'pendo-track-geo-lcation-export-file-error-input')]");
    final By NoOptionSelectedErrorMessage = By.xpath("//div[contains(@class,'error-msg name-error-message')]");
    final By ErrorMsgUploadingInvalidFile = By.xpath("//div[contains(@class,'pendo-track-geo-location-details-user-error')] | //div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By ExcludedLocationCheckBox = By.xpath("//div[contains(@class,'pendo-track-geo-location-import-excluded')] | //div[contains(@class, 'pendo-track-geo-location-excluded')]");
    final By ExportFileNameField = By.xpath("//div[contains(@class,'pendo-track-geo-lcation-export-file-name-input')]/input");
    final By SpaceInFileNameErrorMsg = By.xpath("//div[contains(@class,'pendo-track-geo-lcation-export-file-error-input')]");
    final By DisabledExportButton = By.xpath("//button[@class='button os-button pendo_feature_geo_settings_export disabled button-primary shape-cornor medium   outline    ']");
    final By GuaranteedCampaignImpressionsInactiveField = By.xpath("//span[@class='form-control fake-input']");
    final By GuaranteedCampaignCreativeAdMediaLibraryFilterButton = By.xpath("//button[contains(@class,'button os-button os-filter-btn pendo_feature_media_library_filter')]");
    final String AwarenessMediaLibraryGenericFilterOptions = "(//span[@class='title-name-container'])[%d]";
    final String AwarenessMediaLibraryTypeGenericOptions = "(//div[contains(@class,'fade filters-popover')]/descendant::div[contains(@class,'tab-pane active show')]/descendant::label[contains(@class,'radio-label')])[%d]";
    final By AwarenessMediaLibraryFilterApplyButton = By.xpath("//button[contains(@class,'button os-button pendo_feature_global_filter_apply button-primary')]");
    final String AwarenessMediaLibraryImageSelection = "(//img[@class='os-async-img-container__'])[%d]";
    final By AwarenessMediaLibraryChooseButton = By.xpath("//button[contains(@class,'button os-button pendo_feature_media_library_save_button')]");
    final By AwarenessMediaLibraryChooseTypeErrorPopUp = By.xpath("//div[contains(@class,'pendo-track-media-library-wrong-file-format-selected')]");
    final By AwarenessMediaLibraryMediaTikMark = By.xpath("//div[@class='plan-select icon-check ']");
    final By GuaranteedCampaignCreativeAdMoreThenMaximumVideoErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By GuaranteedCampaignCreativeAdInvalidFileWithVideoExtensionErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By GuaranteedCampaignCreativeVideoInvalidFormatErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By GuaranteedCampaignCreativeVideoInvalidImageDimensionsErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By GuaranteedCampaignCreativeAdInvalidFileWithImageExtensionErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By GuaranteedCampaignCreativeVideoInvalidVideoDimensionsErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By GuaranteedCampaignCreativeImageInvalidFormatErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final String GenericCreativeLibraryUploadButton = "(//div[@class='creative-actionbtn']/child::div[@class='creative-line action-icons icon icon-upload-library'])[%d]";
    final By Creatives = By.xpath("//span[@class='tab-icon icon icon-banner-ads-o']");
    final By ErrorMessageOfImage = By.xpath("(//div[@class='error-msg'])[2]");
    final By ErrorMessageOfLessThanMinSize = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By ErrorMessageOfLessThanMaxSize = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By AddTracker = By.xpath("//button[contains(@class,'pendo_track_feature_ad_tracker_button')]");
    final By DcmUrlField = By.xpath("(//div[contains(@class,'pendo-track-creative-form-group-third_party_tags')]/descendant::textarea)[1]");
    final By DcmScriptField = By.xpath("(//div[contains(@class,'pendo-track-creative-form-group-third_party_tags')]/descendant::textarea)[2]");
    final By DcmImageField = By.xpath("(//div[contains(@class,'pendo-track-creative-form-group-third_party_tags')]/descendant::textarea)[3]");
    final By ErrorMessageOfEmptyScriptField = By.xpath("//div[contains(@class,'pendo-track-dcm-impression-script-url-error')]");
    final By ErrorMessageOfInvalidScriptTag = By.xpath("//div[contains(@class,'pendo-track-dcm-impression-script-url-invalid')]");
    final By ErrorMessageEmptyImageTagField = By.xpath("//div[contains(@class,'pendo-track-dcm-impression-image-url-error')]");
    final By ErrorMessageMinTwoProductsRequired = By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--error']");
    final By ErrorMessageOfInvalidImageTag = By.xpath("//div[contains(@class,'pendo-track-dcm-impression-image-url-error')]");
    final By ErrorMessageMaxFiveProductsAllowed = By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--error']");
    final By ErrorMessageUploadCreatives = By.xpath("//div[@class='Toastify__toast Toastify__toast-theme--colored Toastify__toast--error']");
    final By ErrorMessageEmptyURLField = By.xpath("//div[contains(@class,'pendo-track-dcm-click-tracker-url-error')]");
    final By ErrorMessageOfInvalidURL = By.xpath("//div[contains(@class,'pendo-track-dcm-click-tracker-url-error')]");
    final By ErrorMessageEmptyQAFullFledgeCreativeAdUrlField = By.xpath("//div[contains(@class,'pendo-track-creative-form-error-group-url')]");
    final By CreativeAdDuplicateIcon = By.xpath("//div[contains(@class,'pendo-track-auction-camaping-creative-ad-duplicate')]");
    final By CreativeAdDuplicateConfirmationButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By CreativeAdEditIcon = By.xpath("//div[contains(@class,'pendo-track-auction-camaping-creative-ad-edit-view')]");
    final By CreativeAdDuplicateCancelButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_right_btn')]");
    final By CreativeAdDeleteIcon = By.xpath("(//div[contains(@class,'pendo-track-auction-camaping-creative-ad-delete')])[1]");
    final By CreativeAdDeleteConfirmationButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By CreativesCreatedAd = By.xpath("(//div[@class='creative-isdevice'])[2]");
    final By CreativesCreatedAdCount = By.xpath("//div[contains(@class,' pendo-track-creative-tab-menu-qa-full-fledge')]/span[2]");
    final By WalletBalanceTopUpButton = By.xpath("//div[@class='purge-ignore-wallet-balance-block']/button");
    final By TopUpAmountField = By.xpath("//span[@class='currency-symbol d-align-center']/following-sibling::div/input");
    final By TopUpButton = By.xpath("//button[contains(@class,'button os-button pendo_feature_topup_button ')]");
    final By CarouselAlertPopUp = By.xpath("//div[@class='modal-header']");
    final By SelectedInventoryDeleteButton = By.xpath("//span[contains(@class,'delete-btn')]");
    final By SelectedInventoryDeleteConfirmationButton = By.xpath("//button[contains(@class,'button os-button pendo_feature_confirmation_modal_action_btn')]");
    final By SelectedInventoryFrame = By.xpath("//div[@class='brand-selected-section1']");
    final By InventorySearchField = By.xpath("//div[contains(@class,'pendo-track-guaranteed-campaign-inventory-search')]/input");
    final By InventoryPageResults = By.xpath("//div[@class='inventory-card']");
    final String AwarenessMediaLibraryVideoSelection = "(//div[contains(@class,'video-player-wrapper')])[%d]";
    final By BiddableCpmErrorMessage = By.xpath("//div[contains(@class,'pendo-track-auction-campaign-biddable-cpm-input')]/following-sibling::div[contains(@class,'pendo-track-auction-campaign-biddable-cpm-error')]");
    final By BiddableCPMTextField = By.xpath("//div[contains(@class,'pendo-track-auction-campaign-biddable-cpm-input')]");
    final By DailyBudgetLowerThanBiddableValueError = By.xpath("//div[contains(@class,'pendo-track-auction-campaign-daily-budget-input')]/following-sibling::div[contains(@class,'pendo-track-auction-campaign-daily-budget-error')]");
    final By DailyBudgetEmptyError = By.xpath("//div[contains(@class,'pendo-track-auction-campaign-daily-budget-input')]/following-sibling::div[contains(@class,'pendo-track-auction-campaign-daily-budget-error')]");
    final By CreateNewAudienceButton = By.xpath("//button[contains(@class,'pendo-track-audience-create-new-button')]");
    final By DesiredAudience = By.xpath("(//span[@class='name'])[1]");
    final By AttributeTypeDropdown = By.xpath("//div[@class='filters-options']");
    final By SecondRowAttributeTypeDropdown = By.xpath("(//div[@class='filters-options'])[2]");
    final String AttributeOptions = ("(//div[contains(@class,'Select__menu-list')]/div)[%d]");
    final String ConditionOptions = ("(//div[contains(@id,'-option-')])[%d]");
    final By ValueDropdown = By.xpath("//div[@class='Select__value-container Select__value-container--is-multi css-hlgwow']");
    final By AttributeValueField = By.xpath("//div[@class='filter-values']/descendant::input");
    final String AttributeValueFieldWithValue = ("//div[contains(@class,'Select__multi-value__label')][%d]");
    final By AddAttributeButton = By.xpath("//div[@class='add-new-button']");
    final By AudienceSaveButton = By.xpath("//button[contains(@class,'pendo-track-audience-targeting-custom-new-save-button')]");
    final By AttributeDeleteButton = By.xpath("(//div[@class='delete-row'])[3]");
    final By AudienceCreationSuccessMsg = By.xpath("//div[@class='Toastify__progress-bar Toastify__progress-bar--animated Toastify__progress-bar-theme--colored Toastify__progress-bar--success']");
    final By SelectingSameAudienceDropdownErrorMsg = By.xpath("//div[@class='Toastify__progress-bar Toastify__progress-bar--animated Toastify__progress-bar-theme--colored Toastify__progress-bar--error']");
    final By CrossButtonNearSelectedAudience = By.xpath("//i[@class='remove-pill icon icon-close1']");
    final By EditAudienceButton = By.xpath("//i[@class='edit-icon icon icon-edit1']");
    final By ByUserActivityRadioButton = By.xpath("//label[contains(@class,'pendo_feature_track-custom-audience-by-rfm-radio-selection')]");
    final By ProductCategoryDropdown = By.xpath("//div[contains(@class,'pendo-track-audience-product-category-dropdown')]/child::div[contains(@class,'universal-dd')]");
    final By BrandSelectionDropdown = By.xpath("//div[contains(@class,'pendo-track-audience-brand-dropdown')]/child::div[contains(@class,'universal-dd')]");
    final By UserActionDropdown = By.xpath("//div[contains(@class,'pendo-track-audience-user-action-dropdown')]");
    final By DurationDropdown = By.xpath("//div[contains(@class,'pendo-track-audience-user-recency-dropdown')]");
    final String ActionFrequency = ("(//div[contains(@class,'pendo-track-create-audience-frequecny-pill')]/descendant::span[contains(@class,'pill-children')])[%d]");
    final By ErrorMsgForNotFilingMandatoryDetails = By.xpath("//div[@class='Toastify__progress-bar Toastify__progress-bar--animated Toastify__progress-bar-theme--colored Toastify__progress-bar--error']");
    final By AudienceApplyButton = By.xpath("//button[contains(@class,'pendo-track-audience-targeting-save-button')]");
    final By AudienceApplyButtonDisabled = By.xpath("//button[contains(@class,'pendo-track-audience-targeting-save-button') and contains(@class,'disabled')]");
    final By YesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By AuctionCampaignPriority = By.xpath("//div[contains(@class,'pendo-track-auction-campaign-priority')]");
    final String GenericAuctionCampaignPriorityDropdown = "(//div[contains(@id,'-option-')])[%d]";
    final By AuctionCampaignAdvancedSettingsButton = By.xpath("//div[@class='advance-options-link']/button");
    final By ErrorMessageAddMoreThan50Keywords = By.xpath("//div[contains(@class,'pendo-track-keywords-processed-partially')]");
    final By ErrorMessage = By.xpath("//div[contains(@class,'pendo-track-keywords-count-failed')]");
    final By ErrorMessageForEmptyKeyword = By.xpath("//div[contains(@class,'pendo-track-add-empty-keywords-error')] | //div[contains(@class,'pendo-track-empty-keywords-error')]");
    final By SaveButtonInCustomTargeting = By.xpath("//button[contains(@class,'pendo-track-custom-targeting-save-button')]");
    final By SaveButtonInProductCatalogTargeting = By.xpath("//button[contains(@class,'pendo-track-product-catalog-targeting-save-button')]");
    final By UploadInProductCatalogTargeting = By.xpath("//a[@data-rb-event-key='Upload']");
    final By CrossButtonToDeselectSelectedSkuFile = By.xpath("//span[@class='icon icon-close1 dismiss-icon']");
    final By UploadFileFieldInProductCatalogTargeting = By.xpath("//input[@accept='.tsv']");
    final By UploadSuccessfulMsg = By.xpath("//div[contains(@class,'Toastify__progress-bar Toastify__progress-bar--animated Toastify__progress-bar-theme--colored Toastify__progress-bar--success')]");
    final By ConfirmUploadInProductCatalogTargeting = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By ErrorMessageClickSaveWithEmptyFieldInCatalogTargeting = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By TextBoxAddKeyword = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By AddButtonInProductCatalogTargeting = By.xpath("//div[contains(@class,'add-new-button')]");
    final By FilterRowInProductCatalogTargeting = By.xpath("//div[@class='dropdown-filter-container']");
    final By DeleteButtonInProductCatalogTargeting = By.xpath("(//div[@class='delete-row'])[2]");
    final By DeleteButtonInCustomTargeting = By.xpath("(//div[@class='delete-row'])[2]");
    final By SecondFilterRowInProductCatalogTargeting = By.xpath("(//div[@class='dropdown-filter-container'])[2]");
    final By SampleFileDownload = By.xpath("//a[@class='sample-file-link']");
    final By DeviceTargeting = By.xpath("//div[contains(@class,'pendo-track-device-targeting-setting-card')]");
    final String SelectOptionFromSearchDeviceDropdown = ("(//div[contains(@id,'option-')])[%d]");
    final String DeleteSelectedOption = ("(//i[contains(@class,'remove-pill')])[%d]");
    final By ResetOptionInDeviceTargeting = By.xpath("//div[@class='reset-container']");
    final By ClickYesForResetInDeviceTargeting = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By MessageTargetingOptions = By.xpath("//div[contains(@class,'pendo-track-auction-device-targeting-done-successfully')]");
    final By MessageTargetingOptionsTemp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By CustomTargeting = By.xpath("//div[contains(@class,'pendo-track-custom-targeting-setting-card')]/span");
    final String SelectOptionFromDropdownInCustomTargeting = ("//div[contains(@id,'-option-')][%d]");
    final By AddButtonInCustomTargeting = By.xpath("//div[contains(@class,'pendo-track-custom-targeting-dropdown-filter-add-new-button')]");
    final By ResetOptionInCustomTargeting = By.xpath("//span[contains(@class,'pendo-track-custom-targeting-dropdown-filter-reset-button ')]");
    final By ConfirmResetInCustomTargeting = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By ConfirmRemove = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final String DeleteIconForKeywords = ("(//td[@class='deleteRow']/child::span[contains(@class,'trash-2')])[1]");
    final By SelectHomePage = By.xpath("(//span[text()='Home Page'])[1]");
    final By QAMultiInventoryPage = By.xpath("//div[contains(@id,'QA_PAGE_MULTI_INVENTORY')]");
    final String SelectInventory = ("(//button[contains(@class,'pendo-track-inventory-selection-select-button')])[%d]");
    final By BackButton = By.xpath("//button[contains(@class,'pendo_feature_targetting_back_button')]");
    final String DeleteIconForInventories = ("(//span[contains(@class,'delete-icon')])[%d]");
    final By MediaEstimatorCPMBidEditIcon = By.xpath("//span[contains(@class,'pendo_feature_media_estimator_bid_edit')]");
    final By MediaEstimatorCPMBid = By.xpath("//div[contains(@class,'pendo-track-media-estimator-cpm-input')]/descendant::input");
    final By TargetingOptions = By.xpath("//span[@class='tab-text' and contains(text(),'Targeting')]");
    final By EnterIcon = By.xpath("//span[contains(@class,'icon icon-enter cursor-pointer')]");
    final By InventoryInOverviewPanel = By.xpath("//label[contains(@class,'pendo-track-invenotry-panel-label')]");
    //    final By SelectedInventories = By.xpath("//div[@class='inventory-cta-inner']");
    final By SelectedInventories = By.xpath("//tr[contains(@class,'row-selected')]");
    final String AttributeTypeDropDownField = ("//div[@class='filters-options'][%d]");
    final String ConditionTypeDropDownField = ("//div[@class='filter-conditions'][%d]");
    final String BrandTypeDropDownField = ("//div[@class='filter-values'][%d]");
    final String OptionsInDropDown = ("//div[contains(@id,'-option-')][%d]");
    final By ConfirmInProductCatalogTargeting = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By ClearAllButtonInProductCatalogTargeting = By.xpath("//button[contains(@class,'button clear-all-btn ml-auto button')]/descendant::span");
    final By FilterVerificationText = By.xpath("//div[contains(@class,'pendo-track-product-catalog-targeting')]/descendant::div[@class='tab-subtext ellipsis-text']");
    final By InvalidFileErrorMsg = By.xpath("//div[contains(@class,'pendo-track-prodcut-catalog-file-format-is-inocrrect')]");
    final By ResetSuccessMsg = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By CreativeAdMediaLibraryCloseButton = By.xpath("(//label[contains(@class,'pure-toggle-label icon icon-close1')])[3]"); //changed
    final By ProductsRemoveButton = By.xpath("//button[contains(@class,'remove-sku-btn-snackbar')]"); //changed
    final By ProductsRemoveConfirmationButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]"); //changed
    final By CrossButtonLevel1 = By.xpath("(//label[@class='pure-toggle-label icon icon-close1' and @data-toggle-label='right'])[1]");
    final By CrossButtonLevel2 = By.xpath("(//label[@class='pure-toggle-label icon icon-close1' and @data-toggle-label='right'])[2]");
    final By CrossButtonLevel3 = By.xpath("(//label[@class='pure-toggle-label icon icon-close1' and @data-toggle-label='right'])[3]");
    final By CancelButton = By.xpath("//button[contains(@class,'cancel-btn button')]");
    final By AddKeywordsButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By ConfirmationButtonForAudienceSave = By.xpath("//button[contains(@class,'button pendo_feature_confirmation_modal_action_btn')]");
    final By PayFromWalletBalanceButton = By.xpath("//button[contains(@class,'pendo-track-pay-from-wallet-button button-primary')]");
    final By PayFromWalletBalanceButtonDisabled = By.xpath("//button[contains(@class,'pendo-track-pay-from-wallet-button button-primary') and contains(@class,'disabled')]");
    final By CampaignNameVerificationFirstRow = By.xpath("(//td[contains(@class,'pendo-track-goal-list-table-name')]/descendant::span)[1]");
    final By GuaranteedCampaignTabSwitch = By.xpath("(//div[contains(@class,'pendo_feature_campaign_list_campaign_sub_type_selection_tabs campaign-subtype-selection ')]/div)[2]");
    final String TrackerRemoveButton = "(//div[contains(@class,'pendo_ott_feature_remove_rule_action_button')])[%d]";
    final By GenericPopUpCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button Toastify__close-button--colored')]");
    final By CreativeAdSaveSuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By SuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By DesktopMenuButton = By.xpath("//button[contains(@class,'desktop-menu-config filter-with-drawer-btn')]");
    final By NotificationSettings = By.xpath("(//div[contains(@class,'dropdown-menu show dropdown-menu-right')]/descendant::a)[1]");
    final By AlertsDeliveryEmailIdField = By.xpath("//div[contains(@class,'select-dropdown select-dropdown')]/descendant::div[contains(@class,'Select__placeholder')]");
    final By OwnEmailID = By.xpath("//div[contains(@class,'Select__option')]");
    final By SaveButton = By.xpath("//button[contains(@class,'pendo_feature_seller_details_save_btn')]");
    final By SuccessSavePopup = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By EmailValidator = By.xpath("//div[contains(@class,'Select__menu-notice--no-options')]");
    final By TodayInCalender = By.xpath("//div[contains(@class,'pendo_feature_realtime_enabled')]/descendant::div[contains(text(),'Today')]");


    //Global Variables
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;
    public static int RetryListener = 0;

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

    @Step("Clicking on guaranteed campaign tracker remove button")
    public void ClickingOnTrackerRemoveButton(int TrackerNo) {
        String XpathFormatter = String.format(TrackerRemoveButton, TrackerNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Step("Clicking on guaranteed campaign tab switch")
    public void ClickOnGuaranteedCampaignTabSwitch() throws InterruptedException {
//        Thread.sleep(3000);
        wait.until(invisibilityOfElementLocated(BlackLoader));
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(80));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(GuaranteedCampaignTabSwitch));
        driver.findElement(GuaranteedCampaignTabSwitch).click();
    }

    @Step("Validating successful creation of Search Only campaign")
    public boolean ValidateCreatedSearchOnlyCampaignName(String CampaignName) {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        ExtensiveWait.until(ExpectedConditions.visibilityOfElementLocated(CampaignNameVerificationFirstRow));
        return driver.findElement(CampaignNameVerificationFirstRow).getText().equalsIgnoreCase(CampaignName);
    }

    @Step("Validating successful creation of Search Only campaign")
    public boolean ValidateCreatedAuctionCampaignName(String CampaignName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CampaignNameVerificationFirstRow));
        return driver.findElement(CampaignNameVerificationFirstRow).getText().equalsIgnoreCase(CampaignName);
    }

    @Step("Clicking on pay from wallet balance button")
    public void ClickOnPayFromWalletBalanceButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        ExtensiveWait.until(visibilityOfElementLocated(PayFromWalletBalanceButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((PayFromWalletBalanceButton)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(PayFromWalletBalanceButtonDisabled));
    }


    @Step("Clicking on Yes button")
    public void ClickOnYesButtonToConfirmAudienceChange() {
        wait.until(visibilityOfElementLocated(ConfirmationButtonForAudienceSave));
        driver.findElement(ConfirmationButtonForAudienceSave).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Clicking cross button")
    public void ClickCrossButtonLevel1() {
        wait.until(visibilityOfElementLocated(CrossButtonLevel1));
        driver.findElement(CrossButtonLevel1).click();
    }

    @Step("Clicking cross button")
    public void ClickCrossButtonLevel2() {
        wait.until(visibilityOfElementLocated(CrossButtonLevel2));
        driver.findElement(CrossButtonLevel2).click();
    }

    @Step("Clicking cross button")
    public void ClickCrossButtonLevel3() {
        wait.until(visibilityOfElementLocated(CrossButtonLevel3));
        driver.findElement(CrossButtonLevel3).click();
    }

    @Step("Validate error message for saving empty customer target")
    public boolean ValidateErrorMessageForSavingEmptyCustomTarget() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMessageClickSaveWithEmptyFieldInCatalogTargeting));
            return driver.findElement(ErrorMessageClickSaveWithEmptyFieldInCatalogTargeting).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking Cancel button to cancel export location")
    public void ClickingCancelButton() {
        wait.until(visibilityOfElementLocated(CancelButton));
        driver.findElement(CancelButton).click();
    }

    @Step("Validating pop up while changing audience")
    public void ClickYesButtonForConfirmation() {
        wait.until(elementToBeClickable(YesButton));
        driver.findElement(YesButton).click();
    }

    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    @Step("Clicking on creative ad product remove confirmation button") //changed
    public void ClickCreativeAdProductRemoveConfirmationButton() {
        wait.until(elementToBeClickable(ProductsRemoveConfirmationButton));
        driver.findElement(ProductsRemoveConfirmationButton).click();
    }

    @Step("Clicking on creative ad product remove button") //changed
    public void ClickCreativeAdProductRemoveButton() {
        wait.until(elementToBeClickable(ProductsRemoveButton));
        driver.findElement(ProductsRemoveButton).click();
    }

    @Step("Clicking on creative ad media library close button") //changed
    public void ClickCreativeAdMediaLibraryCloseButton() {
        wait.until(elementToBeClickable(CreativeAdMediaLibraryCloseButton));
        driver.findElement(CreativeAdMediaLibraryCloseButton).click();
    }

    @Step("Clicking on guaranteed campaign cost per impression")
    public void ClickingOnGuaranteedCampaignsImpressions() {
        wait.until(presenceOfElementLocated(GuaranteedCampaignsImpressions));
        driver.findElement(GuaranteedCampaignsImpressions).click();

    }

    @Step("Clicking on the Next button")
    public void ClickAwarenessNextButton() {
        wait.until(elementToBeClickable(AwarenessNextButton));
        driver.findElement(AwarenessNextButton).click();
    }

    @Step("Clicking on the Next button while creating guaranteed campaign")
    public void ClickGuaranteedNextButton() {
        wait.until(elementToBeClickable(GuaranteedNextButton));
        driver.findElement(GuaranteedNextButton).click();
    }

    public static String CampaignName;

    @Step("Renaming of campaign name button")
    public String RenameCampaignName() {
        wait.until(elementToBeClickable(performancePage.CampaignNameRenameButton));
        driver.findElement(performancePage.CampaignNameRenameButton).click();
        String DefaultCampaignName = driver.findElement(performancePage.ExistingCampaignName).getAttribute("value");
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        CampaignName = DefaultCampaignName;
        driver.switchTo().activeElement().sendKeys(DefaultCampaignName);
        return DefaultCampaignName;
    }

    @Step("Clicking on create campaign button")
    public void ClickOnCreateCampaignButton() {
        wait.until(elementToBeClickable(performancePage.CreateNewCampaignButton));
        WebElement element = driver.findElement(performancePage.CreateNewCampaignButton);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @Step("Clicking on awareness dashboard")
    public void ClickingOnAwarenessDashBoard() {
        wait.until(elementToBeClickable(AwarenessDashboard));
        driver.findElement(AwarenessDashboard).click();
    }

    @Step("Clicking on guaranteed campaign select page type field")
    public void ClickingOnGuaranteedCampaignSelectPageTypeField() {
        wait.until(elementToBeClickable(GuaranteedCampaignSelectPageTypeField));
        driver.findElement(GuaranteedCampaignSelectPageTypeField).click();
    }

    @Step("Entering data in guaranteed campaign select page type field")
    public void EnteringDataInGuaranteedCampaignSelectPageTypeField(String PageName) {
        driver.switchTo().activeElement().sendKeys(PageName);
    }

    @Step("Clicking on guaranteed campaign select page type field drop down")
    public void ClickingOnGuaranteedCampaignSelectPageTypeFieldDropDown() {
        wait.until(elementToBeClickable(GuaranteedCampaignSelectPageTypeInputFieldDropdown));
        driver.findElement(GuaranteedCampaignSelectPageTypeInputFieldDropdown).click();
    }

    @Step("Clicking on guaranteed campaign month next navigator")
    public boolean ClickingOnGuaranteedCampaignsMonthNextNavigator(String MonthYear) {
        wait.until(visibilityOfElementLocated(GuaranteedCampaignMonthTitle));
        WebElement nextNavigator = driver.findElement(GuaranteedCampaignMonthNextNavigator);
        String PresentMonth = driver.findElement(GuaranteedCampaignMonthTitle).getText();

        int monthsClicked = 0;
        boolean status;

        while (!PresentMonth.equalsIgnoreCase(MonthYear) || PresentMonth.equalsIgnoreCase("अक्टूबर 2024")) {
            if (monthsClicked >= 2) {
                System.out.println("Only two months ahead can be selected");
                break;
            }

            if (nextNavigator.isEnabled()) {
                wait.until(elementToBeClickable(nextNavigator));
                nextNavigator.click();
                PresentMonth = driver.findElement(GuaranteedCampaignMonthTitle).getText();
                monthsClicked++;
            } else {
                break;
            }
        }
        status = monthsClicked > 2;
        return status;
    }

    @Step("Clicking on guaranteed campaign select date button")
    public void ClickingOnGuaranteedCampaignSelectDateButton() {
        wait.until(elementToBeClickable(GuaranteedCampaignSelectDate));
        driver.findElement(GuaranteedCampaignSelectDate).click();
    }

    @Step("Clicking on guaranteed campaign available date")
    public void ClickingOnGuaranteedCampaignAvailableDateInSelectDate(String MonthNo, int RowConditionSelector) {
        String XpathFormatter = String.format(GuaranteedCampaignAvailableDate, MonthNo, RowConditionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on guaranteed campaign add inventory button")
    public void ClickingOnGuaranteedCampaignAddInventoryButton() {
        wait.until(elementToBeClickable(GuaranteedCampaignAddInventoryButton));
        driver.findElement(GuaranteedCampaignAddInventoryButton).click();
    }

    @Step("Clicking on guaranteed campaign pay now button")
    public void ClickingOnGuaranteedCampaignPayNowButton() {
        wait.until(invisibilityOfElementLocated(GuaranteedCampaignInactivePayNowButton));
        wait.until(elementToBeClickable(GuaranteedCampaignPayNowButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((GuaranteedCampaignPayNowButton)));
    }

    @Step("Clicking on guaranteed campaign pay later button")
    public void ClickingOnGuaranteedCampaignPayLaterButton() {
        wait.until(invisibilityOfElementLocated(GuaranteedCampaignPayLaterInactiveButton));
        wait.until(elementToBeClickable(GuaranteedCampaignPayLaterButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((GuaranteedCampaignPayLaterButton)));
    }

    @Step("Clicking on guaranteed campaign pay later ok button")
    public void ClickingOnGuaranteedCampaignPayLaterOkButton() {
        wait.until(elementToBeClickable(GuaranteedCampaignPayLaterOkButton));
        driver.findElement(GuaranteedCampaignPayLaterOkButton).click();
    }


    @Step("Clicking on campaign creative new ad")
    public void ClickingCampaignCreativeNewAdButton() {
        wait.until(elementToBeClickable(AwarenessCampaignCreativesNewAd));
        driver.findElement(AwarenessCampaignCreativesNewAd).click();
    }


    @Step("Entering data in campaign creative ad name in new ad")
    public void AddingNameInAdNameField(String AdName) {
        wait.until(elementToBeClickable(AwarenessCampaignCreativesNewAdName));
        driver.findElement(AwarenessCampaignCreativesNewAdName).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AwarenessCampaignCreativesNewAdName).sendKeys(AdName);

    }

    @Step("Uploading left image in guaranteed campaign creative new ad")
    public void UploadingLeftImageInGuaranteedCampaignCreativeNewAd(String ImageName) {
        String UserPath = System.getProperty("user.dir");
        String ImagePath = UserPath + File.separator + "Resources" + File.separator + "OsmosResources" + File.separator + "Images" + File.separator + ImageName;
        driver.findElement(AwarenessCampaignCreativesNewAdLeftImageField).sendKeys(ImagePath);

    }

    @Step("Uploading video in campaign creative new ad")
    public void UploadingVideoInCampaignCreativeNewAd(String VideoName) {
        String UserPath = System.getProperty("user.dir");
        String ImagePath = UserPath + File.separator + "Resources" + File.separator + "OsmosResources" + File.separator + "Videos" + File.separator + VideoName;
        driver.findElement(AwarenessCampaignCreativesNewAdLeftImageField).sendKeys(ImagePath);

    }

    @Step("Uploading right image in campaign creative new ad")
    public void UploadingRightImageInCampaignCreativeNewAd(String ImageName) {
        String UserPath = System.getProperty("user.dir");
        String ImagePath = UserPath + File.separator + "Resources" + File.separator + "OsmosResources" + File.separator + "Images" + File.separator + ImageName;
        driver.findElement(AwarenessCampaignCreativesNewAdRightImageField).sendKeys(ImagePath);

    }

    @Step("Clicking on awareness campaign creative save button in new ad")
    public void ClickingOnAwarenessCampaignCreativesNewAdSaveButton() {
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='os-async-img undefined'])[4]")));
        wait.until(elementToBeClickable(AwarenessCampaignCreativesNewAdSaveButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((AwarenessCampaignCreativesNewAdSaveButton)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));

    }

    @Step("Clicking on campaign creative save button in new ad")
    public void ClickingOnCampaignCreativesNewAdSaveButton() {
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='os-async-img undefined'])[4]")));
        wait.until(elementToBeClickable(GuaranteedCampaignCreativesNewAdSaveButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((GuaranteedCampaignCreativesNewAdSaveButton)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Clicking on campaign qa full fledge ")
    public void ClickingOnCampaignQAFullFledgeFormat(int FormatNo) {
        String XpathFormatter = String.format(QAFullFledgeFormat, FormatNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on campaign creative ad carousel text field")
    public void ClickingOnCampaignCreativeAdCarouselTextField(int TextFieldNo) {
        String XpathFormatter = String.format(AwarenessCampaignCreateAdCarouselTextField, TextFieldNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering data in campaign creative ad carousel text field")
    public void EnteringDataInCampaignCreativeAdCarouselTextField(int TextFieldNo, String TextFieldData) {
        String XpathFormatter = String.format(AwarenessCampaignCreateAdCarouselTextField, TextFieldNo);
        wait.until(visibilityOfElementLocated(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).sendKeys(TextFieldData);
    }

    @Step("Clicking on campaign creative ad carousel cta field")
    public void ClickingOnCampaignCreativeAdCarouselCTAField(int TextFieldNo) {
        String XpathFormatter = String.format(AwarenessCampaignCreateAdCarouselCTAField, TextFieldNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on campaign creative ad carousel cta field drop down")
    public void ClickingOnCampaignCreativeAdCarouselCTAFieldDropDown(int DropDownNo) {
        String XpathFormatter = String.format(AwarenessCampaignCreateAdCarouselCTAFieldDropDown, DropDownNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on campaign creative carousel add button")
    public void ClickingOnCampaignCreativeAdCarouselAddButton() {
        wait.until(elementToBeClickable(AwarenessCampaignCreateAdCarouselAddIcon));
        driver.findElement(AwarenessCampaignCreateAdCarouselAddIcon).click();
    }

    @Step("Clicking on campaign creative ad carousel delete button")
    public void ClickingOnCampaignCreativeAdCarouselDeleteButton(int CTANo) {
        String XpathFormatter = String.format(AwarenessCampaignCreateAdCarouselDeleteIcon, CTANo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on campaign creative ad carousel delete button yes button")
    public void ClickingOnCampaignCreativeAdCarouselDeleteYesButton() {
        wait.until(elementToBeClickable(AwarenessCampaignCreateAdCarouselDeleteIconConfirmation));
        driver.findElement(AwarenessCampaignCreateAdCarouselDeleteIconConfirmation).click();
    }

    @Step("Clicking on campaign creative ad carousel creative count")
    public void ClickingOnCampaignCreativeAdCarouselCreativeCount(int CreativeCount) {
        String XpathFormatter = String.format(AwarenessCampaignCreateAdCarouselCreativeCount, CreativeCount);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Entering data in campaign creative ad qa full fledge text component field")
    public void EnteringDataInCampaignCreativesQAFullFledgeCreativeAdTextComponentField(String Text) {
        wait.until(visibilityOfElementLocated(QAFullFledgeFormatCreativeAdTextComponentField));
        driver.findElement(QAFullFledgeFormatCreativeAdTextComponentField).sendKeys(Text);
    }

    @Step("Entering data in campaign creative ad qa full fledge Url field")
    public void EnteringDataInCampaignCreativesQAFullFledgeCreativeAdUrlField(String Url) {
        wait.until(visibilityOfElementLocated(QAFullFledgeFormatCreativeAdUrlField));
        driver.findElement(QAFullFledgeFormatCreativeAdUrlField).sendKeys(controlOrCommandKey + "a");

        driver.findElement(QAFullFledgeFormatCreativeAdUrlField).sendKeys(Url);

    }

    @Step("Clicking on campaign creative ad qa full fledge add product button")
    public void ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductButton() {
        wait.until(visibilityOfElementLocated(QAFullFledgeFormatCreativeAdAddProductButton));
        driver.findElement(QAFullFledgeFormatCreativeAdAddProductButton).click();
    }

    @Step("Clicking on add product button")
    public void ClickAddProductButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(elementToBeClickable(performancePage.AddProductButton));
        driver.findElement(performancePage.AddProductButton).click();
    }

    @Step("Clicking on add button to add selected products")
    public void ClickAddButton() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(40));
        ExtensiveWait.until(elementToBeClickable(performancePage.AddButton));
        driver.findElement(performancePage.AddButton).click();
    }

    @Step("Clicking on campaign creative ad qa full fledge add product add button")
    public void ClickingOnCampaignCreativesQAFullFledgeCreativeAdAddProductAddButton() {
        wait.until(visibilityOfElementLocated(QAFullFledgeFormatCreativeAdAddProductAddButton));
        driver.findElement(QAFullFledgeFormatCreativeAdAddProductAddButton).click();
    }


    @Step("Clicking on campaign creative send for review button")
    public void ClickingOnGuaranteedCampaignCreativesSendForReviewButton() {
        wait.until(invisibilityOfElementLocated(BlackLoader));
        wait.until(elementToBeClickable(GuaranteedCampaignSendForReviewButton));
        driver.findElement(GuaranteedCampaignSendForReviewButton).click();
    }


    @Step("Clicking on guaranteed campaign cost per day")
    public void ClickingOnGuaranteedCampaignsDay() {
        wait.until(elementToBeClickable(GuaranteedCampaignsDay));
        driver.findElement(GuaranteedCampaignsDay).click();
    }


    @Step("Clicking on select page button  in auction campaign creation")
    public void ClickOnSelectPageButton() {
        wait.until(elementToBeClickable(SelectPageButton));
        driver.findElement(SelectPageButton).click();
    }

    @Step("Selecting desired page")
    public void SelectDesiredPage() {
        wait.until(elementToBeClickable((By.xpath(SelectDesiredPage))));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(SelectDesiredPage)));
    }

    @Step("Clicking done button")
    public void ClickDoneButton() {
        wait.until(elementToBeClickable(DoneButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((DoneButton)));
    }

    @Step("Selecting 1st inventory")
    public void SelectInventory() throws InterruptedException {
//        Thread.sleep(3000);
        wait.until(visibilityOfElementLocated(SelectionOfInventory));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(SelectionOfInventory);
        js.executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'inventory-cta-inner')])[1]")));
    }

    @Step("Clicking Next button in step-1 page")
    public void ClickInventorySaveButton() {
        wait.until(visibilityOfElementLocated(InventorySaveButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(InventorySaveButton);
        js.executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));

    }

    @Step("Clicking keyword targeting in step-2")
    public void ClickKeywordTargeting() throws InterruptedException {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        ExtensiveWait.until(elementToBeClickable(KeywordTargeting));
        driver.findElement(KeywordTargeting).click();
    }

    @Step("Clicking add keyword button")
    public void ClickAddKeywordButton() {
        wait.until(elementToBeClickable(AddKeywordButton));
        driver.findElement(AddKeywordButton).click();
    }

    @Step("Adding positive keywords to keyword field")
    public void AddPositiveKeywords(String keyword1, String keyword2) {
        wait.until(elementToBeClickable(performancePage.KeywordTextField));
        driver.findElement(performancePage.KeywordTextField).sendKeys(keyword1);
        driver.findElement(performancePage.KeywordTextField).sendKeys(Keys.ENTER);
        driver.findElement(performancePage.KeywordTextField).sendKeys(keyword2);
    }

    @Step("Clicking save keyword button")
    public void ClickSaveKeywordsButton() throws InterruptedException {
        Thread.sleep(1500);
        wait.until(elementToBeClickable(SaveKeywordButton));
        driver.findElement(SaveKeywordButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(SaveKeywordButtonDisabled));
    }

    @Step("Clicking save button to save valid Keywords")
    public void ClickAddedKeywordSaveButton() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(elementToBeClickable(SaveAddedKeywords));
        driver.findElement(SaveAddedKeywords).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(SaveAddedKeywordsDisabled));

    }

    @Step("Clicking save button to save targeting settings")
    public void ClickTargetingSaveButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(invisibilityOfElementLocated(InActiveSaveButton));
        ExtensiveWait.until(visibilityOfElementLocated(SaveTargetingButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((SaveTargetingButton)));
    }

    @Step("Clicking save button to save targeting settings without customizing any target")
    public void ClickTargetingSaveButtonWithoutCustomization() {
        wait.until(elementToBeClickable(SaveTargetingButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((SaveTargetingButton)));
    }

    @Step("Selecting QA Full fledge Format")
    public void SelectQAFullFledgeFormat() throws InterruptedException {
        Thread.sleep(4000);
        wait.until(elementToBeClickable(AuctionQAFullFledgeFormat));
        driver.findElement(AuctionQAFullFledgeFormat).click();
    }

    @Step("Clicking upload button from creative library")
    public void ClickUploadButtonFromCreativeLibrary(int MediaTypeNo) {
        String XpathFormatter = String.format(GenericCreativeLibraryUploadButton, MediaTypeNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting image from creative library")
    public void SelectMediaFromCreativeLibrary() {
        wait.until(elementToBeClickable(SelectImageFromCreativeLibrary));
        driver.findElement(SelectImageFromCreativeLibrary).click();
    }

    @Step("Clicking choose button after selecting image")
    public void ClickChooseButton() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(elementToBeClickable(ChooseImageButton));
        driver.findElement(ChooseImageButton).click();
    }

    @Step("Clicking checkboxes to select individual products")
    public void ClickCheckboxesToSelectIndividualProducts(int ProductNo) {
        String XpathFormatter = String.format(AwarenessCampaignCreateAdIndividualProductCheckBox, ProductNo);

        try {
            wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
            driver.findElement(By.xpath(XpathFormatter)).click();
        } catch (StaleElementReferenceException e) {
            wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
            driver.findElement(By.xpath(XpathFormatter)).click();
        }
    }

    @Step("Clicking Save button")
    public void ClickingSaveButton() {
        wait.until(elementToBeClickable(SaveCampaignFormatButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((SaveCampaignFormatButton)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));
    }


    @Step("Adding value in daily budget field")
    public void AddValueInDailyBudgetField(String DailyBudget) {
        wait.until(elementToBeClickable((DailyBudgetField)));
        driver.findElement(DailyBudgetField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(DailyBudget);
    }

    @Step("Temp")
    public void AddValueInDailyBudgetFieldTemp(String DailyBudget) {
        wait.until(visibilityOfAllElementsLocatedBy((DailyBudgetFieldTemp)));
        driver.findElement(DailyBudgetFieldTemp).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(DailyBudget);
    }

    @Step("Clicking submit for review button")
    public void ClickSubmitForReviewButton() {
        wait.until(elementToBeClickable((SubmitForReviewButton)));
        driver.findElement(SubmitForReviewButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Clicking on the radio button of native ads")
    public void ClickingOnTheNativeAdsRadioButton() {
        wait.until(elementToBeClickable((NativeAdsRadioButton)));
        driver.findElement(NativeAdsRadioButton).click();
    }

    @Step("Clicking on the radio button of Audience network ads")
    public void ClickingOnTheAudienceNetworkAdsRadioButton() {
        wait.until(elementToBeClickable((AudienceNetworkAdsRadioButton)));
        driver.findElement(AudienceNetworkAdsRadioButton).click();
    }

    @Step("Validating error message without selecting any option and clicking next button")
    public boolean ValidatingErrorMessageWithOutSelectingAnyOption() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMessageForNotChoosingAnyOption));
            return driver.findElement(ErrorMessageForNotChoosingAnyOption).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating creative ad success pop up")
    public boolean ValidateCreativeAdSuccessPopUp() {
        try {
            wait.until(visibilityOfElementLocated(CreativeAdSaveSuccessPopUp));
            return driver.findElement(CreativeAdSaveSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message without selecting any page and clicking done button")
    public boolean ValidatingErrorMessageWithOutSelectingAnyPage() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMessageForNotChoosingAnyPage));
            return driver.findElement(ErrorMessageForNotChoosingAnyPage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message without selecting any inventory and clicking save button")
    public boolean ValidatingErrorMessageWithOutSelectingAnyInventory() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMessageForNotChoosingAnyInventory));
            return driver.findElement(ErrorMessageForNotChoosingAnyInventory).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on geo location targeting")
    public void ClickingOnGeoLocationTargeting() throws InterruptedException {
//        Thread.sleep(2500);
        wait.until(elementToBeClickable(GeoLocationTargeting));
        driver.findElement(GeoLocationTargeting).click();
    }

    @Step("Clicking on included location field")
    public void ClickingOnIncludedLocationField() {
        wait.until(visibilityOfElementLocated(IncludedLocation));
        driver.findElement(IncludedLocation).click();
    }

    @Step("Entering desired text in include location field")
    public void EnteringDesiredTextInIncludeLocationField(String Location) {
        wait.until(visibilityOfElementLocated(IncludedLocationField));
        driver.findElement(IncludedLocationField).sendKeys(Location);
    }

    @Step("Clicking on Excluded location field")
    public void ClickingOnExcludedLocationField() {
        wait.until(visibilityOfElementLocated(ExcludedLocation));
        driver.findElement(ExcludedLocation).click();
    }

    @Step("Entering desired text in exclude location field")
    public void EnteringDesiredTextInExcludeLocationField(String Location) {
        wait.until(visibilityOfElementLocated(ExcludedLocationField));
        driver.findElement(ExcludedLocationField).sendKeys(Location);
    }

    @Step("Selecting desired location")
    public void SelectingDesiredLocationWithCheckbox(int checkboxnumber) {
        String Checkbox = String.format(LocationCheckBoxes, checkboxnumber);
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        ExtensiveWait.until((visibilityOfElementLocated(By.xpath(Checkbox))));
        driver.findElement(By.xpath(Checkbox)).click();
    }

    @Step("Selecting multiple locations")
    public void SelectingMultipleLocationWithCheckbox(int locationcount) {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        for (int checkboxCount = 1; checkboxCount <= locationcount; checkboxCount++) {
            String Checkbox = String.format(LocationCheckBoxes, checkboxCount);
            ExtensiveWait.until(presenceOfElementLocated(By.xpath(Checkbox)));
//            driver.findElement(By.xpath(Checkbox)).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Checkbox)));
        }

    }

    @Step("Clicking on Apply location button")
    public void ClickingOnApplyLocationButton() {
        wait.until(visibilityOfElementLocated(LocationApplyButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((LocationApplyButton)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(LocationApplyButtonDisabled));
    }

    @Step("Validating added location count")
    public boolean ValidateAddedLocationCountInTargetingCandy() {
        wait.until(visibilityOfElementLocated(TargetingCandySelectedLocationCount));
        return driver.findElement(TargetingCandySelectedLocationCount).getText().contains("20");
    }

    @Step("Validating error message when selecting more than maximum locations")
    public boolean ValidatingMaximumLocationSelectedErrorMsg() {
        try {
            wait.until(visibilityOfElementLocated(MaximumLocationSelectionErrorMsg));
            return driver.findElement(MaximumLocationSelectionErrorMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking reset locations button")
    public void ClickingLocationResetButton() {
        wait.until(visibilityOfElementLocated(ResetLocationField));
        driver.findElement(ResetLocationField).click();
    }

    @Step("Clicking reset locations confirmation button")
    public void ClickingLocationResetConfirmationButton() {
        wait.until(visibilityOfElementLocated(ResetLocationConfirmationButton));
        driver.findElement(ResetLocationConfirmationButton).click();
    }

    @Step("Validating the error message while selecting same locations in include and exclude location")
    public boolean ValidatingSameLocationSelectionErrorMsg() {
        try {
            wait.until(visibilityOfElementLocated(SameLocationSelectionErrorMsg));
            return driver.findElement(SameLocationSelectionErrorMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating the  message after saving the geo location preference")
    public boolean ValidatingUpdateLocationMessage() {
        try {
            wait.until(visibilityOfElementLocated(GeoLocationUpdateMsg));
            return driver.findElement(GeoLocationUpdateMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking cross button to delete selected locations")
    public void ClickingCrossButtonToDeleteSelectedLocations() {
        wait.until(visibilityOfElementLocated(CrossIconToDeleteSelectedLocations));
        driver.findElement(CrossIconToDeleteSelectedLocations).click();
    }

    @Step("Validating all location selected in include location")
    public boolean ValidatingAllLocationSelected() {
        try {
            wait.until(visibilityOfElementLocated(AllLocationSelected));
            return driver.findElement(AllLocationSelected).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating visibility of selected locations")
    public boolean ValidatingSelectedLocations() {
        boolean Flag = false;
        boolean isvisiable = wait.until(invisibilityOfElementLocated(SelectedLocations));
        if (isvisiable)
            Flag = true;

        return Flag;
    }

    @Step("Clicking export button to export button")
    public void ClickingExportButton() {
        wait.until(visibilityOfElementLocated(ExportButton));
        driver.findElement(ExportButton).click();
    }

    @Step("Importing location file")
    public void ImportingLocationFile(String FileName) {
        wait.until(presenceOfElementLocated(ImportButton));
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" + File.separator + "OsmosResources" + File.separator + "Json" + File.separator + FileName;
        driver.findElement(ImportButton).sendKeys(Filepath);
    }

    @Step("Clicking continue button")
    public void ClickingContinueButtonToImport() {
        wait.until(presenceOfElementLocated(ContinueButton));
        driver.findElement(ContinueButton).click();
    }

    @Step("Validating error message while clicking continue button without selecting any option")
    public boolean ValidatingErrorMsgWhenNoOptionSelected() {
        try {
            wait.until(presenceOfElementLocated(NoOptionSelectedErrorMessage));
            return driver.findElement(NoOptionSelectedErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message after uploading an invalid file")
    public boolean ValidatingErrorMsgWhenUploadingInvalidFile() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMsgUploadingInvalidFile));
            return driver.findElement(ErrorMsgUploadingInvalidFile).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating successful importing location msg after importing valid locations")
    public boolean ValidatingSuccessfulImportingLocationsPopup() {
        try {
            wait.until(visibilityOfElementLocated(ImportLocationSuccessMsg));
            return driver.findElement(ImportLocationSuccessMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking export button to export selected locations")
    public void ClickingExportSelectedLocationsButton() {
        wait.until(visibilityOfElementLocated(ExportSelectedLocationButton));
        driver.findElement(ExportSelectedLocationButton).click();
    }

    @Step("Validating error message when exporting file with empty file name")
    public boolean ValidatingEmptyFileNameErrorMsg() {
        try {
            wait.until(visibilityOfElementLocated(EmptyFileNameErrorMsg));
            return driver.findElement(EmptyFileNameErrorMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message when exporting file without selecting any option")
    public boolean ValidatingNoOptionSelectionErrorMsg() {
        try {
            wait.until(visibilityOfElementLocated(NoOptionSelectedErrorMsgWhileExporting));
            return driver.findElement(NoOptionSelectedErrorMsgWhileExporting).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Exporting locations")
    public boolean ValidatingExportLocation() {
        try {
            wait.until(visibilityOfElementLocated(SuccessfulExportMsg));
            return driver.findElement(SuccessfulExportMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Deselecting include location checkbox")
    public void DeselectingIncludedLocation() {
        wait.until(visibilityOfElementLocated(IncludedLocationCheckBox));
        driver.findElement(IncludedLocationCheckBox).click();
    }

    @Step("Deselecting exclude location checkbox")
    public void DeselectingExcludedLocation() {
        wait.until(visibilityOfElementLocated(ExcludedLocationCheckBox));
        driver.findElement(ExcludedLocationCheckBox).click();
    }

    @Step("Adding file name while exporting location")
    public void AddingExportFileName(String file_name) {
        wait.until(visibilityOfElementLocated(ExportFileNameField));
        driver.findElement(ExportFileNameField).sendKeys(file_name);
    }

    @Step("Validate error message while adding spaces only in file name field")
    public boolean ValidateAddingSpacesOnlyInFileNameField() {
        try {
            wait.until(visibilityOfElementLocated(SpaceInFileNameErrorMsg));
            return driver.findElement(SpaceInFileNameErrorMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if  the export button is disabled")
    public boolean ValidatingExportButtonStatus() {
        try {
            WebElement button = driver.findElement(DisabledExportButton);
            return button.getAttribute("class").contains("disabled");
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating guaranteed campaign select page type error pop up")
    public Boolean ValidatingGuaranteedCampaignSelectPageTypePopUp() {
        try {
            wait.until(elementToBeClickable(GuaranteedCampaignSelectPageTypeErrorPopUp));
            return driver.findElement(GuaranteedCampaignSelectPageTypeErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }

    }

    @Step("Clicking on guaranteed campaign impressions field")
    public void ClickingCampaignImpressionsField() {
        wait.until(elementToBeClickable(GuaranteedCampaignImpressionsInactiveField));
        driver.findElement(GuaranteedCampaignImpressionsInactiveField).click();
    }

    @Step("Entering data in  guaranteed campaign impressions field")
    public void EnteringDataInCampaignImpressionsField(int ImpressionsValue) {
        driver.findElement(By.xpath("//div[contains(@class,'right-value')]/div")).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(String.valueOf(ImpressionsValue));
    }

    @Step("Validating guaranteed campaign select date error pop up")
    public Boolean ValidatingGuaranteedCampaignSelectDateErrorPopUp() {
        try {
            wait.until(visibilityOfElementLocated(GuaranteedCampaignSelectDataErrorPopUp));
            return driver.findElement(GuaranteedCampaignSelectDataErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating creative ad ad name field is accepting only spaces")
    public Boolean ValidatingCreativeAdAdNameFieldIsAcceptingSpaces() {
        boolean flag = false;
        String Text = driver.findElement(AwarenessCampaignCreativesNewAdName).getAttribute("value");
        if (Text.trim().isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Step("Validating creative ad ad name field is accepting more then 35 characters")
    public Boolean ValidatingCreativeAdAdNameFieldIsAcceptingMoreThenMaximumLength() {
        boolean flag = true; //change
        String Text = driver.findElement(AwarenessCampaignCreativesNewAdName).getAttribute("value");
        if (Text.length() > 35) {
            flag = false;
        }
        return flag;
    }

    @Step("Clicking on guaranteed campaign creative new ad media library filter button")
    public void ClickingCampaignCreativeAdMediaLibraryFilterButton() {
        wait.until(elementToBeClickable(GuaranteedCampaignCreativeAdMediaLibraryFilterButton));
        driver.findElement(GuaranteedCampaignCreativeAdMediaLibraryFilterButton).click();

    }

    @Step("Clicking on guaranteed campaign media library filter options")
    public void ClickingOnGuaranteedCampaignMediaLibraryFilterOptions(int FilterOption) {
        String XpathFormatter = String.format(AwarenessMediaLibraryGenericFilterOptions, FilterOption);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on guaranteed campaign media library type options")
    public void ClickingOnGuaranteedCampaignMediaLibraryTypeOptions(int FilterOption) {
        String XpathFormatter = String.format(AwarenessMediaLibraryTypeGenericOptions, FilterOption);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on guaranteed campaign creative new ad media library apply button")
    public void ClickingCampaignCreativeAdMediaLibraryApplyButton() {
        wait.until(elementToBeClickable(AwarenessMediaLibraryFilterApplyButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((AwarenessMediaLibraryFilterApplyButton)));
    }

    @Step("Selecting image from media library guaranteed campaign")
    public void SelectingImageFromMediaLibrary(int ImageNo) {
        String XpathFormatter = String.format(AwarenessMediaLibraryImageSelection, ImageNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(XpathFormatter)));

    }

    @Step("Clicking on choose button in guaranteed campaign media library")
    public void ClickingOnChooseButtonInMediaLibrary() throws InterruptedException {
        Thread.sleep(2500);
        wait.until(elementToBeClickable(AwarenessMediaLibraryChooseButton));
        driver.findElement(AwarenessMediaLibraryChooseButton).click();
    }

    @Step("Validating guaranteed campaign media library error pop up ")
    public Boolean ValidatingGuaranteedCampaignMediaLibraryErrorPopUp() {
        try {
            wait.until(visibilityOfAllElementsLocatedBy(AwarenessMediaLibraryChooseTypeErrorPopUp));
            return driver.findElement(AwarenessMediaLibraryChooseTypeErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating guaranteed campaign media library selected media count")
    public boolean ValidatingGuaranteedCampaignMediaLibraryMediaCount() {
        boolean Flag = true;  //changed
        int Count = 0;
        Count = driver.findElements(AwarenessMediaLibraryMediaTikMark).size();
        if (Count > 1) {
            Flag = false;
        }
        return Flag;
    }

    @Step("Validating guaranteed campaign creative ad more then maximum size video error pop up ")
    public Boolean ValidatingGuaranteedCampaignUMoreThenMaximumSizeVideoErrorPopUp() {
        try {
            wait.until(visibilityOfElementLocated(GuaranteedCampaignCreativeAdMoreThenMaximumVideoErrorPopUp));
            return driver.findElement(GuaranteedCampaignCreativeAdMoreThenMaximumVideoErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating guaranteed campaign invalid file with video extension error pop up ")
    public Boolean ValidatingGuaranteedCampaignInvalidFileWithVideoExtensionErrorPopUp() {
        try {
            wait.until(visibilityOfElementLocated(GuaranteedCampaignCreativeAdInvalidFileWithVideoExtensionErrorPopUp));
            return driver.findElement(GuaranteedCampaignCreativeAdInvalidFileWithVideoExtensionErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating guaranteed campaign creative ad invalid video format error pop up ")
    public Boolean ValidatingGuaranteedCampaignInvalidVideoFormatErrorPopUp() {
        try {
            wait.until(visibilityOfElementLocated(GuaranteedCampaignCreativeVideoInvalidFormatErrorPopUp));
            return driver.findElement(GuaranteedCampaignCreativeVideoInvalidFormatErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating guaranteed campaign creative ad invalid image dimensions error pop up ")
    public Boolean ValidatingGuaranteedCampaignInvalidImageDimensionsErrorPopUp() {
        try {
            wait.until(elementToBeClickable(GuaranteedCampaignCreativeVideoInvalidImageDimensionsErrorPopUp));
            return driver.findElement(GuaranteedCampaignCreativeVideoInvalidImageDimensionsErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating guaranteed campaign invalid file with image extension error pop up ")
    public Boolean ValidatingGuaranteedCampaignInvalidFileWithImageExtensionErrorPopUp() {
        try {
            wait.until(elementToBeClickable(GuaranteedCampaignCreativeAdInvalidFileWithImageExtensionErrorPopUp));
            return driver.findElement(GuaranteedCampaignCreativeAdInvalidFileWithImageExtensionErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating guaranteed campaign creative ad invalid video dimensions error pop up ")
    public Boolean ValidatingGuaranteedCampaignInvalidVideoDimensionsErrorPopUp() {
        try {
            wait.until(elementToBeClickable(GuaranteedCampaignCreativeVideoInvalidVideoDimensionsErrorPopUp));
            return driver.findElement(GuaranteedCampaignCreativeVideoInvalidVideoDimensionsErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating guaranteed campaign creative ad invalid image format error pop up ")
    public Boolean ValidatingGuaranteedCampaignInvalidImageFormatErrorPopUp() {
        try {
            wait.until(elementToBeClickable(GuaranteedCampaignCreativeImageInvalidFormatErrorPopUp));
            return driver.findElement(GuaranteedCampaignCreativeImageInvalidFormatErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating creative ad carousel field is accepting only spaces")
    public Boolean ValidatingCreativeAdCarouselFieldIsAcceptingSpaces(int CarouselNo) {
        boolean flag = false;
        String XpathFormatter = String.format(AwarenessCampaignCreateAdCarouselTextField, CarouselNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        String Text = driver.findElement(By.xpath(XpathFormatter)).getAttribute("value");
        if (Text.trim().isEmpty()) {
            flag = true;
        }
        return flag;

    }

    @Step("Validating creative ad carousel field is accepting more then 35 characters")
    public Boolean ValidatingCreativeAdCarouselFieldIsAcceptingMoreThenMaximumLength(int CarouselNo) {
        boolean flag = true;
        String XpathFormatter = String.format(AwarenessCampaignCreateAdCarouselTextField, CarouselNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        String Text = driver.findElement(By.xpath(XpathFormatter)).getAttribute("value");
        if (Text.length() > 35) {
            flag = false;
        }
        return flag;

    }

    @Step("Validating on guaranteed campaign creative carousel add button limit")
    public Boolean ValidatingCampaignCreativeAdCarouselAddButtonLimit() {
        boolean flag = true;
        int Count = driver.findElements(AwarenessCampaignCreateAdCarouselAddIcon).size();
        if (Count > 5) {
            flag = false;
        }
        return flag;
    }

    @Step("Clicking on creatives without selecting inventory")
    public boolean ClickOnCreativesWithoutSelectingInventory() {
        wait.until((visibilityOfElementLocated(Creatives)));
        return driver.findElement(Creatives).isEnabled();
    }

    @Step("Clicking Save without Uploading Images from Creative Library ")
    public boolean ClickingSaveWithoutUploadingImage() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageOfImage)));
            return driver.findElement(ErrorMessageOfImage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Uploading Image of Less Than Minimum Size")
    public boolean UploadingImageOfLessThanMinSize() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageOfLessThanMinSize)));
            return driver.findElement(ErrorMessageOfLessThanMinSize).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Uploading Image of more Than Maximum Size")
    public boolean UploadingImageOfMoreThanMaxSize() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageOfLessThanMaxSize)));
            return driver.findElement(ErrorMessageOfLessThanMaxSize).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step(" Click on Add tracker ")
    public void ClickOnAddTracker() {
        wait.until((elementToBeClickable(AddTracker)));
        driver.findElement(AddTracker).click();
    }

    @Step("Entering DCM Click URL")
    public void EnterDcmClickURL(String url) {
        wait.until((elementToBeClickable(DcmUrlField)));
        driver.findElement(DcmUrlField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(DcmUrlField).sendKeys(url);
    }

    @Step("Entering DCM Click URL")
    public void EnterDcmScriptTag(String Script) {
        wait.until((elementToBeClickable(DcmScriptField)));
        driver.findElement(DcmScriptField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(DcmScriptField).sendKeys(Script);
    }

    @Step("Entering DCM Click URL")
    public void EnterDcmImageTag(String imageTag) {
        wait.until((visibilityOfElementLocated(DcmImageField)));
        driver.findElement(DcmImageField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(DcmImageField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(DcmImageField).sendKeys(imageTag);
    }

    @Step("Clicking Save without Entering Script Tag in Script Tag Field ")
    public boolean ClickingSaveWithEmptyScriptField() {
        try {
            wait.until((visibilityOfElementLocated(DcmImageField)));
            return driver.findElement(ErrorMessageOfEmptyScriptField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking Save with Invalid Script Tag in Script Tag Field ")
    public boolean ClickingSaveWithInvalidScriptTag() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageOfInvalidScriptTag)));
            return driver.findElement(ErrorMessageOfInvalidScriptTag).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking Save with Spaces in Image Tag Field ")
    public boolean ValidateDCMImageTagErrorMessage() {
        try {
            driver.findElement(QAFullFledgeFormatCreativeAdUrlField).click();
            return driver.findElement(ErrorMessageEmptyImageTagField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Add Keywords button")
    public void ClickingOnAddKeywordsButton() {
        wait.until(presenceOfElementLocated(AddKeywordsButton));
        driver.findElement(AddKeywordsButton).click();
    }

    @Step("Clicking Save with Empty in Image Tag Field ")
    public boolean ClickingSaveWithEmptyImageTag() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageEmptyImageTagField)));
            return driver.findElement(ErrorMessageEmptyImageTagField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Adding less than Minimum Products in create Add field ")
    public boolean ValidateErrorMessageForNotAddingMinimumProducts() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageMinTwoProductsRequired)));
            return driver.findElement(ErrorMessageMinTwoProductsRequired).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking Save with Invalid Image Tag in Image Tag Field ")
    public boolean ClickingSaveWithInvalidImageTag() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageOfInvalidImageTag)));
            return driver.findElement(ErrorMessageOfInvalidImageTag).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Adding more than Maximum Products in create Add field ")
    public boolean AddingMoreThanMaxProducts() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageMaxFiveProductsAllowed)));
            return driver.findElement(ErrorMessageMaxFiveProductsAllowed).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking Pay Now and Send For Review without Selecting Creatives ")
    public boolean ClickingSendForReviewWithoutSelectingCreatives() {
        try {
            wait.until((visibilityOfAllElementsLocatedBy(ErrorMessageUploadCreatives)));
            return driver.findElement(ErrorMessageUploadCreatives).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking Save with Spaces in Script Tag Field ")
    public boolean ValidateScriptTagErrorMessage() {
        driver.findElement(QAFullFledgeFormatCreativeAdUrlField).click();
        return driver.findElement(ErrorMessageOfEmptyScriptField).isDisplayed();
    }

    @Step("Checking Add Tracker Option is Visible or not after adding three trackers ")
    public boolean CheckingTheVisibilityOfAddTrackerOption() {
        boolean isElementInvisible = wait.until(invisibilityOfElementLocated(AddTracker));
        boolean Flag = false;
        if (isElementInvisible)
            Flag = true;
        return Flag;
    }

    @Step("Clicking save with spaces in guaranteed campaign url field ")
    public boolean ClickingSaveWithSpacesURLField(String input) {
        driver.findElement(QAFullFledgeFormatCreativeAdUrlField).click();
        String actualText = driver.findElement(DcmUrlField).getAttribute("value");
        if (actualText.contentEquals(input)) {
            return driver.findElement(ErrorMessageEmptyURLField).isDisplayed();
        } else
            return driver.findElement(ErrorMessageEmptyURLField).isDisplayed();
    }

    @Step("Clicking save without entering url in dcm url field in guaranteed campaign")
    public boolean ClickingSaveWithEmptyURLField() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageEmptyURLField)));
            return driver.findElement(ErrorMessageEmptyURLField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking Save with Invalid URL in URL Field ")
    public boolean ClickingSaveWithInvalidURL() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageOfInvalidURL)));
            return driver.findElement(ErrorMessageOfInvalidURL).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking Save with invalid url in QA full fledge creative ad Url field ")
    public boolean ClickingSaveWithInvalidURLInQAFullFledgeCreative() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageInvalidQAFullFledgeCreativeAdUrlField)));
            return driver.findElement(ErrorMessageInvalidQAFullFledgeCreativeAdUrlField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking save with invalid url in qa full fledge creative ad url field ")
    public boolean ClickingSaveWithInvalidURLWithSpacesInBetweenInQAFullFledgeCreative() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageSpacesInBetweenQAFullFledgeCreativeAdUrlField)));
            return driver.findElement(ErrorMessageSpacesInBetweenQAFullFledgeCreativeAdUrlField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking save with empty url in qa full fledge creative ad url field ")
    public boolean ClickingSaveWithEmptyURLInQAFullFledgeCreative() {
        try {
            wait.until((visibilityOfElementLocated(ErrorMessageEmptyQAFullFledgeCreativeAdUrlField)));
            return driver.findElement(ErrorMessageEmptyQAFullFledgeCreativeAdUrlField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }

    }

    @Step("Validating creative ad component accepting more then 35 characters")

    public boolean ValidatingTextComponentField() {
        wait.until(elementToBeClickable(QAFullFledgeFormatCreativeAdTextComponentField));
        String actualText = driver.findElement(QAFullFledgeFormatCreativeAdTextComponentField).getAttribute("value");
        boolean Flag = false;
        if (actualText.length() >= 35) {
            Flag = true;
        }
        return Flag;
    }

    @Step("Entering Invalid Data in guaranteed campaign creative ad qa full fledge text component field")
    public void EnteringInvalidInCampaignCreativesQAFullFledgeCreativeAdTextComponentField(String input) {
        wait.until(visibilityOfElementLocated(QAFullFledgeFormatCreativeAdTextComponentField));
        driver.findElement(QAFullFledgeFormatCreativeAdTextComponentField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(QAFullFledgeFormatCreativeAdTextComponentField).sendKeys(input);
    }


    @Step("Validating text component field in guaranteed campaign")
    public boolean EnteringSpacesInTextComponentField() {
        wait.until((visibilityOfElementLocated(QAFullFledgeFormatCreativeAdTextComponentField)));
        String actualText = driver.findElement(QAFullFledgeFormatCreativeAdTextComponentField).getAttribute("value");
        boolean Flag = false;
        if (actualText.trim().isEmpty()) {
            Flag = true;
        }
        return Flag;
    }

    @Step("Clicking on duplicate icon in creative ad")
    public void ClickingOnDuplicateIconInCreativeAd() {
        wait.until((elementToBeClickable(CreativeAdDuplicateIcon)));
        driver.findElement(CreativeAdDuplicateIcon).click();
    }

    @Step("Clicking on duplicate icon confirmation button in creative ad")
    public void ClickingOnDuplicateIconConfirmationButtonInCreativeAd() {
        wait.until((elementToBeClickable(CreativeAdDuplicateConfirmationButton)));
        driver.findElement(CreativeAdDuplicateConfirmationButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Clicking on duplicate icon cancel button in creative ad")
    public void ClickingOnDuplicateIconCancelButtonInCreativeAd() {
        wait.until((elementToBeClickable(CreativeAdDuplicateCancelButton)));
        driver.findElement(CreativeAdDuplicateCancelButton).click();
    }

    @Step("Clicking on okay button to close the alert")
    public void ClickOnOkayButton() {
        wait.until((elementToBeClickable(CreativeAdDuplicateCancelButton)));
        driver.findElement(CreativeAdDuplicateCancelButton).click();
    }

    @Step("Clicking on delete icon in creative ad")
    public void ClickingOnDeleteIconInCreativeAd() {
        wait.until((elementToBeClickable(CreativeAdDeleteIcon)));
        driver.findElement(CreativeAdDeleteIcon).click();
    }

    @Step("Clicking on delete icon confirmation button in creative ad")
    public void ClickingOnDeleteIconConfirmationButtonInCreativeAd() {
        wait.until((elementToBeClickable(CreativeAdDeleteConfirmationButton)));
        driver.findElement(CreativeAdDeleteConfirmationButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Clicking on edit icon in creative ad")
    public void ClickingOnEditIconInCreativeAd() {
        wait.until((visibilityOfElementLocated(CreativeAdEditIcon)));
        driver.findElement(CreativeAdEditIcon).click();
    }

    @Step("Validating edit creative ad")
    public boolean ValidatingEditCreativeAd() {
        boolean Flag = true;
        boolean IsVisible = wait.until(visibilityOfElementLocated(AwarenessCampaignCreativesNewAdName)) != null;
        if (IsVisible)
            Flag = false;
        return Flag;

    }

    @Step("Validating deleted creative ad")
    public boolean ValidatingDeletedCreativeAd() {
        boolean Flag = true;
        boolean IsVisible = wait.until(invisibilityOfElementLocated(CreativesCreatedAd));
        if (IsVisible)
            Flag = false;
        return Flag;

    }

    @Step("Validating successful payment popup")
    public Boolean ValidateSuccessfulPayment() {
        try {
            wait.until((visibilityOfElementLocated(SuccessPopUp)));
            return driver.findElement(SuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating duplicated creative ad")
    public Boolean ValidatingDuplicatedCreativeAd() {
        boolean Flag = false;
        wait.until((visibilityOfElementLocated(CreativesCreatedAdCount)));
        String Text = driver.findElement(CreativesCreatedAdCount).getText();
        int Count = Integer.parseInt(Text);
        if (Count == 1)
            Flag = true;
        return Flag;


    }

    @Step("Clicking on wallet balance top up button in pay now")
    public void ClickingOnWalletBalanceTopUpButtonInPayNowOption() {
        wait.until((elementToBeClickable(WalletBalanceTopUpButton)));
        driver.findElement(WalletBalanceTopUpButton).click();
    }

    @Step("Entering data in top up amount field ")
    public void EnteringDataInTopUpAmountField(String Value) {
        wait.until((elementToBeClickable(TopUpAmountField)));
        driver.findElement(TopUpAmountField).sendKeys(Value);
    }

    @Step("Clicking on top up button ")
    public void ClickingOnTopUpButton() {
        wait.until((elementToBeClickable(TopUpButton)));
        driver.findElement(TopUpButton).click();
    }

    @Step("Validating top up error message")
    public Boolean ValidatingTopUpErrorMessage() {
        wait.until((visibilityOfElementLocated(TopUpErrorMessage)));
        return driver.findElement(TopUpErrorMessage).isDisplayed();
    }

    @Step("Validating carousel alert pop up")
    public Boolean ValidatingCarouselAlertPopUp() {
        try {
            wait.until((visibilityOfElementLocated(CarouselAlertPopUp)));
            return driver.findElement(CarouselAlertPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on selected inventory delete button ")
    public void ClickingOnSelectedInventoryDeleteButton() {
        wait.until((elementToBeClickable(SelectedInventoryDeleteButton)));
        driver.findElement(SelectedInventoryDeleteButton).click();
    }

    @Step("Validating deleted inventory")
    public Boolean ValidatingDeletedInventory() {
        boolean Flag = false;
        boolean IsVisible = wait.until(invisibilityOfElementLocated(SelectedInventoryFrame));
        if (IsVisible)
            Flag = true;
        return Flag;

    }

    final By SideCart = By.xpath("//div[contains(@class,'brand-ads-inventory-cart')]");

    @Step("Clicking on selected inventory delete confirmation button ")
    public void ClickingOnSelectedInventoryDeleteConfirmationButton() {
        wait.until((elementToBeClickable(SelectedInventoryDeleteConfirmationButton)));
        driver.findElement(SelectedInventoryDeleteConfirmationButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(SideCart));
    }

    @Step("Entering data in inventory search field ")
    public void EnteringDataInInventorySearchField(String InventoryName) {
        wait.until((elementToBeClickable(InventorySearchField)));
        driver.findElement(InventorySearchField).sendKeys(InventoryName);
    }

    @Step("Validating inventory search results")
    public Boolean ValidatingInventorySearchResults() {
        try {
            wait.until((visibilityOfElementLocated(InventoryPageResults)));
            return driver.findElement(InventoryPageResults).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Selecting video from media library guaranteed campaign")
    public void SelectingVideoFromMediaLibrary(int VideoNo) {
        String XpathFormatter = String.format(AwarenessMediaLibraryVideoSelection, VideoNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Validating inventory search results")
    public Boolean ValidatingBiddableCPMErrorMessage() {
        try {
            wait.until((visibilityOfElementLocated(BiddableCpmErrorMessage)));
            return driver.findElement(BiddableCpmErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating biddable cpm field")
    public Boolean ValidatingBiddableCPMFieldData() {
        wait.until((visibilityOfElementLocated(BiddableCPMTextField)));
        String text = driver.findElement(BiddableCPMTextField).getText();
//        System.out.println(text);
        return driver.findElement(BiddableCPMTextField).getText().contains("-");
    }

    @Step("Validating daily budget value less then biddable value error")
    public Boolean ValidatingDailyBudgetValueLessThenBiddableValueError() {
        try {
            wait.until((visibilityOfElementLocated(DailyBudgetLowerThanBiddableValueError)));
            return driver.findElement(DailyBudgetLowerThanBiddableValueError).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating daily budget empty field error")
    public Boolean ValidatingDailyBudgetEmptyFieldError() {
        try {
            wait.until((visibilityOfElementLocated(DailyBudgetEmptyError)));
            return driver.findElement(DailyBudgetEmptyError).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on audience targeting section")
    public void ClickingOnAudienceTargeting() throws InterruptedException {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(2000);
//        ExtensiveWait.until( not (ExpectedConditions.visibilityOfElementLocated(performancePage.SaveButtonSpinner)));
        ExtensiveWait.until((elementToBeClickable(AudienceTargeting)));
        driver.findElement(AudienceTargeting).click();
    }

    @Step("Clicking on the search audience field")
    public void ClickingOnSearchAudienceField() {
        wait.until(elementToBeClickable(SearchAudienceField));
        driver.findElement(SearchAudienceField).click();
    }

    @Step("Clicking on the search audience field after selecting an audience")
    public void ClickingOnSearchAudienceFieldAfterSelectingAudience() {
        wait.until(presenceOfElementLocated(SearchAudienceField));
        driver.findElement(SearchAudienceField).click();
    }

    @Step("Entering desired text in search audience field")
    public void EnteringDesiredTextInSearchAudienceField(String AudienceName) {
        wait.until(visibilityOfElementLocated(SearchAudienceField));
        driver.switchTo().activeElement().sendKeys(AudienceName);
    }

    @Step("Selecting desired audience from audience dropdown")
    public void SelectingDesiredAudience() {
        wait.until(elementToBeClickable(DesiredAudience));
        driver.findElement(DesiredAudience).click();
    }

    @Step("Deselecting selected  audience by clicking the cross button")
    public void DeselectingSelectedAudience() {
        wait.until(elementToBeClickable(CrossButtonNearSelectedAudience));
        driver.findElement(CrossButtonNearSelectedAudience).click();
    }

    @Step("Clicking on create new audience button")
    public void ClickingOnCreateNewAudienceButton() {
        wait.until(visibilityOfElementLocated(CreateNewAudienceButton));
        driver.findElement(CreateNewAudienceButton).click();
    }

    @Step("Clicking on radio button of 'by user activity'  ")
    public void ClickByUserActivityRadioButton() {
        wait.until(elementToBeClickable(ByUserActivityRadioButton));
        driver.findElement(ByUserActivityRadioButton).click();
    }

    @Step("Adding a new audience name")
    public void AddingAudienceNewName(String AudienceName) {
        wait.until(visibilityOfElementLocated(AudienceNameField));
        driver.findElement(AudienceNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AudienceNameField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(AudienceNameField).sendKeys(AudienceName);
    }

    @Step("Clicking on attribute type dropdown")
    public void ClickingAttributeTypeDropdown() {
        wait.until(visibilityOfElementLocated(AttributeTypeDropdown));
        driver.findElement(AttributeTypeDropdown).click();
    }

    @Step("Clicking on second row attribute type dropdown")
    public void ClickingSecondRowAttributeTypeDropdown() {
        wait.until(visibilityOfElementLocated(SecondRowAttributeTypeDropdown));
        driver.findElement(SecondRowAttributeTypeDropdown).click();
    }

    @Step("Selecting desired attribute")
    public void SelectingDesiredAttribute(int desired_attribute) {
        String XpathFormatter = String.format(AttributeOptions, desired_attribute);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("clicking on the condition type dropdown")
    public void ClickingConditionTypeDropdown() {
        wait.until(elementToBeClickable(ConditionTypeDropdown));
        driver.findElement(ConditionTypeDropdown).click();
    }

    @Step("clicking on the Second row condition type dropdown")
    public void ClickingOnSecondRowConditionTypeDropdown() {
        wait.until(elementToBeClickable(SecondRowConditionTypeDropdown));
        driver.findElement(SecondRowConditionTypeDropdown).click();
    }

    @Step("Selecting desired condition")
    public void SelectingDesiredCondition(int desired_options) {
        String XpathFormatter = String.format(ConditionOptions, desired_options);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on value drop down")
    public void ClickingOnValueDropdown() {
        wait.until(visibilityOfElementLocated(ValueDropdown));
        driver.findElement(ValueDropdown).click();
    }

    @Step("Adding Keywords to attribute value field")
    public void AddingKeywordsToAttributeValue(String Keyword) {
        wait.until(visibilityOfElementLocated(AttributeValueField));
        driver.findElement(AttributeValueField).click();
        driver.findElement(AttributeValueField).sendKeys(Keyword);
    }

    @Step("Validating added keyword in attribute value field")
    public boolean ValidatingAddedCustomKeywords(String Keyword, int KeywordNo) {
        wait.until(visibilityOfElementLocated(AttributeValueField));
        String XpathFormatter = String.format(AttributeValueFieldWithValue, KeywordNo);
//        String value = driver.findElement(By.xpath(XpathFormatter)).getText();
        return driver.findElement(By.xpath(XpathFormatter)).getText().equals(Keyword);

    }

    @Step("Clicking on add keyword button")
    public void ClickingOnAddKeywordButton() {
        wait.until(presenceOfElementLocated(AddDesiredValueButton));
        WebElement element = driver.findElement(AddDesiredValueButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
//        driver.findElement(AddKeywordButton).click();
    }

    @Step("Deleting added keyword to attribute field")
    public void ClickingOnDeleteAddedKeywordIcon() {
        wait.until(visibilityOfElementLocated(DeleteKeywordIcon));
        driver.findElement(DeleteKeywordIcon).click();
    }

    @Step("Selecting desired value")
    public void SelectingDesiredValue(int desired_value) {
        String XpathFormatter = String.format(ConditionOptions, desired_value);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on the add attribute button")
    public void ClickOnAddAttributeButton() {
        wait.until(visibilityOfElementLocated(AddAttributeButton));
        driver.findElement(AddAttributeButton).click();
    }

    @Step("Clicking on cross button to delete attribute row")
    public void ClickingAttributeRowDeleteButton() {
        wait.until(visibilityOfElementLocated(AttributeDeleteButton));
        driver.findElement(AttributeDeleteButton).click();
    }

    @Step("Clicking on the save button to add the new audience")
    public void ClickOnAudienceSaveButton() {
        wait.until(visibilityOfElementLocated(AudienceSaveButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((AudienceSaveButton)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Validating successful message after creating audience")
    public boolean ValidatingSuccessfulMsgForCreatingAudience() {
        try {
            wait.until(visibilityOfElementLocated(AudienceCreationSuccessMsg));
            return driver.findElement(AudienceCreationSuccessMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating error message after selecting same audience from dropdown")
    public boolean ValidatingErrorMsgForSelectingSameAudienceFromDropdown() {
        try {
            wait.until(visibilityOfElementLocated(SelectingSameAudienceDropdownErrorMsg));
            return driver.findElement(SelectingSameAudienceDropdownErrorMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on the edit button to edit custom audience")
    public void ClickOnAudienceEditButton() {
        wait.until(visibilityOfElementLocated(EditAudienceButton));
        driver.findElement(EditAudienceButton).click();
    }

    @Step("Validating visibility of audience name field")
    public boolean ValidatingVisibilityOfAudienceNameField() {
        try {
            wait.until(visibilityOfElementLocated(AudienceNameField));
            return driver.findElement(AudienceNameField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on the product category selection dropdown")
    public void ClickOnProductCategoryDropdown() {
        wait.until(visibilityOfElementLocated(ProductCategoryDropdown));
        driver.findElement(ProductCategoryDropdown).click();
    }

    @Step("Adding text to product category field")
    public void AddingTextToProductCategoryField(String keyword) {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        ExtensiveWait.until(presenceOfElementLocated(ProductCategoryField));
        driver.findElement(ProductCategoryField).sendKeys(keyword);
    }

    @Step("Selecting desired product category from the dropdown")
    public void SelectDesiredProductCategory(int ProductCategory) {
        String XpathFormatter = String.format(ProductCategoryOptions, ProductCategory);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on the brand selection dropdown")
    public void ClickOnBrandSelectionDropdown() {
        wait.until(visibilityOfElementLocated(BrandSelectionDropdown));
        driver.findElement(BrandSelectionDropdown).click();
    }

    @Step("Selecting desired brand from the dropdown")
    public void SelectDesiredBrand(int Brand) {
        String XpathFormatter = String.format(BrandOptions, Brand);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on the user action dropdown")
    public void ClickingOnUserActionDropdown() {
        wait.until(elementToBeClickable(UserActionDropdown));
        driver.findElement(UserActionDropdown).click();
    }

    @Step("Selecting desired user action from the dropdown")
    public void SelectDesiredUserAction(int UserAction) {
        String XpathFormatter = String.format(Options, UserAction);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on the duration dropdown")
    public void ClickingOnDurationDropdown() {
        wait.until(elementToBeClickable(DurationDropdown));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(DurationDropdown)).perform();
        wait.until(elementToBeClickable(DurationDropdown));
        driver.findElement(DurationDropdown).click();
    }

    @Step("Selecting desired user action from the dropdown")
    public void SelectDesiredDuration(int duration) {
        String XpathFormatter = String.format(Options, duration);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Select desired frequency of user action")
    public void SelectingDesiredFrequencyOfUserAction(int frequency) {
        String XpathFormatter = String.format(ActionFrequency, frequency);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        WebElement element = driver.findElement(By.xpath(XpathFormatter));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @Step("Validating Error Message without filling mandatory fields clicking save button")
    public boolean ValidatingErrorMsgWithoutFillingAnyDetailClickingSaveButton() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMsgForNotFilingMandatoryDetails));
            return driver.findElement(ErrorMsgForNotFilingMandatoryDetails).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }

    }

    @Step("Clicking apply button after choosing desired audience")
    public void ClickingAudienceApplyButton() {
        wait.until(elementToBeClickable(AudienceApplyButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((AudienceApplyButton)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(AudienceApplyButtonDisabled));

    }

    @Step("Validating pop up while changing audience")
    public boolean ValidatingPopUpWhileChangingAudience() {
        try {
            wait.until(visibilityOfElementLocated(YesButton));
            return driver.findElement(YesButton).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on auction campaign priority field")
    public void ClickingAuctionCampaignPriorityField() {
        wait.until(elementToBeClickable(AuctionCampaignPriority));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(AuctionCampaignAdvancedSettingsButton)).perform();
        driver.findElement(AuctionCampaignPriority).click();
    }

    @Step("Selecting option from auction campaign priority field")
    public void SelectDropDownFromAuctionCampaignPriority(int DropDownNo) {
        String XpathFormatter = String.format(GenericAuctionCampaignPriorityDropdown, DropDownNo);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on auction advanced settings button")
    public void ClickingOnAuctionAdvancedSettingsButton() {
        wait.until(presenceOfElementLocated(AuctionCampaignAdvancedSettingsButton));
        driver.findElement(AuctionCampaignAdvancedSettingsButton).click();
//        WebElement element = driver.findElement(AuctionCampaignAdvancedSettingsButton);
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//        js.executeScript("arguments[0].click();", element);
    }

    @Step("Adding special characters to the keyword field in auction campaign")
    public boolean ValidateAdditionOfSpecialCharactersInKeywordField() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMessageAddSpecialCharactersInKeywords));
            return driver.findElement(ErrorMessageAddSpecialCharactersInKeywords).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Adding more than 50 Keywords  to the keyword field in auction campaign")
    public boolean AddMoreThan50KeywordsToKeywordField() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMessageAddMoreThan50Keywords));
            return driver.findElement(ErrorMessageAddMoreThan50Keywords).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("After  adding 50 keywords in Keyword field keyword field is disabled in auction campaign")
    public boolean KeywordFieldDisabledAfterAdding50Keywords() {
        wait.until(visibilityOfElementLocated(performancePage.KeywordTextField));
        return driver.findElement(performancePage.KeywordTextField).isEnabled();
    }

    @Step("Add more Than 250 Letters in a keyword in auction campaign")
    public boolean Add250LettersInKeyword() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMessage));
            return driver.findElement(ErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on the add given Keyword button without adding any keyword in auction campaign")
    public boolean ClickAddKeywordWithEmptyKeywordField() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMessageForEmptyKeyword));
            return driver.findElement(ErrorMessageForEmptyKeyword).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on save without adding any keyword in auction campaign")
    public boolean ClickOnSaveWithEmptyKeywordField() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMessageForEmptyKeyword));
            return driver.findElement(ErrorMessageForEmptyKeyword).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking product catalog targeting in step-2 in auction campaign")
    public void ClickProductCatalogTargeting() throws InterruptedException {
        wait.until(visibilityOfElementLocated(ProductCatalogTargeting));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ProductCatalogTargeting)).perform();
//        Thread.sleep(2000);
        wait.until(elementToBeClickable(ProductCatalogTargeting));
        driver.findElement(ProductCatalogTargeting).click();
    }

    @Step("Clicking save in product catalog targeting in auction campaign step -2")
    public void ClickSaveInProductCatalogTargeting() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(elementToBeClickable(SaveButtonInProductCatalogTargeting));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((SaveButtonInProductCatalogTargeting)));

    }

    @Step("Clicking Cancel button to cancel export location")
    public void ClickingCrossButtonToDeselectSelectedSkuFile() {
        wait.until(visibilityOfElementLocated(CrossButtonToDeselectSelectedSkuFile));
        driver.findElement(CrossButtonToDeselectSelectedSkuFile).click();
    }

    @Step("Clicking save in product catalog targeting in auction campaign step -2")
    public void ClickSaveInProductCatalogTargetingAfterUpload() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExtensiveWait.until(visibilityOfElementLocated(CrossButtonToDeselectSelectedSkuFile));
        ExtensiveWait.until(elementToBeClickable(SaveButtonInProductCatalogTargeting));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((SaveButtonInProductCatalogTargeting)));

    }

    @Step("Click On save with empty fields in product catalog targeting in auction campaign")
    public boolean ClickSaveWithEmptyFieldInProductCatalogTargeting() {
        try {
            wait.until(visibilityOfElementLocated(ErrorMessageClickSaveWithEmptyFieldInProductCatalogTargeting));
            return driver.findElement(ErrorMessageClickSaveWithEmptyFieldInProductCatalogTargeting).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking upload in  product catalog targeting in step-2 in auction campaign")
    public void ClickUploadInProductCatalogTargeting() {
        wait.until(visibilityOfElementLocated(UploadInProductCatalogTargeting));
        driver.findElement(UploadInProductCatalogTargeting).click();
    }

    @Step("Uploading file in product catalog targeting in auction campaign")
    public void UploadingFileInProductCatalogTargeting(String FileName) {
        String UserPath = System.getProperty("user.dir");
        String FilePath = UserPath + File.separator + "Resources" + File.separator + "OsmosResources" + File.separator + "Files" + File.separator + FileName;
        driver.findElement(UploadFileFieldInProductCatalogTargeting).sendKeys(FilePath);

    }

    @Step("Check if file is uploaded successfully in auction campaign")
    public boolean ValidateSuccessfulFileUpload() {
        try {
            wait.until(visibilityOfElementLocated(UploadSuccessfulMsg));
            return driver.findElement(UploadSuccessfulMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Check if file is uploaded successfully in auction campaign")
    public boolean ValidateInvalidFileErrorMsg() {
        try {
            wait.until(visibilityOfElementLocated(InvalidFileErrorMsg));
            return driver.findElement(InvalidFileErrorMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Confirm upload In  product catalog targeting in step-2 in auction campaign")
    public void ConfirmButtonInProductCatalogTargeting() {
        wait.until(elementToBeClickable(ConfirmUploadInProductCatalogTargeting));
        driver.findElement(ConfirmUploadInProductCatalogTargeting).click();
    }

    @Step("Clicking custom targeting in step-2 in auction campaign")
    public void ClickCustomTargeting() throws InterruptedException {
        wait.until(visibilityOfElementLocated(CustomTargeting));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(CustomTargeting)).perform();
        Thread.sleep(2000);
        wait.until(elementToBeClickable(CustomTargeting));
        driver.findElement(CustomTargeting).click();
    }

    @Step("Clicking save in custom targeting in step-2 in auction campaign")
    public void ClickSaveInCustomTargeting() {
        wait.until(elementToBeClickable(SaveButtonInCustomTargeting));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((SaveButtonInCustomTargeting)));
    }


    @Step("Check If targeting options are saved in auction campaign")
    public boolean CheckIfTargetingOptionSaves() {
        try {
            wait.until(visibilityOfElementLocated(TextBoxAddKeyword));
            return driver.findElement(TextBoxAddKeyword).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on attribute type dropdown in filters in product catalog targeting in auction campaign")
    public void ClickOnCatalogCategoryTypeDropdown() {
        wait.until(elementToBeClickable(CatalogCategoryTypeDropdown));
        driver.findElement(CatalogCategoryTypeDropdown).click();
    }

    @Step("Clicking On attribute type dropdown in filters in product catalog targeting in auction campaign")
    public void ClickBrandTypeDropdownInProductCatalogTargeting() {
        wait.until(elementToBeClickable(BrandTypeDropdown));
        driver.findElement(BrandTypeDropdown).click();
    }

    @Step("Clicking On add button in filters in product catalog targeting in auction campaign")
    public void ClickAddButtonInProductCatalogTargeting() {
        wait.until(elementToBeClickable(AddButtonInProductCatalogTargeting));
        driver.findElement(AddButtonInProductCatalogTargeting).click();
    }

    @Step("Check functionality of add button  in product catalog targeting in auction campaign")
    public boolean ValidateAdditionOfNewRow() {
        boolean flag = false;
        wait.until(visibilityOfElementLocated(FilterRowInProductCatalogTargeting));
        int count = driver.findElements(FilterRowInProductCatalogTargeting).size();
        if (count == 1)
            flag = true;
        return flag;
    }

    @Step("Clicking on delete button in filters in product catalog targeting in auction campaign")
    public void ClickDeleteButtonInProductCatalogTargeting() {
        wait.until(elementToBeClickable(DeleteButtonInProductCatalogTargeting));
        driver.findElement(DeleteButtonInProductCatalogTargeting).click();
    }

    @Step("Check functionality of row delete button  in product catalog targeting in auction campaign")
    public boolean ValidateDeletionOfFilterRow() {
        boolean flag = true;
        wait.until(invisibilityOfElementLocated(SecondFilterRowInProductCatalogTargeting));
        int count = driver.findElements(FilterRowInProductCatalogTargeting).size();
        if (count == 1)
            flag = false;
        return flag;
    }

    @Step("Validate apply of filter in product catalog targeting")
    public boolean ValidateFilterAppliedInProductCatalogTargeting() {
        try {
            wait.until(elementToBeClickable(FilterVerificationText));
            return driver.findElement(FilterVerificationText).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Selecting option in brand type dropdown in product catalog targeting")
    public void SelectDesiredOptionFromBrandTypeDropdown(int BrandOption) {
        String XpathFormatter = String.format(DesiredAttributeInBrandTypeDropdown, BrandOption);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Downloading the sample file in product catalog targeting in auction campaign")
    public void DownloadSampleFileInProductCatalogTargeting() {
        wait.until(elementToBeClickable(SampleFileDownload));
        driver.findElement(SampleFileDownload).click();
    }

    @Step("Clicking product catalog targeting in step-2 in auction campaign")
    public void ClickDeviceTargeting() throws InterruptedException {
        wait.until(visibilityOfElementLocated(DeviceTargeting));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(DeviceTargeting)).perform();
        Thread.sleep(2000);
        wait.until(elementToBeClickable(DeviceTargeting));
        driver.findElement(DeviceTargeting).click();
    }

    @Step("Clicking on search devices  in Device targeting in auction campaign")
    public void ClickOnSearchDeviceInDeviceTargeting() {
        wait.until(elementToBeClickable(SearchDeviceField));
        driver.findElement(SearchDeviceField).click();
    }

    @Step("Selecting product option in row one field one")
    public void SelectingOptionsFromSearchDeviceDropdown(int RowOptionSelector) {
        String XpathFormatter = String.format(SelectOptionFromSearchDeviceDropdown, RowOptionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on cross on selected option in  search devices  in Device targeting in auction campaign")
    public void DeletingTheSelectedOptionInSearchDeviceInDeviceTargeting(int RowOptionSelector) {
        String XpathFormatter = String.format(DeleteSelectedOption, RowOptionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on  Reset in Device targeting in auction campaign")
    public void ClickOnResetInDeviceTargeting() {
        wait.until(elementToBeClickable(ResetOptionInDeviceTargeting));
        driver.findElement(ResetOptionInDeviceTargeting).click();
        driver.findElement(ClickYesForResetInDeviceTargeting).click();
    }

    @Step("Clicking on  Apply button in device targeting in auction campaign")
    public void ClickOnApplyInDeviceTargeting() {
        wait.until(elementToBeClickable(ApplyInDeviceTargeting));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement((ApplyInDeviceTargeting)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ApplyInDeviceTargetingDisabled));
    }

    @Step("Validate that upon clicking Apply Device targeting options are saved")
    public boolean ValidateDeviceTargetingAppliedSuccessfully() {
        try {
            wait.until(visibilityOfElementLocated(MessageTargetingOptions));
            return driver.findElement(MessageTargetingOptions).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate that upon clicking Apply Device targeting options are saved")
    public boolean ValidateResetInCustomTargeting() {
        try {
            wait.until(visibilityOfElementLocated(ResetSuccessMsg));
            return driver.findElement(ResetSuccessMsg).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Attribute Dropdown in custom targeting in auction campaign")
    public void ClickOnAttributeDropdownInCustomTargeting() {
        wait.until(elementToBeClickable(AttributeDropdownInCustomTargeting));
        driver.findElement(AttributeDropdownInCustomTargeting).click();
    }

    @Step("Clicking on Value Dropdown in custom targeting in auction campaign")
    public void ClickOnValueDropdownInCustomTargeting() {
        wait.until(elementToBeClickable(ValueDropdownInCustomTargeting));
        driver.findElement(ValueDropdownInCustomTargeting).click();
    }

    @Step("Selecting options from Attribute type dropdown in custom targeting in Auction campaign")
    public void SelectingOptionsFromAttributeDropdownInCustomTargeting(int RowOptionSelector) {
        String XpathFormatter = String.format(SelectOptionFromDropdownInCustomTargeting, RowOptionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting options from Value type dropdown in custom targeting in Auction campaign")
    public void SelectingOptionsFromValueDropdownInCustomTargeting(int RowOptionSelector) {
        String XpathFormatter = String.format(SelectOptionFromDropdownInCustomTargeting, RowOptionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on Add Button  in custom targeting in auction campaign")
    public void ClickOnAddButtonInCustomTargeting() {
        wait.until(elementToBeClickable(AddButtonInCustomTargeting));
        driver.findElement(AddButtonInCustomTargeting).click();
    }

    @Step("Clicking on delete button in filters in custom targeting in auction campaign")
    public void ClickDeleteButtonInCustomTargeting() {
        wait.until(elementToBeClickable(DeleteButtonInCustomTargeting));
        driver.findElement(DeleteButtonInCustomTargeting).click();
    }

    @Step("Clicking on  Reset in Catalog targeting in auction campaign")
    public void ClickOnResetInCustomTargeting() {
        wait.until(elementToBeClickable(ResetOptionInCustomTargeting));
        driver.findElement(ResetOptionInCustomTargeting).click();
        driver.findElement(ConfirmResetInCustomTargeting).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Validate that upon clicking Save custom targeting options are saved")
    public boolean CheckSaveInCustomTargeting() {
        try {
            wait.until(visibilityOfElementLocated(MessageTargetingOptionsTemp));
            return driver.findElement(MessageTargetingOptionsTemp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Selecting checkboxes in front of added keywords in keyword targeting")
    public void SelectCheckboxesNextToAddedKeywords(int RowOptionSelector) {
        String XpathFormatter = String.format(CheckBoxesForKeywordsInKeywordTargeting, RowOptionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Clicking on Remove button after selecting keywords in keyword  targeting in auction campaign")
    public void ClickOnRemoveInKeywordTargeting() {
        wait.until(elementToBeClickable(RemoveButtonForRemovingSelectedKeywords));
        driver.findElement(RemoveButtonForRemovingSelectedKeywords).click();
        wait.until(elementToBeClickable(ConfirmRemove));
        driver.findElement(ConfirmRemove).click();
    }

    @Step("Clicking delete icon next to  added keywords in keyword targeting")
    public void ClickDeleteIconNextToAddedKeywords(int RowOptionSelector) {
        String XpathFormatter = String.format(DeleteIconForKeywords, RowOptionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
        wait.until(elementToBeClickable(ConfirmRemove));
        driver.findElement(ConfirmRemove).click();

    }

    @Step("Selecting Home page")
    public void SelectHomePage() {
        wait.until(elementToBeClickable(SelectHomePage));
        driver.findElement(SelectHomePage).click();
    }

    @Step("Selecting Qa Multi inventory page")
    public void SelectQAMultiInventoryPage() {
        wait.until(elementToBeClickable(QAMultiInventoryPage));
        driver.findElement(QAMultiInventoryPage).click();
    }

    @Step("Select inventory after selecting Page")
    public void SelectMultipleInventory(int AvailableCount) throws InterruptedException {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        int inventoryNo = 1;
        int SelectedCount = 0;

        while (SelectedCount < AvailableCount) {
            String inventories = String.format(SelectInventory, inventoryNo);
            ExtensiveWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inventories)));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath(inventories)));
            SelectedCount++;
            Thread.sleep(500);
        }
    }

    @Step("Entering value in Media Estimator Total Budget Field")
    public void EnterValueInMediaEstimatorTotalBudgetField(String input) throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));
        wait.until(elementToBeClickable(MediaEstimatorTotalBudgetFieldEditIcon));
        driver.findElement(MediaEstimatorTotalBudgetFieldEditIcon).click();
        wait.until(presenceOfElementLocated(MediaEstimatorTotalBudgetField));
        driver.findElement(MediaEstimatorTotalBudgetField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(MediaEstimatorTotalBudgetField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(MediaEstimatorTotalBudgetField).sendKeys(input);
        Thread.sleep(800);
        driver.findElement(MediaEstimatorTotalBudgetField).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Validate Media Estimator total budget field with Negative value")
    public boolean ValidateMediaEstimatorTotalBudgetFieldWithNegativeValue() {
        boolean flag = true;
        wait.until(elementToBeClickable(MediaEstimatorTotalBudgetFieldEditIcon));
        driver.findElement(MediaEstimatorTotalBudgetFieldEditIcon).click();
        driver.findElement(MediaEstimatorTotalBudgetField).click();
        String actualText = driver.findElement(MediaEstimatorTotalBudgetField).getAttribute("value");
        if (actualText.contains("-")) {
            flag = false;
        }
        return flag;
    }

    @Step("Selecting Media Estimator CPM Bid Field")
    public void SelectMediaEstimatorCPMBidField(String input) throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
        wait.until(elementToBeClickable(MediaEstimatorCPMBidEditIcon));
        driver.findElement(MediaEstimatorCPMBidEditIcon).click();
        driver.findElement(MediaEstimatorCPMBid).sendKeys(controlOrCommandKey + "a");
        driver.findElement(MediaEstimatorCPMBid).sendKeys(Keys.BACK_SPACE);
        driver.findElement(MediaEstimatorCPMBid).sendKeys(input);
        Thread.sleep(500);
        driver.findElement(MediaEstimatorCPMBid).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }

    @Step("Entering Special characters and alphabets  in total budget field in media estimator ")
    public boolean ValidateMediaEstimatorTotalBudgetFieldWithSpecialCharactersAndAlphabets() {
        boolean flag = false;
        wait.until(elementToBeClickable(MediaEstimatorTotalBudgetFieldEditIcon));
        driver.findElement(MediaEstimatorTotalBudgetFieldEditIcon).click();
        driver.findElement(MediaEstimatorTotalBudgetField).click();
        String actualText = driver.findElement(MediaEstimatorTotalBudgetField).getAttribute("value");
        if (actualText.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Step("Entering Negative value in total budget field in media estimator ")
    public boolean ValidateMediaEstimatorCPMBidFieldWithNegativeValue() {
        boolean flag = true;
        wait.until(elementToBeClickable(MediaEstimatorCPMBidEditIcon));
        driver.findElement(MediaEstimatorCPMBidEditIcon).click();
        driver.findElement(MediaEstimatorCPMBid).click();
        String actualText = driver.findElement(MediaEstimatorCPMBid).getAttribute("value");
        if (actualText.contains("-")) {
            flag = false;
        }
        return flag;
    }

    @Step("Entering Special characters and alphabets  in total budget field in media estimator ")
    public boolean ValidateMediaEstimatorCPMBidFieldWithSpecialCharactersAndAlphabets() {
        boolean flag = false;
        wait.until(elementToBeClickable(MediaEstimatorCPMBidEditIcon));
        driver.findElement(MediaEstimatorCPMBidEditIcon).click();
        driver.findElement(MediaEstimatorCPMBid).click();
        String actualText = driver.findElement(MediaEstimatorCPMBid).getAttribute("value");
        if (actualText.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Step("Clicking back button")
    public void ClickBackButton() {
        wait.until(elementToBeClickable(BackButton));
        driver.findElement(BackButton).click();
    }

    @Step("Validation of delete icons for inventories after saving")
    public boolean ValidateDeleteIconForInventories(int RowOptionSelector) {
        String XpathFormatter = String.format(DeleteIconForInventories, RowOptionSelector);
        wait.until(visibilityOfElementLocated(By.xpath(XpathFormatter)));
        return driver.findElement(By.xpath(XpathFormatter)).isEnabled();
    }

    @Step("Clicking targeting options Step-2")
    public void ClickTargetingOptions() {
        wait.until(elementToBeClickable(TargetingOptions));
        driver.findElement(TargetingOptions).click();
    }

    @Step("Clicking soft enter button")
    public void ClickEnterIcon() {
        wait.until(elementToBeClickable(EnterIcon));
        driver.findElement(EnterIcon).click();
    }

    @Step("Validation of Targeting Options Without selecting page  ")
    public boolean ValidateTargetingOptionsWithoutSelectingPage() {
        wait.until(elementToBeClickable(TargetingOptions));
        return driver.findElement(TargetingOptions).isEnabled();
    }

    @Step("Verify added inventories are visible in the overview panel")
    public boolean VerifyAddedInventoriesAreInvisibleInOverviewPanel() {
        boolean flag = false;
        wait.until(presenceOfAllElementsLocatedBy(InventoryInOverviewPanel));
        int CountOfInventoriesInOverviewPanel = driver.findElements(InventoryInOverviewPanel).size();
        int CountOfInventoriesSelected = driver.findElements(SelectedInventories).size();
//        System.out.println(CountOfInventoriesInOverviewPanel + "And" +CountOfInventoriesSelected);
        if (CountOfInventoriesInOverviewPanel == CountOfInventoriesSelected) {
            flag = true;
        }
        return flag;
    }

    @Step("Verify added inventories are visible in the overview panel")
    public boolean ValidateDeleteIconsAreDisabled(int count) {
        String XpathFormatter = String.format(DeleteIconForInventories, count);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathFormatter)));
        String Class = String.valueOf(driver.findElement(By.xpath(XpathFormatter)).getAttribute("class"));
        boolean flag = Class.contains("read-only");
        return flag;

    }


    @Step("Selecting options from the dropdown in product catalog targeting")
    public void SelectOptionsFromDropdownInProductCatalogTargeting(int RowOptionSelector) {
        String XpathFormatter = String.format(OptionsInDropDown, RowOptionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Selecting Attribute type dropdown field")
    public void SelectingAttributeTypeDropdown(int RowOptionSelector) {
        String XpathFormatter = String.format(AttributeTypeDropDownField, RowOptionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting Attribute type dropdown field")
    public void SelectingConditionTypeDropdown(int RowOptionSelector) {
        String XpathFormatter = String.format(ConditionTypeDropDownField, RowOptionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting Attribute type dropdown field")
    public void SelectingBrandTypeDropdown(int RowOptionSelector) {
        String XpathFormatter = String.format(BrandTypeDropDownField, RowOptionSelector);
        wait.until(elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Confirm After Clicking save in product catalog targeting in step-2 in auction campaign")
    public void ConfirmAfterClickingSaveInProductCatalogTargeting() {
        wait.until(elementToBeClickable(ConfirmInProductCatalogTargeting));
        driver.findElement(ConfirmInProductCatalogTargeting).click();
    }

    @Step("Validate visibility of confirm button after switching between upload and filter")
    public boolean ValidateVisibilityOfConfirmButton() {
        try {
            wait.until(elementToBeClickable(ConfirmInProductCatalogTargeting));
            return driver.findElement(ConfirmInProductCatalogTargeting).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Confirm After Clicking save in product catalog targeting in step-2 in auction campaign")
    public void ClickClearAllInProductCatalogTargeting() {
        wait.until(elementToBeClickable(ClearAllButtonInProductCatalogTargeting));
        driver.findElement(ClearAllButtonInProductCatalogTargeting).click();
    }

    @Step("Clicking on selected month")
    public String ReturnNextMonth(int NextFutureMonth) {
        LocalDate nextMonthDate = LocalDate.now().plusMonths(NextFutureMonth);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        String FormattedDate = nextMonthDate.format(formatter);
        return FormattedDate;
    }


    @Step("Clicking on pop up close button")
    public void ClickingOnPopUpCloseButton() {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(4));
        ExtensiveWait.until(elementToBeClickable(GenericPopUpCloseButton));
        driver.findElement(GenericPopUpCloseButton).click();
    }

    @Step("Clicking on desktop menu button")
    public void ClickOnDesktopMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DesktopMenuButton));
        driver.findElement(DesktopMenuButton).click();
    }

    @Step("Clicking on the notification setting option")
    public void ClickOnNotificationSetting() {
        wait.until(ExpectedConditions.elementToBeClickable(NotificationSettings));
        driver.findElement(NotificationSettings).click();
    }

    @Step("Clicking on campaign alerts delivery email ID field")
    public void ClickOnAlertsDeliveryEmailIdField() {
        wait.until(ExpectedConditions.elementToBeClickable(AlertsDeliveryEmailIdField));
        driver.findElement(AlertsDeliveryEmailIdField).click();
    }

    @Step("Entering desired text to mail id field")
    public void EnterDesiredTextToMailIdField(String EmailId) {
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(EmailId);
    }

    @Step("Validate visibility of email add button")
    public boolean ValidateVisibilityOfValidEmailAddButton() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(6));
            ExtensiveWait.until(ExpectedConditions.elementToBeClickable(EmailValidator));
            return driver.findElement(EmailValidator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Selecting own email ID option")
    public void SelectingOwnEmailID() {
        wait.until(ExpectedConditions.elementToBeClickable(OwnEmailID));
        driver.findElement(OwnEmailID).click();
    }

    @Step("Clicking on save button")
    public void ClickOnSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
        driver.findElement(SaveButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ButtonSpinner));
    }

    @Step("Validate visibility of notification save popup")
    public boolean ValidateSavingOfNotificationSettings() {
        try {
            WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            ExtensiveWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SuccessSavePopup));
            return driver.findElement(SuccessSavePopup).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    private static String OsmosSellerUrl = "https://osmos-qa-staging-1.onlinesales.ai/";

    public void RetryOnFail(Runnable action) {
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
                TakeScreenshotOnSoftAssertion("Test Failed due to " + Message + " Attempt: " + attempts);

                if (System.getProperty("url") != null)
                    OsmosSellerUrl = System.getProperty("url");

                driver.navigate().to(OsmosSellerUrl);
            }
        }
        if (!success) {
            Assert.fail("Action failed after multiple attempts due to: " + Message);
        }
    }
    //--------------------------------------------------------------------------------------------------


    final By SelectAllCheckBox = By.xpath("//div[contains(@class,'pendo_feature_inventory_select_all')]/label");
    final By TopBannerFormat = By.xpath("(//div[contains(@class,'pendo-track-creative-tab-menu-top-banner')])[1]");
    final By CPMRadioButton = By.xpath("//div[contains(@class,'pendo_feature_inventory_auction_buying_type_cpm')]");
    final By CPCRadioButton = By.xpath("//div[contains(@class,'pendo_feature_inventory_auction_buying_type_cpc')]");
    final String DesiredInventory = ("(//button[contains(@class,'pendo_feature_inventory_select_btn')])[%d]");
    final By AuctionInventorySearchField = By.xpath("//div[contains(@class,'inventory-list-table-wrapper')]/descendant::div[contains(@class,'pendo_feature_table_search_input')]/descendant::input");
    final By DestinationUrlField = By.xpath("//div[contains(@class,'textarea-wrapper')]/textarea");
    final By ChargeableCPCField = By.xpath("//div[contains(@class,'pendo-track-auction-campaign-chargeable-cpc-input')]");
    final By ChargeableCPMField = By.xpath("//div[contains(@class,'pendo-track-auction-campaign-chargeable-cpm-input')]");
    final By SecondChargeableCPMField = By.xpath("(//div[contains(@class,'pendo-track-auction-campaign-chargeable-cpm-input')])[2]");
    final By ConfirmationPopUp = By.xpath("//div[contains(@class,'modal-content')]");
    final By SetButtonForChargeableField = By.xpath("(//button[contains(@class,'pendo_feature_inventory_level_bid_set_edit button')])[1]");
    final By SetButtonForBiddableField = By.xpath("(//button[contains(@class,'pendo_feature_inventory_level_bid_set_edit button')])[2]");
    final By HighestColumnValue = By.xpath("(//div[contains(@class,'clickable-compare-data')]/descendant::span)[1]");
    final By ChargeableValueSaveButton = By.xpath("//button[contains(@class,'pendo_feature_inventory_level_bid_save')]");
    final By MinimumValueErrorMessage = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By PublisherSettingsButton = By.xpath("//button[contains(@class,'pendo_feature_publisher_settings_btn')]");
    final By SecondBiddableCPMField = By.xpath("(//div[contains(@class,'pendo-track-auction-campaign-biddable-cpm-input')])[2]");
    final By CopyToAllButton = By.xpath("//span[contains(@class,'icon icon-copy')]");
    final By ResetButton = By.xpath("//button[contains(@class,'pendo_feature_inventory_level_bid_reset button')]");
    final By WarningMessageForChargeableField = By.xpath("(//div[contains(@class,'error-msg name-error-message')]/descendant::div[contains(@class,'warning-msg')])[1]");
    final By MinimumCPMColumn = By.xpath("(//div[contains(@class,'modal-content')]/descendant::th[contains(@class,'pendo_feature_column_sort_th')])[2]");
    final By PageSearchField = By.xpath("//div[contains(@class,'pendo-track-card-list-page-type-search-input')]/descendant::input");
    final By FirstPage = By.xpath("(//div[contains(@class,'group-container page')])[1]");
    final By IndividualChargeableEditButton = By.xpath("(//td[contains(@class,'right-align editableCell')]/descendant::span)[1]");
    final By WarningIcon = By.xpath("//span[contains(@class,'icon icon-warning-filled error-color')]");
    final By EnterButton = By.xpath("//span[contains(@class,'icon-enter')]");


    @Step("Clicking on CPM radio button")
    public void ClickingOnCPMRadioButton() {
        wait.until(elementToBeClickable(CPMRadioButton));
        driver.findElement(CPMRadioButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));

    }

    @Step("Clicking on CPM radio button")
    public void ClickingOnCPCRadioButton() {
        wait.until(elementToBeClickable(CPCRadioButton));
        driver.findElement(CPCRadioButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(WhiteLoader));

    }

    @Step("Clicking on desired inventory option")
    public void ClickOnDesiredInventory(int optionNo) {
        String formattedXpath = String.format((DesiredInventory), optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Entering data in Auction inventory search field ")
    public void EnteringDataInAuctionInventorySearchField(String InventoryName) {
        wait.until((elementToBeClickable(AuctionInventorySearchField)));
        driver.findElement(AuctionInventorySearchField).sendKeys(InventoryName);
    }

    @Step("Entering data in Auction inventory search field ")
    public void EnteringDataInDestinationUrlField(String url) {
        wait.until((elementToBeClickable(DestinationUrlField)));
        driver.findElement(DestinationUrlField).click();
        driver.switchTo().activeElement().sendKeys(url);
    }

    @Step("Entering data in chargeable cpc field ")
    public void EnteringDataInChargeableCPCField(String chargeableCpc) {
        wait.until((presenceOfElementLocated(ChargeableCPCField)));
        driver.findElement(ChargeableCPCField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(chargeableCpc);
    }

    @Step("Entering data in chargeable cpm field ")
    public void EnteringDataInChargeableCPMField(String chargeableCpc) {
        wait.until((presenceOfElementLocated(ChargeableCPMField)));
        driver.findElement(ChargeableCPMField).click();
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(chargeableCpc);
    }

    @Step("Clicking on Select All inventory checkbox")
    public void ClickOnSelectAllInventoryCheckbox() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SelectAllCheckBox));
        driver.findElement(SelectAllCheckBox).click();
    }

    @Step("Selecting Top Banner Format")
    public void SelectTopBannerFormat() {
        wait.until(elementToBeClickable(TopBannerFormat));
        driver.findElement(TopBannerFormat).click();
    }

    @Step("Validating confirmation popup while changing buying type after customization")
    public boolean ValidateVisibilityOfConfirmationPopup() {
        try {
            wait.until(visibilityOfElementLocated(ConfirmationPopUp));
            return driver.findElement(ConfirmationPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

        @Step("Select multiple inventories after selecting Page")
    public void SelectMultipleInventories(int NumberOfInventories) throws InterruptedException {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        int inventoryNo = 1;
        int SelectedCount = 0;
        while (SelectedCount < NumberOfInventories) {
            String inventories = String.format(DesiredInventory, inventoryNo);
            ExtensiveWait.until(presenceOfElementLocated(By.xpath(inventories)));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath(inventories)));
            SelectedCount++;
            Thread.sleep(200);
        }
    }
//    @Step("Select multiple  inventories after selecting the page")
//    public void SelectMultipleInventories1(int numberOfInventories) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        int inventoryNo = 1;
//        int selectedCount = 0;
//
//        while (selectedCount < numberOfInventories) {
//            String inventoryXPath = String.format(DesiredInventory, inventoryNo);
//            try {
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inventoryXPath)));
//                WebElement inventoryElement = driver.findElement(By.xpath(inventoryXPath));
//                try {
//                    inventoryElement.click();
//                    Thread.sleep(300);
//                } catch (Exception e) {
//                    JavascriptExecutor js = (JavascriptExecutor) driver;
//                    js.executeScript("arguments[0].click();", inventoryElement);
//                }
//                selectedCount++;
//            } catch (TimeoutException e) {
//                System.out.println("Inventory element not found: " + inventoryXPath);
//                break;
//            }
//        }
//        System.out.println("Total inventories selected: " + selectedCount);
//
//    }


    @Step("Deleting selected inventories")
    public void DeletingSelectedInventory(int InventoryNumber) {
        String formattedXpath = String.format(String.valueOf(DeleteIconForInventories), InventoryNumber);
        wait.until(elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Validate after deleting any selected inventory")
    public boolean ValidateDeletionOfInventory() {
        boolean flag = true;
        wait.until(presenceOfAllElementsLocatedBy(InventoryInOverviewPanel));
        int CountOfInventoriesInOverviewPanel = driver.findElements(InventoryInOverviewPanel).size();
        int CountOfInventoriesSelected = driver.findElements(SelectedInventories).size();
        if (CountOfInventoriesInOverviewPanel == CountOfInventoriesSelected) {
            flag = false;
        }
        return flag;
    }

    @Step("Validate chargeable CPC field with special characters and alphabets")
    public boolean ValidateChargeableCPMFieldWithSpecialCharactersAndAlphabets() {
        boolean flag = false;
        wait.until(elementToBeClickable(ChargeableCPMField));
        driver.findElement(ChargeableCPMField).click();
        String actualText = driver.findElement(ChargeableCPMField).getText();
        if (actualText.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Step("Validate chargeable CPM field with negative value ")
    public boolean ValidateChargeableCPMFieldWithNegativeValue() {
        boolean flag = true;
        wait.until(elementToBeClickable(ChargeableCPMField));
        driver.findElement(ChargeableCPMField).click();
        String actualText = driver.findElement(ChargeableCPMField).getText();
        if (actualText.contains("-")) {
            flag = false;
        }
        return flag;
    }

    @Step("Click chargeable set button")
    public void ClickingChargeableSetButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SetButtonForChargeableField));
        driver.findElement(SetButtonForChargeableField).click();
    }

    @Step("Click biddable set button")
    public void ClickingBiddableSetButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SetButtonForBiddableField));
        driver.findElement(SetButtonForBiddableField).click();
    }

    @Step("Entering Chargeable CPM Value Less Than Minimum Value")
    public void EnteringValueLessThanMinimumValue() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HighestColumnValue));
        String Value = driver.findElement(HighestColumnValue).getText();
        int CPMValue = Integer.parseInt(Value);
        driver.findElement(SecondChargeableCPMField).click();
        int LessThanMinimumValue = CPMValue - 1;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(String.valueOf(LessThanMinimumValue));
    }

    @Step("Entering Biddable CPM value Less Than Minimum Value")
    public void EnteringValueLessThanMinimumValueInBiddableField() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HighestColumnValue));
        String Value = driver.findElement(HighestColumnValue).getText();
        int CPMValue = Integer.parseInt(Value);
        driver.findElement(SecondBiddableCPMField).click();
        int LessThanMinimumValue = CPMValue - 1;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(String.valueOf(LessThanMinimumValue));
    }

    @Step("Entering Chargeable CPM Value More Than Minimum Value")
    public void EnteringValueMoreThanMinimumValue() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HighestColumnValue));
        String Value = driver.findElement(HighestColumnValue).getText();
        int CPMValue = Integer.parseInt(Value);
        driver.findElement(SecondChargeableCPMField).click();
        int MoreThanMinimumValue = CPMValue + 1;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(String.valueOf(MoreThanMinimumValue));
    }

    @Step("Entering Biddable CPM Value More Than Minimum Value")
    public void EnteringValueMoreThanMinimumValueInBiddableField() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HighestColumnValue));
        String Value = driver.findElement(HighestColumnValue).getText();
        int CPMValue = Integer.parseInt(Value);
        driver.findElement(SecondBiddableCPMField).click();
        int MoreThanMinimumValue = CPMValue + 1;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(String.valueOf(MoreThanMinimumValue));
    }

    @Step("Click chargeable save button")
    public void ClickChargeableSaveButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ChargeableValueSaveButton));
        driver.findElement(ChargeableValueSaveButton).click();

    }

    @Step("Click reset customized cpc/cpm button")
    public void ClickResetButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ResetButton));
        driver.findElement(ResetButton).click();
    }

    @Step("Validate error message for saving value less than minimum cpc or cpm chargeable value")
    public boolean ValidateErrorMessageForSavingLessThanMinimumValue() {
        try {
            wait.until(visibilityOfElementLocated(MinimumValueErrorMessage));
            return driver.findElement(MinimumValueErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Click publisher Settings button")
    public void ClickPublisherSettingsButton() {
        WebElement element = driver.findElement(PublisherSettingsButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(PublisherSettingsButton).click();
    }

    @Step("Adding value in biddable CPM field")
    public void AddValueInBiddableCPMField(String CPMValue) {
        WebElement element = driver.findElement(BiddableCPMField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(BiddableCPMField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(CPMValue);
    }

    @Step("Validate biddable CPM field with special characters and alphabets")
    public boolean ValidateBiddableCPMFieldWithSpecialCharactersAndAlphabets() {
        boolean flag = false;
        WebElement element = driver.findElement(BiddableCPMField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(BiddableCPMField).click();
        String actualText = driver.findElement(BiddableCPMField).getText();
        if (actualText.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Step("Validate chargeable CPM field with negative value ")
    public boolean ValidateBiddableCPMFieldWithNegativeValue() {
        boolean flag = true;
        WebElement element = driver.findElement(BiddableCPMField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(BiddableCPMField).click();
        String actualText = driver.findElement(BiddableCPMField).getText();
        if (actualText.contains("-")) {
            flag = false;
        }
        return flag;
    }


    @Step("Entering Value Less Than Minimum Value In Individual Chargeable CPM Field")
    public void EnteringValueLessThanMinimumValueInIndividualChargeableCPMField() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HighestColumnValue));
        String Value = driver.findElement(HighestColumnValue).getText();
        int CPMValue = Integer.parseInt(Value);
        driver.findElement(IndividualChargeableEditButton).click();
        int LessThanMinimumValue = CPMValue - 1;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(String.valueOf(LessThanMinimumValue));
    }

    @Step("Entering Value More Than Minimum Value In Individual Chargeable CPM Field")
    public void EnteringValueMoreThanMinimumValueInIndividualChargeableCPMField() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HighestColumnValue));
        String Value = driver.findElement(HighestColumnValue).getText();
        int CPMValue = Integer.parseInt(Value);
        driver.findElement(IndividualChargeableEditButton).click();
        int MoreThanMinimumValue = CPMValue + 1;
        driver.switchTo().activeElement().sendKeys(Keys.CONTROL + "A");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(String.valueOf(MoreThanMinimumValue));
    }

    @Step("Validate warning  for entering value less than minimum cpc or cpm individual chargeable value")
    public boolean ValidateWarningForEnteringLessThanMinimumValue() {
        try {
            wait.until(visibilityOfElementLocated(WarningIcon));
            return driver.findElement(WarningIcon).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking Enter Button")
    public void ClickEnterButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EnterButton));
        driver.findElement(EnterButton).click();
    }

    @Step("Clicking Copy to all Button")
    public void ClickCopyToAllButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CopyToAllButton));
        WebElement element = driver.findElement(CopyToAllButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(CopyToAllButton).click();
    }

    @Step("Validate warning message for entering value less than minimum cpc or cpm chargeable value")
    public boolean ValidateMessageForMinimumChargeableValue() {
        try {
            wait.until(visibilityOfElementLocated(WarningMessageForChargeableField));
            return driver.findElement(WarningMessageForChargeableField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validate warning message for entering value less than minimum cpc or cpm  biddable value")
    public boolean ValidateMessageForMinimumBiddableValue() {
        try {
            wait.until(visibilityOfElementLocated(WarningMessageForChargeableField));
            return driver.findElement(WarningMessageForChargeableField).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking minimum cpm column header")
    public void SortMinimumCPMColumn() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MinimumCPMColumn));
        driver.findElement(MinimumCPMColumn).click();
    }


    @Step("Entering desired text into page search field")
    public void EnterPageName(String page_name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PageSearchField));
        driver.findElement(PageSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(page_name);
    }

    @Step("Clicking on Desired page")
    public void SelectPage() {
        wait.until(ExpectedConditions.elementToBeClickable(FirstPage));
        driver.findElement(FirstPage).click();
    }

    @Step("Entering desired text into inventory search field")
    public void EnterInventoryName(String inventory_name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AuctionInventorySearchField));
        driver.findElement(AuctionInventorySearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(inventory_name);
    }
}