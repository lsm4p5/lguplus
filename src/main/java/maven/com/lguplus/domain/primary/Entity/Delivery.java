package maven.com.lguplus.domain.primary.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Delivery {

    @Id @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus deliveryStatus;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;

    public Delivery(String city, String street, String zipcode, DeliveryStatus deliveryStatus, Order order) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.deliveryStatus = deliveryStatus;
        this.order = order;
    }
}
