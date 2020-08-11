/**
 * 
 */
package com.mobi.fortiva.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobi.fortiva.constant.CodeLkupConstant;
import com.mobi.fortiva.dao.impl.CodeLkupRepository;
import com.mobi.fortiva.dto.CodeLkupDto;
import com.mobi.fortiva.exception.BusinessException;
import com.mobi.fortiva.model.CodeLkup;

/**
 * @author MJ
 *
 */
@Service("storeService")
public class CodeLkupServiceImpl implements CodeLkupService {

	@Autowired
	private CodeLkupRepository CodeLkupRepository;
	
	@Transactional 
	@Override
	public List<CodeLkupDto> fetchCodeLkupList() throws BusinessException {
		List<CodeLkupDto> codeLkupList = new ArrayList<CodeLkupDto>(); 
		try {
			
			List<CodeLkup> resultList = CodeLkupRepository.fetchCodeLkupByLkupCodeAndStatus(CodeLkupConstant.SHOPIFY_ACCESS_LIST, "1");
			
			resultList.stream().forEach(model -> { codeLkupList.add(transformModel2Dto(model));});

			
		} catch(Exception exp) {
			System.out.println();
		}
		
		return codeLkupList;
	}


	@Override
	public String fetchAccessList() throws BusinessException {
		String accessList = null; 
		try {
			accessList = CodeLkupRepository.fetchAccessList();
		} catch(Exception exp) {
			
		}
		return accessList;
	}
	
	
	private static CodeLkupDto transformModel2Dto(CodeLkup p_codeLkup) {
		CodeLkupDto result = new CodeLkupDto();
		if(p_codeLkup != null) {
			result.setLkupCode(p_codeLkup.getCodelkupPK().getLkupCode());
			result.setKeyCode(p_codeLkup.getCodelkupPK().getKeyCode());
			result.setDescr(p_codeLkup.getDescr());
			result.setKey1(p_codeLkup.getKey1());
			result.setKey2(p_codeLkup.getKey2());
			result.setKey3(p_codeLkup.getKey3());
			result.setKey4(p_codeLkup.getKey4());
			result.setKey5(p_codeLkup.getKey5());
			result.setKey6(p_codeLkup.getKey6());
			result.setKey7(p_codeLkup.getKey7());
			result.setKey8(p_codeLkup.getKey8());
			result.setKey9(p_codeLkup.getKey9());
			result.setKey10(p_codeLkup.getKey10());
		}
		
		return result;
		
	}

}
