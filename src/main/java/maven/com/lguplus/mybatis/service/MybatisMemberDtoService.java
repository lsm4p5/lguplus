package maven.com.lguplus.mybatis.service;

import maven.com.lguplus.mybatis.dto.MybatisMemberDto;
import maven.com.lguplus.mybatis.mapper.MybatisMemberMapper;
import maven.com.lguplus.trace.annotation.Trace_annotation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MybatisMemberDtoService {
    private MybatisMemberMapper mybatisMemberMapper;

    public  MybatisMemberDtoService(MybatisMemberMapper mybatisMemberMapper) {
        this.mybatisMemberMapper = mybatisMemberMapper;
    }

    // 멤버 전체 조회
    @Trace_annotation
    public List<MybatisMemberDto> getAllUsers() {
        final List<MybatisMemberDto> mybatisMemberDtoList = mybatisMemberMapper.findAll();
        if (mybatisMemberDtoList.isEmpty())
            return null;
        return mybatisMemberDtoList;
    }


}
