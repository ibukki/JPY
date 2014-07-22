package com.jpy.test;

import com.jpy.schema.conf.bean.SchemaConfParamXMLBean;
import com.jpy.schema.conf.bean.SchemaInputXMLBean;
import com.thoughtworks.xstream.XStream;

public class Test {
	
	public static void main(String[] args) {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		
		SchemaInputXMLBean input = new SchemaInputXMLBean();
		
		SchemaConfParamXMLBean param = new SchemaConfParamXMLBean();
		param.setCategory("wageType");
		param.setName("basic pay");
		param.setType("number");
		input.addInput(param);
		
		SchemaConfParamXMLBean param2 = new SchemaConfParamXMLBean();
		param2.setCategory("custom input");
		param2.setName("what ever");
		param2.setType("number");
		input.addInput(param2);
		
		System.out.println(xstream.toXML(input));
		
		//convert xml back to bean
		String xml = xstream.toXML(input);
		XStream xstream2 = new XStream();
		xstream2.alias("schema_conf", SchemaInputXMLBean.class);
		xstream2.alias("param",SchemaConfParamXMLBean.class);
		SchemaInputXMLBean input2 = (SchemaInputXMLBean) xstream2.fromXML(xml);
		System.out.println(input2.getInput().get(0).getName());
	}
}
