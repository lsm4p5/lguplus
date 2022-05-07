package maven.com.lguplus.domain.EntitySecond.second;

import maven.com.lguplus.domain.Entity.Member;

import maven.com.lguplus.domain.EntitySecond.MemberSecond;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeondMemberRepository extends JpaRepository<MemberSecond,Long> {

}
