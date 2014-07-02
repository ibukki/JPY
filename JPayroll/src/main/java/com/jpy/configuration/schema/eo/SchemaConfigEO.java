package com.jpy.configuration.schema.eo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="CONF_SCHEMA")
public class SchemaConfigEO implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8116898319156952805L;

	@Id
	@Column(name = "SCHEMAID")
	private String schemaId;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Lob
	@Column(name = "SCHEMACONTENT")
	private byte[] schemaContent;

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
	 * @return the schemaContent
	 */
	public byte[] getSchemaContent() {
		return schemaContent;
	}

	/**
	 * @param schemaContent the schemaContent to set
	 */
	public void setSchemaContent(byte[] schemaContent) {
		this.schemaContent = schemaContent;
	}
}
