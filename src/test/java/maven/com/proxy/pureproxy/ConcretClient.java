package maven.com.proxy.pureproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcretClient {

    private ConcretLogic concretLogic;

    public ConcretClient(ConcretLogic concretLogic) {
        this.concretLogic = concretLogic;
    }

    public void execute(){
        concretLogic.opertation();
    }
}
