/**
 *
 */
package com.mobi.fortiva.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mobi.fortiva.dao.impl.ShopRepository;
import com.mobi.fortiva.dao.impl.ShopWebhookRepository;
import com.mobi.fortiva.dto.Mail;
import com.mobi.fortiva.dto.ShopDto;
import com.mobi.fortiva.exception.BusinessException;
import com.mobi.fortiva.model.ShopWebhook;
import com.mobi.fortiva.response.Shop;

import freemarker.template.TemplateException;

/**
 * Shop Service class 
 * 
 * @author Sahil Gupta
 *
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {

	@Value("${app.order.increment.capping.amount}")
	private BigDecimal orderCappingAmount;

	@Value("${app.shopify.activate.charges.path}")
	private String activateChargesUrl;

	@Value("${app.test.version}")
	private boolean testEnvironment;

	@Value("${app.shopify.version}")
	private String apiVersion;

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private ShopWebhookRepository shopWebhookRepository;
//
	@Autowired
	private MailSender mailSender;
//
//	@Autowired
//	private BillingDetailRepository billingDetailRepository;

	private DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	private DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String createShop(Shop p_shop, String accessToken, String hmac) throws BusinessException {
		String id = "";
		try {
			Calendar dateNow = Calendar.getInstance();
			if (p_shop != null) {

				com.mobi.fortiva.model.Shop shop = shopRepository.findByDomain(p_shop.getDomain());

				if (shop != null) {
//					shop.setInstallationCount(shop.getInstallationCount() + 1);
					shop.setAccessToken(accessToken);
					shop.setStatus("1");
					shop.setHmac(hmac);
					shop.setEmail(p_shop.getEmail());
					com.mobi.fortiva.model.Shop result = shopRepository.save(shop);

					id = result.getId() + "";
				} else {
					com.mobi.fortiva.model.Shop l_shop = new com.mobi.fortiva.model.Shop();

					l_shop.setShopName(p_shop.getName());
					l_shop.setEmail(p_shop.getEmail());
					l_shop.setHmac(hmac);
					l_shop.setAccessToken(accessToken);

					l_shop.setDomain(p_shop.getDomain());
					l_shop.setPhone(p_shop.getPhone());
					l_shop.setMobile(p_shop.getPhone());
					l_shop.setCurrency(p_shop.getCurrency());
					l_shop.setOwner(p_shop.getShopOwner());
					l_shop.setTimezone(p_shop.getTimezone());
					l_shop.setCountry(p_shop.getCountry());
					l_shop.setUpdDate(dateNow.getTime());
					l_shop.setInstalledTime(dateNow.getTime());
					l_shop.setInstallationCount(1);
					l_shop.setStatus("1");
					l_shop.setBillingApproveStatus(0);
					com.mobi.fortiva.model.Shop result = shopRepository.save(l_shop);

					id = result.getId() + "";
					
					this.sendEmail(id);
				}

			}

		} catch (Exception exp) {
			System.out.println();
		}
		return id;
	}

	@Override
	public ShopDto findById(Long id) throws BusinessException {
		ShopDto shopDetail = new ShopDto();
		try {

			Optional<com.mobi.fortiva.model.Shop> result = shopRepository.findById(id + "");
			if (result.get() != null) {
				com.mobi.fortiva.model.Shop shop = result.get();

				shopDetail.setShopName(shop.getShopName());
				shopDetail.setStatus(shop.getStatus());
				shopDetail.setHmac(shop.getHmac());
				shopDetail.setAccessToken(shop.getAccessToken());
				shopDetail.setDomain(shop.getDomain());
				shopDetail.setId(shop.getId());
				shopDetail.setOwner(shop.getOwner());
				shopDetail.setEmail(shop.getEmail());
				shopDetail.setApiClientId(shop.getApiClientId() + "");
				shopDetail.setProcessId(shop.getProcessId());
				shopDetail.setBillingApproveStatus(shop.getBillingApproveStatus().toString());
			}

		} catch (Exception exp) {
			System.out.println();
		}
		return shopDetail;
	}

	@Override
	public boolean updateShopProcessId(String shopId, String processId) throws BusinessException {
		boolean recordUpdated = false;
		try {

			Optional<com.mobi.fortiva.model.Shop> result = shopRepository.findById(shopId + "");
			if (result.isPresent()) {
				com.mobi.fortiva.model.Shop shop = result.get();
				int billingStatus = shop.getBillingApproveStatus();
				shop.setProcessId(processId);
				shop.setStatus("1");
				shop.setBillingApproveStatus(1);
				shop.setBillingApproveDate(Calendar.getInstance().getTime());
				shop.setCreditAvailable(1);
				shopRepository.save(shop);
//				Optional<BillingDetail> billingDetail = billingDetailRepository.findByShopId(Long.parseLong(shopId));
//				if (billingDetail.isPresent() && billingStatus == 1) {
//					billingDetail.get().setUsageAmount(billingDetail.get().getUsageAmount().add(orderCappingAmount));
//					billingDetailRepository.save(billingDetail.get());
//				} else if (billingDetail.isPresent()) {
//					billingDetail.get().setNextBillingDate( DateUtils.addDays(Calendar.getInstance().getTime(),30));
//					billingDetail.get().setMailSent(0);
//					billingDetailRepository.save(billingDetail.get());
//
//				}
//				this.activateCharges(shop);

				recordUpdated = true;
			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return recordUpdated;
	}

//	private boolean activateCharges(com.mobikasa.shopify.appinstaller.model.Shop shop) throws BusinessException {
//		ObjectMapper objMapper = new ObjectMapper();
//		try {
//			Map<String, String> headerMap = new HashMap<String, String>();
//			headerMap.put("X-Shopify-Access-Token", shop.getAccessToken());
//			headerMap.put("Accept", "application/json");
//
//			ActivateApplicationCharge charge = new ActivateApplicationCharge();
//
//			charge.setApiClientId(new Long(shop.getApiClientId()));
//			charge.setActivatedOn(dateFormat2.format(Calendar.getInstance().getTime()));
//			charge.setBillingOn(dateFormat2.format(Calendar.getInstance().getTime()));
//			charge.setCancelledOn(null);
//
//			charge.setCreatedAt(dateFormat1.format(Calendar.getInstance().getTime()));
//			charge.setDecoratedReturnUrl("");
//			charge.setId(new Long(shop.getProcessId()));
//			charge.setName("Test Plan");
//			charge.setPrice("1000");
//			charge.setReturnUrl("");
//			charge.setStatus("accepted");
//			charge.setTest(testEnvironment);
//			charge.setTrialDays(0);
//			charge.setTrialEndsOn(null);
//			charge.setUpdatedAt(dateFormat1.format(Calendar.getInstance().getTime()));
//
//			ActivateApplicationChargeRequest request = new ActivateApplicationChargeRequest(charge);
//
//			String activateChargeUrl = RequestUrlUtility.updateRequestUrlChargeId(activateChargesUrl, shop.getDomain(),
//					shop.getProcessId().toString());
//
//			String response = APIClient.callAPI(objMapper.writeValueAsString(request), activateChargeUrl, headerMap,
//					"POST");
//
//			APIClient.parseJsonObject(response, Map.class);
//
//			return true;
//		} catch (Exception exp) {
//			exp.printStackTrace();
//		}
//		return false;
//	}

	@Override
	public boolean createShopWebhook(String shopId, String webhookId, String webhookType, String status)
			throws BusinessException {
		boolean recordUpdated = false;
		try {
			ShopWebhook l_shopWebhook = new ShopWebhook();

			l_shopWebhook.setShopId(shopId);
			l_shopWebhook.setWebhookId(webhookId);
			l_shopWebhook.setWebhookType(webhookType);
			l_shopWebhook.setStatus(status);

			shopWebhookRepository.save(l_shopWebhook);
			recordUpdated = true;

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return recordUpdated;
	}

	@Override
	public ShopDto findByDomain(String p_domain) throws BusinessException {
		ShopDto shopDetail = null;
		try {

			com.mobi.fortiva.model.Shop result = shopRepository.findByDomain(p_domain + "");
			if (result != null) {
				shopDetail = new ShopDto();
				shopDetail.setShopName(result.getShopName());
				shopDetail.setHmac(result.getHmac());
				shopDetail.setAccessToken(result.getAccessToken());
				shopDetail.setDomain(result.getDomain());
				shopDetail.setId(result.getId());
				shopDetail.setStatus(result.getStatus());
			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return shopDetail;
	}

//	@Override
//	public ShopDto findByDomainAndStatus(String p_domain, String p_status) throws BusinessException {
//		ShopDto shopDetail = null;
//		try {
//
//			com.mobikasa.shopify.appinstaller.model.Shop result = shopRepository.findByDomainAndStatus(p_domain,
//					p_status);
//			if (result != null) {
//				shopDetail = new ShopDto();
//				shopDetail.setShopName(result.getShopName());
//				shopDetail.setHmac(result.getHmac());
//				shopDetail.setAccessToken(result.getAccessToken());
//				shopDetail.setDomain(result.getDomain());
//				shopDetail.setId(result.getId());
//			}
//
//		} catch (Exception exp) {
//			exp.printStackTrace();
//		}
//		return shopDetail;
//	}
//
//	@Override
//	public List<ShopDto> findByStatus(String p_status) throws BusinessException {
//		List<ShopDto> shopList = new ArrayList<ShopDto>();
//		try {
//
//			List<com.mobikasa.shopify.appinstaller.model.Shop> resultList = shopRepository.findByStatus(p_status);
//			for (com.mobikasa.shopify.appinstaller.model.Shop result : resultList) {
//				ShopDto shopDetail = new ShopDto();
//				shopDetail.setShopName(result.getShopName());
//				shopDetail.setHmac(result.getHmac());
//				shopDetail.setAccessToken(result.getAccessToken());
//				shopDetail.setDomain(result.getDomain());
//				shopDetail.setId(result.getId());
//				shopDetail.setId(result.getId());
//				shopList.add(shopDetail);
//			}
//
//		} catch (Exception exp) {
//			exp.printStackTrace();
//		}
//		return shopList;
//	}
//
//	@SuppressWarnings("unused")
//	@Override
//	public List<ShopDto> findShopBillingDetail(Pageable pageable, ShopSearchCriteria searchCriteOria)
//			throws BusinessException {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		List<ShopDto> shopList = new ArrayList<ShopDto>();
//		try {
//
//			List<Object> result = shopRepository.findShopBillingDetail(pageable, searchCriteOria.getName(),
//					searchCriteOria.getStatus());
//
//			for (Object shop : result) {
//				ShopDto l_shop = new ShopDto();
//				Object[] obj = (Object[]) shop;
//				l_shop.setId(  obj[0].toString() );
//				l_shop.setStatus((boolean) obj[1] ? "1" : "0");
//				l_shop.setShopName(obj[2].toString());
//				l_shop.setInstalledTime(obj[3] != null ? dateFormat.parse(obj[3].toString().split(" ")[0]) : null);
//				l_shop.setUninstalledTime(obj[4] != null ? dateFormat.parse(obj[4].toString().split(" ")[0]) : null);
//				l_shop.setReinstalledTime(obj[5] != null ? dateFormat.parse(obj[5].toString().split(" ")[0]) : null);
//
//				l_shop.setSubscriptionCharge( obj[6] == null ? "1000" : obj[6].toString());
//				l_shop.setApiRate(obj[7] == null ? "0.07" : obj[7].toString());
//				l_shop.setBillingid(obj[8] == null ? "" : obj[8].toString());
//				shopList.add(l_shop);
//			}
//		} catch (Exception exp) {
//			exp.printStackTrace();
//		}
//
//		return shopList;
//	}
//
	public void sendEmail(String shopId) {
		Optional<com.mobi.fortiva.model.Shop> shop=shopRepository.findById(shopId);
		if(shop.isPresent()){
			Mail mailData = new Mail();
			Map<String, String> cont = new HashMap<>();
			cont.put("templateName", "welcome.html");
			mailData.setTo(shop.get().getEmail());
			mailData.setContent(cont);
			try {
				mailSender.sendEmail(mailData);
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
	}
}