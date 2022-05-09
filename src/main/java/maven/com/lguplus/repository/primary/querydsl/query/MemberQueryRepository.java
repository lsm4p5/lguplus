package maven.com.lguplus.repository.primary.querydsl.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;

@Repository
public class MemberQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public MemberQueryRepository(EntityManager em) {

        this.queryFactory = new JPAQueryFactory(em);
    }




}
