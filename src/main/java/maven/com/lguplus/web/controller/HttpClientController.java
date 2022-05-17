package maven.com.lguplus.web.controller;

import lombok.extern.slf4j.Slf4j;

import maven.com.lguplus.httpclient.ResponseHttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HttpClientController {

    @GetMapping("/api/v1/http_request")
    ResponseHttpClient responseHttpClient(){


        ResponseHttpClient.Item2  build= ResponseHttpClient.Item2.builder().title( "title" )
                .actor( "actor" ).director( "director" ).link( "link" ).userRating( 0.3f ).build();

        ResponseHttpClient.Item2  build1= ResponseHttpClient.Item2.builder().title( "title" )
                .actor( "actor1" ).director( "director1" ).link( "link1" ).userRating( 0.4f ).build();

        ResponseHttpClient.Item2 build2= ResponseHttpClient.Item2.builder().title( "title" )
                .actor( "actor3" ).director( "director2" ).link( "link2" ).userRating( 0.5f ).build();
        ResponseHttpClient ab = new ResponseHttpClient();
        ab.getItems().add( build );
        ab.getItems().add( build1 );
        ab.getItems().add( build2 );

        return ab;
    }


}
