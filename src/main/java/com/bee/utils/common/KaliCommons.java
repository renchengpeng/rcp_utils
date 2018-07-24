
package com.bee.utils.common;

/**
 * 卡里公用部分
 * 
 * @author wangjiucheng
 */
public interface KaliCommons {

    /*** 请求后台路由前缀 */
    public final static String KALI_ADMIN = "kali";

    /*** 请求前台路由前缀 */
    public final static String KALI_VIP = "kali/vip";
    
    /** 卡鲤 TOKEN前缀 **/
    public static final String KALI_TOKEN = "KALI_TOKEN_";
    
    /****************************************************************** 订单相关状态 开始 ******************************************************/
    /*** 待审核 */
    public static final String KL_ORDER_STATUS_1 = "1";

    /*** 订单被驳回 */
    public static final String KL_ORDER_STATUS_2 = "2";

    /*** 待付款 */
    public static final String KL_ORDER_STATUS_3 = "3";

    /*** 已上传水单，待审核 */
    public static final String KL_ORDER_STATUS_4 = "4";

    /*** 水单未过审 */
    public static final String KL_ORDER_STATUS_5 = "5";

    /*** 水单过审，付款成功，待开票 */
    public static final String KL_ORDER_STATUS_6 = "6";

    /*** 订单完成 */
    public static final String KL_ORDER_STATUS_7 = "7";

    /*** 订单取消 */
    public static final String KL_ORDER_STATUS_8 = "8";
    
    /*** 订单待发货 */
    public static final String KL_ORDER_STATUS_9 = "9";
    
    /*** 虚拟卡待上传卡密 */
    public static final String KL_ORDER_STATUS_0 = "0";

    /****************************************************************** 订单相关状态 结束 ******************************************************/

    /****************************************************************** 品牌状态 开始 ******************************************************/
    /*** 卡里品牌上架 */
    public static final String KL_BRAND_UP = "0";

    /*** 卡里品牌下架 */
    public static final String KL_BRAND_DOWN = "1";

    /****************************************************************** 品牌状态 结束 ******************************************************/

    /****************************************************************** 商户状态 开始 ******************************************************/
    /*** 卡里商户上架 */
    public static final String KL_MER_UP = "0";

    /*** 卡里商户下架 */
    public static final String KL_MER_DOWN = "1";

    /****************************************************************** 商户状态 结束 ******************************************************/

    /****************************************************************** 商户状态 开始 ******************************************************/
    /*** 卡里商品上架 */
    public static final String KL_PRODUCT_UP = "0";

    /*** 卡里商品下架 */
    public static final String KL_PRODUCT_DOWN = "1";

    /****************************************************************** 商户状态 结束 ******************************************************/

    /****************************************************************** 楼层状态 开始 ******************************************************/
    /*** 启用 */
    public static final String KL_FLOOR_STATUS_0 = "0";

    /*** 关闭 */
    public static final String KL_FLOOR_STATUS_1 = "1";

    /****************************************************************** 楼层状态 结束 ******************************************************/

    /****************************************************************** 方法执行状态 开始 ******************************************************/
    /** 方法执行成功 **/
    public static final String KALI_RESULT_SUCCESS = "1";

    /** 方法执行失败 **/
    public static final String KALI_RESULT_FAIL = "0";

    /****************************************************************** 方法执行状态 结束 ******************************************************/

    /****************************************************************** banner开启/关闭 开始 ******************************************************/
    /** banner开启 **/
    public static final String KALI_BANNER_OPEN = "01";

    /**banner关闭 **/
    public static final String KALI_BANNER_CLOSE = "00";

    /****************************************************************** banner开启/关闭 结束 ******************************************************/
    /**错误响应结果码 **/
    public static final String KALI_RESULT_TOKEN_ERROR = "-1";

}
