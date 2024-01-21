package edu.miu.springdemo.aspect;

import edu.miu.springdemo.entity.Logger;
import edu.miu.springdemo.repo.LoggerRepo;
import jakarta.persistence.criteria.Join;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Autowired
    private LoggerRepo loggerRepo;

    @Pointcut("@annotation(edu.miu.springdemo.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){    }

    @Around("executionTimeAnnotation()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.nanoTime();
        Object result = proceedingJoinPoint.proceed();

        long endTime = System.nanoTime();
        long executionTime = endTime-startTime;

        logToDatabase(proceedingJoinPoint,executionTime);

        return result;
    }

    private void logToDatabase(JoinPoint joinPoint,long executionTime){
        String methodName = joinPoint.getSignature().toShortString();
        String transactionId = generateTransactionId();

        Logger logger =  new Logger();
        logger.setTransactionId(transactionId);
        logger.setDatetime(new Date());
        logger.setPrinciple("THEFAKESTATICUSER");
        logger.setOperation(methodName+" - Execution Time: "+ executionTime);
        loggerRepo.save(logger);

    }

     private String generateTransactionId(){
        return UUID.randomUUID().toString();
     }
}
