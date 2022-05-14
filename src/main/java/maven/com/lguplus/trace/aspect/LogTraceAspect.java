package maven.com.lguplus.trace.aspect;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.trace.TraceStatus;

import maven.com.lguplus.trace.logtrace.LogTrace;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
            Object[] args = joinPoint.getArgs();

            message = getStringMessage( message, args );

//            System.out.println( "message = " + message );
            status = logTrace.begin( message );
            //로직 호출
            Object result = joinPoint.proceed();

            logTrace.end( status );

           // System.out.println( "result = " + result );


            return result;

        } catch (Exception e) {
            logTrace.exception( status, e );
            throw e;
        }
    }

    private String getStringMessage(String message, Object[] args) {


        String add_str="[";

        for (Object arg : args) {
          //  System.out.println( "arg = " + arg );
            add_str += arg;
        }
        add_str +="]";
        message = message + add_str;
        return message;
    }

    @Before("@annotation(maven.com.lguplus.trace.annotation.Trace_annotation)")
    public void doTrace(JoinPoint joinPoint){
        TraceStatus status = null;
        Object[] args = joinPoint.getArgs();
        String message = joinPoint.getSignature().toLongString();

        message = getStringMessage( message, args );

        status = logTrace.begin( message );

  //      log.info( "[trace] {} args={}", joinPoint.getSignature(), args );
    }
}