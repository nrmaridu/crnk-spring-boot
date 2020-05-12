package com.practice.crnk.exception.mappers;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.NoDataFoundException;
import org.jooq.exception.TooManyRowsException;
import org.springframework.stereotype.Component;

import io.crnk.core.exception.InternalServerErrorException;
import io.crnk.core.exception.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;

/**
 * @author nrmaridu
 * @since May 12, 2020
 */
@Aspect
@Component
@Log4j2
public class ExceptionMapperAspect {

    @AfterThrowing(pointcut = "execution(* com.practice.crnk.dao..*(..))", throwing = "ex")
    public void handleException(Exception ex) throws Throwable {
        if (ex instanceof NoDataFoundException) {
            throw new ResourceNotFoundException("resource not found");
        } else if (ex instanceof DataAccessException || ex instanceof TooManyRowsException) {
            throw new InternalServerErrorException("Failed to process the request");
        }
    }


    /*@After(value = "execution(* com.practice.crnk.dao.UniversityDao.findOne())")
    public void handle() {
        log.debug("Method executed");
    }

    @Around("within(com.practice.crnk.dao.UniversityDao)")
    public Object intercept(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Entered");
        Object result = joinPoint.proceed();
        System.err.println(joinPoint.toShortString() + ": " + result);
        return result;
    }*/
}
