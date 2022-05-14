package maven.com.lguplus.mybatis.service;

import maven.com.lguplus.mybatis.dto.MybatisMemberDto;
import maven.com.lguplus.mybatis.mapper.MybatisMemberMapper;
import maven.com.lguplus.mybatis.mapper.MybatisMemberxmlMapper;
import maven.com.lguplus.trace.annotation.Trace_annotation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MybatisMemberDtoxmlService {

    private MybatisMemberxmlMapper mybatisMemberxmlMapper;

    public MybatisMemberDtoxmlService(MybatisMemberxmlMapper mybatisMemberxmlMapper) {
        this.mybatisMemberxmlMapper = mybatisMemberxmlMapper;
    }

    @Trace_annotation
    public List<MybatisMemberDto> getAllUsers_xml() {
        System.out.println("MybatisMemberDtoxmlService.getAllUsers_xml");
        final List<MybatisMemberDto> mybatisMemberDtoList = mybatisMemberxmlMapper.findMemberAll();
        for (MybatisMemberDto mybatisMemberDto : mybatisMemberDtoList) {
            System.out.println("mybatisMemberDto = " + mybatisMemberDto);
        }
        if (mybatisMemberDtoList.isEmpty())
            return null;
        return mybatisMemberDtoList;
    }
}
