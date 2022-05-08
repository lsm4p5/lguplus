package maven.com.lguplus.mybatis.service;

import maven.com.lguplus.api.dto.MemberDto;
import maven.com.lguplus.mybatis.dto.MybatisMemberDto;
import maven.com.lguplus.mybatis.mapper.MybatisMemberxmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MybatisMemberDtoxmlServiceTest {

    @Autowired
    MybatisMemberDtoxmlService mybatisMemberDtoxmlService;

    @Autowired
    DataSource datasource;

    @Autowired
    MybatisMemberxmlMapper mybatisMemberxmlMapper;

    @Test
    @Commit
    public void mybatisTest() throws Exception {

        MybatisMemberDto mybatisMemberDto = new MybatisMemberDto("loginId10",
                "username10", "password10", 15);

        mybatisMemberxmlMapper.mybatisMemberDtoAdd(mybatisMemberDto);

        System.out.println("mybatisMemberDto = " + mybatisMemberDto);
    }

    @Test
    @Commit
    public void jdbctemplateTest() throws Exception {
        //given

        MybatisMemberDto memberDto = new MybatisMemberDto("loginname20", "username20",
                "password20", 25);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);

        // Insert
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("member_id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", memberDto.getUsername());
        parameters.put("loginname", memberDto.getLoginname());
        parameters.put("password", memberDto.getPassword());
        parameters.put("age", memberDto.getAge());

        Number key = jdbcInsert.executeAndReturnKey(new
                MapSqlParameterSource(parameters));
        System.out.println("key.longValue() = " + key.longValue());

        List<MybatisMemberDto> query = jdbcTemplate.query("select * from member", memberDtoRowMapper());
        for (MybatisMemberDto dto : query) {
            System.out.println("dto = " + dto);
        }


    }

    private RowMapper<MybatisMemberDto> memberDtoRowMapper() {
        return (rs, rowNum) -> {
            MybatisMemberDto memberDto = new MybatisMemberDto();
            memberDto.setUsername(rs.getString("username"));
            memberDto.setLoginname(rs.getString("loginname"));
            memberDto.setPassword(rs.getString("password"));
            memberDto.setAge(rs.getInt("age"));
            memberDto.setMember_id(rs.getLong("member_id"));
            return memberDto;
        };
    }
}