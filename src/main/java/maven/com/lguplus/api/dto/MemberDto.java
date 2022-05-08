package maven.com.lguplus.api.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
@ToString
@NoArgsConstructor
public class MemberDto {

    private String loginname;
    private String username;
    private String password;
    private int age;
    private String teamName;

    @QueryProjection
    public MemberDto(String loginname, String username, String password, int age,String teamName) {
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.age = age;
        this.teamName = teamName;
    }

    public MemberDto(String loginname, String username, String password, int age) {
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
