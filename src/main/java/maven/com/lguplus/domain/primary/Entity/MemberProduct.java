package maven.com.lguplus.domain.primary.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class MemberProduct {

    @Id @GeneratedValue
    @Column(name="MEMBER_PRODUCT_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    private int count;
    private int price;

    private LocalDateTime orderDateTime;

    public MemberProduct(Member member, Product product, int count, int price, LocalDateTime orderDateTime) {
        this.member = member;
        this.product = product;
        this.count = count;
        this.price = price;
        this.orderDateTime = orderDateTime;
    }
}
