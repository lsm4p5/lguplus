package maven.com.lguplus.trace.aspect;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.trace.TraceStatus;
import maven.com.lguplus.trace.logtrace.LogTrace;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogTraceAspect {

    private final LogTrace logTrace;

    public LogTraceAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    @Around("execution(*  maven.com.lguplus.api.controller..*(..)) || execution(*  maven.com.lguplus.service..*(..)) || execution(*  maven.com.lguplus.repository..*(..)) ||execution(*  maven.com.lguplus.controller..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        TraceStatus status = null;

        try {
            //String message = joinPoint.getSignature().toShortString();
            String message = joinPoint.getSignature().toLongString();
//            System.out.println( "message = " + message );
//            System.out.println( "joinPoint.getName() = " + joinPoint.getArgs().toString() );

            status = logTrace.begin( message );
            //로직 호출
            Object result = joinPoint.proceed();

            logTrace.end( status );


            return result;

        } catch (Exception e) {
            logTrace.exception( status, e );
            throw e;
        }
    }
}
