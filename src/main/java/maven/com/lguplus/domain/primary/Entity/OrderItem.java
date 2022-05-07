package maven.com.lguplus.domain.primary.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class OrderItem {

    @Id @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;

    public OrderItem(Order order, Item item, int orderPrice, int count) {
        this.order = order;
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}
