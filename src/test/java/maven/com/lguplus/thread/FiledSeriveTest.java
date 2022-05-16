package maven.com.lguplus.thread;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.thread.code.FieldService;
import org.junit.jupiter.api.Test;


@Slf4j
public class FiledSeriveTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() {
        log.info( "main start" );

        Runnable userC = new Runnable(){
            @Override
            public void run() {
                fieldService.logic("USERC");
            }
        } ;

        Runnable userA = ()->{
            fieldService.logic("USERA");
        };

        Runnable userB = ()->{
            fieldService.logic("USERB");
        };


        Thread threadA = new Thread( userA );
        threadA.setName( "thread-A" );
        Thread threadB = new Thread(userB);
        threadB.setName( "thread-B" );

        threadA.start();
     //   sleep(2000); // 동시성 문제 발생X
        sleep(100); // 동시성 문제 발생
        threadB.start();

        sleep( 3000 ); //메인 쓰레드 종료 대기
        log.info( "main exit" );

   }

    private void sleep(int mills)  {
        try {
            Thread.sleep( mills );
        } catch (InterruptedException e) {
           // throw new RuntimeException( e );
            e.printStackTrace();
        }
    }


}
