/*@(#)ParamKeys.java   Jun 17, 2012
 *   
 * Copy Right 2012 Bank of Communications Co.Ltd. 
 * All Copyright Reserved
 */
package com.bee.utils.common;

/**
 * <p>
 * All the parameters key should define under this interface.
 * 
 */
public interface ParamKeys {
	
	// ORDERS表中的seqNo对应的serviceId
	public static final String SHANMALL_ORDERS_SEQ_NO = "SMOrdersService";
	// ORDERINFO表中的seqNo对应的serviceId
	public static final String SHANMALL_ORDERINFO_SEQ_NO = "SMOrderInfoService";
	
	// ORDERS表中的seqNo对应的serviceId
	public static final String FEIYU_ORDERS_SEQ_NO = "FYOrdersService";
	// ORDERINFO表中的seqNo对应的serviceId
	public static final String FEIYU_ORDERINFO_SEQ_NO = "FYOrderInfoService";

	// SHOPPING-CAT表中的seqNo对应的serviceId
	public static final String SHOPPING_CART_SEQ_NO = "ShoppingCartService";
	
	public static final String DZBXK_TRAN_HISTORY_SEQ_NO = "DZBXKTranHistoryService";

	// Employee表中的custSeq对应的serviceId
	public static final String CUST_SEQ_NO = "EmployeeInfoService";
	
	public static final String DZBXK_AC_BAL_HIS_SEQ_NO = "DZBXKAcBalHisNoService";
	
	//IpForBackUps
	public static final String IP_SEQ = "IpForBackUpService";
	
	
	// product表中的PRD_SEQ对应的serviceId
	public static final String PRD_SEQ = "ProductInfoService";

	// Enterprise表中的ENTERPRISE_SEQ对应的serviceId
	public static final String ENTERPRISE_SEQ_NO = "EnterpriseInfoService";
	
	// MERCHANT表中的MERCHANT_SEQ对应的serviceId
	public static final String ADVANCE_MER_SEQ_NO = "AdvanceMerService";
	//INVOICE_APPLY表中的INVOICE_APPLY_SEQ对应的serviceId
	public static final String INVOIDE_APPLY_SEQ_NO = "InvoiceApplyService";
	
	/**
	 * 预付商户银行信息
	 */
	public static final String MER_BANK_AC_SEQ_NO = "MerBankAcService";

	//支付订单编号
	public static final String PAY_ORDER_SEQ_NO = "PayOrderService";
	
	public static final String PAY_ORDER_CHECK_SEQ_NO = "PayOrderCheckService";

	public static final String INVOICE_PRODUCT_SEQ_NO = "InvoiceProductService";


	public static final String ROLE_SEQ_NO = "RoleService";

	public static final String PRIVILEGE_SEQ_NO = "PrivilegeService";

	// 菜单表序号(RESOURCE) RESOURCE_ID对应
	public static final String RESOURCE_SEQ_NO = "MenuService";
	//微信通知
	public static final String WECHAT_NOTICE_MANAGE_SEQ_NO = "WechatNoticeManageService";
	
	public static final String WEBRESOURCE_SEQ_NO = "WebMenuService";
	
	// 模块表序号(RESOURCE) MODULE_SEQ_NO对应
    public static final String MODULE_SEQ_NO = "MoudleTableService";


	public static final String CUST_AC_SEQ_NO = "CustAcNoService";
	public static final String PROVISION_AC_SEQ_NO = "ProvisionAccountService";
	
	public static final String USER_MSG_RECEIVE_No = "UserMsgReceiveService";
	
	//users表对应的USER_ID
	public static final String USERS_SEQ_NO = "UsersService";
	
	// DiscountActivity表中的ID对应的serviceId
	public static final String DISCOUNT_ACTIVITY_SEQ_NO = "DiscountActivityService";
	
	//优惠券COUPON表对应的COUPON_BATCH_NO
	public static final String COUPON_SEQ_NO = "CouponService";
	public static final String COUPONINFO_SEQ_NO = "CouponInfoService";
	public static final String GIFTPACKAGE_SEQ_NO = "GiftPackageService"; 
	public static final String GIFTCUSTOMER_SEQ_NO = "GiftCustomerService";
	
	public static final String REFUND_ORDERS_SEQ_NO = "RefundOrdersService";
	
	public static final String YTQ_REFUND_ORDERS_SEQ_NO = "YtqRefundOrdersService";
	//手机充值
	public static final String PHONE_RECHARGE_SEQ_NO="PhoneRechargeService";
	//部门
	public static final String DEPARTMENT_SEQ_NO="DepartmentService";
	//商品类别
	public static final String PRD_TYPE_SEQ_NO="PrdTypeService";
	//用户详细信息
	public static final String PERSONALCUSTOMER_SEQ_NO = "PersonalCustomerService";
	//用户开户充值错误数据表
	public static final String REGISTER_RECHARGE_SEQ_NO="RegisterRechargeService";
	//开户充值序列号
	public static final String BATCH_FILE_NO_SEQ_NO="BatchFileNoService";
	//转账记录
	public static final String TRANSFER_HISTORY_SEQ_NO="TransferHistoryService";
	//推广用户
	public static final String SPREAD_USER_SEQ_NO = "SpreadUserService";
	//费率 - 蜂管家中
	public static final String FEERATE_SEQ_NO="FeeRateService";
	// 电子报销ka
	public static final String DZBXK_CARD_SEQ_NO = "DzbxkCardService";
	//企业预付订单
	public static final String VIP_ORDER_ADVANCE_SEQ_NO="VipOrderAdvanceService";
	public static final String SUB_VIP_ORDER_ADVANCE_SEQ_NO="SubVipOrderAdvanceService";
	//奖励记录
	public static final String BONUS_HIS_SERVICE="BonusHisService";
	
	//支付宝转让信息流水号
	public static final String ALIPEY_TRANSFER_SEQ_NO = "AliPayTransferService";
	//蜂采商城协议编号
	public static final String APPLICATION_NO_SEQ_NO = "ApplicatioNoService";
	
	//新商户系统编号
	public static final String MERCHANT_NO="MerchantService";
	
	//api商户系统编号
    public static final String API_MERCHANT_NO="ApiMerchantService";
    
    // 推荐商品编号
    public static final String PRODUCT_RECOMMEND_SEQ="ProductRecommendService";
	
	//新商户 用户id
    public static final String MERCHANTUSER_SEQ="MerLoginService";
    
    //新商户  快递编码
    public static final String EXPRESS_SEQ="DeliverService";
   
    //限额规则主键生成
    public static final String CONS_QUOTA_NO="ConsQuotaService";
    
    // FQB_NO对应的serviceId
    public static final String FQB_NO= "FQBNoService";
    
    // FPAYTranHistoryService对应的serviceId
    public static final String FPAY_TRAN_NO= "FPAYTranHistoryService";
    // ProvisionTranHistoryService对应的serviceId
    public static final String PROVISION_TRAN_NO= "ProvisionTranHistoryService";
    
    //新消息推送消息编号
  	public static final String MESSAGE_ID="MessageService";
  	public static final String MESSAGE_ID_MI="messageServiceMi";
  	public static final String MESSAGE_ID_ADV="messageServiceAdv";
    //优惠使用记录
    public static final String COUPON_USEINFO_SEQ="CouponUseInfoService";

    //蜂采订单记录
    public static final String VIP_ORDER_SEQ_NO="VipOrderService";
    
    //蜂采子订单记录
    public static final String VIP_ORDER_DETAIL_SEQ_NO="VipOrderDetailService";
    
    //购物车主键
    public static final String VIP_SHOPPING_SEQ_NO="VipShoppingCarService";
    
    //个人收货地址主键编号
    public static final String P_DELIVER_ADDRESS_SEQ_NO="PersonDeliverAddressService";
    //企业收货地址主键编号
    public static final String E_DELIVER_ADDRESS_SEQ_NO="EnterpriseDeliverAddressService";
    //折付宝购物车主键
    public static final String Z_SHOOPING_CAR_SEQ="ZShoppingCarService";
    //折付宝足迹主键编号
    public static final String FOOT_MARK_SEQ_NO="FootMarkService";
    //收藏店铺的主键
    public static final String COLLECT_MER_SEQ_NO="CollectMerService";
    //收藏宝贝的主键
    public static final String COLLECT_PRD_SEQ_NO="CollectProductService";
    
    //蜂贝 订单编号
    public static final String FB_ORDERS_NO="FbOrdersService";
    //蜂贝 订单详情 编号
    public static final String FB_ORDERINFO_NO="FbOrderInfoService";
    
    //预付商户限额
    public static final String LIMIT_SEQ="MerchantLimitAmtService";
    
    //API限额交易记录
    public static final String API_LIMIT_TRAN_NO="ApiLimitTranHistoryService";
    //API商户限额
    public static final String API_LIMIT_SEQ="ApiMerchantLimitAmtService";
    
    //蜂通卡Tran历史
    public static final String FQB_TRAN_HISTORY_SEQ  = "FQBTranHistoryService";
    //蜂通卡AcBal历史
    public static final String FQB_AC_BAL_HIS_SEQ  = "FQBAcBalHistoryService";
    //蜂通卡转账历史
    public static final String FQB_TRANSFER_HIS_SEQ  = "FQBTransferHisService";
    //折付宝评论快递批次号
    public static final String MER_DELIVER_COMMENT_SEQ_NO = "MerDeliverCommentService";
    //折付宝评论商品批次号
    public static final String PRD_COMMENT_SEQ_NO = "PrdCommentService";
    
    //抽奖系统
    public static final String MARKET_ACTIVITY_SEQ_NO = "MarketActivityService";
    
    // 蜂点商户登录
    public static final String FD_MERCHANTUSER_SEQ = "FdMerLoginService";
    // 蜂点商户信息
    public static final String FD_MERCHANT_NO = "FdMerchantService";
    
    //蜂点新系统  企业注册 ENTERPRISE_INFO表
 	public static final String ENTERPRISE_FENGDIAN_SEQ_NO = "EnterpriseFengDianInfoService";
 	
 	// 折付宝预付额度主键
    public static final String Z_ADVANCE_SEQ_NO = "AdvanceLimtService";
    // 折付宝预付额度交易记录表主键
    public static final String Z_ADVANCE_LIMIT_TRAN_HIS_SEQ_NO = "AdvanceLimtTranHisService";
    
    //申请售后记录ID
    public static final String AFS_SERVICE_APPLY_SEQ = "AfsServiceApplySeq";
    public static final String AFS_SERVICE_APPLY_SEQ_SM = "afsServiceApplySeqSM";
    
    //信用额度变更记录
    public static final String ADVANCE_LIMIT_HIS_SEQ_NO = "AdvanceLimtHisService";
    
  //DZBXKBatchHistory表中的seqNo对应的serviceId
    public static final String BATCH_SEQ_NO = "ResaleDZBXKBatchHistoryService";
    //心愿支行
    public static final String EXPECTBANKBRANCH_SEQ_NO = "ExpectBankBranchService";
    
    // 蜂贝心愿商品主键ID
    public static final String FB_THIRD_PRODUCT_ID = "ThirdProductService";
    
    //还款记录ID
    public static final String ADVANCE_LIMIT_REPAY_HIS_SEQ_NO = "AdvanceLimtRepayHisService";
    
    //还款记录第三方
    public static final String ADVANCE_LIMIT_REPAY_HIS_KFT_SEQ_NO = "AdvanceLimtRepayHisKftService";
    
    //蜂贝退款记录编号
    public static final String FB_REFUND_HIS_RE_NO = "RefundHisService";
    //蜂采退款记录编号
    public static final String FH_REFUND_HIS_RE_NO = "FHRefundHisService";
    
    //楼层小商品
    public static final String FLOOR_PRODUCT_SEQ_NO="FloorProductService";

    //资源
    public static final String ORGANIZE_RESOURCES_SEQ_NO="OrganizeResourcesService";
    
    public static final String ORGANIZE_PRIVILEGES_NO="OrganizePrivilegesService";
    
    
    //组织机构角色编号
    public static final String ORGANIZE_ROLES_SEQ_NO = "OrganizeRolesService";
    
    public static final String ORGANIZE_POSITION_SEQ_NO="OrganizePositionService";
    //Activity
    public static final String ACTIVITY_SEQ_NO="ActivityService";
    //ActivityUser抽奖活动用户信息表主键
    public static final String ACTIVITY_USER_SEQ_NO="ActivityUserService";
    //Award
    public static final String AWARD_SEQ_NO="ActivityAwardService";
    //Banner
    public static final String BANNER_SEQ_NO="BannerService";
    //Notice(公告)
    public static final String NOTICE_SEQ_NO="NoticeService";
    //ImgUpload
    public static final String UPLOADIMG_SEQ_NO="UploadImgService";
    
    //部门
    public static final String ORGANIZE_DEPARTMENT_SEQ_NO="OrganizeDepartmentService";
    
    public static final String BATCH_REGISTER_SEQ_NO = "BatchRegisterService";
    
    public static final String VIP_PRD_APPLY_NO =  "VipPrdApplyService";
    
    public static final String TRAN_NO =  "TranNoService";
    
    public static final String VIP_WELFARE_ORDERS_NO="VipWelfareOrdersService";
    
    public static final String VIP_WELFARE_ORDERS_INFO_NO="VipWelfareOrderInfoService";
    
    public static final String OPEN_BILLING_SEQ_NO="OpenBillingService";
 
    public static final String VIP_LOGIN_SEQ_NO="VipLoginService";
    
    //关键字
    public static final String KEYWORD_INVOICE_ITEM_SEQ_NO="KeyWordInvoiceItemService";
    
    public static final String VIP_PRD_STATUS_SEQ_NO="VipPrdStatusService";
    
    public static final String VIP_MODEL_RELATION_SEQ_NO="VipModelRelationService";
    
    //订单结算
    public static final String ORDER_SETTLEMENT_CHECK_SEQ_NO = "OrderSettlementCheckService";
    
    //魔钥相关
    public static final String VIP_APPLY_CUPBOARD_HIS_SEQ_NO = "VipApplyCupboardHisService";
    public static final String CUP_AFTER_SALE_SERVICE_HIS_SEQ_NO = "CupAfterSaleServiceHisService";
    public static final String GOODS_USE_APPLY_SEQ_NO = "GoodsUseApplyService";
    public static final String GOODS_RFID_USE_HIS_SEQ_NO = "GoodsRfidUseHisService";
    public static final String GOODS_INFO_SEQ_NO = "GoodsInfoService";
    public static final String GOODS_APPLY_DETIAL_SEQ_NO = "GoodsApplyDetialService";
    public static final String WORKFLOW_DESIGN_SEQ_NO="WorkflowDesignService";
    public static final String GOODS_STORE_HIS_SEQ_NO="GoodsStoreHisService";
    public static final String GOODS_EXCEPTION_INFO_SEQ_NO="GoodsExceptionInfoService";
    public static final String PERSONAL_EXCEPTION_INFO_SEQ_NO="PersonalExceptionInfoService";//20180810 xyd
    public static final String CUPBOARD_OPEN_HIS_SEQ_NO="CupboardOpenHisService";
    public static final String DELAY_USE_APPLY_SEQ_NO="DelayUseApplyService";
    public static final String CABINET_DOOR_INFO_SEQ_NO="CabinetDoorInfoService";
    public static final String CUPBOARD_STORE_HIS_SEQ_NO="CupboardStoreHisService";
    public static final String RFID_SEQ_NO="RfidService";
    public static final String RFID_STORE_HIS_SEQ_NO="RfidStoreHisService";
    public static final String VIP_CUPBOARD_RELATION_SEQ_NO="VipCupboardRelationService";
    public static final String CUPBOARD_BATCH_HIS_SEQ_NO="CupboardBatchHisService";
    public static final String CUPBOARD_SEQ_NO="CupboardService";
    public static final String RFID_STORE_BATCH_HIS_SEQ_NO="RfidStoreBatchHisService";
    public static final String CUPBOARD_REVISE_HIS_SEQ_NO="CupboardReviseHisService";
    public static final String ADVERTISING_PICTURES_SEQ_NO="AdvertisingPicturesService";
    public static final String ADVERTISEMENT_SEQ_NO="AdvertisementService";
    public static final String ADVERTISEMENT_DETAILS_SEQ_NO="AdvertisementDetailsService";
    public static final String REVISE_REALMNAME_HIS_SEQ_NO="ReviseRealmnameHisService";
    public static final String PUBLIC_ADV_HIS_SEQ_NO="PublicAdvHisService";
    public static final String REVISE_WARN_TIME_HIS_SEQ_NO="ReviseWarnTimeHisService";
  	public static final String MOYAO_DEPARTMENT_SEQ_NO="MoyaoDepartmentService";
  	public static final String MOYAO_ROLE_SEQ_NO = "MoyaoRoleService";
	public static final String MOYAO_PRIVILEGE_SEQ_NO = "MoyaoPrivilegeService";
	public static final String MOYAO_RESOURCE_SEQ_NO = "MoyaoMenuService";
	public static final String MOYAO_USERS_SEQ_NO = "MoyaoUsersService";
	public static final String MOYAO_PERSONALCUSTOMER_SEQ_NO = "MoyaoPersonalCustomerService";
	public static final String MOYAO_ENTERPRISE_SEQ_NO = "MoyaoEnterpriseService";
	public static final String MOYAO_VIP_LOGIN_SEQ_NO="MoyaoVipLoginService";
	public static final String PERSONAL_APPLY_SEQ_NO="PersonalApplyService";
	public static final String MOYAO_ORGANIZE_DEPARTMENT_SEQ_NO="MoyaoOrganizeDepartmentService";
	public static final String NEWS_PUSH_SEQ_NO="NewsPushService";
	public static final String APP_VERSION_SEQ_NO="AppVersionService";//20180730 xyd 魔钥版本表
	//福员外相关
    public static final String FYW_ACCOUNT_SEQ_NO="FywAccountService";
    public static final String FYW_FILE_BATCH_HISTORY_SEQ_NO="FywFileBatchHistoryService";
    public static final String FYW_INVOICE_ITEM_SEQ_NO="FywInvoiceItemService";
    public static final String FYW_INVOICE_ORDERS_SEQ_NO="FywInvoiceOrdersService"; 
    public static final String FYW_MERCHANT_SEQ_NO="FywMerchantService"; 
    public static final String FYW_REGISTER_RECHARGE_SEQ_NO="FywRegisterRechargeService"; 
    public static final String FYW_TRAN_HISTORY_SEQ_NO="FywTranHistoryService"; 
    public static final String FYW_ACTIVITY_NO="FywActivityService";
    public static final String FYW_SUBSIDY_SEQ="FywSubsidyService";
    public static final String FYW_DAILY_CHECK_SEQ="FywDailyCheckService";
    
    public static final String THIRD_LOGIN_ACCOUNT_SEQ_NO="ThirdLoginAccountService"; 
    
    public static final String REPEAT_PAY_ORDER_SEQ_NO="RepeatPayOrderService"; 
    
    // 意向客户信息
    public static final String FD_INTENTIO_VIP = "FdIntentioVipService";
    // 意向客户批次
    public static final String FD_INTENTIO_VIP_BATCH_NUM = "FdIntentioVipBatchNumService";
    // CRM客户操作记录
    public static final String CRM_VIP_OPERATOR_NUM = "CrmVipOperatorNumService";
    // CRM客户等级
    public static final String FD_INTENTION_LEVEL_NUM = "FdIntentionLevelNumService";
    
    
    // 呼叫中心编号
    public static final String CALL_CENTER_SEQ_NO = "CallCenterService";
    // 忙猫相关 start
    public static final String PRODUCT_COMMENT_SEQ_NO="ProductCommentService";
    public static final String VIEW_SEQ_NO="BannerHisService";
    public static final String BANK_CARD_SEQ_NO="BanksCardService";
    public static final String PRD_BRAND_SEQ_NO="PrdBrandService";
    public static final String PRD_TYPE_CODE_NO="PrdTypeService";
    //分销商编号
    public static final String AGENT_MER_SEQ= "AgentMerService";
    //分销商登陆信息编号
    public static final String AGENT_MER_LOGIN_SEQ= "AgentMerLoginService";
    //蜂惠banner编号
    public static final String FH_BANNER_SEQ_NO= "FhBannerService";
    //蜂惠订单编号
    public static final String FH_ORDERS_SEQ_NO= "FhOrdersService";
    //峰惠对账记录编号
    public static final String SETTLEMENT_NO="SettkementHisService";
 
    public static final String AGENT_ACCOUNT_NO="AgentVirAccountService";
    
    public static final String FH_PRODUCT_NO="FhProductService";
    
    public static final String RECORD_SEQ_NO="FdChangeRecordService";
    
    public static final String PRD_SKU_NO="productSkuNoService";
    //发票记录编号
    public static final String INVOICE_INF_HIS_SEQ_NO= "InvoiceInfHisService";
    
    //合同
    public static final String CONTRACT_SEQ_NO="ContractService";
    //合同模板
    public static final String CONTRACT_TEMPLATE_SEQ_NO="ContractTemplateService";
    
    //分成策略编号
    public static final String REBATE_STRATEGY_SEQ_NO= "RebateStrategyService";
    
    //跃程订单编号
    public static final String YC_ORDER_SEQ_NO="YcOrderService";
    
    //跃程充值产品编号
    public static final String YC_PRODUCT_SEQ_NO="YcProductService";
    
    //操作指南编号
    public static final String ODM_OPERATION_GUIDE_SEQ_NO="OperationGuideOdmService";
}
