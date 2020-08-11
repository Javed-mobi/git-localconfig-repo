package com.mobi.fortiva.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "email",
    "domain",
    "province",
    "country",
    "address1",
    "zip",
    "city",
    "source",
    "phone",
    "latitude",
    "longitude",
    "primary_locale",
    "address2",
    "created_at",
    "updated_at",
    "country_code",
    "country_name",
    "currency",
    "customer_email",
    "timezone",
    "iana_timezone",
    "shop_owner",
    "money_format",
    "money_with_currency_format",
    "weight_unit",
    "province_code",
    "taxes_included",
    "tax_shipping",
    "county_taxes",
    "plan_display_name",
    "plan_name",
    "has_discounts",
    "has_gift_cards",
    "myshopify_domain",
    "google_apps_domain",
    "google_apps_login_enabled",
    "money_in_emails_format",
    "money_with_currency_in_emails_format",
    "eligible_for_payments",
    "requires_extra_payments_agreement",
    "password_enabled",
    "has_storefront",
    "eligible_for_card_reader_giveaway",
    "finances",
    "primary_location_id",
    "cookie_consent_level",
    "visitor_tracking_consent_preference",
    "force_ssl",
    "checkout_api_supported",
    "multi_location_enabled",
    "setup_required",
    "pre_launch_enabled",
    "enabled_presentment_currencies"
})
public class Shop {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("province")
    private String province;
    @JsonProperty("country")
    private String country;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("zip")
    private String zip;
    @JsonProperty("city")
    private String city;
    @JsonProperty("source")
    private Object source;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("primary_locale")
    private String primaryLocale;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("customer_email")
    private String customerEmail;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("iana_timezone")
    private String ianaTimezone;
    @JsonProperty("shop_owner")
    private String shopOwner;
    @JsonProperty("money_format")
    private String moneyFormat;
    @JsonProperty("money_with_currency_format")
    private String moneyWithCurrencyFormat;
    @JsonProperty("weight_unit")
    private String weightUnit;
    @JsonProperty("province_code")
    private String provinceCode;
    @JsonProperty("taxes_included")
    private Object taxesIncluded;
    @JsonProperty("tax_shipping")
    private Object taxShipping;
    @JsonProperty("county_taxes")
    private Boolean countyTaxes;
    @JsonProperty("plan_display_name")
    private String planDisplayName;
    @JsonProperty("plan_name")
    private String planName;
    @JsonProperty("has_discounts")
    private Boolean hasDiscounts;
    @JsonProperty("has_gift_cards")
    private Boolean hasGiftCards;
    @JsonProperty("myshopify_domain")
    private String myshopifyDomain;
    @JsonProperty("google_apps_domain")
    private Object googleAppsDomain;
    @JsonProperty("google_apps_login_enabled")
    private Object googleAppsLoginEnabled;
    @JsonProperty("money_in_emails_format")
    private String moneyInEmailsFormat;
    @JsonProperty("money_with_currency_in_emails_format")
    private String moneyWithCurrencyInEmailsFormat;
    @JsonProperty("eligible_for_payments")
    private Boolean eligibleForPayments;
    @JsonProperty("requires_extra_payments_agreement")
    private Boolean requiresExtraPaymentsAgreement;
    @JsonProperty("password_enabled")
    private Boolean passwordEnabled;
    @JsonProperty("has_storefront")
    private Boolean hasStorefront;
    @JsonProperty("eligible_for_card_reader_giveaway")
    private Boolean eligibleForCardReaderGiveaway;
    @JsonProperty("finances")
    private Boolean finances;
    @JsonProperty("primary_location_id")
    private Long primaryLocationId;
    @JsonProperty("cookie_consent_level")
    private String cookieConsentLevel;
    @JsonProperty("visitor_tracking_consent_preference")
    private String visitorTrackingConsentPreference;
    @JsonProperty("force_ssl")
    private Boolean forceSsl;
    @JsonProperty("checkout_api_supported")
    private Boolean checkoutApiSupported;
    @JsonProperty("multi_location_enabled")
    private Boolean multiLocationEnabled;
    @JsonProperty("setup_required")
    private Boolean setupRequired;
    @JsonProperty("pre_launch_enabled")
    private Boolean preLaunchEnabled;
    @JsonProperty("enabled_presentment_currencies")
    private List<String> enabledPresentmentCurrencies = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @JsonProperty("province")
    public String getProvince() {
        return province;
    }

    @JsonProperty("province")
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("address1")
    public String getAddress1() {
        return address1;
    }

    @JsonProperty("address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("source")
    public Object getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Object source) {
        this.source = source;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("primary_locale")
    public String getPrimaryLocale() {
        return primaryLocale;
    }

    @JsonProperty("primary_locale")
    public void setPrimaryLocale(String primaryLocale) {
        this.primaryLocale = primaryLocale;
    }

    @JsonProperty("address2")
    public String getAddress2() {
        return address2;
    }

    @JsonProperty("address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("country_name")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("country_name")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("customer_email")
    public String getCustomerEmail() {
        return customerEmail;
    }

    @JsonProperty("customer_email")
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("iana_timezone")
    public String getIanaTimezone() {
        return ianaTimezone;
    }

    @JsonProperty("iana_timezone")
    public void setIanaTimezone(String ianaTimezone) {
        this.ianaTimezone = ianaTimezone;
    }

    @JsonProperty("shop_owner")
    public String getShopOwner() {
        return shopOwner;
    }

    @JsonProperty("shop_owner")
    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    @JsonProperty("money_format")
    public String getMoneyFormat() {
        return moneyFormat;
    }

    @JsonProperty("money_format")
    public void setMoneyFormat(String moneyFormat) {
        this.moneyFormat = moneyFormat;
    }

    @JsonProperty("money_with_currency_format")
    public String getMoneyWithCurrencyFormat() {
        return moneyWithCurrencyFormat;
    }

    @JsonProperty("money_with_currency_format")
    public void setMoneyWithCurrencyFormat(String moneyWithCurrencyFormat) {
        this.moneyWithCurrencyFormat = moneyWithCurrencyFormat;
    }

    @JsonProperty("weight_unit")
    public String getWeightUnit() {
        return weightUnit;
    }

    @JsonProperty("weight_unit")
    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    @JsonProperty("province_code")
    public String getProvinceCode() {
        return provinceCode;
    }

    @JsonProperty("province_code")
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    @JsonProperty("taxes_included")
    public Object getTaxesIncluded() {
        return taxesIncluded;
    }

    @JsonProperty("taxes_included")
    public void setTaxesIncluded(Object taxesIncluded) {
        this.taxesIncluded = taxesIncluded;
    }

    @JsonProperty("tax_shipping")
    public Object getTaxShipping() {
        return taxShipping;
    }

    @JsonProperty("tax_shipping")
    public void setTaxShipping(Object taxShipping) {
        this.taxShipping = taxShipping;
    }

    @JsonProperty("county_taxes")
    public Boolean getCountyTaxes() {
        return countyTaxes;
    }

    @JsonProperty("county_taxes")
    public void setCountyTaxes(Boolean countyTaxes) {
        this.countyTaxes = countyTaxes;
    }

    @JsonProperty("plan_display_name")
    public String getPlanDisplayName() {
        return planDisplayName;
    }

    @JsonProperty("plan_display_name")
    public void setPlanDisplayName(String planDisplayName) {
        this.planDisplayName = planDisplayName;
    }

    @JsonProperty("plan_name")
    public String getPlanName() {
        return planName;
    }

    @JsonProperty("plan_name")
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @JsonProperty("has_discounts")
    public Boolean getHasDiscounts() {
        return hasDiscounts;
    }

    @JsonProperty("has_discounts")
    public void setHasDiscounts(Boolean hasDiscounts) {
        this.hasDiscounts = hasDiscounts;
    }

    @JsonProperty("has_gift_cards")
    public Boolean getHasGiftCards() {
        return hasGiftCards;
    }

    @JsonProperty("has_gift_cards")
    public void setHasGiftCards(Boolean hasGiftCards) {
        this.hasGiftCards = hasGiftCards;
    }

    @JsonProperty("myshopify_domain")
    public String getMyshopifyDomain() {
        return myshopifyDomain;
    }

    @JsonProperty("myshopify_domain")
    public void setMyshopifyDomain(String myshopifyDomain) {
        this.myshopifyDomain = myshopifyDomain;
    }

    @JsonProperty("google_apps_domain")
    public Object getGoogleAppsDomain() {
        return googleAppsDomain;
    }

    @JsonProperty("google_apps_domain")
    public void setGoogleAppsDomain(Object googleAppsDomain) {
        this.googleAppsDomain = googleAppsDomain;
    }

    @JsonProperty("google_apps_login_enabled")
    public Object getGoogleAppsLoginEnabled() {
        return googleAppsLoginEnabled;
    }

    @JsonProperty("google_apps_login_enabled")
    public void setGoogleAppsLoginEnabled(Object googleAppsLoginEnabled) {
        this.googleAppsLoginEnabled = googleAppsLoginEnabled;
    }

    @JsonProperty("money_in_emails_format")
    public String getMoneyInEmailsFormat() {
        return moneyInEmailsFormat;
    }

    @JsonProperty("money_in_emails_format")
    public void setMoneyInEmailsFormat(String moneyInEmailsFormat) {
        this.moneyInEmailsFormat = moneyInEmailsFormat;
    }

    @JsonProperty("money_with_currency_in_emails_format")
    public String getMoneyWithCurrencyInEmailsFormat() {
        return moneyWithCurrencyInEmailsFormat;
    }

    @JsonProperty("money_with_currency_in_emails_format")
    public void setMoneyWithCurrencyInEmailsFormat(String moneyWithCurrencyInEmailsFormat) {
        this.moneyWithCurrencyInEmailsFormat = moneyWithCurrencyInEmailsFormat;
    }

    @JsonProperty("eligible_for_payments")
    public Boolean getEligibleForPayments() {
        return eligibleForPayments;
    }

    @JsonProperty("eligible_for_payments")
    public void setEligibleForPayments(Boolean eligibleForPayments) {
        this.eligibleForPayments = eligibleForPayments;
    }

    @JsonProperty("requires_extra_payments_agreement")
    public Boolean getRequiresExtraPaymentsAgreement() {
        return requiresExtraPaymentsAgreement;
    }

    @JsonProperty("requires_extra_payments_agreement")
    public void setRequiresExtraPaymentsAgreement(Boolean requiresExtraPaymentsAgreement) {
        this.requiresExtraPaymentsAgreement = requiresExtraPaymentsAgreement;
    }

    @JsonProperty("password_enabled")
    public Boolean getPasswordEnabled() {
        return passwordEnabled;
    }

    @JsonProperty("password_enabled")
    public void setPasswordEnabled(Boolean passwordEnabled) {
        this.passwordEnabled = passwordEnabled;
    }

    @JsonProperty("has_storefront")
    public Boolean getHasStorefront() {
        return hasStorefront;
    }

    @JsonProperty("has_storefront")
    public void setHasStorefront(Boolean hasStorefront) {
        this.hasStorefront = hasStorefront;
    }

    @JsonProperty("eligible_for_card_reader_giveaway")
    public Boolean getEligibleForCardReaderGiveaway() {
        return eligibleForCardReaderGiveaway;
    }

    @JsonProperty("eligible_for_card_reader_giveaway")
    public void setEligibleForCardReaderGiveaway(Boolean eligibleForCardReaderGiveaway) {
        this.eligibleForCardReaderGiveaway = eligibleForCardReaderGiveaway;
    }

    @JsonProperty("finances")
    public Boolean getFinances() {
        return finances;
    }

    @JsonProperty("finances")
    public void setFinances(Boolean finances) {
        this.finances = finances;
    }

    @JsonProperty("primary_location_id")
    public Long getPrimaryLocationId() {
        return primaryLocationId;
    }

    @JsonProperty("primary_location_id")
    public void setPrimaryLocationId(Long primaryLocationId) {
        this.primaryLocationId = primaryLocationId;
    }

    @JsonProperty("cookie_consent_level")
    public String getCookieConsentLevel() {
        return cookieConsentLevel;
    }

    @JsonProperty("cookie_consent_level")
    public void setCookieConsentLevel(String cookieConsentLevel) {
        this.cookieConsentLevel = cookieConsentLevel;
    }

    @JsonProperty("visitor_tracking_consent_preference")
    public String getVisitorTrackingConsentPreference() {
        return visitorTrackingConsentPreference;
    }

    @JsonProperty("visitor_tracking_consent_preference")
    public void setVisitorTrackingConsentPreference(String visitorTrackingConsentPreference) {
        this.visitorTrackingConsentPreference = visitorTrackingConsentPreference;
    }

    @JsonProperty("force_ssl")
    public Boolean getForceSsl() {
        return forceSsl;
    }

    @JsonProperty("force_ssl")
    public void setForceSsl(Boolean forceSsl) {
        this.forceSsl = forceSsl;
    }

    @JsonProperty("checkout_api_supported")
    public Boolean getCheckoutApiSupported() {
        return checkoutApiSupported;
    }

    @JsonProperty("checkout_api_supported")
    public void setCheckoutApiSupported(Boolean checkoutApiSupported) {
        this.checkoutApiSupported = checkoutApiSupported;
    }

    @JsonProperty("multi_location_enabled")
    public Boolean getMultiLocationEnabled() {
        return multiLocationEnabled;
    }

    @JsonProperty("multi_location_enabled")
    public void setMultiLocationEnabled(Boolean multiLocationEnabled) {
        this.multiLocationEnabled = multiLocationEnabled;
    }

    @JsonProperty("setup_required")
    public Boolean getSetupRequired() {
        return setupRequired;
    }

    @JsonProperty("setup_required")
    public void setSetupRequired(Boolean setupRequired) {
        this.setupRequired = setupRequired;
    }

    @JsonProperty("pre_launch_enabled")
    public Boolean getPreLaunchEnabled() {
        return preLaunchEnabled;
    }

    @JsonProperty("pre_launch_enabled")
    public void setPreLaunchEnabled(Boolean preLaunchEnabled) {
        this.preLaunchEnabled = preLaunchEnabled;
    }

    @JsonProperty("enabled_presentment_currencies")
    public List<String> getEnabledPresentmentCurrencies() {
        return enabledPresentmentCurrencies;
    }

    @JsonProperty("enabled_presentment_currencies")
    public void setEnabledPresentmentCurrencies(List<String> enabledPresentmentCurrencies) {
        this.enabledPresentmentCurrencies = enabledPresentmentCurrencies;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
