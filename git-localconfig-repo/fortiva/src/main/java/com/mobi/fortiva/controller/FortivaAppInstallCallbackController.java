package com.mobi.fortiva.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobi.fortiva.client.APIClient;
import com.mobi.fortiva.dto.ShopDto;
import com.mobi.fortiva.exception.BaseException;
import com.mobi.fortiva.response.AccessTokenResponse;
import com.mobi.fortiva.response.ShopDetailResponse;
import com.mobi.fortiva.service.impl.PaymentChargeService;
import com.mobi.fortiva.service.impl.ShopService;
//import com.mobikasa.shopify.appinstaller.client.APIClient;
//import com.mobikasa.shopify.appinstaller.dto.ShopDto;
//import com.mobikasa.shopify.appinstaller.exception.BaseException;
//import com.mobikasa.shopify.appinstaller.response.AccessTokenResponse;
//import com.mobikasa.shopify.appinstaller.response.ShopDetailResponse;
//import com.mobikasa.shopify.appinstaller.service.impl.PaymentChargeService;
//import com.mobikasa.shopify.appinstaller.service.impl.ShopService;
//import com.mobikasa.shopify.appinstaller.util.Hmac;
//import com.mobikasa.shopify.appinstaller.util.RequestUrlUtility;
import com.mobi.fortiva.util.Hmac;
import com.mobi.fortiva.util.RequestUrlUtility;

@RestController
public class FortivaAppInstallCallbackController {

    @Value("${app.base.url}")
    private String baseUrl;
    
    @Value("${app.install.key}")
    private String key;
    
    @Value("${app.install.secretkey}")
    private String secretKey;
    
    @Value("${app.shopify.accessToken.url}")
    private String accessTokenUrl;
    
    @Value("${app.shopify.shopDetail.url}")
    private String storeDetailUrl;
    
    @Value("${app.shopify.version}")
    private String apiVersion;
    
    @Value("${app.shopify.charges.url}")
    private String shopifyChargesUrl;
    
    @Value("${app.test.version}")
    private boolean testEnvironment;
    
    @Value("${app.auto.approval.version}")
    private boolean autoApproval;
    
    @Value("${app.payment.approve.callback.context}")
    private String paymentApproveCallabck;
    
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    private ShopService shopService;

    @Autowired
	private PaymentChargeService paymentChargeService;

    @GetMapping(value = {"${app.install.callback.context}"})
    public RedirectView installShopifyAppCallback(@RequestParam String shop, @RequestParam String hmac,
                                                  @RequestParam String code, @RequestParam String state, HttpServletRequest request) {
        AccessTokenResponse accessResponse = null;
        String shopId = "";
        try {
            if (StringUtils.hasText(shop) && StringUtils.hasText(hmac) && StringUtils.hasText(code) && StringUtils.hasText(state)) {
                boolean hmacValidated = Hmac.checkHmac(request.getQueryString().replace("&hmac=" + hmac, ""), hmac, secretKey);
                if (hmacValidated) {
                    accessResponse = this.fetchAccessToken(shop, code);
                    if (accessResponse != null && StringUtils.hasText(accessResponse.getAccessToken())) {
                        
                        
                        ShopDto shopEntity = shopService.findByDomain(shop);
                        
                        if(shopEntity == null || ( "0".equals(shopEntity.getStatus()) ) ) {
                        	 shopId = this.fetchStoreDetail(accessResponse, shop, hmac);
                        	 
                        	 if(autoApproval) {
                             	paymentChargeService.createPaymentCharges(new Long(shopId), "1000", "0.07");
                             }
                        } else {
                        	shopId = shopEntity.getId();
                        }
                        
                        if (StringUtils.hasText(shopId)) {
                            return new RedirectView("dashboard/configuration?shopId=" + shopId);
                        }
                    }
                }
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return new RedirectView("");
    }

    private AccessTokenResponse fetchAccessToken(String p_shop, String p_code) {
        AccessTokenResponse accessResponse = null;
        try {
            HashMap<String, String> requestdata = new HashMap<String, String>();
            requestdata.put("client_id", key);
            requestdata.put("client_secret", secretKey);
            requestdata.put("code", p_code);
            String oAuthUrl = RequestUrlUtility.updateRequestUrl(accessTokenUrl, "", "", "", "", p_shop, "");
            ObjectMapper objectMapper = new ObjectMapper();
            String reqestString = objectMapper.writeValueAsString(requestdata);
            String response = APIClient.callAPI(reqestString, oAuthUrl, null, "POST");
            System.out.println("MJ:: "+response);
            accessResponse = (AccessTokenResponse) APIClient.parseJsonObject(response, AccessTokenResponse.class);
        } catch (IOException | BaseException exp) {
            exp.printStackTrace();
        }

        return accessResponse;
    }

    private String fetchStoreDetail(AccessTokenResponse accessResponse, String p_shop, String hmac) {
        String shopId = "";
        try {
            Map<String, String> headerMap = new HashMap<String, String>();
            headerMap.put("X-Shopify-Access-Token", accessResponse.getAccessToken());
            String updatedUrl = RequestUrlUtility.updateRequestUrl(storeDetailUrl, "", "", "", "", p_shop, apiVersion);
            String response = APIClient.callAPI("", updatedUrl, headerMap, "GET");
            ShopDetailResponse shopDetail = (ShopDetailResponse) APIClient.parseJsonObject(response, ShopDetailResponse.class);
            shopId = shopService.createShop(shopDetail.getShop(), accessResponse.getAccessToken(), hmac);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return shopId;
    }




}
