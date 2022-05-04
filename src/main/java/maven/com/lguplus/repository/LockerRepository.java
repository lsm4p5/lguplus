package maven.com.lguplus.repository;


import maven.com.lguplus.domain.Entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Long> {

}
