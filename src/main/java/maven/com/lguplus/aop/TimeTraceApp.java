package maven.com.lguplus.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Aspect
@Slf4j
public class TimeTraceApp {

    @Around("execution(* com.lguplus..*(..))")
    public Object execute(@NotNull ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("start = {}" , joinPoint.toString());

        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            log.info("END = {} {}ms" ,joinPoint.toString() , timeMs);
        }
    }


}
