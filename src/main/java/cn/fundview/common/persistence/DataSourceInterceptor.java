package cn.fundview.common.persistence;

import org.aspectj.lang.ProceedingJoinPoint;
public class DataSourceInterceptor {

	//@Around("execution(* cn.fundview.setting.dao.**.*.*(..))")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("aaaa");
        if (jp.getTarget() instanceof DataSourceTwoDao) {
            CustomerContextHolder.setContextType("dataSource1");
        } else{
        	CustomerContextHolder.setContextType("dataSource2");
        }
        return jp.proceed();
    }

}
