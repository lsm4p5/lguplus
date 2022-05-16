package maven.com.proxy.pureproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcretLogic{
    private ConcretLogic concretLogic;

    public TimeProxy(ConcretLogic concretLogic) {
        this.concretLogic = concretLogic;
    }

    @Override
    public String opertation() {

        log.info( "TimeDecorator 실행" );

        long startTime = System.currentTimeMillis();

        String result = concretLogic.opertation();

        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info( "TimeDecorator 종료 resutlTime={}ms", resultTime );

        return result;

    }
}
