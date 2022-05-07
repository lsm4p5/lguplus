package maven.com.lguplus.repository.primary;


import maven.com.lguplus.domain.primary.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
