package maven.com.lguplus.service.beanservice;

import maven.com.lguplus.service.discount.DiscountPolicy;
import maven.com.lguplus.service.discount.DiscountService;
import maven.com.lguplus.service.login.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeanQueryTest {

    @Autowired
    WebApplicationContext wac ;

    @Test
    public void beanQueryTest() {

        DiscountService discountService = (DiscountService) BeanUtils.getBean("discountService");

        System.out.println("discountService = " + discountService);
    }

    @Test
    public void getBeanNames() {
        String[] result = BeanUtils.getBeanNames();
        int i=0;
        for (String s : result) {
            System.out.println("getbeanNames = " + s);
            i++;
        }
        System.out.println("====================i = " + i);
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

    @Test
    public void webapplication(){
        String applicationName = wac.getApplicationName();
        System.out.println("applicationName = " + applicationName);

        DiscountPolicy bean = wac.getBean(DiscountPolicy.class);
        System.out.println("bean = " + bean);

        String[] beanDefinitionNames = wac.getBeanDefinitionNames();
        int i =0;
        for (String beanDefinitionName : beanDefinitionNames) {
         //   System.out.println("beanDefinitionName = " + beanDefinitionName);
            i++;
        }
        System.out.println("============================ i = " + i);
        BeanUtils.getBeanNamesApplication();

    }

}