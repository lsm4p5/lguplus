package maven.com.lguplus;


import lombok.RequiredArgsConstructor;
import maven.com.lguplus.domain.Entity.*;
import maven.com.lguplus.repository.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.Optional;


@Component
@RequiredArgsConstructor
//@Transactional
public class InitTestData {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final MovieRepository movieRepository;
    private final BookRepository bookRepository;
    private final AlbumRepository albumRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        System.out.println("InitTestData.init");
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        Member member1 = new Member("login1","member1","1234",10,teamA);
        Member member2 = new Member("login2","member2","1234",20,teamA);
        Member member3 = new Member("login3","member3","1234",30,teamB);
        Member member4 = new Member("login4","member4","1234",40,teamB);
        Member member5 = new Member("login5","member5","1234",40,teamB);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);

        memberRepository.save(member5);

        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));

        Member  member = new Member();
        member.setLoginname("test");
        member.setPassword(("test!"));
        member.setUsername("테스터");

        member.setHomeAddress(new Address("homeCity","street","zipcode"));
        member.getFavoriteFoods().add("치킨");
        member.getFavoriteFoods().add("족발");
        member.getFavoriteFoods().add("피자");

        member.getAddressHistory().add(new AddressEntity("old1", "street5", "zipcode1"));
        member.getAddressHistory().add(new AddressEntity("old4", "street2", "zipcode2"));
        memberRepository.save(member);


        Movie movie = new Movie();
        movie.setDirector("DirectorA");
        movie.setActor("ActorA");
        movie.setItemName("바람과함계 사라지다");
        movie.setPrice(100000);

        movieRepository.save(movie);

        Book book = new Book();
        book.setItemName("누구를 위해 일하는가");
        book.setAuthor("바보들");
        bookRepository.save(book);

        // 조회 후 저장, 값 Type Member 처리시에 주의해야 한다.
        //
        Optional<Member> optionalMember = memberRepository.findById(member.getId());
        System.out.println("optionalMember = " + optionalMember);
        if(optionalMember.isPresent()) {
            Member findMember = optionalMember.get();
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
            //치킨 -> 한식
    //         findMember.getFavoriteFoods().remove("치킨");
    //         findMember.getFavoriteFoods().add("한식");

             findMember.getAddressHistory().remove(new AddressEntity("old1", "street1", "zipcode1"));
             findMember.getAddressHistory().add(new AddressEntity("newCity1", "street1", "zipcode1"));
            memberRepository.save(findMember);
            System.out.println("findMember = " + findMember);

        }

        System.out.println("InitTestData.init END");

    }

}