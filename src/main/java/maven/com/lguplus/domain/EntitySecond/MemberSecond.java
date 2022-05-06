package maven.com.lguplus.domain.EntitySecond;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MemberSecond {

    @Id @GeneratedValue
    Long id;
    String name;

}
