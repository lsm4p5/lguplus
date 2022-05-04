package maven.com.lguplus.repository;


import maven.com.lguplus.domain.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Long> {
}
