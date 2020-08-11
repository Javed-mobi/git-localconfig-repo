package com.mobi.fortiva.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

public class ShopRepositoryImpl implements ShopRepositoryCustom {

	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Object> findShopBillingDetail(Pageable pageable, String storeName, String storeStatus) {
		
		StringBuilder l_query = new StringBuilder("select stores.id as 'shopId', stores.status, stores.shop_name, stores.installed_at, stores.uninstalled_at, stores.re_installed_at, ") 
				.append(" billing_details.subscription_amount, billing_details.per_order_charge, stores.billing_approve_status as 'billing_id'") 
				.append(" from stores left join billing_details on stores.id = billing_details.shop_id ")
				.append(" where 1=1 ");
		
		if( !StringUtils.isEmpty(storeName)) {
			l_query.append(" and stores.shop_name like '%").append(storeName).append("%' ");
		}
		if( !StringUtils.isEmpty(storeStatus)) {
			l_query.append(" and stores.status = ").append(storeStatus).append("");
		}
		
		Query query = entityManager.createNativeQuery(l_query.toString());
		List<Object> result = query.getResultList();
		return result;
	}

	/*
	 * public Page<Shop> findShopBillingDetail(ShopSearchCriteria searchCriteria,
	 * Pageable pageable){ extractPage(pageable, <actual content>); }
	 * 
	 * public static <T> Page<T> extractPage(Pageable page, List<T> contents) { int
	 * startIndex = page.getPageNumber() == 0 ? page.getPageNumber() :
	 * page.getPageNumber() + page.getPageSize(); int toIndex = startIndex +
	 * page.getPageSize(); toIndex = toIndex > contents.size() ? contents.size() :
	 * toIndex;
	 * 
	 * final int total = contents.size();
	 * 
	 * List<T> filteredContents;
	 * 
	 * if (startIndex < contents.size()) { filteredContents =
	 * contents.subList(startIndex, toIndex); } else { filteredContents = new
	 * ArrayList<>(); }
	 * 
	 * TotalSupplier totalSupplier = () -> { return total; };
	 * 
	 * return PageableExecutionUtils.getPage(filteredContents,
	 * gotoPage(page.getPageNumber(), page.getPageSize()), totalSupplier); }
	 * 
	 * private static PageRequest gotoPage(int number, int size) { return new
	 * PageRequest(number, size); }
	 */

}
