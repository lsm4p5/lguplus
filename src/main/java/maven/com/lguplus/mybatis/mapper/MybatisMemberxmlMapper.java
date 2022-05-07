package maven.com.lguplus.mybatis.mapper;

import maven.com.lguplus.mybatis.dto.MybatisMemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisMemberxmlMapper {

    List<MybatisMemberDto> findMemberAll();

    void mybatisMemberDtoAdd(MybatisMemberDto mybatisMemberDto);
}
