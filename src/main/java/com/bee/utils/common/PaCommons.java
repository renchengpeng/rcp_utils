
package com.bee.utils.common;

/**
 *  企业代付公用部分
 * 
 * @author wangjiucheng
 */
public interface PaCommons {

    /*** 请求后台路由前缀 */
    public final static String PA_ADMIN = "daifu";

    /****************************************************************** 方法执行状态 开始 ******************************************************/
    /** 方法执行成功 **/
    public static final String PA_RESULT_SUCCESS = "1";

    /** 方法执行失败 **/
    public static final String PA_RESULT_FAIL = "0";

    /**错误响应结果码 **/
    public static final String PA_RESULT_TOKEN_ERROR = "-1";
    
    /**操作员账号状态 正常 **/
    public static final String OPPERATOR_STATUS_0="0";
    /**操作员账号状态 关闭 **/
    public static final String OPPERATOR_STATUS_1="1";
    /**审核类型 0 人工 **/
    public static final String APPROVAL_TYPE_0 = "0";
    /**审核类型 1 自动 **/
    public static final String APPROVAL_TYPE_1 = "1";
    /**是否超额 0 是 **/
    public static final String IS_OVERFULFIL_0 = "0";
    /**是否超额 1 否 **/
    public static final String IS_OVERFULFIL_1 = "1";
    
    /** 开票状态 1--待开票 **/
    public static final String OPEN_INVOICE_STATUS_1 = "1";
    /** 开票状态 2--已开票 **/
    public static final String OPEN_INVOICE_STATUS_2 = "2";
}
