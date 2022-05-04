package maven.com.lguplus.repository;


import maven.com.lguplus.api.dto.MemberProjection;
import maven.com.lguplus.domain.Entity.Member;
import maven.com.lguplus.repository.querydsl.MemberRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member,Long> , MemberRepositoryCustom {
    /* select m from Member m */
    List<Member> findByUsername(String username);
    List<Member> findByloginname(String loginname);


 //   @EntityGraph(attributePaths = {"favoriteFoods"},{"addressHistory"})
    @EntityGraph(attributePaths = ("addressHistory"))
    Optional<Member> findById(Long id);

    @EntityGraph(attributePaths = ("team"))
//    @EntityGraph("Member.all") //
    List<Member> findEntityGraphByUsername(@Param("username") String username);

    @EntityGraph(attributePaths = ("team"))
    Page<Member> findPageByAge(int age, Pageable pageble);
    Slice<Member> findSliceByAge(int age, Pageable pageble);

    @Query(value = "select * from member where username = ?", nativeQuery = true)
    Member findByNativeQuery(String username);

    @Query(value = "select m.loginname, m.username,m.password,m.age,t.team_name as teamName " +
            "from member m left join team t",
            countQuery = "select count(*) from member m left join team t",
            nativeQuery = true)
    Page<MemberProjection> findByNativeProjection(Pageable pageable);

    // 벌크작업한 후에 영속성 컨텍스틑 clear를 해주어야 함. 아래 옵션임.
    @Modifying(clearAutomatically = true)
    @Query("update Member m set m.age = m.age+1 where m.age>= :age")
    int bulkAgePlus(@Param("age") int age);

}
