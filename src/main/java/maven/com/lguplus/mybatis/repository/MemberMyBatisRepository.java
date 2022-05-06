package maven.com.lguplus.mybatis.repository;

import maven.com.lguplus.mybatis.dto.MyBatisMemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMyBatisRepository {
    public int insert(MyBatisMemberDto memberDto);

    public List<MyBatisMemberDto> selectAll();

    public List<MyBatisMemberDto> selectByName(String name);

    public MyBatisMemberDto selectByBookId(int memberId);

    public int update(MyBatisMemberDto member);

    public int deleteByBookId(int memberId);
}
