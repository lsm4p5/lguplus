package maven.com.lguplus.aop.exam;

import lombok.RequiredArgsConstructor;
import maven.com.lguplus.aop.exam.annotation.Trace;
import maven.com.lguplus.trace.annotation.Trace_annotation;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;


    public void request(String itemId) {
        examRepository.save( itemId );
    }
}
