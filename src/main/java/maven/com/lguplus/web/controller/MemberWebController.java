package maven.com.lguplus.web.controller;


import lombok.RequiredArgsConstructor;
import maven.com.lguplus.domain.Entity.Member;
import maven.com.lguplus.repository.MemberRepository;
import maven.com.lguplus.web.formdto.MemberForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberWebController {

    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("form") MemberForm form) {
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute MemberForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        Member member1 = new Member(form.getLoginname(),form.getUsername(),form.getPassword(),form.getAge(),null);
        memberRepository.save(member1);
        return "redirect:/";
    }
}