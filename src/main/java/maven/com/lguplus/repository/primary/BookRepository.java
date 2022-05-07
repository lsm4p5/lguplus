package maven.com.lguplus.repository.primary;


import maven.com.lguplus.domain.primary.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
