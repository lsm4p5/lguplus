package maven.com.lguplus.mybatis.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MybatisMemberDto {

   private Long memberId;
   private String loginname;
   private String username;
   private String password;
   private int age;


}
