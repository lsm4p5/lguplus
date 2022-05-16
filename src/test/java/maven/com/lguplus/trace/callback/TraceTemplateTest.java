package maven.com.lguplus.trace.callback;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.trace.logtrace.LogTrace;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class TraceTemplateTest {

    @Autowired
    LogTrace logtrace;

//    private static String call() {
//        log.info( "callbak Call" );
//        return null;
//    }

    @Test
    void traceTemplate(){

        String message = "Test Message";
        TraceTemplate template = new TraceTemplate(logtrace);


        Object call_callback = template.execute( message, new TraceCallback<Object>() {
            @Override
            public Object call() {
                log.info( "call callback" );
                return "OK";
            }
        } );

        System.out.println( "call_callback = " + call_callback );

    }

}