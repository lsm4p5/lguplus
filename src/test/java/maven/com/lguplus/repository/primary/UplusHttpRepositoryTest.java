package maven.com.lguplus.repository.primary;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.httpclient.HttpClientDto;
import maven.com.lguplus.httpclient.UplusHttpRepository;

import maven.com.lguplus.httpclient.ResponseHttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class UplusHttpRepositoryTest {

    @Autowired
    UplusHttpRepository uplus;


    @Test
    void httpTest(){
        ResponseHttpClient result = uplus.findByApiResponse( "query" );
        System.out.println( "result = " + result );
        System.out.println( "result.getItems().size() = " + result.getItems().size() );

        List<HttpClientDto> list = uplus.findByApiResponse("query").getItems().stream()
                .map(m -> HttpClientDto.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .userRating(m.getUserRating())
                        .build())
                .collect( Collectors.toList());

        for (HttpClientDto movieDto : list) {
            System.out.println( "movieDto = " + movieDto.toString() );
        }

    }




}