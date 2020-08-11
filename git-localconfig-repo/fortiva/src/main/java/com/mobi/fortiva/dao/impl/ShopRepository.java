package com.mobi.fortiva.dao.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mobi.fortiva.exception.BusinessException;
import com.mobi.fortiva.model.Shop;

@Repository
public interface ShopRepository extends PagingAndSortingRepository<Shop, String>, ShopRepositoryCustom {
	
	public Shop findByDomain(String p_domain) throws BusinessException;
	
	public Shop findByDomainAndStatus(String p_domain, String status) throws BusinessException;
	
	public List<Shop> findByStatus(String status) throws BusinessException;
	
	public Page<Shop> findByShopNameAndStatus(Pageable pageable, String shopName, String status);

}	
