package maven.com.lguplus.mock;


import maven.com.lguplus.domain.primary.Entity.Member;
import maven.com.lguplus.repository.primary.MemberRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class QueryMocTest {

    @MockBean
    private MemberRepository memberRepository;


    @Test
    void mockquery() {
        Mockito.when( memberRepository.findAll() ).thenReturn( returnMember() );
        List<Member> all = memberRepository.findAll();
        System.out.println( "all = " + all );

    }

    List<Member> returnMember(){

        Member member1 = new Member("UserA");
        member1.setId( 1L );

        Member member2 = new Member( "userB" );
        member2.setId( 2L );

        Member member3 = new Member( "userC" );
        member3.setId( 3L );
        List<Member> members = new ArrayList<>();


        members.add( member1 );
        members.add( member2 );
        members.add(member3);

        System.out.println( "================== members = " + members );


        return members;
    }

    @Test
    public void query1() throws Exception{
        List<Member> all = memberRepository.findAll();

        for (Member member : all) {
            System.out.println("member = " + member);
        }
    }



}
