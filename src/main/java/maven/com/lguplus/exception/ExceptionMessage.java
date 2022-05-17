package maven.com.lguplus.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    UPLUS_UNAUTHORIZED("유플러스 오픈 API 통신 중 인증 에러가 발생하였습니다."),
    UPLUS_API_ERROR("유플러스 오픈 API 통신 중 알수 없는 에러가 발생하였습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

}