package PagesPulse;

import PagesPulse.CampaignTemplatePage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.security.SecureRandom;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Random;


import static java.lang.String.valueOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class OrdersPage {

    WebDriver driver;
    WebDriverWait wait;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String OrderName = String.valueOf(RandomString(10));
    public String TagName = String.valueOf(RandomString(3));
    public String TagName2 = String.valueOf(RandomString(3));
    public String ImageTagName = String.valueOf(RandomString(3));

    final By BlackLoader = By.xpath("//div[contains(@class,'loader-wrapper black-loader')]");
    final By OrdersButton = By.xpath("//span[contains(@class,'nav-icon icon icon-orders')]");
    final By AllOrdersButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-all-bookings')]/div");
    final By AllOrdersMenuButton = By.xpath("(//button[contains(@class,'dropdown-menu-btn  dropdown-toggle btn btn-primary')])[1]");
    final By AllOrdersEditButton = By.xpath("//a[contains(@class,'pendo_feature_oms_seller_all_orders_dropdown_edit_button dropdown-item')]");
    final By AllOrdersNameField = By.xpath("//div[contains(@class,'pendo-oms-booking-name')]/descendant::input");
    final By AllOrdersDescriptionField = By.xpath("//div[contains(@class,'pendo-oms-booking-description')]/descendant::input");
    final By AllOrdersBillingMonthField = By.xpath("//div[contains(@class,'pendo-oms-booking-billing-month')]/descendant::div[contains(@class,'date-picker-wrapper')]");
    final By NextYearButton = By.xpath("//div[contains(@class,'pendo-oms-booking-billing-month')]/descendant::button[contains(@class,'react-datepicker__navigation--next')]");
    final String BillingFieldMonthSelector = "(//div[contains(@class,'react-datepicker__month-text')])[%d]";
    final By BillingMonthCurrentYear = By.xpath("//div[contains(@class,'react-datepicker__header react-datepicker-year-header')]");
    final By PrevYearButton = By.xpath("//button[contains(@class,'react-datepicker__navigation--previous')]");
    final By AdvertiserCategoryField = By.xpath("//div[contains(@class,'pendo-oms-booking-advertiser-category')]/descendant::div[contains(@class,'universal-dd-wrapper ')]");
    final By AdvertiserCategorySearchField = By.xpath("//div[contains(@class,'pendo-oms-booking-advertiser-category')]/descendant::input");
    final String IABCategoryDropDownOptions = "(//div[contains(@id,'-option-')])[%d]";
    final By SubscriptionCategoryField = By.xpath("//div[contains(@class,'pendo-oms-booking-subscription-category')]/descendant::div[contains(@class,'universal-dd-wrapper ')]");
    final By DevCustomCategoryField = By.xpath("(//div[contains(@class,'universal-dd-wrapper undefined full-border dropdown')])[2]");
    final String CustomCategoryDropDownOptions = "(//div[contains(@id,'-option-')])[%d]";
    final By OrderDetailsSaveButton = By.xpath("(//button[contains(@class,'pendo_feature_oms_booking_form_details_form_next_button')]) | (//button[contains(@class,'pendo_feature_oms_booking_form_details_form_save_button')])");
    final By ProductTemplatePackageTotalCostField = By.xpath("(//div[contains(@class,'input-wrapper  undefined false false border-padding white-bg full-width max-height ')])[2]");
    final By AllOrdersAddComment = By.xpath("//a[contains(@class,'pendo_feature_oms_admin_all_orders_dropdown_add_comment_button')]");
    final By CommentInputField = By.xpath("//div[contains(@class,'submit-input-wrapper')]/textarea");
    final By AddCommentsButton = By.xpath("//div[contains(@class,'pendo_feature_review_comment_only_button ')]");
    final By AddCommentSuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By ReviewOrdersButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-review-bookings')]");
    final By ReviewOrdersViewButton = By.xpath("(//td[contains(@class,'pendo_feature_oms_admin_review_orders_table_view_button')]/button)[1]");
    final By ViewOrdersSearchField = By.xpath("//input[contains(@class,'simple-input ')]");
    final By ViewOrdersSearchResults = By.xpath("//div[contains(@id,'cardList_')]");
    final By MediaTranscodeErrorMessage = By.xpath("//div[contains(@class,'border-solid  default error ')]");
    final By ApproveAndNextButton = By.xpath("//button[contains(@class,'button os-button pendo_feature_oms_review_screen_approve_and_next_button ')]");
    final By ReviewOrdersMediaCards = By.xpath("//div[contains(@class,'common-creative-card ')]");
    final By ReviewOrdersRejectButton = By.xpath("//button[contains(@class,'pendo_feature_oms_review_screen_reject_button ')]");
    final By AddCommentEmptyErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By GoToOrderButton = By.xpath("//button[contains(@class,'button os-button mh-auto button-primary shape-cornor medium     link' )]");
    final By BackButton = By.xpath("//button[contains(@class,'button os-button width-fit button-primary shape-cornor medium     link')]");
    final By CommentIconButton = By.xpath("//img[contains(@class,'pendo_feature_oms_review_screen_view_comment_icon_button')]");
    final By CreateOrderButton = By.xpath("//button[contains(@class,'pendo_feature_oms_seller_create_new_order_button')]");
    final By DevBrandField = By.xpath("(//div[contains(@class,'universal-dd-wrapper undefined full-border dropdown')])[1]");
    final By DevBrandSearchField = By.xpath("//div[contains(@class,'Select__input-container css-19bb58m')]/input");
    final By IABCategoryFieldDevTemp = By.xpath("(//div[contains(@class,'universal-dd-wrapper undefined full-border dropdown')])[2]");
    final By DevBasicInfoNextButton = By.xpath("(//button[contains(@class,'pendo_feature_oms_booking_form_details_form_next_button')])[1]");
    final By OrderCostField = By.xpath("//div[contains(@class,'pendo-oms-booking-order-cost')]/descendant::div[contains(@class,'white-bg')]");
    final By AddProductTemplateButton = By.xpath("//button[contains(@class,'pendo_feature_oms_booking_form_package_template_Selection_empty_state_button')]");
    final By AddProductTemplateSearchField = By.xpath("(//div[contains(@class,'pendo_feature_table_search_input')]/descendant::input)[2]");
    final String AddProductTemplateTableRadioButton = "(//div[contains(@class,'table-body-parent-section ')]/descendant::label[contains(@class,'os-custom-checkbox-label')])[%d]"; //changed
    final By AddProductTemplatesButton = By.xpath("//button[contains(@class,'pendo_feature_oms_seller_add_product_templates_button')]");
    final String StartDateField = "(//div[contains(@class,'pendo-oms-booking-pt-startDate')]/descendant::div[contains(@class,'date-picker-input-wrapper')])[%d]";
    final String EndDateField = "(//div[contains(@class,'pendo-oms-booking-pt-endDate')]/descendant::div[contains(@class,'date-picker-input-wrapper')])[%d]";
    final By GenericMonthField = By.xpath("//div[contains(@class,'month-dropdown')]");
    final String GenericMonthDropDown = "(//div[contains(@id,'-option-')])[%d]";
    final By GenericYearField = By.xpath("//div[contains(@class,'year-dropdown')]");
    final String GenericYearDropDown = "//div[text()='%d']";
    final String GenericDateRange = "(//div[contains(@class,'react-datepicker__day--') and not(contains(@class,'--outside-month'))])[%d]";
    final By GenericHourField = By.xpath("//div[contains(@class,'pendo-track-time-picker-hour-dropdown')]");
    final String GenericHourDropDown = "(//div[contains(@id,'-option-')])[%d]";
    final By GenericMinutesField = By.xpath("//div[contains(@class,'pendo-track-time-picker-minute-dropdown')]");
    final String GenericMinutesDropDown = "(//div[contains(@id,'-option-')])[%d]";
    final By CalenderApplyButton = By.xpath("//button[contains(@class,'pendo-track-time-picker-apply-button')]");
    final String PackageTotalCostField = "(//div[contains(@class,'pendo-oms-booking-pt-package-total-cost')]/descendant::div[contains(@class,'input-wrapper')]/div)[%d]";
    final String BonusRateField = "(//div[contains(@class,'pendo-oms-booking-pt-bonus-rate')]/descendant::div[contains(@class,'input-with-dropdown-wrapper')])[%d]";
    final By BasicInfoNextButton = By.xpath("//button[contains(@class,'pendo_feature_oms_booking_form_details_form_next_button')]");
    final By ProductTemplateNextButton = By.xpath("(//button[contains(@class,'pendo_feature_oms_booking_form_product_template_form_next_button')])");
    final By AddCreativeButton = By.xpath("//button[contains(@class,'pendo_feature_oms_bookings_form_add_creatives_button')]");
    final By CreativeDetailsNameField = By.xpath("//div[contains(@class,'creative-name-wrapper')]/descendant::input");
    final By CreativeDetailsDescriptionField = By.xpath("//div[contains(@class,'pendo-event-tracker-common-form-component-description')]/descendant::input");
    final By CreativeDetailsUrlField = By.xpath("//div[contains(@class,'url-input-wrapper')]");
    final By CreativeDetailsSpecificUrlRadioButton = By.xpath("//label[contains(@for,'SPECIFIC')]");
    final By YesButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn ')]");
    final By CreativeDetailsWebUrlField = By.xpath("(//div[contains(@class,'url-input-wrapper')])[1]");
    final By CreativeDetailsIosUrlField = By.xpath("(//div[contains(@class,'url-input-wrapper')])[2]");
    final By CreativeDetailsAndroidUrlField = By.xpath("(//div[contains(@class,'url-input-wrapper')])[3]");
    final String CreativeDetailsChooseFromLibraryButton = "(//button[contains(@class,'pendo_feature_ads_form_media_upload_video_choose_from_library_button')])[%d]";
    final String CreativeLibraryMediaVideoSelector = "(//div[contains(@class,'video-player-wrapper')])[%d]";
    final By CreativeLibraryChooseButton = By.xpath("//button[contains(@class,'pendo_feature_media_library_save_button ')]");
    final By AddCompanionImagesToggleButton = By.xpath("//label[contains(@class,'pendo_feature_enable_companion_images_toggle_button ')]/span");
    final String CreativeLibraryMediaImageSelector = "(//img[contains(@class,'os-async-img-container__')])[%d]";
    final By AdSchedulingToggleButton = By.xpath("//label[contains(@class,'pendo_feature_ads-scheduling_toggle_button')]/span");
    final By AddTimeSlotsButton = By.xpath("//button[contains(@class,'pendo_track_dynamic_list_custom_add_icon_button ')]");
    final String AdSchedulingSelectDayField = "(//div[contains(@class,'pendo-track-filter-action-dropdown')]/descendant::div[contains(@class,'universal-dropdown-container')])[%d]";
    final String SelectDaysDropDownOptions = "(//div[contains(@class,'option-item-toolti')])[%d]";
    final String SelectTimeSlotField = "(//div[contains(@class,'pendo-track-filter-sub-component-wrapper')]/descendant::div[contains(@class,'universal-dropdown-container')])[%d]";
    final String TimeSlotsDownOptions = "(//div[contains(@class,'option-with-checkbox')])[%d]";
    final By GenericYearFieldText = By.xpath("//div[contains(@class,'year-dropdown')]/descendant::div[contains(@class,'Select__single-value css-1dimb5e-singleValue')]");
    final String GenericOptionsSelector = "(//div[contains(@id,'-option-')])[%d]";
    final String ClickTrackerUrlField = "(//div[contains(@class,'pendo-track-filter-sub-component-wrapper CLICK')]/descendant::input)[%d]";
    final String CreativeTreeMenu = "(//div[contains(@class,'tree-menu-left-tab-section')]/div)[%d]";
    final By CreativeCopyAdField = By.xpath("//div[contains(@class,'os-popover-wrapper')]");
    final By CreativeCopyAdSearchField = By.xpath("//div[contains(@class,'card-search-input')]");
    final String CreativeCopyAdCopyButton = "(//button[contains(@class,'copy-button')])[%d]";
    final String CreativeAdCard = "(//div[contains(@class,'group-container')])[%d]";
    final By CopyAdButton = By.xpath("//div[contains(@class,'fixed-layout-footer  ')]/button");
    final By CopyAdSuccessPopup = By.xpath("//div[contains(@class,'pendo-oms-booking-creative-creation-success')]");
    final By GenericPopupCloseButton = By.xpath("//button[contains(@class,'Toastify__close-button--colored')]");
    final By AdCreativeAddSuccessPopup = By.xpath("//div[contains(@class,'pendo-oms-booking-creative-creation-success')]");
    final By CreativeDetailsBudgetSplitField = By.xpath("//div[contains(@class,'budget-split-wrapper')]/descendant::div[contains(@class,'full-width')]");
    final By PreviewOrderButton = By.xpath("//button[contains(@class,'pendo_feature_oms_booking_form_preview_order_button')]");
    final By SubmitForReviewButton = By.xpath("(//div[contains(@class,'fixed-layout-footer flex')]/button)[2]");
    final By CreativeDetailsStartDateField = By.xpath("//div[contains(@class,'pendo_feature_ads-scheduling_start_date_setup')]/descendant::div[contains(@class,'os-datepicker')]");
    final By AddTrackerButton = By.xpath("//button[contains(@class,'pendo_track_feature_ad_tracker_plus_icon_button')]");
    final String ImpressionUrlField = "(//div[contains(@class,'pendo-track-filter-sub-component-wrapper IMPRESSION')]/descendant::input)[%d]";
    final By CreativeDetailsSaveButton = By.xpath("//button[contains(@class,'pendo-tracking-ads-form-footer-submit-close')]");
    final String TimeSlotsTrashIconButton = "//div[contains(@class,'pendo_ott_feature_remove_rule_action_button')]/span[contains(@class,'icon-trash')]";
    final String TimeSlotsCopyIconButton = "(//div[contains(@class,'duplicate-action')])[%d]";
    final By ScheduleAdRadioButton = By.xpath("//div[contains(@class,'pendo_feature_ads-scheduling_start_end_date ')]/label");
    final By CreativeDetailsMonthField = By.xpath("//div[contains(@class,'month-dropdown')]");
    final String GenericDropDownSelector = "(//div[contains(@id,'-option-')])[%d]";
    final By CreativeDetailsYearField = By.xpath("//div[contains(@class,'year-dropdown')]");
    final By CreativeDetailsEndDateField = By.xpath("//div[contains(@class,'pendo_feature_ads-scheduling_end_date_setup')]/descendant::div[contains(@class,'react-datepicker__input-container')]");
    final String EventTrackerField = "(//div[contains(@class,'pendo-track-filter-action-dropdown')]/descendant::div[contains(@class,'os-select-dropdown')])[%d]";
    final By ConfirmationButtonForAudienceSave = By.xpath("//button[contains(@class,'button pendo_feature_confirmation_modal_action_btn')]");
    final By AddMoreProductTemplatesButton = By.xpath("//button[contains(@class,'pendo_feature_oms_booking_form_package_template_selection_nonempty_state_button')]");
    final By AddFilterResults = By.xpath("(//td[contains(@class,'pendo_feature_oms_package_template_table_name_column_link_button')])[1]");
    final By AddFilterApplyButton = By.xpath("//button[contains(@class,'pendo_feature_pill_filter_submit_button')]");
    final By AddFilterDropdownField = By.xpath("//div[contains(@class,'pendo-track-filter-fincane-operator-toggle-single-dropdown')]/descendant::button");
    final By AddFilterConditionField = By.xpath("//div[contains(@class,'condition-dropdowns')]/descendant::div[contains(@class,'universal-dd-wrapper')]");
    final By AddFilterTypeField = By.xpath("//div[contains(@class,'pendo-track-filter-action-dropdown')]/descendant::div[contains(@class,'universal-dd-wrapper')]");
    final By ProductTemplateAddFilterButton = By.xpath("(//div[contains(@class,'pendo-track-react-table-filter-button')]/button)[2]");
    final By EmptyTemplateErrorMessage = By.xpath("//div[contains(@class,'booking-template-selection-form-wrapper-parent')]/descendant::div[contains(@class,'error-msg name-error-message') and not(contains(@class,'d-none'))]");
    final By InvalidTimeErrorMessage = By.xpath("//div[contains(@class,'pendo-oms-booking-pt-startDate')]/descendant::div[contains(@class,'error-msg')]");
    final By OrderCreationDuplicateNameErrorPopUp = By.xpath("//div[contains(@class,'pendo-oms-booking-api-error')]");
    final By BasicInfoNameFieldEmptyErrorMessage = By.xpath("//div[contains(@class,'pendo-track-field-empty-error')]");
    final By VideoUploadFromSystemButton = By.xpath("//button[contains(@class,'pendo_feature_ads_form_media_upload_video_upload_from_system_button')]/following-sibling::input[contains(@accept,'mp4')]");
    final By CreativesDisplayAdImageUpload = By.xpath("//div[contains(@class,'pendo_feature_media_library_upload_button')]/descendant::input");
    final By VideoCreativeLibraryUploadField = By.xpath("//div[contains(@class,'pendo_feature_media_library_upload_button')]/descendant::input");
    final By DesktopImageUploadFromSystemButton = By.xpath("//button[contains(@class,'pendo_feature_ads_form_media_upload_video_upload_from_system_button')]/following-sibling::input[contains(@accept,'image')]");
    final By MobileImageUploadFromSystemButton = By.xpath("//button[contains(@class,'pendo_feature_ads_form_media_upload_video_upload_from_system_button')]/following-sibling::input[contains(@accept,'image')]");
    final By DailyBudgetSaveButton = By.xpath("//button[contains(@class,'pendo-oms-booking-pt-daily-budget-split-save')]");
    final By CopyToAllButton = By.xpath("//a[contains(@class,'pendo_oms_daily_budget_copy_to_all dropdown-item')]");
    final String DailyBudgetCopyIcon = "(//div[contains(@class,'pendo_new_copy_icon dropdown')]/button)[%d]";
    final String DailyBudgetCapBudgetField = "(//div[contains(@class,'input-with-copy-wrapper')]/div[contains(@class,'input-wrapper')])[%d]";
    final String DailyBudgetRadioButton = "(//div[contains(@class,'selection-checkbox')]/label)[%d]";
    final By SplitEquallyButton = By.xpath("//button[contains(@class,'pendo-oms-booking-pt-daily-budget-split-equally')]");
    final String DailyBudgetCapEditButton = "(//div[contains(@class,'pendo-oms-booking-pt-daily-budget')]/descendant::button)[%d]";
    final String DailyBudgetCapRadioButton = "(//div[contains(@class,'pendo-oms-booking-pt-daily-budget')]/descendant::label)[%d]";
    final By CreativeDetailsSuccessPopUp = By.xpath("//div[contains(@class,'pendo-oms-booking-creative-creation-success')]");
    final By BudgetSplitLessThan100ErrorPopUp = By.xpath("//div[contains(@class,'top-center')]/div[contains(@class,'pendo-oms-booking-creative-budget-split-error')]");
    final By BudgetSplitSuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final String BudgetSplitEditIcon = ("(//span[contains(@class,'icon-edit-filled')])[%d]");
    final By EmptyCreativeErrorPopUp = By.xpath("//div[contains(@class,'pendo-oms-booking-creative-count-error')]");
    final By CompleteAllRequiredFieldsErrorPopUp = By.xpath("//div[contains(@class,'pendo-track-form-empty-toast-error')]");
    final By AddProductTemplatesEmptyTemplateErrorPopUp = By.xpath("//div[contains(@class,'pendo-oms-product-template-row-selection-error')]");
    final By ClickTrackerInvalidUrlErrorMessage = By.xpath("//div[contains(@class,'CLICK')]/descendant::div[contains(@class,'pendo-track-field-url-invalid-error')]");
    final By ClickTrackerEmptyUrlErrorMessage = By.xpath("//div[contains(@class,'CLICK')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]");
    final By impressionTrackerFieldInvalidUrlErrorMessage = By.xpath("//div[contains(@class,'IMPRESSION')]/descendant::div[contains(@class,'pendo-track-field-url-invalid-error')]");
    final By impressionTrackerEmptyFieldErrorPopUp = By.xpath("//div[contains(@class,'IMPRESSION')]/descendant::div[contains(@class,'pendo-track-field-empty-error')]");
    final By ImageTwoWithMoreThanMaximumSizeErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By ImageInvalidDimensionsErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By ImageTwoIncorrectFormatErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By InvalidImageTwoFileErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By InvalidImageFileErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By ImageIncorrectFormatErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By ImageOneInvalidDimensionsErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By ImageWithMoreThanMaximumSizeErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By IncorrectFileFormatErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By InvalidFileErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By VideoIncorrectDimensionsErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By IncorrectVideoTypeFormatErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By VideoWithMoreThan200SecondsErrorPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--error')]");
    final By WebUrlFieldInvalidUrlErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-tving-field-url-invalid-error')])[1]");
    final By IosUrlFieldInvalidUrlErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-tving-field-url-invalid-error')])[1]");
    final By AndroidUrlFieldInvalidUrlErrorMessage = By.xpath("(//div[contains(@class,'pendo-track-tving-field-url-invalid-error')])[1]");
    final By UrlFieldInvalidUrlErrorMessage = By.xpath("//div[contains(@class,'pendo-track-tving-field-url-invalid-error')]");
    final By BudgetSplitMinimumErrorMessage = By.xpath("//div[contains(@class,'pendo-track-field-min-value-error')]");
    final By OrderCostPackageCostErrorMessage = By.xpath("//div[contains(@class,'price-breakdown-form-wrapper')]/descendant::div[contains(@class,'error-msg')]");
    final By CommentAndRejectButton = By.xpath("//div[contains(@class,'pendo_feature_review_comment_and_reject_button')]");
    final By DevOrdersButton = By.xpath("//a[contains(@id,'header-menu-orders')]/span[contains(@class,'icon-order-3')]");
    final By ProductTemplateSaveButton = By.xpath("//button[contains(@class,'pendo_feature_oms_booking_form_product_template_form_save_button')] | //button[contains(@class,'pendo_feature_oms_booking_form_product_template_form_next_button')]");
    final By SetDailyBudgetInputField = By.xpath("//div[contains(@class,'input-with-copy-wrapper')]/descendant::input[contains(@class,'form-control simple-input ')]");
    final By EndDateFieldPulse = By.xpath("//div[contains(@class,'pendo-oms-booking-pt-endDate')]/descendant::div[@class='date-picker-input']");
    final By NonEditStartDateField = By.xpath("//div[contains(@class,'-mode-text undefined')]");
    final By StartDateFieldPulse = By.xpath("//div[contains(@class,'pendo-oms-booking-pt-startDate')]/descendant::div[@class='date-picker-input']");
    final By CreativeSaveButton = By.xpath("//button[contains(@class,'pendo_feature_oms_bookings_form_creatives_cta_button button-primary')]");
    final String ClosedOrderTemplateXPath = "(//div[contains(@class,'card-close  no-background')]/descendant::span[contains(@class,'collapsible-icon ')])[%d]";
    final By BonusLessThanZeroErrorMessage = By.xpath("(//div[contains(@class,'pendo-oms-booking-pt-bonus-rate')]/descendant::div[contains(@class,'error-msg name-error-message')])[3]");
    final By CommentFieldErrorWarning = By.xpath("//div[contains(@class,'submit-input-wrapper')]/descendant::textarea[contains(@class,'form-control error-control')]");
    final By ConfirmButton = By.xpath("//button[contains(@class,'pendo_feature_confirmation_modal_action_btn')]");
    final By OrderApprovedSuccessPopUp = By.xpath("//div[contains(@class,'Toastify__toast Toastify__toast-theme--colored Toastify__toast--success')]");
    final By CommentReviewSuccessPopUp = By.xpath("//div[contains(@class,'pendo-tracking-review-comment-success-toast')]");
    final By OrdersTableSearchField = By.xpath("//div[contains(@class,'table-search-input')]/descendant::input");
    final By AddTagInputField = By.xpath("//div[contains(@class,'tags-edit-modal-body-wrapper')]/descendant::input");
    final By ModelHeaderCloseButton = By.xpath("//div[contains(@class,'modal-header')]/descendant::button");
    final By CrossButtonLevel1 = By.xpath("(//label[@class='pure-toggle-label icon icon-close1' and @data-toggle-label='right'])[1]");
    final By CrossButtonLevel2 = By.xpath("(//label[@class='pure-toggle-label icon icon-close1' and @data-toggle-label='right'])[2]");
    final By CrossButtonLevel3 = By.xpath("(//label[@class='pure-toggle-label icon icon-close1' and @data-toggle-label='right'])[3]");
    final By MarkAsReviewedButton = By.xpath("//span[text()='Mark as Reviewed']");
    final By UnMarkAsReviewedButton = By.xpath("//span[text()='Unmark as Reviewed']");
    final By ApprovedUserText = By.xpath("//label[contains(@class,'text-break text-wrap')]/span");
    final By ApprovedOrderNameText = By.xpath("(//label[contains(@class,'text-break text-wrap')]/span)[1]");
    final By CreativeApproveStatusIcon = By.xpath("//div[contains(@class,'creative-status')]");
    final By VideoPreviewSelector = By.xpath("//div[contains(@class,'show-preview-icon')]/descendant::video");
    final By VideoCreativeLibrarySearchField = By.xpath("//div[contains(@class,' creative-selection-search')]/descendant::input");
    final By VideoCreativeLibraryButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-video-creative_library')]");
    final By VideoCreativeCloseButton = By.xpath("//button[contains(@class,'remove-media-button')]");
    final By ApprovedVideoTickMark = By.xpath("//span[contains(@class,'creative-approved-image')]");
    final By CreativeCardContainer = By.xpath("(//div[contains(@class,'launcher-collapsible-card')])[3]");
    final By AddTagButton = By.xpath("(//div[contains(@class,'media-tags')]/descendant::button)[1]");
    final By AddTagSaveButton = By.xpath("//div[contains(@class,'modal-content')]/descendant::button[contains(@class,'save-btn')]");
    final By AddTagSaveButtonDisabled = By.xpath("//div[contains(@class,'modal-content')]/descendant::button[contains(@class,'save-btn')and contains(@class,'disabled')]");
    final By EditTagButton = By.xpath("//div[contains(@class,'edit-tags')]");
    final By RemoveTagButton = By.xpath("//i[contains(@class,'remove-pill')]");
    final By AddNewCreativeAddButton = By.xpath("//button[contains(@class,'pendo_feature_oms_bookings_form_add')]");
    final By SelectAdAccountField = By.xpath("//div[contains(@class,'universal-dropdown-container')]/descendant::button");
    final By SellerSelectAdAccountField = By.xpath("//div[contains(@class,'os-drodown-wrapper')]");
    final By AdAccountSearchField = By.xpath("//div[contains(@class,'Select__input-container')]/descendant::input");
    final By SellerAdAccountSearchField = By.xpath("//div[contains(@class,'entity-search-and-navigator')]/descendant::input");
    final String SelectAdAccountDropDownXpath = "//div[contains(@id,'-listbox')]/descendant::div[contains(@id,'-option-')][%d]";
    final By SelectAdAccountSearchIcon = By.xpath("//div[contains(@class,'right')]/div[contains(@class,'main-search-icon')]");
    final By CreativelibrarySearchField = By.xpath("//div[contains(@class,'creative-selection-search')]/descendant::input");
    final By DevOrdersTableResults = By.xpath("//td[contains(@class,'pendo_feature_oms_seller_order_list_name_column_link_button')]");
    final By ProductTemplateCard = By.xpath("(//div[contains(@class,'collapsible-card-header')])[2]");
    final By CreativeDeleteIcon = By.xpath("(//div[contains(@class,'pendo_track_ads_card_delete_button')])[1]");
    final By MidFlightSubmitForReviewButton = By.xpath("//button[contains(@class,'pendo_feature_oms_booking_form_mid_flight_submit_for_review_button')]");
    final By PulseOrdersTableResults = By.xpath("//td[contains(@class,'pendo_feature_oms_admin_all_orders_name_column_link_button')]");
    final By PulseOrderCostValue = By.xpath("(//div[contains(@class,'pendo-oms-booking-order-cost')]/descendant::span)[5]");
    final By PulseProductTemplateValue = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-package-total-cost')]/descendant::span)[3]");
    final By PulseProductTemplateTwoValue = By.xpath("(//div[contains(@class,'pendo-event-tracker-common-form-component-package-total-cost')]/descendant::span)[6]");
    final By ReviewChangeButton = By.xpath("(//div[contains(@class,'fixed-layout-footer ')]/descendant::button)[2]");
    final By MidFlightStatusRejected = By.xpath("//label[contains(@class,'mid-flight-status-rejected')]");
    final By ImageCreativeLibraryButton = By.xpath("//a[contains(@class,'pendo-tracking-navbar-submenu-display-ads_creative_library')]");
    final String CreativeProductTemplateCardSelector = "(//div[contains(@class,'tree-menu-container')]/descendant::div[contains(@class,'card-close')])[%d]";
    final By ImageRemoveButton = By.xpath("//button[contains(@class,'remove-media-button')]");
    final By ImageFormat750X122RadioButton = By.xpath("//label[contains(@for,'750_X_122')]");
    final By ImageFormat550X190RadioButton = By.xpath("//label[contains(@for,'550_X_190')]");
    final By imageCreativeLibrarySearchField = By.xpath("//div[contains(@class,'creative-selection-search')]/descendant::input");
    final By ImagePreviewSelector = By.xpath("(//div[contains(@class,'media-list-mosaic-view-container')]/descendant::img)[1]");

    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    Keys controlOrCommandKey = (os.contains("mac")) ? Keys.COMMAND : Keys.CONTROL;

    @Attachment(value = "Screenshot: {name}", type = "image/png")
    public byte[] TakeScreenshotOnSoftAssertion(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    @Step("Click on select ad account field")
    public void ClickOnSelectAdAccountField() {
        wait.until(ExpectedConditions.elementToBeClickable(SelectAdAccountField));
        driver.findElement(SelectAdAccountField).click();
    }

    @Step("Click on seller select ad account field")
    public void ClickOnSellerSelectAdAccountField() {
        wait.until(ExpectedConditions.elementToBeClickable(SellerSelectAdAccountField));
        driver.findElement(SellerSelectAdAccountField).click();
    }

    @Step("Enter data in ad account search field")
    public void EnterDataInAdAccountSearchField(String inputData) {
        wait.until(ExpectedConditions.elementToBeClickable(AdAccountSearchField));
        driver.findElement(AdAccountSearchField).sendKeys(Keys.CONTROL + "a");  // Select all existing content
        driver.findElement(AdAccountSearchField).sendKeys(inputData);  // Enter new data
    }

    @Step("Enter data in seller ad account search field")
    public void EnterDataInSellerAdAccountSearchField(String inputData) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(SellerAdAccountSearchField));
        driver.findElement(SellerAdAccountSearchField).sendKeys(Keys.CONTROL + "a");  // Select all existing content
        driver.findElement(SellerAdAccountSearchField).sendKeys(inputData);  // Enter new data
        Thread.sleep(3000);
    }

    @Step("Click on select ad account search icon")
    public void ClickOnSelectAdAccountSearchIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(SelectAdAccountSearchIcon));
        driver.findElement(SelectAdAccountSearchIcon).click();
    }

    @Step("Select ad account option from dropdown")
    public void SelectAdAccountDropDown(int optionIndex) {
        String XpathFormatter = String.format(SelectAdAccountDropDownXpath, optionIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    public StringBuilder RandomString(int count) {
        String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk_0123456789";
        StringBuilder randomString = new StringBuilder();
        String fixedPart = "QATesting";
        SecureRandom rand = new SecureRandom();

        randomString.append(fixedPart);

        for (int i = 0; i < count; i++) {
            int randomIndex = rand.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            randomString.append(randomChar);
        }

        return randomString;
    }

    @Step("Checking if comment field error warning is displayed")
    public boolean IsCommentFieldErrorWarningDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CommentFieldErrorWarning));
            return driver.findElement(CommentFieldErrorWarning).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    public static StringBuilder createRandomString(int Count) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder randomString = new StringBuilder();
        SecureRandom rand = new SecureRandom();

        for (int i = 0; i < Count; i++) {
            int randomIndex = rand.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(randomIndex));
        }
        return randomString;
    }


    @Step("Clicking on orders  template button")
    public void ClickOnOrdersTemplateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(OrdersButton));
        driver.findElement(OrdersButton).click();
    }

    @Step("Clicking on all orders button")
    public void ClickOnAllOrdersButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersButton));
        driver.findElement(AllOrdersButton).click();
    }

    @Step("Clicking on three dots button")
    public void ClickOnMenuButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersMenuButton));
        driver.findElement(AllOrdersMenuButton).click();
    }

    @Step("Clicking on edit button")
    public void ClickOnEditButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersEditButton));
        driver.findElement(AllOrdersEditButton).click();
    }

    public String ApprovedOrderName;

    @Step("Adding desired name to orders name field")
    public void AddNameInNameField() {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersNameField));
        driver.findElement(AllOrdersNameField).sendKeys(controlOrCommandKey + "a");
        ApprovedOrderName = String.valueOf(RandomString(10));
        driver.findElement(AllOrdersNameField).sendKeys(ApprovedOrderName);
    }

    @Step("Adding desired name to orders name field")
    public void AddNameInNameFieldDev() {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersNameField));
        driver.findElement(AllOrdersNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AllOrdersNameField).sendKeys(RandomString(10));
    }

    @Step("Adding desired name to orders name field")
    public void AddNameInNameField200() {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersNameField));
        driver.findElement(AllOrdersNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AllOrdersNameField).sendKeys(RandomString(201));
    }

    @Step("Adding desired name to orders name field validation")
    public void AddNameInNameFieldValidation(String Text) {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersNameField));
        driver.findElement(AllOrdersNameField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AllOrdersNameField).sendKeys(Text);
    }

    @Step("Enter data in all orders description field")
    public void EnterDataInAllOrdersDescriptionField(int CharacterCount) {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersDescriptionField));
        driver.findElement(AllOrdersDescriptionField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AllOrdersDescriptionField).sendKeys(createRandomString(CharacterCount));
    }

    @Step("Enter data in all orders description field")
    public void EnterDataInAllOrdersDescriptionFieldForSpaces(String Text) {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersDescriptionField));
        driver.findElement(AllOrdersDescriptionField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(AllOrdersDescriptionField).sendKeys(Text);
    }

    @Step("Clicking on billing month field")
    public void ClickOnBillingMonthField() {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersBillingMonthField));
        driver.findElement(AllOrdersBillingMonthField).click();
    }

    @Step("Clicking on billing month next year nav button until desired year selected")
    public void ClickOnBillingMonthNextYearNavButton(String targetYear) {
        int year = Integer.parseInt(targetYear);
        int currentYear = getCurrentYear();

        while (currentYear != year) {
            if (currentYear < year) {
                wait.until(ExpectedConditions.elementToBeClickable(NextYearButton));
                driver.findElement(NextYearButton).click();
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(PrevYearButton));
                driver.findElement(PrevYearButton).click();
            }
            currentYear = getCurrentYear();
        }
    }

    private int getCurrentYear() {
        wait.until(visibilityOfElementLocated(BillingMonthCurrentYear));
        String yearText = driver.findElement(BillingMonthCurrentYear).getText();
        return Integer.parseInt(yearText);
    }

    @Step("Selecting desired  month from billing month field")
    public void SelectingDesiredMonthInBillingMonthField(int MonthNo) {
        String XpathFormatter = String.format(BillingFieldMonthSelector, MonthNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Clicking on advertiser category field")
    public void ClickOnAdvertiserCategoryField() {
        wait.until(ExpectedConditions.elementToBeClickable(AdvertiserCategoryField));
        driver.findElement(AdvertiserCategoryField).click();
    }

    @Step("Clicking on dev iab category field")
    public void ClickOnIABCategoryFieldDevTemp() {
        wait.until(ExpectedConditions.elementToBeClickable(IABCategoryFieldDevTemp));
        driver.findElement(IABCategoryFieldDevTemp).click();
    }

    @Step("Enter data in advertiser category field")
    public void EnterDataInAdvertiserCategorySearchField(String Text) {
        wait.until(ExpectedConditions.elementToBeClickable(AdvertiserCategorySearchField));
        driver.findElement(AdvertiserCategorySearchField).sendKeys(Text);
    }

    @Step("Selecting desired option from iab category ")
    public void SelectingDesiredOptionFromIabCategoryDropDown(int MonthNo) {
        String XpathFormatter = String.format(IABCategoryDropDownOptions, MonthNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Clicking on subscription category field")
    public void ClickOnSubscriptionCategoryField() {
        wait.until(ExpectedConditions.elementToBeClickable(SubscriptionCategoryField));
        driver.findElement(SubscriptionCategoryField).click();
    }

    @Step("Clicking on custom category field")
    public void ClickOnCustomCategoryFieldDevTemp() {
        wait.until(ExpectedConditions.elementToBeClickable(DevCustomCategoryField));
        driver.findElement(DevCustomCategoryField).click();
    }

    @Step("Selecting desired option from custom category ")
    public void SelectingDesiredOptionFromCustomCategoryDropDown(int MonthNo) {
        String XpathFormatter = String.format(CustomCategoryDropDownOptions, MonthNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Clicking on order details save button")
    public void ClickOnOrdersDetailsSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(OrderDetailsSaveButton));
        driver.findElement(OrderDetailsSaveButton).click();
    }

    @Step("Enter data in package total cost field")
    public void EnterDataInProductTemplatePackageTotalCostField(String Value) {
        wait.until(ExpectedConditions.elementToBeClickable(ProductTemplatePackageTotalCostField));
        driver.findElement(ProductTemplatePackageTotalCostField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Value);
    }

    @Step("Clicking on add comments")
    public void ClickOnAddComments() {
        wait.until(ExpectedConditions.elementToBeClickable(AllOrdersAddComment));
        driver.findElement(AllOrdersAddComment).click();
    }

    @Step("Enter data in comment field")
    public void EnterDataInCommentInputField(String Data) {
        wait.until(ExpectedConditions.elementToBeClickable(CommentInputField));
        driver.findElement(CommentInputField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Data);
    }

    @Step("Clicking on add comment button")
    public void ClickOnAddCommentButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddCommentsButton));
        driver.findElement(AddCommentsButton).click();
    }

    @Step("Validating add comment success pop up")
    public boolean ValidateAddCommentSuccessPopUp() {
        try {
            wait.until(visibilityOfElementLocated(AddCommentSuccessPopUp));
            return driver.findElement(AddCommentSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Clicking on review orders button")
    public void ClickOnReviewOrdersButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ReviewOrdersButton));
        driver.findElement(ReviewOrdersButton).click();
    }

    @Step("Clicking on review orders view button")
    public void ClickOnReviewOrdersViewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ReviewOrdersViewButton));
        driver.findElement(ReviewOrdersViewButton).click();
    }

    @Step("Enter data in view order search field")
    public void EnterDataInViewOrderSearchField(String OrderName) {
        wait.until(ExpectedConditions.elementToBeClickable(ViewOrdersSearchField));
        driver.findElement(ViewOrdersSearchField).sendKeys(OrderName);
    }

    @Step("Clicking on  view order search result")
    public void ClickingOnViewOrderSearchResult() {
        wait.until(ExpectedConditions.elementToBeClickable(ViewOrdersSearchResults));
        driver.findElement(ViewOrdersSearchResults).click();
    }

    public boolean Approved;
    public boolean Rejected;


    @Step("Validating order creative media's transcode ")
    public boolean ValidatingTranscodeConditionsAndApproving() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(visibilityOfElementLocated(ApproveAndNextButton));
        // Checking if the button is disabled or enabled.
        WebElement Button = driver.findElement(ApproveAndNextButton);
        boolean IsDisabled = Button.getAttribute("class").contains("disabled");
        //Finding number of Medias present in the selected order
        List<WebElement> cards = driver.findElements(ReviewOrdersMediaCards);
        int totalCards = cards.size();

        int ErrorCards = 0;
        //Finding number of Failed to transcode medias in the selected order
        for (WebElement card : cards) {
            if (!card.findElements(MediaTranscodeErrorMessage).isEmpty()) {
                ErrorCards++;
            }
        }
        // Determine if the button should be disabled based on card conditions
        boolean shouldBeDisabled;
        if (totalCards == 1 && ErrorCards == 1) {
            // Should be Disabled the button if there is exactly one card , and it contains an error
            shouldBeDisabled = true;

        } else if (totalCards >= 1 && ErrorCards < totalCards) {
            // Should be Enabled the button if there are multiple cards and at least one card is error-free
            shouldBeDisabled = false;

        } else {
            // Should be Disabled the button if all cards have errors
            shouldBeDisabled = (ErrorCards == totalCards);

        }
        // Comparing the actual button state with the expected state.

        boolean result = (IsDisabled == shouldBeDisabled);

        if (result) {
//            System.out.println("Button state is correct.");
            // If the button is not disabled, clicking on it.
            if (!IsDisabled) {
                Approved = true;
//                System.out.println("Approved Button clicked.");
            } else {
                Rejected = true;
//                WebElement RejectButton = driver.findElement(ReviewOrdersRejectButton);
//                RejectButton.click();
//                CommentingAndRejectingOrder();
//                System.out.println("Reject button clicked.");
            }

        } else {
            // Edge Case :If the button state does not match
            if (totalCards == 1 && ErrorCards == 1) {
                System.out.println("Assertion Failed: The approve button is enabled despite having only one card with one transcode error.");
            } else {
                System.out.println("Assertion Failed: Button state is incorrect based on the number of cards and errors.");
            }
        }


        return result;
    }

    @Step("Validating add comment empty field pop up")
    public boolean ValidateAddCommentEmptyDataErrorPopUp() {
        try {
            wait.until(visibilityOfElementLocated(AddCommentEmptyErrorPopUp));
            return driver.findElement(AddCommentEmptyErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }

    }

    @Step("Validating add comment field only spaces error pop up")
    public boolean ValidateAddCommentOnlySpacesErrorPopUp() {
        try {
            wait.until(visibilityOfElementLocated(AddCommentEmptyErrorPopUp));
            return driver.findElement(AddCommentEmptyErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }

    }

    @Step("Clicking on approve and next button")
    public void ClickOnApproveAndNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ApproveAndNextButton));
        driver.findElement(ApproveAndNextButton).click();

    }

    @Step("Clicking on Yes button")
    public void ClickOnYesButtonToConfirm() {
        wait.until(visibilityOfElementLocated(ConfirmationButtonForAudienceSave));
        driver.findElement(ConfirmationButtonForAudienceSave).click();
    }

    @Step("Clicking on reject button")
    public void ClickOnRejectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ReviewOrdersRejectButton));
        driver.findElement(ReviewOrdersRejectButton).click();
    }

    @Step("Commenting and rejecting an order")
    public void CommentingAndRejectingOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(CommentInputField));
        driver.findElement(CommentInputField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys("Qa Testing");

        wait.until(ExpectedConditions.elementToBeClickable(CommentAndRejectButton));
        driver.findElement(CommentAndRejectButton).click();
    }

    @Step("Clicking on go to orders button")
    public void ClickOnGoToOrdersButton() {
        wait.until(ExpectedConditions.elementToBeClickable(GoToOrderButton));
        driver.findElement(GoToOrderButton).click();
    }

    @Step("Clicking on back button")
    public void ClickOnBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(BackButton));
        driver.findElement(BackButton).click();
    }

    @Step("Clicking on comment icon button")
    public void ClickOnCommentIconButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CommentIconButton));
        driver.findElement(CommentIconButton).click();
    }

    @Step("Clicking on create order button")
    public void ClickOnCreateOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateOrderButton));
        driver.findElement(CreateOrderButton).click();
    }

    @Step("Clicking on create order brand field")
    public void ClickOnCreateOrderBrandField() {
        wait.until(ExpectedConditions.elementToBeClickable(DevBrandField));
        driver.findElement(DevBrandField).click();
    }

    @Step("Enter data in dev brand search field")
    public void EnterDataInDevBrandSearchField(String Text) {
        wait.until(ExpectedConditions.elementToBeClickable(DevBrandSearchField));
        driver.findElement(DevBrandSearchField).sendKeys(Text);
    }

    @Step("Selecting desired option from dev brand drop down")
    public void SelectingDesiredOptionFromDebBrandDropDown(int OptionNo) {
        String XpathFormatter = String.format(IABCategoryDropDownOptions, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Clicking on dev basic info save button")
    public void ClickOnCreateOrderBasicInfoSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DevBasicInfoNextButton));
        driver.findElement(DevBasicInfoNextButton).click();
    }

    @Step("Enter data in order cost field")
    public void EnterDataInOrderCostField(String Value) {
        wait.until(ExpectedConditions.elementToBeClickable(OrderCostField));
        driver.findElement(OrderCostField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Value);
    }

    @Step("Clicking on create order add template button")
    public void ClickOnCreateOrderAddTemplateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddProductTemplateButton));
        driver.findElement(AddProductTemplateButton).click();
    }

    @Step("Enter data in add template search field")
    public void EnterDataInAddTemplateSearchField(String Text) {
        wait.until(ExpectedConditions.elementToBeClickable(AddProductTemplateSearchField));
        driver.findElement(AddProductTemplateSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Text);
    }

    @Step("Selecting desired template radio button from table")
    public void SelectingDesiredTemplateRadioButtonFromTable(int RadioNo) throws InterruptedException {
        Thread.sleep(2000);
        String XpathFormatter = String.format(AddProductTemplateTableRadioButton, RadioNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Clicking on add product templates button")
    public void ClickOnAddProductTemplatesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddProductTemplatesButton));
        driver.findElement(AddProductTemplatesButton).click();
    }

    @Step("Clicking start date field for desired template")
    public void ClickStartDateFieldForDesiredTemplate(int TemplateNo) throws InterruptedException {
        Thread.sleep(2000);
        String XpathFormatter = String.format(StartDateField, TemplateNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Clicking end date field for desired template")
    public void ClickEndDateFieldForDesiredTemplate(int TemplateNo) throws InterruptedException {
        Thread.sleep(2000);
        String XpathFormatter = String.format(EndDateField, TemplateNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
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
    public void SelectDesiredDayDayRange(int DayNo) {
        String XpathFormatter = String.format(GenericDateRange, DayNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on hour field ")
    public void ClickOnHourField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(GenericHourField));
        driver.findElement(GenericHourField).click();
    }

    @Step("Selecting desired month from month drop down ")
    public void SelectHourFromHourDropDown(int OptionNo) {
        String XpathFormatter = String.format(GenericHourDropDown, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on hour field ")
    public void ClickOnMinuteField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(GenericMinutesField));
        driver.findElement(GenericMinutesField).click();
    }


    @Step("Selecting desired minute from minute drop down")
    public void SelectMinutesFromMinutesDropDown(int optionNo) {
        String xpathFormatter = String.format(GenericMinutesDropDown, optionNo);
        // Wait for the element to be visible and clickable
        WebElement minuteOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFormatter)));
        // Click the minute option
        minuteOption.click();
    }


    private LocalTime roundToNearestFutureQuarterHour(LocalTime time) {
        int minute = time.getMinute();
        int newMinute;

        if (minute < 15) {
            newMinute = 15;
        } else if (minute < 30) {
            newMinute = 30;
        } else if (minute < 45) {
            newMinute = 45;
        } else {
            newMinute = 0;
            time = time.plusHours(1); // Move to the next hour
        }

        return time.withMinute(newMinute).withSecond(0).withNano(0);
    }

    @Step("Selecting valid time")
    public void SelectValidTime() {
        LocalTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toLocalTime();
//        System.out.println("CurrentTime (KST): " + now);

        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        // Define a formatter to display the time in a readable format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        // Print the current time with timezone
        String formattedTime = currentTime.format(formatter);
//        System.out.println("Current time with timezone (KST): " + formattedTime);


        LocalTime futureTime = now.plusMinutes(60); // Adding 4 hours and 32 minutes
        futureTime = roundToNearestFutureQuarterHour(futureTime); // Round to the nearest future quarter-hour
        int hour = futureTime.getHour();
        int minute = futureTime.getMinute();
        // Convert hour and minute to dropdown option numbers
        int hourOptionNo = hour + 1; // Assuming dropdown options are indexed from 0
        int minuteOptionNo = (minute / 15) + 1; // Adjusting for 1-based indexing (1 = 00, 2 = 15, etc.)
        // Click and select hour
        ClickOnHourField();
        SelectHourFromHourDropDown(hourOptionNo);
        // Click and select minute
        ClickOnMinuteField();
        SelectMinutesFromMinutesDropDown(minuteOptionNo);
    }


    @Step("Selecting the nearest future quarter-hour time based on the current time")
    public void SelectInvalidTime() {
        LocalTime time = LocalTime.now();
        time = roundToNearestFutureQuarterHour(time);  // Round up to the nearest future quarter-hour

        int hour = time.getHour();
        int minute = time.getMinute();

        // Convert hour and minute to dropdown option numbers
        int hourOptionNo = hour + 1; // Adjusting index for the dropdown options
        int minuteOptionNo = (minute / 15) + 1; // Adjusting index for the dropdown options

        // Click and select hour
        ClickOnHourField();
        SelectHourFromHourDropDown(hourOptionNo);

        // Click and select minute
        ClickOnMinuteField();
        SelectMinutesFromMinutesDropDown(minuteOptionNo);
    }


    @Step("Clicking on calender apply button")
    public void ClickOnCalenderApplyButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CalenderApplyButton));
        driver.findElement(CalenderApplyButton).click();
    }

    @Step("Enter data in package total cost field")
    public void EnterDataInPackageTotalCostField(int optionNo, String data) {
        String XpathFormatter = String.format(PackageTotalCostField, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(data);
    }

    @Step("Clicking on the bonus rate field and entering data")
    public void EnterDataInBonusRateField(int optionNo, String value) {
        String XpathFormatter = String.format(BonusRateField, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(value);
    }

    @Step("Clicking on basic info next button")
    public void ClickOnBasicInfoNextButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(BasicInfoNextButton));
        driver.findElement(BasicInfoNextButton).click();
    }

    @Step("Clicking on product template next button")
    public void ClickOnProductTemplateNextButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(ProductTemplateNextButton));
        driver.findElement(ProductTemplateNextButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(BlackLoader));
    }


    @Step("Clicking on add creative button")
    public void ClickOnAddCreativeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddCreativeButton));
        driver.findElement(AddCreativeButton).click();
    }

    @Step("Enter data in creative details name field")
    public void EnterDataInCreativeDetailsNameField(String Name) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsNameField));
        driver.findElement(CreativeDetailsNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Name);
    }

    @Step("Enter data in creative details name field")
    public void EnterDataInCreativeDetailsNameField200() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsNameField));
        driver.findElement(CreativeDetailsNameField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(RandomString(201));
    }

    @Step("Enter data in creative details description field")
    public void EnterDataInCreativeDetailsDescriptionField(int Count) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsDescriptionField));
        driver.findElement(CreativeDetailsDescriptionField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(CreateRandomString(Count));
    }

    public static StringBuilder CreateRandomString(int count) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder randomString = new StringBuilder("QA Testing");
        SecureRandom rand = new SecureRandom();

        // Subtract the length of "QA Testing" from the count to determine how many random characters to add
        int remainingCount = count - "QA Testing".length();

        for (int i = 0; i < remainingCount; i++) {
            int randomIndex = rand.nextInt(CHARACTERS.length());
            randomString.append(CHARACTERS.charAt(randomIndex));
        }

        return randomString;
    }

    @Step("Enter data in creative details url field")
    public void EnterDataInCreativeDetailsUrlField(String URL) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsUrlField));
        driver.findElement(CreativeDetailsUrlField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(URL);
    }

    @Step("Clicking on specific url radio button")
    public void ClickOnCreativeDetailsSpecificUrlRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsSpecificUrlRadioButton));
        driver.findElement(CreativeDetailsSpecificUrlRadioButton).click();
    }

    @Step("Clicking on yes button")
    public void ClickOnYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(YesButton));
        driver.findElement(YesButton).click();
    }

    @Step("Enter data in creative details web url field")
    public void EnterDataInCreativeDetailsWebUrlField(String URL) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsWebUrlField));
        driver.findElement(CreativeDetailsWebUrlField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(URL);
    }

    @Step("Enter data in creative details web url field")
    public void EnterDataInCreativeDetailsIosUrlField(String URL) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsIosUrlField));
        driver.findElement(CreativeDetailsIosUrlField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(URL);
    }

    @Step("Enter data in creative details web url field")
    public void EnterDataInCreativeDetailsAndroidUrlField(String URL) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsAndroidUrlField));
        driver.findElement(CreativeDetailsAndroidUrlField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Keys.BACK_SPACE);
        driver.switchTo().activeElement().sendKeys(URL);
    }

    @Step("Selecting creative details choose from library button")
    public void SelectingCreativeDetailsChooseFromLibraryButton(int OptionNo) {
        String XpathFormatter = String.format(CreativeDetailsChooseFromLibraryButton, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    final By VideoPlayerResumeIcon = By.xpath("(//div[contains(@class,'media-list-mosaic-view-container')]/descendant::button[contains(@class,'play-pause-button')])[1]");

    @Step("Selecting creative library video ")
    public void SelectingCreativeLibraryVideo(int OptionNo) {
        String XpathFormatter = String.format(CreativeLibraryMediaVideoSelector, OptionNo);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(VideoPlayerResumeIcon));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Clicking on creative library choose button")
    public void ClickOnCreativeLibraryChooseButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeLibraryChooseButton));
        wait.until(ExpectedConditions.elementToBeClickable(CreativeLibraryChooseButton));
        driver.findElement(CreativeLibraryChooseButton).click();
    }

    @Step("Clicking on creative library add companion images toggle button")
    public void ClickOnCreativeLibraryAddCompanionImagesToggleButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddCompanionImagesToggleButton));
        driver.findElement(AddCompanionImagesToggleButton).click();
    }

    @Step("Selecting creative library image ")
    public void SelectingCreativeLibraryImage(int OptionNo) {
        String XpathFormatter = String.format(CreativeLibraryMediaImageSelector, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Clicking on creative library ad scheduling toggle button")
    public void ClickOnCreativeLibraryAdSchedulingToggleButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdSchedulingToggleButton));
        driver.findElement(AdSchedulingToggleButton).click();
    }

    @Step("Clicking on creative library add time slots button")
    public void ClickOnCreativeLibraryAddTimeSlotsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddTimeSlotsButton));
        driver.findElement(AddTimeSlotsButton).click();
    }

    @Step("Selecting desired day from ad scheduling select day field drop down")
    public void ClickOnCreativeLibraryAdSchedulingTSelectDayField(int optionNo) {
        String XpathFormatter = String.format(AdSchedulingSelectDayField, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired day from select day drop down")
    public void SelectingDesiredOptionSelectDaysDropDownOptions(int OptionNo) {
        String XpathFormatter = String.format(SelectDaysDropDownOptions, OptionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

    }

    @Step("Selecting desired time slot from select time slot field drop down")
    public void ClickOnClickOnCreativeLibrarySelectTimeSlotField(int optionNo) {
        String XpathFormatter = String.format(SelectTimeSlotField, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired time slot from time slots drop down")
    public void SelectingDesiredTimeSlotFromTimeSlotsDropDown(int optionNo) {
        String XpathFormatter = String.format(TimeSlotsDownOptions, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on creative details start date field")
    public void ClickOnCreativeDetailsStartDateField() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsStartDateField));
        driver.findElement(CreativeDetailsStartDateField).click();
    }

    @Step("Clicking on add tracker button")
    public void ClickOnAddTrackerButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddTrackerButton));
        driver.findElement(AddTrackerButton).click();
    }

    @Step("Enter data in impression URL field")
    public void EnterDataInImpressionUrlField(int FieldNo, String URL) {
        String XpathFormatter = String.format(ImpressionUrlField, FieldNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(URL);
    }


    @Step("Clicking on creative details save button")
    public void ClickOnCreativeDetailsSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsSaveButton));
        driver.findElement(CreativeDetailsSaveButton).click();
    }

    @Step("Selecting desired time slot trash icon button")
    public void SelectingDesiredTimeSlotTrashIconButton(int optionNo) {
        String XpathFormatter = String.format(TimeSlotsTrashIconButton, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired time slot copy icon button")
    public void SelectingDesiredTimeSlotCopyIconButton(int optionNo) {
        String XpathFormatter = String.format(TimeSlotsCopyIconButton, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on schedule ad radio button")
    public void ClickOnScheduleAdRadioButton() {

        wait.until(ExpectedConditions.elementToBeClickable(ScheduleAdRadioButton));
        driver.findElement(ScheduleAdRadioButton).click();
    }

    @Step("Clicking on creative details month field")
    public void ClickOnCreativeDetailsMonthField() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsMonthField));
        driver.findElement(CreativeDetailsMonthField).click();
    }


    @Step("Selecting desired month from month dropdown")
    public void SelectingDesiredMonthFromMonthDropdown(int optionNo) {
        String XpathFormatter = String.format(GenericDropDownSelector, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Step("Clicking on creative details year field")
    public void ClickOnCreativeDetailsYearField() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsYearField));
        driver.findElement(CreativeDetailsYearField).click();
    }

    @Step("Selecting desired month from month dropdown")
    public void SelectingDesiredYearFromYearDropdown(int optionNo) {
        String XpathFormatter = String.format(GenericDropDownSelector, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Step("Clicking on creative details end date field")
    public void ClickOnCreativeDetailsEndDateField() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsEndDateField));
        driver.findElement(CreativeDetailsEndDateField).click();
    }


    @Step("Selecting desired event tracker field ")
    public void SelectDesiredEventTrackerField(int optionNo) {
        String XpathFormatter = String.format(EventTrackerField, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired option from tracker field")
    public void SelectingDesiredOptionFromTrackerField(int optionNo) {
        String XpathFormatter = String.format(GenericOptionsSelector, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Step("Enter data in click tracker URL field")
    public void EnterDataInClickTrackerUrlField(int fieldIndex, String URL) {
        String XpathFormatter = String.format(ClickTrackerUrlField, fieldIndex);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(URL);
    }


    @Step("Selecting desired option from creative tree menu")
    public void SelectingDesiredOptionFromCreativeTreeMenu(int optionNo) {
        String XpathFormatter = String.format(CreativeTreeMenu, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Step("Clicking on creative copy ad field")
    public void ClickOnCreativeCopyAdField() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeCopyAdField));
        driver.findElement(CreativeCopyAdField).click();
    }


    @Step("Enter data in creative copy ad search field")
    public void EnterDataInCreativeCopyAdSearchField(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeCopyAdSearchField));
        driver.findElement(CreativeCopyAdSearchField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(data);
    }


    @Step("Selecting desired copy button from creative copy ad")
    public void SelectingDesiredCopyButtonFromCreativeCopyAd(int optionNo) {
        String XpathFormatter = String.format(CreativeCopyAdCopyButton, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Step("Selecting desired creative ad card")
    public void SelectingDesiredCreativeAdCard(int optionNo) {
        String XpathFormatter = String.format(CreativeAdCard, optionNo);
        WebElement creativeAdElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        Actions actions = new Actions(driver);
        actions.moveToElement(creativeAdElement).perform();
    }


    @Step("Clicking on copy ad button")
    public void ClickOnCopyAdButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CopyAdButton));
        driver.findElement(CopyAdButton).click();
    }


    @Step("Validating copy ad success popup visibility")
    public boolean IsCopyAdSuccessPopupDisplayed() {
        try {
            wait.until(visibilityOfElementLocated(CopyAdSuccessPopup));
            return driver.findElement(CopyAdSuccessPopup).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on popup close button")
    public void ClickOnPopupCloseButton() throws InterruptedException {
        WebDriverWait ExtensiveWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        ExtensiveWait.until(ExpectedConditions.elementToBeClickable(GenericPopupCloseButton));
        driver.findElement(GenericPopupCloseButton).click();
        Thread.sleep(1000);
    }


    @Step("Validating copy ad success popup visibility")
    public boolean IsAdCreativeAddSuccessPopupDisplayed() {
        try {
            wait.until(visibilityOfElementLocated(AdCreativeAddSuccessPopup));
            return driver.findElement(AdCreativeAddSuccessPopup).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Enter data in creative details budget split field")
    public void EnterDataInCreativeDetailsBudgetSplitField(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsBudgetSplitField));
        driver.findElement(CreativeDetailsBudgetSplitField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(data);
    }

    @Step("Clicking on preview order button")
    public void ClickOnPreviewOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(PreviewOrderButton));
        driver.findElement(PreviewOrderButton).click();
    }

    @Step("Clicking on submit for review button")
    public void ClickOnSubmitForReviewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SubmitForReviewButton));
        driver.findElement(SubmitForReviewButton).click();
    }

    @Step("Selecting desired daily budget cap radio button")
    public void SelectingDesiredDailyBudgetCapRadioButton(int optionNo) {
        String XpathFormatter = String.format(DailyBudgetCapRadioButton, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting desired daily budget cap edit button")
    public void SelectingDesiredDailyBudgetCapEditButton(int optionNo) {
        String XpathFormatter = String.format(DailyBudgetCapEditButton, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on split equally button")
    public void ClickOnSplitEquallyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SplitEquallyButton));
        driver.findElement(SplitEquallyButton).click();
    }

    @Step("Selecting desired daily budget radio button")
    public void SelectingDesiredDailyBudgetRadioButton(int optionNo) {
        String XpathFormatter = String.format(DailyBudgetRadioButton, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Enter data in daily budget cap budget field")
    public void EnterDataInDailyBudgetCapBudgetField(int optionNo, String Value) {
        String XpathFormatter = String.format(DailyBudgetCapBudgetField, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Value);
    }

    @Step("Selecting desired daily budget copy icon")
    public void SelectingDesiredDailyBudgetCopyIcon(int FieldNo, int optionNo) {
        String XpathFormatter = String.format(DailyBudgetCopyIcon, optionNo);
        String XpathFormatter2 = String.format(DailyBudgetCapBudgetField, optionNo);
        WebElement creativeAdElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        Actions actions = new Actions(driver);
        actions.moveToElement(creativeAdElement).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Clicking on copy to all button")
    public void ClickOnCopyToAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CopyToAllButton));
        driver.findElement(CopyToAllButton).click();
    }


    @Step("Clicking on daily budget save button")
    public void ClickOnDailyBudgetSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DailyBudgetSaveButton));
        driver.findElement(DailyBudgetSaveButton).click();
    }

    @Step("Selecting desired video upload from system button")
    public void SelectingDesiredVideoUploadFromSystemButton(String FileName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AddTrackerButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" + File.separator + "PulseResources" + File.separator + "Videos" + File.separator + FileName;
        driver.findElement(VideoUploadFromSystemButton).sendKeys(Filepath);
    }

    @Step("Uploading video in creative library upload field")
    public void UploadingVideoInCreativeLibraryUploadField(String FileName) {
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" + File.separator + "PulseResources" + File.separator + "Videos" + File.separator + FileName;
        driver.findElement(VideoCreativeLibraryUploadField).sendKeys(Filepath);
    }


    @Step("Uploading mobile image from system")
    public void ImageOneMediaUploader(String FileName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AddTrackerButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" + File.separator + "PulseResources" + File.separator + "Images" + File.separator + FileName;
        driver.findElement(MobileImageUploadFromSystemButton).sendKeys(Filepath);
    }


    @Step("Uploading desktop image from system")
    public void ImageTwoMediaUploader(String FileName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AddTrackerButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" + File.separator + "PulseResources" + File.separator + "Images" + File.separator + FileName;
        driver.findElement(DesktopImageUploadFromSystemButton).sendKeys(Filepath);
    }


    @Step("Validating basic info name field empty error message")
    public boolean IsBasicInfoNameFieldEmptyErrorMessageDisplayed() {
        try {
            wait.until(visibilityOfElementLocated(BasicInfoNameFieldEmptyErrorMessage));
            return driver.findElement(BasicInfoNameFieldEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating name field accepting more than 200 characters")
    public boolean ValidateNameFieldAcceptingMoreThan200Characters() {
        boolean flag = true;
        String text = driver.findElement(AllOrdersNameField).getAttribute("value");
        if (text.length() > 200) {
            flag = false;
        }
        return flag;
    }


    @Step("Validating order creation duplicate name error pop-up")
    public boolean IsOrderCreationDuplicateNameErrorPopUpDisplayed() {
        try {
            wait.until(visibilityOfElementLocated(OrderCreationDuplicateNameErrorPopUp));
            return driver.findElement(OrderCreationDuplicateNameErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating all orders description field accepting more than 1000 characters")
    public boolean ValidateAllOrdersDescriptionFieldAcceptingMoreThan1000Characters() {
        boolean flag = true;
        String text = driver.findElement(AllOrdersDescriptionField).getAttribute("value");
        if (text.length() > 1000) {
            flag = false;
        }
        return flag;
    }

    @Step("Validating all orders description field accepting only spaces")
    public boolean ValidateAllOrdersDescriptionFieldAcceptingOnlySpaces() {
        String text = driver.findElement(AllOrdersDescriptionField).getAttribute("value");
        return !text.trim().isEmpty();
    }

    @Step("Validating order cost field accepting characters without any error")
    public boolean ValidateOrderCostFieldAcceptingCharacters() {
        wait.until(ExpectedConditions.elementToBeClickable(OrderCostField));
        return driver.switchTo().activeElement().getAttribute("value").equals("Abcd%^$#@&");
    }

    public boolean ValidateOrderCostFieldAcceptingFloatValue() {
        wait.until(ExpectedConditions.elementToBeClickable(OrderCostField));
        return driver.switchTo().activeElement().getAttribute("value").contains(".");
    }

    @Step("Validating order cost field accepting negative value without any error")
    public boolean ValidateOrderCostFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.elementToBeClickable(OrderCostField));
        return driver.switchTo().activeElement().getAttribute("value").contains("-");
    }

    public boolean CheckIfValueBecomesNegativeAfterDownArrow() {
        wait.until(ExpectedConditions.elementToBeClickable(OrderCostField));
        for (int i = 0; i < 5; i++) {
            driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
        }
        return driver.switchTo().activeElement().getAttribute("value").contains(".");

    }

    @Step("Validating invalid time error message is displayed")
    public boolean IsInvalidTimeErrorMessageDisplayed() {
        try {
            wait.until(visibilityOfElementLocated(InvalidTimeErrorMessage));
            return driver.findElement(InvalidTimeErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating empty template error message is displayed")
    public boolean IsEmptyTemplateErrorMessageDisplayed() {
        try {
            wait.until(visibilityOfElementLocated(EmptyTemplateErrorMessage));
            return driver.findElement(EmptyTemplateErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on product template add filter button")
    public void ClickOnProductTemplateAddFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductTemplateAddFilterButton));
        driver.findElement(ProductTemplateAddFilterButton).click();
    }

    @Step("Clicking on add filter type field")
    public void ClickOnAddFilterTypeField() {
        wait.until(ExpectedConditions.elementToBeClickable(AddFilterTypeField));
        driver.findElement(AddFilterTypeField).click();
    }

    @Step("Selecting desired option from type field")
    public void SelectingDesiredOptionFromAddFilter(int optionNo) {
        String XpathFormatter = String.format(GenericOptionsSelector, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }


    @Step("Clicking on add filter condition field")
    public void ClickOnAddFilterConditionField() {
        wait.until(ExpectedConditions.elementToBeClickable(AddFilterConditionField));
        driver.findElement(AddFilterConditionField).click();
    }


    @Step("Clicking on add filter dropdown field")
    public void ClickOnAddFilterDropdownField() {
        wait.until(ExpectedConditions.presenceOfElementLocated(AddFilterDropdownField));
        driver.findElement(AddFilterDropdownField).click();
    }

    @Step("Clicking on add filter apply button")
    public void ClickOnAddFilterApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddFilterApplyButton));
        driver.findElement(AddFilterApplyButton).click();
    }


    @Step("Validating filter results are displayed")
    public boolean ValidateFilterResultsDisplayed() {
        try {
            wait.until(visibilityOfElementLocated(AddFilterResults));
            return driver.findElement(AddFilterResults).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on add more product templates button")
    public void ClickOnAddMoreProductTemplatesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddMoreProductTemplatesButton));
        driver.findElement(AddMoreProductTemplatesButton).click();
    }


    private static String TvingSellerUrl = "https://oms-qa-staging-1.onlinesales.ai/";

    public void RetryOnFailTvingSeller(Runnable action) {
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
                if (System.getProperty("TvingSellerUrl") != null) TvingSellerUrl = System.getProperty("TvingSellerUrl");
                driver.navigate().to(TvingSellerUrl);


            }
        }
        if (!success) {
            Assert.fail("Action failed after multiple attempts due to: " + Message);
        }
    }


    @Step("Selecting current month from month drop down")
    public boolean SelectCurrentMonthFromMonthDropDown() {
        boolean flag = true;
        int CurrentMonthNumber = LocalDate.now().getMonthValue();
        String XpathFormatter = String.format(GenericMonthDropDown, CurrentMonthNumber);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

        String selectedMonthText = driver.findElement(GenericMonthField).getText().trim().toUpperCase();
        int selectedMonthNumber = Month.valueOf(selectedMonthText).getValue();

        if (selectedMonthNumber != CurrentMonthNumber) {
            flag = false;
        }

        return flag;
    }

    @Step("Selecting end date month from month drop down")
    public boolean SelectEndDateMonthFromMonthDropDown() {
        boolean flag = true;
        int CurrentMonthNumber = LocalDate.now().getMonthValue();
        String XpathFormatter = String.format(GenericMonthDropDown, CurrentMonthNumber);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

        String selectedMonthText = driver.findElement(GenericMonthField).getText().trim().toUpperCase();
        int selectedMonthNumber = Month.valueOf(selectedMonthText).getValue();

        if (selectedMonthNumber != CurrentMonthNumber) {
            flag = false;
        }

        return flag;
    }


    @Step("Selecting current year from year drop down ")
    public boolean SelectCurrentYearFromYearDropdown() {
        boolean flag = true;
        int CurrentYear = LocalDate.now().getYear();
        String XpathFormatter = String.format(GenericYearDropDown, CurrentYear);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

        String selectedYearText = driver.findElement(GenericYearFieldText).getText().trim();
        int selectedYear = Integer.parseInt(selectedYearText);

        if (selectedYear != CurrentYear) {
            flag = false;
        }

        return flag;
    }

    @Step("Selecting current day from day range ")
    public void SelectCurrentDayFromDayRange() {
        int CurrentDay = LocalDate.now().getDayOfMonth();
        String XpathFormatter = String.format(GenericDateRange, CurrentDay);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
    }

    @Step("Selecting current day from day range ")
    public void SelectDayBasedOnTimeAhead() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime futureTime = now.plusHours(24);

        int dayToSelect = futureTime.getDayOfMonth();
        String formattedXPath = String.format(GenericDateRange, dayToSelect);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXPath)));
        driver.findElement(By.xpath(formattedXPath)).click();
    }


    @Step("Validating package total cost field accepting characters without any error")
    public boolean ValidatePackageTotalCostFieldAcceptingCharacters(int optionNo, String inputData) {
        String formattedXpath = String.format(PackageTotalCostField, optionNo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formattedXpath)));
        return driver.findElement(By.xpath(formattedXpath)).getText().equals(inputData);
    }

    @Step("Validating package total cost field accepting float value without any error")
    public boolean ValidatePackageTotalCostFieldAcceptingFloatValue(int optionNo) {
        String formattedXpath = String.format(PackageTotalCostField, optionNo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formattedXpath)));
        return driver.findElement(By.xpath(formattedXpath)).getText().contains(".");
    }

    @Step("Validating package total cost field accepting negative value without any error")
    public boolean ValidatePackageTotalCostFieldAcceptingNegativeValue(int optionNo) {
        String formattedXpath = String.format(PackageTotalCostField, optionNo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formattedXpath)));
        return driver.findElement(By.xpath(formattedXpath)).getText().contains("-");
    }

    @Step("Validating package total cost field becomes negative after pressing the down arrow multiple times")
    public boolean CheckIfValueBecomesNegativeAfterMultipleDownArrows(int optionNo) {
        String XpathFormatter = String.format(PackageTotalCostField, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();

        // Press down arrow 4 times
        for (int i = 0; i < 4; i++) {
            driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
        }
        String value = driver.findElement(By.xpath(XpathFormatter)).getText(); // Get the updated value
        return value.contains("-");
    }

    @Step("Validating bonus rate field accepting characters without any error")
    public boolean ValidateBonusRateFieldAcceptingCharacters(int optionNo) {
        String XpathFormatter = String.format(BonusRateField, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        return driver.switchTo().activeElement().getAttribute("value").equals("Abcd%^$#@&");
    }

    @Step("Validating bonus rate field accepting float value without any error")
    public boolean ValidateBonusRateFieldAcceptingFloatValue(int optionNo) {
        String XpathFormatter = String.format(BonusRateField, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        return driver.switchTo().activeElement().getAttribute("value").contains(".");
    }

    @Step("Validating bonus rate field accepting negative value without any error")
    public boolean ValidateBonusRateFieldAcceptingNegativeValue(int optionNo) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BonusLessThanZeroErrorMessage));
            return driver.findElement(BonusLessThanZeroErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating bonus rate field value becomes negative after using down arrow key")
    public boolean CheckIfBonusRateValueBecomesNegativeAfterDownArrow(int optionNo) {
        String XpathFormatter = String.format(BonusRateField, optionNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathFormatter)));
        driver.findElement(By.xpath(XpathFormatter)).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys("0"); // Set value to 0

        for (int i = 0; i < 4; i++) {
            driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN); // Press down arrow
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BonusLessThanZeroErrorMessage));
            return driver.findElement(BonusLessThanZeroErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }

    }


    @Step("Checking if the order cost and package cost mismatch error message is displayed")
    public boolean IsOrderCostPackageCostErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(OrderCostPackageCostErrorMessage));
            return driver.findElement(OrderCostPackageCostErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating name field accepting more than 200 characters")
    public boolean ValidateCreativeADNameFieldAcceptingMoreThan200Characters() {
        boolean flag = true;
        String text = driver.findElement(CreativeDetailsNameField).getAttribute("value");
        if (text.length() > 200) {
            flag = false;
        }
        return flag;
    }


    @Step("Validating creative details name field accepting only spaces")
    public boolean ValidateCreativeDetailsNameFieldAcceptingOnlySpaces() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsNameField));
        return driver.switchTo().activeElement().getAttribute("value").trim().isEmpty();
    }


    @Step("Validating creative details description field accepting more than 1000 characters")
    public boolean ValidateCreativeDetailsDescriptionFieldAcceptingMoreThan1000Characters() {
        String text = driver.findElement(CreativeDetailsDescriptionField).getAttribute("value");
        return text.length() > 1000;
    }

    @Step("Validating creative details description field accepting only spaces")
    public boolean ValidateCreativeDetailsDescriptionFieldAcceptingOnlySpaces() {
        driver.findElement(CreativeDetailsDescriptionField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(CreativeDetailsDescriptionField).sendKeys("    "); // 4 spaces
        String text = driver.findElement(CreativeDetailsDescriptionField).getAttribute("value");
        return text.trim().isEmpty();
    }


    @Step("Enter data in creative details description field")
    public void EnterDataInCreativeDetailsDescriptionFieldSpaces(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsDescriptionField));
        driver.findElement(CreativeDetailsDescriptionField).click();
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(text);
    }


    @Step("Validating creative details budget split field accepting characters without any error")
    public boolean ValidateCreativeDetailsBudgetSplitFieldAcceptingCharacters() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsBudgetSplitField));
        return driver.switchTo().activeElement().getAttribute("value").equals("Abcd%^$#@&");
    }

    @Step("Validating creative details budget split field accepting float value without any error")
    public boolean ValidateCreativeDetailsBudgetSplitFieldAcceptingFloatValue() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsBudgetSplitField));
        return driver.switchTo().activeElement().getAttribute("value").contains(".");
    }

    @Step("Validating creative details budget split field accepting negative value without any error")
    public boolean ValidateCreativeDetailsBudgetSplitFieldAcceptingNegativeValue() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsBudgetSplitField));
        return driver.switchTo().activeElement().getAttribute("value").contains("-");
    }

    @Step("Validating creative details budget split field value becomes negative after using down arrow key")
    public boolean CheckIfCreativeDetailsBudgetSplitValueBecomesNegativeAfterDownArrow() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsBudgetSplitField));
        for (int i = 0; i < 4; i++) {
            driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN); // Press down arrow
        }
        return driver.switchTo().activeElement().getAttribute("value").contains("-");
    }


    @Step("Validating budget split minimum error message is displayed when entering 0")
    public boolean ValidateBudgetSplitMinimumErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BudgetSplitMinimumErrorMessage));
            return driver.findElement(BudgetSplitMinimumErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating invalid URL error message in Creative Details URL field")
    public boolean ValidateCreativeDetailsUrlFieldInvalidUrlError() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(UrlFieldInvalidUrlErrorMessage));
            return driver.findElement(UrlFieldInvalidUrlErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating URL field with spaces in between")
    public boolean ValidateCreativeDetailsUrlFieldWithSpacesInBetweenError(String Text) {

        wait.until(ExpectedConditions.elementToBeClickable(CreativeDetailsUrlField));
        String urlValue = driver.switchTo().activeElement().getAttribute("value");
        // Check if the URL value contains spaces
        boolean containsSpaces = urlValue.equals(Text);
        return containsSpaces;
    }

    @Step("Validating web URL field with invalid URL")
    public boolean ValidateWebUrlFieldWithInvalidURL() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(WebUrlFieldInvalidUrlErrorMessage));
            return driver.findElement(WebUrlFieldInvalidUrlErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating web URL field with spaces in between")
    public boolean ValidateWebUrlFieldWithSpacesInBetweenError(String Text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(WebUrlFieldInvalidUrlErrorMessage));
            return driver.switchTo().activeElement().getAttribute("value").equals(Text);
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating iOS URL field with invalid URL")
    public boolean ValidateIosUrlFieldWithInvalidURL() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(IosUrlFieldInvalidUrlErrorMessage));
            return driver.findElement(IosUrlFieldInvalidUrlErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating iOS URL field with spaces in between")
    public boolean ValidateIosUrlFieldWithSpacesInBetweenError(String Text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(IosUrlFieldInvalidUrlErrorMessage));
            return driver.switchTo().activeElement().getAttribute("value").equals(Text);
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating Android URL field with invalid URL")
    public boolean ValidateAndroidUrlFieldWithInvalidURL() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AndroidUrlFieldInvalidUrlErrorMessage));
            return driver.findElement(AndroidUrlFieldInvalidUrlErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Android URL field with spaces in between")
    public boolean ValidateAndroidUrlFieldWithSpacesInBetweenError(String Text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AndroidUrlFieldInvalidUrlErrorMessage));
            return driver.switchTo().activeElement().getAttribute("value").equals(Text);
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if error pop-up is displayed for videos longer than 200 seconds")
    public boolean IsVideoWithMoreThan200SecondsErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(VideoWithMoreThan200SecondsErrorPopUp));
            return driver.findElement(VideoWithMoreThan200SecondsErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating if error pop-up for incorrect video file format is displayed")
    public boolean IsIncorrectVideoFileFormatErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(IncorrectVideoTypeFormatErrorPopUp));
            return driver.findElement(IncorrectVideoTypeFormatErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating if error pop-up for incorrect video dimensions is displayed")
    public boolean IsIncorrectDimensionsErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(VideoIncorrectDimensionsErrorPopUp));
            return driver.findElement(VideoIncorrectDimensionsErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating if error pop-up for invalid file upload is displayed")
    public boolean IsInvalidFileErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidFileErrorPopUp));
            return driver.findElement(InvalidFileErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if error pop-up for incorrect file format is displayed")
    public boolean IsIncorrectFileFormatErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(IncorrectFileFormatErrorPopUp));
            return driver.findElement(IncorrectFileFormatErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating if error pop-up for image with more than maximum size is displayed")
    public boolean IsImageWithMoreThanMaximumSizeErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ImageWithMoreThanMaximumSizeErrorPopUp));
            return driver.findElement(ImageWithMoreThanMaximumSizeErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating if error pop-up for image with invalid dimensions is displayed")
    public boolean IsImageOneInvalidDimensionsErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ImageOneInvalidDimensionsErrorPopUp));
            return driver.findElement(ImageOneInvalidDimensionsErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating if error pop-up for image with incorrect format is displayed")
    public boolean IsImageIncorrectFormatErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ImageIncorrectFormatErrorPopUp));
            return driver.findElement(ImageIncorrectFormatErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating if error pop-up for invalid image file is displayed")
    public boolean IsInvalidImageFileErrorPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidImageFileErrorPopUp));
            return driver.findElement(InvalidImageFileErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating if error pop-up for image with more than maximum size is displayed")
    public boolean IsImageWithMoreThanMaximumSizeErrorPopUpDisplayedForImageTwo() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ImageWithMoreThanMaximumSizeErrorPopUp));
            return driver.findElement(ImageWithMoreThanMaximumSizeErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if error pop-up for image with invalid dimensions is displayed")
    public boolean IsImageInvalidDimensionsErrorPopUpDisplayedForImageTwo() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ImageInvalidDimensionsErrorPopUp));
            return driver.findElement(ImageInvalidDimensionsErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if error pop-up for image with incorrect format is displayed")
    public boolean IsImageIncorrectFormatErrorPopUpDisplayedForImageTwo() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ImageIncorrectFormatErrorPopUp));
            return driver.findElement(ImageIncorrectFormatErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if error pop-up for invalid image file is displayed")
    public boolean IsInvalidImageFileErrorPopUpDisplayedForImageTwoForImageTwo() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidImageFileErrorPopUp));
            return driver.findElement(InvalidImageFileErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Checking if Impression Tracker empty field error is displayed")
    public boolean CheckIfImpressionTrackerEmptyFieldErrorIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(impressionTrackerEmptyFieldErrorPopUp));
            return driver.findElement(impressionTrackerEmptyFieldErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Checking if Impression Tracker field invalid URL error message is displayed")
    public boolean CheckIfImpressionTrackerFieldInvalidUrlErrorMessageIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(impressionTrackerFieldInvalidUrlErrorMessage));
            return driver.findElement(impressionTrackerFieldInvalidUrlErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if Impression Tracker field is accepting spaces in between the text")
    public boolean ValidateImpressionUrlFieldAcceptingSpacesInBetween(String Text) {
        String urlValue = driver.switchTo().activeElement().getAttribute("value");
        return urlValue.equals(Text);
    }


    @Step("Validating if Click Tracker URL field shows invalid URL error message")
    public boolean ValidateClickTrackerInvalidUrlErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ClickTrackerInvalidUrlErrorMessage));
            return driver.findElement(ClickTrackerInvalidUrlErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if Click Tracker URL field shows empty URL error message")
    public boolean ValidateClickTrackerEmptyUrlErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ClickTrackerEmptyUrlErrorMessage));
            return driver.findElement(ClickTrackerEmptyUrlErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if Click Tracker URL field is accepting spaces in between the text")
    public boolean ValidateClickTrackerUrlFieldAcceptingSpacesInBetween(String Text) {
        String urlValue = driver.switchTo().activeElement().getAttribute("value");
        return urlValue.equals(Text);
    }


    @Step("Validating if Add Product Templates Empty Template error pop-up is displayed")
    public boolean ValidateAddProductTemplatesEmptyTemplateErrorPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(AddProductTemplatesEmptyTemplateErrorPopUp));
            return driver.findElement(AddProductTemplatesEmptyTemplateErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if 'Complete All Required Fields' error pop-up is displayed after clicking save without any data")
    public boolean ValidateCompleteAllRequiredFieldsErrorPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CompleteAllRequiredFieldsErrorPopUp));
            return driver.findElement(CompleteAllRequiredFieldsErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating if 'Empty Creative' error pop-up is displayed")
    public boolean ValidateEmptyCreativeErrorPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(EmptyCreativeErrorPopUp));
            return driver.findElement(EmptyCreativeErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Edit Daily budget Icon  ")
    public void ClickOnDailyBudgetEditIcon(int DailyBudgetIconNo) {
        String xpathFormatter = String.format(BudgetSplitEditIcon, DailyBudgetIconNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }

    @Step("Entering Data in the Daily budget ")
    public void EnterDataInBudgetSplit(String Text) {
        driver.switchTo().activeElement().sendKeys(controlOrCommandKey + "a");
        driver.switchTo().activeElement().sendKeys(Text);
    }

    @Step("Validating Budget Split field accepting negative values after pressing down arrow key 4 times without any error")
    public boolean ValidateBudgetSplitFieldAcceptingNegativeValuesWithDownArrowMultipleTimes() {
        try {
            for (int i = 0; i < 4; i++) {
                driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN); // Simulate pressing the down arrow key
            }
            String value = driver.switchTo().activeElement().getAttribute("value");
            return value.contains("-"); // Check if the field contains a negative value
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating Budget Split field accepting alphabetic characters without any error")
    public boolean ValidateBudgetSplitFieldAcceptingAlphabets(String Text) {
        try {
            String value = driver.switchTo().activeElement().getAttribute("value");
            return value.equals(Text); // Check if the field contains only alphabetic characters
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if Budget Split success pop-up is displayed")
    public boolean IsBudgetSplitSuccessPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BudgetSplitSuccessPopUp));
            return driver.findElement(BudgetSplitSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating if Budget Split Less Than 100 Error pop-up is displayed")
    public boolean IsBudgetSplitLessThan100PopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BudgetSplitLessThan100ErrorPopUp));
            return driver.findElement(BudgetSplitLessThan100ErrorPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Validating created creative ad success pop up")
    public boolean IsCreatedCreativeAdSuccessPopUpDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeDetailsSuccessPopUp));
            return driver.findElement(CreativeDetailsSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Dev Orders Button")
    public void ClickOnDevOrdersButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DevOrdersButton));
        driver.findElement(DevOrdersButton).click();
    }


    @Step("Validating order approved success pop up")
    public boolean ValidateOrderApprovedSuccessPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(OrderApprovedSuccessPopUp));
            return driver.findElement(OrderApprovedSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Validating comment review success pop up")
    public boolean ValidateCommentReviewSuccessPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CommentReviewSuccessPopUp));
            return driver.findElement(CommentReviewSuccessPopUp).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Product Template Save Button")
    public void ClickOnProductTemplateSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductTemplateSaveButton));
        driver.findElement(ProductTemplateSaveButton).click();
    }

    @Step("Calculating the difference between start and end dates in days")
    public boolean VerifyEditableDailyBudgetFieldsMatchWithStartDateEndDate() {
        LocalDate today = LocalDate.now();
        int presentDay = today.getDayOfMonth();
        boolean flag = false;

        try {
            // Check for non-editable start date element
            WebElement StartDateElement = wait.until(ExpectedConditions.presenceOfElementLocated(NonEditStartDateField));
            boolean IsStartDateNonEditable = StartDateElement.getAttribute("class").contains("non-edit");

            if (IsStartDateNonEditable) {
                System.out.println("Non-editable start date identified.");

                // Extract and parse the start date
                String StartDateText = StartDateElement.getText(); // Example: "12 Sep 24, 09:45 PM +09:00"
                LocalDate StartDate = parseDateFromText(StartDateText); // Converts the start date string to LocalDate

                // Extract and parse the end date
                WebElement EndDateElement = driver.findElement(EndDateFieldPulse);
                String EndDateText = EndDateElement.getText(); // Example: "29 Oct 24, 09:45 PM +09:00"
                LocalDate EndDate = parseDateFromText(EndDateText); // Converts the end date string to LocalDate

                // Calculate the difference in days between start and end dates
                int DaysDifference = (int) ChronoUnit.DAYS.between(StartDate, EndDate);
                // System.out.println("Difference in days: " + DaysDifference);

                // Store the count of editable fields
                int EditableFieldsCount = driver.findElements(SetDailyBudgetInputField).size();
                // System.out.println("Editable Fields Count: " + EditableFieldsCount);

                // Check if the difference in days matches the number of editable fields
                if (EditableFieldsCount == DaysDifference) {
                    flag = true;
//                    System.out.println("Editable fields match the difference in days.");
                } else {
                    System.out.println("Editable fields do not match the difference in days.");
                }
            }
        } catch (Exception e) {
        }

        try {
            WebElement EditableStartDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(StartDateFieldPulse));
            boolean isVisible = (EditableStartDateElement != null);
            if (isVisible) {
                System.out.println("Start date is editable.");

                // Extract and parse the start date
                WebElement StartDateElement = driver.findElement(StartDateFieldPulse);
                String startDateText = StartDateElement.getText(); // Example: "12 Sep 24, 09:45 PM +09:00"
                LocalDate startDate = parseDateFromText(startDateText); // Converts the start date string to LocalDate

                // Extract and parse the end date
                WebElement endDateElement = driver.findElement(EndDateFieldPulse);
                String endDateText = endDateElement.getText(); // Example: "29 Oct 24, 09:45 PM +09:00"
                LocalDate endDate = parseDateFromText(endDateText); // Converts the end date string to LocalDate

                // Calculate the difference in days between start and end dates
                int DaysDifference = (int) ChronoUnit.DAYS.between(startDate, endDate);
                System.out.println("Difference in days: " + (DaysDifference + 1));

                // Store the count of editable fields
                int EditableFieldsCount = driver.findElements(SetDailyBudgetInputField).size();
                System.out.println("Editable Fields Count: " + EditableFieldsCount);

                // Check if the difference in days matches the number of editable fields
                if (EditableFieldsCount == (DaysDifference + 1)) {
                    flag = true;
                    System.out.println("Editable fields match the difference in days.");
                } else {
                    System.out.println("Editable fields do not match the difference in days.");
                }
            }
        } catch (Exception e) {
        }

        return flag;
    }

    private LocalDate parseDateFromText(String dateText) {
        // Example dateText: "12 Sep 24, 09:45 PM +09:00"
        // We need to extract "12 Sep 24"
        String datePart = dateText.split(",")[0].trim(); // Extract "12 Sep 24"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yy");
        return LocalDate.parse(datePart, formatter);
    }

    @Step("Clicking on Creative Save Button")
    public void ClickOnCreativeSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeSaveButton));
        driver.findElement(CreativeSaveButton).click();
    }

    @Step("Clicking on Confirm Button")
    public void ClickOnConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmButton));
        driver.findElement(ConfirmButton).click();
    }

    @Step("Optionally clicking on Closed Order Template")
    public void OptionallyClickOnClosedOrderTemplate(int templateNo) {
        String xpathFormatter = String.format(ClosedOrderTemplateXPath, templateNo);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathFormatter)));
        driver.findElement(By.xpath(xpathFormatter)).click();
    }


    @Step("Entering data into Orders Table Search Field")
    public void EnterDataInOrdersTableSearchField(String SearchText) {
        wait.until(ExpectedConditions.elementToBeClickable(OrdersTableSearchField));
        WebElement searchField = driver.findElement(OrdersTableSearchField);
        searchField.click();
        searchField.clear();
        searchField.sendKeys(SearchText);
    }


    @Step("Validating if the approved video tick mark is displayed")
    public boolean IsApprovedVideoTickMarkDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedVideoTickMark));
            return driver.findElement(ApprovedVideoTickMark).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on the Video Creative Library")
    public void ClickOnVideoCreativeLibrary() {
        wait.until(ExpectedConditions.elementToBeClickable(VideoCreativeLibraryButton));
        driver.findElement(VideoCreativeLibraryButton).click();
    }

    @Step("Entering search term in the Video Creative Library Search Field")
    public void EnterSearchTermInVideoCreativeLibrarySearchField(String searchTerm) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(VideoCreativeLibrarySearchField));
        driver.findElement(VideoCreativeLibrarySearchField).sendKeys(controlOrCommandKey + "a");
        driver.findElement(VideoCreativeLibrarySearchField).sendKeys(searchTerm);
        Thread.sleep(1500);


    }

    @Step("Clicking on the Video Preview Selector")
    public void ClickOnVideoPreviewSelector() {
        wait.until(ExpectedConditions.elementToBeClickable(VideoPreviewSelector));
        driver.findElement(VideoPreviewSelector).click();
    }

    @Step("Validating if Creative Approve Status Icon is displayed")
    public boolean IsCreativeApproveStatusIconDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeApproveStatusIcon));
            return driver.findElement(CreativeApproveStatusIcon).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on Mark As Reviewed button")
    public void ClickOnMarkAsReviewedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(MarkAsReviewedButton));
        driver.findElement(MarkAsReviewedButton).click();
    }

    @Step("Clicking on unmark As Reviewed button")
    public void ClickOnUnMarkAsReviewedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(UnMarkAsReviewedButton));
        driver.findElement(UnMarkAsReviewedButton).click();
    }

    public String VideoApprovedUser;

    @Step("Clicking on creative approved status icon")
    public void ClickOnCreativeApprovedStatusIcon() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeApproveStatusIcon));
        driver.findElement(CreativeApproveStatusIcon).click();
        Thread.sleep(1500);
        VideoApprovedUser = driver.findElement(ApprovedUserText).getText();
    }

    @Step("Clicking on the creative card container")
    public void ClickOnCreativeCardContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeCardContainer));
        driver.findElement(CreativeCardContainer).click();
    }

    @Step("Clicking on the Add New Creative button")
    public void ClickOnAddNewCreativeAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddNewCreativeAddButton));
        driver.findElement(AddNewCreativeAddButton).click();
    }

    public String ApprovedUser;

    @Step("Validating video approved by which user")
    public boolean ValidatingCreativeVideoApprovedByWhichUser() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeApproveStatusIcon));
        driver.findElement(CreativeApproveStatusIcon).click();
        Thread.sleep(1500);
        ApprovedUser = driver.findElement(ApprovedUserText).getText();
//        System.out.println(VideoApprovedUser + "  =  " + ApprovedUser);
        return VideoApprovedUser.equals(ApprovedUser);
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


    @Step("Entering data into the Add Tag Input Field: {0}")
    public void SendKeysToAddTagInputField(String tagData) {
        wait.until(ExpectedConditions.elementToBeClickable(AddTagInputField));
        driver.findElement(AddTagInputField).clear();
        driver.findElement(AddTagInputField).sendKeys(tagData);
    }

    @Step("Clicking on the Model Header Close Button")
    public void ClickOnModelHeaderCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ModelHeaderCloseButton));
        driver.findElement(ModelHeaderCloseButton).click();
    }

    @Step("Clicking on the Video Creative Close Button")
    public void ClickOnVideoCreativeCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(VideoCreativeCloseButton));
        driver.findElement(VideoCreativeCloseButton).click();
    }

    @Step("Clicking on the Add Tag Button")
    public void ClickOnAddTagButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddTagButton));
        driver.findElement(AddTagButton).click();
    }

    @Step("Clicking on the Add Tag Save Button")
    public void ClickOnAddTagSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AddTagSaveButton));
        driver.findElement(AddTagSaveButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(AddTagSaveButtonDisabled));
    }

    public String ReviewedOrderName;

    @Step("Validating video approved by which order")
    public boolean ValidatingCreativeVideoApprovedByWhichOrder() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeApproveStatusIcon));
        driver.findElement(CreativeApproveStatusIcon).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedOrderNameText));
        ReviewedOrderName = driver.findElement(ApprovedOrderNameText).getText();
        return ApprovedOrderName.equals(ReviewedOrderName);
    }

    @Step("Clicking on Edit Tag Button")
    public void ClickOnEditTagButton() {
        wait.until(ExpectedConditions.elementToBeClickable(EditTagButton));
        driver.findElement(EditTagButton).click();
    }

    @Step("Clicking on Remove Tag Button")
    public void ClickOnRemoveTagButton() {
        wait.until(ExpectedConditions.elementToBeClickable(RemoveTagButton));
        driver.findElement(RemoveTagButton).click();
    }

    @Step("Sending optional data to Creative Library Search Field: {0}")
    public void OptionalSendToCreativelibrarySearchField(String searchData) {
        wait.until(ExpectedConditions.presenceOfElementLocated(CreativelibrarySearchField));
        wait.until(ExpectedConditions.elementToBeClickable(CreativelibrarySearchField));
        driver.findElement(CreativelibrarySearchField).sendKeys(searchData);
    }


    @Step("Check if Dev Orders Table Results are displayed")
    public boolean IsDevOrdersTableResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DevOrdersTableResults));
            return driver.findElement(DevOrdersTableResults).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    @Step("Click on Dev Orders Table Results")
    public void ClickOnDevOrdersTableResults() {
        wait.until(ExpectedConditions.elementToBeClickable(DevOrdersTableResults));
        driver.findElement(DevOrdersTableResults).click();
    }


    @Step("Click on Product Template Card")
    public void ClickOnProductTemplateCard() {
        wait.until(ExpectedConditions.elementToBeClickable(ProductTemplateCard));
        driver.findElement(ProductTemplateCard).click();
    }


    @Step("Click on Creative Delete Icon")
    public void ClickOnCreativeDeleteIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(CreativeDeleteIcon));
        driver.findElement(CreativeDeleteIcon).click();
    }


    @Step("Click on Mid-Flight Submit for Review Button")
    public void ClickOnMidFlightSubmitForReviewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(MidFlightSubmitForReviewButton));
        driver.findElement(MidFlightSubmitForReviewButton).click();
    }


    @Step("Check if Pulse Orders Table Results are displayed")
    public boolean IsPulseOrdersTableResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PulseOrdersTableResults));
            return driver.findElement(PulseOrdersTableResults).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Click on Pulse Orders Table Results")
    public void ClickOnPulseOrdersTableResults() {
        wait.until(ExpectedConditions.elementToBeClickable(PulseOrdersTableResults));
        driver.findElement(PulseOrdersTableResults).click();
    }


    @Step("Check if Pulse Order Cost Value is updated with value of seller order cost")
    public boolean IsPulseOrderCostValueUpdatedWithValueOfSellerOrderCost() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PulseOrderCostValue));
            Thread.sleep(1500);
            String Text = driver.findElement(PulseOrderCostValue).getText();
            return Text.equals("40,000");
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Step("Check if Pulse Product template Value is updated with value of seller product template cost")
    public boolean IsPulseProductTemplateValueUpdatedWithValueOfSellerProductCost() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PulseProductTemplateValue));
            Thread.sleep(1500);
            String Text = driver.findElement(PulseProductTemplateValue).getText();
            String TextTwo = driver.findElement(PulseProductTemplateTwoValue).getText();
//            System.out.println(Text);
//            System.out.println(TextTwo);
            return Text.equals("10,000") && TextTwo.equals("10,000");
        } catch (NoSuchElementException | TimeoutException | InterruptedException e) {
            return false;
        }
    }

    @Step("Click on Review Change Button")
    public void ClickOnReviewChangeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ReviewChangeButton));
        driver.findElement(ReviewChangeButton).click();
    }

    @Step("Check if Mid-Flight Status Rejected is displayed")
    public boolean IsMidFlightStatusRejectedDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MidFlightStatusRejected));
            return driver.findElement(MidFlightStatusRejected).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Clicking on the Image Creative Library")
    public void ClickOnImageCreativeLibrary() {
        wait.until(ExpectedConditions.elementToBeClickable(ImageCreativeLibraryButton));
        driver.findElement(ImageCreativeLibraryButton).click();
    }

    @Step("Selecting the creative product template card with index {0}")
    public void SelectCreativeProductTemplateCard(int index) {
        String formattedXpath = String.format(CreativeProductTemplateCardSelector, index);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(formattedXpath)));
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Uploading image in display ad creative library upload field")
    public void UploadingImageInDisplayAdCreativeLibraryUploadField(String FileName) {
        String UserPath = System.getProperty("user.dir");
        String Filepath = UserPath + File.separator + "Resources" + File.separator + "PulseResources" + File.separator + "Images" + File.separator + FileName;
        driver.findElement(CreativesDisplayAdImageUpload).sendKeys(Filepath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ImageRemoveButton));


    }

    @Step("Click on 750X122 image format option")
    public void ClickOn750X122ImageFormat() {
        wait.until(ExpectedConditions.elementToBeClickable(ImageFormat750X122RadioButton));
        driver.findElement(ImageFormat750X122RadioButton).click();
    }

    @Step("Click on 750X122 image format option")
    public void ClickOn550X190ImageFormat() {
        wait.until(ExpectedConditions.elementToBeClickable(ImageFormat550X190RadioButton));
        driver.findElement(ImageFormat550X190RadioButton).click();
    }

    @Step("Enter data in image creative library search field")
    public void EnterDataInImageCreativeLibrarySearchField(String input) {
        wait.until(ExpectedConditions.elementToBeClickable(imageCreativeLibrarySearchField));
        WebElement field = driver.findElement(imageCreativeLibrarySearchField);
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(input);
    }

    @Step("Clicking on the image Preview Selector")
    public void ClickOnImagePreviewSelector() {
        wait.until(ExpectedConditions.elementToBeClickable(ImagePreviewSelector));
        driver.findElement(ImagePreviewSelector).click();
    }

    @Step("Validating if Image Creative Approve Status Icon is displayed")
    public boolean IsImageCreativeApproveStatusIconDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CreativeApproveStatusIcon));
            return driver.findElement(CreativeApproveStatusIcon).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    final By CompanionImagesEmptyErrorMessage = By.xpath("//div[contains(@class,'error-msg mh20')]");

    @Step("Check if Companion Images Empty Error Message is displayed")
    public boolean IsCompanionImagesEmptyErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CompanionImagesEmptyErrorMessage));
            return driver.findElement(CompanionImagesEmptyErrorMessage).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}
