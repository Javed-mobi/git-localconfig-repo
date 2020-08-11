package com.mobi.fortiva.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.SSLContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobi.fortiva.exception.BaseException;
import com.mobi.fortiva.exception.BusinessException;
import com.mobi.fortiva.model.ApiLogEntity;
import com.mobi.fortiva.util.CommonUtil;

public class APIClient {

	public static String callAPI(String request, String apiUrl, Map<String, String> requestHeader, String requestMethod) throws BaseException {
		HttpURLConnection connection = null;
		DataOutputStream wr = null;
		InputStream is = null;
		BufferedReader rd = null;
		try {
			ApiLogEntity apiLog = CommonUtil.createApiLog("shopify", request, 0L,apiUrl);

			URL url = new URL(apiUrl);
			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestMethod(requestMethod == null ? "POST" : requestMethod);
			connection.setRequestProperty("Content-Length", "" + Integer.toString(request.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			
			if(requestHeader != null && !requestHeader.isEmpty()) {
				
				for(Map.Entry<String, String> header : requestHeader.entrySet()) {
					connection.setRequestProperty(header.getKey(), header.getValue());
				}
				
			}
			
			//connection.setUseCaches(false);
			connection.setDoOutput(true);
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(180000);
			
			if(!requestMethod.equalsIgnoreCase("GET")) {
				wr = new DataOutputStream(connection.getOutputStream());
				wr.writeBytes(request);
				wr.flush();
			}
			
			is = connection.getInputStream();
			System.out.println(request);
			rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String line;
			StringBuffer res = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				res.append(line);
				res.append('\r');
			}
			System.out.println(res);
			CommonUtil.updateApiLog(apiLog, res.toString());
			if (res.toString().equals("")) {
				throw new BusinessException("common.msg.ApiResponseNotFound", BusinessException.BUSSINESS_TYP);
			}
			return res.toString();

		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			// throw new BusinessException(e.getMessage(), BusinessException.BUSSINESS_TYP);
		} finally {
			if (connection != null) {
				try {
					connection.disconnect();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				connection = null;
			}
			if (wr != null) {
				try {
					wr.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				wr = null;
			}
			if (is != null) {
				try {
					is.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				is = null;
			}
			rd = null;
		}
		return null;
	}

	static {
		try {
			SSLContext ctx = SSLContext.getInstance("TLSv1.2");
			ctx.init(null, null, null);
			SSLContext.setDefault(ctx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object parseJsonObject(String jsonString, Class<?> varClass) throws IOException {
		if (jsonString != null && !jsonString.isEmpty()) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
				return objectMapper.readValue(jsonString, varClass);
			} catch (JsonParseException jEx) {
				jEx.printStackTrace();
				throw jEx;
			} catch (JsonMappingException jMEx) {
				jMEx.printStackTrace();
				throw jMEx;
			} catch (IOException iEx) {
				iEx.printStackTrace();
				throw iEx;
			}
		}
		System.out.println("JSON Response is not coming.Try Agian With your Json");
		return null;
	}
	/*
	 * private void saveInLog(UserInfo userInfo, Map<String, String> apiDetails) {
	 * try { RestAPILogDTO restAPILogDTO = new RestAPILogDTO();
	 * restAPILogDTO.setApiName(apiDetails.get("methodName"));
	 * restAPILogDTO.setUrl(apiDetails.get("apiUrl") +
	 * apiDetails.get("methodName"));
	 * restAPILogDTO.setRequestData(apiDetails.get("request"));
	 * restAPILogDTO.setSuccess("true");
	 * restAPILogDTO.setMessage(apiDetails.get("message"));
	 * restAPILogDTO.setErrorCode("0");
	 * restAPILogDTO.setResponseCode(Integer.parseInt(apiDetails.get("responseCode")
	 * )); restAPILogDTO.setResponseTimeInMilliSec(0); if
	 * (apiDetails.get("response").length() > 1000) { String shortResponse =
	 * apiDetails.get("response").substring(0, 999);
	 * restAPILogDTO.setResponseData(shortResponse); } else {
	 * restAPILogDTO.setResponseData(apiDetails.get("response")); } restAPILogDTO =
	 * ejbCommonServiceLookup().saveRestApiLogs(userInfo, restAPILogDTO); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 */

}