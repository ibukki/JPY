package com.jpy.schema.eo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="SCHEMA")
public class SchemaEO implements Serializable{

	/**
	 * serialVersion
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SCHEMAID")
	private String schemaId;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Lob
	@Column(name="SCHEMACONTENT")
	private byte[] content;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}
	
	
}
