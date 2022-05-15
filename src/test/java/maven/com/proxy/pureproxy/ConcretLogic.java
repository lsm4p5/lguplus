package maven.com.proxy.pureproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcretLogic {

    public String opertation() {
        log.info( "ConcretLocic 실행" );
        return "data";
    }
}
