package maven.com.lguplus.repository.primary;


import maven.com.lguplus.domain.primary.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
