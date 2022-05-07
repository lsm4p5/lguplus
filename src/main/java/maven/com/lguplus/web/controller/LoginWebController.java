package maven.com.lguplus.web.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.domain.primary.Entity.Member;
import maven.com.lguplus.service.login.LoginService;
import maven.com.lguplus.web.SessionConst;
import maven.com.lguplus.web.formdto.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginWebController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form,
                          BindingResult bindingResult,
                          @RequestParam(defaultValue = "/") String redirectURL,
                          HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "/login/loginForm";
        }


        Optional<Member> optionalMember = loginService.login(form.getLoginname(), form.getPassword());

        if (optionalMember.isPresent()) {
            //로그인 성공 처리 TODO
            //세션 관리자를 통해 세션을 생성하고, 회원데이터 보관
            // 세션이 있으면 세션을 반환, 없으면 신규 세션을 생성
            HttpSession session = request.getSession();
            Member loginMember = optionalMember.get();
            //세션에 로그인 회원 정보 보관
            session.setAttribute(SessionConst.LOGIN_MEMBER,loginMember);
            log.info("LoginController - redirect:{}, loginMember={}", redirectURL,loginMember);
//            if((redirectURL != null) && redirectURL.equals("/")) {
//                log.info("redirect=================");
//                return "loginhome";
//            }
            return "redirect:" +redirectURL ;
        }
        else{
            log.info("아이디 또는 비밀번호가 맞지 않습니다.");
            bindingResult.reject("Login Fail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "/login/loginForm";
        }

    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";

    }
}
