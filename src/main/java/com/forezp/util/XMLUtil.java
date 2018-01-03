package com.forezp.util;

import java.util.HashMap;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

public class XMLUtil {
	public static final String XMLHEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

	public static final String XMLHEAD_GBK = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n";

	/**
	 * 格式化报文，去掉NAMESPACE；
	 * 
	 * @param xmlObj
	 * @param xmlns
	 * @return
	 */
	public static String getXMLText(XmlObject xmlObj, String xmlns) {
		if (xmlObj == null)
			return null;
		return XMLHEAD + xmlObj.xmlText(getXmlOptions(xmlns));
	}

	public static String getXMLText(XmlObject xmlObj, String xmlns, String charSet) {
		if (xmlObj == null)
			return null;

		if ("GBK".equals(charSet))
			return XMLHEAD_GBK + xmlObj.xmlText(getXmlOptions(xmlns, charSet));
		else
			return xmlObj.xmlText(getXmlOptions(xmlns, charSet));
	}

	/**
	 * 格式化报文，去掉NAMESPACE；不包含报文编码行
	 * 
	 * @param xmlObj
	 * @param xmlns
	 * @return
	 */
	public static String getXMLTextNoHead(XmlObject xmlObj, String xmlns) {
		if (xmlObj == null)
			return null;
		return xmlObj.xmlText(getXmlOptions(xmlns));
	}

	/**
	 * 生成一个格式化报文的 XmlOptions
	 * 
	 * @param xmlns
	 * @return
	 */
	public static XmlOptions getXmlOptions(String xmlns) {
		return getXmlOptions(xmlns, "UTF-8");
	}

	public static XmlOptions getXmlOptions(String xmlns, String charSet) {
		XmlOptions options = new XmlOptions();
		HashMap<String, String> suggestedPrefixes = new HashMap<String, String>();
		suggestedPrefixes.put("", xmlns);
		options.setSaveImplicitNamespaces(suggestedPrefixes);
		options.setSavePrettyPrint();
		options.setSavePrettyPrintIndent(2);
		options.setUseDefaultNamespace();
		options.setCharacterEncoding(charSet);
		options.setSaveCDataEntityCountThreshold(1);
		options.setSaveCDataLengthThreshold(8);
		return options;
	}

	/**
	 * 
	 * @param xmlns
	 * @return
	 */
	public static XmlOptions getInComingXmlOptions(String xmlns) {
		XmlOptions options = new XmlOptions();
		HashMap<String, String> suggestedPrefixes = new HashMap<String, String>();
		suggestedPrefixes.put("", xmlns);
		options.setLoadSubstituteNamespaces(suggestedPrefixes);
		return options;
	}

}
