package maven.com.lguplus.repository;


import maven.com.lguplus.domain.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
