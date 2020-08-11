package com.mobi.fortiva.service.impl;

import java.util.List;

import com.mobi.fortiva.dto.CodeLkupDto;
import com.mobi.fortiva.exception.BusinessException;

public interface CodeLkupService {
	
	public List<CodeLkupDto> fetchCodeLkupList() throws BusinessException;
	
	public String fetchAccessList() throws BusinessException;
}
