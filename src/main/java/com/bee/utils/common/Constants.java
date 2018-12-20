package com.bee.utils.common;

/**
 * @author "john.lh"
 * @Date 2014-5-28 上午12:32:46
 */
public interface Constants {

    /**risk swtich "1" : on ,  "0" : off **/

    public static final String SWTICH_ON = "1";
    public static final String SWTICH_OFF = "0";
    /**费鱼的accesstoken的key**/
    public static final String FY_ENTER_ACCESSTOKEN = "FY_ENTER_ACCESSTOKEN";
    public static final String FY_EMP_ENTER_ACCESSTOKEN = "FY_EMP_ENTER_ACCESSTOKEN";


    public static final String ERROR_MESSAGE = "errorMessage";
    //ODM 登录账号开启状态 0：关闭 1：开启
    public static final String ODMLOGIN_STATUS_OPEN = "1";
    public static final String ODMLOGIN_STATUS_CLOSE = "0";
    
    //timing- 是否是推荐系统推荐
    public static final String IS_SPREAD = "1";// 1：是
    
    
    //timing- fyw tasklet
    public static final String FYW_WRONG_TASKLET_TYPE_ONE = "1";// 1：账户异常
    public static final String FYW_WRONG_TASKLET_TYPE_TWO = "2";// 2：请求异常
    
    
    public static final String AGENT_PROPORTIONS_TO_FENGDIAN_EXCHANGE_NAME = "agent_proportions_to_fengdian_exchange";// 各平台向蜂点分成的交换机
    public static final String AGENT_PROPORTIONS_TO_FENGDIAN_ROUTING_KEY = "agent_proportions_to_fengdian_routingKey";// 各平台向蜂点分成的路由键

    public static final String FEIYUFENGXIAO_RESALE_QUEUE_NAME_ANPAY = "feiyufengxiao_resale_queue_anpay";// 费鱼蜂销 anpay

    public static final String FEIYUFENGXIAO_RESALE_QUEUE_NAME_FINANCIAL = "feiyufengxiao_resale_queue_financial";// 费鱼蜂销 financial-web

    public static final String FEIYUFENGXIAO_RESALE_FAIL_QUEUE_NAME = "feiyufengxiao_resale_fail_queue";// 费鱼蜂销

    public static final String FPAY_RESALE_QUEUE_NAME_ANPAY = "fpay_resale_queue_anpay";//  蜂pay提现 anpay

    public static final String FPAY_RESALE_QUEUE_NAME_FINANCIAL = "fpay_resale_queue_financial";//  蜂pay提现 financial-web

    public static final String FPAY_RESALE_FAIL_QUEUE_NAME = "fpay_resale_fail_queue";// 蜂pay提现失败

    public static final String MANGMAO_WITHDRAW_MONEY_QUEUE_ANPAY = "mangmao_withdraw_money_queue_anpay";// 忙猫新提现 anpay

    public static final String MANGMAO_WITHDRAW_MONEY_QUEUE_FINANCIAL = "mangmao_withdraw_money_queue_financial";// 忙猫新提现 financial-web

    public static final String MANGMAO_WITHDRAW_MONEY_RETURN_QUEUE = "mangmao_withdraw_money_return_queue";// 忙猫新提现

    public static final String XFQ_FEIYUFENGXIAO_RESALE_QUEUE_NAME_ANPAY = "xfq_feiyufengxiao_resale_queue_anpay";// 消费券的蜂销  anpay

    public static final String XFQ_FEIYUFENGXIAO_RESALE_QUEUE_NAME_FINANCIAL = "xfq_feiyufengxiao_resale_queue_financial";// 消费券的蜂销 financial-web

    public static final String XFQ_FEIYUFENGXIAO_RESALE_FAIL_QUEUE_NAME = "xfq_feiyufengxiao_resale_fail_queue";// 消费券的蜂销 返回队列

    public static final String XFQ_FPAY_RESALE_QUEUE_NAME_ANPAY = "xfq_fpay_resale_queue_anpay";//  消费券的蜂pay提现 anpay

    public static final String XFQ_FPAY_RESALE_QUEUE_NAME_FINANCIAL = "xfq_fpay_resale_queue_financial";//  消费券的蜂pay提现 financial-web

    public static final String XFQ_FPAY_RESALE_FAIL_QUEUE_NAME = "xfq_fpay_resale_fail_queue";// 消费券的蜂pay提现失败

    public static final String XFQ_MANGMAO_WITHDRAW_MONEY_QUEUE_ANPAY = "xfq_mangmao_withdraw_money_queue_anpay";// 消费券的二手商城发送到 anpay

    public static final String XFQ_MANGMAO_WITHDRAW_MONEY_QUEUE_FINANCIAL = "xfq_mangmao_withdraw_money_queue_financial";// 消费券的二手商城发送到 financial-web

    public static final String XFQ_MANGMAO_WITHDRAW_MONEY_RETURN_QUEUE = "xfq_mangmao_withdraw_money_return_queue";// 消费券的二手商城 返回

    public static final String FYW_DELAY_QUEUE = "fyw_delay_queue";// 福员外
    
    public static final String FYW_REQUEST_HIS_QUEUE = "fyw_request_his_queue";// 福员外
    
    public static final String FYW_DELAY_EXCHANGE = "fyw_delay_exchange";// 福员外

    /** 支付宝虚拟卡状态 0未绑定 1已绑定  2异常**/
    public static final String FYW_VIRTUAL_CARD_ZERO = "0";
    public static final String FYW_VIRTUAL_CARD_ONE= "1";
    public static final String FYW_VIRTUAL_CARD_ERROR= "2";

    /**支付宝定额券发放状态 0发放失败 1发放成功**/
    public static final String FYW_QUOTA_TICKET_STATUS_ONE= "1";
    public static final String FYW_QUOTA_TICKET_STATUS_ZERO= "0";





    // timing- 20170623
    //福员外批量开户记录是否删除 0：未删除
    public static final String FYW_FILE_BATCH_ISDEL = "0";// 0 未删除

    //福员外账号权限类型 1 主账号 2 主账号的子账号
    public static final String FYW_PERMISSON_TYPE_ONE = "1";
    public static final String FYW_PERMISSON_TYPE_TWO = "2";
    
    public static final String MER_DELIVER_ISDEFAULT_TRUE = "1";// mer 快递 是否默认 是

    public static final String MER_DELIVER_ISDEFAULT_FALSE = "0";// mer 快递 是否默认 否

    public static final String MER_ELECTRONIC_CARD_PWD_STATUS_1 = "1";// 正常

    public static final String MER_ELECTRONIC_CARD_PWD_STATUS_2 = "2";// 已售出

    public static final String MER_ELECTRONIC_CARD_PWD_STATUS_3 = "3";// 已作废

    public static final int JD_LVL_FOUR_ADDRESS_NULL_DEFALUT = 0;// 四级地址默认值

    // 预付采购时合同操作是否显示
    public static final String AGREEMENT_DISPLAY_0 = "0";// 0不显示

    public static final String AGREEMENT_DISPLAY_1 = "1";// 0显示

    // 合同审核状态
    public static final String AGREEMENT_STATUS_0 = "0";// 0未上传

    public static final String AGREEMENT_STATUS_1 = "1";// 1未审核

    public static final String AGREEMENT_STATUS_2 = "2";// 2审核通过

    public static final String AGREEMENT_STATUS_3 = "3";// 3驳回

    // 客户上传合同的文件类型
    public static final String AGREEMENT_FILE_TYPE_DOC = "0";// .doc

    public static final String AGREEMENT_FILE_TYPE_DOCX = "1";// .docx

    public static final String AGREEMENT_FILE_TYPE_XLS = "2";// .xls

    public static final String AGREEMENT_FILE_TYPE_XLSX = "3";// .xlsx

    public static final String AGREEMENT_FILE_TYPE_PDF = "4";// .pdf

    // 合同配送状态
    public static final String PROCESS_STATUS_0 = "0";// 未配送

    public static final String PROCESS_STATUS_1 = "1";// 已配送

    public static final String CHARSET_UTF_8 = "UTF-8";

    public static final String CHARSET_GBK = "GBK";

    public static final String CHARSET_ISO_8859_1 = "ISO_8859_1";

    /** 默认送货地址标志 **/
    public static final String IS_DEFAULT_ADDRESS_Y = "Y";

    public static final String IS_DEFAULT_ADDRESS_N = "N";

    /** 企业状态 开通 **/
    public static final String ENTERPRISE_STATUS_ACTIVE = "0";

    /** 企业状态 待审核 **/
    public static final String ENTERPRISE_STATUS_WAIT = "1";

    /** 企业状态 驳回 **/
    public static final String ENTERPRISE_STATUS_BACK = "2";

    /** 企业状态 关闭 **/
    public static final String ENTERPRISE_STATUS_CLOSE = "3";
    /** 企业状态 冻结**/
    public static final String ENTERPRISE_STATUS_FREEZE = "4";
    /** 企业状态 申请注销 **/
    public static final String ENTERPRISE_STATUS_APPLY_CLOSE = "5";

    /** Jd售后类型 **/
    /* 退 */
    public static final String JDORDER_SERVICE_TYPE_BACK = "10";

    /* 换 */
    public static final String JDORDER_SERVICE_TYPE_CHANGE = "20";

    /* 修 */
    public static final String JDORDER_SERVICE_TYPE_REPAIR = "30";

    /** 商城售后类型 **/
    /* 退 */
    public static final String MALLORDER_SERVICE_TYPE_BACK = "10";

    /* 换 */
    public static final String MALLORDER_SERVICE_TYPE_CHANGE = "20";

    /* 修 */
    public static final String MALLORDER_SERVICE_TYPE_REPAIR = "30";

    public static final String MERCHANT = "merchant";

    public static final String FD = "fd";

    public static final String FB = "fb";

    public static final String MALL = "mall";

    public static final String FH = "fh";

    public static final String FYW = "api";

    public static final String MARKET = "market";
    
    public static final String ODM = "odm";

    /** 魔钥企业请求前缀 **/
    public static final String MOYAO_VIP = "moyao/vip";

    /** 魔钥个人请求前缀 **/
    public static final String MOYAO_PERSONAL = "moyao/personal";
    /** 魔钥广告请求前缀 **/
    public static final String MOYAO_ADVERTISEMENT = "moyao/advertisement";
    /** 魔钥app版本请求前缀 **/
    public static final String MOYAO_APP = "moyao/app";
    /** 魔钥公众号相关请求前缀 **/
    public static final String MOYAO_WECHAT = "moyao/wechat";
    public static final String FD_WECHAT = "fd/wechat";
    /** 商户状态 正常 **/
    public static final String MERCHANT_STATUS_ACTIVE = "0";
    /** 商户状态 关闭 **/
    public static final String MERCHANT_STATUS_CLOSE = "1";

    /** customer 用户状态 正常 **/
    public static final String CUSTOMER_STATUS_ACTIVE = "0";

    /** customer 用户状态 未激活 **/
    public static final String CUSTOMER_STATUS_NOT_ACTIVE = "1";

    /** customer 用户状态 冻结 **/
    public static final String CUSTOMER_STATUS_BLCOK = "2";

    /** customer 用户状态 已销户 **/
    public static final String CUSTOMER_STATUS_CLOSE = "9";

    /** 客户类型 员工即个人 **/
    public static final String CUSTOMER_TYPE_EMPLOYEE = "1";

    /** 客户类型 企业 **/
    public static final String CUSTOMER_TYPE_ENTERPRISE = "2";

    /** 客户类型 商户 **/
    public static final String CUSTOMER_TYPE_MER = "3";

    /** AccountType类型 蜂钱包 */
    public static final String ACCOUNT_TYPE_WALLET = "1";

    /** 账户产品状态 正常 **/
    public static final String ACCOUNT_PRODUCT_STATUS_ACTIVE = "0";

    /** 账户产品状态 审核中 **/
    public static final String ACCOUNT_PRODUCT_STATUS_WAITING = "1";

    /** 账户产品状态 审核未通过 **/
    public static final String ACCOUNT_PRODUCT_STATUS_BACK = "2";

    /** 账户产品状态 注销 **/
    public static final String ACCOUNT_PRODUCT_STATUS_CANCEL = "3";

    /** 商品种类状态 正常 **/
    public static final String PRDTYPE_STATUS_ACTIVE = "0";

    /** 商品种类状态 失效 **/
    public static final String PRDTYPE_STATUS_NOT_ACTIVE = "1";

    /** 商品状态 上架 **/
    public static final String PRD_STATUS_1 = "1";

    /** 商品状态 下架 **/
    public static final String PRD_STATUS_2 = "2";
    
    /** 是否推荐商品 是 **/
    public static final String PRD_RECOMMEND_STATUS_1 = "1";

    /** 是否推荐商品 否 **/
    public static final String PRD_RECOMMEND_STATUS_2 = "2";

    /** 订单状态 01-未付款 */
    public static final String ORDER_STATUS_01 = "01";

    /** 订单状态 02-已付款 */
    public static final String ORDER_STATUS_02 = "02";

    /** 订单状态 03-发货 */
    public static final String ORDER_STATUS_03 = "03";

    /** 订单状态 04-确认已收货 */
    public static final String ORDER_STATUS_04 = "04";

    /** 订单状态 05-订单完成 */
    public static final String ORDER_STATUS_05 = "05";

    /** 订单状态 06-退款中 */
    public static final String ORDER_STATUS_06 = "06";

    /** 订单状态 07-订单取消 */
    public static final String ORDER_STATUS_07 = "07";

    /** 订单状态 08-订单已退款 */
    public static final String ORDER_STATUS_08 = "08";

    /** 订单状态 09-订单申请退款 */
    public static final String ORDER_STATUS_09 = "09";

    /** 订单状态 10-订单退款驳回 */
    public static final String ORDER_STATUS_10 = "10";

    /** 子订单状态 1-正常，2-拒签 3-已发货 4--确认收货 5-退款*/
    public static final String ORDERINFO_STATUS_1 = "1";
    /** 子订单状态 2-拒签 */
    public static final String ORDERINFO_STATUS_2 = "2";
    /** 子订单状态 3-已发货 */
    public static final String ORDERINFO_STATUS_3 = "3";
    /** 子订单状态 4-确认收货 */
    public static final String ORDERINFO_STATUS_4 = "4";

    /** 子订单状态 5-退款 */
    public static final String ORDERINFO_STATUS_5 = "5";

    /** 订单删除状态 0-订单是否删除 0 未删 */
    public static final String ORDER_IS_DEL_0 = "0";

    /** 订单删除状态 1-订单是否删除 1 已删除 */
    public static final String ORDER_IS_DEL_1 = "1";

    /** 订单是否虚拟订单 0-否 0是实体商品 */
    public static final String ORDER_IS_VIRSUAL_0 = "0";

    /** 订单是否虚拟订单 1-是 1是虚拟商品 */
    public static final String ORDER_IS_VIRSUAL_1 = "1";

    /** 订单是电子卡订单 */
    public static final String ORDER_IS_VIRSUAL_2 = "2";

    /** 订单类型 1-消费 */
    public static final String ORDER_TYPE_1 = "1";

    /** 订单类型 2-提现 */
    public static final String ORDER_TYPE_2 = "2";

    /** 订单类型 3-充值 */
    public static final String ORDER_TYPE_3 = "3";

    /** 交易类型 1-消费 */
    public static final String TRAN_TYPE_1 = "1";

    /** 交易类型 2-转让 */
    public static final String TRAN_TYPE_2 = "2";

    /** 交易类型 3-充值 */
    public static final String TRAN_TYPE_3 = "3";

    /** 交易类型 4-蜂钱包生成电子卡扣款 */
    public static final String TRAN_TYPE_4 = "4";

    /** 交易类型 5-冲正 */
    public static final String TRAN_TYPE_5 = "5";

    /** 交易类型 6-退款 */
    public static final String TRAN_TYPE_6 = "6";

    /** 交易类型 7-转账 */
    public static final String TRAN_TYPE_7 = "7";

    /** 交易类型 8-调账转出 */
    public static final String TRAN_TYPE_8 = "8";

    /** 交易类型 9-调账充值 */
    public static final String TRAN_TYPE_9 = "9";
    

    /** 交易类型 10-（福员外）调账充值 */
    public static final String TRAN_TYPE_10 = "10";

    /** 交易类型 11-（福员外） 生成虚拟卡*/
    public static final String TRAN_TYPE_11= "11";

    /** 交易类型 11-（福员外） 生成定额券*/
    public static final String TRAN_TYPE_12= "12";
    
    /** 交易类型 13-提现 */
    public static final String TRAN_TYPE_13 = "13";

    /************************************** 支付订单 ***********************************************************/
    /** 支付订单类型 1-消费 */
    public static final String PAY_ORDER_TYPE_1 = "1";

    /** 支付订单类型 2-提现 */
    public static final String PAY_ORDER_TYPE_2 = "2";

    /** 支付订单类型 3-充值 */
    public static final String PAY_ORDER_TYPE_3 = "3";

    /** 支付订单类型 4-转账 */
    public static final String PAY_ORDER_TYPE_4 = "4";

    /** 支付订单状态 01-未付款 */
    public static final String PAY_ORDER_STATUS_01 = "01";

    /** 支付订单状态 02-已付款 */
    public static final String PAY_ORDER_STATUS_02 = "02";

    /** 支付订单状态 03-已取消 */
    public static final String PAY_ORDER_STATUS_03 = "03";

    /** 支付订单状态 04-退款中 */
    public static final String PAY_ORDER_STATUS_04 = "04";

    /** 支付订单状态 05-已退款 */
    public static final String PAY_ORDER_STATUS_05 = "05";

    /** 支付订单状态 06-删除状态 */
    public static final String PAY_ORDER_STATUS_06 = "06";

    /** 退款订单状态 01-退款中 */
    public static final String REFUND_ORDER_STATUS_01 = "01";

    /** 退款订单状态 02-已退款 */
    public static final String REFUND_ORDER_STATUS_02 = "02";

    /** 退款订单状态 03-退款失败 */
    public static final String REFUND_ORDER_STATUS_03 = "03";

    /**支付通道 01-融宝**/
    public final static String PAY_CHANNEL_REPAL="01";
    /**支付通道 02-快付通**/
    public final static String PAY_CHANNEL_KFT="02";
    /**支付通道 03-随行付**/
    public final static String PAY_CHANNEL_SXF="03";
    
 
    /**随网关支付**/
    public final static String PAY_METHOD_BANK="01";
    /**支付宝**/
    public final static String PAY_METHOD_ZFB="02";
    /**微信**/
    public final static String PAY_METHOD_WX="03";
    /**壹通券**/
    public final static String PAY_METHOD_XYED="04";
     /** 账户支付 **/
    public final static String PAY_METHOD_OPAY = "05";
    
    
    
    //支付方式 退款方式 支付宝支付，微信支付
    public final static String  returnTypeWx = "weixin";
    public final static String  returnTypeZfb = "alipay";
    
    //支付系统渠道标志
    /**蜂采**/
    public final static String CHANNEL_01="01";
    /**商城**/
    public final static String CHANNEL_02="02";
    /**蜂财**/
    public final static String CHANNEL_03="03";
    /**推荐系统**/
    public final static String CHANNEL_04="04";
    /**清算系统**/
    public final static String CHANNEL_05="05";
    /**闪报企业**/
    public final static String CHANNEL_SHANBAO="07";
    /**闪mall系统**/
    public final static String CHANNEL_SHANMALL="08";
    /**福员外**/
    public final static String CHANNEL_09="09";
    /**企业蜂贝**/
    public final static String CHANNEL_10 = "10";

    /** 费鱼员工 **/
    public final static String CHANNEL_FEIYU_EMP = "11";

    /** 费鱼企业 **/
    public final static String CHANNEL_FEIYU = "12";

    /** 费鱼mall系统 **/
    public final static String CHANNEL_FEIYUMALL = "13";

    /** 员工蜂钱包系统 **/
    public final static String CHANNEL_14 = "14";
    
    /** 费鱼推荐系统 **/
    public final static String CHANNEL_FEIYU_CHANNEL = "15";
    
    /** 分销商odm系统**/
    public final static String CHANNEL_16 = "16";
    /**跃程充值 **/
    public final static String CHANNEL_17="17";
    /**快寄卖 **/
    public final static String CHANNEL_18="18";
    /**消费券的员工商城 **/
    public final static String CHANNEL_19="19";
    /**新商城（替换原有商城内划算/蜂贝）**/
    public final static String CHANNEL_20="20";
    /**消费券的二手商城 **/
    public final static String CHANNEL_21="21";
    /**消费券跃程充值 **/
    public final static String CHANNEL_22="22";

    public final static String CHANNEL = "channel"; // by cws channel-web

    public final static String ADMIN = "admin";


    public final static String ENTERPRISE = "vip";

    public final static String FINANCIAL = "financial";

    public final static String EMPFEIYU = "empfeiyu";

    public final static String IS_NEW_ADDR = "Y";

    public final static String IS_NOT_NEW_ADDR = "N";

    public final static String IS_UPDATE_ADDR = "Y";

    public final static String IS_DEFAULT_ADDR = "Y";

    public final static String PRODUCT = "product";

    public final static String SERVICE = "service";

    public final static String ADVANCE = "advance";
    /**
     * api申请状态拦截  xyd 20180413
     */
    public final static String API_APPLY = "apiApply";
    /** 申请中 */
    public final static String API_STATE_0 = "0";
    /** 申请通过 */
    public final static String API_STATE_1 = "1";
    /** 被驳回 */
    public final static String API_STATE_2 = "2";
    /** 已关闭 */
    public final static String API_STATE_3 = "3";
    
    /** 实体商品 */
    public final static String PRODUCT_IS_VIRTUAL_0 = "0";

    /** 虚拟商品 */
    public final static String PRODUCT_IS_VIRTUAL_1 = "1";

    /** 电子卡 */
    public final static String PRODUCT_IS_VIRTUAL_2 = "2";

    public final static String RETURN_SUCCESS_CODE = "0000";

    public final static String RETURN_FAIL_CODE = "1111";

    public final static String PAGE_FLAG = "order";

    public final static String IS_DEL = "Y";

    /** 批量开户充值时的列表状态 */
    /** 00-开户信息未处理 */
    public static final String REGISTER_RECHARGE_STATUS_0 = "00";

    /** 01-出错 */
    public static final String REGISTER_RECHARGE_STATUS_1 = "01";

    /** 02-开户成功 */
    public static final String REGISTER_RECHARGE_STATUS_2 = "02";

    /** 03 充值成功 */
    public static final String REGISTER_RECHARGE_STATUS_3 = "03";

    /** 04 一次性开户充值成功 */
    public static final String REGISTER_RECHARGE_STATUS_4 = "04";

    /** 转账类型 01-企业转账 */
    public static final String TRANSFER_TYPE_1 = "01";

    /** 转账类型 02-个人转账 */
    public static final String TRANSFER_TYPE_2 = "02";

    /** 转账类型 03-个人调账 */
    public static final String TRANSFER_TYPE_3 = "03";

    /** 优惠券0: 未使用 */
    public static final String COUPON_INFO_STATUS_0 = "0";

    /** 优惠券 1：已使用 */
    public static final String COUPON_INFO_STATUS_1 = "1";

    /** 优惠券1: 未使用 */
    public static final String COUPON_USE_STATUS_1 = "1";

    /** 优惠券2:已使用 */
    public static final String COUPON_USE_STATUS_2 = "2";

    /** 优惠券3: 已过期 */
    public static final String COUPON_USE_STATUS_3 = "3";

    /** 优惠券4：可使用 */
    public static final String COUPON_USE_STATUS_4 = "4";

    /** 全场券 */
    public static final String COUPON_TYPE_1 = "1";

    /** 店铺 */
    public static final String COUPON_TYPE_2 = "2";

    /** 满一定金额后才可使用 */
    public static final String COUPON_USE_CONDITION_1 = "1";

    /** 无条件使用 */
    public static final String COUPON_USE_CONDITION_2 = "2";

    /** 优惠券状态-未启用 */
    public static final String COUPON_STATUS_0 = "0";

    /** 优惠券状态-领用中 */
    public static final String COUPON_STATUS_1 = "1";

    /** 优惠券状态-已结束 */
    public static final String COUPON_STATUS_2 = "2";

    /** 指定发放 */
    public static final String COUPON_SEND_TYPE_1 = "1";

    /** 自动领取 */
    public static final String COUPON_SEND_TYPE_2 = "2";

    /** 不属于大礼包 */
    public static final String COUPON_IS_BELONGTO_GIFT_0 = "0";

    /** 属于大礼包 */
    public static final String COUPON_IS_BELONGTO_GIFT_1 = "1";

    /** 优惠券创建人类型 1 ：自营 */
    public static final String COUPON_CREATE_MAN_TYPE_1 = "1";

    /** 优惠券创建人类型 2：商户 */
    public static final String COUPON_CREATE_MAN_TYPE_2 = "2";

    /** 是否已转赠 0 ：未转赠 */
    public static final String COUPON_IS_RESEND_0 = "0";

    /** 是否已转赠 1 ：已转赠 */
    public static final String COUPON_IS_RESEND_1 = "1";

    /** 电子卡未绑定 */
    public static final String ECARD_BIND_STATUS_0 = "0";

    /** 电子卡已绑定 */
    public static final String ECARD_BIND_STATUS_1 = "1";
    
    /** 电子卡未激活 */
    public static final String ECARD_ACTIVE_STATUS_0 = "0";
    
    /** 电子卡已激活 */
    public static final String ECARD_ACTIVE_STATUS_1 = "1";

    public static final String ECARD_ISPAY_0 = "0";// 未支付

    public static final String ECARD_ISPAY_1 = "1";// 已支付

    /** 渠道-推荐系统 */
    /** 商户部经理电话 */
    public static final String COMMERCE_MANAGER_TELEPHONE = "18911199162";

    /**
     * 新商户平台 商户审核状态
     */
    /** 商户状态 待审核 **/
    public static final String MERCHANT_AUDITSTATUS_WAIT = "0";

    /** 商户状态 开通 **/
    public static final String MERCHANT_AUDITSTATUS_ACTIVE = "1";

    /** 商户状态 驳回 **/
    public static final String MERCHANT_AUDITSTATUS_BACK = "2";

    /** 商户状态 取消 **/
    public static final String MERCHANT_AUDITSTATUS_CLOSE = "3";

    /**
     * 新商户平台 用户状态
     */
    /** 正常 */
    public static final String MERCHANT_USER_ACTIVE = "0";

    /** 不正常 */
    public static final String MERCHANT_USER_CLOSE = "1";

    /**
     * 新商户平台 权限状态
     */
    /** 商户平台状态 未申请 **/
    public static final String MERPLATFORM_AUDITSTATUS_NO = "-1";

    /** 商户平台状态 待审核 **/
    public static final String MERPLATFORM_AUDITSTATUS_WAIT = "0";

    /** 商户平台状态 已通过 **/
    public static final String MERPLATFORM_AUDITSTATUS_ACTIVE = "1";

    /** 商户平台状态 未通过 **/
    public static final String MERPLATFORM_AUDITSTATUS_BACK = "2";

    /** 商户平台状态 取消 **/
    public static final String MERPLATFORM_AUDITSTATUS_CLOSE = "3";

    /**
     * 商户分类
     */
    /** 商户商家 **/
    public static final String MER_TYPE_1 = "1";
    /** 商户服务商品商家 **/
    public static final String MER_TYPE_2 = "2";

    /**
     * 平台标识
     */

    /** 全平台 **/
    public static final String PLAT_ALL = "0";

    /** 蜂贝平台-个人 **/
    public static final String PLAT_FENGBEI = "1";

    /** 蜂采 **/
    public static final String PLAT_FC = "2";

    /** 蜂惠 **/
    public static final String PLAT_FENGHUI = "3";
    
    /** 蜂财 **/
    public static final String PLAT_FENGCAI = "4";

    /** 闪mall系统 **/
    public final static String PLAT_SHANMALL = "5";

    /** 闪报系统 **/
    public final static String PLAT_SHANBAO = "6";

    /** 费鱼mall系统 **/
    public final static String PLAT_FEIYUMALL = "9";

    /** 费鱼系统 **/
    public final static String PLAT_FEIYU = "10";

    /** 费鱼个人系统 **/
    public final static String PLAT_EMPFEIYU = "11";

    /** 账无忌系统 **/
    public final static String PLAT_YIJIA = "12";

    /** 蜂点 **/
    public final static String PLAT_FD = "14";
    /** 费鱼蜂销**/
    public final static String PLAT_FEIYU_FENGXIAO= "15";
    /** 魔钥平台**/
    public final static String PLAT_MOYAO= "16";
    /**忙猫**/
    public final static String PLAT_MANGMAO= "17";
    /**卡里**/
    public final static String PLAT_KALI="18";
    /**支付宝券**/
    public final static String PLAT_ZHI_FU_BAO="19";
    /**商户**/
    public final static String PLAT_MERCHANT="20";
    
    /** 魔钥-物品上传附件**/
    public final static String DISENCLOSURE= "1";
    /** 商户平台 用户类型 1:主账户 */
    public static final String MERCHANT_USER_TYPE_1 = "1";

    /** 商户平台 用户类型 2:子账户 */
    public static final String MERCHANT_USER_TYPE_2 = "2";

    /** 收支类型 1 ：收入 */
    public static final String IN_OUT_TYPE_1 = "1";

    /** 收支类型 2 ：支出 */
    public static final String
            IN_OUT_TYPE_2 = "2";


    /** MSG消息 */
    /** 是否已读否 */
    public static final String MSG_TYPE_WD = "0";

    /** 是否已读是 */
    public static final String MSG_TYPE_YD = "1";

    /** MSG消息类型 */
    /** 系统消息 */
    public static final String MSG_TYPE_XTXX = "1";

    /** 优惠信息 */
    public static final String MSG_TYPE_YHXX = "2";
    
    /** 弹框信息 */
    public static final String MSG_TYPE_TKXX = "3";

    /** 弹框类型 1--注册弹框 */
    public static final String MSG_TK_TYPE_1 = "1";

    /** 弹框类型 2--付款弹框 */
    public static final String MSG_TK_TYPE_2 = "2";

    /** 弹框类型 3--提交订单弹框*/
    public static final String MSG_TK_TYPE_3 = "3";

    /** 弹框类型  4--开票弹框*/
    public static final String MSG_TK_TYPE_4 = "4";

    /** 弹框类型  5--采购弹框*/
    public static final String MSG_TK_TYPE_5 = "5";

    /** MSG消息推送类型 */
    /** 所有商户 */
    public static final String MSG_PUSH_TYPE_ALL = "1";

    /** 主账户 */
    public static final String MSG_TYPE_MAIN = "2";

    /** 蜂采平台所有账户 */
    public static final String MSG_TYPE_FENGHUI = "3";

    /** 蜂贝平台所有账户 */
    public static final String MSG_TYPE_FENGBEI = "4";

    /** MSG平台类型 */
    /** 商户 */
    public static final String MSG_SH = "1";

    /** 蜂采 */
    public static final String MSG_FH = "2";

    /** 产品类型-FPAY[00] 蜂pay */
    public static final String PRODUCT_TYPE_FPAY = "00";

    /** 产品类型-FTK[04] 蜂通卡 */
    public static final String PRODUCT_TYPE_FTK = "04";

    /** 产品类型-FEG[05] 蜂E购 */
    public static final String PRODUCT_TYPE_FEG = "05";

    /** 产品类型-FXK[06] 蜂信卡 */
    public static final String PRODUCT_TYPE_FXK = "06";

    /** 产品类型-DZQ[07] 电子券 */
    public static final String PRODUCT_TYPE_DZQ = "07";

    /** 产品类型-BASE[09] 基础费率 */
    public static final String PRODUCT_TYPE_BASE = "09";

    /** 产品类型-BANK[10] 银行网银 */
    public static final String PRODUCT_TYPE_BANK = "10";

    /** 产品类型-电子报销款 */
    public static final String PRODUCT_TYPE_DZBXK = "01";

    /** 账户类型-FPAY[00] 蜂pay */
    public static final String ACCOUNT_TYPE_FPAY = "00";

    /** 电子报销款 */
    public static final String ACCOUNT_TYPE_DZBXK = "01";

    /** 蜂钱包 */
    public static final String ACCOUNT_TYPE_FQB = "02";

    /** 账户类型-FTK[04] 蜂通卡 */
    public static final String ACCOUNT_TYPE_FTK = "04";

    /** 账户类型-FEG[05] 蜂E购 */
    public static final String ACCOUNT_TYPE_FEG = "05";

    /** 账户类型-FXK[06] 蜂信卡 */
    public static final String ACCOUNT_TYPE_FXK = "06";

    /** 账户类型-DZQ 电子券 */
    public static final String ACCOUNT_TYPE_DZQ = "07";

    /** 账户类型-REAPAL 第三方支付公司 */
    public static final String ACCOUNT_TYPE_THIRD = "08";

    /** 账户类型 壹通券 */
    public static final String ACCOUNT_TYPE_FEIYU = "09";

    /** 账户类型-BANK 丰付系统银行网银支付 */
    public static final String ACCOUNT_TYPE_BANK = "10";
    
    /** 账户类型-徽商银行账户 */
    public static final String ACCOUNT_TYPE_HUISHANG="11";

    /** 限额规则状态-1-使用 */
    public static final String QUOTA_RULE_STATUS_1 = "1";

    /** 限额规则状态-2-停用 */
    public static final String QUOTA_RULE_STATUS_2 = "2";

    /** 企业开户/充值日限额-1-不使用 */
    public static final String VIP_FEE_LEVEL_1 = "1";

    /** 企业开户日限额-0-使用 */
    public static final String VIP_FEE_LEVEL_0 = "0";

    /** 后台管理账户状态-0-正常 */
    public static final String USERS_STATUS_0 = "0";

    /** 后台管理账户状态-1-关闭 */
    public static final String USERS_STATUS_1 = "1";

    /** 订单状态 01-未付款 */
    public static final String VIP_ORDER_STATUS_01 = "01";

    /** 订单状态 02-已付款 */
    public static final String VIP_ORDER_STATUS_02 = "02";

    /** 订单状态 03-发货 */
    public static final String VIP_ORDER_STATUS_03 = "03";

    /** 订单状态 04-确认已收货 */
    public static final String VIP_ORDER_STATUS_04 = "04";

    /** 订单状态 05-订单完成 */
    public static final String VIP_ORDER_STATUS_05 = "05";

    /** 订单状态 06-退款中 */
    public static final String VIP_ORDER_STATUS_06 = "06";

    /** 订单状态 07-订单取消 */
    public static final String VIP_ORDER_STATUS_07 = "07";

    /** 订单状态 08-订单已退款 */
    public static final String VIP_ORDER_STATUS_08 = "08";

    /** 订单状态 09-订单申请退款 */
    public static final String VIP_ORDER_STATUS_09 = "09";

    /** 订单状态 10-订单退款驳回 */
    public static final String VIP_ORDER_STATUS_10 = "10";

    /** 企业采购订单 */
    public static final String VIP_ORDERS_TYPE_01 = "01";

    /** 企业服务订单 */
    public static final String VIP_ORDERS_TYPE_02 = "02";

    /** 京东普通商品 */
    public static final String PRD_DETAIL_TYPE_JD_COMMONS = "jdCommons";

    /** 京东图书音像商品 */
    public static final String PRD_DETAIL_TYPE_JD_BOOK = "jdBook";

    /** 待沟通 */
    public static final String INTENTION_VIP_STATUS_1 = "1";

    /** 已完成 */
    public static final String INTENTION_VIP_STATUS_2 = "2";

    /** 已取消 */
    public static final String INTENTION_VIP_STATUS_3 = "3";

    /** 激活状态 */
    public static final String VIP_DISCOUNT_STATUS_0 = "0";

    /** 未激活状态 */
    public static final String VIP_DISCOUNT_STATUS_1 = "1";

    /** 失效状态 */
    public static final String VIP_DISCOUNT_STATUS_2 = "2";

    /** 企业独立定价 */
    public static final String ENTERPRISE_ISINDEPENDENTPRICING_0 = "0";

    /** 企业非独立定价 */
    public static final String ENTERPRISE_ISINDEPENDENTPRICING_1 = "1";

    /** 待确认-商户部 */
    public static final String ADVANCE_ORDERS_STATUS_2 = "02";

    /** 待付款 */
    public static final String ADVANCE_ORDERS_STATUS_3 = "03";

    /** 付款完成 */
    public static final String ADVANCE_ORDERS_STATUS_4 = "04";

    /** 已确认付款 */
    public static final String ADVANCE_ORDERS_STATUS_5 = "05";

    /** 订单处理中 */
    public static final String ADVANCE_ORDERS_STATUS_6 = "06";

    /** 订单处理完成 */
    public static final String ADVANCE_ORDERS_STATUS_7 = "07";

    /** 取消 */
    public static final String ADVANCE_ORDERS_STATUS_9 = "09";

    /** 签收 */
    public static final String ADVANCE_ORDERS_SIGN_1 = "1";

    /** 未签收 */
    public static final String ADVANCE_ORDERS_SIGN_2 = "2";

    /** 预付采购 */
    public static final String ADVANCE_ORDERS_TYPE_1 = "01";

    /** 企业采购 */
    public static final String ADVANCE_ORDERS_TYPE_2 = "02";

    /** 企业服务 */
    public static final String ADVANCE_ORDERS_TYPE_3 = "03";

    /** 已选蜂E卡 */
    public static final String ADVANCE_ORDERS_HAS_ECARD = "1";

    /** 待付款 */
    public static final String SUB_ADVANCE_ORDERS_STATUS_1 = "01";

    /** 付款完成-待确认 */
    public static final String SUB_ADVANCE_ORDERS_STATUS_2 = "02";

    /** 确认付款-且确认下单完成 */
    public static final String SUB_ADVANCE_ORDERS_STATUS_3 = "03";

    /** 商户下单完成 */
    public static final String SUB_ADVANCE_ORDERS_STATUS_4 = "04";

    /** 回票中 */
    public static final String SUB_ADVANCE_ORDERS_STATUS_5 = "05";

    /** 已完成 */
    public static final String SUB_ADVANCE_ORDERS_STATUS_8 = "08";

    /** 已取消 */
    public static final String SUB_ADVANCE_ORDERS_STATUS_9 = "09";

    /** 已签收合同 */
    public static final String SUB_ADVANCE_AGREEMENT_SIGN_1 = "01";

    /** 未激活 */
    public static final String INVOICE_PRODUCT_STATUS_1 = "1";

    /** 已激活 */
    public static final String INVOICE_PRODUCT_STATUS_0 = "0";

    /** 01-员工 */
    public static final String FB_USERTYPE_1 = "01";

    /** 02-个人 */
    public static final String FB_USERTYPE_2 = "02";

    /** 0-正常 */
    public static final String FB_STATUS_0 = "0";

    /** 1-未激活 */
    public static final String FB_STATUS_1 = "1";

    /** 2-冻结 */
    public static final String FB_STATUS_2 = "2";

    /** 9-已销户 */
    public static final String FB_STATUS_9 = "9";
    /** 评论状态 */
    /** 0-正常 */
    public static final String MALL_COMMENT_STATUS_0 = "0";

    /** 1-追加评论 */
    public static final String MALL_COMMENT_STATUS_1 = "1";

    /** 2-删除 */
    public static final String FB_COMMENT_STATUS_2 = "2";

    /** 0-等待付款 */
    public static final String LIMIT_TRAN_HIS_0 = "0";

    /** 1-交易成功 */
    public static final String LIMIT_TRAN_HIS_1 = "1";

    /** 0-交易失败 */
    public static final String LIMIT_TRAN_HIS_2 = "2";

    /** 0-不可用 */
    public static final String LIMIT_ACCOUNT_0 = "0";

    /** 1-可用 */
    public static final String LIMIT_ACCOUNT_1 = "1";

    /*** 0 ：未删除 */
    public static final String ORDERS_DEL_0 = "0";

    /*** 1 ：已删除 */
    public static final String ORDERS_DEL_1 = "1";

    /** 蜂采后台 银行信息列表 启用0 */
    public static final String FH_BANK_START = "0";

    /** 蜂采后台 银行信息列表 禁用1 */
    public static final String FH_BANK_STOP = "1";

    /** 账号 开通 **/
    public static final String USER_STATUS_ACTIVE = "0";

    /** 账号 待审核 **/
    public static final String USER_STATUS_WAIT = "1";

    /** 账号 驳回 **/
    public static final String USER_STATUS_BACK = "2";

    /** 账号 关闭 **/
    public static final String USER_STATUS_CLOSE = "3";

    /** 管理账号 **/
    public static final String USER_TYPE_PRIMARY_ACCOUNT = "3";

    /** 发放账号 **/
    public static final String USER_TYPE_ADMINISTRATIVE_ACCOUNT = "1";

    /** 采购账号 **/
    public static final String USER_TYPE_FINANCIAL_ACCOUNT = "2";

    /** 企业预付开通状态 **/
    public static final String ADVANCE_STATUS_OPEN = "0";

    /** 企业预付审核中状态 **/
    public static final String ADVANCE_STATUS_WAITING = "1";

    /** 企业预付驳回状态 **/
    public static final String ADVANCE_STATUS_BACK = "2";

    /** 企业预付关闭状态 **/
    public static final String ADVANCE_STATUS_CLOSE = "3";

    /** 购物车方式 全额 **/
    public static final String AMT_TYPE_ALL = "1";

    /** 购物车方式 采购 **/
    public static final String AMT_TYPE_AMT = "2";

    /** 蜂销用户类型 个人 **/
    public static final Integer SPREAD_USER_TYPE_PERSON = 1;

    /** 蜂销用户类型 机构 **/
    public static final Integer SPREAD_USER_TYPE_INSTITUTION = 2;

    /** 蜂销用户类型 第三方合作企业 **/
    public static final Integer SPREAD_USER_TYPE_COOPERATIONENTERPRISE = 3;

    /** 蜂销奖励类型 个人 **/
    public static final String BONUS_TYPE_PERSON = "1";

    /** 蜂销奖励类型 机构 **/
    public static final String BONUS_TYPE_INSTITUTION = "2";

    /** 蜂销奖励类型 第三方合作企业 **/
    public static final String BONUS_TYPE_COOPERATIONENTERPRISE = "3";

    /** 蜂销奖励类型 下级订单奖励 **/
    public static final String BONUS_TYPE_SUBORDER = "4";

    /* 参与抽奖的中奖状态 */
    public static final String PARTCIPANT_UNAWAED = "0";

    public static final String PARTCIPANT_AWAED = "1";

    /* 客户活动状态 0:未开始 1：已开始2：已结束 */
    public static final String ACTIVITY_STATUS_ZERO = "0";

    public static final String ACTIVITY_STATUS_ONE = "1";

    public static final String ACTIVITY_STATUS_TWO = "-1";

    /* 参与抽奖的人是否已领奖 0：未领取 1：已领取 */
    public static final String ISSUEBONUS_NOT = "0";

    public static final String ISSUEBONUS_YES = "1";

    /* 参与者是否中奖了 */
    public static final String ISAWARD = "1";

    public static final String NOTAWARD = "0";

    /** 蜂点方法执行成功 **/
    public static final String FD_RESULT_SUCCESS = "1";

    /** 蜂点方法执行失败 **/
    public static final String FD_RESULT_FAIL = "0";
    /** 魔钥方法执行成功 **/
    public static final String MOYAO_RESULT_SUCCESS = "1";

    /** 魔钥方法执行失败 **/
    public static final String MOYAO_RESULT_FAIL = "0";
    /** 蜂点没有TOKEN,或者TOKEN过期 **/
    public static final String FD_RESULT_TOKEN_ERROR = "-1";

    /** 跳转页面 **/
    public static final String FD_RETURE_CURRENT_PAGE = "-2";

    /** 交易状态 0-交易中 **/
    public static final String TRADE_TYPE_0 = "0";

    /** 交易状态 1-交易成功 **/
    public static final String TRADE_TYPE_1 = "1";

    /** 交易状态 2-交易失败 **/
    public static final String TRADE_TYPE_2 = "2";
    
    /** 交易状态 3-交易异常（用在支付结果表示买家未付款） **/
    public static final String TRADE_TYPE_3 = "3";

    /** 额度账户状态 1-账户正常 **/
    public static final String ADV_LIMIT_AC_TYPE_1 = "1";

    /** 额度账户状态 2-账户被冻结 **/
    public static final String ADV_LIMIT_AC_TYPE_2 = "2";

    /** 额度账户状态 3-账户注销 **/
    public static final String ADV_LIMIT_AC_TYPE_3 = "3";

    /** 模块状态 上线 **/
    public static final String MODULE_ONLINE_STATUS = "1";

    /** 模块状态 下线 **/
    public static final String MODULE_OFFLINE_STATUS = "2";

    /** 模块级别 一级 **/
    public static final String MODULE_SYS_ONE_LEVEL = "1";

    /** 模块级别 二级 **/
    public static final String MODULE_SYS_TWO_LEVEL = "2";

    /** 蜂点 顶级模块 **/
    public static final Integer FD_MODULE_TOP_ID = 0;

    /** 蜂点 企业模块 1 **/
    public static final Integer FD_MODULE_ENTERPRISE_ID = 1;

    /** 蜂点 商户模块 2 **/
    public static final Integer FD_MODULE_MERCHENT_ID = 2;

    /** 蜂点 个人模块 3 **/
    public static final Integer FD_MODULE_PERSONAL_ID = 3;

    /** 蜂点企业 TOKEN前缀 **/
    public static final String FD_ENTERPRISE = "FD_ENTERPRISE_";

    /** 蜂点商户 TOKEN前缀 **/
    public static final String FD_MERCHENT = "FD_MERCHENT_";

    /** 蜂点个人 TOKEN前缀 **/
    public static final String FD_PERSONAL = "FD_PERSONAL_";
    /** 魔钥个人 TOKEN前缀 **/
    public static final String MOYAO_TOKEN_ENTERPRISE = "MOYAO_ENTERPRISE_";
    
    /** 魔钥个人 TOKEN前缀 **/
    public static final String MOYAO_TOKEN_PERSONAL = "MOYAO_PERSONAL_";
    
    /** 支付中心用户 TOKEN前缀 **/
    public static final String PAY_CUSTOMER_TOKEN = "PAY_CUSTOMER_";

    /** 京东支付类型 4：余额 7：网银钱包 101：金采支付 */
    public static final Integer JD_PAYTYPE_BAL = 4;

    /** 电子报销款 - 1，人工处理，0，随行付支付 2，融宝支付3，爱农 ，4拉卡拉*/
    public static final String RESALE_DZBXK_DEAL_WAY_0 = "0";

    /** 电子报销款 - 1，人工处理，0，随行付支付 2，融宝支付3，爱农 ，4拉卡拉,5招商银行*/
    public static final String RESALE_DZBXK_DEAL_WAY_1 = "1";

    /** 电子报销款 - 1，人工处理，0，随行付支付2，融宝支付3，爱农，4拉卡拉,5招商银行 */
    public static final String RESALE_DZBXK_DEAL_WAY_2 = "2";

    /** 电子报销款 - 1，人工处理，0，随行付支付 2，融宝支付3，爱农 ，4拉卡拉,5招商银行*/
    public static final String RESALE_DZBXK_DEAL_WAY_3 = "3";
    
    /** 电子报销款 - 1，人工处理，0，随行付支付 2，融宝支付3，爱农，4拉卡拉 ,5招商银行*/
    public static final String RESALE_DZBXK_DEAL_WAY_4 = "4";
    
    /** 电子报销款 - 1，人工处理，0，随行付支付 2，融宝支付3，爱农，4拉卡拉 ,5招商银行 */
    public static final String RESALE_DZBXK_DEAL_WAY_5 = "5";

    /** 转让电子报销款 - 转让中 */
    public static final String RESALE_DZBXK_0 = "0";

    /** 转让报销款 - 已转让 */
    public static final String RESALE_DZBXK_1 = "1";

    /** 转让报销款 - 失败 */
    public static final String RESALE_DZBXK_2 = "2";

    /** 转让报销款 - 已取消 */
    public static final String RESALE_DZBXK_3 = "3";

    /** cws 20160802 钱包账户转让状态 4-已确认 【现金赎回状态 4-已确认 】 **/
    public final static String RESALE_DZBXK_4 = "4";

    /** 代付处理中Timing- */
    public final static String RESALE_DZBXK_5 = "5";

    /** API商户用户状态 1-账户正常 **/
    public static final String API_MERCHANT_AC_TYPE_1 = "1";

    /** API商户用户状态 2-账户被冻结 **/
    public static final String API_MERCHANT_AC_TYPE_2 = "2";

    /** API商户用户状态 3-账户注销 **/
    public static final String API_MERCHANT_AC_TYPE_3 = "3";

    /** 支付类型 1-支付宝 **/
    public static final String PAY_TYPE_1 = "1";

    /** 支付类型 2-微信 **/
    public static final String PAY_TYPE_2 = "2";

    /** 支付类型 3-信用支付 **/
    public static final String PAY_TYPE_3 = "3";

    /** 支付类型 4-随行付 **/
    public static final String PAY_TYPE_4 = "4";

    /** 支付类型 5-蜂钱包 **/
    public static final String PAY_TYPE_5 = "5";

    /** 支付类型 6-壹通券 **/
    public static final String PAY_TYPE_6 = "6";

    /** 京东售后状态0：申请中 */
    public static final String JD_AFS_STATUS_0 = "0";

    /** 京东售后状态1：换，修或用户确认完成  已完成 */
    public static final String JD_AFS_STATUS_1 = "1";

    /** 京东售后状态2：已取消 */
    public static final String JD_AFS_STATUS_2 = "2";

    /** 京东售后状态3：退款完成 */
    public static final String JD_AFS_STATUS_3 = "3";

    /** 京东售后状态4：退款中 */
    public static final String JD_AFS_STATUS_4 = "4";

    /** 大礼包是否过期 0：未过期 */
    public static final Integer GIFT_PACKAGE_EXPIRED_0 = 0;

    /** 大礼包是否过期 1：已过期 */
    public static final Integer GIFT_PACKAGE_EXPIRED_1 = 1;

    /** 删除消息记录标识 */
    public static final String IS_DELETE = "0";

    /** 未删除消息记录标识 */
    public static final String NO_DELETE = "1";

    /** 蜂点模块上下线状态 1:上线 */
    public static final String FD_MODULE_ON = "1";

    /** 蜂点模块上下线状态 1:下线 */
    public static final String FD_MODULE_OFF = "2";

    /** 蜂点模块/账号是否有误 1:有误 */
    public static final String FD_HAS_ERROR_1 = "1";

    /** 蜂点模块/账号是否有误 2:没有 */
    public static final String FD_HAS_ERROR_2 = "2";

    /** 蜂点模块级别 0:根模块 */
    public static final String FD_MODULE_LEVEL_0 = "0";

    /** 蜂点模块级别 1:1级子模块 */
    public static final String FD_MODULE_LEVEL_1 = "1";

    /** 楼层是否显示 **/
    public static final String FLOOR_STATUS_0 = "0";// 不显示

    public static final String FLOOR_STATUS_1 = "1";// 显示

    public static final Integer FLOOR_PRD_TYPE_LEVEL = 1;// 楼层级别

    public static final String FLOOR_STATUS = "0";// 楼层状态

    public static final String FLOOR_FB_PLATFORM = "1";// 蜂贝楼层平台

    public static final String FLOOR_SHANMALL_PLATFORM = "5";// 闪mall楼层平台

    public static final String FLOOR_VFBP = "8";// 蜂钱包个人

    /** 蜂点子账户是否拥有主账户的某个权限 1:拥有 */
    public static final String IS_SUB_ACCOUNT_OWN_YES = "1";

    /** 蜂点子账户是否拥有主账户的某个权限 2:没有 */
    public static final String IS_SUB_ACCOUNT_OWN_NO = "2";


    public static final String MSG_PLATFORM_STATUS = "1";// 平台消息状态 1是显示 0是不显示

    /******************************************* 蜂采专区 开始(与此无关请不要添加在此) *******************************************************/

    /** 企业待审核 **/
    public static final String FC_RESULT_ENTERPRISE_IN_AUDIT = "0004";

    /** 企业被驳回 **/
    public static final String FC_RESULT_ENTERPRISE_REJECT = "0005";

    /** 企业被关闭 **/
    public static final String FC_RESULT_ENTERPRISE_CLOSE = "0006";

    /** 模块下线 **/
    public static final String FC_RESULT_MODULE_OFFLINE = "0007";

    /******************************************* 蜂采专区 结束(与此无关请不要添加在此) *******************************************************/

    /******************************************* 蜂点公共专区 开始(与此无关请不要添加在此) *******************************************************/

    /** 蜂采获取产品分类菜单(首页) **/
    public static final String PRODUCT_TYPE_STATUS_TOP = "0";

    /** 方法执行成功 **/
    public static final String RESULT_SUCCESS = "1";

    /** 方法执行失败 **/
    public static final String RESULT_FAIL = "0";

    /** 没有TOKEN,或者TOKEN过期 **/
    public static final String RESULT_TOKEN_ERROR = "0003";

    /** 登出 **/
    public static final String NORMAL_OUT = "0012";

    /** 登录时间过期 **/
    public static final String LOGIN_TIME_EXPIRATION = "-1";

    /** 无效令牌 **/
    public static final String RESULT_SIGN_ERROR = "0009";

    /** 登录信息为空 **/
    public static final String LOGIN_INFO_NULL = "0010";

    /** 跳转蜂点系统 **/
    public static final String NORMAL_JUMP = "0011";

    /** 获取用户信息失败 **/
    public static final String GET_USER_INFO_FAILED = "0012";

    /** 登录名已存在  ***/
    public static final String LOGIN_NAME_EXIST = "0012";

    /** redis超时的时间 **/
    public static final Long TIME_OUT = 30 * 60L;

    /** 默认角色 **/
    public static final String DEFAULT_ROLE = "0";

    /** 普通角色 **/
    public static final String OTHER_ROLE = "1";

    /** 菜单顶层 **/
    public static final Integer MENU_TOP = 0;

    /******************************************* 蜂点公共专区 结束(与此无关请不要添加在此) *******************************************************/

    /**
     * 蜂软
     */
    public static final String FR = "fr";

    /**
     * 蜂软session redis前缀常量
     */
    public static final String FR_SESSION_PREV = "frSession_";

    // 员工类型 1正式 2 兼职 3 临时
    /** 员工类型 1 正式 */
    public static final String FD_EMP_TYPE_1 = "1";

    /** 员工类型 2 兼职 */
    public static final String FD_EMP_TYPE_2 = "2";

    /** 员工类型 3 临时 */
    public static final String FD_EMP_TYPE_3 = "3";

    /**
     * 蜂点企业是否注册闪报
     */
    public static final String FD_REGISTER_YES = "yesRegister";

    public static final String FD_REGISTER_NO = "noRegister";

    /**
     * 企业福利 大订单状态 01：待商户部确认 02：待付款 03：付款完成 04：确认付款 07:订单处理完成 09：已取消
     */
    public static final String VFB_ADVANCE_ORDERS_STATUS_1 = "01";

    public static final String VFB_ADVANCE_ORDERS_STATUS_2 = "02";

    public static final String VFB_ADVANCE_ORDERS_STATUS_3 = "03";

    public static final String VFB_ADVANCE_ORDERS_STATUS_4 = "04";

    public static final String VFB_ADVANCE_ORDERS_STATUS_7 = "07";

    public static final String VFB_ADVANCE_ORDERS_STATUS_9 = "09";

    /**
     * 企业福利 小订单 子订单状态 01：待付款 02：付款完成，待确认 03：确认付款 04：处理中 08：已完成 09：已取消
     */
    public static final String VFB_SUB_ADVANCE_ORDERS_STATUS_1 = "01";

    public static final String VFB_SUB_ADVANCE_ORDERS_STATUS_2 = "02";

    public static final String VFB_SUB_ADVANCE_ORDERS_STATUS_3 = "03";

    public static final String VFB_SUB_ADVANCE_ORDERS_STATUS_4 = "04";

    public static final String VFB_SUB_ADVANCE_ORDERS_STATUS_8 = "08";

    public static final String VFB_SUB_ADVANCE_ORDERS_STATUS_9 = "09";

    /** fqb交易状态 1已成功 0 待处理 2已退款 **/
    public static final String FQB_TRAN_STATUS_0 = "0";

    public static final String FQB_TRAN_STATUS_1 = "1";

    public static final String FQB_TRAN_STATUS_2 = "2";

    /** 蜂点企业是否第一个登录名 0:是 1:否 **/
    public static final String ENTERPRISE_FIRST_LOGIN_YES = "0";

    public static final String ENTERPRISE_FIRST_LOGIN_NO = "1";

    /**
     * 企业产品申请状态 1 审核中
     */
    public static final String VFB_VIP_PRD_APPLY = "1";

    /** 商户平台会计科目状态 1:上架 2:下架 **/
    public static final String INVOICEITEM_STATUS_ON = "1";

    public static final String INVOICEITEM_STATUS_OFF = "2";

    /** 商户平台会计科目级别 1:一级科目 2:二级科目 **/
    public static final Integer INVOICEITEM_GRADE_ONE_LEVEL = 1;

    public static final Integer INVOICEITEM_GRADE_TWO_LEVEL = 2;

    /** 商品是否关联了科目 1:关联 2:没有关联 **/
    public static final String IS_ITEM_TRUE = "1";

    public static final String IS_ITEM_FALSE = "2";

    /** api商户的付款方式 1:对公账户 2:支票 **/
    public static final String API_PAYMETHOD_PUBLICACCOUNT = "1";

    public static final String API_PAYMETHOD_CHEQUE = "2";

    /** 商品是否关联了子属性 1:关联 2:没有关联 **/
    public static final String IS_ATTRIBUTE_TRUE = "1";

    public static final String IS_ATTRIBUTE_FALSE = "2";

    /** kafka 发送邮件 短信 时 消息类型 **/
    public static final String MESSAGETYPE_0 = "0";// 短信

    public static final String MESSAGETYPE_1 = "1";// 邮箱

    /** 认证状态 0：未认证 1：已认证 **/
    public static final String IS_AUTH_STATUS_0 = "0";

    /** 1：已认证 **/
    public static final String IS_AUTH_STATUS_1 = "1";

    /** 是否签署文件 0：未签署 1：已签署 2 签署中 **/
    public static final String IS_SIGN_STATUS_0 = "0";

    /** 1：已签署 **/
    public static final String IS_SIGN_STATUS_1 = "1";

    /** 2 签署中 **/
    public static final String IS_SIGN_STATUS_2 = "2";

    /** 是否是部门主管：1-是 0-不是 */
    public static final String IS_MANAGER = "1";

    public static final String NOT_MANAGER = "0";

    /** 组织架构 左边树形菜单的层数 */
    public static final int ORG_LEFT_MENU_FLOOR_NUMBER = 3;

    /** 1：第三方参数必传 **/
    public static final String THIRD_PARAM_MUST_PASS = "1";

    /** 0：第三方参数非必传 **/
    public static final String THIRD_PARAM_NOT_MUST_PASS = "0";

    /** 1：使用第三方配置参数 **/
    public static final String USE_CONFIG_PARAMETERS = "1";

    /** 0：不使用第三方配置参数 **/
    public static final String NOT_USE_CONFIG_PARAMETERS = "0";

    /** 1：企业注册类型 **/
    public static final String VIP_OP_TYPE_REGISTER = "1";

    /** 2：企业登录类型 **/
    public static final String VIP_OP_TYPE_LOGIN = "2";

    /** 3：首次点击模块  **/
    public static final String VIP_OP_TYPE_FIRST_CLICK = "3";

    /** 4：点击模块  **/
    public static final String VIP_OP_TYPE_CLICK = "4";

    /** 开票状态 0--未保存 */
    public static final String OPEN_INVOICE_STATUS_0 = "0";

    /** 开票状态 1--保存未开票 **/
    public static final String OPEN_INVOICE_STATUS_1 = "1";

    /** 开票状态 2--已开票 **/
    public static final String OPEN_INVOICE_STATUS_2 = "2";

    /** 普通开票状态 01 未开票 */
    public static final String INVOICE_STATUS_01 = "01";

    /** 普通开票状态 02 开票中 */
    public static final String INVOICE_STATUS_02 = "02";

    /** 普通开票状态 03 已开票 */
    public static final String INVOICE_STATUS_03 = "03";

    /** 开票申请状态 00 正在创建 */
    public static final String INVOICE_APPLY_STATUS_00 = "00";

    /** 开票申请状态 01 已申请，处理中 */
    public static final String INVOICE_APPLY_STATUS_01 = "01";

    /** 开票申请状态 02 回票信息已经确定，正在准备配送 */
    public static final String INVOICE_APPLY_STATUS_02 = "02";

    /** 开票申请状态 03 发票正在配送 */
    public static final String INVOICE_APPLY_STATUS_03 = "03";

    /** 开票申请状态 04 客户已经确认收到发票 */
    public static final String INVOICE_APPLY_STATUS_04 = "04";

    /** 开票申请状态 05 申请已被取消 */
    public static final String INVOICE_APPLY_STATUS_05 = "05";

    /** 信息状态1 启用 */
    public static final String MSG_STATE_1 = "1";

    /** 信息状态 0 未启用 */
    public static final String MSG_STATE_0 = "0";

    /** 开票类型 01 普通商户 */
    public static final String APPLY_TYPE_01 = "01";

    /** 开票类型 02 优嘉优品商户 */
    public static final String APPLY_TYPE_02 = "02";

    /** 收入 0 支出 1 */
    public static final String SETTLEMENT_STATUS_0 = "0";

    public static final String SETTLEMENT_STATUS_1 = "1";

    /** 是否对账 已对账 0 未对账1 */
    public static final String SETTLEMENT_STATUS_CHECK_0 = "0";

    /** 是否对账 已对账 0 未对账1 */
    public static final String SETTLEMENT_STATUS_CHECK_1 = "1";

    /** 日志打印是否开启敏感信息加密 */
    public static final boolean LOG_SWICH_TRUE = true;

    public static final boolean LOG_SWICH_FALSE = false;

    /** 1- 处理中 */
    public static final String MOYAO_APPLY_USE_STATUS_1 = "1";

    /** 2-已完成 */
    public static final String MOYAO_APPLY_USE_STATUS_2 = "2";

    /** 3-驳回 */
    public static final String MOYAO_APPLY_USE_STATUS_3 = "3";

    /** 4-取消 */
    public static final String MOYAO_APPLY_USE_STATUS_4 = "4";

    /** 0-停用 */
    public static final String MOYAO_WORKFLOW_STATUS_0 = "0";

    /** 1-启用 */
    public static final String MOYAO_WORKFLOW_STATUS_1 = "1";

    /** 0-不是默认 */
    public static final String MOYAO_DEFAULT_WORKFLOW_0 = "0";

    /** 1-是默认 */
    public static final String MOYAO_DEFAULT_WORKFLOW_1 = "1";

    /** 0-待审核 */
    public static final String MOYAO_GOODS_APPLY_DETIAL_STATUS_0 = "0";
    /**
     * 0。不在线
     */
    public static final String MOYAO_NEWS_PUSH_STATUS_0 = "0";
    /**
     * 1。在线
     */
    public static final String MOYAO_NEWS_PUSH_STATUS_1 = "1";

    /** 1-未取用 */
    public static final String MOYAO_GOODS_APPLY_DETIAL_STATUS_1 = "1";

    /** 2-已取 */
    public static final String MOYAO_GOODS_APPLY_DETIAL_STATUS_2 = "2";

    /** 3-已归还 */
    public static final String MOYAO_GOODS_APPLY_DETIAL_STATUS_3 = "3";

    /** 4-已取消 */
    public static final String MOYAO_GOODS_APPLY_DETIAL_STATUS_4 = "4";
    /** 5-取用处理中 */
    public static final String MOYAO_GOODS_APPLY_DETIAL_STATUS_5 = "5";
    /** 6-存入处理中 */
    public static final String MOYAO_GOODS_APPLY_DETIAL_STATUS_6 = "6";
    /** 7-未存入 */
    public static final String MOYAO_GOODS_APPLY_DETIAL_STATUS_7 = "7";

    /** 1-存储中 */
    public static final String MOYAO_GOODS_INFO_STATUS_1 = "1";

    /** 2-已取走 */
    public static final String MOYAO_GOODS_INFO_STATUS_2 = "2";

    /** 3-警告状态 */
    public static final String MOYAO_GOODS_INFO_STATUS_3 = "3";

    /** 1-柜门开启 */
    public static final String MOYAO_CUPBOARD_OPENSTATUS_1 = "1";

    /** 2-柜门关闭 */
    public static final String MOYAO_CUPBOARD_OPENSTATUS_2 = "2";

    /** 3-柜门开待处理 */
    public static final String MOYAO_CUPBOARD_OPENSTATUS_3 = "3";

    /** 0-待入库-魔钥标签入库状态使用 */
    public static final String MOYAO_STORE_STATUS_0 = "0";
    
    /** 1-流水线状态--入库 */
    public static final String MOYAO_STORE_STATUS_1 = "1";

    /** 2-流水线状态--出库 */
    public static final String MOYAO_STORE_STATUS_2 = "2";
    
    /** 3-流水线状态--待生产 */
    public static final String MOYAO_STORE_STATUS_3 = "3";
    
    /** 4-流水线状态--生产中 */
    public static final String MOYAO_STORE_STATUS_4 = "4";
    
    /** 9-待出库-魔钥标签出库状态使用 */
    public static final String MOYAO_STORE_STATUS_9 = "9";
    /** 魔钥-01-员工 */
    public static final String MOYAO_USERTYPE_1 = "01";

    /** 魔钥-02-个人 */
    public static final String MOYAO_USERTYPE_2 = "02";
    /** 魔钥-0-正常 */
    public static final String MOYAO_STATUS_0 = "0";

    /** 魔钥-1-未激活 */
    public static final String MOYAO_STATUS_1 = "1";

    /** 魔钥-2-冻结 */
    public static final String MOYAO_STATUS_2 = "2";

    /** 魔钥-9-已销户 */
    public static final String MOYAO_STATUS_9 = "9";
    /** 1--使用中 */
    public static final String MOYAO_CUPBOARD_STATUS_1 = "1";

    /** 2-故障中 */
    public static final String MOYAO_CUPBOARD_STATUS_2 = "2";

    /** 0-未使用 */
    public static final String MOYAO_CUPBOARD_STATUS_0 = "0";
    /** 3-柜子状态 已作废 */
    public static final String MOYAO_CUPBOARD_STATUS_3 = "3";

    /** 1-退货 */
    public static final String MOYAO_STORE_TYPE_1 = "1";

    /** 2-换货 */
    public static final String MOYAO_STORE_TYPE_2 = "2";

    /** 3-维修 */
    public static final String MOYAO_STORE_TYPE_3 = "3";

    /** 0-新品 */
    public static final String MOYAO_STORE_TYPE_0 = "0";

    /** 1-使用中 */
    public static final String MOYAO_VIP_CUPBOARD_RELATION_STATUS_1 = "1";

    /** 2-已停用 */
    public static final String MOYAO_VIP_CUPBOARD_RELATION_STATUS_2 = "2";
    
    /** 1-魔钥柜子在线状态 ：1-在线 */
    public static final String MOYAO_CUPBOARD_ONLINE_STATUS_1 = "1";
    /** 0-魔钥柜子在线状态 ：0-下线 */
    public static final String MOYAO_CUPBOARD_ONLINE_STATUS_0 = "0";
    /** 1-魔钥 物品申请类型  1-取还物品 */
    public static final String MOYAO_GOODS_APPLY_TYPE_1 = "1";
    /** 2-魔钥 物品申请类型 ：2-新加入物品 */
    public static final String MOYAO_GOODS_APPLY_TYPE_2 = "2";
    /** 1-魔钥用户在线状态 ：1-在线 */
    public static final String MOYAO_USER_ONLINE_STATUS_1 = "1";
    /** 0-魔钥用户在线状态 ：0-下线 */
    public static final String MOYAO_USER_ONLINE_STATUS_0 = "0";

    /** empfeiyu-service部分专用开始 */
    // 手机充值时的3种状态
    public static final String PHONE_RECHARGE_STATUS_1 = "1";

    public static final String PHONE_RECHARGE_STATUS_2 = "2";

    public static final String PHONE_RECHARGE_STATUS_3 = "3";

    // 添加支行时用到 0:未处理 1：已处理
    public static final String EXPECT_BANK_BRANCH_STATUS_0 = "0";

    public static final String EXPECT_BANK_BRANCH_STATUS_1 = "1";

    // 电子卡状态 1 未绑定 2 已绑定 3 转让中 4 转让失败
    public static final String CARD_STATUS_1 = "1";

    public static final String CARD_STATUS_2 = "2";

    public static final String CARD_STATUS_3 = "3";

    public static final String CARD_STATUS_4 = "4";

    // 密码
    public static final String IS_NEW_PWD = "0";

    public static final String REGISTER_RECHARGE_STATUS_SUCCESS = "success";

    // 手机验证码
    public static final String PHONE_VALID_CODE = "1";

    // 邮箱验证码
    public static final String EMAIL_VALID_CODE = "0";

    public static final String EMAIL_VALID_CODE_2 = "2";

    /** empfeiyu-service部分专用结束 */

    /**** feiyu-web专用开始 ****/

    public static final String IS_SPLIT_0 = "0";

    public static final String IS_SPLIT_1 = "1";

    /**** feiyu-web专用结束 ****/
    /** 心跳 **/
    public static final String MOYAO_TRANSCODE_10000 = "10000";
    
    /** 10001-魔钥指令-开柜子指令 */
    public static final String MOYAO_TRANSCODE_10001 = "10001";

    /** 10002-魔钥指令-手动盘点指令 */
    public static final String MOYAO_TRANSCODE_10002 = "10002";

    /** 10003-魔钥指令-柜子自动盘点指令 */
    public static final String MOYAO_TRANSCODE_10003 = "10003";

    /** 10004-魔钥指令-标签出库指令盘点 */
    public static final String MOYAO_TRANSCODE_10004 = "10004";

    /** 10005-魔钥指令-标签入库 */
    public static final String MOYAO_TRANSCODE_10005 = "10005";
    
    /** 10006-魔钥指令-置换柜子编号 */
    public static final String MOYAO_TRANSCODE_10006 = "10006";
    /** 10007-魔钥指令-柜门关闭时，柜子发出的关门指令 */
    public static final String MOYAO_TRANSCODE_10007 = "10007";
    /** 10008-魔钥指令-检查柜门开关状态 */
    public static final String MOYAO_TRANSCODE_10008 = "10008";
    /** 10009-魔钥指令-修改柜子报警时间 */
    public static final String MOYAO_TRANSCODE_10009 = "10009";
    /** 10010-魔钥指令-超出柜门未关闭报警时间指令 */
    public static final String MOYAO_TRANSCODE_10010 = "10010";
    /** 10011-魔钥指令-柜子上线指令 */
    public static final String MOYAO_TRANSCODE_10011 = "10011";
    /** 10012-魔钥指令-遗嘱 */
    public static final String MOYAO_TRANSCODE_10012 = "10012";
    /** 10013-魔钥指令-发布广告 */
    public static final String MOYAO_TRANSCODE_10013 = "10013";
    /** 10014-魔钥指令-替换域名*/
    public static final String MOYAO_TRANSCODE_10014 = "10014";
    /** 10015-魔钥指令-柜子重连发送柜门锁状态*/
    public static final String MOYAO_TRANSCODE_10015 = "10015";
    /** 10016-魔钥指令-远程推送升级程序**/
    public static final String MOYAO_TRANSCODE_10016 = "10016";
    /** 10017-魔钥指令-远程推送固件升级**/
    public static final String MOYAO_TRANSCODE_10017 = "10017";
    /** 10016-魔钥指令-上传视频**/
    public static final String MOYAO_TRANSCODE_10088 = "10088";
    /** 10018-魔钥指令-开启视频**/
    public static final String MOYAO_TRANSCODE_10018 = "10018";
    /** 10021-魔钥指令-柜孔状态**/
    public static final String MOYAO_TRANSCODE_10021 = "10021";
    /** 10019-魔钥指令-柜子升级成功后，返回版本号信息**/
    public static final String MOYAO_TRANSCODE_10019 = "10019";
    /** 10020-魔钥指令-发布视频 */
    public static final String MOYAO_TRANSCODE_10020 = "10020";
    /** 10022-wifi信息  客户端向moyao推送连接wifi成功消息*/
    public static final String MOYAO_TRANSCODE_10022 = "10022";
    /** T0001-魔钥交易类型-指令开门 */
    public static final String MOYAO_TRANTYPE_T0001 = "T0001";
    /** T0002-魔钥交易类型-盘点标签 */
    public static final String MOYAO_TRANTYPE_T0002 = "T0002";
    /** T0003-魔钥交易类型-修改柜子编号 */
    public static final String MOYAO_TRANTYPE_T0003 = "T0003";
    /** T0004-魔钥交易类型-检查柜门是否开关 */
    public static final String MOYAO_TRANTYPE_T0004 = "T0004";
    /** T0005-魔钥交易类型-修改柜子报警时间 */
    public static final String MOYAO_TRANTYPE_T0005 = "T0005";
    /** T0005-魔钥交易类型-发布广告 */
    public static final String MOYAO_TRANTYPE_T0006 = "T0006";
    /** T0007-魔钥交易类型-替换域名 */
    public static final String MOYAO_TRANTYPE_T0007 = "T0007";
    /** T0008-魔钥交易类型-远程推送升级**/
    public static final String MOYAO_TRANTYPE_T0008 = "T0008";
    /** T0009-魔钥交易类型-视频交互**/
    public static final String MOYAO_TRANTYPE_T0009 = "T0009";
    /** T0010-魔钥交易类型-柜孔信息交互**/
    public static final String MOYAO_TRANTYPE_T0010 = "T0010";
    /** serverTopic-魔钥服务端主题前缀 */
    public static final String MOYAO_SERVER_TOPIC_PREFIX = "serverTopic/";
    /** clientTopic-魔钥客户端主题前缀 */
    public static final String MOYAO_CLIENT_TOPIC_PREFIX = "clientTopic/";
    /** serverTopic-魔钥服务端主题--广告推送 */
    public static final String MOYAO_SERVER_TOPIC_ADV = "serverTopic/advertisement";
    /** serverTopic-魔钥服务端主题--广告推送 */
    public static final String MOYAO_SERVER_TOPIC_REALMNAME = "serverTopic/reviseRealmName";
    /** serverTipic-魔钥服务客户端程序升级**/
    public static final String MOYAO_SERVER_TOPIC_UPGRADE = "serverTopic/upgrade";
    /** 0000-魔钥状态-成功 */
    public static final String MOYAO_RESULTCODE_0000 = "0000";

    /** 0001-魔钥状态-系统异常 */
    public static final String MOYAO_RESULTCODE_0001 = "0001";
    /** 1111-魔钥状态-柜子不在线*/
    public static final String MOYAO_RESULTCODE_1111 = "1111";
    /** 1-未处理 */
    public static final String MOYAO_GOODS_EXCEPTION_STATUS_1 = "1";

    /** 2-已处理 */
    public static final String MOYAO_GOODS_EXCEPTION_STATUS_2 = "2";

    /** 商品是否一次性：0不是 */
    public static final String MOYAO_GOODS_IS_DISPOSABLE_0 = "0";

    /** 商品是否一次性：1是 */
    public static final String MOYAO_GOODS_IS_DISPOSABLE_1 = "1";

    /** 0-魔钥-整体扫描  */
    public static final String MOYAO_SCANTYPE_STATUS_0 = "0";

    /** 1-魔钥-单个柜子扫描 */
    public static final String MOYAO_SCANTYPE_STATUS_1 = "1";
    /** 0-魔钥-个人  */
    public static final String MOYAO_TYPE_0 = "0";

    /** 1-魔钥-企业 */
    public static final String MOYAO_TYPE_1 = "1";

    /** 3-魔钥批次状态-待生产 */
    public static final String MOYAO_BATCH_STATUS_3 = "3";

    /** 4-魔钥批次状态-生产中 */
    public static final String MOYAO_BATCH_STATUS_4 = "4";

    /** 1-魔钥批次状态-已入库 */
    public static final String MOYAO_BATCH_STATUS_1 = "1";

    /** 1-魔钥-标签状态-使用中 */
    public static final String MOYAO_RFID_STATUS_1 = "1";

    /** 2-魔钥-标签状态-报损 */
    public static final String MOYAO_RFID_STATUS_2 = "2";

    /** 0-魔钥标签状态-未使用 */
    public static final String MOYAO_RFID_STATUS_0 = "0";

    /** 1-魔钥-物品状态-使用中 */
    public static final String MOYAO_GOODS_STATUS_1 = "1";

    /** 2-魔钥-物品状态-未使用 */
    public static final String MOYAO_GOODS_STATUS_2 = "2";
    
    /** 0-魔钥-标签批量批次处理状态:0-待处理 */
    public static final String MOYAO_RFID_BATCH_STATUS_0 = "0";
    
    /** 1-魔钥-标签批量批次处理状态-操作成功 */
    public static final String MOYAO_RFID_BATCH_STATUS_1 = "1";
    
    /** 2-魔钥-标签批量批次处理状态-操作失败 */
    public static final String MOYAO_RFID_BATCH_STATUS_2 = "2";
    
    /** 0-魔钥-标签批量出入库类型-待入库 */
    public static final String MOYAO_RFID_STORE_TYPE_0 = "0";
    
    /** 1-魔钥-标签批量出入库类型-入库 */
    public static final String MOYAO_RFID_STORE_TYPE_1 = "1";
    
    /** 2-魔钥-标签批量出入库类型-出库 */
    public static final String MOYAO_RFID_STORE_TYPE_2 = "2";
    
    /** 3-魔钥-标签批量出入库类型-待出库 */
    public static final String MOYAO_RFID_STORE_TYPE_3 = "3";
    
    /** 0-魔钥-操作用户类型-超级管理员 */
    public static final String MOYAO_OPERATE_USER_TYPE_0 = "0";
    /** 4-魔钥-操作用户类型-手动开门操作用户 */
    public static final String MOYAO_OPERATE_USER_TYPE_4 = "4";
    
    /** 1-魔钥-物品存取操作类型 1-取走物品 */
    public static final String MOYAO_GOODS_OPERATE_TYPE_1 = "1";
    /** 2-魔钥-物品存取操作类型 2-存入物品 */
    public static final String MOYAO_GOODS_OPERATE_TYPE_2 = "2";
    /** 3-魔钥-物品存取操作类型 3-新增物品 */
    public static final String MOYAO_GOODS_OPERATE_TYPE_3 = "3";
    
    /** 0-魔钥-执行失败 */
    public static final String MOYAO_FAIL_0 = "0";
    /** 1-魔钥-执行成功 */
    public static final String MOYAO_SUCCESS_1 = "1";
    /** 魔钥-操作用户角色  0-后台管理员 */
    public static final String MOYAO_OPERATOR_ROLE_0 = "0";
    /** 魔钥-操作用户角色  1-企业端操作员 */
    public static final String MOYAO_OPERATOR_ROLE_1 = "1";
    /** 魔钥-操作用户角色  2-普通员工 */ 
    public static final String MOYAO_OPERATOR_ROLE_2 = "2";
    /** 魔钥-操作用户角色  3-特殊权限用户  */ 
    public static final String MOYAO_OPERATOR_ROLE_3 = "3";
    /** 魔钥-操作用户角色  4-手动操作  */ 
    public static final String MOYAO_OPERATOR_ROLE_4 = "4";
    /** 魔钥-物品存取记录是否正常  1-正常 */
    public static final String MOYAO_GOODS_STORE_NORMAL_FLAG_1 = "1";
    /** 魔钥-物品存取记录是否正常  0-不正常 */
    public static final String MOYAO_GOODS_STORE_NORMAL_FLAG_0 = "0";
    /** 0-魔钥-操作处理状态:0-待处理 */
    public static final String MOYAO_OPERATE_STATUS_0 = "0";
    
    /** 1-魔钥-操作处理状态   1-操作成功 */
    public static final String MOYAO_OPERATE_STATUS_1 = "1";
    
    /** 2-魔钥-操作处理状态   2-操作失败 */
    public static final String MOYAO_OPERATE_STATUS_2 = "2";
    
    /** 1福员外-采购订单-已创建,待审核 */
    public static final String FYW_ORDERS_STATUS_1 = "1";

    /** 2福员外-采购订单-已审核，待支付 */
    public static final String FYW_ORDERS_STATUS_2 = "2";

    /** 3福员外-采购订单-水单已创建，未通过 */
    public static final String FYW_ORDERS_STATUS_3 = "3";

    /** 4福员外-采购订单-水单通过审核，采购到账，等待开票 */
    public static final String FYW_ORDERS_STATUS_4 = "4";

    /** 5福员外-采购订单-订单已开票，订单完成 */
    public static final String FYW_ORDERS_STATUS_5 = "5";

    /** 6福员外-采购订单-订单已取消 */
    public static final String FYW_ORDERS_STATUS_6 = "6";

    /** 7福员外-采购订单-水单未过审核 */
    public static final String FYW_ORDERS_STATUS_7 = "7";
    /** 8福员外-采购订单-订单发票已配送 */
    public static final String FYW_ORDERS_STATUS_8 = "8";
    /** 9福员外-采购订单-订单订单完成 */
    public static final String FYW_ORDERS_STATUS_9 = "9";
    
    
    /**福员外-账户类型-个人 */
    public static final String FYW_ACCOUNT_TYPE_1="1";
    /**福员外-账户类型-企业 */
    public static final String FYW_ACCOUNT_TYPE_2="2";  
    /**福员外-账户状态-未在第三方激活 */
    public static final String FYW_ACCOUNT_STATUS_0="0";
    /**福员外-账户状态-已在第三方激活 */
    public static final String FYW_ACCOUNT_STATUS_1="1";
    
    /**福员外-商户状态-启用 */
    public static final String FYW_MERCHANT_STATUS_0="0";
    /**福员外-商户状态-停止使用 */
    public static final String FYW_MERCHANT_STATUS_1="1";
    
    /**福员外-交易类型-消费 */
    public static final String FYW_TRAN_TYPE_1="1";
    /**福员外-交易类型-转让 */
    public static final String FYW_TRAN_TYPE_2="2";
    /**福员外-交易类型-充值 */
    public static final String FYW_TRAN_TYPE_3="3";
    /**福员外-交易类型-冲正 */
    public static final String FYW_TRAN_TYPE_5="5";
    /**福员外-交易类型-退款 */
    public static final String FYW_TRAN_TYPE_6="6";
    /**福员外-交易类型-绑定虚拟卡 */
    public static final String FYW_TRAN_TYPE_7="7";

    /**福员外-收支类型-收入 */
    public static final String FYW_IN_OUT_TYPE_1="1";
    /**福员外-收支类型-支出 */
    public static final String FYW_IN_OUT_TYPE_2="2";
    
    /**福员外-请求类型-扫码激活 */
    public static final String FYW_REQUEST_TYPE_00="00";
    /**福员外-请求类型-扫码进入 */
    public static final String FYW_REQUEST_TYPE_01="01";
    /**福员外-请求类型-企业充值 */
    public static final String FYW_REQUEST_TYPE_02="02";
    /**福员外-请求类型-员工绑定虚拟卡充值 */
    public static final String FYW_REQUEST_TYPE_03="03";
    /**福员外-请求类型-企业生成定额券 */
    public static final String FYW_REQUEST_TYPE_04="04";

    /**福员外-请求状态 -请求生成，等待处理 */
    public static final String FYW_REQUEST_STATUS_00="00";
    /**福员外-请求状态 -已发送请求   /更新企业账户交易完成*/
    public static final String FYW_REQUEST_STATUS_01="01";
    /**福员外-请求状态 -接收到回调访问 /收到返回数据*/
    public static final String FYW_REQUEST_STATUS_02="02";
    /**福员外-请求状态 -请求结束*/
    public static final String FYW_REQUEST_STATUS_03="03";
    /**福员外-请求状态 -没有回调*/
    public static final String FYW_REQUEST_STATUS_04="04";
    /**福员外-请求状态 -定额券完整处理完毕*/
    public static final String FYW_REQUEST_STATUS_05="05";

    /**福员外 -活动标识-企业金额补发 */
    public static final String FYW_ACTIVITY_TAG_0000="0000";
    /**福员外 -活动标识-企业开户充值 */
    public static final String FYW_ACTIVITY_TAG_0001="0001";
    /**福员外 -活动标识-企业充值返利 */
    public static final String FYW_ACTIVITY_TAG_0002="0002";
    /**福员外 -活动开关-开启 */
    public static final String FYW_ACTIVITY_SWITCH_0="0";
    /**福员外 -活动开关-关闭 */
    public static final String FYW_ACTIVITY_SWITCH_1="1";

            
    /** API商户的上线加状态 1：上架  0：下架*/
    public static final String API_MERCHANT_STATUS_0="0";
    public static final String API_MERCHANT_STATUS_1="1";
    
    /*** 携程产品类型 */
    public static final String XC_HOTEL_CODE="0";
    public static final String XC_TICKET="1";
    public static final String XC_MERCHANT_NAME="携程";
    
    /** FB订单存储到redis中的key值 */
    public static final String FB_FAIL_ORDERS="FB_ordersFail";

    /** 携程数据 0.失败 1.成功*/
    public static final String APPROVING_FLAG_0="0";
    public static final String APPROVING_FLAG_1="1";
    
    /**删除状态（1-正常 0-删除）*/
    public static final String DEL_STATUS_0="0";
    public static final String DEL_STATUS_1="1";
    /** 携程机票退款批量任务*/
    public static final String XC_FLIGHT_FLAG_0="0";
    /** 携程酒店退款批量任务*/
    public static final String XC_HOTEL_FLAG_1="1";
    /** 携程保险退款批量任务*/
    public static final String XC_INSURANCE_FLAG_4 ="4"; 
    /** 携程机票对账批量任务*/
    public static final String XC_FLIGHT_FLAG_2="2";
    /** 携程酒店对账批量任务*/
    public static final String XC_HOTEL_FLAG_3="3";
    /** 携程机票*/
    public static final String XC_FLIGHT ="携程机票";
    /** 携程酒店*/
    public static final String XC_HOTEL ="携程酒店";
    /** 携程保险*/
    public static final String XC_INSURANCE ="携程保险";
    
    /**
     * 未处理
     */
    public static final String REPEAT_PAY_ORDER_STATUS_1 ="1";
    /**
     * 已处理
     */
    public static final String REPEAT_PAY_ORDER_STATUS_2 ="2";
    
    /**
     * CRM客户管理管理   客户动向: 0黑名单  1公海  2意向库  3电销私海  4私海  5达成合作 6签约完成待审核'
     */
    /** 黑名单 */
    public static final String VIP_BLACK_STATUS ="0";
    /** 公海 */
    public static final String VIP_HIGHTSEA_STATUS ="1";
    /** 意向库 */
    public static final String VIP_INTENTION_STATUS ="2";
    /** 电销私海 */
    public static final String VIP_PHONE_PERSONSEA_STATUS ="3";
    /** 私海 */
    public static final String VIP_PERSONSEA_STATUS ="4";
    /** 达成合作 cooperation */
    public static final String VIP_COOPERATION_STATUS  ="5";
    /** 签约完成待审核 */
    public static final String VIP_WAIT_STATUS  ="6";
    
    /** FD-角色状态  0-关闭 */
    public static final String FD_ROLE_STATUS_0 = "0";
    /** FD-角色状态  1-正常 */
    public static final String FD_ROLE_STATUS_1 = "1";
    
    /** CRM-客户分配类型  1-从公海分配到电销私海 */
    public static final String CRM_ASSGIN_TYPE_1 = "1";
    /** CRM-客户分配类型  2-从意向库分配到客户私海 */
    public static final String CRM_ASSGIN_TYPE_2 = "2";
    /** CRM-客户分配类型  3-从公海到黑名单 */ 
    public static final String CRM_ASSGIN_TYPE_3 = "3";
    /** CRM-客户分配类型  4-从公海到意向库 */ 
    public static final String CRM_ASSGIN_TYPE_4 = "4";
    /** CRM-客户分配类型  5-从公海到私海 */ 
    public static final String CRM_ASSGIN_TYPE_5 = "5";
    /** CRM-客户分配类型  6-从电销私海到意向库 */ 
    public static final String CRM_ASSGIN_TYPE_6 = "6";
    /** CRM-客户分配类型  7-从私海到审核 */ 
    public static final String CRM_ASSGIN_TYPE_7 = "7";
    /** CRM-客户分配类型  8-从审核到合作客户 */ 
    public static final String CRM_ASSGIN_TYPE_8 = "8";
    /** CRM-客户分配类型 9-从审核到私海 */ 
    public static final String CRM_ASSGIN_TYPE_9 = "9";
    /** CRM-客户分配类型 10-重新分配给客户经理 */
    public static final String CRM_ASSGIN_TYPE_10 = "10";
    /** CRM-客户分配类型 11-意向库分配给电销私海 */
    public static final String CRM_ASSGIN_TYPE_11 = "11";
    /** CRM-客户分配类型 11-公海到客户经理 */
    public static final String CRM_ASSGIN_TYPE_12 = "12";

    /** CRM-客户公开类型  1-从电销私海公开到公海 */
    public static final String CRM_OPEN_TYPE_1 = "1";
    /** CRM-客户公开类型  2-从私海公开到公海 */
    public static final String CRM_OPEN_TYPE_2 = "2";
    /** CRM-客户公开类型  3-从黑名单公开到公海 */ 
    public static final String CRM_OPEN_TYPE_3 = "3";
    
    /** CRM-客户操作类型  1-沟通记录 */
    public static final String CRM_VIP_OPERATOR_TYPE_1 = "1";
    /** CRM-客户操作类型  2-系统操作*/ 
    public static final String CRM_VIP_OPERATOR_TYPE_2 = "2";
    
    /** 登录用户状态: 0-正常 */
    public static final String LOGIN_USER_STATUS_0="0";
    /** 登录用户状态: 1-关闭 */
    public static final String LOGIN_USER_STATUS_1="1";
    /** 登录用户状态: 2-注销 */
    public static final String LOGIN_USER_STATUS_2="2";
    /** 登录用户状态: 3-冻结 */
    public static final String LOGIN_USER_STATUS_3="3";
    
    /**
     * 商品商户商品类型
     */
    public static final String PRD_DISTINGUISH_1="1";
    /**
     * 服务商品类型
     */
    public static final String PRD_DISTINGUISH_2="2";
    
    /**
     * 商品类目类型 1:蜂贝   2:蜂惠
     */
    public static final String PRD_CATEGORY_TYPE_1="1";
    public static final String PRD_CATEGORY_TYPE_2="2";

    
    /** 商品分成策略: 1-仅首次返分成*/
    public static final String MER_STRATEGY_TYPE_1="1";
    /** 商品分成策略: 2-每次交易分成 */
    public static final String MER_STRATEGY_TYPE_2="2";
    /** 商品分成策略: 3-不分成 */
    public static final String MER_STRATEGY_TYPE_3="3";
    
    /** 商品分成策略: 百分比返佣还是固定数额返佣  0-百分比 */
    public static final String MER_STRATEGY_TYPE_PERCENT="0";
    /** 商品分成策略: 百分比返佣还是固定数额返佣  1-固定数额 */
    public static final String MER_STRATEGY_TYPE_QUOTA="1";
    
    /** 商品分成策略: 阶梯分成是否存在  0-不存在 */
    public static final String MER_IS_LADDER_REBATE_EXIST_0="0";
    /** 商品分成策略: 阶梯分成是否存在  1-存在 */
    public static final String MER_IS_LADDER_REBATE_EXIST_1="1";
    
    /** 分销商类型: 0--个人 */
    public static final String AGENTMER_TYPE_0="0"; 
    
    /** 分销商类型: 1--机构  */
    public static final String AGENTMER_TYPE_1="1"; 
    
    /** 分销商类型: 2--平台 */
    public static final String AGENTMER_TYPE_2="3"; 
    
    /** 分销商状态 0--待审核**/
    public static final String AGENTMER_STATUS_WAIT = "0";

    /** 分销商状态  1--通过 **/
    public static final String AGENTMER_STATUS_ACTIVE = "1";

    /** 分销商状态 2--驳回**/
    public static final String AGENTMER_STATUS_BACK = "2";

    /** 分销商状态3--注销 **/
    public static final String AGENTMER_STATUS_CLOSE = "3";

    /** 分销商级别 0--普通**/
    public static final String AGENTMER_LEVEL_COMMON = "0";

    /** 分销商级别 1--高级 **/
    public static final String AGENTMER_LEVEL_ADVANCE = "1";

    /** 默认的分销商编号 0 **/
    public static final String DEFAULT_AGENTMER_SEQ = "0";

    /** 分销商网站信息状态  0--待审核 **/
    public static final String ODM_WEB_SET_VERIFY = "0";

    /** 分销商网站信息状态  1--审核通过 **/
    public static final String ODM_WEB_SET_ACTIVE = "1";

    /** 分销商网站信息状态  2--驳回**/
    public static final String ODM_WEB_SET_BACK = "2";

    /** 蜂惠方法执行失败 **/
    public static final String FH_RESULT_FAIL = "0";
    /** 蜂惠方法执行成功 **/
    public static final String FH_RESULT_SUCCESS = "1";
    
    /****************************************************************** 蜂惠订单相关状态 开始 ******************************************************/
    /*** 待审核 */
    public static final String FH_ORDER_STATUS_1 = "1";

    /*** 订单被驳回 */
    public static final String FH_ORDER_STATUS_2 = "2";

    /*** 待付款 */
    public static final String FH_ORDER_STATUS_3 = "3";

    /*** 已上传水单，待审核 */
    public static final String FH_ORDER_STATUS_4 = "4";

    /*** 水单未过审 */
    public static final String FH_ORDER_STATUS_5 = "5";

    /*** 水单过审，付款成功，待开票 */
    public static final String FH_ORDER_STATUS_6 = "6";

    /*** 订单开票完成 */
    public static final String FH_ORDER_STATUS_7 = "7";

    /*** 订单取消 */
    public static final String FH_ORDER_STATUS_8 = "8";
    
    /*** 索取发票 */
    public static final String FH_ORDER_STATUS_9 = "9";
    
    /*** 申请开票 */
    public static final String FH_INVOICE_STATUS_0 = "0";
    
    /*** 已开票 */
    public static final String FH_INVOICE_STATUS_1 = "1";
    
    /*** 普通发票 */
    public static final String INVOICE_NATURE_0 = "0";
    
    /*** 专项发票 */
    public static final String INVOICE_NATURE_1 = "1";
    
    /*** 纸质发票 */
    public static final String INVOICE_TYPE_0 = "0";
    
    /*** 电子发票 */
    public static final String INVOICE_TYPE_1 = "1";

    /*** 订单是否删除 0：未删除*/
    public static final String FH_ORDER_DEL_STATUS_0 = "0";
    
    /*** 订单是否删除 1：已删除 */
    public static final String FH_ORDER_DEL_STATUS_1 = "1";
    /*** 订单服务类型 0 默认买断 */
    public static final String FH_ORDER_SERVICE_TYPE_DEFAULT = "0";
    /*** 订单服务类型 1 按时间收费 */
    public static final String FH_ORDER_SERVICE_TYPE_TIME = "1";
    
    
    /****************************************************************** 蜂惠订单相关状态 结束 ******************************************************/
    
    /*** 分销商结算标识 0：未结算 */
    public static final String FH_IS_AGENT_SETTLEMENT_0 = "0";
    
    /*** 分销商结算标识 1：已结算 */
    public static final String FH_IS_AGENT_SETTLEMENT_1 = "1";
    
    /*** 商户结算标识 0：未结算 */
    public static final String FH_IS_MER_SETTLEMENT_0 = "0";
    
    /*** 商户结算标识 1：已结算 */
    public static final String FH_IS_MER_SETTLEMENT_1 = "1";
    
    /** 服务商品审核状态 开通 **/
    public static final String SERVICE_PRODUCT_AUDIT_STATUS_ACTIVE = "0";

    /** 服务商品审核状态 待审核 **/
    public static final String SERVICE_PRODUCT_AUDIT_STATUS_WAIT = "1";

    /** 服务商品审核状态 驳回 **/
    public static final String SERVICE_PRODUCT_AUDIT_STATUS_BACK = "2";
    
    /**banner开启状态*/
    public static final String BANNER_OFF_STATUS = "00";//关闭
    public static final String BANNER_ON_STATUS = "01";//打开

    /**产品是否绑定了属性0:绑定了 1:未绑定*/
    public static final String IS_BIND_ATTR_0="0";
    public static final String IS_BIND_ATTR_1="1";
    
    /**分销商是否代理了商品-是*/
    public static final String IS_AGENT_YES = "0";
    /**分销商是否代理了商品-否*/
    public static final String IS_AGENT_NO = "1";
    
    /** 加价策略: 百分比还是固定数额  0-百分比 */
    public static final String RAISE_PRICE_TYPE_PERCENT = "0";
    /** 加价策略: 百分比还是固定数额  1-固定数额 */
    public static final String RAISE_PRICE_TYPE_QUOTA="1";
    
    /** 0-可用 */
    public static final String EFFECTIVE_SIGN_0 = "0";

    /** 1-不可用 */
    public static final String EFFECTIVE_SIGN_1 = "1";
    
    /**认证状态(0已认证,1认证中,2未认证,3认证失败)*/
    public static final String AUTH_STATAUS_0="0";
    public static final String AUTH_STATAUS_1="1";
    public static final String AUTH_STATAUS_2="2";
    public static final String AUTH_STATAUS_3="3";

    
    /**企业引导状态  0-未引导 **/
    public static final String ENTERPRISE_LEADSTATUS_0="0";
    /**企业引导状态  1-已引导**/
    public static final String ENTERPRISE_LEADSTATUS_1="1";

    
    /** 0-合同完成*/
    public static final String CONTRACT_STATUS_0 = "0";

    /** 是否签订完合同状态*/
    public static final String CONTRACT_FINISH_1 = "1";//已签订
    
    /** 是否签订完合同状态*/
    public static final String CONTRACT_FINISH_0 = "0";//未签订
    
    /** 是否签订完合同状态*/
    public static final String CONTRACT_FINISH_2 = "2";//暂未开通合同业务
    
    /** 是否签订完合同状态*/
    public static final String CONTRACT_FINISH_3 = "3";//标识公共模块，不用签合同，不用认证
    
    /** 企业是否颁发数字证书 0-未颁发，1-已颁发*/
    public static final String ENTP_REG_STATUS_0 = "0";
    public static final String ENTP_REG_STATUS_1 = "1";
    
    /** 此模块是否开通签合同功能：1-开通签合同功能 0-未开通签合同功能*/
    public static final String SIGN_CONTRACT_STATUS_0 = "0";
    public static final String SIGN_CONTRACT_STATUS_1 = "1";
    
    
    /******************************签名相关标识 *****************************************/
    //蜂点
    public static final String SIGNATURE_FD="1";
    //壹通券
    public static final String SIGNATURE_YITONGQUAN="2";
    //魔钥
    public static final String SIGNATURE_MOYAO="3";
    //卡鲤
    public static final String SIGNATURE_KALI="4";
    //快寄卖
    public static final String SIGNATURE_KUAIJIMAI="5";
    /***********************************************************************/
    
    /** 请求成功状态码 */
    public static final String REQUEST_STATUS_200 = "200";
    
    /** 众签返回 请求成功状态吗 */
    public static final String REQUEST_STATUS_0 = "0";
    
    /** 众签返回 打款成功状态吗 */
    public static final String MAKE_MONEY_STATUS_1 = "1";
    /** 众签返回 打款中状态吗 */
    public static final String MAKE_MONEY_STATUS_0 = "0";
    /** 众签返回 打款失败状态吗 */
    public static final String MAKE_MONEY_STATUS_3 = "3";
    /** 有效标识 */
    public static final String VALID_STATUS_0 = "0";//无效
    public static final String VALID_STATUS_1 = "1";//有效
    
    /** 蜂点域名 */
    public static final String FD_WEB_URL = "www.qiyeos.com";

    /** 蜂销域名 */
    public static final String FX_WEB_URL = "fx.qiyeos.com";

    /** 壹通券推荐系统logo */
    public static final String  YTQ_CHANNEL_LOGO = "email/logo/ytqchannellogo.png";
    
    /** 合同模板区分蜂点ODM（0-蜂点 1-分销商） */
    public static final String AGENT_MER_FLAG_0 = "0";//蜂点
    public static final String AGENT_MER_FLAG_1 = "1";//分销商
    
    //idservice 集群参数
    public static final String ID_CLUSTER_KEY = "idCluster";
    /**跃程 产品类型0话费 */
    public static final String YC_PRODUCT_TYPE_0="0";
    /**跃程 产品类型1流量*/
    public static final String YC_PRODUCT_TYPE_1="1";
    /**跃程 产品类型4油卡*/
    public static final String YC_PRODUCT_TYPE_4="4";
    /**跃程 产品状态 0上架   */
    public static final String YC_PRODUCT_STATUS_0="0";
    /**跃程 产品状态 1下架   */
    public static final String YC_PRODUCT_STATUS_1="1";
    /**跃程 运营商 0移动 */
    public static final String YC_PRODUCT_OPERATOR_MOBILE="0";
    /**跃程 运营商 1联通*/
    public static final String YC_PRODUCT_OPERATOR_UNICOM="1";
    /**跃程 运营商 2电信*/
    public static final String YC_PRODUCT_OPERATOR_TELECOM="2";
    /**跃程 运营商 3中石油*/
    public static final String YC_PRODUCT_OPERATOR_PETROCHINA="3";
    /**跃程 运营商 4中石化*/
    public static final String YC_PRODUCT_OPERATOR_SINOPEC="4";
    
    /**跃程 订单状态 0 订单已创建，未支付 */
    public static final String YC_ORDER_STATUS_0="0";
    /**跃程 订单状态1 支付成功，进行直充 */
    public static final String YC_ORDER_STATUS_1="1";
    /**跃程 订单状态2 直充申请成功，等待回调*/
    public static final String YC_ORDER_STATUS_2="2";
    /**跃程 订单状态3 收到回调，订单完成*/
    public static final String YC_ORDER_STATUS_3="3";
    /**跃程 订单状态4 订单已取消*/
    public static final String YC_ORDER_STATUS_4="4";
    /**跃程 订单状态5 订单错误取消 */
    public static final String YC_ORDER_STATUS_5="5";

    /**分销商编号作为redis KEY*/
    public static final String AGENT_MER_SEQ_REDIS_kEY="ODM_WEB_SET_AGENT_MER_SEQ:";

    /**分销商网站域名作为redis KEY*/
    public static final String WEB_URL_REDIS_kEY="ODM_WEB_SET:";

    /**http协议  odm中用 */
    public static final String HTTP_PROTOCOL_1 = "1";//http
    public static final String HTTP_PROTOCOL_2 = "2";//https
    /*******************************服务商品属性类型***************************/
    /**服务商品属性类型  默认类型  0*/
    public static final String SPECIFICATION_TYPE_DEFAULT ="0";
    /**服务商品属性类型  时间类型  1*/
    public static final String SPECIFICATION_TYPE_TIME ="1";
    /********************************时间单位***************************************/
    /** 时间单位  天*/
    public static final String SPECIFICATION_TIME_UNIT_DAY ="DAY";
    /** 时间单位  月*/
    public static final String SPECIFICATION_TIME_UNIT_MONTH ="MONTH";
    /** 时间单位  年*/
    public static final String SPECIFICATION_TIME_UNIT_YEAR ="YEAR";
    /***********************************************************************/
    
    /**蜂点邮箱服务地址*/
    public static final String EMAIL_HOST="smtp.beecredit.com";
    /**蜂点邮件用户名*/
    public static final String EMAIL_USER_NAME="service@beecredit.com";
    /**蜂点密码*/
    public static final String EMAIL_PASSWORD="Byzy2015"; /**邮箱服务地址*/

    /**壹通券邮箱服务地址*/
    public static final String YITONGQUAN_EMAIL_HOST="smtp.exmail.qq.com";
    /**壹通券邮件用户名*/
    public static final String YITONGQUAN_EMAIL_USER_NAME="service@yitongquan.cn";
    /**壹通券密码*/
    public static final String YITONGQUAN_EMAIL_PASSWORD="Byzy0730";
    
    /*******************************蜂点同步壹通券类型***************************/
    /**蜂点同步壹通券类型 企业信息   0*/
    public static final String FD_TO_YTQ_CHANGE_TYPE_0 ="0";
    /**蜂点同步壹通券类型 账号信息   1*/
    public static final String FD_TO_YTQ_CHANGE_TYPE_1 ="1";

    /**ODM蜂点权限标识   00001*/
    public static final String ODM_PRIVILEGE_FD ="00001";
    /**ODM小宝盒权限标识   00002*/
    public static final String ODM_PRIVILEGE_XBH ="00002";
    
    /**壹通券记录操作 1.生成*/
    public static final String DZBXK_CARD_STATUS_CREAT ="1";
    /**壹通券记录操作 2.绑定*/
    public static final String DZBXK_CARD_STATUS_BIND ="2";
    /**壹通券记录操作 3.转让*/
    public static final String DZBXK_CARD_STATUS_TRAN ="3";
    
    

    /**用户类型（0-企业，1-个人）*/
    public static final String ODM_USER_TYPE_0 = "0";
    public static final String ODM_USER_TYPE_1 = "1";
    /**系统类型（0-odm壹通券，1-odm壹通券推荐系统）*/
    public static final String ODM_SYS_TYPE_0 = "0";
    public static final String ODM_SYS_TYPE_1 = "1";
    
    /** 冻结状态（0-未冻结，1-冻结）  */
    public static final String FREEZE_STATUS_0 = "0";
    public static final String FREEZE_STATUS_1 = "1";

    /** userType 个人 */
    public static final String USER_TYPE_2 = "2";


    /*****************************字符串常量**********************************/
    /** success字符串 */
    public static final String STR_SUCCESS = "success";
    /** http 字符串 */
    public static final String STR_HTTP = "http";
    /** https 字符串 */
    public static final String STR_HTTPS = "https";
    /** true 字符串 */
    public static final String STR_TRUE = "true";

    /***********************************渠道编码开始***************************************/

    /** 默认的渠道编码 0 **/
    public static final String DEFAULT_CHANNEL_CODE = "0";

    /** 默认的渠道编码 00001 商城**/
    public static final String MALL_CHANNEL_CODE = "00001";

    /** 默认的渠道编码 00002 蜂惠 **/
    public static final String FH_CHANNEL_CODE = "00002";

    /***********************************渠道编码结束***************************************/
    /** fb商城 TOKEN前缀 **/
    public static final String FB_PERSONAL = "FB_PERSONAL_";
    
    /** 商城个人 TOKEN前缀 **/
    public static final String MALL_PERSONAL = "MALL_PERSONAL_";

    /** 蜂惠试用状态 0 : 试用中   1 : 已结束  2 : 暂停中 **/
    public static final String FH_TRYTOUT_STATUS_0 = "0";

    /** 蜂惠试用状态 0 : 使用中   1 : 已结束  2 : 暂停中 **/
    public static final String FH_TRYTOUT_STATUS_1 = "1";
    /** 蜂惠试用状态 0 : 使用中   1 : 已结束  2 : 暂停中 **/
    public static final String FH_TRYTOUT_STATUS_2 = "2";

    /** 商城购物车单个商品最大数量 **/
    public static final Integer SHOPPING_CAR_PRODUCT_MAX_COUNT = 999;

    /** 地址级别 ： 级别1 省级别 */
    public static final String ADDRESS_LEVEL_1 = "1";
    /** 地址级别 ： 级别2 市级别 */
    public static final String ADDRESS_LEVEL_2 = "2";
    /** 地址级别 ： 级别3 区级别 */
    public static final String ADDRESS_LEVEL_3 = "3";

    /** 福员外科目状态,商户科目关联关系状态  1:上架 **/
    public static final String FYW_INVOICEITEM_STATUS_ON = "1";
    /** 福员外科目状态,商户科目关联关系状态   2:下架 **/
    public static final String FYW_INVOICEITEM_STATUS_OFF = "2";
    
    /** 福员外商户是否推荐   1:已推荐 **/
    public static final String FYW_MERCHANT_IS_RECOMMENDED_1 = "1";
    /** 福员外商户是否推荐   0:未推荐 **/
    public static final String FYW_MERCHANT_IS_RECOMMENDED_0 = "0";
    
    /** 推荐类型：1:基于用户的协同过滤 **/
    public static final String FYW_RECOMMEND_TYPE_1 = "1";



    /** 严选售后申请单状态：1:	待审核 **/
    public static final Integer YX_AFS_STATUS_1 = 1;

    /** 严选售后申请单状态：2:待用户寄回 **/
    public static final Integer YX_AFS_STATUS_2 = 2;

    /** 严选售后申请单状态：3:用户已寄送 **/
    public static final Integer YX_AFS_STATUS_3 = 3;

    /** 严选售后申请单状态：4:退货成功 **/
    public static final Integer YX_AFS_STATUS_4 = 4;

    /** 严选售后申请单状态：5:客服审核不通过 **/
    public static final Integer YX_AFS_STATUS_5 = 5;

    /** 严选售后申请单状态：6:用户取消 **/
    public static final Integer YX_AFS_STATUS_6 = 6;

    /** 严选售后申请单状态：7:系统取消 **/
    public static final Integer YX_AFS_STATUS_7 = 7;

    /** 严选售后申请单状态：8:客服取消 **/
    public static final Integer YX_AFS_STATUS_8 = 8;

    /** 严选售后申请单状态：9:系统取消 **/
    public static final Integer YX_AFS_STATUS_9 = 9;

    /** 严选售后申请单状态：11:待客服确认 **/
    public static final Integer YX_AFS_STATUS_11 = 11;

    /**网站站点标识  1-PC端**/
    public static final String WEB_SITE_FLAG_1 = "1";
    
    /**网站站点标识 2-H5端**/
    public static final String WEB_SITE_FLAG_2 = "2";
    
    /**网站站点标识 3-APP端**/
    public static final String WEB_SITE_FLAG_3 = "3";
    
    /**网站站点**/
    public static final String WEB_SITE_FLAG = "WEB_SITE_FLAG_";

    /** 退款类型 01-售后退款**/
    public static final String REFUND_TYPE_01 = "01";

    /**退款类型 02-下单失败退款**/
    public static final String REFUND_TYPE_02 = "02";

    /**蜂惠banner位置id 011**/
    public static final String FH_LOCATION_ID = "011";
    /**商城banner位置id 020**/
    public static final String MALL_LOCATION_ID = "020";

    /** 登录账号开启状态 1：开启**/
    public static final String LOGIN_STATUS_OPEN = "1";

    /** 登录账号开启状态 0：关闭**/
    public static final String LOGIN_STATUS_CLOSE = "0";

    /** 蜂惠 TOKEN前缀 **/
    public static final String FH_ENTERPRISE = "FH_ENTERPRISE_";

    /** 登录账户类型：0-主账号 **/
    public static final String VIP_LOGIN_PRIMARY_ACCOUNT = "0";
    
    /** 登录账户类型：1-子账号 **/
    public static final String VIP_LOGIN_SUB_ACCOUNT = "1";

    /** 注册位置 0蜂点同步到模块 **/
    public static final String REGISTER_FLAG_FD = "0";
    /** 注册位置 1模块单独注册 **/
    public static final String REGISTER_FLAG_MODULE = "1";

    /** 企业登录位置 0蜂点登录到模块 **/
    public static final String LOGIN_FLAG_FD = "0";
    /** 企业登录位置 1模块单独登录 **/
    public static final String LOGIN_FLAG_MODULE = "1";

    /** 支付宝个人 TOKEN前缀 **/
    public static final String FYW_PERSONAL = "FYW_PERSONAL_";
    public static final String FYW_ENTERPRISE = "FYW_ENTERPRISE_";

    /** 支付宝 企业账户状态 0正常 1：未用 **/
    public static final String FYW_ACCOUNT_0 = "0";
    public static final String FYW_ACCOUNT_1 = "1";
    /** 子账号权限标识：0-普通子账号  1-分发子账号，2-采购子账号  **/
    public static final String FYW_LOGIN_POWER_0 = "0";
    public static final String FYW_LOGIN_POWER_1 = "1";
    public static final String FYW_LOGIN_POWER_2 = "2";
    
    /** 企业是否早支付宝存在  0 未存在,  1 已存在 **/
    public static final String FYW_EXIST_TYPE_0 = "0";
    public static final String FYW_EXIST_TYPE_1 = "1";
    
    /**支付宝banner位置id 234**/
    public static final String FYW_LOCATION_ID = "234";

    /** 模块是否ODM 0否 **/
    public static final String ODM_MODULE_STATUS_0 = "0";

    /** 模块是否ODM 1是 **/
    public static final String ODM_MODULE_STATUS_1 = "1";
    
    /** 模块没有移动端**/
    public static final String FD_APP_FLAG_NO = "0";
    /** 模块有移动端  **/
    public static final String FD_APP_FLAG_YES = "1";
    
    /** 模块域名统一  **/
    public static final String FD_URLSAME_FLAG_YES = "0";
    /** 模块域名不统一  **/
    public static final String FD_URLSAME_FLAG_NO = "1";

    /** 默认的地址编号 0 **/
    public static final Integer DEFAULT_ADDRESS_ID = 0;

    /** 内划算合同名称前缀 在线支付签章 **/
    public static final String PAY_DOCUMENT_PREFIX = "OXFQZ";
    
}
