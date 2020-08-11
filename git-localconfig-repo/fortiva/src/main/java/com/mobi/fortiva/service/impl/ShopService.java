package com.mobi.fortiva.service.impl;

import com.mobi.fortiva.dto.ShopDto;
import com.mobi.fortiva.exception.BusinessException;
import com.mobi.fortiva.response.Shop;


public interface ShopService {
	
	public String createShop(Shop p_shop, String accessToken, String hmac) throws BusinessException;

	public ShopDto findById(Long id)  throws BusinessException;
	
	public ShopDto findByDomain(String p_domain)  throws BusinessException;
	
//	public ShopDto findByDomainAndStatus(String p_domain, String p_status)  throws BusinessException;
//	
//	public List<ShopDto> findByStatus(String p_status)  throws BusinessException;
//	
//	public List<ShopDto> findShopBillingDetail(Pageable pageable, ShopSearchCriteria searchCriteria) throws BusinessException;
//	
	public boolean updateShopProcessId(String shopId, String processId) throws BusinessException;
//	
	public boolean createShopWebhook(String shopId, String webhookId, String webhookType, String status) throws BusinessException;
//
//	public void sendEmail(String shopId);
}
