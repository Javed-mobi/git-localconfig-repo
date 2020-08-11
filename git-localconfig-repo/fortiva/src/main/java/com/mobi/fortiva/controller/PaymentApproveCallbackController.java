package com.mobi.fortiva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.mobi.fortiva.FortivaRegisterWebhook;
import com.mobi.fortiva.service.impl.ShopService;


@RestController
public class PaymentApproveCallbackController {

	@Autowired
	private FortivaRegisterWebhook shopifyRegisterWebhook;

	@Autowired
	private ShopService shopService;
	

	@RequestMapping(value = { "${app.payment.approve.callback.context}" })
	public RedirectView paymentApproveCallback(@RequestParam(name = "charge_id") String processId, @RequestParam String shopId) {
		try {
			
			boolean recordUpdated = shopService.updateShopProcessId(shopId, processId);

			if(recordUpdated)
				shopifyRegisterWebhook.registerShopifyWebhook(shopId);
		} catch (Exception exp) {

		}
		return new RedirectView("dashboard/configuration?shopId=" + shopId);
	}

}