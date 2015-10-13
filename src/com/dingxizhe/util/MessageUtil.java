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
	 * 将xml转为map集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request)
		throws IOException,DocumentException{
		//创建键值对
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		
		//获取输入输入流
		InputStream ins = request.getInputStream();
		//获取所有节点数据
		Document doc = reader.read(ins);
		//获取根节点标记
		Element root = doc.getRootElement();
		
		//获取节点数据集合
		List<Element> list = root.elements();
		
		//遍历集合将数据存储到map中
		for(Element e:list){
			map.put(e.getName(), e.getText());
		}
		//关闭输入流
		ins.close();
		//返回键值对
		return map;
	}
	

	/**
	 * 将文本消息对象转换为xml
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
