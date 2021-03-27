package com.ljp.monitor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserMonitor {

	private final Log logger = LogFactory.getLog(this.getClass());

	@Around("execution(public * com.ljp.controller.UserController.*(..))")
	public Object Interceptor(ProceedingJoinPoint pjp) {
		Object result = null;
		Object[] args = pjp.getArgs();
		StringBuilder stringBuilder = new StringBuilder(pjp.getSignature().toShortString()+"->");
		if (args != null && args.length > 0) {
			for (int i=0;i<args.length;i++) {
				if(args[i]!=null) {
					stringBuilder.append("arg"+i+":"+args[i].toString()+";");
				}else {
					stringBuilder.append("arg"+i+":null;");
				}
			}
		}else {
			stringBuilder.append("args:null;");
		}
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			stringBuilder.append("run err:"+e.getStackTrace());
		}
		if(result!=null) {
			stringBuilder.append("result:"+result.toString());
		}
		Monitor.incream(pjp.getSignature().toShortString());
		logger.debug(stringBuilder.toString()+Monitor.str());
		return result;
	}

}
