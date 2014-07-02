package com.jpy.wagetype.eo;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WAGE_TYPE")
public class WageTypeEO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8634851659371938427L;

	@Id
	@Column(name = "WAGETYPEID")
	private String wageTypeId;
	
	@Id
	@Column(name = "SEQUENCE")
	private Long sequence;
	
	@Column(name = "BEGDA")
	private Date begda;
	
	@Column(name = "ENDDA")
	private Date endda;
	
	@Column(name = "AMOUNT")
	private Double amount;
	
	@Column(name = "COUNT")
	private Long count;
	
	@Column(name= "CURRENCY")
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
	 * @return the begda
	 */
	public Date getBegda() {
		return begda;
	}

	/**
	 * @param begda the begda to set
	 */
	public void setBegda(Date begda) {
		this.begda = begda;
	}

	/**
	 * @return the endda
	 */
	public Date getEndda() {
		return endda;
	}

	/**
	 * @param endda the endda to set
	 */
	public void setEndda(Date endda) {
		this.endda = endda;
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
