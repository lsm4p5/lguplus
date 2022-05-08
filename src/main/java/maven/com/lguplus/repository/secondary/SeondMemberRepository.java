package maven.com.lguplus.repository.secondary;


import maven.com.lguplus.domain.secondary.SecondaryEntity.SecondaryMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeondMemberRepository extends JpaRepository<SecondaryMember,Long> {

}
