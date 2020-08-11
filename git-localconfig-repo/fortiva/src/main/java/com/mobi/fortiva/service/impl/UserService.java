package com.mobi.fortiva.service.impl;

import com.mobi.fortiva.model.UserMaster;


public interface UserService {
	
	public UserMaster findUserByUserName(String userName);
	
}
