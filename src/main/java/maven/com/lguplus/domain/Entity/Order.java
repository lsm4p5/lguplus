package maven.com.lguplus.domain.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ORDERS")
@Getter @Setter
@NoArgsConstructor
public class Order {

    @Id   @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;



    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="DELIVERY_ID")
    private Delivery delivery;

    public void change_memebr(Member member) {
        // 필요하면 만들어 준다..
        this.member = member;
        member.getOrders().add(this);
    }

    Order createOrderAndOrderItem(Member member,List<Item> items){
        // item들을 받아서 orderItem List를 완성한다.
        // member와 Item을 가지고서, Order && OrderItem, Order를 생성하여 준다...

        return null;

    }
}
