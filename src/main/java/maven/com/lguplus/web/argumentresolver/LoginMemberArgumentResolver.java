package maven.com.lguplus.web.argumentresolver;



import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.domain.primary.Entity.Member;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static maven.com.lguplus.web.SessionConst.LOGIN_MEMBER;

@Slf4j
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("LoginMemberArgrumentResolver - supportsParamebter 실행");

        boolean hasLoginAnnotraion = parameter.hasParameterAnnotation(Login.class);
        boolean hasMemberType = Member.class.isAssignableFrom((parameter.getParameterType()));

        return hasLoginAnnotraion && hasMemberType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        log.info("LoginMemberArgrumentResolver - resolveArgument 실행 ");

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        HttpSession session = request.getSession();

        if (session == null) {
            return null;
        }
        log.info("LoginMemberArgrumentResolver session.getAttribute((SessionConst.LOGIN_MEMBER)) ={}", session.getAttribute((LOGIN_MEMBER)));

        return session.getAttribute((LOGIN_MEMBER));


    }
}
