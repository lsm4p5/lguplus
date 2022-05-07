package maven.com.lguplus.repository.primary;


import maven.com.lguplus.domain.primary.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Long> {
}
