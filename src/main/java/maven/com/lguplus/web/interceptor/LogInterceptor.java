package maven.com.lguplus.web.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();
        request.setAttribute(LOG_ID, uuid);
        log.info("LogInterceptor - Request(preHandle) [{}]getDispatcherType[{}][{}][{}]", uuid,
                request.getDispatcherType(), requestURI, handler);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LogInterceptor - postHandle ModelAndView[{}]", modelAndView);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse
            response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String logId = (String)request.getAttribute(LOG_ID);
        log.info("LogInterceptor - Response(afterComletion) [{}]getDispatcherType[{}][{}]", logId, request.getDispatcherType(),
                requestURI);
        if (ex != null) {
            log.error("LogInterceptor - afterCompletion error!!", ex);
        }
    }
}