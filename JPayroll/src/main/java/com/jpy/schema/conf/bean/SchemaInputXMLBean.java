package com.jpy.schema.conf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("schema_conf")
public class SchemaInputXMLBean implements Serializable{
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -3450695343281325414L;
	@XStreamAlias("input")
	private List<SchemaConfParamXMLBean> input;

	/**
	 * @return the input
	 */
	public List<SchemaConfParamXMLBean> getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(List<SchemaConfParamXMLBean> input) {
		this.input = input;
	}
	
	public void addInput(SchemaConfParamXMLBean inputBean){
		if(this.input == null){
			this.input = new ArrayList<SchemaConfParamXMLBean>();
		}
		this.input.add(inputBean);
	}
}
