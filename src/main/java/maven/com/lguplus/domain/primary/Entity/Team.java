package maven.com.lguplus.domain.primary.Entity;

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

    /**
     *  Tean을 생성후 Member에서 team.id가 같은 멤버의 changeteam을 호출하고 member의 team의 값을 넣을수 있다.
     */

}
