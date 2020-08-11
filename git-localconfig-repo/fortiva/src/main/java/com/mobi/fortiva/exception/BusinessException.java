package com.mobi.fortiva.exception;

import java.util.List;

/**
 * @author MJ
 *
 */
public class BusinessException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 356240320372860905L;
	
	public BusinessException(String msgCode, String type) {
		super(msgCode, type);
		// TODO Auto-generated constructor stub
	}
	
	public BusinessException(String message, Throwable cause) {
		super(message,cause);
		// TODO Auto-generated constructor stub
	}
	public BusinessException(List<String> message, String type) {
		super(message,type);
		// TODO Auto-generated constructor stub
	}

}
