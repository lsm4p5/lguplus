package maven.com.lguplus.repository;


import maven.com.lguplus.api.dto.MemberDto;
import maven.com.lguplus.api.dto.MemberProjection;
import maven.com.lguplus.api.dto.MemberSearchCondition;
import maven.com.lguplus.api.dto.MemberTeamDto;
import maven.com.lguplus.domain.Entity.Member;
import maven.com.lguplus.domain.Entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SprintDataTest {

    @Autowired
    private  MemberRepository memberRepository;

    @Autowired
    private  TeamRepository teamRepository;

//    @Autowired
//    private  EntityManager em;

    @Test
    public void paging() throws Exception{
        //given

        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC,"username"));


        //when

        Page<Member> page = memberRepository.findPageByAge(age,pageRequest);

        Page<MemberDto> tomap = page.map(m -> new MemberDto(m.getLoginname(), m.getUsername(), m.getPassword(),m.getAge(),m.getTeam().getTeamName()));

        List<Member> content = page.getContent();
        for (Member member : content) {
            System.out.println("member = " + member);
        }

        long totalElements = page.getTotalElements();
        System.out.println("totalElements = " + totalElements);

        List<MemberDto> memberDtos = tomap.getContent();
        for (MemberDto memberDto : memberDtos) {
            System.out.println("memberDto = " + memberDto);
        }
//        assertThat(content.size()).isEqualTo(3);
//        assertThat(page.getTotalElements()).isEqualTo(5);
//        assertThat(page.getNumber()).isEqualTo(0);
//        assertThat(page.getTotalPages()).isEqualTo(2);
//        assertThat(page.isFirst()).isTrue();
//        assertThat(page.hasNext()).isTrue();

    }

    @Test
    public void slice() throws Exception{


        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC,"username"));

    /**
     //when
     Slice<Member> page = memberRepository.findByAge(age,pageRequest);

     List<Member> content = page.getContent();
     for (Member member : content) {
     System.out.println("member = " + member);
     }

     assertThat(content.size()).isEqualTo(3);
     assertThat(page.getNumber()).isEqualTo(0);
     assertThat(page.isFirst()).isTrue();
     assertThat(page.hasNext()).isTrue();
     */
    }

    @Test
    @Transactional
    @Commit
    public void bulupdate() throws Exception{


        //when
        int resultCount = memberRepository.bulkAgePlus(20);
        System.out.println("resultCount = " + resultCount);
//        em.clear();
        //then

        List<Member> result = memberRepository.findByUsername("member5");
        Member member5 = result.get(0);
        System.out.println("member5 = " + member5);

        assertThat(resultCount).isEqualTo(4);

    }

    @Test
    public void findMemberLazy() throws Exception{


        Team teamC = new Team("teamC");
        teamRepository.save(teamC);




        //when
        //       List<Member> members = memberRepository.findMemberFetchJoin();
        //       List<Member> members = memberRepository.findAll();
        //      List<Member> members = memberRepository.findMemberEntityGraph();
        List<Member> members = memberRepository.findEntityGraphByUsername("member1");

        for (Member member : members) {
            System.out.println("member = " + member.getUsername());
            System.out.println("member.teamClass = " + member.getTeam().getClass());
            System.out.println("member.getTeam().getName() = " + member.getTeam().getTeamName());
        }


    }



    @Test
    public void callCustom() throws Exception{

        //given
        MemberSearchCondition contion = new MemberSearchCondition();
        List<MemberTeamDto> memberCustom = memberRepository.search(contion);
        for (MemberTeamDto member : memberCustom) {
            System.out.println("member = " + member);
        }
        //when

        //then
    }

    @Test
    public void nativeQuery(){


        //  Member result = memberRepository.findByNativeQuery("m1");
        //   System.out.println("result = " + result);
        Page<MemberProjection> page = memberRepository.findByNativeProjection(PageRequest.of(0, 10));

        List<MemberProjection> contents = page.getContent();
        int i=0;
        for (MemberProjection content : contents) {

            System.out.println("[" + ++i + "th]"+ content.getLoginname()+"," +
            content.getUsername() +"," +
            content.getTeamName() +"," +
            content.getPassword() + "," +
            content.getAge());
        }
        long totalElements = page.getTotalElements();
        System.out.println("totalElements = " + totalElements);
    }

}
