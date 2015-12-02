package hxk.test;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Administrator
 * @description
 * 其xml内容
 *  <person>
	<name>水货</name>
	<age>25</age>
	<out>
	   <in>in</in>
	</out>
   </person>
 *2015-5-27  下午5:44:05
 */
public class XmlUtil {
    /**
     * @description 读取配置文件	
     *2015-6-14  下午8:59:13
     *返回类型:void
     */
    public static void read(){
	try {
	    Configuration config = new XMLConfiguration("config.xml");
	    String name = config.getString("name");
	    //使用标签名字[@属性名] 就可以得到属性值
	    String level = config.getString("name[@level]");
	    int age = config.getInt("age");
	    System.out.println(name + " -- " + age);
	    System.out.println("level--> " + level);
	    System.out.println(config.getString("out.in"));
	} catch (ConfigurationException e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * @description 将字符串形式的xml转换为可读取的xml	 
     *2015-6-14  下午8:59:59
     *返回类型:void
     */
    public static void readString(){
	String xml = "<person><name>水货</name><age>25</age><out><in>in</in></out></person>";
	InputStream in = new ByteArrayInputStream(xml.getBytes());
	XMLConfiguration config = new XMLConfiguration();
	try {
	    config.load(in);
	    System.out.println(config.getString("name"));
	    System.out.println(config.getString("out.in"));
	    Iterator<String> iterator= config.getKeys();
	    while (iterator.hasNext()) {
		String string = iterator.next();
		System.out.println(string +"---> " + config.getString(string));
	    }
	} catch (ConfigurationException e) {
	    e.printStackTrace();
	}
    }
    
    
    /**
     * @description 使用dom4j解析xml文件	
     *2015-6-14  下午9:34:08
     *返回类型:void
     */
    public static void domRead(){
	SAXReader sax = new SAXReader();
	File file = new File("src//config.xml");
	try {
	    Document document = sax.read(file);
	    Element root = document.getRootElement();
	    Element element = root.element("name");
	    System.out.println(element.getTextTrim());
	} catch (DocumentException e) {
	    e.printStackTrace();
	}
    }
    
    
    /**
    * @description dom4j直接读取string字符串并转换为xml	
    *2015-6-14  下午9:28:36
    *返回类型:void
    */
    public static void domReadString(){
	String xml = "<person><name>水货</name><age>25</age><out><in>in</in></out></person>";
	try {
	    Document document = DocumentHelper.parseText(xml);
	    Element root = document.getRootElement();
	    Element element = root.element("name");
	    System.out.println(element.getTextTrim());
	} catch (DocumentException e) {
	    e.printStackTrace();
	}
    }
    
    
    public static void main(String[] args) {
	read();
    }
}
