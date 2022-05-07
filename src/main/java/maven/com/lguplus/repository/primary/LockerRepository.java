package maven.com.lguplus.repository.primary;


import maven.com.lguplus.domain.primary.Entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Long> {

}
