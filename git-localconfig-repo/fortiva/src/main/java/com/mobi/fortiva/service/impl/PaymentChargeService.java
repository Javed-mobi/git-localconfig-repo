package com.mobi.fortiva.service.impl;

import java.io.IOException;
import java.math.BigDecimal;

import com.mobi.fortiva.exception.BaseException;



public interface PaymentChargeService {
	
	public String createPaymentCharges(Long p_shopId, String p_subscriptionPrice, String p_usageCharge) throws BaseException, IOException;
//
//	public String updateBillingRate(Long p_shopId, BigDecimal p_usageCharge) throws BaseException, IOException;
}
