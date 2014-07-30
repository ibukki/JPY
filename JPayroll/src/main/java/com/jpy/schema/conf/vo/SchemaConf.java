package com.jpy.schema.conf.vo;

import java.util.List;

public class SchemaConf {
	
	private List<SchemaConfParam> input;
	
	private List<SchemaConfParam> output;

	/**
	 * @return the input
	 */
	public List<SchemaConfParam> getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(List<SchemaConfParam> input) {
		this.input = input;
	}

	/**
	 * @return the output
	 */
	public List<SchemaConfParam> getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(List<SchemaConfParam> output) {
		this.output = output;
	}
	
}
