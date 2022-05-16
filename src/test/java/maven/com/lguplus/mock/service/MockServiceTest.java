package maven.com.lguplus.mock.service;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.aop.exam.ExamRepository;
import maven.com.lguplus.aop.exam.ExamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;

//@ExtendWith(MockitoExtension.class)
@Slf4j
@SpringBootTest
public class MockServiceTest {

    @Autowired
    ExamService examService;
    @MockBean
    private ExamRepository examRepository;




    @Test
    void mockTest() {
        Mockito.when( examRepository.save( any() ) ).thenReturn( MockReturn() );
     //   examService = new ExamService( examRepository );
        examService.request( "Input" );
        examRepository.save("22");
    }
    String MockReturn(){
        log.info("Mock Test ");
        return "OK";
    }


}
