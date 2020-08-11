/**
 * 
 */
package com.mobi.fortiva.dao.impl;

import java.util.List;

import com.mobi.fortiva.model.CodeLkup;

/**
 * @author MJ
 *
 */

public interface CodeLkupCustom {
	
	public List<CodeLkup> fetchCodeLkupByLkupCodeAndStatus(String p_lkupCode, String p_status);
	
	public String fetchAccessList();
}
