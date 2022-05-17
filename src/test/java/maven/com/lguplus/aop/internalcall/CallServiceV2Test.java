package maven.com.lguplus.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.aop.internalcall.aop.CallLogAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Import( CallLogAspect.class )
@Component
@Slf4j
@SpringBootTest
class CallServiceV2Test {

//
//    @Autowired
//    CallServiceV2 callServiceV2;
//
//
//    @Test
//    void external() {
//        // log.info("target={}", callServiceV0);
//      callServiceV2.external();
//
//
//    }
//
//    @Test
//    void internal() {
//
//         callServiceV2.internal();
//
//    }

}