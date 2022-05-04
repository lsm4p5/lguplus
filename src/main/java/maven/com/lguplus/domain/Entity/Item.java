package maven.com.lguplus.domain.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor//(access = AccessLevel.PROTECTED)
@Getter @Setter
@ToString(of ={"itemName","itemPrice","quantity","discountItemPrice"})
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //-> 사용하면 안됨
@DiscriminatorColumn(name="DTYPE")
public class Item extends BaseEntity{

    @Id @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String itemName;
    private Integer itemPrice;
    private Integer quantity;

    private Integer discoutItemPrice;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.itemPrice = price;
        this.quantity = quantity;
    }

    public int calculaterItemPrice() {
        return itemPrice - discoutItemPrice;
    }
}