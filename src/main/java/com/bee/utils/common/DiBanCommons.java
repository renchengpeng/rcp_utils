package com.bee.utils.common;

/**
 * 
 * TODO 滴办公用
 * @author wangjiucheng
 */
public class DiBanCommons {
    /*** 请求后台路由前缀 */
    public final static String VDB_ADMIN = "vdiban";
    
    
    /***********************税区状态 开始******************************/
    //解冻状态
    public final static String UNFREEZE="0";
    //冻结状态
    public final static String  FREEZE="1";
    /***********************税区状态 结束******************************/
    
    /***********************问题状态码  开始******************************/
    //待确认
    public final static String UNCONFIRMED="1";
    //待付款
    public final static String OBLIGATION="2";
    //水单审核中
    public final static String WATER_BILL_AUDIT="3";
    //水单审核未通过
    public final static String WATER_BILL_AUDIT_FAILED="4";
    //待分配
    public final static String WAIT_FOR_DISTRIBUTION="5";
    //已分配待解答
    public final static String ASSIGNED_TO_BE_SOLVED="6";
    //审核答案中
    public final static String CHECK_THE_ANSWERS="7";
    //审核未通过
    public final static String AUDIT_FAILED="8";
    //解答完毕
    public final static String ANSWER_TO_COMPLETE="9";
    //已评分
    public final static String HAS_SCORE="10";
    //已退款
    public final static String HAVE_REFUND="11";
    /***********************问题状态码  结束******************************/
    //返回状态码-成功
    public static final String VDB_RETURN_SUCCESS="1";
    //返回状态码-失败
    public static final String VDB_RETURN_FAIL="0";
}
