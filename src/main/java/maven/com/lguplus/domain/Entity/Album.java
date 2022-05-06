package maven.com.lguplus.domain.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.List;

@Entity
@Getter @Setter
@DiscriminatorValue("A")
@NoArgsConstructor
public class Album extends Item {
    private String artist;
    private String etc;

    public Album(String artist, String etc) {
        this.artist = artist;
        this.etc = etc;
    }

    public Album(String itemName, Integer price, Integer quantity, String artist, String etc) {
        super(itemName, price, quantity);
        this.artist = artist;
        this.etc = etc;
    }

    public Album(String itemName, Integer itemPrice, Integer quantity, Integer discoutItemPrice, List<Category> categories, String artist, String etc) {
        super(itemName, itemPrice, quantity, discoutItemPrice, categories);
        this.artist = artist;
        this.etc = etc;
    }
}
