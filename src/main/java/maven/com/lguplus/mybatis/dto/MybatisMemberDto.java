package maven.com.lguplus.mybatis.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Setter
public class MybatisMemberDto {

   private Long member_id;
   private String loginname;
   private String username;
   private String password;
   private int age;

   public MybatisMemberDto(String loginname, String username, String password, int age) {
      this.loginname = loginname;
      this.username = username;
      this.password = password;
      this.age = age;
   }
}
