package com.bee.sys.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;

/**
 * <P>
 * TODO
 * </P>
 * 
 * @version 1.0
 * @author "john.lh"
 */
@Lazy(value = true)
public class SpringBeanUtil implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringBeanUtil.applicationContext = applicationContext;
	}

	@Override
	public void destroy() throws Exception {
		applicationContext = null;
	}

	/**
	 * 
	 * <p>
	 * 依据beanName 获取Bean对象
	 * </p>
	 * 
	 * @param beanName
	 * @return
	 * @author "john.lh"
	 */
	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	/**
	 * 
	 * <p>
	 * 依据beanName和Class类型获取bean对象
	 * </p>
	 * 
	 * @param beanName
	 * @param clazz
	 * @return
	 * @author "john.lh"
	 */
	public static <T> T getBean(String beanName, Class<T> clazz) {
		return applicationContext.getBean(beanName, clazz);
	}
}
