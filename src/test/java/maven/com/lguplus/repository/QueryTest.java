package maven.com.lguplus.repository;


import maven.com.lguplus.domain.Entity.Item;
import maven.com.lguplus.domain.Entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
@SpringBootTest
public class QueryTest {

    @Autowired
    private  MemberRepository memberRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void query1() throws Exception{
        List<Member> all = memberRepository.findAll();

        for (Member member : all) {
            System.out.println("member = " + member);
        }
    }

    @Test
    @Commit
    public void jpqlTest1(){

        //String jpql = "select  t from Team t ";
        String jpql = "select i from Item i where type(i) in (Book,Movie)";
        List<Item> resultList = em.createQuery(jpql, Item.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();
        for (Item item : resultList) {
            System.out.println("member = " + item);
        }

        em.createNamedQuery("Member.findByUsername",Member.class)
                .setParameter("username","member1")
                .getResultList();

        /* 모든 회원의 나이를 +1 해준다 */

        int resultcount = em.createQuery("update Member m set m.age= m.age+1")
                .executeUpdate();
        System.out.println("resultcount = " + resultcount);

        em.clear();

        //조회를 하면 DB에서 조회후 영속성컨텍스트로 ㅎㅎ

    }

}
