package maven.com.lguplus.web.formdto;

import maven.com.lguplus.httpclient.ResponseHttpClient;
import org.junit.jupiter.api.Test;

import java.util.List;

class ResponseHttpClientTest {

    @Test
    void buildTest() {

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

        System.out.println( "ab = " + ab.getItems().toString() );
        System.out.println( "build = " + build );
        System.out.println( "build = " + build1 );
        System.out.println( "build = " + build2 );

        //System.out.println( "ab = " + ab.getItems() );

        List<ResponseHttpClient.Item2> items = ab.getItems();
        for (ResponseHttpClient.Item2 item : items) {
            System.out.println( "================== item = " + item );
        }






    }

}