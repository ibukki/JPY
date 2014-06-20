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
@Table(name="EMPLOYEE")
public class EmployeeEO implements Serializable{
	
	/**
	 * serialize id
	 */
	private static final long serialVersionUID = -5144513949937164829L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeIdSeq")
	@SequenceGenerator(name = "employeeIdSeq", sequenceName = "EMP_ID_SEQ", allocationSize = 1, initialValue = 1)
	@Column(name = "EMPLOYEEID", unique = true)
	private Long employeeId;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name= "LASTNAME")
	private String lastName;
	
	@Column(name="MIDDLENAME")
	private String middleName;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@Column(name="JOB")
	private String job;
	
	@Column(name="DATEOFBIRTH")
	private Date dateOfBirth;
	
	@Column(name="SCHEMAID")
	private String schemaId;
	
	@Column(name="EEGROUPID")
	private String EEGroupId;

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
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
