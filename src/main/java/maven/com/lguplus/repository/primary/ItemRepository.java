package maven.com.lguplus.repository.primary;


import maven.com.lguplus.domain.primary.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    List<Item> findByItemName(String itemName);
}
