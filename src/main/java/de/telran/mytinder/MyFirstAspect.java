package de.telran.mytinder;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyFirstAspect {
    //@Pointcut("execution(public void de.telran.mytinder.service.impl.RatingServiceImpl.shareRating(Long, Long, Integer))")
    @Pointcut("@annotation(jakarta.transaction.Transactional)")
    public void method() {}
    @Before("method()")
    public void doSomething() {
        System.out.println("Aspect is working, this is method shareRating");
    }
    @After("method()")
    public void doSomethingAfter() {
        System.out.println("Aspect is working, this is method shareRating after execution");
    }
}
