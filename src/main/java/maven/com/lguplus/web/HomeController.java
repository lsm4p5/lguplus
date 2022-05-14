package maven.com.lguplus.web;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.domain.primary.Entity.Member;
import maven.com.lguplus.repository.primary.MemberRepository;

import maven.com.lguplus.trace.annotation.Trace_annotation;
import maven.com.lguplus.web.argumentresolver.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;

    @Trace_annotation
    @GetMapping("/")
    public String homeLoginArgumentResolver(@Login Member member, Model model) {

        //세션에 회원 데이타가 없으면
        if (member == null) {
            return "home";
        }

        model.addAttribute("member", member);

        log.info("HomeController - homeLoginArgumentResolver loginMember = {}" , member);

        return "loginhome";
    }
}