package com.bee.sys.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ValideDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String validCode;//验证码
    
    private String telphone;//发送验证码的手机
    
    private String valideMail; // 发送验证码邮箱
    
    private Long valideTime;//发送验证码的时间
    
    private String email;//邮箱号
    
    private String messageType;//0 短信  1 邮箱
    
    private String systemCode;//平台
    
    private String template;//模版
    
    private String subject;//邮件主题
    
    private String signature;
    
    private Map<String,Object> map = new HashMap<String,Object>();//发送邮件时，参数走这个
    
    public Long getValideTime() {
        return valideTime;
    }
    public void setValideTime(Long valideTime) {
        this.valideTime = valideTime;
    }
	public String getValideMail() {
		return valideMail;
	}
	public void setValideMail(String valideMail) {
		this.valideMail = valideMail;
	}
    public String getMessageType() {
    
        return messageType;
    }
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    public String getSystemCode() {
    
        return systemCode;
    }
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
    public String getValidCode() {
    
        return validCode;
    }
    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }
    public String getTelphone() {
    
        return telphone;
    }
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
    public String getTemplate() {
    
        return template;
    }
    public void setTemplate(String template) {
        this.template = template;
    }
    public String getEmail() {
    
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSubject() {
    
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Map<String, Object> getMap() {
    
        return map;
    }
    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
    public String getSignature() {
    
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    
}
