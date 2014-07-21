package com.jpy.schema.conf.eo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="SCHEMA_CONF")
public class SchemaConfEO implements Serializable{
	
	/**
	 * serial version Id
	 */
	private static final long serialVersionUID = 8924338654688704548L;

	@Id
	@Column(name="SCHEMAID")
	private String schemaId;
	
	@Lob
	@Column(name="INPUTPARAM")
	private byte[] inputParam;
	
	@Lob
	@Column(name="OUTPUTPARAM")
	private byte[] outputParam;

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
	 * @return the inputParam
	 */
	public byte[] getInputParam() {
		return inputParam;
	}

	/**
	 * @param inputParam the inputParam to set
	 */
	public void setInputParam(byte[] inputParam) {
		this.inputParam = inputParam;
	}

	/**
	 * @return the outputParam
	 */
	public byte[] getOutputParam() {
		return outputParam;
	}

	/**
	 * @param outputParam the outputParam to set
	 */
	public void setOutputParam(byte[] outputParam) {
		this.outputParam = outputParam;
	}
}
