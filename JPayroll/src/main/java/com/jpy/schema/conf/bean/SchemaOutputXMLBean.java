package com.jpy.schema.conf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("schema_conf")
public class SchemaOutputXMLBean implements Serializable{

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 3253433299219024860L;
	
	@XStreamAlias("output")
	private List<SchemaConfParamXMLBean> output;

	/**
	 * @return the output
	 */
	public List<SchemaConfParamXMLBean> getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(List<SchemaConfParamXMLBean> output) {
		this.output = output;
	}
	
	public void addOutput(SchemaConfParamXMLBean outputBean){
		if(this.output == null){
			this.output = new ArrayList<SchemaConfParamXMLBean>();
		}
		this.output.add(outputBean);
	}
}
