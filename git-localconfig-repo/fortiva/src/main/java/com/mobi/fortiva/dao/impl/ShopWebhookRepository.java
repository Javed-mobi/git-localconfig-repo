package com.mobi.fortiva.dao.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobi.fortiva.model.ShopWebhook;

@Repository
public interface ShopWebhookRepository extends CrudRepository<ShopWebhook, String>, ShopWebhookRepositoryCustom{

}	
