package maven.com.lguplus.domain.primary.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Book extends Item{
    private String author;
    private String isbn;

    public Book(String author, String isbn) {
        this.author = author;
        this.isbn = isbn;
    }

    public Book(String itemName, Integer price, Integer quantity, String author, String isbn) {
        super(itemName, price, quantity);
        this.author = author;
        this.isbn = isbn;
    }

    public Book(String itemName, Integer itemPrice, Integer quantity, Integer discoutItemPrice, List<Category> categories, String author, String isbn) {
        super(itemName, itemPrice, quantity, discoutItemPrice, categories);
        this.author = author;
        this.isbn = isbn;
    }
}
