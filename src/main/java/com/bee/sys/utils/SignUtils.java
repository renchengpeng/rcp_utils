package com.bee.sys.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.bee.framework.i.bp.core.CoreException;
import com.bee.framework.ui.utils.CipherUtil;

/**
 * 
 * 内部签名规则
 * @author zjk
 */
public class SignUtils {
    
    protected static final Logger log = LoggerFactory.getLogger(SignUtils.class);
    
    /**
     * 
     * 生成签名
     * @author zjk
     * 2017年11月30日
     * @param param 中包含中文的需要进行base64编码，防止签名结果不匹配
     * 				会自动过滤 sign不进行加签
     * @return 生成的sign
     */
    public static String createSign(Map<String, String> param){
        return CipherUtil.encryptMD5(createParam(param).toUpperCase(), true);
    }
    
    
    /**
     * 通过 request 校验签名
     * @param request 含sign的话，会自动过滤
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public static boolean validateSign(HttpServletRequest request) throws Exception{
    	Map<String,String> map = BeeUtils.getParameterMap(request.getParameterMap());
        if(map==null || map.size() == 0) {
        	throw new CoreException("参数获取失败");
        }
        return validateSign(map, map.get("sign"));
    }
    
    /**
     * 
     * 校验签名
     * @author zjk
     * 2017年11月30日
     * @param param 含sign的话，会自动过滤
     * @param sign
     * @return true 通过 false 失败
     * @throws CoreException 
     */
    public static boolean validateSign(Map<String, String> param,String sign) throws Exception{
        String timestamp = param.get("timestamp");
        Long timeNow=System.currentTimeMillis()/1000;
        
        if(StringUtils.isBlank(timestamp) || (timeNow-Long.valueOf(timestamp))>600l){//时间戳过期时间是10分钟暂定
            return false;
        }
        String mysign=createSign(param);
        log.debug(">>>>>【传进来的签名："+sign+"】--------【生成的签名:"+mysign+"】<<<<<<<<<<");
        return sign.equals(mysign);
    }
    
    
    /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组  自动过滤 sign 不进行拼接
     * @return 拼接后字符串
     */
    public static String createParam(Map<String, String> param) {

        List<String> keys = new ArrayList<String>(param.keySet());
        Collections.sort(keys);
        StringBuilder prestr = new StringBuilder();
        String key="";
        String value="";
        for (int i = 0; i < keys.size(); i++) {
              key = keys.get(i);
              value = param.get(key);
            if("".equals(value) || value == null ||  key.equalsIgnoreCase("sign")){
                continue;
            }
            prestr.append(key).append("=").append(value).append("&");
        }
        log.debug(">>>>【加密前拼接的字符串为:"+prestr+"】<<<<<");
        return  prestr.deleteCharAt(prestr.length()-1).toString();
    }
    
    /**
     * 
     * 带私钥的签名生成方法
     * @author zjk
     * 2018年9月10日
     * @param param
     * @param privateKey
     * @return
     */
    public static String createSign(Map<String, String> param,String privateKey){
        return CipherUtil.encryptMD5(createParam(param,privateKey).toUpperCase(), true);
    }
    
    
    /**
     * 
     * 带私钥的签名串拼接
     * @author zjk
     * 2018年9月10日
     * @param param
     * @param privateKey
     * @return
     */
    public static String createParam(Map<String, String> param,String privateKey) {
        param.put("privateKey", privateKey);
        List<String> keys = new ArrayList<String>(param.keySet());
        Collections.sort(keys);
        StringBuilder prestr = new StringBuilder();
        String key="";
        String value="";
        for (int i = 0; i < keys.size(); i++) {
              key = keys.get(i);
              value = param.get(key);
            if("".equals(value) || value == null ||  key.equalsIgnoreCase("sign")){
                continue;
            }
            prestr.append(key).append("=").append(value).append("&");
        }
        log.debug(">>>>【加密前拼接的字符串为:"+prestr+"】<<<<<");
        return  prestr.deleteCharAt(prestr.length()-1).toString();
    }
    
    /**
     * 
     * 带私钥的验签方法
     * @author zjk
     * 2018年9月10日
     * @param request
     * @param privateKey
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static boolean validateSign(HttpServletRequest request,String privateKey) throws Exception{
        Map<String,String> map = BeeUtils.getParameterMap(request.getParameterMap());
        if(map==null || map.size() == 0) {
            throw new CoreException("参数获取失败");
        }
        map.put("privateKey", privateKey);
        return validateSign(map, map.get("sign"));
    }
    
    
}
