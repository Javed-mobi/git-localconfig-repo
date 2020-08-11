package com.mobi.fortiva.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobi.fortiva.client.APIClient;
//import com.mobi.fortiva.dao.impl.BillingDetailRepository;
import com.mobi.fortiva.dto.Mail;
import com.mobi.fortiva.dto.ShopDto;
import com.mobi.fortiva.exception.BaseException;
//import com.mobi.fortiva.model.BillingDetail;
import com.mobi.fortiva.request.RecurringApplicationChargeRequest;
import com.mobi.fortiva.util.RequestUrlUtility;

import freemarker.template.TemplateException;

@Service
public class PaymentChargeServiceImpl implements PaymentChargeService {

	@Value("${app.base.url}")
	private String baseUrl;

	@Value("${server.servlet.context-path}")
	private String contextPath;

	@Value("${app.shopify.version}")
	private String apiVersion;

	@Value("${app.shopify.charges.url}")
	private String shopifyChargesUrl;

	@Value("${app.test.version}")
	private boolean testEnvironment;

	@Value("${app.payment.approve.callback.context}")
	private String paymentApproveCallabck;

	@Autowired
	private MailSender mailSender;

	@Autowired
	private ShopService shopService;

//	@Autowired
//	private BillingDetailRepository billingDetailRepository;
	

	@SuppressWarnings("unchecked")
	public String createPaymentCharges(Long p_shopId, String p_subscriptionPrice, String p_usageCharge)
			throws BaseException, IOException {
		try {

			ShopDto shopDto = shopService.findById(p_shopId);

			String planName = "Test Plan";
			BigDecimal subscriptionPrice = new BigDecimal(p_subscriptionPrice);
			BigDecimal usageCharge = new BigDecimal(p_usageCharge);
			Integer cappedAmount = 500;

			Map<String, String> headerMap = new HashMap<String, String>();
			headerMap.put("X-Shopify-Access-Token", shopDto.getAccessToken());
			headerMap.put("Accept", "application/json");

			RecurringApplicationChargeRequest request = new RecurringApplicationChargeRequest(planName,
					subscriptionPrice,
					baseUrl + contextPath + paymentApproveCallabck + "?shopId=" + p_shopId,
					cappedAmount,
					"Terms can not be blank",
					testEnvironment ? testEnvironment : null);

			String applicationChargesUrl = RequestUrlUtility.updateRequestUrl(shopifyChargesUrl, "", "", "", "",
					shopDto.getDomain(), apiVersion);

			String response = APIClient.callAPI(new ObjectMapper().writeValueAsString(request), applicationChargesUrl,
					headerMap, "POST");

			Map<String, Object> data = (Map<String, Object>) APIClient.parseJsonObject(response, Map.class);

			String confirmationUrl = ((Map<String, Object>) data.get("recurring_application_charge")).get("confirmation_url").toString();

//			this.saveBillingDetail(shopDto, subscriptionPrice, usageCharge, cappedAmount, confirmationUrl);

			this.sendEmail(shopDto, confirmationUrl);

		} catch (Exception exp) {
			System.out.println();
		}

		return null;
	}

	private void sendEmail(ShopDto shopEntity, String url)
			throws MessagingException, IOException, TemplateException {
		Mail mailData = new Mail();
		Map<String, String> cont = new HashMap<>();
		cont.put("url", url);
		cont.put("templateName", "activation.html");
		mailData.setContent(cont);
		mailData.setTo(shopEntity.getEmail());
		mailSender.sendEmail(mailData);
	}

//	private void saveBillingDetail(ShopDto shopEntity, BigDecimal subscriptionPrice, BigDecimal usagePrice, Integer cappedAmount, String confirmationUrl) {
//		BillingDetail detail = null;
//		try {
//
//			Optional<BillingDetail> result = billingDetailRepository.findByShopId(new Long(shopEntity.getId()));
//
//			
//			if(!result .isPresent()) {
//				detail = new BillingDetail();
//			} else {
//				detail = result.get();
//			}
//			
//			detail.setShopId(new Long(shopEntity.getId()));
//			detail.setSubscriptionAmount(subscriptionPrice);
//			detail.setPerOrderCharge(usagePrice);
//			detail.setUsageAmount(new BigDecimal(cappedAmount.intValue()));
//			detail.setUsedAmount(BigDecimal.ZERO);
//			detail.setThresholdPercentage(new BigDecimal(90));
//			detail.setConfirmationUrl(confirmationUrl);
//			
//			billingDetailRepository.save(detail);
//		} catch (Exception exp) {
//			exp.printStackTrace();
//		}
//	}
//
//
//
//	@Override
//	public String updateBillingRate(Long p_shopId, BigDecimal p_usageCharge) throws BaseException, IOException {
//		BillingDetail detail = null;
//		try {
//
//			Optional<BillingDetail> result = billingDetailRepository.findByShopId(new Long(p_shopId));
//			if(!result .isPresent()) {
//				detail = new BillingDetail();
//			} else {
//				detail = result.get();
//			}
//
//			detail.setPerOrderCharge(p_usageCharge);
//			billingDetailRepository.save(detail);
//		} catch (Exception exp) {
//			System.out.println();
//		}
//		return apiVersion;
//	}
}
