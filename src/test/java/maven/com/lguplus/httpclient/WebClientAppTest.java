package maven.com.lguplus.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest
@Slf4j
class WebClientAppTest {

    @Autowired
    WebClientApp webClientApp;

    private final static String url = "http://localhost:8080/api/v1/http_request";

    @Test
    void findByuplusServerTest(){
        ResponseHttpClient responseHttpClient = webClientApp.findByuplusServerGet( url );
        log.info( " ResponseHttpClient ={}", responseHttpClient );
    }

    @Test
    void findByuplusServerTest2(){
        List<HttpClientDto> list = webClientApp.findByuplusServerGet(url).getItems().stream()
                .map(m -> HttpClientDto.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .userRating(m.getUserRating())
                        .build())
                .collect( Collectors.toList());
        for (HttpClientDto httpClientDto : list) {
            log.info( "httpClientDto = {}", httpClientDto );
        }
    }


}