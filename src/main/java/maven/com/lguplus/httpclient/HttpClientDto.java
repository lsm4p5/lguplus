package maven.com.lguplus.httpclient;

import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@ToString
public class HttpClientDto {
    private String title;
    private String link;
    private float userRating;
}
