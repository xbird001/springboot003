package com.springboot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava.Range;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;


@SpringBootConfiguration
public class EncodingConvertConfigeration {
	
	/**
	 * 在VM Arguments: -Dfile.encoding=UTF-8时进行装载
	 * @return
	 */
	@Bean
	@Conditional(value={UTF8Condition.class})
	public Runnable createUTF8EncodingConvert() {
		return () -> {};
	}
	
	/**
	 * 在VM Arguments: -Dfile.encoding=GBK时进行装载
	 * @return
	 */
	@Bean
	@Conditional(value={GBKCondition.class})
	public Runnable createGBKEncodingConvert() {
		return () -> {};
	}
	
	@Bean
	@ConditionalOnProperty(name={"tomcat.ip"},havingValue="127.0.0.1")
	public Runnable createProperties() {
		return () -> {};
	}
	
	
	@Bean
	@ConditionalOnClass(name={"com.google.gson.Gson"})
	public Runnable createGson() {
		return () -> {};
	}
	
	/**
	 * 当给定的bean中存在任一个时都返回true
	 * @return
	 */
	@Bean
	@ConditionalOnBean(name={"user","xx"})
	public Runnable createBeanUser() {
		return () -> {};
	}
	
	@Bean
	@ConditionalOnBean(type={"com.springboot.Person"})
	public Runnable createBeanPerson() {
		return () -> {};
	}
	
	@Bean
	@ConditionalOnMissingBean(type={"com.springboot.Xxx"})
	public Runnable createBeanXxx() {
		return () -> {};
	}
	
	/**
	 * 当JDK的版本大于或等于1.6时装配该bean
	 * @return
	 */
	@Bean
	@ConditionalOnJava(range=Range.EQUAL_OR_NEWER, value=JavaVersion.EIGHT)
	public Runnable createBeanOnJava() {
		return () -> {};
	}	
	
	
}
