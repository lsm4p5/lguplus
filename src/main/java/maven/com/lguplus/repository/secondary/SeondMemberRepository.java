package maven.com.lguplus.repository.secondary;


import maven.com.lguplus.domain.primary.SecondaryEntity.MemberSecond;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeondMemberRepository extends JpaRepository<MemberSecond,Long> {

}
