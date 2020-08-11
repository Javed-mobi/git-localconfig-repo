package com.mobi.fortiva;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.RateLimiter;
import com.mobi.fortiva.client.APIClient;
import com.mobi.fortiva.constant.ApplicationConstant;
import com.mobi.fortiva.dto.CodeLkupDto;
import com.mobi.fortiva.dto.ShopDto;
import com.mobi.fortiva.request.FortivaWebhookConfigureRequest;
import com.mobi.fortiva.response.FortivaWebhookConfigureResponse;
import com.mobi.fortiva.service.impl.CodeLkupService;
import com.mobi.fortiva.service.impl.ShopService;

@Component
public class FortivaRegisterWebhook {
	
	@Autowired
	private CodeLkupService codeLkupService;
	
	@Value("${app.base.url}")
	private String baseUrl;
	
	@Value("${webhook.base.url}")
	private String webhookBaseUrl;
	
	@Value("${app.shopify.version}")
	private String apiVersion;
	
	@Autowired
	private ShopService shopService;
	
	public void registerShopifyWebhook(String id) {
		try {
			
			System.out.println();
			
			ShopDto result = shopService.findById(Long.valueOf(id));
			
			String webookAdminUrl = "https://" + result.getDomain() + "/admin/api/" + apiVersion + "/webhooks.json";
			
			List<CodeLkupDto> accessList = codeLkupService.fetchCodeLkupList();
			
			RateLimiter rateLimiter = RateLimiter.create(2);
			
			accessList.forEach(access -> registerWebhook(webookAdminUrl, access, webhookBaseUrl, result.getId(), result.getAccessToken(), rateLimiter));
			
		} catch(Exception exp) {
			System.out.println();
		}	
	}

	public void registerWebhook(String p_webookAdminUrl, CodeLkupDto p_access, String p_baseUrl, String p_shopId, String p_accessToken, RateLimiter rateLimiter) {
		
		try {
			ObjectMapper objMapper = new ObjectMapper();
			
			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("X-Shopify-Access-Token", p_accessToken);
			headerMap.put("Accept", "application/json");
			
			if (StringUtils.hasText(p_webookAdminUrl) && StringUtils.hasText(p_shopId) ) {
				
				String webhook_url =  p_baseUrl + ApplicationConstant.CHARACTER_BACKSLASH + p_access.getKey3() ;
				
				FortivaWebhookConfigureRequest request = new FortivaWebhookConfigureRequest(p_access.getKey2(), webhook_url);
				
				rateLimiter.acquire();
				
				String response = APIClient.callAPI(objMapper.writeValueAsString(request), p_webookAdminUrl, headerMap, "POST");
				
				FortivaWebhookConfigureResponse shopifyWebhookResponse = (FortivaWebhookConfigureResponse) APIClient.parseJsonObject(response, FortivaWebhookConfigureResponse.class);
				
				shopService.createShopWebhook(p_shopId, shopifyWebhookResponse.getWebhook().getId().toString(), shopifyWebhookResponse.getWebhook().getTopic(), "1");
				
			}
		} catch(Exception exp) {
			
		}
	}
	
	
}	

	