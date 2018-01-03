package com.forezp.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlOptions;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class XmlTool {

	private static String _ejbServerUrl;

	private static String _servCodeConf;

	private static String _bizCodeConf;

	private static boolean _xmlSaveFlag = false;

	// 将报文保存下来的路径
	// private static String _xmlSavePath;

	public static XmlOptions getInComingXmlOptions(String xmlns) {
		XmlOptions opts = new XmlOptions();
		HashMap<String, String> suggestedPrefixes = new HashMap<String, String>();
		suggestedPrefixes.put("", xmlns);
		opts.setLoadSubstituteNamespaces(suggestedPrefixes);
		return opts;
	}

	public static XmlOptions getOutGoingXmlOptions(String xmlns) {
		XmlOptions opts = new XmlOptions();
		HashMap<String, String> suggestedPrefixes = new HashMap<String, String>();
		suggestedPrefixes.put("", xmlns);
		opts.setSaveImplicitNamespaces(suggestedPrefixes);
		opts.setSavePrettyPrint();
		opts.setUseDefaultNamespace();
		return opts;
	}

	/**
	 * 将收到的报文保存到文件中, 按日期分子目录;
	 * 
	 * @param destDir
	 * @param fileName
	 * @param xmlString
	 * @return
	 * @throws IOException
	 */
	public static String saveXml2File(String destDir, String fileName,
			String xmlString) throws IOException {
		String separatorChar = System.getProperties().getProperty(
				"file.separator");

		String strDate = DateUtil.format2String(DateUtil.YYYYMMDD);

		String path = destDir + separatorChar + strDate;
		File dir = new File(path);
		if (!dir.exists())
			dir.mkdirs();

		File fullFileName = new File(path + separatorChar + fileName);
		while (fullFileName.exists()) {
			fullFileName = new File(path + separatorChar + fileName
					+ DateUtil.format2String("HHmmssSSS"));
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter(fullFileName,
				true));
		bw.write(xmlString);
		bw.close();
		String fullPath = path + separatorChar + fileName;
		return fullPath;
	}

	/**
	 * 生成给一级枢纽的响应报文;
	 * 
	 * @param RespType
	 * @param RespCode
	 * @param ResDesc
	 * @param svcCont
	 * @param interBoss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getRespXml(String RespType, String RespCode,
			String ResDesc, String svcCont, Document interBoss) {
		String result = "BBOSSRSP ERROR XMLDATA";
		if (interBoss != null) {
			String processTime = DateUtil
					.format2String(DateUtil.YYYYMMDDHHMMSS);
			Element elemSvcCont = (Element) interBoss
					.selectSingleNode("/InterBOSS/SvcCont");
			elemSvcCont.setText("");
			if (svcCont != null && !svcCont.trim().equals(""))
				elemSvcCont.addCDATA(svcCont);

			Element elemActionCode = (Element) interBoss
					.selectSingleNode("/InterBOSS/ActionCode");
			elemActionCode.setText("1");

			Element root = interBoss.getRootElement();
			List elements = root.elements();
			Element idh = (Element) interBoss
					.selectSingleNode("/InterBOSS/TransIDH");
			if (idh != null) {
				idh.setText("BBOSSRSP" + processTime);
				Element newNote = DocumentHelper.createElement("Response");
				newNote.addElement("RspType").setText(RespType);
				newNote.addElement("RspCode").setText(RespCode);
				newNote.addElement("RspDesc").setText(ResDesc);

				Element prcTime = (Element) interBoss
						.selectSingleNode("/InterBOSS/ProcessTime");

				prcTime.setText(processTime);
				elements.add(elements.indexOf(prcTime) + 1, newNote);
				root.setContent(elements);
			} else {
				Element newTransIDH = DocumentHelper.createElement("TransIDH");
				newTransIDH.setText("BBOSSRSP" + processTime);

				Element newNote = DocumentHelper.createElement("Response");
				newNote.addElement("RspType").setText(RespType);
				newNote.addElement("RspCode").setText(RespCode);
				newNote.addElement("RspDesc").setText(ResDesc);

				Element prcTime = (Element) interBoss
						.selectSingleNode("/InterBOSS/ProcessTime");

				prcTime.setText(processTime);
				elements.add(elements.indexOf(prcTime), newTransIDH);
				elements.add(elements.indexOf(prcTime) + 1, newNote);
				root.setContent(elements);
			}

			StringWriter writer = new StringWriter();
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setSuppressDeclaration(true);
			XMLWriter xmlwriter = new XMLWriter(writer, format);
			try {
				xmlwriter.write(interBoss.asXML());
				xmlwriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			result = interBoss.asXML().trim();
		}
		return result;
	}

	/**
	 * 生产给网中网的反馈报文
	 * 
	 * @param RespType
	 * @param RespCode
	 * @param ResDesc
	 * @param svcCont
	 * @param interBoss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getTnsRespXml(String RespType, String RespCode,
			String ResDesc, String svcCont, Document interBoss) {
		String result = "BOSSRSP ERROR XMLDATA";
		if (interBoss != null) {
			String processTime = DateUtil
					.format2String(DateUtil.YYYYMMDDHHMMSS);

			Element elemActionCode = (Element) interBoss
					.selectSingleNode("/InterBOSS/BIPType/ActionCode");
			elemActionCode.setText("1");

			Element root = interBoss.getRootElement();
			List elements = root.elements();

			List transList = ((Element) interBoss
					.selectSingleNode("/InterBOSS/TransInfo")).elements();
			Element idh = (Element) interBoss
					.selectSingleNode("/InterBOSS/TransInfo/TransIDH");
			if (idh != null) {
				idh.setText("BBOSSRSP" + processTime);
			} else {
				idh = DocumentHelper.createElement("TransIDH");
				idh.setText("BBOSSRSP" + processTime);
				transList.add(idh);
			}
			Element pt = (Element) interBoss
					.selectSingleNode("/InterBOSS/TransInfo/TransIDHTime");
			if (pt != null) {
				pt.setText(processTime);
			} else {
				pt = DocumentHelper.createElement("TransIDHTime");
				pt.setText(processTime);
				transList.add(pt);
			}
			Element newNote = DocumentHelper.createElement("Response");
			newNote.addElement("RspType").setText(RespType);
			newNote.addElement("RspCode").setText(RespCode);
			newNote.addElement("RspDesc").setText(ResDesc);
			elements.add(newNote);
			Element elemSvcCont = DocumentHelper.createElement("SvcCont");
			elemSvcCont.setText("");
			if (svcCont != null && !svcCont.trim().equals(""))
				elemSvcCont.addCDATA(svcCont);
			elements.add(elemSvcCont);
			root.setContent(elements);

			StringWriter writer = new StringWriter();
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setSuppressDeclaration(true);
			XMLWriter xmlwriter = new XMLWriter(writer, format);
			try {
				xmlwriter.write(interBoss.asXML());
				xmlwriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			result = interBoss.asXML().trim();
		} else if (ResDesc != null) {
			result = ResDesc;
		}
		return result;
	}

	/**
	 * 取报文内容体;
	 * 
	 * @param interBoss
	 * @return
	 */
	public static String getSvcCont(Document interBoss) {
		Element elemSvcCont = (Element) interBoss
				.selectSingleNode("/InterBOSS/SvcCont");
		return elemSvcCont.getText();
	}

	public static Document getDocument(String interBossXml) throws Exception {
		return DocumentHelper.parseText(interBossXml);
	}

	public static String getBizResp(String svcContXml, Document interBoss) {
		String result = "";
		if (svcContXml.indexOf("<RspCode>00</RspCode>") != -1) {
			result = getRespXml("0", "0000", "Success", svcContXml, interBoss);
		} else if (svcContXml.indexOf("<RspCode>0000</RspCode>") != -1) {
			result = getRespXml("0", "0000", "Success", svcContXml, interBoss);
		} else if (svcContXml.trim().equals("")) {
			result = getRespXml("0", "0000", "Success", svcContXml, interBoss);
		} else if (svcContXml.indexOf("<OrderResult>00</OrderResult>") > -1) {
			result = getRespXml("0", "0000", "Success", svcContXml, interBoss);
		} else {
			result = getRespXml("2", "2998", "Business Wrong", svcContXml,
					interBoss);
		}
		return result;
	}

	public static String getTnsBizResp(String svcContXml, Document interBoss) {
		String result = "";
		if (svcContXml.indexOf("<RspCode>00</RspCode>") != -1) {
			result = getTnsRespXml("0", "0000", "Success", svcContXml,
					interBoss);
		} else if (svcContXml.indexOf("<RspCode>0000</RspCode>") != -1) {
			result = getTnsRespXml("0", "0000", "Success", svcContXml,
					interBoss);
		} else if (svcContXml.trim().equals("")) {
			result = getTnsRespXml("0", "0000", "Success", svcContXml,
					interBoss);
		} else if (svcContXml.indexOf("@SUCCESS@") > -1) {
			svcContXml = svcContXml.replaceAll("@SUCCESS@", "");
			result = getTnsRespXml("0", "0000", "Success", svcContXml,
					interBoss);
		} else if (svcContXml.indexOf("@FAILURE@") > -1) {
			svcContXml = svcContXml.replaceAll("@FAILURE@", "");
			result = getTnsRespXml("2", "2998", "Business Wrong", svcContXml,
					interBoss);
		} else if (svcContXml.indexOf("<Status>00</Status>") > -1) {
			result = getTnsRespXml("0", "0000", "Success", svcContXml,
					interBoss);
		} else {
			result = getTnsRespXml("2", "2998", "Business Wrong", svcContXml,
					interBoss);
		}
		return result;
	}

	public static File getLastModifiedFileInDir(String dirPath) {
		Map<Long, File> tm = new TreeMap<Long, File>();
		File f = new File(dirPath);
		File subFile[] = f.listFiles();
		int fileCount = subFile.length;
		for (int i = 0; i < fileCount; i++) {
			Long tempLong = new Long(subFile[i].lastModified());
			tm.put(tempLong, subFile[i]);
		}
		Set set = tm.keySet();
		Object key = set.toArray()[set.size() - 1];
		return (File) tm.get(key);
	}

	public static String getDocumentNodeStr(Document interBoss, String nodePath)
			throws Exception {
		Element element = (Element) interBoss.selectSingleNode(nodePath);
		String nodeStr = element.getText();
		return nodeStr;
	}

	public static void setXmlSaveFlag(boolean saveFlag) {
		_xmlSaveFlag = saveFlag;
	}

	public static boolean getXmlSaveFlag() {
		return _xmlSaveFlag;
	}

	public static String getEjbServerUrl() {
		return _ejbServerUrl;
	}

	public static void setEjbServerUrl(String serverUrl) {
		_ejbServerUrl = serverUrl;
	}

	public static String get_bizCodeConf() {
		return _bizCodeConf;
	}

	public static void set_bizCodeConf(String codeConf) {
		_bizCodeConf = codeConf;
	}

	public static String get_servCodeConf() {
		return _servCodeConf;
	}

	public static void set_servCodeConf(String codeConf) {
		_servCodeConf = codeConf;
	}

	public static String getSvcCont(String interBossxml) throws Exception {
		Document interBoss = getDocument(interBossxml);
		Element svcCont = (Element) interBoss
				.selectSingleNode("/InterBOSS/SvcCont");
		String xml = svcCont.getText();
		return xml.trim();
	}

	public static String getRoutingInfo(String interBossxml) throws Exception {
		Document interBoss = getDocument(interBossxml);
		Element routingInfo = (Element) interBoss
				.selectSingleNode("/InterBOSS/RoutingInfo/OrigDomain");
		String xml = routingInfo.getText();
		return xml;
	}

	/**
	 * JavaBean转换成xml 默认编码UTF-8
	 *
	 * @param obj
	 * @param writer
	 * @return
	 */
	public static String convertToXml(Object obj) {
		return convertToXml(obj, "UTF-8");
	}

	/**
	 * JavaBean转换成xml
	 * 
	 * @param obj
	 * @param encoding
	 * @return
	 */
	public static String convertToXml(Object obj, String encoding) {
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * xml转换成JavaBean
	 * 
	 * @param xml
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertToJavaBean(String xml, Class<T> c) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}

	/**
	 * 格式化带有空格String类型的xml
	 * 
	 * @author huangso
	 * @version Nov 19, 2015 4:22:09 PM
	 * @param inputXML
	 * @return
	 * @throws Exception
	 */
	public static String formatXML(String inputXML) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new StringReader(inputXML));
		String requestXML = null;
		XMLWriter writer = null;
		if (document != null) {
			try {
				StringWriter stringWriter = new StringWriter();
				// 格式化输出格式
				OutputFormat format = OutputFormat.createPrettyPrint();
				format.setEncoding("UTF-8");
				writer = new XMLWriter(stringWriter, format);
				writer.write(document);
				writer.flush();
				requestXML = stringWriter.getBuffer().toString();
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return requestXML;
	}
	/**
	 * 设置报文内容
	 * @param svcCont 报文体内容
	 * @return String
	 * @throws Exception
	 */
	public static String createInterBoss(String svcCont)throws Exception{
		Element _InterBOSS = DocumentHelper.createElement("InterBOSS");
		Document doc_InterBOSS = DocumentHelper.createDocument(_InterBOSS);
		try {
			Element elemSvcCont = DocumentHelper.createElement("SvcCont");
			elemSvcCont.setText("");
			if (StringUtils.isNotBlank(svcCont))
				elemSvcCont.addCDATA(svcCont);
			_InterBOSS.add(elemSvcCont);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return doc_InterBOSS.asXML();
	}
}
