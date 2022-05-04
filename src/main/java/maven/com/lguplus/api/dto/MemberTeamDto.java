package maven.com.lguplus.api.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class MemberTeamDto {
    private String loginname;
    private String username;
    private String password;
    private String teamName;
    private int age;

    @QueryProjection
    public MemberTeamDto(String loginname, String username, String password, String teamName, int age) {
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.teamName = teamName;
        this.age = age;
    }
}
