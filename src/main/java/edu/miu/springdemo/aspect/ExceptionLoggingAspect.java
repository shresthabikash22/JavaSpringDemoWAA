package edu.miu.springdemo.aspect;

import edu.miu.springdemo.entity.ExceptionLogger;
import edu.miu.springdemo.repo.ExceptionLoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Aspect
@Component
public class ExceptionLoggingAspect{
    @Autowired
    private ExceptionLoggerRepo exceptionLoggerRepo;

    @Pointcut("execution(* edu.miu.springdemo.controller.*.*(..))")
    public void allMethods(){

    }
    @AfterThrowing(pointcut = "allMethods()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        String methodName = joinPoint.getSignature().toShortString();
        String transactionId =  generateTransactionId();

        ExceptionLogger exceptionLogger = new ExceptionLogger();
        exceptionLogger.setTransactionId(transactionId);
        exceptionLogger.setDatetime(new Date());
        exceptionLogger.setPrinciple("THEFAKESTATICUSER");
        exceptionLogger.setOperation(methodName);
        exceptionLogger.setExceptionType(exception.getClass().getName());
        
        exceptionLoggerRepo.save(exceptionLogger);
    }

    private String generateTransactionId(){
        return UUID.randomUUID().toString();
    }
}
