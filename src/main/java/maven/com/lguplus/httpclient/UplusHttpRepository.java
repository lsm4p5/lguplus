package maven.com.lguplus.httpclient;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.config.UplusProperties;
import maven.com.lguplus.exception.ExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;



@Repository
@Slf4j
public class UplusHttpRepository {
    private final UplusProperties uplusProperties;
    private final RestTemplate restTemplate;

    @Autowired
    public UplusHttpRepository(UplusProperties uplusProperties, RestTemplate restTemplate) {
        this.uplusProperties = uplusProperties;
        this.restTemplate = restTemplate;
    }

    public ResponseHttpClient findByApiResponse(String query) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Uplus-Client-Id", uplusProperties.getClientId());
        httpHeaders.add("Uplus-Client-Secret", uplusProperties.getClientSecret());

        //httpHeaders.add("Content-Type", "application/json");

        String url = uplusProperties.getUplusUrl() + "?query=" + query;
        log.info( "url = {}" , url );
        log.info( "httpHeaders = {}" , httpHeaders );

        /**
         * 사용 예시임. SubmitDatas는 별도의 클래스로 만들어 져야 함.
         *
         * @Component
         * public class sendData {
         *     private static RestTemplate restTemplate;
         *
         *     public static ResponseEntity<SubmitData> sendEngine() {
         *         int SubNum = 123;
         *         int Pnum = 1;
         *         Object Pcode = "코드";
         *         SubmitData requestDto = SubmitData.builder()
         *                 .SubNum(SubNum)
         *                 .Pnum(Pnum)
         *                 .Pcode(Pcode)
         *                 .build();
         *
         *         HttpHeaders headers = new HttpHeaders();
         *         headers.add("Content-Type", "application/json");
         *         HttpEntity<SubmitData> entity = new HttpEntity<>(requestDto, headers);
         *
         *         String url = "http://localhost:8080/send";
         *
         *         return restTemplate.exchange(url, HttpMethod.POST, entity, SubmitData.class);
         *     }
         * }
         *
         */

        try {

            return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseHttpClient.class).getBody();

        } catch (HttpClientErrorException ex) {

            throw new OpenApiRuntimeException( ExceptionMessage.UPLUS_API_ERROR);
        }
        //TODO: auth exception..
    }
}

