package com.dingxizhe.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dingxizhe.message.po.TextMessage;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	
	/**
	 * ��xmlתΪmap����
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request)
		throws IOException,DocumentException{
		//������ֵ��
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		
		//��ȡ����������
		InputStream ins = request.getInputStream();
		//��ȡ���нڵ�����
		Document doc = reader.read(ins);
		//��ȡ���ڵ���
		Element root = doc.getRootElement();
		
		//��ȡ�ڵ����ݼ���
		List<Element> list = root.elements();
		
		//�������Ͻ����ݴ洢��map��
		for(Element e:list){
			map.put(e.getName(), e.getText());
		}
		//�ر�������
		ins.close();
		//���ؼ�ֵ��
		return map;
	}
	

	/**
	 * ���ı���Ϣ����ת��Ϊxml
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());
		return xStream.toXML(textMessage);
	}
}
