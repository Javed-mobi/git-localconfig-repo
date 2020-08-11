package com.mobi.fortiva.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobi.fortiva.model.ApiLogEntity;

@Repository
public interface ApiLogRepository extends JpaRepository<ApiLogEntity, Long> {

}
