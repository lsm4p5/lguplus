package maven.com.lguplus.aop.internalcall.aop;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.aop.internalcall.CallServiceV0;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


@Slf4j
@Import( CallLogAspect.class )
@SpringBootTest
class CallLogAspectTest {

    @Autowired
    CallServiceV0 callServiceV0;

    @Test
    void external() {
       // log.info("target={}", callServiceV0);
        callServiceV0.external();


    }

    @Test
    void internal() {

        callServiceV0.internal();

    }

}