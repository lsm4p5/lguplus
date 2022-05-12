package maven.com.lguplus.aop.exam;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.aop.exam.aop.RetryAspect;
import maven.com.lguplus.aop.exam.aop.TraceAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Import( TraceAspect.class)
@Import({TraceAspect.class, RetryAspect.class})
@Slf4j
class ExamServiceTest {

    @Autowired
    ExamService examService;

    @Test
    void test() {
        for (int i = 0; i < 5; i++) {
            log.info( "client request i ={}", i );
            examService.request( "data" + i  );
        }
    }

}