package maven.com.lguplus.web.formdto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberForm {

    private String loginname;
    private String username;
    private String password;
    private int age;
    private String teamName;

}
