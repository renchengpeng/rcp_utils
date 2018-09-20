package com.bee.utils.common;

/**
 * 
 * TODO 滴办公用
 * @author wangjiucheng
 */
public class DiBanCommons {
	
	//加密使用
	public static final String DB_PRIVATE_KEY = "DIBANWANWANSUI88";
	 
    /*** 请求后台路由前缀 */
    public final static String VDB= "vdiban";
    /*** 请求滴办个人路由前缀 */
    public final static String PDB = "pdiban";
    
    /***********************税区状态 开始******************************/
    //解冻状态
    public final static String UNFREEZE="0";
    //冻结状态
    public final static String  FREEZE="1";
    /***********************税区状态 结束******************************/
    
    /***********************注册类型  开始*************************************/
    // 使用状态：0-不使用
    public final static String USE_STATUS_0="0";
    // 使用状态：1-使用
    public final static String USE_STATUS_1="1";
    /***********************注册类型  结束*************************************/
    
    /***********************专业领域  开始*************************************/
    // 使用状态：0-使用
    public final static String FIELD_STATUS_0="0";
    // 使用状态：1-未使用
    public final static String FIELD_STATUS_1="1";
    /***********************专业领域  结束*************************************/
    
    /***********************问题类型  开始*************************************/
    // 使用状态：0-使用
    public final static String QUESTION_TYPE_STATUS_0="0";
    // 使用状态：1-未使用
    public final static String QUESTION_TYPE_STATUS_1="1";
    /***********************问题类型  结束*************************************/
    
    /***********************认证状态 开始*******************************************/
    //审核
    public final static String AUDIT="0";
    //拒审
    public final static String REFUSE_TO_REVIEW="1";
    /***********************认证状态 结束*******************************************/
    
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
    //无匹配专家
    public static final String NO_REPLY = "12";

    /***********************问题状态码  结束******************************/
    
    /************************税区/律协 开始*****************************************/
    //税区标识
    public final static String TAX_IDENTIFICATION="1";
    //律协标识
    public final static String BAR_ASSOCIATION="2";
    /************************税区/律协 结束*****************************************/
    
    /************************是否已分配解答人 开始*****************************************/
    //已分配 
    public final static String HAS_ALLOT_ANSWER_1="1";
    //未分配
    public final static String HAS_ALLOT_ANSWER_0="0";
    /************************是否已分配解答人 结束*****************************************/
}