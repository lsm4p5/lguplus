package maven.com.lguplus.httpclient;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseHttpClient {

    private List<Item2> items = new ArrayList<>();

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Item2 {
        private String title;
        private String link;
        private String actor;
        private String director;
        private float userRating;
        //...TODO: 필드 추가
    }
}