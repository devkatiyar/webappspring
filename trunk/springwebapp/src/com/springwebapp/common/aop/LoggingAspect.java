package com.springwebapp.common.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	private final Log log = LogFactory.getLog(LoggingAspect.class);

	/*
	 * 
	 * @Around("execution(* com.springwebapp.user..*.*(..))") public Object
	 * logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
	 * 
	 * StopWatch stopWatch = new StopWatch(); stopWatch.start();
	 * 
	 * Object retVal = joinPoint.proceed();
	 * 
	 * stopWatch.stop();
	 * 
	 * StringBuffer logMessage = new StringBuffer();
	 * logMessage.append(joinPoint.getTarget().getClass().getName());
	 * logMessage.append(".");
	 * logMessage.append(joinPoint.getSignature().getName());
	 * logMessage.append("("); // append args Object[] args =
	 * joinPoint.getArgs(); for (int i = 0; i < args.length; i++) {
	 * logMessage.append(args[i]).append(","); } if (args.length > 0) {
	 * logMessage.deleteCharAt(logMessage.length() - 1); }
	 * 
	 * logMessage.append(")"); logMessage.append(" execution time: ");
	 * logMessage.append(stopWatch.getTotalTimeMillis());
	 * logMessage.append(" ms"); log.info(logMessage.toString()); return retVal;
	 * }
	 * 
	 * @Before("execution(* com.springwebapp..*.*.*(..))") public void
	 * logBeforeMethod(JoinPoint joinPoint) { log.info("Join point kind : " +
	 * joinPoint.getKind()); log.info("Signature declaring type : "+
	 * joinPoint.getSignature().getDeclaringTypeName());
	 * log.info("Signature name : " + joinPoint.getSignature().getName());
	 * log.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
	 * log.info("Target class : "+ joinPoint.getTarget().getClass().getName());
	 * log.info("This class : " + joinPoint.getThis().getClass().getName());
	 * 
	 * }
	 */

	@Pointcut("execution(* com.springwebapp..*.*.*(..))")
	//@Pointcut("execution(* com.springwebapp..*(..))")
	public void allMethods() {
	}

	@Around("allMethods()")
	public Object profile(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		long start = System.currentTimeMillis();
		StringBuffer logMessage = new StringBuffer();
		logMessage.append(proceedingJoinPoint.getTarget().getClass().getName());
		logMessage.append(".");
		logMessage.append(proceedingJoinPoint.getSignature().getName());
		logMessage.append("(");
		// append args
		Object[] args = proceedingJoinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			logMessage.append(args[i]).append(",");
		}
		if (args.length > 0) {
			logMessage.deleteCharAt(logMessage.length() - 1);
		}
		logMessage.append(")");
		log.info("===Start execution "+ proceedingJoinPoint.getSignature().getName() + "===");
		log.info(logMessage.toString());
		Object output = proceedingJoinPoint.proceed();
		log.info("===End Execution "+ proceedingJoinPoint.getSignature().getName() + "===");
		
		return output;
	}

}
