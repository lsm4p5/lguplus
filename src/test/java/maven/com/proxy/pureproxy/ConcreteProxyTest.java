package maven.com.proxy.pureproxy;

import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcretLogic concretLogic = new ConcretLogic();
        ConcretClient client = new ConcretClient( concretLogic );
        client.execute();
    }

    @Test
    void AddProxy(){
        ConcretLogic concretLogic = new ConcretLogic();
        TimeProxy timeProxy = new TimeProxy( concretLogic );
        ConcretClient client = new ConcretClient( timeProxy );
        client.execute();
    }

}
