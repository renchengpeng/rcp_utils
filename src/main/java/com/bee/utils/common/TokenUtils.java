package com.bee.utils.common;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.bee.framework.ui.utils.CipherUtil;

/**
 * 
 * 折付宝token
 * @author zjk
 */
public class TokenUtils {
    
    /**
     * 
     * 生成token
     * @author zjk
     * 2016年8月30日
     * @return
     */
    public static String createToken(String loginname,String custAcNo){
        StringBuffer sb=new StringBuffer();
        if( StringUtils.isNotBlank(loginname) && StringUtils.isNotBlank(custAcNo)){
            sb.append(loginname);
            sb.append(custAcNo);
        }
        sb.append(UUID.randomUUID());
        return CipherUtil.encryptMD5(sb.toString(), false);
    }
    
}
