package maven.com.lguplus.repository;

import maven.com.lguplus.domain.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
