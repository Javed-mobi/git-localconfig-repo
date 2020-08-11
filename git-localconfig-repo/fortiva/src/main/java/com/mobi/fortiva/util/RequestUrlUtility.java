package com.mobi.fortiva.util;

public class RequestUrlUtility {
	
	private RequestUrlUtility() {
		
	}
	
	public static String updateRequestUrl(String p_url, String p_key, String p_scope, String p_state, String p_redirectUrl, String p_shop, String p_version ) {
		
		return  p_url
				.replace("$key", p_key)
				.replace("$scope", p_scope)
				.replace("$state", p_state)
				.replace("$redirectUrl", p_redirectUrl)
				.replace("$shop", p_shop)
				.replace("$apiVersion", p_version);
		
	}
	
	public static String updateRequestUrlShopId(String p_url, String p_shopId) {
		
		return  p_url
				.replace("$shopId", p_shopId);
		
	}

	public static String updateRequestUrlChargeId(String p_url, String p_shop, String chargeId) {
		
		return  p_url
				.replace("$shop", p_shop)
				.replace("$chargeId", chargeId);
		
	}
	
	public static String updateRequestUrlScriptId(String p_url, String p_shop, String scriptId) {
		
		return  p_url
				.replace("$shop", p_shop)
				.replace("$scriptTagId", scriptId);
		
	}
}
