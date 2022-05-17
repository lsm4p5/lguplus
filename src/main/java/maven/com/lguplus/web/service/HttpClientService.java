package maven.com.lguplus.web.service;


import maven.com.lguplus.httpclient.UplusHttpRepository;
import maven.com.lguplus.httpclient.HttpClientDto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HttpClientService {

    private final UplusHttpRepository uplusHttpRepository;

    public HttpClientService(UplusHttpRepository movieRepository) {
        this.uplusHttpRepository = movieRepository;
    }

    public List<HttpClientDto> findByQuery(String query) {

        List<HttpClientDto> list = uplusHttpRepository.findByApiResponse(query).getItems().stream()
                .map(m -> HttpClientDto.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .userRating(m.getUserRating())
                        .build())
                .collect( Collectors.toList());

        return list;
    }
}