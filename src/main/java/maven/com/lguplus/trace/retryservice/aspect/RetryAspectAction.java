package maven.com.lguplus.trace.retryservice.aspect;



import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.aop.exam.annotation.Retry;
import maven.com.lguplus.trace.TraceStatus;
import maven.com.lguplus.trace.logtrace.LogTrace;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RetryAspectAction {

    private final LogTrace logTrace;

    public RetryAspectAction(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    // @Around("@abbitatuib(maven.lguplus.aop.exam.annotation.Retry)")
  //  c
  //  @Around( "@annotation(maven.com.lguplus.trace.retryservice.annotation.Retryannotation)" )
    @Around("@annotation(retry)")
    public Object doRetry2(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        TraceStatus status = null;
        Exception exceptionHolder = null;

        try {
           // log.info( "[retry] {} retry={}", joinPoint.getSignature(), retry );
            int maxRetry = retry.value();
            Object[] args = joinPoint.getArgs();
            String message = getStringMessage( joinPoint.getSignature().toLongString(), args );
            message +=  "retryMax=["+ retry +"]";

            for (int retryCount = 1; retryCount <= maxRetry; retryCount++) {
                try {
                    //log.info( "[retry] try count={}/{}", retryCount, maxRetry );
                    String message_input = message + "try count = " +retryCount +"/" + maxRetry;
                    status = logTrace.begin( message_input );
                    Object result = joinPoint.proceed();
                    logTrace.end(status);
                    return result;
                } catch (Exception e) {
                    exceptionHolder = e;
                    logTrace.exception(status, e );
                }
            }
            throw exceptionHolder;
        } catch (Exception e2) {
            logTrace.exception(status, e2 );
            e2.printStackTrace();
            throw e2;
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

}
