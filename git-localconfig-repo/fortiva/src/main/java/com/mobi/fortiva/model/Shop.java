package com.mobi.fortiva.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the usermaster database table.
 * 
 */
@Entity
@Table(name = "stores")
public class Shop {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	@Column(name = "email")
	private String email;

	@Column(name = "domain")
	private String domain;

	@Column(name = "phone")
	private String phone;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "currency")
	private String currency;

	@Column(name = "owner")
	private String owner;

	@Column(name = "timezone")
	private String timezone;

	@Column(name = "country")
	private String country;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updDate")
	private Date updDate;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "access_token")
	private String accessToken;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "installed_at")
	private Date installedTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "uninstalled_at")
	private Date uninstalledTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "re_installed_at")
	private Date reinstalledTime;

	@Column(name = "installation_count")
	private Integer installationCount;

	@Column(name = "status")
	private String status;

	@Column(name = "hmac")
	private String hmac;
	
	@Column(name = "process_id")
	private String processId;
	
	@Column(name = "billing_approve_date")
    private Date billingApproveDate;
    
    @Column(name = "billing_approve_status")
    private Integer billingApproveStatus;

	@Column(name = "credit_available")
	private int creditAvailable;

	@Column(name = "api_client_id")
	private int apiClientId;

	@Column(name = "script_tag_id")
	private String scriptTagId;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Date getInstalledTime() {
		return installedTime;
	}

	public void setInstalledTime(Date installedTime) {
		this.installedTime = installedTime;
	}

	public Date getUninstalledTime() {
		return uninstalledTime;
	}

	public void setUninstalledTime(Date uninstalledTime) {
		this.uninstalledTime = uninstalledTime;
	}

	public Date getReinstalledTime() {
		return reinstalledTime;
	}

	public void setReinstalledTime(Date reinstalledTime) {
		this.reinstalledTime = reinstalledTime;
	}

	public Integer getInstallationCount() {
		return installationCount;
	}

	public void setInstallationCount(Integer installationCount) {
		this.installationCount = installationCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHmac() {
		return hmac;
	}

	public void setHmac(String hmac) {
		this.hmac = hmac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public Date getBillingApproveDate() {
		return billingApproveDate;
	}

	public void setBillingApproveDate(Date billingApproveDate) {
		this.billingApproveDate = billingApproveDate;
	}

	public Integer getBillingApproveStatus() {
		return billingApproveStatus;
	}

	public void setBillingApproveStatus(Integer billingApproveStatus) {
		this.billingApproveStatus = billingApproveStatus;
	}

	public int getCreditAvailable() {
		return creditAvailable;
	}

	public void setCreditAvailable(int creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

	public int getApiClientId() {
		return apiClientId;
	}

	public void setApiClientId(int apiClientId) {
		this.apiClientId = apiClientId;
	}

	public String getScriptTagId() {
		return scriptTagId;
	}

	public void setScriptTagId(String scriptTagId) {
		this.scriptTagId = scriptTagId;
	}
	
}