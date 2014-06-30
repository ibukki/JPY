package com.jpy.masterdata.eo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_LOGIN")
public class UserLoginEO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8414992933069742840L;

	@Id
	@Column(name = "USERID", unique = true)
	private Long userId;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "LASTACCESSED")
	private Date lastAccessed;
	
	@Column(name = "FAILEDCOUNT")
	private int failedCount;
	
	@Column(name = "EXPIREDATE")
	private Date expireDate;
	
	@Column(name = "STATUS")
	private char status;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the lastAccessed
	 */
	public Date getLastAccessed() {
		return lastAccessed;
	}

	/**
	 * @param lastAccessed the lastAccessed to set
	 */
	public void setLastAccessed(Date lastAccessed) {
		this.lastAccessed = lastAccessed;
	}

	/**
	 * @return the failedCount
	 */
	public int getFailedCount() {
		return failedCount;
	}

	/**
	 * @param failedCount the failedCount to set
	 */
	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	/**
	 * @return the expireDate
	 */
	public Date getExpireDate() {
		return expireDate;
	}

	/**
	 * @param expireDate the expireDate to set
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
	}
}
