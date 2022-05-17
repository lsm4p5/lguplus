package maven.com.lguplus.httpclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {
    private final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

    @Autowired
    private WebClient webClient;

    @GetMapping("/test")
    public Mono<String> doTest() {
        WebClient client = WebClient.create();
        return client.get()
                .uri("http://localhost:8080")
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/api/test2")
    public Mono<String> doTest2() {
        return webClient.get()
                .uri("http://localhost:808")
                .retrieve()
                .bodyToMono(String.class);
    }
}