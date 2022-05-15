package maven.com.proxy.pureproxy;

import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcretLogic concretLogic = new ConcretLogic();
        ConcretClient client = new ConcretClient(concretLogic);
        client.execute();
    }

}
