package com.mobi.fortiva.util;

import java.util.Date;

//import com.mobikasa.shopify.appinstaller.dao.impl.ApiLogRepository;
//import com.mobikasa.shopify.appinstaller.model.ApiLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobi.fortiva.dao.impl.ApiLogRepository;
import com.mobi.fortiva.model.ApiLogEntity;

@Component
public class CommonUtil {

    private static String SIFT_WEBHOOK_SECRET_KEY = "#####";

    @Autowired
    public static ApiLogRepository apiLogRepository;

    @Autowired
    public void setUserRepo(ApiLogRepository apiLogRepository) {
        apiLogRepository = apiLogRepository;
    }


    public static ApiLogEntity createApiLog(String event, String requestData, Long storeId, String url){
        ApiLogEntity apiLog=new ApiLogEntity();
        Date date=new Date();
        try{
            apiLog.setEvent(event);
            apiLog.setRequestData(requestData);
            apiLog.setRequestTime(date);
            apiLog.setShopId(storeId);
            apiLog.setUrl(url);
            apiLogRepository.save(apiLog);
        }catch(Exception e){
            e.printStackTrace();
        }
        return apiLog;
    }

    public static void updateApiLog(ApiLogEntity apiLog, String responseData) {
        Date date=new Date();
        try{
            apiLog.setResponseData(responseData);
            apiLog.setResponseTime(date);
            apiLogRepository.save(apiLog);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
