package com.bee.sys.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.bee.framework.i.bp.core.CoreException;

/**
 * 
 *********************************************************.<br>
 * @classname PropertiesReadUtils <br>
 * @description 获取properties中的属性值
 * @author fengjianjun <br>
 * @created 2017年4月1日 下午3:23:50 <br>
 *********************************************************.<br>
 */
public class PropertiesUtils {
    
    /**
     * 
     *********************************************************.<br>
     * @method getProperties <br>
     * @description 默认获取 config/beeconfig.properties，如有其他文件，则fileName不为空，且为相对路径 <br>
     * @return Properties <br>
     * @author fengjianjun <br>
     * @created 2017年4月1日 下午3:37:25 <br>
     *********************************************************.<br>
     */
    private static Properties getProperties(String fileName) throws CoreException{
        Properties properties = null;
        try {
            InputStream inputStream = null;
            properties = new Properties();
            if(StringUtils.isEmpty(fileName)){
                throw new CoreException("文件路径不正确");
            }
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(inputStream == null){
                throw new CoreException("找不到该文件");
            }
            properties.load(inputStream);
        } catch (CoreException e) {
            throw e;	
        } catch (IOException e) {
            throw new CoreException(e.getMessage(),e);	
        }
        return properties;
    }
    
    /**
     * 
     *********************************************************.<br>
     * @method getProperties <br>
     * @description 默认获取 config/beeconfig.properties
     * @return Properties <br>
     * @author fengjianjun <br>
     * @created 2017年4月1日 下午3:37:25 <br>
     *********************************************************.<br>
     */
    private static Properties getProperties() throws CoreException{
        Properties properties = null;
        try {
            InputStream inputStream = null;
            properties = new Properties();
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/beeconfig.properties");
            if(inputStream == null){
                throw new CoreException("找不到该文件");
            }
            properties.load(inputStream);
        } catch (CoreException e) {
            throw e;    
        } catch (IOException e) {
            throw new CoreException(e.getMessage(),e);  
        }
        return properties;
    }
    
    /**
     * 
     *********************************************************.<br>
     * @method getStringValue <br>
     * @description 获取字符串value,如果找到该值，则返回；否则返回默认值<br>
     * @return String <br>
     * @author fengjianjun <br>
     * @created 2017年4月1日 下午3:38:41 <br>
     *********************************************************.<br>
     */
    public static String getStringValue(String fileName,String key,String defaultValue) throws CoreException{
        
        Properties properties = null;
        if(!StringUtils.isEmpty(fileName)){
            properties = getProperties(fileName);
        }else{
            properties = getProperties();
        }
        if(StringUtils.isEmpty(key)){
            return defaultValue;
        }
        if(properties.containsKey(key)){
            return properties.getProperty(key);
        }
        return defaultValue;
    }
    
    /**
     * 
     *********************************************************.<br>
     * @method getStringValue <br>
     * @description 获取字符串value,如果找到该值，则返回；否则返回默认值<br>
     * @return String <br>
     * @author fengjianjun <br>
     * @created 2017年4月1日 下午3:38:41 <br>
     *********************************************************.<br>
     */
    public static String getStringValue(String key,String defaultValue) throws CoreException{
        
        Properties properties = getProperties();
        if(StringUtils.isEmpty(key)){
            return defaultValue;
        }
        if(properties.containsKey(key)){
            return properties.getProperty(key);
        }
        return defaultValue;
    }
    /**
     * 
     *********************************************************.<br>
     * @method getIntValue <br>
     * @description 获取int值，如果找不到，则返回默认值<br>
     * @return int <br>
     * @author fengjianjun <br>
     * @created 2017年4月1日 下午3:39:55 <br>
     *********************************************************.<br>
     */
    public static int getIntValue(String fileName,String key,int defaultValue) throws CoreException{
        Properties properties = null;
        if(!StringUtils.isEmpty(fileName)){
            properties = getProperties(fileName);
        }else{
            properties = getProperties();
        }
        if(StringUtils.isEmpty(key)){
            return defaultValue;
        }
        if(properties.containsKey(key)){
            return Integer.valueOf(properties.getProperty(key));
        }
        return defaultValue;
    }
    
    /**
     * 
     *********************************************************.<br>
     * @method getIntValue <br>
     * @description 获取int值，如果找不到，则返回默认值<br>
     * @return int <br>
     * @author fengjianjun <br>
     * @created 2017年4月1日 下午3:39:55 <br>
     *********************************************************.<br>
     */
    public static int getIntValue(String key,int defaultValue) throws CoreException{
        Properties properties = getProperties();
        if(StringUtils.isEmpty(key)){
            return defaultValue;
        }
        if(properties.containsKey(key)){
            return Integer.valueOf(properties.getProperty(key));
        }
        return defaultValue;
    }
    
    /**
     * 
     *********************************************************.<br>
     * @method getStringValue <br>
     * @description 获取字符串value,如果找到该值，则返回；否则返回默认值<br>
     * @return String <br>
     * @author fengjianjun <br>
     * @created 2018年3月14日 14:36:42 <br>
     *********************************************************.<br>
     */
	public static String getStringValue(String key) {

		try {
			Properties properties = getProperties();
			if (StringUtils.isEmpty(key)) {
				return null;
			}
			if (properties.containsKey(key)) {
				return properties.getProperty(key);
			}
		} catch (CoreException e) {
			
		}
		return null;
	}
}

	