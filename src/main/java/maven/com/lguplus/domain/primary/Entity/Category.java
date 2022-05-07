package maven.com.lguplus.domain.primary.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Category {

    @Id @GeneratedValue
    @Column(name="CATEGORY_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name ="PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="CATEGORY_ITEM",
            joinColumns = @JoinColumn(name="CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name="ITEM_ID")
    )
    private List<Item> items = new ArrayList<>();

    public Category(Category parent, List<Category> child, List<Item> items) {
        this.parent = parent;
        this.child = child;
        this.items = items;
    }
}
