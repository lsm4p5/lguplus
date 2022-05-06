package maven.com.lguplus.domain.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Getter @Setter
@DiscriminatorValue("M")
@NoArgsConstructor
public class Movie extends Item{

    private String director;
    private String actor;


}
