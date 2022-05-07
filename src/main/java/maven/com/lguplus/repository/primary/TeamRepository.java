package maven.com.lguplus.repository.primary;

import maven.com.lguplus.domain.primary.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Long>{

    List<Team> findByTeamName(String name);

}
