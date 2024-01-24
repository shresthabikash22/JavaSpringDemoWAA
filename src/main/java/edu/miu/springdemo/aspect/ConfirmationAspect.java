package edu.miu.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConfirmationAspect {
    @Pointcut("@annotation(edu.miu.springdemo.aspect.annotation.Confirm)")
    public void confirmartionAnnotation(){}

    @After("confirmartionAnnotation()")
    public void confirmation(JoinPoint jointPoint){
        System.out.println("**********  "+jointPoint.getSignature().getName() + " function called");

    }

}
