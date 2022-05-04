package maven.com.lguplus.domain.Entity;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@ToString(of = {"id","teamName"})
public class Team {

    @Id  @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String teamName;

    private String team_value;

    @BatchSize(size=100)
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.teamName = name;
    }

}
