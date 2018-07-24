package com.bee.sys.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

/**
 * 日志代理类
 * @author zl
 */
public class LoggerProxy implements Logger {

    protected transient Logger log = LoggerFactory.getLogger(getClass());

    protected boolean logSwich = false;

    protected static final String PHONE_PATTERN = "(1|861)(3|5|7|8)\\d{9}";

    protected static final String EMAIL_PATTERN = "([a-zA-Z0-9_-]{0,50})@[a-zA-Z0-9_-]+(\\.(com|COM|cn|CN))+";

    protected static final String CARDNO_PATTERN = "[-\\d]{16,19}";

    protected static final int RADIX = 3;

    /**
     * @param clazz
     * @param logSwich
     *            true：开启脱敏处理 false：不开启脱敏处理
     */
    public LoggerProxy(Class<?> clazz, boolean logSwich) {
        log = LoggerFactory.getLogger(clazz);
        this.logSwich = logSwich;
    }

    @Override
    public void trace(String msg) {
        log.trace(handleMsg(msg));
    }

    @Override
    public void trace(Throwable e) {
        log.trace(e);
    }

    @Override
    public void trace(String msg, Throwable e) {
        log.trace(handleMsg(msg), e);
    }

    @Override
    public void debug(String msg) {
        log.debug(handleMsg(msg));
    }

    @Override
    public void debug(Throwable e) {
        log.debug(e);
    }

    @Override
    public void debug(String msg, Throwable e) {
        log.debug(handleMsg(msg), e);
    }

    @Override
    public void info(String msg) {
        log.info(handleMsg(msg));
    }

    @Override
    public void info(Throwable e) {
        log.info(e);
    }

    @Override
    public void info(String msg, Throwable e) {
        log.info(handleMsg(msg), e);
    }

    @Override
    public void warn(String msg) {
        log.warn(handleMsg(msg));
    }

    @Override
    public void warn(Throwable e) {
        log.warn(e);
    }

    @Override
    public void warn(String msg, Throwable e) {
        log.warn(handleMsg(msg), e);
    }

    @Override
    public void error(String msg) {
        log.error(handleMsg(msg));
    }

    @Override
    public void error(Throwable e) {
        log.error(e);
    }

    @Override
    public void error(String msg, Throwable e) {
        log.error(handleMsg(msg), e);
    }

    @Override
    public boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return isInfoEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    public void debug(String msg, String... arg) {
        log.debug(handleMsg(msg, arg));
    }

    public void info(String msg, String... arg) {
        log.info(handleMsg(msg, arg));
    }

    public void warn(String msg, String... arg) {
        log.warn(handleMsg(msg, arg));
    }
    
    public void error(String msg, String... arg) {
    	log.error(handleMsg(msg, arg));
    }

    /**
     * 数据处理
     * 
     * @author zl 2017年11月9日
     * @param msg
     * @param arg
     * @return
     */
    private String handleMsg(String msg, String... arg) {
        if (!StringUtils.isEmpty(msg)) {
            StringBuilder sb = new StringBuilder();
            String[] ss = msg.split("\\{\\}");
            for (int i = 0; i < ss.length; i++) {
                if (i < arg.length) {
                    sb.append(ss[i]);
                    sb.append(arg[i]);
                } else {
                    sb.append(ss[i]);
                }
            }
            return handleMsg(sb.toString());
        }
        return "";
    }

    /**
     * 数据处理
     * 
     * @author zl 2017年11月9日
     * @param msg
     * @return
     */
    private String handleMsg(String msg) {
        if (logSwich) {
            // 关键数据脱敏（目前支持手机号，邮箱，银行卡号）
            for (String string : find(msg)) {
                msg = msg.replace(string, encrypt(string));
            }
        }
        return msg;
    }

    private static List<String> find(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
//        sb.append(CARDNO_PATTERN);
//        sb.append(")|(");
        sb.append(PHONE_PATTERN);
        sb.append(")|(");
        sb.append(EMAIL_PATTERN);
        sb.append(")");
        Pattern p = Pattern.compile(sb.toString()); // 使用正则表达式匹配
        Matcher m = p.matcher(str);
        List<String> list = new ArrayList<String>();
        while (m.find()) {
        	String s = m.group();
        	int index = str.indexOf(s);
        	boolean flag = true;
        	if(index>0) {
        		if(str.substring(index-1, index).matches("[0-9]")) {
        			flag = false;
        		}
        	}
        	if(index+s.length()<str.length()) {
        		if(str.substring(index+s.length(), index+s.length()+1).matches("[0-9]")) {
        			flag = false;
        		}
        	}
        	if(flag) {
        		list.add(m.group());
        	}
        }
        return list;
    }
    private static String encrypt(String ele) {
        StringBuilder sb = new StringBuilder();
        if (ele.matches(PHONE_PATTERN)) {
            sb.append(ele.substring(0, 3));
            sb.append("****");
            sb.append(ele.substring(7, 11));
        } else if (ele.matches(EMAIL_PATTERN)) {
            String[] ss = ele.split("@");
            String prev = ss[0];
            int length = prev.length();
            int count = length / RADIX + 1;
            int midlePrev = length / 2 - 1;
            int midleNext = midlePrev + count;
            sb.append(ele.substring(0, midlePrev));
            sb.append("****");
            sb.append(ele.substring(midleNext, ele.length()));
//        } else if (ele.matches(CARDNO_PATTERN)) {// 查日志可以匹配整个字符串前（length/2）位
//            int length = ele.length();
//            int count = length / RADIX + 1;
//            int midlePrev = length / 2 - 1;
//            int midleNext = midlePrev + count;
//            sb.append(ele.substring(0, midlePrev));
//            sb.append("****");
//            sb.append(ele.substring(midleNext, ele.length()));
        }
        return sb.toString();
    }

   /*public static void main(String[] args) {
        String str = "手机号18813113781和手机号217717771777hui15244141485dkfjkafj卡键：12897890348590@qq.com.CNjCardNo62148301243251627ijh18813113785";
        for (String string : find(str)) {
            System.out.println(string);
            str = str.replace(string, encrypt(string));
        }
        System.out.println(str);
    }*/
}
