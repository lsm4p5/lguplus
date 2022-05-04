package maven.com.lguplus.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CheckController {

    @GetMapping("/api/check-exception")
    public String checkException( String name) throws Exception {

        if (name == null) {
            log.info("CheckController - name = {}", name);
            throw new Exception("예외입니다");
        }
        return "OK";
    }
}
