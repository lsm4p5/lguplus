package maven.com.lguplus.service.login;

import lombok.extern.slf4j.Slf4j;
import maven.com.lguplus.domain.primary.Entity.Member;
import maven.com.lguplus.repository.primary.MemberRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.eclipse.jdt.internal.compiler.problem.ProblemSeverities.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@Slf4j
class LoginServiceMocTest {

    @MockBean
    MemberRepository memberRepository;

    @Autowired
    LoginService loginService;

    @Test
    void mocklogin() {
        Mockito.when( memberRepository.findByloginname( any() ) ).thenReturn(retLoginResult());
        java.util.Optional<Member> login = loginService.login( "USERAA", "password" );
        if(login.isPresent()){
            log.info( "Member = {}", login.get() );
        }
        else {
            log.info( " Member is not exist" );
        }

    }

   List<Member> retLoginResult() {
        Member member = new Member();
        member.setId( 1L );
        member.setPassword( "password" );
        member.setUsername( "USERAA" );

       List<Member> members = new ArrayList<>();
       members.add(member);

        return members;
    }



}