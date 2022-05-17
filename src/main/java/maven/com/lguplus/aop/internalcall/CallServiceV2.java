package maven.com.lguplus.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.Application;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class CallServiceV2 {

   // private final ApplicationContext applicationContext;
    private final ObjectProvider<CallServiceV2> callServiceV2Provider;

    public CallServiceV2(ObjectProvider<CallServiceV2> callServiceV2Provider) {
        this.callServiceV2Provider = callServiceV2Provider;
    }

    public void external() {
        log.info( "call external" );
        CallServiceV2 callServiceV2 = callServiceV2Provider.getObject();
//        CallServiceV2 callServiceV2 = applicationContext.getBean( CallServiceV2.class );
        callServiceV2.internal(); // 내부 메서드 호출(this.internal)

    }

    public void internal() {

        log.info( "call internal" );
    }
}
