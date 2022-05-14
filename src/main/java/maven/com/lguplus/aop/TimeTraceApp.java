package maven.com.lguplus.aop;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.aop.exam.annotation.Trace;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

//@Component
@Aspect
@Slf4j
public class TimeTraceApp {

    @Around("execution(* maven.com.lguplus..*(..))")
    public Object execute(@NotNull ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        log.info("Start : function={}, args={},{}" ,joinPoint.getSignature().getName(),args, joinPoint.toString());

        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
           // log.info("END = function,{}, args{},{},{}, {}ms" ,joinPoint.getSignature().getName(),args, joinPoint.getSignature().toShortString(),joinPoint.toString() ,timeMs);
            log.info("END : function={}, args={},{}, {}ms" ,joinPoint.getSignature().getName(),args, joinPoint.toString() ,timeMs);
        }
    }


}
