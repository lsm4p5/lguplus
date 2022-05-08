package maven.com.lguplus.domain.secondary.SecondaryEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SecondaryMember {

    @Id @GeneratedValue
    Long id;
    String name;

}
