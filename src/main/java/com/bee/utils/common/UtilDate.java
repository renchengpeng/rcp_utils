
package com.bee.utils.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.bee.framework.date.util.DateUtils;
import com.bee.framework.i.bp.core.CoreException;

/*
 * * 类名：UtilDate 功能：自定义订单类 详细：工具类，可以用作获取系统日期、订单编号等 版本：3.3 日期：2012-08-17 说明： 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class UtilDate {

    /** 年月日时分秒(无下划线) yyyyMMddHHmmss */
    public static final String dtLong = "yyyyMMddHHmmss";

    /** 完整时间 yyyy-MM-dd HH:mm:ss */
    public static final String simple = "yyyy-MM-dd HH:mm:ss";

    /** 年月日(无下划线) yyyyMMdd */
    public static final String dtShort = "yyyyMMdd";

    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
     * 
     * @return 以yyyyMMddHHmmss为格式的当前系统时间
     */
    public static String getOrderNum() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtLong);
        return df.format(date);
    }

    /**
     * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String getDateFormatter() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(simple);
        return df.format(date);
    }

    /**
     * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
     * 
     * @return
     */
    public static String getDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtShort);
        return df.format(date);
    }

    /**
     * 产生随机的三位数
     * 
     * @return
     */
    public static String getThree() {
        Random rad = new Random();
        return rad.nextInt(1000) + "";
    }
    
    /**
     * 
     * 返回yyyy-MM-dd格式的日期
     * @author zjk
     * 2018年8月9日
     * @return
     * @throws CoreException
     */
    public static Date getNowDate() throws CoreException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        return getDate(sdf.format(new Date()));
    }

    /**
     * 
     * 根据yyyy-MM-dd类型日期获取一个
     * @author zjk
     * 2018年8月9日
     * @param dateString
     * @return
     * @throws CoreException
     */
    public static Date getDate(String dateString) throws CoreException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
            return sdf.parse(dateString);
        } catch (ParseException e) {
            throw new CoreException("获取时间失败");
        }
    }
    
    /**
     * 
     * 获取yyyy-MM-dd格式的日期
     * @author zjk
     * 2018年8月9日
     * @param date
     * @return
     */
    public static String getDateString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        return sdf.format(date);
    }

    
    /**
     * 
     *  获取传入日期本周的周一的日期
     * @author zjk
     * 2018年8月9日
     * @param date
     * @return
     */
    public static Date getFirstDayDateOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        
        return cal.getTime();
    }
    
    /**
     * 
     *  获取传入日期本周的周日的日期
     * @author zjk
     * 2018年8月9日
     * @param date
     * @return
     */
    public static Date getLastDayDateOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, 6);
        return cal.getTime();
    }
    
    
    
    /**
     * 
     * 获取传入日期当月的第一天的日期
     * @author zjk
     * 2018年8月9日
     * @param date
     * @return
     */
    public static Date getFirstDayDateOfMonth(Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }
    
    
    /**
     * 
     * 获取传入日期当月的最后一天的日期
     * @author zjk
     * 2018年8月9日
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }
    
    /**
     * 
     * 获取传入日期当年的第一天的日期
     * @author zjk
     * 2018年8月9日
     * @param date
     * @return
     */
    public static Date getFirstDayDateOfYear(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, last);
        return cal.getTime();
    }
    
    /**
     * 
     * 获取传入日期当年的最后一天的日期
     * @author zjk
     * 2018年8月9日
     * @param date
     * @return
     */
    public static Date getLastDayOfYear(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, last);
        return cal.getTime();
    }


    public static void main(String[] args) {
        try {
            System.out.println(UtilDate.getFirstDayDateOfWeek(UtilDate.getNowDate()));
            System.out.println(DateUtils.getNextDate(UtilDate.getDate("2018-8-31"),1));
            System.out.println(UtilDate.getFirstDayDateOfWeek(UtilDate.getDate("2019-1-1")));
            System.out.println(DateUtils.getDateString(UtilDate.getLastDayDateOfWeek(UtilDate.getDate("2019-1-1"))));
            System.out.println(DateUtils.getDateString(UtilDate.getFirstDayDateOfMonth(UtilDate.getDate("2018-09-12"))));
            System.out.println(DateUtils.getDateString(UtilDate.getLastDayOfMonth(UtilDate.getDate("2018-09-12"))));
            System.out.println(DateUtils.getDateString(UtilDate.getFirstDayDateOfYear(UtilDate.getDate("2018-08-12"))));
            System.out.println(DateUtils.getDateString(UtilDate.getLastDayOfYear(UtilDate.getDate("2018-08-12"))));
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

}
