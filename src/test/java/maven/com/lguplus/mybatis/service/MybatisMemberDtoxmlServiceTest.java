package maven.com.lguplus.mybatis.service;

import maven.com.lguplus.mybatis.dto.MybatisMemberDto;
import maven.com.lguplus.mybatis.mapper.MybatisMemberxmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MybatisMemberDtoxmlServiceTest {

        @Autowired
        MybatisMemberDtoxmlService mybatisMemberDtoxmlService;
        @Autowired
        MybatisMemberxmlMapper mybatisMemberxmlMapper;
        @Test
        @Commit
        public void mybatisTest() throws Exception{

            MybatisMemberDto mybatisMemberDto = new MybatisMemberDto("loginId10",
                "username10","password10", 15) ;

            mybatisMemberxmlMapper.mybatisMemberDtoAdd(mybatisMemberDto);

            System.out.println("mybatisMemberDto = " + mybatisMemberDto);



    }

}