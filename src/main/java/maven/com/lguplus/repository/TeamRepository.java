package maven.com.lguplus.repository;

import maven.com.lguplus.domain.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Long>{

    List<Team> findByTeamName(String name);

}
