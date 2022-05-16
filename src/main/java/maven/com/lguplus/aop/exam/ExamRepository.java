package maven.com.lguplus.aop.exam;

import maven.com.lguplus.aop.exam.annotation.Retry;


import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {
    private static int seq = 0;

    /**
     * 5번에 1번 실패하는 요청
     */

    @Retry(4)
    public String save(String itemId) {
        seq++;
        System.out.println( "ExamRepository.save" );
        if (seq % 5 == 0) {
            throw new IllegalStateException( "예외 발생 [" + seq + "]");
        }
//        if(seq>5){
//            throw new IllegalStateException( "예외 발생 [" + seq + "]");
//        }
        return "ok";
    }
}
