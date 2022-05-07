package maven.com.lguplus.mybatis.controller;

import maven.com.lguplus.mybatis.service.MybatisMemberDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisMemberDtoController {

    private MybatisMemberDtoService mybatisMemberDtoService;

    public MybatisMemberDtoController(MybatisMemberDtoService userService) {
        this.mybatisMemberDtoService = userService;
    }

    @GetMapping("/mybatis/members")
    public ResponseEntity AllUsers() {
        return new ResponseEntity(mybatisMemberDtoService.getAllUsers(), HttpStatus.OK);
    }
}
