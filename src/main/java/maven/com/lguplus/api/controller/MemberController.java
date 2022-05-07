package maven.com.lguplus.api.controller;


import lombok.RequiredArgsConstructor;
import maven.com.lguplus.api.dto.MemberSearchCondition;
import maven.com.lguplus.api.dto.MemberTeamDto;
import maven.com.lguplus.repository.primary.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/api/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition)
    {
        return memberRepository.search(condition);
    }

    @GetMapping("/api/v2/members")
    public Page<MemberTeamDto> searchMemberV3(MemberSearchCondition condition,
                                              Pageable pageable) {
        return memberRepository.searchPageComplex(condition, pageable);
    }

}
