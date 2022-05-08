package maven.com.lguplus.service.orderservice;

import maven.com.lguplus.domain.primary.Entity.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
