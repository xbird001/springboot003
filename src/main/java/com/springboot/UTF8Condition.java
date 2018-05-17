package com.springboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class UTF8Condition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encoding = System.getProperty("file.encoding");
		if("UTF-8".equals(encoding.toUpperCase())) {
			return true;
		}
		return false;
	}

}
