package maven.com.lguplus.repository;


import maven.com.lguplus.domain.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
