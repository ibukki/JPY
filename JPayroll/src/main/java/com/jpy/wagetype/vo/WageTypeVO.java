package com.jpy.wagetype.vo;

import java.io.Serializable;


public class WageTypeVO implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String wageTypeId;

	private Long sequence;
	
	private String begdaString;
	
	private String enddaString;
	
	private Double amount;
	
	private Long count;
	
	private String currency;
	
	/**
	 * @return the wageTypeId
	 */
	public String getWageTypeId() {
		return wageTypeId;
	}

	/**
	 * @param wageTypeId the wageTypeId to set
	 */
	public void setWageTypeId(String wageTypeId) {
		this.wageTypeId = wageTypeId;
	}

	/**
	 * @return the sequence
	 */
	public Long getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}


	/**
	 * @return the begdaString
	 */
	public String getBegdaString() {
		return begdaString;
	}

	/**
	 * @param begdaString the begdaString to set
	 */
	public void setBegdaString(String begdaString) {
		this.begdaString = begdaString;
	}


	/**
	 * @return the enddaString
	 */
	public String getEnddaString() {
		return enddaString;
	}

	/**
	 * @param enddaString the enddaString to set
	 */
	public void setEnddaString(String enddaString) {
		this.enddaString = enddaString;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}


}
