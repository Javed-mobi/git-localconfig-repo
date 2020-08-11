/**
 * 
 */
package com.mobi.fortiva.dao.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;

/**
 * @author MJ
 *
 */

public interface ShopRepositoryCustom {
	
	public List<Object> findShopBillingDetail(Pageable pageable, String storeName, String storeStatus);
}
