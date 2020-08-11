/**
 *
 */
package com.mobi.fortiva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobi.fortiva.dao.impl.UserRepository;
import com.mobi.fortiva.model.UserMaster;

/**
 * @author MJ
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserMaster findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}