package maven.com.lguplus.service.beanservice;

import maven.com.lguplus.service.discount.DiscountPolicy;
import maven.com.lguplus.service.discount.DiscountService;
import maven.com.lguplus.service.login.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeanQueryTest {



    @Test
    public void beanQueryTest() {

        DiscountService discountService = (DiscountService) BeanUtils.getBean("discountService");

        System.out.println("discountService = " + discountService);
    }

    @Test
    public void getBeanNames() {
        String[] result = BeanUtils.getBeanNames();
        for (String s : result) {
            System.out.println("getbeanNames = " + s);
        }
    }

    @Test
    public void getBeanTest(){

        DiscountService discountService = BeanUtils.getBean(DiscountService.class);
        System.out.println("discountService = " + discountService);

        LoginService loginService = BeanUtils.getBean(LoginService.class);
        System.out.println("loginService = " + loginService);

        DiscountPolicy discountPolicy = BeanUtils.getBean(DiscountPolicy.class);
        System.out.println("discountPolicy = " + discountPolicy);
    }



}