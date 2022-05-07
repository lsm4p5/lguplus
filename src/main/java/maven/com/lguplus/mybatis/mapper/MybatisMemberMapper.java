package maven.com.lguplus.mybatis.mapper;

import maven.com.lguplus.mybatis.dto.MybatisMemberDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MybatisMemberMapper {

    @Select("SELECT * FROM user")
    List<MybatisMemberDto> findAll();

    @Select("SELECT * FROM Member WHERE member_id = #{memberId}")
    MybatisMemberDto findByUserIdx(@Param("memberId") int memberId);

    @Insert("INSERT INTO user(loginname, username,password,age) VALUES(#{loginname},#{username},#{password}, #{age}")
    @Options(useGeneratedKeys = true, keyProperty = "member_id")
    public abstract int save(@Param("mybatisMemberDto") final MybatisMemberDto mybatisMemberDto);
}
