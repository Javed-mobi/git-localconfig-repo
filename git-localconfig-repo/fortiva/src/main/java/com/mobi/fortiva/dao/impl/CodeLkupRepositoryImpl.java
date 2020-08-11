package com.mobi.fortiva.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobi.fortiva.constant.CodeLkupConstant;
import com.mobi.fortiva.model.CodeLkup;

public class CodeLkupRepositoryImpl implements CodeLkupCustom {

	@Autowired
	private EntityManager entityManger;

	@Override
	public List<CodeLkup> fetchCodeLkupByLkupCodeAndStatus(String p_lkupCode, String p_status) {
		Session session = entityManger.unwrap(Session.class);
		List<CodeLkup> resultList = new ArrayList<CodeLkup>();
		try {

			@SuppressWarnings("deprecation")
			Criteria crt = session.createCriteria(CodeLkup.class);
			crt.add(Restrictions.eq("status", p_status));
			crt.add(Restrictions.eq("codelkupPK.lkupCode", p_lkupCode));

			resultList = crt.list();

			// resultList.add(new Code)
		} catch (Exception exp) {

		}
		return resultList;
	}

	@Override
	public String fetchAccessList() {
		Session session = entityManger.unwrap(Session.class);
		List<CodeLkup> resultList = null;
		String result = null;
		try {
			@SuppressWarnings("deprecation")
			Criteria crt = session.createCriteria(CodeLkup.class);
			crt.add(Restrictions.eq("codelkupPK.LkupCode", CodeLkupConstant.SHOPIFY_ACCESS_LIST));
			crt.add(Restrictions.eq("status", 1));

			crt.setProjection(Projections.groupProperty("key1"));

			result = (String) crt.uniqueResult();
		} catch (Exception exp) {

		}
		return result;
	}

}
