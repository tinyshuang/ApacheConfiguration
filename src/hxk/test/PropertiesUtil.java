package hxk.test;


import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


/**
 * @author Administrator
 * @description Configuration的插件需要依赖Lang 2.6的jar包以及loggingjar包
 * Lang 2.6的jar包,Lang 3以上的jar包不行..因为Lang 3已经取消了NestableException这个异常类了
 *2015-5-27  下午4:49:35
 */
public class PropertiesUtil {
    
    /**
     * @description 对Properties文件的简单读取	
     *2015-5-27  下午5:33:45
     *返回类型:void
     */
    public static void simpleRead() {
	Configuration config;
	try {
	    config = new PropertiesConfiguration("info.properties");
	    String name = config.getString("name");
	    int age = config.getInt("age");
	    System.out.println(name + "--> " + age);
	} catch (ConfigurationException e) {
	    e.printStackTrace();
	}
    }
    
    
    /**
     * @description 读取List	
     *2015-5-27  下午5:38:54
     *返回类型:void
     */
    public static void readList(){
	Configuration config;
	try {
	    config = new PropertiesConfiguration("info.properties");
	    String[] nums = config.getStringArray("nums");
	    for (String string : nums) {
		System.out.println(string);
	    }
	    
	    System.out.println("---");
	    List<Object> numsList = config.getList("keys");
	    for (Object object : numsList) {
		System.out.println(object);
	    }
	} catch (ConfigurationException e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * @description 传一个默认值给空的值	
     *2015-5-27  下午5:39:04
     *返回类型:void
     */
    public static void notNull(){
	Configuration config;
	try {
	    config = new PropertiesConfiguration("info.properties");
	    Integer id=config.getInteger("id", new Integer(123));  
	    System.out.println(id);
	} catch (ConfigurationException e) {
	    e.printStackTrace();
	}
    }
    
    
    
    
    public static void main(String[] args) {
	notNull();
    }
}
