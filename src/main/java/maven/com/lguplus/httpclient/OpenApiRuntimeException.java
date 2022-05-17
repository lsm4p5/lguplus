package maven.com.lguplus.httpclient;

import lombok.NoArgsConstructor;
import maven.com.lguplus.exception.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "API 통신 에러")
@NoArgsConstructor
public class OpenApiRuntimeException extends RuntimeException {

    public OpenApiRuntimeException(ExceptionMessage message) {
        super(message.getMessage());
    }
}