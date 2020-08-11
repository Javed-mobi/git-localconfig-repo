package com.mobi.fortiva.dao.impl;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mobi.fortiva.model.UserMaster;


@Repository
public interface UserRepository extends PagingAndSortingRepository<UserMaster, Long>{
	
	public UserMaster findByUserName(String userName);
}	
