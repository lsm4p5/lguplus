package maven.com.lguplus.mybatis.controller;

import maven.com.lguplus.mybatis.service.MybatisMemberDtoService;
import maven.com.lguplus.mybatis.service.MybatisMemberDtoxmlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisMemberDtoController {

    private MybatisMemberDtoService mybatisMemberDtoService;

    private MybatisMemberDtoxmlService mybatisMemberDtoxmlService;

    public MybatisMemberDtoController(MybatisMemberDtoService mybatisMemberDtoService,
                                      MybatisMemberDtoxmlService mybatisMemberDtoxmlService) {
        this.mybatisMemberDtoService = mybatisMemberDtoService;
        this.mybatisMemberDtoxmlService = mybatisMemberDtoxmlService;
    }

    @GetMapping("/mybatis/members")
    public ResponseEntity AllUsers() {
        return new ResponseEntity(mybatisMemberDtoService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/mybatis/members_xml")
    public ResponseEntity AllUsers_xml() {
        return new ResponseEntity(mybatisMemberDtoxmlService.getAllUsers_xml(), HttpStatus.OK);
    }
}
