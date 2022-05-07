package maven.com.lguplus.repository.primary;

import maven.com.lguplus.domain.primary.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
