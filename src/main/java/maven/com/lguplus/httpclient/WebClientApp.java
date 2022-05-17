package maven.com.lguplus.httpclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.Optional;


@Component
public class WebClientApp {

    private final WebClient webClient;

    @Autowired
    public WebClientApp(WebClient webClient) {
        this.webClient = webClient;
    }

    public ResponseHttpClient findByuplusServerGet(String url){

        Optional<ResponseHttpClient> optional = webClient.mutate()
                .baseUrl( url )
                .build()
                .get()
                .uri( url )
                .accept( MediaType.APPLICATION_JSON )
                .retrieve()
                .onStatus( status -> status.is4xxClientError()
                                || status.is5xxServerError()
                        , clientResponse ->
                                clientResponse.bodyToMono( String.class )
                                        .map( body -> new RuntimeException( body ) ) )
                .bodyToFlux( ResponseHttpClient.class )
                .toStream()
                .findAny();
        //      .collect( Collectors.toList() );

        if(optional.isEmpty()){
            return null;
        }
        else{
            return optional.get();
        }

    }

    public ResponseHttpClient findByuplusServerPost(String url){

        Optional<ResponseHttpClient> optional = webClient.mutate()
                .baseUrl( url )
                .build()
                .post()
                .uri( url )
                .accept( MediaType.APPLICATION_JSON )
                .retrieve()
                .onStatus( status -> status.is4xxClientError()
                                || status.is5xxServerError()
                        , clientResponse ->
                                clientResponse.bodyToMono( String.class )
                                        .map( body -> new RuntimeException( body ) ) )
                .bodyToMono( ResponseHttpClient.class )
                .flux()
                .toStream()
                .findFirst();
         //       .orElse( null );
        //      .collect( Collectors.toList() );

        if(optional == null || optional.isEmpty()){
            return null;
        }
        else{
            return optional.get();
        }

    }

}
