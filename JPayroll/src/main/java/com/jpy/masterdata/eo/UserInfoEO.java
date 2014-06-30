package com.jpy.masterdata.eo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_INFO")
public class UserInfoEO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8940914586918961039L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
	@SequenceGenerator(name = "userIdSeq", sequenceName = "USER_ID_SEQ", allocationSize = 1, initialValue = 1)
	@Column(name = "USERID", unique = true)
	private Long userId;
	
	@Column(name = "USERNAME", unique = true)
	private String userName;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name= "LASTNAME")
	private String lastName;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATEOFBIRTH")
	private Date dateOfBirth;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@Column(name="POSITION")
	private String position;
	
	@Column(name="SCHEMAID")
	private String schemaId;
	
	@Column(name="EEGROUPID")
	private String EEGroupId;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the schemaId
	 */
	public String getSchemaId() {
		return schemaId;
	}

	/**
	 * @param schemaId the schemaId to set
	 */
	public void setSchemaId(String schemaId) {
		this.schemaId = schemaId;
	}

	/**
	 * @return the eEGroupId
	 */
	public String getEEGroupId() {
		return EEGroupId;
	}

	/**
	 * @param eEGroupId the eEGroupId to set
	 */
	public void setEEGroupId(String eEGroupId) {
		EEGroupId = eEGroupId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
