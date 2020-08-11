package com.mobi.fortiva.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.mobi.fortiva.util.RequestUrlUtility;

@RestController
public class FortivaAppInstallController {

	@Value("${app.install.callback.context}")
	private String callbackUrl;
	
	@Value("${app.install.key}")
	private String key;
	
	@Value("${app.install.secretkey}")
	private String secretKey;
	
	@Value("${app.base.url}")
	private String baseUrl;
	
	@Value("${app.shopify.install.url}")
	private String appInstallUrl;
	
	@Value("${app.scope.required}")
	private String scope;
	
	@Value("${server.servlet.context-path}")
	private String contextPath;

	@GetMapping(value = { "${app.install.context}"})
	public RedirectView installShopifyApp(@RequestParam String shop) {
		String updatedUrl = "";
		try {
			
			String state = Calendar.getInstance().getTimeInMillis() + "";
			String redirectUrl = baseUrl + contextPath + callbackUrl;
			
			updatedUrl = RequestUrlUtility.updateRequestUrl(appInstallUrl, key, scope, state, redirectUrl, shop, "");
					
		} catch(Exception exp) {
			
		}	
		return new RedirectView(updatedUrl);
	}
}
