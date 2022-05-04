package maven.com.lguplus.repository.querydsl;


import maven.com.lguplus.api.dto.MemberSearchCondition;
import maven.com.lguplus.api.dto.MemberTeamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberRepositoryCustom {

    List<MemberTeamDto> search(MemberSearchCondition memberSearchCondition);
    Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition,Pageable pageable);

}
