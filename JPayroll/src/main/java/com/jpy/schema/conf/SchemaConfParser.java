package com.jpy.schema.conf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.jpy.schema.conf.bean.SchemaConfParamXMLBean;
import com.jpy.schema.conf.bean.SchemaInputXMLBean;
import com.jpy.schema.conf.bean.SchemaOutputXMLBean;
import com.jpy.schema.conf.vo.SchemaConfParam;
import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author ibukki
 *
 */
public class SchemaConfParser {
	
	private static Logger logger = Logger.getLogger(SchemaConfParser.class);
	
	public static List<SchemaConfParam> parseConfParams(byte[] confByte, String type){
		InputStream inputStream = new ByteArrayInputStream(confByte);
		XStream xstream2 = new XStream();
		List<SchemaConfParamXMLBean> paramList = null;
		if("input".equals(type)){
			xstream2.alias("schema_conf", SchemaInputXMLBean.class);
			xstream2.alias("param",SchemaConfParamXMLBean.class);
			SchemaInputXMLBean inputXMLBean = (SchemaInputXMLBean) xstream2.fromXML(inputStream);
			if(inputXMLBean != null){
				paramList = inputXMLBean.getInput();
			}
			
		}else if("output".equals(type)){
			xstream2.alias("schema_conf", SchemaOutputXMLBean.class);
			xstream2.alias("param",SchemaConfParamXMLBean.class);
			SchemaOutputXMLBean outputXMLBean = (SchemaOutputXMLBean) xstream2.fromXML(inputStream);
			if(outputXMLBean != null){
				paramList = outputXMLBean.getOutput();
			}
		}
		
		List<SchemaConfParam> paramVOList = new ArrayList<SchemaConfParam>();
		for (SchemaConfParamXMLBean schemaConfParamXMLBean : paramList) {
			SchemaConfParam paramVO = new SchemaConfParam();
			try {
				BeanUtils.copyProperties(paramVO, schemaConfParamXMLBean);
			} catch (Exception e) {
				logger.error("parseConfParams( ) - failed to copy the properties"); 
			}
			paramVOList.add(paramVO);
		}
		return paramVOList;
	}
	
	
	public static String convertConfBeanToXML(List<SchemaConfParamXMLBean> paramList, String type){
		XStream xstream = new XStream();
		if("input".equals(type)){
			SchemaInputXMLBean inputXMLBean = new SchemaInputXMLBean();
			inputXMLBean.setInput(paramList);
			return xstream.toXML(inputXMLBean);
		}else if("output".equals(type)){
			SchemaOutputXMLBean outputXMLBean = new SchemaOutputXMLBean();
			outputXMLBean.setOutput(paramList);
			return xstream.toXML(outputXMLBean);
		}
		return null;
	}
}
