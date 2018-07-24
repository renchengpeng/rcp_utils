/**
 * 
 */
package com.bee.sys.utils;

import com.bee.framework.i.bp.core.service.ServiceRegistry;
import com.bee.framework.i.bp.service.id.seq.StepSequenceFactory;
import com.bee.framework.ui.utils.IdWorker;

/**
 * @author fanzhm
 * @since 2012-12-28 工具类
 * 
 */
public class SeqNoUtil {

	/**
	 * 生产SEQ_NO
	 * 
	 * @param serviceId
	 */
	public static String createSeqNo(String serviceId) {
		StepSequenceFactory idFactory = ((StepSequenceFactory) SpringBeanUtil
				.getBean("serviceRegistry", ServiceRegistry.class).findService(
						serviceId));
		return idFactory.create().toString();
	}
	
	/**
	 * 
	 * 获取非数据库唯一标识，不同数据中心一台机器一个应用一个业务
	 * @author john.lh
	 * 2016年4月16日
	 * @param workerId  机器ID标识
	 * @param datacenterId 数据中心标识
	 * @return
	 */
	public static long getSeqNo(IdWorker idWorker){
	    return idWorker.nextId();
	}
}
