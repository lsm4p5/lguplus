package maven.com.lguplus.mybatis.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MybatisMemberDto {

   private Long member_id;
   private String loginname;
   private String username;
   private String password;
   private int age;

}
