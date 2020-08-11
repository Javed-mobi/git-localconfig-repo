package com.mobi.fortiva.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * Created by MJ
 */
public class Hmac {
	
	private Hmac() {
	}

    public static final String HMAC_ALGORITHM = "HmacSHA256";

    public static String calculateHmac(String message, String secret) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac hmac = Mac.getInstance(HMAC_ALGORITHM);
        SecretKeySpec key = new SecretKeySpec(secret.getBytes(), HMAC_ALGORITHM);
        hmac.init(key);
        
        String encoded = Hex.encodeHexString(hmac.doFinal(message.getBytes()));
        return encoded;
    }


    public static boolean checkHmac(String message, String hmac, String secret) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
    	String calculatedHmac = calculateHmac(message, secret); 
        return hmac.equals(calculatedHmac);
    }

}