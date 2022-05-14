package maven.com.lguplus.aop.exam;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.aop.exam.aop.RetryAspect;
import maven.com.lguplus.aop.exam.aop.TraceAspect;
import maven.com.lguplus.trace.retryservice.annotation.Retryannotation;
import maven.com.lguplus.trace.retryservice.aspect.RetryAspectAction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Import( TraceAspect.class)
//@Import({TraceAspect.class, RetryAspect.class})
//@Import({RetryAspectAction.class,TraceAspect.class})
@Slf4j
class ExamServiceTest {

    @Autowired
    ExamService examService;

    @Test
    void test() {
        try {
            for (int i = 0; i < 5; i++) {
                log.info( "client request i ={}", i );
                examService.request( "data" + i );
            }
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(InvalidDataAccessApiUsageException.class);
            //e.printStackTrace();
        }

    }

}