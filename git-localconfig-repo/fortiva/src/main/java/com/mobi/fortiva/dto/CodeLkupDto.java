package com.mobi.fortiva.dto;

import java.io.Serializable;

public class CodeLkupDto implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String lkupCode;
	private String keyCode;
	private String descr;
	private String key1;
	private String key2;
	private String key3;
	private String key4;
	private String key5;
	private String key6;
	private String key7;
	private String key8;
	private String key9;
	private String key10;
	private Integer status;
	
	public CodeLkupDto() {}
	
	public CodeLkupDto(String key1, String key2) {
		this.key1 = key1;
		this.key2 = key2;
	}
	
	public String getLkupCode() {
		return lkupCode;
	}
	public void setLkupCode(String lkupCode) {
		this.lkupCode = lkupCode;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	public String getKey3() {
		return key3;
	}
	public void setKey3(String key3) {
		this.key3 = key3;
	}
	public String getKey4() {
		return key4;
	}
	public void setKey4(String key4) {
		this.key4 = key4;
	}
	public String getKey5() {
		return key5;
	}
	public void setKey5(String key5) {
		this.key5 = key5;
	}
	public String getKey6() {
		return key6;
	}
	public void setKey6(String key6) {
		this.key6 = key6;
	}
	public String getKey7() {
		return key7;
	}
	public void setKey7(String key7) {
		this.key7 = key7;
	}
	public String getKey8() {
		return key8;
	}
	public void setKey8(String key8) {
		this.key8 = key8;
	}
	public String getKey9() {
		return key9;
	}
	public void setKey9(String key9) {
		this.key9 = key9;
	}
	public String getKey10() {
		return key10;
	}
	public void setKey10(String key10) {
		this.key10 = key10;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}