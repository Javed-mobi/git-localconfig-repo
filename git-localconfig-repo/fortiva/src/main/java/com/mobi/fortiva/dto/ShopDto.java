package com.mobi.fortiva.dto;

import java.util.Date;

/**
 * The persistent class for the usermaster database table.
 * 
 */
public class ShopDto {

	private String id;

	private String email;
	private String domain;
	private String shopName;
	private String accessToken;
	private String status;
	private String hmac;
	private String processId;
	private String owner;
	private String apiClientId;
	private Date installedTime;
	private Date uninstalledTime;
	private Date reinstalledTime;
	
	private String billingid;
	private String subscriptionCharge;
	private String apiRate;
	
	private String billingApproveStatus;
	
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

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getApiClientId() {
		return apiClientId;
	}

	public void setApiClientId(String apiClientId) {
		this.apiClientId = apiClientId;
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

	public String getBillingid() {
		return billingid;
	}

	public void setBillingid(String billingid) {
		this.billingid = billingid;
	}

	public String getSubscriptionCharge() {
		return subscriptionCharge;
	}

	public void setSubscriptionCharge(String subscriptionCharge) {
		this.subscriptionCharge = subscriptionCharge;
	}

	public String getApiRate() {
		return apiRate;
	}

	public void setApiRate(String apiRate) {
		this.apiRate = apiRate;
	}

	public String getBillingApproveStatus() {
		return this.billingApproveStatus;
	}

	public void setBillingApproveStatus(String billingApproveStatus) {
		this.billingApproveStatus = billingApproveStatus;
	}

}