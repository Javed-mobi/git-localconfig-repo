package com.mobi.fortiva.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the codelkup database table.
 * 
 */
@Entity
@Table(name = "codelkup")
public class CodeLkup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CodeLkupPK codelkupPK;

	@Column(name = "Descr")
	private String descr;

	@Column(name = "Key1")
	private String key1;

	@Column(name = "Key2")
	private String key2;

	@Column(name = "Key3")
	private String key3;

	@Column(name = "Key4")
	private String key4;

	@Column(name = "Key5")
	private String key5;
	
	@Column(name = "Key6")
	private String key6;

	@Column(name = "Key7")
	private String key7;

	@Column(name = "Key8")
	private String key8;

	@Column(name = "Key9")
	private String key9;

	@Column(name = "Key10")
	private String key10;

	@Column(name = "Status")
	private String status;

	public CodeLkup() {
	}

	/**
	 * @return the codelkupPK
	 */
	public CodeLkupPK getCodelkupPK() {
		return codelkupPK;
	}

	/**
	 * @param codelkupPK
	 *            the codelkupPK to set
	 */
	public void setCodelkupPK(CodeLkupPK codelkupPK) {
		this.codelkupPK = codelkupPK;
	}

	/**
	 * @return the descr
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * @param descr
	 *            the descr to set
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	/**
	 * @return the key1
	 */
	public String getKey1() {
		return key1;
	}

	/**
	 * @param key1
	 *            the key1 to set
	 */
	public void setKey1(String key1) {
		this.key1 = key1;
	}

	/**
	 * @return the key2
	 */
	public String getKey2() {
		return key2;
	}

	/**
	 * @param key2
	 *            the key2 to set
	 */
	public void setKey2(String key2) {
		this.key2 = key2;
	}

	/**
	 * @return the key3
	 */
	public String getKey3() {
		return key3;
	}

	/**
	 * @param key3
	 *            the key3 to set
	 */
	public void setKey3(String key3) {
		this.key3 = key3;
	}

	/**
	 * @return the key4
	 */
	public String getKey4() {
		return key4;
	}

	/**
	 * @param key4
	 *            the key4 to set
	 */
	public void setKey4(String key4) {
		this.key4 = key4;
	}

	/**
	 * @return the key5
	 */
	public String getKey5() {
		return key5;
	}

	/**
	 * @param key5
	 *            the key5 to set
	 */
	public void setKey5(String key5) {
		this.key5 = key5;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	
	
}